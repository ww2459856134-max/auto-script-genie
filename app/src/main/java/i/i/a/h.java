package i.i.a;

import androidx.recyclerview.widget.k0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Serializable;

/* loaded from: classes.dex */
public class h implements Cloneable, Serializable {

    /* renamed from: j, reason: collision with root package name */
    static int f1733j = 2;
    protected transient int c;
    protected transient long[][][] d;
    protected transient int e;
    protected transient b f;
    protected transient long[] g;

    /* renamed from: h, reason: collision with root package name */
    protected transient d f1735h;

    /* renamed from: i, reason: collision with root package name */
    protected transient g f1736i;

    /* renamed from: k, reason: collision with root package name */
    static final long[] f1734k = new long[32];
    protected static final transient c t = new c();
    protected static final transient e A = new e();
    protected static final transient f C = new f();

    protected h(int i2, int i3) throws IndexOutOfBoundsException, NegativeArraySizeException {
        if (i2 >= 0) {
            h(i2 - 1);
            this.c = i3;
            b();
            m();
            return;
        }
        throw new NegativeArraySizeException("(requested capacity=" + i2 + ") < 0");
    }

    protected static void n(int i2, int i3) throws IndexOutOfBoundsException {
        String string;
        if (i2 < 0) {
            string = "(i=" + i2 + ") < 0";
        } else {
            string = "";
        }
        if (i2 == Integer.MAX_VALUE) {
            string = string + "(i=" + i2 + ")";
        }
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(string.isEmpty() ? "" : ", ");
            sb.append("(j=");
            sb.append(i3);
            sb.append(") < 0");
            string = sb.toString();
        }
        if (i2 > i3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(string.isEmpty() ? "" : ", ");
            sb2.append("(i=");
            sb2.append(i2);
            sb2.append(") > (j=");
            sb2.append(i3);
            sb2.append(")");
            string = sb2.toString();
        }
        throw new IndexOutOfBoundsException(string);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h clone() throws IndexOutOfBoundsException {
        try {
            h hVar = (h) super.clone();
            hVar.d = null;
            hVar.h(1);
            hVar.b();
            hVar.f1735h = null;
            hVar.l(0, this.e, this, t);
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }

    protected final void b() {
        this.g = new long[32];
        this.f = new b(this);
        this.f1736i = new g(this);
    }

    public boolean c(int i2) {
        long[][] jArr;
        long[] jArr2;
        if (i2 + 1 >= 1) {
            int i3 = i2 >> 6;
            return (i2 >= this.e || (jArr = this.d[i3 >> 10]) == null || (jArr2 = jArr[(i3 >> 5) & 31]) == null || (jArr2[i3 & 31] & (1 << i2)) == 0) ? false : true;
        }
        throw new IndexOutOfBoundsException("i=" + i2);
    }

    public int d(int i2) {
        long[][] jArr;
        long[] jArr2;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("i=" + i2);
        }
        int i3 = i2 >> 6;
        int i4 = i3 & 31;
        int i5 = (i3 >> 5) & 31;
        int i6 = i3 >> 10;
        long j2 = -1;
        long j3 = (-1) << i2;
        long[][][] jArr3 = this.d;
        int length = jArr3.length;
        if (i6 < length && (jArr = jArr3[i6]) != null && (jArr2 = jArr[i5]) != null) {
            j3 &= ~jArr2[i4];
            if (j3 == 0) {
                int i7 = i3 + 1;
                i6 = i7 >> 10;
                i4 = i7 & 31;
                int i8 = (i7 >> 5) & 31;
                loop0: while (i6 != length) {
                    long[][] jArr4 = this.d[i6];
                    if (jArr4 == null) {
                        break;
                    }
                    while (i8 != 32) {
                        long[] jArr5 = jArr4[i8];
                        if (jArr5 == null) {
                            break loop0;
                        }
                        while (i4 != 32) {
                            j2 = ~jArr5[i4];
                            if (j2 != 0) {
                                break loop0;
                            }
                            i4++;
                        }
                        i8++;
                        i4 = 0;
                    }
                    i6++;
                    i8 = 0;
                    i4 = 0;
                }
                i5 = i8;
                j3 = j2;
            }
        }
        int iNumberOfTrailingZeros = ((((i6 << 10) + (i5 << 5)) + i4) << 6) + Long.numberOfTrailingZeros(j3);
        if (iNumberOfTrailingZeros == Integer.MAX_VALUE) {
            return -1;
        }
        return iNumberOfTrailingZeros;
    }

