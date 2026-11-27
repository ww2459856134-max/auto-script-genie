package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

/* loaded from: classes2.dex */
public class SingleXmlCellsDocumentImpl extends XmlComplexContentImpl implements SingleXmlCellsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "singleXmlCells")};
    private static final long serialVersionUID = 1;

    public SingleXmlCellsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public CTSingleXmlCells addNewSingleXmlCells() {
        CTSingleXmlCells cTSingleXmlCells;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCells = (CTSingleXmlCells) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSingleXmlCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public CTSingleXmlCells getSingleXmlCells() {
        CTSingleXmlCells cTSingleXmlCells;
        synchronized (monitor()) {
            check_orphaned();
            cTSingleXmlCells = (CTSingleXmlCells) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTSingleXmlCells == null) {
                cTSingleXmlCells = null;
            }
        }
        return cTSingleXmlCells;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument
    public void setSingleXmlCells(CTSingleXmlCells cTSingleXmlCells) throws Throwable {
        generatedSetterHelperImpl(cTSingleXmlCells, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
