package i.b.ha.a.e.g;

/* loaded from: classes.dex */
public abstract class j {
    private static final double[][] a;
    private static final double[][] b;
    private static final double[] c;
    private static final double[] d;
    private static final double[] e;
    private static final double[] f;
    private static final long[] g;

    /* renamed from: h, reason: collision with root package name */
    private static final long[] f1494h;

    /* renamed from: i, reason: collision with root package name */
    private static final double[] f1495i;

    static {
        StrictMath.log(Double.MAX_VALUE);
        a = new double[][]{new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
        b = new double[][]{new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
        c = new double[]{0.0d, 0.1246747374534607d, 0.24740394949913025d, 0.366272509098053d, 0.4794255495071411d, 0.5850973129272461d, 0.6816387176513672d, 0.7675435543060303d, 0.8414709568023682d, 0.902267575263977d, 0.9489846229553223d, 0.9808930158615112d, 0.9974949359893799d, 0.9985313415527344d};
        d = new double[]{0.0d, -4.068233003401932E-9d, 9.755392680573412E-9d, 1.9987994582857286E-8d, -1.0902938113007961E-8d, -3.9986783938944604E-8d, 4.23719669792332E-8d, -5.207000323380292E-8d, 2.800552834259E-8d, 1.883511811213715E-8d, -3.5997360512765566E-9d, 4.116164446561962E-8d, 5.0614674548127384E-8d, -1.0129027912496858E-9d};
        e = new double[]{1.0d, 0.9921976327896118d, 0.9689123630523682d, 0.9305076599121094d, 0.8775825500488281d, 0.8109631538391113d, 0.7316888570785522d, 0.6409968137741089d, 0.5403022766113281d, 0.4311765432357788d, 0.3153223395347595d, 0.19454771280288696d, 0.07073719799518585d, -0.05417713522911072d};
        f = new double[]{0.0d, 3.4439717236742845E-8d, 5.865827662008209E-8d, -3.7999795083850525E-8d, 1.184154459111628E-8d, -3.43338934259355E-8d, 1.1795268640216787E-8d, 4.438921624363781E-8d, 2.925681159240093E-8d, -2.6437112632041807E-8d, 2.2860509143963117E-8d, -4.813899778443457E-9d, 3.6725170580355583E-9d, 2.0217439756338078E-10d};
        g = new long[]{2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
        f1494h = new long[]{-3958705157555305932L, -4267615245585081135L};
        f1495i = new double[]{0.0d, 0.125d, 0.25d, 0.375d, 0.5d, 0.625d, 0.75d, 0.875d, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
    }

    private static double A(double d2, double d3) {
        int i2 = (int) ((8.0d * d2) + 0.5d);
        double d4 = d2 - f1495i[i2];
        double d5 = c[i2];
        double d6 = d[i2];
        double d7 = e[i2];
        double d8 = f[i2];
        double dS = s(d4);
        double dR = r(d4);
        double d9 = 1.073741824E9d * d4;
        double d10 = (d4 + d9) - d9;
        double d11 = dS + (d4 - d10);
        double d12 = d5 + 0.0d;
        double d13 = d7 * d10;
        double d14 = d12 + d13;
        double d15 = (-((d12 - 0.0d) - d5)) + 0.0d + (-((d14 - d12) - d13)) + (d5 * dR) + (d7 * d11) + d6 + (d8 * d10) + (d6 * dR) + (d8 * d11);
        if (d3 != 0.0d) {
            double d16 = (((d7 + d8) * (dR + 1.0d)) - ((d5 + d6) * (d10 + d11))) * d3;
            double d17 = d14 + d16;
            d15 += -((d17 - d14) - d16);
            d14 = d17;
        }
        return d14 + d15;
    }

    public static double B(double d2) {
        return Math.sqrt(d2);
    }

    public static double a(double d2) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d2) & Long.MAX_VALUE);
    }

    public static int b(int i2) {
        int i3 = i2 >>> 31;
        return (i2 ^ ((~i3) + 1)) + i3;
    }

    public static long c(long j2) {
        long j3 = j2 >>> 63;
        return (j2 ^ ((~j3) + 1)) + j3;
    }

    public static double d(double d2) {
        if (d2 != d2) {
            return d2;
        }
        double dJ = j(d2);
        if (dJ == d2) {
            return dJ;
        }
        double d3 = dJ + 1.0d;
        return d3 == 0.0d ? d2 * d3 : d3;
    }

    public static double e(double d2, double d3) {
        return (Double.doubleToRawLongBits(d3) ^ Double.doubleToRawLongBits(d2)) >= 0 ? d2 : -d2;
    }

    public static double f(double d2) {
        double dA;
        double dC = 0.0d;
        if (d2 < 0.0d) {
            d2 = -d2;
        }
        if (d2 != d2 || d2 == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        int iA = 0;
        if (d2 > 3294198.0d) {
            double[] dArr = new double[3];
            w(d2, dArr);
            iA = ((int) dArr[0]) & 3;
            d2 = dArr[1];
            dC = dArr[2];
        } else if (d2 > 1.5707963267948966d) {
            e eVar = new e(d2);
            iA = eVar.a() & 3;
            d2 = eVar.b();
            dC = eVar.c();
        }
        if (iA == 0) {
            return g(d2, dC);
        }
        if (iA == 1) {
            dA = A(d2, dC);
        } else {
            if (iA != 2) {
                if (iA != 3) {
                    return Double.NaN;
                }
                return A(d2, dC);
            }
            dA = g(d2, dC);
        }
        return -dA;
    }

    private static double g(double d2, double d3) {
        double d4 = 1.5707963267948966d - d2;
        return A(d4, (-((d4 - 1.5707963267948966d) + d2)) + (6.123233995736766E-17d - d3));
    }

    public static double h(double d2) {
        return i(d2, 0.0d, null);
    }

    private static double i(double d2, double d3, double[] dArr) {
        double d4;
        int i2 = (int) d2;
        if (d2 < 0.0d) {
            if (d2 < -746.0d) {
                if (dArr != null) {
                    dArr[0] = 0.0d;
                    dArr[1] = 0.0d;
                }
                return 0.0d;
            }
            if (i2 < -709) {
                double dI = i(d2 + 40.19140625d, d3, dArr) / 2.8504009514401178E17d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 2.8504009514401178E17d;
                    dArr[1] = dArr[1] / 2.8504009514401178E17d;
                }
                return dI;
            }
            if (i2 == -709) {
                double dI2 = i(d2 + 1.494140625d, d3, dArr) / 4.455505956692757d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 4.455505956692757d;
                    dArr[1] = dArr[1] / 4.455505956692757d;
                }
                return dI2;
            }
            i2--;
        } else if (i2 > 709) {
            if (dArr != null) {
                dArr[0] = Double.POSITIVE_INFINITY;
                dArr[1] = 0.0d;
            }
            return Double.POSITIVE_INFINITY;
        }
        int i3 = i2 + 750;
        double d5 = g.a[i3];
        double d6 = g.b[i3];
        double d7 = i2;
        int i4 = (int) ((d2 - d7) * 1024.0d);
        double d8 = f.a[i4];
        double d9 = f.b[i4];
        double d10 = d2 - (d7 + (i4 / 1024.0d));
        double d11 = (((((((0.04168701738764507d * d10) + 0.1666666505023083d) * d10) + 0.5000000000042687d) * d10) + 1.0d) * d10) - 3.940510424527919E-20d;
        double d12 = d5 * d8;
        double d13 = (d5 * d9) + (d8 * d6) + (d6 * d9);
        double d14 = d13 + d12;
        if (d14 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d3 != 0.0d) {
            double d15 = d14 * d3;
            d4 = (d15 * d11) + d15 + (d14 * d11) + d13 + d12;
        } else {
            d4 = (d14 * d11) + d13 + d12;
        }
        if (dArr != null) {
            dArr[0] = d12;
            double d16 = d14 * d3;
            dArr[1] = (d16 * d11) + d16 + (d14 * d11) + d13;
        }
        return d4;
    }

