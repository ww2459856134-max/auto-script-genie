package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

/* loaded from: classes.dex */
public class c1 extends i2 {
    private static final byte[] D = n0();
    protected CTChartsheet C;

    protected c1(n.a.a.k.b.m mVar) {
        super(mVar);
    }

    private static byte[] n0() {
        i.b.ha.a.c.k.j jVar = i.b.ha.a.c.k.j.p().get();
        try {
            new i2().write(jVar);
            return jVar.d();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.apache.poi.xssf.usermodel.i2
    protected CTDrawing M() {
        return this.C.getDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.i2
    protected void j0(InputStream inputStream) throws IOException {
        super.j0(i.b.ha.a.c.j.l.a().w(D).get());
        try {
            this.C = ChartsheetDocument.Factory.parse(inputStream, n.a.a.j.m.a).getChartsheet();
        } catch (XmlException e) {
            throw new n.a.a.j.d(e);
        }
    }

    @Override // org.apache.poi.xssf.usermodel.i2
    protected void write(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(n.a.a.j.m.a);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartsheet.type.getName().getNamespaceURI(), "chartsheet"));
        CTChartsheet cTChartsheet = this.C;
        if (cTChartsheet != null) {
            cTChartsheet.save(outputStream, xmlOptions);
        }
    }
}
