package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument;

/* loaded from: classes3.dex */
public class StylesDocumentImpl extends XmlComplexContentImpl implements StylesDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styles")};
    private static final long serialVersionUID = 1;

    public StylesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles addNewStyles() {
        CTStyles cTStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTStyles = (CTStyles) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTStyles;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public CTStyles getStyles() {
        CTStyles cTStyles;
        synchronized (monitor()) {
            check_orphaned();
            cTStyles = (CTStyles) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTStyles == null) {
                cTStyles = null;
            }
        }
        return cTStyles;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.StylesDocument
    public void setStyles(CTStyles cTStyles) throws Throwable {
        generatedSetterHelperImpl(cTStyles, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
