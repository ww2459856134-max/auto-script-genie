package h.e.g;

import android.graphics.Typeface;
import android.os.Handler;

/* loaded from: classes.dex */
class c {
    private final p a;
    private final Handler b;

    c(p pVar, Handler handler) {
        this.a = pVar;
        this.b = handler;
    }

    private void a(int i2) {
        this.b.post(new b(this, this.a, i2));
    }

    private void c(Typeface typeface) {
        this.b.post(new a(this, this.a, typeface));
    }

    void b(l lVar) {
        if (lVar.a()) {
            c(lVar.a);
        } else {
            a(lVar.b);
        }
    }
}
