package h.e.d;

import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class e {
    private static void a(ArrayList<d> arrayList, char c, float[] fArr) {
        arrayList.add(new d(c, fArr));
    }

    public static boolean b(d[] dVarArr, d[] dVarArr2) {
        if (dVarArr == null || dVarArr2 == null || dVarArr.length != dVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            if (dVarArr[i2].a != dVarArr2[i2].a || dVarArr[i2].b.length != dVarArr2[i2].b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int iMin = Math.min(i4, length - i2);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, iMin);
        return fArr2;
    }

    public static d[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i(str, i2);
            String strTrim = str.substring(i3, i4).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i3 = i4;
            i2 = i4 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (d[]) arrayList.toArray(new d[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        d[] dVarArrD = d(str);
        if (dVarArrD == null) {
            return null;
        }
        try {
            d.e(dVarArrD, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static d[] f(d[] dVarArr) {
        if (dVarArr == null) {
            return null;
        }
        d[] dVarArr2 = new d[dVarArr.length];
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            dVarArr2[i2] = new d(dVarArr[i2]);
        }
        return dVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(String str, int i2, c cVar) {
        cVar.b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = i2; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
                if (z3) {
                }
            } else {
                if (cCharAt != 'E' && cCharAt != 'e') {
                    switch (cCharAt) {
                        case ',':
                            break;
                        case '-':
                            if (i3 != i2 && !z) {
                                cVar.b = true;
                                z = false;
                                z3 = true;
                                break;
                            }
                            z = false;
                            break;
                        case '.':
                            if (z2) {
                                cVar.b = true;
                                z = false;
                                z3 = true;
                                break;
                            } else {
                                z = false;
                                z2 = true;
                                break;
                            }
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (z3) {
                }
            }
            cVar.a = i3;
        }
        cVar.a = i3;
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            c cVar = new c();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                g(str, i2, cVar);
                int i4 = cVar.a;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = cVar.b ? i4 : i4 + 1;
            }
            return c(fArr, 0, i3);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    private static int i(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static void j(d[] dVarArr, d[] dVarArr2) {
        for (int i2 = 0; i2 < dVarArr2.length; i2++) {
            dVarArr[i2].a = dVarArr2[i2].a;
            for (int i3 = 0; i3 < dVarArr2[i2].b.length; i3++) {
                dVarArr[i2].b[i3] = dVarArr2[i2].b[i3];
            }
        }
    }
}
