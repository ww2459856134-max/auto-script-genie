package n.b.a.n;

import com.auto.exceldeps.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes2.dex */
public abstract class b {
    public static final a a;

    static {
        a aVar = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, Chars.EQ, 76);
        a = aVar;
        new a(aVar, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        new a(aVar, "PEM", true, Chars.EQ, 64);
        StringBuffer stringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuffer.setCharAt(stringBuffer.indexOf("+"), NameUtil.HYPHEN);
        stringBuffer.setCharAt(stringBuffer.indexOf("/"), NameUtil.USCORE);
        new a("MODIFIED-FOR-URL", stringBuffer.toString(), false, (char) 0, Integer.MAX_VALUE);
    }

    public static a a() {
        return a;
    }
}
