package i.e.a.k;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: classes.dex */
public final class b extends r {
    final byte[] c;

    protected b(String str, byte[] bArr) {
        super(str);
        this.c = bArr;
    }

    @Override // i.e.a.k.r
    public int a(byte[] bArr, int i2) {
        byte[] bArr2 = this.c;
        int length = bArr2.length;
        System.arraycopy(bArr2, 0, bArr, i2, length);
        return length;
    }

    @Override // i.e.a.k.r
    public int b(char[] cArr, int i2) {
        throw new RuntimeException("Internal error: appendChars() should never be called");
    }

    @Override // i.e.a.k.r
    public final int h() {
        return this.c.length;
    }

    @Override // i.e.a.k.r
    public void i(OutputStream outputStream) throws IOException {
        outputStream.write(this.c);
    }

    @Override // i.e.a.k.r
    public void j(Writer writer) throws IOException {
        throw new RuntimeException("Internal error: writeChars() should never be called");
    }

    protected b(String str, String str2, byte[] bArr) {
        super(str, str2);
        this.c = bArr;
    }
}
