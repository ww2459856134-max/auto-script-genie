package n.a.a.n.c;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class v extends f {
    private f[] d;
    private j0 e;

    private void f(f[] fVarArr) {
        Set setEmptySet;
        f[] fVarArr2 = this.d;
        int length = fVarArr.length;
        for (f fVar : fVarArr) {
            fVar.a(this);
        }
        if (fVarArr2 != null && fVarArr2.length >= 1) {
            if (length < 1) {
                setEmptySet = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet((length * 3) / 2);
                hashSet.addAll(Arrays.asList(fVarArr).subList(0, length));
                setEmptySet = hashSet;
            }
            for (f fVar2 : fVarArr2) {
                if (!setEmptySet.contains(fVar2)) {
                    fVar2.c(this);
                }
            }
        }
    }

    public boolean g() {
        f[] fVarArr = this.d;
        if (fVarArr != null && fVarArr.length > 0) {
            return true;
        }
        j0 j0Var = this.e;
        return (j0Var == null || j0Var.c()) ? false : true;
    }

    public void h(f[] fVarArr) {
        if (fVarArr == null) {
            this.d = null;
            f(f.c);
        } else {
            f[] fVarArr2 = (f[]) fVarArr.clone();
            this.d = fVarArr2;
            f(fVarArr2);
        }
    }

    public void i(n.a.a.n.c.r1.w0 w0Var, f[] fVarArr, j0 j0Var) {
        e(w0Var);
        h(fVarArr);
        this.e = j0Var;
    }
}
