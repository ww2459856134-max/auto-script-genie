package h.p.a.a;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
class h implements TypeEvaluator<h.e.d.d[]> {
    private h.e.d.d[] a;

    h() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h.e.d.d[] evaluate(float f, h.e.d.d[] dVarArr, h.e.d.d[] dVarArr2) {
        if (!h.e.d.e.b(dVarArr, dVarArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!h.e.d.e.b(this.a, dVarArr)) {
            this.a = h.e.d.e.f(dVarArr);
        }
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            this.a[i2].d(dVarArr[i2], dVarArr2[i2], f);
        }
        return this.a;
    }
}
