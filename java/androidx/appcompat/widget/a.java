package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public class a implements h.e.j.a1 {
    private boolean a = false;
    int b;
    final /* synthetic */ b c;

    protected a(b bVar) {
        this.c = bVar;
    }

    @Override // h.e.j.a1
    public void a(View view) {
        this.a = true;
    }

    @Override // h.e.j.a1
    public void b(View view) {
        if (this.a) {
            return;
        }
        b bVar = this.c;
        bVar.f143h = null;
        super/*android.view.ViewGroup*/.setVisibility(this.b);
    }

    @Override // h.e.j.a1
    public void c(View view) {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.a = false;
    }

    public a d(h.e.j.z0 z0Var, int i2) {
        this.c.f143h = z0Var;
        this.b = i2;
        return this;
    }
}
