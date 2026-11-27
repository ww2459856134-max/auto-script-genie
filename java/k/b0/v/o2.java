package k.b0.v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class o2 extends k.x.c1 {

    /* renamed from: i, reason: collision with root package name */
    private static int f1920i = 8216;
    private int c;
    private int d;
    private ArrayList e;
    private ArrayList f;
    private byte[] g;

    /* renamed from: h, reason: collision with root package name */
    private int f1921h;

    public o2(int i2, int i3) {
        super(k.x.z0.s);
        this.c = i2;
        this.d = i3;
        this.f1921h = 0;
        this.e = new ArrayList(50);
        this.f = new ArrayList(50);
    }

    public int A(String str) {
        int length = (str.length() * 2) + 3;
        if (this.f1921h >= f1920i - 5) {
            if (str.length() > 0) {
                return str.length();
            }
            return -1;
        }
        this.f.add(new Integer(str.length()));
        int i2 = this.f1921h;
        int i3 = length + i2;
        int i4 = f1920i;
        if (i3 < i4) {
            this.e.add(str);
            this.f1921h += length;
            return 0;
        }
        int i5 = (i4 - 3) - i2;
        if (i5 % 2 != 0) {
            i5--;
        }
        int i6 = i5 / 2;
        this.e.add(str.substring(0, i6));
        this.f1921h += (i6 * 2) + 3;
        return str.length() - i6;
    }

    public int B() {
        return this.f1921h + 8;
    }

    @Override // k.x.c1
    public byte[] y() {
        int length = 8;
        byte[] bArr = new byte[this.f1921h + 8];
        this.g = bArr;
        int i2 = 0;
        k.x.s0.a(this.c, bArr, 0);
        k.x.s0.a(this.d, this.g, 4);
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.x.s0.f(((Integer) this.f.get(i2)).intValue(), this.g, length);
            byte[] bArr2 = this.g;
            bArr2[length + 2] = 1;
            k.x.y0.e(str, bArr2, length + 3);
            length += (str.length() * 2) + 3;
            i2++;
        }
        return this.g;
    }
}
