package androidx.appcompat.app;

import android.view.View;

/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ View c;
    final /* synthetic */ View d;
    final /* synthetic */ AlertController e;

    e(AlertController alertController, View view, View view2) {
        this.e = alertController;
        this.c = view;
        this.d = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.f(this.e.A, this.c, this.d);
    }
}
