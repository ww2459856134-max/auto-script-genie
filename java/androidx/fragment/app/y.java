package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class y extends c0 {
    final /* synthetic */ h.b.a.c.a a;
    final /* synthetic */ AtomicReference b;
    final /* synthetic */ androidx.activity.result.l.b c;
    final /* synthetic */ androidx.activity.result.c d;
    final /* synthetic */ Fragment e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y(Fragment fragment, h.b.a.c.a aVar, AtomicReference atomicReference, androidx.activity.result.l.b bVar, androidx.activity.result.c cVar) {
        super(null);
        this.e = fragment;
        this.a = aVar;
        this.b = atomicReference;
        this.c = bVar;
        this.d = cVar;
    }

    @Override // androidx.fragment.app.c0
    void a() {
        String strP = this.e.p();
        this.b.set(((ActivityResultRegistry) this.a.apply(null)).j(strP, this.e, this.c, this.d));
    }
}
