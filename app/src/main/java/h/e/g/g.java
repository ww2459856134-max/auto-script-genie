package h.e.g;

import android.util.Base64;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.util.List;

/* loaded from: classes.dex */
public final class g {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public g(String str, String str2, String str3, List<List<byte[]>> list) {
        h.e.i.h.d(str);
        this.a = str;
        h.e.i.h.d(str2);
        this.b = str2;
        h.e.i.h.d(str3);
        this.c = str3;
        h.e.i.h.d(list);
        this.d = list;
        this.e = 0;
        this.f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + ProcessIdUtil.DEFAULT_PROCESSID + str2 + ProcessIdUtil.DEFAULT_PROCESSID + str3;
    }

    public List<List<byte[]>> b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
