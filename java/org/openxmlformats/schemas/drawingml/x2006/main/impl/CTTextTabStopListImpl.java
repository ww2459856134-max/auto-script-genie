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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;

/* loaded from: classes2.dex */
public class CTTextTabStopListImpl extends XmlComplexContentImpl implements CTTextTabStopList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tab")};
    private static final long serialVersionUID = 1;

    public CTTextTabStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop addNewTab() {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop[] getTabArray() {
        return (CTTextTabStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTextTabStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public List<CTTextTabStop> getTabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.as
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTabArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.bx
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTabArray(((Integer) obj).intValue(), (CTTextTabStop) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ob0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTab(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ex
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTab(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.f20
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTabArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop insertNewTab(int i2) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void removeTab(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(CTTextTabStop[] cTTextTabStopArr) {
        check_orphaned();
        arraySetterHelper(cTTextTabStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop getTabArray(int i2) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTextTabStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(int i2, CTTextTabStop cTTextTabStop) throws Throwable {
        generatedSetterHelperImpl(cTTextTabStop, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
