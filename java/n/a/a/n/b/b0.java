package n.a.a.n.b;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.Locale;
import n.a.a.o.a1;

/* loaded from: classes.dex */
public abstract class b0 {
    protected final String a;
    protected final Locale b;

    public b0(String str) {
        this(a1.e(), str);
    }

    static String c(String str) {
        return Chars.DQUOTE + str + Chars.DQUOTE;
    }

    public String a(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        b(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public abstract void b(StringBuffer stringBuffer, Object obj);

    public String d(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        e(stringBuffer, obj);
        return stringBuffer.toString();
    }

    public abstract void e(StringBuffer stringBuffer, Object obj);

    public b0(Locale locale, String str) {
        this.b = locale;
        this.a = str;
    }
}
