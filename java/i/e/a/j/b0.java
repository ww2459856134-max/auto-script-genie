package i.e.a.j;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class b0 extends f {
    protected InputStream i0;
    protected byte[] j0;
    protected final i.e.a.l.o k0;
    protected final e l0;
    protected int[] m0;

    public b0(z zVar, InputStream inputStream, byte[] bArr, int i2, int i3) {
        super(zVar);
        this.m0 = new int[32];
        this.k0 = zVar.E();
        this.l0 = zVar.C();
        this.i0 = inputStream;
        this.j0 = bArr;
        this.f0 = i2;
        this.g0 = i3;
    }

    private final v S0(int i2, int i3) throws XMLStreamException {
        this.f0--;
        int iB = e.b(i2);
        b bVarH = this.l0.h(iB, i2, 0);
        if (bVarH != null) {
            return bVarH;
        }
        int[] iArr = this.m0;
        iArr[0] = i2;
        return P0(iB, iArr, 1, i3);
    }

    private final v T0(int i2, int i3, int i4) throws XMLStreamException {
        this.f0--;
        int iC = e.c(i2, i3);
        b bVarH = this.l0.h(iC, i2, i3);
        if (bVarH != null) {
            return bVarH;
        }
        int[] iArr = this.m0;
        iArr[0] = i2;
        iArr[1] = i3;
        return P0(iC, iArr, 2, i4);
    }

    private final v U0(int i2, int i3, int i4, int i5, int[] iArr) throws XMLStreamException {
        return i5 <= 1 ? i5 == 0 ? S0(i2, i3) : T0(i4, i2, i3) : V0(i2, iArr, i5, i3);
    }

    private final v V0(int i2, int[] iArr, int i3, int i4) throws XMLStreamException {
        this.f0--;
        if (i3 >= iArr.length) {
            iArr = i.e.a.l.c.c(iArr, iArr.length);
            this.m0 = iArr;
        }
        int i5 = i3 + 1;
        iArr[i3] = i2;
        int iD = e.d(iArr, i5);
        b bVarI = this.l0.i(iD, iArr, i5);
        return bVarI == null ? P0(iD, iArr, i5, i4) : bVarI;
    }

    private final int X0() throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i2 = this.f0;
        int i3 = i2 + 1;
        this.f0 = i3;
        byte b = bArr[i2];
        if (b == 45) {
            if (i3 >= this.g0) {
                X();
            }
            byte[] bArr2 = this.j0;
            int i4 = this.f0;
            this.f0 = i4 + 1;
            byte b2 = bArr2[i4];
            if (b2 != 45) {
                r0(I0(b2), " (expected '-' for COMMENT)");
                throw null;
            }
            if (this.f) {
                this.f1582h = true;
            } else {
                q();
            }
            this.g = 5;
            return 5;
        }
        if (b != 91) {
            r0(I0(b), " (expected either '-' for COMMENT or '[CDATA[' for CDATA section)");
            throw null;
        }
        this.g = 12;
        for (int i5 = 0; i5 < 6; i5++) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr3 = this.j0;
            int i6 = this.f0;
            this.f0 = i6 + 1;
            byte b3 = bArr3[i6];
            if (b3 != ((byte) "CDATA[".charAt(i5))) {
                r0(I0(b3), " (expected '" + "CDATA[".charAt(i5) + "' for CDATA section)");
                throw null;
            }
        }
        if (this.f) {
            this.f1582h = true;
        } else {
            o();
        }
        return 12;
    }

    private final int Y0() throws XMLStreamException {
        i1("DOCTYPE");
        this.A = k1(q1(true, "after DOCTYPE keyword, before root name"));
        byte bQ1 = q1(false, null);
        if (bQ1 == 80) {
            i1("PUBLIC");
            this.G = o1(q1(true, null));
            this.H = p1(q1(true, null));
            bQ1 = q1(false, null);
        } else if (bQ1 == 83) {
            i1("SYSTEM");
            byte bQ12 = q1(true, null);
            this.G = null;
            this.H = p1(bQ12);
            bQ1 = q1(false, null);
        } else {
            this.H = null;
            this.G = null;
        }
        if (bQ1 == 62) {
            this.f1582h = false;
            this.g = 11;
            return 11;
        }
        if (bQ1 != 91) {
            r0(I0(bQ1), this.H != null ? " (expected '[' for the internal subset, or '>' to end DOCTYPE declaration)" : " (expected a 'PUBLIC' or 'SYSTEM' keyword, '[' for the internal subset, or '>' to end DOCTYPE declaration)");
            throw null;
        }
        this.f1582h = true;
        this.g = 11;
        return 11;
    }

    private final int a1(int i2) throws XMLStreamException {
        byte bG1;
        int i3 = i2 - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                if (this.f0 >= this.g0) {
                    X();
                }
                byte[] bArr = this.j0;
                int i8 = this.f0;
                this.f0 = i8 + 1;
                i6 = (i6 << 8) | (bArr[i8] & 255);
            }
            if (i6 != this.A.m(i5)) {
                u0(this.A.l());
                throw null;
            }
        }
        int iM = this.A.m(i3);
        int i9 = 0;
        do {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr2 = this.j0;
            int i10 = this.f0;
            int i11 = i10 + 1;
            this.f0 = i11;
            i4 = (i4 << 8) | (bArr2[i10] & 255);
            if (i4 == iM) {
                if (i11 >= this.g0) {
                    X();
                }
                byte[] bArr3 = this.j0;
                int i12 = this.f0;
                this.f0 = i12 + 1;
                int i13 = bArr3[i12];
                while (i13 <= 32) {
                    if (i13 == 10) {
                        J0();
                    } else if (i13 == 13) {
                        int i14 = this.f0;
                        if (i14 < this.g0) {
                            byte[] bArr4 = this.j0;
                            this.f0 = i14 + 1;
                            bG1 = bArr4[i14];
                        } else {
                            bG1 = g1();
                        }
                        if (bG1 != 10) {
                            K0(this.f0 - 1);
                            i13 = bG1 & 255;
                        } else {
                            J0();
                        }
                    } else if (i13 != 32 && i13 != 9) {
                        D0(i13);
                        throw null;
                    }
                    int i15 = this.f0;
                    if (i15 < this.g0) {
                        byte[] bArr5 = this.j0;
                        this.f0 = i15 + 1;
                        bG1 = bArr5[i15];
                    } else {
                        bG1 = g1();
                    }
                    i13 = bG1 & 255;
                }
                if (i13 == 62) {
                    return 2;
                }
                F0(I0((byte) i13), " expected space or closing '>'");
                throw null;
            }
            i9++;
        } while (i9 <= 3);
        u0(this.A.l());
        throw null;
    }

    private final int c1() throws XMLStreamException {
        this.g = 3;
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        v vVarK1 = k1(bArr[i2]);
        this.A = vVarK1;
        String strI = vVarK1.i();
        if (strI.length() == 3 && strI.equalsIgnoreCase("xml") && this.A.k() == null) {
            i0(i.e.a.i.b.f1565l);
            throw null;
        }
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr2 = this.j0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        int i5 = bArr2[i3] & 255;
        if (i5 <= 32) {
            while (true) {
                if (i5 == 10) {
                    J0();
                } else if (i5 == 13) {
                    if (this.f0 >= this.g0) {
                        X();
                    }
                    byte[] bArr3 = this.j0;
                    int i6 = this.f0;
                    if (bArr3[i6] == 10) {
                        this.f0 = i6 + 1;
                    }
                    J0();
                } else if (i5 != 32 && i5 != 9) {
                    D0(i5);
                    throw null;
                }
                if (this.f0 >= this.g0) {
                    X();
                }
                byte[] bArr4 = this.j0;
                int i7 = this.f0;
                i5 = bArr4[i7] & 255;
                if (i5 <= 32) {
                    this.f0 = i7 + 1;
                } else if (this.f) {
                    this.f1582h = true;
                } else {
                    s();
                }
            }
        } else {
            if (i5 != 63) {
                m0(I0((byte) i5));
                throw null;
            }
            if (i4 >= this.g0) {
                X();
            }
            byte[] bArr5 = this.j0;
            int i8 = this.f0;
            this.f0 = i8 + 1;
            byte b = bArr5[i8];
            if (b != 62) {
                m0(I0(b));
                throw null;
            }
            this.f1584j.x();
            this.f1582h = false;
        }
        return 3;
    }

    private final int d1(boolean z) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i2 = this.f0;
        int i3 = i2 + 1;
        this.f0 = i3;
        byte b = bArr[i2];
        if (b == 45) {
            if (i3 >= this.g0) {
                X();
            }
            byte[] bArr2 = this.j0;
            int i4 = this.f0;
            this.f0 = i4 + 1;
            b = bArr2[i4];
            if (b == 45) {
                if (this.f) {
                    this.f1582h = true;
                } else {
                    q();
                }
                this.g = 5;
                return 5;
            }
        } else if (b == 68 && z) {
            Y0();
            if (this.f || !this.f1582h) {
                return 11;
            }
            r(true);
            this.f1582h = false;
            return 11;
        }
        this.f1582h = true;
        this.g = 4;
        p0(z, I0(b), " (expected '-' for COMMENT)");
        throw null;
    }

    private final void i1(String str) throws XMLStreamException {
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i3 = this.f0;
            this.f0 = i3 + 1;
            byte b = bArr[i3];
            if (b != ((byte) str.charAt(i2))) {
                r0(I0(b), " (expected '" + str.charAt(i2) + "' for " + str + " keyword)");
                throw null;
            }
        }
    }

    protected int O0() {
        this.f1584j.x();
        this.g = 9;
        return 9;
    }

    protected final v P0(int i2, int[] iArr, int i3, int i4) throws XMLStreamException {
        return H0(this.l0, this.k0, i2, iArr, i3, i4);
    }

    protected final int Q0(int i2) throws XMLStreamException {
        if (i2 == 13) {
            if (this.f0 >= this.g0 && !W()) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            byte[] bArr = this.j0;
            int i3 = this.f0;
            if (bArr[i3] == 10) {
                this.f0 = i3 + 1;
            }
        }
        J0();
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr2 = this.j0;
        int i4 = this.f0;
        byte b = bArr2[i4];
        if (b != 32 && b != 9) {
            if (b == 60 && i4 + 1 < this.g0 && bArr2[i4 + 1] != 33) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            this.f1584j.x()[0] = '\n';
            this.f1584j.A(1);
            return 1;
        }
        this.f0 = i4 + 1;
        int i5 = b != 32 ? 8 : 32;
        int i6 = 1;
        while (true) {
            if (i6 > i5) {
                break;
            }
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr3 = this.j0;
            int i7 = this.f0;
            byte b2 = bArr3[i7];
            if (b2 == b) {
                this.f0 = i7 + 1;
                i6++;
            } else if (b2 == 60 && i7 + 1 < this.g0 && bArr3[i7 + 1] != 33) {
                this.f1584j.y(i6, (char) b);
                return -1;
            }
        }
        char[] cArrX = this.f1584j.x();
        cArrX[0] = '\n';
        char c = (char) b;
        for (int i8 = 1; i8 <= i6; i8++) {
            cArrX[i8] = c;
        }
        int i9 = i6 + 1;
        this.f1584j.A(i9);
        return i9;
    }

    protected final int R0(int i2) throws XMLStreamException {
        if (i2 == 13) {
            if (this.f0 >= this.g0 && !W()) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            byte[] bArr = this.j0;
            int i3 = this.f0;
            if (bArr[i3] == 10) {
                this.f0 = i3 + 1;
            }
        }
        J0();
        if (this.f0 >= this.g0 && !W()) {
            this.f1584j.y(0, Chars.SPACE);
            return -1;
        }
        byte[] bArr2 = this.j0;
        int i4 = this.f0;
        byte b = bArr2[i4];
        if (b != 32 && b != 9) {
            if (b == 60) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            this.f1584j.x()[0] = '\n';
            this.f1584j.A(1);
            return 1;
        }
        this.f0 = i4 + 1;
        int i5 = b != 32 ? 8 : 32;
        int i6 = 1;
        do {
            if (this.f0 < this.g0 || W()) {
                byte[] bArr3 = this.j0;
                int i7 = this.f0;
                if (bArr3[i7] == b) {
                    this.f0 = i7 + 1;
                    i6++;
                }
            }
            this.f1584j.y(i6, (char) b);
            return -1;
        } while (i6 < i5);
        char[] cArrX = this.f1584j.x();
        cArrX[0] = '\n';
        char c = (char) b;
        for (int i8 = 1; i8 <= i6; i8++) {
            cArrX[i8] = c;
        }
        int i9 = i6 + 1;
        this.f1584j.A(i9);
        return i9;
    }

    @Override // i.e.a.j.e0
    protected final boolean W() throws IOException, XMLStreamException {
        long j2 = this.Z;
        int i2 = this.g0;
        this.Z = j2 + i2;
        this.b0 -= i2;
        this.f0 = 0;
        InputStream inputStream = this.i0;
        if (inputStream == null) {
            this.g0 = 0;
            return false;
        }
        try {
            byte[] bArr = this.j0;
            int i3 = inputStream.read(bArr, 0, bArr.length);
            if (i3 >= 1) {
                this.g0 = i3;
                return true;
            }
            this.g0 = 0;
            if (i3 != 0) {
                return false;
            }
            i0("InputStream returned 0 bytes, even when asked to read up to " + this.j0.length);
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected final int W0() throws XMLStreamException {
        int i2;
        int i3;
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i4 = this.f0;
        this.f0 = i4 + 1;
        byte b = bArr[i4];
        int i5 = 0;
        if (b == 120) {
            do {
                if (this.f0 >= this.g0) {
                    X();
                }
                byte[] bArr2 = this.j0;
                int i6 = this.f0;
                this.f0 = i6 + 1;
                byte b2 = bArr2[i6];
                if (b2 != 59) {
                    int i7 = i5 << 4;
                    if (b2 > 57 || b2 < 48) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else {
                            if (b2 < 65 || b2 > 70) {
                                F0(I0(b2), "; expected a hex digit (0-9a-fA-F)");
                                throw null;
                            }
                            i2 = b2 - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b2 - 48;
                    }
                    i5 = i7 + i3;
                }
            } while (i5 <= 1114111);
            d0();
            throw null;
        }
        while (b != 59) {
            if (b > 57 || b < 48) {
                F0(I0(b), "; expected a decimal number");
                throw null;
            }
            i5 = (i5 * 10) + (b - 48);
            if (i5 > 1114111) {
                d0();
                throw null;
            }
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr3 = this.j0;
            int i8 = this.f0;
            this.f0 = i8 + 1;
            b = bArr3[i8];
        }
        G0(i5);
        return i5;
    }

    @Override // i.e.a.j.e0
    public final int Z(boolean z) throws XMLStreamException {
        if (this.f1582h) {
            C0();
        }
        N0();
        while (true) {
            if (this.f0 >= this.g0 && !W()) {
                N0();
                return -1;
            }
            byte[] bArr = this.j0;
            int i2 = this.f0;
            int i3 = i2 + 1;
            this.f0 = i3;
            int i4 = bArr[i2] & 255;
            if (i4 == 60) {
                if (i3 >= this.g0) {
                    Y(5);
                }
                byte[] bArr2 = this.j0;
                int i5 = this.f0;
                this.f0 = i5 + 1;
                byte b = bArr2[i5];
                if (b == 33) {
                    return d1(z);
                }
                if (b == 63) {
                    return c1();
                }
                if (b != 47 && z) {
                    return e1(b);
                }
                q0(z, b);
                throw null;
            }
            if (i4 != 32) {
                if (i4 == 10) {
                    J0();
                } else if (i4 == 13) {
                    if (i3 >= this.g0 && !W()) {
                        J0();
                        N0();
                        return -1;
                    }
                    byte[] bArr3 = this.j0;
                    int i6 = this.f0;
                    if (bArr3[i6] == 10) {
                        this.f0 = i6 + 1;
                    }
                    J0();
                } else if (i4 != 9) {
                    p0(z, I0((byte) i4), null);
                    throw null;
                }
            }
        }
    }

    protected final int Z0() throws XMLStreamException {
        byte bG1;
        this.f1583i--;
        this.g = 2;
        v vVarA = this.D.a();
        this.A = vVarA;
        int iQ = vVarA.q();
        int i2 = this.g0;
        int i3 = this.f0;
        if (i2 - i3 < (iQ << 2) + 1) {
            return a1(iQ);
        }
        byte[] bArr = this.j0;
        int i4 = iQ - 1;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8) | (bArr[i3 + 3] & 255);
            i3 += 4;
            if (i6 != this.A.m(i5)) {
                this.f0 = i3;
                u0(this.A.l());
                throw null;
            }
        }
        int iM = this.A.m(i4);
        int i7 = i3 + 1;
        int i8 = bArr[i3] & 255;
        if (i8 != iM) {
            int i9 = i7 + 1;
            int i10 = (i8 << 8) | (bArr[i7] & 255);
            if (i10 != iM) {
                i7 = i9 + 1;
                int i11 = (i10 << 8) | (bArr[i9] & 255);
                if (i11 != iM) {
                    i9 = i7 + 1;
                    if (((bArr[i7] & 255) | (i11 << 8)) != iM) {
                        this.f0 = i9;
                        u0(this.A.l());
                        throw null;
                    }
                    i7 = i9;
                }
            } else {
                i7 = i9;
            }
        }
        int i12 = this.j0[i7] & 255;
        this.f0 = i7 + 1;
        while (i12 <= 32) {
            if (i12 == 10) {
                J0();
            } else if (i12 == 13) {
                int i13 = this.f0;
                if (i13 < this.g0) {
                    byte[] bArr2 = this.j0;
                    this.f0 = i13 + 1;
                    bG1 = bArr2[i13];
                } else {
                    bG1 = g1();
                }
                if (bG1 != 10) {
                    K0(this.f0 - 1);
                    i12 = bG1 & 255;
                } else {
                    J0();
                }
            } else if (i12 != 32 && i12 != 9) {
                D0(i12);
                throw null;
            }
            int i14 = this.f0;
            if (i14 < this.g0) {
                byte[] bArr3 = this.j0;
                this.f0 = i14 + 1;
                bG1 = bArr3[i14];
            } else {
                bG1 = g1();
            }
            i12 = bG1 & 255;
        }
        if (i12 == 62) {
            return 2;
        }
        F0(I0((byte) i12), " expected space or closing '>'");
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void a() throws IOException {
        InputStream inputStream = this.i0;
        if (inputStream != null) {
            inputStream.close();
            this.i0 = null;
        }
    }

    @Override // i.e.a.j.e0
    public final int a0() throws XMLStreamException {
        byte bH1;
        if (!this.f1582h) {
            int i2 = this.g;
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
            } else if (this.f1585k) {
                this.f1585k = false;
                return O0();
            }
        } else if (C0()) {
            return O0();
        }
        N0();
        if (this.f0 >= this.g0 && !W()) {
            N0();
            return -1;
        }
        byte[] bArr = this.j0;
        int i3 = this.f0;
        byte b = bArr[i3];
        if (b == 60) {
            int i4 = i3 + 1;
            this.f0 = i4;
            if (i4 < this.g0) {
                this.f0 = i4 + 1;
                bH1 = bArr[i4];
            } else {
                bH1 = h1(5);
            }
            return bH1 == 33 ? X0() : bH1 == 63 ? c1() : bH1 == 47 ? Z0() : e1(bH1);
        }
        if (b == 38) {
            this.f0 = i3 + 1;
            int iB1 = b1(false);
            if (iB1 == 0) {
                this.g = 9;
                return 9;
            }
            this.h0 = -iB1;
        } else {
            this.h0 = b & 255;
        }
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        this.g = 4;
        return 4;
    }

    @Override // i.e.a.j.e0
    protected void b() {
        byte[] bArr;
        super.b();
        if (this.l0.k()) {
            this.c.Y(this.l0);
        }
        if (this.i0 == null || (bArr = this.j0) == null) {
            return;
        }
        this.c.x(bArr);
        this.j0 = null;
    }

    protected abstract int b1(boolean z) throws XMLStreamException;

    protected abstract int e1(byte b) throws XMLStreamException;

    protected final boolean f1(int i2) throws IOException, XMLStreamException {
        int i3;
        if (this.i0 == null) {
            return false;
        }
        long j2 = this.Z;
        int i4 = this.f0;
        this.Z = j2 + i4;
        this.b0 -= i4;
        int i5 = this.g0 - i4;
        byte[] bArr = this.j0;
        System.arraycopy(bArr, i4, bArr, 0, i5);
        this.f0 = 0;
        this.g0 = i5;
        do {
            try {
                byte[] bArr2 = this.j0;
                int length = bArr2.length;
                int i6 = this.g0;
                int i7 = length - i6;
                int i8 = this.i0.read(bArr2, i6, i7);
                if (i8 < 1) {
                    if (i8 != 0) {
                        return false;
                    }
                    i0("InputStream returned 0 bytes, even when asked to read up to " + i7);
                    throw null;
                }
                i3 = this.g0 + i8;
                this.g0 = i3;
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        } while (i3 < i2);
        return true;
    }

    protected final byte g1() throws XMLStreamException {
        if (W()) {
            byte[] bArr = this.j0;
            int i2 = this.f0;
            this.f0 = i2 + 1;
            return bArr[i2];
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(this.g));
        throw null;
    }

    protected final byte h1(int i2) throws XMLStreamException {
        if (W()) {
            byte[] bArr = this.j0;
            int i3 = this.f0;
            this.f0 = i3 + 1;
            return bArr[i3];
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(i2));
        throw null;
    }

    protected final byte j1() throws XMLStreamException {
        if (this.f0 < this.g0 || W()) {
            byte[] bArr = this.j0;
            int i2 = this.f0;
            this.f0 = i2 + 1;
            return bArr[i2];
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(this.g));
        throw null;
    }

    protected final v k1(byte b) throws XMLStreamException {
        int i2 = this.g0;
        int i3 = this.f0;
        if (i2 - i3 < 8) {
            return n1(b);
        }
        int i4 = b & 255;
        if (i4 < 65) {
            F0(i4, "; expected a name start character");
            throw null;
        }
        byte[] bArr = this.j0;
        int i5 = i3 + 1;
        this.f0 = i5;
        int i6 = bArr[i3] & 255;
        if (i6 < 65 && (i6 < 45 || i6 > 58 || i6 == 47)) {
            return S0(i4, 1);
        }
        int i7 = (i4 << 8) | i6;
        int i8 = i5 + 1;
        this.f0 = i8;
        int i9 = bArr[i5] & 255;
        if (i9 < 65 && (i9 < 45 || i9 > 58 || i9 == 47)) {
            return S0(i7, 2);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = i8 + 1;
        this.f0 = i11;
        int i12 = bArr[i8] & 255;
        if (i12 < 65 && (i12 < 45 || i12 > 58 || i12 == 47)) {
            return S0(i10, 3);
        }
        int i13 = (i10 << 8) | i12;
        this.f0 = i11 + 1;
        int i14 = bArr[i11] & 255;
        return (i14 >= 65 || (i14 >= 45 && i14 <= 58 && i14 != 47)) ? m1(i14, i13) : S0(i13, 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        return V0(r10, r11, r1, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return V0(r10, r11, r1, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
    
        return V0(r10, r11, r1, 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v l1(int i2, int[] iArr) throws XMLStreamException {
        byte bG1;
        byte bG12;
        int i3;
        byte bG13;
        int i4 = 2;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i5 = this.f0;
            int i6 = i5 + 1;
            this.f0 = i6;
            int i7 = bArr[i5] & 255;
            if (i7 < 65 && (i7 < 45 || i7 > 58 || i7 == 47)) {
                break;
            }
            int i8 = (i2 << 8) | i7;
            if (i6 < this.g0) {
                this.f0 = i6 + 1;
                bG1 = bArr[i6];
            } else {
                bG1 = g1();
            }
            int i9 = bG1 & 255;
            if (i9 < 65 && (i9 < 45 || i9 > 58 || i9 == 47)) {
                break;
            }
            int i10 = (i8 << 8) | i9;
            int i11 = this.f0;
            if (i11 < this.g0) {
                byte[] bArr2 = this.j0;
                this.f0 = i11 + 1;
                bG12 = bArr2[i11];
            } else {
                bG12 = g1();
            }
            int i12 = bG12 & 255;
            if (i12 < 65 && (i12 < 45 || i12 > 58 || i12 == 47)) {
                break;
            }
            i3 = (i10 << 8) | i12;
            int i13 = this.f0;
            if (i13 < this.g0) {
                byte[] bArr3 = this.j0;
                this.f0 = i13 + 1;
                bG13 = bArr3[i13];
            } else {
                bG13 = g1();
            }
            int i14 = bG13 & 255;
            if (i14 < 65 && (i14 < 45 || i14 > 58 || i14 == 47)) {
                break;
            }
            if (i4 >= iArr.length) {
                iArr = i.e.a.l.c.c(iArr, iArr.length);
                this.m0 = iArr;
            }
            iArr[i4] = i3;
            i4++;
            i2 = i14;
        }
        return V0(i3, iArr, i4, 4);
    }

    protected v m1(int i2, int i3) throws XMLStreamException {
        byte[] bArr = this.j0;
        int i4 = this.f0;
        int i5 = i4 + 1;
        this.f0 = i5;
        int i6 = bArr[i4] & 255;
        if (i6 < 65 && (i6 < 45 || i6 > 58 || i6 == 47)) {
            return T0(i3, i2, 1);
        }
        int i7 = (i2 << 8) | i6;
        int i8 = i5 + 1;
        this.f0 = i8;
        int i9 = bArr[i5] & 255;
        if (i9 < 65 && (i9 < 45 || i9 > 58 || i9 == 47)) {
            return T0(i3, i7, 2);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = i8 + 1;
        this.f0 = i11;
        int i12 = bArr[i8] & 255;
        if (i12 < 65 && (i12 < 45 || i12 > 58 || i12 == 47)) {
            return T0(i3, i10, 3);
        }
        int i13 = (i10 << 8) | i12;
        this.f0 = i11 + 1;
        int i14 = bArr[i11] & 255;
        if (i14 < 65 && (i14 < 45 || i14 > 58 || i14 == 47)) {
            return T0(i3, i13, 4);
        }
        int[] iArr = this.m0;
        iArr[0] = i3;
        iArr[1] = i13;
        return l1(i14, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        return U0(r4, 1, r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        return U0(r1, 2, r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        return U0(r12, 3, r8, r9, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v n1(byte b) throws XMLStreamException {
        byte bG1;
        byte bG12;
        int i2;
        byte bG13;
        int i3 = b & 255;
        if (i3 < 65) {
            F0(i3, "; expected a name start character");
            throw null;
        }
        int i4 = i3;
        int[] iArrC = this.m0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i7 = this.f0;
            int i8 = i7 + 1;
            this.f0 = i8;
            int i9 = bArr[i7] & 255;
            if (i9 < 65 && (i9 < 45 || i9 > 58 || i9 == 47)) {
                break;
            }
            int i10 = i9 | (i4 << 8);
            if (i8 < this.g0) {
                this.f0 = i8 + 1;
                bG1 = bArr[i8];
            } else {
                bG1 = g1();
            }
            int i11 = bG1 & 255;
            if (i11 < 65 && (i11 < 45 || i11 > 58 || i11 == 47)) {
                break;
            }
            int i12 = i11 | (i10 << 8);
            int i13 = this.f0;
            if (i13 < this.g0) {
                byte[] bArr2 = this.j0;
                this.f0 = i13 + 1;
                bG12 = bArr2[i13];
            } else {
                bG12 = g1();
            }
            int i14 = bG12 & 255;
            if (i14 < 65 && (i14 < 45 || i14 > 58 || i14 == 47)) {
                break;
            }
            i2 = (i12 << 8) | i14;
            int i15 = this.f0;
            if (i15 < this.g0) {
                byte[] bArr3 = this.j0;
                this.f0 = i15 + 1;
                bG13 = bArr3[i15];
            } else {
                bG13 = g1();
            }
            i4 = bG13 & 255;
            if (i4 < 65 && (i4 < 45 || i4 > 58 || i4 == 47)) {
                break;
            }
            if (i6 == 0) {
                i5 = i2;
            } else if (i6 == 1) {
                iArrC[0] = i5;
                iArrC[1] = i2;
            } else {
                if (i6 >= iArrC.length) {
                    iArrC = i.e.a.l.c.c(iArrC, iArrC.length);
                    this.m0 = iArrC;
                }
                iArrC[i6] = i2;
            }
            i6++;
        }
        return U0(i2, 4, i5, i6, iArrC);
    }

    protected abstract String o1(byte b) throws XMLStreamException;

    protected abstract String p1(byte b) throws XMLStreamException;

    protected byte q1(boolean z, String str) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        byte b = bArr[i2];
        if ((b & 255) > 32) {
            if (!z) {
                return b;
            }
            r0(I0(b), " (expected white space " + str + ")");
            throw null;
        }
        do {
            if (b == 10) {
                J0();
            } else if (b == 13) {
                if (this.f0 >= this.g0) {
                    X();
                }
                byte[] bArr2 = this.j0;
                int i3 = this.f0;
                if (bArr2[i3] == 10) {
                    this.f0 = i3 + 1;
                }
                J0();
            } else if (b != 32 && b != 9) {
                D0(b);
                throw null;
            }
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr3 = this.j0;
            int i4 = this.f0;
            this.f0 = i4 + 1;
            b = bArr3[i4];
        } while ((b & 255) <= 32);
        return b;
    }
}
