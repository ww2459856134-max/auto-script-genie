package n.a.a.n.b;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class h0 implements s {
    private char a;
    private f0 c;
    private f0 d;
    private f0 e;
    private f0 f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2345h;
    private double b = 1.0d;
    private final List<f0> g = new LinkedList();

    private static f0 b(List<f0> list) {
        for (f0 f0Var : list) {
            if (i(f0Var)) {
                return f0Var;
            }
        }
        return null;
    }

    private static boolean i(f0 f0Var) {
        char c = f0Var.a;
        return c == '0' || c == '?' || c == '#';
    }

    private f0 k() {
        List<f0> list = this.g;
        ListIterator<f0> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            f0 f0VarPrevious = listIterator.previous();
            if (i(f0VarPrevious)) {
                while (listIterator.hasPrevious()) {
                    f0 f0VarPrevious2 = listIterator.previous();
                    if (f0VarPrevious.b - f0VarPrevious2.b > 1 || !i(f0VarPrevious2)) {
                        break;
                    }
                    f0VarPrevious = f0VarPrevious2;
                }
                return f0VarPrevious;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    @Override // n.a.a.n.b.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Matcher matcher, String str, a0 a0Var, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        char cCharAt = str.charAt(0);
        if (cCharAt == '#') {
            char c = this.a;
            if (c != 0) {
                this.g.add(new f0(c, length));
                stringBuffer.append(this.a);
                this.a = (char) 0;
                length++;
            }
            while (i < str.length()) {
                this.g.add(new f0(str.charAt(i), length + i));
                i++;
            }
        } else if (cCharAt == '%') {
            this.b *= 100.0d;
        } else if (cCharAt != '?') {
            if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case '.':
                        if (this.c == null && !this.g.isEmpty()) {
                            f0 f0Var = new f0(NameUtil.PERIOD, length);
                            this.c = f0Var;
                            this.g.add(f0Var);
                            break;
                        }
                        break;
                    case '/':
                        if (this.d == null && !this.g.isEmpty()) {
                            f0 f0VarK = k();
                            this.f = f0VarK;
                            this.f2345h = (f0VarK == b(this.g) ? 1 : 0) | (this.f2345h ? 1 : 0);
                            f0 f0Var2 = new f0(NameUtil.PERIOD, length);
                            this.d = f0Var2;
                            this.g.add(f0Var2);
                            break;
                        }
                        break;
                    case '0':
                        break;
                    default:
                        return null;
                }
            } else if (this.e == null && !this.g.isEmpty()) {
                f0 f0Var3 = new f0(NameUtil.PERIOD, length);
                this.e = f0Var3;
                this.g.add(f0Var3);
                this.a = str.charAt(1);
                return str.substring(0, 1);
            }
        }
        return str;
    }

    public f0 c() {
        return this.c;
    }

    public f0 d() {
        return this.e;
    }

    public f0 e() {
        return this.f;
    }

    public double f() {
        return this.b;
    }

    public f0 g() {
        return this.d;
    }

    public List<f0> h() {
        return this.g;
    }

    public boolean j() {
        return this.f2345h;
    }
}
