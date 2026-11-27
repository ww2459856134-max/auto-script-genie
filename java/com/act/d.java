package com.act;

import android.app.ProgressDialog;
import com.frame.k0;
import com.frame.v0;

/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ e c;

    d(e eVar) {
        this.c = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ProgressDialog progressDialog = this.c.J == null ? null : (ProgressDialog) this.c.J.get();
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
}
