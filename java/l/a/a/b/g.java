package l.a.a.b;

/* loaded from: classes.dex */
public class g implements d {
    private l.a.a.b.i.b a = new l.a.a.b.i.b();

    public g(char[] cArr, long j2, long j3, byte[] bArr, boolean z) throws l.a.a.c.b {
        b(bArr, cArr, j3, j2, z);
    }

    private void b(byte[] bArr, char[] cArr, long j2, long j3, boolean z) throws l.a.a.c.b {
        byte b;
        if (cArr == null || cArr.length <= 0) {
            throw new l.a.a.c.b("Wrong password!", l.a.a.c.a.WRONG_PASSWORD);
        }
        this.a.c(cArr, z);
        int i2 = 0;
        byte b2 = bArr[0];
        while (i2 < 12) {
            i2++;
            if (i2 == 12 && (b = (byte) (this.a.b() ^ b2)) != ((byte) (j3 >> 24)) && b != ((byte) (j2 >> 8))) {
                throw new l.a.a.c.b("Wrong password!", l.a.a.c.a.WRONG_PASSWORD);
            }
            l.a.a.b.i.b bVar = this.a;
            bVar.d((byte) (bVar.b() ^ b2));
            if (i2 != 12) {
                b2 = bArr[i2];
            }
        }
    }

    @Override // l.a.a.b.d
    public int a(byte[] bArr, int i2, int i3) throws l.a.a.c.b {
        if (i2 < 0 || i3 < 0) {
            throw new l.a.a.c.b("one of the input parameters were null in standard decrypt data");
        }
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            byte b = (byte) (((bArr[i4] & 255) ^ this.a.b()) & 255);
            this.a.d(b);
            bArr[i4] = b;
        }
        return i3;
    }
}
