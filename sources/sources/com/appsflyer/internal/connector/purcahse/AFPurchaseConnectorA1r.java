package com.appsflyer.internal.connector.purcahse;

import com.appsflyer.api.InAppPurchaseEvent;
import com.appsflyer.api.SubscriptionPurchaseEvent;
import java.util.List;
/* loaded from: classes.dex */
public interface AFPurchaseConnectorA1r {

    /* loaded from: classes.dex */
    public interface AFPurchaseConnectorA1w<StoreClient> {
    }

    /* loaded from: classes.dex */
    public interface AFPurchaseConnectorA1x {
        void getOneTimePurchaseOfferDetails(List<SubscriptionPurchaseEvent> list);

        void getQuantity(List<SubscriptionPurchaseEvent> list);

        void toJsonMap(List<InAppPurchaseEvent> list);
    }

    void InAppPurchaseEvent();

    boolean getOneTimePurchaseOfferDetails();

    void getPackageName();

    void toJsonMap(AFPurchaseConnectorA1x aFPurchaseConnectorA1x);
}
