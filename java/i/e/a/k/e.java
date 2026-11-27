package i.e.a.k;

import androidx.recyclerview.widget.k0;
import com.auto.exceldeps.log4j.util.Chars;
import java.io.IOException;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public final class e extends x {

    /* renamed from: h, reason: collision with root package name */
    protected final int f1620h;

    /* renamed from: i, reason: collision with root package name */
    protected Writer f1621i;

    /* renamed from: j, reason: collision with root package name */
    protected char[] f1622j;

    /* renamed from: k, reason: collision with root package name */
    protected int f1623k;

    /* renamed from: l, reason: collision with root package name */
    protected final int f1624l;

    /* renamed from: m, reason: collision with root package name */
    private final int f1625m;

    /* renamed from: n, reason: collision with root package name */
    private final int f1626n;

    /* renamed from: o, reason: collision with root package name */
    final i.e.a.l.o f1627o;

    public e(w wVar, Writer writer) {
        super(wVar);
        this.f1621i = writer;
        char[] cArrI = wVar.i(XmlValidationError.INCORRECT_ATTRIBUTE);
        this.f1622j = cArrI;
        this.f1624l = cArrI.length;
        this.f1620h = k0.a.DEFAULT_DRAG_ANIMATION_DURATION;
        this.f1623k = 0;
        int iM = x.m(wVar);
        int i2 = iM < 16 ? 1 << iM : 65534;
        this.f1625m = i2;
        this.f1626n = Math.min(256, i2);
        this.f1627o = iM < 8 ? i.g() : i.h();
    }

    private final void K(char c) throws IOException {
        if (this.f1623k >= this.f1624l) {
            if (this.f1621i == null) {
                return;
            } else {
                N();
            }
        }
        char[] cArr = this.f1622j;
        int i2 = this.f1623k;
        this.f1623k = i2 + 1;
        cArr[i2] = c;
    }

    private final void L(char c, char c2) throws IOException {
        if (this.f1623k + 1 >= this.f1624l) {
            if (this.f1621i == null) {
                return;
            } else {
                N();
            }
        }
        char[] cArr = this.f1622j;
        int i2 = this.f1623k;
        int i3 = i2 + 1;
        this.f1623k = i3;
        cArr[i2] = c;
        this.f1623k = i3 + 1;
        cArr[i3] = c2;
    }

    private final void M(String str) throws IOException {
        int length = str.length();
        int i2 = this.f1623k;
        int i3 = i2 + length;
        int i4 = this.f1624l;
        if (i3 >= i4) {
            if (this.f1621i == null) {
                return;
            }
            if (length > i4) {
                D(str, 0, str.length());
                return;
            } else {
                N();
                i2 = this.f1623k;
            }
        }
        str.getChars(0, length, this.f1622j, i2);
        this.f1623k = i2 + length;
    }

    private final void N() throws IOException {
        Writer writer;
        int i2 = this.f1623k;
        if (i2 <= 0 || (writer = this.f1621i) == null) {
            return;
        }
        this.e += i2;
        this.g -= i2;
        this.f1623k = 0;
        writer.write(this.f1622j, 0, i2);
    }

    private final void P(String str, int i2) throws IOException, XMLStreamException {
        int i3 = 0;
        while (i2 > 0) {
            char[] cArr = this.b;
            int length = cArr.length;
            if (i2 < length) {
                length = i2;
            }
            int i4 = i3 + length;
            str.getChars(i3, i4, cArr, 0);
            Q(cArr, 0, length);
            i2 -= length;
            i3 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Q(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return;
        }
        if (this.f1623k + i3 > this.f1624l) {
            Z(cArr, i2, i3);
            return;
        }
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1627o.b;
            int i5 = this.f1626n;
            do {
                char c = cArr[i2];
                if (c < i5 && iArr[c] == 0) {
                    char[] cArr2 = this.f1622j;
                    int i6 = this.f1623k;
                    this.f1623k = i6 + 1;
                    cArr2[i6] = c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < i5) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 == 2 || i8 == 3 || i8 == 4 || i8 == 9 || i8 == 10 || i8 == 14) {
                            O(c2);
                            if (i4 - i7 >= this.f1624l - this.f1623k) {
                                N();
                            }
                        } else {
                            char[] cArr3 = this.f1622j;
                            int i9 = this.f1623k;
                            this.f1623k = i9 + 1;
                            cArr3[i9] = c2;
                        }
                    } else if (c2 < this.f1625m) {
                        char[] cArr4 = this.f1622j;
                        int i10 = this.f1623k;
                        this.f1623k = i10 + 1;
                        cArr4[i10] = c2;
                    }
                    i2 = i7;
                }
            } while (i2 < i4);
            return;
        }
    }

    private int R(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = i3 + i2;
        int i5 = i2;
        while (i5 < i4) {
            int[] iArr = this.f1627o.e;
            int i6 = this.f1626n;
            do {
                char c = cArr[i5];
                if (c < i6 && iArr[c] == 0) {
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr2 = this.f1622j;
                    int i7 = this.f1623k;
                    this.f1623k = i7 + 1;
                    cArr2[i7] = c;
                    i5++;
                } else {
                    int i8 = i5 + 1;
                    char c2 = cArr[i5];
                    if (c2 < i6) {
                        int i9 = iArr[c2];
                        if (i9 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i9 != 2 && i9 != 3) {
                            if (i9 == 4) {
                                n("CDATA block", c2);
                                throw null;
                            }
                            if (i9 == 17 && i8 - i2 >= 3 && cArr[i8 - 2] == ']' && cArr[i8 - 3] == ']') {
                                i8--;
                                S();
                                T();
                            }
                        }
                    } else if (c2 >= this.f1625m) {
                        n("CDATA block", c2);
                        throw null;
                    }
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr3 = this.f1622j;
                    int i10 = this.f1623k;
                    this.f1623k = i10 + 1;
                    cArr3[i10] = c2;
                    i5 = i8;
                }
            } while (i5 < i4);
            return -1;
        }
        return -1;
    }

    private int U(char[] cArr, int i2, int i3, boolean z) throws IOException, XMLStreamException {
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1627o.e;
            int i5 = this.f1626n;
            do {
                char c = cArr[i2];
                if (c < i5 && iArr[c] == 0) {
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr2 = this.f1622j;
                    int i6 = this.f1623k;
                    this.f1623k = i6 + 1;
                    cArr2[i6] = c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < i5) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 != 2 && i8 != 3) {
                            if (i8 == 4) {
                                n("comment", c2);
                                throw null;
                            }
                            if (i8 == 13 && (i7 == i4 || cArr[i7] == '-')) {
                                if (!this.a.K()) {
                                    return i7 - 1;
                                }
                                if (this.f1623k >= this.f1624l) {
                                    N();
                                }
                                char[] cArr3 = this.f1622j;
                                int i9 = this.f1623k;
                                this.f1623k = i9 + 1;
                                cArr3[i9] = Chars.SPACE;
                            }
                        }
                    } else if (c2 >= this.f1625m) {
                        n("comment", c2);
                        throw null;
                    }
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr4 = this.f1622j;
                    int i10 = this.f1623k;
                    this.f1623k = i10 + 1;
                    cArr4[i10] = c2;
                    i2 = i7;
                }
            } while (i2 < i4);
            return -1;
        }
        return -1;
    }

    private int Y(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1627o.e;
            int i5 = this.f1626n;
            do {
                char c = cArr[i2];
                if (c < i5 && iArr[c] == 0) {
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr2 = this.f1622j;
                    int i6 = this.f1623k;
                    this.f1623k = i6 + 1;
                    cArr2[i6] = c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < i5) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 != 2 && i8 != 3) {
                            if (i8 == 4) {
                                n("processing instruction", c2);
                                throw null;
                            }
                            if (i8 == 12 && i7 < i4 && cArr[i7] == '>') {
                                return i7;
                            }
                        }
                    } else if (c2 >= this.f1625m) {
                        n("processing instruction", c2);
                        throw null;
                    }
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr3 = this.f1622j;
                    int i9 = this.f1623k;
                    this.f1623k = i9 + 1;
                    cArr3[i9] = c2;
                    i2 = i7;
                }
            } while (i2 < i4);
            return -1;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Z(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1627o.b;
            int i5 = this.f1626n;
            do {
                char c = cArr[i2];
                if (c < i5 && iArr[c] == 0) {
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr2 = this.f1622j;
                    int i6 = this.f1623k;
                    this.f1623k = i6 + 1;
                    cArr2[i6] = c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < i5) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 == 2 || i8 == 3) {
                            O(c2);
                        } else if (i8 == 4 || i8 == 9 || i8 == 10 || i8 == 14) {
                            O(c2);
                        } else {
                            if (this.f1623k >= this.f1624l) {
                                N();
                            }
                            char[] cArr3 = this.f1622j;
                            int i9 = this.f1623k;
                            this.f1623k = i9 + 1;
                            cArr3[i9] = c2;
                        }
                    } else if (c2 >= this.f1625m) {
                        O(c2);
                    }
                    i2 = i7;
                }
            } while (i2 < i4);
            return;
        }
    }

    @Override // i.e.a.k.x
    public void A(r rVar) throws IOException, XMLStreamException {
        int i2 = this.f1623k;
        int iH = rVar.h();
        if (i2 + iH + 3 > this.f1624l) {
            N();
            if (iH + 3 > this.f1624l) {
                this.f1621i.write(60);
                this.f1621i.write(47);
                rVar.j(this.f1621i);
                char[] cArr = this.f1622j;
                int i3 = this.f1623k;
                this.f1623k = i3 + 1;
                cArr[i3] = '>';
                return;
            }
            i2 = this.f1623k;
        }
        char[] cArr2 = this.f1622j;
        int i4 = i2 + 1;
        cArr2[i2] = '<';
        int i5 = i4 + 1;
        cArr2[i4] = '/';
        rVar.b(cArr2, i5);
        int i6 = i5 + iH;
        cArr2[i6] = '>';
        this.f1623k = i6 + 1;
    }

    @Override // i.e.a.k.x
    public void B(r rVar) throws IOException, XMLStreamException {
        K('&');
        X(rVar);
        K(';');
    }

    @Override // i.e.a.k.x
    public int C(r rVar, String str) throws IOException, XMLStreamException {
        L('<', '?');
        X(rVar);
        if (str != null && str.length() > 0) {
            int length = str.length();
            K(Chars.SPACE);
            int iY = -1;
            int i2 = 0;
            while (length > 0) {
                char[] cArr = this.b;
                int length2 = cArr.length;
                if (length2 > length) {
                    length2 = length;
                }
                int i3 = i2 + length2;
                str.getChars(i2, i3, cArr, 0);
                iY = Y(cArr, 0, length2);
                if (iY >= 0) {
                    break;
                }
                length -= length2;
                i2 = i3;
            }
            if (iY >= 0) {
                return i2 + iY;
            }
        }
        L('?', '>');
        return -1;
    }

    @Override // i.e.a.k.x
    public void D(String str, int i2, int i3) throws IOException {
        if (this.f1621i == null) {
            return;
        }
        int i4 = this.f1620h;
        if (i3 < i4) {
            if (this.f1623k + i3 >= this.f1624l) {
                N();
            }
            str.getChars(i2, i2 + i3, this.f1622j, this.f1623k);
            this.f1623k += i3;
            return;
        }
        int i5 = this.f1623k;
        if (i5 > 0) {
            if (i5 < i4) {
                int i6 = i4 - i5;
                int i7 = i2 + i6;
                str.getChars(i2, i7, this.f1622j, i5);
                this.f1623k = i5 + i6;
                i3 -= i6;
                i2 = i7;
            }
            N();
        }
        this.f1621i.write(str, i2, i3);
    }

    @Override // i.e.a.k.x
    public void E(String str) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return;
        }
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
        if (this.f1621i == null) {
            return;
        }
        int i4 = i3 + i2;
        while (i2 < i4) {
            int i5 = i2 + 1;
            char c = cArr[i2];
            if (c > ' ' && (!this.a.C() || (c != 133 && c != 8232))) {
                q(i.e.a.i.b.B, Integer.valueOf(c), Integer.valueOf(i5 - 1));
                throw null;
            }
            if (this.f1623k >= this.f1624l) {
                N();
            }
            char[] cArr2 = this.f1622j;
            int i6 = this.f1623k;
            this.f1623k = i6 + 1;
            cArr2[i6] = c;
            i2 = i5;
        }
    }

    @Override // i.e.a.k.x
    public void G() throws IOException {
        int i2 = this.f1623k;
        if (i2 + 2 > this.f1624l) {
            if (this.f1621i == null) {
                return;
            }
            N();
            i2 = this.f1623k;
        }
        char[] cArr = this.f1622j;
        int i3 = i2 + 1;
        cArr[i2] = '/';
        cArr[i3] = '>';
        this.f1623k = i3 + 1;
    }

    @Override // i.e.a.k.x
    public void H() throws IOException, XMLStreamException {
        K('>');
    }

    @Override // i.e.a.k.x
    public void I(r rVar) throws IOException, XMLStreamException {
        int i2 = this.f1623k;
        int iH = rVar.h();
        if (i2 + iH + 1 > this.f1624l) {
            if (this.f1621i == null) {
                return;
            }
            N();
            if (iH >= this.f1624l) {
                this.f1621i.write(60);
                rVar.j(this.f1621i);
                return;
            }
            i2 = this.f1623k;
        }
        char[] cArr = this.f1622j;
        int i3 = i2 + 1;
        cArr[i2] = '<';
        rVar.b(cArr, i3);
        this.f1623k = i3 + iH;
    }

    @Override // i.e.a.k.x
    public void J(String str, String str2, String str3) throws IOException, XMLStreamException {
        M("<?xml version='");
        M(str);
        K(Chars.QUOTE);
        if (str2 != null && str2.length() > 0) {
            M(" encoding='");
            M(str2);
            K(Chars.QUOTE);
        }
        if (str3 != null) {
            M(" standalone='");
            M(str3);
            K(Chars.QUOTE);
        }
        L('?', '>');
    }

    protected final void O(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f1622j;
        int i5 = this.f1623k;
        if (i5 + 10 >= cArr.length) {
            N();
            i5 = this.f1623k;
        }
        int i6 = i5 + 1;
        cArr[i5] = '&';
        if (i2 >= 256) {
            int i7 = i6 + 1;
            cArr[i6] = '#';
            int i8 = i7 + 1;
            cArr[i7] = 'x';
            int i9 = 20;
            int i10 = i8;
            do {
                int i11 = (i2 >> i9) & 15;
                if (i11 > 0 || i10 != i8) {
                    int i12 = i10 + 1;
                    cArr[i10] = (char) (i11 < 10 ? i11 + 48 : i11 + 87);
                    i10 = i12;
                }
                i9 -= 4;
            } while (i9 > 0);
            int i13 = i2 & 15;
            i3 = i10 + 1;
            cArr[i10] = (char) (i13 < 10 ? i13 + 48 : i13 + 87);
        } else {
            if (i2 == 38) {
                int i14 = i6 + 1;
                cArr[i6] = 'a';
                int i15 = i14 + 1;
                cArr[i14] = 'm';
                i4 = i15 + 1;
                cArr[i15] = 'p';
                cArr[i4] = ';';
                this.f1623k = i4 + 1;
            }
            if (i2 == 60) {
                int i16 = i6 + 1;
                cArr[i6] = 'l';
                i3 = i16 + 1;
                cArr[i16] = 't';
            } else if (i2 == 62) {
                int i17 = i6 + 1;
                cArr[i6] = 'g';
                i3 = i17 + 1;
                cArr[i17] = 't';
            } else if (i2 == 39) {
                int i18 = i6 + 1;
                cArr[i6] = 'a';
                int i19 = i18 + 1;
                cArr[i18] = 'p';
                int i20 = i19 + 1;
                cArr[i19] = 'o';
                i3 = i20 + 1;
                cArr[i20] = 's';
            } else if (i2 == 34) {
                int i21 = i6 + 1;
                cArr[i6] = 'q';
                int i22 = i21 + 1;
                cArr[i21] = 'u';
                int i23 = i22 + 1;
                cArr[i22] = 'o';
                i3 = i23 + 1;
                cArr[i23] = 't';
            } else {
                int i24 = i6 + 1;
                cArr[i6] = '#';
                int i25 = i24 + 1;
                cArr[i24] = 'x';
                if (i2 >= 16) {
                    int i26 = i2 >> 4;
                    int i27 = i25 + 1;
                    cArr[i25] = (char) (i26 < 10 ? i26 + 48 : i26 + 87);
                    i2 &= 15;
                    i25 = i27;
                }
                i3 = i25 + 1;
                cArr[i25] = (char) (i2 < 10 ? i2 + 48 : i2 + 87);
            }
        }
        i4 = i3;
        cArr[i4] = ';';
        this.f1623k = i4 + 1;
    }

    public final void S() throws IOException {
        M("]]>");
    }

    public final void T() throws IOException {
        M("<![CDATA[");
    }

    public final void V() throws IOException {
        M("-->");
    }

    public final void W() throws IOException {
        M("<!--");
    }

    protected final void X(r rVar) throws IOException {
        int i2 = this.f1623k;
        int iH = rVar.h();
        if (i2 + iH > this.f1624l) {
            N();
            if (iH >= this.f1624l) {
                rVar.j(this.f1621i);
                return;
            }
            i2 = this.f1623k;
        }
        rVar.b(this.f1622j, i2);
        this.f1623k += iH;
    }

    @Override // i.e.a.k.s
    public r a(String str) {
        return new d(str);
    }

    @Override // i.e.a.k.s
    public r b(String str, String str2) {
        return new d(str, str2);
    }

    @Override // i.e.a.k.x
    public void c(boolean z) throws IOException {
        Writer writer = this.f1621i;
        if (writer == null || !z) {
            return;
        }
        writer.close();
        this.f1621i = null;
    }

    @Override // i.e.a.k.x
    public void d() {
        super.d();
        char[] cArr = this.f1622j;
        if (cArr != null) {
            this.a.s(cArr);
            this.f1622j = null;
        }
    }

    @Override // i.e.a.k.x
    public final void g() throws IOException {
        if (this.f1621i != null) {
            N();
            this.f1621i.flush();
        }
    }

    @Override // i.e.a.k.x
    protected int k() {
        return this.f1623k;
    }

    @Override // i.e.a.k.x
    public void t(r rVar, String str) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return;
        }
        K(Chars.SPACE);
        X(rVar);
        L(Chars.EQ, Chars.DQUOTE);
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            P(str, length);
        }
        K(Chars.DQUOTE);
    }

    @Override // i.e.a.k.x
    public int u(String str) throws IOException, XMLStreamException {
        T();
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
            int iR = R(cArr, 0, length2);
            if (iR >= 0) {
                return i2 + iR;
            }
            length -= length2;
            i2 = i3;
        }
        S();
        return -1;
    }

    @Override // i.e.a.k.x
    public void v(String str) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return;
        }
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
            w(cArr, 0, length2);
            length -= length2;
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0052  */
    @Override // i.e.a.k.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(char[] cArr, int i2, int i3) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return;
        }
        int i4 = i3 + i2;
        while (i2 < i4) {
            int[] iArr = this.f1627o.a;
            int i5 = this.f1626n;
            do {
                char c = cArr[i2];
                if (c < i5 && iArr[c] == 0) {
                    if (this.f1623k >= this.f1624l) {
                        N();
                    }
                    char[] cArr2 = this.f1622j;
                    int i6 = this.f1623k;
                    this.f1623k = i6 + 1;
                    cArr2[i6] = c;
                    i2++;
                } else {
                    int i7 = i2 + 1;
                    char c2 = cArr[i2];
                    if (c2 < i5) {
                        int i8 = iArr[c2];
                        if (i8 == 1) {
                            o(c2);
                            throw null;
                        }
                        if (i8 != 2) {
                            if (i8 != 4) {
                                switch (i8) {
                                    case 11:
                                        if (i7 < i4 && cArr[i7] != '>') {
                                            if (this.f1623k >= this.f1624l) {
                                                N();
                                            }
                                            char[] cArr3 = this.f1622j;
                                            int i9 = this.f1623k;
                                            this.f1623k = i9 + 1;
                                            cArr3[i9] = c2;
                                            break;
                                        }
                                        break;
                                }
                            }
                            O(c2);
                        } else if (this.a.J()) {
                            O(c2);
                        }
                    } else if (c2 >= this.f1625m) {
                        O(c2);
                    }
                    i2 = i7;
                }
            } while (i2 < i4);
            return;
        }
    }

    @Override // i.e.a.k.x
    public int x(String str) throws IOException, XMLStreamException {
        if (this.f1621i == null) {
            return -1;
        }
        W();
        int length = str.length();
        int iU = -1;
        int i2 = 0;
        while (length > 0) {
            char[] cArr = this.b;
            int length2 = cArr.length;
            if (length2 > length) {
                length2 = length;
            }
            int i3 = i2 + length2;
            str.getChars(i2, i3, cArr, 0);
            iU = U(cArr, 0, length2, false);
            if (iU >= 0) {
                break;
            }
            length -= length2;
            i2 = i3;
        }
        if (iU >= 0) {
            return i2 + iU;
        }
        V();
        return -1;
    }

    @Override // i.e.a.k.x
    public void y(r rVar, String str, String str2, String str3) throws IOException, XMLStreamException {
        M("<!DOCTYPE ");
        X(rVar);
        if (str != null) {
            if (str2 != null) {
                M(" PUBLIC \"");
                M(str2);
                M("\" \"");
            } else {
                M(" SYSTEM \"");
            }
            M(str);
            K(Chars.DQUOTE);
        }
        if (str3 != null && str3.length() > 0) {
            L(Chars.SPACE, '[');
            M(str3);
            K(']');
        }
        K('>');
    }

    @Override // i.e.a.k.x
    public void z(String str) throws IOException, XMLStreamException {
        D(str, 0, str.length());
    }
}
