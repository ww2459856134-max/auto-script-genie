package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

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
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;

/* loaded from: classes2.dex */
public class CTRstImpl extends XmlComplexContentImpl implements CTRst {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "t"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "r"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rPh"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "phoneticPr")};
    private static final long serialVersionUID = 1;

    public CTRstImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticPr addNewPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt addNewR() {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun addNewRPh() {
        CTPhoneticRun cTPhoneticRun;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRun = (CTPhoneticRun) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTPhoneticRun;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticPr getPhoneticPr() {
        CTPhoneticPr cTPhoneticPr;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticPr = (CTPhoneticPr) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTPhoneticPr == null) {
                cTPhoneticPr = null;
            }
        }
        return cTPhoneticPr;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt[] getRArray() {
        return (CTRElt[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTRElt[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public List<CTRElt> getRList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.y6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.qh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRArray(((Integer) obj).intValue(), (CTRElt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.la
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeR(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.kg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun[] getRPhArray() {
        return (CTPhoneticRun[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTPhoneticRun[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public List<CTPhoneticRun> getRPhList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRPhArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRPhArray(((Integer) obj).intValue(), (CTPhoneticRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.m
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRPh(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRPh(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.n6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRPhArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public String getT() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt insertNewR(int i2) {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun insertNewRPh(int i2) {
        CTPhoneticRun cTPhoneticRun;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRun = (CTPhoneticRun) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTPhoneticRun;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public boolean isSetPhoneticPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public boolean isSetT() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void removeR(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void removeRPh(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setPhoneticPr(CTPhoneticPr cTPhoneticPr) throws Throwable {
        generatedSetterHelperImpl(cTPhoneticPr, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRArray(CTRElt[] cTREltArr) {
        check_orphaned();
        arraySetterHelper(cTREltArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRPhArray(CTPhoneticRun[] cTPhoneticRunArr) {
        check_orphaned();
        arraySetterHelper(cTPhoneticRunArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setT(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public int sizeOfRPhArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void unsetPhoneticPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void unsetT() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public STXstring xgetT() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void xsetT(STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STXstring sTXstring2 = (STXstring) typeStore.find_element_user(qNameArr[0], 0);
            if (sTXstring2 == null) {
                sTXstring2 = (STXstring) get_store().add_element_user(qNameArr[0]);
            }
            sTXstring2.set(sTXstring);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTRElt getRArray(int i2) {
        CTRElt cTRElt;
        synchronized (monitor()) {
            check_orphaned();
            cTRElt = (CTRElt) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTRElt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRElt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public CTPhoneticRun getRPhArray(int i2) {
        CTPhoneticRun cTPhoneticRun;
        synchronized (monitor()) {
            check_orphaned();
            cTPhoneticRun = (CTPhoneticRun) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTPhoneticRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPhoneticRun;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRArray(int i2, CTRElt cTRElt) throws Throwable {
        generatedSetterHelperImpl(cTRElt, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst
    public void setRPhArray(int i2, CTPhoneticRun cTPhoneticRun) throws Throwable {
        generatedSetterHelperImpl(cTPhoneticRun, PROPERTY_QNAME[2], i2, (short) 2);
    }
}
