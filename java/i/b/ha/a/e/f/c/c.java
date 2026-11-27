package i.b.ha.a.e.f.c;

import i.b.ha.a.e.g.j;
import java.io.Serializable;

/* loaded from: classes.dex */
public class c implements Serializable {
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;

    /* renamed from: h, reason: collision with root package name */
    private long f1490h;

    /* renamed from: i, reason: collision with root package name */
    private double f1491i;

    /* renamed from: j, reason: collision with root package name */
    private double f1492j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f1493k;

    public c() {
        this(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(double d, double d2) {
        long j2;
        long j3 = this.f1490h;
        if (j3 != 0) {
            if (this.f1493k) {
                double d3 = j3 + 1.0d;
                double d4 = j3 / (j3 + 1.0d);
                double d5 = this.f1491i;
                double d6 = d - d5;
                j2 = j3;
                double d7 = this.f1492j;
                double d8 = d2 - d7;
                this.d += d6 * d6 * d4;
                this.f += d8 * d8 * d4;
                this.g += d6 * d8 * d4;
                this.f1491i = d5 + (d6 / d3);
                this.f1492j = d7 + (d8 / d3);
            }
            if (!this.f1493k) {
                this.d += d * d;
                this.f += d2 * d2;
                this.g += d * d2;
            }
            this.c += d;
            this.e += d2;
            this.f1490h = j2 + 1;
        }
        this.f1491i = d;
        this.f1492j = d2;
        j2 = j3;
        if (!this.f1493k) {
        }
        this.c += d;
        this.e += d2;
        this.f1490h = j2 + 1;
    }

    public double b() {
        double d = d();
        double dB = j.B(c());
        return d < 0.0d ? -dB : dB;
    }

    public double c() {
        double dF = f();
        return (dF - e()) / dF;
    }

    public double d() {
        if (this.f1490h >= 2 && j.a(this.d) >= 4.9E-323d) {
            return this.g / this.d;
        }
        return Double.NaN;
    }

    public double e() {
        double d = this.f;
        double d2 = this.g;
        return j.n(0.0d, d - ((d2 * d2) / this.d));
    }

    public double f() {
        if (this.f1490h < 2) {
            return Double.NaN;
        }
        return this.f;
    }

    public c(boolean z) {
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0d;
        this.f1490h = 0L;
        this.f1491i = 0.0d;
        this.f1492j = 0.0d;
        this.f1493k = z;
    }
}
