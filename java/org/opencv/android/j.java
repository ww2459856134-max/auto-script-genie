package org.opencv.android;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ u c;

    j(n nVar, u uVar) {
        this.c = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.c.c();
    }
}
