package i.e.a.j;

import java.io.IOException;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;

/* loaded from: classes.dex */
public abstract class n {
    final z d;
    String f;
    String g;

    /* renamed from: h, reason: collision with root package name */
    final char[] f1600h;
    protected int a = 0;
    protected int b = 0;
    protected int c = 0;
    int e = 0;

    protected n(z zVar) {
        this.d = zVar;
        this.f1600h = zVar.k(60);
    }

    private final int f(int i2) throws IOException, XMLStreamException {
        int iD = d();
        if (iD == i2) {
            return iD;
        }
        if (iD <= 32) {
            if (iD == 10 || iD == 13) {
                h();
            }
            return e(false);
        }
        q(iD, "; expected either '" + ((char) i2) + "' or white space");
        throw null;
    }

    private final int g(String str) throws IOException, XMLStreamException {
        int iE = e(false);
        if (iE != 61) {
            q(iE, "; expected '=' after '" + str + "'");
            throw null;
        }
        int iE2 = e(false);
        if (iE2 == 34 || iE2 == 39) {
            return iE2;
        }
        q(iE2, "; expected a quote character enclosing value for '" + str + "'");
        throw null;
    }

    private final String k() throws IOException, XMLStreamException {
        int iB = b("encoding");
        if (iB != 0) {
            q(iB, "encoding");
            throw null;
        }
        int i2 = i(this.f1600h, g("encoding"));
        if (i2 != 0) {
            return i2 < 0 ? new String(this.f1600h) : new String(this.f1600h, 0, i2);
        }
        p("encoding", null, null, null);
        throw null;
    }

    private final String l() throws IOException, XMLStreamException {
        String str;
        int iB = b("standalone");
        if (iB != 0) {
            q(iB, "standalone");
            throw null;
        }
        int i2 = i(this.f1600h, g("standalone"));
        if (i2 == 2) {
            char[] cArr = this.f1600h;
            if (cArr[0] == 'n' && cArr[1] == 'o') {
                return "no";
            }
        } else if (i2 == 3) {
            char[] cArr2 = this.f1600h;
            if (cArr2[0] == 'y' && cArr2[1] == 'e' && cArr2[2] == 's') {
                return "yes";
            }
        }
        if (i2 < 0) {
            str = "'" + new String(this.f1600h) + "[..]'";
        } else if (i2 == 0) {
            str = "<empty>";
        } else {
            str = "'" + new String(this.f1600h, 0, i2) + "'";
        }
        p("standalone", str, "yes", "no");
        throw null;
    }

    private final int m() throws IOException, XMLStreamException {
        String str;
        int iB = b("version");
        if (iB != 0) {
            q(iB, "version");
            throw null;
        }
        int i2 = i(this.f1600h, g("version"));
        if (i2 == 3) {
            char[] cArr = this.f1600h;
            if (cArr[0] == '1' && cArr[1] == '.') {
                char c = cArr[2];
                if (c == '0') {
                    return 256;
                }
                if (c == '1') {
                    return 272;
                }
            }
        }
        if (i2 < 0) {
            str = "'" + new String(this.f1600h) + "[..]'";
        } else if (i2 == 0) {
            str = "<empty>";
        } else {
            str = "'" + new String(this.f1600h, 0, i2) + "'";
        }
        p("version", str, "1.0", "1.1");
        throw null;
    }

    public abstract e0 a() throws XMLStreamException;

    protected abstract int b(String str) throws IOException, XMLStreamException;

    protected abstract Location c();

    protected abstract int d() throws IOException, XMLStreamException;

    protected abstract int e(boolean z) throws IOException, XMLStreamException;

    protected abstract void h();

    protected abstract int i(char[] cArr, int i2) throws IOException, XMLStreamException;

    protected void j() throws IOException, XMLStreamException {
        int iE = e(false);
        if (iE != 118) {
            q(iE, "; expected keyword 'version'");
            throw null;
        }
        this.e = m();
        int iF = f(63);
        if (iF == 101) {
            this.f = k();
            iF = f(63);
        }
        if (iF == 115) {
            this.g = l();
            iF = f(63);
        }
        if (iF != 63) {
            q(iF, "; expected \"?>\" end marker");
            throw null;
        }
        int iD = d();
        if (iD == 62) {
            return;
        }
        q(iD, "; expected \"?>\" end marker");
        throw null;
    }

    protected void n() throws XMLStreamException {
        r("Unexpected end-of-input in xml declaration");
        throw null;
    }

    protected void o() throws XMLStreamException {
        r("Illegal null byte/char in input stream");
        throw null;
    }

    protected final void p(String str, String str2, String str3, String str4) throws XMLStreamException {
        String str5;
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = "; expected \"" + str3 + "\" or \"" + str4 + "\"";
        }
        if (str2 == null || str2.length() == 0) {
            r("Missing XML pseudo-attribute '" + str + "' value" + str5);
            throw null;
        }
        r("Invalid XML pseudo-attribute '" + str + "' value " + str2 + str5);
        throw null;
    }

    protected void q(int i2, String str) throws XMLStreamException {
        String str2;
        char c = (char) i2;
        if (Character.isISOControl(c)) {
            str2 = "Unexpected character (CTRL-CHAR, code " + i2 + ")" + str;
        } else {
            str2 = "Unexpected character '" + c + "' (code " + i2 + ")" + str;
        }
        r(str2);
        throw null;
    }

    protected void r(String str) throws XMLStreamException {
        throw new i.e.a.e(str, c());
    }
}
