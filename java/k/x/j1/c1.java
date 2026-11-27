package k.x.j1;

/* loaded from: classes.dex */
class c1 extends e1 {
    private y e;
    private String f;

    static {
        k.y.c.b(c1.class);
    }

    c1(String str) {
        this.f = str.substring(0, str.length() - 1);
    }

    y j(k.w wVar) {
        if (this.e == null) {
            this.e = y.c(this.f, wVar);
        }
        return this.e;
    }
}
