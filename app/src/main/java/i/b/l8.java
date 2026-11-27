package i.b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
abstract class l8 {
    private static final Pattern a = Pattern.compile("^/data/user/(\\d+)(?:/|$)");
    private static final Pattern b = Pattern.compile("/data/user/\\d+/[^/\"\\\\]+/img/");

    static boolean a(String str) {
        Matcher matcher = a.matcher(str);
        return matcher.find() && !"0".equals(matcher.group(1));
    }

    static String b(String str, String str2) {
        if (!a(str2)) {
            return str;
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        return b.matcher(str).replaceAll(Matcher.quoteReplacement(str2 + "/img/"));
    }
}
