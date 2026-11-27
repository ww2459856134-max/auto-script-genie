package n.a.a.j;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import n.a.a.k.b.o;
import n.a.a.k.b.q;
import n.a.a.k.b.s;

/* loaded from: classes.dex */
public abstract class l {
    private static final Logger g = n.a.a.i.b.a(l.class);
    private final String a;
    private final String b;
    private final String c;
    private final i d;
    private final j e;
    private final k f;

    protected l(String str, String str2, String str3, i iVar, j jVar, k kVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = iVar;
        this.e = jVar;
        this.f = kVar;
    }

    public String a() {
        return this.a;
    }

    public InputStream b(n.a.a.k.b.m mVar) throws n.a.a.k.a.a, n.a.a.k.a.b, IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("Core-Part cannot be empty");
        }
        Iterator<q> it = mVar.v(h()).iterator();
        if (!it.hasNext()) {
            g.atWarn().log("No part {} found", c());
            return null;
        }
        o oVarC = s.c(it.next().e());
        n.a.a.k.b.m mVarB = mVar.q().B(oVarC);
        if (mVarB != null) {
            return mVarB.m();
        }
        throw new IllegalArgumentException("Could not read part " + oVarC + " from " + mVar);
    }

    public String c() {
        return this.c;
    }

    public String d(int i2) {
        return !this.c.contains("#") ? c() : this.c.replace("#", Integer.toString(i2));
    }

    public i e() {
        return this.d;
    }

    public j f() {
        return this.e;
    }

    public k g() {
        return this.f;
    }

    public String h() {
        return this.b;
    }

    protected l(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null);
    }
}
