package k.y.d;

import k.y.c;

/* loaded from: classes.dex */
public class b extends c {
    private boolean b = false;

    @Override // k.y.c
    public void a(Object obj) {
        System.err.print("Error: ");
        System.err.println(obj);
    }

    @Override // k.y.c
    protected c c(Class cls) {
        return this;
    }

    @Override // k.y.c
    public void e(boolean z) {
        this.b = z;
    }

    @Override // k.y.c
    public void f(Object obj) {
        if (this.b) {
            return;
        }
        System.err.print("Warning:  ");
        System.err.println(obj);
    }

    @Override // k.y.c
    public void g(Object obj, Throwable th) {
        if (this.b) {
            return;
        }
        System.err.print("Warning:  ");
        System.err.println(obj);
        th.printStackTrace();
    }
}
