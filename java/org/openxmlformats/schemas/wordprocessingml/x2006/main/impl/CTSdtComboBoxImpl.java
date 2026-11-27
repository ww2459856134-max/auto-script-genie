package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtListItem;

/* loaded from: classes3.dex */
public class CTSdtComboBoxImpl extends XmlComplexContentImpl implements CTSdtComboBox {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "listItem"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lastValue")};
    private static final long serialVersionUID = 1;

    public CTSdtComboBoxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem addNewListItem() {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtListItem = (CTSdtListItem) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public String getLastValue() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
            }
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem[] getListItemArray() {
        return (CTSdtListItem[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSdtListItem[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public List<CTSdtListItem> getListItemList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t31
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getListItemArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setListItemArray(((Integer) obj).intValue(), (CTSdtListItem) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sg2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewListItem(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zp1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeListItem(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nx
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfListItemArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem insertNewListItem(int i2) {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtListItem = (CTSdtListItem) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public boolean isSetLastValue() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void removeListItem(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setLastValue(String str) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setListItemArray(CTSdtListItem[] cTSdtListItemArr) {
        check_orphaned();
        arraySetterHelper(cTSdtListItemArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public int sizeOfListItemArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void unsetLastValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public STString xgetLastValue() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTString = (STString) typeStore.find_attribute_user(qNameArr[1]);
            if (sTString == null) {
                sTString = (STString) get_default_attribute_value(qNameArr[1]);
            }
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void xsetLastValue(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STString sTString2 = (STString) typeStore.find_attribute_user(qNameArr[1]);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qNameArr[1]);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public CTSdtListItem getListItemArray(int i2) {
        CTSdtListItem cTSdtListItem;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtListItem = (CTSdtListItem) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSdtListItem == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtListItem;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox
    public void setListItemArray(int i2, CTSdtListItem cTSdtListItem) throws Throwable {
        generatedSetterHelperImpl(cTSdtListItem, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
