package k.b0.v;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
class u2 {
    private HashMap a = new HashMap(100);
    private ArrayList b = new ArrayList(100);
    private int c = 0;

    private n2 a(String str, int i2, l0 l0Var) throws IOException {
        n2 n2Var = null;
        while (i2 != 0) {
            n2Var = new n2();
            i2 = (i2 == str.length() || str.length() == 0) ? n2Var.C(str, true) : n2Var.C(str.substring(str.length() - i2), false);
            if (i2 != 0) {
                l0Var.e(n2Var);
                n2Var = new n2();
            }
        }
        return n2Var;
    }

    public String b(int i2) {
        return (String) this.b.get(i2);
    }

    public int c(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null) {
            num = new Integer(this.a.size());
            this.a.put(str, num);
            this.b.add(str);
        }
        this.c++;
        return num.intValue();
    }

    public void d(l0 l0Var) throws IOException {
        o2 o2Var = new o2(this.c, this.b.size());
        h0 h0Var = new h0(this.b.size());
        int iC = h0Var.C();
        Iterator it = this.b.iterator();
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (it.hasNext() && i2 == 0) {
            str = (String) it.next();
            int iB = o2Var.B() + 4;
            int iA = o2Var.A(str);
            if (i3 % iC == 0) {
                h0Var.A(l0Var.c(), iB);
            }
            i3++;
            i2 = iA;
        }
        l0Var.e(o2Var);
        if (i2 != 0 || it.hasNext()) {
            n2 n2VarA = a(str, i2, l0Var);
            while (it.hasNext()) {
                String str2 = (String) it.next();
                int iB2 = n2VarA.B() + 4;
                int iA2 = n2VarA.A(str2);
                if (i3 % iC == 0) {
                    h0Var.A(l0Var.c(), iB2);
                }
                i3++;
                if (iA2 != 0) {
                    l0Var.e(n2VarA);
                    n2VarA = a(str2, iA2, l0Var);
                }
            }
            l0Var.e(n2VarA);
        }
        l0Var.e(h0Var);
    }
}