    public int e(int i2) {
        long j2;
        long[] jArr;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("i=" + i2);
        }
        int i3 = i2 >> 6;
        int i4 = i3 & 31;
        int i5 = (i3 >> 5) & 31;
        int i6 = i3 >> 10;
        long[][][] jArr2 = this.d;
        int length = jArr2.length;
        long j3 = 0;
        if (i6 < length) {
            long[][] jArr3 = jArr2[i6];
            if (jArr3 == null || (jArr = jArr3[i5]) == null) {
                j2 = 0;
            } else {
                j2 = jArr[i4] & ((-1) << i2);
                if (j2 == 0) {
                }
                j3 = j2;
            }
            int i7 = i3 + 1;
            i6 = i7 >> 10;
            i4 = i7 & 31;
            int i8 = (i7 >> 5) & 31;
            loop0: while (i6 != length) {
                long[][] jArr4 = this.d[i6];
                if (jArr4 != null) {
                    while (i8 != 32) {
                        long[] jArr5 = jArr4[i8];
                        if (jArr5 != null) {
                            while (i4 != 32) {
                                j2 = jArr5[i4];
                                if (j2 != 0) {
                                    break loop0;
                                }
                                i4++;
                            }
                        }
                        i8++;
                        i4 = 0;
                    }
                }
                i6++;
                i8 = 0;
                i4 = 0;
            }
            i5 = i8;
            j3 = j2;
        }
        if (i6 >= length) {
            return -1;
        }
        return ((((i6 << 10) + (i5 << 5)) + i4) << 6) + Long.numberOfTrailingZeros(j3);
    }

    public boolean equals(Object obj) throws IndexOutOfBoundsException {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this == hVar) {
            return true;
        }
        if (this.f1735h == null) {
            this.f1735h = new d();
        }
        l(0, Math.max(this.e, hVar.e), hVar, this.f1735h);
        return this.f1735h.a;
    }

    protected final void f(int i2) {
        int length = this.d.length;
        if (i2 < length) {
            while (i2 != length) {
                this.d[i2] = null;
                i2++;
            }
            this.f.a = 0;
        }
    }

    public void g(h hVar) throws IndexOutOfBoundsException {
        l(0, hVar.e, hVar, A);
    }

    protected final void h(int i2) {
        int i3 = (i2 >> 6) >> 10;
        int iHighestOneBit = Integer.highestOneBit(i3);
        if (iHighestOneBit == 0) {
            iHighestOneBit = 1;
        }
        if (i3 >= iHighestOneBit) {
            iHighestOneBit <<= 1;
        }
        if (iHighestOneBit > 32768) {
            iHighestOneBit = 32768;
        }
        long[][][] jArr = this.d;
        int length = jArr != null ? jArr.length : 0;
        if (iHighestOneBit != length || jArr == null) {
            long[][][] jArr2 = new long[iHighestOneBit][][];
            if (length != 0) {
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(length, iHighestOneBit));
                f(0);
            }
            this.d = jArr2;
            this.e = iHighestOneBit == 32768 ? Integer.MAX_VALUE : WXMediaMessage.THUMB_LENGTH_LIMIT * iHighestOneBit;
        }
    }

    public int hashCode() throws IndexOutOfBoundsException {
        m();
        return this.f.a;
    }

    public void i(int i2) {
        if (i2 + 1 < 1) {
            throw new IndexOutOfBoundsException("i=" + i2);
        }
        int i3 = i2 >> 6;
        int i4 = i3 >> 10;
        int i5 = (i3 >> 5) & 31;
        if (i2 >= this.e) {
            h(i2);
        }
        long[][][] jArr = this.d;
        long[][] jArr2 = jArr[i4];
        if (jArr2 == null) {
            jArr2 = new long[32][];
            jArr[i4] = jArr2;
        }
        long[] jArr3 = jArr2[i5];
        if (jArr3 == null) {
            jArr3 = new long[32];
            jArr2[i5] = jArr3;
        }
        int i6 = i3 & 31;
        jArr3[i6] = jArr3[i6] | (1 << i2);
        this.f.a = 0;
    }

    public void k(int i2, int i3) throws IndexOutOfBoundsException {
        l(i2, i3, null, C);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void l(int i2, int i3, h hVar, a aVar) throws IndexOutOfBoundsException {
        long[][] jArr;
        boolean z;
        long[][] jArr2;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        long[][][] jArr3;
        int i9;
        int i10;
        long[] jArr4;
        boolean z4;
        long[] jArr5;
        boolean z5;
        int i11;
        boolean z6;
        int i12;
        int i13;
        int i14;
        int i15;
        long[][][] jArr6;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean zF;
        int i22;
        int i23;
        int i24;
        int i25 = i2;
        int i26 = i3;
        if (aVar.e(hVar)) {
            this.f.a = 0;
        }
        if (i26 < i25 || i25 + 1 < 1) {
            n(i2, i3);
            throw null;
        }
        if (i25 == i26) {
            return;
        }
        int iD = aVar.d();
        boolean z7 = (iD & 1) != 0;
        boolean z8 = (iD & 2) != 0;
        boolean z9 = (iD & 4) != 0;
        boolean z10 = (iD & 8) != 0;
        int i27 = i25 >> 6;
        long j2 = (-1) << i25;
        int i28 = (i26 - 1) >> 6;
        long j3 = (-1) >>> (-i26);
        long[][][] jArr7 = this.d;
        int length = jArr7.length;
        long[][][] jArr8 = hVar != null ? hVar.d : null;
        int length2 = jArr8 != null ? hVar.d.length : 0;
        int i29 = i27 >> 10;
        int i30 = (i27 >> 5) & 31;
        int i31 = i27 & 31;
        int i32 = i28 >> 10;
        int i33 = (i28 >> 5) & 31;
        int i34 = i28 & 31;
        int i35 = (i32 << 5) + i33;
        boolean z11 = i27 == 0 && j2 == -1;
        int i36 = i27;
        boolean z12 = i30 == 0;
        int i37 = length;
        int i38 = i29;
        int i39 = 0;
        int i40 = 0;
        while (i25 < i26) {
            if (i38 < i37) {
                jArr = jArr7[i38];
                z = jArr != null;
                if (i38 < length2 || jArr8 == null) {
                    jArr2 = null;
                } else {
                    jArr2 = jArr8[i38];
                    boolean z13 = jArr2 != null;
                    if (((z || z13 || !z7) && ((z || !z8) && (z13 || !z9))) || !z11 || i38 == i32) {
                        z2 = z11;
                        i4 = i38 == i32 ? i33 + 1 : 32;
                        long[][] jArr9 = jArr;
                        boolean z14 = z;
                        z3 = z12;
                        int i41 = i39;
                        int length3 = i37;
                        int i42 = i30;
                        long[][][] jArr10 = jArr7;
                        i5 = i42;
                        while (i5 != i4) {
                            if (z14) {
                                jArr4 = jArr9[i5];
                                z4 = jArr4 != null;
                                if (z13) {
                                    jArr5 = null;
                                } else {
                                    jArr5 = jArr2[i5];
                                    z5 = jArr5 != null;
                                    i11 = (i38 << 5) + i5;
                                    z6 = i35 != i11;
                                    if (((!z4 && !z5 && z7) || ((!z4 && z8) || (!z5 && z9))) && z2 && z6) {
                                        if (z14) {
                                            jArr9[i5] = null;
                                        }
                                        i12 = length2;
                                        i13 = i4;
                                        i23 = i38;
                                        i22 = i5;
                                        i21 = i28;
                                        jArr6 = jArr8;
                                        i19 = i32;
                                        int i43 = i35;
                                        i17 = i36;
                                        i18 = i43;
                                    } else {
                                        int i44 = i11 << 5;
                                        int i45 = z6 ? 32 : i34;
                                        if (!z4) {
                                            jArr4 = this.g;
                                        }
                                        long[] jArr11 = !z5 ? f1734k : jArr5;
                                        if (!z2 || !z6) {
                                            i12 = length2;
                                            long[] jArr12 = jArr4;
                                            i13 = i4;
                                            i14 = i38;
                                            i15 = i5;
                                            jArr6 = jArr8;
                                            i16 = length3;
                                            int i46 = i35;
                                            i17 = i36;
                                            i18 = i46;
                                            if (z2) {
                                                i19 = i32;
                                                i20 = 32;
                                                int i47 = i28;
                                                if (i17 == i47) {
                                                    i21 = i47;
                                                    zF = aVar.f(i44, i31, jArr12, jArr11, j2 & j3);
                                                } else {
                                                    i21 = i47;
                                                    boolean zF2 = aVar.f(i44, i31, jArr12, jArr11, j2) & aVar.a(i44, i31 + 1, i45, jArr12, jArr11);
                                                    int i48 = i45;
                                                    zF = i48 != 32 ? zF2 & aVar.f(i44, i48, jArr12, jArr11, j3) : zF2;
                                                }
                                                z2 = true;
                                            } else {
                                                i19 = i32;
                                                i20 = 32;
                                                i21 = i28;
                                                zF = aVar.a(i44, 0, i45, jArr12, jArr11) & aVar.f(i44, i45, jArr12, jArr11, j3);
                                            }
                                            jArr4 = jArr12;
                                            if (zF) {
                                                zF = aVar.c(jArr4);
                                            }
                                        } else if (!z10 || z5) {
                                            i12 = length2;
                                            long[] jArr13 = jArr4;
                                            i13 = i4;
                                            i14 = i38;
                                            i15 = i5;
                                            jArr6 = jArr8;
                                            i16 = length3;
                                            int i49 = i35;
                                            i17 = i36;
                                            i18 = i49;
                                            i21 = i28;
                                            i19 = i32;
                                            jArr4 = jArr13;
                                            i20 = 32;
                                            zF = aVar.a(i44, 0, 32, jArr13, jArr11);
                                        } else {
                                            zF = aVar.c(jArr4);
                                            i12 = length2;
                                            i13 = i4;
                                            i14 = i38;
                                            i15 = i5;
                                            i21 = i28;
                                            jArr6 = jArr8;
                                            i19 = i32;
                                            i20 = 32;
                                            i16 = length3;
                                            int i50 = i35;
                                            i17 = i36;
                                            i18 = i50;
                                        }
                                        if (zF) {
                                            i22 = i15;
                                            if (jArr4 == this.g) {
                                                if (i25 >= this.e) {
                                                    h(i25);
                                                    long[][][] jArr14 = this.d;
                                                    length3 = jArr14.length;
                                                    jArr10 = jArr14;
                                                } else {
                                                    length3 = i16;
                                                }
                                                if (jArr9 == null) {
                                                    long[][] jArr15 = new long[i20][];
                                                    i23 = i14;
                                                    jArr10[i23] = jArr15;
                                                    jArr9 = jArr15;
                                                    z14 = true;
                                                } else {
                                                    i23 = i14;
                                                }
                                                jArr9[i22] = jArr4;
                                                this.g = new long[i20];
                                            } else {
                                                i23 = i14;
                                                length3 = i16;
                                            }
                                            i41++;
                                        } else {
                                            i22 = i15;
                                            if (z14) {
                                                jArr9[i22] = null;
                                            }
                                            length3 = i16;
                                            i23 = i14;
                                        }
                                        z3 &= z14 || jArr9[i22] == null;
                                    }
                                    i5 = i22 + 1;
                                    i38 = i23;
                                    i4 = i13;
                                    jArr8 = jArr6;
                                    length2 = i12;
                                    i32 = i19;
                                    i28 = i21;
                                    i31 = 0;
                                    int i51 = i17;
                                    i35 = i18;
                                    i36 = i51;
                                }
                                i11 = (i38 << 5) + i5;
                                if (i35 != i11) {
                                }
                                if (!z4) {
                                    int i442 = i11 << 5;
                                    if (z6) {
                                    }
                                    if (!z4) {
                                    }
                                    if (!z5) {
                                    }
                                    if (!z2) {
                                        i12 = length2;
                                        long[] jArr122 = jArr4;
                                        i13 = i4;
                                        i14 = i38;
                                        i15 = i5;
                                        jArr6 = jArr8;
                                        i16 = length3;
                                        int i462 = i35;
                                        i17 = i36;
                                        i18 = i462;
                                        if (z2) {
                                        }
                                        jArr4 = jArr122;
                                        if (zF) {
                                        }
                                        if (zF) {
                                        }
                                        if (z14) {
                                            z3 &= z14 || jArr9[i22] == null;
                                        }
                                    }
                                } else {
                                    int i4422 = i11 << 5;
                                    if (z6) {
                                    }
                                    if (!z4) {
                                    }
                                    if (!z5) {
                                    }
                                    if (!z2) {
                                    }
                                }
                                i5 = i22 + 1;
                                i38 = i23;
                                i4 = i13;
                                jArr8 = jArr6;
                                length2 = i12;
                                i32 = i19;
                                i28 = i21;
                                i31 = 0;
                                int i512 = i17;
                                i35 = i18;
                                i36 = i512;
                            } else {
                                jArr4 = null;
                            }
                            if (z13) {
                            }
                            i11 = (i38 << 5) + i5;
                            if (i35 != i11) {
                            }
                            if (!z4) {
                            }
                            i5 = i22 + 1;
                            i38 = i23;
                            i4 = i13;
                            jArr8 = jArr6;
                            length2 = i12;
                            i32 = i19;
                            i28 = i21;
                            i31 = 0;
                            int i5122 = i17;
                            i35 = i18;
                            i36 = i5122;
                        }
                        i6 = length2;
                        i7 = i38;
                        i8 = i28;
                        jArr3 = jArr8;
                        i9 = i35;
                        i10 = i32;
                        int i52 = length3;
                        if (i5 == 32 && z3 && i7 < i52) {
                            jArr10[i7] = null;
                        } else {
                            i40++;
                        }
                        i37 = i52;
                        jArr7 = jArr10;
                        i39 = i41;
                    } else {
                        if (i38 < i37) {
                            jArr7[i38] = null;
                        }
                        z3 = z12;
                        i6 = length2;
                        z2 = z11;
                        i7 = i38;
                        i8 = i28;
                        jArr3 = jArr8;
                        i9 = i35;
                        i10 = i32;
                    }
                    i38 = i7 + 1;
                    int i53 = i38 << 10;
                    i24 = i53 << 6;
                    if (i24 < 0) {
                        i24 = Integer.MAX_VALUE;
                    }
                    i35 = i9;
                    i36 = i53;
                    i25 = i24;
                    z12 = z3;
                    z11 = z2;
                    jArr8 = jArr3;
                    length2 = i6;
                    i32 = i10;
                    i28 = i8;
                    i30 = 0;
                    i26 = i3;
                }
                if (z) {
                    z2 = z11;
                    if (i38 == i32) {
                    }
                    long[][] jArr92 = jArr;
                    boolean z142 = z;
                    z3 = z12;
                    int i412 = i39;
                    int length32 = i37;
                    int i422 = i30;
                    long[][][] jArr102 = jArr7;
                    i5 = i422;
                    while (i5 != i4) {
                    }
                    i6 = length2;
                    i7 = i38;
                    i8 = i28;
                    jArr3 = jArr8;
                    i9 = i35;
                    i10 = i32;
                    int i522 = length32;
                    if (i5 == 32) {
                        i40++;
                        i37 = i522;
                        jArr7 = jArr102;
                        i39 = i412;
                    }
                } else {
                    z2 = z11;
                    if (i38 == i32) {
                    }
                    long[][] jArr922 = jArr;
                    boolean z1422 = z;
                    z3 = z12;
                    int i4122 = i39;
                    int length322 = i37;
                    int i4222 = i30;
                    long[][][] jArr1022 = jArr7;
                    i5 = i4222;
                    while (i5 != i4) {
                    }
                    i6 = length2;
                    i7 = i38;
                    i8 = i28;
                    jArr3 = jArr8;
                    i9 = i35;
                    i10 = i32;
                    int i5222 = length322;
                    if (i5 == 32) {
                    }
                }
                i38 = i7 + 1;
                int i532 = i38 << 10;
                i24 = i532 << 6;
                if (i24 < 0) {
                }
                i35 = i9;
                i36 = i532;
                i25 = i24;
                z12 = z3;
                z11 = z2;
                jArr8 = jArr3;
                length2 = i6;
                i32 = i10;
                i28 = i8;
                i30 = 0;
                i26 = i3;
            } else {
                jArr = null;
            }
            if (i38 < length2) {
                jArr2 = null;
            }
            if (z) {
            }
            i38 = i7 + 1;
            int i5322 = i38 << 10;
            i24 = i5322 << 6;
            if (i24 < 0) {
            }
            i35 = i9;
            i36 = i5322;
            i25 = i24;
            z12 = z3;
            z11 = z2;
            jArr8 = jArr3;
            length2 = i6;
            i32 = i10;
            i28 = i8;
            i30 = 0;
            i26 = i3;
        }
        aVar.b(i40, i39);
    }

    protected final void m() throws IndexOutOfBoundsException {
        if (this.f.a != 0) {
            return;
        }
        l(0, this.e, null, this.f1736i);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        StringBuilder sb = new StringBuilder(k0.a.DEFAULT_DRAG_ANIMATION_DURATION);
        sb.append('{');
        int iE = e(0);
        while (iE >= 0) {
            sb.append(iE);
            int iE2 = e(iE + 1);
            if (this.c <= 0) {
                iE = iE2;
            } else {
                if (iE2 < 0) {
                    break;
                }
                int iD = d(iE);
                if (iD < 0) {
                    iD = Integer.MAX_VALUE;
                }
                if (iE + this.c < iD) {
                    sb.append("..");
                    sb.append(iD - 1);
                    iE = e(iD);
                }
            }
            if (iE >= 0) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h() {
        this(1, f1733j);
    }
}
