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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;

/* loaded from: classes2.dex */
public class CTGradientStopListImpl extends XmlComplexContentImpl implements CTGradientStopList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gs")};
    private static final long serialVersionUID = 1;

    public CTGradientStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop addNewGs() {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop[] getGsArray() {
        return (CTGradientStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTGradientStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public List<CTGradientStop> getGsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.wc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.dq
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGsArray(((Integer) obj).intValue(), (CTGradientStop) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.fs
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ar
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop insertNewGs(int i2) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void removeGs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(CTGradientStop[] cTGradientStopArr) {
        check_orphaned();
        arraySetterHelper(cTGradientStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public int sizeOfGsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop getGsArray(int i2) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTGradientStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(int i2, CTGradientStop cTGradientStop) throws Throwable {
        generatedSetterHelperImpl(cTGradientStop, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
