package i.i.a;

import java.util.Objects;

/* loaded from: classes.dex */
public class d extends a {
    boolean a;

    protected d() {
    }

    @Override // i.i.a.a
    protected boolean a(int i2, int i3, int i4, long[] jArr, long[] jArr2) {
        boolean z = true;
        while (i3 != i4) {
            long j2 = jArr[i3];
            boolean z2 = false;
            this.a &= j2 == jArr2[i3];
            if (j2 == 0) {
                z2 = true;
            }
            z &= z2;
            i3++;
        }
        return z;
    }

    @Override // i.i.a.a
    protected int d() {
        return 1;
    }

    @Override // i.i.a.a
    protected boolean e(h hVar) {
        Objects.requireNonNull(hVar);
        this.a = true;
        return false;
    }

    @Override // i.i.a.a
    protected boolean f(int i2, int i3, long[] jArr, long[] jArr2, long j2) {
        long j3 = jArr[i3];
        this.a &= (j3 & j2) == (jArr2[i3] & j2);
        return j3 == 0;
    }
}
