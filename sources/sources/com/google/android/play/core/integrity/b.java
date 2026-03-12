package com.google.android.play.core.integrity;
/* compiled from: com.google.android.play:integrity@@1.3.0 */
/* loaded from: classes2.dex */
final class b extends bq {
    private String a;
    private y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.bq
    public final bq a(y yVar) {
        this.b = yVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.bq
    public final bq b(String str) {
        if (str != null) {
            this.a = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.integrity.bq
    public final br c() {
        y yVar;
        String str = this.a;
        if (str == null || (yVar = this.b) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.a == null) {
                sb.append(" token");
            }
            if (this.b == null) {
                sb.append(" integrityDialogWrapper");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new br(str, yVar);
    }
}
