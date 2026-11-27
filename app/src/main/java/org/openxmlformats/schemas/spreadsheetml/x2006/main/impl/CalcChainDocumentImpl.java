package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* loaded from: classes2.dex */
public class CalcChainDocumentImpl extends XmlComplexContentImpl implements CalcChainDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcChain")};
    private static final long serialVersionUID = 1;

    public CalcChainDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain addNewCalcChain() {
        CTCalcChain cTCalcChain;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcChain = (CTCalcChain) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCalcChain;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public CTCalcChain getCalcChain() {
        CTCalcChain cTCalcChain;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcChain = (CTCalcChain) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCalcChain == null) {
                cTCalcChain = null;
            }
        }
        return cTCalcChain;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument
    public void setCalcChain(CTCalcChain cTCalcChain) throws Throwable {
        generatedSetterHelperImpl(cTCalcChain, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
