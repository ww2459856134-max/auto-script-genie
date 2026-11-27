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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableGrid;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* loaded from: classes2.dex */
public class CTTableImpl extends XmlComplexContentImpl implements CTTable {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tblGrid"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tr")};
    private static final long serialVersionUID = 1;

    public CTTableImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableGrid addNewTblGrid() {
        CTTableGrid cTTableGrid;
        synchronized (monitor()) {
            check_orphaned();
            cTTableGrid = (CTTableGrid) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTableGrid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableProperties addNewTblPr() {
        CTTableProperties cTTableProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTableProperties = (CTTableProperties) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow addNewTr() {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableGrid getTblGrid() {
        CTTableGrid cTTableGrid;
        synchronized (monitor()) {
            check_orphaned();
            cTTableGrid = (CTTableGrid) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTableGrid == null) {
                cTTableGrid = null;
            }
        }
        return cTTableGrid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableProperties getTblPr() {
        CTTableProperties cTTableProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTableProperties = (CTTableProperties) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableProperties == null) {
                cTTableProperties = null;
            }
        }
        return cTTableProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow[] getTrArray() {
        return (CTTableRow[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTTableRow[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public List<CTTableRow> getTrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.c70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.ia
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTrArray(((Integer) obj).intValue(), (CTTableRow) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.pi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.o4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.h8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow insertNewTr(int i2) {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public boolean isSetTblPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void removeTr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTblGrid(CTTableGrid cTTableGrid) throws Throwable {
        generatedSetterHelperImpl(cTTableGrid, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTblPr(CTTableProperties cTTableProperties) throws Throwable {
        generatedSetterHelperImpl(cTTableProperties, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTrArray(CTTableRow[] cTTableRowArr) {
        check_orphaned();
        arraySetterHelper(cTTableRowArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public int sizeOfTrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void unsetTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public CTTableRow getTrArray(int i2) {
        CTTableRow cTTableRow;
        synchronized (monitor()) {
            check_orphaned();
            cTTableRow = (CTTableRow) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTTableRow == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTableRow;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTable
    public void setTrArray(int i2, CTTableRow cTTableRow) throws Throwable {
        generatedSetterHelperImpl(cTTableRow, PROPERTY_QNAME[2], i2, (short) 2);
    }
}
