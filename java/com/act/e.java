package com.act;

import android.app.ProgressDialog;
import android.widget.Toast;
import androidx.appcompat.app.s;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class e extends s {
    private WeakReference<ProgressDialog> J;

    static /* synthetic */ void T(String str) {
        try {
            Toast.makeText(v0.g(), str, 0).show();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void S() {
        l1.e(new d(this));
    }

    public void U() {
        try {
            WeakReference<ProgressDialog> weakReference = this.J;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this, 3);
                progressDialog.setProgressStyle(0);
                this.J = new WeakReference<>(progressDialog);
            } else if (progressDialog.isShowing()) {
                return;
            }
            progressDialog.setMessage("加载中...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        } catch (Exception e) {
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void V(String str) {
        W(str, false);
    }

    public void W(String str, boolean z) {
        try {
            WeakReference<ProgressDialog> weakReference = this.J;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this, 3);
                progressDialog.setProgressStyle(0);
                this.J = new WeakReference<>(progressDialog);
            } else if (progressDialog.isShowing()) {
                return;
            }
            progressDialog.setMessage(str);
            progressDialog.setCancelable(z);
            progressDialog.show();
        } catch (Exception e) {
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void X(boolean z) {
        try {
            WeakReference<ProgressDialog> weakReference = this.J;
            ProgressDialog progressDialog = weakReference == null ? null : weakReference.get();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this, 3);
                progressDialog.setProgressStyle(0);
                this.J = new WeakReference<>(progressDialog);
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

    public void Y(final String str) {
        l1.e(new Runnable() { // from class: com.act.a
            @Override // java.lang.Runnable
            public final void run() {
                e.T(str);
            }
        });
    }
}
