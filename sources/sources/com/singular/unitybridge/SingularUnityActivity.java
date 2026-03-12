package com.singular.unitybridge;

import android.content.Intent;
import android.os.Bundle;
import com.unity3d.player.UnityPlayerActivity;
/* loaded from: classes3.dex */
public class SingularUnityActivity extends UnityPlayerActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SingularUnityBridge.onNewIntent(intent);
    }
}
