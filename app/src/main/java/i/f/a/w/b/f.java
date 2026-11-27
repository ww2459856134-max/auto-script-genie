package i.f.a.w.b;

/* loaded from: classes.dex */
public final class f {
    private final i.f.a.v.n.c a = new i.f.a.v.n.c(i.f.a.v.n.a.f1692m);

    private void a(byte[] bArr, int i2) throws i.f.a.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (i.f.a.v.n.e unused) {
            throw i.f.a.d.a();
        }
    }

    public i.f.a.v.e b(i.f.a.v.b bVar) throws i.f.a.d, i.f.a.g {
        a aVar = new a(bVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar2 : bVarArrB) {
            iC += bVar2.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        for (int i2 = 0; i2 < length; i2++) {
            b bVar3 = bVarArrB[i2];
            byte[] bArrA = bVar3.a();
            int iC2 = bVar3.c();
            a(bArrA, iC2);
            for (int i3 = 0; i3 < iC2; i3++) {
                bArr[(i3 * length) + i2] = bArrA[i3];
            }
        }
        return e.a(bArr);
    }
}
