package h.e.i;

/* loaded from: classes.dex */
public class g<T> extends f<T> {
    private final Object c;

    public g(int i2) {
        super(i2);
        this.c = new Object();
    }

    @Override // h.e.i.f, h.e.i.e
    public T a() {
        T t;
        synchronized (this.c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // h.e.i.f, h.e.i.e
    public boolean b(T t) {
        boolean zB;
        synchronized (this.c) {
            zB = super.b(t);
        }
        return zB;
    }
}
