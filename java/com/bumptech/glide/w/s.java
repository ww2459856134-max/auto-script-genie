package com.bumptech.glide.w;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p1;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class s extends Fragment {
    private final q A0;
    private final Set<s> B0;
    private s C0;
    private com.bumptech.glide.s D0;
    private Fragment E0;
    private final com.bumptech.glide.w.a z0;

    private class a implements q {
        a() {
        }

        @Override // com.bumptech.glide.w.q
        public Set<com.bumptech.glide.s> a() {
            Set<s> setV1 = s.this.V1();
            HashSet hashSet = new HashSet(setV1.size());
            for (s sVar : setV1) {
                if (sVar.Y1() != null) {
                    hashSet.add(sVar.Y1());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + s.this + "}";
        }
    }

    public s() {
        this(new com.bumptech.glide.w.a());
    }

    private void U1(s sVar) {
        this.B0.add(sVar);
    }

    private Fragment X1() {
        Fragment fragmentK = K();
        return fragmentK != null ? fragmentK : this.E0;
    }

    private static p1 a2(Fragment fragment) {
        while (fragment.K() != null) {
            fragment = fragment.K();
        }
        return fragment.F();
    }

    private boolean b2(Fragment fragment) {
        Fragment fragmentX1 = X1();
        while (true) {
            Fragment fragmentK = fragment.K();
            if (fragmentK == null) {
                return false;
            }
            if (fragmentK.equals(fragmentX1)) {
                return true;
            }
            fragment = fragment.K();
        }
    }

    private void c2(Context context, p1 p1Var) {
        g2();
        s sVarR = com.bumptech.glide.c.c(context).k().r(context, p1Var);
        this.C0 = sVarR;
        if (equals(sVarR)) {
            return;
        }
        this.C0.U1(this);
    }

    private void d2(s sVar) {
        this.B0.remove(sVar);
    }

    private void g2() {
        s sVar = this.C0;
        if (sVar != null) {
            sVar.d2(this);
            this.C0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A0() {
        super.A0();
        this.z0.c();
        g2();
    }

    @Override // androidx.fragment.app.Fragment
    public void D0() {
        super.D0();
        this.E0 = null;
        g2();
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        this.z0.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void T0() {
        super.T0();
        this.z0.e();
    }

    Set<s> V1() {
        s sVar = this.C0;
        if (sVar == null) {
            return Collections.emptySet();
        }
        if (equals(sVar)) {
            return Collections.unmodifiableSet(this.B0);
        }
        HashSet hashSet = new HashSet();
        for (s sVar2 : this.C0.V1()) {
            if (b2(sVar2.X1())) {
                hashSet.add(sVar2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    com.bumptech.glide.w.a W1() {
        return this.z0;
    }

    public com.bumptech.glide.s Y1() {
        return this.D0;
    }

    public q Z1() {
        return this.A0;
    }

    void e2(Fragment fragment) {
        p1 p1VarA2;
        this.E0 = fragment;
        if (fragment == null || fragment.x() == null || (p1VarA2 = a2(fragment)) == null) {
            return;
        }
        c2(fragment.x(), p1VarA2);
    }

    public void f2(com.bumptech.glide.s sVar) {
        this.D0 = sVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void s0(Context context) {
        super.s0(context);
        p1 p1VarA2 = a2(this);
        if (p1VarA2 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                c2(x(), p1VarA2);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + X1() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public s(com.bumptech.glide.w.a aVar) {
        this.A0 = new a();
        this.B0 = new HashSet();
        this.z0 = aVar;
    }
}
