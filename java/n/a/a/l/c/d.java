package n.a.a.l.c;

/* loaded from: classes.dex */
public class d {
    private final boolean[] a;

    protected d(e eVar, long j2) {
        if (j2 >= 0) {
            long jD = eVar.d();
            int i2 = (int) (j2 / jD);
            this.a = new boolean[j2 % jD != 0 ? i2 + 1 : i2];
        } else {
            throw new IllegalArgumentException("Cannot create a ChainLoopDetector with negative size, but had: " + j2);
        }
    }

    protected void a(int i2) {
        boolean[] zArr = this.a;
        if (i2 >= zArr.length) {
            return;
        }
        if (!zArr[i2]) {
            zArr[i2] = true;
            return;
        }
        throw new IllegalStateException("Potential loop detected - Block " + i2 + " was already claimed but was just requested again");
    }
}
