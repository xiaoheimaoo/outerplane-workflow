package com.appsflyer.internal;

import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AFi1gSDK implements AFi1lSDK {
    private PluginInfo getMediationNetwork = new PluginInfo(Plugin.NATIVE, "6.17.3", null, 4, null);

    @Override // com.appsflyer.internal.AFi1lSDK
    public final void getMediationNetwork(PluginInfo pluginInfo) {
        Intrinsics.checkNotNullParameter(pluginInfo, "");
        this.getMediationNetwork = pluginInfo;
    }

    @Override // com.appsflyer.internal.AFi1lSDK
    public final Map<String, Object> AFAdRevenueData() {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("platform", this.getMediationNetwork.getPlugin().getPluginName()), TuplesKt.to(MediationMetaData.KEY_VERSION, this.getMediationNetwork.getVersion()));
        if (!this.getMediationNetwork.getAdditionalParams().isEmpty()) {
            mutableMapOf.put("extras", this.getMediationNetwork.getAdditionalParams());
        }
        return mutableMapOf;
    }
}
