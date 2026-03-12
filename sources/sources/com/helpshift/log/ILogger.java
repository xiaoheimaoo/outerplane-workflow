package com.helpshift.log;
/* loaded from: classes3.dex */
public interface ILogger {

    /* loaded from: classes3.dex */
    public enum LEVEL {
        DEBUG,
        WARN,
        ERROR
    }

    void d(String str, String str2);

    void d(String str, String str2, Throwable th);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th);
}
