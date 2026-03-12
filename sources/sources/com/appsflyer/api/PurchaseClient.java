package com.appsflyer.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.exceptions.SDKMissingException;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1l;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1r;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1u;
import com.appsflyer.internal.connector.purcahse.AFPurchaseConnectorA1w;
import com.appsflyer.internal.models.InAppPurchaseValidationResult;
import com.appsflyer.internal.models.SubscriptionValidationResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u0000 \u00062\u00020\u0001:\b\u0007\u0006\b\t\n\u000b\f\rJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lcom/appsflyer/api/PurchaseClient;", "", "", "startObservingTransactions", "()V", "stopObservingTransactions", "Companion", "Builder", "InAppPurchaseEventDataSource", "InAppPurchaseValidationResultListener", "PurchaseEventDataSource", "SubscriptionPurchaseEventDataSource", "SubscriptionPurchaseValidationResultListener", "ValidationResultListener"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PurchaseClient {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bæ\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$InAppPurchaseEventDataSource;", "Lcom/appsflyer/api/PurchaseClient$PurchaseEventDataSource;", "Lcom/appsflyer/api/InAppPurchaseEvent;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface InAppPurchaseEventDataSource extends PurchaseEventDataSource<InAppPurchaseEvent> {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\bf\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$InAppPurchaseValidationResultListener;", "Lcom/appsflyer/api/PurchaseClient$ValidationResultListener;", "", "", "Lcom/appsflyer/internal/models/InAppPurchaseValidationResult;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface InAppPurchaseValidationResultListener extends ValidationResultListener<Map<String, ? extends InAppPurchaseValidationResult>> {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J)\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H'¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$PurchaseEventDataSource;", "Lcom/appsflyer/api/PurchaseEvent;", "PurchaseType", "", "", "p0", "", "", "onNewPurchases", "(Ljava/util/List;)Ljava/util/Map;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PurchaseEventDataSource<PurchaseType extends PurchaseEvent> {
        Map<String, Object> onNewPurchases(List<? extends PurchaseType> list);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bæ\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseEventDataSource;", "Lcom/appsflyer/api/PurchaseClient$PurchaseEventDataSource;", "Lcom/appsflyer/api/SubscriptionPurchaseEvent;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface SubscriptionPurchaseEventDataSource extends PurchaseEventDataSource<SubscriptionPurchaseEvent> {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\bf\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseValidationResultListener;", "Lcom/appsflyer/api/PurchaseClient$ValidationResultListener;", "", "", "Lcom/appsflyer/internal/models/SubscriptionValidationResult;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface SubscriptionPurchaseValidationResultListener extends ValidationResultListener<Map<String, ? extends SubscriptionValidationResult>> {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$ValidationResultListener;", "Result", "", "", "p0", "", "p1", "", "onFailure", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "onResponse", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface ValidationResultListener<Result> {
        void onFailure(String str, Throwable th);

        void onResponse(Result result);
    }

    void startObservingTransactions();

    void stopObservingTransactions();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0007X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$Companion;", "", "<init>", "()V", "", "VERSION_NAME", "Ljava/lang/String;", "getVERSION_NAME", "()Ljava/lang/String;", "getVERSION_NAME$annotations"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String VERSION_NAME = "2.1.0";

        @JvmStatic
        public static /* synthetic */ void getVERSION_NAME$annotations() {
        }

        private Companion() {
        }

        public final String getVERSION_NAME() {
            return VERSION_NAME;
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001e\u0010\nJ\u0019\u0010 \u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b>\u0010?"}, d2 = {"Lcom/appsflyer/api/PurchaseClient$Builder;", "", "Landroid/content/Context;", "p0", "Lcom/appsflyer/api/Store;", "p1", "<init>", "(Landroid/content/Context;Lcom/appsflyer/api/Store;)V", "", "autoLogInApps", "(Z)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/api/PurchaseClient;", "build", "()Lcom/appsflyer/api/PurchaseClient;", "logSubscriptions", "Lcom/appsflyer/AppsFlyerLib;", "setAfClient", "(Lcom/appsflyer/AppsFlyerLib;)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r$AFPurchaseConnectorA1w;", "setBillingClientFactory", "(Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r$AFPurchaseConnectorA1w;)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r;", "setConnector", "(Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r;)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/api/PurchaseClient$InAppPurchaseEventDataSource;", "setInAppPurchaseEventDataSource", "(Lcom/appsflyer/api/PurchaseClient$InAppPurchaseEventDataSource;)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/api/PurchaseClient$InAppPurchaseValidationResultListener;", "setInAppValidationResultListener", "(Lcom/appsflyer/api/PurchaseClient$InAppPurchaseValidationResultListener;)Lcom/appsflyer/api/PurchaseClient$Builder;", "setSandbox", "Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseEventDataSource;", "setSubscriptionPurchaseEventDataSource", "(Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseEventDataSource;)Lcom/appsflyer/api/PurchaseClient$Builder;", "Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseValidationResultListener;", "setSubscriptionValidationResultListener", "(Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseValidationResultListener;)Lcom/appsflyer/api/PurchaseClient$Builder;", "afClient", "Lcom/appsflyer/AppsFlyerLib;", "billingClientFactory", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r$AFPurchaseConnectorA1w;", "connector", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1r;", "context", "Landroid/content/Context;", "inAppPurchaseEventDataSource", "Lcom/appsflyer/api/PurchaseClient$InAppPurchaseEventDataSource;", "inAppValidationResultListener", "Lcom/appsflyer/api/PurchaseClient$InAppPurchaseValidationResultListener;", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1l;", "purchaseDatabaseHelper", "Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1l;", "", "", "purchaseTypes", "Ljava/util/Set;", "sandbox", "Z", "store", "Lcom/appsflyer/api/Store;", "subscriptionPurchaseEventDataSource", "Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseEventDataSource;", "subscriptionValidationResultListener", "Lcom/appsflyer/api/PurchaseClient$SubscriptionPurchaseValidationResultListener;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private AppsFlyerLib afClient;
        private AFPurchaseConnectorA1r.AFPurchaseConnectorA1w<?> billingClientFactory;
        private AFPurchaseConnectorA1r connector;
        private final Context context;
        private InAppPurchaseEventDataSource inAppPurchaseEventDataSource;
        private InAppPurchaseValidationResultListener inAppValidationResultListener;
        private final AFPurchaseConnectorA1l purchaseDatabaseHelper;
        private final Set<String> purchaseTypes;
        private boolean sandbox;
        private final Store store;
        private SubscriptionPurchaseEventDataSource subscriptionPurchaseEventDataSource;
        private SubscriptionPurchaseValidationResultListener subscriptionValidationResultListener;

        public Builder(Context context, Store store) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(store, "");
            this.store = store;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "");
            this.context = applicationContext;
            this.purchaseDatabaseHelper = new AFPurchaseConnectorA1l(context);
            this.purchaseTypes = new HashSet();
        }

        public final Builder logSubscriptions(boolean z) {
            if (z) {
                this.purchaseTypes.add("subs");
            } else {
                this.purchaseTypes.remove("subs");
            }
            return this;
        }

        public final Builder autoLogInApps(boolean z) {
            if (z) {
                this.purchaseTypes.add("inapp");
            } else {
                this.purchaseTypes.remove("inapp");
            }
            return this;
        }

        public final Builder setSandbox(boolean z) {
            this.sandbox = z;
            return this;
        }

        public final Builder setSubscriptionValidationResultListener(SubscriptionPurchaseValidationResultListener subscriptionPurchaseValidationResultListener) {
            this.subscriptionValidationResultListener = subscriptionPurchaseValidationResultListener;
            return this;
        }

        public final Builder setInAppValidationResultListener(InAppPurchaseValidationResultListener inAppPurchaseValidationResultListener) {
            this.inAppValidationResultListener = inAppPurchaseValidationResultListener;
            return this;
        }

        public final Builder setSubscriptionPurchaseEventDataSource(SubscriptionPurchaseEventDataSource subscriptionPurchaseEventDataSource) {
            this.subscriptionPurchaseEventDataSource = subscriptionPurchaseEventDataSource;
            return this;
        }

        public final Builder setInAppPurchaseEventDataSource(InAppPurchaseEventDataSource inAppPurchaseEventDataSource) {
            this.inAppPurchaseEventDataSource = inAppPurchaseEventDataSource;
            return this;
        }

        public final Builder setBillingClientFactory(AFPurchaseConnectorA1r.AFPurchaseConnectorA1w<?> aFPurchaseConnectorA1w) {
            this.billingClientFactory = aFPurchaseConnectorA1w;
            return this;
        }

        public final Builder setAfClient(AppsFlyerLib appsFlyerLib) {
            this.afClient = appsFlyerLib;
            return this;
        }

        public final Builder setConnector(AFPurchaseConnectorA1r aFPurchaseConnectorA1r) {
            this.connector = aFPurchaseConnectorA1r;
            return this;
        }

        public final PurchaseClient build() throws SDKMissingException {
            try {
                if (this.afClient == null) {
                    this.afClient = AppsFlyerLib.getInstance();
                }
                if (AFPurchaseConnectorA1y.InAppPurchaseEvent[this.store.ordinal()] == 1 && this.connector == null) {
                    Context context = this.context;
                    AFPurchaseConnectorA1u.AFPurchaseConnectorA1x aFPurchaseConnectorA1x = (AFPurchaseConnectorA1u.AFPurchaseConnectorA1x) this.billingClientFactory;
                    try {
                        Object[] objArr = {context};
                        Object obj = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-1362281777);
                        if (obj == null) {
                            obj = ((Class) AFPurchaseConnectorA1w.getQuantity((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 70, (-16777146) - Color.rgb(0, 0, 0), (char) KeyEvent.getDeadChar(0, 0))).getMethod("a_", Context.class);
                            AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-1362281777, obj);
                        }
                        this.connector = new AFPurchaseConnectorA1u(context, aFPurchaseConnectorA1x, (SharedPreferences) ((Method) obj).invoke(null, objArr), this.purchaseDatabaseHelper);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                Context context2 = this.context;
                boolean z = this.sandbox;
                AFPurchaseConnectorA1r aFPurchaseConnectorA1r = this.connector;
                Intrinsics.checkNotNull(aFPurchaseConnectorA1r);
                Set<String> set = this.purchaseTypes;
                SubscriptionPurchaseValidationResultListener subscriptionPurchaseValidationResultListener = this.subscriptionValidationResultListener;
                InAppPurchaseValidationResultListener inAppPurchaseValidationResultListener = this.inAppValidationResultListener;
                SubscriptionPurchaseEventDataSource subscriptionPurchaseEventDataSource = this.subscriptionPurchaseEventDataSource;
                InAppPurchaseEventDataSource inAppPurchaseEventDataSource = this.inAppPurchaseEventDataSource;
                AppsFlyerLib appsFlyerLib = this.afClient;
                Intrinsics.checkNotNull(appsFlyerLib);
                Object[] objArr2 = {context2, Boolean.valueOf(z), aFPurchaseConnectorA1r, set, subscriptionPurchaseValidationResultListener, inAppPurchaseValidationResultListener, subscriptionPurchaseEventDataSource, inAppPurchaseEventDataSource, appsFlyerLib, this.purchaseDatabaseHelper};
                Object obj2 = AFPurchaseConnectorA1w.PurchaseClientCompanion.get(-2048738244);
                if (obj2 == null) {
                    obj2 = ((Class) AFPurchaseConnectorA1w.getQuantity(TextUtils.indexOf("", "", 0, 0) + 70, KeyEvent.getMaxKeyCode() >> 16, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 41950))).getDeclaredConstructor(Context.class, Boolean.TYPE, AFPurchaseConnectorA1r.class, Set.class, SubscriptionPurchaseValidationResultListener.class, InAppPurchaseValidationResultListener.class, SubscriptionPurchaseEventDataSource.class, InAppPurchaseEventDataSource.class, AppsFlyerLib.class, AFPurchaseConnectorA1l.class);
                    AFPurchaseConnectorA1w.PurchaseClientCompanion.put(-2048738244, obj2);
                }
                return (PurchaseClient) ((Constructor) obj2).newInstance(objArr2);
            } catch (NoClassDefFoundError e) {
                Log.w("AppsFlyer_Connector", "[PurchaseConnector]: AppsFlyer SDK required!");
                e.printStackTrace();
                throw new SDKMissingException();
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class AFPurchaseConnectorA1y {
            public static final /* synthetic */ int[] InAppPurchaseEvent;

            static {
                int[] iArr = new int[Store.values().length];
                try {
                    iArr[Store.GOOGLE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                InAppPurchaseEvent = iArr;
            }
        }
    }

    static String getVERSION_NAME() {
        return Companion.getVERSION_NAME();
    }
}
