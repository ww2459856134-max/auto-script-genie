package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class q0 {
    int b;
    int c;
    int d;
    int e;

    /* renamed from: h, reason: collision with root package name */
    boolean f376h;

    /* renamed from: i, reason: collision with root package name */
    boolean f377i;
    boolean a = true;
    int f = 0;
    int g = 0;

    q0() {
    }

    boolean a(RecyclerView.a0 a0Var) {
        int i2 = this.c;
        return i2 >= 0 && i2 < a0Var.b();
    }

    View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.c);
        this.c += this.d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
