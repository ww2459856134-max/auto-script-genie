package h.p.a.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class p extends q {
    final Matrix a;
    final ArrayList<q> b;
    float c;
    private float d;
    private float e;
    private float f;
    private float g;

    /* renamed from: h, reason: collision with root package name */
    private float f1361h;

    /* renamed from: i, reason: collision with root package name */
    private float f1362i;

    /* renamed from: j, reason: collision with root package name */
    final Matrix f1363j;

    /* renamed from: k, reason: collision with root package name */
    int f1364k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f1365l;

    /* renamed from: m, reason: collision with root package name */
    private String f1366m;

    public p(p pVar, h.d.b<String, Object> bVar) {
        r nVar;
        super();
        this.a = new Matrix();
        this.b = new ArrayList<>();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.f1361h = 0.0f;
        this.f1362i = 0.0f;
        Matrix matrix = new Matrix();
        this.f1363j = matrix;
        this.f1366m = null;
        this.c = pVar.c;
        this.d = pVar.d;
        this.e = pVar.e;
        this.f = pVar.f;
        this.g = pVar.g;
        this.f1361h = pVar.f1361h;
        this.f1362i = pVar.f1362i;
        this.f1365l = pVar.f1365l;
        String str = pVar.f1366m;
        this.f1366m = str;
        this.f1364k = pVar.f1364k;
        if (str != null) {
            bVar.put(str, this);
        }
        matrix.set(pVar.f1363j);
        ArrayList<q> arrayList = pVar.b;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            q qVar = arrayList.get(i2);
            if (qVar instanceof p) {
                this.b.add(new p((p) qVar, bVar));
            } else {
                if (qVar instanceof o) {
                    nVar = new o((o) qVar);
                } else {
                    if (!(qVar instanceof n)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    nVar = new n((n) qVar);
                }
                this.b.add(nVar);
                String str2 = nVar.b;
                if (str2 != null) {
                    bVar.put(str2, nVar);
                }
            }
        }
    }

    private void d() {
        this.f1363j.reset();
        this.f1363j.postTranslate(-this.d, -this.e);
        this.f1363j.postScale(this.f, this.g);
        this.f1363j.postRotate(this.c, 0.0f, 0.0f);
        this.f1363j.postTranslate(this.f1361h + this.d, this.f1362i + this.e);
    }

    private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f1365l = null;
        this.c = androidx.core.content.c.r.j(typedArray, xmlPullParser, "rotation", 5, this.c);
        this.d = typedArray.getFloat(1, this.d);
        this.e = typedArray.getFloat(2, this.e);
        this.f = androidx.core.content.c.r.j(typedArray, xmlPullParser, "scaleX", 3, this.f);
        this.g = androidx.core.content.c.r.j(typedArray, xmlPullParser, "scaleY", 4, this.g);
        this.f1361h = androidx.core.content.c.r.j(typedArray, xmlPullParser, "translateX", 6, this.f1361h);
        this.f1362i = androidx.core.content.c.r.j(typedArray, xmlPullParser, "translateY", 7, this.f1362i);
        String string = typedArray.getString(0);
        if (string != null) {
            this.f1366m = string;
        }
        d();
    }

    @Override // h.p.a.a.q
    public boolean a() {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (this.b.get(i2).a()) {
                return true;
            }
        }
        return false;
    }

    @Override // h.p.a.a.q
    public boolean b(int[] iArr) {
        boolean zB = false;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            zB |= this.b.get(i2).b(iArr);
        }
        return zB;
    }

    public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = androidx.core.content.c.r.s(resources, theme, attributeSet, a.b);
        e(typedArrayS, xmlPullParser);
        typedArrayS.recycle();
    }

    public String getGroupName() {
        return this.f1366m;
    }

    public Matrix getLocalMatrix() {
        return this.f1363j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.f1361h;
    }

    public float getTranslateY() {
        return this.f1362i;
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            d();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            d();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            d();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            d();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            d();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f1361h) {
            this.f1361h = f;
            d();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.f1362i) {
            this.f1362i = f;
            d();
        }
    }

    public p() {
        super();
        this.a = new Matrix();
        this.b = new ArrayList<>();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.f1361h = 0.0f;
        this.f1362i = 0.0f;
        this.f1363j = new Matrix();
        this.f1366m = null;
    }
}
