package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.tencent.open.SocialConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeCoordinate;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideSizeType;

/* loaded from: classes2.dex */
public class CTSlideSizeImpl extends XmlComplexContentImpl implements CTSlideSize {
    private static final QName[] PROPERTY_QNAME = {new QName("", "cx"), new QName("", "cy"), new QName("", SocialConstants.PARAM_TYPE)};
    private static final long serialVersionUID = 1;

    public CTSlideSizeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public int getCx() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public int getCy() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeType.Enum getType() {
        STSlideSizeType.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
            }
            r1 = simpleValue == null ? null : (STSlideSizeType.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setCx(int i2) {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setCy(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void setType(STSlideSizeType.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeCoordinate xgetCx() {
        STSlideSizeCoordinate sTSlideSizeCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideSizeCoordinate = (STSlideSizeCoordinate) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTSlideSizeCoordinate;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeCoordinate xgetCy() {
        STSlideSizeCoordinate sTSlideSizeCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideSizeCoordinate = (STSlideSizeCoordinate) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTSlideSizeCoordinate;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public STSlideSizeType xgetType() {
        STSlideSizeType sTSlideSizeType;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTSlideSizeType = (STSlideSizeType) typeStore.find_attribute_user(qNameArr[2]);
            if (sTSlideSizeType == null) {
                sTSlideSizeType = (STSlideSizeType) get_default_attribute_value(qNameArr[2]);
            }
        }
        return sTSlideSizeType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetCx(STSlideSizeCoordinate sTSlideSizeCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STSlideSizeCoordinate sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) typeStore.find_attribute_user(qNameArr[0]);
            if (sTSlideSizeCoordinate2 == null) {
                sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) get_store().add_attribute_user(qNameArr[0]);
            }
            sTSlideSizeCoordinate2.set(sTSlideSizeCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetCy(STSlideSizeCoordinate sTSlideSizeCoordinate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STSlideSizeCoordinate sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) typeStore.find_attribute_user(qNameArr[1]);
            if (sTSlideSizeCoordinate2 == null) {
                sTSlideSizeCoordinate2 = (STSlideSizeCoordinate) get_store().add_attribute_user(qNameArr[1]);
            }
            sTSlideSizeCoordinate2.set(sTSlideSizeCoordinate);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideSize
    public void xsetType(STSlideSizeType sTSlideSizeType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STSlideSizeType sTSlideSizeType2 = (STSlideSizeType) typeStore.find_attribute_user(qNameArr[2]);
            if (sTSlideSizeType2 == null) {
                sTSlideSizeType2 = (STSlideSizeType) get_store().add_attribute_user(qNameArr[2]);
            }
            sTSlideSizeType2.set(sTSlideSizeType);
        }
    }
}
