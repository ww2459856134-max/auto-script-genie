package org.opencv.android;

import android.content.DialogInterface;

/* loaded from: classes2.dex */
class i implements DialogInterface.OnClickListener {
    final /* synthetic */ n c;

    i(n nVar) {
        this.c = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.c.c();
    }
}
