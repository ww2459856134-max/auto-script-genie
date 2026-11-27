package com.jsj.autojs.l;

import android.content.DialogInterface;
import com.frame.v0;

/* loaded from: classes.dex */
class z implements DialogInterface.OnCancelListener {
    z(c0 c0Var) {
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (v0.g().j()) {
            return;
        }
        v0.g().p(3);
    }
}
