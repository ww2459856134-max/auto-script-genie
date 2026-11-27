package k.x;

/* loaded from: classes.dex */
public abstract class e0 {
    private static byte a;
    private static byte b;
    private static byte c;
    private static byte d;
    private static byte e;

    static {
        k.y.c.b(e0.class);
        a = (byte) 1;
        b = (byte) 2;
        c = (byte) 3;
        d = (byte) 4;
        e = (byte) 5;
    }

    public static byte[] a(String str, k.w wVar) {
        return str.startsWith("http:") ? c(str, wVar) : b(str, wVar);
    }

    private static byte[] b(String str, k.w wVar) {
        int i2;
        String strSubstring;
        int length;
        k kVar = new k();
        if (str.charAt(1) == ':') {
            kVar.a(a);
            kVar.a((byte) str.charAt(0));
            i2 = 2;
        } else {
            if (str.charAt(0) == '\\' || str.charAt(0) == '/') {
                kVar.a(b);
            }
            i2 = 0;
        }
        while (true) {
            if (str.charAt(i2) != '\\' && str.charAt(i2) != '/') {
                break;
            }
            i2++;
        }
        while (i2 < str.length()) {
            int iIndexOf = str.indexOf(47, i2);
            int iIndexOf2 = str.indexOf(92, i2);
            int iMax = (iIndexOf == -1 || iIndexOf2 == -1) ? (iIndexOf == -1 || iIndexOf2 == -1) ? Math.max(iIndexOf, iIndexOf2) : 0 : Math.min(iIndexOf, iIndexOf2);
            if (iMax == -1) {
                strSubstring = str.substring(i2);
                length = str.length();
            } else {
                strSubstring = str.substring(i2, iMax);
                length = iMax + 1;
            }
            if (!strSubstring.equals(".")) {
                if (strSubstring.equals("..")) {
                    kVar.a(d);
                } else {
                    kVar.b(y0.c(strSubstring, wVar));
                }
            }
            if (length < str.length()) {
                kVar.a(c);
            }
            i2 = length;
        }
        return kVar.d();
    }

    private static byte[] c(String str, k.w wVar) {
        k kVar = new k();
        kVar.a(e);
        kVar.a((byte) str.length());
        kVar.b(y0.c(str, wVar));
        return kVar.d();
    }
}
