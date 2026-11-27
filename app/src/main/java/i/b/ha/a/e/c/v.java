package i.b.ha.a.e.c;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class v {
    private final String a;
    private final String b;
    private final String c;
    private final NumberFormat d;

    public v(NumberFormat numberFormat) {
        this("{", "}", "; ", numberFormat);
    }

    public static v c() {
        return d(Locale.getDefault());
    }

    public static v d(Locale locale) {
        return new v(i.b.ha.a.e.g.c.c(locale));
    }

    public String a(u uVar) {
        StringBuffer stringBuffer = new StringBuffer();
        b(uVar, stringBuffer, new FieldPosition(0));
        return stringBuffer.toString();
    }

    public StringBuffer b(u uVar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.a);
        for (int i2 = 0; i2 < uVar.a(); i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.c);
            }
            i.b.ha.a.e.g.c.a(uVar.b(i2), this.d, stringBuffer, fieldPosition);
        }
        stringBuffer.append(this.b);
        return stringBuffer;
    }

    public v(String str, String str2, String str3, NumberFormat numberFormat) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        str.trim();
        str2.trim();
        str3.trim();
        this.d = numberFormat;
    }
}
