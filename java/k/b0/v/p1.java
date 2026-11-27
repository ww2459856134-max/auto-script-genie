package k.b0.v;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes.dex */
public abstract class p1 extends o {

    /* renamed from: n, reason: collision with root package name */
    private static DecimalFormat f1922n = new DecimalFormat("#.###");

    /* renamed from: l, reason: collision with root package name */
    private double f1923l;

    /* renamed from: m, reason: collision with root package name */
    private NumberFormat f1924m;

    protected p1(k.p pVar) {
        super(k.x.z0.z, pVar);
        this.f1923l = pVar.getValue();
    }

    @Override // k.c
    public k.f getType() {
        return k.f.d;
    }

    public double getValue() {
        return this.f1923l;
    }

    @Override // k.c
    public String p() {
        if (this.f1924m == null) {
            NumberFormat numberFormatH = ((k.x.h1) e()).H();
            this.f1924m = numberFormatH;
            if (numberFormatH == null) {
                this.f1924m = f1922n;
            }
        }
        return this.f1924m.format(this.f1923l);
    }

    @Override // k.b0.v.o, k.x.c1
    public byte[] y() {
        byte[] bArrY = super.y();
        byte[] bArr = new byte[bArrY.length + 8];
        System.arraycopy(bArrY, 0, bArr, 0, bArrY.length);
        k.x.c0.a(this.f1923l, bArr, bArrY.length);
        return bArr;
    }
}
