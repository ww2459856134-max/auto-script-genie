package n.a.a.n.c;

import com.auto.exceldeps.log4j.util.Chars;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {
    public static final i d = new i();
    private final Map<String, n1> a;
    private final n1[] b;
    private boolean c;

    private i() {
        this.a = Collections.emptyMap();
        this.b = new n1[0];
    }

    private static void b(n1[] n1VarArr, i iVar) {
        int length = n1VarArr.length;
        l0 l0VarP = n1VarArr[0].p();
        for (n1 n1Var : n1VarArr) {
            if (l0VarP != n1Var.p()) {
                throw new IllegalStateException("Workbook evaluators must all have the same evaluation listener");
            }
        }
        k kVar = new k(l0VarP);
        for (int i2 = 0; i2 < length; i2++) {
            n1VarArr[i2].b(iVar, kVar, i2);
        }
    }

    public static void c(Map<String, n1> map) {
        if (map.size() < 1) {
            throw new IllegalArgumentException("Must provide at least one collaborating worbook");
        }
        new i(map, (n1[]) map.values().toArray(new n1[0]));
    }

    public static void d(Map<String, n.a.a.n.d.j0> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, n.a.a.n.d.j0> entry : map.entrySet()) {
            String key = entry.getKey();
            n.a.a.n.d.j0 value = entry.getValue();
            if (!(value instanceof o1)) {
                throw new IllegalArgumentException("Formula Evaluator " + value + " provides no WorkbookEvaluator access");
            }
            map2.put(key, ((o1) value).b());
        }
        c(map2);
    }

    private void e() {
        n1[] n1VarArr = this.b;
        if (n1VarArr.length < 1) {
            return;
        }
        for (n1 n1Var : n1VarArr) {
            n1Var.f();
        }
        this.c = true;
    }

    private void f(n1[] n1VarArr) {
        HashSet hashSet = new HashSet();
        for (n1 n1Var : n1VarArr) {
            hashSet.add(n1Var.m());
        }
        int size = hashSet.size();
        i[] iVarArr = new i[size];
        hashSet.toArray(iVarArr);
        for (int i2 = 0; i2 < size; i2++) {
            iVarArr[i2].e();
        }
    }

    public n1 a(String str) throws h {
        if (this.c) {
            throw new IllegalStateException("This environment has been unhooked");
        }
        n1 n1Var = this.a.get(str);
        if (n1Var != null) {
            return n1Var;
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append("Could not resolve external workbook name '");
        sb.append(str);
        sb.append("'.");
        if (this.b.length >= 1) {
            sb.append(" The following workbook names are valid: (");
            Iterator<String> it = this.a.keySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3 = i2 + 1;
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(Chars.QUOTE);
                sb.append(it.next());
                sb.append("'");
                i2 = i3;
            }
            sb.append(')');
        } else {
            sb.append(" Workbook environment has not been set up.");
        }
        throw new h(sb.toString());
    }

    private i(Map<String, n1> map, n1[] n1VarArr) {
        IdentityHashMap identityHashMap = new IdentityHashMap(n1VarArr.length);
        for (Map.Entry<String, n1> entry : map.entrySet()) {
            String str = (String) identityHashMap.put(entry.getValue(), entry.getKey());
            if (str != null) {
                throw new IllegalArgumentException("Attempted to register same workbook under names '" + str + "' and '" + entry.getKey() + "'");
            }
        }
        f(n1VarArr);
        b(n1VarArr, this);
        this.c = false;
        this.b = (n1[]) n1VarArr.clone();
        this.a = map;
    }
}
