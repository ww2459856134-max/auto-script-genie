package i.b.ha.a.e.d;

import i.b.ha.a.e.g.j;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a extends b implements Serializable {
    protected final int[] c;
    protected final int[] d;
    protected final int[] e;
    protected final int[] f;
    protected final int[] g;

    /* renamed from: h, reason: collision with root package name */
    protected final int[] f1489h;

    protected a(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, null);
    }

    public void a(long j2) {
        b(new int[]{(int) (j2 >>> 32), (int) (j2 & 4294967295L)});
    }

    public void b(int[] iArr) {
        if (iArr == null) {
            a(System.currentTimeMillis() + System.identityHashCode(this));
            return;
        }
        int[] iArr2 = this.c;
        System.arraycopy(iArr, 0, iArr2, 0, j.q(iArr.length, iArr2.length));
        if (iArr.length < this.c.length) {
            int length = iArr.length;
            while (true) {
                int[] iArr3 = this.c;
                if (length >= iArr3.length) {
                    break;
                }
                long j2 = iArr3[length - iArr.length];
                iArr3[length] = (int) ((((j2 ^ (j2 >> 30)) * 1812433253) + length) & 4294967295L);
                length++;
            }
        }
        clear();
    }

    protected a(int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = ((i2 + 32) - 1) / 32;
        this.c = new int[i6];
        this.d = new int[i6];
        this.e = new int[i6];
        this.f = new int[i6];
        this.g = new int[i6];
        this.f1489h = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i7 + i6;
            this.d[i7] = (i8 - 1) % i6;
            this.e[i7] = (i8 - 2) % i6;
            this.f[i7] = (i7 + i3) % i6;
            this.g[i7] = (i7 + i4) % i6;
            this.f1489h[i7] = (i7 + i5) % i6;
        }
        b(iArr);
    }
}
