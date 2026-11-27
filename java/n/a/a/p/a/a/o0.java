package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;

/* loaded from: classes.dex */
public class o0 extends o {
    private CTScatterChart c;

    protected o0(l lVar, CTScatterChart cTScatterChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTScatterChart;
        for (CTScatterSer cTScatterSer : cTScatterChart.getSerList()) {
            this.a.add(new n0(this, cTScatterSer, cTScatterSer.getXVal(), cTScatterSer.getYVal()));
        }
        c(map, map2);
    }

    private void c(Map<Long, m> map, Map<Long, t0> map2) {
        if (this.c.sizeOfAxIdArray() == 0) {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                this.c.addNewAxId().setVal(it.next().longValue());
            }
            Iterator<Long> it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                this.c.addNewAxId().setVal(it2.next().longValue());
            }
        }
        b(this.c.getAxIdArray(), map, map2);
    }
}
