package n.a.a.n.c.r1;

/* loaded from: classes.dex */
public final class m0 implements n0 {
    public static final m0 b = new m0("");
    private final String a;

    public m0(String str) {
        if (str == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        this.a = str;
    }

    @Override // n.a.a.n.c.r1.n0
    public String getStringValue() {
        return this.a;
    }

    public String toString() {
        return m0.class.getName() + " [" + this.a + "]";
    }
}
