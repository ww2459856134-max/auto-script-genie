package i.f.a.z.d;

import java.util.Formatter;

/* loaded from: classes.dex */
class i {
    private final c a;
    private final d[] b;

    i(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.e() - cVar.g()) + 1];
    }

    final c a() {
        return this.a;
    }

    final d b(int i2) {
        return this.b[e(i2)];
    }

    final d c(int i2) {
        d dVar;
        d dVar2;
        d dVarB = b(i2);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int iE = e(i2) - i3;
            if (iE >= 0 && (dVar2 = this.b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i2) + i3;
            d[] dVarArr = this.b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.b;
    }

    final int e(int i2) {
        return i2 - this.a.g();
    }

    final void f(int i2, d dVar) {
        this.b[e(i2)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i2++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
