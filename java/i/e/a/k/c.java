package i.e.a.k;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class c extends x {

    /* renamed from: n, reason: collision with root package name */
    static final byte[] f1612n = Q("<![CDATA[");

    /* renamed from: o, reason: collision with root package name */
    static final byte[] f1613o = Q("]]>");
    static final byte[] p = Q("<!--");
    static final byte[] q = Q("-->");
    static final byte[] r = Q("<?xml version='");
    static final byte[] s = Q(" encoding='");
    static final byte[] t = Q(" standalone='");

    /* renamed from: h, reason: collision with root package name */
    protected OutputStream f1614h;

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f1615i;

    /* renamed from: j, reason: collision with root package name */
    protected int f1616j;

    /* renamed from: k, reason: collision with root package name */
    protected final int f1617k;

    /* renamed from: l, reason: collision with root package name */
    protected int f1618l;

    /* renamed from: m, reason: collision with root package name */
    protected final i.e.a.l.o f1619m;

    protected c(w wVar, OutputStream outputStream, i.e.a.l.o oVar) {
        super(wVar);
        this.f1618l = 0;
        this.f1614h = outputStream;
        byte[] bArrH = wVar.h(4000);
        this.f1615i = bArrH;
        this.f1617k = bArrH.length;
        this.f1616j = 0;
        this.f1619m = oVar;
    }

    protected static final void P(String str, byte[] bArr, int i2) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i2 + i3] = (byte) str.charAt(i3);
        }
    }

    protected static final byte[] Q(String str) {
        byte[] bArr = new byte[str.length()];
        P(str, bArr, 0);
        return bArr;
    }

    private final void R(String str) throws IOException, XMLStreamException {
        int length = str.length();
        char[] cArr = this.b;
        int i2 = 0;
        while (true) {
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i3 = i2 + length2;
            str.getChars(i2, i3, cArr, 0);
            w(cArr, 0, length2);
            length -= length2;
            if (length <= 0) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1619m.a;
            do {
                char c = cArr[i2];
                if (c < 2048) {
                    if (iArr[c] != 0) {
                        if (c == '\n') {
                            this.f++;
                        }
                    }
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i5 = this.f1616j;
                    this.f1616j = i5 + 1;
                    bArr[i5] = (byte) c;
                    i2++;
                }
                int i6 = i2 + 1;
                char c2 = cArr[i2];
                if (c2 < 2048) {
                    int i7 = iArr[c2];
                    if (i7 == 1) {
                        o(c2);
                        throw null;
                    }
                    if (i7 != 2) {
                        if (i7 == 4) {
                            Y(c2);
                            i2 = i6;
                        } else {
                            if (i7 != 5) {
                                switch (i7) {
                                    case 9:
                                    case 10:
                                        break;
                                    case 11:
                                        if (i6 >= i4 || cArr[i6] == '>') {
                                            Y(c2);
                                            break;
                                        }
                                        break;
                                    default:
                                        if (this.f1616j >= this.f1617k) {
                                            O();
                                        }
                                        byte[] bArr2 = this.f1615i;
                                        int i8 = this.f1616j;
                                        this.f1616j = i8 + 1;
                                        bArr2[i8] = (byte) c2;
                                        break;
                                }
                            } else {
                                S(c2);
                            }
                            i2 = i6;
                        }
                    } else if (this.a.J()) {
                        Y(c2);
                        i2 = i6;
                    } else {
                        this.f++;
                        if (this.f1616j >= this.f1617k) {
                        }
                        byte[] bArr22 = this.f1615i;
                        int i82 = this.f1616j;
                        this.f1616j = i82 + 1;
                        bArr22[i82] = (byte) c2;
                        i2 = i6;
                    }
                } else {
                    i2 = T(c2, cArr, i6, i4);
                }
            } while (i2 < i4);
            return;
        }
    }

    @Override // i.e.a.k.x
    public final void A(r rVar) throws IOException, XMLStreamException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        int i2 = this.f1616j;
        int iH = rVar.h();
        if (i2 + iH + 3 > this.f1617k) {
            O();
            if (iH + 3 > this.f1617k) {
                this.f1614h.write(60);
                this.f1614h.write(47);
                rVar.i(this.f1614h);
                byte[] bArr = this.f1615i;
                int i3 = this.f1616j;
                this.f1616j = i3 + 1;
                bArr[i3] = 62;
                return;
            }
            i2 = this.f1616j;
        }
        byte[] bArr2 = this.f1615i;
        int i4 = i2 + 1;
        bArr2[i2] = 60;
        int i5 = i4 + 1;
        bArr2[i4] = 47;
        int iA = i5 + rVar.a(bArr2, i5);
        bArr2[iA] = 62;
        this.f1616j = iA + 1;
    }

    @Override // i.e.a.k.x
    public void B(r rVar) throws IOException, XMLStreamException {
        l0((byte) 38);
        j0(rVar);
        l0((byte) 59);
    }

    @Override // i.e.a.k.x
    public int C(r rVar, String str) throws IOException, XMLStreamException {
        m0((byte) 60, (byte) 63);
        j0(rVar);
        if (str != null) {
            l0((byte) 32);
            int length = str.length();
            int i2 = 0;
            while (length > 0) {
                char[] cArr = this.b;
                int length2 = cArr.length;
                if (length2 > length) {
                    length2 = length;
                }
                int i3 = i2 + length2;
                str.getChars(i2, i3, cArr, 0);
                int iK0 = k0(cArr, 0, length2);
                if (iK0 >= 0) {
                    return i2 + iK0;
                }
                length -= length2;
                i2 = i3;
            }
        }
        m0((byte) 63, (byte) 62);
        return -1;
    }

    @Override // i.e.a.k.x
    public final void D(String str, int i2, int i3) throws IOException, XMLStreamException {
        while (i3 > 0) {
            char[] cArr = this.b;
            int length = cArr.length;
            if (i3 < length) {
                length = i3;
            }
            int i4 = i2 + length;
            str.getChars(i2, i4, cArr, 0);
            p0(cArr, 0, length);
            i3 -= length;
            i2 = i4;
        }
    }

    @Override // i.e.a.k.x
    public final void E(String str) throws IOException, XMLStreamException {
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            char[] cArr = this.b;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i3 = i2 + length2;
            str.getChars(i2, i3, cArr, 0);
            F(cArr, 0, length2);
            length -= length2;
            i2 = i3;
        }
    }

    @Override // i.e.a.k.x
    public void F(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        if (this.f1614h == null) {
            return;
        }
        int i4 = this.f1618l;
        if (i4 != 0) {
            q(i.e.a.i.b.B, Integer.valueOf(i4), Integer.valueOf(i2 - 1));
            throw null;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int i6 = i2 + 1;
            char c = cArr[i2];
            if (c > ' ' && (!this.a.C() || (c != 133 && c != 8232))) {
                q(i.e.a.i.b.B, Integer.valueOf(c), Integer.valueOf(i6 - 1));
                throw null;
            }
            if (this.f1616j >= this.f1617k) {
                O();
            }
            byte[] bArr = this.f1615i;
            int i7 = this.f1616j;
            this.f1616j = i7 + 1;
            bArr[i7] = (byte) c;
            i2 = i6;
        }
    }

    @Override // i.e.a.k.x
    public void G() throws IOException {
        int i2 = this.f1616j;
        if (i2 + 2 > this.f1617k) {
            O();
            i2 = this.f1616j;
        }
        byte[] bArr = this.f1615i;
        int i3 = i2 + 1;
        bArr[i2] = 47;
        bArr[i3] = 62;
        this.f1616j = i3 + 1;
    }

    @Override // i.e.a.k.x
    public final void H() throws IOException, XMLStreamException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        if (this.f1616j >= this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i2 = this.f1616j;
        this.f1616j = i2 + 1;
        bArr[i2] = 62;
    }

    @Override // i.e.a.k.x
    public final void I(r rVar) throws IOException, XMLStreamException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        int i2 = this.f1616j;
        if (rVar.h() + i2 + 1 > this.f1617k) {
            i0((byte) 60, rVar);
            return;
        }
        byte[] bArr = this.f1615i;
        int i3 = i2 + 1;
        bArr[i2] = 60;
        this.f1616j = i3 + rVar.a(bArr, i3);
    }

    @Override // i.e.a.k.x
    public void J(String str, String str2, String str3) throws IOException, XMLStreamException {
        n0(r);
        D(str, 0, str.length());
        l0((byte) 39);
        if (str2 != null && str2.length() > 0) {
            n0(s);
            D(str2, 0, str2.length());
            l0((byte) 39);
        }
        if (str3 != null) {
            n0(t);
            D(str3, 0, str3.length());
            l0((byte) 39);
        }
        m0((byte) 63, (byte) 62);
    }

    protected final int K(int i2, int i3, String str) throws XMLStreamException {
        if (i3 >= 56320 && i3 <= 57343) {
            int i4 = ((i2 - 55296) << 10) + WXMediaMessage.THUMB_LENGTH_LIMIT + (i3 - 56320);
            if (i4 <= 1114111) {
                return i4;
            }
            o(i4);
            throw null;
        }
        p("Incomplete surrogate pair" + str + ": first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i3));
        throw null;
    }

    protected abstract r L(String str) throws XMLStreamException;

    protected abstract r M(String str, String str2) throws XMLStreamException;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
    
        r4.f1616j = r9;
        r9 = r6 + 1;
        r6 = r5[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
    
        if (r6 >= 2048) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        r0 = r0[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r0 == 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if (r0 == 5) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        Y(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        S(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        r6 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        o(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r6 = T(r6, r5, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if ((r7 - r6) < (r4.f1617k - r4.f1616j)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        r9 = r4.f1616j;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final int N(char[] cArr, int i2, int i3, byte[] bArr, int i4) throws IOException, XMLStreamException {
        int i5 = i3 + i2;
        while (i2 < i5) {
            int[] iArr = this.f1619m.b;
            while (true) {
                char c = cArr[i2];
                if (c >= 2048 || iArr[c] != 0) {
                    break;
                }
                int i6 = i4 + 1;
                bArr[i4] = (byte) c;
                i2++;
                if (i2 >= i5) {
                    return i6;
                }
                i4 = i6;
            }
        }
        return i4;
    }

    protected final void O() throws IOException {
        OutputStream outputStream;
        int i2 = this.f1616j;
        if (i2 <= 0 || (outputStream = this.f1614h) == null) {
            return;
        }
        this.e += i2;
        this.g -= i2;
        this.f1616j = 0;
        outputStream.write(this.f1615i, 0, i2);
    }

    protected abstract void S(int i2) throws IOException, XMLStreamException;

    protected abstract int T(int i2, char[] cArr, int i3, int i4) throws IOException, XMLStreamException;

    protected abstract void U(int i2, int i3) throws IOException, XMLStreamException;

    protected final void V() throws IOException {
        int i2 = this.f1618l;
        this.f1618l = 0;
        W(i2);
        throw null;
    }

    protected final void W(int i2) throws IOException {
        g();
        throw new IOException("Unpaired surrogate character (0x" + Integer.toHexString(i2) + ")");
    }

    protected void X(String str) throws XMLStreamException {
        if (str == null || str.length() == 0) {
            r(i.e.a.i.b.E);
            throw null;
        }
        int iCharAt = str.charAt(0);
        int length = str.length();
        int i2 = 2;
        if (iCharAt < 55296 || iCharAt > 57343) {
            i2 = 1;
        } else {
            if (iCharAt >= 56320) {
                r("Illegal surrogate pairing in name: first character (" + i.e.a.l.p.c(iCharAt) + ") not valid surrogate first character");
                throw null;
            }
            if (length < 2) {
                r("Illegal surrogate pairing in name: incomplete surrogate (missing second half)");
                throw null;
            }
            iCharAt = K(iCharAt, str.charAt(1), " in name");
        }
        if (!i.e.a.l.p.e(iCharAt)) {
            r("Invalid name start character " + i.e.a.l.p.c(iCharAt) + " (name \"" + str + "\")");
            throw null;
        }
        int iJ = j();
        if (iCharAt > iJ) {
            r("Illegal name start character " + i.e.a.l.p.c(iCharAt) + " (name \"" + str + "\"): can not be expressed using effective encoding (" + this.a.u() + ")");
            throw null;
        }
        while (i2 < length) {
            int iCharAt2 = str.charAt(i2);
            if (iCharAt2 >= 55296 && iCharAt2 <= 57343) {
                if (iCharAt2 >= 56320) {
                    r("Illegal surrogate pairing in name: character at #" + i2 + " (" + i.e.a.l.p.c(iCharAt2) + ") not valid surrogate first character");
                    throw null;
                }
                i2++;
                if (i2 >= length) {
                    r("Illegal surrogate pairing in name: name ends with incomplete surrogate pair");
                    throw null;
                }
                iCharAt2 = K(iCharAt2, str.charAt(i2), " in name");
            }
            if (iCharAt2 > iJ) {
                r("Illegal name character " + i.e.a.l.p.c(iCharAt2) + " (name \"" + str + "\", index #" + i2 + "): can not be expressed using effective encoding (" + this.a.u() + ")");
                throw null;
            }
            if (!i.e.a.l.p.d(iCharAt2)) {
                r("Invalid name character " + i.e.a.l.p.c(iCharAt2) + ") in name (\"" + str + "\"), index #" + i2);
                throw null;
            }
            i2++;
        }
    }

    protected final void Y(int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr = this.f1615i;
        int i5 = this.f1616j;
        if (i5 + 10 >= bArr.length) {
            O();
            i5 = this.f1616j;
        }
        int i6 = i5 + 1;
        bArr[i5] = 38;
        if (i2 >= 256) {
            int i7 = i6 + 1;
            bArr[i6] = 35;
            int i8 = i7 + 1;
            bArr[i7] = 120;
            int i9 = 20;
            int i10 = i8;
            do {
                int i11 = (i2 >> i9) & 15;
                if (i11 > 0 || i10 != i8) {
                    int i12 = i10 + 1;
                    bArr[i10] = (byte) (i11 < 10 ? i11 + 48 : i11 + 87);
                    i10 = i12;
                }
                i9 -= 4;
            } while (i9 > 0);
            int i13 = i2 & 15;
            i3 = i10 + 1;
            bArr[i10] = (byte) (i13 < 10 ? i13 + 48 : i13 + 87);
        } else {
            if (i2 == 38) {
                int i14 = i6 + 1;
                bArr[i6] = 97;
                int i15 = i14 + 1;
                bArr[i14] = 109;
                i4 = i15 + 1;
                bArr[i15] = 112;
                bArr[i4] = 59;
                this.f1616j = i4 + 1;
            }
            if (i2 == 60) {
                int i16 = i6 + 1;
                bArr[i6] = 108;
                i3 = i16 + 1;
                bArr[i16] = 116;
            } else if (i2 == 62) {
                int i17 = i6 + 1;
                bArr[i6] = 103;
                i3 = i17 + 1;
                bArr[i17] = 116;
            } else if (i2 == 39) {
                int i18 = i6 + 1;
                bArr[i6] = 97;
                int i19 = i18 + 1;
                bArr[i18] = 112;
                int i20 = i19 + 1;
                bArr[i19] = 111;
                i3 = i20 + 1;
                bArr[i20] = 115;
            } else if (i2 == 34) {
                int i21 = i6 + 1;
                bArr[i6] = 113;
                int i22 = i21 + 1;
                bArr[i21] = 117;
                int i23 = i22 + 1;
                bArr[i22] = 111;
                i3 = i23 + 1;
                bArr[i23] = 116;
            } else {
                int i24 = i6 + 1;
                bArr[i6] = 35;
                int i25 = i24 + 1;
                bArr[i24] = 120;
                if (i2 >= 16) {
                    int i26 = i2 >> 4;
                    int i27 = i25 + 1;
                    bArr[i25] = (byte) (i26 < 10 ? i26 + 48 : i26 + 87);
                    i2 &= 15;
                    i25 = i27;
                }
                i3 = i25 + 1;
                bArr[i25] = (byte) (i2 < 10 ? i2 + 48 : i2 + 87);
            }
        }
        i4 = i3;
        bArr[i4] = 59;
        this.f1616j = i4 + 1;
    }

    protected final void Z(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            this.f1618l = 0;
            i2++;
            i3--;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int[] iArr = this.f1619m.b;
            do {
                char c = cArr[i2];
                if (c < 2048 && iArr[c] == 0) {
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i6 = this.f1616j;
                    this.f1616j = i6 + 1;
                    bArr[i6] = (byte) c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < 2048) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 != 5) {
                            Y(c2);
                        } else {
                            S(c2);
                        }
                        i2 = i7;
                    } else {
                        i2 = T(c2, cArr, i7, i5);
                    }
                }
            } while (i2 < i5);
            return;
        }
    }

    @Override // i.e.a.k.s
    public final r a(String str) throws XMLStreamException {
        X(str);
        return L(str);
    }

    public final void a0(r rVar, char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int iA;
        int i4;
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        int i5 = this.f1616j;
        byte[] bArr = this.f1615i;
        if (rVar.h() + i5 >= this.f1617k) {
            i0((byte) 32, rVar);
            iA = this.f1616j;
        } else {
            int i6 = i5 + 1;
            bArr[i5] = 32;
            iA = rVar.a(bArr, i6) + i6;
        }
        if (iA + 3 + i3 > this.f1617k) {
            this.f1616j = iA;
            O();
            int i7 = this.f1616j;
            int i8 = i7 + 1;
            this.f1616j = i8;
            bArr[i7] = 61;
            i4 = i8 + 1;
            this.f1616j = i4;
            bArr[i8] = 34;
            if (i4 + i3 + 1 > this.f1617k) {
                Z(cArr, i2, i3);
                l0((byte) 34);
                return;
            }
        } else {
            int i9 = iA + 1;
            bArr[iA] = 61;
            i4 = i9 + 1;
            bArr[i9] = 34;
        }
        int iN = i4;
        if (i3 > 0) {
            iN = N(cArr, i2, i3, bArr, iN);
        }
        bArr[iN] = 34;
        this.f1616j = iN + 1;
    }

    @Override // i.e.a.k.s
    public r b(String str, String str2) throws XMLStreamException {
        X(str);
        X(str2);
        return M(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int b0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            this.f1618l = 0;
            i2++;
            i3--;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int[] iArr = this.f1619m.e;
            do {
                char c = cArr[i2];
                if (c < 2048 && iArr[c] == 0) {
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i6 = this.f1616j;
                    this.f1616j = i6 + 1;
                    bArr[i6] = (byte) c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < 2048) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 == 2 || i8 == 3) {
                            this.f++;
                            if (this.f1616j >= this.f1617k) {
                                O();
                            }
                            byte[] bArr2 = this.f1615i;
                            int i9 = this.f1616j;
                            this.f1616j = i9 + 1;
                            bArr2[i9] = (byte) c2;
                            i2 = i7;
                        } else {
                            if (i8 == 4) {
                                n("CDATA", c2);
                                throw null;
                            }
                            if (i8 == 5) {
                                S(c2);
                            } else if (i8 == 11 && i7 < i5 && cArr[i7] == ']') {
                                int i10 = i7 + 1;
                                if (i10 < i5 && cArr[i10] == '>') {
                                    i2 = i7 + 2;
                                    m0((byte) 93, (byte) 93);
                                    c0();
                                    d0();
                                    l0((byte) 62);
                                }
                            } else {
                                if (this.f1616j >= this.f1617k) {
                                }
                                byte[] bArr22 = this.f1615i;
                                int i92 = this.f1616j;
                                this.f1616j = i92 + 1;
                                bArr22[i92] = (byte) c2;
                            }
                            i2 = i7;
                        }
                    } else {
                        i2 = T(c2, cArr, i7, i5);
                    }
                }
            } while (i2 < i5);
            return -1;
        }
        return -1;
    }

    @Override // i.e.a.k.x
    public void c(boolean z) throws IOException {
        OutputStream outputStream = this.f1614h;
        if (outputStream == null || !z) {
            return;
        }
        outputStream.close();
        this.f1614h = null;
    }

    protected final void c0() throws IOException {
        n0(f1613o);
    }

    @Override // i.e.a.k.x
    public void d() {
        super.d();
        byte[] bArr = this.f1615i;
        if (bArr != null) {
            this.a.r(bArr);
            this.f1615i = null;
        }
        char[] cArr = this.b;
        if (cArr != null) {
            this.a.s(cArr);
            this.b = null;
        }
    }

    protected final void d0() throws IOException {
        n0(f1612n);
    }

    protected int e0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            this.f1618l = 0;
            i2++;
            i3--;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int[] iArr = this.f1619m.e;
            do {
                char c = cArr[i2];
                if (c < 2048 && iArr[c] == 0) {
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i6 = this.f1616j;
                    this.f1616j = i6 + 1;
                    bArr[i6] = (byte) c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < 2048) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 == 2 || i8 == 3) {
                            this.f++;
                        } else {
                            if (i8 == 4) {
                                n("comment", c2);
                                throw null;
                            }
                            if (i8 == 5) {
                                S(c2);
                            } else if (i8 == 13 && (i7 >= i5 || cArr[i7] == '-')) {
                                m0((byte) 45, (byte) 32);
                            }
                            i2 = i7;
                        }
                        if (this.f1616j >= this.f1617k) {
                            O();
                        }
                        byte[] bArr2 = this.f1615i;
                        int i9 = this.f1616j;
                        this.f1616j = i9 + 1;
                        bArr2[i9] = (byte) c2;
                        i2 = i7;
                    } else {
                        i2 = T(c2, cArr, i7, i5);
                    }
                }
            } while (i2 < i5);
            return -1;
        }
        return -1;
    }

    protected final void f0() throws IOException {
        n0(q);
    }

    @Override // i.e.a.k.x
    public final void g() throws IOException {
        if (this.f1614h != null) {
            O();
            this.f1614h.flush();
        }
    }

    protected final void g0() throws IOException {
        n0(p);
    }

    protected final void h0(r rVar, String str, int i2) throws IOException, XMLStreamException {
        l0((byte) 32);
        int iH = rVar.h();
        int i3 = this.f1616j;
        if (i3 + iH > this.f1617k) {
            O();
            if (iH > this.f1617k) {
                rVar.i(this.f1614h);
            } else {
                int i4 = this.f1616j;
                this.f1616j = i4 + rVar.a(this.f1615i, i4);
            }
        } else {
            this.f1616j = i3 + rVar.a(this.f1615i, i3);
        }
        m0((byte) 61, (byte) 34);
        int i5 = 0;
        while (i2 > 0) {
            char[] cArr = this.b;
            int length = cArr.length;
            if (i2 < length) {
                length = i2;
            }
            int i6 = i5 + length;
            str.getChars(i5, i6, cArr, 0);
            Z(cArr, 0, length);
            i2 -= length;
            i5 = i6;
        }
        l0((byte) 34);
    }

    protected final void i0(byte b, r rVar) throws IOException {
        O();
        if (rVar.h() >= this.f1617k) {
            this.f1614h.write(b);
            rVar.i(this.f1614h);
            return;
        }
        int i2 = this.f1616j;
        byte[] bArr = this.f1615i;
        int i3 = i2 + 1;
        bArr[i2] = b;
        this.f1616j = i3 + rVar.a(bArr, i3);
    }

    protected final void j0(r rVar) throws IOException {
        int i2 = this.f1616j;
        int iH = rVar.h();
        if (i2 + iH > this.f1617k) {
            O();
            if (iH >= this.f1617k) {
                rVar.i(this.f1614h);
                return;
            }
            i2 = this.f1616j;
        }
        this.f1616j = i2 + rVar.a(this.f1615i, i2);
    }

    @Override // i.e.a.k.x
    protected final int k() {
        return this.f1616j;
    }

    protected int k0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            this.f1618l = 0;
            i2++;
            i3--;
        }
        int i5 = i3 + i2;
        while (i2 < i5) {
            int[] iArr = this.f1619m.e;
            do {
                char c = cArr[i2];
                if (c < 2048 && iArr[c] == 0) {
                    if (this.f1616j >= this.f1617k) {
                        O();
                    }
                    byte[] bArr = this.f1615i;
                    int i6 = this.f1616j;
                    this.f1616j = i6 + 1;
                    bArr[i6] = (byte) c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < 2048) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 == 2 || i8 == 3) {
                            this.f++;
                        } else {
                            if (i8 == 4) {
                                n("processing instruction", c2);
                                throw null;
                            }
                            if (i8 == 5) {
                                S(c2);
                                i2 = i7;
                            } else if (i8 == 12 && i7 < i5 && cArr[i7] == '>') {
                                return i7;
                            }
                        }
                        if (this.f1616j >= this.f1617k) {
                            O();
                        }
                        byte[] bArr2 = this.f1615i;
                        int i9 = this.f1616j;
                        this.f1616j = i9 + 1;
                        bArr2[i9] = (byte) c2;
                        i2 = i7;
                    } else {
                        i2 = T(c2, cArr, i7, i5);
                    }
                }
            } while (i2 < i5);
            return -1;
        }
        return -1;
    }

    protected final void l0(byte b) throws IOException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        if (this.f1616j >= this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i2 = this.f1616j;
        this.f1616j = i2 + 1;
        bArr[i2] = b;
    }

    protected final void m0(byte b, byte b2) throws IOException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        if (this.f1616j + 1 >= this.f1617k) {
            O();
        }
        byte[] bArr = this.f1615i;
        int i2 = this.f1616j;
        int i3 = i2 + 1;
        this.f1616j = i3;
        bArr[i2] = b;
        this.f1616j = i3 + 1;
        bArr[i3] = b2;
    }

    protected final void n0(byte[] bArr) throws IOException {
        o0(bArr, 0, bArr.length);
    }

    protected final void o0(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f1618l != 0) {
            V();
            throw null;
        }
        int i4 = this.f1616j;
        if (i4 + i3 <= this.f1617k) {
            System.arraycopy(bArr, i2, this.f1615i, i4, i3);
            this.f1616j += i3;
            return;
        }
        if (i4 > 0) {
            g();
            i4 = this.f1616j;
        }
        if (i3 >= 250) {
            this.f1614h.write(bArr, i2, i3);
        } else {
            System.arraycopy(bArr, i2, this.f1615i, i4, i3);
            this.f1616j += i3;
        }
    }

    public abstract void p0(char[] cArr, int i2, int i3) throws IOException, XMLStreamException;

    @Override // i.e.a.k.x
    public final void t(r rVar, String str) throws IOException, XMLStreamException {
        int length = str.length();
        if (length > this.c) {
            h0(rVar, str, length);
            return;
        }
        char[] cArr = this.b;
        if (length > 0) {
            str.getChars(0, length, cArr, 0);
        }
        a0(rVar, cArr, 0, length);
    }

    @Override // i.e.a.k.x
    public int u(String str) throws IOException, XMLStreamException {
        d0();
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            char[] cArr = this.b;
            int length2 = cArr.length;
            if (length2 > length) {
                length2 = length;
            }
            int i3 = i2 + length2;
            str.getChars(i2, i3, cArr, 0);
            int iB0 = b0(cArr, 0, length2);
            if (iB0 >= 0) {
                return i2 + iB0;
            }
            length -= length2;
            i2 = i3;
        }
        c0();
        return -1;
    }

    @Override // i.e.a.k.x
    public final void v(String str) throws IOException, XMLStreamException {
        int length = str.length();
        if (length > this.c) {
            R(str);
        } else if (length > 0) {
            char[] cArr = this.b;
            str.getChars(0, length, cArr, 0);
            w(cArr, 0, length);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
    
        r2 = r7 + 1;
        r7 = r6[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r7 >= 2048) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        switch(r1[r7]) {
            case 1: goto L57;
            case 2: goto L30;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L61;
            case 7: goto L61;
            case 8: goto L61;
            case 9: goto L55;
            case 10: goto L55;
            case 11: goto L24;
            default: goto L61;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r2 >= r8) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        if (r6[r2] != '>') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        r5.f1616j = r0;
        Y(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        r5.f1616j = r0;
        S(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
    
        r5.f1616j = r0;
        Y(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
    
        if (r5.a.J() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        r5.f1616j = r0;
        Y(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        r7 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        r3 = r0 + 1;
        r5.f1615i[r0] = (byte) r7;
        r5.f++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        o(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007a, code lost:
    
        r3 = r0 + 1;
        r5.f1615i[r0] = (byte) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        r7 = r2;
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
    
        r5.f1616j = r0;
        r7 = T(r7, r6, r2, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if ((r8 - r7) < (r5.f1617k - r5.f1616j)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r0 = r5.f1616j;
     */
    @Override // i.e.a.k.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = this.f1618l;
        if (i4 != 0) {
            U(i4, cArr[i2]);
            this.f1618l = 0;
            i2++;
            i3--;
        }
        int i5 = this.f1616j;
        if (i5 + i3 > this.f1617k) {
            q0(cArr, i2, i3);
            return;
        }
        int i6 = i3 + i2;
        while (true) {
            if (i2 < i6) {
                int[] iArr = this.f1619m.a;
                while (true) {
                    char c = cArr[i2];
                    if (c < 2048) {
                        if (iArr[c] != 0) {
                            if (c == '\n') {
                                this.f++;
                            }
                        }
                        int i7 = i5 + 1;
                        this.f1615i[i5] = (byte) c;
                        i2++;
                        if (i2 >= i6) {
                            i5 = i7;
                        } else {
                            i5 = i7;
                        }
                    }
                }
            }
        }
        this.f1616j = i5;
    }

    @Override // i.e.a.k.x
    public int x(String str) throws IOException, XMLStreamException {
        g0();
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            char[] cArr = this.b;
            int length2 = cArr.length;
            int i3 = length < length2 ? length : length2;
            str.getChars(i2, i2 + i3, cArr, 0);
            int iE0 = e0(cArr, 0, i3);
            if (iE0 >= 0) {
                return i2 + iE0;
            }
            i2 += length2;
            length -= length2;
        }
        f0();
        return -1;
    }

    @Override // i.e.a.k.x
    public void y(r rVar, String str, String str2, String str3) throws IOException, XMLStreamException {
    }

    @Override // i.e.a.k.x
    public void z(String str) throws IOException, XMLStreamException {
        D(str, 0, str.length());
    }
}
