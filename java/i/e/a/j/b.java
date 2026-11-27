package i.e.a.j;

/* loaded from: classes.dex */
public abstract class b extends v {
    protected final int e;

    protected b(String str, String str2, String str3, int i2) {
        super(str, str2, str3);
        this.e = i2;
    }

    public int hashCode() {
        return this.e;
    }

    public abstract boolean t(int i2, int i3);

    public abstract boolean u(int[] iArr, int i2);

    public abstract boolean v(int i2, int i3, int i4);

    public abstract boolean w(int i2, int[] iArr, int i3);
}
