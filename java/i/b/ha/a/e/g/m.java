package i.b.ha.a.e.g;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class m {
    public static void a(Object obj) throws i.b.ha.a.e.b.l {
        if (obj == null) {
            throw new i.b.ha.a.e.b.l();
        }
    }

    public static int b(double d) {
        return new Double(d).hashCode();
    }

    public static int c(double[] dArr) {
        return Arrays.hashCode(dArr);
    }
}
