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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;

/* loaded from: classes3.dex */
public class CTTblGridBaseImpl extends XmlComplexContentImpl implements CTTblGridBase {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridCol")};
    private static final long serialVersionUID = 1;

    public CTTblGridBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public CTTblGridCol addNewGridCol() {
        CTTblGridCol cTTblGridCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridCol = (CTTblGridCol) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblGridCol;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public CTTblGridCol[] getGridColArray() {
        return (CTTblGridCol[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTblGridCol[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public List<CTTblGridCol> getGridColList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oq1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGridColArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.su
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGridColArray(((Integer) obj).intValue(), (CTTblGridCol) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p12
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGridCol(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oe1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGridCol(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ba3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGridColArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public CTTblGridCol insertNewGridCol(int i2) {
        CTTblGridCol cTTblGridCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridCol = (CTTblGridCol) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTblGridCol;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public void removeGridCol(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public void setGridColArray(CTTblGridCol[] cTTblGridColArr) {
        check_orphaned();
        arraySetterHelper(cTTblGridColArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public int sizeOfGridColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public CTTblGridCol getGridColArray(int i2) {
        CTTblGridCol cTTblGridCol;
        synchronized (monitor()) {
            check_orphaned();
            cTTblGridCol = (CTTblGridCol) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTblGridCol == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblGridCol;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridBase
    public void setGridColArray(int i2, CTTblGridCol cTTblGridCol) throws Throwable {
        generatedSetterHelperImpl(cTTblGridCol, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
