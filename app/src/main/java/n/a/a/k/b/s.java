package n.a.a.k.b;

import com.auto.exceldeps.log4j.Logger;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class s {
    private static final Logger a = n.a.a.i.b.a(s.class);
    public static final URI b;
    public static final o c;
    public static final URI d;
    public static final o e;
    public static final URI f;
    public static final o g;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f2287h;

    /* renamed from: i, reason: collision with root package name */
    private static final char[] f2288i;

    static {
        URI uri;
        URI uri2;
        URI uri3;
        o oVarC;
        o oVarC2;
        o oVar = null;
        try {
            uri = new URI("/");
            try {
                uri2 = new URI("/_rels/.rels");
                try {
                    new URI("/");
                    uri3 = new URI("/docProps/core.xml");
                } catch (URISyntaxException unused) {
                    uri3 = null;
                    f = uri;
                    b = uri2;
                    d = uri3;
                    oVarC2 = c(uri2);
                    try {
                        oVarC = c(uri3);
                        oVar = new o(uri, false);
                    } catch (n.a.a.k.a.a unused2) {
                        oVarC = null;
                    }
                    c = oVarC2;
                    e = oVarC;
                    g = oVar;
                    f2287h = Pattern.compile("\\w+://");
                    f2288i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                }
            } catch (URISyntaxException unused3) {
                uri2 = null;
            }
        } catch (URISyntaxException unused4) {
            uri = null;
            uri2 = null;
        }
        f = uri;
        b = uri2;
        d = uri3;
        try {
            oVarC2 = c(uri2);
            oVarC = c(uri3);
            try {
                oVar = new o(uri, false);
            } catch (n.a.a.k.a.a unused5) {
            }
        } catch (n.a.a.k.a.a unused6) {
            oVarC = null;
            oVarC2 = null;
        }
        c = oVarC2;
        e = oVarC;
        g = oVar;
        f2287h = Pattern.compile("\\w+://");
        f2288i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(String str, String str2) {
        if (!str.endsWith("/") && !str2.startsWith("/")) {
            return str + '/' + str2;
        }
        if (!(str2.startsWith("/") ^ str.endsWith("/"))) {
            return "";
        }
        return str + str2;
    }

    public static o b(String str) throws n.a.a.k.a.a {
        try {
            return c(n(str));
        } catch (URISyntaxException e2) {
            throw new n.a.a.k.a.a(e2.getMessage());
        }
    }

    public static o c(URI uri) throws n.a.a.k.a.a {
        if (uri != null) {
            return new o(uri, true);
        }
        throw new IllegalArgumentException("partName");
    }

    public static String d(String str) {
        if (str.length() == 0) {
            return str;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        while (byteBufferWrap.hasRemaining()) {
            int i2 = byteBufferWrap.get() & 255;
            if (k(i2)) {
                sb.append('%');
                char[] cArr = f2288i;
                sb.append(cArr[(i2 >> 4) & 15]);
                sb.append(cArr[(i2 >> 0) & 15]);
            } else {
                sb.append((char) i2);
            }
        }
        return sb.toString();
    }

    public static String e(URI uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        int length = path.length();
        int i2 = length;
        do {
            i2--;
            if (i2 < 0) {
                return "";
            }
        } while (path.charAt(i2) != '/');
        return path.substring(i2 + 1, length);
    }

    public static String f(URI uri) {
        String strE = e(uri);
        int iLastIndexOf = strE.lastIndexOf(46);
        return iLastIndexOf == -1 ? strE : strE.substring(0, iLastIndexOf);
    }

    public static o g(o oVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("partName");
        }
        if (f.getPath().equals(oVar.g().getPath())) {
            return c;
        }
        if (oVar.j()) {
            throw new n.a.a.k.a.b("Can't be a relationship part");
        }
        String path = oVar.g().getPath();
        String strE = e(oVar.g());
        try {
            return b(a(a(path.substring(0, path.length() - strE.length()), "_rels"), strE) + ".rels");
        } catch (n.a.a.k.a.a unused) {
            return null;
        }
    }

    public static URI h(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Must not be null");
        }
        if (!j(uri)) {
            throw new IllegalArgumentException("Must be a relationship part");
        }
        if (uri.compareTo(b) == 0) {
            return f;
        }
        String path = uri.getPath();
        return i(a(path.substring(0, (path.length() - r3.length()) - 5).substring(0, (r0.length() - 5) - 1), f(uri)));
    }

    public static URI i(String str) {
        try {
            return n(str);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("path");
        }
    }

    public static boolean j(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("partUri");
        }
        String path = uri.getPath();
        return path != null && path.matches(".*_rels.*.rels$");
    }

    private static boolean k(int i2) {
        return i2 >= 128 || i2 == 124 || Character.isWhitespace(i2);
    }

    public static URI l(URI uri, URI uri2, boolean z) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = uri.getPath().split("/", -1);
        String[] strArrSplit2 = uri2.getPath().split("/", -1);
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty source URI !");
        }
        if (strArrSplit2.length == 0) {
            throw new IllegalArgumentException("Can't relativize an empty target URI !");
        }
        if (uri.toString().equals("/")) {
            String path = uri2.getPath();
            if (!z || path.isEmpty() || path.charAt(0) != '/') {
                return uri2;
            }
            try {
                return new URI(path.substring(1));
            } catch (Exception e2) {
                a.atWarn().withThrowable(e2).log("Failed to relativize");
                return null;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < strArrSplit.length && i3 < strArrSplit2.length && strArrSplit[i3].equals(strArrSplit2[i3]); i3++) {
            i2++;
        }
        if ((i2 == 0 || i2 == 1) && strArrSplit[0].isEmpty() && strArrSplit2[0].isEmpty()) {
            for (int i4 = 0; i4 < strArrSplit.length - 2; i4++) {
                sb.append("../");
            }
            for (int i5 = 0; i5 < strArrSplit2.length; i5++) {
                if (!strArrSplit2[i5].isEmpty()) {
                    sb.append(strArrSplit2[i5]);
                    if (i5 != strArrSplit2.length - 1) {
                        sb.append("/");
                    }
                }
            }
            try {
                return new URI(sb.toString());
            } catch (Exception e3) {
                a.atWarn().withThrowable(e3).log("Failed to relativize");
                return null;
            }
        }
        if (i2 != strArrSplit.length || i2 != strArrSplit2.length) {
            if (i2 == 1) {
                sb.append("/");
            } else {
                for (int i6 = i2; i6 < strArrSplit.length - 1; i6++) {
                    sb.append("../");
                }
            }
            while (i2 < strArrSplit2.length) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '/') {
                    sb.append("/");
                }
                sb.append(strArrSplit2[i2]);
                i2++;
            }
        } else if (uri.equals(uri2)) {
            sb.append(strArrSplit[strArrSplit.length - 1]);
        }
        String rawFragment = uri2.getRawFragment();
        if (rawFragment != null) {
            sb.append("#");
            sb.append(rawFragment);
        }
        try {
            return new URI(sb.toString());
        } catch (Exception e4) {
            a.atWarn().withThrowable(e4).log("Failed to relativize");
            return null;
        }
    }

    public static URI m(URI uri, URI uri2) {
        if (uri == null || uri.isAbsolute()) {
            throw new IllegalArgumentException("sourcePartUri invalid - " + uri);
        }
        if (uri2 != null && !uri2.isAbsolute()) {
            return uri.resolve(uri2);
        }
        throw new IllegalArgumentException("targetUri invalid - " + uri2);
    }

    public static URI n(String str) throws URISyntaxException {
        if (str.contains("\\")) {
            str = str.replace('\\', '/');
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf) + "#" + d(str.substring(iIndexOf + 1));
        }
        if (!str.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            while (length >= 0) {
                char cCharAt = str.charAt(length);
                if (!Character.isWhitespace(cCharAt) && cCharAt != 160) {
                    break;
                }
                sb.append(cCharAt);
                length--;
            }
            if (sb.length() > 0) {
                str = str.substring(0, length + 1) + d(sb.reverse().toString());
            }
        }
        if (f2287h.matcher(str).matches()) {
            str = str + "/";
        }
        return new URI(str);
    }
}
