package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument;

/* loaded from: classes2.dex */
public class MaxExclusiveDocumentImpl extends XmlComplexContentImpl implements MaxExclusiveDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "maxExclusive")};
    private static final long serialVersionUID = 1;

    public MaxExclusiveDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet addNewMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public Facet getMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (facet == null) {
                facet = null;
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.MaxExclusiveDocument
    public void setMaxExclusive(Facet facet) throws Throwable {
        generatedSetterHelperImpl(facet, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
