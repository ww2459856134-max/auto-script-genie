package n.a.a.l.d;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import n.a.a.o.w0;

/* loaded from: classes.dex */
public class a extends b {
    private byte[] a;
    private long b;

    public a(byte[] bArr, int i2) {
        this.a = bArr;
        this.b = i2;
    }

    private void f(long j2) {
        byte[] bArr = this.a;
        long length = j2 - bArr.length;
        if (length < bArr.length * 0.25d) {
            length = (long) (bArr.length * 0.25d);
        }
        if (length < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
            length = 4096;
        }
        byte[] bArrL = w0.l(length + bArr.length, Integer.MAX_VALUE);
        System.arraycopy(this.a, 0, bArrL, 0, (int) this.b);
        this.a = bArrL;
    }

    @Override // n.a.a.l.d.b
    public void a() {
        this.a = null;
        this.b = -1L;
    }

    @Override // n.a.a.l.d.b
    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(this.a, 0, (int) this.b);
    }

    @Override // n.a.a.l.d.b
    public ByteBuffer c(int i2, long j2) {
        long j3 = this.b;
        if (j2 < j3) {
            return ByteBuffer.wrap(this.a, (int) j2, (int) Math.min(i2, j3 - j2));
        }
        throw new IndexOutOfBoundsException("Unable to read " + i2 + " bytes from " + j2 + " in stream of length " + this.b);
    }

    @Override // n.a.a.l.d.b
    public long d() {
        return this.b;
    }

    @Override // n.a.a.l.d.b
    public void e(ByteBuffer byteBuffer, long j2) {
        long jCapacity = byteBuffer.capacity() + j2;
        if (jCapacity > this.a.length) {
            f(jCapacity);
        }
        byteBuffer.get(this.a, (int) j2, byteBuffer.capacity());
        if (jCapacity > this.b) {
            this.b = jCapacity;
        }
    }

    public a(byte[] bArr) {
        this(bArr, bArr.length);
    }
}
