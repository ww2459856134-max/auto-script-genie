package androidx.activity;

import android.text.TextUtils;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ ComponentActivity c;

    b(ComponentActivity componentActivity) {
        this.c = componentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            super/*android.app.Activity*/.onBackPressed();
        } catch (IllegalStateException e) {
            if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        }
    }
}
