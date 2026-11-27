package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.f;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private final Runnable a;
    final ArrayDeque<i> b = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements androidx.lifecycle.g, a {
        private final androidx.lifecycle.f a;
        private final i b;
        private a c;

        LifecycleOnBackPressedCancellable(androidx.lifecycle.f fVar, i iVar) {
            this.a = fVar;
            this.b = iVar;
            fVar.a(this);
        }

        @Override // androidx.lifecycle.g
        public void a(androidx.lifecycle.i iVar, f.a aVar) {
            if (aVar == f.a.ON_START) {
                this.c = OnBackPressedDispatcher.this.b(this.b);
                return;
            }
            if (aVar != f.a.ON_STOP) {
                if (aVar == f.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                a aVar2 = this.c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.a.c(this);
            this.b.e(this);
            a aVar = this.c;
            if (aVar != null) {
                aVar.cancel();
                this.c = null;
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    public void a(androidx.lifecycle.i iVar, i iVar2) {
        androidx.lifecycle.f fVarO = iVar.o();
        if (fVarO.b() == f.b.DESTROYED) {
            return;
        }
        iVar2.a(new LifecycleOnBackPressedCancellable(fVarO, iVar2));
    }

    a b(i iVar) {
        this.b.add(iVar);
        j jVar = new j(this, iVar);
        iVar.a(jVar);
        return jVar;
    }

    public void c() {
        Iterator<i> itDescendingIterator = this.b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            i next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
