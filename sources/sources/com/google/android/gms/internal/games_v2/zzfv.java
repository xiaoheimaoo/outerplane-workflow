package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-games-v2@@22.1.0 */
/* loaded from: classes2.dex */
public final class zzfv implements SnapshotsClient {
    private final zzaq zza;

    public zzfv(zzaq zzaqVar) {
        this.zza = zzaqVar;
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotMetadata> commitAndClose(final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfo
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Snapshot snapshot2 = Snapshot.this;
                final SnapshotMetadataChange snapshotMetadataChange2 = snapshotMetadataChange;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzff
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzN((TaskCompletionSource) obj2, Snapshot.this, snapshotMetadataChange2);
                    }
                }).setMethodKey(6722).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<String> delete(final SnapshotMetadata snapshotMetadata) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfq
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final SnapshotMetadata snapshotMetadata2 = SnapshotMetadata.this;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzft
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzO((TaskCompletionSource) obj2, SnapshotMetadata.this.getSnapshotId());
                    }
                }).setMethodKey(6724).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Void> discardAndClose(final Snapshot snapshot) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfp
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final Snapshot snapshot2 = Snapshot.this;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfe
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        SnapshotContents snapshotContents = Snapshot.this.getSnapshotContents();
                        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
                        Contents zza = snapshotContents.zza();
                        snapshotContents.zzb();
                        ((com.google.android.gms.games.internal.zzao) ((com.google.android.gms.games.internal.zzai) obj).getService()).zzC(zza);
                        ((TaskCompletionSource) obj2).trySetResult(null);
                    }
                }).setMethodKey(6723).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxCoverImageSize() {
        return this.zza.zzb(zzfd.zza);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxDataSize() {
        return this.zza.zzb(zzfu.zza);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Intent> getSelectSnapshotIntent(final String str, final boolean z, final boolean z2, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfl
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z3 = z;
                final boolean z4 = z2;
                final int i2 = i;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfi
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).trySetResult(((com.google.android.gms.games.internal.zzao) ((com.google.android.gms.games.internal.zzai) obj).getService()).zzz(str2, z3, z4, i2));
                    }
                }).setMethodKey(6719).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<AnnotatedData<SnapshotMetadataBuffer>> load(final boolean z) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfm
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final boolean z2 = z;
                return googleApi.doRead(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfh
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzL((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6720).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        return this.zza.zzb(new zzfr(str, metadata.getSnapshotId(), builder.build(), snapshot.getSnapshotContents()));
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i) {
        return open(snapshotMetadata.getUniqueName(), false, i);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(String str, boolean z) {
        return open(str, z, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(final String str, final boolean z, final int i) {
        return this.zza.zzb(new zzap() { // from class: com.google.android.gms.internal.games_v2.zzfn
            @Override // com.google.android.gms.internal.games_v2.zzap
            public final /* synthetic */ Task zza(GoogleApi googleApi) {
                TaskApiCall.Builder builder = TaskApiCall.builder();
                final String str2 = str;
                final boolean z2 = z;
                final int i2 = i;
                return googleApi.doWrite(builder.run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzfg
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final /* synthetic */ void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzai) obj).zzM((TaskCompletionSource) obj2, str2, z2, i2);
                    }
                }).setMethodKey(6721).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return this.zza.zzb(new zzfr(str, str2, snapshotMetadataChange, snapshotContents));
    }
}
