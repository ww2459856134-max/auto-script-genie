package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroup;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups;

/* loaded from: classes2.dex */
public class CTFunctionGroupsImpl extends XmlComplexContentImpl implements CTFunctionGroups {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "functionGroup"), new QName("", "builtInGroupCount")};
    private static final long serialVersionUID = 1;

    public CTFunctionGroupsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup addNewFunctionGroup() {
        CTFunctionGroup cTFunctionGroupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFunctionGroupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public long getBuiltInGroupCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
            }
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup[] getFunctionGroupArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTFunctionGroup[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public List<CTFunctionGroup> getFunctionGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.uh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFunctionGroupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFunctionGroupArray(((Integer) obj).intValue(), (CTFunctionGroup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.hj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFunctionGroup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.vc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFunctionGroup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.cb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFunctionGroupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup insertNewFunctionGroup(int i2) {
        CTFunctionGroup cTFunctionGroupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTFunctionGroupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public boolean isSetBuiltInGroupCount() {
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void removeFunctionGroup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setBuiltInGroupCount(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setFunctionGroupArray(CTFunctionGroup[] cTFunctionGroupArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFunctionGroupArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public int sizeOfFunctionGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void unsetBuiltInGroupCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public XmlUnsignedInt xgetBuiltInGroupCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
            if (xmlUnsignedInt == null) {
                xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qNameArr[1]);
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void xsetBuiltInGroupCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[1]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[1]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public CTFunctionGroup getFunctionGroupArray(int i2) {
        CTFunctionGroup cTFunctionGroupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFunctionGroupFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTFunctionGroupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFunctionGroupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups
    public void setFunctionGroupArray(int i2, CTFunctionGroup cTFunctionGroup) throws Throwable {
        generatedSetterHelperImpl(cTFunctionGroup, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
