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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews;

/* loaded from: classes2.dex */
public class CTCustomWorkbookViewsImpl extends XmlComplexContentImpl implements CTCustomWorkbookViews {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customWorkbookView")};
    private static final long serialVersionUID = 1;

    public CTCustomWorkbookViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView addNewCustomWorkbookView() {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookView = (CTCustomWorkbookView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView[] getCustomWorkbookViewArray() {
        return (CTCustomWorkbookView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomWorkbookView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public List<CTCustomWorkbookView> getCustomWorkbookViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.s5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomWorkbookViewArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomWorkbookViewArray(((Integer) obj).intValue(), (CTCustomWorkbookView) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.od
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomWorkbookView(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.tb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomWorkbookView(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.g2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomWorkbookViewArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView insertNewCustomWorkbookView(int i2) {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookView = (CTCustomWorkbookView) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void removeCustomWorkbookView(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void setCustomWorkbookViewArray(CTCustomWorkbookView[] cTCustomWorkbookViewArr) {
        check_orphaned();
        arraySetterHelper(cTCustomWorkbookViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public int sizeOfCustomWorkbookViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public CTCustomWorkbookView getCustomWorkbookViewArray(int i2) {
        CTCustomWorkbookView cTCustomWorkbookView;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomWorkbookView = (CTCustomWorkbookView) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCustomWorkbookView == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomWorkbookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews
    public void setCustomWorkbookViewArray(int i2, CTCustomWorkbookView cTCustomWorkbookView) throws Throwable {
        generatedSetterHelperImpl(cTCustomWorkbookView, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
