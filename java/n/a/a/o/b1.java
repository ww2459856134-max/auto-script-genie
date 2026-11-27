package n.a.a.o;

/* loaded from: classes.dex */
public class b1 {
    private long a;
    private final int b;

    public b1(int i2) throws ArrayIndexOutOfBoundsException {
        if (i2 >= 0) {
            this.b = i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i2);
    }

    public void a(long j2, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this.a = j2;
        b(bArr);
    }

    public void b(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        y0.c(bArr, this.b, this.a);
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    public b1(int i2, long j2, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        this(i2);
        a(j2, bArr);
    }
}
