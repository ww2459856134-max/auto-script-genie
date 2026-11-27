package i.e.a.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class f extends e0 {
    protected int f0;
    protected int g0;
    protected int h0;

    protected f(z zVar) {
        super(zVar);
        this.h0 = 0;
        this.Z = 0L;
        this.b0 = 0;
    }

    @Override // i.e.a.j.e0
    public n.b.a.h D() {
        String strH = this.c.H();
        String strI = this.c.I();
        long j2 = this.Z;
        int i2 = this.f0;
        return i.e.a.i.d.b(strH, strI, j2 + i2, this.a0, i2 - this.b0);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0163 A[PHI: r4 r14
      0x0163: PHI (r4v14 int) = (r4v13 int), (r4v18 int) binds: [B:74:0x0124, B:78:0x013e] A[DONT_GENERATE, DONT_INLINE]
      0x0163: PHI (r14v7 int) = (r14v6 int), (r14v9 int) binds: [B:74:0x0124, B:78:0x013e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final v H0(e eVar, i.e.a.l.o oVar, int i2, int[] iArr, int i3, int i4) throws XMLStreamException {
        int i5;
        boolean zE;
        int i6;
        int i7;
        boolean zD;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = ((i3 << 2) - 4) + i4;
        if (i4 < 4) {
            int i13 = i3 - 1;
            i5 = iArr[i13];
            iArr[i13] = i5 << ((4 - i4) << 3);
        } else {
            i5 = 0;
        }
        int i14 = iArr[0] >>> 24;
        char[] cArrB = this.t;
        int[] iArr2 = oVar.c;
        int i15 = iArr2[i14];
        int i16 = 1;
        if (i15 == 0 || i15 == 1 || i15 == 2) {
            zE = false;
            i6 = 0;
            i7 = 1;
        } else if (i15 == 3) {
            i6 = 0;
            zE = true;
            i7 = 1;
        } else if (i15 != 4) {
            if ((i14 & 224) == 192) {
                i10 = i14 & 31;
                i11 = 1;
            } else if ((i14 & 240) == 224) {
                i10 = i14 & 15;
                i11 = 2;
            } else {
                if ((i14 & 248) != 240) {
                    L0(i14);
                    throw null;
                }
                i10 = i14 & 7;
                i11 = 3;
            }
            i7 = 1 + i11;
            if (i7 > i12) {
                e0(cArrB, 0);
                throw null;
            }
            int i17 = iArr[0];
            int i18 = (i17 >> 16) & 255;
            if ((i18 & 192) != 128) {
                M0(i18);
                throw null;
            }
            int i19 = (i10 << 6) | (i18 & 63);
            if (i11 > 1) {
                int i20 = (i17 >> 8) & 255;
                if ((i20 & 192) != 128) {
                    M0(i20);
                    throw null;
                }
                i19 = (i19 << 6) | (i20 & 63);
                if (i11 > 2) {
                    int i21 = i17 & 255;
                    if ((i21 & 192) != 128) {
                        M0(i21 & 255);
                        throw null;
                    }
                    i19 = (i19 << 6) | (i21 & 63);
                }
            }
            i14 = i19;
            zE = i.e.a.l.p.e(i14);
            if (i11 > 2) {
                int i22 = i14 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                cArrB[0] = (char) ((i22 >> 10) + 55296);
                i14 = (i22 & 1023) | 56320;
                i6 = 1;
            } else {
                i6 = 0;
            }
        }
        if (!zE) {
            j0(i14, 0);
            throw null;
        }
        int i23 = i6 + 1;
        cArrB[i6] = (char) i14;
        int i24 = -1;
        while (i7 < i12) {
            int i25 = (iArr[i7 >> 2] >> ((3 - (i7 & 3)) << 3)) & 255;
            i7++;
            int i26 = iArr2[i25];
            if (i26 != 0) {
                if (i26 != i16) {
                    if (i26 != 2 && i26 != 3) {
                        if (i26 != 4) {
                            if ((i25 & 224) == 192) {
                                i8 = i25 & 31;
                                i9 = i16;
                            } else if ((i25 & 240) == 224) {
                                i8 = i25 & 15;
                                i9 = 2;
                            } else {
                                if ((i25 & 248) != 240) {
                                    L0(i25);
                                    throw null;
                                }
                                i8 = i25 & 7;
                                i9 = 3;
                            }
                            if (i7 + i9 > i12) {
                                e0(cArrB, i23);
                                throw null;
                            }
                            int i27 = iArr[i7 >> 2] >> ((3 - (i7 & 3)) << 3);
                            i7++;
                            if ((i27 & 192) != 128) {
                                M0(i27);
                                throw null;
                            }
                            int i28 = (i8 << 6) | (i27 & 63);
                            if (i9 > i16) {
                                int i29 = iArr[i7 >> 2] >> ((3 - (i7 & 3)) << 3);
                                i7++;
                                if ((i29 & 192) != 128) {
                                    M0(i29);
                                    throw null;
                                }
                                i28 = (i28 << 6) | (i29 & 63);
                                if (i9 > 2) {
                                    int i30 = iArr[i7 >> 2] >> ((3 - (i7 & 3)) << 3);
                                    i7++;
                                    if ((i30 & 192) != 128) {
                                        M0(i30 & 255);
                                        throw null;
                                    }
                                    i28 = (i28 << 6) | (i30 & 63);
                                }
                                i25 = i28;
                                zD = i.e.a.l.p.d(i25);
                                if (i9 > 2) {
                                    int i31 = i25 - WXMediaMessage.THUMB_LENGTH_LIMIT;
                                    if (i23 >= cArrB.length) {
                                        cArrB = i.e.a.l.c.b(cArrB, cArrB.length);
                                        this.t = cArrB;
                                    }
                                    cArrB[i23] = (char) ((i31 >> 10) + 55296);
                                    i25 = (i31 & 1023) | 56320;
                                    i23++;
                                }
                            }
                            if (!zD) {
                                j0(i25, i23);
                                throw null;
                            }
                            if (i23 >= cArrB.length) {
                                char[] cArrB2 = i.e.a.l.c.b(cArrB, cArrB.length);
                                this.t = cArrB2;
                                cArrB = cArrB2;
                            }
                            cArrB[i23] = (char) i25;
                            i23++;
                            i16 = 1;
                        }
                    }
                } else {
                    if (i24 >= 0) {
                        n0();
                        throw null;
                    }
                    i24 = i23;
                }
                zD = true;
                if (!zD) {
                }
            }
            zD = false;
            if (!zD) {
            }
        }
        String str = new String(cArrB, 0, i23);
        if (i4 < 4) {
            iArr[i3 - 1] = i5;
        }
        return eVar.a(i2, str, i24, iArr, i3);
    }

    @Override // i.e.a.j.e0
    public long I() throws XMLStreamException {
        if (this.f1582h) {
            t();
        }
        return this.Z + this.f0;
    }

    protected abstract int I0(byte b) throws XMLStreamException;

    @Override // i.e.a.j.e0
    public long J() throws XMLStreamException {
        return -1L;
    }

    protected final void J0() {
        this.b0 = this.f0;
        this.a0++;
    }

    protected final void K0(int i2) {
        this.b0 = i2;
        this.a0++;
    }

    protected void L0(int i2) throws XMLStreamException {
        i0("Invalid UTF-8 start byte 0x" + Integer.toHexString(i2));
        throw null;
    }

    protected void M0(int i2) throws XMLStreamException {
        i0("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i2));
        throw null;
    }

    protected final void N0() {
        this.c0 = this.Z + this.f0;
        this.d0 = this.a0;
        this.e0 = r2 - this.b0;
    }

    @Override // i.e.a.j.e0
    public long O() {
        return this.c0;
    }

    @Override // i.e.a.j.e0
    public long P() {
        return -1L;
    }
}
