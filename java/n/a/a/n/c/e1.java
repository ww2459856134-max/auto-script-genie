package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.IOException;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class e1 {
    private static boolean a(String str, String str2) {
        return c1.i(str) | c1.i(str2);
    }

    public static String b(StringBuilder sb, int i2, String str, String str2) {
        return a(str, str2) ? c(sb, i2, str, str2) : d(sb, i2, str, str2);
    }

    private static String c(StringBuilder sb, int i2, String str, String str2) throws IOException {
        sb.append(Chars.QUOTE);
        if (i2 >= 0) {
            sb.append('[');
            sb.append(i2);
            sb.append(']');
        }
        c1.a(sb, str);
        if (str2 != null) {
            sb.append(NameUtil.COLON);
            c1.a(sb, str2);
        }
        sb.append(Chars.QUOTE);
        return sb.toString();
    }

    private static String d(StringBuilder sb, int i2, String str, String str2) {
        if (i2 >= 0) {
            sb.append('[');
            sb.append(i2);
            sb.append(']');
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(NameUtil.COLON);
            sb.append(str2);
        }
        return sb.toString();
    }
}
