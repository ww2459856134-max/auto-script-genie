package i.e.a.l;

/* loaded from: classes.dex */
public final class h {
    private String a = null;
    private StringBuilder b = null;

    public void a(String str) {
        int length = str.length();
        if (length > 0) {
            String str2 = this.a;
            if (str2 != null) {
                StringBuilder sb = new StringBuilder(str2.length() + length);
                this.b = sb;
                sb.append(this.a);
                this.a = null;
            }
            StringBuilder sb2 = this.b;
            if (sb2 != null) {
                sb2.append(str);
            } else {
                this.a = str;
            }
        }
    }

    public String b() {
        String str = this.a;
        if (str != null) {
            this.a = null;
            return str;
        }
        StringBuilder sb = this.b;
        if (sb == null) {
            return "";
        }
        String string = sb.toString();
        this.b = null;
        return string;
    }
}
