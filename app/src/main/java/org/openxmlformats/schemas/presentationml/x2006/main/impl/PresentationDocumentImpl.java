package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;

/* loaded from: classes2.dex */
public class PresentationDocumentImpl extends XmlComplexContentImpl implements PresentationDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "presentation")};
    private static final long serialVersionUID = 1;

    public PresentationDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public CTPresentation addNewPresentation() {
        CTPresentation cTPresentation;
        synchronized (monitor()) {
            check_orphaned();
            cTPresentation = (CTPresentation) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPresentation;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public CTPresentation getPresentation() {
        CTPresentation cTPresentation;
        synchronized (monitor()) {
            check_orphaned();
            cTPresentation = (CTPresentation) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTPresentation == null) {
                cTPresentation = null;
            }
        }
        return cTPresentation;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument
    public void setPresentation(CTPresentation cTPresentation) throws Throwable {
        generatedSetterHelperImpl(cTPresentation, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
