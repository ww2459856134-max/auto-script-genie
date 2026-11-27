package l.a.a.e.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class l extends InputStream {
    private boolean A;
    private boolean C;
    private PushbackInputStream c;
    private c d;
    private l.a.a.d.b e;
    private char[] f;
    private l.a.a.i.f g;

    /* renamed from: h, reason: collision with root package name */
    private l.a.a.f.j f2208h;

    /* renamed from: i, reason: collision with root package name */
    private CRC32 f2209i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f2210j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2211k;
    private l.a.a.f.l t;

    public l(InputStream inputStream, char[] cArr, l.a.a.f.l lVar) {
        this(inputStream, cArr, null, lVar);
    }

    private void B(l.a.a.f.j jVar) throws IOException {
        if (s(jVar.j()) || jVar.e() != l.a.a.f.t.d.STORE || jVar.n() >= 0) {
            return;
        }
        throw new IOException("Invalid local file header for: " + jVar.j() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
    }

    private void a() throws IOException {
        if (this.A) {
            throw new IOException("Stream closed");
        }
    }

    private boolean c(List<l.a.a.f.h> list) {
        if (list == null) {
            return false;
        }
        Iterator<l.a.a.f.h> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().d() == l.a.a.d.c.ZIP64_EXTRA_FIELD_SIGNATURE.a()) {
                return true;
            }
        }
        return false;
    }

    private void d() throws IOException {
        this.d.a(this.c, this.d.d(this.c));
        u();
        z();
        x();
        this.C = true;
    }

    private int f(l.a.a.f.a aVar) throws l.a.a.c.b {
        if (aVar == null || aVar.c() == null) {
            throw new l.a.a.c.b("AesExtraDataRecord not found or invalid for Aes encrypted entry");
        }
        return aVar.c().e() + 12;
    }

    private long i(l.a.a.f.j jVar) throws l.a.a.c.b {
        if (l.a.a.i.i.i(jVar).equals(l.a.a.f.t.d.STORE)) {
            return jVar.n();
        }
        if (!jVar.q() || this.f2211k) {
            return jVar.d() - j(jVar);
        }
        return -1L;
    }

    private int j(l.a.a.f.j jVar) throws l.a.a.c.b {
        if (jVar.s()) {
            return jVar.g().equals(l.a.a.f.t.e.AES) ? f(jVar.c()) : jVar.g().equals(l.a.a.f.t.e.ZIP_STANDARD) ? 12 : 0;
        }
        return 0;
    }

    private b<?> n(k kVar, l.a.a.f.j jVar) throws IOException {
        if (!jVar.s()) {
            return new f(kVar, jVar, this.f, this.t.a());
        }
        if (jVar.g() == l.a.a.f.t.e.AES) {
            return new a(kVar, jVar, this.f, this.t.a(), this.t.c());
        }
        if (jVar.g() == l.a.a.f.t.e.ZIP_STANDARD) {
            return new m(kVar, jVar, this.f, this.t.a(), this.t.c());
        }
        throw new l.a.a.c.b(String.format("Entry [%s] Strong Encryption not supported", jVar.j()), l.a.a.c.a.UNSUPPORTED_ENCRYPTION);
    }

    private c o(b<?> bVar, l.a.a.f.j jVar) throws l.a.a.c.b {
        return l.a.a.i.i.i(jVar) == l.a.a.f.t.d.DEFLATE ? new d(bVar, this.t.a()) : new j(bVar);
    }

    private c p(l.a.a.f.j jVar) throws IOException {
        return o(n(new k(this.c, i(jVar)), jVar), jVar);
    }

    private boolean q(l.a.a.f.j jVar) {
        return jVar.s() && l.a.a.f.t.e.ZIP_STANDARD.equals(jVar.g());
    }

    private boolean s(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    private void u() throws IOException {
        if (!this.f2208h.q() || this.f2211k) {
            return;
        }
        l.a.a.f.d dVarJ = this.e.j(this.c, c(this.f2208h.h()));
        this.f2208h.v(dVarJ.c());
        this.f2208h.J(dVarJ.e());
        this.f2208h.x(dVarJ.d());
    }

    private void w() throws IOException {
        if (this.f2210j == null) {
            this.f2210j = new byte[512];
        }
        while (read(this.f2210j) != -1) {
        }
        this.C = true;
    }

    private void x() {
        this.f2208h = null;
        this.f2209i.reset();
    }

    private void z() throws IOException {
        if ((this.f2208h.g() == l.a.a.f.t.e.AES && this.f2208h.c().d().equals(l.a.a.f.t.b.TWO)) || this.f2208h.f() == this.f2209i.getValue()) {
            return;
        }
        l.a.a.c.a aVar = l.a.a.c.a.CHECKSUM_MISMATCH;
        if (q(this.f2208h)) {
            aVar = l.a.a.c.a.WRONG_PASSWORD;
        }
        throw new l.a.a.c.b("Reached end of entry, but crc verification failed for " + this.f2208h.j(), aVar);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        a();
        return !this.C ? 1 : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.A) {
            return;
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.close();
        }
        this.A = true;
    }

    public l.a.a.f.j m(l.a.a.f.i iVar, boolean z) throws IOException {
        l.a.a.i.f fVar;
        if (this.f2208h != null && z) {
            w();
        }
        l.a.a.f.j jVarP = this.e.p(this.c, this.t.b());
        this.f2208h = jVarP;
        if (jVarP == null) {
            return null;
        }
        if (jVarP.s() && this.f == null && (fVar = this.g) != null) {
            y(fVar.getPassword());
        }
        B(this.f2208h);
        this.f2209i.reset();
        if (iVar != null) {
            this.f2208h.x(iVar.f());
            this.f2208h.v(iVar.d());
            this.f2208h.J(iVar.n());
            this.f2208h.z(iVar.r());
            this.f2211k = true;
        } else {
            this.f2211k = false;
        }
        this.d = p(this.f2208h);
        this.C = false;
        return this.f2208h;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public void y(char[] cArr) {
        this.f = cArr;
    }

    private l(InputStream inputStream, char[] cArr, l.a.a.i.f fVar, l.a.a.f.l lVar) {
        this.e = new l.a.a.d.b();
        this.f2209i = new CRC32();
        this.f2211k = false;
        this.A = false;
        this.C = false;
        if (lVar.a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        this.c = new PushbackInputStream(inputStream, lVar.a());
        this.f = cArr;
        this.g = fVar;
        this.t = lVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.A) {
            throw new IOException("Stream closed");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Negative read length");
        }
        if (i3 == 0) {
            return 0;
        }
        if (this.f2208h == null) {
            return -1;
        }
        try {
            int i4 = this.d.read(bArr, i2, i3);
            if (i4 == -1) {
                d();
            } else {
                this.f2209i.update(bArr, i2, i4);
            }
            return i4;
        } catch (IOException e) {
            if (q(this.f2208h)) {
                throw new l.a.a.c.b(e.getMessage(), e.getCause(), l.a.a.c.a.WRONG_PASSWORD);
            }
            throw e;
        }
    }
}
