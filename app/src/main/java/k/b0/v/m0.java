package k.b0.v;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
class m0 implements g0 {
    private File a;
    private RandomAccessFile b;

    static {
        k.y.c.b(m0.class);
    }

    public m0(File file) throws IOException {
        File fileCreateTempFile = File.createTempFile("jxl", ".tmp", file);
        this.a = fileCreateTempFile;
        fileCreateTempFile.deleteOnExit();
        this.b = new RandomAccessFile(this.a, "rw");
    }

    @Override // k.b0.v.g0
    public void a(byte[] bArr, int i2) throws IOException {
        long filePointer = this.b.getFilePointer();
        this.b.seek(i2);
        this.b.write(bArr);
        this.b.seek(filePointer);
    }

    @Override // k.b0.v.g0
    public void b(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        this.b.seek(0L);
        while (true) {
            int i2 = this.b.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    @Override // k.b0.v.g0
    public int c() throws IOException {
        return (int) this.b.getFilePointer();
    }

    @Override // k.b0.v.g0
    public void close() throws IOException {
        this.b.close();
        this.a.delete();
    }

    @Override // k.b0.v.g0
    public void write(byte[] bArr) throws IOException {
        this.b.write(bArr);
    }
}
