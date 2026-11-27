package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class k extends f {
    private h.b.a.b.a<h, j> a;
    private f.b b;
    private final WeakReference<i> c;
    private int d;
    private boolean e;
    private boolean f;
    private ArrayList<f.b> g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f289h;

    public k(i iVar) {
        this(iVar, true);
    }

    private void d(i iVar) {
        Iterator<Map.Entry<h, j>> itA = this.a.a();
        while (itA.hasNext() && !this.f) {
            Map.Entry<h, j> next = itA.next();
            j value = next.getValue();
            while (value.a.compareTo(this.b) > 0 && !this.f && this.a.contains(next.getKey())) {
                f.a aVarA = f.a.a(value.a);
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + value.a);
                }
                n(aVarA.b());
                value.a(iVar, aVarA);
                m();
            }
        }
    }

    private f.b e(h hVar) {
        Map.Entry<h, j> entryP = this.a.p(hVar);
        f.b bVar = null;
        f.b bVar2 = entryP != null ? entryP.getValue().a : null;
        if (!this.g.isEmpty()) {
            bVar = this.g.get(r0.size() - 1);
        }
        return k(k(this.b, bVar2), bVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (!this.f289h || h.b.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(i iVar) {
        h.b.a.b.e<h, j>.a aVarG = this.a.g();
        while (aVarG.hasNext() && !this.f) {
            Map.Entry next = aVarG.next();
            j jVar = (j) next.getValue();
            while (jVar.a.compareTo(this.b) < 0 && !this.f && this.a.contains(next.getKey())) {
                n(jVar.a);
                f.a aVarC = f.a.c(jVar.a);
                if (aVarC == null) {
                    throw new IllegalStateException("no event up from " + jVar.a);
                }
                jVar.a(iVar, aVarC);
                m();
            }
        }
    }

    private boolean i() {
        if (this.a.size() == 0) {
            return true;
        }
        f.b bVar = this.a.b().getValue().a;
        f.b bVar2 = this.a.h().getValue().a;
        return bVar == bVar2 && this.b == bVar2;
    }

    static f.b k(f.b bVar, f.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void l(f.b bVar) {
        if (this.b == bVar) {
            return;
        }
        this.b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        p();
        this.e = false;
    }

    private void m() {
        this.g.remove(r0.size() - 1);
    }

    private void n(f.b bVar) {
        this.g.add(bVar);
    }

    private void p() {
        i iVar = this.c.get();
        if (iVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f = false;
            if (this.b.compareTo(this.a.b().getValue().a) < 0) {
                d(iVar);
            }
            Map.Entry<h, j> entryH = this.a.h();
            if (!this.f && entryH != null && this.b.compareTo(entryH.getValue().a) > 0) {
                g(iVar);
            }
        }
        this.f = false;
    }

    @Override // androidx.lifecycle.f
    public void a(h hVar) {
        i iVar;
        f("addObserver");
        f.b bVar = this.b;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        j jVar = new j(hVar, bVar2);
        if (this.a.k(hVar, jVar) == null && (iVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            f.b bVarE = e(hVar);
            this.d++;
            while (jVar.a.compareTo(bVarE) < 0 && this.a.contains(hVar)) {
                n(jVar.a);
                f.a aVarC = f.a.c(jVar.a);
                if (aVarC == null) {
                    throw new IllegalStateException("no event up from " + jVar.a);
                }
                jVar.a(iVar, aVarC);
                m();
                bVarE = e(hVar);
            }
            if (!z) {
                p();
            }
            this.d--;
        }
    }

    @Override // androidx.lifecycle.f
    public f.b b() {
        return this.b;
    }

    @Override // androidx.lifecycle.f
    public void c(h hVar) {
        f("removeObserver");
        this.a.l(hVar);
    }

    public void h(f.a aVar) {
        f("handleLifecycleEvent");
        l(aVar.b());
    }

    @Deprecated
    public void j(f.b bVar) {
        f("markState");
        o(bVar);
    }

    public void o(f.b bVar) {
        f("setCurrentState");
        l(bVar);
    }

    private k(i iVar, boolean z) {
        this.a = new h.b.a.b.a<>();
        this.d = 0;
        this.e = false;
        this.f = false;
        this.g = new ArrayList<>();
        this.c = new WeakReference<>(iVar);
        this.b = f.b.INITIALIZED;
        this.f289h = z;
    }
}
