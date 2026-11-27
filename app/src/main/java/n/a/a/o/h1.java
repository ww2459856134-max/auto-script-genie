package n.a.a.o;

/* loaded from: classes.dex */
public abstract class h1 {
    private static boolean a;

    static {
        a = System.getenv("SOURCE_DATE_EPOCH") != null;
    }

    public static boolean a() {
        return a;
    }
}
