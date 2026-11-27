package i.e.a.j;

/* loaded from: classes.dex */
public final class r {
    private final q a;
    private final String b;
    private final r c;
    private final int d;

    public r(q qVar, String str, r rVar, int i2) {
        this.a = qVar;
        this.c = rVar;
        this.d = i2;
        this.b = qVar.b;
        qVar.b = str;
    }

    public boolean a(String str, int i2) {
        if (this.d < i2) {
            return false;
        }
        if (str == this.a.a) {
            return true;
        }
        for (r rVar = this.c; rVar != null && rVar.d >= i2; rVar = rVar.c) {
            if (str == rVar.a.a) {
                return true;
            }
        }
        return false;
    }

    public int b(int i2) {
        if (this.d != i2) {
            return 0;
        }
        int i3 = 1;
        for (r rVar = this.c; rVar != null && rVar.d == i2; rVar = rVar.c) {
            i3++;
        }
        return i3;
    }

    public q c() {
        return this.a;
    }

    public String d() {
        return this.a.b;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.a.a;
    }

    public r g() {
        return this.c;
    }

    public boolean h(String str) {
        return str.equals(this.a.b);
    }

    public boolean i(String str) {
        return str.equals(this.a.a);
    }

    public r j() {
        this.a.b = this.b;
        return this.c;
    }

    public String toString() {
        return "[NS-DECL, prefix = <" + this.a.a + ">, current URI <" + this.a.b + ">, level " + this.d + ", prev URI <" + this.b + ">]";
    }
}
