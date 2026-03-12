package defpackage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
/* renamed from: FirebaseMessagingWorkaround  reason: default package */
/* loaded from: classes.dex */
public class FirebaseMessagingWorkaround {
    public static void subscribeAsync(final String str) {
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: FirebaseMessagingWorkaround.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                String str2;
                if (task.isSuccessful()) {
                    r0 = str + "Subscribed";
                } else {
                    str2 = str + "Unsubscribe failed";
                }
            }
        });
    }

    public static void unsubscribeAsync(final String str) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: FirebaseMessagingWorkaround.2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                String str2;
                if (task.isSuccessful()) {
                    r0 = str + "Unsubscribed";
                } else {
                    str2 = str + "Unsubscribe failed";
                }
            }
        });
    }
}
