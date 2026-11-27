package n.a.a.p.a.a;

import com.auto.exceldeps.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes.dex */
public abstract class o {
    private static final Logger b = n.a.a.i.b.a(o.class);
    protected List<n> a = new ArrayList();

    protected o(l lVar) {
    }

    protected void b(CTUnsignedInt[] cTUnsignedIntArr, Map<Long, m> map, Map<Long, t0> map2) {
        ArrayList arrayList = new ArrayList(cTUnsignedIntArr.length);
        for (CTUnsignedInt cTUnsignedInt : cTUnsignedIntArr) {
            Long lValueOf = Long.valueOf(cTUnsignedInt.getVal());
            m mVar = map.get(lValueOf);
            if (mVar == null) {
                t0 t0Var = map2.get(lValueOf);
                if (t0Var != null) {
                    arrayList.add(t0Var);
                }
            } else if (mVar instanceof j) {
            }
        }
        Collections.unmodifiableList(arrayList);
    }
}
