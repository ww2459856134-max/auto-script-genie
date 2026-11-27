package n.a.a.k.c;

import com.auto.exceldeps.log4j.Logger;
import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.c.j.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;
import n.a.a.o.k1;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public final class a extends o1 implements Closeable {
    private static final Logger O = n.a.a.i.b.a(a.class);
    private static int P = 100000000;
    private byte[] J;
    private File K;
    private n.a.a.l.b.f.b M;

    a(o1 o1Var, InputStream inputStream) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, NoSuchProviderException, InvalidAlgorithmParameterException {
        super(o1Var.getName());
        long size = o1Var.getSize();
        int iA = e.a();
        if (iA < 0 || (size < iA && size != -1)) {
            if (size < -1 || size >= 2147483647L) {
                throw new IOException("ZIP entry size is too large or invalid");
            }
            this.J = size == -1 ? w0.s(inputStream, m0()) : w0.r(inputStream, size, m0());
            return;
        }
        if (!e.c()) {
            this.K = k1.a("poi-zip-entry", ".tmp");
            O.atInfo().log("Creating temp file {} for zip entry {} of size {} bytes", this.K.getAbsolutePath(), o1Var.getName(), Long.valueOf(size));
            w0.g(inputStream, this.K);
            return;
        }
        n.a.a.l.b.f.b bVar = new n.a.a.l.b.f.b();
        this.M = bVar;
        OutputStream outputStreamD = bVar.d();
        try {
            w0.h(inputStream, outputStreamD);
            if (outputStreamD != null) {
                outputStreamD.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamD != null) {
                    try {
                        outputStreamD.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static int m0() {
        int iJ = w0.j();
        return iJ < 0 ? P : Math.min(P, iJ);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.J = null;
        n.a.a.l.b.f.b bVar = this.M;
        if (bVar != null) {
            bVar.a();
        }
        File file = this.K;
        if (file == null || !file.exists() || this.K.delete()) {
            return;
        }
        O.atDebug().log("temp file was already deleted (probably due to previous call to close this resource)");
    }

    public InputStream l0() throws IOException {
        n.a.a.l.b.f.b bVar = this.M;
        if (bVar != null) {
            try {
                return bVar.c();
            } catch (IOException e) {
                throw new IOException("failed to read from encrypted temp data", e);
            }
        }
        File file = this.K;
        if (file == null) {
            if (this.J != null) {
                return l.a().w(this.J).get();
            }
            throw new IOException("Cannot retrieve data from Zip Entry, probably because the Zip Entry was closed before the data was requested.");
        }
        try {
            return Files.newInputStream(file.toPath(), new OpenOption[0]);
        } catch (FileNotFoundException unused) {
            throw new IOException("temp file " + this.K.getAbsolutePath() + " is missing");
        }
    }
}
