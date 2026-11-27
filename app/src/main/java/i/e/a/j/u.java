package i.e.a.j;

/* loaded from: classes.dex */
public final class u extends b {
    final int f;
    final int g;

    /* renamed from: h, reason: collision with root package name */
    final int f1603h;

    u(String str, String str2, String str3, int i2, int[] iArr) {
        super(str, str2, str3, i2);
        this.f = iArr[0];
        this.g = iArr[1];
        this.f1603h = iArr[2];
    }

    @Override // i.e.a.j.v
    public v g(q qVar) {
        u uVar = new u(this.a, this.b, this.c, this.e, this.f, this.g, this.f1603h);
        uVar.d = qVar;
        return uVar;
    }

    @Override // i.e.a.j.v
    public int h() {
        return this.f1603h;
    }

    @Override // i.e.a.j.v
    public int m(int i2) {
        return i2 < 2 ? i2 == 0 ? this.f : this.g : this.f1603h;
    }

    @Override // i.e.a.j.v
    public int q() {
        return 3;
    }

    @Override // i.e.a.j.b
    public boolean t(int i2, int i3) {
        return false;
    }

    @Override // i.e.a.j.b
    public boolean u(int[] iArr, int i2) {
        return i2 == 3 && iArr[0] == this.f && iArr[1] == this.g && iArr[2] == this.f1603h;
    }

    @Override // i.e.a.j.b
    public boolean v(int i2, int i3, int i4) {
        return false;
    }

    @Override // i.e.a.j.b
    public boolean w(int i2, int[] iArr, int i3) {
        return i2 == this.e && i3 == 3 && iArr[0] == this.f && iArr[1] == this.g && iArr[2] == this.f1603h;
    }

    public u(String str, String str2, String str3, int i2, int i3, int i4, int i5) {
        super(str, str2, str3, i2);
        this.f = i3;
        this.g = i4;
        this.f1603h = i5;
    }
}
