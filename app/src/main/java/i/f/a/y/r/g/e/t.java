package i.f.a.y.r.g.e;

import androidx.recyclerview.widget.k0;
import com.auto.exceldeps.log4j.util.Chars;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
final class t {
    private final i.f.a.v.a a;
    private final n b = new n();
    private final StringBuilder c = new StringBuilder();

    t(i.f.a.v.a aVar) {
        this.a = aVar;
    }

    private o b(int i2) {
        char c;
        int iF = f(i2, 5);
        if (iF == 15) {
            return new o(i2 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new o(i2 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i2, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new o(i2 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = NameUtil.HYPHEN;
                break;
            case 61:
                c = NameUtil.PERIOD;
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iF2)));
        }
        return new o(i2 + 6, c);
    }

    private o d(int i2) throws i.f.a.g {
        char c;
        int iF = f(i2, 5);
        if (iF == 15) {
            return new o(i2 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new o(i2 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i2, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new o(i2 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new o(i2 + 7, (char) (iF2 + 7));
        }
        switch (f(i2, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = Chars.DQUOTE;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = Chars.QUOTE;
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = NameUtil.HYPHEN;
                break;
            case 243:
                c = NameUtil.PERIOD;
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = NameUtil.COLON;
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = Chars.EQ;
                break;
            case 249:
                c = '>';
                break;
            case k0.a.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                c = '?';
                break;
            case 251:
                c = NameUtil.USCORE;
                break;
            case 252:
                c = Chars.SPACE;
                break;
            default:
                throw i.f.a.g.a();
        }
        return new o(i2 + 8, c);
    }

    private q e(int i2) throws i.f.a.g {
        int i3 = i2 + 7;
        if (i3 > this.a.k()) {
            int iF = f(i2, 4);
            return iF == 0 ? new q(this.a.k(), 10, 10) : new q(this.a.k(), iF - 1, 10);
        }
        int iF2 = f(i2, 7) - 8;
        return new q(i3, iF2 / 11, iF2 % 11);
    }

    static int g(i.f.a.v.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.g(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.a.k()) {
            return false;
        }
        while (i2 < i3) {
            if (this.a.g(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.a.k()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.a.k(); i4++) {
            if (i4 == 2) {
                if (!this.a.g(i2 + 2)) {
                    return false;
                }
            } else if (this.a.g(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i2) {
        int i3;
        if (i2 + 1 > this.a.k()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.a.k(); i4++) {
            if (this.a.g(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i2) {
        int iF;
        if (i2 + 5 > this.a.k()) {
            return false;
        }
        int iF2 = f(i2, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i2 + 6 <= this.a.k() && (iF = f(i2, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    private boolean l(int i2) {
        int iF;
        if (i2 + 5 > this.a.k()) {
            return false;
        }
        int iF2 = f(i2, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i2 + 7 > this.a.k()) {
            return false;
        }
        int iF3 = f(i2, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i2 + 8 <= this.a.k() && (iF = f(i2, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 + 7 > this.a.k()) {
            return i2 + 4 <= this.a.k();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.a.g(i4);
            }
            if (this.a.g(i3)) {
                return true;
            }
            i3++;
        }
    }

    private l n() {
        while (k(this.b.a())) {
            o oVarB = b(this.b.a());
            this.b.h(oVarB.a());
            if (oVarB.c()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(oVarB.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.k()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.k());
            }
            this.b.f();
        }
        return new l(false);
    }

    private p o() throws i.f.a.g {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (!(iA != this.b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    private l p() throws i.f.a.g {
        while (l(this.b.a())) {
            o oVarD = d(this.b.a());
            this.b.h(oVarD.a());
            if (oVarD.c()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(oVarD.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.k()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.k());
            }
            this.b.e();
        }
        return new l(false);
    }

    private l q() throws i.f.a.g {
        while (m(this.b.a())) {
            q qVarE = e(this.b.a());
            this.b.h(qVarE.a());
            if (qVarE.d()) {
                return new l(qVarE.e() ? new p(this.b.a(), this.c.toString()) : new p(this.b.a(), this.c.toString(), qVarE.c()), true);
            }
            this.c.append(qVarE.b());
            if (qVarE.e()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(qVarE.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new l(false);
    }

    String a(StringBuilder sb, int i2) throws i.f.a.k, i.f.a.g {
        String str = null;
        while (true) {
            p pVarC = c(i2, str);
            String strA = s.a(pVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = pVarC.d() ? String.valueOf(pVarC.c()) : null;
            if (i2 == pVarC.a()) {
                return sb.toString();
            }
            i2 = pVarC.a();
            str = strValueOf;
        }
    }

    p c(int i2, String str) throws i.f.a.g {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i2);
        p pVarO = o();
        return (pVarO == null || !pVarO.d()) ? new p(this.b.a(), this.c.toString()) : new p(this.b.a(), this.c.toString(), pVarO.c());
    }

    int f(int i2, int i3) {
        return g(this.a, i2, i3);
    }
}
