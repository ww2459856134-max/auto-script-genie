package l.a.a.f;

/* loaded from: classes.dex */
public class a extends p {
    private int b;
    private l.a.a.f.t.b c;
    private String d;
    private l.a.a.f.t.a e;
    private l.a.a.f.t.d f;

    public a() {
        b(l.a.a.d.c.AES_EXTRA_DATA_RECORD);
        this.b = 7;
        this.c = l.a.a.f.t.b.TWO;
        this.d = "AE";
        this.e = l.a.a.f.t.a.KEY_STRENGTH_256;
        this.f = l.a.a.f.t.d.DEFLATE;
    }

    public l.a.a.f.t.a c() {
        return this.e;
    }

    public l.a.a.f.t.b d() {
        return this.c;
    }

    public l.a.a.f.t.d e() {
        return this.f;
    }

    public int f() {
        return this.b;
    }

    public String g() {
        return this.d;
    }

    public void h(l.a.a.f.t.a aVar) {
        this.e = aVar;
    }

    public void i(l.a.a.f.t.b bVar) {
        this.c = bVar;
    }

    public void j(l.a.a.f.t.d dVar) {
        this.f = dVar;
    }

    public void k(int i2) {
        this.b = i2;
    }

    public void l(String str) {
        this.d = str;
    }
}
