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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;

/* loaded from: classes2.dex */
public class CTCalcChainImpl extends XmlComplexContentImpl implements CTCalcChain {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "c"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTCalcChainImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell addNewC() {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell[] getCArray() {
        return (CTCalcCell[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCalcCell[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public List<CTCalcCell> getCList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.wc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCArray(((Integer) obj).intValue(), (CTCalcCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.hf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewC(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeC(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell insertNewC(int i2) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void removeC(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(CTCalcCell[] cTCalcCellArr) {
        check_orphaned();
        arraySetterHelper(cTCalcCellArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public int sizeOfCArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public CTCalcCell getCArray(int i2) {
        CTCalcCell cTCalcCell;
        synchronized (monitor()) {
            check_orphaned();
            cTCalcCell = (CTCalcCell) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCalcCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCalcCell;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain
    public void setCArray(int i2, CTCalcCell cTCalcCell) throws Throwable {
        generatedSetterHelperImpl(cTCalcCell, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
