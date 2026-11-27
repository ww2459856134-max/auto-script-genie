package k.x;

/* loaded from: classes.dex */
public abstract class p0 {
    private StringBuffer a;

    protected p0() {
        this.a = new StringBuffer();
    }

    protected boolean a() {
        StringBuffer stringBuffer = this.a;
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    protected String b() {
        StringBuffer stringBuffer = this.a;
        return stringBuffer != null ? stringBuffer.toString() : "";
    }

    protected p0(String str) {
        this.a = new StringBuffer(str);
    }

    protected p0(p0 p0Var) {
        this.a = new StringBuffer(p0Var.b());
    }
}
