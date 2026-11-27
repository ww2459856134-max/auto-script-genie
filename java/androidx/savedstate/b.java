package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.f;

/* loaded from: classes.dex */
public final class b {
    private final c a;
    private final SavedStateRegistry b = new SavedStateRegistry();

    private b(c cVar) {
        this.a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public SavedStateRegistry b() {
        return this.b;
    }

    public void c(Bundle bundle) {
        f fVarO = this.a.o();
        if (fVarO.b() != f.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        fVarO.a(new Recreator(this.a));
        this.b.b(fVarO, bundle);
    }

    public void d(Bundle bundle) {
        this.b.c(bundle);
    }
}
