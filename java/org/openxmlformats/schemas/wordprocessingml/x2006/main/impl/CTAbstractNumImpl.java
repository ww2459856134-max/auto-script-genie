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
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* loaded from: classes3.dex */
public class CTAbstractNumImpl extends XmlComplexContentImpl implements CTAbstractNum {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "nsid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "multiLevelType"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tmpl"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleLink"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numStyleLink"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNumId")};
    private static final long serialVersionUID = 1;

    public CTAbstractNumImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl addNewLvl() {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType addNewMultiLevelType() {
        CTMultiLevelType cTMultiLevelTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLevelTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTMultiLevelTypeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewNsid() {
        CTLongHexNumber cTLongHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLongHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewNumStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString addNewStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber addNewTmpl() {
        CTLongHexNumber cTLongHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTLongHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public BigInteger getAbstractNumId() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl[] getLvlArray() {
        return (CTLvl[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTLvl[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public List<CTLvl> getLvlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qn3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLvlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sm1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLvlArray(((Integer) obj).intValue(), (CTLvl) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.it0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLvl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nm0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLvl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLvlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTMultiLevelType getMultiLevelType() {
        CTMultiLevelType cTMultiLevelTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLevelTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTMultiLevelTypeFind_element_user == null) {
                cTMultiLevelTypeFind_element_user = null;
            }
        }
        return cTMultiLevelTypeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getNsid() {
        CTLongHexNumber cTLongHexNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTLongHexNumberFind_element_user == null) {
                cTLongHexNumberFind_element_user = null;
            }
        }
        return cTLongHexNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getNumStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTString getStyleLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLongHexNumber getTmpl() {
        CTLongHexNumber cTLongHexNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTLongHexNumberFind_element_user == null) {
                cTLongHexNumberFind_element_user = null;
            }
        }
        return cTLongHexNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl insertNewLvl(int i2) {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetMultiLevelType() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetNumStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetStyleLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public boolean isSetTmpl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void removeLvl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setAbstractNumId(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(CTLvl[] cTLvlArr) {
        check_orphaned();
        arraySetterHelper(cTLvlArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setMultiLevelType(CTMultiLevelType cTMultiLevelType) throws Throwable {
        generatedSetterHelperImpl(cTMultiLevelType, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setName(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNsid(CTLongHexNumber cTLongHexNumber) throws Throwable {
        generatedSetterHelperImpl(cTLongHexNumber, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setNumStyleLink(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setStyleLink(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setTmpl(CTLongHexNumber cTLongHexNumber) throws Throwable {
        generatedSetterHelperImpl(cTLongHexNumber, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public int sizeOfLvlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetMultiLevelType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetNumStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetStyleLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void unsetTmpl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public STDecimalNumber xgetAbstractNumId() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void xsetAbstractNumId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qNameArr[7]);
            if (sTDecimalNumber2 == null) {
                sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qNameArr[7]);
            }
            sTDecimalNumber2.set(sTDecimalNumber);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public CTLvl getLvlArray(int i2) {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTLvl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum
    public void setLvlArray(int i2, CTLvl cTLvl) throws Throwable {
        generatedSetterHelperImpl(cTLvl, PROPERTY_QNAME[6], i2, (short) 2);
    }
}
