package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTObjectPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDvAspect;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOleUpdate;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOleUpdate$Enum;

/* loaded from: classes2.dex */
public class CTOleObjectImpl extends XmlComplexContentImpl implements CTOleObject {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "objectPr"), new QName("", "progId"), new QName("", "dvAspect"), new QName("", "link"), new QName("", "oleUpdate"), new QName("", "autoLoad"), new QName("", "shapeId"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id")};
    private static final long serialVersionUID = 1;

    public CTOleObjectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public CTObjectPr addNewObjectPr() {
        CTObjectPr cTObjectPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectPrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTObjectPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean getAutoLoad() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[5]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STDvAspect.Enum getDvAspect() {
        STDvAspect.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
            }
            r1 = simpleValue == null ? null : (STDvAspect.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public String getLink() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public CTObjectPr getObjectPr() {
        CTObjectPr cTObjectPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTObjectPrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTObjectPrFind_element_user == null) {
                cTObjectPrFind_element_user = null;
            }
        }
        return cTObjectPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STOleUpdate$Enum getOleUpdate() {
        STOleUpdate$Enum sTOleUpdate$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            sTOleUpdate$Enum = simpleValue == null ? null : (STOleUpdate$Enum) simpleValue.getEnumValue();
        }
        return sTOleUpdate$Enum;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public String getProgId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public long getShapeId() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetAutoLoad() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[5]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetDvAspect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetObjectPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetOleUpdate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public boolean isSetProgId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setAutoLoad(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setDvAspect(STDvAspect.Enum r6) {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setLink(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setObjectPr(CTObjectPr cTObjectPr) throws Throwable {
        generatedSetterHelperImpl(cTObjectPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setOleUpdate(STOleUpdate$Enum sTOleUpdate$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setEnumValue(sTOleUpdate$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setProgId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void setShapeId(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetAutoLoad() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetDvAspect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetObjectPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetOleUpdate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void unsetProgId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public XmlBoolean xgetAutoLoad() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[5]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[5]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STDvAspect xgetDvAspect() {
        STDvAspect sTDvAspect;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTDvAspect = (STDvAspect) typeStore.find_attribute_user(qNameArr[2]);
            if (sTDvAspect == null) {
                sTDvAspect = (STDvAspect) get_default_attribute_value(qNameArr[2]);
            }
        }
        return sTDvAspect;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STXstring xgetLink() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public STOleUpdate xgetOleUpdate() {
        STOleUpdate sTOleUpdateFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTOleUpdateFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTOleUpdateFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public XmlString xgetProgId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public XmlUnsignedInt xgetShapeId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetAutoLoad(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[5]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[5]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetDvAspect(STDvAspect sTDvAspect) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDvAspect sTDvAspect2 = (STDvAspect) typeStore.find_attribute_user(qNameArr[2]);
            if (sTDvAspect2 == null) {
                sTDvAspect2 = (STDvAspect) get_store().add_attribute_user(qNameArr[2]);
            }
            sTDvAspect2.set(sTDvAspect);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qNameArr[7]);
            if (sTRelationshipId2 == null) {
                sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qNameArr[7]);
            }
            sTRelationshipId2.set(sTRelationshipId);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetLink(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STXstring sTXstring2 = (STXstring) typeStore.find_attribute_user(qNameArr[3]);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_attribute_user(qNameArr[3]);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetOleUpdate(STOleUpdate sTOleUpdate) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOleUpdate sTOleUpdateFind_attribute_user = typeStore.find_attribute_user(qNameArr[4]);
            if (sTOleUpdateFind_attribute_user == null) {
                sTOleUpdateFind_attribute_user = (STOleUpdate) get_store().add_attribute_user(qNameArr[4]);
            }
            sTOleUpdateFind_attribute_user.set(sTOleUpdate);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetProgId(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[1]);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[1]);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject
    public void xsetShapeId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[6]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }
}
