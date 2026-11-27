package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument;

/* loaded from: classes2.dex */
public class TblStyleLstDocumentImpl extends XmlComplexContentImpl implements TblStyleLstDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblStyleLst")};
    private static final long serialVersionUID = 1;

    public TblStyleLstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public CTTableStyleList addNewTblStyleLst() {
        CTTableStyleList cTTableStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleList = (CTTableStyleList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public CTTableStyleList getTblStyleLst() {
        CTTableStyleList cTTableStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleList = (CTTableStyleList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableStyleList == null) {
                cTTableStyleList = null;
            }
        }
        return cTTableStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public void setTblStyleLst(CTTableStyleList cTTableStyleList) throws Throwable {
        generatedSetterHelperImpl(cTTableStyleList, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
