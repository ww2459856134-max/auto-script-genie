package androidx.lifecycle;

import androidx.lifecycle.f;

/* loaded from: classes.dex */
class j {
    f.b a;
    g b;

    j(h hVar, f.b bVar) {
        this.b = l.f(hVar);
        this.a = bVar;
    }

    void a(i iVar, f.a aVar) {
        f.b bVarB = aVar.b();
        this.a = k.k(this.a, bVarB);
        this.b.a(iVar, aVar);
        this.a = bVarB;
    }
}
