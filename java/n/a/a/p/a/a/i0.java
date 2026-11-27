package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;

/* loaded from: classes.dex */
public class i0 extends o {
    private CTPie3DChart c;

    protected i0(l lVar, CTPie3DChart cTPie3DChart) {
        super(lVar);
        this.c = cTPie3DChart;
        for (CTPieSer cTPieSer : cTPie3DChart.getSerList()) {
            this.a.add(new h0(this, cTPieSer, cTPieSer.getCat(), cTPieSer.getVal()));
        }
    }
}
