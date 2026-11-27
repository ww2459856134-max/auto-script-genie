package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.XMLConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.FullDerivationSet;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* loaded from: classes2.dex */
public class SchemaDocumentImpl extends XmlComplexContentImpl implements SchemaDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "schema")};
    private static final long serialVersionUID = 1;

    public static class SchemaImpl extends OpenAttrsImpl implements SchemaDocument.Schema {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "include"), new QName("http://www.w3.org/2001/XMLSchema", "import"), new QName("http://www.w3.org/2001/XMLSchema", "redefine"), new QName("http://www.w3.org/2001/XMLSchema", "annotation"), new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", "complexType"), new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("http://www.w3.org/2001/XMLSchema", "element"), new QName("http://www.w3.org/2001/XMLSchema", "attribute"), new QName("http://www.w3.org/2001/XMLSchema", "notation"), new QName("", "targetNamespace"), new QName("", "version"), new QName("", "finalDefault"), new QName("", "blockDefault"), new QName("", "attributeFormDefault"), new QName("", "elementFormDefault"), new QName("", "id"), new QName(XMLConstants.XML_NS_URI, "lang")};
        private static final long serialVersionUID = 1;

        public SchemaImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation addNewAnnotation() {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().add_element_user(PROPERTY_QNAME[3]);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute addNewAttribute() {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().add_element_user(PROPERTY_QNAME[9]);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup addNewAttributeGroup() {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().add_element_user(PROPERTY_QNAME[7]);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType addNewComplexType() {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().add_element_user(PROPERTY_QNAME[5]);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement addNewElement() {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().add_element_user(PROPERTY_QNAME[8]);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup addNewGroup() {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().add_element_user(PROPERTY_QNAME[6]);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import addNewImport() {
            ImportDocument.Import r1;
            synchronized (monitor()) {
                check_orphaned();
                r1 = (ImportDocument.Import) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include addNewInclude() {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation addNewNotation() {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().add_element_user(PROPERTY_QNAME[10]);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine addNewRedefine() {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().add_element_user(PROPERTY_QNAME[2]);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType addNewSimpleType() {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().add_element_user(PROPERTY_QNAME[4]);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation[] getAnnotationArray() {
            return (AnnotationDocument.Annotation[]) getXmlObjectArray(PROPERTY_QNAME[3], new AnnotationDocument.Annotation[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<AnnotationDocument.Annotation> getAnnotationList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getAnnotationArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setAnnotationArray(((Integer) obj).intValue(), (AnnotationDocument.Annotation) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewAnnotation(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d5
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeAnnotation(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u1
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfAnnotationArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute[] getAttributeArray() {
            return (TopLevelAttribute[]) getXmlObjectArray(PROPERTY_QNAME[9], new TopLevelAttribute[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getAttributeFormDefault() {
            FormChoice.Enum r1;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[15]);
                }
                r1 = simpleValue == null ? null : (FormChoice.Enum) simpleValue.getEnumValue();
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup[] getAttributeGroupArray() {
            return (NamedAttributeGroup[]) getXmlObjectArray(PROPERTY_QNAME[7], new NamedAttributeGroup[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<NamedAttributeGroup> getAttributeGroupList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ta
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getAttributeGroupArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p8
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setAttributeGroupArray(((Integer) obj).intValue(), (NamedAttributeGroup) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewAttributeGroup(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeAttributeGroup(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k9
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfAttributeGroupArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<TopLevelAttribute> getAttributeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getAttributeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f7
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setAttributeArray(((Integer) obj).intValue(), (TopLevelAttribute) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewAttribute(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m6
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeAttribute(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b4
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfAttributeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getBlockDefault() {
            Object objectValue;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[14]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            }
            return objectValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType[] getComplexTypeArray() {
            return (TopLevelComplexType[]) getXmlObjectArray(PROPERTY_QNAME[5], new TopLevelComplexType[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<TopLevelComplexType> getComplexTypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getComplexTypeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setComplexTypeArray(((Integer) obj).intValue(), (TopLevelComplexType) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewComplexType(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j6
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeComplexType(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b3
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfComplexTypeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement[] getElementArray() {
            return (TopLevelElement[]) getXmlObjectArray(PROPERTY_QNAME[8], new TopLevelElement[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice.Enum getElementFormDefault() {
            FormChoice.Enum r1;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[16]);
                }
                r1 = simpleValue == null ? null : (FormChoice.Enum) simpleValue.getEnumValue();
            }
            return r1;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<TopLevelElement> getElementList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getElementArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i7
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setElementArray(((Integer) obj).intValue(), (TopLevelElement) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewElement(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeElement(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i6
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfElementArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public Object getFinalDefault() {
            Object objectValue;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[13]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            }
            return objectValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup[] getGroupArray() {
            return (NamedGroup[]) getXmlObjectArray(PROPERTY_QNAME[6], new NamedGroup[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<NamedGroup> getGroupList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m7
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getGroupArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r8
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setGroupArray(((Integer) obj).intValue(), (NamedGroup) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewGroup(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeGroup(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s8
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfGroupArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getId() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[17]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import[] getImportArray() {
            return (ImportDocument.Import[]) getXmlObjectArray(PROPERTY_QNAME[1], new ImportDocument.Import[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<ImportDocument.Import> getImportList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.z0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getImportArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p0
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setImportArray(((Integer) obj).intValue(), (ImportDocument.Import) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewImport(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c8
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeImport(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g5
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfImportArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include[] getIncludeArray() {
            return (IncludeDocument.Include[]) getXmlObjectArray(PROPERTY_QNAME[0], new IncludeDocument.Include[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<IncludeDocument.Include> getIncludeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getIncludeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f1
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setIncludeArray(((Integer) obj).intValue(), (IncludeDocument.Include) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewInclude(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o7
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeInclude(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.sa
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfIncludeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getLang() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[18]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation[] getNotationArray() {
            return (NotationDocument.Notation[]) getXmlObjectArray(PROPERTY_QNAME[10], new NotationDocument.Notation[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<NotationDocument.Notation> getNotationList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getNotationArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w0
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setNotationArray(((Integer) obj).intValue(), (NotationDocument.Notation) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewNotation(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeNotation(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w8
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfNotationArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine[] getRedefineArray() {
            return (RedefineDocument.Redefine[]) getXmlObjectArray(PROPERTY_QNAME[2], new RedefineDocument.Redefine[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<RedefineDocument.Redefine> getRedefineList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getRedefineArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setRedefineArray(((Integer) obj).intValue(), (RedefineDocument.Redefine) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewRedefine(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeRedefine(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g6
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfRedefineArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType[] getSimpleTypeArray() {
            return (TopLevelSimpleType[]) getXmlObjectArray(PROPERTY_QNAME[4], new TopLevelSimpleType[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public List<TopLevelSimpleType> getSimpleTypeList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.oa
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getSimpleTypeArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k2
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setSimpleTypeArray(((Integer) obj).intValue(), (TopLevelSimpleType) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewSimpleType(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n9
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeSimpleType(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfSimpleTypeArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getTargetNamespace() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[11]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public String getVersion() {
            String stringValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
                stringValue = simpleValue == null ? null : simpleValue.getStringValue();
            }
            return stringValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation insertNewAnnotation(int i2) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute insertNewAttribute(int i2) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup insertNewAttributeGroup(int i2) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType insertNewComplexType(int i2) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement insertNewElement(int i2) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup insertNewGroup(int i2) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import insertNewImport(int i2) {
            ImportDocument.Import r5;
            synchronized (monitor()) {
                check_orphaned();
                r5 = (ImportDocument.Import) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
            }
            return r5;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include insertNewInclude(int i2) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation insertNewNotation(int i2) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine insertNewRedefine(int i2) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType insertNewSimpleType(int i2) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetAttributeFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetBlockDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetElementFormDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetFinalDefault() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetId() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetLang() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetTargetNamespace() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[11]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public boolean isSetVersion() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAnnotation(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[3], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttribute(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[9], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeAttributeGroup(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[7], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeComplexType(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[5], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeElement(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[8], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeGroup(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[6], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeImport(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeInclude(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeNotation(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[10], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeRedefine(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[2], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void removeSimpleType(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[4], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(AnnotationDocument.Annotation[] annotationArr) {
            check_orphaned();
            arraySetterHelper(annotationArr, PROPERTY_QNAME[3]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(TopLevelAttribute[] topLevelAttributeArr) {
            check_orphaned();
            arraySetterHelper(topLevelAttributeArr, PROPERTY_QNAME[9]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeFormDefault(FormChoice.Enum r6) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setEnumValue(r6);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(NamedAttributeGroup[] namedAttributeGroupArr) {
            check_orphaned();
            arraySetterHelper(namedAttributeGroupArr, PROPERTY_QNAME[7]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setBlockDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
                }
                simpleValue.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(TopLevelComplexType[] topLevelComplexTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelComplexTypeArr, PROPERTY_QNAME[5]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(TopLevelElement[] topLevelElementArr) {
            check_orphaned();
            arraySetterHelper(topLevelElementArr, PROPERTY_QNAME[8]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementFormDefault(FormChoice.Enum r6) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
                }
                simpleValue.setEnumValue(r6);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setFinalDefault(Object obj) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
                }
                simpleValue.setObjectValue(obj);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(NamedGroup[] namedGroupArr) {
            check_orphaned();
            arraySetterHelper(namedGroupArr, PROPERTY_QNAME[6]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setId(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(ImportDocument.Import[] importArr) {
            check_orphaned();
            arraySetterHelper(importArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(IncludeDocument.Include[] includeArr) {
            check_orphaned();
            arraySetterHelper(includeArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setLang(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(NotationDocument.Notation[] notationArr) {
            check_orphaned();
            arraySetterHelper(notationArr, PROPERTY_QNAME[10]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(RedefineDocument.Redefine[] redefineArr) {
            check_orphaned();
            arraySetterHelper(redefineArr, PROPERTY_QNAME[2]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(TopLevelSimpleType[] topLevelSimpleTypeArr) {
            check_orphaned();
            arraySetterHelper(topLevelSimpleTypeArr, PROPERTY_QNAME[4]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setTargetNamespace(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setVersion(String str) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
                }
                simpleValue.setStringValue(str);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAnnotationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfAttributeGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfComplexTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfElementArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfGroupArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfImportArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfIncludeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfNotationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfRedefineArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public int sizeOfSimpleTypeArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetAttributeFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[15]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetBlockDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[14]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetElementFormDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[16]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetFinalDefault() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[13]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetId() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[17]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetLang() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[18]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetTargetNamespace() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[11]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void unsetVersion() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[12]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetAttributeFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                formChoice = (FormChoice) typeStore.find_attribute_user(qNameArr[15]);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qNameArr[15]);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public BlockSet xgetBlockDefault() {
            BlockSet blockSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                blockSet = (BlockSet) typeStore.find_attribute_user(qNameArr[14]);
                if (blockSet == null) {
                    blockSet = (BlockSet) get_default_attribute_value(qNameArr[14]);
                }
            }
            return blockSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FormChoice xgetElementFormDefault() {
            FormChoice formChoice;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                formChoice = (FormChoice) typeStore.find_attribute_user(qNameArr[16]);
                if (formChoice == null) {
                    formChoice = (FormChoice) get_default_attribute_value(qNameArr[16]);
                }
            }
            return formChoice;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public FullDerivationSet xgetFinalDefault() {
            FullDerivationSet fullDerivationSet;
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                fullDerivationSet = (FullDerivationSet) typeStore.find_attribute_user(qNameArr[13]);
                if (fullDerivationSet == null) {
                    fullDerivationSet = (FullDerivationSet) get_default_attribute_value(qNameArr[13]);
                }
            }
            return fullDerivationSet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlID xgetId() {
            XmlID xmlID;
            synchronized (monitor()) {
                check_orphaned();
                xmlID = (XmlID) get_store().find_attribute_user(PROPERTY_QNAME[17]);
            }
            return xmlID;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public LangAttribute.Lang xgetLang() {
            LangAttribute.Lang lang;
            synchronized (monitor()) {
                check_orphaned();
                lang = (LangAttribute.Lang) get_store().find_attribute_user(PROPERTY_QNAME[18]);
            }
            return lang;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlAnyURI xgetTargetNamespace() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(PROPERTY_QNAME[11]);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public XmlToken xgetVersion() {
            XmlToken xmlToken;
            synchronized (monitor()) {
                check_orphaned();
                xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            }
            return xmlToken;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetAttributeFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qNameArr[15]);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qNameArr[15]);
                }
                formChoice2.set(formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetBlockDefault(BlockSet blockSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                BlockSet blockSet2 = (BlockSet) typeStore.find_attribute_user(qNameArr[14]);
                if (blockSet2 == null) {
                    blockSet2 = (BlockSet) get_store().add_attribute_user(qNameArr[14]);
                }
                blockSet2.set(blockSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetElementFormDefault(FormChoice formChoice) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                FormChoice formChoice2 = (FormChoice) typeStore.find_attribute_user(qNameArr[16]);
                if (formChoice2 == null) {
                    formChoice2 = (FormChoice) get_store().add_attribute_user(qNameArr[16]);
                }
                formChoice2.set(formChoice);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetFinalDefault(FullDerivationSet fullDerivationSet) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                FullDerivationSet fullDerivationSet2 = (FullDerivationSet) typeStore.find_attribute_user(qNameArr[13]);
                if (fullDerivationSet2 == null) {
                    fullDerivationSet2 = (FullDerivationSet) get_store().add_attribute_user(qNameArr[13]);
                }
                fullDerivationSet2.set(fullDerivationSet);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetId(XmlID xmlID) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlID xmlID2 = (XmlID) typeStore.find_attribute_user(qNameArr[17]);
                if (xmlID2 == null) {
                    xmlID2 = (XmlID) get_store().add_attribute_user(qNameArr[17]);
                }
                xmlID2.set(xmlID);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetLang(LangAttribute.Lang lang) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                LangAttribute.Lang lang2 = (LangAttribute.Lang) typeStore.find_attribute_user(qNameArr[18]);
                if (lang2 == null) {
                    lang2 = (LangAttribute.Lang) get_store().add_attribute_user(qNameArr[18]);
                }
                lang2.set(lang);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetTargetNamespace(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qNameArr[11]);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qNameArr[11]);
                }
                xmlAnyURI2.set(xmlAnyURI);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void xsetVersion(XmlToken xmlToken) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[12]);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[12]);
                }
                xmlToken2.set(xmlToken);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public AnnotationDocument.Annotation getAnnotationArray(int i2) {
            AnnotationDocument.Annotation annotation;
            synchronized (monitor()) {
                check_orphaned();
                annotation = (AnnotationDocument.Annotation) get_store().find_element_user(PROPERTY_QNAME[3], i2);
                if (annotation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return annotation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelAttribute getAttributeArray(int i2) {
            TopLevelAttribute topLevelAttribute;
            synchronized (monitor()) {
                check_orphaned();
                topLevelAttribute = (TopLevelAttribute) get_store().find_element_user(PROPERTY_QNAME[9], i2);
                if (topLevelAttribute == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelAttribute;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedAttributeGroup getAttributeGroupArray(int i2) {
            NamedAttributeGroup namedAttributeGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedAttributeGroup = (NamedAttributeGroup) get_store().find_element_user(PROPERTY_QNAME[7], i2);
                if (namedAttributeGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedAttributeGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelComplexType getComplexTypeArray(int i2) {
            TopLevelComplexType topLevelComplexType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelComplexType = (TopLevelComplexType) get_store().find_element_user(PROPERTY_QNAME[5], i2);
                if (topLevelComplexType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelComplexType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelElement getElementArray(int i2) {
            TopLevelElement topLevelElement;
            synchronized (monitor()) {
                check_orphaned();
                topLevelElement = (TopLevelElement) get_store().find_element_user(PROPERTY_QNAME[8], i2);
                if (topLevelElement == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelElement;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NamedGroup getGroupArray(int i2) {
            NamedGroup namedGroup;
            synchronized (monitor()) {
                check_orphaned();
                namedGroup = (NamedGroup) get_store().find_element_user(PROPERTY_QNAME[6], i2);
                if (namedGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return namedGroup;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public ImportDocument.Import getImportArray(int i2) {
            ImportDocument.Import r5;
            synchronized (monitor()) {
                check_orphaned();
                r5 = (ImportDocument.Import) get_store().find_element_user(PROPERTY_QNAME[1], i2);
                if (r5 == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return r5;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public IncludeDocument.Include getIncludeArray(int i2) {
            IncludeDocument.Include include;
            synchronized (monitor()) {
                check_orphaned();
                include = (IncludeDocument.Include) get_store().find_element_user(PROPERTY_QNAME[0], i2);
                if (include == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return include;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public NotationDocument.Notation getNotationArray(int i2) {
            NotationDocument.Notation notation;
            synchronized (monitor()) {
                check_orphaned();
                notation = (NotationDocument.Notation) get_store().find_element_user(PROPERTY_QNAME[10], i2);
                if (notation == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return notation;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public RedefineDocument.Redefine getRedefineArray(int i2) {
            RedefineDocument.Redefine redefine;
            synchronized (monitor()) {
                check_orphaned();
                redefine = (RedefineDocument.Redefine) get_store().find_element_user(PROPERTY_QNAME[2], i2);
                if (redefine == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return redefine;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public TopLevelSimpleType getSimpleTypeArray(int i2) {
            TopLevelSimpleType topLevelSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                topLevelSimpleType = (TopLevelSimpleType) get_store().find_element_user(PROPERTY_QNAME[4], i2);
                if (topLevelSimpleType == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return topLevelSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAnnotationArray(int i2, AnnotationDocument.Annotation annotation) throws Throwable {
            generatedSetterHelperImpl(annotation, PROPERTY_QNAME[3], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeArray(int i2, TopLevelAttribute topLevelAttribute) throws Throwable {
            generatedSetterHelperImpl(topLevelAttribute, PROPERTY_QNAME[9], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setAttributeGroupArray(int i2, NamedAttributeGroup namedAttributeGroup) throws Throwable {
            generatedSetterHelperImpl(namedAttributeGroup, PROPERTY_QNAME[7], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setComplexTypeArray(int i2, TopLevelComplexType topLevelComplexType) throws Throwable {
            generatedSetterHelperImpl(topLevelComplexType, PROPERTY_QNAME[5], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setElementArray(int i2, TopLevelElement topLevelElement) throws Throwable {
            generatedSetterHelperImpl(topLevelElement, PROPERTY_QNAME[8], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setGroupArray(int i2, NamedGroup namedGroup) throws Throwable {
            generatedSetterHelperImpl(namedGroup, PROPERTY_QNAME[6], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setImportArray(int i2, ImportDocument.Import r4) throws Throwable {
            generatedSetterHelperImpl(r4, PROPERTY_QNAME[1], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setIncludeArray(int i2, IncludeDocument.Include include) throws Throwable {
            generatedSetterHelperImpl(include, PROPERTY_QNAME[0], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setNotationArray(int i2, NotationDocument.Notation notation) throws Throwable {
            generatedSetterHelperImpl(notation, PROPERTY_QNAME[10], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setRedefineArray(int i2, RedefineDocument.Redefine redefine) throws Throwable {
            generatedSetterHelperImpl(redefine, PROPERTY_QNAME[2], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument.Schema
        public void setSimpleTypeArray(int i2, TopLevelSimpleType topLevelSimpleType) throws Throwable {
            generatedSetterHelperImpl(topLevelSimpleType, PROPERTY_QNAME[4], i2, (short) 2);
        }
    }

    public SchemaDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema addNewSchema() {
        SchemaDocument.Schema schema;
        synchronized (monitor()) {
            check_orphaned();
            schema = (SchemaDocument.Schema) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return schema;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public SchemaDocument.Schema getSchema() {
        SchemaDocument.Schema schema;
        synchronized (monitor()) {
            check_orphaned();
            schema = (SchemaDocument.Schema) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (schema == null) {
                schema = null;
            }
        }
        return schema;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument
    public void setSchema(SchemaDocument.Schema schema) throws Throwable {
        generatedSetterHelperImpl(schema, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
