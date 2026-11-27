package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRotY;

/* loaded from: classes2.dex */
public class CTRotYImpl extends XmlComplexContentImpl implements CTRotY {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTRotYImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public int getVal() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
            }
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public void setVal(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public STRotY xgetVal() {
        STRotY sTRotYFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTRotYFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTRotYFind_attribute_user == null) {
                sTRotYFind_attribute_user = (STRotY) get_default_attribute_value(qNameArr[0]);
            }
        }
        return sTRotYFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY
    public void xsetVal(STRotY sTRotY) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRotY sTRotYFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTRotYFind_attribute_user == null) {
                sTRotYFind_attribute_user = (STRotY) get_store().add_attribute_user(qNameArr[0]);
            }
            sTRotYFind_attribute_user.set(sTRotY);
        }
    }
}
