package n.a.a.o;

/* loaded from: classes.dex */
public class m0 {
    private byte a;
    private final int b;

    public m0(int i2) throws ArrayIndexOutOfBoundsException {
        this(i2, (byte) 0);
    }

    public void a(byte b) {
        this.a = b;
    }

    public void b(byte b, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        a(b);
        c(bArr);
    }

    public void c(byte[] bArr) throws ArrayIndexOutOfBoundsException {
        bArr[this.b] = this.a;
    }

    public String toString() {
        return String.valueOf((int) this.a);
    }

    public m0(int i2, byte b) throws ArrayIndexOutOfBoundsException {
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
        }
        this.b = i2;
        a(b);
    }
}
