package h.a.l.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* loaded from: classes.dex */
class c extends o {
    h.d.f<Long> K;
    h.d.j<Integer> L;

    c(c cVar, h hVar, Resources resources) {
        super(cVar, hVar, resources);
        if (cVar != null) {
            this.K = cVar.K;
            this.L = cVar.L;
        } else {
            this.K = new h.d.f<>();
            this.L = new h.d.j<>();
        }
    }

    private static long D(int i2, int i3) {
        return i3 | (i2 << 32);
    }

    int B(int[] iArr, Drawable drawable, int i2) {
        int iZ = super.z(iArr, drawable);
        this.L.h(iZ, Integer.valueOf(i2));
        return iZ;
    }

    int C(int i2, int i3, Drawable drawable, boolean z) {
        int iA = super.a(drawable);
        long jD = D(i2, i3);
        long j2 = z ? 8589934592L : 0L;
        long j3 = iA;
        this.K.a(jD, Long.valueOf(j3 | j2));
        if (z) {
            this.K.a(D(i3, i2), Long.valueOf(4294967296L | j3 | j2));
        }
        return iA;
    }

    int E(int i2) {
        if (i2 < 0) {
            return 0;
        }
        return this.L.f(i2, 0).intValue();
    }

    int F(int[] iArr) {
        int iA = super.A(iArr);
        return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
    }

    int G(int i2, int i3) {
        return (int) this.K.g(D(i2, i3), -1L).longValue();
    }

    boolean H(int i2, int i3) {
        return (this.K.g(D(i2, i3), -1L).longValue() & 4294967296L) != 0;
    }

    boolean I(int i2, int i3) {
        return (this.K.g(D(i2, i3), -1L).longValue() & 8589934592L) != 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new h(this, null);
    }

    @Override // h.a.l.a.l
    void r() {
        this.K = this.K.clone();
        this.L = this.L.clone();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new h(this, resources);
    }
}
