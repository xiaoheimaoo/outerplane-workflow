package com.google.firebase.firestore.local;

import com.google.protobuf.ByteString;
/* loaded from: classes3.dex */
interface GlobalsCache {
    ByteString getSessionsToken();

    void setSessionToken(ByteString byteString);
}
