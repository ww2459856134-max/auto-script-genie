package n.a.a.n.c.t1;

import java.util.Iterator;

/* loaded from: classes.dex */
public interface m8 {
    default Iterator<Integer> a() {
        return new k8(this);
    }

    default Iterator<Integer> b() {
        return new l8(this);
    }

    n.a.a.n.c.r1.w0 getItem(int i2);

    int getSize();
}
