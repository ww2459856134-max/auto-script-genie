package i.f.a;

/* loaded from: classes.dex */
public final class h extends i {
    private final i c;

    public h(i iVar) {
        super(iVar.d(), iVar.a());
        this.c = iVar;
    }

    @Override // i.f.a.i
    public byte[] b() {
        byte[] bArrB = this.c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            bArr[i2] = (byte) (255 - (bArrB[i2] & 255));
        }
        return bArr;
    }

    @Override // i.f.a.i
    public byte[] c(int i2, byte[] bArr) {
        byte[] bArrC = this.c.c(i2, bArr);
        int iD = d();
        for (int i3 = 0; i3 < iD; i3++) {
            bArrC[i3] = (byte) (255 - (bArrC[i3] & 255));
        }
        return bArrC;
    }

    @Override // i.f.a.i
    public i e() {
        return this.c;
    }

    @Override // i.f.a.i
    public boolean f() {
        return this.c.f();
    }

    @Override // i.f.a.i
    public i g() {
        return new h(this.c.g());
    }
}
