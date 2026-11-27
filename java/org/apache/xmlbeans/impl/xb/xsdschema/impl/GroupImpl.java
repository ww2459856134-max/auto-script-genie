package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Group;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;

/* loaded from: classes2.dex */
public class GroupImpl extends AnnotatedImpl implements Group {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "element"), new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", "all"), new QName("http://www.w3.org/2001/XMLSchema", "choice"), new QName("http://www.w3.org/2001/XMLSchema", "sequence"), new QName("http://www.w3.org/2001/XMLSchema", "any"), new QName("", "name"), new QName("", "ref"), new QName("", "minOccurs"), new QName("", "maxOccurs")};
    private static final long serialVersionUID = 1;

    public GroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any addNewAny() {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement addNewElement() {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All[] getAllArray() {
        return (All[]) getXmlObjectArray(PROPERTY_QNAME[2], new All[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<All> getAllList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAllArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAllArray(((Integer) obj).intValue(), (All) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAll(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.wa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAll(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAllArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any[] getAnyArray() {
        return (AnyDocument.Any[]) getXmlObjectArray(PROPERTY_QNAME[5], new AnyDocument.Any[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<AnyDocument.Any> getAnyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnyArray(((Integer) obj).intValue(), (AnyDocument.Any) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAny(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAny(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnyArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getChoiceArray() {
        return (ExplicitGroup[]) getXmlObjectArray(PROPERTY_QNAME[3], new ExplicitGroup[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<ExplicitGroup> getChoiceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ya
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getChoiceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setChoiceArray(((Integer) obj).intValue(), (ExplicitGroup) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewChoice(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeChoice(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfChoiceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement[] getElementArray() {
        return (LocalElement[]) getXmlObjectArray(PROPERTY_QNAME[0], new LocalElement[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<LocalElement> getElementList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getElementArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ja
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setElementArray(((Integer) obj).intValue(), (LocalElement) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewElement(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeElement(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfElementArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef[] getGroupArray() {
        return (GroupRef[]) getXmlObjectArray(PROPERTY_QNAME[1], new GroupRef[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<GroupRef> getGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.na
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGroupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGroupArray(((Integer) obj).intValue(), (GroupRef) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGroup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGroup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGroupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public Object getMaxOccurs() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public BigInteger getMinOccurs() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[8]);
            }
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public QName getRef() {
        QName qNameValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            qNameValue = simpleValue == null ? null : simpleValue.getQNameValue();
        }
        return qNameValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getSequenceArray() {
        return (ExplicitGroup[]) getXmlObjectArray(PROPERTY_QNAME[4], new ExplicitGroup[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<ExplicitGroup> getSequenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSequenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSequenceArray(((Integer) obj).intValue(), (ExplicitGroup) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSequence(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSequence(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSequenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All insertNewAll(int i2) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any insertNewAny(int i2) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewChoice(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement insertNewElement(int i2) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef insertNewGroup(int i2) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewSequence(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMaxOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetMinOccurs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public boolean isSetRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAll(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAny(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeChoice(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeElement(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeGroup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeSequence(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(All[] allArr) {
        check_orphaned();
        arraySetterHelper(allArr, PROPERTY_QNAME[2]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(AnyDocument.Any[] anyArr) {
        check_orphaned();
        arraySetterHelper(anyArr, PROPERTY_QNAME[5]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, PROPERTY_QNAME[3]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(LocalElement[] localElementArr) {
        check_orphaned();
        arraySetterHelper(localElementArr, PROPERTY_QNAME[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(GroupRef[] groupRefArr) {
        check_orphaned();
        arraySetterHelper(groupRefArr, PROPERTY_QNAME[1]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMaxOccurs(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setMinOccurs(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setName(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setRef(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, PROPERTY_QNAME[4]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAllArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAnyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfChoiceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfElementArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfSequenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMaxOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetMinOccurs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void unsetRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AllNNI xgetMaxOccurs() {
        AllNNI allNNI;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            allNNI = (AllNNI) typeStore.find_attribute_user(qNameArr[9]);
            if (allNNI == null) {
                allNNI = (AllNNI) get_default_attribute_value(qNameArr[9]);
            }
        }
        return allNNI;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNonNegativeInteger xgetMinOccurs() {
        XmlNonNegativeInteger xmlNonNegativeInteger;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlNonNegativeInteger = (XmlNonNegativeInteger) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlNonNegativeInteger == null) {
                xmlNonNegativeInteger = (XmlNonNegativeInteger) get_default_attribute_value(qNameArr[8]);
            }
        }
        return xmlNonNegativeInteger;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlNCName xgetName() {
        XmlNCName xmlNCName;
        synchronized (monitor()) {
            check_orphaned();
            xmlNCName = (XmlNCName) get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return xmlNCName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public XmlQName xgetRef() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMaxOccurs(AllNNI allNNI) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            AllNNI allNNI2 = (AllNNI) typeStore.find_attribute_user(qNameArr[9]);
            if (allNNI2 == null) {
                allNNI2 = (AllNNI) get_store().add_attribute_user(qNameArr[9]);
            }
            allNNI2.set(allNNI);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetMinOccurs(XmlNonNegativeInteger xmlNonNegativeInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlNonNegativeInteger xmlNonNegativeInteger2 = (XmlNonNegativeInteger) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlNonNegativeInteger2 == null) {
                xmlNonNegativeInteger2 = (XmlNonNegativeInteger) get_store().add_attribute_user(qNameArr[8]);
            }
            xmlNonNegativeInteger2.set(xmlNonNegativeInteger);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetName(XmlNCName xmlNCName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlNCName xmlNCName2 = (XmlNCName) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlNCName2 == null) {
                xmlNCName2 = (XmlNCName) get_store().add_attribute_user(qNameArr[6]);
            }
            xmlNCName2.set(xmlNCName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void xsetRef(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qNameArr[7]);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All getAllArray(int i2) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (all == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public AnyDocument.Any getAnyArray(int i2) {
        AnyDocument.Any any;
        synchronized (monitor()) {
            check_orphaned();
            any = (AnyDocument.Any) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (any == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return any;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getChoiceArray(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public LocalElement getElementArray(int i2) {
        LocalElement localElement;
        synchronized (monitor()) {
            check_orphaned();
            localElement = (LocalElement) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (localElement == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return localElement;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public GroupRef getGroupArray(int i2) {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (groupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getSequenceArray(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(int i2, All all) throws Throwable {
        generatedSetterHelperImpl(all, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAnyArray(int i2, AnyDocument.Any any) throws Throwable {
        generatedSetterHelperImpl(any, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(int i2, ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setElementArray(int i2, LocalElement localElement) throws Throwable {
        generatedSetterHelperImpl(localElement, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setGroupArray(int i2, GroupRef groupRef) throws Throwable {
        generatedSetterHelperImpl(groupRef, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(int i2, ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[4], i2, (short) 2);
    }
}
