package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* loaded from: classes.dex */
class c implements g {
    c() {
    }

    private h p(f fVar) {
        return (h) fVar.e();
    }

    @Override // androidx.cardview.widget.g
    public float a(f fVar) {
        return p(fVar).d();
    }

    @Override // androidx.cardview.widget.g
    public float b(f fVar) {
        return p(fVar).c();
    }

    @Override // androidx.cardview.widget.g
    public float c(f fVar) {
        return a(fVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.g
    public float d(f fVar) {
        return fVar.g().getElevation();
    }

    @Override // androidx.cardview.widget.g
    public void e(f fVar) {
        if (!fVar.a()) {
            fVar.b(0, 0, 0, 0);
            return;
        }
        float fB = b(fVar);
        float fA = a(fVar);
        int iCeil = (int) Math.ceil(j.c(fB, fA, fVar.f()));
        int iCeil2 = (int) Math.ceil(j.d(fB, fA, fVar.f()));
        fVar.b(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.widget.g
    public float f(f fVar) {
        return a(fVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.g
    public void g(f fVar, float f) {
        p(fVar).g(f, fVar.a(), fVar.f());
        e(fVar);
    }

    @Override // androidx.cardview.widget.g
    public void h(f fVar, float f) {
        p(fVar).h(f);
    }

    @Override // androidx.cardview.widget.g
    public void i(f fVar, float f) {
        fVar.g().setElevation(f);
    }

    @Override // androidx.cardview.widget.g
    public ColorStateList j(f fVar) {
        return p(fVar).b();
    }

    @Override // androidx.cardview.widget.g
    public void k(f fVar) {
        g(fVar, b(fVar));
    }

    @Override // androidx.cardview.widget.g
    public void l(f fVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        fVar.d(new h(colorStateList, f));
        View viewG = fVar.g();
        viewG.setClipToOutline(true);
        viewG.setElevation(f2);
        g(fVar, f3);
    }

    @Override // androidx.cardview.widget.g
    public void m(f fVar) {
        g(fVar, b(fVar));
    }

    @Override // androidx.cardview.widget.g
    public void n() {
    }

    @Override // androidx.cardview.widget.g
    public void o(f fVar, ColorStateList colorStateList) {
        p(fVar).f(colorStateList);
    }
}
