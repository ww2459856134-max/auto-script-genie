package i.b.ha.a.b.d.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class q1 extends i.b.ha.a.b.d.a<o1> implements i.b.ha.a.b.f.h {
    private static final byte[] O = j2.e.a();
    private static final byte[] P = j2.d.a();
    private static final byte[] Q = j2.f.a();
    private static final byte[] U = {65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};
    private static final BigInteger V = BigInteger.valueOf(Long.MAX_VALUE);
    private final boolean A;
    private long C;
    private final boolean D;
    private final byte[] G;
    private final byte[] H;
    private final byte[] I;
    private final byte[] J;
    private final byte[] K;
    private int M;
    private final y1 e;
    private final boolean f;
    private final Inflater g;

    /* renamed from: h, reason: collision with root package name */
    private final ByteBuffer f1437h;

    /* renamed from: i, reason: collision with root package name */
    private r1 f1438i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1439j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1440k;
    private ByteArrayInputStream t;

    public q1(InputStream inputStream, String str, boolean z, boolean z2) {
        this(inputStream, str, z, z2, false);
    }

    private boolean F(byte[] bArr) throws IOException {
        BigInteger bigIntegerF = x1.f(bArr);
        long length = 8 - bArr.length;
        byte[] bArr2 = U;
        BigInteger bigIntegerAdd = bigIntegerF.add(BigInteger.valueOf(length - bArr2.length));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (bigIntegerAdd.signum() < 0) {
                int length3 = bArr.length + bigIntegerAdd.intValue();
                if (length3 < 8) {
                    return false;
                }
                int iAbs = Math.abs(bigIntegerAdd.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(iAbs, length2));
                if (iAbs < length2) {
                    O(bArr3, iAbs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = V;
                    if (bigIntegerAdd.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    T(Long.MAX_VALUE);
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger.negate());
                }
                T(bigIntegerAdd.longValue());
                N(bArr3);
            }
            return Arrays.equals(bArr3, U);
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean G(int i2) {
        return i2 == w1.g0[0];
    }

    private void H(j2 j2Var, j2 j2Var2) throws ZipException {
        a2 a2VarW = this.f1438i.a.w(f1.f1410h);
        if (a2VarW != null && !(a2VarW instanceof f1)) {
            throw new ZipException("archive contains unparseable zip64 extra field");
        }
        f1 f1Var = (f1) a2VarW;
        this.f1438i.c = f1Var != null;
        if (this.f1438i.b) {
            return;
        }
        if (f1Var != null) {
            j2 j2Var3 = j2.g;
            if (j2Var3.equals(j2Var2) || j2Var3.equals(j2Var)) {
                if (f1Var.i() == null || f1Var.l() == null) {
                    throw new ZipException("archive contains corrupted zip64 extra field");
                }
                long jC = f1Var.i().c();
                if (jC < 0) {
                    throw new ZipException("broken archive, entry with negative compressed size");
                }
                this.f1438i.a.setCompressedSize(jC);
                long jC2 = f1Var.l().c();
                if (jC2 < 0) {
                    throw new ZipException("broken archive, entry with negative size");
                }
                this.f1438i.a.setSize(jC2);
                return;
            }
        }
        if (j2Var2 == null || j2Var == null) {
            return;
        }
        if (j2Var2.d() < 0) {
            throw new ZipException("broken archive, entry with negative compressed size");
        }
        this.f1438i.a.setCompressedSize(j2Var2.d());
        if (j2Var.d() < 0) {
            throw new ZipException("broken archive, entry with negative size");
        }
        this.f1438i.a.setSize(j2Var.d());
    }

    private void I(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IOException(String.format("Negative offset %,d into buffer", Integer.valueOf(i2)));
        }
        ((PushbackInputStream) ((FilterInputStream) this).in).unread(bArr, i2, i3);
        j(i3);
    }

    private void J() throws IOException {
        N(this.J);
        j2 j2Var = new j2(this.J);
        if (j2.f.equals(j2Var)) {
            N(this.J);
            j2Var = new j2(this.J);
        }
        this.f1438i.a.setCrc(j2Var.d());
        N(this.K);
        j2 j2Var2 = new j2(this.K, 8);
        if (!j2Var2.equals(j2.d) && !j2Var2.equals(j2.e)) {
            long jD = x1.d(this.K);
            if (jD < 0) {
                throw new ZipException("broken archive, entry with negative compressed size");
            }
            this.f1438i.a.setCompressedSize(jD);
            long jE = x1.e(this.K, 8);
            if (jE < 0) {
                throw new ZipException("broken archive, entry with negative size");
            }
            this.f1438i.a.setSize(jE);
            return;
        }
        I(this.K, 8, 8);
        long jE2 = j2.e(this.K);
        if (jE2 < 0) {
            throw new ZipException("broken archive, entry with negative compressed size");
        }
        this.f1438i.a.setCompressedSize(jE2);
        long jF = j2.f(this.K, 4);
        if (jF < 0) {
            throw new ZipException("broken archive, entry with negative size");
        }
        this.f1438i.a.setSize(jF);
    }

    private int K(byte[] bArr, int i2, int i3) throws DataFormatException, IOException {
        int iM = M(bArr, i2, i3);
        if (iM <= 0) {
            if (this.g.finished()) {
                return -1;
            }
            if (this.g.needsDictionary()) {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            }
            if (iM == -1) {
                throw new IOException("Truncated ZIP file");
            }
        }
        return iM;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r3 = r0 - r4;
        java.lang.System.arraycopy(r1, r4, r1, 0, r3);
        O(r1, r3);
        java.lang.System.arraycopy(r1, 0, r8.G, 0, r0);
        O(r8.G, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r0 = new i.b.ha.a.b.d.c.j2(r8.G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r8.D != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        if (r0.equals(i.b.ha.a.b.d.c.j2.f) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        throw new i.b.ha.a.b.d.c.w0(i.b.ha.a.b.d.c.v0.g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
    
        if (r0.equals(i.b.ha.a.b.d.c.j2.f1423h) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (r0.equals(i.b.ha.a.b.d.c.j2.f) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        r0 = r8.G;
        java.lang.System.arraycopy(r0, 4, r0, 0, r0.length - 4);
        r0 = r8.G;
        O(r0, r0.length - 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean L() throws IOException {
        int iMin = Math.min(30, 22);
        byte[] bArr = new byte[iMin];
        N(bArr);
        int i2 = 0;
        loop0: while (true) {
            int i3 = 0;
            while (i2 <= 4092 && i3 <= iMin - 4) {
                try {
                    j2 j2Var = new j2(bArr, i3);
                    if (j2Var.equals(j2.e) || j2Var.equals(j2.f1423h) || j2Var.equals(j2.f)) {
                        break loop0;
                    }
                    if (j2Var.equals(new j2(w1.g0))) {
                        I(bArr, i3, iMin - i3);
                        return false;
                    }
                    i3++;
                    i2++;
                } catch (EOFException unused) {
                    throw new ZipException("Cannot find zip signature within the file");
                }
            }
            if (i2 >= 4092) {
                throw new ZipException("Cannot find zip signature within the first 4096 bytes");
            }
            System.arraycopy(bArr, iMin - 3, bArr, 0, 3);
            O(bArr, 3);
        }
    }

    private int M(byte[] bArr, int i2, int i3) throws DataFormatException, IOException {
        int iInflate = 0;
        while (true) {
            if (this.g.needsInput()) {
                int iX = x();
                if (iX > 0) {
                    r1.c(this.f1438i, this.f1437h.limit());
                    iInflate = this.g.inflate(bArr, i2, i3);
                    if (iInflate != 0) {
                        break;
                    }
                    break;
                    break;
                }
                if (iX == -1) {
                    return -1;
                }
            } else {
                try {
                    iInflate = this.g.inflate(bArr, i2, i3);
                    if (iInflate != 0 || !this.g.needsInput()) {
                        break;
                    }
                } catch (DataFormatException e) {
                    throw o2.j(e.getMessage(), e);
                }
            }
        }
        return iInflate;
    }

    private void N(byte[] bArr) throws IOException {
        O(bArr, 0);
    }

    private void O(byte[] bArr, int i2) throws IOException {
        int length = bArr.length - i2;
        int iA = i.b.ha.a.b.f.g.a(((FilterInputStream) this).in, bArr, i2, length);
        d(iA);
        if (iA < length) {
            throw new EOFException();
        }
    }

    private int P() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 != -1) {
            d(1);
        }
        return i2;
    }

    private byte[] Q(int i2) throws IOException {
        byte[] bArrC = i.b.ha.a.b.f.g.c(((FilterInputStream) this).in, i2);
        d(bArrC.length);
        if (bArrC.length >= i2) {
            return bArrC;
        }
        throw new EOFException();
    }

    private int R(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f1438i.b) {
            if (this.t == null) {
                S();
            }
            return this.t.read(bArr, i2, i3);
        }
        long size = this.f1438i.a.getSize();
        if (this.f1438i.d >= size) {
            return -1;
        }
        if (this.f1437h.position() >= this.f1437h.limit()) {
            this.f1437h.position(0);
            int i4 = ((FilterInputStream) this).in.read(this.f1437h.array());
            if (i4 == -1) {
                this.f1437h.limit(0);
                throw new IOException("Truncated ZIP file");
            }
            this.f1437h.limit(i4);
            d(i4);
            r1.c(this.f1438i, i4);
        }
        int iMin = Math.min(this.f1437h.remaining(), i3);
        if (size - this.f1438i.d < iMin) {
            iMin = (int) (size - this.f1438i.d);
        }
        this.f1437h.get(bArr, i2, iMin);
        r1.g(this.f1438i, iMin);
        return iMin;
    }

    private void S() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = this.f1438i.c ? 20 : 12;
        boolean zO = false;
        int iP = 0;
        while (!zO) {
            int i3 = ((FilterInputStream) this).in.read(this.f1437h.array(), iP, 512 - iP);
            if (i3 <= 0) {
                throw new IOException("Truncated ZIP file");
            }
            int i4 = i3 + iP;
            if (i4 < 4) {
                iP = i4;
            } else {
                zO = o(byteArrayOutputStream, iP, i3, i2);
                if (!zO) {
                    iP = p(byteArrayOutputStream, iP, i3, i2);
                }
            }
        }
        if (this.f1438i.a.getCompressedSize() != this.f1438i.a.getSize()) {
            throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it cannot be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See https://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length != this.f1438i.a.getSize()) {
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it cannot be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See https://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        this.t = new ByteArrayInputStream(byteArray);
    }

    private void T(long j2) throws IOException {
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException();
        }
        while (j3 < j2) {
            long length = j2 - j3;
            InputStream inputStream = ((FilterInputStream) this).in;
            byte[] bArr = this.H;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i2 = inputStream.read(bArr, 0, (int) length);
            if (i2 == -1) {
                return;
            }
            d(i2);
            j3 += i2;
        }
    }

    private void U() throws IOException {
        int i2 = this.M;
        if (i2 > 0) {
            T((i2 * 46) - 30);
        }
        if (y()) {
            T(16L);
            N(this.I);
            int iD = l2.d(this.I);
            if (iD >= 0) {
                T(iD);
                return;
            }
        }
        throw new IOException("Truncated ZIP file");
    }

    private boolean V(o1 o1Var) {
        int method = o1Var.getMethod();
        return o1Var.getCompressedSize() != -1 || method == 8 || method == k2.ENHANCED_DEFLATED.b() || (o1Var.x().i() && this.A && method == 0) || k2.d(method) || method == k2.XZ.b();
    }

    private boolean W(o1 o1Var) {
        int method = o1Var.getMethod();
        return !o1Var.x().i() || (this.A && method == 0) || method == 8 || method == k2.ENHANCED_DEFLATED.b() || k2.d(method) || method == k2.XZ.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean o(ByteArrayOutputStream byteArrayOutputStream, int i2, int i3, int i4) throws IOException {
        int i5;
        boolean z = false;
        int i6 = 0;
        while (!z) {
            int i7 = i2 + i3;
            if (i6 >= i7 - 4) {
                break;
            }
            byte b = this.f1437h.array()[i6];
            byte[] bArr = O;
            if (b == bArr[0] && this.f1437h.array()[i6 + 1] == bArr[1]) {
                if (i6 < i4 || this.f1437h.array()[i6 + 2] != bArr[2] || this.f1437h.array()[i6 + 3] != bArr[3]) {
                    int i8 = i6 + 2;
                    byte b2 = this.f1437h.array()[i8];
                    byte[] bArr2 = P;
                    if (b2 == bArr2[2] && this.f1437h.array()[i6 + 3] == bArr2[3]) {
                        i5 = i6 - i4;
                    } else {
                        byte b3 = this.f1437h.array()[i8];
                        byte[] bArr3 = Q;
                        if (b3 == bArr3[2] && this.f1437h.array()[i6 + 3] == bArr3[3]) {
                            i5 = i6;
                        } else {
                            i5 = i6;
                            if (!z) {
                                I(this.f1437h.array(), i5, i7 - i5);
                                byteArrayOutputStream.write(this.f1437h.array(), 0, i5);
                                J();
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            i6++;
        }
        return z;
    }

    private int p(ByteArrayOutputStream byteArrayOutputStream, int i2, int i3, int i4) {
        int i5 = i2 + i3;
        int i6 = (i5 - i4) - 3;
        if (i6 <= 0) {
            return i5;
        }
        byteArrayOutputStream.write(this.f1437h.array(), 0, i6);
        int i7 = i4 + 3;
        System.arraycopy(this.f1437h.array(), i6, this.f1437h.array(), 0, i7);
        return i7;
    }

    private void q() throws IOException {
        if (this.f1439j) {
            throw new IOException("The stream is closed");
        }
        if (this.f1438i == null) {
            return;
        }
        if (u()) {
            w();
        } else {
            if (skip(Long.MAX_VALUE) < 0) {
                throw new IllegalStateException("Can't read the remainder of the stream");
            }
            int iZ = (int) (this.f1438i.e - (this.f1438i.a.getMethod() == 8 ? z() : this.f1438i.d));
            if (iZ > 0) {
                I(this.f1437h.array(), this.f1437h.limit() - iZ, iZ);
                r1.d(this.f1438i, iZ);
            }
            if (u()) {
                w();
            }
        }
        if (this.t == null && this.f1438i.b) {
            J();
        }
        this.g.reset();
        this.f1437h.clear().flip();
        this.f1438i = null;
        this.t = null;
    }

    private boolean u() {
        return this.f1438i.e <= this.f1438i.a.getCompressedSize() && !this.f1438i.b;
    }

    private void w() throws IOException {
        long compressedSize = this.f1438i.a.getCompressedSize() - this.f1438i.e;
        while (compressedSize > 0) {
            long j2 = ((FilterInputStream) this).in.read(this.f1437h.array(), 0, (int) Math.min(this.f1437h.capacity(), compressedSize));
            if (j2 < 0) {
                throw new EOFException("Truncated ZIP entry: " + i.b.ha.a.b.f.a.a(this.f1438i.a.getName()));
            }
            f(j2);
            compressedSize -= j2;
        }
    }

    private int x() throws IOException {
        if (this.f1439j) {
            throw new IOException("The stream is closed");
        }
        int i2 = ((FilterInputStream) this).in.read(this.f1437h.array());
        if (i2 > 0) {
            this.f1437h.limit(i2);
            d(this.f1437h.limit());
            this.g.setInput(this.f1437h.array(), 0, this.f1437h.limit());
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000c A[PHI: r3
      0x000c: PHI (r3v2 int) = (r3v1 int), (r3v7 int) binds: [B:3:0x0004, B:5:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean y() throws IOException {
        boolean zG = false;
        int iP = -1;
        while (true) {
            if (!zG) {
                iP = P();
                if (iP <= -1) {
                    break;
                }
            } else if (G(iP)) {
                iP = P();
                byte[] bArr = w1.g0;
                if (iP == bArr[1]) {
                    iP = P();
                    if (iP == bArr[2]) {
                        iP = P();
                        if (iP == -1) {
                            break;
                        }
                        if (iP == bArr[3]) {
                            return true;
                        }
                        zG = G(iP);
                    } else {
                        if (iP == -1) {
                            break;
                        }
                        zG = G(iP);
                    }
                } else {
                    if (iP == -1) {
                        break;
                    }
                    zG = G(iP);
                }
            } else {
                zG = false;
            }
        }
    }

    private long z() {
        long bytesRead = this.g.getBytesRead();
        if (this.f1438i.e >= 4294967296L) {
            while (true) {
                long j2 = bytesRead + 4294967296L;
                if (j2 > this.f1438i.e) {
                    break;
                }
                bytesRead = j2;
            }
        }
        return bytesRead;
    }

    public o1 B() throws IOException {
        return D();
    }

    @Deprecated
    public o1 D() throws IOException {
        boolean z;
        j2 j2Var;
        j2 j2Var2;
        this.C = 0L;
        if (!this.f1439j && !this.f1440k) {
            if (this.f1438i != null) {
                q();
                z = false;
            } else {
                z = true;
            }
            long jI = i();
            try {
                if (!z) {
                    N(this.G);
                } else if (!L()) {
                    this.f1440k = true;
                    U();
                    return null;
                }
                j2 j2Var3 = new j2(this.G);
                if (!j2Var3.equals(j2.e)) {
                    if (!j2Var3.equals(j2.d) && !j2Var3.equals(j2.f1424i) && !F(this.G)) {
                        throw new ZipException(String.format("Unexpected record signature: 0x%x", Long.valueOf(j2Var3.d())));
                    }
                    this.f1440k = true;
                    U();
                    return null;
                }
                this.f1438i = new r1(null);
                this.f1438i.a.d0(i2.H(l2.e(this.G, 4)));
                e0 e0VarD = e0.d(this.G, 6);
                boolean zK = e0VarD.k();
                y1 y1Var = zK ? z1.a : this.e;
                this.f1438i.b = e0VarD.i();
                this.f1438i.a.X(e0VarD);
                this.f1438i.a.setMethod(l2.e(this.G, 8));
                this.f1438i.a.setTime(o2.e(j2.f(this.G, 10)));
                if (this.f1438i.b) {
                    j2Var = null;
                    j2Var2 = null;
                } else {
                    this.f1438i.a.setCrc(j2.f(this.G, 14));
                    j2Var = new j2(this.G, 18);
                    j2Var2 = new j2(this.G, 22);
                }
                int iE = l2.e(this.G, 26);
                int iE2 = l2.e(this.G, 28);
                byte[] bArrQ = Q(iE);
                this.f1438i.a.b0(y1Var.b(bArrQ), bArrQ);
                if (zK) {
                    this.f1438i.a.c0(n1.NAME_WITH_EFS_FLAG);
                }
                try {
                    this.f1438i.a.setExtra(Q(iE2));
                    if (!zK && this.f) {
                        o2.l(this.f1438i.a, bArrQ, null);
                    }
                    H(j2Var2, j2Var);
                    this.f1438i.a.Z(jI);
                    this.f1438i.a.R(i());
                    this.f1438i.a.f0(true);
                    k2 k2VarC = k2.c(this.f1438i.a.getMethod());
                    if (this.f1438i.a.getCompressedSize() != -1) {
                        if (o2.a(this.f1438i.a) && k2VarC != k2.STORED && k2VarC != k2.DEFLATED) {
                            a aVar = new a(((FilterInputStream) this).in, this.f1438i.a.getCompressedSize());
                            switch (p1.a[k2VarC.ordinal()]) {
                                case 1:
                                    this.f1438i.g = new u0(aVar);
                                    break;
                                case 2:
                                    try {
                                        r1 r1Var = this.f1438i;
                                        r1Var.g = new a0(r1Var.a.x().c(), this.f1438i.a.x().b(), aVar);
                                        break;
                                    } catch (IllegalArgumentException e) {
                                        throw new IOException("bad IMPLODE data", e);
                                    }
                                case 3:
                                    this.f1438i.g = new i.b.ha.a.b.e.b.b(aVar);
                                    break;
                                case 4:
                                    this.f1438i.g = new i.b.ha.a.b.e.c.a(aVar);
                                    break;
                                case 5:
                                case 6:
                                    this.f1438i.g = s(aVar);
                                    break;
                            }
                        }
                    } else if (k2VarC == k2.ENHANCED_DEFLATED) {
                        this.f1438i.g = new i.b.ha.a.b.e.c.a(((FilterInputStream) this).in);
                    }
                    this.M++;
                    return this.f1438i.a;
                } catch (RuntimeException e2) {
                    throw o2.j("Invalid extra data in entry " + this.f1438i.a.getName(), e2);
                }
            } catch (EOFException unused) {
            }
        }
        return null;
    }

    @Override // i.b.ha.a.b.f.h
    public long a() {
        r1 r1Var = this.f1438i;
        if (r1Var == null) {
            return -1L;
        }
        int method = r1Var.a.getMethod();
        if (method == 0) {
            return this.f1438i.d;
        }
        if (method == 8) {
            return z();
        }
        if (method == k2.UNSHRINKING.b() || method == k2.IMPLODING.b() || method == k2.ENHANCED_DEFLATED.b() || method == k2.BZIP2.b()) {
            return ((i.b.ha.a.b.f.h) this.f1438i.o()).a();
        }
        return -1L;
    }

    @Override // i.b.ha.a.b.f.h
    public long c() {
        return this.C;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f1439j) {
            return;
        }
        this.f1439j = true;
        try {
            ((FilterInputStream) this).in.close();
        } finally {
            this.g.end();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws DataFormatException, IOException {
        int iK;
        if (i3 == 0) {
            return 0;
        }
        if (this.f1439j) {
            throw new IOException("The stream is closed");
        }
        r1 r1Var = this.f1438i;
        if (r1Var == null) {
            return -1;
        }
        if (i2 > bArr.length || i3 < 0 || i2 < 0 || bArr.length - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        o2.b(r1Var.a);
        if (!W(this.f1438i.a)) {
            throw new w0(v0.f, this.f1438i.a);
        }
        if (!V(this.f1438i.a)) {
            throw new w0(v0.f1442h, this.f1438i.a);
        }
        int method = this.f1438i.a.getMethod();
        if (method == 0) {
            iK = R(bArr, i2, i3);
        } else if (method == 8) {
            iK = K(bArr, i2, i3);
        } else {
            if (method != k2.UNSHRINKING.b() && method != k2.IMPLODING.b() && method != k2.ENHANCED_DEFLATED.b() && method != k2.BZIP2.b() && !k2.d(method) && method != k2.XZ.b()) {
                throw new w0(k2.c(method), this.f1438i.a);
            }
            iK = this.f1438i.g.read(bArr, i2, i3);
        }
        if (iK >= 0) {
            this.f1438i.f.update(bArr, i2, iK);
            this.C += iK;
        }
        return iK;
    }

    protected InputStream s(InputStream inputStream) throws IOException {
        return new i.b.ha.a.b.e.f.a(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws DataFormatException, IOException {
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException("Negative skip value");
        }
        while (j3 < j2) {
            long length = j2 - j3;
            byte[] bArr = this.H;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i2 = read(bArr, 0, (int) length);
            if (i2 == -1) {
                return j3;
            }
            j3 += i2;
        }
        return j3;
    }

    public q1(InputStream inputStream, String str, boolean z, boolean z2, boolean z3) {
        super(inputStream, str);
        this.g = new Inflater(true);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        this.f1437h = byteBufferAllocate;
        this.G = new byte[30];
        this.H = new byte[1024];
        this.I = new byte[2];
        this.J = new byte[4];
        this.K = new byte[16];
        ((FilterInputStream) this).in = new PushbackInputStream(inputStream, byteBufferAllocate.capacity());
        this.e = z1.a(str);
        this.f = z;
        this.A = z2;
        this.D = z3;
        byteBufferAllocate.limit(0);
    }

    private final class a extends i.b.ha.a.c.j.e {
        a(InputStream inputStream, long j2) {
            super(inputStream, j2);
        }

        private boolean u() {
            return n() >= 0 && m() >= n();
        }

        private int w(int i2) {
            if (i2 != -1) {
                q1.this.d(i2);
                r1.c(q1.this.f1438i, i2);
            }
            return i2;
        }

        @Override // i.b.ha.a.c.j.e, i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (u()) {
                return -1;
            }
            int i2 = super.read();
            if (i2 != -1) {
                w(1);
            }
            return i2;
        }

        @Override // i.b.ha.a.c.j.e, i.b.ha.a.c.j.i, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (i3 == 0) {
                return 0;
            }
            if (u()) {
                return -1;
            }
            int i4 = super.read(bArr, i2, (int) (n() >= 0 ? Math.min(i3, n() - m()) : i3));
            w(i4);
            return i4;
        }
    }
}
