package i.b.ha.a.e.g;

/* loaded from: classes.dex */
public abstract class l {
    public static double[] a(double[] dArr, int i2) {
        double[] dArr2 = new double[i2];
        System.arraycopy(dArr, 0, dArr2, 0, j.q(i2, dArr.length));
        return dArr2;
    }

    public static boolean b(double[] dArr, int i2, int i3, boolean z) throws i.b.ha.a.e.b.d {
        if (dArr == null) {
            throw new i.b.ha.a.e.b.l(i.b.ha.a.e.b.p.d.INPUT_ARRAY, new Object[0]);
        }
        if (i2 < 0) {
            throw new i.b.ha.a.e.b.j(i.b.ha.a.e.b.p.d.START_POSITION, Integer.valueOf(i2));
        }
        if (i3 < 0) {
            throw new i.b.ha.a.e.b.j(i.b.ha.a.e.b.p.d.LENGTH, Integer.valueOf(i3));
        }
        int i4 = i2 + i3;
        if (i4 <= dArr.length) {
            return i3 != 0 || z;
        }
        throw new i.b.ha.a.e.b.m(i.b.ha.a.e.b.p.d.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(i4), Integer.valueOf(dArr.length), true);
    }
}
