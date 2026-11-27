package n.a.a.k.b.z;

import com.auto.exceldeps.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import n.a.a.o.k1;

/* loaded from: classes.dex */
public final class n extends n.a.a.k.b.m {

    /* renamed from: j, reason: collision with root package name */
    private static final Logger f2296j = n.a.a.i.b.a(n.class);

    /* renamed from: i, reason: collision with root package name */
    private File f2297i;

    public n(n.a.a.k.b.k kVar, n.a.a.k.b.o oVar, String str, boolean z) throws n.a.a.k.a.a, IOException {
        super(kVar, oVar, new c(str), z);
        this.f2297i = k1.a("poi-package-part", ".tmp");
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
            f2296j.atWarn().log("Failed to clear data in temp file", e);
        }
    }

    @Override // n.a.a.k.b.m
    public void i() {
        if (this.f2297i.delete()) {
            return;
        }
        f2296j.atInfo().log("Failed to delete temp file; may already have been closed and deleted");
    }

    @Override // n.a.a.k.b.m
    protected InputStream n() throws IOException {
        return Files.newInputStream(this.f2297i.toPath(), new OpenOption[0]);
    }

    @Override // n.a.a.k.b.m
    protected OutputStream p() throws IOException {
        return Files.newOutputStream(this.f2297i.toPath(), new OpenOption[0]);
    }

    @Override // n.a.a.k.b.m
    public long x() {
        return this.f2297i.length();
    }
}
