package i.e.a.j;

/* loaded from: classes.dex */
public final class x extends b {
    final int[] f;
    final int g;

    x(String str, String str2, String str3, int i2, int[] iArr, int i3) {
        super(str, str2, str3, i2);
        this.f = iArr;
        this.g = i3;
    }

    @Override // i.e.a.j.v
    public v g(q qVar) {
        x xVar = new x(this.a, this.b, this.c, this.e, this.f, this.g);
        xVar.d = qVar;
        return xVar;
    }

    @Override // i.e.a.j.v
    public int h() {
        return this.f[this.g - 1];
    }

    @Override // i.e.a.j.v
    public int m(int i2) {
        if (i2 < this.g) {
            return this.f[i2];
        }
        return 0;
    }

    @Override // i.e.a.j.v
    public int q() {
        return this.g;
    }

    @Override // i.e.a.j.b
    public boolean t(int i2, int i3) {
        int i4 = this.g;
        if (i4 >= 3) {
            return false;
        }
        if (i4 == 1) {
            return this.f[0] == i2 && i3 == 0;
        }
        int[] iArr = this.f;
        return iArr[0] == i2 && iArr[1] == i3;
    }

    @Override // i.e.a.j.b
    public boolean u(int[] iArr, int i2) {
        if (i2 != this.g) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] != this.f[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // i.e.a.j.b
    public boolean v(int i2, int i3, int i4) {
        int i5;
        if (i2 != this.e || (i5 = this.g) >= 3) {
            return false;
        }
        if (i5 == 1) {
            return this.f[0] == i3 && i4 == 0;
        }
        int[] iArr = this.f;
        return iArr[0] == i3 && iArr[1] == i4;
    }

    @Override // i.e.a.j.b
    public boolean w(int i2, int[] iArr, int i3) {
        if (i2 != this.e || i3 != this.g) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (iArr[i4] != this.f[i4]) {
                return false;
            }
        }
        return true;
    }
}
