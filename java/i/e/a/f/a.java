package i.e.a.f;

import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import i.e.a.j.k;
import i.e.a.j.l;
import i.e.a.j.r;
import i.e.a.j.v;
import i.e.a.j.z;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class a extends c {
    protected int A0;
    protected byte[] z0;

    public a(z zVar) {
        super(zVar);
        this.m0 = 1;
        this.g = 257;
    }

    private int I1(boolean z) throws XMLStreamException {
        this.C = z;
        int iH = this.V.h(this.w0);
        if (iH < 0) {
            this.V.j();
            i0(this.V.k());
            throw null;
        }
        this.W = iH;
        this.f1583i++;
        if (!this.t0) {
            if (!this.A.p()) {
                s0(this.A, false);
                throw null;
            }
            int i2 = this.W;
            for (int i3 = 0; i3 < i2; i3++) {
                v vVarL = this.V.l(i3);
                if (!vVarL.p()) {
                    s0(vVarL, true);
                    throw null;
                }
            }
        }
        this.g = 1;
        return 1;
    }

    private final boolean J1() throws XMLStreamException {
        int iD1;
        int iF1;
        int i2 = this.f0;
        int i3 = this.g0;
        if (i2 >= i3) {
            return false;
        }
        int i4 = this.n0;
        this.n0 = 0;
        if (i4 < 0) {
            if (i4 != -1) {
                q1();
                throw null;
            }
            if (this.z0[i2] == 10) {
                this.f0 = i2 + 1;
            }
            J0();
            this.f1584j.b('\n');
            return true;
        }
        int i5 = i4 & 255;
        int i6 = this.i0.a[i5];
        if (i6 == 5) {
            this.f1584j.b((char) B1(i4));
        } else if (i6 == 6) {
            byte[] bArr = this.z0;
            int i7 = i2 + 1;
            this.f0 = i7;
            int i8 = bArr[i2] & 255;
            int i9 = i4 >> 8;
            if (i9 != 0) {
                iD1 = D1(i5, i9, i8);
            } else {
                if (i7 >= i3) {
                    this.n0 = (i8 << 8) | i4;
                    return false;
                }
                this.f0 = i7 + 1;
                iD1 = D1(i4, i8, bArr[i7] & 255);
            }
            this.f1584j.b((char) iD1);
        } else {
            if (i6 != 7) {
                q1();
                throw null;
            }
            byte[] bArr2 = this.z0;
            int i10 = i2 + 1;
            this.f0 = i10;
            int i11 = bArr2[i2] & 255;
            int i12 = i4 >> 8;
            if (i12 != 0) {
                int i13 = i12 & 255;
                int i14 = i4 >> 16;
                if (i14 != 0) {
                    iF1 = F1(i5, i13, i14, i11);
                } else {
                    if (i10 >= i3) {
                        this.n0 = (i11 << 16) | i4;
                        return false;
                    }
                    this.f0 = i10 + 1;
                    iF1 = F1(i5, i13, i11, bArr2[i10] & 255);
                }
            } else {
                if (i10 >= i3) {
                    this.n0 = (i11 << 8) | i4;
                    return false;
                }
                int i15 = i10 + 1;
                this.f0 = i15;
                int i16 = bArr2[i10] & 255;
                if (i15 >= i3) {
                    this.n0 = (i11 << 8) | i4 | (i16 << 16);
                    return false;
                }
                this.f0 = i15 + 1;
                iF1 = F1(i4, i11, i16, bArr2[i15] & 255);
            }
            this.f1584j.d(iF1);
        }
        return true;
    }

    private final boolean L1() throws XMLStreamException {
        int iR1;
        int iZ1;
        int i2 = this.n0;
        if (i2 == -1) {
            if (!f1()) {
                return false;
            }
            char[] cArrB = this.V.b();
            if (this.w0 >= cArrB.length) {
                cArrB = this.V.s();
            }
            int i3 = this.w0;
            this.w0 = i3 + 1;
            cArrB[i3] = Chars.SPACE;
            return true;
        }
        int i4 = this.f0;
        int i5 = this.g0;
        if (i4 >= i5) {
            return false;
        }
        if (i2 == -60) {
            byte[] bArr = this.z0;
            int i6 = i4 + 1;
            this.f0 = i6;
            byte b = bArr[i4];
            if (b == 35) {
                this.n0 = -61;
                if (i6 >= i5) {
                    return false;
                }
                if (bArr[i6] == 120) {
                    this.n0 = -62;
                    int i7 = i6 + 1;
                    this.f0 = i7;
                    if (i7 >= i5) {
                        return false;
                    }
                    iR1 = Y1(true);
                } else {
                    iR1 = R1(true);
                }
            } else {
                v vVarK2 = k2(b);
                if (vVarK2 == null) {
                    this.n0 = -63;
                    return false;
                }
                iZ1 = z1(vVarK2);
                if (iZ1 == 0) {
                    this.A = vVarK2;
                    t0(this.v0, false);
                    throw null;
                }
                iR1 = iZ1;
            }
        } else if (i2 == -61) {
            if (this.z0[i4] == 120) {
                this.n0 = -62;
                int i8 = i4 + 1;
                this.f0 = i8;
                if (i8 >= i5) {
                    return false;
                }
                iR1 = Y1(true);
            } else {
                iR1 = R1(true);
            }
        } else if (i2 == -62) {
            iR1 = Y1(true);
        } else if (i2 == -63) {
            v vVarJ2 = j2();
            if (vVarJ2 == null) {
                return false;
            }
            iZ1 = z1(vVarJ2);
            if (iZ1 == 0) {
                this.A = vVarJ2;
                t0(this.v0, false);
                throw null;
            }
            iR1 = iZ1;
        } else {
            iR1 = i2 == -64 ? R1(false) : i2 == -65 ? Y1(false) : M1();
        }
        if (iR1 == 0) {
            return false;
        }
        char[] cArrB2 = this.V.b();
        if ((iR1 >> 16) != 0) {
            int i9 = iR1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (this.w0 >= cArrB2.length) {
                cArrB2 = this.V.s();
            }
            int i10 = this.w0;
            this.w0 = i10 + 1;
            cArrB2[i10] = (char) (55296 | (i9 >> 10));
            iR1 = (i9 & 1023) | 56320;
        }
        if (this.w0 >= cArrB2.length) {
            cArrB2 = this.V.s();
        }
        int i11 = this.w0;
        this.w0 = i11 + 1;
        cArrB2[i11] = (char) iR1;
        return true;
    }

    private final int M1() throws XMLStreamException {
        int i2 = this.n0;
        this.n0 = 0;
        int i3 = i2 & 255;
        int i4 = this.i0.a[i3];
        if (i4 == 5) {
            return B1(i2);
        }
        if (i4 == 6) {
            byte[] bArr = this.z0;
            int i5 = this.f0;
            int i6 = i5 + 1;
            this.f0 = i6;
            int i7 = bArr[i5] & 255;
            int i8 = i2 >> 8;
            if (i8 != 0) {
                return D1(i3, i8, i7);
            }
            if (i6 >= this.g0) {
                this.n0 = i2 | (i7 << 8);
                return 0;
            }
            this.f0 = i6 + 1;
            return D1(i2, i7, bArr[i6] & 255);
        }
        if (i4 != 7) {
            q1();
            throw null;
        }
        byte[] bArr2 = this.z0;
        int i9 = this.f0;
        int i10 = i9 + 1;
        this.f0 = i10;
        int i11 = bArr2[i9] & 255;
        int i12 = i2 >> 8;
        if (i12 != 0) {
            int i13 = i12 & 255;
            int i14 = i2 >> 16;
            if (i14 != 0) {
                return F1(i3, i13, i14, i11);
            }
            if (i10 >= this.g0) {
                this.n0 = i2 | (i11 << 16);
                return 0;
            }
            this.f0 = i10 + 1;
            return F1(i3, i13, i11, bArr2[i10] & 255);
        }
        int i15 = this.g0;
        if (i10 >= i15) {
            this.n0 = i2 | (i11 << 8);
            return 0;
        }
        int i16 = i10 + 1;
        this.f0 = i16;
        int i17 = bArr2[i10] & 255;
        if (i16 >= i15) {
            this.n0 = i2 | (i11 << 8) | (i17 << 16);
            return 0;
        }
        this.f0 = i16 + 1;
        return F1(i2, i11, i17, bArr2[i16] & 255);
    }

    private int N1() throws XMLStreamException {
        if (this.m0 == 1) {
            return h2();
        }
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return 257;
        }
        byte[] bArr = this.z0;
        this.f0 = i2 + 1;
        return P1(bArr[i2]);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int P1(byte b) throws XMLStreamException {
        int i2 = this.m0;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                q1();
                                throw null;
                            }
                        }
                        if (b == 91) {
                            I0(b);
                            r0(b, " (expected '[' for CDATA)");
                            throw null;
                        }
                        this.f1584j.x();
                        this.m0 = 1;
                        if (this.f0 >= this.g0) {
                            return 257;
                        }
                        return h2();
                    }
                    if (b == 65) {
                        I0(b);
                        r0(b, " (expected 'A' for CDATA)");
                        throw null;
                    }
                    this.m0 = 6;
                    int i3 = this.f0;
                    if (i3 >= this.g0) {
                        return 257;
                    }
                    byte[] bArr = this.z0;
                    this.f0 = i3 + 1;
                    b = bArr[i3];
                    if (b == 91) {
                    }
                }
                if (b == 84) {
                    I0(b);
                    r0(b, " (expected 'T' for CDATA)");
                    throw null;
                }
                this.m0 = 5;
                int i4 = this.f0;
                if (i4 >= this.g0) {
                    return 257;
                }
                byte[] bArr2 = this.z0;
                this.f0 = i4 + 1;
                b = bArr2[i4];
                if (b == 65) {
                }
            }
            if (b == 65) {
                I0(b);
                r0(b, " (expected 'A' for CDATA)");
                throw null;
            }
            this.m0 = 4;
            int i5 = this.f0;
            if (i5 >= this.g0) {
                return 257;
            }
            byte[] bArr3 = this.z0;
            this.f0 = i5 + 1;
            b = bArr3[i5];
            if (b == 84) {
            }
        } else {
            if (b != 67) {
                I0(b);
                r0(b, " (expected 'C' for CDATA)");
                throw null;
            }
            this.m0 = 2;
            int i6 = this.f0;
            if (i6 >= this.g0) {
                return 257;
            }
            byte[] bArr4 = this.z0;
            this.f0 = i6 + 1;
            b = bArr4[i6];
        }
        if (b != 68) {
            I0(b);
            r0(b, " (expected 'D' for CDATA)");
            throw null;
        }
        this.m0 = 3;
        int i7 = this.f0;
        if (i7 >= this.g0) {
            return 257;
        }
        byte[] bArr5 = this.z0;
        this.f0 = i7 + 1;
        b = bArr5[i7];
        if (b == 65) {
        }
    }

    private final int R1(boolean z) throws XMLStreamException {
        byte[] bArr = this.z0;
        int i2 = this.f0;
        int i3 = i2 + 1;
        this.f0 = i3;
        byte b = bArr[i2];
        if (z) {
            if (b < 48 || b > 57) {
                I0(b);
                F0(b, " expected a digit (0 - 9) for character entity");
                throw null;
            }
            this.n0 = -64;
            this.s0 = b - 48;
            if (i3 >= this.g0) {
                return 0;
            }
            this.f0 = i3 + 1;
            b = bArr[i3];
        }
        while (b != 59) {
            int i4 = b - 48;
            if (i4 < 0 || i4 > 9) {
                I0(b);
                F0(b, " expected a digit (0 - 9) for character entity");
                throw null;
            }
            int i5 = (this.s0 * 10) + i4;
            this.s0 = i5;
            if (i5 > 1114111) {
                d0();
                throw null;
            }
            int i6 = this.f0;
            if (i6 >= this.g0) {
                return 0;
            }
            byte[] bArr2 = this.z0;
            this.f0 = i6 + 1;
            b = bArr2[i6];
        }
        G0(this.s0);
        this.n0 = 0;
        return this.s0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r10.q0 != r0.m(r10.p0)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r10.r0 = 0;
        r10.q0 = 0;
        r10.p0++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        u0(r0.l());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int T1() throws XMLStreamException {
        int i2;
        int i3 = this.m0;
        if (i3 == 0) {
            v vVar = this.A;
            int iQ = vVar.q() - 1;
            while (this.p0 < iQ) {
                while (true) {
                    int i4 = this.r0;
                    if (i4 >= 4) {
                        break;
                    }
                    int i5 = this.f0;
                    if (i5 >= this.g0) {
                        return 257;
                    }
                    int i6 = this.q0 << 8;
                    byte[] bArr = this.z0;
                    this.f0 = i5 + 1;
                    this.q0 = (bArr[i5] & 255) | i6;
                    this.r0 = i4 + 1;
                }
            }
            int iH = vVar.h();
            do {
                int i7 = this.f0;
                if (i7 >= this.g0) {
                    return 257;
                }
                int i8 = this.q0 << 8;
                byte[] bArr2 = this.z0;
                this.f0 = i7 + 1;
                int i9 = (bArr2[i7] & 255) | i8;
                this.q0 = i9;
                if (i9 == iH) {
                    this.m0 = 1;
                } else {
                    i2 = this.r0 + 1;
                    this.r0 = i2;
                }
            } while (i2 <= 3);
            u0(vVar.l());
            throw null;
        }
        if (i3 != 1) {
            q1();
            throw null;
        }
        if (this.n0 != 0 && !f1()) {
            return 257;
        }
        while (true) {
            int i10 = this.f0;
            int i11 = this.g0;
            if (i10 >= i11) {
                return 257;
            }
            byte[] bArr3 = this.z0;
            int i12 = i10 + 1;
            this.f0 = i12;
            int i13 = bArr3[i10] & 255;
            if (i13 > 32) {
                if (i13 == 62) {
                    this.g = 2;
                    return 2;
                }
                byte b = (byte) i13;
                I0(b);
                F0(b, " expected space or closing '>'");
                throw null;
            }
            if (i13 == 10) {
                J0();
            } else if (i13 == 13) {
                if (i12 >= i11) {
                    this.n0 = -1;
                    return 257;
                }
                if (bArr3[i12] == 10) {
                    this.f0 = i12 + 1;
                }
                J0();
            } else if (i13 != 32 && i13 != 9) {
                D0(i13);
                throw null;
            }
        }
    }

    private int U1() throws XMLStreamException {
        this.f1583i--;
        v vVarA = this.D.a();
        this.A = vVarA;
        int iQ = vVarA.q();
        if (this.g0 - this.f0 < (iQ << 2) + 1) {
            this.l0 = 2;
            this.m0 = 0;
            this.r0 = 0;
            this.q0 = 0;
            this.p0 = 0;
            return T1();
        }
        byte[] bArr = this.z0;
        int i2 = iQ - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f0;
            int i5 = (bArr[i4] << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8) | (bArr[i4 + 3] & 255);
            this.f0 = i4 + 4;
            if (i5 != this.A.m(i3)) {
                u0(this.A.l());
                throw null;
            }
        }
        int iM = this.A.m(i2);
        int i6 = this.f0;
        int i7 = i6 + 1;
        this.f0 = i7;
        int i8 = bArr[i6] & 255;
        if (i8 != iM) {
            int i9 = i7 + 1;
            this.f0 = i9;
            int i10 = (i8 << 8) | (bArr[i7] & 255);
            if (i10 != iM) {
                int i11 = i9 + 1;
                this.f0 = i11;
                int i12 = (i10 << 8) | (bArr[i9] & 255);
                if (i12 != iM) {
                    this.f0 = i11 + 1;
                    if (((bArr[i11] & 255) | (i12 << 8)) != iM) {
                        u0(this.A.l());
                        throw null;
                    }
                }
            }
        }
        byte[] bArr2 = this.z0;
        int i13 = this.f0;
        this.f0 = i13 + 1;
        byte b = bArr2[i13];
        while (true) {
            int i14 = b & 255;
            if (i14 > 32) {
                if (i14 == 62) {
                    this.g = 2;
                    return 2;
                }
                byte b2 = (byte) i14;
                I0(b2);
                F0(b2, " expected space or closing '>'");
                throw null;
            }
            if (i14 == 10) {
                J0();
            } else if (i14 == 13) {
                int i15 = this.f0;
                if (i15 >= this.g0) {
                    this.n0 = -1;
                    this.l0 = 2;
                    this.m0 = 1;
                    return 257;
                }
                if (this.z0[i15] == 10) {
                    this.f0 = i15 + 1;
                }
                J0();
            } else if (i14 != 32 && i14 != 9) {
                D0(i14);
                throw null;
            }
            int i16 = this.f0;
            if (i16 >= this.g0) {
                this.l0 = 2;
                this.m0 = 1;
                return 257;
            }
            byte[] bArr3 = this.z0;
            this.f0 = i16 + 1;
            b = bArr3[i16];
        }
    }

    private final int Y1(boolean z) throws XMLStreamException {
        int i2;
        int i3;
        byte[] bArr = this.z0;
        int i4 = this.f0;
        this.f0 = i4 + 1;
        byte b = bArr[i4];
        while (b != 59) {
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i2 = b - 65;
                } else {
                    if (b > 102 || b < 97) {
                        I0(b);
                        F0(b, " expected a hex digit (0-9a-fA-F) for character entity");
                        throw null;
                    }
                    i2 = b - 97;
                }
                i3 = i2 + 10;
            } else {
                i3 = b - 48;
            }
            if (z) {
                this.n0 = -65;
                z = false;
            } else {
                i3 += this.s0 << 4;
                if (i3 > 1114111) {
                    d0();
                    throw null;
                }
            }
            this.s0 = i3;
            int i5 = this.f0;
            if (i5 >= this.g0) {
                return 0;
            }
            byte[] bArr2 = this.z0;
            this.f0 = i5 + 1;
            b = bArr2[i5];
        }
        G0(this.s0);
        this.n0 = 0;
        return this.s0;
    }

    private final boolean c2() throws XMLStreamException {
        int iR1;
        int iZ1;
        int i2 = this.n0;
        if (i2 == -1) {
            if (!f1()) {
                return false;
            }
            char[] cArrB = this.t;
            if (this.x0 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
            }
            int i3 = this.x0;
            this.x0 = i3 + 1;
            cArrB[i3] = Chars.SPACE;
            return true;
        }
        int i4 = this.f0;
        int i5 = this.g0;
        if (i4 >= i5) {
            return false;
        }
        if (i2 == -60) {
            byte[] bArr = this.z0;
            int i6 = i4 + 1;
            this.f0 = i6;
            byte b = bArr[i4];
            if (b == 35) {
                this.n0 = -61;
                if (i6 >= i5) {
                    return false;
                }
                if (bArr[i6] == 120) {
                    this.n0 = -62;
                    int i7 = i6 + 1;
                    this.f0 = i7;
                    if (i7 >= i5) {
                        return false;
                    }
                    iR1 = Y1(true);
                } else {
                    iR1 = R1(true);
                }
            } else {
                v vVarK2 = k2(b);
                if (vVarK2 == null) {
                    this.n0 = -63;
                    return false;
                }
                iZ1 = z1(vVarK2);
                if (iZ1 == 0) {
                    this.A = vVarK2;
                    t0(this.v0, false);
                    throw null;
                }
                iR1 = iZ1;
            }
        } else if (i2 == -61) {
            if (this.z0[i4] == 120) {
                this.n0 = -62;
                int i8 = i4 + 1;
                this.f0 = i8;
                if (i8 >= i5) {
                    return false;
                }
                iR1 = Y1(true);
            } else {
                iR1 = R1(true);
            }
        } else if (i2 == -62) {
            iR1 = Y1(true);
        } else if (i2 == -63) {
            v vVarJ2 = j2();
            if (vVarJ2 == null) {
                return false;
            }
            iZ1 = z1(vVarJ2);
            if (iZ1 == 0) {
                this.A = vVarJ2;
                t0(this.v0, false);
                throw null;
            }
            iR1 = iZ1;
        } else {
            iR1 = i2 == -64 ? R1(false) : i2 == -65 ? Y1(false) : M1();
        }
        if (iR1 == 0) {
            return false;
        }
        char[] cArrB2 = this.t;
        if ((iR1 >> 16) != 0) {
            int i9 = iR1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (this.x0 >= cArrB2.length) {
                cArrB2 = i.e.a.l.c.b(cArrB2, cArrB2.length);
                this.t = cArrB2;
            }
            int i10 = this.x0;
            this.x0 = i10 + 1;
            cArrB2[i10] = (char) (55296 | (i9 >> 10));
            iR1 = (i9 & 1023) | 56320;
        }
        if (this.x0 >= cArrB2.length) {
            cArrB2 = i.e.a.l.c.b(cArrB2, cArrB2.length);
            this.t = cArrB2;
        }
        int i11 = this.x0;
        this.x0 = i11 + 1;
        cArrB2[i11] = (char) iR1;
        return true;
    }

    private void f2(byte b) {
        boolean z;
        this.u0 = b;
        v vVarD = this.v0;
        String strK = vVarD.k();
        if (strK == null) {
            z = vVarD.i() == "xmlns";
        } else {
            if (strK != "xmlns") {
                vVarD = d(vVarD, strK);
                if (this.t0) {
                    this.t0 = vVarD.p();
                }
            }
        }
        if (!z) {
            this.m0 = 7;
            this.V.r(vVarD, this.w0);
        } else {
            this.m0 = 8;
            this.x0 = 0;
            this.J++;
        }
    }

    private void g2(v vVar) {
        String strK = vVar.k();
        if (strK == null) {
            this.t0 = true;
        } else {
            vVar = d(vVar, strK);
            this.t0 = vVar.p();
        }
        this.A = vVar;
        this.D = new k(vVar, this.D);
        this.W = 0;
        this.J = 0;
        this.w0 = 0;
        this.m0 = 2;
    }

    private int m2() throws XMLStreamException {
        int i2;
        int i3;
        int i4 = this.f0;
        int i5 = i4 + 3;
        int i6 = this.g0;
        if (i5 > i6) {
            return 0;
        }
        byte[] bArr = this.z0;
        int i7 = i4 + 1;
        byte b = bArr[i4];
        if (b == 35) {
            return bArr[i7] == 120 ? Z1(i7 + 1) : S1(i7);
        }
        if (b == 97) {
            int i8 = i7 + 1;
            byte b2 = bArr[i7];
            if (b2 == 109) {
                int i9 = i8 + 1;
                if (i9 >= i6 || bArr[i8] != 112 || bArr[i9] != 59) {
                    return 0;
                }
                this.f0 = i8 + 2;
                return 38;
            }
            if (b2 != 112 || (i3 = i8 + 2) >= i6 || bArr[i8] != 111 || bArr[i8 + 1] != 115 || bArr[i3] != 59) {
                return 0;
            }
            this.f0 = i8 + 3;
            return 39;
        }
        if (b == 103) {
            if (bArr[i7] != 116 || bArr[i7 + 1] != 59) {
                return 0;
            }
            this.f0 = i7 + 2;
            return 62;
        }
        if (b == 108) {
            if (bArr[i7] != 116 || bArr[i7 + 1] != 59) {
                return 0;
            }
            this.f0 = i7 + 2;
            return 60;
        }
        if (b != 113 || (i2 = i7 + 3) >= i6 || bArr[i7] != 117 || bArr[i7 + 1] != 111 || bArr[i7 + 2] != 116 || bArr[i2] != 59) {
            return 0;
        }
        this.f0 = i7 + 4;
        return 34;
    }

    private final boolean n2() throws XMLStreamException {
        int i2 = this.f0;
        int i3 = this.g0;
        if (i2 >= i3) {
            return false;
        }
        int i4 = this.n0;
        if (i4 >= 0) {
            int i5 = i4 & 255;
            int i6 = this.i0.a[i5];
            if (i6 == 5) {
                o2(i4);
            } else if (i6 == 6) {
                byte[] bArr = this.z0;
                int i7 = i2 + 1;
                this.f0 = i7;
                int i8 = bArr[i2] & 255;
                int i9 = i4 >> 8;
                if (i9 != 0) {
                    D1(i5, i9, i8);
                } else {
                    if (i7 >= i3) {
                        this.n0 = (i8 << 8) | i4;
                        return false;
                    }
                    this.f0 = i7 + 1;
                    D1(i4, i8, bArr[i7] & 255);
                }
            } else {
                if (i6 != 7) {
                    q1();
                    throw null;
                }
                byte[] bArr2 = this.z0;
                int i10 = i2 + 1;
                this.f0 = i10;
                int i11 = bArr2[i2] & 255;
                int i12 = i4 >> 8;
                if (i12 != 0) {
                    int i13 = i12 & 255;
                    int i14 = i4 >> 16;
                    if (i14 != 0) {
                        F1(i5, i13, i14, i11);
                    } else {
                        if (i10 >= i3) {
                            this.n0 = (i11 << 16) | i4;
                            return false;
                        }
                        this.f0 = i10 + 1;
                        F1(i5, i13, i11, bArr2[i10] & 255);
                    }
                } else {
                    if (i10 >= i3) {
                        this.n0 = (i11 << 8) | i4;
                        return false;
                    }
                    int i15 = i10 + 1;
                    this.f0 = i15;
                    int i16 = bArr2[i10] & 255;
                    if (i15 >= i3) {
                        this.n0 = (i11 << 8) | i4 | (i16 << 16);
                        return false;
                    }
                    this.f0 = i15 + 1;
                    F1(i4, i11, i16, bArr2[i15] & 255);
                }
            }
            this.n0 = 0;
            return true;
        }
        do {
            int i17 = this.n0;
            if (i17 == -1) {
                this.n0 = 0;
                byte[] bArr3 = this.z0;
                int i18 = this.f0;
                if (bArr3[i18] == 10) {
                    this.f0 = i18 + 1;
                }
                J0();
                return true;
            }
            switch (i17) {
                case -86:
                    byte[] bArr4 = this.z0;
                    int i19 = this.f0;
                    byte b = bArr4[i19];
                    if (b != 93) {
                        if (b != 62) {
                            this.n0 = 0;
                            return true;
                        }
                        this.f0 = i19 + 1;
                        i0("Encountered ']]>' in text segment");
                        throw null;
                    }
                    this.f0 = i19 + 1;
                    break;
                case -85:
                    byte[] bArr5 = this.z0;
                    int i20 = this.f0;
                    if (bArr5[i20] == 93) {
                        this.f0 = i20 + 1;
                        this.n0 = -86;
                        break;
                    } else {
                        this.n0 = 0;
                        return true;
                    }
                case -84:
                    v vVarJ2 = j2();
                    if (vVarJ2 == null) {
                        return false;
                    }
                    if (z1(vVarJ2) == 0) {
                        this.A = vVarJ2;
                        this.l0 = 9;
                    }
                    this.n0 = 0;
                    return true;
                case -83:
                    if (!A1()) {
                        return false;
                    }
                    this.n0 = 0;
                    return true;
                case -82:
                    if (!y1()) {
                        return false;
                    }
                    this.n0 = 0;
                    return true;
                case -81:
                    this.s0 = 0;
                    byte[] bArr6 = this.z0;
                    int i21 = this.f0;
                    if (bArr6[i21] != 120) {
                        if (y1()) {
                            this.n0 = 0;
                            return true;
                        }
                        this.n0 = -82;
                        return false;
                    }
                    this.f0 = i21 + 1;
                    if (A1()) {
                        this.n0 = 0;
                        return true;
                    }
                    this.n0 = -83;
                    return false;
                case -80:
                    byte[] bArr7 = this.z0;
                    int i22 = this.f0;
                    this.f0 = i22 + 1;
                    byte b2 = bArr7[i22];
                    if (b2 != 35) {
                        v vVarK2 = k2(b2);
                        if (vVarK2 == null) {
                            this.n0 = -84;
                            return false;
                        }
                        if (z1(vVarK2) == 0) {
                            this.A = vVarK2;
                            this.l0 = 9;
                        }
                        this.n0 = 0;
                        return true;
                    }
                    this.n0 = -81;
                    break;
                default:
                    q1();
                    throw null;
            }
        } while (this.f0 < this.g0);
        return false;
    }

    protected final boolean A1() throws XMLStreamException {
        int i2;
        int i3;
        int i4 = this.s0;
        do {
            int i5 = this.f0;
            if (i5 >= this.g0) {
                this.s0 = i4;
                return false;
            }
            byte[] bArr = this.z0;
            this.f0 = i5 + 1;
            byte b = bArr[i5];
            if (b == 59) {
                this.s0 = i4;
                return true;
            }
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i2 = b - 65;
                } else {
                    if (b > 102 || b < 97) {
                        I0(b);
                        F0(b, " expected a hex digit (0-9a-fA-F) for character entity");
                        throw null;
                    }
                    i2 = b - 97;
                }
                i3 = i2 + 10;
            } else {
                i3 = b - 48;
            }
            i4 = (i4 << 4) + i3;
        } while (i4 <= 1114111);
        this.s0 = i4;
        d0();
        throw null;
    }

    protected final int B1(int i2) throws XMLStreamException {
        byte[] bArr = this.z0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) == 128) {
            return ((i2 & 31) << 6) | (b & 63);
        }
        o1(b & 255, i4);
        throw null;
    }

    protected final int C1(int i2) throws XMLStreamException {
        int i3 = i2 & 15;
        byte[] bArr = this.z0;
        int i4 = this.f0;
        int i5 = i4 + 1;
        this.f0 = i5;
        byte b = bArr[i4];
        if ((b & 192) != 128) {
            o1(b & 255, i5);
            throw null;
        }
        int i6 = (b & 63) | (i3 << 6);
        int i7 = i5 + 1;
        this.f0 = i7;
        byte b2 = bArr[i5];
        if ((b2 & 192) == 128) {
            int i8 = (b2 & 63) | (i6 << 6);
            return (i3 < 13 || i8 < 55296) ? i8 : (i8 < 57344 || (i8 >= 65534 && i8 <= 65535)) ? R(i8) : i8;
        }
        o1(b2 & 255, i7);
        throw null;
    }

    protected final int D1(int i2, int i3, int i4) throws XMLStreamException {
        if ((i3 & 192) != 128) {
            o1(i3 & 255, this.f0 - 1);
            throw null;
        }
        if ((i4 & 192) == 128) {
            int i5 = ((i3 & 63) << 6) | ((i2 & 15) << 12) | (i4 & 63);
            return (i2 < 13 || i5 < 55296) ? i5 : (i5 < 57344 || (i5 >= 65534 && i5 <= 65535)) ? R(i5) : i5;
        }
        o1(i4 & 255, this.f0);
        throw null;
    }

    protected final int E1(int i2) throws XMLStreamException {
        byte[] bArr = this.z0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            o1(b & 255, i4);
            throw null;
        }
        int i5 = ((i2 & 7) << 6) | (b & 63);
        int i6 = i4 + 1;
        this.f0 = i6;
        byte b2 = bArr[i4];
        if ((b2 & 192) != 128) {
            o1(b2 & 255, i6);
            throw null;
        }
        int i7 = (i5 << 6) | (b2 & 63);
        int i8 = i6 + 1;
        this.f0 = i8;
        byte b3 = bArr[i6];
        if ((b3 & 192) == 128) {
            return ((i7 << 6) | (b3 & 63)) - WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        o1(b3 & 255, i8);
        throw null;
    }

    protected final int F1(int i2, int i3, int i4, int i5) throws XMLStreamException {
        if ((i3 & 192) != 128) {
            o1(i3 & 255, this.f0 - 2);
            throw null;
        }
        int i6 = ((i2 & 7) << 6) | (i3 & 63);
        if ((i4 & 192) != 128) {
            o1(i4 & 255, this.f0 - 1);
            throw null;
        }
        int i7 = (i6 << 6) | (i4 & 63);
        if ((i5 & 192) == 128) {
            return ((i7 << 6) | (i5 & 63)) - WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        o1(i5 & 255, this.f0);
        throw null;
    }

    public void G1(byte[] bArr, int i2, int i3) throws XMLStreamException {
        if (this.f0 < this.g0) {
            throw new XMLStreamException("Still have " + (this.g0 - this.f0) + " unread bytes");
        }
        if (this.o0) {
            throw new XMLStreamException("Already closed, can not feed more input");
        }
        long j2 = this.Z;
        int i4 = this.A0;
        this.Z = j2 + i4;
        this.b0 -= i4;
        this.z0 = bArr;
        this.f0 = i2;
        this.g0 = i2 + i3;
        this.A0 = i3;
    }

    protected final int H1() throws XMLStreamException {
        if (this.n0 == 0 || J1()) {
            throw new UnsupportedOperationException();
        }
        return 257;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean K1() throws XMLStreamException {
        int i2;
        if (this.n0 != 0) {
            if (!L1()) {
                return false;
            }
            this.n0 = 0;
        }
        char[] cArrB = this.V.b();
        int[] iArr = this.i0.b;
        byte b = this.u0;
        while (this.f0 < this.g0) {
            if (this.w0 >= cArrB.length) {
                cArrB = this.V.s();
            }
            int i3 = this.g0;
            int length = this.f0 + (cArrB.length - this.w0);
            if (length < i3) {
                i3 = length;
            }
            while (true) {
                int i4 = this.f0;
                if (i4 < i3) {
                    byte[] bArr = this.z0;
                    int i5 = i4 + 1;
                    this.f0 = i5;
                    int iB1 = bArr[i4] & 255;
                    if (iArr[iB1] != 0) {
                        int i6 = iArr[iB1];
                        if (i6 != 14) {
                            switch (i6) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (this.z0[i2] == 10) {
                                            this.f0 = i2 + 1;
                                        }
                                        J0();
                                        iB1 = 32;
                                        break;
                                    } else {
                                        this.n0 = -1;
                                        return false;
                                    }
                                case 2:
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                    }
                                    break;
                                case 3:
                                    J0();
                                    iB1 = 32;
                                    break;
                                case 4:
                                    L0(iB1);
                                    throw null;
                                case 5:
                                    if (i5 < this.g0) {
                                        iB1 = B1(iB1);
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 6:
                                    int i7 = this.g0;
                                    if (i7 - i5 >= 2) {
                                        iB1 = C1(iB1);
                                        break;
                                    } else {
                                        if (i7 > i5) {
                                            this.f0 = i5 + 1;
                                            iB1 |= (bArr[i5] & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 7:
                                    int i8 = this.g0;
                                    if (i8 - i5 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i9 = this.w0;
                                        int i10 = i9 + 1;
                                        this.w0 = i10;
                                        cArrB[i9] = (char) ((iE1 >> 10) | 55296);
                                        iB1 = (iE1 & 1023) | 56320;
                                        if (i10 >= cArrB.length) {
                                            cArrB = this.V.s();
                                            break;
                                        }
                                    } else {
                                        if (i8 > i5) {
                                            int i11 = i5 + 1;
                                            this.f0 = i11;
                                            iB1 |= (bArr[i5] & 255) << 8;
                                            if (i8 > i11) {
                                                this.f0 = i11 + 1;
                                                iB1 |= (bArr[i11] & 255) << 16;
                                            }
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                    break;
                                case 8:
                                    iB1 = 32;
                                    break;
                                case 9:
                                    F0(iB1, "'<' not allowed in attribute value");
                                    throw null;
                                case 10:
                                    iB1 = V1();
                                    if (iB1 > 0) {
                                        if ((iB1 >> 16) != 0) {
                                            int i12 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                            int i13 = this.w0;
                                            int i14 = i13 + 1;
                                            this.w0 = i14;
                                            cArrB[i13] = (char) ((i12 >> 10) | 55296);
                                            iB1 = (i12 & 1023) | 56320;
                                            if (i14 >= cArrB.length) {
                                                cArrB = this.V.s();
                                                break;
                                            }
                                        }
                                    } else {
                                        if (iB1 < 0) {
                                            return false;
                                        }
                                        t0(this.v0, false);
                                        throw null;
                                    }
                                    break;
                            }
                        } else if (iB1 == b) {
                            return true;
                        }
                        int i15 = this.w0;
                        this.w0 = i15 + 1;
                        cArrB[i15] = (char) iB1;
                    } else {
                        int i16 = this.w0;
                        this.w0 = i16 + 1;
                        cArrB[i16] = (char) iB1;
                    }
                }
            }
        }
        return false;
    }

    protected final int O1() throws XMLStreamException {
        if (this.n0 == -30) {
            int i2 = this.f0;
            int i3 = this.g0;
            if (i2 >= i3) {
                return 257;
            }
            if (this.z0[i2] != 93) {
                this.f1584j.b(']');
                this.n0 = 0;
                return 0;
            }
            int i4 = i2 + 1;
            this.f0 = i4;
            this.n0 = -31;
            if (i4 >= i3) {
                return 257;
            }
        }
        while (this.n0 == -31) {
            int i5 = this.f0;
            if (i5 >= this.g0) {
                return 257;
            }
            byte[] bArr = this.z0;
            int i6 = i5 + 1;
            this.f0 = i6;
            byte b = bArr[i5];
            if (b == 62) {
                this.n0 = 0;
                this.m0 = 0;
                this.l0 = 257;
                return 12;
            }
            if (b != 93) {
                this.f0 = i6 - 1;
                this.f1584j.c("]]");
                this.n0 = 0;
                return 0;
            }
            this.f1584j.b(']');
        }
        return J1() ? 0 : 257;
    }

    @Override // i.e.a.f.c
    protected final byte P0() throws XMLStreamException {
        return this.z0[this.f0];
    }

    protected int Q1() throws XMLStreamException {
        int i2 = this.f0;
        int i3 = this.g0;
        if (i2 >= i3) {
            return 257;
        }
        if (this.n0 == -20) {
            if (this.z0[i2] != 45) {
                this.n0 = 0;
                this.f1584j.c(ProcessIdUtil.DEFAULT_PROCESSID);
                return 0;
            }
            int i4 = i2 + 1;
            this.f0 = i4;
            this.n0 = -21;
            if (i4 >= i3) {
                return 257;
            }
        }
        if (this.n0 != -21) {
            return J1() ? 0 : 257;
        }
        this.n0 = 0;
        byte[] bArr = this.z0;
        int i5 = this.f0;
        this.f0 = i5 + 1;
        if (bArr[i5] != 62) {
            b0();
            throw null;
        }
        this.m0 = 0;
        this.l0 = 257;
        return 5;
    }

    @Override // i.e.a.f.c
    protected final byte R0() throws XMLStreamException {
        byte[] bArr = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        return bArr[i2];
    }

    protected int S1(int i2) throws XMLStreamException {
        int i3 = i2 + 1;
        byte b = this.z0[i2];
        int i4 = this.g0;
        int i5 = 0;
        while (b <= 57 && b >= 48) {
            i5 = (i5 * 10) + (b - 48);
            if (i5 > 1114111) {
                d0();
                throw null;
            }
            if (i3 >= i4) {
                return 0;
            }
            int i6 = i3 + 1;
            b = this.z0[i3];
            if (b == 59) {
                this.f0 = i6;
                G0(i5);
                return i5;
            }
            i3 = i6;
        }
        I0(b);
        F0(b, " expected a digit (0 - 9) for character entity");
        throw null;
    }

    @Override // i.e.a.f.c
    protected final byte U0() throws XMLStreamException {
        return this.z0[this.f0 - 1];
    }

    protected int V1() throws XMLStreamException {
        int iR1;
        int i2 = this.f0;
        int i3 = this.g0;
        if (i2 >= i3) {
            this.n0 = -60;
            return -1;
        }
        byte[] bArr = this.z0;
        int i4 = i2 + 1;
        this.f0 = i4;
        byte b = bArr[i2];
        if (b != 35) {
            v vVarK2 = k2(b);
            if (vVarK2 == null) {
                this.n0 = -63;
                return -1;
            }
            int iZ1 = z1(vVarK2);
            if (iZ1 != 0) {
                return iZ1;
            }
            this.A = vVarK2;
            return 0;
        }
        this.n0 = -61;
        if (i4 >= i3) {
            return -1;
        }
        if (bArr[i4] == 120) {
            this.n0 = -62;
            int i5 = i4 + 1;
            this.f0 = i5;
            if (i5 >= i3) {
                return -1;
            }
            iR1 = Y1(true);
        } else {
            iR1 = R1(true);
        }
        if (iR1 == 0) {
            return -1;
        }
        return iR1;
    }

    protected int W1() throws XMLStreamException {
        int i2;
        int i3;
        int i4 = this.f0;
        int i5 = i4 + 3;
        int i6 = this.g0;
        if (i5 > i6) {
            return 0;
        }
        byte[] bArr = this.z0;
        int i7 = i4 + 1;
        byte b = bArr[i4];
        if (b == 35) {
            return bArr[i7] == 120 ? Z1(i7 + 1) : S1(i7);
        }
        if (b == 97) {
            int i8 = i7 + 1;
            byte b2 = bArr[i7];
            if (b2 == 109) {
                int i9 = i8 + 1;
                if (i9 >= i6 || bArr[i8] != 112 || bArr[i9] != 59) {
                    return 0;
                }
                this.f0 = i8 + 2;
                return 38;
            }
            if (b2 != 112 || (i3 = i8 + 2) >= i6 || bArr[i8] != 111 || bArr[i8 + 1] != 115 || bArr[i3] != 59) {
                return 0;
            }
            this.f0 = i8 + 3;
            return 39;
        }
        if (b == 103) {
            if (bArr[i7] != 116 || bArr[i7 + 1] != 59) {
                return 0;
            }
            this.f0 = i7 + 2;
            return 62;
        }
        if (b == 108) {
            if (bArr[i7] != 116 || bArr[i7 + 1] != 59) {
                return 0;
            }
            this.f0 = i7 + 2;
            return 60;
        }
        if (b != 113 || (i2 = i7 + 3) >= i6 || bArr[i7] != 117 || bArr[i7 + 1] != 111 || bArr[i7 + 2] != 116 || bArr[i2] != 59) {
            return 0;
        }
        this.f0 = i7 + 4;
        return 34;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        return false;
     */
    @Override // i.e.a.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean X0() throws XMLStreamException {
        while (true) {
            int i2 = this.f0;
            int i3 = this.g0;
            if (i2 >= i3) {
                break;
            }
            byte[] bArr = this.z0;
            byte b = bArr[i2];
            if ((b & 255) > 32) {
                if (this.n0 != -1) {
                    return true;
                }
                J0();
                this.n0 = 0;
                return true;
            }
            int i4 = i2 + 1;
            this.f0 = i4;
            if (b == 10) {
                J0();
            } else if (b == 13) {
                if (i4 >= i3) {
                    this.n0 = -1;
                    break;
                }
                if (bArr[i4] == 10) {
                    this.f0 = i4 + 1;
                }
                J0();
            } else if (b != 32 && b != 9) {
                D0(b);
                throw null;
            }
        }
    }

    protected int X1() throws XMLStreamException {
        this.f1584j.x();
        byte[] bArr = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = bArr[i2];
        if (b == 35) {
            this.f1584j.x();
            this.m0 = 5;
            this.n0 = -70;
            if (this.f0 >= this.g0) {
                return 257;
            }
            return d2();
        }
        v vVarK2 = k2(b);
        if (vVarK2 == null) {
            this.m0 = 6;
            return 257;
        }
        int iZ1 = z1(vVarK2);
        if (iZ1 == 0) {
            this.A = vVarK2;
            this.g = 9;
            this.l0 = 9;
            return 9;
        }
        this.f1584j.w((char) iZ1);
        this.l0 = 0;
        this.g = 4;
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        return this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        I0(r7);
        F0(r7, " expected a hex digit (0-9a-fA-F) for character entity");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int Z1(int i2) throws XMLStreamException {
        int i3;
        int i4;
        int i5 = i2 + 1;
        byte b = this.z0[i2];
        int i6 = this.g0;
        int i7 = 0;
        while (true) {
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i3 = b - 65;
                } else {
                    if (b > 102 || b < 97) {
                        break;
                    }
                    i3 = b - 97;
                }
                i4 = i3 + 10;
            } else {
                i4 = b - 48;
            }
            i7 = (i7 << 4) + i4;
            if (i7 > 1114111) {
                d0();
                throw null;
            }
            if (i5 >= i6) {
                return 0;
            }
            int i8 = i5 + 1;
            b = this.z0[i5];
            if (b == 59) {
                this.f0 = i8;
                G0(i7);
                return i7;
            }
            i5 = i8;
        }
    }

    @Override // i.e.a.j.e0
    public int a0() throws XMLStreamException {
        int i2 = this.g;
        if (i2 != 257) {
            if (i2 == 1) {
                if (this.C) {
                    this.f1583i--;
                    this.g = 2;
                    return 2;
                }
            } else if (i2 == 2) {
                this.D = this.D.b();
                while (true) {
                    r rVar = this.I;
                    if (rVar == null || rVar.e() < this.f1583i) {
                        break;
                    }
                    this.I = this.I.j();
                }
            }
            N0();
            if (this.f1582h) {
                if (!x0()) {
                    return 257;
                }
                this.f1582h = false;
            }
            this.l0 = 257;
            this.g = 257;
            this.m0 = 0;
        }
        if (this.l0 == 257) {
            if (this.m0 == 0) {
                if (this.n0 != 0) {
                    this.l0 = 4;
                    return q2();
                }
                int i3 = this.f0;
                if (i3 >= this.g0) {
                    return this.g;
                }
                byte[] bArr = this.z0;
                this.f0 = i3 + 1;
                byte b = bArr[i3];
                if (b == 60) {
                    this.m0 = 1;
                } else {
                    if (b != 38) {
                        this.l0 = 4;
                        return p2(b);
                    }
                    this.m0 = 2;
                }
            }
            int i4 = this.f0;
            int i5 = this.g0;
            if (i4 >= i5) {
                return this.g;
            }
            int i6 = this.m0;
            if (i6 == 1) {
                byte[] bArr2 = this.z0;
                this.f0 = i4 + 1;
                byte b2 = bArr2[i4];
                if (b2 != 33) {
                    if (b2 != 63) {
                        return b2 == 47 ? U1() : i1(b2);
                    }
                    this.l0 = 3;
                    this.m0 = 0;
                    return e1();
                }
                this.m0 = 3;
            } else {
                if (i6 == 2) {
                    return X1();
                }
                if (i6 == 6) {
                    return a2();
                }
                if (i6 == 5) {
                    return d2();
                }
            }
            if (this.m0 != 3) {
                q1();
                throw null;
            }
            int i7 = this.f0;
            if (i7 >= i5) {
                return this.g;
            }
            byte[] bArr3 = this.z0;
            this.f0 = i7 + 1;
            byte b3 = bArr3[i7];
            if (b3 == 45) {
                this.l0 = 5;
                this.m0 = 0;
            } else {
                if (b3 != 91) {
                    I0(b3);
                    r0(b3, " (expected either '-' for COMMENT or '[CDATA[' for CDATA section)");
                    throw null;
                }
                this.l0 = 12;
                this.m0 = 0;
            }
        }
        int i8 = this.l0;
        if (i8 == 1) {
            return h1();
        }
        if (i8 == 2) {
            return T1();
        }
        if (i8 == 3) {
            return e1();
        }
        if (i8 != 4) {
            if (i8 == 5) {
                return b1();
            }
            if (i8 == 12) {
                return N1();
            }
            q1();
            throw null;
        }
        if (!this.f && this.e) {
            return H1();
        }
        if (this.n0 != 0) {
            return q2();
        }
        q1();
        throw null;
    }

    protected int a2() throws XMLStreamException {
        v vVarJ2 = j2();
        if (vVarJ2 == null) {
            return this.l0;
        }
        int iZ1 = z1(vVarJ2);
        if (iZ1 == 0) {
            this.A = vVarJ2;
            this.g = 9;
            return 9;
        }
        this.f1584j.w((char) iZ1);
        this.l0 = 0;
        this.g = 4;
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        return this.g;
    }

    @Override // i.e.a.f.c
    protected final int b1() throws XMLStreamException {
        int i2 = this.m0;
        if (i2 == 1) {
            return i2();
        }
        int i3 = this.f0;
        if (i3 >= this.g0) {
            return 257;
        }
        byte[] bArr = this.z0;
        this.f0 = i3 + 1;
        byte b = bArr[i3];
        if (i2 == 0) {
            if (b == 45) {
                this.m0 = 1;
                this.f1584j.x();
                return i2();
            }
            I0(b);
            r0(b, " (expected '-' for COMMENT)");
            throw null;
        }
        if (i2 != 3) {
            q1();
            throw null;
        }
        if (b != 62) {
            b0();
            throw null;
        }
        this.m0 = 0;
        this.l0 = 257;
        return 5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean b2() throws XMLStreamException {
        int i2;
        int[] iArr = this.i0.b;
        char[] cArrB = this.t;
        byte b = this.u0;
        if (this.n0 != 0) {
            if (!c2()) {
                return false;
            }
            this.n0 = 0;
        }
        while (this.f0 < this.g0) {
            if (this.x0 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
            }
            int i3 = this.g0;
            int length = this.f0 + (cArrB.length - this.x0);
            if (length < i3) {
                i3 = length;
            }
            while (true) {
                int i4 = this.f0;
                if (i4 < i3) {
                    byte[] bArr = this.z0;
                    int i5 = i4 + 1;
                    this.f0 = i5;
                    int iB1 = bArr[i4] & 255;
                    if (iArr[iB1] != 0) {
                        int i6 = iArr[iB1];
                        if (i6 != 14) {
                            switch (i6) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (this.z0[i2] == 10) {
                                            this.f0 = i2 + 1;
                                        }
                                        J0();
                                        iB1 = 32;
                                        break;
                                    } else {
                                        this.n0 = -1;
                                        return false;
                                    }
                                case 2:
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                    }
                                    break;
                                case 3:
                                    J0();
                                    iB1 = 32;
                                    break;
                                case 4:
                                    L0(iB1);
                                    throw null;
                                case 5:
                                    if (i5 < this.g0) {
                                        iB1 = B1(iB1);
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 6:
                                    int i7 = this.g0;
                                    if (i7 - i5 >= 2) {
                                        iB1 = C1(iB1);
                                        break;
                                    } else {
                                        if (i7 > i5) {
                                            this.f0 = i5 + 1;
                                            iB1 |= (bArr[i5] & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 7:
                                    int i8 = this.g0;
                                    if (i8 - i5 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i9 = this.x0;
                                        int i10 = i9 + 1;
                                        this.x0 = i10;
                                        cArrB[i9] = (char) ((iE1 >> 10) | 55296);
                                        iB1 = (iE1 & 1023) | 56320;
                                        if (i10 >= cArrB.length) {
                                            cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                                            this.t = cArrB;
                                            break;
                                        }
                                    } else {
                                        if (i8 > i5) {
                                            int i11 = i5 + 1;
                                            this.f0 = i11;
                                            iB1 |= (bArr[i5] & 255) << 8;
                                            if (i8 > i11) {
                                                this.f0 = i11 + 1;
                                                iB1 |= (bArr[i11] & 255) << 16;
                                            }
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                    break;
                                case 8:
                                    iB1 = 32;
                                    break;
                                case 9:
                                    F0(iB1, "'<' not allowed in attribute value");
                                    throw null;
                                case 10:
                                    iB1 = V1();
                                    if (iB1 > 0) {
                                        if ((iB1 >> 16) != 0) {
                                            int i12 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                            int i13 = this.x0;
                                            int i14 = i13 + 1;
                                            this.x0 = i14;
                                            cArrB[i13] = (char) ((i12 >> 10) | 55296);
                                            iB1 = (i12 & 1023) | 56320;
                                            if (i14 >= cArrB.length) {
                                                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                                                this.t = cArrB;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (iB1 < 0) {
                                            return false;
                                        }
                                        t0(this.v0, true);
                                        throw null;
                                    }
                                    break;
                            }
                        } else if (iB1 == b) {
                            int i15 = this.x0;
                            if (i15 == 0) {
                                e(this.v0, "");
                            } else {
                                e(this.v0, this.c.l(cArrB, i15));
                            }
                            return true;
                        }
                        int i16 = this.x0;
                        this.x0 = i16 + 1;
                        cArrB[i16] = (char) iB1;
                    } else {
                        int i17 = this.x0;
                        this.x0 = i17 + 1;
                        cArrB[i17] = (char) iB1;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0113 A[SYNTHETIC] */
    @Override // i.e.a.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean d1(boolean z) throws XMLStreamException {
        char[] cArrO;
        int iP;
        int i2;
        if (z) {
            cArrO = this.f1584j.x();
            this.u0 = (byte) 0;
            this.y0 = false;
            iP = 0;
        } else {
            if (this.n0 != 0 && !J1()) {
                return false;
            }
            cArrO = this.f1584j.o();
            iP = this.f1584j.p();
        }
        int[] iArr = this.i0.d;
        byte[] bArr = this.z0;
        while (true) {
            if (this.f0 < this.g0) {
                if (iP >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iP = 0;
                }
                int i3 = this.g0;
                int length = this.f0 + (cArrO.length - iP);
                if (length < i3) {
                    i3 = length;
                }
                while (true) {
                    int i4 = this.f0;
                    if (i4 < i3) {
                        int i5 = i4 + 1;
                        this.f0 = i5;
                        int iB1 = bArr[i4] & 255;
                        if (iArr[iB1] != 0) {
                            switch (iArr[iB1]) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (bArr[i2] == 10) {
                                            this.f0 = i2 + 1;
                                        }
                                        J0();
                                        iB1 = 10;
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.n0 = -1;
                                        break;
                                    }
                                case 2:
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                    }
                                    break;
                                case 3:
                                    J0();
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 4:
                                    L0(iB1);
                                    throw null;
                                case 5:
                                    if (i5 < this.g0) {
                                        iB1 = B1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 6:
                                    int i6 = this.g0;
                                    if (i6 - i5 >= 2) {
                                        iB1 = C1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i6 > i5) {
                                            byte[] bArr2 = this.z0;
                                            this.f0 = i5 + 1;
                                            iB1 |= (bArr2[i5] & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 7:
                                    int i7 = this.g0;
                                    if (i7 - i5 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i8 = iP + 1;
                                        cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                        if (i8 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                            iP = 0;
                                        } else {
                                            iP = i8;
                                        }
                                        iB1 = 56320 | (iE1 & 1023);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i7 > i5) {
                                            byte[] bArr3 = this.z0;
                                            int i9 = i5 + 1;
                                            this.f0 = i9;
                                            iB1 |= (bArr3[i5] & 255) << 8;
                                            if (i7 > i9) {
                                                this.f0 = i9 + 1;
                                                iB1 |= (bArr3[i9] & 255) << 16;
                                            }
                                        }
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 8:
                                    byte b = this.u0;
                                    if (b == 0) {
                                        this.u0 = (byte) iB1;
                                    } else if (b == iB1) {
                                        this.u0 = (byte) 0;
                                    }
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 9:
                                    if (!this.y0) {
                                        this.y0 = true;
                                    }
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 10:
                                    if (this.u0 == 0) {
                                        this.y0 = false;
                                    }
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 11:
                                    if (!this.y0 && this.u0 == 0) {
                                        this.f1584j.A(iP);
                                        return true;
                                    }
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                default:
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                            }
                        } else {
                            cArrO[iP] = (char) iB1;
                            iP++;
                        }
                    }
                }
            }
        }
        this.f1584j.A(iP);
        return false;
    }

    protected int d2() throws XMLStreamException {
        if (this.n0 == -70) {
            byte[] bArr = this.z0;
            int i2 = this.f0;
            byte b = bArr[i2];
            this.s0 = 0;
            if (b == 120) {
                this.n0 = -73;
                int i3 = i2 + 1;
                this.f0 = i3;
                if (i3 >= this.g0) {
                    return 257;
                }
            } else {
                this.n0 = -72;
            }
        }
        if (this.n0 == -73) {
            if (!A1()) {
                return 257;
            }
        } else if (!y1()) {
            return 257;
        }
        s1(this.s0);
        this.g = 4;
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        this.n0 = 0;
        return this.g;
    }

    @Override // i.e.a.f.c
    protected int e1() throws XMLStreamException {
        if (this.m0 == 5) {
            return l2();
        }
        while (true) {
            int i2 = this.f0;
            if (i2 >= this.g0) {
                return 257;
            }
            int i3 = this.m0;
            if (i3 == 0) {
                byte[] bArr = this.z0;
                this.f0 = i2 + 1;
                v vVarL1 = l1(bArr[i2]);
                this.A = vVarL1;
                if (vVarL1 == null) {
                    this.m0 = 4;
                    return 257;
                }
                this.m0 = 1;
                Y0(vVarL1);
                if (this.f0 >= this.g0) {
                    return 257;
                }
            } else if (i3 != 1) {
                if (i3 == 2) {
                    if (!X0()) {
                        return 257;
                    }
                    this.m0 = 5;
                    this.f1584j.x();
                    return l2();
                }
                if (i3 == 3) {
                    byte[] bArr2 = this.z0;
                    this.f0 = i2 + 1;
                    byte b = bArr2[i2];
                    if (b != 62) {
                        I0(b);
                        m0(b);
                        throw null;
                    }
                } else {
                    if (i3 != 4) {
                        q1();
                        throw null;
                    }
                    v vVarM1 = m1();
                    this.A = vVarM1;
                    if (vVarM1 == null) {
                        return 257;
                    }
                    Y0(vVarM1);
                    this.m0 = 1;
                }
            }
            byte[] bArr3 = this.z0;
            int i4 = this.f0;
            int i5 = i4 + 1;
            this.f0 = i5;
            byte b2 = bArr3[i4];
            if (b2 != 63) {
                if (b2 != 32 && b2 != 13 && b2 != 10 && b2 != 9) {
                    I0(b2);
                    m0(b2);
                    throw null;
                }
                if (!X0()) {
                    this.m0 = 2;
                    return 257;
                }
                this.f1584j.x();
                int i6 = this.f0;
                if (i6 + 1 < this.g0) {
                    byte[] bArr4 = this.z0;
                    if (bArr4[i6] == 63 && bArr4[i6 + 1] == 62) {
                        this.f0 = i6 + 2;
                    }
                }
                this.m0 = 5;
                return l2();
            }
            if (i5 < this.g0 && bArr3[i5] == 62) {
                this.f0 = i5 + 1;
                break;
            }
            this.m0 = 3;
        }
        this.m0 = 0;
        this.l0 = 257;
        return 3;
    }

    protected int e2() throws XMLStreamException {
        if (this.n0 != -15) {
            return J1() ? 0 : 257;
        }
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return 257;
        }
        byte b = this.z0[i2];
        this.n0 = 0;
        if (b != 62) {
            this.f1584j.b('?');
            return 0;
        }
        this.f0 = i2 + 1;
        this.m0 = 0;
        this.l0 = 257;
        return 3;
    }

    @Override // i.e.a.f.c
    protected final boolean f1() {
        if (this.n0 != -1) {
            q1();
            throw null;
        }
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return false;
        }
        this.n0 = 0;
        if (this.z0[i2] == 10) {
            this.f0 = i2 + 1;
        }
        this.a0++;
        this.b0 = this.f0;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x010e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    @Override // i.e.a.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int h1() throws XMLStreamException {
        byte b;
        int i2;
        int i3;
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                return 257;
            }
            switch (this.m0) {
                case 1:
                    v vVarM1 = m1();
                    if (vVarM1 == null) {
                        return 257;
                    }
                    g2(vVarM1);
                    if (this.f0 >= this.g0) {
                        return 257;
                    }
                    if (this.n0 != 0) {
                        byte[] bArr = this.z0;
                        int i5 = this.f0;
                        int i6 = i5 + 1;
                        this.f0 = i6;
                        byte b2 = bArr[i5];
                        int i7 = b2 & 255;
                        if (i7 <= 32) {
                            if (i7 == 10) {
                                J0();
                            } else if (i7 == 13) {
                                if (i6 >= this.g0) {
                                    this.n0 = -1;
                                    return 257;
                                }
                                if (bArr[i6] == 10) {
                                    this.f0 = i6 + 1;
                                }
                                J0();
                            } else if (i7 != 32 && i7 != 9) {
                                D0(i7);
                                throw null;
                            }
                        } else {
                            if (i7 == 62) {
                                return I1(false);
                            }
                            if (i7 != 47) {
                                I0(b2);
                                F0(b2, " expected space, or '>' or \"/>\"");
                                throw null;
                            }
                            this.m0 = 9;
                        }
                    } else if (!f1()) {
                        return 257;
                    }
                    this.m0 = 3;
                    if (this.f0 >= this.g0) {
                        return 257;
                    }
                    if (this.n0 == 0 && (!f1() || this.f0 >= this.g0)) {
                        return 257;
                    }
                    byte[] bArr2 = this.z0;
                    int i8 = this.f0;
                    this.f0 = i8 + 1;
                    b = bArr2[i8];
                    while (true) {
                        i2 = b & 255;
                        if (i2 <= 32) {
                            if (i2 == 10) {
                                J0();
                            } else if (i2 == 13) {
                                int i9 = this.f0;
                                if (i9 >= this.g0) {
                                    this.n0 = -1;
                                    return 257;
                                }
                                if (this.z0[i9] == 10) {
                                    this.f0 = i9 + 1;
                                }
                                J0();
                            } else if (i2 != 32 && i2 != 9) {
                                D0(i2);
                                throw null;
                            }
                            i3 = this.f0;
                            if (i3 >= this.g0) {
                                return 257;
                            }
                            byte[] bArr3 = this.z0;
                            this.f0 = i3 + 1;
                            b = bArr3[i3];
                        } else {
                            int i10 = this.m0;
                            if (i10 != 3) {
                                if (i10 != 5) {
                                    if (i10 != 6) {
                                        q1();
                                        throw null;
                                    }
                                    if (b != 34 && b != 39) {
                                        I0(b);
                                        F0(b, " Expected a quote");
                                        throw null;
                                    }
                                    f2(b);
                                } else {
                                    if (b != 61) {
                                        I0(b);
                                        F0(b, " expected '='");
                                        throw null;
                                    }
                                    this.m0 = 6;
                                }
                            } else if (b == 47) {
                                this.m0 = 9;
                            } else {
                                if (b == 62) {
                                    return I1(false);
                                }
                                v vVarL1 = l1(b);
                                if (vVarL1 == null) {
                                    this.m0 = 4;
                                    return 257;
                                }
                                this.m0 = 5;
                                this.v0 = vVarL1;
                            }
                        }
                    }
                    break;
                case 2:
                    if (this.n0 != 0) {
                    }
                    this.m0 = 3;
                    if (this.f0 >= this.g0) {
                    }
                    if (this.n0 == 0) {
                        break;
                    }
                    byte[] bArr22 = this.z0;
                    int i82 = this.f0;
                    this.f0 = i82 + 1;
                    b = bArr22[i82];
                    while (true) {
                        i2 = b & 255;
                        if (i2 <= 32) {
                        }
                        byte[] bArr32 = this.z0;
                        this.f0 = i3 + 1;
                        b = bArr32[i3];
                    }
                    break;
                case 3:
                case 5:
                case 6:
                    if (this.n0 == 0) {
                    }
                    byte[] bArr222 = this.z0;
                    int i822 = this.f0;
                    this.f0 = i822 + 1;
                    b = bArr222[i822];
                    while (true) {
                        i2 = b & 255;
                        if (i2 <= 32) {
                        }
                        byte[] bArr322 = this.z0;
                        this.f0 = i3 + 1;
                        b = bArr322[i3];
                    }
                    break;
                case 4:
                    v vVarM12 = m1();
                    if (vVarM12 == null) {
                        return 257;
                    }
                    this.v0 = vVarM12;
                    this.m0 = 5;
                case 7:
                    if (!K1()) {
                        return 257;
                    }
                    this.m0 = 2;
                case 8:
                    if (!b2()) {
                        return 257;
                    }
                    this.m0 = 2;
                case 9:
                    byte[] bArr4 = this.z0;
                    this.f0 = i4 + 1;
                    byte b3 = bArr4[i4];
                    if (b3 == 62) {
                        return I1(true);
                    }
                    I0(b3);
                    F0(b3, " expected '>'");
                    throw null;
                default:
                    q1();
                    throw null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0114, code lost:
    
        r11.f1584j.A(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0119, code lost:
    
        return 257;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final int h2() throws XMLStreamException {
        int i2;
        int iO1;
        if (this.n0 != 0 && (iO1 = O1()) != 0) {
            return iO1;
        }
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        int[] iArr = this.i0.e;
        byte[] bArr = this.z0;
        while (true) {
            if (this.f0 < this.g0) {
                int i3 = 0;
                if (iP >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iP = 0;
                }
                int i4 = this.g0;
                int length = this.f0 + (cArrO.length - iP);
                if (length < i4) {
                    i4 = length;
                }
                while (true) {
                    int i5 = this.f0;
                    if (i5 < i4) {
                        int i6 = i5 + 1;
                        this.f0 = i6;
                        int iB1 = bArr[i5] & 255;
                        if (iArr[iB1] != 0) {
                            int i7 = iArr[iB1];
                            if (i7 != 11) {
                                switch (i7) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (bArr[i2] == 10) {
                                                this.f0 = i2 + 1;
                                            }
                                            J0();
                                            iB1 = 10;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = -1;
                                            break;
                                        }
                                    case 2:
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                        }
                                        break;
                                    case 3:
                                        J0();
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    case 4:
                                        L0(iB1);
                                        throw null;
                                    case 5:
                                        if (i6 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i8 = this.g0;
                                        if (i8 - i6 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i8 > i6) {
                                                byte[] bArr2 = this.z0;
                                                this.f0 = i6 + 1;
                                                iB1 |= (bArr2[i6] & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        if (i9 - i6 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i10 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i10 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i10;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i6) {
                                                byte[] bArr3 = this.z0;
                                                int i11 = i6 + 1;
                                                this.f0 = i11;
                                                iB1 |= (bArr3[i6] & 255) << 8;
                                                if (i9 > i11) {
                                                    this.f0 = i11 + 1;
                                                    iB1 |= (bArr3[i11] & 255) << 16;
                                                }
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    default:
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                }
                            } else if (i6 >= this.g0) {
                                this.n0 = -30;
                            } else if (this.z0[i6] == 93) {
                                this.f0 = i6 + 1;
                                while (true) {
                                    int i12 = this.f0;
                                    if (i12 >= this.g0) {
                                        this.n0 = -31;
                                    } else {
                                        byte[] bArr4 = this.z0;
                                        if (bArr4[i12] == 62) {
                                            this.f0 = i12 + 1;
                                            this.f1584j.A(iP);
                                            this.m0 = 0;
                                            this.l0 = 257;
                                            return 12;
                                        }
                                        if (bArr4[i12] != 93) {
                                            int i13 = iP + 1;
                                            cArrO[iP] = ']';
                                            if (i13 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i13;
                                            }
                                            iP = i3 + 1;
                                            cArrO[i3] = ']';
                                        } else {
                                            this.f0 = i12 + 1;
                                            int i14 = iP + 1;
                                            cArrO[iP] = ']';
                                            if (i14 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                                iP = 0;
                                            } else {
                                                iP = i14;
                                            }
                                        }
                                    }
                                }
                            } else {
                                cArrO[iP] = (char) iB1;
                                iP++;
                            }
                        } else {
                            cArrO[iP] = (char) iB1;
                            iP++;
                        }
                    }
                }
            }
        }
    }

    @Override // i.e.a.f.c
    protected int i1(byte b) throws XMLStreamException {
        v vVarL1 = l1(b);
        this.l0 = 1;
        if (vVarL1 == null) {
            this.m0 = 1;
            return 257;
        }
        g2(vVarL1);
        return h1();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int i2() throws XMLStreamException {
        int i2;
        int iQ1;
        if (this.n0 != 0 && (iQ1 = Q1()) != 0) {
            return iQ1;
        }
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        int[] iArr = this.i0.e;
        byte[] bArr = this.z0;
        while (true) {
            if (this.f0 < this.g0) {
                int i3 = 0;
                if (iP >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iP = 0;
                }
                int i4 = this.g0;
                int length = this.f0 + (cArrO.length - iP);
                if (length < i4) {
                    i4 = length;
                }
                while (true) {
                    int i5 = this.f0;
                    if (i5 < i4) {
                        int i6 = i5 + 1;
                        this.f0 = i6;
                        int iB1 = bArr[i5] & 255;
                        if (iArr[iB1] != 0) {
                            int i7 = iArr[iB1];
                            if (i7 != 13) {
                                switch (i7) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (bArr[i2] == 10) {
                                                this.f0 = i2 + 1;
                                            }
                                            J0();
                                            iB1 = 10;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = -1;
                                            break;
                                        }
                                    case 2:
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                        }
                                        break;
                                    case 3:
                                        J0();
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    case 4:
                                        L0(iB1);
                                        throw null;
                                    case 5:
                                        if (i6 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i8 = this.g0;
                                        if (i8 - i6 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i8 > i6) {
                                                byte[] bArr2 = this.z0;
                                                this.f0 = i6 + 1;
                                                iB1 |= (bArr2[i6] & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        if (i9 - i6 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i10 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i10 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i10;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i6) {
                                                byte[] bArr3 = this.z0;
                                                int i11 = i6 + 1;
                                                this.f0 = i11;
                                                iB1 |= (bArr3[i6] & 255) << 8;
                                                if (i9 > i11) {
                                                    this.f0 = i11 + 1;
                                                    iB1 |= (bArr3[i11] & 255) << 16;
                                                }
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    default:
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                }
                            } else {
                                int i12 = this.g0;
                                if (i6 >= i12) {
                                    this.n0 = -20;
                                } else {
                                    byte[] bArr4 = this.z0;
                                    if (bArr4[i6] == 45) {
                                        int i13 = i6 + 1;
                                        this.f0 = i13;
                                        if (i13 < i12) {
                                            this.f0 = i13 + 1;
                                            if (bArr4[i13] != 62) {
                                                b0();
                                                throw null;
                                            }
                                            this.f1584j.A(iP);
                                            this.m0 = 0;
                                            this.l0 = 257;
                                            return 5;
                                        }
                                        this.n0 = -21;
                                    }
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                }
                            }
                        } else {
                            cArrO[iP] = (char) iB1;
                            iP++;
                        }
                    }
                }
            }
        }
        this.f1584j.A(iP);
        return 257;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r13.p0 != 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        r0 = r13.k0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r0 != i.e.a.j.l.g) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r13.f0 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        return i.e.a.j.l.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r0 != i.e.a.j.l.f1599j) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        r13.f0 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return i.e.a.j.l.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        return Z0(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0076, code lost:
    
        return Z0(r0, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d6, code lost:
    
        if (r13.p0 != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00da, code lost:
    
        if (r0 != i.e.a.j.l.f) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
    
        r13.f0 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e1, code lost:
    
        return i.e.a.j.l.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00e6, code lost:
    
        return Z0(r0, 3);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00bd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v j2() throws XMLStreamException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.q0;
        while (true) {
            int i7 = this.r0;
            if (i7 == 0) {
                int i8 = this.f0;
                if (i8 < this.g0) {
                    byte[] bArr = this.z0;
                    int i9 = i8 + 1;
                    this.f0 = i9;
                    i6 = bArr[i8] & 255;
                    if (i6 < 65 && (i6 < 45 || i6 > 58 || i6 == 47)) {
                        break;
                    }
                } else {
                    return null;
                }
            } else {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 == 3) {
                        }
                        i4 = this.p0;
                        if (i4 != 0) {
                            this.k0[0] = i6;
                            this.p0 = 1;
                        } else {
                            int[] iArr = this.k0;
                            if (i4 >= iArr.length) {
                                this.k0 = i.e.a.l.c.c(iArr, iArr.length);
                            }
                            int[] iArr2 = this.k0;
                            int i10 = this.p0;
                            this.p0 = i10 + 1;
                            iArr2[i10] = i6;
                        }
                        this.r0 = 0;
                    }
                    i5 = this.f0;
                    if (i5 >= this.g0) {
                        byte[] bArr2 = this.z0;
                        int i11 = i5 + 1;
                        this.f0 = i11;
                        int i12 = bArr2[i5] & 255;
                        if (i12 < 65 && (i12 < 45 || i12 > 58 || i12 == 47)) {
                            break;
                        }
                        i6 = (i6 << 8) | i12;
                        i4 = this.p0;
                        if (i4 != 0) {
                        }
                        this.r0 = 0;
                    } else {
                        this.q0 = i6;
                        this.r0 = 3;
                        return null;
                    }
                }
                i2 = this.f0;
                if (i2 >= this.g0) {
                    byte[] bArr3 = this.z0;
                    i3 = i2 + 1;
                    this.f0 = i3;
                    int i13 = bArr3[i2] & 255;
                    if (i13 < 65 && (i13 < 45 || i13 > 58 || i13 == 47)) {
                        break;
                    }
                    i6 = (i6 << 8) | i13;
                    i5 = this.f0;
                    if (i5 >= this.g0) {
                    }
                } else {
                    this.q0 = i6;
                    this.r0 = 2;
                    return null;
                }
            }
            int i14 = this.f0;
            if (i14 < this.g0) {
                byte[] bArr4 = this.z0;
                this.f0 = i14 + 1;
                int i15 = bArr4[i14] & 255;
                if (i15 < 65 && (i15 < 45 || i15 > 58 || i15 == 47)) {
                    break;
                }
                i6 = (i6 << 8) | i15;
                i2 = this.f0;
                if (i2 >= this.g0) {
                }
            } else {
                this.q0 = i6;
                this.r0 = 1;
                return null;
            }
        }
        if (this.p0 == 0) {
            if (i6 == l.f1597h) {
                this.f0 = i3 - 1;
                return l.c;
            }
            if (i6 == l.f1598i) {
                this.f0 = i3 - 1;
                return l.d;
            }
        }
        return Z0(i6, 2);
    }

    protected final v k2(byte b) throws XMLStreamException {
        int i2 = b & 255;
        if (i2 < 65) {
            F0(i2, "; expected a name start character");
            throw null;
        }
        this.p0 = 0;
        this.q0 = i2;
        this.r0 = 1;
        return j2();
    }

    @Override // i.e.a.f.c
    protected final v l1(byte b) throws XMLStreamException {
        int i2 = b & 255;
        if (i2 < 65) {
            F0(i2, "; expected a name start character");
            throw null;
        }
        this.p0 = 0;
        this.q0 = i2;
        this.r0 = 1;
        return m1();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int l2() throws XMLStreamException {
        int i2;
        int iE2;
        if (this.n0 != 0 && (iE2 = e2()) != 0) {
            return iE2;
        }
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        int[] iArr = this.i0.e;
        byte[] bArr = this.z0;
        while (true) {
            if (this.f0 < this.g0) {
                int i3 = 0;
                if (iP >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iP = 0;
                }
                int i4 = this.g0;
                int length = this.f0 + (cArrO.length - iP);
                if (length < i4) {
                    i4 = length;
                }
                while (true) {
                    int i5 = this.f0;
                    if (i5 < i4) {
                        int i6 = i5 + 1;
                        this.f0 = i6;
                        int iB1 = bArr[i5] & 255;
                        if (iArr[iB1] != 0) {
                            int i7 = iArr[iB1];
                            if (i7 != 12) {
                                switch (i7) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (bArr[i2] == 10) {
                                                this.f0 = i2 + 1;
                                            }
                                            J0();
                                            iB1 = 10;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = -1;
                                            break;
                                        }
                                    case 2:
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                        }
                                        break;
                                    case 3:
                                        J0();
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    case 4:
                                        L0(iB1);
                                        throw null;
                                    case 5:
                                        if (i6 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i8 = this.g0;
                                        if (i8 - i6 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i8 > i6) {
                                                byte[] bArr2 = this.z0;
                                                this.f0 = i6 + 1;
                                                iB1 |= (bArr2[i6] & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        if (i9 - i6 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i10 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i10 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i10;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i6) {
                                                byte[] bArr3 = this.z0;
                                                int i11 = i6 + 1;
                                                this.f0 = i11;
                                                iB1 |= (bArr3[i6] & 255) << 8;
                                                if (i9 > i11) {
                                                    this.f0 = i11 + 1;
                                                    iB1 |= (bArr3[i11] & 255) << 16;
                                                }
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    default:
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                }
                            } else if (i6 >= this.g0) {
                                this.n0 = -15;
                            } else {
                                if (this.z0[i6] == 62) {
                                    this.f0 = i6 + 1;
                                    this.f1584j.A(iP);
                                    this.m0 = 0;
                                    this.l0 = 257;
                                    return 3;
                                }
                                cArrO[iP] = (char) iB1;
                                iP++;
                            }
                        } else {
                            cArrO[iP] = (char) iB1;
                            iP++;
                        }
                    }
                }
            }
        }
        this.f1584j.A(iP);
        return 257;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        return Z0(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        return Z0(r0, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        return Z0(r0, 2);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0089 A[SYNTHETIC] */
    @Override // i.e.a.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v m1() throws XMLStreamException {
        int i2;
        int i3;
        int i4;
        int i5 = this.q0;
        while (true) {
            int i6 = this.r0;
            if (i6 == 0) {
                int i7 = this.f0;
                if (i7 < this.g0) {
                    byte[] bArr = this.z0;
                    this.f0 = i7 + 1;
                    i5 = bArr[i7] & 255;
                    if (i5 < 65 && (i5 < 45 || i5 > 58 || i5 == 47)) {
                        break;
                    }
                } else {
                    return null;
                }
            } else {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                        }
                        i3 = this.p0;
                        if (i3 != 0) {
                            this.k0[0] = i5;
                            this.p0 = 1;
                        } else {
                            int[] iArr = this.k0;
                            if (i3 >= iArr.length) {
                                this.k0 = i.e.a.l.c.c(iArr, iArr.length);
                            }
                            int[] iArr2 = this.k0;
                            int i8 = this.p0;
                            this.p0 = i8 + 1;
                            iArr2[i8] = i5;
                        }
                        this.r0 = 0;
                    }
                    i4 = this.f0;
                    if (i4 >= this.g0) {
                        byte[] bArr2 = this.z0;
                        this.f0 = i4 + 1;
                        int i9 = bArr2[i4] & 255;
                        if (i9 < 65 && (i9 < 45 || i9 > 58 || i9 == 47)) {
                            break;
                        }
                        i5 = (i5 << 8) | i9;
                        i3 = this.p0;
                        if (i3 != 0) {
                        }
                        this.r0 = 0;
                    } else {
                        this.q0 = i5;
                        this.r0 = 3;
                        return null;
                    }
                }
                i2 = this.f0;
                if (i2 >= this.g0) {
                    byte[] bArr3 = this.z0;
                    this.f0 = i2 + 1;
                    int i10 = bArr3[i2] & 255;
                    if (i10 < 65 && (i10 < 45 || i10 > 58 || i10 == 47)) {
                        break;
                    }
                    i5 = (i5 << 8) | i10;
                    i4 = this.f0;
                    if (i4 >= this.g0) {
                    }
                } else {
                    this.q0 = i5;
                    this.r0 = 2;
                    return null;
                }
            }
            int i11 = this.f0;
            if (i11 < this.g0) {
                byte[] bArr4 = this.z0;
                this.f0 = i11 + 1;
                int i12 = bArr4[i11] & 255;
                if (i12 < 65 && (i12 < 45 || i12 > 58 || i12 == 47)) {
                    break;
                }
                i5 = (i5 << 8) | i12;
                i2 = this.f0;
                if (i2 >= this.g0) {
                }
            } else {
                this.q0 = i5;
                this.r0 = 1;
                return null;
            }
        }
        return Z0(i5, 3);
    }

    protected final void o2(int i2) throws XMLStreamException {
        byte[] bArr = this.z0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) == 128) {
            return;
        }
        o1(b & 255, i4);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed A[PHI: r5 r6
      0x00ed: PHI (r5v17 int) = (r5v16 int), (r5v21 int) binds: [B:56:0x00e4, B:45:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00ed: PHI (r6v12 int) = (r6v11 int), (r6v15 int) binds: [B:56:0x00e4, B:45:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f A[SYNTHETIC] */
    @Override // i.e.a.f.c, i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void p() throws XMLStreamException {
        int i2;
        int iE1;
        int i3;
        if (this.n0 != 0) {
            q1();
            throw null;
        }
        int[] iArr = this.i0.a;
        byte[] bArr = this.z0;
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        while (true) {
            int i4 = this.f0;
            if (i4 < this.g0) {
                int i5 = 0;
                if (iP >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iP = 0;
                }
                int i6 = this.g0;
                int length = (cArrO.length - iP) + i4;
                if (length < i6) {
                    i6 = length;
                }
                while (true) {
                    if (i4 < i6) {
                        int i7 = i4 + 1;
                        int iB1 = bArr[i4] & 255;
                        if (iArr[iB1] != 0) {
                            this.f0 = i7;
                            switch (iArr[iB1]) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (bArr[i2] == 10) {
                                            this.f0 = i2 + 1;
                                        }
                                        J0();
                                        iB1 = 10;
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.n0 = -1;
                                        break;
                                    }
                                case 2:
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                    }
                                    break;
                                case 3:
                                    J0();
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 4:
                                    L0(iB1);
                                    throw null;
                                case 5:
                                    if (i7 < this.g0) {
                                        iB1 = B1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 6:
                                    int i8 = this.g0;
                                    if (i8 - i7 >= 2) {
                                        iB1 = C1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i8 > i7) {
                                            byte[] bArr2 = this.z0;
                                            this.f0 = i7 + 1;
                                            iB1 |= (bArr2[i7] & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 7:
                                    int i9 = this.g0;
                                    if (i9 - i7 >= 3) {
                                        iE1 = E1(iB1);
                                        i3 = iP + 1;
                                        cArrO[iP] = (char) ((iE1 >> 10) | 55296);
                                        if (i3 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                        } else {
                                            i5 = i3;
                                        }
                                        iB1 = (iE1 & 1023) | 56320;
                                        iP = i5;
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i9 > i7) {
                                            byte[] bArr3 = this.z0;
                                            int i10 = i7 + 1;
                                            this.f0 = i10;
                                            iB1 |= (bArr3[i7] & 255) << 8;
                                            if (i9 > i10) {
                                                this.f0 = i10 + 1;
                                                iB1 |= (bArr3[i10] & 255) << 16;
                                            }
                                        }
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 8:
                                default:
                                    cArrO[iP] = (char) iB1;
                                    iP++;
                                    break;
                                case 9:
                                    this.f0 = i7 - 1;
                                    break;
                                case 10:
                                    iB1 = W1();
                                    if (iB1 != 0) {
                                        if ((iB1 >> 16) != 0) {
                                            iE1 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                            i3 = iP + 1;
                                            cArrO[iP] = (char) ((iE1 >> 10) | 55296);
                                            if (i3 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i5;
                                        }
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.f0--;
                                        break;
                                    }
                                case 11:
                                    byte b = 0;
                                    int i11 = 1;
                                    while (true) {
                                        int i12 = this.f0;
                                        if (i12 < this.g0 && (b = bArr[i12]) == 93) {
                                            this.f0 = i12 + 1;
                                            i11++;
                                        }
                                    }
                                    if (b == 62 && i11 > 1) {
                                        f0();
                                        throw null;
                                    }
                                    while (true) {
                                        i11--;
                                        if (i11 <= 0) {
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            int i13 = iP + 1;
                                            cArrO[iP] = ']';
                                            if (i13 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                                iP = 0;
                                            } else {
                                                iP = i13;
                                            }
                                        }
                                    }
                                    break;
                            }
                        } else {
                            cArrO[iP] = (char) iB1;
                            i4 = i7;
                            iP++;
                        }
                    } else {
                        this.f0 = i4;
                    }
                }
            }
        }
        this.f1584j.A(iP);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final int p2(byte b) throws XMLStreamException {
        int i2;
        int iB1 = b & 255;
        switch (this.i0.a[iB1]) {
            case 1:
                R(iB1);
                i2 = this.f0;
                if (i2 < this.g0) {
                    this.n0 = -1;
                    return 257;
                }
                if (this.z0[i2] == 10) {
                    this.f0 = i2 + 1;
                }
                J0();
                iB1 = 10;
                this.f1584j.w((char) iB1);
                if (!this.e && !this.f) {
                    return H1();
                }
                this.g = 4;
                if (this.f) {
                    p();
                } else {
                    this.f1582h = true;
                }
                return this.g;
            case 2:
                i2 = this.f0;
                if (i2 < this.g0) {
                }
                break;
            case 3:
                J0();
                this.f1584j.w((char) iB1);
                if (!this.e) {
                    break;
                }
                this.g = 4;
                if (this.f) {
                }
                return this.g;
            case 4:
                L0(iB1);
                throw null;
            case 5:
                if (this.f0 >= this.g0) {
                    this.n0 = iB1;
                    return 257;
                }
                iB1 = B1(iB1);
                this.f1584j.w((char) iB1);
                if (!this.e) {
                }
                this.g = 4;
                if (this.f) {
                }
                return this.g;
            case 6:
                int i3 = this.g0;
                int i4 = this.f0;
                if (i3 - i4 < 2) {
                    if (i3 > i4) {
                        byte[] bArr = this.z0;
                        this.f0 = i4 + 1;
                        iB1 |= (bArr[i4] & 255) << 8;
                    }
                    this.n0 = iB1;
                    return 257;
                }
                iB1 = C1(iB1);
                this.f1584j.w((char) iB1);
                if (!this.e) {
                }
                this.g = 4;
                if (this.f) {
                }
                return this.g;
            case 7:
                int i5 = this.g0;
                int i6 = this.f0;
                if (i5 - i6 >= 3) {
                    this.f1584j.z(E1(iB1));
                    if (!this.e) {
                    }
                    this.g = 4;
                    if (this.f) {
                    }
                    return this.g;
                }
                if (i5 > i6) {
                    byte[] bArr2 = this.z0;
                    int i7 = i6 + 1;
                    this.f0 = i7;
                    iB1 |= (bArr2[i6] & 255) << 8;
                    if (i5 > i7) {
                        this.f0 = i7 + 1;
                        iB1 |= (bArr2[i7] & 255) << 16;
                    }
                }
                this.n0 = iB1;
                return 257;
            case 8:
            default:
                this.f1584j.w((char) iB1);
                if (!this.e) {
                }
                this.g = 4;
                if (this.f) {
                }
                return this.g;
            case 9:
            case 10:
                q1();
                throw null;
        }
    }

    protected int q2() throws XMLStreamException {
        int iD1;
        int iF1;
        int i2 = this.f0;
        int i3 = this.g0;
        if (i2 >= i3) {
            return 257;
        }
        int i4 = this.n0;
        this.n0 = 0;
        if (i4 == -1) {
            if (this.z0[i2] == 10) {
                this.f0 = i2 + 1;
            }
            J0();
            this.f1584j.w('\n');
        } else {
            int i5 = i4 & 255;
            int i6 = this.i0.a[i5];
            if (i6 == 5) {
                this.f1584j.w((char) B1(i4));
            } else {
                if (i6 != 6) {
                    if (i6 != 7) {
                        q1();
                        throw null;
                    }
                    byte[] bArr = this.z0;
                    int i7 = i2 + 1;
                    this.f0 = i7;
                    int i8 = bArr[i2] & 255;
                    int i9 = i4 >> 8;
                    if (i9 != 0) {
                        int i10 = i9 & 255;
                        int i11 = i4 >> 16;
                        if (i11 != 0) {
                            iF1 = F1(i5, i10, i11, i8);
                        } else {
                            if (i7 >= i3) {
                                this.n0 = (i8 << 16) | i4;
                                return 257;
                            }
                            this.f0 = i7 + 1;
                            iF1 = F1(i5, i10, i8, bArr[i7] & 255);
                        }
                    } else {
                        if (i7 >= i3) {
                            this.n0 = (i8 << 8) | i4;
                            return 257;
                        }
                        int i12 = i7 + 1;
                        this.f0 = i12;
                        int i13 = bArr[i7] & 255;
                        if (i12 >= i3) {
                            this.n0 = (i8 << 8) | i4 | (i13 << 16);
                            return 257;
                        }
                        this.f0 = i12 + 1;
                        iF1 = F1(i4, i8, i13, bArr[i12] & 255);
                    }
                    this.f1584j.z(iF1);
                    this.g = 4;
                    return 4;
                }
                byte[] bArr2 = this.z0;
                int i14 = i2 + 1;
                this.f0 = i14;
                int i15 = bArr2[i2] & 255;
                int i16 = i4 >> 8;
                if (i16 != 0) {
                    iD1 = D1(i5, i16, i15);
                } else {
                    if (i14 >= i3) {
                        this.n0 = (i15 << 8) | i4;
                        return 257;
                    }
                    this.f0 = i14 + 1;
                    iD1 = D1(i4, i15, bArr2[i14] & 255);
                }
                this.f1584j.w((char) iD1);
            }
        }
        if (this.e && !this.f) {
            return H1();
        }
        this.g = 4;
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        return this.g;
    }

    public String toString() {
        return "asyncScanner; curr=" + this.g + " next=" + this.l0 + ", state = " + this.m0;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00d4 A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean x0() throws XMLStreamException {
        int i2;
        if (this.n0 != 0 && !n2()) {
            return false;
        }
        int[] iArr = this.i0.a;
        byte[] bArr = this.z0;
        while (true) {
            int i3 = this.f0;
            int i4 = this.g0;
            if (i3 < i4) {
                while (true) {
                    if (i3 < i4) {
                        int i5 = i3 + 1;
                        int i6 = bArr[i3] & 255;
                        if (iArr[i6] != 0) {
                            this.f0 = i5;
                            switch (iArr[i6]) {
                                case 1:
                                    R(i6);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (bArr[i2] == 10) {
                                            this.f0 = i2 + 1;
                                        }
                                        J0();
                                        break;
                                    } else {
                                        this.n0 = -1;
                                        break;
                                    }
                                case 2:
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                    }
                                    break;
                                case 3:
                                    J0();
                                    break;
                                case 4:
                                    L0(i6);
                                    throw null;
                                case 5:
                                    if (i5 < this.g0) {
                                        o2(i6);
                                        break;
                                    } else {
                                        this.n0 = i6;
                                        break;
                                    }
                                case 6:
                                    int i7 = this.g0;
                                    if (i7 - i5 >= 2) {
                                        C1(i6);
                                        break;
                                    } else {
                                        if (i7 > i5) {
                                            byte[] bArr2 = this.z0;
                                            this.f0 = i5 + 1;
                                            i6 |= (bArr2[i5] & 255) << 8;
                                        }
                                        this.n0 = i6;
                                        break;
                                    }
                                case 7:
                                    int i8 = this.g0;
                                    if (i8 - i5 >= 3) {
                                        E1(i6);
                                        break;
                                    } else {
                                        if (i8 > i5) {
                                            byte[] bArr3 = this.z0;
                                            int i9 = i5 + 1;
                                            this.f0 = i9;
                                            i6 |= (bArr3[i5] & 255) << 8;
                                            if (i8 > i9) {
                                                this.f0 = i9 + 1;
                                                i6 |= (bArr3[i9] & 255) << 16;
                                            }
                                        }
                                        this.n0 = i6;
                                        break;
                                    }
                                case 9:
                                    this.f0 = i5 - 1;
                                    return true;
                                case 10:
                                    if (m2() != 0) {
                                        break;
                                    } else {
                                        this.n0 = -80;
                                        return this.f0 < this.g0 && n2();
                                    }
                                case 11:
                                    byte b = 0;
                                    int i10 = 1;
                                    while (true) {
                                        int i11 = this.f0;
                                        if (i11 < this.g0 && (b = bArr[i11]) == 93) {
                                            this.f0 = i11 + 1;
                                            i10++;
                                        }
                                    }
                                    if (b == 62 && i10 > 1) {
                                        f0();
                                        throw null;
                                    }
                                    break;
                                    break;
                            }
                        } else {
                            i3 = i5;
                        }
                    } else {
                        this.f0 = i3;
                    }
                }
            }
        }
        return false;
    }

    @Override // i.e.a.j.e0
    protected boolean y0() throws XMLStreamException {
        q1();
        throw null;
    }

    protected final boolean y1() throws XMLStreamException {
        int i2 = this.s0;
        do {
            int i3 = this.f0;
            if (i3 >= this.g0) {
                this.s0 = i2;
                return false;
            }
            byte[] bArr = this.z0;
            this.f0 = i3 + 1;
            byte b = bArr[i3];
            if (b == 59) {
                this.s0 = i2;
                return true;
            }
            int i4 = b - 48;
            if (i4 < 0 || i4 > 9) {
                I0(b);
                F0(b, " expected a digit (0 - 9) for character entity");
                throw null;
            }
            i2 = (i2 * 10) + i4;
        } while (i2 <= 1114111);
        this.s0 = i2;
        d0();
        throw null;
    }

    protected final int z1(v vVar) throws XMLStreamException {
        byte[] bArr = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = bArr[i2];
        if (b != 59) {
            I0(b);
            F0(b, " expected ';' following entity name (\"" + vVar.l() + "\")");
            throw null;
        }
        String strL = vVar.l();
        if (strL == "amp") {
            return 38;
        }
        if (strL == "lt") {
            return 60;
        }
        if (strL == "apos") {
            return 39;
        }
        if (strL == "quot") {
            return 34;
        }
        return strL == "gt" ? 62 : 0;
    }
}
