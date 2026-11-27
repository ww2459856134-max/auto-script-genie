package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumberOrPercent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STZoom$Enum;

/* loaded from: classes3.dex */
public class CTZoomImpl extends XmlComplexContentImpl implements CTZoom {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "percent")};
    private static final long serialVersionUID = 1;

    public CTZoomImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public Object getPercent() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STZoom$Enum getVal() {
        STZoom$Enum sTZoom$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            sTZoom$Enum = simpleValue == null ? null : (STZoom$Enum) simpleValue.getEnumValue();
        }
        return sTZoom$Enum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void setPercent(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void setVal(STZoom$Enum sTZoom$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setEnumValue(sTZoom$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STDecimalNumberOrPercent xgetPercent() {
        STDecimalNumberOrPercent sTDecimalNumberOrPercent;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumberOrPercent = (STDecimalNumberOrPercent) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTDecimalNumberOrPercent;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public STZoom xgetVal() {
        STZoom sTZoomFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTZoomFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTZoomFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void xsetPercent(STDecimalNumberOrPercent sTDecimalNumberOrPercent) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDecimalNumberOrPercent sTDecimalNumberOrPercent2 = (STDecimalNumberOrPercent) typeStore.find_attribute_user(qNameArr[1]);
            if (sTDecimalNumberOrPercent2 == null) {
                sTDecimalNumberOrPercent2 = (STDecimalNumberOrPercent) get_store().add_attribute_user(qNameArr[1]);
            }
            sTDecimalNumberOrPercent2.set(sTDecimalNumberOrPercent);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom
    public void xsetVal(STZoom sTZoom) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STZoom sTZoomFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
            if (sTZoomFind_attribute_user == null) {
                sTZoomFind_attribute_user = (STZoom) get_store().add_attribute_user(qNameArr[0]);
            }
            sTZoomFind_attribute_user.set(sTZoom);
        }
    }
}
