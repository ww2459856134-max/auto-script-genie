package i.f.a.z.d;

import i.f.a.r;

/* loaded from: classes.dex */
final class c {
    private final i.f.a.v.b a;
    private final r b;
    private final r c;
    private final r d;
    private final r e;
    private final int f;
    private final int g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1722h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1723i;

    c(i.f.a.v.b bVar, r rVar, r rVar2, r rVar3, r rVar4) throws i.f.a.k {
        boolean z = rVar == null || rVar2 == null;
        boolean z2 = rVar3 == null || rVar4 == null;
        if (z && z2) {
            throw i.f.a.k.a();
        }
        if (z) {
            rVar = new r(0.0f, rVar3.d());
            rVar2 = new r(0.0f, rVar4.d());
        } else if (z2) {
            rVar3 = new r(bVar.j() - 1, rVar.d());
            rVar4 = new r(bVar.j() - 1, rVar2.d());
        }
        this.a = bVar;
        this.b = rVar;
        this.c = rVar2;
        this.d = rVar3;
        this.e = rVar4;
        this.f = (int) Math.min(rVar.c(), rVar2.c());
        this.g = (int) Math.max(rVar3.c(), rVar4.c());
        this.f1722h = (int) Math.min(rVar.d(), rVar3.d());
        this.f1723i = (int) Math.max(rVar2.d(), rVar4.d());
    }

    static c j(c cVar, c cVar2) throws i.f.a.k {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.c, cVar2.d, cVar2.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    c a(int i2, int i3, boolean z) throws i.f.a.k {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5 = this.b;
        r rVar6 = this.c;
        r rVar7 = this.d;
        r rVar8 = this.e;
        if (i2 > 0) {
            r rVar9 = z ? rVar5 : rVar7;
            int iD = ((int) rVar9.d()) - i2;
            if (iD < 0) {
                iD = 0;
            }
            r rVar10 = new r(rVar9.c(), iD);
            if (!z) {
                rVar2 = rVar10;
                rVar = rVar5;
                if (i3 <= 0) {
                    r rVar11 = z ? this.c : this.e;
                    int iD2 = ((int) rVar11.d()) + i3;
                    if (iD2 >= this.a.g()) {
                        iD2 = this.a.g() - 1;
                    }
                    r rVar12 = new r(rVar11.c(), iD2);
                    if (!z) {
                        rVar4 = rVar12;
                        rVar3 = rVar6;
                        return new c(this.a, rVar, rVar3, rVar2, rVar4);
                    }
                    rVar3 = rVar12;
                } else {
                    rVar3 = rVar6;
                }
                rVar4 = rVar8;
                return new c(this.a, rVar, rVar3, rVar2, rVar4);
            }
            rVar = rVar10;
        } else {
            rVar = rVar5;
        }
        rVar2 = rVar7;
        if (i3 <= 0) {
        }
        rVar4 = rVar8;
        return new c(this.a, rVar, rVar3, rVar2, rVar4);
    }

    r b() {
        return this.c;
    }

    r c() {
        return this.e;
    }

    int d() {
        return this.g;
    }

    int e() {
        return this.f1723i;
    }

    int f() {
        return this.f;
    }

    int g() {
        return this.f1722h;
    }

    r h() {
        return this.b;
    }

    r i() {
        return this.d;
    }

    c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.f1722h = cVar.f1722h;
        this.f1723i = cVar.f1723i;
    }
}
