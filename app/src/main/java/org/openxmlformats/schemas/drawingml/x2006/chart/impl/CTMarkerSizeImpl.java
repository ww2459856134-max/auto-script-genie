package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerSize;

/* loaded from: classes2.dex */
public class CTMarkerSizeImpl extends XmlComplexContentImpl implements CTMarkerSize {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTMarkerSizeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public short getVal() {
        short shortValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            shortValue = 0;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
            }
            if (simpleValue != null) {
                shortValue = simpleValue.getShortValue();
            }
        }
        return shortValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public void setVal(short s) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public STMarkerSize xgetVal() {
        STMarkerSize sTMarkerSizeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTMarkerSizeFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTMarkerSizeFind_attribute_user == null) {
                sTMarkerSizeFind_attribute_user = (STMarkerSize) get_default_attribute_value(qNameArr[0]);
            }
        }
        return sTMarkerSizeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTMarkerSize
    public void xsetVal(STMarkerSize sTMarkerSize) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STMarkerSize sTMarkerSizeFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTMarkerSizeFind_attribute_user == null) {
                sTMarkerSizeFind_attribute_user = (STMarkerSize) get_store().add_attribute_user(qNameArr[0]);
            }
            sTMarkerSizeFind_attribute_user.set(sTMarkerSize);
        }
    }
}
