package l.a.a.b;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public class b implements e {
    private l.a.a.b.i.a a;
    private l.a.a.b.f.a b;
    private boolean d;
    private final byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f2189h;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f2190i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f2191j;
    private final SecureRandom c = new SecureRandom();
    private int e = 1;
    private int f = 0;

    public b(char[] cArr, l.a.a.f.t.a aVar, boolean z) throws l.a.a.c.b {
        if (cArr == null || cArr.length == 0) {
            throw new l.a.a.c.b("input password is empty or null");
        }
        if (aVar != l.a.a.f.t.a.KEY_STRENGTH_128 && aVar != l.a.a.f.t.a.KEY_STRENGTH_256) {
            throw new l.a.a.c.b("Invalid AES key strength");
        }
        this.d = false;
        this.f2189h = new byte[16];
        this.g = new byte[16];
        f(cArr, aVar, z);
    }

    private byte[] b(int i2) throws l.a.a.c.b {
        if (i2 != 8 && i2 != 16) {
            throw new l.a.a.c.b("invalid salt size, cannot generate salt");
        }
        int i3 = i2 == 8 ? 2 : 4;
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i3; i4++) {
            int iNextInt = this.c.nextInt();
            int i5 = i4 * 4;
            bArr[i5] = (byte) (iNextInt >> 24);
            bArr[i5 + 1] = (byte) (iNextInt >> 16);
            bArr[i5 + 2] = (byte) (iNextInt >> 8);
            bArr[i5 + 3] = (byte) iNextInt;
        }
        return bArr;
    }

    private void f(char[] cArr, l.a.a.f.t.a aVar, boolean z) throws l.a.a.c.b {
        byte[] bArrB = b(aVar.e());
        this.f2191j = bArrB;
        byte[] bArrA = c.a(bArrB, cArr, aVar, z);
        this.f2190i = c.b(bArrA, aVar);
        this.a = c.c(bArrA, aVar);
        this.b = c.d(bArrA, aVar);
    }

    @Override // l.a.a.b.e
    public int a(byte[] bArr, int i2, int i3) throws l.a.a.c.b {
        int i4;
        if (this.d) {
            throw new l.a.a.c.b("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
        if (i3 % 16 != 0) {
            this.d = true;
        }
        int i5 = i2;
        while (true) {
            int i6 = i2 + i3;
            if (i5 >= i6) {
                return i3;
            }
            int i7 = i5 + 16;
            this.f = i7 <= i6 ? 16 : i6 - i5;
            c.e(this.g, this.e);
            this.a.e(this.g, this.f2189h);
            int i8 = 0;
            while (true) {
                i4 = this.f;
                if (i8 < i4) {
                    int i9 = i5 + i8;
                    bArr[i9] = (byte) (bArr[i9] ^ this.f2189h[i8]);
                    i8++;
                }
            }
            this.b.g(bArr, i5, i4);
            this.e++;
            i5 = i7;
        }
    }

    public byte[] c() {
        return this.f2190i;
    }

    public byte[] d() {
        byte[] bArr = new byte[10];
        System.arraycopy(this.b.d(), 0, bArr, 0, 10);
        return bArr;
    }

    public byte[] e() {
        return this.f2191j;
    }
}
