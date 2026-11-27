package n.a.a.n.b;

import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes.dex */
public class c0 extends b0 {
    public c0(Locale locale) {
        super(locale, "General");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // n.a.a.n.b.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(StringBuffer stringBuffer, Object obj) {
        String str;
        boolean z;
        Formatter formatter;
        if (!(obj instanceof Number)) {
            if (obj instanceof Boolean) {
                stringBuffer.append(obj.toString().toUpperCase(Locale.ROOT));
                return;
            } else {
                stringBuffer.append(obj);
                return;
            }
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue == 0.0d) {
            stringBuffer.append('0');
            return;
        }
        double dLog10 = Math.log10(Math.abs(dDoubleValue));
        try {
            if (dLog10 > 10.0d || dLog10 < -9.0d) {
                str = "%1.5E";
            } else {
                if (((long) dDoubleValue) == dDoubleValue) {
                    str = "%1.0f";
                    z = false;
                    formatter = new Formatter(stringBuffer, this.b);
                    formatter.format(this.b, str, obj);
                    formatter.close();
                    if (z) {
                        return;
                    }
                    int iLastIndexOf = (str.endsWith("E") ? stringBuffer.lastIndexOf("E") : stringBuffer.length()) - 1;
                    while (stringBuffer.charAt(iLastIndexOf) == '0') {
                        stringBuffer.deleteCharAt(iLastIndexOf);
                        iLastIndexOf--;
                    }
                    if (stringBuffer.charAt(iLastIndexOf) == '.') {
                        stringBuffer.deleteCharAt(iLastIndexOf);
                        return;
                    }
                    return;
                }
                str = "%1.9f";
            }
            formatter.format(this.b, str, obj);
            formatter.close();
            if (z) {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
        z = true;
        formatter = new Formatter(stringBuffer, this.b);
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        b(stringBuffer, obj);
    }
}
