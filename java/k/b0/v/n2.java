package k.b0.v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class n2 extends k.x.c1 {

    /* renamed from: j, reason: collision with root package name */
    private static int f1913j = 8224;
    private String c;
    private boolean d;
    private int e;
    private ArrayList f;
    private ArrayList g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f1914h;

    /* renamed from: i, reason: collision with root package name */
    private int f1915i;

    public n2() {
        super(k.x.z0.v);
        this.f1915i = 0;
        this.f = new ArrayList(50);
        this.g = new ArrayList(50);
    }

    public int A(String str) {
        int length = (str.length() * 2) + 3;
        if (this.f1915i >= f1913j - 5) {
            return str.length();
        }
        this.g.add(new Integer(str.length()));
        int i2 = this.f1915i;
        int i3 = length + i2;
        int i4 = f1913j;
        if (i3 < i4) {
            this.f.add(str);
            this.f1915i += length;
            return 0;
        }
        int i5 = (i4 - 3) - i2;
        if (i5 % 2 != 0) {
            i5--;
        }
        int i6 = i5 / 2;
        this.f.add(str.substring(0, i6));
        this.f1915i += (i6 * 2) + 3;
        return str.length() - i6;
    }

    public int B() {
        return this.f1915i;
    }

    public int C(String str, boolean z) {
        this.d = z;
        this.e = str.length();
        int length = !this.d ? (str.length() * 2) + 1 : (str.length() * 2) + 3;
        int i2 = f1913j;
        if (length <= i2) {
            this.c = str;
            this.f1915i += length;
            return 0;
        }
        int i3 = (this.d ? i2 - 4 : i2 - 2) / 2;
        this.c = str.substring(0, i3);
        this.f1915i = f1913j - 1;
        return str.length() - i3;
    }

    @Override // k.x.c1
    public byte[] y() {
        int i2;
        byte[] bArr = new byte[this.f1915i];
        this.f1914h = bArr;
        int i3 = 0;
        if (this.d) {
            k.x.s0.f(this.e, bArr, 0);
            this.f1914h[2] = 1;
            i2 = 3;
        } else {
            bArr[0] = 1;
            i2 = 1;
        }
        k.x.y0.e(this.c, this.f1914h, i2);
        int length = i2 + (this.c.length() * 2);
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.x.s0.f(((Integer) this.g.get(i3)).intValue(), this.f1914h, length);
            byte[] bArr2 = this.f1914h;
            bArr2[length + 2] = 1;
            k.x.y0.e(str, bArr2, length + 3);
            length += (str.length() * 2) + 3;
            i3++;
        }
        return this.f1914h;
    }
}
