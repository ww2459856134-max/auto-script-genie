package o.a;

import java.util.Random;

/* loaded from: classes3.dex */
public abstract class f {
    public static int a(int i2, int i3) {
        if (i3 >= i2) {
            return i3 == i2 ? i2 : new Random().nextInt(i3 - i2) + i2;
        }
        throw new IllegalArgumentException("start must be less than or equal to end");
    }
}
