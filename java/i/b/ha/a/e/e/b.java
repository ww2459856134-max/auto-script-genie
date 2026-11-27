package i.b.ha.a.e.e;

import i.b.ha.a.e.g.j;
import i.b.ha.a.e.g.l;

/* loaded from: classes.dex */
public abstract class b {
    private static final double[] a = {1.0d, 1.0d, 2.0d, 6.0d, 24.0d, 120.0d, 720.0d, 5040.0d, 40320.0d, 362880.0d, 3628800.0d, 3.99168E7d, 4.790016E8d, 6.2270208E9d, 8.71782912E10d, 1.307674368E12d, 2.0922789888E13d, 3.55687428096E14d, 6.402373705728E15d, 1.21645100408832E17d, 2.43290200817664E18d, 5.109094217170944E19d, 1.1240007277776077E21d, 2.585201673888498E22d, 6.204484017332394E23d};

    /* JADX WARN: Removed duplicated region for block: B:149:0x03c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(double d, double d2, int i2) {
        int i3;
        double d3;
        int i4;
        double dN;
        double d4;
        boolean z;
        int i5;
        double dA;
        boolean z2;
        boolean z3;
        int i6;
        char c;
        double d5;
        double d6;
        int i7;
        int i8;
        double d7;
        char c2;
        double d8;
        int i9;
        int iQ;
        int i10;
        double d9;
        double[] dArr = new double[i2];
        int i11 = (int) d;
        int iQ2 = 0;
        int i12 = 1;
        if (i2 <= 0 || d < 0.0d || d > 10000.0d || d2 < 0.0d || d2 >= 1.0d) {
            i3 = i2;
            if (i3 > 0) {
                dArr[0] = 0.0d;
            }
            iQ2 = j.q(i3, 0) - 1;
        } else {
            for (int i13 = 0; i13 < i2; i13++) {
                dArr[i13] = 0.0d;
            }
            if (d < 1.0E-4d) {
                double d10 = d2 + 1.0d;
                double d11 = d > 8.9E-308d ? 0.5d * d : 0.0d;
                double dT = d2 != 0.0d ? j.t(d11, d2) / (d2 * g.a(d2)) : 1.0d;
                double d12 = d + 1.0d > 1.0d ? (-d11) * d11 : 0.0d;
                dArr[0] = dT + ((dT * d12) / d10);
                if (d != 0.0d) {
                    d9 = 0.0d;
                    if (dArr[0] != 0.0d) {
                    }
                    if (i2 != 1) {
                        if (d <= d9) {
                            while (i12 < i2) {
                                dArr[i12] = d9;
                                i12++;
                            }
                        } else {
                            double d13 = d12 != d9 ? 8.9E-308d / d12 : 1.78E-307d / d;
                            while (i12 < i2) {
                                double d14 = dT / d10;
                                d10 += 1.0d;
                                double d15 = d14 * d11;
                                dT = d15 <= d13 * d10 ? 0.0d : d15;
                                dArr[i12] = dT + ((dT * d12) / d10);
                                if (dArr[i12] == 0.0d && iQ2 > i12) {
                                    iQ2 = i12;
                                }
                                i12++;
                            }
                        }
                    }
                    i3 = i2;
                } else {
                    d9 = 0.0d;
                }
                iQ2 = i2;
                if (i2 != 1) {
                }
                i3 = i2;
            } else if (d <= 25.0d || i2 > i11 + 1) {
                int i14 = i11 + 1;
                double d16 = (i14 + d2) * 2.0d;
                double d17 = d16 / d;
                if (i2 - i11 >= 3) {
                    int i15 = i11 + 2;
                    int i16 = i2 - 1;
                    double d18 = 2.0d;
                    double d19 = ((i15 - 1) + d2) * 2.0d;
                    double d20 = d17;
                    double d21 = 1.0d;
                    while (true) {
                        int i17 = i14;
                        i14 = i15;
                        i9 = i17;
                        if (i14 > i16) {
                            z = false;
                            i14 = i16;
                            d4 = d21;
                            d16 = d19;
                            d17 = d20;
                            dN = 2.0E16d;
                            iQ = i2;
                            break;
                        }
                        d19 += d18;
                        double d22 = ((d19 * d20) / d) - d21;
                        if (d22 > 1.0E292d) {
                            double d23 = d22 / 1.0E308d;
                            double d24 = d20 / 1.0E308d;
                            int i18 = i14 + 1;
                            d4 = d23;
                            double d25 = d24;
                            while (true) {
                                i14++;
                                d19 += 2.0d;
                                double d26 = ((d19 * d4) / d) - d25;
                                if (d26 > 1.0d) {
                                    break;
                                }
                                d25 = d4;
                                d4 = d26;
                            }
                            double d27 = d19 / d;
                            double d28 = ((d25 * d4) * (0.5d - (0.5d / (d27 * d27)))) / 1.0E16d;
                            d17 = 1.0E308d * d4;
                            int i19 = i14 - 1;
                            double d29 = d19 - 2.0d;
                            iQ = j.q(i2, i19);
                            while (i18 <= iQ) {
                                double d30 = ((d29 * d23) / d) - d24;
                                if (d30 * d23 > d28) {
                                    break;
                                }
                                i18++;
                                d24 = d23;
                                d23 = d30;
                            }
                            i9 = i19;
                            z = true;
                            i14 = iQ;
                            d16 = d29;
                            dN = d28;
                        } else {
                            i15 = i14 + 1;
                            d21 = d20;
                            d20 = d22;
                            d18 = 2.0d;
                        }
                    }
                    if (z) {
                        i10 = iQ;
                        d3 = 2.0d;
                        i14 = i9;
                    } else {
                        d3 = 2.0d;
                        d16 = (i14 + d2) * 2.0d;
                        i10 = iQ;
                        dN = j.n(dN, j.B(1.0E16d * d4) * j.B(d17 * 2.0d));
                    }
                    i4 = i10;
                } else {
                    d3 = 2.0d;
                    i4 = i2;
                    dN = 2.0E16d;
                    d4 = 1.0d;
                    z = false;
                }
                if (!z) {
                    while (true) {
                        i14++;
                        d16 += d3;
                        d8 = ((d16 * d17) / d) - d4;
                        if (d8 >= dN) {
                            break;
                        }
                        double d31 = d17;
                        d17 = d8;
                        d4 = d31;
                    }
                    d17 = d8;
                }
                int i20 = i14 + 1;
                double d32 = d16 + d3;
                double d33 = 1.0d / d17;
                int i21 = i20 / 2;
                int i22 = (i20 * 2) - (i21 * 4);
                int i23 = i4;
                double d34 = i21;
                double d35 = (d34 - 1.0d) + d2;
                double d36 = (d34 * 2.0d) + d2;
                if (i22 != 0) {
                    dA = ((d35 * d33) * d36) / d34;
                    i5 = i22;
                } else {
                    i5 = i22;
                    dA = 0.0d;
                }
                int i24 = i20 - i2;
                double d37 = d33;
                int i25 = 1;
                double d38 = 0.0d;
                while (true) {
                    if (i25 > i24) {
                        break;
                    }
                    i20--;
                    d32 -= 2.0d;
                    double d39 = ((d32 * d37) / d) - d38;
                    i5 = 2 - i5;
                    if (i5 != 0) {
                        d34 -= 1.0d;
                        double d40 = (d34 * 2.0d) + d2;
                        if (i20 == 1) {
                            d38 = d37;
                            d37 = d39;
                            break;
                        }
                        double d41 = (d34 - 1.0d) + d2;
                        if (d41 == 0.0d) {
                            d41 = 1.0d;
                        }
                        dA = ((dA + (d40 * d39)) * d41) / d34;
                    }
                    i25++;
                    d38 = d37;
                    d37 = d39;
                }
                dArr[i20 - 1] = d37;
                if (i24 < 0) {
                    z2 = false;
                    z3 = false;
                    if (!z2 && !z3 && i20 - 2 != 0) {
                        for (i8 = 1; i8 <= i7; i8++) {
                            i20--;
                            d32 -= 2.0d;
                            int i26 = i20 - 1;
                            dArr[i26] = ((dArr[i20] * d32) / d) - dArr[i20 + 1];
                            i5 = 2 - i5;
                            if (i5 != 0) {
                                d34 -= 1.0d;
                                double d42 = (d34 * 2.0d) + d2;
                                double d43 = (d34 - 1.0d) + d2;
                                if (d43 == 0.0d) {
                                    d43 = 1.0d;
                                }
                                dA = ((dA + (dArr[i26] * d42)) * d43) / d34;
                            }
                        }
                    }
                    if (!z2) {
                        if (z3) {
                            c = 0;
                            d5 = 1.0d;
                            d6 = 2.0d;
                        } else {
                            d5 = 1.0d;
                            d6 = 2.0d;
                            c = 0;
                            dArr[0] = ((((d2 + 1.0d) * 2.0d) * dArr[1]) / d) - dArr[2];
                        }
                        double d44 = ((d34 - d5) * d6) + d2;
                        if (d44 == 0.0d) {
                            d44 = 1.0d;
                        }
                        dA += dArr[c] * d44;
                    }
                    if (j.a(d2) > 1.0E-16d) {
                        dA *= g.a(d2) * j.t(d * 0.5d, -d2);
                    }
                    double d45 = dA > 1.0d ? 8.9E-308d * dA : 8.9E-308d;
                    i3 = i2;
                    for (i6 = 0; i6 < i3; i6++) {
                        if (j.a(dArr[i6]) < d45) {
                            dArr[i6] = 0.0d;
                        }
                        dArr[i6] = dArr[i6] / dA;
                    }
                    iQ2 = i23;
                } else if (i2 <= 1) {
                    if (d2 + 1.0d == 1.0d) {
                        c2 = 0;
                        d7 = 1.0d;
                    } else {
                        d7 = d2;
                        c2 = 0;
                    }
                    dA += dArr[c2] * d7;
                    z2 = true;
                    z3 = false;
                    if (!z2) {
                        while (i8 <= i7) {
                        }
                    }
                    if (!z2) {
                    }
                    if (j.a(d2) > 1.0E-16d) {
                    }
                    if (dA > 1.0d) {
                    }
                    i3 = i2;
                    while (i6 < i3) {
                    }
                    iQ2 = i23;
                } else {
                    i20--;
                    d32 -= 2.0d;
                    int i27 = i20 - 1;
                    dArr[i27] = ((d37 * d32) / d) - d38;
                    if (i20 == 1) {
                        z2 = false;
                        z3 = true;
                        if (!z2) {
                        }
                        if (!z2) {
                        }
                        if (j.a(d2) > 1.0E-16d) {
                        }
                        if (dA > 1.0d) {
                        }
                        i3 = i2;
                        while (i6 < i3) {
                        }
                        iQ2 = i23;
                    } else {
                        i5 = 2 - i5;
                        if (i5 != 0) {
                            d34 -= 1.0d;
                            double d46 = (d34 * 2.0d) + d2;
                            double d47 = (d34 - 1.0d) + d2;
                            if (d47 == 0.0d) {
                                d47 = 1.0d;
                            }
                            dA = ((dA + (dArr[i27] * d46)) * d47) / d34;
                        }
                        z2 = false;
                        z3 = false;
                        if (!z2) {
                        }
                        if (!z2) {
                        }
                        if (j.a(d2) > 1.0E-16d) {
                        }
                        if (dA > 1.0d) {
                        }
                        i3 = i2;
                        while (i6 < i3) {
                        }
                        iQ2 = i23;
                    }
                }
            } else {
                double dB = j.B(0.6366197723675814d / d);
                double d48 = 0.125d / d;
                double d49 = d48 * d48;
                int i28 = d >= 130.0d ? 4 : d >= 35.0d ? 8 : 11;
                double d50 = i28 * 4.0d;
                double d51 = (int) ((d / 6.283185307179586d) + 0.5d);
                double d52 = ((d - (6.28125d * d51)) - (d51 * 0.001935307179586477d)) - ((d2 + 0.5d) / 0.6366197723675814d);
                double dZ = j.z(d52);
                double dF = j.f(d52);
                double d53 = d2 * 2.0d;
                double d54 = d53;
                int i29 = 1;
                int i30 = 2;
                while (i29 <= i30) {
                    double d55 = d50 - 1.0d;
                    double d56 = (d55 - d54) * (d55 + d54) * d49 * 0.5d;
                    double d57 = d50 - 3.0d;
                    double d58 = (d54 - d57) * (d54 + d57);
                    double[] dArr2 = a;
                    int i31 = i28 * 2;
                    double d59 = (d56 * d58) / dArr2[i31];
                    double d60 = d50 + 1.0d;
                    double d61 = (d56 * ((d54 - d60) * (d54 + d60))) / dArr2[i31 + 1];
                    double d62 = d50;
                    int i32 = 2;
                    while (i32 <= i28) {
                        d62 -= 4.0d;
                        double d63 = d62 - 1.0d;
                        double d64 = (d63 - d54) * (d63 + d54);
                        double d65 = d62 - 3.0d;
                        double d66 = (d54 + d65) * (d54 - d65);
                        double[] dArr3 = a;
                        d59 = (d59 + (1.0d / dArr3[i31 - 2])) * d64 * d66 * d49;
                        d61 = (d61 + (1.0d / dArr3[i31 - 1])) * d64 * d58 * d49;
                        i31 -= 2;
                        i32++;
                        d58 = d66;
                    }
                    dArr[i29 - 1] = (((d59 + 1.0d) * dF) - ((((d61 + 1.0d) * ((d54 * d54) - 1.0d)) * d48) * dZ)) * dB;
                    if (i2 == 1) {
                        return new a(l.a(dArr, i2), i2);
                    }
                    d54 += 2.0d;
                    i29++;
                    i30 = 2;
                    double d67 = dZ;
                    dZ = -dF;
                    dF = d67;
                }
                if (i2 > i30) {
                    double d68 = d53 + 2.0d;
                    for (int i33 = 2; i33 < i2; i33++) {
                        dArr[i33] = ((dArr[i33 - 1] * d68) / d) - dArr[i33 - 2];
                        d68 += 2.0d;
                    }
                }
                i3 = i2;
                iQ2 = i3;
            }
        }
        return new a(l.a(dArr, i3), iQ2);
    }

    public static double b(double d, double d2) throws i.b.ha.a.e.b.d, i.b.ha.a.e.b.a {
        int i2 = (int) d;
        int i3 = i2 + 1;
        a aVarA = a(d2, d - i2, i3);
        if (aVarA.b >= i3) {
            return aVarA.a[i2];
        }
        if (aVarA.b < 0) {
            throw new i.b.ha.a.e.b.d(i.b.ha.a.e.b.p.d.BESSEL_FUNCTION_BAD_ARGUMENT, Double.valueOf(d), Double.valueOf(d2));
        }
        if (j.a(aVarA.a[aVarA.b - 1]) < 1.0E-100d) {
            return aVarA.a[i2];
        }
        throw new i.b.ha.a.e.b.a(i.b.ha.a.e.b.p.d.BESSEL_FUNCTION_FAILED_CONVERGENCE, Double.valueOf(d), Double.valueOf(d2));
    }
}
