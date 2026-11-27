package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class n {
    public RecyclerView.d0 a;
    public RecyclerView.d0 b;
    public int c;
    public int d;
    public int e;
    public int f;

    private n(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        this.a = d0Var;
        this.b = d0Var2;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }

    n(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i2, int i3, int i4, int i5) {
        this(d0Var, d0Var2);
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
    }
}
