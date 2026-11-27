package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class c1 {
    private static final Pattern a = Pattern.compile("([A-Za-z]+)([0-9]+)");

    static void a(Appendable appendable, String str) throws IOException {
        try {
            if (str == null) {
                appendable.append("#REF");
                return;
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '\'') {
                    appendable.append(Chars.QUOTE);
                }
                appendable.append(cCharAt);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void b(Appendable appendable, String str) {
        try {
            if (!i(str)) {
                a(appendable, str);
                return;
            }
            appendable.append(Chars.QUOTE);
            a(appendable, str);
            appendable.append(Chars.QUOTE);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    static boolean c(String str, String str2) {
        return n.a.a.n.e.s.b(str, str2, n.a.a.n.a.EXCEL97);
    }

    public static String d(String str) {
        StringBuilder sb = new StringBuilder((str == null ? 0 : str.length()) + 2);
        b(sb, str);
        return sb.toString();
    }

    static boolean e(char c) {
        if (Character.isLetterOrDigit(c)) {
            return false;
        }
        if (c != '\t' && c != '\n' && c != '\r') {
            return (c == '.' || c == '_') ? false : true;
        }
        throw new IllegalStateException("Illegal character (0x" + Integer.toHexString(c) + ") found in sheet name");
    }

    private static boolean f(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt != 'F') {
            if (cCharAt != 'T') {
                if (cCharAt != 'f') {
                    if (cCharAt != 't') {
                        return false;
                    }
                }
            }
            return "TRUE".equalsIgnoreCase(str);
        }
        return "FALSE".equalsIgnoreCase(str);
    }

    static boolean g(String str) {
        Matcher matcher = a.matcher(str);
        if (matcher.matches()) {
            return c(matcher.group(1), matcher.group(2));
        }
        return false;
    }

    static boolean h(String str) {
        int length = str.length();
        char cCharAt = str.charAt(0);
        if (cCharAt != 'R' && cCharAt != 'r') {
            if (cCharAt != 'C' && cCharAt != 'c') {
                return false;
            }
            if (length > 1) {
                return Character.isDigit(str.charAt(1));
            }
            return true;
        }
        if (length > 1) {
            char cCharAt2 = str.charAt(1);
            if (cCharAt2 != 'C' && cCharAt2 != 'c') {
                return Character.isDigit(cCharAt2);
            }
            if (length > 2) {
                return Character.isDigit(str.charAt(2));
            }
        }
        return true;
    }

    static boolean i(String str) {
        int length;
        if (str == null || (length = str.length()) < 1) {
            return false;
        }
        if (Character.isDigit(str.charAt(0))) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (e(str.charAt(i2))) {
                return true;
            }
        }
        return (Character.isLetter(str.charAt(0)) && Character.isDigit(str.charAt(length - 1)) && g(str)) || f(str) || h(str);
    }
}
