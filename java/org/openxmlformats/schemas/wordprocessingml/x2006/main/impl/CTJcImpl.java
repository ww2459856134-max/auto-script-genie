package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

/* loaded from: classes3.dex */
public class CTJcImpl extends XmlComplexContentImpl implements CTJc {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val")};
    private static final long serialVersionUID = 1;

    public CTJcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public STJc.Enum getVal() {
        STJc.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (STJc.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public void setVal(STJc.Enum r6) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public STJc xgetVal() {
        STJc sTJc;
        synchronized (monitor()) {
            check_orphaned();
            sTJc = (STJc) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public void xsetVal(STJc sTJc) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STJc sTJc2 = (STJc) typeStore.find_attribute_user(qNameArr[0]);
            if (sTJc2 == null) {
                sTJc2 = (STJc) get_store().add_attribute_user(qNameArr[0]);
            }
            sTJc2.set(sTJc);
        }
    }
}
