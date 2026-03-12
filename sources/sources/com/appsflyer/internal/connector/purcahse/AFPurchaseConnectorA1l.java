package com.appsflyer.internal.connector.purcahse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1l;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "p0", "<init>", "(Landroid/content/Context;)V", "", "", "getQuantity", "()Ljava/util/Set;", "Landroid/database/sqlite/SQLiteDatabase;", "", "onCreate", "(Landroid/database/sqlite/SQLiteDatabase;)V", "onOpen", "", "p1", "p2", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "toJsonMap", "(Ljava/util/Set;)V", "AFPurchaseConnectorA1w"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AFPurchaseConnectorA1l extends SQLiteOpenHelper {
    public static final AFPurchaseConnectorA1w AFPurchaseConnectorA1w = new AFPurchaseConnectorA1w(null);
    private static final int InAppPurchaseEvent = 1;
    public static final String getPackageName = "purchases";
    private static final String getQuantity = "afpurchases.db";
    public static final String toJsonMap = "token";

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AFPurchaseConnectorA1l(Context context) {
        super(context, getQuantity, (SQLiteDatabase.CursorFactory) null, 1);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0083T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0083T¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0006\n\u0004\b\f\u0010\u0006"}, d2 = {"Lcom/appsflyer/internal/connector/purcahse/AFPurchaseConnectorA1l$AFPurchaseConnectorA1w;", "", "<init>", "()V", "", "toJsonMap", "Ljava/lang/String;", "InAppPurchaseEvent", "getQuantity", "getOneTimePurchaseOfferDetails", "", "I", "getPackageName"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AFPurchaseConnectorA1w {
        private AFPurchaseConnectorA1w() {
        }

        public /* synthetic */ AFPurchaseConnectorA1w(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "");
        sQLiteDatabase.execSQL("CREATE TABLE purchases (token TEXT PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public final Set<String> getQuantity() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Cursor query = getReadableDatabase().query(getPackageName, new String[]{toJsonMap}, null, null, null, null, null);
        try {
            Cursor cursor = query;
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow(toJsonMap));
                Intrinsics.checkNotNullExpressionValue(string, "");
                linkedHashSet.add(string);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
            return linkedHashSet;
        } finally {
        }
    }

    public final void toJsonMap(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (String str : set) {
                contentValues.put(toJsonMap, str);
                writableDatabase.insertWithOnConflict(getPackageName, null, contentValues, 4);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }
}
