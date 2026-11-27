package k.b0.v;

/* loaded from: classes.dex */
public abstract class h extends o {

    /* renamed from: l, reason: collision with root package name */
    private boolean f1902l;

    protected h(k.a aVar) {
        super(k.x.z0.J, aVar);
        this.f1902l = aVar.getValue();
    }

    @Override // k.c
    public k.f getType() {
        return k.f.e;
    }

    public boolean getValue() {
        return this.f1902l;
    }

    @Override // k.c
    public String p() {
        return new Boolean(this.f1902l).toString();
    }

    @Override // k.b0.v.o, k.x.c1
    public byte[] y() {
        byte[] bArrY = super.y();
        byte[] bArr = new byte[bArrY.length + 2];
        System.arraycopy(bArrY, 0, bArr, 0, bArrY.length);
        if (this.f1902l) {
            bArr[bArrY.length] = 1;
        }
        return bArr;
    }
}
