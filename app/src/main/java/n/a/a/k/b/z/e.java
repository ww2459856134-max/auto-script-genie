package n.a.a.k.b.z;

import com.auto.exceldeps.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class e extends n.a.a.k.b.m {

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f2290j = n.a.a.i.b.a(e.class);

    /* renamed from: i, reason: collision with root package name */
    private n.a.a.l.b.f.b f2291i;

    public e(n.a.a.k.b.k kVar, n.a.a.k.b.o oVar, String str, boolean z) throws n.a.a.k.a.a, IOException {
        super(kVar, oVar, new c(str), z);
        this.f2291i = new n.a.a.l.b.f.b();
    }

    @Override // n.a.a.k.b.m
    public boolean E(OutputStream outputStream) throws n.a.a.k.a.f {
        return new n.a.a.k.b.z.r.e().a(this, outputStream);
    }

    @Override // n.a.a.k.b.m
    public void g() throws IOException {
        try {
            OutputStream outputStreamP = p();
            try {
                outputStreamP.write(new byte[0]);
                if (outputStreamP != null) {
                    outputStreamP.close();
                }
            } finally {
            }
        } catch (IOException e) {
            f2290j.atWarn().log("Failed to clear data in temp file", e);
        }
    }

    @Override // n.a.a.k.b.m
    public void i() {
        this.f2291i.a();
    }

    @Override // n.a.a.k.b.m
    protected InputStream n() throws IOException {
        return this.f2291i.c();
    }

    @Override // n.a.a.k.b.m
    protected OutputStream p() throws IOException {
        return this.f2291i.d();
    }

    @Override // n.a.a.k.b.m
    public long x() {
        return this.f2291i.b();
    }
}
