package com.appsflyer.internal;

import android.graphics.Color;
import android.net.Uri;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public final class AFf1vSDK extends AFe1eSDK<Map<String, String>> {
    private final UUID AFInAppEventParameterName;
    public AFa1vSDK areAllFieldsValid;
    private final AFd1lSDK copy;
    private String copydefault;
    private final boolean equals;
    private String hashCode;
    private String toString;

    /* loaded from: classes.dex */
    public interface AFa1vSDK {
        void getCurrencyIso4217Code(Map<String, String> map);

        void getMediationNetwork(String str);
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final boolean AFAdRevenueData() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean a_() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AppsFlyerRequestListener areAllFieldsValid() {
        return null;
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final boolean copydefault() {
        return false;
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final long getCurrencyIso4217Code() {
        return 3000L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFf1vSDK(AFc1bSDK aFc1bSDK, UUID uuid, Uri uri) {
        super(AFe1mSDK.ONELINK, new AFe1mSDK[]{AFe1mSDK.RC_CDN}, aFc1bSDK, uuid.toString());
        boolean z = false;
        this.copy = aFc1bSDK.getRevenue();
        this.AFInAppEventParameterName = uuid;
        try {
            if (!AFk1xSDK.getRevenue(uri.getHost()) && !AFk1xSDK.getRevenue(uri.getPath())) {
                Object[] objArr = {uri, aFc1bSDK.i()};
                Object obj = AFa1jSDK.unregisterClient.get(228484367);
                if (obj == null) {
                    obj = ((Class) AFa1jSDK.AFAdRevenueData(Color.alpha(0), (char) Color.blue(0), 37 - (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getDeclaredConstructor(Uri.class, AFa1rSDK.class);
                    AFa1jSDK.unregisterClient.put(228484367, obj);
                }
                Object newInstance = ((Constructor) obj).newInstance(objArr);
                Object obj2 = AFa1jSDK.unregisterClient.get(-891849335);
                if (obj2 == null) {
                    obj2 = ((Class) AFa1jSDK.AFAdRevenueData(Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 37)).getMethod("getRevenue", null);
                    AFa1jSDK.unregisterClient.put(-891849335, obj2);
                }
                Object invoke = ((Method) obj2).invoke(newInstance, null);
                Object obj3 = AFa1jSDK.unregisterClient.get(-1788381861);
                if (obj3 == null) {
                    obj3 = ((Class) AFa1jSDK.AFAdRevenueData(38 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (View.resolveSize(0, 0) + 39041), View.resolveSize(0, 0) + 51)).getMethod("getRevenue", null);
                    AFa1jSDK.unregisterClient.put(-1788381861, obj3);
                }
                boolean booleanValue = ((Boolean) ((Method) obj3).invoke(invoke, null)).booleanValue();
                Object obj4 = AFa1jSDK.unregisterClient.get(784237499);
                if (obj4 == null) {
                    obj4 = ((Class) AFa1jSDK.AFAdRevenueData(AndroidCharacter.getMirror('0') - 11, (char) (39041 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), 50 - TextUtils.lastIndexOf("", '0'))).getMethod("getMediationNetwork", null);
                    AFa1jSDK.unregisterClient.put(784237499, obj4);
                }
                z = ((Boolean) ((Method) obj4).invoke(invoke, null)).booleanValue();
                String[] split = uri.getPath().split("/");
                if (booleanValue && split.length == 3) {
                    this.toString = split[1];
                    this.hashCode = split[2];
                    this.copydefault = uri.toString();
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLogForExcManagerOnly("OneLinkValidator: reflection init failed", e);
        }
        this.equals = z;
    }

    public final boolean equals() {
        return (TextUtils.isEmpty(this.toString) || TextUtils.isEmpty(this.hashCode) || this.toString.equals("app")) ? false : true;
    }

    public final boolean copy() {
        return this.equals;
    }

    @Override // com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFe1lSDK
    public final void getRevenue() {
        super.getRevenue();
        AFa1vSDK aFa1vSDK = this.areAllFieldsValid;
        if (aFa1vSDK != null) {
            if (this.AFAdRevenueData == AFe1uSDK.SUCCESS && ((AFe1eSDK) this).component3 != null) {
                aFa1vSDK.getCurrencyIso4217Code((Map) ((AFe1eSDK) this).component3.getBody());
                return;
            }
            Throwable component1 = component1();
            if (component1 instanceof ParsingException) {
                if (((ParsingException) component1).getRawResponse().isSuccessful()) {
                    aFa1vSDK.getMediationNetwork("Can't parse one link data");
                    return;
                }
                String str = this.copydefault;
                aFa1vSDK.getMediationNetwork(str != null ? str : "Can't get OneLink data");
                return;
            }
            String str2 = this.copydefault;
            aFa1vSDK.getMediationNetwork(str2 != null ? str2 : "Can't get OneLink data");
        }
    }

    @Override // com.appsflyer.internal.AFe1eSDK
    protected final AFd1jSDK<Map<String, String>> getRevenue(String str) {
        AFd1lSDK aFd1lSDK = this.copy;
        return (AFd1jSDK) AFd1lSDK.getRevenue(new Object[]{aFd1lSDK, this.toString, this.hashCode, this.AFInAppEventParameterName, str}, 1826287225, -1826287225, System.identityHashCode(aFd1lSDK));
    }
}
