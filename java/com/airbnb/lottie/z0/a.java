package com.airbnb.lottie.z0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.e;

/* loaded from: classes.dex */
public class a<T> {
    private final e a;
    public final T b;
    public T c;
    public final Interpolator d;
    public final float e;
    public Float f;
    private float g;

    /* renamed from: h, reason: collision with root package name */
    private float f565h;

    /* renamed from: i, reason: collision with root package name */
    private int f566i;

    /* renamed from: j, reason: collision with root package name */
    private int f567j;

    /* renamed from: k, reason: collision with root package name */
    private float f568k;

    /* renamed from: l, reason: collision with root package name */
    private float f569l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f570m;

    /* renamed from: n, reason: collision with root package name */
    public PointF f571n;

    public a(e eVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.g = -3987645.8f;
        this.f565h = -3987645.8f;
        this.f566i = 784923401;
        this.f567j = 784923401;
        this.f568k = Float.MIN_VALUE;
        this.f569l = Float.MIN_VALUE;
        this.f570m = null;
        this.f571n = null;
        this.a = eVar;
        this.b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = f;
        this.f = f2;
    }

    public boolean a(float f) {
        return f >= e() && f < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.f569l == Float.MIN_VALUE) {
            if (this.f == null) {
                this.f569l = 1.0f;
            } else {
                this.f569l = e() + ((this.f.floatValue() - this.e) / this.a.e());
            }
        }
        return this.f569l;
    }

    public float c() {
        if (this.f565h == -3987645.8f) {
            this.f565h = ((Float) this.c).floatValue();
        }
        return this.f565h;
    }

    public int d() {
        if (this.f567j == 784923401) {
            this.f567j = ((Integer) this.c).intValue();
        }
        return this.f567j;
    }

    public float e() {
        e eVar = this.a;
        if (eVar == null) {
            return 0.0f;
        }
        if (this.f568k == Float.MIN_VALUE) {
            this.f568k = (this.e - eVar.o()) / this.a.e();
        }
        return this.f568k;
    }

    public float f() {
        if (this.g == -3987645.8f) {
            this.g = ((Float) this.b).floatValue();
        }
        return this.g;
    }

    public int g() {
        if (this.f566i == 784923401) {
            this.f566i = ((Integer) this.b).intValue();
        }
        return this.f566i;
    }

    public boolean h() {
        return this.d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.b + ", endValue=" + this.c + ", startFrame=" + this.e + ", endFrame=" + this.f + ", interpolator=" + this.d + '}';
    }

    public a(T t) {
        this.g = -3987645.8f;
        this.f565h = -3987645.8f;
        this.f566i = 784923401;
        this.f567j = 784923401;
        this.f568k = Float.MIN_VALUE;
        this.f569l = Float.MIN_VALUE;
        this.f570m = null;
        this.f571n = null;
        this.a = null;
        this.b = t;
        this.c = t;
        this.d = null;
        this.e = Float.MIN_VALUE;
        this.f = Float.valueOf(Float.MAX_VALUE);
    }
}
