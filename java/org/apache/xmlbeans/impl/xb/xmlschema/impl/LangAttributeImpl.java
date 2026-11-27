package org.apache.xmlbeans.impl.xb.xmlschema.impl;

import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;

/* loaded from: classes2.dex */
public class LangAttributeImpl extends XmlComplexContentImpl implements LangAttribute {
    private static final QName[] PROPERTY_QNAME = {new QName(XMLConstants.XML_NS_URI, "lang")};
    private static final long serialVersionUID = 1;

    public static class LangImpl extends XmlUnionImpl implements LangAttribute.Lang, XmlLanguage, LangAttribute.Lang.Member {
        private static final long serialVersionUID = 1;

        public static class MemberImpl extends JavaStringEnumerationHolderEx implements LangAttribute.Lang.Member {
            private static final long serialVersionUID = 1;

            public MemberImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected MemberImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }

        public LangImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        protected LangImpl(SchemaType schemaType, boolean z) {
            super(schemaType, z);
        }
    }

    public LangAttributeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public String getLang() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public boolean isSetLang() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void setLang(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void unsetLang() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public LangAttribute.Lang xgetLang() {
        LangAttribute.Lang lang;
        synchronized (monitor()) {
            check_orphaned();
            lang = (LangAttribute.Lang) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return lang;
    }

    @Override // org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute
    public void xsetLang(LangAttribute.Lang lang) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            LangAttribute.Lang lang2 = (LangAttribute.Lang) typeStore.find_attribute_user(qNameArr[0]);
            if (lang2 == null) {
                lang2 = (LangAttribute.Lang) get_store().add_attribute_user(qNameArr[0]);
            }
            lang2.set(lang);
        }
    }
}
