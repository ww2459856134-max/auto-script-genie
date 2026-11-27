package com.airbnb.lottie.t0.b;

import android.graphics.Path;
import com.airbnb.lottie.e0;
import java.util.List;

/* loaded from: classes.dex */
public class u implements p, com.airbnb.lottie.t0.c.b {
    private final boolean b;
    private final e0 c;
    private final com.airbnb.lottie.t0.c.g<?, Path> d;
    private boolean e;
    private final Path a = new Path();
    private d f = new d();

    public u(e0 e0Var, com.airbnb.lottie.v0.m.c cVar, com.airbnb.lottie.v0.l.r rVar) {
        rVar.b();
        this.b = rVar.d();
        this.c = e0Var;
        com.airbnb.lottie.t0.c.g<com.airbnb.lottie.v0.l.o, Path> gVarA = rVar.c().a();
        this.d = gVarA;
        cVar.i(gVarA);
        gVarA.a(this);
    }

    private void b() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t0.c.b
    public void d() {
        b();
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            e eVar = list.get(i2);
            if (eVar instanceof w) {
                w wVar = (w) eVar;
                if (wVar.i() == com.airbnb.lottie.v0.l.w.SIMULTANEOUSLY) {
                    this.f.a(wVar);
                    wVar.b(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        if (this.b) {
            this.e = true;
            return this.a;
        }
        this.a.set(this.d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f.b(this.a);
        this.e = true;
        return this.a;
    }
}
