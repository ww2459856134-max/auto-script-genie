package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComments;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument;

/* loaded from: classes2.dex */
public class CommentsDocumentImpl extends XmlComplexContentImpl implements CommentsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "comments")};
    private static final long serialVersionUID = 1;

    public CommentsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public CTComments addNewComments() {
        CTComments cTComments;
        synchronized (monitor()) {
            check_orphaned();
            cTComments = (CTComments) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTComments;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public CTComments getComments() {
        CTComments cTComments;
        synchronized (monitor()) {
            check_orphaned();
            cTComments = (CTComments) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTComments == null) {
                cTComments = null;
            }
        }
        return cTComments;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CommentsDocument
    public void setComments(CTComments cTComments) throws Throwable {
        generatedSetterHelperImpl(cTComments, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
