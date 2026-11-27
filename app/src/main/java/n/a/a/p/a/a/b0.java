package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* loaded from: classes.dex */
public class b0 extends o {
    private CTDoughnutChart c;

    protected b0(l lVar, CTDoughnutChart cTDoughnutChart) {
        super(lVar);
        this.c = cTDoughnutChart;
        for (CTPieSer cTPieSer : cTDoughnutChart.getSerList()) {
            this.a.add(new a0(this, cTPieSer, cTPieSer.getCat(), cTPieSer.getVal()));
        }
    }
}
