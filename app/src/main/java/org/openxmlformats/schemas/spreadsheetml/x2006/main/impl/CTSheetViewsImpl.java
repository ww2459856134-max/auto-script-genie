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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;

/* loaded from: classes2.dex */
public class CTSheetViewsImpl extends XmlComplexContentImpl implements CTSheetViews {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheetView"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTSheetViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView addNewSheetView() {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView[] getSheetViewArray() {
        return (CTSheetView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTSheetView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public List<CTSheetView> getSheetViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.he
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSheetViewArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.l1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSheetViewArray(((Integer) obj).intValue(), (CTSheetView) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ok
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSheetView(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSheetView(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ug
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSheetViewArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView insertNewSheetView(int i2) {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void removeSheetView(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setSheetViewArray(CTSheetView[] cTSheetViewArr) {
        check_orphaned();
        arraySetterHelper(cTSheetViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public int sizeOfSheetViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public CTSheetView getSheetViewArray(int i2) {
        CTSheetView cTSheetView;
        synchronized (monitor()) {
            check_orphaned();
            cTSheetView = (CTSheetView) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTSheetView == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSheetView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews
    public void setSheetViewArray(int i2, CTSheetView cTSheetView) throws Throwable {
        generatedSetterHelperImpl(cTSheetView, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
