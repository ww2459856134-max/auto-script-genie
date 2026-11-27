package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;

/* loaded from: classes2.dex */
public class SpaceAttributeImpl extends XmlComplexContentImpl implements SpaceAttribute {
    private static final QName[] PROPERTY_QNAME = {new QName(XMLConstants.XML_NS_URI, "space")};
    private static final long serialVersionUID = 1;

    public static class SpaceImpl extends JavaStringEnumerationHolderEx implements SpaceAttribute.Space {
        private static final long serialVersionUID = 1;

        public SpaceImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected SpaceImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public SpaceAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public SpaceAttribute.Space.Enum getSpace() {
        SpaceAttribute.Space.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r1 = simpleValue == null ? null : (SpaceAttribute.Space.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void setSpace(SpaceAttribute.Space.Enum r6) {
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

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public SpaceAttribute.Space xgetSpace() {
        SpaceAttribute.Space space;
        synchronized (monitor()) {
            check_orphaned();
            space = (SpaceAttribute.Space) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return space;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute
    public void xsetSpace(SpaceAttribute.Space space) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SpaceAttribute.Space space2 = (SpaceAttribute.Space) typeStore.find_attribute_user(qNameArr[0]);
            if (space2 == null) {
                space2 = (SpaceAttribute.Space) get_store().add_attribute_user(qNameArr[0]);
            }
            space2.set(space);
        }
    }
}
