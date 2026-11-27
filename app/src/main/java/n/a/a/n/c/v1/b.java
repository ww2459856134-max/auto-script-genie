package n.a.a.n.c.v1;

import java.util.HashMap;
import n.a.a.n.c.t1.j6;

/* loaded from: classes.dex */
public class b extends a {
    private final HashMap<Integer, String> c;

    public b(c... cVarArr) {
        super(cVarArr);
        this.c = new HashMap<>();
    }

    @Override // n.a.a.n.c.v1.a, n.a.a.n.c.v1.c
    public j6 a(String str) {
        j6 j6VarA = super.a(str);
        if (j6VarA != null) {
            this.c.put(Integer.valueOf(c(str)), str);
        }
        return j6VarA;
    }

    public int c(String str) {
        return str.hashCode();
    }
}
