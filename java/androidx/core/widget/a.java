package androidx.core.widget;

import android.view.animation.AnimationUtils;

/* loaded from: classes.dex */
class a {
    private int a;
    private int b;
    private float c;
    private float d;

    /* renamed from: j, reason: collision with root package name */
    private float f218j;

    /* renamed from: k, reason: collision with root package name */
    private int f219k;
    private long e = Long.MIN_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private long f217i = -1;
    private long f = 0;
    private int g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f216h = 0;

    a() {
    }

    private float e(long j2) {
        if (j2 < this.e) {
            return 0.0f;
        }
        long j3 = this.f217i;
        if (j3 < 0 || j2 < j3) {
            return c.e((j2 - r0) / this.a, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.f218j;
        return (1.0f - f) + (f * c.e((j2 - j3) / this.f219k, 0.0f, 1.0f));
    }

    private float g(float f) {
        return ((-4.0f) * f * f) + (f * 4.0f);
    }

    public void a() {
        if (this.f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float fG = g(e(jCurrentAnimationTimeMillis));
        long j2 = jCurrentAnimationTimeMillis - this.f;
        this.f = jCurrentAnimationTimeMillis;
        float f = j2 * fG;
        this.g = (int) (this.c * f);
        this.f216h = (int) (f * this.d);
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f216h;
    }

    public int d() {
        float f = this.c;
        return (int) (f / Math.abs(f));
    }

    public int f() {
        float f = this.d;
        return (int) (f / Math.abs(f));
    }

    public boolean h() {
        return this.f217i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f217i + ((long) this.f219k);
    }

    public void i() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f219k = c.f((int) (jCurrentAnimationTimeMillis - this.e), 0, this.b);
        this.f218j = e(jCurrentAnimationTimeMillis);
        this.f217i = jCurrentAnimationTimeMillis;
    }

    public void j(int i2) {
        this.b = i2;
    }

    public void k(int i2) {
        this.a = i2;
    }

    public void l(float f, float f2) {
        this.c = f;
        this.d = f2;
    }

    public void m() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.e = jCurrentAnimationTimeMillis;
        this.f217i = -1L;
        this.f = jCurrentAnimationTimeMillis;
        this.f218j = 0.5f;
        this.g = 0;
        this.f216h = 0;
    }
}
