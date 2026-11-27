package h.e.d;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public class f extends h.e.g.p {
    private androidx.core.content.c.m a;

    public f(androidx.core.content.c.m mVar) {
        this.a = mVar;
    }

    @Override // h.e.g.p
    public void a(int i2) {
        androidx.core.content.c.m mVar = this.a;
        if (mVar != null) {
            mVar.d(i2);
        }
    }

    @Override // h.e.g.p
    public void b(Typeface typeface) {
        androidx.core.content.c.m mVar = this.a;
        if (mVar != null) {
            mVar.e(typeface);
        }
    }
}
