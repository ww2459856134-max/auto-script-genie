package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes.dex */
public class s extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private boolean I0;
    private Dialog K0;
    private boolean L0;
    private boolean M0;
    private boolean N0;
    private Handler z0;
    private Runnable A0 = new a();
    private DialogInterface.OnCancelListener B0 = new b();
    private DialogInterface.OnDismissListener C0 = new c();
    private int D0 = 0;
    private int E0 = 0;
    private boolean F0 = true;
    private boolean G0 = true;
    private int H0 = -1;
    private androidx.lifecycle.o<androidx.lifecycle.i> J0 = new d();
    private boolean O0 = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            s.this.C0.onDismiss(s.this.K0);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            if (s.this.K0 != null) {
                s sVar = s.this;
                sVar.onCancel(sVar.K0);
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            if (s.this.K0 != null) {
                s sVar = s.this;
                sVar.onDismiss(sVar.K0);
            }
        }
    }

    class d implements androidx.lifecycle.o<androidx.lifecycle.i> {
        d() {
        }

        @Override // androidx.lifecycle.o
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(androidx.lifecycle.i iVar) {
            if (iVar == null || !s.this.G0) {
                return;
            }
            View viewZ1 = s.this.z1();
            if (viewZ1.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (s.this.K0 != null) {
                if (p1.F0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + s.this.K0);
                }
                s.this.K0.setContentView(viewZ1);
            }
        }
    }

    class e extends p0 {
        final /* synthetic */ p0 a;

        e(p0 p0Var) {
            this.a = p0Var;
        }

        @Override // androidx.fragment.app.p0
        public View d(int i2) {
            return this.a.g() ? this.a.d(i2) : s.this.d2(i2);
        }

        @Override // androidx.fragment.app.p0
        public boolean g() {
            return this.a.g() || s.this.e2();
        }
    }

    private void Z1(boolean z, boolean z2) {
        if (this.M0) {
            return;
        }
        this.M0 = true;
        this.N0 = false;
        Dialog dialog = this.K0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.K0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.z0.getLooper()) {
                    onDismiss(this.K0);
                } else {
                    this.z0.post(this.A0);
                }
            }
        }
        this.L0 = true;
        if (this.H0 >= 0) {
            L().U0(this.H0, 1);
            this.H0 = -1;
            return;
        }
        f2 f2VarL = L().l();
        f2VarL.n(this);
        if (z) {
            f2VarL.h();
        } else {
            f2VarL.g();
        }
    }

    private void f2(Bundle bundle) {
        if (this.G0 && !this.O0) {
            try {
                this.I0 = true;
                Dialog dialogC2 = c2(bundle);
                this.K0 = dialogC2;
                if (this.G0) {
                    i2(dialogC2, this.D0);
                    Context contextX = x();
                    if (contextX instanceof Activity) {
                        this.K0.setOwnerActivity((Activity) contextX);
                    }
                    this.K0.setCancelable(this.F0);
                    this.K0.setOnCancelListener(this.B0);
                    this.K0.setOnDismissListener(this.C0);
                    this.O0 = true;
                } else {
                    this.K0 = null;
                }
            } finally {
                this.I0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Dialog dialog = this.K0;
        if (dialog != null) {
            this.L0 = true;
            dialog.setOnDismissListener(null);
            this.K0.dismiss();
            if (!this.M0) {
                onDismiss(this.K0);
            }
            this.K0 = null;
            this.O0 = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void D0() {
        super.D0();
        if (!this.N0 && !this.M0) {
            this.M0 = true;
        }
        Z().h(this.J0);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater E0(Bundle bundle) {
        LayoutInflater layoutInflaterE0 = super.E0(bundle);
        if (this.G0 && !this.I0) {
            f2(bundle);
            if (p1.F0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.K0;
            return dialog != null ? layoutInflaterE0.cloneInContext(dialog.getContext()) : layoutInflaterE0;
        }
        if (p1.F0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.G0) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterE0;
    }

    @Override // androidx.fragment.app.Fragment
    public void R0(Bundle bundle) {
        super.R0(bundle);
        Dialog dialog = this.K0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i2 = this.D0;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.E0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.F0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.G0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.H0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void S0() {
        super.S0();
        Dialog dialog = this.K0;
        if (dialog != null) {
            this.L0 = false;
            dialog.show();
            View decorView = this.K0.getWindow().getDecorView();
            androidx.lifecycle.x.a(decorView, this);
            androidx.lifecycle.y.a(decorView, this);
            androidx.savedstate.d.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T0() {
        super.T0();
        Dialog dialog = this.K0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V0(Bundle bundle) {
        Bundle bundle2;
        super.V0(bundle);
        if (this.K0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.K0.onRestoreInstanceState(bundle2);
    }

    public void X1() {
        Z1(false, false);
    }

    public void Y1() {
        Z1(true, false);
    }

    public Dialog a2() {
        return this.K0;
    }

    public int b2() {
        return this.E0;
    }

    @Override // androidx.fragment.app.Fragment
    void c1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.c1(layoutInflater, viewGroup, bundle);
        if (this.h0 != null || this.K0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.K0.onRestoreInstanceState(bundle2);
    }

    public Dialog c2(Bundle bundle) {
        if (p1.F0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(y1(), b2());
    }

    View d2(int i2) {
        Dialog dialog = this.K0;
        if (dialog != null) {
            return dialog.findViewById(i2);
        }
        return null;
    }

    boolean e2() {
        return this.O0;
    }

    public final Dialog g2() {
        Dialog dialogA2 = a2();
        if (dialogA2 != null) {
            return dialogA2;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void h2(boolean z) {
        this.F0 = z;
        Dialog dialog = this.K0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void i2(Dialog dialog, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    @Override // androidx.fragment.app.Fragment
    p0 j() {
        return new e(super.j());
    }

    public void j2(p1 p1Var, String str) {
        this.M0 = false;
        this.N0 = true;
        f2 f2VarL = p1Var.l();
        f2VarL.d(this, str);
        f2VarL.g();
    }

    public void k2(p1 p1Var, String str) {
        this.M0 = false;
        this.N0 = true;
        f2 f2VarL = p1Var.l();
        f2VarL.d(this, str);
        f2VarL.i();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.L0) {
            return;
        }
        if (p1.F0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        Z1(true, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void s0(Context context) {
        super.s0(context);
        Z().e(this.J0);
        if (this.N0) {
            return;
        }
        this.M0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        this.z0 = new Handler();
        this.G0 = this.V == 0;
        if (bundle != null) {
            this.D0 = bundle.getInt("android:style", 0);
            this.E0 = bundle.getInt("android:theme", 0);
            this.F0 = bundle.getBoolean("android:cancelable", true);
            this.G0 = bundle.getBoolean("android:showsDialog", this.G0);
            this.H0 = bundle.getInt("android:backStackId", -1);
        }
    }
}
