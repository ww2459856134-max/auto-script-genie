package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* loaded from: classes.dex */
public class k0 extends o {
    private CTPieChart c;

    protected k0(l lVar, CTPieChart cTPieChart) {
        super(lVar);
        this.c = cTPieChart;
        for (CTPieSer cTPieSer : cTPieChart.getSerList()) {
            this.a.add(new j0(this, cTPieSer, cTPieSer.getCat(), cTPieSer.getVal()));
        }
    }
}
