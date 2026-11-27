package i.b.ha.a.e.c;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class s {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final NumberFormat g;

    public s(NumberFormat numberFormat) {
        this("{", "}", "{", "}", ",", ",", numberFormat);
    }

    public static s d() {
        return e(Locale.getDefault());
    }

    public static s e(Locale locale) {
        return new s(i.b.ha.a.e.g.c.c(locale));
    }

    public String a(r rVar) {
        StringBuffer stringBuffer = new StringBuffer();
        b(rVar, stringBuffer, new FieldPosition(0));
        return stringBuffer.toString();
    }

    public StringBuffer b(r rVar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.a);
        int iD = rVar.d();
        for (int i2 = 0; i2 < iD; i2++) {
            stringBuffer.append(this.c);
            for (int i3 = 0; i3 < rVar.a(); i3++) {
                if (i3 > 0) {
                    stringBuffer.append(this.f);
                }
                i.b.ha.a.e.g.c.a(rVar.e(i2, i3), this.g, stringBuffer, fieldPosition);
            }
            stringBuffer.append(this.d);
            if (i2 < iD - 1) {
                stringBuffer.append(this.e);
            }
        }
        stringBuffer.append(this.b);
        return stringBuffer;
    }

    public NumberFormat c() {
        return this.g;
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5, str6, i.b.ha.a.e.g.c.b());
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6, NumberFormat numberFormat) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = numberFormat;
        numberFormat.setGroupingUsed(false);
    }
}
