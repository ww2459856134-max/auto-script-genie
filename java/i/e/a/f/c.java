package i.e.a.f;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import i.e.a.j.f;
import i.e.a.j.v;
import i.e.a.j.z;
import i.e.a.l.o;
import java.io.IOException;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class c extends f {
    protected o i0;
    protected i.e.a.j.e j0;
    protected int[] k0;
    protected int l0;
    protected int m0;
    protected int n0;
    protected boolean o0;
    protected int p0;
    protected int q0;
    protected int r0;
    protected int s0;
    protected boolean t0;
    protected byte u0;
    protected v v0;
    protected int w0;
    protected int x0;
    protected boolean y0;

    protected c(z zVar) {
        super(zVar);
        this.k0 = new int[32];
        this.l0 = 257;
        this.n0 = 0;
        this.o0 = false;
        this.r0 = 0;
        this.s0 = 0;
    }

    private final v S0(byte b) throws XMLStreamException {
        int i2 = b & 255;
        if (i2 < 65) {
            F0(i2, "; expected a name start character");
            throw null;
        }
        this.p0 = 0;
        this.q0 = i2;
        this.r0 = 1;
        return T0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        return Q0(r0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        return Q0(r0, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
    
        return Q0(r0, 2);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x007d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final v T0() throws XMLStreamException {
        int i2;
        int iR0 = this.q0;
        while (true) {
            int i3 = this.r0;
            if (i3 == 0) {
                if (this.f0 < this.g0) {
                    iR0 = R0() & 255;
                    if (iR0 < 65 && (iR0 < 45 || iR0 > 58 || iR0 == 47)) {
                        break;
                    }
                } else {
                    return null;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                        }
                        i2 = this.p0;
                        if (i2 != 0) {
                            this.k0[0] = iR0;
                            this.p0 = 1;
                        } else {
                            int[] iArr = this.k0;
                            if (i2 >= iArr.length) {
                                this.k0 = i.e.a.l.c.c(iArr, iArr.length);
                            }
                            int[] iArr2 = this.k0;
                            int i4 = this.p0;
                            this.p0 = i4 + 1;
                            iArr2[i4] = iR0;
                        }
                        this.r0 = 0;
                    }
                    if (this.f0 >= this.g0) {
                        int iR02 = R0() & 255;
                        if (iR02 < 65 && (iR02 < 45 || iR02 > 58 || iR02 == 47)) {
                            break;
                        }
                        iR0 = (iR0 << 8) | iR02;
                        i2 = this.p0;
                        if (i2 != 0) {
                        }
                        this.r0 = 0;
                    } else {
                        this.q0 = iR0;
                        this.r0 = 3;
                        return null;
                    }
                }
                if (this.f0 >= this.g0) {
                    int iR03 = R0() & 255;
                    if (iR03 < 65 && (iR03 < 45 || iR03 > 58 || iR03 == 47)) {
                        break;
                    }
                    iR0 = (iR0 << 8) | iR03;
                    if (this.f0 >= this.g0) {
                    }
                } else {
                    this.q0 = iR0;
                    this.r0 = 2;
                    return null;
                }
            }
            if (this.f0 < this.g0) {
                int iR04 = R0() & 255;
                if (iR04 < 65 && (iR04 < 45 || iR04 > 58 || iR04 == 47)) {
                    break;
                }
                iR0 = (iR0 << 8) | iR04;
                if (this.f0 >= this.g0) {
                }
            } else {
                this.q0 = iR0;
                this.r0 = 1;
                return null;
            }
        }
        return Q0(iR0, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x021a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int c1() throws XMLStreamException {
        byte bR0;
        byte bR02;
        int i2;
        byte bR03;
        if (this.n0 == -1 && !f1()) {
            return 257;
        }
        if (this.m0 == 16) {
            if (!d1(false)) {
                return 257;
            }
            this.m0 = 50;
        }
        while (this.f0 < this.g0) {
            int i3 = this.m0;
            if (i3 != 50) {
                switch (i3) {
                    case 0:
                        v vVarL1 = l1((byte) 68);
                        this.A = vVarL1;
                        if (vVarL1 == null) {
                            this.m0 = 1;
                            return 257;
                        }
                        if (!"DOCTYPE".equals(vVarL1.l())) {
                            o0(true, "expected 'DOCTYPE'");
                            throw null;
                        }
                        this.m0 = 2;
                    case 1:
                        v vVarM1 = m1();
                        this.A = vVarM1;
                        if (vVarM1 == null) {
                            this.m0 = 1;
                            return 257;
                        }
                        if (!"DOCTYPE".equals(vVarM1.l())) {
                            o0(true, "expected 'DOCTYPE'");
                            throw null;
                        }
                        if (this.f0 >= this.g0) {
                            continue;
                        } else {
                            bR0 = R0();
                            if (bR0 == 32 && bR0 != 13 && bR0 != 10 && bR0 != 9) {
                                I0(bR0);
                                p0(true, bR0, " (expected space after 'DOCTYPE')");
                                throw null;
                            }
                            this.m0 = 3;
                            if (X0()) {
                                v vVarL12 = l1(R0());
                                this.A = vVarL12;
                                if (vVarL12 == null) {
                                    this.m0 = 4;
                                } else {
                                    this.m0 = 4;
                                }
                            }
                        }
                    case 2:
                        bR0 = R0();
                        if (bR0 == 32) {
                        }
                        this.m0 = 3;
                        if (X0()) {
                        }
                        break;
                    case 3:
                        if (X0()) {
                        }
                        break;
                    case 4:
                        v vVarM12 = m1();
                        this.A = vVarM12;
                        if (vVarM12 == null) {
                            continue;
                        } else {
                            this.m0 = 5;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else {
                                bR02 = R0();
                                if (bR02 != 62) {
                                    this.m0 = 0;
                                    this.l0 = 257;
                                    return 11;
                                }
                                if (bR02 != 32 && bR02 != 13 && bR02 != 10 && bR02 != 9) {
                                    I0(bR02);
                                    p0(true, bR02, " (expected space after root name in DOCTYPE declaration)");
                                    throw null;
                                }
                                this.m0 = 6;
                                if (X0()) {
                                    byte bR04 = R0();
                                    if (bR04 == 62) {
                                        this.m0 = 0;
                                        this.l0 = 257;
                                        return 11;
                                    }
                                    v vVarL13 = l1(bR04);
                                    if (vVarL13 == null) {
                                        this.m0 = 7;
                                    } else {
                                        String strL = vVarL13.l();
                                        if ("PUBLIC".equals(strL)) {
                                            this.m0 = 8;
                                        } else {
                                            if (!"SYSTEM".equals(strL)) {
                                                o0(true, "unexpected token '" + strL + "': expected either PUBLIC or SYSTEM");
                                                throw null;
                                            }
                                            this.m0 = 9;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    case 5:
                        bR02 = R0();
                        if (bR02 != 62) {
                        }
                        break;
                    case 6:
                        if (X0()) {
                        }
                        break;
                    case 7:
                        v vVarM13 = m1();
                        if (vVarM13 == null) {
                            this.m0 = 7;
                        } else {
                            String strL2 = vVarM13.l();
                            if ("PUBLIC".equals(strL2)) {
                                this.m0 = 8;
                            } else {
                                if (!"SYSTEM".equals(strL2)) {
                                    o0(true, "unexpected token '" + strL2 + "': expected either PUBLIC or SYSTEM");
                                    throw null;
                                }
                                this.m0 = 9;
                            }
                        }
                    case 8:
                        byte bR05 = R0();
                        if (bR05 == 32 || bR05 == 13) {
                            i2 = 10;
                        } else {
                            i2 = 10;
                            if (bR05 != 10 && bR05 != 9) {
                                I0(bR05);
                                p0(true, bR05, " (expected space after PUBLIC keyword)");
                                throw null;
                            }
                        }
                        this.m0 = i2;
                        break;
                    case 9:
                        byte bR06 = R0();
                        if (bR06 != 32 && bR06 != 13 && bR06 != 10 && bR06 != 9) {
                            I0(bR06);
                            p0(true, bR06, " (expected space after SYSTEM keyword)");
                            throw null;
                        }
                        this.m0 = 13;
                    case 10:
                        if (X0()) {
                            byte bR07 = R0();
                            this.u0 = bR07;
                            if (bR07 != 34 && bR07 != 39) {
                                I0(bR07);
                                p0(true, bR07, " (expected '\"' or ''' for PUBLIC ID)");
                                throw null;
                            }
                            char[] cArrX = this.f1584j.x();
                            if (this.f0 >= this.g0 || !k1(cArrX, 0, false)) {
                                this.m0 = 11;
                            } else {
                                t1();
                                this.m0 = 12;
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 11:
                        if (k1(this.f1584j.o(), this.f1584j.p(), false)) {
                            t1();
                            this.m0 = 12;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else {
                                bR03 = R0();
                                if (bR03 == 32 && bR03 != 13 && bR03 != 10 && bR03 != 9) {
                                    I0(bR03);
                                    p0(true, bR03, " (expected space after PUBLIC ID)");
                                    throw null;
                                }
                                this.m0 = 13;
                                if (X0()) {
                                    byte bR08 = R0();
                                    this.u0 = bR08;
                                    if (bR08 != 34 && bR08 != 39) {
                                        I0(bR08);
                                        p0(true, bR08, " (expected '\"' or ''' for SYSTEM ID)");
                                        throw null;
                                    }
                                    char[] cArrX2 = this.f1584j.x();
                                    if (this.f0 >= this.g0 || !k1(cArrX2, 0, true)) {
                                        this.m0 = 14;
                                    } else {
                                        u1();
                                        this.m0 = 15;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 12:
                        bR03 = R0();
                        if (bR03 == 32) {
                        }
                        this.m0 = 13;
                        if (X0()) {
                        }
                        break;
                    case 13:
                        if (X0()) {
                        }
                        break;
                    case 14:
                        if (k1(this.f1584j.o(), this.f1584j.p(), true)) {
                            u1();
                            this.m0 = 15;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else if (X0()) {
                                byte bR09 = R0();
                                if (bR09 == 62) {
                                    this.m0 = 0;
                                    this.l0 = 257;
                                    return 11;
                                }
                                if (bR09 != 91) {
                                    byte b = this.u0;
                                    I0(b);
                                    p0(true, b, " (expected either '[' for internal subset, or '>' to end DOCTYPE)");
                                    throw null;
                                }
                                this.m0 = 16;
                                if (!d1(true)) {
                                    return 257;
                                }
                                this.m0 = 50;
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    case 15:
                        if (X0()) {
                        }
                        break;
                    default:
                        q1();
                        throw null;
                }
            }
            if (X0()) {
                byte bR010 = R0();
                if (bR010 != 62) {
                    p0(true, bR010, "expected '>' to end DTD");
                    throw null;
                }
                this.m0 = 0;
                this.l0 = 257;
                return 11;
            }
        }
        return this.g;
    }

    private final int g1(boolean z) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            return 257;
        }
        byte bR0 = R0();
        if (bR0 == 45) {
            this.l0 = 5;
            this.m0 = 0;
            return b1();
        }
        if (bR0 == 68) {
            this.l0 = 11;
            this.m0 = 0;
            return c1();
        }
        I0(bR0);
        p0(z, bR0, " (expected '-' for COMMENT)");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:276:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x014e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x029b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x033a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0353 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0010 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int j1() throws XMLStreamException {
        byte bR0;
        byte b;
        byte bR02;
        if (this.n0 == -1 && !f1()) {
            return 257;
        }
        while (this.f0 < this.g0) {
            switch (this.m0) {
                case 1:
                    byte bR03 = R0();
                    if (bR03 != 32 && bR03 != 13 && bR03 != 10 && bR03 != 9) {
                        I0(bR03);
                        p0(true, bR03, " (expected space after 'xml' in xml declaration)");
                        throw null;
                    }
                    this.m0 = 2;
                    if (this.f0 >= this.g0) {
                        continue;
                    } else if (X0()) {
                        continue;
                    } else {
                        v vVarS0 = S0(R0());
                        this.A = vVarS0;
                        if (vVarS0 == null) {
                            this.m0 = 3;
                        } else {
                            if (!vVarS0.o("version")) {
                                i0("Unexpected keyword '" + this.A.l() + "' in XML declaration: expected 'version'");
                                throw null;
                            }
                            this.m0 = 4;
                        }
                    }
                    break;
                case 2:
                    if (X0()) {
                    }
                    break;
                case 3:
                    v vVarT0 = T0();
                    this.A = vVarT0;
                    if (vVarT0 == null) {
                        continue;
                    } else {
                        if (!vVarT0.o("version")) {
                            i0("Unexpected keyword '" + this.A.l() + "' in XML declaration: expected 'version'");
                            throw null;
                        }
                        this.m0 = 4;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else if (X0()) {
                            byte bR04 = R0();
                            if (bR04 != 61) {
                                I0(bR04);
                                p0(true, bR04, " (expected '=' after 'version' in xml declaration)");
                                throw null;
                            }
                            this.m0 = 5;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else if (X0()) {
                                continue;
                            } else {
                                byte bR05 = R0();
                                this.u0 = bR05;
                                if (bR05 != 34 && bR05 != 39) {
                                    I0(bR05);
                                    p0(true, bR05, " (expected '\"' or ''' in xml declaration for version value)");
                                    throw null;
                                }
                                char[] cArrX = this.f1584j.x();
                                if (this.f0 >= this.g0 || !n1(cArrX, 0)) {
                                    this.m0 = 6;
                                } else {
                                    x1();
                                    this.m0 = 7;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 4:
                    if (X0()) {
                    }
                    break;
                case 5:
                    if (X0()) {
                    }
                    break;
                case 6:
                    if (n1(this.f1584j.o(), this.f1584j.p())) {
                        x1();
                        this.m0 = 7;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else {
                            bR0 = R0();
                            if (bR0 != 63) {
                                this.m0 = 20;
                            } else {
                                if (bR0 != 32 && bR0 != 13 && bR0 != 10 && bR0 != 9) {
                                    I0(bR0);
                                    p0(true, bR0, " (expected space after version value in xml declaration)");
                                    throw null;
                                }
                                this.m0 = 8;
                                if (this.f0 >= this.g0) {
                                    continue;
                                } else if (X0()) {
                                    byte bR06 = R0();
                                    if (bR06 == 63) {
                                        this.m0 = 20;
                                    } else {
                                        v vVarS02 = S0(bR06);
                                        this.A = vVarS02;
                                        if (vVarS02 == null) {
                                            this.m0 = 9;
                                        } else if (vVarS02.o("encoding")) {
                                            this.m0 = 10;
                                        } else {
                                            if (!this.A.o("standalone")) {
                                                i0("Unexpected keyword '" + this.A.l() + "' in XML declaration: expected 'encoding'");
                                                throw null;
                                            }
                                            this.m0 = 16;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    } else {
                        this.m0 = 6;
                    }
                    break;
                case 7:
                    bR0 = R0();
                    if (bR0 != 63) {
                    }
                    break;
                case 8:
                    if (X0()) {
                    }
                    break;
                case 9:
                    v vVarT02 = T0();
                    this.A = vVarT02;
                    if (vVarT02 == null) {
                        continue;
                    } else if (vVarT02.o("encoding")) {
                        this.m0 = 10;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else if (X0()) {
                            byte bR07 = R0();
                            if (bR07 != 61) {
                                I0(bR07);
                                p0(true, bR07, " (expected '=' after 'encoding' in xml declaration)");
                                throw null;
                            }
                            this.m0 = 11;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else if (X0()) {
                                continue;
                            } else {
                                byte bR08 = R0();
                                this.u0 = bR08;
                                if (bR08 != 34 && bR08 != 39) {
                                    I0(bR08);
                                    p0(true, bR08, " (expected '\"' or ''' in xml declaration for encoding value)");
                                    throw null;
                                }
                                this.m0 = 12;
                                char[] cArrX2 = this.f1584j.x();
                                if (this.f0 >= this.g0 || !n1(cArrX2, 0)) {
                                    this.m0 = 12;
                                } else {
                                    v1();
                                    this.m0 = 13;
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (!this.A.o("standalone")) {
                            i0("Unexpected keyword '" + this.A.l() + "' in XML declaration: expected 'encoding'");
                            throw null;
                        }
                        this.m0 = 16;
                    }
                    break;
                case 10:
                    if (X0()) {
                    }
                    break;
                case 11:
                    if (X0()) {
                    }
                    break;
                case 12:
                    if (n1(this.f1584j.o(), this.f1584j.p())) {
                        v1();
                        b = 13;
                        this.m0 = 13;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else {
                            bR02 = R0();
                            if (bR02 != 63) {
                                this.m0 = 20;
                            } else {
                                if (bR02 != 32 && bR02 != b && bR02 != 10 && bR02 != 9) {
                                    I0(bR02);
                                    p0(true, bR02, " (expected space after encoding value in xml declaration)");
                                    throw null;
                                }
                                this.m0 = 14;
                                if (this.f0 >= this.g0) {
                                    continue;
                                } else if (X0()) {
                                    byte bR09 = R0();
                                    if (bR09 == 63) {
                                        this.m0 = 20;
                                    } else {
                                        v vVarS03 = S0(bR09);
                                        this.A = vVarS03;
                                        if (vVarS03 == null) {
                                            this.m0 = 15;
                                        } else {
                                            if (!vVarS03.o("standalone")) {
                                                i0("Unexpected keyword '" + this.A.l() + "' in XML declaration: expected 'standalone'");
                                                throw null;
                                            }
                                            this.m0 = 16;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    } else {
                        this.m0 = 12;
                    }
                case 13:
                    b = 13;
                    bR02 = R0();
                    if (bR02 != 63) {
                    }
                    break;
                case 14:
                    if (X0()) {
                    }
                    break;
                case 15:
                    v vVarT03 = T0();
                    this.A = vVarT03;
                    if (vVarT03 == null) {
                        continue;
                    } else {
                        if (!vVarT03.o("standalone")) {
                            i0("Unexpected keyword 'encoding' in XML declaration: expected 'standalone'");
                            throw null;
                        }
                        this.m0 = 16;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else if (X0()) {
                            byte bR010 = R0();
                            if (bR010 != 61) {
                                I0(bR010);
                                p0(true, bR010, " (expected '=' after 'standalone' in xml declaration)");
                                throw null;
                            }
                            this.m0 = 17;
                            if (this.f0 >= this.g0) {
                                continue;
                            } else if (X0()) {
                                continue;
                            } else {
                                byte bR011 = R0();
                                this.u0 = bR011;
                                if (bR011 != 34 && bR011 != 39) {
                                    I0(bR011);
                                    p0(true, bR011, " (expected '\"' or ''' in xml declaration for standalone value)");
                                    throw null;
                                }
                                char[] cArrX3 = this.f1584j.x();
                                if (this.f0 >= this.g0 || !n1(cArrX3, 0)) {
                                    this.m0 = 18;
                                } else {
                                    w1();
                                    this.m0 = 19;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 16:
                    if (X0()) {
                    }
                    break;
                case 17:
                    if (X0()) {
                    }
                    break;
                case 18:
                    if (n1(this.f1584j.o(), this.f1584j.p())) {
                        w1();
                        this.m0 = 19;
                        if (this.f0 >= this.g0) {
                            continue;
                        } else if (!X0()) {
                            continue;
                        } else {
                            if (R0() != 63) {
                                byte bU0 = U0();
                                I0(bU0);
                                p0(true, bU0, " (expected '?>' to end xml declaration)");
                                throw null;
                            }
                            this.m0 = 20;
                            if (this.f0 < this.g0) {
                                this.A = null;
                                this.m0 = 0;
                                this.l0 = 257;
                                if (R0() != 62) {
                                    O0();
                                    return 7;
                                }
                                byte bU02 = U0();
                                I0(bU02);
                                p0(true, bU02, " (expected '>' to end xml declaration)");
                                throw null;
                            }
                        }
                    } else {
                        this.m0 = 18;
                    }
                case 19:
                    if (!X0()) {
                    }
                    break;
                case 20:
                    this.A = null;
                    this.m0 = 0;
                    this.l0 = 257;
                    if (R0() != 62) {
                    }
                    break;
                default:
                    q1();
                    throw null;
            }
        }
        return 257;
    }

    private final boolean k1(char[] cArr, int i2, boolean z) throws XMLStreamException {
        byte b = this.u0;
        while (this.f0 < this.g0) {
            int iR0 = R0() & 255;
            if (iR0 == b) {
                this.f1584j.A(i2);
                return true;
            }
            if (!z && !r1(iR0)) {
                byte b2 = (byte) iR0;
                I0(b2);
                StringBuilder sb = new StringBuilder();
                sb.append(" (not valid in ");
                sb.append(z ? "SYSTEM" : "PUBLIC");
                sb.append(" ID)");
                p0(true, b2, sb.toString());
                throw null;
            }
            if (i2 >= cArr.length) {
                cArr = this.f1584j.n();
                i2 = 0;
            }
            cArr[i2] = (char) iR0;
            i2++;
        }
        this.f1584j.A(i2);
        return false;
    }

    private final Boolean p1() throws XMLStreamException {
        if (this.f0 >= this.g0) {
            return null;
        }
        if (this.n0 == -5) {
            if (P0() != 63) {
                this.n0 = 0;
                this.m0 = 2;
                return Boolean.FALSE;
            }
            int i2 = this.f0 + 1;
            this.f0 = i2;
            this.n0 = -6;
            if (i2 >= this.g0) {
                return null;
            }
        }
        int i3 = this.n0;
        if (i3 == -6) {
            v vVarS0 = S0(R0());
            this.A = vVarS0;
            if (vVarS0 == null) {
                this.n0 = -7;
                return null;
            }
            if (!"xml".equals(vVarS0.l())) {
                this.n0 = 0;
                this.m0 = 1;
                this.l0 = 3;
                Y0(this.A);
                return Boolean.FALSE;
            }
        } else {
            if (i3 != -7) {
                q1();
                throw null;
            }
            v vVarT0 = T0();
            this.A = vVarT0;
            if (vVarT0 == null) {
                return null;
            }
            if (!"xml".equals(vVarT0.l())) {
                this.n0 = 0;
                this.m0 = 1;
                this.l0 = 3;
                Y0(this.A);
                return Boolean.FALSE;
            }
        }
        this.n0 = 0;
        this.l0 = 7;
        this.m0 = 1;
        return Boolean.TRUE;
    }

    @Override // i.e.a.j.e0
    protected void A0() throws XMLStreamException {
        q1();
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void B0() throws XMLStreamException {
        q1();
        throw null;
    }

    @Override // i.e.a.j.f
    protected int I0(byte b) throws XMLStreamException {
        return b;
    }

    protected void O0() {
        if (this.j0 == null) {
            this.i0 = this.c.E();
            this.j0 = this.c.C();
        }
    }

    protected abstract byte P0() throws XMLStreamException;

    protected final v Q0(int i2, int i3) throws XMLStreamException {
        v vVarB;
        int i4 = this.p0;
        if (i3 == 0) {
            i4--;
            i2 = this.k0[i4];
        }
        if (i4 == 0) {
            vVarB = e.b(i2);
        } else if (i4 == 1) {
            vVarB = e.c(this.k0[0], i2);
        } else if (i4 != 2) {
            vVarB = null;
        } else {
            int[] iArr = this.k0;
            vVarB = e.d(iArr[0], iArr[1], i2);
        }
        if (vVarB != null) {
            this.f0--;
            return vVarB;
        }
        O0();
        return Z0(i2, i3);
    }

    protected abstract byte R0() throws XMLStreamException;

    protected abstract byte U0() throws XMLStreamException;

    protected int V0() throws XMLStreamException {
        O0();
        this.g = 7;
        return 7;
    }

    @Override // i.e.a.j.e0
    protected boolean W() throws XMLStreamException {
        q1();
        throw null;
    }

    protected final v W0(i.e.a.j.e eVar, int i2, int[] iArr, int i3, int i4) throws XMLStreamException {
        return H0(eVar, this.i0, i2, iArr, i3, i4);
    }

    protected abstract boolean X0() throws XMLStreamException;

    protected void Y0(v vVar) throws XMLStreamException {
        String strI = vVar.i();
        if (strI.length() == 3 && strI.equalsIgnoreCase("xml") && !vVar.n()) {
            i0(i.e.a.i.b.f1565l);
            throw null;
        }
    }

    @Override // i.e.a.j.e0
    public final int Z(boolean z) throws XMLStreamException {
        if (this.g != 257) {
            N0();
            if (this.g == 7) {
                this.g = 257;
                v vVar = this.A;
                if (vVar != null) {
                    this.l0 = 3;
                    this.m0 = 1;
                    Y0(vVar);
                    return e1();
                }
            } else {
                this.l0 = 257;
                this.g = 257;
                this.m0 = 0;
            }
        }
        int i2 = this.l0;
        if (i2 != 257) {
            if (i2 == 1) {
                return h1();
            }
            if (i2 == 3) {
                return e1();
            }
            if (i2 == 5) {
                return b1();
            }
            if (i2 == 7) {
                return j1();
            }
            if (i2 == 11) {
                return c1();
            }
            q1();
            throw null;
        }
        if (this.m0 == 1) {
            if (this.f0 >= this.g0) {
                return this.g;
            }
            if (this.n0 != 0) {
                Boolean boolP1 = p1();
                if (boolP1 == null) {
                    return 257;
                }
                return boolP1 == Boolean.FALSE ? V0() : j1();
            }
            if (P0() != 60) {
                this.m0 = 0;
                return V0();
            }
            this.f0++;
            this.n0 = -5;
            Boolean boolP12 = p1();
            if (boolP12 == null) {
                return 257;
            }
            return boolP12 == Boolean.FALSE ? V0() : j1();
        }
        if (this.n0 != 0 && !f1()) {
            return this.g;
        }
        do {
            if (this.m0 == 0) {
                if (this.f0 >= this.g0) {
                    if (!this.o0) {
                        return this.g;
                    }
                    N0();
                    return -1;
                }
                byte bR0 = R0();
                if (bR0 == 60) {
                    this.m0 = 2;
                } else if (bR0 != 32 && bR0 != 13 && bR0 != 10 && bR0 != 9) {
                    I0(bR0);
                    p0(z, bR0, null);
                    throw null;
                }
            }
            int i3 = this.m0;
            if (i3 != 2) {
                if (i3 == 3) {
                    return g1(z);
                }
                q1();
                throw null;
            }
            if (this.f0 >= this.g0) {
                return this.g;
            }
            byte bR02 = R0();
            if (bR02 == 33) {
                this.m0 = 3;
                return g1(z);
            }
            if (bR02 == 63) {
                this.l0 = 3;
                this.m0 = 0;
                return e1();
            }
            if (bR02 != 47 && z) {
                return i1(bR02);
            }
            q0(z, bR02);
            throw null;
        } while (X0());
        if (!this.o0) {
            return this.g;
        }
        N0();
        return -1;
    }

    protected final v Z0(int i2, int i3) throws XMLStreamException {
        this.f0--;
        int i4 = this.p0;
        if (i3 == 0) {
            i4--;
            i2 = this.k0[i4];
            i3 = 4;
        }
        int i5 = i3;
        if (i4 > 1) {
            int[] iArr = this.k0;
            if (i4 >= iArr.length) {
                this.k0 = i.e.a.l.c.c(iArr, iArr.length);
            }
            int[] iArr2 = this.k0;
            int i6 = i4 + 1;
            iArr2[i4] = i2;
            int iD = i.e.a.j.e.d(iArr2, i6);
            i.e.a.j.b bVarI = this.j0.i(iD, this.k0, i6);
            return bVarI == null ? W0(this.j0, iD, this.k0, i6, i5) : bVarI;
        }
        if (i4 == 0) {
            int iB = i.e.a.j.e.b(i2);
            i.e.a.j.b bVarH = this.j0.h(iB, i2, 0);
            if (bVarH != null) {
                return bVarH;
            }
            int[] iArr3 = this.k0;
            iArr3[0] = i2;
            return W0(this.j0, iB, iArr3, 1, i5);
        }
        int i7 = this.k0[0];
        int iC = i.e.a.j.e.c(i7, i2);
        i.e.a.j.b bVarH2 = this.j0.h(iC, i7, i2);
        if (bVarH2 != null) {
            return bVarH2;
        }
        int[] iArr4 = this.k0;
        iArr4[1] = i2;
        return W0(this.j0, iC, iArr4, 2, i5);
    }

    @Override // i.e.a.j.e0
    protected void a() throws IOException {
        this.o0 = true;
    }

    protected void a1() throws XMLStreamException {
        q1();
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void b() {
        super.b();
        i.e.a.j.e eVar = this.j0;
        if (eVar == null || !eVar.k()) {
            return;
        }
        this.c.Y(this.j0);
    }

    protected abstract int b1() throws XMLStreamException;

    protected abstract boolean d1(boolean z) throws XMLStreamException;

    protected abstract int e1() throws XMLStreamException;

    protected abstract boolean f1() throws XMLStreamException;

    protected abstract int h1() throws XMLStreamException;

    protected abstract int i1(byte b) throws XMLStreamException;

    protected abstract v l1(byte b) throws XMLStreamException;

    protected abstract v m1() throws XMLStreamException;

    protected boolean n1(char[] cArr, int i2) throws XMLStreamException {
        byte b = this.u0;
        while (this.f0 < this.g0) {
            int iR0 = R0() & 255;
            if (iR0 == b) {
                this.f1584j.A(i2);
                return true;
            }
            if (iR0 <= 32 || iR0 > 122) {
                byte b2 = (byte) iR0;
                I0(b2);
                p0(true, b2, " (not valid in XML pseudo-attribute values)");
                throw null;
            }
            if (i2 >= cArr.length) {
                cArr = this.f1584j.n();
                i2 = 0;
            }
            cArr[i2] = (char) iR0;
            i2++;
        }
        this.f1584j.A(i2);
        return false;
    }

    @Override // i.e.a.j.e0
    protected void o() throws XMLStreamException {
        q1();
        throw null;
    }

    protected void o1(int i2, int i3) throws XMLStreamException {
        this.f0 = i3;
        M0(i2);
        throw null;
    }

    @Override // i.e.a.j.e0
    protected abstract void p() throws XMLStreamException;

    @Override // i.e.a.j.e0
    protected void q() throws XMLStreamException {
        q1();
        throw null;
    }

    protected int q1() {
        throw new IllegalStateException("Internal error: should never execute this code path");
    }

    @Override // i.e.a.j.e0
    protected void r(boolean z) throws XMLStreamException {
        q1();
        throw null;
    }

    protected boolean r1(int i2) {
        return i2 == 10 || i2 == 13 || i2 == 32 || (i2 >= 48 && i2 <= 57) || ((i2 >= 64 && i2 <= 90) || ((i2 >= 97 && i2 <= 122) || i2 == 33 || ((i2 >= 35 && i2 <= 37) || ((i2 >= 39 && i2 <= 47) || ((i2 >= 58 && i2 <= 59) || i2 == 61 || i2 == 63 || i2 == 95)))));
    }

    @Override // i.e.a.j.e0
    protected void s() throws XMLStreamException {
        q1();
        throw null;
    }

    protected void s1(int i2) throws XMLStreamException {
        G0(i2);
        if ((i2 >> 16) != 0) {
            int i3 = i2 - WXMediaMessage.THUMB_LENGTH_LIMIT;
            this.f1584j.b((char) (55296 | (i3 >> 10)));
            i2 = (i3 & 1023) | 56320;
        }
        this.f1584j.b((char) i2);
    }

    @Override // i.e.a.j.e0
    protected final void t() throws XMLStreamException {
        this.f1582h = false;
        int i2 = this.g;
        if (i2 == 3) {
            s();
            throw null;
        }
        if (i2 == 4) {
            p();
            return;
        }
        if (i2 == 5) {
            q();
            throw null;
        }
        if (i2 == 6) {
            a1();
            throw null;
        }
        if (i2 == 11) {
            r(true);
            throw null;
        }
        if (i2 != 12) {
            i.e.a.i.b.a();
            throw null;
        }
        o();
        throw null;
    }

    protected void t1() throws XMLStreamException {
        this.G = this.f1584j.h();
    }

    protected void u1() throws XMLStreamException {
        this.H = this.f1584j.h();
    }

    protected void v1() throws XMLStreamException {
        String strD = i.e.a.l.b.d(this.f1584j.h());
        if ("UTF-8" == strD || "US-ASCII" == strD || "ISO-8859-1" == strD) {
            this.c.V(strD);
            if (strD != null) {
                this.c.R(strD);
            }
            this.i0 = this.c.E();
            return;
        }
        i0("Unsupported encoding '" + strD + "': only UTF-8 and US-ASCII support by async parser");
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void w0() throws XMLStreamException {
        q1();
        throw null;
    }

    protected void w1() throws XMLStreamException {
        if (this.f1584j.l("yes")) {
            this.c.W(Boolean.TRUE);
            return;
        }
        if (this.f1584j.l("no")) {
            this.c.W(Boolean.FALSE);
            return;
        }
        i0("Invalid standalone value '" + this.f1584j.h() + "': can only use 'yes' and 'no'");
        throw null;
    }

    protected void x1() throws XMLStreamException {
        if (this.f1584j.l("1.0")) {
            this.c.X("1.0");
            return;
        }
        if (this.f1584j.l("1.1")) {
            this.c.X("1.1");
            return;
        }
        i0("Unrecognized XML version '" + this.f1584j.h() + "' (expected '1.0' or '1.1')");
        throw null;
    }

    @Override // i.e.a.j.e0
    protected void z0() throws XMLStreamException {
        q1();
        throw null;
    }
}
