package n.a.a.o;

/* loaded from: classes.dex */
public class x0 {
    private int a;
    private final int b;

    public x0(int i2) throws ArrayIndexOutOfBoundsException {
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("negative offset");
        }
        this.b = i2;
    }

    public int a() {
        return this.a;
    }

    public void b(int i2, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this.a = i2;
        c(bArr);
    }

    public void c(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        y0.b(bArr, this.b, this.a);
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    public x0(int i2, int i3, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i2);
        b(i3, bArr);
    }
}
