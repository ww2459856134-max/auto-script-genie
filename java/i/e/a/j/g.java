package i.e.a.j;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class g extends n {

    /* renamed from: i, reason: collision with root package name */
    protected final InputStream f1586i;

    /* renamed from: j, reason: collision with root package name */
    protected final byte[] f1587j;

    /* renamed from: k, reason: collision with root package name */
    private int f1588k;

    /* renamed from: l, reason: collision with root package name */
    private int f1589l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f1590m;

    /* renamed from: n, reason: collision with root package name */
    protected int f1591n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f1592o;

    private g(z zVar, InputStream inputStream) {
        super(zVar);
        this.f1590m = true;
        this.f1591n = 0;
        this.f1592o = false;
        this.f1586i = inputStream;
        this.f1587j = zVar.h(4000);
        this.f1588k = 0;
        this.f1589l = 0;
    }

    private void C() throws IOException {
        throw new CharConversionException("Unsupported encoding (EBCDIC)");
    }

    private void D(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    private void I(String str, int i2) throws XMLStreamException {
        if (!this.f1592o || i2 == this.f1591n) {
            return;
        }
        r("Declared encoding '" + str + "' uses " + i2 + " bytes per character; but physical encoding appeared to use " + this.f1591n + "; cannot decode");
        throw null;
    }

    private void J(String str, int i2, boolean z) throws XMLStreamException {
        if (this.f1592o) {
            I(str, i2);
            if (z != this.f1590m) {
                r("Declared encoding '" + str + "' has different endianness (" + (z ? "big" : "little") + " endian) than what physical ordering appeared to be; cannot decode");
                throw null;
            }
        }
    }

    public static g u(z zVar, InputStream inputStream) throws XMLStreamException {
        return new g(zVar, inputStream);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void v() throws IOException {
        if (x(4)) {
            int i2 = this.f1588k;
            byte[] bArr = this.f1587j;
            int i3 = (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
            if (i3 == -16842752) {
                D("3412");
                throw null;
            }
            if (i3 == -131072) {
                this.f1590m = false;
                this.f1588k = i2 + 4;
                this.f1591n = 4;
            } else if (i3 == 65279) {
                this.f1590m = true;
                this.f1588k = i2 + 4;
                this.f1591n = 4;
            } else {
                if (i3 == 65534) {
                    D("2143");
                    throw null;
                }
                int i4 = i3 >>> 16;
                if (i4 == 65279) {
                    this.f1588k = i2 + 2;
                    this.f1591n = 2;
                    this.f1590m = true;
                } else if (i4 == 65534) {
                    this.f1588k = i2 + 2;
                    this.f1591n = 2;
                    this.f1590m = false;
                } else if ((i3 >>> 8) == 15711167) {
                    this.f1588k = i2 + 3;
                    this.f1591n = 1;
                    this.f1590m = true;
                } else {
                    switch (i3) {
                        case 60:
                            this.f1590m = true;
                            this.f1591n = 4;
                            break;
                        case 15360:
                            D("2143");
                            throw null;
                        case 3932160:
                            D("3412");
                            throw null;
                        case 3932223:
                            this.f1591n = 2;
                            this.f1590m = true;
                            break;
                        case 1006632960:
                            this.f1591n = 4;
                            this.f1590m = false;
                            break;
                        case 1006649088:
                            this.f1591n = 2;
                            this.f1590m = false;
                            break;
                        case 1010792557:
                            this.f1591n = 1;
                            this.f1590m = true;
                            break;
                        case 1282385812:
                            C();
                            throw null;
                    }
                }
            }
            this.c = this.f1588k;
        }
        boolean z = this.f1591n > 0;
        this.f1592o = z;
        if (z) {
            return;
        }
        this.f1591n = 1;
        this.f1590m = true;
    }

    protected byte A() throws IOException, XMLStreamException {
        if (this.f1588k >= this.f1589l) {
            z();
        }
        byte[] bArr = this.f1587j;
        int i2 = this.f1588k;
        this.f1588k = i2 + 1;
        return bArr[i2];
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int B() throws IOException, XMLStreamException {
        byte bA;
        byte bA2;
        byte bA3;
        byte bA4;
        int i2;
        int i3;
        int i4;
        int i5 = this.f1588k;
        if (i5 < this.f1589l) {
            byte[] bArr = this.f1587j;
            this.f1588k = i5 + 1;
            bA = bArr[i5];
        } else {
            bA = A();
        }
        int i6 = this.f1588k;
        if (i6 < this.f1589l) {
            byte[] bArr2 = this.f1587j;
            this.f1588k = i6 + 1;
            bA2 = bArr2[i6];
        } else {
            bA2 = A();
        }
        if (this.f1591n != 2) {
            int i7 = this.f1588k;
            if (i7 < this.f1589l) {
                byte[] bArr3 = this.f1587j;
                this.f1588k = i7 + 1;
                bA3 = bArr3[i7];
            } else {
                bA3 = A();
            }
            int i8 = this.f1588k;
            if (i8 < this.f1589l) {
                byte[] bArr4 = this.f1587j;
                this.f1588k = i8 + 1;
                bA4 = bArr4[i8];
            } else {
                bA4 = A();
            }
            if (!this.f1590m) {
                int i9 = (bA2 & 255) << 8;
                int i10 = bA & 255;
                i2 = i10 | i9 | ((bA3 & 255) << 16) | (bA4 << 24);
                if (i2 == 0) {
                    return i2;
                }
                o();
                throw null;
            }
            i3 = (bA << 24) | ((bA2 & 255) << 16) | ((bA3 & 255) << 8);
            i4 = bA4 & 255;
        } else if (this.f1590m) {
            i3 = (bA & 255) << 8;
            i4 = bA2 & 255;
        } else {
            i3 = bA & 255;
            i4 = (bA2 & 255) << 8;
        }
        i2 = i3 | i4;
        if (i2 == 0) {
        }
    }

    protected void E(int i2) throws IOException, XMLStreamException {
        if (i2 == 13 && B() != 10) {
            this.f1588k -= this.f1591n;
        }
        this.b++;
        this.c = this.f1588k;
    }

    protected int F() throws IOException, XMLStreamException {
        int i2 = 0;
        while (true) {
            int iB = B();
            if (iB > 32) {
                this.f1588k -= this.f1591n;
                return i2;
            }
            if (iB == 13 || iB == 10) {
                E(iB);
            } else if (iB == 0) {
                o();
                throw null;
            }
            i2++;
        }
    }

    protected void G(byte b) throws IOException, XMLStreamException {
        byte bA;
        if (b == 13) {
            int i2 = this.f1588k;
            if (i2 < this.f1589l) {
                byte[] bArr = this.f1587j;
                this.f1588k = i2 + 1;
                bA = bArr[i2];
            } else {
                bA = A();
            }
            if (bA != 10) {
                this.f1588k--;
            }
        }
        this.b++;
        this.c = this.f1588k;
    }

    protected int H() throws IOException, XMLStreamException {
        byte bA;
        int i2 = 0;
        while (true) {
            int i3 = this.f1588k;
            if (i3 < this.f1589l) {
                byte[] bArr = this.f1587j;
                this.f1588k = i3 + 1;
                bA = bArr[i3];
            } else {
                bA = A();
            }
            if ((bA & 255) > 32) {
                this.f1588k--;
                return i2;
            }
            if (bA == 13 || bA == 10) {
                G(bA);
            } else if (bA == 0) {
                o();
                throw null;
            }
            i2++;
        }
    }

    protected String K(String str) throws XMLStreamException {
        String strD = i.e.a.l.b.d(str);
        if (strD == "UTF-8" || strD == "ISO-8859-1" || strD == "US-ASCII") {
            I(strD, 1);
        } else if (strD == "UTF-16") {
            I(strD, 2);
        } else if (strD == "UTF-16LE") {
            J(strD, 2, false);
        } else if (strD == "UTF-16BE") {
            J(strD, 2, true);
        } else if (strD == "UTF-32") {
            I(strD, 4);
        } else if (strD == "UTF-32LE") {
            J(strD, 4, false);
        } else if (strD == "UTF-32BE") {
            J(strD, 4, true);
        }
        return strD;
    }

    @Override // i.e.a.j.n
    public final e0 a() throws XMLStreamException {
        try {
            try {
                return w();
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        } finally {
            this.d.A(this.f1600h);
        }
    }

    @Override // i.e.a.j.n
    protected int b(String str) throws IOException, XMLStreamException {
        return this.f1591n > 1 ? s(str) : t(str);
    }

    @Override // i.e.a.j.n
    protected Location c() {
        int i2 = this.a;
        int i3 = this.f1588k;
        int i4 = i2 + i3;
        int i5 = i3 - this.c;
        int i6 = this.f1591n;
        if (i6 > 1) {
            i4 /= i6;
            i5 /= i6;
        }
        return i.e.a.i.d.b(this.d.H(), this.d.I(), i4, this.b, i5);
    }

    @Override // i.e.a.j.n
    protected int d() throws IOException, XMLStreamException {
        byte bA;
        if (this.f1591n > 1) {
            return B();
        }
        int i2 = this.f1588k;
        if (i2 < this.f1589l) {
            byte[] bArr = this.f1587j;
            this.f1588k = i2 + 1;
            bA = bArr[i2];
        } else {
            bA = A();
        }
        return bA & 255;
    }

    @Override // i.e.a.j.n
    protected int e(boolean z) throws IOException, XMLStreamException {
        byte bA;
        int iF = this.f1591n > 1 ? F() : H();
        if (z && iF == 0) {
            q(d(), "; expected a white space");
            throw null;
        }
        if (this.f1591n > 1) {
            return B();
        }
        int i2 = this.f1588k;
        if (i2 < this.f1589l) {
            byte[] bArr = this.f1587j;
            this.f1588k = i2 + 1;
            bA = bArr[i2];
        } else {
            bA = A();
        }
        return bA & 255;
    }

    @Override // i.e.a.j.n
    protected void h() {
        this.f1588k -= this.f1591n;
    }

    @Override // i.e.a.j.n
    protected int i(char[] cArr, int i2) throws IOException, XMLStreamException {
        byte bA;
        int length = cArr.length;
        boolean z = this.f1591n > 1;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = 10;
            if (z) {
                int iB = B();
                if (iB == 13 || iB == 10) {
                    E(iB);
                } else {
                    i4 = iB;
                }
            } else {
                int i5 = this.f1588k;
                if (i5 < this.f1589l) {
                    byte[] bArr = this.f1587j;
                    this.f1588k = i5 + 1;
                    bA = bArr[i5];
                } else {
                    bA = A();
                }
                if (bA == 0) {
                    o();
                    throw null;
                }
                if (bA == 13 || bA == 10) {
                    G(bA);
                } else {
                    i4 = bA;
                }
                i4 &= 255;
            }
            if (i4 == i2) {
                return i3;
            }
            cArr[i3] = (char) i4;
        }
        return -1;
    }

    protected int s(String str) throws IOException, XMLStreamException {
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            int iB = B();
            if (iB == 0) {
                o();
                throw null;
            }
            if (iB != str.charAt(i2)) {
                return iB;
            }
        }
        return 0;
    }

    protected int t(String str) throws IOException, XMLStreamException {
        byte bA;
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            int i3 = this.f1588k;
            if (i3 < this.f1589l) {
                byte[] bArr = this.f1587j;
                this.f1588k = i3 + 1;
                bA = bArr[i3];
            } else {
                bA = A();
            }
            if (bA == 0) {
                o();
                throw null;
            }
            int i4 = bA & 255;
            if (i4 != str.charAt(i2)) {
                return i4;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e0 w() throws IOException, XMLStreamException {
        String strK;
        v();
        if (y()) {
            j();
            String str = this.f;
            strK = str != null ? K(str) : null;
        }
        if (strK == null) {
            int i2 = this.f1591n;
            strK = i2 == 2 ? this.f1590m ? "UTF-16BE" : "UTF-16LE" : i2 == 4 ? this.f1590m ? "UTF-32BE" : "UTF-32LE" : "UTF-8";
        }
        this.d.R(strK);
        this.d.U(this.e, this.f, this.g);
        if (strK == "UTF-8" || strK == "ISO-8859-1" || strK == "US-ASCII") {
            return new d0(this.d, this.f1586i, this.f1587j, this.f1588k, this.f1589l);
        }
        if (strK.startsWith("UTF-32")) {
            return new a0(this.d, new c0(this.d, this.f1586i, this.f1587j, this.f1588k, this.f1589l, this.f1590m));
        }
        InputStream pVar = this.f1586i;
        if (this.f1588k < this.f1589l) {
            pVar = new p(this.d, pVar, this.f1587j, this.f1588k, this.f1589l);
        }
        if (strK == "UTF-16") {
            strK = this.f1590m ? "UTF-16BE" : "UTF-16LE";
        }
        try {
            return new a0(this.d, new InputStreamReader(pVar, strK));
        } catch (UnsupportedEncodingException e) {
            throw new i.e.a.i.c("Unsupported encoding: " + e.getMessage());
        }
    }

    protected boolean x(int i2) throws IOException {
        int i3;
        int i4 = this.f1589l - this.f1588k;
        while (i4 < i2) {
            InputStream inputStream = this.f1586i;
            if (inputStream == null) {
                i3 = -1;
            } else {
                byte[] bArr = this.f1587j;
                int i5 = this.f1589l;
                i3 = inputStream.read(bArr, i5, bArr.length - i5);
            }
            if (i3 < 1) {
                return false;
            }
            this.f1589l += i3;
            i4 += i3;
        }
        return true;
    }

    protected boolean y() throws IOException, XMLStreamException {
        int i2 = this.f1591n;
        if (i2 != 1) {
            if (!x(i2 * 6)) {
                return false;
            }
            int i3 = this.f1588k;
            if (B() == 60 && B() == 63 && B() == 120 && B() == 109 && B() == 108 && B() <= 32) {
                return true;
            }
            this.f1588k = i3;
            return false;
        }
        if (!x(6)) {
            return false;
        }
        byte[] bArr = this.f1587j;
        int i4 = this.f1588k;
        if (bArr[i4] != 60 || bArr[i4 + 1] != 63 || bArr[i4 + 2] != 120 || bArr[i4 + 3] != 109 || bArr[i4 + 4] != 108 || (bArr[i4 + 5] & 255) > 32) {
            return false;
        }
        this.f1588k = i4 + 6;
        return true;
    }

    protected void z() throws IOException, XMLStreamException {
        int i2 = this.a;
        int i3 = this.f1589l;
        this.a = i2 + i3;
        this.c -= i3;
        this.f1588k = 0;
        InputStream inputStream = this.f1586i;
        if (inputStream == null) {
            this.f1589l = -1;
        } else {
            byte[] bArr = this.f1587j;
            this.f1589l = inputStream.read(bArr, 0, bArr.length);
        }
        if (this.f1589l >= 1) {
            return;
        }
        n();
        throw null;
    }
}
