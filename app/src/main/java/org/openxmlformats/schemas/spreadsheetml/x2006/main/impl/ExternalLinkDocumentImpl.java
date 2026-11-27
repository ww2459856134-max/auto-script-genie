package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalLink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument;

/* loaded from: classes2.dex */
public class ExternalLinkDocumentImpl extends XmlComplexContentImpl implements ExternalLinkDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalLink")};
    private static final long serialVersionUID = 1;

    public ExternalLinkDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public CTExternalLink addNewExternalLink() {
        CTExternalLink cTExternalLink;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalLink = (CTExternalLink) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalLink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public CTExternalLink getExternalLink() {
        CTExternalLink cTExternalLink;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalLink = (CTExternalLink) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTExternalLink == null) {
                cTExternalLink = null;
            }
        }
        return cTExternalLink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.ExternalLinkDocument
    public void setExternalLink(CTExternalLink cTExternalLink) throws Throwable {
        generatedSetterHelperImpl(cTExternalLink, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
