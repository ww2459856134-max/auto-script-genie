package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;

/* loaded from: classes.dex */
public final class b1 extends n.a.a.p.a.a.l {
    protected b1() {
        Z();
    }

    private void Z() {
        M().addNewLayout();
        K().addNewPlotVisOnly().setVal(true);
        CTPrintSettings cTPrintSettingsAddNewPrintSettings = this.c.addNewPrintSettings();
        cTPrintSettingsAddNewPrintSettings.addNewHeaderFooter();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTPrintSettingsAddNewPrintSettings.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setB(0.75d);
        cTPageMarginsAddNewPageMargins.setL(0.7d);
        cTPageMarginsAddNewPageMargins.setR(0.7d);
        cTPageMarginsAddNewPageMargins.setT(0.75d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPrintSettingsAddNewPrintSettings.addNewPageSetup();
    }

    @Override // n.a.a.p.a.a.l
    protected n.a.a.j.e O() {
        return null;
    }

    @Override // n.a.a.p.a.a.l
    protected n.a.a.j.l Q() {
        return null;
    }

    protected void a0(r1 r1Var) {
    }

    @Override // n.a.a.p.a.a.l, n.a.a.j.c
    protected void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream outputStreamO = getPackagePart().o();
        try {
            this.c.save(outputStreamO, xmlOptions);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected b1(n.a.a.k.b.m mVar) throws XmlException, IOException {
        super(mVar);
    }
}
