package com.helpshift.user;

import com.helpshift.HelpshiftUserLoginEventsListener;
import com.helpshift.concurrency.HSThreadingService;
import java.util.Map;
/* loaded from: classes3.dex */
public class InternalUserLoginEventListener implements HelpshiftUserLoginEventsListener {
    private final HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener;
    private final HSThreadingService threadingService;

    public InternalUserLoginEventListener(HSThreadingService hSThreadingService, HelpshiftUserLoginEventsListener helpshiftUserLoginEventsListener) {
        this.threadingService = hSThreadingService;
        this.helpshiftUserLoginEventsListener = helpshiftUserLoginEventsListener;
    }

    @Override // com.helpshift.HelpshiftUserLoginEventsListener
    public void onLoginFailure(final String str, final Map<String, String> map) {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.user.InternalUserLoginEventListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (InternalUserLoginEventListener.this.helpshiftUserLoginEventsListener != null) {
                    InternalUserLoginEventListener.this.helpshiftUserLoginEventsListener.onLoginFailure(str, map);
                }
            }
        });
    }

    @Override // com.helpshift.HelpshiftUserLoginEventsListener
    public void onLoginSuccess() {
        this.threadingService.runOnUIThread(new Runnable() { // from class: com.helpshift.user.InternalUserLoginEventListener.2
            @Override // java.lang.Runnable
            public void run() {
                if (InternalUserLoginEventListener.this.helpshiftUserLoginEventsListener != null) {
                    InternalUserLoginEventListener.this.helpshiftUserLoginEventsListener.onLoginSuccess();
                }
            }
        });
    }
}
