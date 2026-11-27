package i.b;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class r8 {
    private static final Pattern a = Pattern.compile("[^0-9.]");

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return "number".equals(str2) ? a.matcher(str).replaceAll("").trim() : str;
    }
}
