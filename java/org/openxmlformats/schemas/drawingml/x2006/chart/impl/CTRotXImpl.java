package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRotX;

/* loaded from: classes2.dex */
public class CTRotXImpl extends XmlComplexContentImpl implements CTRotX {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTRotXImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public byte getVal() {
        byte byteValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            byteValue = 0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
            }
            if (simpleValue != null) {
                byteValue = simpleValue.getByteValue();
            }
        }
        return byteValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public void setVal(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public STRotX xgetVal() {
        STRotX sTRotXFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTRotXFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTRotXFind_attribute_user == null) {
                sTRotXFind_attribute_user = (STRotX) get_default_attribute_value(qNameArr[0]);
            }
        }
        return sTRotXFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTRotX
    public void xsetVal(STRotX sTRotX) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRotX sTRotXFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTRotXFind_attribute_user == null) {
                sTRotXFind_attribute_user = (STRotX) get_store().add_attribute_user(qNameArr[0]);
            }
            sTRotXFind_attribute_user.set(sTRotX);
        }
    }
}
