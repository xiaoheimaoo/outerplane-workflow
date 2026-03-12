import os
import re
import json
import zipfile
import requests
import subprocess
from seleniumbase import SB

DOWNLOAD_URL = "https://d.apkpure.com/b/XAPK/com.smilegate.outerplane.stove.google?version=latest"
ARTIFACTS_DIR = "artifacts"
SOURCES_DIR = "sources"
SAVE_PATH = os.path.join(ARTIFACTS_DIR, "outerplane_latest.xapk")
MAIN_APK_NAME = "com.smilegate.outerplane.stove.google.apk"


def ensure_dirs() -> None:
    os.makedirs(ARTIFACTS_DIR, exist_ok=True)
    os.makedirs(SOURCES_DIR, exist_ok=True)


def get_cloudflare_clearance():
    print("[*] 正在启动 SeleniumBase 以绕过 Cloudflare...")
    with SB(uc=True, xvfb=True, headless=False, window_size="1280,900") as sb:
        print("[*] 正在访问目标网站并处理验证...")
        sb.uc_open_with_reconnect("https://apkpure.com/", 4)
        sb.sleep(6) 
        
        try:
            sb.uc_gui_click_captcha()
            sb.sleep(4)
        except Exception:
            pass 
            
        page_title = sb.get_title()
        print(f"[*] 当前页面标题: {page_title}")
        
        user_agent = sb.driver.execute_script("return navigator.userAgent;")
        cookies_list = sb.driver.get_cookies()
        cookies_dict = {cookie["name"]: cookie["value"] for cookie in cookies_list}

        print(f"[+] 成功获取浏览器 UA: {user_agent}")
        if not cookies_dict:
            raise RuntimeError("未获取到任何 cookies，Cloudflare 验证未通过。")

        return user_agent, cookies_dict


def download_file(url: str, save_path: str, user_agent: str, cookies: dict):
    headers = {
        "User-Agent": user_agent,
        "Accept": "*/*",
        "Referer": "https://apkpure.com/",
    }

    print(f"[*] 开始下载 XAPK: {url}")
    with requests.get(url, headers=headers, cookies=cookies, stream=True, timeout=120, allow_redirects=True) as r:
        r.raise_for_status()
        total = int(r.headers.get("Content-Length", 0))
        downloaded = 0

        with open(save_path, "wb") as f:
            for chunk in r.iter_content(chunk_size=1024 * 256):
                if not chunk:
                    continue
                f.write(chunk)
                downloaded += len(chunk)

                if total > 0:
                    percent = downloaded * 100 / total
                    print(f"\r[*] 下载中: {downloaded}/{total} bytes ({percent:.2f}%)", end="")
                else:
                    print(f"\r[*] 已下载: {downloaded} bytes", end="")
    print(f"\n[+] 下载完成: {os.path.abspath(save_path)}")


def get_apk_signature(apk_path: str) -> str:
    print(f"[*] 正在使用 apksigner 提取 APK 签名 SHA-256: {apk_path}")
    try:
        # 使用 apksigner 获取证书信息
        output = subprocess.check_output(
            ["apksigner", "verify", "--print-certs", apk_path], 
            text=True, 
            stderr=subprocess.STDOUT
        )
        
        # apksigner 的输出格式通常为: "Signer #1 certificate SHA-256 digest: 8a1b2c..."
        match = re.search(r"SHA-256 digest:\s*([a-fA-F0-9]+)", output)
        if match:
            clean_sha256 = match.group(1).lower()
            print(f"[+] 成功提取签名 SHA-256: {clean_sha256}")
            return clean_sha256
        else:
            print("[-] apksigner 输出中未找到匹配的 SHA-256 摘要。详细输出:")
            print(output)
            
    except subprocess.CalledProcessError as e:
        print(f"[-] 提取 APK 签名失败 (apksigner 报错): {e.output}")
    except Exception as e:
        print(f"[-] 发生未知错误: {e}")
        
    return "UNKNOWN"


def extract_and_analyze():
    print("\n[*] 开始解析 XAPK...")
    app_version = "unknown"
    
    with zipfile.ZipFile(SAVE_PATH, 'r') as z:
        if 'manifest.json' in z.namelist():
            manifest_data = json.loads(z.read('manifest.json').decode('utf-8'))
            app_version = manifest_data.get('version_name', 'unknown')
            print(f"[*] 解析到游戏版本号: {app_version}")
        
        print(f"[*] 正在提取 {MAIN_APK_NAME} 到 artifacts 目录...")
        z.extract(MAIN_APK_NAME, ARTIFACTS_DIR)
        
    apk_path = os.path.join(ARTIFACTS_DIR, MAIN_APK_NAME)

    # 提取 APK 签名 SHA-256
    apk_signature_sha256 = get_apk_signature(apk_path)

    # 调用 JADX 反编译
    print(f"[*] 正在使用 JADX 反编译 APK 到 {SOURCES_DIR} 目录...")
    subprocess.run(["jadx", "-d", SOURCES_DIR, apk_path], check=True)

    # 定位并解析 SecurityNative.java
    target_java_file = os.path.join(SOURCES_DIR, "sources", "com", "vagames", "security", "SecurityNative.java")
    
    real_salt = "NOT_FOUND"
    if os.path.exists(target_java_file):
        print(f"[*] 正在分析源码: {target_java_file}")
        with open(target_java_file, 'r', encoding='utf-8') as f:
            java_source = f.read()

        regex_pattern = r'\+\s*str\s*\+\s*":([^:]+):"\s*\+\s*getSigningCertSha256Fingerprint'
        match = re.search(regex_pattern, java_source)

        if match:
            real_salt = match.group(1)
            print(f"[+] 成功提取真实 Salt: {real_salt}")
        else:
            print("[-] 警告: 未能匹配到真实 Salt。")
    else:
        print(f"[-] 错误: 找不到目标文件 {target_java_file}")

    # 将结果写入根目录的 version.json
    result_data = {
        "version": app_version,
        "salt": real_salt,
        "signature_sha256": apk_signature_sha256
    }
    
    version_json_path = "version.json"
    with open(version_json_path, 'w', encoding='utf-8') as f:
        json.dump(result_data, f, indent=4)
    print(f"[+] 分析结果已保存至根目录: {version_json_path}")


def main():
    ensure_dirs()
    ua, cf_cookies = get_cloudflare_clearance()
    download_file(DOWNLOAD_URL, SAVE_PATH, ua, cf_cookies)
    extract_and_analyze()


if __name__ == "__main__":
    main()
