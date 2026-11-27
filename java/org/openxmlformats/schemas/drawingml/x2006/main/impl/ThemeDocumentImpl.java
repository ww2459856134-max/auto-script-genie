package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* loaded from: classes2.dex */
public class ThemeDocumentImpl extends XmlComplexContentImpl implements ThemeDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "theme")};
    private static final long serialVersionUID = 1;

    public ThemeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public CTOfficeStyleSheet addNewTheme() {
        CTOfficeStyleSheet cTOfficeStyleSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeStyleSheet = (CTOfficeStyleSheet) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOfficeStyleSheet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public CTOfficeStyleSheet getTheme() {
        CTOfficeStyleSheet cTOfficeStyleSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeStyleSheet = (CTOfficeStyleSheet) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTOfficeStyleSheet == null) {
                cTOfficeStyleSheet = null;
            }
        }
        return cTOfficeStyleSheet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public void setTheme(CTOfficeStyleSheet cTOfficeStyleSheet) throws Throwable {
        generatedSetterHelperImpl(cTOfficeStyleSheet, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
