package i.e.a.j;

import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.Reader;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class a0 extends e0 {
    private static final i.e.a.l.o l0 = o.l();
    protected Reader f0;
    protected char[] g0;
    protected int h0;
    protected int i0;
    protected int j0;
    protected final i k0;

    public a0(z zVar, Reader reader, char[] cArr, int i2, int i3) {
        super(zVar);
        this.j0 = 0;
        this.f0 = reader;
        this.g0 = cArr;
        this.h0 = i2;
        this.i0 = i3;
        this.Z = 0L;
        this.b0 = 0;
        this.k0 = zVar.D();
    }

    private char L0(char c) throws XMLStreamException {
        if (c >= 56320) {
            k1(c);
            throw null;
        }
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        this.h0 = i2 + 1;
        char c2 = cArr[i2];
        if (c2 < 56320 || c2 >= 57344) {
            l1(c2);
            throw null;
        }
        int i3 = ((c - 55296) << 10) + WXMediaMessage.THUMB_LENGTH_LIMIT;
        if (i3 <= 1114111) {
            return c2;
        }
        l0(i3);
        throw null;
    }

    private int M0(char c, char c2, int i2) throws XMLStreamException {
        if (c >= 56320) {
            k1(c);
            throw null;
        }
        if (c2 < 56320 || c2 >= 57344) {
            l1(c2);
            throw null;
        }
        int i3 = ((c - 55296) << 10) + WXMediaMessage.THUMB_LENGTH_LIMIT;
        if (i3 > 1114111) {
            l0(i3);
            throw null;
        }
        j0(i3, i2);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int N0(int i2, char c, v vVar) throws XMLStreamException {
        char[] cArrR = this.V.r(vVar, i2);
        int[] iArr = l0.b;
        while (true) {
            int i3 = this.h0;
            if (i3 >= this.i0) {
                X();
                i3 = this.h0;
            }
            if (i2 >= cArrR.length) {
                cArrR = this.V.s();
            }
            int i4 = this.i0;
            int length = (cArrR.length - i2) + i3;
            if (length < i4) {
                i4 = length;
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char cR = this.g0[i3];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 != 3) {
                                        if (i6 != 14) {
                                            switch (i6) {
                                                case 9:
                                                    F0(cR, "'<' not allowed in attribute value");
                                                    throw null;
                                                case 10:
                                                    if (!this.c.i0()) {
                                                        int iX0 = X0(false);
                                                        if (iX0 == 0) {
                                                            t0(vVar, false);
                                                            throw null;
                                                        }
                                                        if ((iX0 >> 16) != 0) {
                                                            int i7 = iX0 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                                            int i8 = i2 + 1;
                                                            cArrR[i2] = (char) ((i7 >> 10) | 55296);
                                                            iX0 = (i7 & 1023) | 56320;
                                                            if (i8 >= cArrR.length) {
                                                                cArrR = this.V.s();
                                                            }
                                                            i2 = i8;
                                                        }
                                                        cR = (char) iX0;
                                                        break;
                                                    }
                                                    break;
                                            }
                                        } else if (cR == c) {
                                            return i2;
                                        }
                                    }
                                    cR = Chars.SPACE;
                                }
                                e1();
                                cR = Chars.SPACE;
                            } else {
                                R(cR);
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            char[] cArr = this.g0;
                            int i9 = this.h0;
                            if (cArr[i9] == '\n') {
                                this.h0 = i9 + 1;
                            }
                            e1();
                            cR = Chars.SPACE;
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i10 = i2 + 1;
                                cArrR[i2] = cR;
                                if (i10 >= cArrR.length) {
                                    cArrR = this.V.s();
                                }
                                cR = cL0;
                                i2 = i10;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrR[i2] = cR;
                        i2++;
                    } else {
                        cArrR[i2] = cR;
                        i2++;
                        i3 = i5;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i5;
                    if (cR > 255) {
                    }
                    cArrR[i2] = cR;
                    i2++;
                } else {
                    cArrR[i2] = cR;
                    i2++;
                    i3 = i5;
                }
            }
            this.h0 = i3;
        }
    }

    private int O0(char c) throws XMLStreamException {
        if (c >= 56320) {
            k1(c);
            throw null;
        }
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        this.h0 = i2 + 1;
        char c2 = cArr[i2];
        if (c2 < 56320 || c2 >= 57344) {
            l1(c2);
            throw null;
        }
        int i3 = ((c - 55296) << 10) + WXMediaMessage.THUMB_LENGTH_LIMIT;
        if (i3 <= 1114111) {
            return i3;
        }
        l0(i3);
        throw null;
    }

    private final int V0() throws XMLStreamException {
        g1("DOCTYPE");
        this.A = h1(n1(true, "after DOCTYPE keyword, before root name"));
        char cN1 = n1(false, null);
        if (cN1 == 'P') {
            g1("PUBLIC");
            this.G = i1(n1(true, null));
            this.H = j1(n1(true, null));
            cN1 = n1(false, null);
        } else if (cN1 == 'S') {
            g1("SYSTEM");
            char cN12 = n1(true, null);
            this.G = null;
            this.H = j1(cN12);
            cN1 = n1(false, null);
        } else {
            this.H = null;
            this.G = null;
        }
        if (cN1 == '>') {
            this.f1582h = false;
            this.g = 11;
            return 11;
        }
        if (cN1 != '[') {
            r0(cN1, this.H != null ? " (expected '[' for the internal subset, or '>' to end DOCTYPE declaration)" : " (expected a 'PUBLIC' or 'SYSTEM' keyword, '[' for the internal subset, or '>' to end DOCTYPE declaration)");
            throw null;
        }
        this.f1582h = true;
        this.g = 11;
        return 11;
    }

    private void Y0(v vVar, char c) throws XMLStreamException {
        char[] cArrB = this.t;
        int i2 = 0;
        while (true) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            int i4 = i3 + 1;
            this.h0 = i4;
            char c2 = cArr[i3];
            if (c2 == c) {
                if (i2 == 0) {
                    e(vVar, "");
                    return;
                } else {
                    e(vVar, this.c.l(cArrB, i2));
                    return;
                }
            }
            if (c2 == '&') {
                int iX0 = X0(false);
                if (iX0 == 0) {
                    t0(vVar, true);
                    throw null;
                }
                if ((iX0 >> 16) != 0) {
                    if (i2 >= cArrB.length) {
                        cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                        this.t = cArrB;
                    }
                    int i5 = iX0 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                    cArrB[i2] = (char) (55296 | (i5 >> 10));
                    iX0 = (i5 & 1023) | 56320;
                    i2++;
                }
                c2 = (char) iX0;
            } else {
                if (c2 == '<') {
                    F0(c2, "'<' not allowed in attribute value");
                    throw null;
                }
                if (c2 < ' ') {
                    if (c2 == '\n') {
                        e1();
                    } else if (c2 == '\r') {
                        if (i4 >= this.i0) {
                            X();
                        }
                        char[] cArr2 = this.g0;
                        int i6 = this.h0;
                        if (cArr2[i6] == '\n') {
                            this.h0 = i6 + 1;
                        }
                        e1();
                        c2 = '\n';
                    } else if (c2 != '\t') {
                        D0(c2);
                        throw null;
                    }
                }
            }
            if (i2 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
            }
            cArrB[i2] = c2;
            i2++;
        }
    }

    private final void g1(String str) throws XMLStreamException {
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            char c = cArr[i3];
            if (c != str.charAt(i2)) {
                r0(c, " (expected '" + str.charAt(i2) + "' for " + str + " keyword)");
                throw null;
            }
        }
    }

    private void k1(char c) throws XMLStreamException {
        i0("Invalid surrogate character (code 0x" + Integer.toHexString(c) + "): can not start a surrogate pair");
        throw null;
    }

    private void l1(char c) throws XMLStreamException {
        i0("Invalid surrogate character (code " + Integer.toHexString(c) + "): is not legal as the second part of a surrogate pair");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x002d A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void A0() throws XMLStreamException {
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        while (true) {
            int i2 = this.h0;
            int i3 = this.i0;
            if (i2 >= i3) {
                X();
                i2 = this.h0;
                i3 = this.i0;
            }
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c = cArr[i2];
                if (c <= 255) {
                    if (iArr[c] != 0) {
                        this.h0 = i4;
                        if (c > 255) {
                            int i5 = iArr[c];
                            if (i5 == 2) {
                                if (this.h0 >= this.i0) {
                                    X();
                                }
                                int i6 = this.h0;
                                if (cArr[i6] == '\n') {
                                    this.h0 = i6 + 1;
                                }
                                e1();
                            } else if (i5 == 3) {
                                e1();
                            } else if (i5 == 12) {
                                if (this.h0 >= this.i0) {
                                    X();
                                }
                                char[] cArr2 = this.g0;
                                int i7 = this.h0;
                                if (cArr2[i7] == '>') {
                                    this.h0 = i7 + 1;
                                    return;
                                }
                            } else {
                                continue;
                            }
                        } else if (c >= 55296) {
                            if (c < 57344) {
                                L0(c);
                            } else if (c >= 65534) {
                                R(c);
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                } else if (c >= 55296) {
                    this.h0 = i4;
                    if (c > 255) {
                    }
                } else {
                    i2 = i4;
                }
            }
            this.h0 = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r5.h0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0030 A[EDGE_INSN: B:35:0x0030->B:21:0x0030 BREAK  A[LOOP:0: B:3:0x0002->B:43:0x0002], SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void B0() throws XMLStreamException {
        char c;
        int i2 = this.h0;
        while (true) {
            if (i2 < this.i0) {
                c = this.g0[i2];
                if (c <= ' ') {
                    break;
                }
                i2++;
                if (c == '\n') {
                    f1(i2);
                } else if (c == '\r') {
                    if (i2 >= this.i0) {
                        if (!W()) {
                            break;
                        } else {
                            i2 = this.h0;
                        }
                    }
                    if (this.g0[i2] == '\n') {
                        i2++;
                    }
                    f1(i2);
                } else if (c != ' ' && c != '\t') {
                    this.h0 = i2;
                    D0(c);
                    throw null;
                }
            } else {
                if (!W()) {
                    break;
                }
                i2 = this.h0;
                c = this.g0[i2];
                if (c <= ' ') {
                }
            }
        }
    }

    @Override // i.e.a.j.e0
    public n.b.a.h D() {
        String strH = this.c.H();
        String strI = this.c.I();
        long j2 = this.Z;
        int i2 = this.h0;
        return i.e.a.i.d.b(strH, strI, j2 + i2, this.a0, i2 - this.b0);
    }

    protected int H0() {
        this.f1584j.x();
        this.g = 9;
        return 9;
    }

    @Override // i.e.a.j.e0
    public long I() throws XMLStreamException {
        return -1L;
    }

    protected final v I0(char[] cArr, int i2, int i3) throws XMLStreamException {
        char c = cArr[0];
        if (c >= 55296 && c < 57344) {
            if (i2 == 1) {
                k1(c);
                throw null;
            }
            M0(c, cArr[1], 0);
            throw null;
        }
        if (!i.e.a.l.p.e(c)) {
            j0(c, 0);
            throw null;
        }
        int i4 = -1;
        for (int i5 = 1; i5 < i2; i5++) {
            char c2 = cArr[i5];
            if (c2 >= 55296 && c2 < 57344) {
                int i6 = i5 + 1;
                if (i6 >= i2) {
                    k1(c2);
                    throw null;
                }
                M0(c2, cArr[i6], i5);
                throw null;
            }
            if (c2 == ':') {
                if (i4 >= 0) {
                    n0();
                    throw null;
                }
                i4 = i5;
            } else if (!i.e.a.l.p.d(c2)) {
                j0(c2, i5);
                throw null;
            }
        }
        return this.k0.a(cArr, 0, i2, i3);
    }

    @Override // i.e.a.j.e0
    public long J() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.Z + this.h0;
    }

    protected final int J0(char c) throws XMLStreamException {
        if (c == '\r') {
            if (this.h0 >= this.i0 && !W()) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            char[] cArr = this.g0;
            int i2 = this.h0;
            if (cArr[i2] == '\n') {
                this.h0 = i2 + 1;
            }
        }
        e1();
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr2 = this.g0;
        int i3 = this.h0;
        char c2 = cArr2[i3];
        if (c2 != ' ' && c2 != '\t') {
            if (c2 == '<' && i3 + 1 < this.i0 && cArr2[i3 + 1] != '!') {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            this.f1584j.x()[0] = '\n';
            this.f1584j.A(1);
            return 1;
        }
        this.h0 = i3 + 1;
        int i4 = c2 != ' ' ? 8 : 32;
        int i5 = 1;
        while (true) {
            if (i5 > i4) {
                break;
            }
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr3 = this.g0;
            int i6 = this.h0;
            char c3 = cArr3[i6];
            if (c3 == c2) {
                this.h0 = i6 + 1;
                i5++;
            } else if (c3 == '<' && i6 + 1 < this.i0 && cArr3[i6 + 1] != '!') {
                this.f1584j.y(i5, c2);
                return -1;
            }
        }
        char[] cArrX = this.f1584j.x();
        cArrX[0] = '\n';
        for (int i7 = 1; i7 <= i5; i7++) {
            cArrX[i7] = c2;
        }
        int i8 = i5 + 1;
        this.f1584j.A(i8);
        return i8;
    }

    protected final int K0(char c) throws XMLStreamException {
        if (c == '\r') {
            if (this.h0 >= this.i0 && !W()) {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            char[] cArr = this.g0;
            int i2 = this.h0;
            if (cArr[i2] == '\n') {
                this.h0 = i2 + 1;
            }
        }
        e1();
        if (this.h0 >= this.i0 && !W()) {
            this.f1584j.y(0, Chars.SPACE);
            return -1;
        }
        char[] cArr2 = this.g0;
        int i3 = this.h0;
        char c2 = cArr2[i3];
        if (c2 != ' ' && c2 != '\t') {
            if (c2 == '<') {
                this.f1584j.y(0, Chars.SPACE);
                return -1;
            }
            this.f1584j.x()[0] = '\n';
            this.f1584j.A(1);
            return 1;
        }
        this.h0 = i3 + 1;
        int i4 = c2 != ' ' ? 8 : 32;
        int i5 = 1;
        do {
            if (this.h0 < this.i0 || W()) {
                char[] cArr3 = this.g0;
                int i6 = this.h0;
                if (cArr3[i6] == c2) {
                    this.h0 = i6 + 1;
                    i5++;
                }
            }
            this.f1584j.y(i5, c2);
            return -1;
        } while (i5 < i4);
        char[] cArrX = this.f1584j.x();
        cArrX[0] = '\n';
        for (int i7 = 1; i7 <= i5; i7++) {
            cArrX[i7] = c2;
        }
        int i8 = i5 + 1;
        this.f1584j.A(i8);
        return i8;
    }

    @Override // i.e.a.j.e0
    public long O() {
        return -1L;
    }

    @Override // i.e.a.j.e0
    public long P() {
        return this.c0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void P0() throws XMLStreamException {
        char c;
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        while (true) {
            int i2 = this.h0;
            if (i2 >= this.i0) {
                X();
                i2 = this.h0;
            }
            int i3 = 0;
            if (iP >= cArrO.length) {
                cArrO = this.f1584j.n();
                iP = 0;
            }
            int i4 = this.i0;
            int length = (cArrO.length - iP) + i2;
            if (length < i4) {
                i4 = length;
            }
            while (i2 < i4) {
                int i5 = i2 + 1;
                char cR = cArr[i2];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 == 1) {
                                R(cR);
                            } else if (i6 != 2) {
                                if (i6 == 3) {
                                    e1();
                                } else if (i6 == 11) {
                                    int i7 = 0;
                                    while (true) {
                                        if (this.h0 >= this.i0) {
                                            X();
                                        }
                                        char[] cArr2 = this.g0;
                                        int i8 = this.h0;
                                        c = cArr2[i8];
                                        if (c != ']') {
                                            break;
                                        }
                                        this.h0 = i8 + 1;
                                        i7++;
                                    }
                                    boolean z = c == '>' && i7 >= 1;
                                    if (z) {
                                        i7--;
                                    }
                                    while (i7 > 0) {
                                        int i9 = iP + 1;
                                        cArrO[iP] = ']';
                                        if (i9 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                            iP = 0;
                                            i7--;
                                        } else {
                                            iP = i9;
                                            i7--;
                                        }
                                    }
                                    if (z) {
                                        this.h0++;
                                        this.f1584j.A(iP);
                                        return;
                                    }
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            int i10 = this.h0;
                            if (cArr[i10] == '\n') {
                                this.h0 = i10 + 1;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i11 = iP + 1;
                                cArrO[iP] = cR;
                                if (i11 >= cArrO.length) {
                                    cArrO = this.f1584j.n();
                                } else {
                                    i3 = i11;
                                }
                                cR = cL0;
                                iP = i3;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrO[iP] = cR;
                        iP++;
                    } else {
                        cArrO[iP] = cR;
                        i2 = i5;
                        iP++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i5;
                    if (cR > 255) {
                    }
                    cArrO[iP] = cR;
                    iP++;
                } else {
                    cArrO[iP] = cR;
                    i2 = i5;
                    iP++;
                }
            }
            this.h0 = i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void Q0() throws XMLStreamException {
        int[] iArr = l0.a;
        char[] cArr = this.g0;
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        while (true) {
            int i2 = this.h0;
            if (i2 >= this.i0) {
                X();
                i2 = this.h0;
            }
            int i3 = 0;
            if (iP >= cArrO.length) {
                cArrO = this.f1584j.n();
                iP = 0;
            }
            int i4 = this.i0;
            int length = (cArrO.length - iP) + i2;
            if (length < i4) {
                i4 = length;
            }
            while (i2 < i4) {
                int i5 = i2 + 1;
                char cR = cArr[i2];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 == 1) {
                                R(cR);
                            } else if (i6 != 2) {
                                if (i6 != 3) {
                                    switch (i6) {
                                        case 9:
                                            this.h0--;
                                            break;
                                        case 10:
                                            int iX0 = X0(false);
                                            if (iX0 != 0) {
                                                if ((iX0 >> 16) != 0) {
                                                    int i7 = iX0 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                                    int i8 = iP + 1;
                                                    cArrO[iP] = (char) ((i7 >> 10) | 55296);
                                                    if (i8 >= cArrO.length) {
                                                        cArrO = this.f1584j.n();
                                                    } else {
                                                        i3 = i8;
                                                    }
                                                    iX0 = (i7 & 1023) | 56320;
                                                    iP = i3;
                                                }
                                                cR = (char) iX0;
                                                break;
                                            } else {
                                                this.f1585k = true;
                                                break;
                                            }
                                        case 11:
                                            int i9 = 1;
                                            while (true) {
                                                if (this.h0 >= this.i0) {
                                                    X();
                                                }
                                                int i10 = this.h0;
                                                char c = cArr[i10];
                                                if (c == ']') {
                                                    this.h0 = i10 + 1;
                                                    i9++;
                                                } else {
                                                    if (c == '>' && i9 > 1) {
                                                        f0();
                                                        throw null;
                                                    }
                                                    while (i9 > 1) {
                                                        int i11 = iP + 1;
                                                        cArrO[iP] = ']';
                                                        if (i11 >= cArrO.length) {
                                                            cArrO = this.f1584j.n();
                                                            iP = 0;
                                                        } else {
                                                            iP = i11;
                                                        }
                                                        i9--;
                                                    }
                                                    cR = ']';
                                                    break;
                                                }
                                            }
                                    }
                                } else {
                                    e1();
                                }
                            }
                            int i12 = this.h0;
                            if (i12 >= this.i0) {
                                X();
                                i12 = this.h0;
                            }
                            if (cArr[i12] == '\n') {
                                this.h0++;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i13 = iP + 1;
                                cArrO[iP] = cR;
                                if (i13 >= cArrO.length) {
                                    cArrO = this.f1584j.n();
                                } else {
                                    i3 = i13;
                                }
                                cR = cL0;
                                iP = i3;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrO[iP] = cR;
                        iP++;
                    } else {
                        cArrO[iP] = cR;
                        i2 = i5;
                        iP++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i5;
                    if (cR > 255) {
                    }
                    cArrO[iP] = cR;
                    iP++;
                } else {
                    cArrO[iP] = cR;
                    i2 = i5;
                    iP++;
                }
            }
            this.h0 = i2;
        }
        this.f1584j.A(iP);
    }

    protected final void R0() throws XMLStreamException {
        while (true) {
            if (this.h0 >= this.i0 && !W()) {
                return;
            }
            char[] cArr = this.g0;
            int i2 = this.h0;
            if (cArr[i2] != '<') {
                Q0();
                if (this.f1585k) {
                    return;
                }
            } else {
                if (i2 + 3 >= this.i0 && !c1(3)) {
                    return;
                }
                char[] cArr2 = this.g0;
                int i3 = this.h0;
                if (cArr2[i3 + 1] != '!' || cArr2[i3 + 2] != '[') {
                    return;
                }
                this.h0 = i3 + 3;
                for (int i4 = 0; i4 < 6; i4++) {
                    if (this.h0 >= this.i0) {
                        X();
                    }
                    char[] cArr3 = this.g0;
                    int i5 = this.h0;
                    this.h0 = i5 + 1;
                    char c = cArr3[i5];
                    if (c != "CDATA[".charAt(i4)) {
                        r0(c, " (expected '" + "CDATA[".charAt(i4) + "' for CDATA section)");
                        throw null;
                    }
                }
                P0();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        r8.h0 = r5;
        r8.f1584j.A(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x005f A[EDGE_INSN: B:52:0x005f->B:34:0x005f BREAK  A[LOOP:0: B:12:0x0026->B:50:0x008f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void S0() throws XMLStreamException {
        int iK0;
        char[] cArrO;
        char c;
        char c2 = (char) this.j0;
        int i2 = 0;
        if (c2 == '\r' || c2 == '\n') {
            iK0 = K0(c2);
            if (iK0 < 0) {
                return;
            } else {
                cArrO = this.f1584j.o();
            }
        } else {
            cArrO = this.f1584j.x();
            cArrO[0] = c2;
            iK0 = 1;
        }
        int i3 = this.h0;
        while (true) {
            if (i3 < this.i0) {
                c = this.g0[i3];
                if (c <= ' ') {
                    break;
                }
                i3++;
                if (c == '\n') {
                    f1(i3);
                } else if (c == '\r') {
                    if (i3 >= this.i0) {
                        if (W()) {
                            i3 = this.h0;
                        } else {
                            if (iK0 >= cArrO.length) {
                                cArrO = this.f1584j.n();
                            } else {
                                i2 = iK0;
                            }
                            iK0 = i2 + 1;
                            cArrO[i2] = '\n';
                        }
                    }
                    if (this.g0[i3] == '\n') {
                        i3++;
                    }
                    f1(i3);
                    c = '\n';
                } else if (c != ' ' && c != '\t') {
                    this.h0 = i3;
                    D0(c);
                    throw null;
                }
                if (iK0 >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iK0 = 0;
                }
                cArrO[iK0] = c;
                iK0++;
            } else {
                if (!W()) {
                    break;
                }
                i3 = this.h0;
                c = this.g0[i3];
                if (c <= ' ') {
                }
            }
        }
    }

    protected final int T0() throws XMLStreamException {
        int i2;
        int i3;
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i4 = this.h0;
        this.h0 = i4 + 1;
        char c = cArr[i4];
        int i5 = 0;
        if (c == 'x') {
            do {
                if (this.h0 >= this.i0) {
                    X();
                }
                char[] cArr2 = this.g0;
                int i6 = this.h0;
                this.h0 = i6 + 1;
                char c2 = cArr2[i6];
                if (c2 != ';') {
                    int i7 = i5 << 4;
                    if (c2 > '9' || c2 < '0') {
                        if (c2 >= 'a' && c2 <= 'f') {
                            i2 = c2 - 'a';
                        } else {
                            if (c2 < 'A' || c2 > 'F') {
                                F0(c2, "; expected a hex digit (0-9a-fA-F)");
                                throw null;
                            }
                            i2 = c2 - 'A';
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = c2 - '0';
                    }
                    i5 = i7 + i3;
                }
            } while (i5 <= 1114111);
            d0();
            throw null;
        }
        while (c != ';') {
            if (c > '9' || c < '0') {
                F0(c, "; expected a decimal number");
                throw null;
            }
            i5 = (i5 * 10) + (c - '0');
            if (i5 > 1114111) {
                d0();
                throw null;
            }
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr3 = this.g0;
            int i8 = this.h0;
            this.h0 = i8 + 1;
            c = cArr3[i8];
        }
        if (i5 >= 55296) {
            if (i5 < 57344) {
                l0(i5);
                throw null;
            }
            if (i5 == 65534 || i5 == 65535) {
                l0(i5);
                throw null;
            }
        } else if (i5 < 32 && i5 != 10 && i5 != 13 && i5 != 9 && (!this.d || i5 == 0)) {
            l0(i5);
            throw null;
        }
        return i5;
    }

    protected final int U0() throws XMLStreamException {
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        int i3 = i2 + 1;
        this.h0 = i3;
        char c = cArr[i2];
        if (c == '-') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr2 = this.g0;
            int i4 = this.h0;
            this.h0 = i4 + 1;
            char c2 = cArr2[i4];
            if (c2 != '-') {
                r0(c2, " (expected '-' for COMMENT)");
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
        if (c != '[') {
            r0(c, " (expected either '-' for COMMENT or '[CDATA[' for CDATA section)");
            throw null;
        }
        this.g = 12;
        for (int i5 = 0; i5 < 6; i5++) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr3 = this.g0;
            int i6 = this.h0;
            this.h0 = i6 + 1;
            char c3 = cArr3[i6];
            if (c3 != "CDATA[".charAt(i5)) {
                r0(c3, " (expected '" + "CDATA[".charAt(i5) + "' for CDATA section)");
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

    @Override // i.e.a.j.e0
    protected final boolean W() throws IOException, XMLStreamException {
        Reader reader = this.f0;
        if (reader == null) {
            this.i0 = 0;
            return false;
        }
        long j2 = this.Z;
        int i2 = this.i0;
        this.Z = j2 + i2;
        this.b0 -= i2;
        this.h0 = 0;
        try {
            char[] cArr = this.g0;
            int i3 = reader.read(cArr, 0, cArr.length);
            if (i3 >= 1) {
                this.i0 = i3;
                return true;
            }
            this.i0 = 0;
            if (i3 != 0) {
                return false;
            }
            i0("Reader returned 0 bytes, even when asked to read up to " + this.g0.length);
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected final int W0() throws XMLStreamException {
        this.f1583i--;
        this.g = 2;
        v vVarA = this.D.a();
        this.A = vVarA;
        String strL = vVarA.l();
        int length = strL.length();
        int i2 = 0;
        do {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            if (cArr[i3] != strL.charAt(i2)) {
                u0(strL);
                throw null;
            }
            i2++;
        } while (i2 < length);
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr2 = this.g0;
        int i4 = this.h0;
        this.h0 = i4 + 1;
        char cN1 = cArr2[i4];
        if (cN1 <= ' ') {
            cN1 = n1(false, null);
        } else if (cN1 != '>' && (cN1 == ':' || i.e.a.l.p.d(cN1))) {
            u0(strL);
            throw null;
        }
        if (cN1 == '>') {
            return 2;
        }
        F0(cN1, " expected space or closing '>'");
        throw null;
    }

    protected final int X0(boolean z) throws XMLStreamException {
        String str;
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        int i3 = i2 + 1;
        this.h0 = i3;
        char cR = cArr[i2];
        if (cR == '#') {
            return T0();
        }
        if (cR == 'a') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr2 = this.g0;
            int i4 = this.h0;
            int i5 = i4 + 1;
            this.h0 = i5;
            cR = cArr2[i4];
            if (cR == 'm') {
                if (i5 >= this.i0) {
                    X();
                }
                char[] cArr3 = this.g0;
                int i6 = this.h0;
                int i7 = i6 + 1;
                this.h0 = i7;
                cR = cArr3[i6];
                if (cR == 'p') {
                    if (i7 >= this.i0) {
                        X();
                    }
                    char[] cArr4 = this.g0;
                    int i8 = this.h0;
                    this.h0 = i8 + 1;
                    cR = cArr4[i8];
                    if (cR == ';') {
                        return 38;
                    }
                    str = "amp";
                } else {
                    str = "am";
                }
            } else if (cR == 'p') {
                if (i5 >= this.i0) {
                    X();
                }
                char[] cArr5 = this.g0;
                int i9 = this.h0;
                int i10 = i9 + 1;
                this.h0 = i10;
                cR = cArr5[i9];
                if (cR == 'o') {
                    if (i10 >= this.i0) {
                        X();
                    }
                    char[] cArr6 = this.g0;
                    int i11 = this.h0;
                    int i12 = i11 + 1;
                    this.h0 = i12;
                    cR = cArr6[i11];
                    if (cR == 's') {
                        if (i12 >= this.i0) {
                            X();
                        }
                        char[] cArr7 = this.g0;
                        int i13 = this.h0;
                        this.h0 = i13 + 1;
                        cR = cArr7[i13];
                        if (cR == ';') {
                            return 39;
                        }
                        str = "apos";
                    } else {
                        str = "apo";
                    }
                } else {
                    str = "ap";
                }
            } else {
                str = "a";
            }
        } else if (cR == 'l') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr8 = this.g0;
            int i14 = this.h0;
            int i15 = i14 + 1;
            this.h0 = i15;
            cR = cArr8[i14];
            if (cR == 't') {
                if (i15 >= this.i0) {
                    X();
                }
                char[] cArr9 = this.g0;
                int i16 = this.h0;
                this.h0 = i16 + 1;
                cR = cArr9[i16];
                if (cR == ';') {
                    return 60;
                }
                str = "lt";
            } else {
                str = "l";
            }
        } else if (cR == 'g') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr10 = this.g0;
            int i17 = this.h0;
            int i18 = i17 + 1;
            this.h0 = i18;
            cR = cArr10[i17];
            if (cR == 't') {
                if (i18 >= this.i0) {
                    X();
                }
                char[] cArr11 = this.g0;
                int i19 = this.h0;
                this.h0 = i19 + 1;
                cR = cArr11[i19];
                if (cR == ';') {
                    return 62;
                }
                str = "gt";
            } else {
                str = "g";
            }
        } else if (cR == 'q') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr12 = this.g0;
            int i20 = this.h0;
            int i21 = i20 + 1;
            this.h0 = i21;
            cR = cArr12[i20];
            if (cR == 'u') {
                if (i21 >= this.i0) {
                    X();
                }
                char[] cArr13 = this.g0;
                int i22 = this.h0;
                int i23 = i22 + 1;
                this.h0 = i23;
                cR = cArr13[i22];
                if (cR == 'o') {
                    if (i23 >= this.i0) {
                        X();
                    }
                    char[] cArr14 = this.g0;
                    int i24 = this.h0;
                    int i25 = i24 + 1;
                    this.h0 = i25;
                    cR = cArr14[i24];
                    if (cR == 't') {
                        if (i25 >= this.i0) {
                            X();
                        }
                        char[] cArr15 = this.g0;
                        int i26 = this.h0;
                        this.h0 = i26 + 1;
                        cR = cArr15[i26];
                        if (cR == ';') {
                            return 34;
                        }
                        str = "quot";
                    } else {
                        str = "quo";
                    }
                } else {
                    str = "qu";
                }
            } else {
                str = "q";
            }
        } else {
            str = "";
        }
        int[] iArr = l0.c;
        char[] cArrB = this.t;
        int length = str.length();
        int i27 = 0;
        while (i27 < length) {
            cArrB[i27] = str.charAt(i27);
            i27++;
        }
        while (cR != ';') {
            boolean zD = true;
            if (cR <= 255) {
                zD = (r5 = iArr[cR]) != 0 ? false : false;
            } else if (cR < 57344) {
                int iO0 = O0(cR);
                if (i27 >= cArrB.length) {
                    cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                    this.t = cArrB;
                }
                cArrB[i27] = cR;
                cR = this.g0[this.h0 - 1];
                zD = i.e.a.l.p.d(iO0);
                i27++;
            } else if (cR >= 65534) {
                cR = R(cR);
            }
            if (!zD) {
                j0(cR, i27);
                throw null;
            }
            if (i27 >= cArrB.length) {
                char[] cArrB2 = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB2;
                cArrB = cArrB2;
            }
            int i28 = i27 + 1;
            cArrB[i27] = cR;
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr16 = this.g0;
            int i29 = this.h0;
            this.h0 = i29 + 1;
            cR = cArr16[i29];
            i27 = i28;
        }
        String str2 = new String(cArrB, 0, i27);
        this.A = new w(str2, null, str2, 0);
        if (this.c.c0()) {
            i0("General entity reference (&" + str2 + ";) encountered in entity expanding mode: operation not (yet) implemented");
            throw null;
        }
        if (!z) {
            return 0;
        }
        i0("General entity reference (&" + str2 + ";) encountered in attribute value, in non-entity-expanding mode: no way to handle it");
        throw null;
    }

    @Override // i.e.a.j.e0
    public final int Z(boolean z) throws XMLStreamException {
        if (this.f1582h) {
            C0();
        }
        m1();
        while (true) {
            if (this.h0 >= this.i0 && !W()) {
                m1();
                return -1;
            }
            char[] cArr = this.g0;
            int i2 = this.h0;
            int i3 = i2 + 1;
            this.h0 = i3;
            int i4 = cArr[i2] & 255;
            if (i4 == 60) {
                if (i3 >= this.i0) {
                    Y(5);
                }
                char[] cArr2 = this.g0;
                int i5 = this.h0;
                this.h0 = i5 + 1;
                char c = cArr2[i5];
                if (c == '!') {
                    return a1(z);
                }
                if (c == '?') {
                    return Z0();
                }
                if (c != '/' && z) {
                    return b1(c);
                }
                q0(z, c);
                throw null;
            }
            if (i4 != 32) {
                if (i4 == 10) {
                    e1();
                } else if (i4 == 13) {
                    if (i3 >= this.i0 && !W()) {
                        e1();
                        m1();
                        return -1;
                    }
                    char[] cArr3 = this.g0;
                    int i6 = this.h0;
                    if (cArr3[i6] == '\n') {
                        this.h0 = i6 + 1;
                    }
                    e1();
                } else if (i4 != 9) {
                    p0(z, i4, null);
                    throw null;
                }
            }
        }
    }

    protected final int Z0() throws XMLStreamException {
        this.g = 3;
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        this.h0 = i2 + 1;
        v vVarH1 = h1(cArr[i2]);
        this.A = vVarH1;
        String strI = vVarH1.i();
        if (strI.length() == 3 && strI.equalsIgnoreCase("xml") && this.A.k() == null) {
            i0(i.e.a.i.b.f1565l);
            throw null;
        }
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr2 = this.g0;
        int i3 = this.h0;
        int i4 = i3 + 1;
        this.h0 = i4;
        char c = cArr2[i3];
        if (c <= ' ') {
            while (true) {
                if (c == '\n') {
                    e1();
                } else if (c == '\r') {
                    if (this.h0 >= this.i0) {
                        X();
                    }
                    char[] cArr3 = this.g0;
                    int i5 = this.h0;
                    if (cArr3[i5] == '\n') {
                        this.h0 = i5 + 1;
                    }
                    e1();
                } else if (c != ' ' && c != '\t') {
                    D0(c);
                    throw null;
                }
                if (this.h0 >= this.i0) {
                    X();
                }
                char[] cArr4 = this.g0;
                int i6 = this.h0;
                c = cArr4[i6];
                if (c <= ' ') {
                    this.h0 = i6 + 1;
                } else if (this.f) {
                    this.f1582h = true;
                } else {
                    s();
                }
            }
        } else {
            if (c != '?') {
                m0(c);
                throw null;
            }
            if (i4 >= this.i0) {
                X();
            }
            char[] cArr5 = this.g0;
            int i7 = this.h0;
            this.h0 = i7 + 1;
            char c2 = cArr5[i7];
            if (c2 != '>') {
                m0(c2);
                throw null;
            }
            this.f1584j.x();
            this.f1582h = false;
        }
        return 3;
    }

    @Override // i.e.a.j.e0
    protected void a() throws IOException {
        Reader reader = this.f0;
        if (reader != null) {
            reader.close();
            this.f0 = null;
        }
    }

    @Override // i.e.a.j.e0
    public final int a0() throws XMLStreamException {
        char cD1;
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
                return H0();
            }
        } else if (C0()) {
            return H0();
        }
        m1();
        if (this.h0 >= this.i0 && !W()) {
            m1();
            return -1;
        }
        char[] cArr = this.g0;
        int i3 = this.h0;
        char c = cArr[i3];
        if (c == '<') {
            int i4 = i3 + 1;
            this.h0 = i4;
            if (i4 < this.i0) {
                this.h0 = i4 + 1;
                cD1 = cArr[i4];
            } else {
                cD1 = d1(5);
            }
            return cD1 == '!' ? U0() : cD1 == '?' ? Z0() : cD1 == '/' ? W0() : b1(cD1);
        }
        if (c == '&') {
            this.h0 = i3 + 1;
            int iX0 = X0(false);
            if (iX0 == 0) {
                this.g = 9;
                return 9;
            }
            this.j0 = -iX0;
        } else {
            this.j0 = c;
        }
        if (this.f) {
            this.f1582h = true;
        } else {
            p();
        }
        this.g = 4;
        return 4;
    }

    protected final int a1(boolean z) throws XMLStreamException {
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        int i3 = i2 + 1;
        this.h0 = i3;
        char c = cArr[i2];
        if (c == '-') {
            if (i3 >= this.i0) {
                X();
            }
            char[] cArr2 = this.g0;
            int i4 = this.h0;
            this.h0 = i4 + 1;
            c = cArr2[i4];
            if (c == '-') {
                if (this.f) {
                    this.f1582h = true;
                } else {
                    q();
                }
                this.g = 5;
                return 5;
            }
        } else if (c == 'D' && z) {
            V0();
            if (this.f || !this.f1582h) {
                return 11;
            }
            r(true);
            this.f1582h = false;
            return 11;
        }
        this.f1582h = true;
        this.g = 4;
        p0(z, c, " (expected '-' for COMMENT)");
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void b() {
        char[] cArr;
        super.b();
        if (this.k0.d()) {
            this.c.Z(this.k0);
        }
        if (this.f0 == null || (cArr = this.g0) == null) {
            return;
        }
        this.c.y(cArr);
        this.g0 = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0160, code lost:
    
        Y0(r4, r7);
        r14.J++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x016a, code lost:
    
        r3 = N0(r3, r7, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0170, code lost:
    
        if (r7 != '\n') goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0172, code lost:
    
        e1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0176, code lost:
    
        if (r7 != '\r') goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x017a, code lost:
    
        if (r13 < r14.i0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x017c, code lost:
    
        X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x017f, code lost:
    
        r7 = r14.g0;
        r12 = r14.h0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0185, code lost:
    
        if (r7[r12] != '\n') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0187, code lost:
    
        r14.h0 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x018b, code lost:
    
        e1();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x018f, code lost:
    
        if (r7 == ' ') goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0191, code lost:
    
        if (r7 != '\t') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0194, code lost:
    
        D0(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0197, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0198, code lost:
    
        F0(r7, " expected '='");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x019d, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        r3 = r14.V.h(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bd, code lost:
    
        if (r3 < 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bf, code lost:
    
        r14.W = r3;
        r14.f1583i++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c6, code lost:
    
        if (r2 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cc, code lost:
    
        if (r15.p() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ce, code lost:
    
        r15 = r14.W;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d0, code lost:
    
        if (r1 >= r15) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d2, code lost:
    
        r2 = r14.V.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00dc, code lost:
    
        if (r2.p() == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00de, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e1, code lost:
    
        s0(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e4, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        s0(r14.A, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ea, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00eb, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ec, code lost:
    
        r14.V.j();
        i0(r14.V.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00fa, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0138, code lost:
    
        if (r7 != '=') goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x013e, code lost:
    
        if (r14.h0 < r14.i0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0140, code lost:
    
        X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0143, code lost:
    
        r7 = r14.g0;
        r12 = r14.h0;
        r13 = r12 + 1;
        r14.h0 = r13;
        r7 = r7[r12];
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x014d, code lost:
    
        if (r7 <= ' ') goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0151, code lost:
    
        if (r7 == '\"') goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0155, code lost:
    
        if (r7 != '\'') goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0158, code lost:
    
        F0(r7, " Expected a quote");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x015d, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x015e, code lost:
    
        if (r5 == false) goto L144;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final int b1(char c) throws XMLStreamException {
        boolean zP;
        this.g = 1;
        int i2 = 0;
        this.J = 0;
        v vVarH1 = h1(c);
        String strK = vVarH1.k();
        if (strK == null) {
            zP = true;
        } else {
            vVarH1 = d(vVarH1, strK);
            zP = vVarH1.p();
        }
        this.A = vVarH1;
        this.D = new k(vVarH1, this.D);
        int iN0 = 0;
        while (true) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            char c2 = cArr[i3];
            if (c2 <= ' ') {
                do {
                    if (c2 == '\n') {
                        e1();
                    } else if (c2 == '\r') {
                        if (this.h0 >= this.i0) {
                            X();
                        }
                        char[] cArr2 = this.g0;
                        int i4 = this.h0;
                        if (cArr2[i4] == '\n') {
                            this.h0 = i4 + 1;
                        }
                        e1();
                    } else if (c2 != ' ' && c2 != '\t') {
                        D0(c2);
                        throw null;
                    }
                    if (this.h0 >= this.i0) {
                        X();
                    }
                    char[] cArr3 = this.g0;
                    int i5 = this.h0;
                    this.h0 = i5 + 1;
                    c2 = cArr3[i5];
                } while (c2 <= ' ');
            } else if (c2 != '/' && c2 != '>') {
                F0(c2, " expected space, or '>' or \"/>\"");
                throw null;
            }
            if (c2 == '/') {
                if (this.h0 >= this.i0) {
                    X();
                }
                char[] cArr4 = this.g0;
                int i6 = this.h0;
                this.h0 = i6 + 1;
                char c3 = cArr4[i6];
                if (c3 != '>') {
                    F0(c3, " expected '>'");
                    throw null;
                }
                this.C = true;
            } else {
                if (c2 == '>') {
                    this.C = false;
                    break;
                }
                if (c2 == '<') {
                    i0("Unexpected '<' character in element (missing closing '>'?)");
                    throw null;
                }
                v vVarH12 = h1(c2);
                String strK2 = vVarH12.k();
                if (strK2 == null) {
                    boolean z = vVarH12.i() == "xmlns";
                } else {
                    if (strK2 != "xmlns") {
                        vVarH12 = d(vVarH12, strK2);
                        if (zP) {
                            zP = vVarH12.p();
                        }
                    }
                }
                while (true) {
                    if (this.h0 >= this.i0) {
                        X();
                    }
                    char[] cArr5 = this.g0;
                    int i7 = this.h0;
                    int i8 = i7 + 1;
                    this.h0 = i8;
                    char c4 = cArr5[i7];
                    if (c4 > ' ') {
                        break;
                    }
                    if (c4 == '\n') {
                        e1();
                    } else if (c4 == '\r') {
                        if (i8 >= this.i0) {
                            X();
                        }
                        char[] cArr6 = this.g0;
                        int i9 = this.h0;
                        if (cArr6[i9] == '\n') {
                            this.h0 = i9 + 1;
                        }
                        e1();
                    } else if (c4 != ' ' && c4 != '\t') {
                        D0(c4);
                        throw null;
                    }
                }
            }
        }
    }

    protected final boolean c1(int i2) throws IOException, XMLStreamException {
        int i3;
        if (this.f0 == null) {
            return false;
        }
        long j2 = this.Z;
        int i4 = this.h0;
        this.Z = j2 + i4;
        this.b0 -= i4;
        int i5 = this.i0 - i4;
        char[] cArr = this.g0;
        System.arraycopy(cArr, i4, cArr, 0, i5);
        this.h0 = 0;
        this.i0 = i5;
        do {
            try {
                char[] cArr2 = this.g0;
                int length = cArr2.length;
                int i6 = this.i0;
                int i7 = length - i6;
                int i8 = this.f0.read(cArr2, i6, i7);
                if (i8 < 1) {
                    if (i8 != 0) {
                        return false;
                    }
                    i0("Reader returned 0 bytes, even when asked to read up to " + i7);
                    throw null;
                }
                i3 = this.i0 + i8;
                this.i0 = i3;
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        } while (i3 < i2);
        return true;
    }

    protected final char d1(int i2) throws XMLStreamException {
        if (W()) {
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            return cArr[i3];
        }
        i0("Unexpected end-of-input when trying to parse " + i.e.a.i.b.c(i2));
        throw null;
    }

    protected final void e1() {
        this.b0 = this.h0;
        this.a0++;
    }

    protected final void f1(int i2) {
        this.b0 = i2;
        this.a0++;
    }

    protected v h1(char c) throws XMLStreamException {
        char[] cArrB = this.t;
        if (c < 'A') {
            F0(c, "; expected a name start character");
            throw null;
        }
        cArrB[0] = c;
        int i2 = 1;
        int i3 = c;
        while (true) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i4 = this.h0;
            char c2 = cArr[i4];
            if (c2 < 'A' && (c2 < '-' || c2 > ':' || c2 == '/')) {
                break;
            }
            this.h0 = i4 + 1;
            if (i2 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
            }
            cArrB[i2] = c2;
            i2++;
            i3 = (i3 * 31) + c2;
        }
        w wVarC = this.k0.c(cArrB, 0, i2, i3);
        return wVarC == null ? I0(cArrB, i2, i3) : wVarC;
    }

    protected String i1(char c) throws XMLStreamException {
        char c2;
        char[] cArrB = this.t;
        int[] iArr = i.e.a.l.o.f;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            c2 = cArr[i3];
            if (c2 == c) {
                return new String(cArrB, 0, i2);
            }
            if (c2 > 255 || iArr[c2] != 1) {
                break;
            }
            if (c2 <= ' ') {
                z = true;
            } else {
                if (z) {
                    if (i2 >= cArrB.length) {
                        cArrB = this.f1584j.n();
                        i2 = 0;
                    }
                    cArrB[i2] = Chars.SPACE;
                    i2++;
                    z = false;
                }
                if (i2 >= cArrB.length) {
                    cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                    this.t = cArrB;
                    i2 = 0;
                }
                cArrB[i2] = c2;
                i2++;
            }
        }
        F0(c2, " in public identifier");
        throw null;
    }

    protected String j1(char c) throws XMLStreamException {
        char[] cArrB = this.t;
        int[] iArr = l0.b;
        int i2 = 0;
        while (true) {
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr = this.g0;
            int i3 = this.h0;
            this.h0 = i3 + 1;
            char c2 = cArr[i3];
            if (iArr[c2] != 0) {
                int i4 = iArr[c2];
                if (i4 == 1) {
                    R(c2);
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        e1();
                    } else if (i4 == 14 && c2 == c) {
                        return new String(cArrB, 0, i2);
                    }
                }
                if (this.h0 >= this.i0) {
                    X();
                }
                char[] cArr2 = this.g0;
                int i5 = this.h0;
                if (cArr2[i5] == '\n') {
                    this.h0 = i5 + 1;
                }
                e1();
                c2 = '\n';
            }
            if (i2 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
                i2 = 0;
            }
            cArrB[i2] = c2;
            i2++;
        }
    }

    protected final void m1() {
        this.c0 = this.Z + this.h0;
        this.d0 = this.a0;
        this.e0 = r2 - this.b0;
    }

    protected char n1(boolean z, String str) throws XMLStreamException {
        if (this.h0 >= this.i0) {
            X();
        }
        char[] cArr = this.g0;
        int i2 = this.h0;
        this.h0 = i2 + 1;
        char c = cArr[i2];
        if (c > ' ') {
            if (!z) {
                return c;
            }
            r0(c, " (expected white space " + str + ")");
            throw null;
        }
        do {
            if (c == '\n') {
                e1();
            } else if (c == '\r') {
                if (this.h0 >= this.i0) {
                    X();
                }
                char[] cArr2 = this.g0;
                int i3 = this.h0;
                if (cArr2[i3] == '\n') {
                    this.h0 = i3 + 1;
                }
                e1();
            } else if (c != ' ' && c != '\t') {
                D0(c);
                throw null;
            }
            if (this.h0 >= this.i0) {
                X();
            }
            char[] cArr3 = this.g0;
            int i4 = this.h0;
            this.h0 = i4 + 1;
            c = cArr3[i4];
        } while (c <= ' ');
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void o() throws XMLStreamException {
        char c;
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        char[] cArrX = this.f1584j.x();
        int i2 = 0;
        while (true) {
            int i3 = this.h0;
            if (i3 >= this.i0) {
                X();
                i3 = this.h0;
            }
            if (i2 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i2 = 0;
            }
            int i4 = this.i0;
            int length = (cArrX.length - i2) + i3;
            if (length < i4) {
                i4 = length;
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char cR = cArr[i3];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 == 1) {
                                R(cR);
                            } else if (i6 != 2) {
                                if (i6 == 3) {
                                    e1();
                                } else if (i6 == 11) {
                                    int i7 = 0;
                                    while (true) {
                                        if (this.h0 >= this.i0) {
                                            X();
                                        }
                                        char[] cArr2 = this.g0;
                                        int i8 = this.h0;
                                        c = cArr2[i8];
                                        if (c != ']') {
                                            break;
                                        }
                                        this.h0 = i8 + 1;
                                        i7++;
                                    }
                                    boolean z = c == '>' && i7 >= 1;
                                    if (z) {
                                        i7--;
                                    }
                                    while (i7 > 0) {
                                        int i9 = i2 + 1;
                                        cArrX[i2] = ']';
                                        if (i9 >= cArrX.length) {
                                            cArrX = this.f1584j.n();
                                            i2 = 0;
                                            i7--;
                                        } else {
                                            i2 = i9;
                                            i7--;
                                        }
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            int i10 = this.h0;
                            if (cArr[i10] == '\n') {
                                this.h0 = i10 + 1;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i11 = i2 + 1;
                                cArrX[i2] = cR;
                                if (i11 >= cArrX.length) {
                                    cArrX = this.f1584j.n();
                                    i2 = 0;
                                } else {
                                    i2 = i11;
                                }
                                cR = cL0;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrX[i2] = cR;
                        i2++;
                    } else {
                        cArrX[i2] = cR;
                        i3 = i5;
                        i2++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i5;
                    if (cR > 255) {
                    }
                    cArrX[i2] = cR;
                    i2++;
                } else {
                    cArrX[i2] = cR;
                    i3 = i5;
                    i2++;
                }
            }
            this.h0 = i3;
        }
        this.h0++;
        this.f1584j.A(i2);
        if (!this.e || this.f1585k) {
            return;
        }
        R0();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0133  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void p() throws XMLStreamException {
        int iJ0;
        char[] cArrO;
        int i2;
        int i3 = this.j0;
        if (i3 < 0) {
            int i4 = -i3;
            cArrO = this.f1584j.x();
            if ((i4 >> 16) != 0) {
                int i5 = i4 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                cArrO[0] = (char) ((i5 >> 10) | 55296);
                i4 = (i5 & 1023) | 56320;
                i2 = 1;
            } else {
                i2 = 0;
            }
            iJ0 = i2 + 1;
            cArrO[i2] = (char) i4;
        } else if (i3 == 13 || i3 == 10) {
            this.h0++;
            iJ0 = J0((char) i3);
            if (iJ0 < 0) {
                return;
            } else {
                cArrO = this.f1584j.o();
            }
        } else {
            cArrO = this.f1584j.x();
            iJ0 = 0;
        }
        int[] iArr = l0.a;
        char[] cArr = this.g0;
        while (true) {
            int i6 = this.h0;
            if (i6 >= this.i0) {
                X();
                i6 = this.h0;
            }
            if (iJ0 >= cArrO.length) {
                cArrO = this.f1584j.n();
                iJ0 = 0;
            }
            int i7 = this.i0;
            int length = (cArrO.length - iJ0) + i6;
            if (length < i7) {
                i7 = length;
            }
            while (i6 < i7) {
                int i8 = i6 + 1;
                char cR = cArr[i6];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i8;
                        if (cR > 255) {
                            int i9 = iArr[cR];
                            if (i9 == 1) {
                                R(cR);
                            } else if (i9 != 2) {
                                if (i9 != 3) {
                                    switch (i9) {
                                        case 9:
                                            this.h0--;
                                            break;
                                        case 10:
                                            int iX0 = X0(false);
                                            if (iX0 != 0) {
                                                if ((iX0 >> 16) != 0) {
                                                    int i10 = iX0 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                                    int i11 = iJ0 + 1;
                                                    cArrO[iJ0] = (char) ((i10 >> 10) | 55296);
                                                    if (i11 >= cArrO.length) {
                                                        cArrO = this.f1584j.n();
                                                        iJ0 = 0;
                                                    } else {
                                                        iJ0 = i11;
                                                    }
                                                    iX0 = (i10 & 1023) | 56320;
                                                }
                                                cR = (char) iX0;
                                                break;
                                            } else {
                                                this.f1585k = true;
                                                break;
                                            }
                                        case 11:
                                            int i12 = 1;
                                            while (true) {
                                                if (this.h0 >= this.i0) {
                                                    X();
                                                }
                                                int i13 = this.h0;
                                                char c = cArr[i13];
                                                if (c == ']') {
                                                    this.h0 = i13 + 1;
                                                    i12++;
                                                } else {
                                                    if (c == '>' && i12 > 1) {
                                                        f0();
                                                        throw null;
                                                    }
                                                    while (i12 > 1) {
                                                        int i14 = iJ0 + 1;
                                                        cArrO[iJ0] = ']';
                                                        if (i14 >= cArrO.length) {
                                                            cArrO = this.f1584j.n();
                                                            iJ0 = 0;
                                                        } else {
                                                            iJ0 = i14;
                                                        }
                                                        i12--;
                                                    }
                                                    cR = ']';
                                                    break;
                                                }
                                            }
                                    }
                                } else {
                                    e1();
                                }
                            }
                            int i15 = this.h0;
                            if (i15 >= this.i0) {
                                X();
                                i15 = this.h0;
                            }
                            if (cArr[i15] == '\n') {
                                this.h0++;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i16 = iJ0 + 1;
                                cArrO[iJ0] = cR;
                                if (i16 >= cArrO.length) {
                                    cArrO = this.f1584j.n();
                                    iJ0 = 0;
                                } else {
                                    iJ0 = i16;
                                }
                                cR = cL0;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrO[iJ0] = cR;
                        iJ0++;
                    } else {
                        cArrO[iJ0] = cR;
                        i6 = i8;
                        iJ0++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i8;
                    if (cR > 255) {
                    }
                    cArrO[iJ0] = cR;
                    iJ0++;
                } else {
                    cArrO[iJ0] = cR;
                    i6 = i8;
                    iJ0++;
                }
            }
            this.h0 = i6;
        }
        this.f1584j.A(iJ0);
        if (!this.e || this.f1585k) {
            return;
        }
        R0();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ad  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void q() throws XMLStreamException {
        int i2;
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        char[] cArrX = this.f1584j.x();
        int i3 = 0;
        while (true) {
            int i4 = this.h0;
            if (i4 >= this.i0) {
                X();
                i4 = this.h0;
            }
            if (i3 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i3 = 0;
            }
            int i5 = this.i0;
            int length = (cArrX.length - i3) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (i4 < i5) {
                int i6 = i4 + 1;
                char cR = cArr[i4];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i6;
                        if (cR > 255) {
                            int i7 = iArr[cR];
                            if (i7 == 1) {
                                R(cR);
                            } else if (i7 != 2) {
                                if (i7 == 3) {
                                    e1();
                                } else if (i7 == 13) {
                                    if (this.h0 >= this.i0) {
                                        X();
                                    }
                                    char[] cArr2 = this.g0;
                                    i2 = this.h0;
                                    if (cArr2[i2] == '-') {
                                        break;
                                    }
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            int i8 = this.h0;
                            if (cArr[i8] == '\n') {
                                this.h0 = i8 + 1;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i9 = i3 + 1;
                                cArrX[i3] = cR;
                                if (i9 >= cArrX.length) {
                                    cArrX = this.f1584j.n();
                                    i3 = 0;
                                } else {
                                    i3 = i9;
                                }
                                cR = cL0;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrX[i3] = cR;
                        i3++;
                    } else {
                        cArrX[i3] = cR;
                        i4 = i6;
                        i3++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i6;
                    if (cR > 255) {
                    }
                    cArrX[i3] = cR;
                    i3++;
                } else {
                    cArrX[i3] = cR;
                    i4 = i6;
                    i3++;
                }
            }
            this.h0 = i4;
        }
        int i10 = i2 + 1;
        this.h0 = i10;
        if (i10 >= this.i0) {
            X();
        }
        char[] cArr3 = this.g0;
        int i11 = this.h0;
        this.h0 = i11 + 1;
        if (cArr3[i11] == '>') {
            this.f1584j.A(i3);
        } else {
            b0();
            throw null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x005b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e3 A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void r(boolean z) throws XMLStreamException {
        char[] cArrX = z ? this.f1584j.x() : null;
        int[] iArr = l0.d;
        int i2 = 0;
        char c = 0;
        boolean z2 = false;
        while (true) {
            int i3 = this.h0;
            if (i3 >= this.i0) {
                X();
                i3 = this.h0;
            }
            int i4 = this.i0;
            if (cArrX != null) {
                if (i2 >= cArrX.length) {
                    cArrX = this.f1584j.n();
                    i2 = 0;
                }
                int length = (cArrX.length - i2) + i3;
                if (length < i4) {
                    i4 = length;
                }
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char cR = this.g0[i3];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 == 1) {
                                R(cR);
                            } else if (i6 != 2) {
                                if (i6 != 3) {
                                    switch (i6) {
                                        case 8:
                                            if (c != 0) {
                                                if (c == cR) {
                                                    c = 0;
                                                    break;
                                                }
                                            } else {
                                                c = cR;
                                                break;
                                            }
                                            break;
                                        case 9:
                                            if (!z2) {
                                                z2 = true;
                                                break;
                                            }
                                            break;
                                        case 10:
                                            if (c == 0) {
                                                z2 = false;
                                                break;
                                            }
                                            break;
                                    }
                                    if (!z2 && c == 0) {
                                        if (cArrX != null) {
                                            this.f1584j.A(i2);
                                        }
                                        char cN1 = n1(false, null);
                                        if (cN1 == '>') {
                                            return;
                                        }
                                        F0(cN1, " expected '>' after the internal subset");
                                        throw null;
                                    }
                                } else {
                                    e1();
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            char[] cArr = this.g0;
                            int i7 = this.h0;
                            if (cArr[i7] == '\n') {
                                this.h0 = i7 + 1;
                            }
                            e1();
                            cR = '\n';
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                if (cArrX != null) {
                                    int i8 = i2 + 1;
                                    cArrX[i2] = cR;
                                    if (i8 >= cArrX.length) {
                                        cArrX = this.f1584j.n();
                                        i2 = 0;
                                    } else {
                                        i2 = i8;
                                    }
                                }
                                cR = cL0;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        if (cArrX == null) {
                            cArrX[i2] = cR;
                            i2++;
                        }
                    }
                    if (cArrX == null) {
                        cArrX[i2] = cR;
                        i2++;
                    }
                    i3 = i5;
                } else {
                    if (cR >= 55296) {
                        this.h0 = i5;
                        if (cR > 255) {
                        }
                        if (cArrX == null) {
                        }
                    }
                    if (cArrX == null) {
                    }
                    i3 = i5;
                }
            }
            this.h0 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void s() throws XMLStreamException {
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        char[] cArrX = this.f1584j.x();
        int i2 = 0;
        while (true) {
            int i3 = this.h0;
            if (i3 >= this.i0) {
                X();
                i3 = this.h0;
            }
            if (i2 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i2 = 0;
            }
            int i4 = this.i0;
            int length = (cArrX.length - i2) + i3;
            if (length < i4) {
                i4 = length;
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char cR = cArr[i3];
                if (cR <= 255) {
                    if (iArr[cR] != 0) {
                        this.h0 = i5;
                        if (cR > 255) {
                            int i6 = iArr[cR];
                            if (i6 == 2) {
                                if (this.h0 >= this.i0) {
                                    X();
                                }
                                int i7 = this.h0;
                                if (cArr[i7] == '\n') {
                                    this.h0 = i7 + 1;
                                }
                                e1();
                                cR = '\n';
                            } else if (i6 == 3) {
                                e1();
                            } else if (i6 == 12) {
                                if (this.h0 >= this.i0) {
                                    X();
                                }
                                char[] cArr2 = this.g0;
                                int i8 = this.h0;
                                if (cArr2[i8] == '>') {
                                    this.h0 = i8 + 1;
                                    this.f1584j.A(i2);
                                    return;
                                }
                            }
                        } else if (cR >= 55296) {
                            if (cR < 57344) {
                                char cL0 = L0(cR);
                                int i9 = i2 + 1;
                                cArrX[i2] = cR;
                                if (i9 >= cArrX.length) {
                                    cArrX = this.f1584j.n();
                                    i2 = 0;
                                } else {
                                    i2 = i9;
                                }
                                cR = cL0;
                            } else if (cR >= 65534) {
                                cR = R(cR);
                            }
                        }
                        cArrX[i2] = cR;
                        i2++;
                    } else {
                        cArrX[i2] = cR;
                        i3 = i5;
                        i2++;
                    }
                } else if (cR >= 55296) {
                    this.h0 = i5;
                    if (cR > 255) {
                    }
                    cArrX[i2] = cR;
                    i2++;
                } else {
                    cArrX[i2] = cR;
                    i3 = i5;
                    i2++;
                }
            }
            this.h0 = i3;
        }
    }

    @Override // i.e.a.j.e0
    protected final void t() throws XMLStreamException {
        this.f1582h = false;
        int i2 = this.g;
        if (i2 == 3) {
            s();
            return;
        }
        if (i2 == 4) {
            p();
            return;
        }
        if (i2 == 5) {
            q();
            return;
        }
        if (i2 == 6) {
            S0();
            return;
        }
        if (i2 == 11) {
            r(true);
        } else if (i2 == 12) {
            o();
        } else {
            i.e.a.i.b.a();
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x002d A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void w0() throws XMLStreamException {
        int i2;
        char c;
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        while (true) {
            int i3 = this.h0;
            int i4 = this.i0;
            if (i3 >= i4) {
                X();
                i3 = this.h0;
                i4 = this.i0;
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 <= 255) {
                    if (iArr[c2] != 0) {
                        this.h0 = i5;
                        if (c2 > 255) {
                            int i6 = iArr[c2];
                            if (i6 == 1) {
                                R(c2);
                            } else if (i6 != 2) {
                                if (i6 == 3) {
                                    e1();
                                } else if (i6 != 11) {
                                    continue;
                                } else {
                                    int i7 = 0;
                                    do {
                                        if (this.h0 >= this.i0) {
                                            X();
                                        }
                                        i7++;
                                        char[] cArr2 = this.g0;
                                        int i8 = this.h0;
                                        i2 = i8 + 1;
                                        this.h0 = i2;
                                        c = cArr2[i8];
                                    } while (c == ']');
                                    if (c != '>') {
                                        this.h0 = i2 - 1;
                                    } else if (i7 > 1) {
                                        return;
                                    }
                                }
                            }
                            int i9 = this.h0;
                            if (i9 >= this.i0) {
                                X();
                                i9 = this.h0;
                            }
                            if (cArr[i9] == '\n') {
                                i9++;
                                this.h0++;
                            }
                            f1(i9);
                        } else if (c2 >= 55296) {
                            if (c2 < 57344) {
                                L0(c2);
                            } else if (c2 >= 65534) {
                                R(c2);
                            }
                        }
                    } else {
                        i3 = i5;
                    }
                } else if (c2 >= 55296) {
                    this.h0 = i5;
                    if (c2 > 255) {
                    }
                } else {
                    i3 = i5;
                }
            }
            this.h0 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002d A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean x0() throws XMLStreamException {
        int[] iArr = l0.a;
        char[] cArr = this.g0;
        while (true) {
            int i2 = this.h0;
            int i3 = this.i0;
            if (i2 >= i3) {
                X();
                i2 = this.h0;
                i3 = this.i0;
            }
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c = cArr[i2];
                if (c <= 255) {
                    if (iArr[c] != 0) {
                        this.h0 = i4;
                        if (c > 255) {
                            int i5 = iArr[c];
                            if (i5 == 1) {
                                R(c);
                            } else if (i5 != 2) {
                                if (i5 != 3) {
                                    switch (i5) {
                                        case 9:
                                            this.h0--;
                                            return false;
                                        case 10:
                                            if (X0(false) != 0) {
                                                break;
                                            } else {
                                                return true;
                                            }
                                        case 11:
                                            int i6 = 1;
                                            while (true) {
                                                if (this.h0 >= this.i0) {
                                                    X();
                                                }
                                                int i7 = this.h0;
                                                char c2 = cArr[i7];
                                                if (c2 == ']') {
                                                    this.h0 = i7 + 1;
                                                    i6++;
                                                } else {
                                                    if (c2 == '>' && i6 > 1) {
                                                        f0();
                                                        throw null;
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    e1();
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            int i8 = this.h0;
                            if (cArr[i8] == '\n') {
                                this.h0 = i8 + 1;
                            }
                            e1();
                        } else if (c >= 55296) {
                            if (c < 57344) {
                                L0(c);
                            } else if (c >= 65534) {
                                R(c);
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                } else if (c >= 55296) {
                    this.h0 = i4;
                    if (c > 255) {
                    }
                } else {
                    i2 = i4;
                }
            }
            this.h0 = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        return false;
     */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean y0() throws XMLStreamException {
        while (true) {
            if (this.h0 >= this.i0 && !W()) {
                return false;
            }
            char[] cArr = this.g0;
            int i2 = this.h0;
            if (cArr[i2] == '<') {
                if (i2 + 3 >= this.i0 && !c1(3)) {
                    return false;
                }
                char[] cArr2 = this.g0;
                int i3 = this.h0;
                if (cArr2[i3 + 1] != '!' || cArr2[i3 + 2] != '[') {
                    break;
                }
                this.h0 = i3 + 3;
                for (int i4 = 0; i4 < 6; i4++) {
                    if (this.h0 >= this.i0) {
                        X();
                    }
                    char[] cArr3 = this.g0;
                    int i5 = this.h0;
                    this.h0 = i5 + 1;
                    char c = cArr3[i5];
                    if (c != "CDATA[".charAt(i4)) {
                        r0(c, " (expected '" + "CDATA[".charAt(i4) + "' for CDATA section)");
                        throw null;
                    }
                }
                w0();
            } else if (x0()) {
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0006 A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void z0() throws XMLStreamException {
        int i2;
        int[] iArr = l0.e;
        char[] cArr = this.g0;
        while (true) {
            int i3 = this.h0;
            int i4 = this.i0;
            if (i3 >= i4) {
                X();
                i3 = this.h0;
                i4 = this.i0;
            }
            while (i3 < i4) {
                int i5 = i3 + 1;
                char c = cArr[i3];
                if (c <= 255) {
                    if (iArr[c] != 0) {
                        this.h0 = i5;
                        if (c > 255) {
                            continue;
                        } else {
                            int i6 = iArr[c];
                            if (i6 == 1) {
                                R(c);
                            } else if (i6 != 2) {
                                if (i6 == 3) {
                                    e1();
                                } else if (i6 == 13) {
                                    if (this.h0 >= this.i0) {
                                        X();
                                    }
                                    char[] cArr2 = this.g0;
                                    i2 = this.h0;
                                    if (cArr2[i2] == '-') {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (this.h0 >= this.i0) {
                                X();
                            }
                            int i7 = this.h0;
                            if (cArr[i7] == '\n') {
                                this.h0 = i7 + 1;
                            }
                            e1();
                        }
                    } else {
                        i3 = i5;
                    }
                } else if (c >= 55296) {
                    this.h0 = i5;
                    if (c > 255) {
                    }
                } else {
                    i3 = i5;
                }
            }
            this.h0 = i3;
        }
        int i8 = i2 + 1;
        this.h0 = i8;
        if (i8 >= this.i0) {
            X();
        }
        char[] cArr3 = this.g0;
        int i9 = this.h0;
        this.h0 = i9 + 1;
        if (cArr3[i9] == '>') {
            return;
        }
        b0();
        throw null;
    }

    public a0(z zVar, Reader reader) {
        super(zVar);
        this.j0 = 0;
        this.f0 = reader;
        this.g0 = zVar.i(4000);
        this.i0 = 0;
        this.h0 = 0;
        this.Z = 0L;
        this.b0 = 0;
        this.k0 = zVar.D();
    }
}
