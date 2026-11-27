package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextDirection;

/* loaded from: classes3.dex */
public class CTTextDirectionImpl extends XmlComplexContentImpl implements CTTextDirection {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val")};
    private static final long serialVersionUID = 1;

    public CTTextDirectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection
    public STTextDirection.Enum getVal() {
        STTextDirection.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (STTextDirection.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection
    public void setVal(STTextDirection.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection
    public STTextDirection xgetVal() {
        STTextDirection sTTextDirection;
        synchronized (monitor()) {
            check_orphaned();
            sTTextDirection = (STTextDirection) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTTextDirection;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection
    public void xsetVal(STTextDirection sTTextDirection) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STTextDirection sTTextDirection2 = (STTextDirection) typeStore.find_attribute_user(qNameArr[0]);
            if (sTTextDirection2 == null) {
                sTTextDirection2 = (STTextDirection) get_store().add_attribute_user(qNameArr[0]);
            }
            sTTextDirection2.set(sTTextDirection);
        }
    }
}
