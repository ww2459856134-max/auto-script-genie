package androidx.core.content.c;

import android.graphics.Typeface;

/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ Typeface c;
    final /* synthetic */ m d;

    k(m mVar, Typeface typeface) {
        this.d = mVar;
        this.c = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.e(this.c);
    }
}
