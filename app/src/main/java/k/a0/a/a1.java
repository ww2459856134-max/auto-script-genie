package k.a0.a;

import com.auto.exceldeps.log4j.util.Chars;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class a1 extends k.x.w0 implements k.m {

    /* renamed from: k, reason: collision with root package name */
    private static k.y.c f1770k = k.y.c.b(a1.class);

    /* renamed from: l, reason: collision with root package name */
    private static final z0 f1771l = new z0();

    /* renamed from: m, reason: collision with root package name */
    private static final z0 f1772m = new z0();

    /* renamed from: n, reason: collision with root package name */
    private static final z0 f1773n = new z0();

    /* renamed from: o, reason: collision with root package name */
    private static final z0 f1774o = new z0();
    private int c;
    private int d;
    private int e;
    private int f;
    private URL g;

    /* renamed from: h, reason: collision with root package name */
    private File f1775h;

    /* renamed from: i, reason: collision with root package name */
    private String f1776i;

    /* renamed from: j, reason: collision with root package name */
    private z0 f1777j;

    a1(f2 f2Var, k.s sVar, k.w wVar) {
        super(f2Var);
        this.f1777j = f1774o;
        byte[] bArrC = x().c();
        this.c = k.x.s0.c(bArrC[0], bArrC[1]);
        this.d = k.x.s0.c(bArrC[2], bArrC[3]);
        this.e = k.x.s0.c(bArrC[4], bArrC[5]);
        this.f = k.x.s0.c(bArrC[6], bArrC[7]);
        int iD = k.x.s0.d(bArrC[28], bArrC[29], bArrC[30], bArrC[31]);
        int iD2 = ((iD & 20) != 0 ? (k.x.s0.d(bArrC[32], bArrC[33], bArrC[34], bArrC[35]) * 2) + 4 : 0) + 32;
        int iD3 = iD2 + ((iD & 128) != 0 ? (k.x.s0.d(bArrC[iD2], bArrC[iD2 + 1], bArrC[iD2 + 2], bArrC[iD2 + 3]) * 2) + 4 : 0);
        if ((iD & 3) == 3) {
            this.f1777j = f1771l;
            if (bArrC[iD3] == 3) {
                this.f1777j = f1772m;
            }
        } else if ((iD & 1) != 0) {
            this.f1777j = f1772m;
            if (bArrC[iD3] == -32) {
                this.f1777j = f1771l;
            }
        } else if ((iD & 8) != 0) {
            this.f1777j = f1773n;
        }
        z0 z0Var = this.f1777j;
        if (z0Var != f1771l) {
            if (z0Var != f1772m) {
                if (z0Var == f1773n) {
                    this.f1776i = k.x.y0.g(bArrC, k.x.s0.d(bArrC[32], bArrC[33], bArrC[34], bArrC[35]) - 1, 36);
                    return;
                } else {
                    f1770k.f("Cannot determine link type");
                    return;
                }
            }
            int i2 = iD3 + 16;
            try {
                int iC = k.x.s0.c(bArrC[i2], bArrC[i2 + 1]);
                String strD = k.x.y0.d(bArrC, k.x.s0.d(bArrC[i2 + 2], bArrC[i2 + 3], bArrC[i2 + 4], bArrC[i2 + 5]) - 1, i2 + 6, wVar);
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < iC; i3++) {
                    stringBuffer.append("..\\");
                }
                stringBuffer.append(strD);
                this.f1775h = new File(stringBuffer.toString());
                return;
            } catch (Throwable th) {
                f1770k.f("Exception when parsing file " + th.getClass().getName() + ".");
                this.f1775h = new File(".");
                return;
            }
        }
        String strG = null;
        int i4 = iD3 + 16;
        try {
            try {
                strG = k.x.y0.g(bArrC, (k.x.s0.d(bArrC[i4], bArrC[i4 + 1], bArrC[i4 + 2], bArrC[i4 + 3]) / 2) - 1, i4 + 4);
                this.g = new URL(strG);
            } catch (MalformedURLException unused) {
            }
        } catch (MalformedURLException unused2) {
            f1770k.f("URL " + strG + " is malformed.  Trying a file");
            try {
                this.f1777j = f1772m;
                this.f1775h = new File(strG);
            } catch (Exception unused3) {
                f1770k.f("Cannot set to file.  Setting a default URL");
                this.f1777j = f1771l;
                this.g = new URL("http://www.andykhan.com/jexcelapi/index.html");
            }
        } catch (Throwable th2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            k.e.c(this.e, this.c, stringBuffer2);
            k.e.c(this.f, this.d, stringBuffer3);
            stringBuffer2.insert(0, "Exception when parsing URL ");
            stringBuffer2.append(Chars.DQUOTE);
            stringBuffer2.append(stringBuffer3.toString());
            stringBuffer2.append("\".  Using default.");
            f1770k.g(stringBuffer2, th2);
            this.g = new URL("http://www.andykhan.com/jexcelapi/index.html");
        }
    }

    public int A() {
        return this.d;
    }

    public String B() {
        return this.f1776i;
    }

    public URL C() {
        return this.g;
    }

    public boolean D() {
        return this.f1777j == f1772m;
    }

    public boolean E() {
        return this.f1777j == f1773n;
    }

    public boolean F() {
        return this.f1777j == f1771l;
    }

    public int b() {
        return this.e;
    }

    public int getRow() {
        return this.c;
    }

    @Override // k.x.w0
    public f2 x() {
        return super.x();
    }

    public File y() {
        return this.f1775h;
    }

    public int z() {
        return this.f;
    }
}
