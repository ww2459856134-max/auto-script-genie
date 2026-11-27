package n.a.a.o;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class j1 {
    public static final Charset a = StandardCharsets.UTF_16LE;

    static {
        Charset charset = StandardCharsets.UTF_8;
        Charset.forName("cp1252");
    }

    public static int a(CharSequence charSequence, char c) {
        if (charSequence == null) {
            return 0;
        }
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i3) == c) {
                i2++;
            }
        }
        return i2;
    }

    public static boolean b(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(true, str.length() - length, str2, 0, length);
    }

    public static int c(String str) {
        return (str.length() * (e(str) ? 2 : 1)) + 3;
    }

    public static byte[] d(String str) {
        return str.getBytes(a);
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c > 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(CharSequence charSequence) {
        int i2 = i(charSequence);
        if (i2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!Character.isWhitespace(charSequence.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(CharSequence charSequence) {
        return !f(charSequence);
    }

    public static boolean h(char c) {
        String string = Character.toString(c);
        return string.toUpperCase(Locale.ROOT).equals(string);
    }

    public static int i(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String j(char c, int i2) {
        if (i2 <= 0) {
            return "";
        }
        char[] cArr = new char[i2];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static String k(char c) {
        return Character.toString(c).toLowerCase(Locale.ROOT);
    }

    public static String l(char c) {
        return Character.toString(c).toUpperCase(Locale.ROOT);
    }
}
