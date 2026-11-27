package org.opencv.core;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class Mat {
    public final long a;

    public Mat(long j2) {
        if (j2 == 0) {
            throw new UnsupportedOperationException("Native object address is NULL");
        }
        this.a = j2;
    }

    private static native int nPutB(long j2, int i2, int i3, int i4, byte[] bArr);

    private static native long n_Mat();

    private static native long n_Mat(int i2, int i3, int i4);

    private static native long n_Mat(int i2, int i3, int i4, ByteBuffer byteBuffer);

    private static native long n_clone(long j2);

    private static native int n_cols(long j2);

    private static native long n_dataAddr(long j2);

    private static native void n_delete(long j2);

    private static native boolean n_empty(long j2);

    private static native boolean n_isContinuous(long j2);

    private static native boolean n_isSubmatrix(long j2);

    private static native void n_release(long j2);

    private static native int n_rows(long j2);

    private static native long n_submat_rr(long j2, int i2, int i3, int i4, int i5);

    private static native int n_type(long j2);

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Mat clone() {
        return new Mat(n_clone(this.a));
    }

    public int b() {
        return n_cols(this.a);
    }

    public long c() {
        return n_dataAddr(this.a);
    }

    public boolean d() {
        return n_empty(this.a);
    }

    public boolean e() {
        return n_isContinuous(this.a);
    }

    public boolean f() {
        return n_isSubmatrix(this.a);
    }

    protected void finalize() throws Throwable {
        n_delete(this.a);
        super.finalize();
    }

    public int g(int i2, int i3, byte[] bArr) {
        int iK = k();
        if (bArr == null || bArr.length % b.h(iK) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Provided data element number (");
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(") should be multiple of the Mat channels count (");
            sb.append(b.h(iK));
            sb.append(")");
            throw new UnsupportedOperationException(sb.toString());
        }
        if (b.i(iK) == 0 || b.i(iK) == 1) {
            return nPutB(this.a, i2, i3, bArr.length, bArr);
        }
        throw new UnsupportedOperationException("Mat data type is not compatible: " + iK);
    }

    public void h() {
        n_release(this.a);
    }

    public int i() {
        return n_rows(this.a);
    }

    public Mat j(int i2, int i3, int i4, int i5) {
        return new Mat(n_submat_rr(this.a, i2, i3, i4, i5));
    }

    public int k() {
        return n_type(this.a);
    }

    public String toString() {
        return "Mat [ " + i() + "*" + b() + "*" + b.k(k()) + ", isCont=" + e() + ", isSubmat=" + f() + ", nativeObj=0x" + Long.toHexString(this.a) + ", dataAddr=0x" + Long.toHexString(c()) + " ]";
    }

    public Mat() {
        this.a = n_Mat();
    }

    public Mat(int i2, int i3, int i4) {
        this.a = n_Mat(i2, i3, i4);
    }

    public Mat(int i2, int i3, int i4, ByteBuffer byteBuffer) {
        this.a = n_Mat(i2, i3, i4, byteBuffer);
    }
}
