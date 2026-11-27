package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase;

/* loaded from: classes3.dex */
public class CTTrPrBaseImpl extends XmlComplexContentImpl implements CTTrPrBase {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "divId"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridBefore"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridAfter"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wBefore"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "wAfter"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cantSplit"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trHeight"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblHeader"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblCellSpacing"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "jc"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hidden")};
    private static final long serialVersionUID = 1;

    public CTTrPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewCantSplit() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf cTCnf;
        synchronized (monitor()) {
            check_orphaned();
            cTCnf = (CTCnf) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCnf;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewDivId() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewGridAfter() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber addNewGridBefore() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJcTable addNewJc() {
        CTJcTable cTJcTable;
        synchronized (monitor()) {
            check_orphaned();
            cTJcTable = (CTJcTable) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTJcTable;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewTblCellSpacing() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff addNewTblHeader() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight addNewTrHeight() {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewWAfter() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth addNewWBefore() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getCantSplitArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getCantSplitList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y61
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCantSplitArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCantSplitArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCantSplit(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCantSplit(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t11
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCantSplitArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf[] getCnfStyleArray() {
        return (CTCnf[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCnf[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTCnf> getCnfStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCnfStyleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nd1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCnfStyleArray(((Integer) obj).intValue(), (CTCnf) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCnfStyle(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e53
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCnfStyle(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCnfStyleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getDivIdArray() {
        return (CTDecimalNumber[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getDivIdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h72
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDivIdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rb0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDivIdArray(((Integer) obj).intValue(), (CTDecimalNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ai0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDivId(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uy2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDivId(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pr3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDivIdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getGridAfterArray() {
        return (CTDecimalNumber[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getGridAfterList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dz2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGridAfterArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wg2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGridAfterArray(((Integer) obj).intValue(), (CTDecimalNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a31
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGridAfter(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l71
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGridAfter(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qa3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGridAfterArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber[] getGridBeforeArray() {
        return (CTDecimalNumber[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTDecimalNumber[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTDecimalNumber> getGridBeforeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n71
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGridBeforeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.al
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGridBeforeArray(((Integer) obj).intValue(), (CTDecimalNumber) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pe2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGridBefore(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jw
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGridBefore(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k23
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGridBeforeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getHiddenArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getHiddenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.iy
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHiddenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kd1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHiddenArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ag2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHidden(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e11
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHidden(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHiddenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJcTable[] getJcArray() {
        return (CTJcTable[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTJcTable[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTJcTable> getJcList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.w52
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getJcArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pm
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setJcArray(((Integer) obj).intValue(), (CTJcTable) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hm0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewJc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fd0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeJc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sb1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfJcArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getTblCellSpacingArray() {
        return (CTTblWidth[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTTblWidth[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getTblCellSpacingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ov0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTblCellSpacingArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yl3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTblCellSpacingArray(((Integer) obj).intValue(), (CTTblWidth) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fp1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTblCellSpacing(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sr2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTblCellSpacing(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fu1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTblCellSpacingArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff[] getTblHeaderArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTOnOff> getTblHeaderList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lq3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTblHeaderArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xs0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTblHeaderArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uh2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTblHeader(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g12
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTblHeader(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fd2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTblHeaderArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight[] getTrHeightArray() {
        return (CTHeight[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTHeight[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTHeight> getTrHeightList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zy0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTrHeightArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i22
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTrHeightArray(((Integer) obj).intValue(), (CTHeight) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.np3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTrHeight(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ew
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTrHeight(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o52
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTrHeightArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getWAfterArray() {
        return (CTTblWidth[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTTblWidth[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getWAfterList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getWAfterArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s20
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setWAfterArray(((Integer) obj).intValue(), (CTTblWidth) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vm2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewWAfter(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ek1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeWAfter(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k63
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfWAfterArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth[] getWBeforeArray() {
        return (CTTblWidth[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTTblWidth[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public List<CTTblWidth> getWBeforeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mz1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getWBeforeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sz
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setWBeforeArray(((Integer) obj).intValue(), (CTTblWidth) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewWBefore(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeWBefore(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bj2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfWBeforeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewCantSplit(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf insertNewCnfStyle(int i2) {
        CTCnf cTCnf;
        synchronized (monitor()) {
            check_orphaned();
            cTCnf = (CTCnf) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCnf;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewDivId(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewGridAfter(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber insertNewGridBefore(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewHidden(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJcTable insertNewJc(int i2) {
        CTJcTable cTJcTable;
        synchronized (monitor()) {
            check_orphaned();
            cTJcTable = (CTJcTable) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTJcTable;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewTblCellSpacing(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff insertNewTblHeader(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight insertNewTrHeight(int i2) {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewWAfter(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth insertNewWBefore(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeCantSplit(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeCnfStyle(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeDivId(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeGridAfter(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeGridBefore(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeHidden(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeJc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTblCellSpacing(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTblHeader(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeTrHeight(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeWAfter(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void removeWBefore(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCantSplitArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCnfStyleArray(CTCnf[] cTCnfArr) {
        check_orphaned();
        arraySetterHelper(cTCnfArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setDivIdArray(CTDecimalNumber[] cTDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper(cTDecimalNumberArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridAfterArray(CTDecimalNumber[] cTDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper(cTDecimalNumberArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridBeforeArray(CTDecimalNumber[] cTDecimalNumberArr) {
        check_orphaned();
        arraySetterHelper(cTDecimalNumberArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setHiddenArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setJcArray(CTJcTable[] cTJcTableArr) {
        check_orphaned();
        arraySetterHelper(cTJcTableArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblCellSpacingArray(CTTblWidth[] cTTblWidthArr) {
        check_orphaned();
        arraySetterHelper(cTTblWidthArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblHeaderArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTrHeightArray(CTHeight[] cTHeightArr) {
        check_orphaned();
        arraySetterHelper(cTHeightArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWAfterArray(CTTblWidth[] cTTblWidthArr) {
        check_orphaned();
        arraySetterHelper(cTTblWidthArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWBeforeArray(CTTblWidth[] cTTblWidthArr) {
        check_orphaned();
        arraySetterHelper(cTTblWidthArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfCantSplitArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfCnfStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfDivIdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfGridAfterArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfGridBeforeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfHiddenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfJcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTblCellSpacingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTblHeaderArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfTrHeightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfWAfterArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public int sizeOfWBeforeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getCantSplitArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTCnf getCnfStyleArray(int i2) {
        CTCnf cTCnf;
        synchronized (monitor()) {
            check_orphaned();
            cTCnf = (CTCnf) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCnf == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCnf;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getDivIdArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getGridAfterArray(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTDecimalNumber getGridBeforeArray(int i2) {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTDecimalNumber == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getHiddenArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTJcTable getJcArray(int i2) {
        CTJcTable cTJcTable;
        synchronized (monitor()) {
            check_orphaned();
            cTJcTable = (CTJcTable) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTJcTable == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTJcTable;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getTblCellSpacingArray(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTOnOff getTblHeaderArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTHeight getTrHeightArray(int i2) {
        CTHeight cTHeight;
        synchronized (monitor()) {
            check_orphaned();
            cTHeight = (CTHeight) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTHeight == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHeight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getWAfterArray(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public CTTblWidth getWBeforeArray(int i2) {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTTblWidth == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCantSplitArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setCnfStyleArray(int i2, CTCnf cTCnf) throws Throwable {
        generatedSetterHelperImpl(cTCnf, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setDivIdArray(int i2, CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridAfterArray(int i2, CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setGridBeforeArray(int i2, CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setHiddenArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setJcArray(int i2, CTJcTable cTJcTable) throws Throwable {
        generatedSetterHelperImpl(cTJcTable, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblCellSpacingArray(int i2, CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTblHeaderArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setTrHeightArray(int i2, CTHeight cTHeight) throws Throwable {
        generatedSetterHelperImpl(cTHeight, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWAfterArray(int i2, CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPrBase
    public void setWBeforeArray(int i2, CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[4], i2, (short) 2);
    }
}
