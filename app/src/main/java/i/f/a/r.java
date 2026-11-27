package i.f.a;

/* loaded from: classes.dex */
public class r {
    private final float a;
    private final float b;

    public r(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    private static float a(r rVar, r rVar2, r rVar3) {
        float f = rVar2.a;
        float f2 = rVar2.b;
        return ((rVar3.a - f) * (rVar.b - f2)) - ((rVar3.b - f2) * (rVar.a - f));
    }

    public static float b(r rVar, r rVar2) {
        return i.f.a.v.m.a.a(rVar.a, rVar.b, rVar2.a, rVar2.b);
    }

    public static void e(r[] rVarArr) {
        r rVar;
        r rVar2;
        r rVar3;
        float fB = b(rVarArr[0], rVarArr[1]);
        float fB2 = b(rVarArr[1], rVarArr[2]);
        float fB3 = b(rVarArr[0], rVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            rVar = rVarArr[0];
            rVar2 = rVarArr[1];
            rVar3 = rVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            rVar = rVarArr[2];
            rVar2 = rVarArr[0];
            rVar3 = rVarArr[1];
        } else {
            rVar = rVarArr[1];
            rVar2 = rVarArr[0];
            rVar3 = rVarArr[2];
        }
        if (a(rVar2, rVar, rVar3) < 0.0f) {
            r rVar4 = rVar3;
            rVar3 = rVar2;
            rVar2 = rVar4;
        }
        rVarArr[0] = rVar2;
        rVarArr[1] = rVar;
        rVarArr[2] = rVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a == rVar.a && this.b == rVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
