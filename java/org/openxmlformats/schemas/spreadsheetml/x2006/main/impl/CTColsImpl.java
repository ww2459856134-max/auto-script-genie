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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;

/* loaded from: classes2.dex */
public class CTColsImpl extends XmlComplexContentImpl implements CTCols {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "col")};
    private static final long serialVersionUID = 1;

    public CTColsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol addNewCol() {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol[] getColArray() {
        return (CTCol[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCol[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public List<CTCol> getColList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getColArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.n2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setColArray(((Integer) obj).intValue(), (CTCol) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.hc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCol(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCol(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfColArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol insertNewCol(int i2) {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void removeCol(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void setColArray(CTCol[] cTColArr) {
        check_orphaned();
        arraySetterHelper(cTColArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public int sizeOfColArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public CTCol getColArray(int i2) {
        CTCol cTCol;
        synchronized (monitor()) {
            check_orphaned();
            cTCol = (CTCol) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCol == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCol;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols
    public void setColArray(int i2, CTCol cTCol) throws Throwable {
        generatedSetterHelperImpl(cTCol, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
