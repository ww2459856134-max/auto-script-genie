package n.a.a.n.b;

import java.util.Locale;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
class g implements s {
    final /* synthetic */ i a;

    private g(i iVar) {
        this.a = iVar;
    }

    @Override // n.a.a.n.b.s
    public String a(Matcher matcher, String str, a0 a0Var, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        char cCharAt = str.charAt(0);
        if (cCharAt == '\n') {
            return "%n";
        }
        if (cCharAt == '\"') {
            str = str.substring(1, str.length() - 1);
        } else {
            if (cCharAt != '*') {
                if (cCharAt != '0') {
                    if (cCharAt == '_') {
                        return null;
                    }
                    if (cCharAt != 'h' && cCharAt != 'm' && cCharAt != 's') {
                        if (cCharAt != '[') {
                            if (cCharAt == '\\') {
                                str = str.substring(1);
                            }
                        } else if (str.length() >= 3) {
                            if (this.a.d != null) {
                                throw new IllegalArgumentException("Duplicate '[' times in format");
                            }
                            String lowerCase = str.toLowerCase(Locale.ROOT);
                            int length2 = lowerCase.length() - 2;
                            i iVar = this.a;
                            iVar.d = iVar.j(lowerCase.charAt(1), length, length2);
                            return lowerCase.substring(1, length2 + 1);
                        }
                    }
                }
                String lowerCase2 = str.toLowerCase(Locale.ROOT);
                this.a.j(lowerCase2.charAt(0), length, lowerCase2.length());
                return lowerCase2;
            }
            if (str.length() > 1) {
                str = t.c(str);
            }
        }
        return i.f.matcher(str).replaceAll("%%");
    }
}
