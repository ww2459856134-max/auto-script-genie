package i.b.ha.a.b.d.c;

import java.util.zip.ZipException;

/* loaded from: classes.dex */
public class h1 extends ZipException {
    public h1(String str) {
        super(str);
    }

    static String a(o1 o1Var) {
        return o1Var.getName() + "'s size exceeds the limit of 4GByte.";
    }
}
