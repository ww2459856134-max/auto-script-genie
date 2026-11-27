package k;

/* loaded from: classes.dex */
public final class f {
    public static final f b = new f("Empty");
    public static final f c = new f("Label");
    public static final f d = new f("Number");
    public static final f e = new f("Boolean");
    public static final f f = new f("Error");
    public static final f g = new f("Numerical Formula");

    /* renamed from: h, reason: collision with root package name */
    public static final f f1990h = new f("Date Formula");

    /* renamed from: i, reason: collision with root package name */
    public static final f f1991i = new f("String Formula");

    /* renamed from: j, reason: collision with root package name */
    public static final f f1992j = new f("Boolean Formula");

    /* renamed from: k, reason: collision with root package name */
    public static final f f1993k = new f("Formula Error");

    /* renamed from: l, reason: collision with root package name */
    public static final f f1994l = new f("Date");
    private String a;

    private f(String str) {
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
