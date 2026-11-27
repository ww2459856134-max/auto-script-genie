package i.e.a.f;

import com.auto.exceldeps.log4j.util.Chars;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import i.e.a.j.k;
import i.e.a.j.l;
import i.e.a.j.r;
import i.e.a.j.v;
import i.e.a.j.z;
import java.nio.ByteBuffer;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public class b extends c {
    protected int A0;
    protected ByteBuffer z0;

    public b(z zVar) {
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
        if (i2 >= this.g0) {
            return false;
        }
        int i3 = this.n0;
        this.n0 = 0;
        if (i3 < 0) {
            if (i3 != -1) {
                q1();
                throw null;
            }
            if (this.z0.get(i2) == 10) {
                this.f0++;
            }
            J0();
            this.f1584j.b('\n');
            return true;
        }
        int i4 = i3 & 255;
        int i5 = this.i0.a[i4];
        if (i5 == 5) {
            this.f1584j.b((char) B1(i3));
        } else if (i5 == 6) {
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i2 + 1;
            int i6 = byteBuffer.get(i2) & 255;
            int i7 = i3 >> 8;
            if (i7 == 0) {
                int i8 = this.f0;
                if (i8 >= this.g0) {
                    this.n0 = (i6 << 8) | i3;
                    return false;
                }
                ByteBuffer byteBuffer2 = this.z0;
                this.f0 = i8 + 1;
                iD1 = D1(i3, i6, byteBuffer2.get(i8) & 255);
            } else {
                iD1 = D1(i4, i7, i6);
            }
            this.f1584j.b((char) iD1);
        } else {
            if (i5 != 7) {
                q1();
                throw null;
            }
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i2 + 1;
            int i9 = byteBuffer3.get(i2) & 255;
            int i10 = i3 >> 8;
            if (i10 == 0) {
                int i11 = this.f0;
                if (i11 >= this.g0) {
                    this.n0 = (i9 << 8) | i3;
                    return false;
                }
                ByteBuffer byteBuffer4 = this.z0;
                this.f0 = i11 + 1;
                int i12 = byteBuffer4.get(i11) & 255;
                int i13 = this.f0;
                if (i13 >= this.g0) {
                    this.n0 = (i9 << 8) | i3 | (i12 << 16);
                    return false;
                }
                ByteBuffer byteBuffer5 = this.z0;
                this.f0 = i13 + 1;
                iF1 = F1(i3, i9, i12, byteBuffer5.get(i13) & 255);
            } else {
                int i14 = i10 & 255;
                int i15 = i3 >> 16;
                if (i15 == 0) {
                    int i16 = this.f0;
                    if (i16 >= this.g0) {
                        this.n0 = (i9 << 16) | i3;
                        return false;
                    }
                    ByteBuffer byteBuffer6 = this.z0;
                    this.f0 = i16 + 1;
                    iF1 = F1(i4, i14, i9, byteBuffer6.get(i16) & 255);
                } else {
                    iF1 = F1(i4, i14, i15, i9);
                }
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
        if (i4 >= this.g0) {
            return false;
        }
        if (i2 == -60) {
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i4 + 1;
            byte b = byteBuffer.get(i4);
            if (b == 35) {
                this.n0 = -61;
                int i5 = this.f0;
                if (i5 >= this.g0) {
                    return false;
                }
                if (this.z0.get(i5) == 120) {
                    this.n0 = -62;
                    int i6 = this.f0 + 1;
                    this.f0 = i6;
                    if (i6 >= this.g0) {
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
            if (this.z0.get(i4) == 120) {
                this.n0 = -62;
                int i7 = this.f0 + 1;
                this.f0 = i7;
                if (i7 >= this.g0) {
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
            int i8 = iR1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (this.w0 >= cArrB2.length) {
                cArrB2 = this.V.s();
            }
            int i9 = this.w0;
            this.w0 = i9 + 1;
            cArrB2[i9] = (char) (55296 | (i8 >> 10));
            iR1 = (i8 & 1023) | 56320;
        }
        if (this.w0 >= cArrB2.length) {
            cArrB2 = this.V.s();
        }
        int i10 = this.w0;
        this.w0 = i10 + 1;
        cArrB2[i10] = (char) iR1;
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
            ByteBuffer byteBuffer = this.z0;
            int i5 = this.f0;
            this.f0 = i5 + 1;
            int i6 = byteBuffer.get(i5) & 255;
            int i7 = i2 >> 8;
            if (i7 != 0) {
                return D1(i3, i7, i6);
            }
            int i8 = this.f0;
            if (i8 >= this.g0) {
                this.n0 = i2 | (i6 << 8);
                return 0;
            }
            ByteBuffer byteBuffer2 = this.z0;
            this.f0 = i8 + 1;
            return D1(i2, i6, byteBuffer2.get(i8) & 255);
        }
        if (i4 != 7) {
            q1();
            throw null;
        }
        ByteBuffer byteBuffer3 = this.z0;
        int i9 = this.f0;
        this.f0 = i9 + 1;
        int i10 = byteBuffer3.get(i9) & 255;
        int i11 = i2 >> 8;
        if (i11 != 0) {
            int i12 = i11 & 255;
            int i13 = i2 >> 16;
            if (i13 != 0) {
                return F1(i3, i12, i13, i10);
            }
            int i14 = this.f0;
            if (i14 >= this.g0) {
                this.n0 = i2 | (i10 << 16);
                return 0;
            }
            ByteBuffer byteBuffer4 = this.z0;
            this.f0 = i14 + 1;
            return F1(i3, i12, i10, byteBuffer4.get(i14) & 255);
        }
        int i15 = this.f0;
        if (i15 >= this.g0) {
            this.n0 = i2 | (i10 << 8);
            return 0;
        }
        ByteBuffer byteBuffer5 = this.z0;
        this.f0 = i15 + 1;
        int i16 = byteBuffer5.get(i15) & 255;
        int i17 = this.f0;
        if (i17 >= this.g0) {
            this.n0 = i2 | (i10 << 8) | (i16 << 16);
            return 0;
        }
        ByteBuffer byteBuffer6 = this.z0;
        this.f0 = i17 + 1;
        return F1(i2, i10, i16, byteBuffer6.get(i17) & 255);
    }

    private int N1() throws XMLStreamException {
        if (this.m0 == 1) {
            return h2();
        }
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return 257;
        }
        ByteBuffer byteBuffer = this.z0;
        this.f0 = i2 + 1;
        return P1(byteBuffer.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c0  */
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
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i3 + 1;
                    b = byteBuffer.get(i3);
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
                ByteBuffer byteBuffer2 = this.z0;
                this.f0 = i4 + 1;
                b = byteBuffer2.get(i4);
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
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i5 + 1;
            b = byteBuffer3.get(i5);
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
            ByteBuffer byteBuffer4 = this.z0;
            this.f0 = i6 + 1;
            b = byteBuffer4.get(i6);
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
        ByteBuffer byteBuffer5 = this.z0;
        this.f0 = i7 + 1;
        b = byteBuffer5.get(i7);
        if (b == 65) {
        }
    }

    private final int R1(boolean z) throws XMLStreamException {
        ByteBuffer byteBuffer = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = byteBuffer.get(i2);
        if (z) {
            if (b < 48 || b > 57) {
                I0(b);
                F0(b, " expected a digit (0 - 9) for character entity");
                throw null;
            }
            this.n0 = -64;
            this.s0 = b - 48;
            int i3 = this.f0;
            if (i3 >= this.g0) {
                return 0;
            }
            ByteBuffer byteBuffer2 = this.z0;
            this.f0 = i3 + 1;
            b = byteBuffer2.get(i3);
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
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i6 + 1;
            b = byteBuffer3.get(i6);
        }
        G0(this.s0);
        this.n0 = 0;
        return this.s0;
    }

    private int T1() throws XMLStreamException {
        int i2;
        int i3 = this.m0;
        if (i3 == 0) {
            v vVar = this.A;
            int iQ = vVar.q() - 1;
            while (this.p0 < iQ) {
                while (this.r0 < 4) {
                    int i4 = this.f0;
                    if (i4 >= this.g0) {
                        return 257;
                    }
                    int i5 = this.q0 << 8;
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i4 + 1;
                    this.q0 = (byteBuffer.get(i4) & 255) | i5;
                    this.r0++;
                }
                if (this.q0 != vVar.m(this.p0)) {
                    u0(vVar.l());
                    throw null;
                }
                this.r0 = 0;
                this.q0 = 0;
                this.p0++;
            }
            int iH = vVar.h();
            do {
                int i6 = this.f0;
                if (i6 >= this.g0) {
                    return 257;
                }
                int i7 = this.q0 << 8;
                ByteBuffer byteBuffer2 = this.z0;
                this.f0 = i6 + 1;
                int i8 = (byteBuffer2.get(i6) & 255) | i7;
                this.q0 = i8;
                if (i8 == iH) {
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
            int i9 = this.f0;
            if (i9 >= this.g0) {
                return 257;
            }
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i9 + 1;
            int i10 = byteBuffer3.get(i9) & 255;
            if (i10 > 32) {
                if (i10 == 62) {
                    this.g = 2;
                    return 2;
                }
                byte b = (byte) i10;
                I0(b);
                F0(b, " expected space or closing '>'");
                throw null;
            }
            if (i10 == 10) {
                J0();
            } else if (i10 == 13) {
                int i11 = this.f0;
                if (i11 >= this.g0) {
                    this.n0 = -1;
                    return 257;
                }
                if (this.z0.get(i11) == 10) {
                    this.f0++;
                }
                J0();
            } else if (i10 != 32 && i10 != 9) {
                D0(i10);
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
        ByteBuffer byteBuffer = this.z0;
        int i2 = iQ - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f0;
            int i5 = (byteBuffer.get(i4 + 3) & 255) | (byteBuffer.get(i4) << 24) | ((byteBuffer.get(i4 + 1) & 255) << 16) | ((byteBuffer.get(i4 + 2) & 255) << 8);
            this.f0 += 4;
            if (i5 != this.A.m(i3)) {
                u0(this.A.l());
                throw null;
            }
        }
        int iM = this.A.m(i2);
        int i6 = this.f0;
        this.f0 = i6 + 1;
        int i7 = byteBuffer.get(i6) & 255;
        if (i7 != iM) {
            int i8 = this.f0;
            this.f0 = i8 + 1;
            int i9 = (i7 << 8) | (byteBuffer.get(i8) & 255);
            if (i9 != iM) {
                int i10 = this.f0;
                this.f0 = i10 + 1;
                int i11 = (i9 << 8) | (byteBuffer.get(i10) & 255);
                if (i11 != iM) {
                    int i12 = this.f0;
                    this.f0 = i12 + 1;
                    if (((byteBuffer.get(i12) & 255) | (i11 << 8)) != iM) {
                        u0(this.A.l());
                        throw null;
                    }
                }
            }
        }
        ByteBuffer byteBuffer2 = this.z0;
        int i13 = this.f0;
        this.f0 = i13 + 1;
        byte b = byteBuffer2.get(i13);
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
                if (this.z0.get(i15) == 10) {
                    this.f0++;
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
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i16 + 1;
            b = byteBuffer3.get(i16);
        }
    }

    private final int Y1(boolean z) throws XMLStreamException {
        int i2;
        int i3;
        int i4;
        int i5;
        ByteBuffer byteBuffer = this.z0;
        int i6 = this.f0;
        this.f0 = i6 + 1;
        byte b = byteBuffer.get(i6);
        if (z) {
            if (b > 57 || b < 48) {
                if (b <= 70 && b >= 65) {
                    i4 = b - 65;
                } else {
                    if (b > 102 || b < 97) {
                        I0(b);
                        F0(b, " expected a hex digit (0-9a-fA-F) for character entity");
                        throw null;
                    }
                    i4 = b - 97;
                }
                i5 = i4 + 10;
            } else {
                i5 = b - 48;
            }
            this.n0 = -65;
            this.s0 = i5;
            int i7 = this.f0;
            if (i7 >= this.g0) {
                return 0;
            }
            ByteBuffer byteBuffer2 = this.z0;
            this.f0 = i7 + 1;
            b = byteBuffer2.get(i7);
        }
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
            int i8 = (this.s0 << 4) + i3;
            this.s0 = i8;
            if (i8 > 1114111) {
                d0();
                throw null;
            }
            int i9 = this.f0;
            if (i9 >= this.g0) {
                return 0;
            }
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i9 + 1;
            b = byteBuffer3.get(i9);
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
        if (i4 >= this.g0) {
            return false;
        }
        if (i2 == -60) {
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i4 + 1;
            byte b = byteBuffer.get(i4);
            if (b == 35) {
                this.n0 = -61;
                int i5 = this.f0;
                if (i5 >= this.g0) {
                    return false;
                }
                if (this.z0.get(i5) == 120) {
                    this.n0 = -62;
                    int i6 = this.f0 + 1;
                    this.f0 = i6;
                    if (i6 >= this.g0) {
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
            if (this.z0.get(i4) == 120) {
                this.n0 = -62;
                int i7 = this.f0 + 1;
                this.f0 = i7;
                if (i7 >= this.g0) {
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
            int i8 = iR1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
            if (this.x0 >= cArrB2.length) {
                cArrB2 = i.e.a.l.c.b(cArrB2, cArrB2.length);
                this.t = cArrB2;
            }
            int i9 = this.x0;
            this.x0 = i9 + 1;
            cArrB2[i9] = (char) (55296 | (i8 >> 10));
            iR1 = (i8 & 1023) | 56320;
        }
        if (this.x0 >= cArrB2.length) {
            cArrB2 = i.e.a.l.c.b(cArrB2, cArrB2.length);
            this.t = cArrB2;
        }
        int i10 = this.x0;
        this.x0 = i10 + 1;
        cArrB2[i10] = (char) iR1;
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
        if (i4 + 3 > this.g0) {
            return 0;
        }
        int i5 = i4 + 1;
        byte b = this.z0.get(i4);
        if (b == 35) {
            return this.z0.get(i5) == 120 ? Z1(i5 + 1) : S1(i5);
        }
        if (b == 97) {
            int i6 = i5 + 1;
            byte b2 = this.z0.get(i5);
            if (b2 == 109) {
                int i7 = i6 + 1;
                if (i7 >= this.g0 || this.z0.get(i6) != 112 || this.z0.get(i7) != 59) {
                    return 0;
                }
                this.f0 = i6 + 2;
                return 38;
            }
            if (b2 != 112 || (i3 = i6 + 2) >= this.g0 || this.z0.get(i6) != 111 || this.z0.get(i6 + 1) != 115 || this.z0.get(i3) != 59) {
                return 0;
            }
            this.f0 = i6 + 3;
            return 39;
        }
        if (b == 103) {
            if (this.z0.get(i5) != 116 || this.z0.get(i5 + 1) != 59) {
                return 0;
            }
            this.f0 = i5 + 2;
            return 62;
        }
        if (b == 108) {
            if (this.z0.get(i5) != 116 || this.z0.get(i5 + 1) != 59) {
                return 0;
            }
            this.f0 = i5 + 2;
            return 60;
        }
        if (b != 113 || (i2 = i5 + 3) >= this.g0 || this.z0.get(i5) != 117 || this.z0.get(i5 + 1) != 111 || this.z0.get(i5 + 2) != 116 || this.z0.get(i2) != 59) {
            return 0;
        }
        this.f0 = i5 + 4;
        return 34;
    }

    private final boolean n2() throws XMLStreamException {
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return false;
        }
        int i3 = this.n0;
        if (i3 >= 0) {
            int i4 = i3 & 255;
            int i5 = this.i0.a[i4];
            if (i5 == 5) {
                o2(i3);
            } else if (i5 == 6) {
                ByteBuffer byteBuffer = this.z0;
                this.f0 = i2 + 1;
                int i6 = byteBuffer.get(i2) & 255;
                int i7 = i3 >> 8;
                if (i7 == 0) {
                    int i8 = this.f0;
                    if (i8 >= this.g0) {
                        this.n0 = (i6 << 8) | i3;
                        return false;
                    }
                    ByteBuffer byteBuffer2 = this.z0;
                    this.f0 = i8 + 1;
                    D1(i3, i6, byteBuffer2.get(i8) & 255);
                } else {
                    D1(i4, i7, i6);
                }
            } else {
                if (i5 != 7) {
                    q1();
                    throw null;
                }
                ByteBuffer byteBuffer3 = this.z0;
                this.f0 = i2 + 1;
                int i9 = byteBuffer3.get(i2) & 255;
                int i10 = i3 >> 8;
                if (i10 == 0) {
                    int i11 = this.f0;
                    if (i11 >= this.g0) {
                        this.n0 = (i9 << 8) | i3;
                        return false;
                    }
                    ByteBuffer byteBuffer4 = this.z0;
                    this.f0 = i11 + 1;
                    int i12 = byteBuffer4.get(i11) & 255;
                    int i13 = this.f0;
                    if (i13 >= this.g0) {
                        this.n0 = (i9 << 8) | i3 | (i12 << 16);
                        return false;
                    }
                    ByteBuffer byteBuffer5 = this.z0;
                    this.f0 = i13 + 1;
                    F1(i3, i9, i12, byteBuffer5.get(i13) & 255);
                } else {
                    int i14 = i10 & 255;
                    int i15 = i3 >> 16;
                    if (i15 == 0) {
                        int i16 = this.f0;
                        if (i16 >= this.g0) {
                            this.n0 = (i9 << 16) | i3;
                            return false;
                        }
                        ByteBuffer byteBuffer6 = this.z0;
                        this.f0 = i16 + 1;
                        F1(i4, i14, i9, byteBuffer6.get(i16) & 255);
                    } else {
                        F1(i4, i14, i15, i9);
                    }
                }
            }
            this.n0 = 0;
            return true;
        }
        do {
            int i17 = this.n0;
            if (i17 == -1) {
                this.n0 = 0;
                if (this.z0.get(this.f0) == 10) {
                    this.f0++;
                }
                J0();
                return true;
            }
            switch (i17) {
                case -86:
                    byte b = this.z0.get(this.f0);
                    if (b != 93) {
                        if (b != 62) {
                            this.n0 = 0;
                            return true;
                        }
                        this.f0++;
                        i0("Encountered ']]>' in text segment");
                        throw null;
                    }
                    this.f0++;
                    break;
                case -85:
                    if (this.z0.get(this.f0) == 93) {
                        this.f0++;
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
                    if (this.z0.get(this.f0) != 120) {
                        if (y1()) {
                            this.n0 = 0;
                            return true;
                        }
                        this.n0 = -82;
                        return false;
                    }
                    this.f0++;
                    if (A1()) {
                        this.n0 = 0;
                        return true;
                    }
                    this.n0 = -83;
                    return false;
                case -80:
                    ByteBuffer byteBuffer7 = this.z0;
                    int i18 = this.f0;
                    this.f0 = i18 + 1;
                    byte b2 = byteBuffer7.get(i18);
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
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i5 + 1;
            byte b = byteBuffer.get(i5);
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
        ByteBuffer byteBuffer = this.z0;
        int i3 = this.f0;
        this.f0 = i3 + 1;
        byte b = byteBuffer.get(i3);
        if ((b & 192) == 128) {
            return ((i2 & 31) << 6) | (b & 63);
        }
        o1(b & 255, this.f0);
        throw null;
    }

    protected final int C1(int i2) throws XMLStreamException {
        int i3 = i2 & 15;
        ByteBuffer byteBuffer = this.z0;
        int i4 = this.f0;
        this.f0 = i4 + 1;
        byte b = byteBuffer.get(i4);
        if ((b & 192) != 128) {
            o1(b & 255, this.f0);
            throw null;
        }
        int i5 = (b & 63) | (i3 << 6);
        ByteBuffer byteBuffer2 = this.z0;
        int i6 = this.f0;
        this.f0 = i6 + 1;
        byte b2 = byteBuffer2.get(i6);
        if ((b2 & 192) == 128) {
            int i7 = (i5 << 6) | (b2 & 63);
            return (i3 < 13 || i7 < 55296) ? i7 : (i7 < 57344 || (i7 >= 65534 && i7 <= 65535)) ? R(i7) : i7;
        }
        o1(b2 & 255, this.f0);
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
        ByteBuffer byteBuffer = this.z0;
        int i3 = this.f0;
        this.f0 = i3 + 1;
        byte b = byteBuffer.get(i3);
        if ((b & 192) != 128) {
            o1(b & 255, this.f0);
            throw null;
        }
        int i4 = ((i2 & 7) << 6) | (b & 63);
        ByteBuffer byteBuffer2 = this.z0;
        int i5 = this.f0;
        this.f0 = i5 + 1;
        byte b2 = byteBuffer2.get(i5);
        if ((b2 & 192) != 128) {
            o1(b2 & 255, this.f0);
            throw null;
        }
        int i6 = (i4 << 6) | (b2 & 63);
        ByteBuffer byteBuffer3 = this.z0;
        int i7 = this.f0;
        this.f0 = i7 + 1;
        byte b3 = byteBuffer3.get(i7);
        if ((b3 & 192) == 128) {
            return ((i6 << 6) | (b3 & 63)) - WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        o1(b3 & 255, this.f0);
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

    public void G1(ByteBuffer byteBuffer) throws XMLStreamException {
        if (this.f0 < this.g0) {
            throw new XMLStreamException("Still have " + (this.g0 - this.f0) + " unread bytes");
        }
        if (this.o0) {
            throw new XMLStreamException("Already closed, can not feed more input");
        }
        long j2 = this.Z;
        int i2 = this.A0;
        this.Z = j2 + i2;
        this.b0 -= i2;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        this.z0 = byteBuffer;
        this.f0 = iPosition;
        this.g0 = iLimit;
        this.A0 = iLimit - iPosition;
    }

    protected final int H1() throws XMLStreamException {
        if (this.n0 == 0 || J1()) {
            throw new UnsupportedOperationException();
        }
        return 257;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0123 A[SYNTHETIC] */
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
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i4 + 1;
                    int iB1 = byteBuffer.get(i4) & 255;
                    if (iArr[iB1] != 0) {
                        int i5 = iArr[iB1];
                        if (i5 != 14) {
                            switch (i5) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (this.z0.get(i2) == 10) {
                                            this.f0++;
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
                                    if (this.f0 < this.g0) {
                                        iB1 = B1(iB1);
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 6:
                                    int i6 = this.g0;
                                    int i7 = this.f0;
                                    if (i6 - i7 >= 2) {
                                        iB1 = C1(iB1);
                                        break;
                                    } else {
                                        if (i6 > i7) {
                                            ByteBuffer byteBuffer2 = this.z0;
                                            this.f0 = i7 + 1;
                                            iB1 |= (byteBuffer2.get(i7) & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 7:
                                    int i8 = this.g0;
                                    int i9 = this.f0;
                                    if (i8 - i9 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i10 = this.w0;
                                        int i11 = i10 + 1;
                                        this.w0 = i11;
                                        cArrB[i10] = (char) (55296 | (iE1 >> 10));
                                        iB1 = (iE1 & 1023) | 56320;
                                        if (i11 >= cArrB.length) {
                                            cArrB = this.V.s();
                                            break;
                                        }
                                    } else {
                                        if (i8 > i9) {
                                            ByteBuffer byteBuffer3 = this.z0;
                                            this.f0 = i9 + 1;
                                            iB1 |= (byteBuffer3.get(i9) & 255) << 8;
                                            int i12 = this.g0;
                                            int i13 = this.f0;
                                            if (i12 > i13) {
                                                ByteBuffer byteBuffer4 = this.z0;
                                                this.f0 = i13 + 1;
                                                iB1 |= (byteBuffer4.get(i13) & 255) << 16;
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
                                            int i14 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                            int i15 = this.w0;
                                            int i16 = i15 + 1;
                                            this.w0 = i16;
                                            cArrB[i15] = (char) (55296 | (i14 >> 10));
                                            iB1 = (i14 & 1023) | 56320;
                                            if (i16 >= cArrB.length) {
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
                        int i17 = this.w0;
                        this.w0 = i17 + 1;
                        cArrB[i17] = (char) iB1;
                    } else {
                        int i18 = this.w0;
                        this.w0 = i18 + 1;
                        cArrB[i18] = (char) iB1;
                    }
                }
            }
        }
        return false;
    }

    protected final int O1() throws XMLStreamException {
        if (this.n0 == -30) {
            int i2 = this.f0;
            if (i2 >= this.g0) {
                return 257;
            }
            if (this.z0.get(i2) != 93) {
                this.f1584j.b(']');
                this.n0 = 0;
                return 0;
            }
            int i3 = this.f0 + 1;
            this.f0 = i3;
            this.n0 = -31;
            if (i3 >= this.g0) {
                return 257;
            }
        }
        while (this.n0 == -31) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                return 257;
            }
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i4 + 1;
            byte b = byteBuffer.get(i4);
            if (b == 62) {
                this.n0 = 0;
                this.m0 = 0;
                this.l0 = 257;
                return 12;
            }
            if (b != 93) {
                this.f0--;
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
        return this.z0.get(this.f0);
    }

    protected int Q1() throws XMLStreamException {
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return 257;
        }
        if (this.n0 == -20) {
            if (this.z0.get(i2) != 45) {
                this.n0 = 0;
                this.f1584j.c(ProcessIdUtil.DEFAULT_PROCESSID);
                return 0;
            }
            int i3 = this.f0 + 1;
            this.f0 = i3;
            this.n0 = -21;
            if (i3 >= this.g0) {
                return 257;
            }
        }
        if (this.n0 != -21) {
            return J1() ? 0 : 257;
        }
        this.n0 = 0;
        ByteBuffer byteBuffer = this.z0;
        int i4 = this.f0;
        this.f0 = i4 + 1;
        if (byteBuffer.get(i4) != 62) {
            b0();
            throw null;
        }
        this.m0 = 0;
        this.l0 = 257;
        return 5;
    }

    @Override // i.e.a.f.c
    protected final byte R0() throws XMLStreamException {
        ByteBuffer byteBuffer = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        return byteBuffer.get(i2);
    }

    protected int S1(int i2) throws XMLStreamException {
        int i3 = i2 + 1;
        byte b = this.z0.get(i2);
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
            b = this.z0.get(i3);
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
        return this.z0.get(this.f0 - 1);
    }

    protected int V1() throws XMLStreamException {
        int iR1;
        int i2 = this.f0;
        if (i2 >= this.g0) {
            this.n0 = -60;
            return -1;
        }
        ByteBuffer byteBuffer = this.z0;
        this.f0 = i2 + 1;
        byte b = byteBuffer.get(i2);
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
        int i3 = this.f0;
        if (i3 >= this.g0) {
            return -1;
        }
        if (this.z0.get(i3) == 120) {
            this.n0 = -62;
            int i4 = this.f0 + 1;
            this.f0 = i4;
            if (i4 >= this.g0) {
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
        if (i4 + 3 > this.g0) {
            return 0;
        }
        int i5 = i4 + 1;
        byte b = this.z0.get(i4);
        if (b == 35) {
            return this.z0.get(i5) == 120 ? Z1(i5 + 1) : S1(i5);
        }
        if (b == 97) {
            int i6 = i5 + 1;
            byte b2 = this.z0.get(i5);
            if (b2 == 109) {
                int i7 = i6 + 1;
                if (i7 >= this.g0 || this.z0.get(i6) != 112 || this.z0.get(i7) != 59) {
                    return 0;
                }
                this.f0 = i6 + 2;
                return 38;
            }
            if (b2 != 112 || (i3 = i6 + 2) >= this.g0 || this.z0.get(i6) != 111 || this.z0.get(i6 + 1) != 115 || this.z0.get(i3) != 59) {
                return 0;
            }
            this.f0 = i6 + 3;
            return 39;
        }
        if (b == 103) {
            if (this.z0.get(i5) != 116 || this.z0.get(i5 + 1) != 59) {
                return 0;
            }
            this.f0 = i5 + 2;
            return 62;
        }
        if (b == 108) {
            if (this.z0.get(i5) != 116 || this.z0.get(i5 + 1) != 59) {
                return 0;
            }
            this.f0 = i5 + 2;
            return 60;
        }
        if (b != 113 || (i2 = i5 + 3) >= this.g0 || this.z0.get(i5) != 117 || this.z0.get(i5 + 1) != 111 || this.z0.get(i5 + 2) != 116 || this.z0.get(i2) != 59) {
            return 0;
        }
        this.f0 = i5 + 4;
        return 34;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        return false;
     */
    @Override // i.e.a.f.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean X0() throws XMLStreamException {
        while (true) {
            int i2 = this.f0;
            if (i2 >= this.g0) {
                break;
            }
            byte b = this.z0.get(i2);
            if ((b & 255) > 32) {
                if (this.n0 == -1) {
                    J0();
                    this.n0 = 0;
                }
                return true;
            }
            int i3 = this.f0 + 1;
            this.f0 = i3;
            if (b == 10) {
                J0();
            } else if (b == 13) {
                if (i3 >= this.g0) {
                    this.n0 = -1;
                    break;
                }
                if (this.z0.get(i3) == 10) {
                    this.f0++;
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
        ByteBuffer byteBuffer = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = byteBuffer.get(i2);
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        I0(r7);
        F0(r7, " expected a hex digit (0-9a-fA-F) for character entity");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int Z1(int i2) throws XMLStreamException {
        int i3;
        int i4;
        int i5 = i2 + 1;
        byte b = this.z0.get(i2);
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
            b = this.z0.get(i5);
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
                ByteBuffer byteBuffer = this.z0;
                this.f0 = i3 + 1;
                byte b = byteBuffer.get(i3);
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
            if (i4 >= this.g0) {
                return this.g;
            }
            int i5 = this.m0;
            if (i5 == 1) {
                ByteBuffer byteBuffer2 = this.z0;
                this.f0 = i4 + 1;
                byte b2 = byteBuffer2.get(i4);
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
                if (i5 == 2) {
                    return X1();
                }
                if (i5 == 6) {
                    return a2();
                }
                if (i5 == 5) {
                    return d2();
                }
            }
            if (this.m0 != 3) {
                q1();
                throw null;
            }
            int i6 = this.f0;
            if (i6 >= this.g0) {
                return this.g;
            }
            ByteBuffer byteBuffer3 = this.z0;
            this.f0 = i6 + 1;
            byte b3 = byteBuffer3.get(i6);
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
        int i7 = this.l0;
        if (i7 == 1) {
            return h1();
        }
        if (i7 == 2) {
            return T1();
        }
        if (i7 == 3) {
            return e1();
        }
        if (i7 != 4) {
            if (i7 == 5) {
                return b1();
            }
            if (i7 == 12) {
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
        if (this.m0 == 1) {
            return i2();
        }
        int i2 = this.f0;
        if (i2 >= this.g0) {
            return 257;
        }
        ByteBuffer byteBuffer = this.z0;
        this.f0 = i2 + 1;
        byte b = byteBuffer.get(i2);
        int i3 = this.m0;
        if (i3 == 0) {
            if (b == 45) {
                this.m0 = 1;
                this.f1584j.x();
                return i2();
            }
            I0(b);
            r0(b, " (expected '-' for COMMENT)");
            throw null;
        }
        if (i3 != 3) {
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
    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0123 A[SYNTHETIC] */
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
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i4 + 1;
                    int iB1 = byteBuffer.get(i4) & 255;
                    if (iArr[iB1] != 0) {
                        int i5 = iArr[iB1];
                        if (i5 != 14) {
                            switch (i5) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (this.z0.get(i2) == 10) {
                                            this.f0++;
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
                                    if (this.f0 < this.g0) {
                                        iB1 = B1(iB1);
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 6:
                                    int i6 = this.g0;
                                    int i7 = this.f0;
                                    if (i6 - i7 >= 2) {
                                        iB1 = C1(iB1);
                                        break;
                                    } else {
                                        if (i6 > i7) {
                                            ByteBuffer byteBuffer2 = this.z0;
                                            this.f0 = i7 + 1;
                                            iB1 |= (byteBuffer2.get(i7) & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        return false;
                                    }
                                case 7:
                                    int i8 = this.g0;
                                    int i9 = this.f0;
                                    if (i8 - i9 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i10 = this.x0;
                                        int i11 = i10 + 1;
                                        this.x0 = i11;
                                        cArrB[i10] = (char) (55296 | (iE1 >> 10));
                                        iB1 = (iE1 & 1023) | 56320;
                                        if (i11 >= cArrB.length) {
                                            cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                                            this.t = cArrB;
                                            break;
                                        }
                                    } else {
                                        if (i8 > i9) {
                                            ByteBuffer byteBuffer3 = this.z0;
                                            this.f0 = i9 + 1;
                                            iB1 |= (byteBuffer3.get(i9) & 255) << 8;
                                            int i12 = this.g0;
                                            int i13 = this.f0;
                                            if (i12 > i13) {
                                                ByteBuffer byteBuffer4 = this.z0;
                                                this.f0 = i13 + 1;
                                                iB1 |= (byteBuffer4.get(i13) & 255) << 16;
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
                                            int i14 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                            int i15 = this.x0;
                                            int i16 = i15 + 1;
                                            this.x0 = i16;
                                            cArrB[i15] = (char) (55296 | (i14 >> 10));
                                            iB1 = (i14 & 1023) | 56320;
                                            if (i16 >= cArrB.length) {
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
                            int i17 = this.x0;
                            if (i17 == 0) {
                                e(this.v0, "");
                            } else {
                                e(this.v0, this.c.l(cArrB, i17));
                            }
                            return true;
                        }
                        int i18 = this.x0;
                        this.x0 = i18 + 1;
                        cArrB[i18] = (char) iB1;
                    } else {
                        int i19 = this.x0;
                        this.x0 = i19 + 1;
                        cArrB[i19] = (char) iB1;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
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
                        this.f0 = i4 + 1;
                        int iB1 = byteBuffer.get(i4) & 255;
                        if (iArr[iB1] != 0) {
                            switch (iArr[iB1]) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (byteBuffer.get(i2) == 10) {
                                            this.f0++;
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
                                    if (this.f0 < this.g0) {
                                        iB1 = B1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 6:
                                    int i5 = this.g0;
                                    int i6 = this.f0;
                                    if (i5 - i6 >= 2) {
                                        iB1 = C1(iB1);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i5 > i6) {
                                            ByteBuffer byteBuffer2 = this.z0;
                                            this.f0 = i6 + 1;
                                            iB1 |= (byteBuffer2.get(i6) & 255) << 8;
                                        }
                                        this.n0 = iB1;
                                        break;
                                    }
                                case 7:
                                    int i7 = this.g0;
                                    int i8 = this.f0;
                                    if (i7 - i8 >= 3) {
                                        int iE1 = E1(iB1);
                                        int i9 = iP + 1;
                                        cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                        if (i9 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                            iP = 0;
                                        } else {
                                            iP = i9;
                                        }
                                        iB1 = 56320 | (iE1 & 1023);
                                        cArrO[iP] = (char) iB1;
                                        iP++;
                                        break;
                                    } else {
                                        if (i7 > i8) {
                                            ByteBuffer byteBuffer3 = this.z0;
                                            this.f0 = i8 + 1;
                                            iB1 |= (byteBuffer3.get(i8) & 255) << 8;
                                            int i10 = this.g0;
                                            int i11 = this.f0;
                                            if (i10 > i11) {
                                                ByteBuffer byteBuffer4 = this.z0;
                                                this.f0 = i11 + 1;
                                                iB1 |= (byteBuffer4.get(i11) & 255) << 16;
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
            byte b = this.z0.get(this.f0);
            this.s0 = 0;
            if (b == 120) {
                this.n0 = -73;
                int i2 = this.f0 + 1;
                this.f0 = i2;
                if (i2 >= this.g0) {
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
                ByteBuffer byteBuffer = this.z0;
                this.f0 = i2 + 1;
                v vVarL1 = l1(byteBuffer.get(i2));
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
                    ByteBuffer byteBuffer2 = this.z0;
                    this.f0 = i2 + 1;
                    byte b = byteBuffer2.get(i2);
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
            ByteBuffer byteBuffer3 = this.z0;
            int i4 = this.f0;
            this.f0 = i4 + 1;
            byte b2 = byteBuffer3.get(i4);
            if (b2 == 63) {
                int i5 = this.f0;
                if (i5 < this.g0 && this.z0.get(i5) == 62) {
                    this.f0++;
                    break;
                }
                this.m0 = 3;
            } else {
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
                if (i6 + 1 >= this.g0 || this.z0.get(i6) != 63 || this.z0.get(this.f0 + 1) != 62) {
                    this.m0 = 5;
                    return l2();
                }
                this.f0 += 2;
            }
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
        byte b = this.z0.get(i2);
        this.n0 = 0;
        if (b != 62) {
            this.f1584j.b('?');
            return 0;
        }
        this.f0++;
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
        if (this.z0.get(i2) == 10) {
            this.f0++;
        }
        this.a0++;
        this.b0 = this.f0;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e5  */
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
                        ByteBuffer byteBuffer = this.z0;
                        int i5 = this.f0;
                        this.f0 = i5 + 1;
                        byte b2 = byteBuffer.get(i5);
                        int i6 = b2 & 255;
                        if (i6 <= 32) {
                            if (i6 == 10) {
                                J0();
                            } else if (i6 == 13) {
                                int i7 = this.f0;
                                if (i7 >= this.g0) {
                                    this.n0 = -1;
                                    return 257;
                                }
                                if (this.z0.get(i7) == 10) {
                                    this.f0++;
                                }
                                J0();
                            } else if (i6 != 32 && i6 != 9) {
                                D0(i6);
                                throw null;
                            }
                        } else {
                            if (i6 == 62) {
                                return I1(false);
                            }
                            if (i6 != 47) {
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
                    ByteBuffer byteBuffer2 = this.z0;
                    int i8 = this.f0;
                    this.f0 = i8 + 1;
                    b = byteBuffer2.get(i8);
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
                                if (this.z0.get(i9) == 10) {
                                    this.f0++;
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
                            ByteBuffer byteBuffer3 = this.z0;
                            this.f0 = i3 + 1;
                            b = byteBuffer3.get(i3);
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
                    ByteBuffer byteBuffer22 = this.z0;
                    int i82 = this.f0;
                    this.f0 = i82 + 1;
                    b = byteBuffer22.get(i82);
                    while (true) {
                        i2 = b & 255;
                        if (i2 <= 32) {
                        }
                        ByteBuffer byteBuffer32 = this.z0;
                        this.f0 = i3 + 1;
                        b = byteBuffer32.get(i3);
                    }
                    break;
                case 3:
                case 5:
                case 6:
                    if (this.n0 == 0) {
                    }
                    ByteBuffer byteBuffer222 = this.z0;
                    int i822 = this.f0;
                    this.f0 = i822 + 1;
                    b = byteBuffer222.get(i822);
                    while (true) {
                        i2 = b & 255;
                        if (i2 <= 32) {
                        }
                        ByteBuffer byteBuffer322 = this.z0;
                        this.f0 = i3 + 1;
                        b = byteBuffer322.get(i3);
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
                    ByteBuffer byteBuffer4 = this.z0;
                    this.f0 = i4 + 1;
                    byte b3 = byteBuffer4.get(i4);
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
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0132, code lost:
    
        r11.f1584j.A(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0137, code lost:
    
        return 257;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
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
                        this.f0 = i5 + 1;
                        int iB1 = byteBuffer.get(i5) & 255;
                        if (iArr[iB1] != 0) {
                            int i6 = iArr[iB1];
                            if (i6 != 11) {
                                switch (i6) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (byteBuffer.get(i2) == 10) {
                                                this.f0++;
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
                                        if (this.f0 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i7 = this.g0;
                                        int i8 = this.f0;
                                        if (i7 - i8 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i7 > i8) {
                                                ByteBuffer byteBuffer2 = this.z0;
                                                this.f0 = i8 + 1;
                                                iB1 |= (byteBuffer2.get(i8) & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        int i10 = this.f0;
                                        if (i9 - i10 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i11 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i11 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i11;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i10) {
                                                ByteBuffer byteBuffer3 = this.z0;
                                                this.f0 = i10 + 1;
                                                iB1 |= (byteBuffer3.get(i10) & 255) << 8;
                                                int i12 = this.g0;
                                                int i13 = this.f0;
                                                if (i12 > i13) {
                                                    ByteBuffer byteBuffer4 = this.z0;
                                                    this.f0 = i13 + 1;
                                                    iB1 |= (byteBuffer4.get(i13) & 255) << 16;
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
                                int i14 = this.f0;
                                if (i14 >= this.g0) {
                                    this.n0 = -30;
                                } else if (this.z0.get(i14) == 93) {
                                    this.f0++;
                                    while (true) {
                                        int i15 = this.f0;
                                        if (i15 >= this.g0) {
                                            this.n0 = -31;
                                        } else {
                                            if (this.z0.get(i15) == 62) {
                                                this.f0++;
                                                this.f1584j.A(iP);
                                                this.m0 = 0;
                                                this.l0 = 257;
                                                return 12;
                                            }
                                            if (this.z0.get(this.f0) != 93) {
                                                int i16 = iP + 1;
                                                cArrO[iP] = ']';
                                                if (i16 >= cArrO.length) {
                                                    cArrO = this.f1584j.n();
                                                } else {
                                                    i3 = i16;
                                                }
                                                iP = i3 + 1;
                                                cArrO[i3] = ']';
                                            } else {
                                                this.f0++;
                                                int i17 = iP + 1;
                                                cArrO[iP] = ']';
                                                if (i17 >= cArrO.length) {
                                                    cArrO = this.f1584j.n();
                                                    iP = 0;
                                                } else {
                                                    iP = i17;
                                                }
                                            }
                                        }
                                    }
                                } else {
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
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f5 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
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
                        this.f0 = i5 + 1;
                        int iB1 = byteBuffer.get(i5) & 255;
                        if (iArr[iB1] != 0) {
                            int i6 = iArr[iB1];
                            if (i6 != 13) {
                                switch (i6) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (byteBuffer.get(i2) == 10) {
                                                this.f0++;
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
                                        if (this.f0 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i7 = this.g0;
                                        int i8 = this.f0;
                                        if (i7 - i8 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i7 > i8) {
                                                ByteBuffer byteBuffer2 = this.z0;
                                                this.f0 = i8 + 1;
                                                iB1 |= (byteBuffer2.get(i8) & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        int i10 = this.f0;
                                        if (i9 - i10 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i11 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i11 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i11;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i10) {
                                                ByteBuffer byteBuffer3 = this.z0;
                                                this.f0 = i10 + 1;
                                                iB1 |= (byteBuffer3.get(i10) & 255) << 8;
                                                int i12 = this.g0;
                                                int i13 = this.f0;
                                                if (i12 > i13) {
                                                    ByteBuffer byteBuffer4 = this.z0;
                                                    this.f0 = i13 + 1;
                                                    iB1 |= (byteBuffer4.get(i13) & 255) << 16;
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
                                int i14 = this.f0;
                                if (i14 >= this.g0) {
                                    this.n0 = -20;
                                } else {
                                    if (this.z0.get(i14) == 45) {
                                        int i15 = this.f0 + 1;
                                        this.f0 = i15;
                                        if (i15 < this.g0) {
                                            ByteBuffer byteBuffer5 = this.z0;
                                            this.f0 = i15 + 1;
                                            if (byteBuffer5.get(i15) != 62) {
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r13.p0 != 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r0 = r13.k0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if (r0 != i.e.a.j.l.g) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r13.f0--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        return i.e.a.j.l.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (r0 != i.e.a.j.l.f1599j) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r13.f0--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        return i.e.a.j.l.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return Z0(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:
    
        return Z0(r0, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e6, code lost:
    
        if (r13.p0 != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ea, code lost:
    
        if (r0 != i.e.a.j.l.f) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ec, code lost:
    
        r13.f0--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f3, code lost:
    
        return i.e.a.j.l.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f8, code lost:
    
        return Z0(r0, 3);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00cb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v j2() throws XMLStreamException {
        int i2;
        int i3;
        int i4;
        int i5 = this.q0;
        while (true) {
            int i6 = this.r0;
            if (i6 == 0) {
                int i7 = this.f0;
                if (i7 < this.g0) {
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i7 + 1;
                    i5 = byteBuffer.get(i7) & 255;
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
                        ByteBuffer byteBuffer2 = this.z0;
                        this.f0 = i4 + 1;
                        int i9 = byteBuffer2.get(i4) & 255;
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
                    ByteBuffer byteBuffer3 = this.z0;
                    this.f0 = i2 + 1;
                    int i10 = byteBuffer3.get(i2) & 255;
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
                ByteBuffer byteBuffer4 = this.z0;
                this.f0 = i11 + 1;
                int i12 = byteBuffer4.get(i11) & 255;
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
        if (this.p0 == 0) {
            if (i5 == l.f1597h) {
                this.f0--;
                return l.c;
            }
            if (i5 == l.f1598i) {
                this.f0--;
                return l.d;
            }
        }
        return Z0(i5, 2);
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
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f4 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
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
                        this.f0 = i5 + 1;
                        int iB1 = byteBuffer.get(i5) & 255;
                        if (iArr[iB1] != 0) {
                            int i6 = iArr[iB1];
                            if (i6 != 12) {
                                switch (i6) {
                                    case 1:
                                        R(iB1);
                                        i2 = this.f0;
                                        if (i2 >= this.g0) {
                                            if (byteBuffer.get(i2) == 10) {
                                                this.f0++;
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
                                        if (this.f0 < this.g0) {
                                            iB1 = B1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 6:
                                        int i7 = this.g0;
                                        int i8 = this.f0;
                                        if (i7 - i8 >= 2) {
                                            iB1 = C1(iB1);
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i7 > i8) {
                                                ByteBuffer byteBuffer2 = this.z0;
                                                this.f0 = i8 + 1;
                                                iB1 |= (byteBuffer2.get(i8) & 255) << 8;
                                            }
                                            this.n0 = iB1;
                                            break;
                                        }
                                    case 7:
                                        int i9 = this.g0;
                                        int i10 = this.f0;
                                        if (i9 - i10 >= 3) {
                                            int iE1 = E1(iB1);
                                            int i11 = iP + 1;
                                            cArrO[iP] = (char) (55296 | (iE1 >> 10));
                                            if (i11 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                            } else {
                                                i3 = i11;
                                            }
                                            iB1 = (iE1 & 1023) | 56320;
                                            iP = i3;
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
                                            if (i9 > i10) {
                                                ByteBuffer byteBuffer3 = this.z0;
                                                this.f0 = i10 + 1;
                                                iB1 |= (byteBuffer3.get(i10) & 255) << 8;
                                                int i12 = this.g0;
                                                int i13 = this.f0;
                                                if (i12 > i13) {
                                                    ByteBuffer byteBuffer4 = this.z0;
                                                    this.f0 = i13 + 1;
                                                    iB1 |= (byteBuffer4.get(i13) & 255) << 16;
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
                                int i14 = this.f0;
                                if (i14 >= this.g0) {
                                    this.n0 = -15;
                                } else {
                                    if (this.z0.get(i14) == 62) {
                                        this.f0++;
                                        this.f1584j.A(iP);
                                        this.m0 = 0;
                                        this.l0 = 257;
                                        return 3;
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        return Z0(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        return Z0(r0, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        return Z0(r0, 2);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x008f A[SYNTHETIC] */
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
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i7 + 1;
                    i5 = byteBuffer.get(i7) & 255;
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
                        ByteBuffer byteBuffer2 = this.z0;
                        this.f0 = i4 + 1;
                        int i9 = byteBuffer2.get(i4) & 255;
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
                    ByteBuffer byteBuffer3 = this.z0;
                    this.f0 = i2 + 1;
                    int i10 = byteBuffer3.get(i2) & 255;
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
                ByteBuffer byteBuffer4 = this.z0;
                this.f0 = i11 + 1;
                int i12 = byteBuffer4.get(i11) & 255;
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
        ByteBuffer byteBuffer = this.z0;
        int i3 = this.f0;
        this.f0 = i3 + 1;
        byte b = byteBuffer.get(i3);
        if ((b & 192) == 128) {
            return;
        }
        o1(b & 255, this.f0);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fc A[PHI: r5 r6
      0x00fc: PHI (r5v19 int) = (r5v18 int), (r5v23 int) binds: [B:56:0x00f3, B:45:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r6v11 int) = (r6v10 int), (r6v14 int) binds: [B:56:0x00f3, B:45:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0140 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
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
                        int iB1 = byteBuffer.get(i4) & 255;
                        if (iArr[iB1] != 0) {
                            this.f0 = i7;
                            switch (iArr[iB1]) {
                                case 1:
                                    R(iB1);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (byteBuffer.get(i2) == 10) {
                                            this.f0++;
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
                                            ByteBuffer byteBuffer2 = this.z0;
                                            this.f0 = i7 + 1;
                                            iB1 |= (byteBuffer2.get(i7) & 255) << 8;
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
                                            ByteBuffer byteBuffer3 = this.z0;
                                            this.f0 = i7 + 1;
                                            iB1 |= (byteBuffer3.get(i7) & 255) << 8;
                                            int i10 = this.g0;
                                            int i11 = this.f0;
                                            if (i10 > i11) {
                                                ByteBuffer byteBuffer4 = this.z0;
                                                this.f0 = i11 + 1;
                                                iB1 |= (byteBuffer4.get(i11) & 255) << 16;
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
                                    int i12 = 1;
                                    while (true) {
                                        int i13 = this.f0;
                                        if (i13 < this.g0 && (b = byteBuffer.get(i13)) == 93) {
                                            this.f0++;
                                            i12++;
                                        }
                                    }
                                    if (b == 62 && i12 > 1) {
                                        f0();
                                        throw null;
                                    }
                                    while (true) {
                                        i12--;
                                        if (i12 <= 0) {
                                            cArrO[iP] = (char) iB1;
                                            iP++;
                                            break;
                                        } else {
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
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
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
                if (this.z0.get(i2) == 10) {
                    this.f0++;
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
                        ByteBuffer byteBuffer = this.z0;
                        this.f0 = i4 + 1;
                        iB1 |= (byteBuffer.get(i4) & 255) << 8;
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
                    ByteBuffer byteBuffer2 = this.z0;
                    this.f0 = i6 + 1;
                    iB1 |= (byteBuffer2.get(i6) & 255) << 8;
                    int i7 = this.g0;
                    int i8 = this.f0;
                    if (i7 > i8) {
                        ByteBuffer byteBuffer3 = this.z0;
                        this.f0 = i8 + 1;
                        iB1 |= (byteBuffer3.get(i8) & 255) << 16;
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
        if (i2 >= this.g0) {
            return 257;
        }
        int i3 = this.n0;
        this.n0 = 0;
        if (i3 == -1) {
            if (this.z0.get(i2) == 10) {
                this.f0++;
            }
            J0();
            this.f1584j.w('\n');
        } else {
            int i4 = i3 & 255;
            int i5 = this.i0.a[i4];
            if (i5 == 5) {
                this.f1584j.w((char) B1(i3));
            } else {
                if (i5 != 6) {
                    if (i5 != 7) {
                        q1();
                        throw null;
                    }
                    ByteBuffer byteBuffer = this.z0;
                    this.f0 = i2 + 1;
                    int i6 = byteBuffer.get(i2) & 255;
                    int i7 = i3 >> 8;
                    if (i7 == 0) {
                        int i8 = this.f0;
                        if (i8 >= this.g0) {
                            this.n0 = (i6 << 8) | i3;
                            return 257;
                        }
                        ByteBuffer byteBuffer2 = this.z0;
                        this.f0 = i8 + 1;
                        int i9 = byteBuffer2.get(i8) & 255;
                        int i10 = this.f0;
                        if (i10 >= this.g0) {
                            this.n0 = (i6 << 8) | i3 | (i9 << 16);
                            return 257;
                        }
                        ByteBuffer byteBuffer3 = this.z0;
                        this.f0 = i10 + 1;
                        iF1 = F1(i3, i6, i9, byteBuffer3.get(i10) & 255);
                    } else {
                        int i11 = i7 & 255;
                        int i12 = i3 >> 16;
                        if (i12 == 0) {
                            int i13 = this.f0;
                            if (i13 >= this.g0) {
                                this.n0 = (i6 << 16) | i3;
                                return 257;
                            }
                            ByteBuffer byteBuffer4 = this.z0;
                            this.f0 = i13 + 1;
                            iF1 = F1(i4, i11, i6, byteBuffer4.get(i13) & 255);
                        } else {
                            iF1 = F1(i4, i11, i12, i6);
                        }
                    }
                    this.f1584j.z(iF1);
                    this.g = 4;
                    return 4;
                }
                ByteBuffer byteBuffer5 = this.z0;
                this.f0 = i2 + 1;
                int i14 = byteBuffer5.get(i2) & 255;
                int i15 = i3 >> 8;
                if (i15 == 0) {
                    int i16 = this.f0;
                    if (i16 >= this.g0) {
                        this.n0 = (i14 << 8) | i3;
                        return 257;
                    }
                    ByteBuffer byteBuffer6 = this.z0;
                    this.f0 = i16 + 1;
                    iD1 = D1(i3, i14, byteBuffer6.get(i16) & 255);
                } else {
                    iD1 = D1(i4, i15, i14);
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

    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e5 A[SYNTHETIC] */
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
        ByteBuffer byteBuffer = this.z0;
        while (true) {
            int i3 = this.f0;
            int i4 = this.g0;
            if (i3 < i4) {
                while (true) {
                    if (i3 < i4) {
                        int i5 = i3 + 1;
                        int i6 = byteBuffer.get(i3) & 255;
                        if (iArr[i6] != 0) {
                            this.f0 = i5;
                            switch (iArr[i6]) {
                                case 1:
                                    R(i6);
                                    i2 = this.f0;
                                    if (i2 >= this.g0) {
                                        if (byteBuffer.get(i2) == 10) {
                                            this.f0++;
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
                                            ByteBuffer byteBuffer2 = this.z0;
                                            this.f0 = i5 + 1;
                                            i6 |= (byteBuffer2.get(i5) & 255) << 8;
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
                                            ByteBuffer byteBuffer3 = this.z0;
                                            this.f0 = i5 + 1;
                                            i6 |= (byteBuffer3.get(i5) & 255) << 8;
                                            int i9 = this.g0;
                                            int i10 = this.f0;
                                            if (i9 > i10) {
                                                ByteBuffer byteBuffer4 = this.z0;
                                                this.f0 = i10 + 1;
                                                i6 |= (byteBuffer4.get(i10) & 255) << 16;
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
                                    int i11 = 1;
                                    while (true) {
                                        int i12 = this.f0;
                                        if (i12 < this.g0 && (b = byteBuffer.get(i12)) == 93) {
                                            this.f0++;
                                            i11++;
                                        }
                                    }
                                    if (b == 62 && i11 > 1) {
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
            ByteBuffer byteBuffer = this.z0;
            this.f0 = i3 + 1;
            byte b = byteBuffer.get(i3);
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
        ByteBuffer byteBuffer = this.z0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = byteBuffer.get(i2);
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
