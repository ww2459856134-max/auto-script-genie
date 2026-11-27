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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFDDList;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFHelpText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFStatusText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMacroName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnsignedDecimalNumber;

/* loaded from: classes3.dex */
public class CTFFDataImpl extends XmlComplexContentImpl implements CTFFData {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "label"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tabIndex"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "enabled"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "calcOnExit"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "entryMacro"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "exitMacro"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "helpText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "statusText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "checkBox"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ddList"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textInput")};
    private static final long serialVersionUID = 1;

    public CTFFDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewCalcOnExit() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox addNewCheckBox() {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList addNewDdList() {
        CTFFDDList cTFFDDListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTFFDDListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff addNewEnabled() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewEntryMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName addNewExitMacro() {
        CTMacroName cTMacroNameAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTMacroNameAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText addNewHelpText() {
        CTFFHelpText cTFFHelpTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTFFHelpTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber addNewLabel() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName addNewName() {
        CTFFName cTFFName;
        synchronized (monitor()) {
            check_orphaned();
            cTFFName = (CTFFName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText addNewStatusText() {
        CTFFStatusText cTFFStatusTextAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTFFStatusTextAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber addNewTabIndex() {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTUnsignedDecimalNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput addNewTextInput() {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInput = (CTFFTextInput) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getCalcOnExitArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getCalcOnExitList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f92
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCalcOnExitArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x51
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCalcOnExitArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k31
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCalcOnExit(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ks3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCalcOnExit(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v72
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCalcOnExitArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox[] getCheckBoxArray() {
        return (CTFFCheckBox[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTFFCheckBox[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFCheckBox> getCheckBoxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCheckBoxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.es3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCheckBoxArray(((Integer) obj).intValue(), (CTFFCheckBox) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fg1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCheckBox(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h33
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCheckBox(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yc1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCheckBoxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList[] getDdListArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTFFDDList[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFDDList> getDdListList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.eb2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDdListArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.em2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDdListArray(((Integer) obj).intValue(), (CTFFDDList) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hx0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDdList(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h42
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDdList(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jl0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDdListArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff[] getEnabledArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTOnOff> getEnabledList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ms1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEnabledArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z22
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEnabledArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEnabled(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEnabled(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kq3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEnabledArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getEntryMacroArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTMacroName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getEntryMacroList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yk3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEntryMacroArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ph1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEntryMacroArray(((Integer) obj).intValue(), (CTMacroName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.d21
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEntryMacro(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kp1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEntryMacro(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ql1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEntryMacroArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName[] getExitMacroArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTMacroName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTMacroName> getExitMacroList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExitMacroArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u62
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExitMacroArray(((Integer) obj).intValue(), (CTMacroName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.me1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExitMacro(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uy1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExitMacro(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jt1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExitMacroArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText[] getHelpTextArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTFFHelpText[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFHelpText> getHelpTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ln
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHelpTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i30
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHelpTextArray(((Integer) obj).intValue(), (CTFFHelpText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHelpText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ne2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHelpText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c31
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHelpTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber[] getLabelArray() {
        return (CTDecimalNumber[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTDecimalNumber> getLabelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.st3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLabelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ld2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLabelArray(((Integer) obj).intValue(), (CTDecimalNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nq1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLabel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o23
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLabel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mv1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLabelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName[] getNameArray() {
        return (CTFFName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTFFName[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFName> getNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.it3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNameArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i01
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNameArray(((Integer) obj).intValue(), (CTFFName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mb2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewName(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fm1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeName(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gy2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNameArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText[] getStatusTextArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTFFStatusText[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFStatusText> getStatusTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qc1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getStatusTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zn3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setStatusTextArray(((Integer) obj).intValue(), (CTFFStatusText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.at1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewStatusText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ms0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeStatusText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gi0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfStatusTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber[] getTabIndexArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTUnsignedDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTUnsignedDecimalNumber> getTabIndexList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTabIndexArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tq2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTabIndexArray(((Integer) obj).intValue(), (CTUnsignedDecimalNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kz1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTabIndex(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c03
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTabIndex(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ug2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTabIndexArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput[] getTextInputArray() {
        return (CTFFTextInput[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTFFTextInput[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public List<CTFFTextInput> getTextInputList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTextInputArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zx0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTextInputArray(((Integer) obj).intValue(), (CTFFTextInput) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ie2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTextInput(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTextInput(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ar3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTextInputArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewCalcOnExit(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox insertNewCheckBox(int i2) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList insertNewDdList(int i2) {
        CTFFDDList cTFFDDListInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTFFDDListInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff insertNewEnabled(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewEntryMacro(int i2) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName insertNewExitMacro(int i2) {
        CTMacroName cTMacroNameInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTMacroNameInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText insertNewHelpText(int i2) {
        CTFFHelpText cTFFHelpTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTFFHelpTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber insertNewLabel(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName insertNewName(int i2) {
        CTFFName cTFFName;
        synchronized (monitor()) {
            check_orphaned();
            cTFFName = (CTFFName) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText insertNewStatusText(int i2) {
        CTFFStatusText cTFFStatusTextInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTFFStatusTextInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber insertNewTabIndex(int i2) {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTUnsignedDecimalNumberInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput insertNewTextInput(int i2) {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInput = (CTFFTextInput) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCalcOnExit(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeCheckBox(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeDdList(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEnabled(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeEntryMacro(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeExitMacro(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeHelpText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeLabel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeName(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeStatusText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTabIndex(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void removeTextInput(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr) {
        check_orphaned();
        arraySetterHelper(cTFFCheckBoxArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(CTFFDDList[] cTFFDDListArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFDDListArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(CTMacroName[] cTMacroNameArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTMacroNameArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(CTMacroName[] cTMacroNameArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTMacroNameArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFHelpTextArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setLabelArray(CTDecimalNumber[] cTDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper(cTDecimalNumberArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(CTFFName[] cTFFNameArr) {
        check_orphaned();
        arraySetterHelper(cTFFNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFFStatusTextArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTabIndexArray(CTUnsignedDecimalNumber[] cTUnsignedDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTUnsignedDecimalNumberArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(CTFFTextInput[] cTFFTextInputArr) {
        check_orphaned();
        arraySetterHelper(cTFFTextInputArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCalcOnExitArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfCheckBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfDdListArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEnabledArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfEntryMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfExitMacroArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfHelpTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfLabelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfStatusTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTabIndexArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public int sizeOfTextInputArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getCalcOnExitArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFCheckBox getCheckBoxArray(int i2) {
        CTFFCheckBox cTFFCheckBox;
        synchronized (monitor()) {
            check_orphaned();
            cTFFCheckBox = (CTFFCheckBox) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTFFCheckBox == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFCheckBox;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFDDList getDdListArray(int i2) {
        CTFFDDList cTFFDDListFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFDDListFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTFFDDListFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFDDListFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTOnOff getEnabledArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getEntryMacroArray(int i2) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTMacroName getExitMacroArray(int i2) {
        CTMacroName cTMacroNameFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMacroNameFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTMacroNameFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMacroNameFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFHelpText getHelpTextArray(int i2) {
        CTFFHelpText cTFFHelpTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFHelpTextFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTFFHelpTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFHelpTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTDecimalNumber getLabelArray(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFName getNameArray(int i2) {
        CTFFName cTFFName;
        synchronized (monitor()) {
            check_orphaned();
            cTFFName = (CTFFName) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTFFName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFName;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFStatusText getStatusTextArray(int i2) {
        CTFFStatusText cTFFStatusTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFFStatusTextFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTFFStatusTextFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFStatusTextFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTUnsignedDecimalNumber getTabIndexArray(int i2) {
        CTUnsignedDecimalNumber cTUnsignedDecimalNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedDecimalNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTUnsignedDecimalNumberFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedDecimalNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public CTFFTextInput getTextInputArray(int i2) {
        CTFFTextInput cTFFTextInput;
        synchronized (monitor()) {
            check_orphaned();
            cTFFTextInput = (CTFFTextInput) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTFFTextInput == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFFTextInput;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCalcOnExitArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setCheckBoxArray(int i2, CTFFCheckBox cTFFCheckBox) throws Throwable {
        generatedSetterHelperImpl(cTFFCheckBox, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setDdListArray(int i2, CTFFDDList cTFFDDList) throws Throwable {
        generatedSetterHelperImpl(cTFFDDList, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEnabledArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setEntryMacroArray(int i2, CTMacroName cTMacroName) throws Throwable {
        generatedSetterHelperImpl(cTMacroName, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setExitMacroArray(int i2, CTMacroName cTMacroName) throws Throwable {
        generatedSetterHelperImpl(cTMacroName, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setHelpTextArray(int i2, CTFFHelpText cTFFHelpText) throws Throwable {
        generatedSetterHelperImpl(cTFFHelpText, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setLabelArray(int i2, CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setNameArray(int i2, CTFFName cTFFName) throws Throwable {
        generatedSetterHelperImpl(cTFFName, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setStatusTextArray(int i2, CTFFStatusText cTFFStatusText) throws Throwable {
        generatedSetterHelperImpl(cTFFStatusText, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTabIndexArray(int i2, CTUnsignedDecimalNumber cTUnsignedDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedDecimalNumber, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFData
    public void setTextInputArray(int i2, CTFFTextInput cTFFTextInput) throws Throwable {
        generatedSetterHelperImpl(cTFFTextInput, PROPERTY_QNAME[11], i2, (short) 2);
    }
}
