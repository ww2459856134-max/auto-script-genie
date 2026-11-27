package l.a.a.i;

/* loaded from: classes.dex */
public abstract class a {
    public static boolean a(byte b, int i2) {
        return ((1 << i2) & ((long) b)) != 0;
    }

    public static byte b(byte b, int i2) {
        return (byte) (b | (1 << i2));
    }

    public static byte c(byte b, int i2) {
        return (byte) (b & (~(1 << i2)));
    }
}
