package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumPicBullet;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;

/* loaded from: classes3.dex */
public class CTNumberingImpl extends XmlComplexContentImpl implements CTNumbering {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numPicBullet"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "abstractNum"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "num"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "numIdMacAtCleanup")};
    private static final long serialVersionUID = 1;

    public CTNumberingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum addNewAbstractNum() {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum addNewNum() {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber addNewNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet addNewNumPicBullet() {
        CTNumPicBullet cTNumPicBulletAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNumPicBulletAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum[] getAbstractNumArray() {
        return (CTAbstractNum[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTAbstractNum[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTAbstractNum> getAbstractNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ey2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAbstractNumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bz0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAbstractNumArray(((Integer) obj).intValue(), (CTAbstractNum) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.np2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAbstractNum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dv2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAbstractNum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.so2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAbstractNumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum[] getNumArray() {
        return (CTNum[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTNum[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTDecimalNumber getNumIdMacAtCleanup() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNum> getNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.w0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNumArray(((Integer) obj).intValue(), (CTNum) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ro0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cg2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zu
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet[] getNumPicBulletArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTNumPicBullet[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public List<CTNumPicBullet> getNumPicBulletList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vg0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNumPicBulletArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fg0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNumPicBulletArray(((Integer) obj).intValue(), (CTNumPicBullet) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNumPicBullet(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ii
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNumPicBullet(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gy
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNumPicBulletArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum insertNewAbstractNum(int i2) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum insertNewNum(int i2) {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet insertNewNumPicBullet(int i2) {
        CTNumPicBullet cTNumPicBulletInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTNumPicBulletInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public boolean isSetNumIdMacAtCleanup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeAbstractNum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void removeNumPicBullet(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr) {
        check_orphaned();
        arraySetterHelper(cTAbstractNumArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(CTNum[] cTNumArr) {
        check_orphaned();
        arraySetterHelper(cTNumArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTNumPicBulletArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfAbstractNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public int sizeOfNumPicBulletArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void unsetNumIdMacAtCleanup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTAbstractNum getAbstractNumArray(int i2) {
        CTAbstractNum cTAbstractNum;
        synchronized (monitor()) {
            check_orphaned();
            cTAbstractNum = (CTAbstractNum) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTAbstractNum == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAbstractNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNum getNumArray(int i2) {
        CTNum cTNum;
        synchronized (monitor()) {
            check_orphaned();
            cTNum = (CTNum) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTNum == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public CTNumPicBullet getNumPicBulletArray(int i2) {
        CTNumPicBullet cTNumPicBulletFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumPicBulletFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTNumPicBulletFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumPicBulletFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setAbstractNumArray(int i2, CTAbstractNum cTAbstractNum) throws Throwable {
        generatedSetterHelperImpl(cTAbstractNum, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumArray(int i2, CTNum cTNum) throws Throwable {
        generatedSetterHelperImpl(cTNum, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering
    public void setNumPicBulletArray(int i2, CTNumPicBullet cTNumPicBullet) throws Throwable {
        generatedSetterHelperImpl(cTNumPicBullet, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
