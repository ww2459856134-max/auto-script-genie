package i.e.a.j;

/* loaded from: classes.dex */
public final class s extends b {
    final int f;

    public s(String str, String str2, String str3, int i2, int i3) {
        super(str, str2, str3, i2);
        this.f = i3;
    }

    @Override // i.e.a.j.v
    public v g(q qVar) {
        s sVar = new s(this.a, this.b, this.c, this.e, this.f);
        sVar.d = qVar;
        return sVar;
    }

    @Override // i.e.a.j.v
    public final int h() {
        return this.f;
    }

    @Override // i.e.a.j.v
    public int m(int i2) {
        if (i2 == 0) {
            return this.f;
        }
        return 0;
    }

    @Override // i.e.a.j.v
    public int q() {
        return 1;
    }

    @Override // i.e.a.j.b
    public boolean t(int i2, int i3) {
        return i2 == this.f && i3 == 0;
    }

    @Override // i.e.a.j.b
    public boolean u(int[] iArr, int i2) {
        return i2 == 1 && iArr[0] == this.f;
    }

    @Override // i.e.a.j.b
    public boolean v(int i2, int i3, int i4) {
        return i2 == this.e && i3 == this.f && i4 == 0;
    }

    @Override // i.e.a.j.b
    public boolean w(int i2, int[] iArr, int i3) {
        return i2 == this.e && i3 == 1 && iArr[0] == this.f;
    }
}
