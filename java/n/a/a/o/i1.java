package n.a.a.o;

/* loaded from: classes.dex */
public class i1 {
    private short a;
    private final int b;

    public i1(int i2) throws ArrayIndexOutOfBoundsException {
        if (i2 >= 0) {
            this.b = i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i2);
    }

    public void a(short s, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this.a = s;
        b(bArr);
    }

    public void b(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        y0.d(bArr, this.b, this.a);
    }

    public String toString() {
        return String.valueOf((int) this.a);
    }

    public i1(int i2, short s, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i2);
        a(s, bArr);
    }
}
