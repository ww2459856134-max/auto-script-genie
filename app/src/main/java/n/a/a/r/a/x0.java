package n.a.a.r.a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class x0 extends n.a.a.j.c {
    private static int b = 100000000;
    protected static final n.a.a.j.l[] c;
    private Long a;

    static {
        n.a.a.j.l[] lVarArr = new n.a.a.j.l[15];
        c = lVarArr;
        lVarArr[n.a.a.e.a.c.EMF.d] = y0.f2529k;
        lVarArr[n.a.a.e.a.c.WMF.d] = y0.f2530l;
        lVarArr[n.a.a.e.a.c.PICT.d] = y0.f2531m;
        lVarArr[n.a.a.e.a.c.JPEG.d] = y0.f2532n;
        lVarArr[n.a.a.e.a.c.PNG.d] = y0.f2533o;
        lVarArr[n.a.a.e.a.c.DIB.d] = y0.p;
        lVarArr[n.a.a.e.a.c.GIF.d] = y0.q;
        lVarArr[n.a.a.e.a.c.TIFF.d] = y0.r;
        lVarArr[n.a.a.e.a.c.EPS.d] = y0.s;
        lVarArr[n.a.a.e.a.c.BMP.d] = y0.t;
        lVarArr[n.a.a.e.a.c.WPG.d] = y0.u;
        lVarArr[n.a.a.e.a.c.WDP.d] = y0.v;
        lVarArr[n.a.a.e.a.c.SVG.d] = y0.w;
    }

    protected x0() {
    }

    public static int K() {
        int iJ = n.a.a.o.w0.j();
        return iJ < 0 ? b : Math.min(b, iJ);
    }

    public Long I() throws IOException {
        if (this.a == null) {
            try {
                InputStream inputStreamM = getPackagePart().m();
                try {
                    this.a = Long.valueOf(n.a.a.o.w0.b(inputStreamM));
                    if (inputStreamM != null) {
                        inputStreamM.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new n.a.a.j.d(e);
            }
        }
        return this.a;
    }

    public byte[] J() throws IOException {
        try {
            InputStream inputStreamM = getPackagePart().m();
            try {
                byte[] bArrS = n.a.a.o.w0.s(inputStreamM, K());
                if (inputStreamM != null) {
                    inputStreamM.close();
                }
                return bArrS;
            } finally {
            }
        } catch (IOException e) {
            throw new n.a.a.j.d(e);
        }
    }

    public boolean equals(Object obj) throws IOException {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        n.a.a.k.b.m packagePart = x0Var.getPackagePart();
        n.a.a.k.b.m packagePart2 = getPackagePart();
        if ((packagePart != null && packagePart2 == null) || (packagePart == null && packagePart2 != null)) {
            return false;
        }
        if (packagePart2 != null) {
            n.a.a.k.b.k kVarQ = packagePart.q();
            n.a.a.k.b.k kVarQ2 = packagePart2.q();
            if ((kVarQ != null && kVarQ2 == null) || (kVarQ == null && kVarQ2 != null)) {
                return false;
            }
            if (kVarQ2 != null && !kVarQ2.equals(kVarQ)) {
                return false;
            }
        }
        Long lI = x0Var.I();
        Long lI2 = I();
        if (lI2 == null) {
            if (lI != null) {
                return false;
            }
        } else if (!lI2.equals(lI)) {
            return false;
        }
        return Arrays.equals(J(), x0Var.J());
    }

    public int hashCode() throws IOException {
        Long lI = I();
        return lI == null ? super.hashCode() : lI.hashCode();
    }

    @Override // n.a.a.j.c
    protected void prepareForCommit() {
    }

    public x0(n.a.a.k.b.m mVar) {
        super(mVar);
    }
}
