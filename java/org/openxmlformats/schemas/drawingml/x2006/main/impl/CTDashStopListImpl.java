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
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList;

/* loaded from: classes2.dex */
public class CTDashStopListImpl extends XmlComplexContentImpl implements CTDashStopList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ds")};
    private static final long serialVersionUID = 1;

    public CTDashStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop addNewDs() {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStop = (CTDashStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop[] getDsArray() {
        return (CTDashStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTDashStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public List<CTDashStop> getDsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l80
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.nw
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDsArray(((Integer) obj).intValue(), (CTDashStop) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.jx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.a30
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.kj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop insertNewDs(int i2) {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStop = (CTDashStop) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void removeDs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void setDsArray(CTDashStop[] cTDashStopArr) {
        check_orphaned();
        arraySetterHelper(cTDashStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public int sizeOfDsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop getDsArray(int i2) {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStop = (CTDashStop) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTDashStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void setDsArray(int i2, CTDashStop cTDashStop) throws Throwable {
        generatedSetterHelperImpl(cTDashStop, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
