package n.a.a.k.b.z;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class h extends n.a.a.k.b.m {

    /* renamed from: i, reason: collision with root package name */
    protected byte[] f2292i;

    public h(n.a.a.k.b.k kVar, n.a.a.k.b.o oVar, String str, boolean z) throws n.a.a.k.a.a {
        super(kVar, oVar, new c(str), z);
    }

    @Override // n.a.a.k.b.m
    public boolean E(OutputStream outputStream) throws n.a.a.k.a.f {
        return new n.a.a.k.b.z.r.e().a(this, outputStream);
    }

    @Override // n.a.a.k.b.m
    public void g() {
        this.f2292i = null;
    }

    @Override // n.a.a.k.b.m
    public void i() {
    }

    @Override // n.a.a.k.b.m
    protected InputStream n() {
        if (this.f2292i == null) {
            this.f2292i = new byte[0];
        }
        try {
            return i.b.ha.a.c.j.l.a().w(this.f2292i).get();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // n.a.a.k.b.m
    protected OutputStream p() {
        return new i(this);
    }

    @Override // n.a.a.k.b.m
    public long x() {
        if (this.f2292i == null) {
            return 0L;
        }
        return r0.length;
    }
}
