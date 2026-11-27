package com.airbnb.lottie.v0;

/* loaded from: classes.dex */
public class c {
    public final String a;
    public final String b;
    public final float c;
    public final b d;
    public final int e;
    public final float f;
    public final float g;

    /* renamed from: h, reason: collision with root package name */
    public final int f514h;

    /* renamed from: i, reason: collision with root package name */
    public final int f515i;

    /* renamed from: j, reason: collision with root package name */
    public final float f516j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f517k;

    public c(String str, String str2, float f, b bVar, int i2, float f2, float f3, int i3, int i4, float f4, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = bVar;
        this.e = i2;
        this.f = f2;
        this.g = f3;
        this.f514h = i3;
        this.f515i = i4;
        this.f516j = f4;
        this.f517k = z;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f514h;
    }
}
