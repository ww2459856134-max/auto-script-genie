package h.e.d;

import android.graphics.Path;
import android.util.Log;

/* loaded from: classes.dex */
public class d {
    public char a;
    public float[] b;

    d(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        char c3 = c2;
        boolean z = false;
        float f9 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        switch (c3) {
            case 'A':
            case 'a':
                i2 = 7;
                i3 = i2;
                break;
            case 'C':
            case 'c':
                i2 = 6;
                i3 = i2;
                break;
            case 'H':
            case 'V':
            case 'h':
            case 'v':
                i3 = 1;
                break;
            case 'L':
            case 'M':
            case 'T':
            case 'l':
            case 'm':
            case 't':
            default:
                i3 = 2;
                break;
            case 'Q':
            case 'S':
            case 'q':
            case 's':
                i3 = 4;
                break;
            case 'Z':
            case 'z':
                path.close();
                path.moveTo(f13, f14);
                f9 = f13;
                f11 = f9;
                f10 = f14;
                f12 = f10;
                i3 = 2;
                break;
        }
        float f15 = f9;
        float f16 = f10;
        float f17 = f13;
        float f18 = f14;
        int i5 = 0;
        char c4 = c;
        while (i5 < fArr2.length) {
            if (c3 != 'A') {
                if (c3 == 'C') {
                    i4 = i5;
                    int i6 = i4 + 2;
                    int i7 = i4 + 3;
                    int i8 = i4 + 4;
                    int i9 = i4 + 5;
                    path.cubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                    f15 = fArr2[i8];
                    float f19 = fArr2[i9];
                    float f20 = fArr2[i6];
                    float f21 = fArr2[i7];
                    f16 = f19;
                    f12 = f21;
                    f11 = f20;
                } else if (c3 == 'H') {
                    i4 = i5;
                    int i10 = i4 + 0;
                    path.lineTo(fArr2[i10], f16);
                    f15 = fArr2[i10];
                } else if (c3 == 'Q') {
                    i4 = i5;
                    int i11 = i4 + 0;
                    int i12 = i4 + 1;
                    int i13 = i4 + 2;
                    int i14 = i4 + 3;
                    path.quadTo(fArr2[i11], fArr2[i12], fArr2[i13], fArr2[i14]);
                    float f22 = fArr2[i11];
                    float f23 = fArr2[i12];
                    f15 = fArr2[i13];
                    f16 = fArr2[i14];
                    f11 = f22;
                    f12 = f23;
                } else if (c3 == 'V') {
                    i4 = i5;
                    int i15 = i4 + 0;
                    path.lineTo(f15, fArr2[i15]);
                    f16 = fArr2[i15];
                } else if (c3 != 'a') {
                    if (c3 != 'c') {
                        if (c3 == 'h') {
                            int i16 = i5 + 0;
                            path.rLineTo(fArr2[i16], 0.0f);
                            f15 += fArr2[i16];
                        } else if (c3 != 'q') {
                            if (c3 == 'v') {
                                int i17 = i5 + 0;
                                path.rLineTo(0.0f, fArr2[i17]);
                                f4 = fArr2[i17];
                            } else if (c3 == 'L') {
                                int i18 = i5 + 0;
                                int i19 = i5 + 1;
                                path.lineTo(fArr2[i18], fArr2[i19]);
                                f15 = fArr2[i18];
                                f16 = fArr2[i19];
                            } else if (c3 == 'M') {
                                int i20 = i5 + 0;
                                f15 = fArr2[i20];
                                int i21 = i5 + 1;
                                f16 = fArr2[i21];
                                if (i5 > 0) {
                                    path.lineTo(fArr2[i20], fArr2[i21]);
                                } else {
                                    path.moveTo(fArr2[i20], fArr2[i21]);
                                    i4 = i5;
                                    f18 = f16;
                                    f17 = f15;
                                }
                            } else if (c3 == 'S') {
                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                    f15 = (f15 * 2.0f) - f11;
                                    f16 = (f16 * 2.0f) - f12;
                                }
                                float f24 = f16;
                                int i22 = i5 + 0;
                                int i23 = i5 + 1;
                                int i24 = i5 + 2;
                                int i25 = i5 + 3;
                                path.cubicTo(f15, f24, fArr2[i22], fArr2[i23], fArr2[i24], fArr2[i25]);
                                f = fArr2[i22];
                                f2 = fArr2[i23];
                                f15 = fArr2[i24];
                                f16 = fArr2[i25];
                                f11 = f;
                                f12 = f2;
                            } else if (c3 == 'T') {
                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                    f15 = (f15 * 2.0f) - f11;
                                    f16 = (f16 * 2.0f) - f12;
                                }
                                int i26 = i5 + 0;
                                int i27 = i5 + 1;
                                path.quadTo(f15, f16, fArr2[i26], fArr2[i27]);
                                float f25 = fArr2[i26];
                                float f26 = fArr2[i27];
                                i4 = i5;
                                f12 = f16;
                                f11 = f15;
                                f15 = f25;
                                f16 = f26;
                            } else if (c3 == 'l') {
                                int i28 = i5 + 0;
                                int i29 = i5 + 1;
                                path.rLineTo(fArr2[i28], fArr2[i29]);
                                f15 += fArr2[i28];
                                f4 = fArr2[i29];
                            } else if (c3 == 'm') {
                                int i30 = i5 + 0;
                                f15 += fArr2[i30];
                                int i31 = i5 + 1;
                                f16 += fArr2[i31];
                                if (i5 > 0) {
                                    path.rLineTo(fArr2[i30], fArr2[i31]);
                                } else {
                                    path.rMoveTo(fArr2[i30], fArr2[i31]);
                                    i4 = i5;
                                    f18 = f16;
                                    f17 = f15;
                                }
                            } else if (c3 == 's') {
                                if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                    float f27 = f15 - f11;
                                    f5 = f16 - f12;
                                    f6 = f27;
                                } else {
                                    f6 = 0.0f;
                                    f5 = 0.0f;
                                }
                                int i32 = i5 + 0;
                                int i33 = i5 + 1;
                                int i34 = i5 + 2;
                                int i35 = i5 + 3;
                                path.rCubicTo(f6, f5, fArr2[i32], fArr2[i33], fArr2[i34], fArr2[i35]);
                                f = fArr2[i32] + f15;
                                f2 = fArr2[i33] + f16;
                                f15 += fArr2[i34];
                                f3 = fArr2[i35];
                            } else if (c3 == 't') {
                                if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                    f7 = f15 - f11;
                                    f8 = f16 - f12;
                                } else {
                                    f8 = 0.0f;
                                    f7 = 0.0f;
                                }
                                int i36 = i5 + 0;
                                int i37 = i5 + 1;
                                path.rQuadTo(f7, f8, fArr2[i36], fArr2[i37]);
                                float f28 = f7 + f15;
                                float f29 = f8 + f16;
                                f15 += fArr2[i36];
                                f16 += fArr2[i37];
                                f12 = f29;
                                f11 = f28;
                            }
                            f16 += f4;
                        } else {
                            int i38 = i5 + 0;
                            int i39 = i5 + 1;
                            int i40 = i5 + 2;
                            int i41 = i5 + 3;
                            path.rQuadTo(fArr2[i38], fArr2[i39], fArr2[i40], fArr2[i41]);
                            f = fArr2[i38] + f15;
                            f2 = fArr2[i39] + f16;
                            f15 += fArr2[i40];
                            f3 = fArr2[i41];
                        }
                        i4 = i5;
                    } else {
                        int i42 = i5 + 2;
                        int i43 = i5 + 3;
                        int i44 = i5 + 4;
                        int i45 = i5 + 5;
                        path.rCubicTo(fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i42], fArr2[i43], fArr2[i44], fArr2[i45]);
                        f = fArr2[i42] + f15;
                        f2 = fArr2[i43] + f16;
                        f15 += fArr2[i44];
                        f3 = fArr2[i45];
                    }
                    f16 += f3;
                    f11 = f;
                    f12 = f2;
                    i4 = i5;
                } else {
                    int i46 = i5 + 5;
                    int i47 = i5 + 6;
                    i4 = i5;
                    c(path, f15, f16, fArr2[i46] + f15, fArr2[i47] + f16, fArr2[i5 + 0], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                    f15 += fArr2[i46];
                    f16 += fArr2[i47];
                }
                i5 = i4 + i3;
                c4 = c2;
                c3 = c4;
                z = false;
            } else {
                i4 = i5;
                int i48 = i4 + 5;
                int i49 = i4 + 6;
                c(path, f15, f16, fArr2[i48], fArr2[i49], fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                f15 = fArr2[i48];
                f16 = fArr2[i49];
            }
            f12 = f16;
            f11 = f15;
            i5 = i4 + i3;
            c4 = c2;
            c3 = c4;
            z = false;
        }
        fArr[z ? 1 : 0] = f15;
        fArr[1] = f16;
        fArr[2] = f11;
        fArr[3] = f12;
        fArr[4] = f17;
        fArr[5] = f18;
    }

    private static void b(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d11 = -d10;
        double d12 = d11 * dCos;
        double d13 = d4 * dSin;
        double d14 = (d12 * dSin2) - (d13 * dCos2);
        double d15 = d11 * dSin;
        double d16 = d4 * dCos;
        double d17 = (dSin2 * d15) + (dCos2 * d16);
        double d18 = d9 / iCeil;
        double d19 = d17;
        double d20 = d14;
        int i2 = 0;
        double d21 = d5;
        double d22 = d6;
        double d23 = d8;
        while (i2 < iCeil) {
            double d24 = d23 + d18;
            double dSin3 = Math.sin(d24);
            double dCos3 = Math.cos(d24);
            double d25 = (d + ((d10 * dCos) * dCos3)) - (d13 * dSin3);
            double d26 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
            double d27 = (d12 * dSin3) - (d13 * dCos3);
            double d28 = (dSin3 * d15) + (dCos3 * d16);
            double d29 = d24 - d23;
            double dTan = Math.tan(d29 / 2.0d);
            double dSin4 = (Math.sin(d29) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
            double d30 = d21 + (d20 * dSin4);
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) d30, (float) (d22 + (d19 * dSin4)), (float) (d25 - (dSin4 * d27)), (float) (d26 - (dSin4 * d28)), (float) d25, (float) d26);
            i2++;
            d18 = d18;
            dSin = dSin;
            d21 = d25;
            d15 = d15;
            dCos = dCos;
            d23 = d24;
            d19 = d28;
            d20 = d27;
            iCeil = iCeil;
            d22 = d26;
            d10 = d3;
        }
    }

    private static void c(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d3 = f;
        double d4 = d3 * dCos;
        double d5 = f2;
        double d6 = f5;
        double d7 = (d4 + (d5 * dSin)) / d6;
        double d8 = ((-f) * dSin) + (d5 * dCos);
        double d9 = f6;
        double d10 = d8 / d9;
        double d11 = f4;
        double d12 = ((f3 * dCos) + (d11 * dSin)) / d6;
        double d13 = (((-f3) * dSin) + (d11 * dCos)) / d9;
        double d14 = d7 - d12;
        double d15 = d10 - d13;
        double d16 = (d7 + d12) / 2.0d;
        double d17 = (d10 + d13) / 2.0d;
        double d18 = (d14 * d14) + (d15 * d15);
        if (d18 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d19 = (1.0d / d18) - 0.25d;
        if (d19 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d18);
            float fSqrt = (float) (Math.sqrt(d18) / 1.99999d);
            c(path, f, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
            return;
        }
        double dSqrt = Math.sqrt(d19);
        double d20 = d14 * dSqrt;
        double d21 = dSqrt * d15;
        if (z == z2) {
            d = d16 - d21;
            d2 = d17 + d20;
        } else {
            d = d16 + d21;
            d2 = d17 - d20;
        }
        double dAtan2 = Math.atan2(d10 - d2, d7 - d);
        double dAtan22 = Math.atan2(d13 - d2, d12 - d) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d22 = d * d6;
        double d23 = d2 * d9;
        b(path, (d22 * dCos) - (d23 * dSin), (d22 * dSin) + (d23 * dCos), d6, d9, d3, d5, radians, dAtan2, dAtan22);
    }

    public static void e(d[] dVarArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            a(path, fArr, c, dVarArr[i2].a, dVarArr[i2].b);
            c = dVarArr[i2].a;
        }
    }

    public void d(d dVar, d dVar2, float f) {
        this.a = dVar.a;
        int i2 = 0;
        while (true) {
            float[] fArr = dVar.b;
            if (i2 >= fArr.length) {
                return;
            }
            this.b[i2] = (fArr[i2] * (1.0f - f)) + (dVar2.b[i2] * f);
            i2++;
        }
    }

    d(d dVar) {
        this.a = dVar.a;
        float[] fArr = dVar.b;
        this.b = e.c(fArr, 0, fArr.length);
    }
}
