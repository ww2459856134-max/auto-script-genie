package k.b0.v;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public abstract class x0 extends k.x.c1 {

    /* renamed from: n, reason: collision with root package name */
    private static final w0 f1978n;

    /* renamed from: o, reason: collision with root package name */
    private static final w0 f1979o;
    private static final w0 p;
    private static final w0 q;
    private static final w0 r;
    private int c;
    private int d;
    private int e;
    private int f;
    private URL g;

    /* renamed from: h, reason: collision with root package name */
    private File f1980h;

    /* renamed from: i, reason: collision with root package name */
    private String f1981i;

    /* renamed from: j, reason: collision with root package name */
    private String f1982j;

    /* renamed from: k, reason: collision with root package name */
    private w0 f1983k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f1984l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1985m;

    static {
        k.y.c.b(x0.class);
        f1978n = new w0();
        f1979o = new w0();
        p = new w0();
        q = new w0();
        r = new w0();
    }

    protected x0(k.m mVar, k.b0.s sVar) {
        super(k.x.z0.N0);
        if (mVar instanceof k.a0.a.a1) {
            A(mVar, sVar);
        } else {
            B(mVar, sVar);
        }
    }

    private void A(k.m mVar, k.b0.s sVar) {
        k.a0.a.a1 a1Var = (k.a0.a.a1) mVar;
        this.f1984l = a1Var.x().c();
        this.c = a1Var.getRow();
        this.e = a1Var.b();
        this.d = a1Var.A();
        this.f = a1Var.z();
        this.f1983k = r;
        if (a1Var.D()) {
            this.f1983k = f1979o;
            this.f1980h = a1Var.y();
        } else if (a1Var.F()) {
            this.f1983k = f1978n;
            this.g = a1Var.C();
        } else if (a1Var.E()) {
            this.f1983k = q;
            this.f1981i = a1Var.B();
        }
        this.f1985m = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(k.m mVar, k.b0.s sVar) {
        x0 x0Var = (x0) mVar;
        this.c = x0Var.c;
        this.d = x0Var.d;
        this.e = x0Var.e;
        this.f = x0Var.f;
        if (x0Var.g != null) {
            try {
                this.g = new URL(x0Var.g.toString());
            } catch (MalformedURLException unused) {
                k.y.a.a(false);
            }
        }
        if (x0Var.f1980h != null) {
            this.f1980h = new File(x0Var.f1980h.getPath());
        }
        this.f1981i = x0Var.f1981i;
        this.f1982j = x0Var.f1982j;
        this.f1983k = x0Var.f1983k;
        this.f1985m = true;
    }

    private byte[] C(byte[] bArr) {
        char cCharAt;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(this.f1980h.getName());
        arrayList2.add(E(this.f1980h.getName()));
        for (File parentFile = this.f1980h.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            arrayList.add(parentFile.getName());
            arrayList2.add(E(parentFile.getName()));
        }
        int size = arrayList.size() - 1;
        boolean z = true;
        int i2 = 0;
        while (z) {
            if (((String) arrayList.get(size)).equals("..")) {
                i2++;
                arrayList.remove(size);
                arrayList2.remove(size);
            } else {
                z = false;
            }
            size--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        if (this.f1980h.getPath().charAt(1) == ':' && (cCharAt = this.f1980h.getPath().charAt(0)) != 'C' && cCharAt != 'c') {
            stringBuffer.append(cCharAt);
            stringBuffer.append(NameUtil.COLON);
            stringBuffer2.append(cCharAt);
            stringBuffer2.append(NameUtil.COLON);
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            stringBuffer.append((String) arrayList.get(size2));
            stringBuffer2.append((String) arrayList2.get(size2));
            if (size2 != 0) {
                stringBuffer.append("\\");
                stringBuffer2.append("\\");
            }
        }
        String string = stringBuffer.toString();
        String string2 = stringBuffer2.toString();
        int length = bArr.length + 4 + string2.length() + 1 + 16 + 2 + 8 + ((string.length() + 1) * 2) + 24;
        String str = this.f1982j;
        if (str != null) {
            length += ((str.length() + 1) * 2) + 4;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length2 = bArr.length;
        String str2 = this.f1982j;
        if (str2 != null) {
            k.x.s0.a(str2.length() + 1, bArr2, length2);
            k.x.y0.e(this.f1982j, bArr2, length2 + 4);
            length2 += ((this.f1982j.length() + 1) * 2) + 4;
        }
        bArr2[length2] = 3;
        bArr2[length2 + 1] = 3;
        bArr2[length2 + 2] = 0;
        bArr2[length2 + 3] = 0;
        bArr2[length2 + 4] = 0;
        bArr2[length2 + 5] = 0;
        bArr2[length2 + 6] = 0;
        bArr2[length2 + 7] = 0;
        bArr2[length2 + 8] = -64;
        bArr2[length2 + 9] = 0;
        bArr2[length2 + 10] = 0;
        bArr2[length2 + 11] = 0;
        bArr2[length2 + 12] = 0;
        bArr2[length2 + 13] = 0;
        bArr2[length2 + 14] = 0;
        bArr2[length2 + 15] = 70;
        int i3 = length2 + 16;
        k.x.s0.f(i2, bArr2, i3);
        int i4 = i3 + 2;
        k.x.s0.a(string2.length() + 1, bArr2, i4);
        k.x.y0.a(string2, bArr2, i4 + 4);
        int length3 = i4 + string2.length() + 1 + 4;
        bArr2[length3] = -1;
        bArr2[length3 + 1] = -1;
        bArr2[length3 + 2] = -83;
        bArr2[length3 + 3] = -34;
        bArr2[length3 + 4] = 0;
        bArr2[length3 + 5] = 0;
        bArr2[length3 + 6] = 0;
        bArr2[length3 + 7] = 0;
        bArr2[length3 + 8] = 0;
        bArr2[length3 + 9] = 0;
        bArr2[length3 + 10] = 0;
        bArr2[length3 + 11] = 0;
        bArr2[length3 + 12] = 0;
        bArr2[length3 + 13] = 0;
        bArr2[length3 + 14] = 0;
        bArr2[length3 + 15] = 0;
        bArr2[length3 + 16] = 0;
        bArr2[length3 + 17] = 0;
        bArr2[length3 + 18] = 0;
        bArr2[length3 + 19] = 0;
        bArr2[length3 + 20] = 0;
        bArr2[length3 + 21] = 0;
        bArr2[length3 + 22] = 0;
        bArr2[length3 + 23] = 0;
        int i5 = length3 + 24;
        k.x.s0.a((string.length() * 2) + 6, bArr2, i5);
        int i6 = i5 + 4;
        k.x.s0.a(string.length() * 2, bArr2, i6);
        int i7 = i6 + 4;
        bArr2[i7] = 3;
        bArr2[i7 + 1] = 0;
        k.x.y0.e(string, bArr2, i7 + 2);
        string.length();
        return bArr2;
    }

    private byte[] D(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 4 + ((this.f1981i.length() + 1) * 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length = bArr.length;
        k.x.s0.a(this.f1981i.length() + 1, bArr2, length);
        k.x.y0.e(this.f1981i, bArr2, length + 4);
        return bArr2;
    }

    private String E(String str) {
        String strSubstring;
        int iIndexOf = str.indexOf(46);
        if (iIndexOf == -1) {
            strSubstring = "";
        } else {
            String strSubstring2 = str.substring(0, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1);
            str = strSubstring2;
        }
        if (str.length() > 8) {
            str = (str.substring(0, 6) + "~" + (str.length() - 8)).substring(0, 8);
        }
        String strSubstring3 = strSubstring.substring(0, Math.min(3, strSubstring.length()));
        if (strSubstring3.length() <= 0) {
            return str;
        }
        return str + NameUtil.PERIOD + strSubstring3;
    }

    private byte[] F(byte[] bArr) {
        String path = this.f1980h.getPath();
        byte[] bArr2 = new byte[bArr.length + (path.length() * 2) + 2 + 4];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length = bArr.length;
        k.x.s0.a(path.length() + 1, bArr2, length);
        k.x.y0.e(path, bArr2, length + 4);
        return bArr2;
    }

    private byte[] G(byte[] bArr) {
        String string = this.g.toString();
        int length = bArr.length + 20 + ((string.length() + 1) * 2);
        String str = this.f1982j;
        if (str != null) {
            length += ((str.length() + 1) * 2) + 4;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int length2 = bArr.length;
        String str2 = this.f1982j;
        if (str2 != null) {
            k.x.s0.a(str2.length() + 1, bArr2, length2);
            k.x.y0.e(this.f1982j, bArr2, length2 + 4);
            length2 += ((this.f1982j.length() + 1) * 2) + 4;
        }
        bArr2[length2] = -32;
        bArr2[length2 + 1] = -55;
        bArr2[length2 + 2] = -22;
        bArr2[length2 + 3] = 121;
        bArr2[length2 + 4] = -7;
        bArr2[length2 + 5] = -70;
        bArr2[length2 + 6] = -50;
        bArr2[length2 + 7] = 17;
        bArr2[length2 + 8] = -116;
        bArr2[length2 + 9] = -126;
        bArr2[length2 + 10] = 0;
        bArr2[length2 + 11] = -86;
        bArr2[length2 + 12] = 0;
        bArr2[length2 + 13] = 75;
        bArr2[length2 + 14] = -87;
        bArr2[length2 + 15] = 11;
        k.x.s0.a((string.length() + 1) * 2, bArr2, length2 + 16);
        k.x.y0.e(string, bArr2, length2 + 20);
        return bArr2;
    }

    public boolean H() {
        return this.f1983k == f1979o;
    }

    public boolean I() {
        return this.f1983k == q;
    }

    public boolean J() {
        return this.f1983k == p;
    }

    public boolean K() {
        return this.f1983k == f1978n;
    }

    public String toString() {
        return H() ? this.f1980h.toString() : K() ? this.g.toString() : J() ? this.f1980h.toString() : "";
    }

    @Override // k.x.c1
    public byte[] y() {
        if (!this.f1985m) {
            return this.f1984l;
        }
        int i2 = 0;
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, -48, -55, -22, 121, -7, -70, -50, 17, -116, -126, 0, -86, 0, 75, -87, 11, 2, 0, 0, 0, 0, 0, 0, 0};
        k.x.s0.f(this.c, bArr, 0);
        k.x.s0.f(this.d, bArr, 2);
        k.x.s0.f(this.e, bArr, 4);
        k.x.s0.f(this.f, bArr, 6);
        if (K()) {
            i2 = 3;
            if (this.f1982j != null) {
                i2 = 23;
            }
        } else if (H()) {
            i2 = 1;
            if (this.f1982j != null) {
                i2 = 21;
            }
        } else if (I()) {
            i2 = 8;
        } else if (J()) {
            i2 = 259;
        }
        k.x.s0.a(i2, bArr, 28);
        if (K()) {
            this.f1984l = G(bArr);
        } else if (H()) {
            this.f1984l = C(bArr);
        } else if (I()) {
            this.f1984l = D(bArr);
        } else if (J()) {
            this.f1984l = F(bArr);
        }
        return this.f1984l;
    }
}
