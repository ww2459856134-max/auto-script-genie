package h.a.l.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

/* loaded from: classes.dex */
abstract class o extends l {
    int[][] J;

    o(o oVar, p pVar, Resources resources) {
        super(oVar, pVar, resources);
        if (oVar != null) {
            this.J = oVar.J;
        } else {
            this.J = new int[f()][];
        }
    }

    int A(int[] iArr) {
        int[][] iArr2 = this.J;
        int iH = h();
        for (int i2 = 0; i2 < iH; i2++) {
            if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // h.a.l.a.l
    public void o(int i2, int i3) {
        super.o(i2, i3);
        int[][] iArr = new int[i3][];
        System.arraycopy(this.J, 0, iArr, 0, i2);
        this.J = iArr;
    }

    int z(int[] iArr, Drawable drawable) {
        int iA = a(drawable);
        this.J[iA] = iArr;
        return iA;
    }
}
