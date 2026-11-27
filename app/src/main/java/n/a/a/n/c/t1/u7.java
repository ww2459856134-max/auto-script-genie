package n.a.a.n.c.t1;

import java.util.function.Function;

/* loaded from: classes.dex */
public abstract class u7 extends b6 implements x2 {
    public static final p6 a = new l7();
    public static final p6 b = new m7();
    public static final p6 c = new n7();
    public static final p6 d = new o7();
    public static final p6 e = new p7();
    public static final p6 f = new q7();
    public static final p6 g = new r7();

    /* renamed from: h, reason: collision with root package name */
    public static final p6 f2397h = new s7();

    /* renamed from: i, reason: collision with root package name */
    public static final p6 f2398i = new t7();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ n.a.a.n.c.r1.w0 n(n.a.a.n.c.r1.w0 w0Var) {
        return n.a.a.n.c.r1.m.v(l(w0Var));
    }

    @Override // n.a.a.n.c.t1.l6
    public n.a.a.n.c.r1.w0 g(int i2, int i3, n.a.a.n.c.r1.w0 w0Var) {
        n.a.a.n.c.r1.w0 w0VarA;
        try {
            w0VarA = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
        } catch (n.a.a.n.c.r1.p e2) {
            w0VarA = e2.a();
        }
        return n.a.a.n.c.r1.m.v(l(w0VarA));
    }

    @Override // n.a.a.n.c.t1.x2
    public n.a.a.n.c.r1.w0 h(n.a.a.n.c.r1.w0[] w0VarArr, int i2, int i3) {
        return w0VarArr.length != 1 ? n.a.a.n.c.r1.o.e : a(w0VarArr[0], i2, i3, new Function() { // from class: n.a.a.n.c.t1.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.n((n.a.a.n.c.r1.w0) obj);
            }
        });
    }

    protected abstract boolean l(n.a.a.n.c.r1.w0 w0Var);
}
