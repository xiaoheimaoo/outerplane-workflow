package com.appsflyer.internal;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class AFk1mSDK extends FilterInputStream {
    private static final short AFAdRevenueData = (short) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d));
    private int AFInAppEventParameterName;
    private int areAllFieldsValid;
    private int component1;
    private int component2;
    private int component3;
    private int component4;
    private final int copy;
    private final int copydefault;
    private int equals;
    private byte[] getCurrencyIso4217Code;
    private byte[] getMediationNetwork;
    private byte[] getMonetizationNetwork;
    private int getRevenue;
    private int hashCode;
    private int toString;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    public AFk1mSDK(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3) throws IOException {
        this(inputStream, iArr, i, bArr, i2, i3, (byte) 0);
    }

    private AFk1mSDK(InputStream inputStream, int[] iArr, int i, byte[] bArr, int i2, int i3, byte b) throws IOException {
        super(new BufferedInputStream(inputStream, 4096));
        this.component4 = Integer.MAX_VALUE;
        this.AFInAppEventParameterName = 1;
        this.getMediationNetwork = new byte[8];
        this.getMonetizationNetwork = new byte[8];
        this.getCurrencyIso4217Code = new byte[8];
        this.getRevenue = 8;
        this.areAllFieldsValid = 8;
        this.component2 = Math.min(Math.max(i2, 5), 16);
        this.component1 = i3;
        if (i3 == 3) {
            System.arraycopy(bArr, 0, this.getMonetizationNetwork, 0, 8);
        }
        long j = (iArr[1] & 4294967295L) | ((iArr[0] & 4294967295L) << 32);
        if (i != 0) {
            int i4 = (int) j;
            this.component3 = i4;
            this.equals = i4 * i;
            this.toString = i ^ i4;
            this.hashCode = (int) (j >> 32);
        } else {
            this.component3 = (int) j;
            long j2 = j >> 3;
            short s = AFAdRevenueData;
            this.equals = (int) ((s * j2) >> 32);
            this.toString = (int) (j >> 32);
            this.hashCode = (int) (j2 + s);
        }
        this.copy = 100;
        this.copydefault = 100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        getCurrencyIso4217Code();
        int i = this.getRevenue;
        if (i >= this.areAllFieldsValid) {
            return -1;
        }
        byte[] bArr = this.getMediationNetwork;
        this.getRevenue = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            getCurrencyIso4217Code();
            int i5 = this.getRevenue;
            if (i5 >= this.areAllFieldsValid) {
                if (i4 == i) {
                    return -1;
                }
                return i2 - (i3 - i4);
            }
            byte[] bArr2 = this.getMediationNetwork;
            this.getRevenue = i5 + 1;
            bArr[i4] = bArr2[i5];
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long j2 = 0;
        while (j2 < j && read() != -1) {
            j2++;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        getCurrencyIso4217Code();
        return this.areAllFieldsValid - this.getRevenue;
    }

    private void getMonetizationNetwork() {
        if (this.component1 == 3) {
            byte[] bArr = this.getMediationNetwork;
            System.arraycopy(bArr, 0, this.getCurrencyIso4217Code, 0, bArr.length);
        }
        byte[] bArr2 = this.getMediationNetwork;
        int i = ((bArr2[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) + ((bArr2[1] << Ascii.DLE) & 16711680) + ((bArr2[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + (bArr2[3] & 255);
        int i2 = ((-16777216) & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << Ascii.DLE)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i3 = 0;
        while (true) {
            int i4 = this.component2;
            if (i3 >= i4) {
                break;
            }
            short s = AFAdRevenueData;
            i2 -= ((((i4 - i3) * s) + i) ^ ((i << 4) + this.toString)) ^ ((i >>> 5) + this.hashCode);
            i -= (((i2 << 4) + this.component3) ^ ((s * (i4 - i3)) + i2)) ^ ((i2 >>> 5) + this.equals);
            i3++;
        }
        byte[] bArr3 = this.getMediationNetwork;
        bArr3[0] = (byte) (i >> 24);
        bArr3[1] = (byte) (i >> 16);
        bArr3[2] = (byte) (i >> 8);
        bArr3[3] = (byte) i;
        bArr3[4] = (byte) (i2 >> 24);
        bArr3[5] = (byte) (i2 >> 16);
        bArr3[6] = (byte) (i2 >> 8);
        bArr3[7] = (byte) i2;
        if (this.component1 == 3) {
            for (int i5 = 0; i5 < 8; i5++) {
                byte[] bArr4 = this.getMediationNetwork;
                bArr4[i5] = (byte) (bArr4[i5] ^ this.getMonetizationNetwork[i5]);
            }
            byte[] bArr5 = this.getCurrencyIso4217Code;
            System.arraycopy(bArr5, 0, this.getMonetizationNetwork, 0, bArr5.length);
        }
    }

    private int getCurrencyIso4217Code() throws IOException {
        if (this.component4 == Integer.MAX_VALUE) {
            this.component4 = ((FilterInputStream) this).in.read();
        }
        if (this.getRevenue == 8) {
            byte[] bArr = this.getMediationNetwork;
            int i = this.component4;
            bArr[0] = (byte) i;
            if (i < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i2 = 1;
            do {
                int read = ((FilterInputStream) this).in.read(this.getMediationNetwork, i2, 8 - i2);
                if (read <= 0) {
                    break;
                }
                i2 += read;
            } while (i2 < 8);
            if (i2 < 8) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = this.copy;
            if (i3 == this.copydefault) {
                getMonetizationNetwork();
            } else {
                if (this.AFInAppEventParameterName <= i3) {
                    getMonetizationNetwork();
                }
                int i4 = this.AFInAppEventParameterName;
                if (i4 < this.copydefault) {
                    this.AFInAppEventParameterName = i4 + 1;
                } else {
                    this.AFInAppEventParameterName = 1;
                }
            }
            int read2 = ((FilterInputStream) this).in.read();
            this.component4 = read2;
            this.getRevenue = 0;
            this.areAllFieldsValid = read2 < 0 ? 8 - (this.getMediationNetwork[7] & 255) : 8;
        }
        return this.areAllFieldsValid;
    }
}
