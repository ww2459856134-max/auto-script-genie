package n.a.a.n.c.t1;

/* loaded from: classes.dex */
public abstract class e3 {
    public static double a(String str, int i2, int i3) throws IllegalArgumentException {
        long j2;
        int i4;
        if (str == null || str.isEmpty()) {
            return 0.0d;
        }
        long length = str.length();
        long j3 = i3;
        if (length > j3) {
            throw new IllegalArgumentException();
        }
        long j4 = 0;
        double d = 0.0d;
        boolean z = true;
        for (char c : str.toCharArray()) {
            if ('0' > c || c > '9') {
                if ('A' <= c && c <= 'Z') {
                    i4 = c - 'A';
                } else if ('a' > c || c > 'z') {
                    j2 = i2;
                } else {
                    i4 = c - 'a';
                }
                j2 = i4 + 10;
            } else {
                j2 = c - 48;
            }
            if (j2 >= i2) {
                throw new IllegalArgumentException("character not allowed");
            }
            if (z) {
                j4 = j2;
                z = false;
            }
            d = (d * i2) + j2;
        }
        return !z && (length > j3 ? 1 : (length == j3 ? 0 : -1)) == 0 && (j4 > ((long) (i2 / 2)) ? 1 : (j4 == ((long) (i2 / 2)) ? 0 : -1)) >= 0 ? b(i2, i3, d) * (-1.0d) : d;
    }

    private static double b(double d, double d2, double d3) {
        return Math.pow(d, d2) - d3;
    }
}
