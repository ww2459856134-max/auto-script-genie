package k.x;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class j0 {
    private ArrayList a = new ArrayList();

    public void a(i0 i0Var) {
        if (i0Var.isInitialized()) {
            return;
        }
        int size = this.a.size();
        if (size >= 4) {
            size++;
        }
        i0Var.f(size);
        this.a.add(i0Var);
    }

    public i0 b(int i2) {
        if (i2 > 4) {
            i2--;
        }
        return (i0) this.a.get(i2);
    }

    r0 c() {
        r0 r0Var = new r0(this.a.size() + 1);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 4; i2++) {
            i0 i0Var = (i0) this.a.get(i2);
            arrayList.add(i0Var);
            r0Var.b(i0Var.A(), i0Var.A());
        }
        int i3 = 0;
        for (int i4 = 4; i4 < this.a.size(); i4++) {
            i0 i0Var2 = (i0) this.a.get(i4);
            Iterator it = arrayList.iterator();
            boolean z = false;
            while (it.hasNext() && !z) {
                i0 i0Var3 = (i0) it.next();
                if (i0Var2.equals(i0Var3)) {
                    r0Var.b(i0Var2.A(), r0Var.a(i0Var3.A()));
                    i3++;
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(i0Var2);
                int iA = i0Var2.A() - i3;
                k.y.a.a(iA > 4);
                r0Var.b(i0Var2.A(), iA);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i0 i0Var4 = (i0) it2.next();
            i0Var4.f(r0Var.a(i0Var4.A()));
        }
        this.a = arrayList;
        return r0Var;
    }

    public void d(k.b0.v.l0 l0Var) throws IOException {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            l0Var.e((i0) it.next());
        }
    }
}
