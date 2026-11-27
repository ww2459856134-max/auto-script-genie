package n.a.a.k.b;

import java.math.BigInteger;
import java.net.URI;
import java.util.Locale;

/* loaded from: classes.dex */
public final class o implements Comparable<o> {
    private final URI c;
    private final boolean d;

    o(URI uri, boolean z) throws n.a.a.k.a.a {
        if (z) {
            n(uri);
        } else if (!s.f.equals(uri)) {
            throw new n.a.a.k.a.g("OCP conformance must be check for ALL part name except special cases : ['/']");
        }
        this.c = uri;
        this.d = k(uri);
    }

    private static void a(String str) throws n.a.a.k.a.a {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (!h(cCharAt) && "-._~".indexOf(cCharAt) <= -1 && ":@".indexOf(cCharAt) <= -1 && "!$&'()*+,;=".indexOf(cCharAt) <= -1) {
                if (cCharAt != '%') {
                    throw new n.a.a.k.a.a("A segment shall not hold any characters other than pchar characters. [M1.6]");
                }
                if (length - i2 >= 2) {
                    int i3 = i2 + 1;
                    if (i(str.charAt(i3))) {
                        int i4 = i2 + 2;
                        if (i(str.charAt(i4))) {
                            char c = (char) Integer.parseInt(str.substring(i3, i2 + 3), 16);
                            if (c == '/' || c == '\\') {
                                throw new n.a.a.k.a.a("A segment shall not contain percent-encoded forward slash ('/'), or backward slash ('\\') characters. [M1.7]");
                            }
                            if (h(c) || "-._~".indexOf(c) > -1) {
                                throw new n.a.a.k.a.a("A segment shall not contain percent-encoded unreserved characters. [M1.8]");
                            }
                            i2 = i4;
                        }
                    }
                }
                throw new n.a.a.k.a.a("The segment " + str + " contain invalid encoded character !");
            }
            i2++;
        }
    }

    public static int b(String str, String str2) {
        int i2 = 0;
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        if (str.equalsIgnoreCase(str2)) {
            return 0;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        String lowerCase2 = str2.toLowerCase(locale);
        int length = lowerCase.length();
        int length2 = lowerCase2.length();
        int i3 = 0;
        while (i2 < length && i3 < length2) {
            int i4 = i2 + 1;
            char cCharAt = lowerCase.charAt(i2);
            int i5 = i3 + 1;
            char cCharAt2 = lowerCase2.charAt(i3);
            if (Character.isDigit(cCharAt) && Character.isDigit(cCharAt2)) {
                int i6 = i4 - 1;
                while (i4 < length && Character.isDigit(lowerCase.charAt(i4))) {
                    i4++;
                }
                int i7 = i5 - 1;
                while (i5 < length2 && Character.isDigit(lowerCase2.charAt(i5))) {
                    i5++;
                }
                int iCompareTo = new BigInteger(lowerCase.substring(i6, i4)).compareTo(new BigInteger(lowerCase2.substring(i7, i5)));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            } else if (cCharAt != cCharAt2) {
                return cCharAt - cCharAt2;
            }
            i2 = i4;
            i3 = i5;
        }
        return length - length2;
    }

    public static int c(o oVar, o oVar2) {
        return b(oVar == null ? null : oVar.f(), oVar2 != null ? oVar2.f() : null);
    }

    private static boolean h(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static boolean i(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private boolean k(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        String path = uri.getPath();
        return path != null && path.matches("^.*/_rels/.*\\.rels$");
    }

    private static void l(URI uri) throws n.a.a.k.a.a {
        if (uri.isAbsolute()) {
            throw new n.a.a.k.a.a("Absolute URI forbidden: " + uri);
        }
    }

    private static void m(URI uri) throws n.a.a.k.a.a {
        if (uri == null) {
            throw new IllegalArgumentException("partURI");
        }
        String path = uri.getPath();
        if (path == null || path.isEmpty() || (path.length() == 1 && path.charAt(0) == '/')) {
            throw new n.a.a.k.a.a("A part name shall not be empty [M1.1]: " + uri.getPath());
        }
    }

    private static void n(URI uri) throws n.a.a.k.a.a {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        m(uri);
        l(uri);
        q(uri);
        o(uri);
        p(uri);
    }

    private static void o(URI uri) throws n.a.a.k.a.a {
        String path = uri.getPath();
        if (path.isEmpty() || path.charAt(path.length() - 1) != '/') {
            return;
        }
        throw new n.a.a.k.a.a("A part name shall not have a forward slash as the last character [M1.5]: " + uri.getPath());
    }

    private static void p(URI uri) throws n.a.a.k.a.a {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        String[] strArrSplit = uri.toASCIIString().replaceFirst("^/", "").split("/");
        if (strArrSplit.length < 1) {
            throw new n.a.a.k.a.a("A part name shall not have empty segments [M1.3]: " + uri.getPath());
        }
        for (String str : strArrSplit) {
            if (str == null || str.isEmpty()) {
                throw new n.a.a.k.a.a("A part name shall not have empty segments [M1.3]: " + uri.getPath());
            }
            if (str.endsWith(".")) {
                throw new n.a.a.k.a.a("A segment shall not end with a dot ('.') character [M1.9]: " + uri.getPath());
            }
            if (str.replaceAll("\\\\.", "").isEmpty()) {
                throw new n.a.a.k.a.a("A segment shall include at least one non-dot character. [M1.10]: " + uri.getPath());
            }
            a(str);
        }
    }

    private static void q(URI uri) throws n.a.a.k.a.a {
        String path = uri.getPath();
        if (path.isEmpty() || path.charAt(0) == '/') {
            return;
        }
        throw new n.a.a.k.a.a("A part name shall start with a forward slash ('/') character [M1.4]: " + uri.getPath());
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        return c(this, oVar);
    }

    public String e() {
        int iLastIndexOf;
        String path = this.c.getPath();
        return (path.isEmpty() || (iLastIndexOf = path.lastIndexOf(46)) <= -1) ? "" : path.substring(iLastIndexOf + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof o) && b(f(), ((o) obj).f()) == 0;
    }

    public String f() {
        return g().toASCIIString();
    }

    public URI g() {
        return this.c;
    }

    public int hashCode() {
        return f().toLowerCase(Locale.ROOT).hashCode();
    }

    public boolean j() {
        return this.d;
    }

    public String toString() {
        return f();
    }
}
