package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u000b\u001a\u00020\b8BX\u0083\u0084\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0015\u0010\f\u001a\u00020\b8BX\u0083\u0084\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0011\u0010\u000e\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r"}, d2 = {"Lcom/appsflyer/internal/AFe1ySDK;", "", "Lcom/appsflyer/internal/AFc1pSDK;", "p0", "Lcom/appsflyer/internal/AFc1oSDK;", "p1", "<init>", "(Lcom/appsflyer/internal/AFc1pSDK;Lcom/appsflyer/internal/AFc1oSDK;)V", "", "component4", "Lkotlin/Lazy;", "getMonetizationNetwork", "getCurrencyIso4217Code", "()Ljava/lang/String;", "getMediationNetwork", "Lcom/appsflyer/internal/AFc1pSDK;", "AFAdRevenueData", "", "getRevenue", "()Z", "Lcom/appsflyer/internal/AFc1oSDK;", "areAllFieldsValid", "component1", "AFa1uSDK"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFe1ySDK {
    private static AFe1wSDK component1;
    private final AFc1oSDK AFAdRevenueData;
    private final Lazy component4;
    public final Lazy getCurrencyIso4217Code;
    private final AFc1pSDK getMediationNetwork;
    public static final AFa1uSDK AFa1uSDK = new AFa1uSDK(null);
    public static String getRevenue = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    public static String getMonetizationNetwork = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    private static final List<String> component2 = CollectionsKt.listOf((Object[]) new String[]{"googleplay", "playstore", "googleplaystore"});

    public AFe1ySDK(AFc1pSDK aFc1pSDK, AFc1oSDK aFc1oSDK) {
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(aFc1oSDK, "");
        this.getMediationNetwork = aFc1pSDK;
        this.AFAdRevenueData = aFc1oSDK;
        this.component4 = LazyKt.lazy(new Function0<String>() { // from class: com.appsflyer.internal.AFe1ySDK.4
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: getRevenue */
            public final String invoke() {
                String currencyIso4217Code = com.appsflyer.internal.AFa1uSDK.getCurrencyIso4217Code(AFe1ySDK.this.AFAdRevenueData, AFe1ySDK.this.getMediationNetwork.areAllFieldsValid());
                String str = currencyIso4217Code;
                if (!(str == null || StringsKt.isBlank(str))) {
                    String obj = StringsKt.trim((CharSequence) str).toString();
                    AFa1uSDK aFa1uSDK = AFe1ySDK.AFa1uSDK;
                    List<String> AFAdRevenueData = AFa1uSDK.AFAdRevenueData();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "");
                    String lowerCase = obj.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    if (!AFAdRevenueData.contains(lowerCase)) {
                        currencyIso4217Code = "-" + obj;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{obj}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        AFLogger.afWarnLog(format);
                        currencyIso4217Code = "";
                    }
                }
                return StringsKt.trim((CharSequence) (currencyIso4217Code != null ? currencyIso4217Code : "")).toString();
            }

            {
                super(0);
            }
        });
        this.getCurrencyIso4217Code = LazyKt.lazy(new Function0<String>() { // from class: com.appsflyer.internal.AFe1ySDK.3
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFAdRevenueData */
            public final String invoke() {
                String packageName = AFe1ySDK.this.getMediationNetwork.getRevenue.getRevenue.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                return AFe1ySDK.getCurrencyIso4217Code(packageName, AFe1ySDK.AFAdRevenueData(AFe1ySDK.this));
            }

            {
                super(0);
            }
        });
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\f¢\u0006\u0006\n\u0004\b\r\u0010\fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0087\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\"\u0004\b\b\u0010\u0011"}, d2 = {"Lcom/appsflyer/internal/AFe1ySDK$AFa1uSDK;", "", "<init>", "()V", "", "", "component2", "Ljava/util/List;", "AFAdRevenueData", "()Ljava/util/List;", "getCurrencyIso4217Code", "getRevenue", "Ljava/lang/String;", "getMonetizationNetwork", "Lcom/appsflyer/internal/AFe1wSDK;", "component1", "Lcom/appsflyer/internal/AFe1wSDK;", "(Lcom/appsflyer/internal/AFe1wSDK;)V", "getMediationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFa1uSDK {
        private AFa1uSDK() {
        }

        public static List<String> AFAdRevenueData() {
            return AFe1ySDK.component2;
        }

        public static void AFAdRevenueData(AFe1wSDK aFe1wSDK) {
            AFe1ySDK.component1 = aFe1wSDK;
        }

        public /* synthetic */ AFa1uSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static boolean getRevenue() {
        return component1 == null;
    }

    public final String getMonetizationNetwork() {
        AFe1tSDK aFe1tSDK;
        if (getRevenue()) {
            aFe1tSDK = AFe1tSDK.DEFAULT;
        } else {
            aFe1tSDK = AFe1tSDK.API;
        }
        int i = AFa1zSDK.getRevenue[aFe1tSDK.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "";
                }
                throw new NoWhenBranchMatchedException();
            }
            AFe1wSDK aFe1wSDK = component1;
            String str = aFe1wSDK != null ? aFe1wSDK.AFAdRevenueData : null;
            return str == null ? "" : str;
        }
        return (String) this.getCurrencyIso4217Code.getValue();
    }

    public final String getCurrencyIso4217Code() {
        AFe1tSDK aFe1tSDK;
        if (getRevenue()) {
            aFe1tSDK = AFe1tSDK.DEFAULT;
        } else {
            aFe1tSDK = AFe1tSDK.API;
        }
        int i = AFa1zSDK.getRevenue[aFe1tSDK.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return "";
                }
                throw new NoWhenBranchMatchedException();
            }
            AFe1wSDK aFe1wSDK = component1;
            String str = aFe1wSDK != null ? aFe1wSDK.getRevenue : null;
            return str == null ? "" : str;
        }
        return "appsflyersdk.com";
    }

    public static final /* synthetic */ String getCurrencyIso4217Code(String str, String str2) {
        String str3 = str + str2;
        Intrinsics.checkNotNullParameter(str3, "");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String substring = new Regex("[^\\w]+").replace(lowerCase, "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring + ".";
    }

    public static final /* synthetic */ String AFAdRevenueData(AFe1ySDK aFe1ySDK) {
        return (String) aFe1ySDK.component4.getValue();
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class AFa1zSDK {
        public static final /* synthetic */ int[] getRevenue;

        static {
            int[] iArr = new int[AFe1tSDK.values().length];
            try {
                iArr[AFe1tSDK.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AFe1tSDK.API.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AFe1tSDK.RC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            getRevenue = iArr;
        }
    }

    public static final void getMediationNetwork(AFe1wSDK aFe1wSDK) {
        AFa1uSDK.AFAdRevenueData(aFe1wSDK);
    }
}