    public static double j(double d2) {
        if (d2 != d2 || d2 >= 4.503599627370496E15d || d2 <= -4.503599627370496E15d) {
            return d2;
        }
        long j2 = (long) d2;
        if (d2 < 0.0d && j2 != d2) {
            j2--;
        }
        return j2 == 0 ? d2 * j2 : j2;
    }

    public static double k(double d2) {
        return l(d2, null);
    }

    private static double l(double d2, double[] dArr) {
        double d3;
        double d4;
        if (d2 == 0.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
        if (((Long.MIN_VALUE & jDoubleToRawLongBits) != 0 || d2 != d2) && d2 != 0.0d) {
            if (dArr != null) {
                dArr[0] = Double.NaN;
            }
            return Double.NaN;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            if (dArr != null) {
                dArr[0] = Double.POSITIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        int i2 = ((int) (jDoubleToRawLongBits >> 52)) - 1023;
        if ((9218868437227405312L & jDoubleToRawLongBits) == 0) {
            if (d2 == 0.0d) {
                if (dArr != null) {
                    dArr[0] = Double.NEGATIVE_INFINITY;
                }
                return Double.NEGATIVE_INFINITY;
            }
            jDoubleToRawLongBits <<= 1;
            while ((4503599627370496L & jDoubleToRawLongBits) == 0) {
                i2--;
                jDoubleToRawLongBits <<= 1;
            }
        }
        if ((i2 == -1 || i2 == 0) && d2 < 1.01d && d2 > 0.99d && dArr == null) {
            double d5 = d2 - 1.0d;
            double d6 = d5 * 1.073741824E9d;
            double d7 = (d5 + d6) - d6;
            double d8 = d5 - d7;
            double[][] dArr2 = a;
            double[] dArr3 = dArr2[dArr2.length - 1];
            double d9 = dArr3[0];
            double d10 = dArr3[1];
            for (int length = dArr2.length - 2; length >= 0; length--) {
                double d11 = d9 * d7;
                double d12 = (d9 * d8) + (d10 * d7) + (d10 * d8);
                double d13 = d11 * 1.073741824E9d;
                double d14 = (d11 + d13) - d13;
                double d15 = (d11 - d14) + d12;
                double[] dArr4 = a[length];
                double d16 = d14 + dArr4[0];
                double d17 = d16 * 1.073741824E9d;
                d9 = (d16 + d17) - d17;
                d10 = (d16 - d9) + d15 + dArr4[1];
            }
            double d18 = d9 * d7;
            double d19 = (d9 * d8) + (d7 * d10) + (d10 * d8);
            double d20 = 1.073741824E9d * d18;
            double d21 = (d18 + d20) - d20;
            return d21 + (d18 - d21) + d19;
        }
        long j2 = 4499201580859392L & jDoubleToRawLongBits;
        double[] dArr5 = i.a[(int) (j2 >> 42)];
        double d22 = jDoubleToRawLongBits & 4398046511103L;
        double d23 = j2 + 4.503599627370496E15d;
        double d24 = d22 / d23;
        if (dArr != null) {
            double d25 = d24 * 1.073741824E9d;
            double d26 = (d24 + d25) - d25;
            double d27 = d24 - d26;
            double d28 = d27 + (((d22 - (d26 * d23)) - (d27 * d23)) / d23);
            double[][] dArr6 = b;
            double[] dArr7 = dArr6[dArr6.length - 1];
            double d29 = dArr7[0];
            double d30 = dArr7[1];
            for (int length2 = dArr6.length - 2; length2 >= 0; length2--) {
                double d31 = d29 * d26;
                double d32 = (d29 * d28) + (d30 * d26) + (d30 * d28);
                double d33 = d31 * 1.073741824E9d;
                double d34 = (d31 + d33) - d33;
                double d35 = (d31 - d34) + d32;
                double[] dArr8 = b[length2];
                double d36 = d34 + dArr8[0];
                double d37 = d35 + dArr8[1];
                double d38 = d36 * 1.073741824E9d;
                d29 = (d36 + d38) - d38;
                d30 = (d36 - d29) + d37;
            }
            double d39 = d29 * d26;
            double d40 = (d29 * d28) + (d26 * d30) + (d30 * d28);
            d3 = d39 + d40;
            d4 = -((d3 - d39) - d40);
        } else {
            d3 = (((((((((((-0.16624882440418567d) * d24) + 0.19999954120254515d) * d24) - 0.2499999997677497d) * d24) + 0.3333333333332802d) * d24) - 0.5d) * d24) + 1.0d) * d24;
            d4 = 0.0d;
        }
        double d41 = i2;
        double d42 = 0.6931470632553101d * d41;
        double d43 = dArr5[0] + d42;
        double d44 = d43 + d3;
        double d45 = (-((d43 - d42) - dArr5[0])) + 0.0d + (-((d44 - d43) - d3));
        double d46 = d41 * 1.1730463525082348E-7d;
        double d47 = d44 + d46;
        double d48 = d45 + (-((d47 - d44) - d46));
        double d49 = dArr5[1] + d47;
        double d50 = d48 + (-((d49 - d47) - dArr5[1]));
        double d51 = d49 + d4;
        double d52 = d50 + (-((d51 - d49) - d4));
        if (dArr != null) {
            dArr[0] = d51;
            dArr[1] = d52;
        }
        return d51 + d52;
    }

    public static double m(double d2) {
        if (d2 == -1.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d2 <= 1.0E-6d && d2 >= -1.0E-6d) {
            return ((((0.3333333333333333d * d2) - 0.5d) * d2) + 1.0d) * d2;
        }
        double d3 = d2 + 1.0d;
        double d4 = -((d3 - 1.0d) - d2);
        double[] dArr = new double[2];
        double dL = l(d3, dArr);
        if (Double.isInfinite(dL)) {
            return dL;
        }
        double d5 = d4 / d3;
        return (((0.5d * d5) + 1.0d) * d5) + dArr[1] + dArr[0];
    }

    public static double n(double d2, double d3) {
        if (d2 > d3) {
            return d2;
        }
        if (d2 < d3) {
            return d3;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        return Double.doubleToRawLongBits(d2) == Long.MIN_VALUE ? d3 : d2;
    }

    public static int o(int i2, int i3) {
        return i2 <= i3 ? i3 : i2;
    }

    public static double p(double d2, double d3) {
        if (d2 > d3) {
            return d3;
        }
        if (d2 < d3) {
            return d2;
        }
        if (d2 != d3) {
            return Double.NaN;
        }
        return Double.doubleToRawLongBits(d2) == Long.MIN_VALUE ? d2 : d3;
    }

    public static int q(int i2, int i3) {
        return i2 <= i3 ? i2 : i3;
    }

    private static double r(double d2) {
        return ((((((2.479773539153719E-5d * r4) - 0.0013888888689039883d) * r4) + 0.041666666666621166d) * r4) - 0.49999999999999994d) * d2 * d2;
    }

    private static double s(double d2) {
        return ((((((2.7553817452272217E-6d * r0) - 1.9841269659586505E-4d) * r0) + 0.008333333333329196d) * r0) - 0.16666666666666666d) * d2 * d2 * d2;
    }

    public static double t(double d2, double d3) {
        if (d3 == 0.0d) {
            return 1.0d;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d3);
        int i2 = (int) ((jDoubleToRawLongBits & 9218868437227405312L) >> 52);
        long j2 = jDoubleToRawLongBits & 4503599627370495L;
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d2);
        int i3 = (int) ((jDoubleToRawLongBits2 & 9218868437227405312L) >> 52);
        long j3 = jDoubleToRawLongBits2 & 4503599627370495L;
        if (i2 > 1085) {
            if ((i2 == 2047 && j2 != 0) || (i3 == 2047 && j3 != 0)) {
                return Double.NaN;
            }
            if (i3 == 1023 && j3 == 0) {
                return i2 == 2047 ? Double.NaN : 1.0d;
            }
            return ((d3 > 0.0d ? 1 : (d3 == 0.0d ? 0 : -1)) > 0) ^ (i3 < 1023) ? Double.POSITIVE_INFINITY : 0.0d;
        }
        if (i2 >= 1023) {
            long j4 = j2 | 4503599627370496L;
            if (i2 >= 1075) {
                long j5 = j4 << (i2 - 1075);
                if (d3 < 0.0d) {
                    j5 = -j5;
                }
                return v(d2, j5);
            }
            int i4 = 1075 - i2;
            if ((((-1) << i4) & j4) == j4) {
                long j6 = j4 >> i4;
                if (d3 < 0.0d) {
                    j6 = -j6;
                }
                return v(d2, j6);
            }
        }
        if (d2 == 0.0d) {
            return d3 < 0.0d ? Double.POSITIVE_INFINITY : 0.0d;
        }
        if (i3 == 2047) {
            if (j3 == 0) {
                return d3 < 0.0d ? 0.0d : Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (d2 < 0.0d) {
            return Double.NaN;
        }
        double d4 = d3 * 1.073741824E9d;
        double d5 = (d3 + d4) - d4;
        double d6 = d3 - d5;
        double[] dArr = new double[2];
        double dL = l(d2, dArr);
        if (Double.isInfinite(dL)) {
            return dL;
        }
        double d7 = dArr[0];
        double d8 = 1.073741824E9d * d7;
        double d9 = (d7 + d8) - d8;
        double d10 = dArr[1] + (d7 - d9);
        double d11 = d9 * d5;
        double d12 = (d9 * d6) + (d5 * d10) + (d10 * d6);
        double d13 = d11 + d12;
        double d14 = -((d13 - d11) - d12);
        return i(d13, ((((((((0.008333333333333333d * d14) + 0.041666666666666664d) * d14) + 0.16666666666666666d) * d14) + 0.5d) * d14) + 1.0d) * d14, null);
    }

    public static double u(double d2, int i2) {
        return v(d2, i2);
    }

    public static double v(double d2, long j2) {
        if (j2 == 0) {
            return 1.0d;
        }
        return j2 > 0 ? new h(d2).d(j2).a : new h(d2).e().d(-j2).a;
    }

    private static void w(double d2, double[] dArr) {
        long j2;
        long j3;
        long j4;
        int i2 = (((int) ((r0 >> 52) & 2047)) - 1023) + 1;
        long jDoubleToRawLongBits = ((Double.doubleToRawLongBits(d2) & 4503599627370495L) | 4503599627370496L) << 11;
        int i3 = i2 >> 6;
        int i4 = i2 - (i3 << 6);
        if (i4 != 0) {
            long j5 = i3 == 0 ? 0L : g[i3 - 1] << i4;
            long[] jArr = g;
            int i5 = 64 - i4;
            j2 = j5 | (jArr[i3] >>> i5);
            int i6 = i3 + 1;
            j3 = (jArr[i3] << i4) | (jArr[i6] >>> i5);
            j4 = (jArr[i6] << i4) | (jArr[i3 + 2] >>> i5);
        } else {
            j2 = i3 == 0 ? 0L : g[i3 - 1];
            long[] jArr2 = g;
            j3 = jArr2[i3];
            j4 = jArr2[i3 + 1];
        }
        long j6 = jDoubleToRawLongBits >>> 32;
        long j7 = jDoubleToRawLongBits & 4294967295L;
        long j8 = j3 >>> 32;
        long j9 = j3 & 4294967295L;
        long j10 = j6 * j8;
        long j11 = j7 * j9;
        long j12 = j8 * j7;
        long j13 = j9 * j6;
        long j14 = j11 + (j13 << 32);
        long j15 = j10 + (j13 >>> 32);
        boolean z = (j11 & Long.MIN_VALUE) != 0;
        boolean z2 = (j13 & 2147483648L) != 0;
        long j16 = j14 & Long.MIN_VALUE;
        boolean z3 = j16 != 0;
        if ((z && z2) || ((z || z2) && !z3)) {
            j15++;
        }
        boolean z4 = j16 != 0;
        boolean z5 = (j12 & 2147483648L) != 0;
        long j17 = j14 + (j12 << 32);
        long j18 = j15 + (j12 >>> 32);
        long j19 = j17 & Long.MIN_VALUE;
        boolean z6 = j19 != 0;
        if ((z4 && z5) || ((z4 || z5) && !z6)) {
            j18++;
        }
        long j20 = j4 >>> 32;
        long j21 = (j6 * j20) + (((j20 * j7) + ((j4 & 4294967295L) * j6)) >>> 32);
        boolean z7 = j19 != 0;
        boolean z8 = (j21 & Long.MIN_VALUE) != 0;
        long j22 = j17 + j21;
        boolean z9 = (j22 & Long.MIN_VALUE) != 0;
        if ((z7 && z8) || ((z7 || z8) && !z9)) {
            j18++;
        }
        long j23 = j2 >>> 32;
        long j24 = j2 & 4294967295L;
        long j25 = j18 + (j7 * j24) + (((j7 * j23) + (j6 * j24)) << 32);
        int i7 = (int) (j25 >>> 62);
        long j26 = (j25 << 2) | (j22 >>> 62);
        long j27 = j22 << 2;
        long j28 = j26 >>> 32;
        long j29 = j26 & 4294967295L;
        long[] jArr3 = f1494h;
        long j30 = jArr3[0] >>> 32;
        long j31 = jArr3[0] & 4294967295L;
        long j32 = j28 * j30;
        long j33 = j29 * j31;
        long j34 = j30 * j29;
        long j35 = j31 * j28;
        long j36 = j33 + (j35 << 32);
        long j37 = j32 + (j35 >>> 32);
        boolean z10 = (j33 & Long.MIN_VALUE) != 0;
        boolean z11 = (j35 & 2147483648L) != 0;
        long j38 = j36 & Long.MIN_VALUE;
        boolean z12 = j38 != 0;
        if ((z10 && z11) || ((z10 || z11) && !z12)) {
            j37++;
        }
        boolean z13 = j38 != 0;
        boolean z14 = (j34 & 2147483648L) != 0;
        long j39 = j36 + (j34 << 32);
        long j40 = j37 + (j34 >>> 32);
        long j41 = j39 & Long.MIN_VALUE;
        boolean z15 = j41 != 0;
        if ((z13 && z14) || ((z13 || z14) && !z15)) {
            j40++;
        }
        long j42 = jArr3[1] >>> 32;
        long j43 = (j28 * j42) + (((j29 * j42) + (j28 * (jArr3[1] & 4294967295L))) >>> 32);
        boolean z16 = j41 != 0;
        boolean z17 = (j43 & Long.MIN_VALUE) != 0;
        long j44 = j39 + j43;
        long j45 = j44 & Long.MIN_VALUE;
        boolean z18 = j45 != 0;
        if ((z16 && z17) || ((z16 || z17) && !z18)) {
            j40++;
        }
        long j46 = j27 >>> 32;
        long j47 = jArr3[0] >>> 32;
        long j48 = (j46 * j47) + ((((j27 & 4294967295L) * j47) + (j46 * (jArr3[0] & 4294967295L))) >>> 32);
        boolean z19 = j45 != 0;
        boolean z20 = (j48 & Long.MIN_VALUE) != 0;
        boolean z21 = ((j44 + j48) & Long.MIN_VALUE) != 0;
        if ((z19 && z20) || ((z19 || z20) && !z21)) {
            j40++;
        }
        double d3 = (j40 >>> 12) / 4.503599627370496E15d;
        double d4 = ((((j40 & 4095) << 40) + (r32 >>> 24)) / 4.503599627370496E15d) / 4.503599627370496E15d;
        double d5 = d3 + d4;
        dArr[0] = i7;
        dArr[1] = d5 * 2.0d;
        dArr[2] = (-((d5 - d3) - d4)) * 2.0d;
    }

    public static double x(double d2) {
        double dJ = j(d2);
        double d3 = d2 - dJ;
        if (d3 <= 0.5d) {
            return (d3 >= 0.5d && (((long) dJ) & 1) != 0) ? dJ + 1.0d : dJ;
        }
        if (dJ == -1.0d) {
            return -0.0d;
        }
        return dJ + 1.0d;
    }

    public static long y(double d2) {
        return (long) j(d2 + 0.5d);
    }

    public static double z(double d2) {
        double dB;
        boolean z;
        double dA;
        double dC = 0.0d;
        int iA = 0;
        if (d2 < 0.0d) {
            dB = -d2;
            z = true;
        } else {
            dB = d2;
            z = false;
        }
        if (dB == 0.0d) {
            return Double.doubleToRawLongBits(d2) < 0 ? -0.0d : 0.0d;
        }
        if (dB != dB || dB == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        if (dB > 3294198.0d) {
            double[] dArr = new double[3];
            w(dB, dArr);
            iA = ((int) dArr[0]) & 3;
            dB = dArr[1];
            dC = dArr[2];
        } else if (dB > 1.5707963267948966d) {
            e eVar = new e(dB);
            iA = eVar.a() & 3;
            dB = eVar.b();
            dC = eVar.c();
        }
        if (z) {
            iA ^= 2;
        }
        if (iA == 0) {
            return A(dB, dC);
        }
        if (iA == 1) {
            return g(dB, dC);
        }
        if (iA == 2) {
            dA = A(dB, dC);
        } else {
            if (iA != 3) {
                return Double.NaN;
            }
            dA = g(dB, dC);
        }
        return -dA;
    }
}
