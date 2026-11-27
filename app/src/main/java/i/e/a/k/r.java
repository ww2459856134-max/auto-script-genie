package i.e.a.k;

import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class r {
    protected final String a;
    protected final String b;

    protected r(String str) {
        this.a = null;
        this.b = str;
    }

    public abstract int a(byte[] bArr, int i2);

    public abstract int b(char[] cArr, int i2);

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public final boolean e(String str) {
        if (this.a != null) {
            return false;
        }
        return this.b.equals(str);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass() && !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (!rVar.b.equals(this.b)) {
            return false;
        }
        String str = this.a;
        return str == null ? rVar.a == null : str.equals(rVar.a);
    }

    public final boolean f(String str, String str2) {
        String str3 = this.b;
        if (str3 == str2) {
            return str == null ? this.a == null : str.equals(this.a);
        }
        if (str3.hashCode() != str2.hashCode()) {
            return false;
        }
        if (str == null) {
            if (this.a != null) {
                return false;
            }
        } else if (!str.equals(this.a)) {
            return false;
        }
        return this.b.equals(str2);
    }

    public final boolean g() {
        return this.a != null;
    }

    public abstract int h();

    public int hashCode() {
        int iHashCode = this.b.hashCode();
        String str = this.a;
        return str != null ? iHashCode ^ str.hashCode() : iHashCode;
    }

    public abstract void i(OutputStream outputStream) throws IOException;

    public abstract void j(Writer writer) throws IOException;

    public String toString() {
        if (this.a == null) {
            return this.b;
        }
        return this.a + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.b;
    }

    protected r(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
