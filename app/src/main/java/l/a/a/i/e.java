package l.a.a.i;

import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class e {
    public static final String a = File.separator;
    public static final Charset b;
    public static final Charset c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        b = charsetForName;
        c = charsetForName;
    }
}
