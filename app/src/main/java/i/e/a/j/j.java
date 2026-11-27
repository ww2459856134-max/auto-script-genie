package i.e.a.j;

import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLReporter;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: i, reason: collision with root package name */
    final Reader f1593i;

    /* renamed from: j, reason: collision with root package name */
    final char[] f1594j;

    /* renamed from: k, reason: collision with root package name */
    private int f1595k;

    /* renamed from: l, reason: collision with root package name */
    private int f1596l;

    private j(z zVar, Reader reader) {
        super(zVar);
        this.f1593i = reader;
        this.f1594j = zVar.i(4000);
        this.f1595k = 0;
        this.f1596l = 0;
    }

    public static j s(z zVar, Reader reader) throws XMLStreamException {
        return new j(zVar, reader);
    }

    @Override // i.e.a.j.n
    public final e0 a() throws XMLStreamException {
        try {
            try {
                return t();
            } catch (IOException e) {
                throw new i.e.a.i.c(e);
            }
        } finally {
            this.d.A(this.f1600h);
        }
    }

    @Override // i.e.a.j.n
    protected int b(String str) throws IOException, XMLStreamException {
        char cW;
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            int i3 = this.f1595k;
            if (i3 < this.f1596l) {
                char[] cArr = this.f1594j;
                this.f1595k = i3 + 1;
                cW = cArr[i3];
            } else {
                cW = w();
            }
            if (cW != str.charAt(i2)) {
                return cW;
            }
            if (cW == 0) {
                o();
                throw null;
            }
        }
        return 0;
    }

    @Override // i.e.a.j.n
    protected Location c() {
        String strH = this.d.H();
        String strI = this.d.I();
        int i2 = this.a;
        return i.e.a.i.d.b(strH, strI, i2 + r3, this.b, this.f1595k - this.c);
    }

    @Override // i.e.a.j.n
    protected int d() throws IOException, XMLStreamException {
        int i2 = this.f1595k;
        if (i2 >= this.f1596l) {
            return w();
        }
        char[] cArr = this.f1594j;
        this.f1595k = i2 + 1;
        return cArr[i2];
    }

    @Override // i.e.a.j.n
    protected int e(boolean z) throws IOException, XMLStreamException {
        char cW;
        int i2 = 0;
        while (true) {
            int i3 = this.f1595k;
            if (i3 < this.f1596l) {
                char[] cArr = this.f1594j;
                this.f1595k = i3 + 1;
                cW = cArr[i3];
            } else {
                cW = w();
            }
            if (cW > ' ') {
                if (!z || i2 != 0) {
                    return cW;
                }
                q(cW, "; expected a white space");
                throw null;
            }
            if (cW == '\r' || cW == '\n') {
                x(cW);
            } else if (cW == 0) {
                o();
                throw null;
            }
            i2++;
        }
    }

    @Override // i.e.a.j.n
    protected void h() {
        this.f1595k--;
    }

    @Override // i.e.a.j.n
    protected int i(char[] cArr, int i2) throws IOException, XMLStreamException {
        char cW;
        int length = cArr.length;
        int i3 = 0;
        while (true) {
            int i4 = this.f1595k;
            if (i4 < this.f1596l) {
                char[] cArr2 = this.f1594j;
                this.f1595k = i4 + 1;
                cW = cArr2[i4];
            } else {
                cW = w();
            }
            if (cW == '\r' || cW == '\n') {
                x(cW);
            } else if (cW == 0) {
                o();
                throw null;
            }
            if (cW == i2) {
                if (i3 < length) {
                    return i3;
                }
                return -1;
            }
            if (i3 < length) {
                cArr[i3] = cW;
                i3++;
            }
        }
    }

    public e0 t() throws IOException, XMLStreamException {
        if (this.f1595k >= this.f1596l) {
            u(7);
        }
        String strY = null;
        int i2 = this.f1596l;
        int i3 = this.f1595k;
        if (i2 - i3 >= 7) {
            char[] cArr = this.f1594j;
            char c = cArr[i3];
            if (c == 65279) {
                int i4 = i3 + 1;
                this.f1595k = i4;
                c = cArr[i4];
            }
            if (c == '<') {
                int i5 = this.f1595k;
                if (cArr[i5 + 1] == '?' && cArr[i5 + 2] == 'x' && cArr[i5 + 3] == 'm' && cArr[i5 + 4] == 'l' && cArr[i5 + 5] <= ' ') {
                    this.f1595k = i5 + 6;
                    j();
                    String str = this.f;
                    if (str != null) {
                        strY = y(str);
                    }
                }
            } else if (c == 239) {
                throw new i.e.a.i.c("Unexpected first character (char code 0xEF), not valid in xml document: could be mangled UTF-8 BOM marker. Make sure that the Reader uses correct encoding or pass an InputStream instead");
            }
        }
        this.d.R(strY);
        this.d.U(this.e, this.f, this.g);
        return new a0(this.d, this.f1593i, this.f1594j, this.f1595k, this.f1596l);
    }

    protected boolean u(int i2) throws IOException {
        this.f1595k = 0;
        this.f1596l = 0;
        if (this.f1593i == null) {
            return false;
        }
        while (true) {
            int i3 = this.f1596l;
            if (i3 >= i2) {
                return true;
            }
            Reader reader = this.f1593i;
            char[] cArr = this.f1594j;
            int i4 = reader.read(cArr, i3, cArr.length - i3);
            if (i4 < 1) {
                return false;
            }
            this.f1596l += i4;
        }
    }

    protected void v() throws IOException, XMLStreamException {
        int i2 = this.a;
        int i3 = this.f1596l;
        this.a = i2 + i3;
        this.c -= i3;
        Reader reader = this.f1593i;
        if (reader == null) {
            n();
            throw null;
        }
        this.f1595k = 0;
        char[] cArr = this.f1594j;
        int i4 = reader.read(cArr, 0, cArr.length);
        this.f1596l = i4;
        if (i4 >= 1) {
            return;
        }
        n();
        throw null;
    }

    protected char w() throws IOException, XMLStreamException {
        if (this.f1595k >= this.f1596l) {
            v();
        }
        char[] cArr = this.f1594j;
        int i2 = this.f1595k;
        this.f1595k = i2 + 1;
        return cArr[i2];
    }

    protected void x(char c) throws IOException, XMLStreamException {
        char cW;
        if (c == '\r') {
            int i2 = this.f1595k;
            if (i2 < this.f1596l) {
                char[] cArr = this.f1594j;
                this.f1595k = i2 + 1;
                cW = cArr[i2];
            } else {
                cW = w();
            }
            if (cW != '\n') {
                this.f1595k--;
            }
        }
        this.b++;
        this.c = this.f1595k;
    }

    protected String y(String str) throws XMLStreamException {
        XMLReporter xMLReporterJ;
        String strD = i.e.a.l.b.d(str);
        String strF = this.d.F();
        if (strF != null && strD != null && !strF.equalsIgnoreCase(strD) && (xMLReporterJ = this.d.J()) != null) {
            xMLReporterJ.report(MessageFormat.format(i.e.a.i.b.G, strF, strD), i.e.a.i.b.F, this, c());
        }
        return strD;
    }
}
