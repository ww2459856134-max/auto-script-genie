package n.a.a.n.c;

/* loaded from: classes.dex */
final class w {
    private static final v[] c = new v[0];
    private int a;
    private v[] b = c;

    private static boolean b(f[] fVarArr, f fVar) {
        int iAbs = Math.abs(fVar.hashCode() % fVarArr.length);
        for (int i2 = iAbs; i2 < fVarArr.length; i2++) {
            f fVar2 = fVarArr[i2];
            if (fVar2 == fVar) {
                return false;
            }
            if (fVar2 == null) {
                fVarArr[i2] = fVar;
                return true;
            }
        }
        for (int i3 = 0; i3 < iAbs; i3++) {
            f fVar3 = fVarArr[i3];
            if (fVar3 == fVar) {
                return false;
            }
            if (fVar3 == null) {
                fVarArr[i3] = fVar;
                return true;
            }
        }
        throw new IllegalStateException("No empty space found");
    }

    public void a(f fVar) {
        int i2 = this.a * 3;
        v[] vVarArr = this.b;
        if (i2 >= vVarArr.length * 2) {
            v[] vVarArr2 = new v[((vVarArr.length * 3) / 2) + 4];
            for (int i3 = 0; i3 < vVarArr.length; i3++) {
                v vVar = this.b[i3];
                if (vVar != null) {
                    b(vVarArr2, vVar);
                }
            }
            this.b = vVarArr2;
        }
        if (b(this.b, fVar)) {
            this.a++;
        }
    }

    public boolean c(f fVar) {
        v[] vVarArr = this.b;
        if (this.a * 3 < vVarArr.length && vVarArr.length > 8) {
            v[] vVarArr2 = new v[vVarArr.length / 2];
            boolean z = false;
            for (int i2 = 0; i2 < vVarArr.length; i2++) {
                v vVar = this.b[i2];
                if (vVar != null) {
                    if (vVar == fVar) {
                        this.a--;
                        z = true;
                    } else {
                        b(vVarArr2, vVar);
                    }
                }
            }
            this.b = vVarArr2;
            return z;
        }
        int iAbs = Math.abs(fVar.hashCode() % vVarArr.length);
        for (int i3 = iAbs; i3 < vVarArr.length; i3++) {
            if (vVarArr[i3] == fVar) {
                vVarArr[i3] = null;
                this.a--;
                return true;
            }
        }
        for (int i4 = 0; i4 < iAbs; i4++) {
            if (vVarArr[i4] == fVar) {
                vVarArr[i4] = null;
                this.a--;
                return true;
            }
        }
        return false;
    }
}
