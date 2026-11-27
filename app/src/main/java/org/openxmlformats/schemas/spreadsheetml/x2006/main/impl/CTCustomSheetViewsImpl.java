package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews;

/* loaded from: classes2.dex */
public class CTCustomSheetViewsImpl extends XmlComplexContentImpl implements CTCustomSheetViews {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customSheetView")};
    private static final long serialVersionUID = 1;

    public CTCustomSheetViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView addNewCustomSheetView() {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetView = (CTCustomSheetView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView[] getCustomSheetViewArray() {
        return (CTCustomSheetView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomSheetView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public List<CTCustomSheetView> getCustomSheetViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.d1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomSheetViewArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ae
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomSheetViewArray(((Integer) obj).intValue(), (CTCustomSheetView) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomSheetView(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.lf
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomSheetView(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.dj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomSheetViewArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView insertNewCustomSheetView(int i2) {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetView = (CTCustomSheetView) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void removeCustomSheetView(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void setCustomSheetViewArray(CTCustomSheetView[] cTCustomSheetViewArr) {
        check_orphaned();
        arraySetterHelper(cTCustomSheetViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public int sizeOfCustomSheetViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public CTCustomSheetView getCustomSheetViewArray(int i2) {
        CTCustomSheetView cTCustomSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomSheetView = (CTCustomSheetView) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCustomSheetView == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetViews
    public void setCustomSheetViewArray(int i2, CTCustomSheetView cTCustomSheetView) throws Throwable {
        generatedSetterHelperImpl(cTCustomSheetView, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
