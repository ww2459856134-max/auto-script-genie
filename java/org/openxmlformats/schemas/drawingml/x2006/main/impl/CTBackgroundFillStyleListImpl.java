package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;

/* loaded from: classes2.dex */
public class CTBackgroundFillStyleListImpl extends XmlComplexContentImpl implements CTBackgroundFillStyleList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "noFill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gradFill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blipFill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pattFill"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpFill")};
    private static final long serialVersionUID = 1;

    public CTBackgroundFillStyleListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties[] getBlipFillArray() {
        return (CTBlipFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTBlipFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTBlipFillProperties> getBlipFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBlipFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.iq
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBlipFillArray(((Integer) obj).intValue(), (CTBlipFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qu
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBlipFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zx
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBlipFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBlipFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties[] getGradFillArray() {
        return (CTGradientFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTGradientFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTGradientFillProperties> getGradFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.eg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGradFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.gu
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGradFillArray(((Integer) obj).intValue(), (CTGradientFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.r30
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGradFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xf
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGradFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGradFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties[] getGrpFillArray() {
        return (CTGroupFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTGroupFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTGroupFillProperties> getGrpFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGrpFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.cb0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGrpFillArray(((Integer) obj).intValue(), (CTGroupFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.md
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGrpFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.uc0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGrpFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sx
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGrpFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties[] getNoFillArray() {
        return (CTNoFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTNoFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTNoFillProperties> getNoFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.x90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNoFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pb0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNoFillArray(((Integer) obj).intValue(), (CTNoFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.w7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNoFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.op
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNoFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.p30
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNoFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties[] getPattFillArray() {
        return (CTPatternFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTPatternFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTPatternFillProperties> getPattFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPattFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nc0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPattFillArray(((Integer) obj).intValue(), (CTPatternFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPattFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.n50
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePattFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.g70
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPattFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties[] getSolidFillArray() {
        return (CTSolidColorFillProperties[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTSolidColorFillProperties[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public List<CTSolidColorFillProperties> getSolidFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.lv
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSolidFillArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.zb0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSolidFillArray(((Integer) obj).intValue(), (CTSolidColorFillProperties) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pr
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSolidFill(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSolidFill(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ik
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSolidFillArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties insertNewBlipFill(int i2) {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties insertNewGradFill(int i2) {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties insertNewGrpFill(int i2) {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties insertNewNoFill(int i2) {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties insertNewPattFill(int i2) {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties insertNewSolidFill(int i2) {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeBlipFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeGradFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeGrpFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeNoFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removePattFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void removeSolidFill(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setBlipFillArray(CTBlipFillProperties[] cTBlipFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTBlipFillPropertiesArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGradFillArray(CTGradientFillProperties[] cTGradientFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTGradientFillPropertiesArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGrpFillArray(CTGroupFillProperties[] cTGroupFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTGroupFillPropertiesArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setNoFillArray(CTNoFillProperties[] cTNoFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTNoFillPropertiesArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setPattFillArray(CTPatternFillProperties[] cTPatternFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTPatternFillPropertiesArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setSolidFillArray(CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr) {
        check_orphaned();
        arraySetterHelper(cTSolidColorFillPropertiesArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfBlipFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfGradFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfGrpFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfNoFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfPattFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public int sizeOfSolidFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTBlipFillProperties getBlipFillArray(int i2) {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTBlipFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGradientFillProperties getGradFillArray(int i2) {
        CTGradientFillProperties cTGradientFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillProperties = (CTGradientFillProperties) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTGradientFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGradientFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTGroupFillProperties getGrpFillArray(int i2) {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTGroupFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTNoFillProperties getNoFillArray(int i2) {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTNoFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTPatternFillProperties getPattFillArray(int i2) {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTPatternFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public CTSolidColorFillProperties getSolidFillArray(int i2) {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTSolidColorFillProperties == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setBlipFillArray(int i2, CTBlipFillProperties cTBlipFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTBlipFillProperties, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGradFillArray(int i2, CTGradientFillProperties cTGradientFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTGradientFillProperties, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setGrpFillArray(int i2, CTGroupFillProperties cTGroupFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTGroupFillProperties, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setNoFillArray(int i2, CTNoFillProperties cTNoFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTNoFillProperties, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setPattFillArray(int i2, CTPatternFillProperties cTPatternFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTPatternFillProperties, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList
    public void setSolidFillArray(int i2, CTSolidColorFillProperties cTSolidColorFillProperties) throws Throwable {
        generatedSetterHelperImpl(cTSolidColorFillProperties, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
