package n.a.a.k.b;

import i.b.ha.a.b.d.c.o1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class y extends m {

    /* renamed from: i, reason: collision with root package name */
    private o1 f2289i;

    y(k kVar, o1 o1Var, o oVar, String str, boolean z) throws n.a.a.k.a.a {
        super(kVar, oVar, new n.a.a.k.b.z.c(str), z);
        this.f2289i = o1Var;
    }

    @Override // n.a.a.k.b.m
    public boolean E(OutputStream outputStream) throws n.a.a.k.a.f {
        return new n.a.a.k.b.z.r.e().a(this, outputStream);
    }

    @Override // n.a.a.k.b.m
    public void i() {
    }

    @Override // n.a.a.k.b.m
    protected InputStream n() throws IOException {
        return ((x) this.c).m0().v(this.f2289i);
    }

    @Override // n.a.a.k.b.m
    protected OutputStream p() {
        return null;
    }

    @Override // n.a.a.k.b.m
    public long x() {
        return this.f2289i.getSize();
    }
}
