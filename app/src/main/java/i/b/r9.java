package i.b;

import i.b.da;

/* loaded from: classes.dex */
final class r9 implements da.a {
    final t9 a;

    r9(t9 t9Var) {
        this.a = t9Var;
    }

    @Override // i.b.da.a
    public void a() {
        if (this.a.q()) {
            com.frame.y0.m("【子任务返回】继续父任务「" + this.a.l().getName() + "」的后续节点");
            da daVarB = da.B();
            daVarB.V1(this.a);
            daVarB.Q1(this.a);
            this.a.g();
        }
    }

    @Override // i.b.da.a
    public void b() {
    }
}
