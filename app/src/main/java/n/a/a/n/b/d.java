package n.a.a.n.b;

import java.util.Locale;
import java.util.regex.Matcher;
import n.a.a.o.j1;

/* loaded from: classes.dex */
class d implements s {
    private int b;
    private int d;
    final /* synthetic */ e e;
    private int a = -1;
    private int c = -1;

    d(e eVar) {
        this.e = eVar;
    }

    @Override // n.a.a.n.b.s
    public String a(Matcher matcher, String str, a0 a0Var, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        switch (str.charAt(0)) {
            case '0':
                this.a = -1;
                int length2 = str.length();
                this.e.g = "%0" + (length2 + 2) + "." + length2 + "f";
                return str.replace('0', 'S');
            case 'A':
            case 'P':
            case 'a':
            case 'p':
                if (str.length() <= 1) {
                    return null;
                }
                this.a = -1;
                this.e.e = true;
                this.e.d = j1.k(str.charAt(1)).equals("m");
                e eVar = this.e;
                eVar.c = eVar.d || j1.h(str.charAt(0));
                return "a";
            case 'D':
            case 'd':
                this.a = -1;
                return str.length() <= 2 ? str.toLowerCase(Locale.ROOT) : str.toLowerCase(Locale.ROOT).replace('d', 'E');
            case 'H':
            case 'h':
                this.a = -1;
                this.c = length;
                this.d = str.length();
                return str.toLowerCase(Locale.ROOT);
            case 'M':
            case 'm':
                this.a = length;
                this.b = str.length();
                return this.c >= 0 ? str.toLowerCase(Locale.ROOT) : str.toUpperCase(Locale.ROOT);
            case 'S':
            case 's':
                if (this.a >= 0) {
                    for (int i2 = 0; i2 < this.b; i2++) {
                        stringBuffer.setCharAt(this.a + i2, 'm');
                    }
                    this.a = -1;
                }
                return str.toLowerCase(Locale.ROOT);
            case 'Y':
            case 'y':
                this.a = -1;
                if (str.length() == 1) {
                    str = "yy";
                } else if (str.length() == 3) {
                    str = "yyyy";
                }
                return str.toLowerCase(Locale.ROOT);
            default:
                return null;
        }
    }

    public void b(StringBuffer stringBuffer) {
        if (this.c < 0 || this.e.e) {
            return;
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            stringBuffer.setCharAt(this.c + i2, 'H');
        }
    }

    public void c(int i2, int i3) {
        int i4 = this.c;
        if (i2 < i4) {
            this.c = i4 + i3;
        }
        int i5 = this.a;
        if (i2 < i5) {
            this.a = i5 + i3;
        }
    }
}
