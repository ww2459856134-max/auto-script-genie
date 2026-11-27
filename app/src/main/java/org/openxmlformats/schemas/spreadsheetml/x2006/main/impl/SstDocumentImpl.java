package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* loaded from: classes2.dex */
public class SstDocumentImpl extends XmlComplexContentImpl implements SstDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sst")};
    private static final long serialVersionUID = 1;

    public SstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public CTSst addNewSst() {
        CTSst cTSst;
        synchronized (monitor()) {
            check_orphaned();
            cTSst = (CTSst) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSst;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public CTSst getSst() {
        CTSst cTSst;
        synchronized (monitor()) {
            check_orphaned();
            cTSst = (CTSst) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSst == null) {
                cTSst = null;
            }
        }
        return cTSst;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument
    public void setSst(CTSst cTSst) throws Throwable {
        generatedSetterHelperImpl(cTSst, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
