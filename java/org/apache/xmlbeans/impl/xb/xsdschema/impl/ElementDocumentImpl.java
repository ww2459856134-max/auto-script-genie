package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;

/* loaded from: classes2.dex */
public class ElementDocumentImpl extends XmlComplexContentImpl implements ElementDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "element")};
    private static final long serialVersionUID = 1;

    public ElementDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement addNewElement() {
        TopLevelElement topLevelElement;
        synchronized (monitor()) {
            check_orphaned();
            topLevelElement = (TopLevelElement) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return topLevelElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public TopLevelElement getElement() {
        TopLevelElement topLevelElement;
        synchronized (monitor()) {
            check_orphaned();
            topLevelElement = (TopLevelElement) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (topLevelElement == null) {
                topLevelElement = null;
            }
        }
        return topLevelElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument
    public void setElement(TopLevelElement topLevelElement) throws Throwable {
        generatedSetterHelperImpl(topLevelElement, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
