package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBoolean;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDateTime;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMissing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumber;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTString;

/* loaded from: classes2.dex */
public class CTSharedItemsImpl extends XmlComplexContentImpl implements CTSharedItems {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "m"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "n"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "e"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "s"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "d"), new QName("", "containsSemiMixedTypes"), new QName("", "containsNonDate"), new QName("", "containsDate"), new QName("", "containsString"), new QName("", "containsBlank"), new QName("", "containsMixedTypes"), new QName("", "containsNumber"), new QName("", "containsInteger"), new QName("", "minValue"), new QName("", "maxValue"), new QName("", "minDate"), new QName("", "maxDate"), new QName("", "count"), new QName("", "longText")};
    private static final long serialVersionUID = 1;

    public CTSharedItemsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean addNewB() {
        CTBoolean cTBooleanAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBooleanAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime addNewD() {
        CTDateTime cTDateTimeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDateTimeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError addNewE() {
        CTError cTErrorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTErrorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing addNewM() {
        CTMissing cTMissingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMissingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber addNewN() {
        CTNumber cTNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString addNewS() {
        CTString cTStringAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTStringAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean[] getBArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTBoolean[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTBoolean> getBList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ic
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBArray(((Integer) obj).intValue(), (CTBoolean) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.gc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewB(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ua
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeB(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.tf
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsBlank() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[10]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsDate() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[8]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsInteger() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[13]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsMixedTypes() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[11]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNonDate() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[7]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsNumber() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[12]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsSemiMixedTypes() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[6]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getContainsString() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public long getCount() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[18]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime[] getDArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTDateTime[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTDateTime> getDList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.h4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ik
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDArray(((Integer) obj).intValue(), (CTDateTime) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.da
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewD(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.kh
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeD(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError[] getEArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTError[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTError> getEList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.yg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.jg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEArray(((Integer) obj).intValue(), (CTError) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewE(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.n5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeE(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.cc
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean getLongText() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[19]);
            }
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing[] getMArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTMissing[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTMissing> getMList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMArray(((Integer) obj).intValue(), (CTMissing) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.a4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewM(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.p4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeM(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMaxDate() {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[17]);
            calendarValue = simpleValue == null ? null : simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMaxValue() {
        double doubleValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            doubleValue = simpleValue == null ? 0.0d : simpleValue.getDoubleValue();
        }
        return doubleValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public Calendar getMinDate() {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[16]);
            calendarValue = simpleValue == null ? null : simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public double getMinValue() {
        double doubleValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[14]);
            doubleValue = simpleValue == null ? 0.0d : simpleValue.getDoubleValue();
        }
        return doubleValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber[] getNArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTNumber[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTNumber> getNList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNArray(((Integer) obj).intValue(), (CTNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.xd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewN(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.r9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeN(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.fd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString[] getSArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTString[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public List<CTString> getSList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.mh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.me
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSArray(((Integer) obj).intValue(), (CTString) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.pj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewS(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.u5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeS(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.fk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean insertNewB(int i2) {
        CTBoolean cTBooleanInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTBooleanInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime insertNewD(int i2) {
        CTDateTime cTDateTimeInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTDateTimeInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError insertNewE(int i2) {
        CTError cTErrorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTErrorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing insertNewM(int i2) {
        CTMissing cTMissingInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTMissingInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber insertNewN(int i2) {
        CTNumber cTNumberInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTNumberInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString insertNewS(int i2) {
        CTString cTStringInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTStringInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsBlank() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[10]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[8]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsInteger() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[11]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNonDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[7]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsNumber() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsSemiMixedTypes() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[6]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetContainsString() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetLongText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMaxValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinDate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public boolean isSetMinValue() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeB(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeD(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeE(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeM(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeN(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void removeS(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(CTBoolean[] cTBooleanArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBooleanArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsBlank(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsInteger(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNonDate(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsNumber(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsSemiMixedTypes(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setContainsString(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setCount(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(CTDateTime[] cTDateTimeArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTDateTimeArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(CTError[] cTErrorArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTErrorArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setLongText(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
            }
            simpleValue.setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(CTMissing[] cTMissingArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTMissingArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMaxValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
            }
            simpleValue.setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMinValue(double d) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
            }
            simpleValue.setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(CTNumber[] cTNumberArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTNumberArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(CTString[] cTStringArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTStringArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfBArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfEArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfNArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public int sizeOfSArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsBlank() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsInteger() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNonDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsNumber() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsSemiMixedTypes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetContainsString() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetLongText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMaxValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void unsetMinValue() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsBlank() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[10]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsDate() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[8]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsInteger() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[13]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[13]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsMixedTypes() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[11]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNonDate() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[7]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsNumber() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[12]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[12]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsSemiMixedTypes() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[6]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetContainsString() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[9]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlUnsignedInt xgetCount() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[18]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlBoolean xgetLongText() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qNameArr[19]);
            if (xmlBoolean == null) {
                xmlBoolean = (XmlBoolean) get_default_attribute_value(qNameArr[19]);
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMaxDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_attribute_user(PROPERTY_QNAME[17]);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMaxValue() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDateTime xgetMinDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_attribute_user(PROPERTY_QNAME[16]);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public XmlDouble xgetMinValue() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_attribute_user(PROPERTY_QNAME[14]);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsBlank(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[10]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[10]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[8]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[8]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsInteger(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[13]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[13]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[11]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[11]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNonDate(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[7]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[7]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsNumber(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[12]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[12]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[6]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[6]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetContainsString(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[9]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[9]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetCount(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[18]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[18]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetLongText(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[19]);
            if (xmlBoolean2 == null) {
                xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[19]);
            }
            xmlBoolean2.set(xmlBoolean);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_attribute_user(qNameArr[17]);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_attribute_user(qNameArr[17]);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMaxValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qNameArr[15]);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qNameArr[15]);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinDate(XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlDateTime xmlDateTime2 = (XmlDateTime) typeStore.find_attribute_user(qNameArr[16]);
            if (xmlDateTime2 == null) {
                xmlDateTime2 = (XmlDateTime) get_store().add_attribute_user(qNameArr[16]);
            }
            xmlDateTime2.set(xmlDateTime);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void xsetMinValue(XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlDouble xmlDouble2 = (XmlDouble) typeStore.find_attribute_user(qNameArr[14]);
            if (xmlDouble2 == null) {
                xmlDouble2 = (XmlDouble) get_store().add_attribute_user(qNameArr[14]);
            }
            xmlDouble2.set(xmlDouble);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTBoolean getBArray(int i2) {
        CTBoolean cTBooleanFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTBooleanFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTDateTime getDArray(int i2) {
        CTDateTime cTDateTimeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDateTimeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTDateTimeFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDateTimeFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTError getEArray(int i2) {
        CTError cTErrorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTErrorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTErrorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTErrorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTMissing getMArray(int i2) {
        CTMissing cTMissingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMissingFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTMissingFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMissingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTNumber getNArray(int i2) {
        CTNumber cTNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public CTString getSArray(int i2) {
        CTString cTStringFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTStringFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTStringFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTStringFind_element_user;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setBArray(int i2, CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setDArray(int i2, CTDateTime cTDateTime) throws Throwable {
        generatedSetterHelperImpl(cTDateTime, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setEArray(int i2, CTError cTError) throws Throwable {
        generatedSetterHelperImpl(cTError, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setMArray(int i2, CTMissing cTMissing) throws Throwable {
        generatedSetterHelperImpl(cTMissing, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setNArray(int i2, CTNumber cTNumber) throws Throwable {
        generatedSetterHelperImpl(cTNumber, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSharedItems
    public void setSArray(int i2, CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[4], i2, (short) 2);
    }
}
