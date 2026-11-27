package l.a.a.b.f;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Objects;
import l.a.a.i.i;

/* loaded from: classes.dex */
public class b {
    private c a;
    private d b;

    public b(c cVar) {
        this(cVar, null);
    }

    private byte[] b(d dVar, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int iA = dVar.a();
        int iE = e(i3, iA);
        int i4 = i3 - ((iE - 1) * iA);
        byte[] bArr3 = new byte[iE * iA];
        int i5 = 0;
        for (int i6 = 1; i6 <= iE; i6++) {
            c(bArr3, i5, dVar, bArr2, i2, i6);
            i5 += iA;
        }
        if (i4 >= iA) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr3, 0, bArr4, 0, i3);
        return bArr4;
    }

    private void c(byte[] bArr, int i2, d dVar, byte[] bArr2, int i3, int i4) {
        int iA = dVar.a();
        byte[] bArr3 = new byte[iA];
        byte[] bArrC = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArrC, 0, bArr2.length);
        a(bArrC, bArr2.length, i4);
        for (int i5 = 0; i5 < i3; i5++) {
            bArrC = dVar.c(bArrC);
            g(bArr3, bArrC);
        }
        System.arraycopy(bArr3, 0, bArr, i2, iA);
    }

    private void d(byte[] bArr) {
        if (this.b == null) {
            this.b = new a(this.a.a());
        }
        this.b.b(bArr);
    }

    private int e(int i2, int i3) {
        return (i2 / i3) + (i2 % i3 > 0 ? 1 : 0);
    }

    private void g(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    protected void a(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 / 16777216);
        bArr[i2 + 1] = (byte) (i3 / WXMediaMessage.THUMB_LENGTH_LIMIT);
        bArr[i2 + 2] = (byte) (i3 / 256);
        bArr[i2 + 3] = (byte) i3;
    }

    public byte[] f(char[] cArr, int i2, boolean z) {
        Objects.requireNonNull(cArr);
        d(i.a(cArr, z));
        if (i2 == 0) {
            i2 = this.b.a();
        }
        return b(this.b, this.a.c(), this.a.b(), i2);
    }

    public b(c cVar, d dVar) {
        this.a = cVar;
        this.b = dVar;
    }
}
