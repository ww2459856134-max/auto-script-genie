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
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* loaded from: classes3.dex */
public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "anchor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "inline")};
    private static final long serialVersionUID = 1;

    public CTDrawingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor addNewAnchor() {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchor = (CTAnchor) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline addNewInline() {
        CTInline cTInline;
        synchronized (monitor()) {
            check_orphaned();
            cTInline = (CTInline) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor[] getAnchorArray() {
        return (CTAnchor[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTAnchor[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTAnchor> getAnchorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnchorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r60
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnchorArray(((Integer) obj).intValue(), (CTAnchor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j41
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnchor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b20
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnchor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j12
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnchorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline[] getInlineArray() {
        return (CTInline[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTInline[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTInline> getInlineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v32
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInlineArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ff0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInlineArray(((Integer) obj).intValue(), (CTInline) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInline(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInline(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yr0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInlineArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor insertNewAnchor(int i2) {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchor = (CTAnchor) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline insertNewInline(int i2) {
        CTInline cTInline;
        synchronized (monitor()) {
            check_orphaned();
            cTInline = (CTInline) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeAnchor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeInline(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(CTAnchor[] cTAnchorArr) {
        check_orphaned();
        arraySetterHelper(cTAnchorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(CTInline[] cTInlineArr) {
        check_orphaned();
        arraySetterHelper(cTInlineArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfInlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor getAnchorArray(int i2) {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchor = (CTAnchor) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTAnchor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline getInlineArray(int i2) {
        CTInline cTInline;
        synchronized (monitor()) {
            check_orphaned();
            cTInline = (CTInline) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTInline == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(int i2, CTAnchor cTAnchor) throws Throwable {
        generatedSetterHelperImpl(cTAnchor, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(int i2, CTInline cTInline) throws Throwable {
        generatedSetterHelperImpl(cTInline, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
