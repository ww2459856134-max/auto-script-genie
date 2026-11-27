package k.a0.a;

/* loaded from: classes.dex */
abstract class a2 {
    public static double a(int i2) {
        if ((i2 & 2) != 0) {
            double d = i2 >> 2;
            return (i2 & 1) != 0 ? d / 100.0d : d;
        }
        double dLongBitsToDouble = Double.longBitsToDouble((i2 & (-4)) << 32);
        return (i2 & 1) != 0 ? dLongBitsToDouble / 100.0d : dLongBitsToDouble;
    }
}
