package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;

/* loaded from: classes2.dex */
public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "twoCellAnchor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "oneCellAnchor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "absoluteAnchor")};
    private static final long serialVersionUID = 1;

    public CTDrawingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor addNewAbsoluteAnchor() {
        CTAbsoluteAnchor cTAbsoluteAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAbsoluteAnchor = (CTAbsoluteAnchor) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAbsoluteAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor addNewOneCellAnchor() {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor addNewTwoCellAnchor() {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor[] getAbsoluteAnchorArray() {
        return (CTAbsoluteAnchor[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTAbsoluteAnchor[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTAbsoluteAnchor> getAbsoluteAnchorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAbsoluteAnchorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.f0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAbsoluteAnchorArray(((Integer) obj).intValue(), (CTAbsoluteAnchor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.b0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAbsoluteAnchor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.c0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAbsoluteAnchor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.k0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAbsoluteAnchorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor[] getOneCellAnchorArray() {
        return (CTOneCellAnchor[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTOneCellAnchor[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTOneCellAnchor> getOneCellAnchorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.l0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOneCellAnchorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.f
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOneCellAnchorArray(((Integer) obj).intValue(), (CTOneCellAnchor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.j0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOneCellAnchor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOneCellAnchor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.j
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOneCellAnchorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor[] getTwoCellAnchorArray() {
        return (CTTwoCellAnchor[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTwoCellAnchor[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public List<CTTwoCellAnchor> getTwoCellAnchorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.x
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTwoCellAnchorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.g0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTwoCellAnchorArray(((Integer) obj).intValue(), (CTTwoCellAnchor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.l
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTwoCellAnchor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTwoCellAnchor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.o
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTwoCellAnchorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor insertNewAbsoluteAnchor(int i2) {
        CTAbsoluteAnchor cTAbsoluteAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAbsoluteAnchor = (CTAbsoluteAnchor) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTAbsoluteAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor insertNewOneCellAnchor(int i2) {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor insertNewTwoCellAnchor(int i2) {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeAbsoluteAnchor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeOneCellAnchor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void removeTwoCellAnchor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setAbsoluteAnchorArray(CTAbsoluteAnchor[] cTAbsoluteAnchorArr) {
        check_orphaned();
        arraySetterHelper(cTAbsoluteAnchorArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setOneCellAnchorArray(CTOneCellAnchor[] cTOneCellAnchorArr) {
        check_orphaned();
        arraySetterHelper(cTOneCellAnchorArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setTwoCellAnchorArray(CTTwoCellAnchor[] cTTwoCellAnchorArr) {
        check_orphaned();
        arraySetterHelper(cTTwoCellAnchorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfAbsoluteAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfOneCellAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public int sizeOfTwoCellAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTAbsoluteAnchor getAbsoluteAnchorArray(int i2) {
        CTAbsoluteAnchor cTAbsoluteAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAbsoluteAnchor = (CTAbsoluteAnchor) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTAbsoluteAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAbsoluteAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTOneCellAnchor getOneCellAnchorArray(int i2) {
        CTOneCellAnchor cTOneCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTOneCellAnchor = (CTOneCellAnchor) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTOneCellAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOneCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public CTTwoCellAnchor getTwoCellAnchorArray(int i2) {
        CTTwoCellAnchor cTTwoCellAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTTwoCellAnchor = (CTTwoCellAnchor) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTwoCellAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTwoCellAnchor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setAbsoluteAnchorArray(int i2, CTAbsoluteAnchor cTAbsoluteAnchor) throws Throwable {
        generatedSetterHelperImpl(cTAbsoluteAnchor, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setOneCellAnchorArray(int i2, CTOneCellAnchor cTOneCellAnchor) throws Throwable {
        generatedSetterHelperImpl(cTOneCellAnchor, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTDrawing
    public void setTwoCellAnchorArray(int i2, CTTwoCellAnchor cTTwoCellAnchor) throws Throwable {
        generatedSetterHelperImpl(cTTwoCellAnchor, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
