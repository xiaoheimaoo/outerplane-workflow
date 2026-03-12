package androidx.credentials.webauthn;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.helpshift.HelpshiftEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* compiled from: Cbor.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002#$B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006%"}, d2 = {"Landroidx/credentials/webauthn/Cbor;", "", "()V", "TYPE_ARRAY", "", "getTYPE_ARRAY", "()I", "TYPE_BYTE_STRING", "getTYPE_BYTE_STRING", "TYPE_FLOAT", "getTYPE_FLOAT", "TYPE_MAP", "getTYPE_MAP", "TYPE_NEGATIVE_INT", "getTYPE_NEGATIVE_INT", "TYPE_TAG", "getTYPE_TAG", "TYPE_TEXT_STRING", "getTYPE_TEXT_STRING", "TYPE_UNSIGNED_INT", "getTYPE_UNSIGNED_INT", "createArg", "", HelpshiftEvent.DATA_MESSAGE_TYPE, "arg", "", "decode", "data", "encode", "getArg", "Landroidx/credentials/webauthn/Cbor$Arg;", TypedValues.CycleType.S_WAVE_OFFSET, "getType", "parseItem", "Landroidx/credentials/webauthn/Cbor$Item;", "Arg", "Item", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Cbor {
    private final int TYPE_UNSIGNED_INT;
    private final int TYPE_NEGATIVE_INT = 1;
    private final int TYPE_BYTE_STRING = 2;
    private final int TYPE_TEXT_STRING = 3;
    private final int TYPE_ARRAY = 4;
    private final int TYPE_MAP = 5;
    private final int TYPE_TAG = 6;
    private final int TYPE_FLOAT = 7;

    /* compiled from: Cbor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/credentials/webauthn/Cbor$Item;", "", "item", "len", "", "(Ljava/lang/Object;I)V", "getItem", "()Ljava/lang/Object;", "getLen", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Item {
        private final Object item;
        private final int len;

        public static /* synthetic */ Item copy$default(Item item, Object obj, int i, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = item.item;
            }
            if ((i2 & 2) != 0) {
                i = item.len;
            }
            return item.copy(obj, i);
        }

        public final Object component1() {
            return this.item;
        }

        public final int component2() {
            return this.len;
        }

        public final Item copy(Object item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new Item(item, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.item, item.item) && this.len == item.len;
            }
            return false;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + Integer.hashCode(this.len);
        }

        public String toString() {
            return "Item(item=" + this.item + ", len=" + this.len + ')';
        }

        public Item(Object item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            this.len = i;
        }

        public final Object getItem() {
            return this.item;
        }

        public final int getLen() {
            return this.len;
        }
    }

    /* compiled from: Cbor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/credentials/webauthn/Cbor$Arg;", "", "arg", "", "len", "", "(JI)V", "getArg", "()J", "getLen", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Arg {
        private final long arg;
        private final int len;

        public static /* synthetic */ Arg copy$default(Arg arg, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = arg.arg;
            }
            if ((i2 & 2) != 0) {
                i = arg.len;
            }
            return arg.copy(j, i);
        }

        public final long component1() {
            return this.arg;
        }

        public final int component2() {
            return this.len;
        }

        public final Arg copy(long j, int i) {
            return new Arg(j, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Arg) {
                Arg arg = (Arg) obj;
                return this.arg == arg.arg && this.len == arg.len;
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.arg) * 31) + Integer.hashCode(this.len);
        }

        public String toString() {
            return "Arg(arg=" + this.arg + ", len=" + this.len + ')';
        }

        public Arg(long j, int i) {
            this.arg = j;
            this.len = i;
        }

        public final long getArg() {
            return this.arg;
        }

        public final int getLen() {
            return this.len;
        }
    }

    public final int getTYPE_UNSIGNED_INT() {
        return this.TYPE_UNSIGNED_INT;
    }

    public final int getTYPE_NEGATIVE_INT() {
        return this.TYPE_NEGATIVE_INT;
    }

    public final int getTYPE_BYTE_STRING() {
        return this.TYPE_BYTE_STRING;
    }

    public final int getTYPE_TEXT_STRING() {
        return this.TYPE_TEXT_STRING;
    }

    public final int getTYPE_ARRAY() {
        return this.TYPE_ARRAY;
    }

    public final int getTYPE_MAP() {
        return this.TYPE_MAP;
    }

    public final int getTYPE_TAG() {
        return this.TYPE_TAG;
    }

    public final int getTYPE_FLOAT() {
        return this.TYPE_FLOAT;
    }

    public final Object decode(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return parseItem(data, 0).getItem();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.Map] */
    public final byte[] encode(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Number) {
            if (data instanceof Double) {
                throw new IllegalArgumentException("Don't support doubles yet");
            }
            long longValue = ((Number) data).longValue();
            if (longValue >= 0) {
                return createArg(this.TYPE_UNSIGNED_INT, longValue);
            }
            return createArg(this.TYPE_NEGATIVE_INT, (-1) - longValue);
        } else if (data instanceof byte[]) {
            byte[] bArr = (byte[]) data;
            return ArraysKt.plus(createArg(this.TYPE_BYTE_STRING, bArr.length), bArr);
        } else if (data instanceof String) {
            String str = (String) data;
            return ArraysKt.plus(createArg(this.TYPE_TEXT_STRING, str.length()), StringsKt.encodeToByteArray(str));
        } else if (data instanceof List) {
            List list = (List) data;
            byte[] createArg = createArg(this.TYPE_ARRAY, list.size());
            for (Object obj : list) {
                Intrinsics.checkNotNull(obj);
                createArg = ArraysKt.plus(createArg, encode(obj));
            }
            return createArg;
        } else if (data instanceof Map) {
            Map map = (Map) data;
            byte[] createArg2 = createArg(this.TYPE_MAP, map.size());
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Intrinsics.checkNotNull(key);
                byte[] encode = encode(key);
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                ((Map) objectRef.element).put(encode, encode(value));
            }
            ArrayList arrayList = new ArrayList(((Map) objectRef.element).keySet());
            CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.credentials.webauthn.Cbor$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int encode$lambda$0;
                    encode$lambda$0 = Cbor.encode$lambda$0(Ref.ObjectRef.this, (byte[]) obj2, (byte[]) obj3);
                    return encode$lambda$0;
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] key2 = (byte[]) it.next();
                Intrinsics.checkNotNullExpressionValue(key2, "key");
                byte[] plus = ArraysKt.plus(createArg2, key2);
                Object obj2 = ((Map) objectRef.element).get(key2);
                Intrinsics.checkNotNull(obj2);
                createArg2 = ArraysKt.plus(plus, (byte[]) obj2);
            }
            return createArg2;
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int encode$lambda$0(Ref.ObjectRef byteMap, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(byteMap, "$byteMap");
        Object obj = ((Map) byteMap.element).get(bArr);
        Intrinsics.checkNotNull(obj);
        byte[] bArr3 = (byte[]) obj;
        Object obj2 = ((Map) byteMap.element).get(bArr2);
        Intrinsics.checkNotNull(obj2);
        byte[] bArr4 = (byte[]) obj2;
        if (bArr.length > bArr2.length) {
            return 1;
        }
        if (bArr.length >= bArr2.length) {
            if (bArr3.length > bArr4.length) {
                return 1;
            }
            if (bArr3.length >= bArr4.length) {
                return 0;
            }
        }
        return -1;
    }

    private final int getType(byte[] bArr, int i) {
        return (bArr[i] & 255) >> 5;
    }

    private final Arg getArg(byte[] bArr, int i) {
        long j = bArr[i] & 31;
        int i2 = (j > 24L ? 1 : (j == 24L ? 0 : -1));
        if (i2 < 0) {
            return new Arg(j, 1);
        }
        if (i2 == 0) {
            return new Arg(bArr[i + 1] & 255, 2);
        }
        if (j == 25) {
            return new Arg((bArr[i + 2] & 255) | ((bArr[i + 1] & 255) << 8), 3);
        } else if (j == 26) {
            return new Arg((bArr[i + 4] & 255) | ((bArr[i + 1] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 8), 5);
        } else {
            throw new IllegalArgumentException("Bad arg");
        }
    }

    private final Item parseItem(byte[] bArr, int i) {
        int type = getType(bArr, i);
        Arg arg = getArg(bArr, i);
        System.out.println((Object) ("Type " + type + ' ' + arg.getArg() + ' ' + arg.getLen()));
        if (type == this.TYPE_UNSIGNED_INT) {
            return new Item(Long.valueOf(arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_NEGATIVE_INT) {
            return new Item(Long.valueOf((-1) - arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_BYTE_STRING) {
            return new Item(ArraysKt.sliceArray(bArr, RangesKt.until(arg.getLen() + i, i + arg.getLen() + ((int) arg.getArg()))), arg.getLen() + ((int) arg.getArg()));
        }
        if (type == this.TYPE_TEXT_STRING) {
            return new Item(new String(ArraysKt.sliceArray(bArr, RangesKt.until(arg.getLen() + i, i + arg.getLen() + ((int) arg.getArg()))), Charsets.UTF_8), arg.getLen() + ((int) arg.getArg()));
        }
        int i2 = 0;
        if (type == this.TYPE_ARRAY) {
            ArrayList arrayList = new ArrayList();
            int len = arg.getLen();
            int arg2 = (int) arg.getArg();
            while (i2 < arg2) {
                Item parseItem = parseItem(bArr, i + len);
                arrayList.add(parseItem.getItem());
                len += parseItem.getLen();
                i2++;
            }
            return new Item(CollectionsKt.toList(arrayList), len);
        } else if (type == this.TYPE_MAP) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int len2 = arg.getLen();
            int arg3 = (int) arg.getArg();
            while (i2 < arg3) {
                Item parseItem2 = parseItem(bArr, i + len2);
                int len3 = len2 + parseItem2.getLen();
                Item parseItem3 = parseItem(bArr, i + len3);
                len2 = len3 + parseItem3.getLen();
                linkedHashMap.put(parseItem2.getItem(), parseItem3.getItem());
                i2++;
            }
            return new Item(MapsKt.toMap(linkedHashMap), len2);
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    private final byte[] createArg(int i, long j) {
        int i2 = i << 5;
        int i3 = (int) j;
        if (j < 24) {
            return new byte[]{(byte) ((i2 | i3) & 255)};
        }
        if (j <= 255) {
            return new byte[]{(byte) ((i2 | 24) & 255), (byte) (i3 & 255)};
        }
        if (j <= 65535) {
            return new byte[]{(byte) ((i2 | 25) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
        }
        if (j <= 4294967295L) {
            return new byte[]{(byte) ((i2 | 26) & 255), (byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
        }
        throw new IllegalArgumentException("bad Arg");
    }
}
