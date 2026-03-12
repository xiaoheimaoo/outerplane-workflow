package com.google.firebase;

import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.MessageForwardingService;
import com.unity3d.player.UnityPlayerActivity;
/* loaded from: classes3.dex */
public class MessagingUnityPlayerActivity extends UnityPlayerActivity {
    private static final String EXTRA_FROM = "google.message_id";
    private static final String EXTRA_MESSAGE_ID_KEY = "google.message_id";
    private static final String EXTRA_MESSAGE_ID_KEY_SERVER = "message_id";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString(Constants.MessagePayloadKeys.MSGID);
        String string2 = extras.getString(Constants.MessagePayloadKeys.MSGID);
        if (string2 == null) {
            string2 = extras.getString("message_id");
        }
        if (string != null && string2 != null) {
            Intent intent2 = new Intent(this, MessageForwardingService.class);
            intent2.setAction(MessageForwardingService.ACTION_REMOTE_INTENT);
            intent2.putExtras(intent);
            intent2.setData(intent.getData());
            MessageForwardingService.enqueueWork(this, intent2);
        }
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.mUnityPlayer != null) {
            this.mUnityPlayer.quit();
            this.mUnityPlayer = null;
        }
        super.onCreate(bundle);
    }
}
