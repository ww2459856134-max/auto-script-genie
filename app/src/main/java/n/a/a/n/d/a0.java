package n.a.a.n.d;

import java.util.Iterator;

/* loaded from: classes.dex */
public class a0 {
    private final int a;
    private final String b;

    public a0(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public static a0 a(e eVar, n.a.a.n.c.j jVar) {
        a0 a0VarA = null;
        if (eVar == null) {
            return null;
        }
        if (jVar != null) {
            Iterator<n.a.a.n.c.m> it = jVar.a(eVar).iterator();
            while (it.hasNext() && (a0VarA = it.next().a()) == null) {
            }
        }
        return a0VarA == null ? b(eVar.k()) : a0VarA;
    }

    public static a0 b(i iVar) {
        if (iVar == null) {
            return null;
        }
        return new a0(iVar.b(), iVar.a());
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }
}
