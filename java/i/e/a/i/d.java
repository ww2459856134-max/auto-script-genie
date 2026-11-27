package i.e.a.i;

import com.auto.exceldeps.log4j.util.Chars;
import n.b.a.h;

/* loaded from: classes.dex */
public class d implements h {

    /* renamed from: i, reason: collision with root package name */
    private static final d f1569i = new d("", "", -1, -1, -1);
    protected final String c;
    protected final String d;
    protected final int e;
    protected final int f;
    protected final int g;

    /* renamed from: h, reason: collision with root package name */
    protected transient String f1570h = null;

    public d(String str, String str2, int i2, int i3, int i4) {
        this.c = str;
        this.d = str2;
        this.e = i2 < 0 ? Integer.MAX_VALUE : i2;
        this.f = i4;
        this.g = i3;
    }

    private void a(StringBuffer stringBuffer) {
        String str;
        if (this.d != null) {
            stringBuffer.append("[row,col,system-id]: ");
            str = this.d;
        } else if (this.c != null) {
            stringBuffer.append("[row,col,public-id]: ");
            str = this.c;
        } else {
            stringBuffer.append("[row,col {unknown-source}]: ");
            str = null;
        }
        stringBuffer.append('[');
        stringBuffer.append(this.g);
        stringBuffer.append(',');
        stringBuffer.append(this.f);
        if (str != null) {
            stringBuffer.append(',');
            stringBuffer.append(Chars.DQUOTE);
            stringBuffer.append(str);
            stringBuffer.append(Chars.DQUOTE);
        }
        stringBuffer.append(']');
    }

    public static d b(String str, String str2, long j2, int i2, int i3) {
        return new d(str, str2, (int) j2, i2 + 1, i3 + 1);
    }

    public static d c() {
        return f1569i;
    }

    @Override // org.apache.poi.javax.xml.stream.Location
    public int getCharacterOffset() {
        return this.e;
    }

    @Override // org.apache.poi.javax.xml.stream.Location
    public int getColumnNumber() {
        return this.f;
    }

    @Override // org.apache.poi.javax.xml.stream.Location
    public int getLineNumber() {
        return this.g;
    }

    @Override // org.apache.poi.javax.xml.stream.Location
    public String getPublicId() {
        return this.c;
    }

    @Override // org.apache.poi.javax.xml.stream.Location
    public String getSystemId() {
        return this.d;
    }

    public String toString() {
        if (this.f1570h == null) {
            StringBuffer stringBuffer = new StringBuffer(100);
            a(stringBuffer);
            this.f1570h = stringBuffer.toString();
        }
        return this.f1570h;
    }
}
