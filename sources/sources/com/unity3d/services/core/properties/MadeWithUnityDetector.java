package com.unity3d.services.core.properties;
/* loaded from: classes3.dex */
public class MadeWithUnityDetector {
    public static final String UNITY_PLAYER_CLASS_NAME = "com.unity3d.player.UnityPlayer";

    public static boolean isMadeWithUnity() {
        try {
            Class.forName(UNITY_PLAYER_CLASS_NAME);
        } catch (Throwable unused) {
        }
        return false;
    }
}
