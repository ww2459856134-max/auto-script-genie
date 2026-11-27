package n.a.a.n.c.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
public class a implements c {
    public static final c b = new a(n.a.a.n.c.p1.b.b);
    private final Collection<c> a;

    public a(c... cVarArr) {
        ArrayList arrayList = new ArrayList(cVarArr.length);
        this.a = arrayList;
        arrayList.addAll(Arrays.asList(cVarArr));
    }

    @Override // n.a.a.n.c.v1.c
    public j6 a(String str) {
        Iterator<c> it = this.a.iterator();
        while (it.hasNext()) {
            j6 j6VarA = it.next().a(str);
            if (j6VarA != null) {
                return j6VarA;
            }
        }
        return null;
    }

    public void b(c cVar) {
        this.a.add(cVar);
    }
}
