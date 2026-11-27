package l.a.a.b;

import java.security.InvalidKeyException;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
public abstract class c {
    public static byte[] a(byte[] bArr, char[] cArr, l.a.a.f.t.a aVar, boolean z) throws l.a.a.c.b {
        l.a.a.b.f.b bVar = new l.a.a.b.f.b(new l.a.a.b.f.c("HmacSHA1", "ISO-8859-1", bArr, XmlValidationError.INCORRECT_ATTRIBUTE));
        int iB = aVar.b();
        int iC = aVar.c();
        int i2 = iB + iC + 2;
        byte[] bArrF = bVar.f(cArr, i2, z);
        if (bArrF == null || bArrF.length != i2) {
            throw new l.a.a.c.b(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", Integer.valueOf(iB), Integer.valueOf(iC)));
        }
        return bArrF;
    }

    public static byte[] b(byte[] bArr, l.a.a.f.t.a aVar) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, aVar.b() + aVar.c(), bArr2, 0, 2);
        return bArr2;
    }

    public static l.a.a.b.i.a c(byte[] bArr, l.a.a.f.t.a aVar) throws l.a.a.c.b {
        int iB = aVar.b();
        byte[] bArr2 = new byte[iB];
        System.arraycopy(bArr, 0, bArr2, 0, iB);
        return new l.a.a.b.i.a(bArr2);
    }

    public static l.a.a.b.f.a d(byte[] bArr, l.a.a.f.t.a aVar) throws InvalidKeyException {
        int iC = aVar.c();
        byte[] bArr2 = new byte[iC];
        System.arraycopy(bArr, aVar.b(), bArr2, 0, iC);
        l.a.a.b.f.a aVar2 = new l.a.a.b.f.a("HmacSHA1");
        aVar2.b(bArr2);
        return aVar2;
    }

    public static void e(byte[] bArr, int i2) {
        bArr[0] = (byte) i2;
        bArr[1] = (byte) (i2 >> 8);
        bArr[2] = (byte) (i2 >> 16);
        bArr[3] = (byte) (i2 >> 24);
        for (int i3 = 4; i3 <= 15; i3++) {
            bArr[i3] = 0;
        }
    }
}
