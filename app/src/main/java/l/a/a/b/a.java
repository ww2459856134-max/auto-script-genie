package l.a.a.b;

import java.util.Arrays;

/* loaded from: classes.dex */
public class a implements d {
    private l.a.a.b.i.a a;
    private l.a.a.b.f.a b;
    private int c = 1;
    private byte[] d = new byte[16];
    private byte[] e = new byte[16];

    public a(l.a.a.f.a aVar, char[] cArr, byte[] bArr, byte[] bArr2, boolean z) throws l.a.a.c.b {
        c(bArr, bArr2, cArr, aVar, z);
    }

    private void c(byte[] bArr, byte[] bArr2, char[] cArr, l.a.a.f.a aVar, boolean z) throws l.a.a.c.b {
        if (cArr == null || cArr.length <= 0) {
            throw new l.a.a.c.b("empty or null password provided for AES decryption", l.a.a.c.a.WRONG_PASSWORD);
        }
        l.a.a.f.t.a aVarC = aVar.c();
        byte[] bArrA = c.a(bArr, cArr, aVarC, z);
        if (!Arrays.equals(bArr2, c.b(bArrA, aVarC))) {
            throw new l.a.a.c.b("Wrong Password", l.a.a.c.a.WRONG_PASSWORD);
        }
        this.a = c.c(bArrA, aVarC);
        this.b = c.d(bArrA, aVarC);
    }

    @Override // l.a.a.b.d
    public int a(byte[] bArr, int i2, int i3) throws l.a.a.c.b {
        int i4 = i2;
        while (true) {
            int i5 = i2 + i3;
            if (i4 >= i5) {
                return i3;
            }
            int i6 = i4 + 16;
            int i7 = i6 <= i5 ? 16 : i5 - i4;
            this.b.g(bArr, i4, i7);
            c.e(this.d, this.c);
            this.a.e(this.d, this.e);
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = i4 + i8;
                bArr[i9] = (byte) (bArr[i9] ^ this.e[i8]);
            }
            this.c++;
            i4 = i6;
        }
    }

    public byte[] b(int i2) {
        return this.b.e(i2);
    }
}
