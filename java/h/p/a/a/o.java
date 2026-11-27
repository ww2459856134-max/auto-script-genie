package h.p.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class o extends r {
    private int[] e;
    androidx.core.content.c.b f;
    float g;

    /* renamed from: h, reason: collision with root package name */
    androidx.core.content.c.b f1353h;

    /* renamed from: i, reason: collision with root package name */
    float f1354i;

    /* renamed from: j, reason: collision with root package name */
    float f1355j;

    /* renamed from: k, reason: collision with root package name */
    float f1356k;

    /* renamed from: l, reason: collision with root package name */
    float f1357l;

    /* renamed from: m, reason: collision with root package name */
    float f1358m;

    /* renamed from: n, reason: collision with root package name */
    Paint.Cap f1359n;

    /* renamed from: o, reason: collision with root package name */
    Paint.Join f1360o;
    float p;

    o() {
        this.g = 0.0f;
        this.f1354i = 1.0f;
        this.f1355j = 1.0f;
        this.f1356k = 0.0f;
        this.f1357l = 1.0f;
        this.f1358m = 0.0f;
        this.f1359n = Paint.Cap.BUTT;
        this.f1360o = Paint.Join.MITER;
        this.p = 4.0f;
    }

    private Paint.Cap e(int i2, Paint.Cap cap) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }

    private Paint.Join f(int i2, Paint.Join join) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
    }

    private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        this.e = null;
        if (androidx.core.content.c.r.r(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.b = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                this.a = h.e.d.e.d(string2);
            }
            this.f1353h = androidx.core.content.c.r.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.f1355j = androidx.core.content.c.r.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f1355j);
            this.f1359n = e(androidx.core.content.c.r.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f1359n);
            this.f1360o = f(androidx.core.content.c.r.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f1360o);
            this.p = androidx.core.content.c.r.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
            this.f = androidx.core.content.c.r.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.f1354i = androidx.core.content.c.r.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1354i);
            this.g = androidx.core.content.c.r.j(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
            this.f1357l = androidx.core.content.c.r.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f1357l);
            this.f1358m = androidx.core.content.c.r.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f1358m);
            this.f1356k = androidx.core.content.c.r.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f1356k);
            this.c = androidx.core.content.c.r.k(typedArray, xmlPullParser, "fillType", 13, this.c);
        }
    }

    @Override // h.p.a.a.q
    public boolean a() {
        return this.f1353h.i() || this.f.i();
    }

    @Override // h.p.a.a.q
    public boolean b(int[] iArr) {
        return this.f.j(iArr) | this.f1353h.j(iArr);
    }

    public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = androidx.core.content.c.r.s(resources, theme, attributeSet, a.c);
        h(typedArrayS, xmlPullParser, theme);
        typedArrayS.recycle();
    }

    float getFillAlpha() {
        return this.f1355j;
    }

    int getFillColor() {
        return this.f1353h.e();
    }

    float getStrokeAlpha() {
        return this.f1354i;
    }

    int getStrokeColor() {
        return this.f.e();
    }

    float getStrokeWidth() {
        return this.g;
    }

    float getTrimPathEnd() {
        return this.f1357l;
    }

    float getTrimPathOffset() {
        return this.f1358m;
    }

    float getTrimPathStart() {
        return this.f1356k;
    }

    void setFillAlpha(float f) {
        this.f1355j = f;
    }

    void setFillColor(int i2) {
        this.f1353h.k(i2);
    }

    void setStrokeAlpha(float f) {
        this.f1354i = f;
    }

    void setStrokeColor(int i2) {
        this.f.k(i2);
    }

    void setStrokeWidth(float f) {
        this.g = f;
    }

    void setTrimPathEnd(float f) {
        this.f1357l = f;
    }

    void setTrimPathOffset(float f) {
        this.f1358m = f;
    }

    void setTrimPathStart(float f) {
        this.f1356k = f;
    }

    o(o oVar) {
        super(oVar);
        this.g = 0.0f;
        this.f1354i = 1.0f;
        this.f1355j = 1.0f;
        this.f1356k = 0.0f;
        this.f1357l = 1.0f;
        this.f1358m = 0.0f;
        this.f1359n = Paint.Cap.BUTT;
        this.f1360o = Paint.Join.MITER;
        this.p = 4.0f;
        this.e = oVar.e;
        this.f = oVar.f;
        this.g = oVar.g;
        this.f1354i = oVar.f1354i;
        this.f1353h = oVar.f1353h;
        this.c = oVar.c;
        this.f1355j = oVar.f1355j;
        this.f1356k = oVar.f1356k;
        this.f1357l = oVar.f1357l;
        this.f1358m = oVar.f1358m;
        this.f1359n = oVar.f1359n;
        this.f1360o = oVar.f1360o;
        this.p = oVar.p;
    }
}
