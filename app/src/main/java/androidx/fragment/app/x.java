package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;

/* loaded from: classes.dex */
class x implements h.b.a.c.a<Void, ActivityResultRegistry> {
    final /* synthetic */ Fragment a;

    x(Fragment fragment) {
        this.a = fragment;
    }

    @Override // h.b.a.c.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityResultRegistry apply(Void r3) {
        Fragment fragment = this.a;
        Object obj = fragment.O;
        return obj instanceof androidx.activity.result.h ? ((androidx.activity.result.h) obj).e() : fragment.x1().e();
    }
}
