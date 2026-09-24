package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes.dex */
public interface Snapshot extends Freezable<Snapshot>, Parcelable {
    SnapshotMetadata getMetadata();

    SnapshotContents getSnapshotContents();
}
