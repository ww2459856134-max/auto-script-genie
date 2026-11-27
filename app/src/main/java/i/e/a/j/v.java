package i.e.a.j;

import org.apache.poi.javax.xml.namespace.QName;

/* loaded from: classes.dex */
public abstract class v {
    protected final String a;
    protected final String b;
    protected final String c;
    protected q d = null;

    protected v(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public static int d(String str, String str2) {
        return str2.hashCode();
    }

    public final boolean a(v vVar) {
        return vVar != null && vVar.c == this.c && vVar.j() == j();
    }

    public final boolean b(String str, String str2) {
        if (!this.c.equals(str2)) {
            return false;
        }
        String strJ = j();
        return (str == null || str.length() == 0) ? strJ == null : str.equals(strJ);
    }

    public final int c() {
        return this.c.hashCode();
    }

    public final QName e() {
        String str = this.b;
        q qVar = this.d;
        String str2 = qVar == null ? null : qVar.b;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.c;
        if (str == null) {
            str = "";
        }
        return new QName(str2, str3, str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return vVar.b == this.b && vVar.c == this.c;
    }

    public final QName f(q qVar) {
        String str;
        String str2 = this.b;
        if (str2 == null) {
            str2 = "";
        }
        q qVar2 = this.d;
        if (qVar2 != null && (str = qVar2.b) != null) {
            return new QName(str, this.c, str2);
        }
        String str3 = qVar.b;
        return new QName(str3 != null ? str3 : "", this.c, str2);
    }

    public abstract v g(q qVar);

    public abstract int h();

    public final String i() {
        return this.c;
    }

    public final String j() {
        q qVar = this.d;
        if (qVar == null) {
            return null;
        }
        return qVar.b;
    }

    public final String k() {
        return this.b;
    }

    public final String l() {
        return this.a;
    }

    public abstract int m(int i2);

    public boolean n() {
        return this.b != null;
    }

    public boolean o(String str) {
        return this.a.equals(str);
    }

    public final boolean p() {
        q qVar = this.d;
        return qVar == null || qVar.b != null;
    }

    public abstract int q();

    public final boolean r(v vVar) {
        return vVar.a == this.a;
    }

    public final int s() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
