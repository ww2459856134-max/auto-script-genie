package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class m1 {
    static h.e.i.e<m1> d = new h.e.i.f(20);
    int a;
    RecyclerView.l.b b;
    RecyclerView.l.b c;

    private m1() {
    }

    static void a() {
        while (d.a() != null) {
        }
    }

    static m1 b() {
        m1 m1VarA = d.a();
        return m1VarA == null ? new m1() : m1VarA;
    }

    static void c(m1 m1Var) {
        m1Var.a = 0;
        m1Var.b = null;
        m1Var.c = null;
        d.b(m1Var);
    }
}
