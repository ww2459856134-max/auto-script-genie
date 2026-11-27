package com.yl.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class e extends Fragment {
    protected Context A0 = v0.g();
    protected Toast B0;
    private Bundle C0;
    private boolean D0;
    private boolean E0;
    private boolean F0;
    private WeakReference<ProgressDialog> G0;
    protected View z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2() {
        try {
            WeakReference<ProgressDialog> weakReference = this.G0;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                k0.r(e);
            }
        } catch (Exception e2) {
            if (v0.g().l()) {
                k0.r(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2() {
        this.B0.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void A0() {
        super.A0();
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
    }

    @Override // androidx.fragment.app.Fragment
    public void G1(Bundle bundle) {
        this.C0 = bundle;
        super.G1(bundle);
    }

    public void U1() {
        l1.e(new Runnable() { // from class: com.yl.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                this.c.a2();
            }
        });
    }

    public View V1(int i2) {
        return this.z0.findViewById(i2);
    }

    protected Context W1() {
        return this.A0;
    }

    public abstract int X1();

    @Override // androidx.fragment.app.Fragment
    public View Y() {
        return this.z0;
    }

    public void Y1() {
    }

    public void d2() {
        if (this.E0) {
            return;
        }
        this.E0 = true;
        if (this.F0) {
            Y1();
        }
    }

    public void e2(Bundle bundle) {
    }

    public void f2(String str) {
        try {
            WeakReference<ProgressDialog> weakReference = this.G0;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(q(), 3);
                progressDialog.setProgressStyle(0);
                this.G0 = new WeakReference<>(progressDialog);
            } else if (progressDialog.isShowing()) {
                return;
            }
            progressDialog.setMessage(str);
            progressDialog.setCancelable(true);
            progressDialog.show();
        } catch (Exception e) {
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void g2(boolean z) {
        try {
            WeakReference<ProgressDialog> weakReference = this.G0;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(q(), 3);
                progressDialog.setProgressStyle(0);
                this.G0 = new WeakReference<>(progressDialog);
            } else if (progressDialog.isShowing()) {
                return;
            }
            progressDialog.setMessage("加载中...");
            progressDialog.setCancelable(z);
            progressDialog.show();
        } catch (Exception e) {
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void h2(String str) {
        Toast toast = this.B0;
        if (toast == null) {
            this.B0 = Toast.makeText(v0.g(), str, 0);
        } else {
            toast.setText(str);
            this.B0.setDuration(0);
        }
        l1.e(new Runnable() { // from class: com.yl.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c2();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
        if (this.z0 == null) {
            try {
                this.z0 = View.inflate(q(), X1(), null);
                e2(this.C0);
                if (this.E0 && !this.F0) {
                    Y1();
                }
                this.F0 = true;
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.z0 == null) {
            try {
                this.z0 = View.inflate(q(), X1(), null);
                e2(this.C0);
            } catch (Exception e) {
                k0.r(e);
            }
        }
        try {
            boolean z = this.D0;
        } catch (Exception e2) {
            k0.r(e2);
        }
        return this.z0;
    }
}
