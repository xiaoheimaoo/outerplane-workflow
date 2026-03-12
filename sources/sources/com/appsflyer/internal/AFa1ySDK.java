package com.appsflyer.internal;

import com.appsflyer.AFLogger;
@Deprecated
/* loaded from: classes.dex */
public final class AFa1ySDK {
    private final AFa1vSDK getMonetizationNetwork = new AFa1vSDK() { // from class: com.appsflyer.internal.AFa1ySDK.5
        @Override // com.appsflyer.internal.AFa1ySDK.AFa1vSDK
        public final Class<?> getRevenue(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AFa1vSDK {
        Class<?> getRevenue(String str) throws ClassNotFoundException;
    }

    public final String getMediationNetwork() {
        AFa1tSDK[] values;
        for (AFa1tSDK aFa1tSDK : AFa1tSDK.values()) {
            if (getRevenue(aFa1tSDK.getCurrencyIso4217Code)) {
                return aFa1tSDK.AFAdRevenueData;
            }
        }
        return AFa1tSDK.DEFAULT.AFAdRevenueData;
    }

    private boolean getRevenue(String str) {
        try {
            this.getMonetizationNetwork.getRevenue(str);
            AFLogger.afRDLog(new StringBuilder("Class: ").append(str).append(" is found.").toString());
            return true;
        } catch (ClassNotFoundException e) {
            AFLogger.afErrorLogForExcManagerOnly(new StringBuilder("Class: ").append(str).append(" is  not found. (Platform extension)").toString(), e, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    /* loaded from: classes.dex */
    enum AFa1tSDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");
        
        final String AFAdRevenueData;
        final String getCurrencyIso4217Code;

        AFa1tSDK(String str, String str2) {
            this.AFAdRevenueData = str;
            this.getCurrencyIso4217Code = str2;
        }
    }
}
