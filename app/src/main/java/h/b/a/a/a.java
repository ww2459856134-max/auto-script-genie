package h.b.a.a;

/* loaded from: classes.dex */
public class a extends d {
    private static volatile a c;
    private d a;
    private d b;

    private a() {
        c cVar = new c();
        this.b = cVar;
        this.a = cVar;
    }

    public static a b() {
        if (c != null) {
            return c;
        }
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
        }
        return c;
    }

    @Override // h.b.a.a.d
    public boolean a() {
        return this.a.a();
    }
}
