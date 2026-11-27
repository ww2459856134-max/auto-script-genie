package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;

/* loaded from: classes2.dex */
public class ComplexTypeDocumentImpl extends XmlComplexContentImpl implements ComplexTypeDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "complexType")};
    private static final long serialVersionUID = 1;

    public ComplexTypeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType addNewComplexType() {
        TopLevelComplexType topLevelComplexType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return topLevelComplexType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public TopLevelComplexType getComplexType() {
        TopLevelComplexType topLevelComplexType;
        synchronized (monitor()) {
            check_orphaned();
            topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (topLevelComplexType == null) {
                topLevelComplexType = null;
            }
        }
        return topLevelComplexType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument
    public void setComplexType(TopLevelComplexType topLevelComplexType) throws Throwable {
        generatedSetterHelperImpl(topLevelComplexType, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
