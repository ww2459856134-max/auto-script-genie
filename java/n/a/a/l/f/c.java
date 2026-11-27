package n.a.a.l.f;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import n.a.a.o.y0;

/* loaded from: classes.dex */
public final class c {
    private n.a.a.l.a.a a;
    private int[] b;
    private boolean c;
    private int d;

    private c(n.a.a.l.a.a aVar) {
        this.a = aVar;
        int[] iArr = new int[aVar.a()];
        this.b = iArr;
        this.c = true;
        Arrays.fill(iArr, -1);
    }

    public static c a(n.a.a.l.a.a aVar, boolean z) {
        c cVar = new c(aVar);
        if (z) {
            cVar.b[aVar.d()] = -2;
        }
        return cVar;
    }

    public static b b(int i2, d dVar, List<c> list) {
        int iA = dVar.c().a();
        return new b(i2 % iA, list.get(i2 / iA));
    }

    public static b e(int i2, d dVar, List<c> list) {
        return b(i2, dVar, list);
    }

    private void h() {
        int[] iArr = this.b;
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (iArr[i2] == -1) {
                z = true;
                break;
            }
            i2++;
        }
        this.c = z;
    }

    private byte[] i() {
        byte[] bArr = new byte[this.a.b()];
        int i2 = 0;
        for (int i3 : this.b) {
            y0.b(bArr, i2, i3);
            i2 += 4;
        }
        return bArr;
    }

    public int c() {
        for (int length = this.b.length - 1; length >= 0; length--) {
            if (this.b[length] != -1) {
                return length + 1;
            }
        }
        return 0;
    }

    public int d() {
        return this.d;
    }

    public int f(int i2) {
        int[] iArr = this.b;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        throw new ArrayIndexOutOfBoundsException("Unable to fetch offset " + i2 + " as the BAT only contains " + this.b.length + " entries");
    }

    public boolean g() {
        return this.c;
    }

    public void j(int i2) {
        this.d = i2;
    }

    public void k(int i2, int i3) {
        int[] iArr = this.b;
        int i4 = iArr[i2];
        iArr[i2] = i3;
        if (i3 == -1) {
            this.c = true;
        } else if (i4 == -1) {
            h();
        }
    }

    public void l(ByteBuffer byteBuffer) {
        byteBuffer.put(i());
    }
}
