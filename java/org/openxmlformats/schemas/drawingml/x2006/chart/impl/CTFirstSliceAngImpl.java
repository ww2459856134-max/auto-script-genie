package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng;
import org.openxmlformats.schemas.drawingml.x2006.chart.STFirstSliceAng;

/* loaded from: classes2.dex */
public class CTFirstSliceAngImpl extends XmlComplexContentImpl implements CTFirstSliceAng {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTFirstSliceAngImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public STFirstSliceAng xgetVal() {
        STFirstSliceAng sTFirstSliceAngFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTFirstSliceAngFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTFirstSliceAngFind_attribute_user == null) {
                sTFirstSliceAngFind_attribute_user = (STFirstSliceAng) get_default_attribute_value(qNameArr[0]);
            }
        }
        return sTFirstSliceAngFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTFirstSliceAng
    public void xsetVal(STFirstSliceAng sTFirstSliceAng) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STFirstSliceAng sTFirstSliceAngFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTFirstSliceAngFind_attribute_user == null) {
                sTFirstSliceAngFind_attribute_user = (STFirstSliceAng) get_store().add_attribute_user(qNameArr[0]);
            }
            sTFirstSliceAngFind_attribute_user.set(sTFirstSliceAng);
        }
    }
}
