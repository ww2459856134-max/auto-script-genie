package i.e.a.j;

/* loaded from: classes.dex */
public final class t extends b {
    final int f;
    final int g;

    public t(String str, String str2, String str3, int i2, int i3, int i4) {
        super(str, str2, str3, i2);
        this.f = i3;
        this.g = i4;
    }

    @Override // i.e.a.j.v
    public v g(q qVar) {
        t tVar = new t(this.a, this.b, this.c, this.e, this.f, this.g);
        tVar.d = qVar;
        return tVar;
    }

    @Override // i.e.a.j.v
    public int h() {
        return this.g;
    }

    @Override // i.e.a.j.v
    public int m(int i2) {
        return i2 == 0 ? this.f : this.g;
    }

    @Override // i.e.a.j.v
    public int q() {
        return 2;
    }

    @Override // i.e.a.j.b
    public boolean t(int i2, int i3) {
        return i2 == this.f && i3 == this.g;
    }

    @Override // i.e.a.j.b
    public boolean u(int[] iArr, int i2) {
        return i2 == 2 && iArr[0] == this.f && iArr[1] == this.g;
    }

    @Override // i.e.a.j.b
    public boolean v(int i2, int i3, int i4) {
        return i2 == this.e && i3 == this.f && i4 == this.g;
    }

    @Override // i.e.a.j.b
    public boolean w(int i2, int[] iArr, int i3) {
        return i2 == this.e && i3 == 2 && iArr[0] == this.f && iArr[1] == this.g;
    }
}
