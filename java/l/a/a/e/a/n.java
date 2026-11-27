package l.a.a.e.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class n extends i {
    protected RandomAccessFile c;
    protected File d;
    private int e;
    private boolean f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f2212h = new byte[1];

    public n(File file, boolean z, int i2) throws FileNotFoundException {
        this.g = 0;
        this.c = new RandomAccessFile(file, l.a.a.f.t.f.READ.a());
        this.d = file;
        this.f = z;
        this.e = i2;
        if (z) {
            this.g = i2;
        }
    }

    @Override // l.a.a.e.a.i
    public void a(l.a.a.f.i iVar) throws IOException {
        if (this.f && this.g != iVar.N()) {
            d(iVar.N());
            this.g = iVar.N();
        }
        this.c.seek(iVar.Q());
    }

    protected File c(int i2) throws IOException {
        if (i2 == this.e) {
            return this.d;
        }
        String canonicalPath = this.d.getCanonicalPath();
        return new File(canonicalPath.substring(0, canonicalPath.lastIndexOf(".")) + (i2 >= 9 ? ".z" : ".z0") + (i2 + 1));
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    protected void d(int i2) throws IOException {
        File fileC = c(i2);
        if (fileC.exists()) {
            this.c.close();
            this.c = new RandomAccessFile(fileC, l.a.a.f.t.f.READ.a());
        } else {
            throw new FileNotFoundException("zip split file does not exist: " + fileC);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f2212h) == -1) {
            return -1;
        }
        return this.f2212h[0];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.c.read(bArr, i2, i3);
        if ((i4 == i3 && i4 != -1) || !this.f) {
            return i4;
        }
        d(this.g + 1);
        this.g++;
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = this.c.read(bArr, i4, i3 - i4);
        return i5 > 0 ? i4 + i5 : i4;
    }
}
