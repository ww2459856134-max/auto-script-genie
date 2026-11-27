package i.e.a.j;

/* loaded from: classes.dex */
final class d {
    final b a;
    final d b;

    d(b bVar, d dVar) {
        this.a = bVar;
        this.b = dVar;
    }

    public b a(int i2, int i3, int i4) {
        if (this.a.v(i2, i3, i4)) {
            return this.a;
        }
        for (d dVar = this.b; dVar != null; dVar = dVar.b) {
            b bVar = dVar.a;
            if (bVar.v(i2, i3, i4)) {
                return bVar;
            }
        }
        return null;
    }

    public b b(int i2, int[] iArr, int i3) {
        if (this.a.w(i2, iArr, i3)) {
            return this.a;
        }
        for (d dVar = this.b; dVar != null; dVar = dVar.b) {
            b bVar = dVar.a;
            if (bVar.w(i2, iArr, i3)) {
                return bVar;
            }
        }
        return null;
    }

    public int c() {
        int i2 = 1;
        for (d dVar = this.b; dVar != null; dVar = dVar.b) {
            i2++;
        }
        return i2;
    }
}
