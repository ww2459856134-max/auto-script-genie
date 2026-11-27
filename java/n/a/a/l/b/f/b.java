package n.a.a.l.b.f;

import com.auto.exceldeps.log4j.LogBuilder;
import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.util.Supplier;
import i.b.ha.a.c.k.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import n.a.a.l.b.d;
import n.a.a.o.c1;
import n.a.a.o.k1;

/* loaded from: classes.dex */
public class b {
    private static final Logger e = n.a.a.i.b.a(b.class);
    private static final n.a.a.l.b.b f = n.a.a.l.b.b.f;
    private final SecretKeySpec a;
    private final byte[] b;
    private final File c;
    private f d;

    public b() throws IOException {
        byte[] bArr = new byte[16];
        this.b = bArr;
        byte[] bArr2 = new byte[16];
        c1.a().nextBytes(bArr);
        c1.a().nextBytes(bArr2);
        this.a = new SecretKeySpec(bArr2, f.c);
        this.c = k1.a("poi-temp-data", ".tmp");
    }

    public void a() {
        if (this.c.delete()) {
            return;
        }
        LogBuilder logBuilderAtWarn = e.atWarn();
        final File file = this.c;
        file.getClass();
        logBuilderAtWarn.log("{} can't be removed (or was already removed).", new Supplier() { // from class: n.a.a.l.b.f.a
            @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
            public final Object get() {
                return file.getAbsolutePath();
            }
        });
    }

    public long b() {
        f fVar = this.d;
        if (fVar == null) {
            return 0L;
        }
        return fVar.f();
    }

    public InputStream c() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return new CipherInputStream(Files.newInputStream(this.c.toPath(), new OpenOption[0]), d.b(this.a, f, n.a.a.l.b.a.cbc, this.b, 2, "PKCS5Padding"));
    }

    public OutputStream d() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, NoSuchProviderException, InvalidAlgorithmParameterException {
        f fVar = new f(new CipherOutputStream(Files.newOutputStream(this.c.toPath(), new OpenOption[0]), d.b(this.a, f, n.a.a.l.b.a.cbc, this.b, 1, "PKCS5Padding")));
        this.d = fVar;
        return fVar;
    }
}
