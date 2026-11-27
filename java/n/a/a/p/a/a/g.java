package n.a.a.p.a.a;

import java.util.Iterator;
import java.util.Map;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;

/* loaded from: classes.dex */
public class g extends o {
    private CTBar3DChart c;

    protected g(l lVar, CTBar3DChart cTBar3DChart, Map<Long, m> map, Map<Long, t0> map2) {
        super(lVar);
        this.c = cTBar3DChart;
        if (cTBar3DChart.getBarDir() == null) {
            cTBar3DChart.addNewBarDir().setVal(a.BAR.c);
        }
        for (CTBarSer cTBarSer : cTBar3DChart.getSerList()) {
            this.a.add(new f(this, cTBarSer, cTBarSer.getCat(), cTBarSer.getVal()));
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
