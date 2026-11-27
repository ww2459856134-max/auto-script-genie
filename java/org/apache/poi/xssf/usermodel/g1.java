package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/* loaded from: classes.dex */
public class g1 implements n.a.a.n.d.n {
    private final XSSFWorkbook a;
    private final Map<String, n.a.a.n.d.i1> b = new HashMap();

    public g1(XSSFWorkbook xSSFWorkbook) {
        this.a = xSSFWorkbook;
    }

    static /* synthetic */ void e(Map map, String str, n.a.a.n.d.i1 i1Var) {
    }

    protected void b(String str, n.a.a.n.d.i1 i1Var) {
        this.b.put(str, i1Var);
    }

    @Override // n.a.a.n.d.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q1 a() {
        q1 q1Var = new q1(this.a);
        final HashMap map = new HashMap();
        map.put("", q1Var);
        this.b.forEach(new BiConsumer() { // from class: org.apache.poi.xssf.usermodel.x
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                g1.e(map, (String) obj, (n.a.a.n.d.i1) obj2);
            }
        });
        q1Var.h(map);
        return q1Var;
    }

    protected Map<String, n.a.a.n.d.i1> d() {
        return this.b;
    }
}
