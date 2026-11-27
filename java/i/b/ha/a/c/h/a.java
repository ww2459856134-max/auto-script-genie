package i.b.ha.a.c.h;

import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

/* loaded from: classes.dex */
public abstract class a {
    public static final OpenOption[] a;

    static {
        StandardOpenOption standardOpenOption = StandardOpenOption.CREATE;
        StandardOpenOption standardOpenOption2 = StandardOpenOption.TRUNCATE_EXISTING;
        StandardOpenOption standardOpenOption3 = StandardOpenOption.CREATE;
        StandardOpenOption standardOpenOption4 = StandardOpenOption.APPEND;
        LinkOption linkOption = LinkOption.NOFOLLOW_LINKS;
        a = new OpenOption[0];
    }
}
