package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes.dex */
class e implements g {
    final RectF a = new RectF();

    e() {
    }

    private j p(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new j(context.getResources(), colorStateList, f, f2, f3);
    }

    private j q(f fVar) {
        return (j) fVar.e();
    }

    @Override // androidx.cardview.widget.g
    public float a(f fVar) {
        return q(fVar).g();
    }

    @Override // androidx.cardview.widget.g
    public float b(f fVar) {
        return q(fVar).i();
    }

    @Override // androidx.cardview.widget.g
    public float c(f fVar) {
        return q(fVar).j();
    }

    @Override // androidx.cardview.widget.g
    public float d(f fVar) {
        return q(fVar).l();
    }

    @Override // androidx.cardview.widget.g
    public void e(f fVar) {
        Rect rect = new Rect();
        q(fVar).h(rect);
        fVar.c((int) Math.ceil(f(fVar)), (int) Math.ceil(c(fVar)));
        fVar.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.g
    public float f(f fVar) {
        return q(fVar).k();
    }

    @Override // androidx.cardview.widget.g
    public void g(f fVar, float f) {
        q(fVar).q(f);
        e(fVar);
    }

    @Override // androidx.cardview.widget.g
    public void h(f fVar, float f) {
        q(fVar).p(f);
        e(fVar);
    }

    @Override // androidx.cardview.widget.g
    public void i(f fVar, float f) {
        q(fVar).r(f);
    }

    @Override // androidx.cardview.widget.g
    public ColorStateList j(f fVar) {
        return q(fVar).f();
    }

    @Override // androidx.cardview.widget.g
    public void k(f fVar) {
        q(fVar).m(fVar.f());
        e(fVar);
    }

    @Override // androidx.cardview.widget.g
    public void l(f fVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        j jVarP = p(context, colorStateList, f, f2, f3);
        jVarP.m(fVar.f());
        fVar.d(jVarP);
        e(fVar);
    }

    @Override // androidx.cardview.widget.g
    public void m(f fVar) {
    }

    @Override // androidx.cardview.widget.g
    public void n() {
        j.r = new d(this);
    }

    @Override // androidx.cardview.widget.g
    public void o(f fVar, ColorStateList colorStateList) {
        q(fVar).o(colorStateList);
    }
}
