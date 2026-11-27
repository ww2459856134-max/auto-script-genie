package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList;

/* loaded from: classes2.dex */
public class CTTLTimeConditionListImpl extends XmlComplexContentImpl implements CTTLTimeConditionList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cond")};
    private static final long serialVersionUID = 1;

    public CTTLTimeConditionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition addNewCond() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition[] getCondArray() {
        return (CTTLTimeCondition[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTLTimeCondition[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public List<CTTLTimeCondition> getCondList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.s
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCondArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.i0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCondArray(((Integer) obj).intValue(), (CTTLTimeCondition) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCond(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCond(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCondArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition insertNewCond(int i2) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void removeCond(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(CTTLTimeCondition[] cTTLTimeConditionArr) {
        check_orphaned();
        arraySetterHelper(cTTLTimeConditionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public int sizeOfCondArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition getCondArray(int i2) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTLTimeCondition == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(int i2, CTTLTimeCondition cTTLTimeCondition) throws Throwable {
        generatedSetterHelperImpl(cTTLTimeCondition, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
