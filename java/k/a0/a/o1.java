package k.a0.a;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class o1 extends k.x.w0 {

    /* renamed from: i, reason: collision with root package name */
    private static k.y.c f1827i = k.y.c.b(o1.class);

    /* renamed from: j, reason: collision with root package name */
    public static m1 f1828j = new m1();
    private String c;
    private k.x.i d;
    private int e;
    private int f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f1829h;

    o1(f2 f2Var, k.w wVar, int i2) {
        super(f2Var);
        this.f = 0;
        this.e = i2;
        this.g = true;
        try {
            this.f1829h = new ArrayList();
            byte[] bArrC = x().c();
            int iC = k.x.s0.c(bArrC[0], bArrC[1]);
            byte b = bArrC[3];
            this.f = k.x.s0.c(bArrC[8], bArrC[9]);
            if ((iC & 32) != 0) {
                this.d = k.x.i.a(bArrC[15]);
            } else {
                this.c = k.x.y0.d(bArrC, b, 15, wVar);
            }
            if ((iC & 12) != 0) {
                return;
            }
            int i3 = b + 15;
            if (bArrC[i3] == 58) {
                int iC2 = k.x.s0.c(bArrC[i3 + 1], bArrC[i3 + 2]);
                int iC3 = k.x.s0.c(bArrC[i3 + 3], bArrC[i3 + 4]);
                int iC4 = k.x.s0.c(bArrC[i3 + 5], bArrC[i3 + 6]);
                int i4 = iC4 & 255;
                k.y.a.a((iC4 & 786432) == 0);
                this.f1829h.add(new n1(this, iC2, i4, iC3, i4, iC3));
                return;
            }
            if (bArrC[i3] == 59) {
                for (int i5 = i3; i5 < bArrC.length; i5 += 11) {
                    int iC5 = k.x.s0.c(bArrC[i5 + 1], bArrC[i5 + 2]);
                    int iC6 = k.x.s0.c(bArrC[i5 + 3], bArrC[i5 + 4]);
                    int iC7 = k.x.s0.c(bArrC[i5 + 5], bArrC[i5 + 6]);
                    int iC8 = k.x.s0.c(bArrC[i5 + 7], bArrC[i5 + 8]);
                    int i6 = iC8 & 255;
                    k.y.a.a((iC8 & 786432) == 0);
                    int iC9 = k.x.s0.c(bArrC[i5 + 9], bArrC[i5 + 10]);
                    int i7 = iC9 & 255;
                    k.y.a.a((iC9 & 786432) == 0);
                    this.f1829h.add(new n1(this, iC5, i6, iC6, i7, iC7));
                }
                return;
            }
            if (bArrC[i3] != 41) {
                String strB = this.c;
                if (strB == null) {
                    strB = this.d.b();
                }
                f1827i.f("Cannot read name ranges for " + strB + " - setting to empty");
                this.f1829h.add(new n1(this, 0, 0, 0, 0, 0));
                return;
            }
            if (i3 < bArrC.length && bArrC[i3] != 58 && bArrC[i3] != 59) {
                if (bArrC[i3] == 41) {
                    i3 += 3;
                } else if (bArrC[i3] == 16) {
                    i3++;
                }
            }
            int i8 = i3;
            while (i8 < bArrC.length) {
                int iC10 = k.x.s0.c(bArrC[i8 + 1], bArrC[i8 + 2]);
                int iC11 = k.x.s0.c(bArrC[i8 + 3], bArrC[i8 + 4]);
                int iC12 = k.x.s0.c(bArrC[i8 + 5], bArrC[i8 + 6]);
                int iC13 = k.x.s0.c(bArrC[i8 + 7], bArrC[i8 + 8]);
                int i9 = iC13 & 255;
                k.y.a.a((iC13 & 786432) == 0 ? true : z);
                int iC14 = k.x.s0.c(bArrC[i8 + 9], bArrC[i8 + 10]);
                int i10 = iC14 & 255;
                k.y.a.a((iC14 & 786432) == 0 ? true : z);
                this.f1829h.add(new n1(this, iC10, i9, iC11, i10, iC12));
                i8 += 11;
                if (i8 < bArrC.length && bArrC[i8] != 58 && bArrC[i8] != 59) {
                    if (bArrC[i8] == 41) {
                        i8 += 3;
                    } else if (bArrC[i8] == 16) {
                        i8++;
                    }
                }
                z = false;
            }
        } catch (Throwable unused) {
            f1827i.f("Cannot read name");
            this.c = "ERROR";
        }
    }

    int A() {
        return this.e;
    }

    public n1[] B() {
        return (n1[]) this.f1829h.toArray(new n1[this.f1829h.size()]);
    }

    public int C() {
        return this.f;
    }

    public boolean D() {
        return this.g;
    }

    public boolean E() {
        return this.f == 0;
    }

    public String getName() {
        return this.c;
    }

    public k.x.i y() {
        return this.d;
    }

    public byte[] z() {
        return x().c();
    }

    o1(f2 f2Var, k.w wVar, int i2, m1 m1Var) {
        super(f2Var);
        this.f = 0;
        this.e = i2;
        this.g = false;
        try {
            this.f1829h = new ArrayList();
            byte[] bArrC = x().c();
            byte b = bArrC[3];
            this.f = k.x.s0.c(bArrC[8], bArrC[9]);
            this.c = k.x.y0.d(bArrC, b, 14, wVar);
            int i3 = b + 14;
            if (i3 >= bArrC.length) {
                return;
            }
            if (bArrC[i3] == 58) {
                int iC = k.x.s0.c(bArrC[i3 + 11], bArrC[i3 + 12]);
                int iC2 = k.x.s0.c(bArrC[i3 + 15], bArrC[i3 + 16]);
                byte b2 = bArrC[i3 + 17];
                this.f1829h.add(new n1(this, iC, b2, iC2, b2, iC2));
                return;
            }
            if (bArrC[i3] == 59) {
                while (i3 < bArrC.length) {
                    this.f1829h.add(new n1(this, k.x.s0.c(bArrC[i3 + 11], bArrC[i3 + 12]), bArrC[i3 + 19], k.x.s0.c(bArrC[i3 + 15], bArrC[i3 + 16]), bArrC[i3 + 20], k.x.s0.c(bArrC[i3 + 17], bArrC[i3 + 18])));
                    i3 += 21;
                }
                return;
            }
            if (bArrC[i3] == 41) {
                if (i3 < bArrC.length && bArrC[i3] != 58 && bArrC[i3] != 59) {
                    if (bArrC[i3] == 41) {
                        i3 += 3;
                    } else {
                        if (bArrC[i3] != 16) {
                            i3++;
                        }
                        i3++;
                    }
                }
                while (i3 < bArrC.length) {
                    this.f1829h.add(new n1(this, k.x.s0.c(bArrC[i3 + 11], bArrC[i3 + 12]), bArrC[i3 + 19], k.x.s0.c(bArrC[i3 + 15], bArrC[i3 + 16]), bArrC[i3 + 20], k.x.s0.c(bArrC[i3 + 17], bArrC[i3 + 18])));
                    i3 += 21;
                    if (i3 < bArrC.length && bArrC[i3] != 58 && bArrC[i3] != 59) {
                        if (bArrC[i3] == 41) {
                            i3 += 3;
                        } else if (bArrC[i3] == 16) {
                            i3++;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            f1827i.f("Cannot read name.");
            this.c = "ERROR";
        }
    }
}
