package n.b.a.m;

/* loaded from: classes2.dex */
public final class j {
    private String a = null;
    private StringBuffer b = null;

    public void a(String str) {
        int length = str.length();
        if (length > 0) {
            String str2 = this.a;
            if (str2 != null) {
                StringBuffer stringBuffer = new StringBuffer(str2.length() + length);
                this.b = stringBuffer;
                stringBuffer.append(this.a);
                this.a = null;
            }
            StringBuffer stringBuffer2 = this.b;
            if (stringBuffer2 != null) {
                stringBuffer2.append(str);
            } else {
                this.a = str;
            }
        }
    }

    public String b() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        StringBuffer stringBuffer = this.b;
        return stringBuffer != null ? stringBuffer.toString() : "";
    }

    public void c() {
        this.a = null;
        this.b = null;
    }
}
