package h.e.g;

import android.graphics.Typeface;

/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ p c;
    final /* synthetic */ Typeface d;

    a(c cVar, p pVar, Typeface typeface) {
        this.c = pVar;
        this.d = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.b(this.d);
    }
}
