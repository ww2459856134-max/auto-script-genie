package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;

/* loaded from: classes2.dex */
public class ChartSpaceDocumentImpl extends XmlComplexContentImpl implements ChartSpaceDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "chartSpace")};
    private static final long serialVersionUID = 1;

    public ChartSpaceDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public CTChartSpace addNewChartSpace() {
        CTChartSpace cTChartSpace;
        synchronized (monitor()) {
            check_orphaned();
            cTChartSpace = (CTChartSpace) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTChartSpace;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public CTChartSpace getChartSpace() {
        CTChartSpace cTChartSpace;
        synchronized (monitor()) {
            check_orphaned();
            cTChartSpace = (CTChartSpace) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTChartSpace == null) {
                cTChartSpace = null;
            }
        }
        return cTChartSpace;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument
    public void setChartSpace(CTChartSpace cTChartSpace) throws Throwable {
        generatedSetterHelperImpl(cTChartSpace, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
