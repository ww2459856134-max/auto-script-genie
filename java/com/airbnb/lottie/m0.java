package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class m0<T> {
    public static Executor e = Executors.newCachedThreadPool();
    private final Set<g0<T>> a;
    private final Set<g0<Throwable>> b;
    private final Handler c;
    private volatile k0<T> d;

    private class a extends FutureTask<k0<T>> {
        a(Callable<k0<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                m0.this.l(get());
            } catch (InterruptedException | ExecutionException e) {
                m0.this.l(new k0(e));
            }
        }
    }

    public m0(Callable<k0<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.y0.d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g0) it.next()).a(th);
        }
    }

    private void h() {
        this.c.post(new l0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((g0) it.next()).a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(k0<T> k0Var) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = k0Var;
        h();
    }

    public synchronized m0<T> e(g0<Throwable> g0Var) {
        if (this.d != null && this.d.a() != null) {
            g0Var.a(this.d.a());
        }
        this.b.add(g0Var);
        return this;
    }

    public synchronized m0<T> f(g0<T> g0Var) {
        if (this.d != null && this.d.b() != null) {
            g0Var.a(this.d.b());
        }
        this.a.add(g0Var);
        return this;
    }

    public synchronized m0<T> j(g0<Throwable> g0Var) {
        this.b.remove(g0Var);
        return this;
    }

    public synchronized m0<T> k(g0<T> g0Var) {
        this.a.remove(g0Var);
        return this;
    }

    m0(Callable<k0<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (!z) {
            e.execute(new a(callable));
            return;
        }
        try {
            l(callable.call());
        } catch (Throwable th) {
            l(new k0<>(th));
        }
    }
}
