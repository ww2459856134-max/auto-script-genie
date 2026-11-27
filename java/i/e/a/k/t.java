package i.e.a.k;

/* loaded from: classes.dex */
final class t {
    final r a;
    final t b;

    t(r rVar, t tVar) {
        this.a = rVar;
        this.b = tVar;
    }

    public r a(String str) {
        if (this.a.e(str)) {
            return this.a;
        }
        for (t tVar = this.b; tVar != null; tVar = tVar.b) {
            r rVar = tVar.a;
            if (rVar.e(str)) {
                return rVar;
            }
        }
        return null;
    }

    public r b(String str, String str2) {
        if (this.a.f(str, str2)) {
            return this.a;
        }
        for (t tVar = this.b; tVar != null; tVar = tVar.b) {
            r rVar = tVar.a;
            if (rVar.f(str, str2)) {
                return rVar;
            }
        }
        return null;
    }

    public int c() {
        int i2 = 1;
        for (t tVar = this.b; tVar != null; tVar = tVar.b) {
            i2++;
        }
        return i2;
    }
}
