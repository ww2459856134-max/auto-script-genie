package l.a.a.e.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class i extends OutputStream implements h {
    private RandomAccessFile c;
    private long d;
    private File e;
    private int f;
    private long g;

    /* renamed from: h, reason: collision with root package name */
    private l.a.a.i.g f2213h;

    public i(File file) throws l.a.a.c.b, FileNotFoundException {
        this(file, -1L);
    }

    private boolean i(int i2) {
        long j2 = this.d;
        return j2 < 65536 || this.g + ((long) i2) <= j2;
    }

    private boolean j(byte[] bArr) {
        int iD = this.f2213h.d(bArr);
        for (l.a.a.d.c cVar : l.a.a.d.c.values()) {
            if (cVar != l.a.a.d.c.SPLIT_ZIP && cVar.a() == iD) {
                return true;
            }
        }
        return false;
    }

    private void p() throws IOException {
        String str;
        String strR = l.a.a.i.d.r(this.e.getName());
        String absolutePath = this.e.getAbsolutePath();
        if (this.e.getParent() == null) {
            str = "";
        } else {
            str = this.e.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.f + 1);
        if (this.f >= 9) {
            str2 = ".z" + (this.f + 1);
        }
        File file = new File(str + strR + str2);
        this.c.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        }
        if (!this.e.renameTo(file)) {
            throw new IOException("cannot rename newly created split file");
        }
        this.e = new File(absolutePath);
        this.c = new RandomAccessFile(this.e, l.a.a.f.t.f.WRITE.a());
        this.f++;
    }

    @Override // l.a.a.e.b.h
    public long a() throws IOException {
        return this.c.getFilePointer();
    }

    @Override // l.a.a.e.b.h
    public int c() {
        return this.f;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    public boolean d(int i2) throws l.a.a.c.b {
        if (i2 < 0) {
            throw new l.a.a.c.b("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        }
        if (i(i2)) {
            return false;
        }
        try {
            p();
            this.g = 0L;
            return true;
        } catch (IOException e) {
            throw new l.a.a.c.b(e);
        }
    }

    public long f() {
        return this.d;
    }

    public boolean m() {
        return this.d != -1;
    }

    public void n(long j2) throws IOException {
        this.c.seek(j2);
    }

    public int o(int i2) throws IOException {
        return this.c.skipBytes(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public i(File file, long j2) throws l.a.a.c.b, FileNotFoundException {
        this.f2213h = new l.a.a.i.g();
        if (j2 >= 0 && j2 < 65536) {
            throw new l.a.a.c.b("split length less than minimum allowed split length of 65536 Bytes");
        }
        this.c = new RandomAccessFile(file, l.a.a.f.t.f.WRITE.a());
        this.d = j2;
        this.e = file;
        this.f = 0;
        this.g = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 <= 0) {
            return;
        }
        long j2 = this.d;
        if (j2 == -1) {
            this.c.write(bArr, i2, i3);
            this.g += i3;
            return;
        }
        long j3 = this.g;
        if (j3 >= j2) {
            p();
            this.c.write(bArr, i2, i3);
            this.g = i3;
            return;
        }
        long j4 = i3;
        if (j3 + j4 > j2) {
            if (j(bArr)) {
                p();
                this.c.write(bArr, i2, i3);
                this.g = j4;
                return;
            }
            this.c.write(bArr, i2, (int) (this.d - this.g));
            p();
            RandomAccessFile randomAccessFile = this.c;
            long j5 = this.d;
            long j6 = this.g;
            randomAccessFile.write(bArr, i2 + ((int) (j5 - j6)), (int) (j4 - (j5 - j6)));
            this.g = j4 - (this.d - this.g);
            return;
        }
        this.c.write(bArr, i2, i3);
        this.g += j4;
    }
}
