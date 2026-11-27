package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* loaded from: classes2.dex */
public class UnionDocumentImpl extends XmlComplexContentImpl implements UnionDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", XmlErrorCodes.UNION)};
    private static final long serialVersionUID = 1;

    public static class UnionImpl extends AnnotatedImpl implements UnionDocument.Union {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("", "memberTypes")};
        private static final long serialVersionUID = 1;

        public static class MemberTypesImpl extends XmlListImpl implements UnionDocument.Union.MemberTypes {
            private static final long serialVersionUID = 1;

            public MemberTypesImpl(SchemaType schemaType) {
                super(schemaType, false);
            }

            protected MemberTypesImpl(SchemaType schemaType, boolean z) {
                super(schemaType, z);
            }
        }

        public UnionImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public List getMemberTypes() {
            List<?> listValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
                listValue = simpleValue == null ? null : simpleValue.getListValue();
            }
            return listValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType[] getSimpleTypeArray() {
            return (LocalSimpleType[]) getXmlObjectArray(PROPERTY_QNAME[0], new LocalSimpleType[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public List<LocalSimpleType> getSimpleTypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y8
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getSimpleTypeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l5
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setSimpleTypeArray(((Integer) obj).intValue(), (LocalSimpleType) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ga
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewSimpleType(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x5
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeSimpleType(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e2
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfSimpleTypeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType insertNewSimpleType(int i2) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public boolean isSetMemberTypes() {
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void removeSimpleType(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setMemberTypes(List list) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setListValue(list);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(LocalSimpleType[] localSimpleTypeArr) {
            check_orphaned();
            arraySetterHelper(localSimpleTypeArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public int sizeOfSimpleTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void unsetMemberTypes() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[1]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public UnionDocument.Union.MemberTypes xgetMemberTypes() {
            UnionDocument.Union.MemberTypes memberTypes;
            synchronized (monitor()) {
                check_orphaned();
                memberTypes = (UnionDocument.Union.MemberTypes) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            }
            return memberTypes;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void xsetMemberTypes(UnionDocument.Union.MemberTypes memberTypes) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                UnionDocument.Union.MemberTypes memberTypes2 = (UnionDocument.Union.MemberTypes) typeStore.find_attribute_user(qNameArr[1]);
                if (memberTypes2 == null) {
                    memberTypes2 = (UnionDocument.Union.MemberTypes) get_store().add_attribute_user(qNameArr[1]);
                }
                memberTypes2.set(memberTypes);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public LocalSimpleType getSimpleTypeArray(int i2) {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().find_element_user(PROPERTY_QNAME[0], i2);
                if (localSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument.Union
        public void setSimpleTypeArray(int i2, LocalSimpleType localSimpleType) throws Throwable {
            generatedSetterHelperImpl(localSimpleType, PROPERTY_QNAME[0], i2, (short) 2);
        }
    }

    public UnionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union addNewUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return union;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public UnionDocument.Union getUnion() {
        UnionDocument.Union union;
        synchronized (monitor()) {
            check_orphaned();
            union = (UnionDocument.Union) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (union == null) {
                union = null;
            }
        }
        return union;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument
    public void setUnion(UnionDocument.Union union) throws Throwable {
        generatedSetterHelperImpl(union, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
