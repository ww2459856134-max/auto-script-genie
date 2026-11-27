package k.x;

/* loaded from: classes.dex */
public abstract class q0 {
    private p0 a;
    private p0 b;
    private p0 c;

    static {
        k.y.c.b(q0.class);
    }

    protected q0() {
        this.a = a();
        this.b = a();
        this.c = a();
    }

    protected abstract p0 a();

    protected abstract p0 b(String str);

    protected abstract p0 c(p0 p0Var);

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (!this.a.a()) {
            stringBuffer.append("&L");
            stringBuffer.append(this.a.b());
        }
        if (!this.c.a()) {
            stringBuffer.append("&C");
            stringBuffer.append(this.c.b());
        }
        if (!this.b.a()) {
            stringBuffer.append("&R");
            stringBuffer.append(this.b.b());
        }
        return stringBuffer.toString();
    }

    protected q0(q0 q0Var) {
        this.a = c(q0Var.a);
        this.b = c(q0Var.b);
        this.c = c(q0Var.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected q0(String str) {
        if (str != null && str.length() != 0) {
            int iIndexOf = str.indexOf("&L");
            int iIndexOf2 = str.indexOf("&R");
            int iIndexOf3 = str.indexOf("&C");
            if (iIndexOf == -1 && iIndexOf2 == -1 && iIndexOf3 == -1) {
                this.c = b(str);
            } else {
                if (iIndexOf != -1) {
                    int length = str.length();
                    if (iIndexOf3 > iIndexOf) {
                        length = (iIndexOf2 <= iIndexOf || iIndexOf3 <= iIndexOf2) ? iIndexOf3 : iIndexOf2;
                        this.a = b(str.substring(iIndexOf + 2, length));
                    } else {
                        if (iIndexOf2 > iIndexOf) {
                        }
                        this.a = b(str.substring(iIndexOf + 2, length));
                    }
                }
                if (iIndexOf2 != -1) {
                    int length2 = str.length();
                    if (iIndexOf3 > iIndexOf2) {
                        length2 = (iIndexOf <= iIndexOf2 || iIndexOf3 <= iIndexOf) ? iIndexOf3 : iIndexOf;
                        this.b = b(str.substring(iIndexOf2 + 2, length2));
                    } else {
                        if (iIndexOf > iIndexOf2) {
                        }
                        this.b = b(str.substring(iIndexOf2 + 2, length2));
                    }
                }
                if (iIndexOf3 != -1) {
                    int length3 = str.length();
                    if (iIndexOf2 > iIndexOf3) {
                        if (iIndexOf <= iIndexOf3 || iIndexOf2 <= iIndexOf) {
                            iIndexOf = iIndexOf2;
                        }
                    } else if (iIndexOf <= iIndexOf3) {
                        iIndexOf = length3;
                    }
                    this.c = b(str.substring(iIndexOf3 + 2, iIndexOf));
                }
            }
            if (this.a == null) {
                this.a = a();
            }
            if (this.c == null) {
                this.c = a();
            }
            if (this.b == null) {
                this.b = a();
                return;
            }
            return;
        }
        this.a = a();
        this.b = a();
        this.c = a();
    }
}
