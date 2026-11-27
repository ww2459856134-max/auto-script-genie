package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllDocument;

/* loaded from: classes2.dex */
public class AllDocumentImpl extends XmlComplexContentImpl implements AllDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "all")};
    private static final long serialVersionUID = 1;

    public AllDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public All getAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (all == null) {
                all = null;
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AllDocument
    public void setAll(All all) throws Throwable {
        generatedSetterHelperImpl(all, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
