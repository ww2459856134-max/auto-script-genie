package i.e.a.k;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class d extends r {
    final char[] c;

    public d(String str) {
        super(str);
        this.c = str.toCharArray();
    }

    @Override // i.e.a.k.r
    public int a(byte[] bArr, int i2) {
        throw new RuntimeException("Internal error: appendBytes() should never be called");
    }

    @Override // i.e.a.k.r
    public int b(char[] cArr, int i2) {
        char[] cArr2 = this.c;
        int length = cArr2.length;
        System.arraycopy(cArr2, 0, cArr, i2, length);
        return length;
    }

    @Override // i.e.a.k.r
    public final int h() {
        return this.c.length;
    }

    @Override // i.e.a.k.r
    public void i(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Internal error: writeBytes() should never be called");
    }

    @Override // i.e.a.k.r
    public void j(Writer writer) throws IOException {
        writer.write(this.c);
    }

    @Override // i.e.a.k.r
    public String toString() {
        return this.a != null ? new String(this.c) : this.b;
    }

    public d(String str, String str2) {
        super(str, str2);
        int length = str.length();
        int length2 = str2.length();
        int i2 = length + 1;
        char[] cArr = new char[i2 + length2];
        this.c = cArr;
        str.getChars(0, length, cArr, 0);
        cArr[length] = NameUtil.COLON;
        str2.getChars(0, length2, cArr, i2);
    }
}
