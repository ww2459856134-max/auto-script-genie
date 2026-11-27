package androidx.appcompat.widget;

/* loaded from: classes.dex */
class l1 {
    private int a = 0;
    private int b = 0;
    private int c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f169h = false;

    l1() {
    }

    public int a() {
        return this.g ? this.a : this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.g ? this.b : this.a;
    }

    public void e(int i2, int i3) {
        this.f169h = false;
        if (i2 != Integer.MIN_VALUE) {
            this.e = i2;
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f = i3;
            this.b = i3;
        }
    }

    public void f(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.f169h) {
            this.a = this.e;
            this.b = this.f;
            return;
        }
        if (z) {
            int i2 = this.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.e;
            }
            this.a = i2;
            int i3 = this.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f;
            }
            this.b = i3;
            return;
        }
        int i4 = this.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.e;
        }
        this.a = i4;
        int i5 = this.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f;
        }
        this.b = i5;
    }

    public void g(int i2, int i3) {
        this.c = i2;
        this.d = i3;
        this.f169h = true;
        if (this.g) {
            if (i3 != Integer.MIN_VALUE) {
                this.a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.b = i3;
        }
    }
}
