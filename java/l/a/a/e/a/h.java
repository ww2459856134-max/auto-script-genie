package l.a.a.e.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class h extends RandomAccessFile {
    private long c;
    private File[] d;
    private RandomAccessFile e;
    private byte[] f;
    private int g;

    /* renamed from: h, reason: collision with root package name */
    private String f2207h;

    public h(File file, String str) throws IOException {
        this(file, str, l.a.a.i.d.h(file));
    }

    private void a(File[] fileArr) throws IOException {
        int i2 = 1;
        for (File file : fileArr) {
            String strK = l.a.a.i.d.k(file);
            try {
                if (i2 != Integer.parseInt(strK)) {
                    throw new IOException("Split file number " + i2 + " does not exist");
                }
                i2++;
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + strK + " expected of format: .001, .002, etc");
            }
        }
    }

    private void d(int i2) throws IOException {
        if (this.g == i2) {
            return;
        }
        if (i2 > this.d.length - 1) {
            throw new IOException("split counter greater than number of split files");
        }
        RandomAccessFile randomAccessFile = this.e;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.e = new RandomAccessFile(this.d[i2], this.f2207h);
        this.g = i2;
    }

    public void c() throws IOException {
        d(this.d.length - 1);
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.e;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        super.close();
    }

    public void f(long j2) throws IOException {
        this.e.seek(j2);
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws IOException {
        return this.e.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long length() throws IOException {
        return this.e.length();
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        if (read(this.f) == -1) {
            return -1;
        }
        return this.f[0] & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j2) throws IOException {
        int i2 = (int) (j2 / this.c);
        if (i2 != this.g) {
            d(i2);
        }
        this.e.seek(j2 - (i2 * this.c));
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    public h(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.f = new byte[1];
        this.g = 0;
        super.close();
        if (l.a.a.f.t.f.WRITE.a().equals(str)) {
            throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
        }
        a(fileArr);
        this.e = new RandomAccessFile(file, str);
        this.d = fileArr;
        this.c = file.length();
        this.f2207h = str;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
        throw null;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.e.read(bArr, i2, i3);
        if (i4 != -1) {
            return i4;
        }
        int i5 = this.g;
        if (i5 == this.d.length - 1) {
            return -1;
        }
        d(i5 + 1);
        return read(bArr, i2, i3);
    }
}
