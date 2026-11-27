package m;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class a implements c, b, Cloneable, ByteChannel {

    @Nullable
    i c;
    long d;

    private boolean m(i iVar, int i2, d dVar, int i3, int i4) {
        int i5 = iVar.c;
        byte[] bArr = iVar.a;
        while (i3 < i4) {
            if (i2 == i5) {
                iVar = iVar.f;
                byte[] bArr2 = iVar.a;
                bArr = bArr2;
                i2 = iVar.b;
                i5 = iVar.c;
            }
            if (bArr[i2] != dVar.d(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public void B(long j2) throws EOFException {
        while (j2 > 0) {
            if (this.c == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, r0.c - r0.b);
            long j3 = iMin;
            this.d -= j3;
            j2 -= j3;
            i iVar = this.c;
            int i2 = iVar.b + iMin;
            iVar.b = i2;
            if (i2 == iVar.c) {
                this.c = iVar.b();
                j.a(iVar);
            }
        }
    }

    @Override // m.l
    public long C(a aVar, long j2) {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        }
        long j3 = this.d;
        if (j3 == 0) {
            return -1L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        aVar.H(this, j2);
        return j2;
    }

    public final d D() {
        long j2 = this.d;
        if (j2 <= 2147483647L) {
            return F((int) j2);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.d);
    }

    @Override // m.c
    public int E(g gVar) {
        int iZ = z(gVar, false);
        if (iZ == -1) {
            return -1;
        }
        try {
            B(gVar.c[iZ].size());
            return iZ;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final d F(int i2) {
        return i2 == 0 ? d.g : new k(this, i2);
    }

    i G(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        i iVar = this.c;
        if (iVar == null) {
            i iVarB = j.b();
            this.c = iVarB;
            iVarB.g = iVarB;
            iVarB.f = iVarB;
            return iVarB;
        }
        i iVar2 = iVar.g;
        if (iVar2.c + i2 <= 8192 && iVar2.e) {
            return iVar2;
        }
        i iVarB2 = j.b();
        iVar2.c(iVarB2);
        return iVarB2;
    }

    public void H(a aVar, long j2) {
        if (aVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (aVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        n.b(aVar.d, 0L, j2);
        while (j2 > 0) {
            i iVar = aVar.c;
            if (j2 < iVar.c - iVar.b) {
                i iVar2 = this.c;
                i iVar3 = iVar2 != null ? iVar2.g : null;
                if (iVar3 != null && iVar3.e) {
                    if ((iVar3.c + j2) - (iVar3.d ? 0 : iVar3.b) <= 8192) {
                        iVar.f(iVar3, (int) j2);
                        aVar.d -= j2;
                        this.d += j2;
                        return;
                    }
                }
                aVar.c = iVar.e((int) j2);
            }
            i iVar4 = aVar.c;
            long j3 = iVar4.c - iVar4.b;
            aVar.c = iVar4.b();
            i iVar5 = this.c;
            if (iVar5 == null) {
                this.c = iVar4;
                iVar4.g = iVar4;
                iVar4.f = iVar4;
            } else {
                iVar5.g.c(iVar4);
                iVar4.a();
            }
            aVar.d -= j3;
            this.d += j3;
            j2 -= j3;
        }
    }

    public a I(int i2) {
        i iVarG = G(1);
        byte[] bArr = iVarG.a;
        int i3 = iVarG.c;
        iVarG.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.d++;
        return this;
    }

    public a J(int i2) {
        i iVarG = G(4);
        byte[] bArr = iVarG.a;
        int i3 = iVarG.c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        iVarG.c = i6 + 1;
        this.d += 4;
        return this;
    }

    public a K(String str) {
        L(str, 0, str.length());
        return this;
    }

    public a L(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        }
        if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                i iVarG = G(1);
                byte[] bArr = iVarG.a;
                int i4 = iVarG.c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) cCharAt;
                while (i5 < iMin) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) cCharAt2;
                    i5++;
                }
                int i6 = iVarG.c;
                int i7 = (i4 + i5) - i6;
                iVarG.c = i6 + i7;
                this.d += i7;
                i2 = i5;
            } else {
                if (cCharAt < 2048) {
                    I((cCharAt >> 6) | 192);
                    I((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    I((cCharAt >> '\f') | 224);
                    I(((cCharAt >> 6) & 63) | 128);
                    I((cCharAt & '?') | 128);
                } else {
                    int i8 = i2 + 1;
                    char cCharAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        I(63);
                        i2 = i8;
                    } else {
                        int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + WXMediaMessage.THUMB_LENGTH_LIMIT;
                        I((i9 >> 18) | 240);
                        I(((i9 >> 12) & 63) | 128);
                        I(((i9 >> 6) & 63) | 128);
                        I((i9 & 63) | 128);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
        return this;
    }

    public final void a() {
        try {
            B(this.d);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // m.c
    public long b(d dVar) throws IOException {
        return i(dVar, 0L);
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a clone() {
        a aVar = new a();
        if (this.d == 0) {
            return aVar;
        }
        i iVarD = this.c.d();
        aVar.c = iVarD;
        iVarD.g = iVarD;
        iVarD.f = iVarD;
        i iVar = this.c;
        while (true) {
            iVar = iVar.f;
            if (iVar == this.c) {
                aVar.d = this.d;
                return aVar;
            }
            aVar.c.g.c(iVar.d());
        }
    }

    @Override // m.l, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean d() {
        return this.d == 0;
    }

    @Override // m.c
    public long e(d dVar) {
        return j(dVar, 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        long j2 = this.d;
        if (j2 != aVar.d) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        i iVar = this.c;
        i iVar2 = aVar.c;
        int i2 = iVar.b;
        int i3 = iVar2.b;
        while (j3 < this.d) {
            long jMin = Math.min(iVar.c - i2, iVar2.c - i3);
            int i4 = 0;
            while (i4 < jMin) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (iVar.a[i2] != iVar2.a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == iVar.c) {
                iVar = iVar.f;
                i2 = iVar.b;
            }
            if (i3 == iVar2.c) {
                iVar2 = iVar2.f;
                i3 = iVar2.b;
            }
            j3 += jMin;
        }
        return true;
    }

    public final byte f(long j2) {
        int i2;
        n.b(this.d, j2, 1L);
        long j3 = this.d;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            i iVar = this.c;
            do {
                iVar = iVar.g;
                int i3 = iVar.c;
                i2 = iVar.b;
                j4 += i3 - i2;
            } while (j4 < 0);
            return iVar.a[i2 + ((int) j4)];
        }
        i iVar2 = this.c;
        while (true) {
            int i4 = iVar2.c;
            int i5 = iVar2.b;
            long j5 = i4 - i5;
            if (j2 < j5) {
                return iVar2.a[i5 + ((int) j2)];
            }
            j2 -= j5;
            iVar2 = iVar2.f;
        }
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // m.b
    public /* bridge */ /* synthetic */ b g(String str, int i2, int i3) throws IOException {
        L(str, i2, i3);
        return this;
    }

    @Override // m.c
    public boolean h(long j2) {
        return this.d >= j2;
    }

    public int hashCode() {
        i iVar = this.c;
        if (iVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = iVar.c;
            for (int i4 = iVar.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + iVar.a[i4];
            }
            iVar = iVar.f;
        } while (iVar != this.c);
        return i2;
    }

    public long i(d dVar, long j2) throws IOException {
        byte[] bArr;
        if (dVar.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        i iVar = this.c;
        long j4 = -1;
        if (iVar == null) {
            return -1L;
        }
        long j5 = this.d;
        if (j5 - j2 < j2) {
            while (j5 > j2) {
                iVar = iVar.g;
                j5 -= iVar.c - iVar.b;
            }
        } else {
            while (true) {
                long j6 = (iVar.c - iVar.b) + j3;
                if (j6 >= j2) {
                    break;
                }
                iVar = iVar.f;
                j3 = j6;
            }
            j5 = j3;
        }
        byte bD = dVar.d(0);
        int size = dVar.size();
        long j7 = 1 + (this.d - size);
        long j8 = j2;
        i iVar2 = iVar;
        long j9 = j5;
        while (j9 < j7) {
            byte[] bArr2 = iVar2.a;
            int iMin = (int) Math.min(iVar2.c, (iVar2.b + j7) - j9);
            int i2 = (int) ((iVar2.b + j8) - j9);
            while (i2 < iMin) {
                if (bArr2[i2] == bD) {
                    bArr = bArr2;
                    if (m(iVar2, i2 + 1, dVar, 1, size)) {
                        return (i2 - iVar2.b) + j9;
                    }
                } else {
                    bArr = bArr2;
                }
                i2++;
                bArr2 = bArr;
            }
            j9 += iVar2.c - iVar2.b;
            iVar2 = iVar2.f;
            j8 = j9;
            j4 = -1;
        }
        return j4;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public long j(d dVar, long j2) {
        int i2;
        int i3;
        long j3 = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        i iVar = this.c;
        if (iVar == null) {
            return -1L;
        }
        long j4 = this.d;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                iVar = iVar.g;
                j4 -= iVar.c - iVar.b;
            }
        } else {
            while (true) {
                long j5 = (iVar.c - iVar.b) + j3;
                if (j5 >= j2) {
                    break;
                }
                iVar = iVar.f;
                j3 = j5;
            }
            j4 = j3;
        }
        if (dVar.size() == 2) {
            byte bD = dVar.d(0);
            byte bD2 = dVar.d(1);
            while (j4 < this.d) {
                byte[] bArr = iVar.a;
                i2 = (int) ((iVar.b + j2) - j4);
                int i4 = iVar.c;
                while (i2 < i4) {
                    byte b = bArr[i2];
                    if (b == bD || b == bD2) {
                        i3 = iVar.b;
                        return (i2 - i3) + j4;
                    }
                    i2++;
                }
                j4 += iVar.c - iVar.b;
                iVar = iVar.f;
                j2 = j4;
            }
            return -1L;
        }
        byte[] bArrF = dVar.f();
        while (j4 < this.d) {
            byte[] bArr2 = iVar.a;
            i2 = (int) ((iVar.b + j2) - j4);
            int i5 = iVar.c;
            while (i2 < i5) {
                byte b2 = bArr2[i2];
                for (byte b3 : bArrF) {
                    if (b2 == b3) {
                        i3 = iVar.b;
                        return (i2 - i3) + j4;
                    }
                }
                i2++;
            }
            j4 += iVar.c - iVar.b;
            iVar = iVar.f;
            j2 = j4;
        }
        return -1L;
    }

    public byte n() {
        long j2 = this.d;
        if (j2 == 0) {
            throw new IllegalStateException("size == 0");
        }
        i iVar = this.c;
        int i2 = iVar.b;
        int i3 = iVar.c;
        int i4 = i2 + 1;
        byte b = iVar.a[i2];
        this.d = j2 - 1;
        if (i4 == i3) {
            this.c = iVar.b();
            j.a(iVar);
        } else {
            iVar.b = i4;
        }
        return b;
    }

    public byte[] o() {
        try {
            return p(this.d);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public byte[] p(long j2) throws EOFException {
        n.b(this.d, 0L, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[(int) j2];
            s(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
    }

    public d q() {
        return new d(o());
    }

    @Override // m.c
    public a r() {
        return this;
    }

    public int read(byte[] bArr, int i2, int i3) {
        n.b(bArr.length, i2, i3);
        i iVar = this.c;
        if (iVar == null) {
            return -1;
        }
        int iMin = Math.min(i3, iVar.c - iVar.b);
        System.arraycopy(iVar.a, iVar.b, bArr, i2, iMin);
        int i4 = iVar.b + iMin;
        iVar.b = i4;
        this.d -= iMin;
        if (i4 == iVar.c) {
            this.c = iVar.b();
            j.a(iVar);
        }
        return iMin;
    }

    public void s(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = read(bArr, i2, bArr.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    public final long size() {
        return this.d;
    }

    @Override // m.b
    public /* bridge */ /* synthetic */ b t(String str) throws IOException {
        K(str);
        return this;
    }

    public String toString() {
        return D().toString();
    }

    public int u() {
        long j2 = this.d;
        if (j2 < 4) {
            throw new IllegalStateException("size < 4: " + this.d);
        }
        i iVar = this.c;
        int i2 = iVar.b;
        int i3 = iVar.c;
        if (i3 - i2 < 4) {
            return ((n() & 255) << 24) | ((n() & 255) << 16) | ((n() & 255) << 8) | (n() & 255);
        }
        byte[] bArr = iVar.a;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & 255);
        this.d = j2 - 4;
        if (i9 == i3) {
            this.c = iVar.b();
            j.a(iVar);
        } else {
            iVar.b = i9;
        }
        return i10;
    }

    public String w(long j2, Charset charset) throws EOFException {
        n.b(this.d, 0L, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j2 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j2);
        }
        if (j2 == 0) {
            return "";
        }
        i iVar = this.c;
        if (iVar.b + j2 > iVar.c) {
            return new String(p(j2), charset);
        }
        String str = new String(iVar.a, iVar.b, (int) j2, charset);
        int i2 = (int) (iVar.b + j2);
        iVar.b = i2;
        this.d -= j2;
        if (i2 == iVar.c) {
            this.c = iVar.b();
            j.a(iVar);
        }
        return str;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            i iVarG = G(1);
            int iMin = Math.min(i2, 8192 - iVarG.c);
            byteBuffer.get(iVarG.a, iVarG.c, iMin);
            i2 -= iMin;
            iVarG.c += iMin;
        }
        this.d += iRemaining;
        return iRemaining;
    }

    @Override // m.b
    public /* bridge */ /* synthetic */ b writeByte(int i2) throws IOException {
        I(i2);
        return this;
    }

    public String x() {
        try {
            return w(this.d, n.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String y(long j2) throws EOFException {
        return w(j2, n.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int z(g gVar, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        i iVar;
        i iVar2 = this.c;
        int i6 = -2;
        if (iVar2 != null) {
            byte[] bArr = iVar2.a;
            int i7 = iVar2.b;
            int i8 = iVar2.c;
            int[] iArr = gVar.d;
            i iVar3 = iVar2;
            int i9 = 0;
            int i10 = -1;
            loop0: while (true) {
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                int i13 = i11 + 1;
                int i14 = iArr[i11];
                if (i14 != -1) {
                    i10 = i14;
                }
                if (iVar3 == null) {
                    break;
                }
                if (i12 >= 0) {
                    int i15 = i7 + 1;
                    int i16 = bArr[i7] & 255;
                    int i17 = i13 + i12;
                    while (i13 != i17) {
                        if (i16 == iArr[i13]) {
                            i2 = iArr[i13 + i12];
                            if (i15 == i8) {
                                iVar3 = iVar3.f;
                                i3 = iVar3.b;
                                bArr = iVar3.a;
                                i8 = iVar3.c;
                                if (iVar3 == iVar2) {
                                    iVar3 = null;
                                }
                            } else {
                                i3 = i15;
                            }
                        } else {
                            i13++;
                        }
                    }
                    return i10;
                }
                int i18 = i13 + (i12 * (-1));
                while (true) {
                    int i19 = i7 + 1;
                    int i20 = i13 + 1;
                    if ((bArr[i7] & 255) != iArr[i13]) {
                        return i10;
                    }
                    boolean z2 = i20 == i18;
                    if (i19 == i8) {
                        i iVar4 = iVar3.f;
                        i5 = iVar4.b;
                        byte[] bArr2 = iVar4.a;
                        i4 = iVar4.c;
                        if (iVar4 != iVar2) {
                            iVar = iVar4;
                            bArr = bArr2;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr2;
                            iVar = null;
                        }
                    } else {
                        i iVar5 = iVar3;
                        i4 = i8;
                        i5 = i19;
                        iVar = iVar5;
                    }
                    if (z2) {
                        i2 = iArr[i20];
                        i3 = i5;
                        i8 = i4;
                        iVar3 = iVar;
                        break;
                    }
                    i7 = i5;
                    i8 = i4;
                    i13 = i20;
                    iVar3 = iVar;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i9 = -i2;
                i7 = i3;
                i6 = -2;
            }
        } else {
            if (z) {
                return -2;
            }
            return gVar.indexOf(d.g);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        i iVar = this.c;
        if (iVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), iVar.c - iVar.b);
        byteBuffer.put(iVar.a, iVar.b, iMin);
        int i2 = iVar.b + iMin;
        iVar.b = i2;
        this.d -= iMin;
        if (i2 == iVar.c) {
            this.c = iVar.b();
            j.a(iVar);
        }
        return iMin;
    }
}
