package i.i.a;

/* loaded from: classes.dex */
public abstract class a {
    protected a() {
    }

    protected abstract boolean a(int i2, int i3, int i4, long[] jArr, long[] jArr2);

    protected void b(int i2, int i3) {
    }

    protected final boolean c(long[] jArr) {
        for (long j2 : jArr) {
            if (j2 != 0) {
                return false;
            }
        }
        return true;
    }

    protected abstract int d();

    protected abstract boolean e(h hVar);

    protected abstract boolean f(int i2, int i3, long[] jArr, long[] jArr2, long j2);
}
