package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblOverlap;

/* loaded from: classes3.dex */
public class CTTblOverlapImpl extends XmlComplexContentImpl implements CTTblOverlap {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val")};
    private static final long serialVersionUID = 1;

    public CTTblOverlapImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap
    public STTblOverlap.Enum getVal() {
        STTblOverlap.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (STTblOverlap.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap
    public void setVal(STTblOverlap.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap
    public STTblOverlap xgetVal() {
        STTblOverlap sTTblOverlap;
        synchronized (monitor()) {
            check_orphaned();
            sTTblOverlap = (STTblOverlap) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTTblOverlap;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblOverlap
    public void xsetVal(STTblOverlap sTTblOverlap) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STTblOverlap sTTblOverlap2 = (STTblOverlap) typeStore.find_attribute_user(qNameArr[0]);
            if (sTTblOverlap2 == null) {
                sTTblOverlap2 = (STTblOverlap) get_store().add_attribute_user(qNameArr[0]);
            }
            sTTblOverlap2.set(sTTblOverlap);
        }
    }
}
