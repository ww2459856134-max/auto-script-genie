package i.e.a.l;

/* loaded from: classes.dex */
public final class a {
    private volatile char[] a = null;
    private volatile char[] b = null;
    private volatile char[] c = null;
    private volatile byte[] d = null;

    public synchronized byte[] a(int i2) {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < i2) {
            return null;
        }
        this.d = null;
        return bArr;
    }

    public synchronized char[] b(int i2) {
        char[] cArr = this.c;
        if (cArr == null || cArr.length < i2) {
            return null;
        }
        this.c = null;
        return cArr;
    }

    public synchronized char[] c(int i2) {
        char[] cArr = this.b;
        if (cArr == null || cArr.length < i2) {
            return null;
        }
        this.b = null;
        return cArr;
    }

    public synchronized char[] d(int i2) {
        char[] cArr = this.a;
        if (cArr == null || cArr.length < i2) {
            return null;
        }
        this.a = null;
        return cArr;
    }

    public synchronized void e(byte[] bArr) {
        this.d = bArr;
    }

    public synchronized void f(char[] cArr) {
        this.c = cArr;
    }

    public synchronized void g(char[] cArr) {
        this.b = cArr;
    }

    public synchronized void h(char[] cArr) {
        this.a = cArr;
    }
}
