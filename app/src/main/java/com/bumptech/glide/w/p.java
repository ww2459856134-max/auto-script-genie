package com.bumptech.glide.w;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f2;
import androidx.fragment.app.h0;
import androidx.fragment.app.p1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class p implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    private static final a f700i = new o();
    private volatile com.bumptech.glide.s a;
    private final Handler d;
    private final a e;
    final Map<FragmentManager, n> b = new HashMap();
    final Map<p1, s> c = new HashMap();
    private final h.d.b<View, Fragment> f = new h.d.b<>();
    private final h.d.b<View, android.app.Fragment> g = new h.d.b<>();

    /* renamed from: h, reason: collision with root package name */
    private final Bundle f701h = new Bundle();

    public interface a {
        com.bumptech.glide.s a(com.bumptech.glide.c cVar, j jVar, q qVar, Context context);
    }

    public p(a aVar) {
        this.e = aVar == null ? f700i : aVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void c(FragmentManager fragmentManager, h.d.b<View, android.app.Fragment> bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            d(fragmentManager, bVar);
            return;
        }
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                bVar.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), bVar);
            }
        }
    }

    @Deprecated
    private void d(FragmentManager fragmentManager, h.d.b<View, android.app.Fragment> bVar) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.f701h.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f701h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                bVar.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    c(fragment.getChildFragmentManager(), bVar);
                }
            }
            i2 = i3;
        }
    }

    private static void e(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.Y() != null) {
                map.put(fragment.Y(), fragment);
                e(fragment.w().s0(), map);
            }
        }
    }

    @Deprecated
    private android.app.Fragment f(View view, Activity activity) {
        this.g.clear();
        c(activity.getFragmentManager(), this.g);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.g.clear();
        return fragment;
    }

    private Fragment g(View view, h0 h0Var) {
        this.f.clear();
        e(h0Var.x().s0(), this.f);
        View viewFindViewById = h0Var.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f.clear();
        return fragment;
    }

    @Deprecated
    private com.bumptech.glide.s h(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        n nVarQ = q(fragmentManager, fragment, z);
        com.bumptech.glide.s sVarE = nVarQ.e();
        if (sVarE != null) {
            return sVarE;
        }
        com.bumptech.glide.s sVarA = this.e.a(com.bumptech.glide.c.c(context), nVarQ.c(), nVarQ.f(), context);
        nVarQ.k(sVarA);
        return sVarA;
    }

    private com.bumptech.glide.s o(Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.e.a(com.bumptech.glide.c.c(context.getApplicationContext()), new b(), new i(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }

    private n q(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        n nVar = (n) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (nVar == null && (nVar = this.b.get(fragmentManager)) == null) {
            nVar = new n();
            nVar.j(fragment);
            if (z) {
                nVar.c().d();
            }
            this.b.put(fragmentManager, nVar);
            fragmentManager.beginTransaction().add(nVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return nVar;
    }

    private s s(p1 p1Var, Fragment fragment, boolean z) {
        s sVar = (s) p1Var.i0("com.bumptech.glide.manager");
        if (sVar == null && (sVar = this.c.get(p1Var)) == null) {
            sVar = new s();
            sVar.e2(fragment);
            if (z) {
                sVar.W1().d();
            }
            this.c.put(p1Var, sVar);
            f2 f2VarL = p1Var.l();
            f2VarL.d(sVar, "com.bumptech.glide.manager");
            f2VarL.h();
            this.d.obtainMessage(2, p1Var).sendToTarget();
        }
        return sVar;
    }

    private static boolean t(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    private com.bumptech.glide.s u(Context context, p1 p1Var, Fragment fragment, boolean z) {
        s sVarS = s(p1Var, fragment, z);
        com.bumptech.glide.s sVarY1 = sVarS.Y1();
        if (sVarY1 != null) {
            return sVarY1;
        }
        com.bumptech.glide.s sVarA = this.e.a(com.bumptech.glide.c.c(context), sVarS.W1(), sVarS.Z1(), context);
        sVarS.f2(sVarA);
        return sVarA;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.b.remove(obj);
        } else {
            if (i2 != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z;
            }
            obj = (p1) message.obj;
            objRemove = this.c.remove(obj);
        }
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    public com.bumptech.glide.s i(Activity activity) {
        if (com.bumptech.glide.b0.p.o()) {
            return k(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), null, t(activity));
    }

    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.s j(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (com.bumptech.glide.b0.p.o() || Build.VERSION.SDK_INT < 17) {
            return k(fragment.getActivity().getApplicationContext());
        }
        return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public com.bumptech.glide.s k(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.b0.p.p() && !(context instanceof Application)) {
            if (context instanceof h0) {
                return n((h0) context);
            }
            if (context instanceof Activity) {
                return i((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return k(contextWrapper.getBaseContext());
                }
            }
        }
        return o(context);
    }

    public com.bumptech.glide.s l(View view) {
        if (com.bumptech.glide.b0.p.o()) {
            return k(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.b0.n.d(view);
        com.bumptech.glide.b0.n.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return k(view.getContext().getApplicationContext());
        }
        if (!(activityB instanceof h0)) {
            android.app.Fragment fragmentF = f(view, activityB);
            return fragmentF == null ? i(activityB) : j(fragmentF);
        }
        h0 h0Var = (h0) activityB;
        Fragment fragmentG = g(view, h0Var);
        return fragmentG != null ? m(fragmentG) : n(h0Var);
    }

    public com.bumptech.glide.s m(Fragment fragment) {
        com.bumptech.glide.b0.n.e(fragment.x(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.b0.p.o()) {
            return k(fragment.x().getApplicationContext());
        }
        return u(fragment.x(), fragment.w(), fragment, fragment.n0());
    }

    public com.bumptech.glide.s n(h0 h0Var) {
        if (com.bumptech.glide.b0.p.o()) {
            return k(h0Var.getApplicationContext());
        }
        a(h0Var);
        return u(h0Var, h0Var.x(), null, t(h0Var));
    }

    @Deprecated
    n p(Activity activity) {
        return q(activity.getFragmentManager(), null, t(activity));
    }

    s r(Context context, p1 p1Var) {
        return s(p1Var, null, t(context));
    }
}
