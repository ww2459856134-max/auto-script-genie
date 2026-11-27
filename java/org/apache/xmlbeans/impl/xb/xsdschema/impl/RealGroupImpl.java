package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.RealGroup;

/* loaded from: classes2.dex */
public class RealGroupImpl extends GroupImpl implements RealGroup {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "all"), new QName("http://www.w3.org/2001/XMLSchema", "choice"), new QName("http://www.w3.org/2001/XMLSchema", "sequence")};
    private static final long serialVersionUID = 1;

    public RealGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All[] getAllArray() {
        return (All[]) getXmlObjectArray(PROPERTY_QNAME[0], new All[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<All> getAllList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAllArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAllArray(((Integer) obj).intValue(), (All) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ha
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAll(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAll(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAllArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getChoiceArray() {
        return (ExplicitGroup[]) getXmlObjectArray(PROPERTY_QNAME[1], new ExplicitGroup[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<ExplicitGroup> getChoiceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getChoiceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setChoiceArray(((Integer) obj).intValue(), (ExplicitGroup) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewChoice(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeChoice(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfChoiceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup[] getSequenceArray() {
        return (ExplicitGroup[]) getXmlObjectArray(PROPERTY_QNAME[2], new ExplicitGroup[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public List<ExplicitGroup> getSequenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSequenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSequenceArray(((Integer) obj).intValue(), (ExplicitGroup) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSequence(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSequence(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSequenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All insertNewAll(int i2) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewChoice(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup insertNewSequence(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeAll(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeChoice(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void removeSequence(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(All[] allArr) {
        check_orphaned();
        arraySetterHelper(allArr, PROPERTY_QNAME[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, PROPERTY_QNAME[1]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(ExplicitGroup[] explicitGroupArr) {
        check_orphaned();
        arraySetterHelper(explicitGroupArr, PROPERTY_QNAME[2]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfAllArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfChoiceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public int sizeOfSequenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public All getAllArray(int i2) {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (all == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getChoiceArray(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public ExplicitGroup getSequenceArray(int i2) {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (explicitGroup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setAllArray(int i2, All all) throws Throwable {
        generatedSetterHelperImpl(all, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setChoiceArray(int i2, ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.impl.GroupImpl, org.apache.xmlbeans.impl.xb.xsdschema.Group
    public void setSequenceArray(int i2, ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[2], i2, (short) 2);
    }
}
