package k.b0.v;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class z extends o {

    /* renamed from: o, reason: collision with root package name */
    static final k.b0.m f1986o;

    /* renamed from: l, reason: collision with root package name */
    private double f1987l;

    /* renamed from: m, reason: collision with root package name */
    private Date f1988m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1989n;

    static {
        k.y.c.b(z.class);
        f1986o = new k.b0.m(k.b0.e.b);
    }

    protected z(k.g gVar) {
        super(k.x.z0.z, gVar);
        this.f1988m = gVar.getDate();
        this.f1989n = gVar.i();
        I(false);
    }

    private void I(boolean z) {
        long j2;
        long j3 = 0;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.f1988m);
            j3 = calendar.get(15);
            j2 = calendar.get(16);
        } else {
            j2 = 0;
        }
        double time = (((this.f1988m.getTime() + j3) + j2) / 8.64E7d) + 25569.0d;
        this.f1987l = time;
        boolean z2 = this.f1989n;
        if (!z2 && time < 61.0d) {
            this.f1987l = time - 1.0d;
        }
        if (z2) {
            this.f1987l = this.f1987l - ((int) r0);
        }
    }

    public Date getDate() {
        return this.f1988m;
    }

    @Override // k.c
    public k.f getType() {
        return k.f.f1994l;
    }

    public boolean i() {
        return this.f1989n;
    }

    @Override // k.c
    public String p() {
        return this.f1988m.toString();
    }

    @Override // k.b0.v.o, k.x.c1
    public byte[] y() {
        byte[] bArrY = super.y();
        byte[] bArr = new byte[bArrY.length + 8];
        System.arraycopy(bArrY, 0, bArr, 0, bArrY.length);
        k.x.c0.a(this.f1987l, bArr, bArrY.length);
        return bArr;
    }
}
