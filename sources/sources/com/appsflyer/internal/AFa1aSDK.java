package com.appsflyer.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1zSDK;
import com.helpshift.HelpshiftEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFa1aSDK implements AFa1bSDK {
    private final AFc1gSDK AFAdRevenueData;
    private boolean getMonetizationNetwork;
    Map<String, Object> getRevenue;

    public AFa1aSDK(AFc1gSDK aFc1gSDK) {
        Intrinsics.checkNotNullParameter(aFc1gSDK, "");
        this.AFAdRevenueData = aFc1gSDK;
    }

    private boolean getMonetizationNetwork() {
        return this.getMonetizationNetwork;
    }

    @Override // com.appsflyer.internal.AFa1bSDK
    public final void getMonetizationNetwork(boolean z) {
        this.getMonetizationNetwork = z;
    }

    @Override // com.appsflyer.internal.AFa1bSDK
    public final Map<String, Object> getCurrencyIso4217Code() {
        return this.getRevenue;
    }

    @Override // com.appsflyer.internal.AFa1bSDK
    public final void getMediationNetwork() {
        Context context;
        if (getMonetizationNetwork() && (context = this.AFAdRevenueData.getRevenue) != null) {
            this.getRevenue = new LinkedHashMap();
            final AFa1uSDK aFa1uSDK = new AFa1uSDK(System.currentTimeMillis());
            try {
                Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", Context.class).invoke(null, context);
                final Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                Method method = cls.getMethod("fetchDeferredAppLinkData", Context.class, String.class, cls2);
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.internal.AFb1zSDK.1
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                        String str;
                        String str2;
                        String str3;
                        Bundle bundle;
                        if (method2.getName().equals("onDeferredAppLinkDataFetched")) {
                            Object obj2 = objArr[0];
                            if (obj2 != null) {
                                Bundle bundle2 = (Bundle) Bundle.class.cast(cls.getMethod("getArgumentBundle", new Class[0]).invoke(cls.cast(obj2), new Object[0]));
                                if (bundle2 != null) {
                                    str2 = bundle2.getString("com.facebook.platform.APPLINK_NATIVE_URL");
                                    str3 = bundle2.getString("target_url");
                                    Bundle bundle3 = bundle2.getBundle("extras");
                                    str = (bundle3 == null || (bundle = bundle3.getBundle("deeplink_context")) == null) ? null : bundle.getString("promo_code");
                                } else {
                                    str = null;
                                    str2 = null;
                                    str3 = null;
                                }
                                AFa1uSDK aFa1uSDK2 = aFa1uSDK;
                                if (aFa1uSDK2 != null) {
                                    aFa1uSDK2.getMediationNetwork(str2, str3, str);
                                }
                            } else {
                                AFa1uSDK aFa1uSDK3 = aFa1uSDK;
                                if (aFa1uSDK3 != null) {
                                    aFa1uSDK3.getMediationNetwork(null, null, null);
                                }
                            }
                            return null;
                        }
                        AFa1uSDK aFa1uSDK4 = aFa1uSDK;
                        if (aFa1uSDK4 != null) {
                            aFa1uSDK4.AFAdRevenueData("onDeferredAppLinkDataFetched invocation failed");
                        }
                        return null;
                    }
                });
                String string = context.getString(context.getResources().getIdentifier("facebook_app_id", TypedValues.Custom.S_STRING, context.getPackageName()));
                if (TextUtils.isEmpty(string)) {
                    aFa1uSDK.AFAdRevenueData("Facebook app id not defined in resources");
                } else {
                    method.invoke(null, context, string, newProxyInstance);
                }
            } catch (ClassNotFoundException e) {
                AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e);
                aFa1uSDK.AFAdRevenueData(e.toString());
            } catch (IllegalAccessException e2) {
                AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e2);
                aFa1uSDK.AFAdRevenueData(e2.toString());
            } catch (NoSuchMethodException e3) {
                AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e3);
                aFa1uSDK.AFAdRevenueData(e3.toString());
            } catch (InvocationTargetException e4) {
                AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e4);
                aFa1uSDK.AFAdRevenueData(e4.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class AFa1uSDK implements AFb1zSDK.AFa1uSDK {
        private /* synthetic */ long getCurrencyIso4217Code;

        AFa1uSDK(long j) {
            this.getCurrencyIso4217Code = j;
        }

        @Override // com.appsflyer.internal.AFb1zSDK.AFa1uSDK
        public final void getMediationNetwork(String str, String str2, String str3) {
            Map<String, Object> map;
            if (str != null) {
                AFLogger.afInfoLog("Facebook Deferred AppLink data received: " + str);
                Map<String, Object> map2 = AFa1aSDK.this.getRevenue;
                if (map2 != null) {
                    map2.put(HelpshiftEvent.DATA_ACTION_TYPE_LINK, str);
                }
                if (str2 != null && (map = AFa1aSDK.this.getRevenue) != null) {
                    map.put("target_url", str2);
                }
                if (str3 != null) {
                    AFa1aSDK aFa1aSDK = AFa1aSDK.this;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("promo_code", str3);
                    linkedHashMap.put("deeplink_context", linkedHashMap2);
                    Map<String, Object> map3 = aFa1aSDK.getRevenue;
                    if (map3 != null) {
                        map3.put("extras", linkedHashMap);
                    }
                }
            } else {
                Map<String, Object> map4 = AFa1aSDK.this.getRevenue;
                if (map4 != null) {
                    map4.put(HelpshiftEvent.DATA_ACTION_TYPE_LINK, "");
                }
            }
            String valueOf = String.valueOf(System.currentTimeMillis() - this.getCurrencyIso4217Code);
            Map<String, Object> map5 = AFa1aSDK.this.getRevenue;
            if (map5 != null) {
                map5.put("ttr", valueOf);
            }
        }

        @Override // com.appsflyer.internal.AFb1zSDK.AFa1uSDK
        public final void AFAdRevenueData(String str) {
            Map<String, Object> map = AFa1aSDK.this.getRevenue;
            if (map != null) {
                map.put("error", str);
            }
        }
    }

    @Override // com.appsflyer.internal.AFa1bSDK
    public final boolean getRevenue() {
        if (getMonetizationNetwork()) {
            Map<String, Object> map = this.getRevenue;
            if (map == null || map.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
