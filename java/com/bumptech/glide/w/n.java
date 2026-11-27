package com.bumptech.glide.w;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class n extends Fragment {
    private final a c;
    private final q d;
    private final Set<n> e;
    private com.bumptech.glide.s f;
    private n g;

    /* renamed from: h, reason: collision with root package name */
    private Fragment f699h;

    public n() {
        this(new a());
    }

    private void a(n nVar) {
        this.e.add(nVar);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f699h;
    }

    @TargetApi(17)
    private boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(Activity activity) {
        l();
        n nVarP = com.bumptech.glide.c.c(activity).k().p(activity);
        this.g = nVarP;
        if (equals(nVarP)) {
            return;
        }
        this.g.a(this);
    }

    private void i(n nVar) {
        this.e.remove(nVar);
    }

    private void l() {
        n nVar = this.g;
        if (nVar != null) {
            nVar.i(this);
            this.g = null;
        }
    }

    @TargetApi(17)
    Set<n> b() {
        if (equals(this.g)) {
            return Collections.unmodifiableSet(this.e);
        }
        if (this.g == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (n nVar : this.g.b()) {
            if (g(nVar.getParentFragment())) {
                hashSet.add(nVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    a c() {
        return this.c;
    }

    public com.bumptech.glide.s e() {
        return this.f;
    }

    public q f() {
        return this.d;
    }

    void j(Fragment fragment) {
        this.f699h = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(com.bumptech.glide.s sVar) {
        this.f = sVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.c.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.c.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.c.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    n(a aVar) {
        this.d = new m(this);
        this.e = new HashSet();
        this.c = aVar;
    }
}
