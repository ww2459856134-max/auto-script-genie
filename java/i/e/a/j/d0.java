package i.e.a.j;

import com.auto.exceldeps.log4j.util.Chars;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.InputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class d0 extends b0 {
    public d0(z zVar, InputStream inputStream, byte[] bArr, int i2, int i3) {
        super(zVar, inputStream, bArr, i2, i3);
    }

    private void B1(v vVar, byte b) throws XMLStreamException {
        int iS1;
        int i2;
        int i3;
        char[] cArrB = this.t;
        int i4 = 0;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i5 = this.f0;
            int i6 = i5 + 1;
            this.f0 = i6;
            byte b2 = bArr[i5];
            if (b2 == b) {
                if (i4 == 0) {
                    e(vVar, "");
                    return;
                } else {
                    e(vVar, this.c.l(cArrB, i4));
                    return;
                }
            }
            if (b2 == 38) {
                iS1 = b1(false);
                if (iS1 == 0) {
                    t0(vVar, true);
                    throw null;
                }
                if ((iS1 >> 16) != 0) {
                    if (i4 >= cArrB.length) {
                        cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                        this.t = cArrB;
                    }
                    i2 = iS1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                    i3 = i4 + 1;
                    cArrB[i4] = (char) ((i2 >> 10) | 55296);
                    iS1 = (i2 & 1023) | 56320;
                    i4 = i3;
                }
            } else {
                if (b2 == 60) {
                    F0(b2, "'<' not allowed in attribute value");
                    throw null;
                }
                iS1 = b2 & 255;
                if (iS1 < 32) {
                    if (iS1 == 10) {
                        J0();
                    } else if (iS1 == 13) {
                        if (i6 >= this.g0) {
                            X();
                        }
                        byte[] bArr2 = this.j0;
                        int i7 = this.f0;
                        if (bArr2[i7] == 10) {
                            this.f0 = i7 + 1;
                        }
                        J0();
                    } else if (iS1 != 9) {
                        D0(iS1);
                        throw null;
                    }
                } else if (iS1 > 127 && (iS1 = s1(iS1, i6)) < 0) {
                    int i8 = -iS1;
                    if (i4 >= cArrB.length) {
                        cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                        this.t = cArrB;
                    }
                    i2 = i8 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                    i3 = i4 + 1;
                    cArrB[i4] = (char) ((i2 >> 10) | 55296);
                    iS1 = (i2 & 1023) | 56320;
                    i4 = i3;
                }
            }
            if (i4 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
            }
            cArrB[i4] = (char) iS1;
            i4++;
        }
    }

    private final void D1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) == 128) {
            return;
        }
        C1(b & 255, i4);
        throw null;
    }

    private final void E1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        int i3 = i2 & 15;
        if (i3 < 13) {
            byte[] bArr = this.j0;
            int i4 = this.f0;
            int i5 = i4 + 1;
            this.f0 = i5;
            byte b = bArr[i4];
            if ((b & 192) != 128) {
                C1(b & 255, i5);
                throw null;
            }
            if (i5 >= this.g0) {
                X();
            }
            byte[] bArr2 = this.j0;
            int i6 = this.f0;
            int i7 = i6 + 1;
            this.f0 = i7;
            byte b2 = bArr2[i6];
            if ((b2 & 192) == 128) {
                return;
            }
            C1(b2 & 255, i7);
            throw null;
        }
        int i8 = i3 << 6;
        byte[] bArr3 = this.j0;
        int i9 = this.f0;
        int i10 = i9 + 1;
        this.f0 = i10;
        byte b3 = bArr3[i9];
        if ((b3 & 192) != 128) {
            C1(b3 & 255, i10);
            throw null;
        }
        int i11 = i8 | (b3 & 63);
        if (i10 >= this.g0) {
            X();
        }
        byte[] bArr4 = this.j0;
        int i12 = this.f0;
        int i13 = i12 + 1;
        this.f0 = i13;
        byte b4 = bArr4[i12];
        if ((b4 & 192) != 128) {
            C1(b4 & 255, i13);
            throw null;
        }
        int i14 = (i11 << 6) | (b4 & 63);
        if (i14 >= 55296) {
            if (i14 < 57344 || (i14 >= 65534 && i14 <= 65535)) {
                R(i14);
            }
        }
    }

    private final void F1(int i2) throws XMLStreamException {
        int i3 = this.f0;
        if (i3 + 4 > this.g0) {
            G1(i2);
            return;
        }
        byte[] bArr = this.j0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            C1(b & 255, i4);
            throw null;
        }
        int i5 = i4 + 1;
        this.f0 = i5;
        byte b2 = bArr[i4];
        if ((b2 & 192) != 128) {
            C1(b2 & 255, i5);
            throw null;
        }
        int i6 = i5 + 1;
        this.f0 = i6;
        byte b3 = bArr[i5];
        if ((b3 & 192) == 128) {
            return;
        }
        C1(b3 & 255, i6);
        throw null;
    }

    private final void G1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            C1(b & 255, i4);
            throw null;
        }
        if (i4 >= this.g0) {
            X();
        }
        byte[] bArr2 = this.j0;
        int i5 = this.f0;
        int i6 = i5 + 1;
        this.f0 = i6;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            C1(b2 & 255, i6);
            throw null;
        }
        if (i6 >= this.g0) {
            X();
        }
        byte[] bArr3 = this.j0;
        int i7 = this.f0;
        int i8 = i7 + 1;
        this.f0 = i8;
        byte b3 = bArr3[i7];
        if ((b3 & 192) == 128) {
            return;
        }
        C1(b3 & 255, i8);
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int r1(int i2, byte b, v vVar) throws XMLStreamException {
        byte[] bArr;
        int i3;
        char[] cArrR = this.V.r(vVar, i2);
        int[] iArr = this.k0.b;
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                X();
                i4 = this.f0;
            }
            if (i2 >= cArrR.length) {
                cArrR = this.V.s();
            }
            int i5 = this.g0;
            int length = (cArrR.length - i2) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int iT1 = this.j0[i4] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i6;
                        int i7 = iArr[iT1];
                        if (i7 != 14) {
                            switch (i7) {
                                case 1:
                                    R(iT1);
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    bArr = this.j0;
                                    i3 = this.f0;
                                    if (bArr[i3] == 10) {
                                        this.f0 = i3 + 1;
                                    }
                                    J0();
                                    iT1 = 32;
                                    break;
                                case 2:
                                    if (this.f0 >= this.g0) {
                                    }
                                    bArr = this.j0;
                                    i3 = this.f0;
                                    if (bArr[i3] == 10) {
                                    }
                                    J0();
                                    iT1 = 32;
                                    break;
                                case 3:
                                    J0();
                                    iT1 = 32;
                                    break;
                                case 4:
                                    L0(iT1);
                                    throw null;
                                case 5:
                                    iT1 = t1(iT1);
                                    break;
                                case 6:
                                    iT1 = u1(iT1);
                                    break;
                                case 7:
                                    int iW1 = w1(iT1);
                                    int i8 = i2 + 1;
                                    cArrR[i2] = (char) (55296 | (iW1 >> 10));
                                    iT1 = (iW1 & 1023) | 56320;
                                    if (i8 >= cArrR.length) {
                                        cArrR = this.V.s();
                                    }
                                    i2 = i8;
                                    break;
                                case 8:
                                    iT1 = 32;
                                    break;
                                case 9:
                                    F0(iT1, "'<' not allowed in attribute value");
                                    throw null;
                                case 10:
                                    int iB1 = b1(false);
                                    if (iB1 == 0) {
                                        t0(vVar, false);
                                        throw null;
                                    }
                                    if ((iB1 >> 16) == 0) {
                                        iT1 = iB1;
                                        break;
                                    } else {
                                        int i9 = iB1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                        int i10 = i2 + 1;
                                        cArrR[i2] = (char) (55296 | (i9 >> 10));
                                        int i11 = (i9 & 1023) | 56320;
                                        if (i10 >= cArrR.length) {
                                            cArrR = this.V.s();
                                        }
                                        iT1 = i11;
                                        i2 = i10;
                                        break;
                                    }
                            }
                        } else if (iT1 == b) {
                            return i2;
                        }
                        cArrR[i2] = (char) iT1;
                        i2++;
                    } else {
                        cArrR[i2] = (char) iT1;
                        i2++;
                        i4 = i6;
                    }
                } else {
                    this.f0 = i4;
                }
            }
        }
    }

    private final int s1(int i2, int i3) throws XMLStreamException {
        int i4;
        char c;
        if ((i2 & 224) == 192) {
            i4 = i2 & 31;
            c = 1;
        } else if ((i2 & 240) == 224) {
            i4 = i2 & 15;
            c = 2;
        } else {
            if ((i2 & 248) != 240) {
                L0(i2 & 255);
                throw null;
            }
            i4 = i2 & 7;
            c = 3;
        }
        if (i3 >= this.g0) {
            X();
            i3 = this.f0;
        }
        int i5 = i3 + 1;
        byte b = this.j0[i3];
        if ((b & 192) != 128) {
            C1(b & 255, i5);
            throw null;
        }
        int i6 = (i4 << 6) | (b & 63);
        if (c > 1) {
            if (i5 >= this.g0) {
                X();
                i5 = this.f0;
            }
            int i7 = i5 + 1;
            byte b2 = this.j0[i5];
            if ((b2 & 192) != 128) {
                C1(b2 & 255, i7);
                throw null;
            }
            i6 = (i6 << 6) | (b2 & 63);
            if (c > 2) {
                if (i7 >= this.g0) {
                    X();
                    i7 = this.f0;
                }
                i5 = i7 + 1;
                byte b3 = this.j0[i7];
                if ((b3 & 192) != 128) {
                    C1(b3 & 255, i5);
                    throw null;
                }
                i6 = -((i6 << 6) | (b3 & 63));
            } else {
                i5 = i7;
            }
        }
        this.f0 = i5;
        return i6;
    }

    private final int t1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) == 128) {
            return ((i2 & 31) << 6) | (b & 63);
        }
        C1(b & 255, i4);
        throw null;
    }

    private final int u1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        int i3 = i2 & 15;
        byte[] bArr = this.j0;
        int i4 = this.f0;
        int i5 = i4 + 1;
        this.f0 = i5;
        byte b = bArr[i4];
        if ((b & 192) != 128) {
            C1(b & 255, i5);
            throw null;
        }
        int i6 = (b & 63) | (i3 << 6);
        if (i5 >= this.g0) {
            X();
        }
        byte[] bArr2 = this.j0;
        int i7 = this.f0;
        int i8 = i7 + 1;
        this.f0 = i8;
        byte b2 = bArr2[i7];
        if ((b2 & 192) == 128) {
            int i9 = (i6 << 6) | (b2 & 63);
            return (i3 < 13 || i9 < 55296) ? i9 : (i9 < 57344 || (i9 >= 65534 && i9 <= 65535)) ? R(i9) : i9;
        }
        C1(b2 & 255, i8);
        throw null;
    }

    private final int v1(int i2) throws XMLStreamException {
        int i3 = i2 & 15;
        byte[] bArr = this.j0;
        int i4 = this.f0;
        int i5 = i4 + 1;
        this.f0 = i5;
        byte b = bArr[i4];
        if ((b & 192) != 128) {
            C1(b & 255, i5);
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
        C1(b2 & 255, i7);
        throw null;
    }

    private final int w1(int i2) throws XMLStreamException {
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            C1(b & 255, i4);
            throw null;
        }
        int i5 = ((i2 & 7) << 6) | (b & 63);
        if (i4 >= this.g0) {
            X();
        }
        byte[] bArr2 = this.j0;
        int i6 = this.f0;
        int i7 = i6 + 1;
        this.f0 = i7;
        byte b2 = bArr2[i6];
        if ((b2 & 192) != 128) {
            C1(b2 & 255, i7);
            throw null;
        }
        int i8 = (i5 << 6) | (b2 & 63);
        if (i7 >= this.g0) {
            X();
        }
        byte[] bArr3 = this.j0;
        int i9 = this.f0;
        int i10 = i9 + 1;
        this.f0 = i10;
        byte b3 = bArr3[i9];
        if ((b3 & 192) == 128) {
            return ((i8 << 6) | (b3 & 63)) - WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        C1(b3 & 255, i10);
        throw null;
    }

    @Override // i.e.a.j.e0
    protected final void A0() throws XMLStreamException {
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        while (true) {
            int i2 = this.f0;
            int i3 = this.g0;
            if (i2 >= i3) {
                X();
                i2 = this.f0;
                i3 = this.g0;
            }
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (iArr[i5] != 0) {
                        this.f0 = i4;
                        int i6 = iArr[i5];
                        if (i6 != 12) {
                            switch (i6) {
                                case 1:
                                    R(i5);
                                    break;
                                case 3:
                                    J0();
                                    continue;
                                case 4:
                                    L0(i5);
                                    throw null;
                                case 5:
                                    D1(i5);
                                    continue;
                                case 6:
                                    E1(i5);
                                    continue;
                                case 7:
                                    F1(i5);
                                    continue;
                            }
                            if (this.f0 >= this.g0) {
                                X();
                            }
                            int i7 = this.f0;
                            if (bArr[i7] == 10) {
                                this.f0 = i7 + 1;
                            }
                            J0();
                        } else {
                            if (i4 >= this.g0) {
                                X();
                            }
                            byte[] bArr2 = this.j0;
                            int i8 = this.f0;
                            if (bArr2[i8] == 62) {
                                this.f0 = i8 + 1;
                                return;
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                } else {
                    this.f0 = i2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        r8.f0 = r5;
        r8.f1584j.A(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0061 A[EDGE_INSN: B:52:0x0061->B:34:0x0061 BREAK  A[LOOP:0: B:12:0x0026->B:50:0x0091], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void A1() throws XMLStreamException {
        int iR0;
        char[] cArrO;
        int i2;
        int i3 = this.h0;
        int i4 = 0;
        if (i3 == 13 || i3 == 10) {
            iR0 = R0(i3);
            if (iR0 < 0) {
                return;
            } else {
                cArrO = this.f1584j.o();
            }
        } else {
            cArrO = this.f1584j.x();
            cArrO[0] = (char) i3;
            iR0 = 1;
        }
        int i5 = this.f0;
        while (true) {
            if (i5 < this.g0) {
                i2 = this.j0[i5] & 255;
                if (i2 <= 32) {
                    break;
                }
                i5++;
                if (i2 == 10) {
                    K0(i5);
                } else if (i2 == 13) {
                    if (i5 >= this.g0) {
                        if (W()) {
                            i5 = this.f0;
                        } else {
                            if (iR0 >= cArrO.length) {
                                cArrO = this.f1584j.n();
                            } else {
                                i4 = iR0;
                            }
                            iR0 = i4 + 1;
                            cArrO[i4] = '\n';
                        }
                    }
                    if (this.j0[i5] == 10) {
                        i5++;
                    }
                    K0(i5);
                    i2 = 10;
                } else if (i2 != 32 && i2 != 9) {
                    this.f0 = i5;
                    D0(i2);
                    throw null;
                }
                if (iR0 >= cArrO.length) {
                    cArrO = this.f1584j.n();
                    iR0 = 0;
                }
                cArrO[iR0] = (char) i2;
                iR0++;
            } else {
                if (!W()) {
                    break;
                }
                i5 = this.f0;
                i2 = this.j0[i5] & 255;
                if (i2 <= 32) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        r5.f0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0032 A[EDGE_INSN: B:35:0x0032->B:21:0x0032 BREAK  A[LOOP:0: B:3:0x0002->B:43:0x0002], SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void B0() throws XMLStreamException {
        int i2;
        int i3 = this.f0;
        while (true) {
            if (i3 < this.g0) {
                i2 = this.j0[i3] & 255;
                if (i2 <= 32) {
                    break;
                }
                i3++;
                if (i2 == 10) {
                    K0(i3);
                } else if (i2 == 13) {
                    if (i3 >= this.g0) {
                        if (!W()) {
                            break;
                        } else {
                            i3 = this.f0;
                        }
                    }
                    if (this.j0[i3] == 10) {
                        i3++;
                    }
                    K0(i3);
                } else if (i2 != 32 && i2 != 9) {
                    this.f0 = i3;
                    D0(i2);
                    throw null;
                }
            } else {
                if (!W()) {
                    break;
                }
                i3 = this.f0;
                i2 = this.j0[i3] & 255;
                if (i2 <= 32) {
                }
            }
        }
    }

    protected void C1(int i2, int i3) throws XMLStreamException {
        this.f0 = i3;
        M0(i2);
        throw null;
    }

    @Override // i.e.a.j.f
    public int I0(byte b) throws XMLStreamException {
        int i2;
        char c;
        if (b >= 0) {
            return b;
        }
        if ((b & 224) == 192) {
            i2 = b & 31;
            c = 1;
        } else if ((b & 240) == 224) {
            i2 = b & 15;
            c = 2;
        } else {
            if ((b & 248) != 240) {
                L0(b & 255);
                throw null;
            }
            i2 = b & 7;
            c = 3;
        }
        byte bJ1 = j1();
        if ((bJ1 & 192) != 128) {
            M0(bJ1 & 255);
            throw null;
        }
        int i3 = (i2 << 6) | (bJ1 & 63);
        if (c <= 1) {
            return i3;
        }
        byte bJ12 = j1();
        if ((bJ12 & 192) != 128) {
            M0(bJ12 & 255);
            throw null;
        }
        int i4 = (i3 << 6) | (bJ12 & 63);
        if (c <= 2) {
            return i4;
        }
        byte bJ13 = j1();
        if ((bJ13 & 192) == 128) {
            return (i4 << 6) | (bJ13 & 63);
        }
        M0(bJ13 & 255);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x01d7  */
    @Override // i.e.a.j.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final int b1(boolean z) throws XMLStreamException {
        String str;
        byte bG1;
        byte bG12;
        byte bG13;
        byte bG14;
        byte bG15;
        byte bG16;
        byte bG17;
        byte bG18;
        byte bG19;
        byte bG110;
        byte bG111;
        byte bG112;
        byte bG113;
        byte bG114;
        if (this.f0 >= this.g0) {
            X();
        }
        byte[] bArr = this.j0;
        int i2 = this.f0;
        int i3 = i2 + 1;
        this.f0 = i3;
        byte b = bArr[i2];
        if (b == 35) {
            return W0();
        }
        if (b == 97) {
            if (i3 < this.g0) {
                this.f0 = i3 + 1;
                bG19 = bArr[i3];
            } else {
                bG19 = g1();
            }
            b = bG19;
            if (b == 109) {
                int i4 = this.f0;
                if (i4 < this.g0) {
                    byte[] bArr2 = this.j0;
                    this.f0 = i4 + 1;
                    bG113 = bArr2[i4];
                } else {
                    bG113 = g1();
                }
                b = bG113;
                if (b == 112) {
                    int i5 = this.f0;
                    if (i5 < this.g0) {
                        byte[] bArr3 = this.j0;
                        this.f0 = i5 + 1;
                        bG114 = bArr3[i5];
                    } else {
                        bG114 = g1();
                    }
                    b = bG114;
                    if (b == 59) {
                        return 38;
                    }
                    str = "amp";
                } else {
                    str = "am";
                }
            } else if (b == 112) {
                int i6 = this.f0;
                if (i6 < this.g0) {
                    byte[] bArr4 = this.j0;
                    this.f0 = i6 + 1;
                    bG110 = bArr4[i6];
                } else {
                    bG110 = g1();
                }
                b = bG110;
                if (b == 111) {
                    int i7 = this.f0;
                    if (i7 < this.g0) {
                        byte[] bArr5 = this.j0;
                        this.f0 = i7 + 1;
                        bG111 = bArr5[i7];
                    } else {
                        bG111 = g1();
                    }
                    b = bG111;
                    if (b == 115) {
                        int i8 = this.f0;
                        if (i8 < this.g0) {
                            byte[] bArr6 = this.j0;
                            this.f0 = i8 + 1;
                            bG112 = bArr6[i8];
                        } else {
                            bG112 = g1();
                        }
                        b = bG112;
                        if (b == 59) {
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
        } else if (b == 108) {
            if (i3 < this.g0) {
                this.f0 = i3 + 1;
                bG17 = bArr[i3];
            } else {
                bG17 = g1();
            }
            b = bG17;
            if (b == 116) {
                int i9 = this.f0;
                if (i9 < this.g0) {
                    byte[] bArr7 = this.j0;
                    this.f0 = i9 + 1;
                    bG18 = bArr7[i9];
                } else {
                    bG18 = g1();
                }
                b = bG18;
                if (b == 59) {
                    return 60;
                }
                str = "lt";
            } else {
                str = "l";
            }
        } else if (b == 103) {
            if (i3 < this.g0) {
                this.f0 = i3 + 1;
                bG15 = bArr[i3];
            } else {
                bG15 = g1();
            }
            b = bG15;
            if (b == 116) {
                int i10 = this.f0;
                if (i10 < this.g0) {
                    byte[] bArr8 = this.j0;
                    this.f0 = i10 + 1;
                    bG16 = bArr8[i10];
                } else {
                    bG16 = g1();
                }
                b = bG16;
                if (b == 59) {
                    return 62;
                }
                str = "gt";
            } else {
                str = "g";
            }
        } else if (b == 113) {
            if (i3 < this.g0) {
                this.f0 = i3 + 1;
                bG1 = bArr[i3];
            } else {
                bG1 = g1();
            }
            b = bG1;
            if (b == 117) {
                int i11 = this.f0;
                if (i11 < this.g0) {
                    byte[] bArr9 = this.j0;
                    this.f0 = i11 + 1;
                    bG12 = bArr9[i11];
                } else {
                    bG12 = g1();
                }
                b = bG12;
                if (b == 111) {
                    int i12 = this.f0;
                    if (i12 < this.g0) {
                        byte[] bArr10 = this.j0;
                        this.f0 = i12 + 1;
                        bG13 = bArr10[i12];
                    } else {
                        bG13 = g1();
                    }
                    b = bG13;
                    if (b == 116) {
                        int i13 = this.f0;
                        if (i13 < this.g0) {
                            byte[] bArr11 = this.j0;
                            this.f0 = i13 + 1;
                            bG14 = bArr11[i13];
                        } else {
                            bG14 = g1();
                        }
                        b = bG14;
                        if (b == 59) {
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
        int[] iArr = this.k0.c;
        char[] cArrB = this.t;
        int length = str.length();
        int i14 = 0;
        while (i14 < length) {
            cArrB[i14] = str.charAt(i14);
            i14++;
        }
        while (b != 59) {
            int iT1 = b & 255;
            int i15 = iArr[iT1];
            boolean zE = true;
            if (i15 == 0 || i15 == 1 || i15 == 2) {
                if (i14 <= 0) {
                    zE = false;
                }
            } else if (i15 != 3) {
                if (i15 == 5) {
                    iT1 = t1(iT1);
                    zE = i.e.a.l.p.e(iT1);
                } else if (i15 == 6) {
                    iT1 = u1(iT1);
                    zE = i.e.a.l.p.e(iT1);
                } else if (i15 == 7) {
                    iT1 = w1(iT1);
                    zE = i.e.a.l.p.e(iT1);
                    if (zE) {
                        if (i14 >= cArrB.length) {
                            cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                            this.t = cArrB;
                        }
                        int i16 = iT1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                        cArrB[i14] = (char) (55296 | (i16 >> 10));
                        iT1 = (i16 & 1023) | 56320;
                        i14++;
                    }
                }
            }
            if (!zE) {
                j0(iT1, i14);
                throw null;
            }
            if (i14 >= cArrB.length) {
                char[] cArrB2 = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB2;
                cArrB = cArrB2;
            }
            int i17 = i14 + 1;
            cArrB[i14] = (char) iT1;
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr12 = this.j0;
            int i18 = this.f0;
            this.f0 = i18 + 1;
            b = bArr12[i18];
            i14 = i17;
        }
        String str2 = new String(cArrB, 0, i14);
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0174, code lost:
    
        B1(r4, r6);
        r14.J++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x017e, code lost:
    
        r3 = r1(r3, r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0184, code lost:
    
        if (r8 != 10) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0186, code lost:
    
        J0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x018a, code lost:
    
        if (r8 != 13) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x018e, code lost:
    
        if (r13 < r14.g0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0190, code lost:
    
        X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0193, code lost:
    
        r6 = r14.j0;
        r8 = r14.f0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0199, code lost:
    
        if (r6[r8] != 10) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x019b, code lost:
    
        r14.f0 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x019f, code lost:
    
        J0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a3, code lost:
    
        if (r8 == 32) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01a5, code lost:
    
        if (r8 != 9) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01a8, code lost:
    
        D0(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01ab, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ac, code lost:
    
        F0(I0(r6), " expected '='");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01b5, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c3, code lost:
    
        r3 = r14.V.h(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c9, code lost:
    
        if (r3 < 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00cb, code lost:
    
        r14.W = r3;
        r14.f1583i++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
    
        if (r2 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d8, code lost:
    
        if (r15.p() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00da, code lost:
    
        r15 = r14.W;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00dc, code lost:
    
        if (r1 >= r15) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00de, code lost:
    
        r2 = r14.V.l(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e8, code lost:
    
        if (r2.p() == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ea, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ed, code lost:
    
        s0(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f0, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f1, code lost:
    
        s0(r14.A, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f6, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f7, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f8, code lost:
    
        r14.V.j();
        i0(r14.V.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0106, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0146, code lost:
    
        if (r8 != 61) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x014c, code lost:
    
        if (r14.f0 < r14.g0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014e, code lost:
    
        X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0151, code lost:
    
        r6 = r14.j0;
        r8 = r14.f0;
        r13 = r8 + 1;
        r14.f0 = r13;
        r6 = r6[r8];
        r8 = r6 & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x015d, code lost:
    
        if (r8 <= 32) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0161, code lost:
    
        if (r8 == 34) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0165, code lost:
    
        if (r8 != 39) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0168, code lost:
    
        F0(I0(r6), " Expected a quote");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0171, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0172, code lost:
    
        if (r5 == false) goto L144;
     */
    @Override // i.e.a.j.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int e1(byte b) throws XMLStreamException {
        boolean zP;
        this.g = 1;
        int i2 = 0;
        this.J = 0;
        v vVarK1 = k1(b);
        String strK = vVarK1.k();
        if (strK == null) {
            zP = true;
        } else {
            vVarK1 = d(vVarK1, strK);
            zP = vVarK1.p();
        }
        this.A = vVarK1;
        this.D = new k(vVarK1, this.D);
        int iR1 = 0;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i3 = this.f0;
            this.f0 = i3 + 1;
            byte b2 = bArr[i3];
            int i4 = b2 & 255;
            if (i4 <= 32) {
                do {
                    if (i4 == 10) {
                        J0();
                    } else if (i4 == 13) {
                        if (this.f0 >= this.g0) {
                            X();
                        }
                        byte[] bArr2 = this.j0;
                        int i5 = this.f0;
                        if (bArr2[i5] == 10) {
                            this.f0 = i5 + 1;
                        }
                        J0();
                    } else if (i4 != 32 && i4 != 9) {
                        D0(i4);
                        throw null;
                    }
                    if (this.f0 >= this.g0) {
                        X();
                    }
                    byte[] bArr3 = this.j0;
                    int i6 = this.f0;
                    this.f0 = i6 + 1;
                    b2 = bArr3[i6];
                    i4 = b2 & 255;
                } while (i4 <= 32);
            } else if (i4 != 47 && i4 != 62) {
                F0(I0(b2), " expected space, or '>' or \"/>\"");
                throw null;
            }
            if (i4 == 47) {
                if (this.f0 >= this.g0) {
                    X();
                }
                byte[] bArr4 = this.j0;
                int i7 = this.f0;
                this.f0 = i7 + 1;
                byte b3 = bArr4[i7];
                if (b3 != 62) {
                    F0(I0(b3), " expected '>'");
                    throw null;
                }
                this.C = true;
            } else {
                if (i4 == 62) {
                    this.C = false;
                    break;
                }
                if (i4 == 60) {
                    i0("Unexpected '<' character in element (missing closing '>'?)");
                    throw null;
                }
                v vVarK12 = k1(b2);
                String strK2 = vVarK12.k();
                if (strK2 == null) {
                    boolean z = vVarK12.i() == "xmlns";
                } else {
                    if (strK2 != "xmlns") {
                        vVarK12 = d(vVarK12, strK2);
                        if (zP) {
                            zP = vVarK12.p();
                        }
                    }
                }
                while (true) {
                    if (this.f0 >= this.g0) {
                        X();
                    }
                    byte[] bArr5 = this.j0;
                    int i8 = this.f0;
                    int i9 = i8 + 1;
                    this.f0 = i9;
                    byte b4 = bArr5[i8];
                    int i10 = b4 & 255;
                    if (i10 > 32) {
                        break;
                    }
                    if (i10 == 10) {
                        J0();
                    } else if (i10 == 13) {
                        if (i9 >= this.g0) {
                            X();
                        }
                        byte[] bArr6 = this.j0;
                        int i11 = this.f0;
                        if (bArr6[i11] == 10) {
                            this.f0 = i11 + 1;
                        }
                        J0();
                    } else if (i10 != 32 && i10 != 9) {
                        D0(i10);
                        throw null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void o() throws XMLStreamException {
        int i2;
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        char[] cArrX = this.f1584j.x();
        int i3 = 0;
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                X();
                i4 = this.f0;
            }
            if (i3 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i3 = 0;
            }
            int i5 = this.g0;
            int length = (cArrX.length - i3) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int iT1 = bArr[i4] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i6;
                        int i7 = iArr[iT1];
                        if (i7 != 11) {
                            switch (i7) {
                                case 1:
                                    R(iT1);
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                        this.f0 = i2 + 1;
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 2:
                                    if (this.f0 >= this.g0) {
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 3:
                                    J0();
                                    break;
                                case 4:
                                    L0(iT1);
                                    throw null;
                                case 5:
                                    iT1 = t1(iT1);
                                    break;
                                case 6:
                                    iT1 = u1(iT1);
                                    break;
                                case 7:
                                    int iW1 = w1(iT1);
                                    int i8 = i3 + 1;
                                    cArrX[i3] = (char) (55296 | (iW1 >> 10));
                                    if (i8 >= cArrX.length) {
                                        cArrX = this.f1584j.n();
                                        i3 = 0;
                                    } else {
                                        i3 = i8;
                                    }
                                    iT1 = (iW1 & 1023) | 56320;
                                    break;
                            }
                        } else {
                            int i9 = 0;
                            while (true) {
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                byte[] bArr2 = this.j0;
                                int i10 = this.f0;
                                byte b = bArr2[i10];
                                if (b != 93) {
                                    boolean z = b == 62 && i9 >= 1;
                                    if (z) {
                                        i9--;
                                    }
                                    while (i9 > 0) {
                                        int i11 = i3 + 1;
                                        cArrX[i3] = ']';
                                        if (i11 >= cArrX.length) {
                                            cArrX = this.f1584j.n();
                                            i3 = 0;
                                            i9--;
                                        } else {
                                            i3 = i11;
                                            i9--;
                                        }
                                    }
                                    if (z) {
                                        this.f0++;
                                        this.f1584j.A(i3);
                                        if (!this.e || this.f1585k) {
                                            return;
                                        }
                                        z1();
                                        return;
                                    }
                                } else {
                                    this.f0 = i10 + 1;
                                    i9++;
                                }
                            }
                        }
                        cArrX[i3] = (char) iT1;
                        i3++;
                    } else {
                        cArrX[i3] = (char) iT1;
                        i4 = i6;
                        i3++;
                    }
                } else {
                    this.f0 = i4;
                }
            }
        }
    }

    @Override // i.e.a.j.b0
    protected String o1(byte b) throws XMLStreamException {
        char[] cArrB = this.t;
        int[] iArr = i.e.a.l.o.f;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr = this.j0;
            int i3 = this.f0;
            this.f0 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 == b) {
                return new String(cArrB, 0, i2);
            }
            int i4 = b2 & 255;
            if (iArr[i4] != 1) {
                F0(i4, " in public identifier");
                throw null;
            }
            if (i4 <= 32) {
                z = true;
            } else {
                if (z) {
                    if (i2 >= cArrB.length) {
                        cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                        this.t = cArrB;
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
                cArrB[i2] = (char) i4;
                i2++;
            }
        }
    }

    @Override // i.e.a.j.e0
    protected final void p() throws XMLStreamException {
        int iQ0;
        char[] cArrO;
        char c;
        int i2;
        int i3;
        int i4 = this.h0;
        char c2 = '\n';
        if (i4 < 0) {
            int i5 = -i4;
            cArrO = this.f1584j.x();
            if ((i5 >> 16) != 0) {
                int i6 = i5 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                cArrO[0] = (char) ((i6 >> 10) | 55296);
                i5 = (i6 & 1023) | 56320;
                i3 = 1;
            } else {
                i3 = 0;
            }
            iQ0 = i3 + 1;
            cArrO[i3] = (char) i5;
        } else if (i4 == 13 || i4 == 10) {
            this.f0++;
            iQ0 = Q0(i4);
            if (iQ0 < 0) {
                return;
            } else {
                cArrO = this.f1584j.o();
            }
        } else {
            cArrO = this.f1584j.x();
            iQ0 = 0;
        }
        int[] iArr = this.k0.a;
        byte[] bArr = this.j0;
        while (true) {
            int i7 = this.f0;
            if (i7 >= this.g0) {
                X();
                i7 = this.f0;
            }
            if (iQ0 >= cArrO.length) {
                cArrO = this.f1584j.n();
                iQ0 = 0;
            }
            int i8 = this.g0;
            int length = (cArrO.length - iQ0) + i7;
            if (length < i8) {
                i8 = length;
            }
            while (true) {
                if (i7 < i8) {
                    int i9 = i7 + 1;
                    int iT1 = bArr[i7] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i9;
                        switch (iArr[iT1]) {
                            case 1:
                                R(iT1);
                            case 2:
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                int i10 = this.f0;
                                c = '\n';
                                if (bArr[i10] == 10) {
                                    this.f0 = i10 + 1;
                                }
                                J0();
                                iT1 = 10;
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 3:
                                J0();
                                c = '\n';
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 4:
                                L0(iT1);
                                throw null;
                            case 5:
                                iT1 = t1(iT1);
                                c = '\n';
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 6:
                                iT1 = this.g0 - i9 >= 2 ? v1(iT1) : u1(iT1);
                                c = '\n';
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 7:
                                int iW1 = w1(iT1);
                                int i11 = iQ0 + 1;
                                cArrO[iQ0] = (char) ((iW1 >> 10) | 55296);
                                if (i11 >= cArrO.length) {
                                    cArrO = this.f1584j.n();
                                    iQ0 = 0;
                                } else {
                                    iQ0 = i11;
                                }
                                i2 = iW1 & 1023;
                                iT1 = i2 | 56320;
                                c = '\n';
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 8:
                            default:
                                c = c2;
                                cArrO[iQ0] = (char) iT1;
                                iQ0++;
                                c2 = c;
                                break;
                            case 9:
                                this.f0 = i9 - 1;
                                break;
                            case 10:
                                iT1 = b1(false);
                                if (iT1 != 0) {
                                    if ((iT1 >> 16) != 0) {
                                        int i12 = iT1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                        int i13 = iQ0 + 1;
                                        cArrO[iQ0] = (char) ((i12 >> 10) | 55296);
                                        if (i13 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                            iQ0 = 0;
                                        } else {
                                            iQ0 = i13;
                                        }
                                        i2 = i12 & 1023;
                                        iT1 = i2 | 56320;
                                    }
                                    c = '\n';
                                    cArrO[iQ0] = (char) iT1;
                                    iQ0++;
                                    c2 = c;
                                    break;
                                } else {
                                    this.f1585k = true;
                                    break;
                                }
                            case 11:
                                int i14 = 1;
                                while (true) {
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    int i15 = this.f0;
                                    byte b = bArr[i15];
                                    if (b == 93) {
                                        this.f0 = i15 + 1;
                                        i14++;
                                    } else {
                                        if (b == 62 && i14 > 1) {
                                            f0();
                                            throw null;
                                        }
                                        while (i14 > 1) {
                                            int i16 = iQ0 + 1;
                                            cArrO[iQ0] = ']';
                                            if (i16 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                                iQ0 = 0;
                                            } else {
                                                iQ0 = i16;
                                            }
                                            i14--;
                                        }
                                        c = '\n';
                                        cArrO[iQ0] = (char) iT1;
                                        iQ0++;
                                        c2 = c;
                                        break;
                                    }
                                }
                        }
                    } else {
                        cArrO[iQ0] = (char) iT1;
                        iQ0++;
                        i7 = i9;
                        c2 = c2;
                    }
                } else {
                    this.f0 = i7;
                }
            }
        }
        this.f1584j.A(iQ0);
        if (!this.e || this.f1585k) {
            return;
        }
        z1();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    @Override // i.e.a.j.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String p1(byte b) throws XMLStreamException {
        byte[] bArr;
        int i2;
        char[] cArrB = this.t;
        int[] iArr = this.k0.b;
        int i3 = 0;
        while (true) {
            if (this.f0 >= this.g0) {
                X();
            }
            byte[] bArr2 = this.j0;
            int i4 = this.f0;
            this.f0 = i4 + 1;
            int iT1 = bArr2[i4] & 255;
            if (iArr[iT1] != 0) {
                int i5 = iArr[iT1];
                if (i5 != 14) {
                    switch (i5) {
                        case 1:
                            R(iT1);
                            if (this.f0 >= this.g0) {
                                X();
                            }
                            bArr = this.j0;
                            i2 = this.f0;
                            if (bArr[i2] == 10) {
                                this.f0 = i2 + 1;
                            }
                            J0();
                            iT1 = 10;
                            break;
                        case 2:
                            if (this.f0 >= this.g0) {
                            }
                            bArr = this.j0;
                            i2 = this.f0;
                            if (bArr[i2] == 10) {
                            }
                            J0();
                            iT1 = 10;
                            break;
                        case 3:
                            J0();
                            break;
                        case 4:
                            L0(iT1);
                            throw null;
                        case 5:
                            iT1 = t1(iT1);
                            break;
                        case 6:
                            iT1 = u1(iT1);
                            break;
                        case 7:
                            int iW1 = w1(iT1);
                            if (i3 >= cArrB.length) {
                                cArrB = this.f1584j.n();
                                i3 = 0;
                            }
                            cArrB[i3] = (char) (55296 | (iW1 >> 10));
                            iT1 = (iW1 & 1023) | 56320;
                            i3++;
                            break;
                    }
                } else if (iT1 == b) {
                    return new String(cArrB, 0, i3);
                }
            }
            if (i3 >= cArrB.length) {
                cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                this.t = cArrB;
                i3 = 0;
            }
            cArrB[i3] = (char) iT1;
            i3++;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void q() throws XMLStreamException {
        int i2;
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        char[] cArrX = this.f1584j.x();
        int i3 = 0;
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                X();
                i4 = this.f0;
            }
            if (i3 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i3 = 0;
            }
            int i5 = this.g0;
            int length = (cArrX.length - i3) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int iT1 = bArr[i4] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i6;
                        int i7 = iArr[iT1];
                        if (i7 != 13) {
                            switch (i7) {
                                case 1:
                                    R(iT1);
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                        this.f0 = i2 + 1;
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 2:
                                    if (this.f0 >= this.g0) {
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 3:
                                    J0();
                                    break;
                                case 4:
                                    L0(iT1);
                                    throw null;
                                case 5:
                                    iT1 = t1(iT1);
                                    break;
                                case 6:
                                    iT1 = u1(iT1);
                                    break;
                                case 7:
                                    int iW1 = w1(iT1);
                                    int i8 = i3 + 1;
                                    cArrX[i3] = (char) (55296 | (iW1 >> 10));
                                    if (i8 >= cArrX.length) {
                                        cArrX = this.f1584j.n();
                                        i3 = 0;
                                    } else {
                                        i3 = i8;
                                    }
                                    iT1 = (iW1 & 1023) | 56320;
                                    break;
                            }
                        } else {
                            if (i6 >= this.g0) {
                                X();
                            }
                            byte[] bArr2 = this.j0;
                            int i9 = this.f0;
                            if (bArr2[i9] == 45) {
                                int i10 = i9 + 1;
                                this.f0 = i10;
                                if (i10 >= this.g0) {
                                    X();
                                }
                                byte[] bArr3 = this.j0;
                                int i11 = this.f0;
                                this.f0 = i11 + 1;
                                if (bArr3[i11] == 62) {
                                    this.f1584j.A(i3);
                                    return;
                                } else {
                                    b0();
                                    throw null;
                                }
                            }
                        }
                        cArrX[i3] = (char) iT1;
                        i3++;
                    } else {
                        cArrX[i3] = (char) iT1;
                        i4 = i6;
                        i3++;
                    }
                } else {
                    this.f0 = i4;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0013 A[SYNTHETIC] */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void r(boolean z) throws XMLStreamException {
        byte[] bArr;
        int i2;
        char[] cArrX = z ? this.f1584j.x() : null;
        int[] iArr = this.k0.d;
        int i3 = 0;
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            int i5 = this.f0;
            if (i5 >= this.g0) {
                X();
                i5 = this.f0;
            }
            int i6 = this.g0;
            if (cArrX != null) {
                if (i3 >= cArrX.length) {
                    cArrX = this.f1584j.n();
                    i3 = 0;
                }
                int length = (cArrX.length - i3) + i5;
                if (length < i6) {
                    i6 = length;
                }
            }
            while (true) {
                if (i5 < i6) {
                    int i7 = i5 + 1;
                    int iT1 = this.j0[i5] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i7;
                        switch (iArr[iT1]) {
                            case 1:
                                R(iT1);
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                bArr = this.j0;
                                i2 = this.f0;
                                if (bArr[i2] == 10) {
                                    this.f0 = i2 + 1;
                                }
                                J0();
                                iT1 = 10;
                                if (cArrX == null) {
                                    break;
                                } else {
                                    cArrX[i3] = (char) iT1;
                                    i3++;
                                    break;
                                }
                            case 2:
                                if (this.f0 >= this.g0) {
                                }
                                bArr = this.j0;
                                i2 = this.f0;
                                if (bArr[i2] == 10) {
                                }
                                J0();
                                iT1 = 10;
                                if (cArrX == null) {
                                }
                                break;
                            case 3:
                                J0();
                                if (cArrX == null) {
                                }
                                break;
                            case 4:
                                L0(iT1);
                                throw null;
                            case 5:
                                iT1 = t1(iT1);
                                if (cArrX == null) {
                                }
                                break;
                            case 6:
                                iT1 = u1(iT1);
                                if (cArrX == null) {
                                }
                                break;
                            case 7:
                                iT1 = w1(iT1);
                                if (cArrX != null) {
                                    int i8 = i3 + 1;
                                    cArrX[i3] = (char) (55296 | (iT1 >> 10));
                                    iT1 = (iT1 & 1023) | 56320;
                                    if (i8 >= cArrX.length) {
                                        cArrX = this.f1584j.n();
                                        i3 = 0;
                                    } else {
                                        i3 = i8;
                                    }
                                }
                                if (cArrX == null) {
                                }
                                break;
                            case 8:
                                if (i4 == 0) {
                                    i4 = iT1;
                                } else if (i4 == iT1) {
                                    i4 = 0;
                                }
                                if (cArrX == null) {
                                }
                                break;
                            case 9:
                                if (!z2) {
                                    z2 = true;
                                }
                                if (cArrX == null) {
                                }
                                break;
                            case 10:
                                if (i4 == 0) {
                                    z2 = false;
                                }
                                if (cArrX == null) {
                                }
                                break;
                            case 11:
                                if (!z2 && i4 == 0) {
                                    if (cArrX != null) {
                                        this.f1584j.A(i3);
                                    }
                                    byte bQ1 = q1(false, null);
                                    if (bQ1 == 62) {
                                        return;
                                    }
                                    F0(I0(bQ1), " expected '>' after the internal subset");
                                    throw null;
                                }
                                if (cArrX == null) {
                                }
                                break;
                            default:
                                if (cArrX == null) {
                                }
                                break;
                        }
                    } else {
                        if (cArrX != null) {
                            cArrX[i3] = (char) iT1;
                            i3++;
                        }
                        i5 = i7;
                    }
                } else {
                    this.f0 = i5;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void s() throws XMLStreamException {
        int i2;
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        char[] cArrX = this.f1584j.x();
        int i3 = 0;
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                X();
                i4 = this.f0;
            }
            if (i3 >= cArrX.length) {
                cArrX = this.f1584j.n();
                i3 = 0;
            }
            int i5 = this.g0;
            int length = (cArrX.length - i3) + i4;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i4 < i5) {
                    int i6 = i4 + 1;
                    int iT1 = bArr[i4] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i6;
                        int i7 = iArr[iT1];
                        if (i7 != 12) {
                            switch (i7) {
                                case 1:
                                    R(iT1);
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                        this.f0 = i2 + 1;
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 2:
                                    if (this.f0 >= this.g0) {
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 3:
                                    J0();
                                    break;
                                case 4:
                                    L0(iT1);
                                    throw null;
                                case 5:
                                    iT1 = t1(iT1);
                                    break;
                                case 6:
                                    iT1 = u1(iT1);
                                    break;
                                case 7:
                                    int iW1 = w1(iT1);
                                    int i8 = i3 + 1;
                                    cArrX[i3] = (char) (55296 | (iW1 >> 10));
                                    if (i8 >= cArrX.length) {
                                        cArrX = this.f1584j.n();
                                        i3 = 0;
                                    } else {
                                        i3 = i8;
                                    }
                                    iT1 = (iW1 & 1023) | 56320;
                                    break;
                            }
                        } else {
                            if (i6 >= this.g0) {
                                X();
                            }
                            byte[] bArr2 = this.j0;
                            int i9 = this.f0;
                            if (bArr2[i9] == 62) {
                                this.f0 = i9 + 1;
                                this.f1584j.A(i3);
                                return;
                            }
                        }
                        cArrX[i3] = (char) iT1;
                        i3++;
                    } else {
                        cArrX[i3] = (char) iT1;
                        i4 = i6;
                        i3++;
                    }
                } else {
                    this.f0 = i4;
                }
            }
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
            A1();
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

    @Override // i.e.a.j.e0
    protected final void w0() throws XMLStreamException {
        int i2;
        byte b;
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        while (true) {
            int i3 = this.f0;
            int i4 = this.g0;
            if (i3 >= i4) {
                X();
                i3 = this.f0;
                i4 = this.g0;
            }
            while (true) {
                if (i3 < i4) {
                    int i5 = i3 + 1;
                    int i6 = bArr[i3] & 255;
                    if (iArr[i6] != 0) {
                        this.f0 = i5;
                        int i7 = iArr[i6];
                        if (i7 != 11) {
                            switch (i7) {
                                case 1:
                                    R(i6);
                                    break;
                                case 3:
                                    J0();
                                    continue;
                                case 4:
                                    L0(i6);
                                    throw null;
                                case 5:
                                    D1(i6);
                                    continue;
                                case 6:
                                    E1(i6);
                                    continue;
                                case 7:
                                    F1(i6);
                                    continue;
                            }
                            if (this.f0 >= this.g0) {
                                X();
                            }
                            int i8 = this.f0;
                            if (bArr[i8] == 10) {
                                this.f0 = i8 + 1;
                            }
                            J0();
                        } else {
                            int i9 = 0;
                            do {
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                i9++;
                                byte[] bArr2 = this.j0;
                                int i10 = this.f0;
                                i2 = i10 + 1;
                                this.f0 = i2;
                                b = bArr2[i10];
                            } while (b == 93);
                            if (b != 62) {
                                this.f0 = i2 - 1;
                            } else if (i9 > 1) {
                                return;
                            }
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

    @Override // i.e.a.j.e0
    protected final boolean x0() throws XMLStreamException {
        int[] iArr = this.k0.a;
        byte[] bArr = this.j0;
        while (true) {
            int i2 = this.f0;
            int i3 = this.g0;
            if (i2 >= i3) {
                X();
                i2 = this.f0;
                i3 = this.g0;
            }
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (iArr[i5] != 0) {
                        this.f0 = i4;
                        switch (iArr[i5]) {
                            case 1:
                                R(i5);
                                break;
                            case 3:
                                J0();
                                continue;
                            case 4:
                                L0(i5);
                                throw null;
                            case 5:
                                D1(i5);
                                continue;
                            case 6:
                                E1(i5);
                                continue;
                            case 7:
                                F1(i5);
                                continue;
                            case 9:
                                this.f0 = i4 - 1;
                                return false;
                            case 10:
                                if (b1(false) == 0) {
                                    return true;
                                }
                                continue;
                            case 11:
                                int i6 = 1;
                                while (true) {
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    int i7 = this.f0;
                                    byte b = bArr[i7];
                                    if (b == 93) {
                                        this.f0 = i7 + 1;
                                        i6++;
                                    } else if (b != 62) {
                                        continue;
                                    } else {
                                        if (i6 > 1) {
                                            f0();
                                            throw null;
                                        }
                                        break;
                                    }
                                }
                        }
                        if (this.f0 >= this.g0) {
                            X();
                        }
                        int i8 = this.f0;
                        if (bArr[i8] == 10) {
                            this.f0 = i8 + 1;
                        }
                        J0();
                    } else {
                        i2 = i4;
                    }
                } else {
                    this.f0 = i2;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void x1() throws XMLStreamException {
        int i2;
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        while (true) {
            int i3 = this.f0;
            if (i3 >= this.g0) {
                X();
                i3 = this.f0;
            }
            int i4 = 0;
            if (iP >= cArrO.length) {
                cArrO = this.f1584j.n();
                iP = 0;
            }
            int i5 = this.g0;
            int length = (cArrO.length - iP) + i3;
            if (length < i5) {
                i5 = length;
            }
            while (true) {
                if (i3 < i5) {
                    int i6 = i3 + 1;
                    int iT1 = bArr[i3] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i6;
                        int i7 = iArr[iT1];
                        if (i7 != 11) {
                            switch (i7) {
                                case 1:
                                    R(iT1);
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                        this.f0 = i2 + 1;
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 2:
                                    if (this.f0 >= this.g0) {
                                    }
                                    i2 = this.f0;
                                    if (bArr[i2] == 10) {
                                    }
                                    J0();
                                    iT1 = 10;
                                    break;
                                case 3:
                                    J0();
                                    break;
                                case 4:
                                    L0(iT1);
                                    throw null;
                                case 5:
                                    iT1 = t1(iT1);
                                    break;
                                case 6:
                                    iT1 = u1(iT1);
                                    break;
                                case 7:
                                    int iW1 = w1(iT1);
                                    int i8 = iP + 1;
                                    cArrO[iP] = (char) (55296 | (iW1 >> 10));
                                    if (i8 >= cArrO.length) {
                                        cArrO = this.f1584j.n();
                                    } else {
                                        i4 = i8;
                                    }
                                    iT1 = (iW1 & 1023) | 56320;
                                    iP = i4;
                                    break;
                            }
                        } else {
                            int i9 = 0;
                            while (true) {
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                byte[] bArr2 = this.j0;
                                int i10 = this.f0;
                                byte b = bArr2[i10];
                                if (b != 93) {
                                    boolean z = b == 62 && i9 >= 1;
                                    if (z) {
                                        i9--;
                                    }
                                    while (i9 > 0) {
                                        int i11 = iP + 1;
                                        cArrO[iP] = ']';
                                        if (i11 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                            iP = 0;
                                            i9--;
                                        } else {
                                            iP = i11;
                                            i9--;
                                        }
                                    }
                                    if (z) {
                                        this.f0++;
                                        this.f1584j.A(iP);
                                        return;
                                    }
                                } else {
                                    this.f0 = i10 + 1;
                                    i9++;
                                }
                            }
                        }
                        cArrO[iP] = (char) iT1;
                        iP++;
                    } else {
                        cArrO[iP] = (char) iT1;
                        i3 = i6;
                        iP++;
                    }
                } else {
                    this.f0 = i3;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        return false;
     */
    @Override // i.e.a.j.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean y0() throws XMLStreamException {
        while (true) {
            if (this.f0 >= this.g0 && !W()) {
                return false;
            }
            byte[] bArr = this.j0;
            int i2 = this.f0;
            if (bArr[i2] == 60) {
                if (i2 + 3 >= this.g0 && !f1(3)) {
                    return false;
                }
                byte[] bArr2 = this.j0;
                int i3 = this.f0;
                if (bArr2[i3 + 1] != 33 || bArr2[i3 + 2] != 91) {
                    break;
                }
                this.f0 = i3 + 3;
                for (int i4 = 0; i4 < 6; i4++) {
                    if (this.f0 >= this.g0) {
                        X();
                    }
                    byte[] bArr3 = this.j0;
                    int i5 = this.f0;
                    this.f0 = i5 + 1;
                    byte b = bArr3[i5];
                    if (b != ((byte) "CDATA[".charAt(i4))) {
                        r0(I0(b), " (expected '" + "CDATA[".charAt(i4) + "' for CDATA section)");
                        throw null;
                    }
                }
                w0();
            } else if (x0()) {
                return true;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9 A[PHI: r4 r5
      0x00c9: PHI (r4v15 int) = (r4v14 int), (r4v19 int) binds: [B:49:0x00c0, B:43:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00c9: PHI (r5v11 int) = (r5v10 int), (r5v14 int) binds: [B:49:0x00c0, B:43:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void y1() throws XMLStreamException {
        int i2;
        int iW1;
        int i3;
        int[] iArr = this.k0.a;
        byte[] bArr = this.j0;
        char[] cArrO = this.f1584j.o();
        int iP = this.f1584j.p();
        while (true) {
            int i4 = this.f0;
            if (i4 >= this.g0) {
                X();
                i4 = this.f0;
            }
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
                    int iT1 = bArr[i4] & 255;
                    if (iArr[iT1] != 0) {
                        this.f0 = i7;
                        switch (iArr[iT1]) {
                            case 1:
                                R(iT1);
                                if (this.f0 >= this.g0) {
                                    X();
                                }
                                i2 = this.f0;
                                if (bArr[i2] == 10) {
                                    this.f0 = i2 + 1;
                                }
                                J0();
                                iT1 = 10;
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 2:
                                if (this.f0 >= this.g0) {
                                }
                                i2 = this.f0;
                                if (bArr[i2] == 10) {
                                }
                                J0();
                                iT1 = 10;
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 3:
                                J0();
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 4:
                                L0(iT1);
                                throw null;
                            case 5:
                                iT1 = t1(iT1);
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 6:
                                iT1 = this.g0 - i7 >= 2 ? v1(iT1) : u1(iT1);
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 7:
                                iW1 = w1(iT1);
                                i3 = iP + 1;
                                cArrO[iP] = (char) ((iW1 >> 10) | 55296);
                                if (i3 >= cArrO.length) {
                                    cArrO = this.f1584j.n();
                                } else {
                                    i5 = i3;
                                }
                                iT1 = (iW1 & 1023) | 56320;
                                iP = i5;
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 8:
                            default:
                                cArrO[iP] = (char) iT1;
                                iP++;
                                break;
                            case 9:
                                this.f0 = i7 - 1;
                                break;
                            case 10:
                                iT1 = b1(false);
                                if (iT1 != 0) {
                                    if ((iT1 >> 16) != 0) {
                                        iW1 = iT1 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                        i3 = iP + 1;
                                        cArrO[iP] = (char) ((iW1 >> 10) | 55296);
                                        if (i3 >= cArrO.length) {
                                            cArrO = this.f1584j.n();
                                        }
                                        iT1 = (iW1 & 1023) | 56320;
                                        iP = i5;
                                    }
                                    cArrO[iP] = (char) iT1;
                                    iP++;
                                    break;
                                } else {
                                    this.f1585k = true;
                                    break;
                                }
                                break;
                            case 11:
                                int i8 = 1;
                                while (true) {
                                    if (this.f0 >= this.g0) {
                                        X();
                                    }
                                    int i9 = this.f0;
                                    byte b = bArr[i9];
                                    if (b == 93) {
                                        this.f0 = i9 + 1;
                                        i8++;
                                    } else {
                                        if (b == 62 && i8 > 1) {
                                            f0();
                                            throw null;
                                        }
                                        while (i8 > 1) {
                                            int i10 = iP + 1;
                                            cArrO[iP] = ']';
                                            if (i10 >= cArrO.length) {
                                                cArrO = this.f1584j.n();
                                                iP = 0;
                                            } else {
                                                iP = i10;
                                            }
                                            i8--;
                                        }
                                        cArrO[iP] = (char) iT1;
                                        iP++;
                                        break;
                                    }
                                }
                        }
                    } else {
                        cArrO[iP] = (char) iT1;
                        i4 = i7;
                        iP++;
                    }
                } else {
                    this.f0 = i4;
                }
            }
        }
        this.f1584j.A(iP);
    }

    @Override // i.e.a.j.e0
    protected final void z0() throws XMLStreamException {
        int[] iArr = this.k0.e;
        byte[] bArr = this.j0;
        while (true) {
            int i2 = this.f0;
            int i3 = this.g0;
            if (i2 >= i3) {
                X();
                i2 = this.f0;
                i3 = this.g0;
            }
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (iArr[i5] != 0) {
                        this.f0 = i4;
                        int i6 = iArr[i5];
                        if (i6 != 13) {
                            switch (i6) {
                                case 1:
                                    R(i5);
                                    break;
                                case 3:
                                    J0();
                                    continue;
                                case 4:
                                    L0(i5);
                                    throw null;
                                case 5:
                                    D1(i5);
                                    continue;
                                case 6:
                                    E1(i5);
                                    continue;
                                case 7:
                                    F1(i5);
                                    continue;
                            }
                            if (this.f0 >= this.g0) {
                                X();
                            }
                            int i7 = this.f0;
                            if (bArr[i7] == 10) {
                                this.f0 = i7 + 1;
                            }
                            J0();
                        } else {
                            if (i4 >= this.g0) {
                                X();
                            }
                            byte[] bArr2 = this.j0;
                            int i8 = this.f0;
                            if (bArr2[i8] == 45) {
                                int i9 = i8 + 1;
                                this.f0 = i9;
                                if (i9 >= this.g0) {
                                    X();
                                }
                                byte[] bArr3 = this.j0;
                                int i10 = this.f0;
                                this.f0 = i10 + 1;
                                if (bArr3[i10] == 62) {
                                    return;
                                }
                                b0();
                                throw null;
                            }
                        }
                    } else {
                        i2 = i4;
                    }
                } else {
                    this.f0 = i2;
                }
            }
        }
    }

    protected final void z1() throws XMLStreamException {
        while (true) {
            if (this.f0 >= this.g0 && !W()) {
                return;
            }
            byte[] bArr = this.j0;
            int i2 = this.f0;
            if (bArr[i2] != 60) {
                y1();
                if (this.f1585k) {
                    return;
                }
            } else {
                if (i2 + 3 >= this.g0 && !f1(3)) {
                    return;
                }
                byte[] bArr2 = this.j0;
                int i3 = this.f0;
                if (bArr2[i3 + 1] != 33 || bArr2[i3 + 2] != 91) {
                    return;
                }
                this.f0 = i3 + 3;
                for (int i4 = 0; i4 < 6; i4++) {
                    if (this.f0 >= this.g0) {
                        X();
                    }
                    byte[] bArr3 = this.j0;
                    int i5 = this.f0;
                    this.f0 = i5 + 1;
                    byte b = bArr3[i5];
                    if (b != ((byte) "CDATA[".charAt(i4))) {
                        r0(I0(b), " (expected '" + "CDATA[".charAt(i4) + "' for CDATA section)");
                        throw null;
                    }
                }
                x1();
            }
        }
    }
}
