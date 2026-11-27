package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* loaded from: classes3.dex */
public class CTColumnsImpl extends XmlComplexContentImpl implements CTColumns {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "col"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "equalWidth"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "space"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "num"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sep")};
    private static final long serialVersionUID = 1;

    public CTColumnsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public CTColumn addNewCol() {
        CTColumn cTColumnAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColumnAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTColumnAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public CTColumn[] getColArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTColumn[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public List<CTColumn> getColList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hj3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getColArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setColArray(((Integer) obj).intValue(), (CTColumn) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yv1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCol(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wb0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCol(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n41
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfColArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public Object getEqualWidth() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public BigInteger getNum() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[3]);
            }
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public Object getSep() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public Object getSpace() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[2]);
            }
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public CTColumn insertNewCol(int i2) {
        CTColumn cTColumnInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColumnInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTColumnInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public boolean isSetEqualWidth() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public boolean isSetNum() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public boolean isSetSep() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void removeCol(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setColArray(CTColumn[] cTColumnArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColumnArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setEqualWidth(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setNum(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setSep(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setSpace(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public int sizeOfColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void unsetEqualWidth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void unsetNum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void unsetSep() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public STOnOff xgetEqualWidth() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public STDecimalNumber xgetNum() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTDecimalNumber = (STDecimalNumber) typeStore.find_attribute_user(qNameArr[3]);
            if (sTDecimalNumber == null) {
                sTDecimalNumber = (STDecimalNumber) get_default_attribute_value(qNameArr[3]);
            }
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public STOnOff xgetSep() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public STTwipsMeasure xgetSpace() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTTwipsMeasure = (STTwipsMeasure) typeStore.find_attribute_user(qNameArr[2]);
            if (sTTwipsMeasure == null) {
                sTTwipsMeasure = (STTwipsMeasure) get_default_attribute_value(qNameArr[2]);
            }
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void xsetEqualWidth(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[1]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[1]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void xsetNum(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qNameArr[3]);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qNameArr[3]);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void xsetSep(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[4]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[4]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void xsetSpace(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qNameArr[2]);
            if (sTTwipsMeasure2 == null) {
                sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qNameArr[2]);
            }
            sTTwipsMeasure2.set(sTTwipsMeasure);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public CTColumn getColArray(int i2) {
        CTColumn cTColumnFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColumnFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTColumnFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColumnFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColumns
    public void setColArray(int i2, CTColumn cTColumn) throws Throwable {
        generatedSetterHelperImpl(cTColumn, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
