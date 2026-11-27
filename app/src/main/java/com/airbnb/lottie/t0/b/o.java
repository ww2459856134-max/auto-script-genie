package com.airbnb.lottie.t0.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes.dex */
public class o implements p, l {
    private final Path a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List<p> d = new ArrayList();
    private final com.airbnb.lottie.v0.l.j e;

    public o(com.airbnb.lottie.v0.l.j jVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        jVar.c();
        this.e = jVar;
    }

    private void d() {
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            this.c.addPath(this.d.get(i2).getPath());
        }
    }

    @TargetApi(19)
    private void f(Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.d.size() - 1; size >= 1; size--) {
            p pVar = this.d.get(size);
            if (pVar instanceof f) {
                f fVar = (f) pVar;
                List<p> listI = fVar.i();
                for (int size2 = listI.size() - 1; size2 >= 0; size2--) {
                    Path path = listI.get(size2).getPath();
                    path.transform(fVar.j());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(pVar.getPath());
            }
        }
        p pVar2 = this.d.get(0);
        if (pVar2 instanceof f) {
            f fVar2 = (f) pVar2;
            List<p> listI2 = fVar2.i();
            for (int i2 = 0; i2 < listI2.size(); i2++) {
                Path path2 = listI2.get(i2).getPath();
                path2.transform(fVar2.j());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(pVar2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // com.airbnb.lottie.t0.b.l
    public void b(ListIterator<e> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            e eVarPrevious = listIterator.previous();
            if (eVarPrevious instanceof p) {
                this.d.add((p) eVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.t0.b.e
    public void e(List<e> list, List<e> list2) {
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            this.d.get(i2).e(list, list2);
        }
    }

    @Override // com.airbnb.lottie.t0.b.p
    public Path getPath() {
        this.c.reset();
        if (this.e.d()) {
            return this.c;
        }
        int i2 = n.a[this.e.b().ordinal()];
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            f(Path.Op.UNION);
        } else if (i2 == 3) {
            f(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            f(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            f(Path.Op.XOR);
        }
        return this.c;
    }
}
