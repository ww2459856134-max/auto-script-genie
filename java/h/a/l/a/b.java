package h.a.l.a;

import android.graphics.drawable.Animatable;

/* loaded from: classes.dex */
class b extends g {
    private final Animatable a;

    b(Animatable animatable) {
        super();
        this.a = animatable;
    }

    @Override // h.a.l.a.g
    public void c() {
        this.a.start();
    }

    @Override // h.a.l.a.g
    public void d() {
        this.a.stop();
    }
}
