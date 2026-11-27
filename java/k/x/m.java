package k.x;

/* loaded from: classes.dex */
public abstract class m {
    private static k.y.c a = k.y.c.b(m.class);

    public static String a(int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        c(i2, i3, stringBuffer);
        return stringBuffer.toString();
    }

    public static void b(int i2, int i3, int i4, k.x.j1.t tVar, StringBuffer stringBuffer) {
        stringBuffer.append(y0.h(tVar.a(i2), "'", "''"));
        stringBuffer.append('!');
        c(i3, i4, stringBuffer);
    }

    public static void c(int i2, int i3, StringBuffer stringBuffer) {
        g(i2, stringBuffer);
        stringBuffer.append(Integer.toString(i3 + 1));
    }

    public static void d(int i2, int i3, boolean z, int i4, boolean z2, k.x.j1.t tVar, StringBuffer stringBuffer) {
        stringBuffer.append(tVar.a(i2));
        stringBuffer.append('!');
        e(i3, z, i4, z2, stringBuffer);
    }

    public static void e(int i2, boolean z, int i3, boolean z2, StringBuffer stringBuffer) {
        if (z) {
            stringBuffer.append('$');
        }
        g(i2, stringBuffer);
        if (z2) {
            stringBuffer.append('$');
        }
        stringBuffer.append(Integer.toString(i3 + 1));
    }

    public static int f(String str) {
        int iH = h(str);
        String upperCase = str.toUpperCase();
        int iLastIndexOf = str.lastIndexOf(33) + 1;
        if (str.charAt(iLastIndexOf) == '$') {
            iLastIndexOf++;
        }
        if (str.charAt(iH - 1) == '$') {
            iH--;
        }
        int iCharAt = 0;
        for (int i2 = iLastIndexOf; i2 < iH; i2++) {
            if (i2 != iLastIndexOf) {
                iCharAt = (iCharAt + 1) * 26;
            }
            iCharAt += upperCase.charAt(i2) - 'A';
        }
        return iCharAt;
    }

    public static void g(int i2, StringBuffer stringBuffer) {
        int i3 = i2 % 26;
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i4 = i2 / 26; i4 != 0; i4 /= 26) {
            stringBuffer2.append((char) (i3 + 65));
            i3 = (i4 % 26) - 1;
        }
        stringBuffer2.append((char) (i3 + 65));
        for (int length = stringBuffer2.length() - 1; length >= 0; length--) {
            stringBuffer.append(stringBuffer2.charAt(length));
        }
    }

    private static int h(String str) {
        int iLastIndexOf = str.lastIndexOf(33) + 1;
        boolean z = false;
        while (!z && iLastIndexOf < str.length()) {
            char cCharAt = str.charAt(iLastIndexOf);
            if (cCharAt < '0' || cCharAt > '9') {
                iLastIndexOf++;
            } else {
                z = true;
            }
        }
        return iLastIndexOf;
    }

    public static int i(String str) {
        try {
            return Integer.parseInt(str.substring(h(str))) - 1;
        } catch (NumberFormatException e) {
            a.g(e, e);
            return 65535;
        }
    }

    public static boolean j(String str) {
        return str.charAt(0) != '$';
    }

    public static boolean k(String str) {
        return str.charAt(h(str) - 1) != '$';
    }
}
