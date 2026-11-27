package androidx.lifecycle;

/* loaded from: classes.dex */
public class u {
    private final a a;
    private final v b;

    public interface a {
        <T extends t> T a(Class<T> cls);
    }

    public u(v vVar, a aVar) {
        this.a = aVar;
        this.b = vVar;
    }

    public <T extends t> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends t> T b(String str, Class<T> cls) {
        T t = (T) this.b.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.a.a(cls);
        this.b.d(str, t2);
        return t2;
    }
}
