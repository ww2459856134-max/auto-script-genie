package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.f;

/* loaded from: classes.dex */
class FragmentManager$6 implements androidx.lifecycle.g {
    final /* synthetic */ String a;
    final /* synthetic */ w1 b;
    final /* synthetic */ androidx.lifecycle.f c;
    final /* synthetic */ p1 d;

    @Override // androidx.lifecycle.g
    public void a(androidx.lifecycle.i iVar, f.a aVar) {
        Bundle bundle;
        if (aVar == f.a.ON_START && (bundle = (Bundle) this.d.f270j.get(this.a)) != null) {
            this.b.a(this.a, bundle);
            this.d.q(this.a);
        }
        if (aVar == f.a.ON_DESTROY) {
            this.c.c(this);
            this.d.f271k.remove(this.a);
        }
    }
}
