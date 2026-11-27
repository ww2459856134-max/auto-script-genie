package com.tencent.open.utils;

/* compiled from: ProGuard */
/* loaded from: classes.dex */
public final class n implements Cloneable {
    private int a;

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i2 = this.a;
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 & 65280) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.a == ((n) obj).b();
    }

    public int hashCode() {
        return this.a;
    }

    public n(byte[] bArr, int i2) {
        int i3 = (bArr[i2 + 1] << 8) & 65280;
        this.a = i3;
        this.a = i3 + (bArr[i2] & 255);
    }

    public n(int i2) {
        this.a = i2;
    }
}
