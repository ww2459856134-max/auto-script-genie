package n.a.a.n.c.p1;

import java.util.Calendar;

/* loaded from: classes.dex */
final class z {
    public final int a;
    public final int b;
    public final int c;
    public final long d;

    public z(Calendar calendar) {
        this.a = calendar.get(1);
        this.b = calendar.get(2) + 1;
        this.c = calendar.get(5);
        this.d = calendar.getTimeInMillis();
    }
}
