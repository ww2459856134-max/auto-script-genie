package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortCondition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSortMethod;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSortMethod$Enum;

/* loaded from: classes2.dex */
public class CTSortStateImpl extends XmlComplexContentImpl implements CTSortState {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sortCondition"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst"), new QName("", "columnSort"), new QName("", "caseSensitive"), new QName("", "sortMethod"), new QName("", "ref")};
    private static final long serialVersionUID = 1;

    public CTSortStateImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTSortCondition addNewSortCondition() {
        CTSortCondition cTSortCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTSortCondition = (CTSortCondition) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSortCondition;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean getCaseSensitive() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[3]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean getColumnSort() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public String getRef() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTSortCondition[] getSortConditionArray() {
        return (CTSortCondition[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSortCondition[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public List<CTSortCondition> getSortConditionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.r1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSortConditionArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.kf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSortConditionArray(((Integer) obj).intValue(), (CTSortCondition) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSortCondition(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.n9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSortCondition(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ei
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSortConditionArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public STSortMethod$Enum getSortMethod() {
        STSortMethod$Enum sTSortMethod$Enum;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[4]);
            }
            sTSortMethod$Enum = simpleValue == null ? null : (STSortMethod$Enum) simpleValue.getEnumValue();
        }
        return sTSortMethod$Enum;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTSortCondition insertNewSortCondition(int i2) {
        CTSortCondition cTSortCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTSortCondition = (CTSortCondition) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSortCondition;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean isSetCaseSensitive() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean isSetColumnSort() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public boolean isSetSortMethod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void removeSortCondition(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setCaseSensitive(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setColumnSort(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setRef(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setSortConditionArray(CTSortCondition[] cTSortConditionArr) {
        check_orphaned();
        arraySetterHelper(cTSortConditionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setSortMethod(STSortMethod$Enum sTSortMethod$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setEnumValue(sTSortMethod$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public int sizeOfSortConditionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void unsetCaseSensitive() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void unsetColumnSort() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void unsetSortMethod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public XmlBoolean xgetCaseSensitive() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[3]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[3]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public XmlBoolean xgetColumnSort() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[2]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[2]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public STRef xgetRef() {
        STRef sTRef;
        synchronized (monitor()) {
            check_orphaned();
            sTRef = (STRef) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTRef;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public STSortMethod xgetSortMethod() {
        STSortMethod sTSortMethodFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTSortMethodFind_attribute_user = typeStore.find_attribute_user(qNameArr[4]);
            if (sTSortMethodFind_attribute_user == null) {
                sTSortMethodFind_attribute_user = (STSortMethod) get_default_attribute_value(qNameArr[4]);
            }
        }
        return sTSortMethodFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void xsetCaseSensitive(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[3]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[3]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void xsetColumnSort(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[2]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[2]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void xsetRef(STRef sTRef) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STRef sTRef2 = (STRef) typeStore.find_attribute_user(qNameArr[5]);
            if (sTRef2 == null) {
                sTRef2 = (STRef) get_store().add_attribute_user(qNameArr[5]);
            }
            sTRef2.set(sTRef);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void xsetSortMethod(STSortMethod sTSortMethod) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STSortMethod sTSortMethodFind_attribute_user = typeStore.find_attribute_user(qNameArr[4]);
            if (sTSortMethodFind_attribute_user == null) {
                sTSortMethodFind_attribute_user = (STSortMethod) get_store().add_attribute_user(qNameArr[4]);
            }
            sTSortMethodFind_attribute_user.set(sTSortMethod);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public CTSortCondition getSortConditionArray(int i2) {
        CTSortCondition cTSortCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTSortCondition = (CTSortCondition) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSortCondition == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSortCondition;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortState
    public void setSortConditionArray(int i2, CTSortCondition cTSortCondition) throws Throwable {
        generatedSetterHelperImpl(cTSortCondition, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
