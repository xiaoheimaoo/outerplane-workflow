package com.appsflyer.share;

import android.content.Context;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.AFa1uSDK;
import com.appsflyer.internal.AFc1bSDK;
import com.appsflyer.internal.AFe1kSDK;
import com.appsflyer.internal.AFe1nSDK;
import com.appsflyer.internal.AFj1dSDK;
import com.appsflyer.internal.AFk1uSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class LinkGenerator {
    String AFAdRevenueData;
    private String areAllFieldsValid;
    private String component1;
    private String component2;
    private String component3;
    private String component4;
    private String equals;
    private String getCurrencyIso4217Code;
    private String getMediationNetwork;
    String getMonetizationNetwork;
    private final String getRevenue;
    private final Map<String, String> hashCode = new HashMap();
    private String toString;

    /* loaded from: classes.dex */
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public LinkGenerator(String str) {
        this.getRevenue = str;
    }

    public LinkGenerator setBrandDomain(String str) {
        this.toString = str;
        return this;
    }

    public String getBrandDomain() {
        return this.toString;
    }

    public LinkGenerator setDeeplinkPath(String str) {
        this.component2 = str;
        return this;
    }

    public LinkGenerator setBaseDeeplink(String str) {
        this.equals = str;
        return this;
    }

    public String getChannel() {
        return this.getMediationNetwork;
    }

    public LinkGenerator setChannel(String str) {
        this.getMediationNetwork = str;
        return this;
    }

    public LinkGenerator setReferrerCustomerId(String str) {
        this.component1 = str;
        return this;
    }

    public String getMediaSource() {
        return this.getRevenue;
    }

    public Map<String, String> getUserParams() {
        return new HashMap(this.hashCode);
    }

    public String getCampaign() {
        return this.getCurrencyIso4217Code;
    }

    public LinkGenerator setCampaign(String str) {
        this.getCurrencyIso4217Code = str;
        return this;
    }

    public LinkGenerator addParameter(String str, String str2) {
        this.hashCode.put(str, str2);
        return this;
    }

    public LinkGenerator addParameters(Map<String, String> map) {
        if (map != null) {
            this.hashCode.putAll(map);
        }
        return this;
    }

    public LinkGenerator setReferrerUID(String str) {
        this.component3 = str;
        return this;
    }

    public LinkGenerator setReferrerName(String str) {
        this.component4 = str;
        return this;
    }

    public LinkGenerator setReferrerImageURL(String str) {
        this.areAllFieldsValid = str;
        return this;
    }

    public LinkGenerator setBaseURL(String str, String str2, String str3) {
        if (str == null || str.length() <= 0) {
            this.getMonetizationNetwork = String.format("https://%s/%s", String.format("%sapp.%s", AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName()), str3);
        } else {
            this.getMonetizationNetwork = String.format("https://%s/%s", (str2 == null || str2.length() < 5) ? "go.onelink.me" : "go.onelink.me", str);
        }
        return this;
    }

    private Map<String, String> AFAdRevenueData() {
        HashMap hashMap = new HashMap();
        hashMap.put("pid", this.getRevenue);
        String str = this.component3;
        if (str != null) {
            hashMap.put("af_referrer_uid", str);
        }
        String str2 = this.getMediationNetwork;
        if (str2 != null) {
            hashMap.put(AFInAppEventParameterName.AF_CHANNEL, str2);
        }
        String str3 = this.component1;
        if (str3 != null) {
            hashMap.put("af_referrer_customer_id", str3);
        }
        String str4 = this.getCurrencyIso4217Code;
        if (str4 != null) {
            hashMap.put("c", str4);
        }
        String str5 = this.component4;
        if (str5 != null) {
            hashMap.put("af_referrer_name", str5);
        }
        String str6 = this.areAllFieldsValid;
        if (str6 != null) {
            hashMap.put("af_referrer_image_url", str6);
        }
        if (this.equals != null) {
            StringBuilder append = new StringBuilder().append(this.equals);
            String str7 = this.component2;
            if (str7 != null) {
                this.component2 = str7.replaceFirst("^[/]", "");
                append.append(this.equals.endsWith("/") ? "" : "/");
                append.append(this.component2);
            }
            hashMap.put("af_dp", append.toString());
        }
        for (Map.Entry<String, String> entry : this.hashCode.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return AFj1dSDK.getMediationNetwork(hashMap);
    }

    public String generateLink() {
        StringBuilder sb = new StringBuilder();
        String str = this.getMonetizationNetwork;
        if (str != null && str.startsWith("http")) {
            sb.append(this.getMonetizationNetwork);
        } else {
            sb.append(String.format(AFk1uSDK.getMediationNetwork, AppsFlyerLib.getInstance().getHostPrefix(), AFa1uSDK.getMonetizationNetwork().getHostName()));
        }
        if (this.AFAdRevenueData != null) {
            sb.append('/').append(this.AFAdRevenueData);
        }
        Map<String, String> AFAdRevenueData = AFAdRevenueData();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : AFAdRevenueData.entrySet()) {
            if (sb2.length() == 0) {
                sb2.append('?');
            } else {
                sb2.append(Typography.amp);
            }
            sb2.append(entry.getKey()).append('=').append(entry.getValue());
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    public void generateLink(Context context, ResponseListener responseListener) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String str = this.toString;
        Map<String, String> AFAdRevenueData = AFAdRevenueData();
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            AFLogger.afInfoLog("CustomerUserId not set, generate User Invite Link is disabled", true);
            return;
        }
        AFa1uSDK.getMonetizationNetwork().getMediationNetwork(context);
        AFa1uSDK monetizationNetwork = AFa1uSDK.getMonetizationNetwork();
        AFc1bSDK aFc1bSDK = (AFc1bSDK) AFa1uSDK.getRevenue(new Object[]{monetizationNetwork}, 389316487, -389316474, System.identityHashCode(monetizationNetwork));
        AFe1kSDK aFe1kSDK = new AFe1kSDK(aFc1bSDK, UUID.randomUUID(), string, AFAdRevenueData, str, responseListener, this);
        AFe1nSDK copydefault = aFc1bSDK.copydefault();
        copydefault.AFAdRevenueData.execute(new AFe1nSDK.AnonymousClass3(aFe1kSDK));
    }

    @Deprecated
    public void generateLink(Context context, final CreateOneLinkHttpTask.ResponseListener responseListener) {
        generateLink(context, new ResponseListener() { // from class: com.appsflyer.share.LinkGenerator.1
            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponse(String str) {
                responseListener.onResponse(str);
            }

            @Override // com.appsflyer.share.LinkGenerator.ResponseListener
            public final void onResponseError(String str) {
                responseListener.onResponseError(str);
            }
        });
    }
}
