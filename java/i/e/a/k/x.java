package i.e.a.k;

import java.io.IOException;
import java.text.MessageFormat;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class x extends s {
    protected final w a;
    protected char[] b;
    protected final int c;
    protected boolean d = false;
    protected int e = 0;
    protected int f = 1;
    protected int g = 0;

    protected x(w wVar) {
        this.a = wVar;
        char[] cArrJ = wVar.j(512);
        this.b = cArrJ;
        this.c = cArrJ.length;
        wVar.B();
        wVar.G();
        wVar.H();
    }

    public static final int m(w wVar) {
        String strD;
        String strZ = wVar.z();
        if (strZ == null || strZ.length() == 0 || (strD = i.e.a.l.b.d(strZ)) == "UTF-8") {
            return 16;
        }
        if (strD == "ISO-8859-1") {
            return 8;
        }
        if (strD == "US-ASCII") {
            return 7;
        }
        return (strD == "UTF-16" || strD == "UTF-16BE" || strD == "UTF-16LE" || strD == "UTF-32BE" || strD == "UTF-32LE") ? 16 : 8;
    }

    public abstract void A(r rVar) throws IOException, XMLStreamException;

    public abstract void B(r rVar) throws IOException, XMLStreamException;

    public abstract int C(r rVar, String str) throws IOException, XMLStreamException;

    public abstract void D(String str, int i2, int i3) throws IOException, XMLStreamException;

    public abstract void E(String str) throws IOException, XMLStreamException;

    public abstract void F(char[] cArr, int i2, int i3) throws IOException, XMLStreamException;

    public abstract void G() throws IOException, XMLStreamException;

    public abstract void H() throws IOException, XMLStreamException;

    public abstract void I(r rVar) throws IOException, XMLStreamException;

    public abstract void J(String str, String str2, String str3) throws IOException, XMLStreamException;

    public abstract void c(boolean z) throws IOException;

    public void d() {
        char[] cArr = this.b;
        if (cArr != null) {
            this.b = null;
            this.a.t(cArr);
        }
    }

    public final void e(boolean z) throws IOException {
        g();
        d();
        c(z || this.a.E());
    }

    public void f() {
        this.d = true;
    }

    public abstract void g() throws IOException;

    public int h() {
        return this.e + k();
    }

    public int i() {
        return (k() - this.g) + 1;
    }

    public abstract int j();

    protected abstract int k();

    public int l() {
        return this.f;
    }

    protected void n(String str, int i2) throws XMLStreamException {
        if (i2 == 65534 || i2 == 65535 || (i2 >= 55296 && i2 <= 57343)) {
            o(i2);
            throw null;
        }
        if (i2 >= 32 || (i2 != 0 && this.a.C())) {
            p(MessageFormat.format(i.e.a.i.b.A, str, Integer.valueOf(i2)));
            throw null;
        }
        o(i2);
        throw null;
    }

    protected void o(int i2) throws XMLStreamException {
        try {
            g();
            if (i2 == 0) {
                p("Invalid null character in text to output");
                throw null;
            }
            if (i2 < 32 || (i2 >= 127 && i2 <= 159)) {
                String str = "Invalid white space character (0x" + Integer.toHexString(i2) + ") in text to output";
                if (this.d) {
                    str = str + " (can only be output using character entity)";
                }
                p(str);
                throw null;
            }
            if (i2 > 1114111) {
                p("Illegal unicode character point (0x" + Integer.toHexString(i2) + ") to output; max is 0x10FFFF as per RFC 3629");
                throw null;
            }
            if (i2 >= 55296 && i2 <= 57343) {
                p("Illegal surrogate pair -- can only be output via character entities (for current encoding), which are not allowed in this content");
                throw null;
            }
            p("Invalid XML character " + i.e.a.l.p.c(i2) + " in text to output");
            throw null;
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    protected void p(String str) throws XMLStreamException {
        s(str);
        throw null;
    }

    protected void q(String str, Object obj, Object obj2) throws XMLStreamException {
        p(MessageFormat.format(str, obj, obj2));
        throw null;
    }

    protected void r(String str) throws XMLStreamException {
        s(str);
        throw null;
    }

    protected void s(String str) throws XMLStreamException {
        try {
            g();
            throw new XMLStreamException(str);
        } catch (IOException e) {
            throw new i.e.a.i.c(e);
        }
    }

    public abstract void t(r rVar, String str) throws IOException, XMLStreamException;

    public abstract int u(String str) throws IOException, XMLStreamException;

    public abstract void v(String str) throws IOException, XMLStreamException;

    public abstract void w(char[] cArr, int i2, int i3) throws IOException, XMLStreamException;

    public abstract int x(String str) throws IOException, XMLStreamException;

    public abstract void y(r rVar, String str, String str2, String str3) throws IOException, XMLStreamException;

    public abstract void z(String str) throws IOException, XMLStreamException;
}
