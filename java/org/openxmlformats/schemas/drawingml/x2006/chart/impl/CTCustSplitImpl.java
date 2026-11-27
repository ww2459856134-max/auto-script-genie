package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* loaded from: classes2.dex */
public class CTCustSplitImpl extends XmlComplexContentImpl implements CTCustSplit {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "secondPiePt")};
    private static final long serialVersionUID = 1;

    public CTCustSplitImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt addNewSecondPiePt() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt[] getSecondPiePtArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public List<CTUnsignedInt> getSecondPiePtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.o6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSecondPiePtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSecondPiePtArray(((Integer) obj).intValue(), (CTUnsignedInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.a6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSecondPiePt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSecondPiePt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSecondPiePtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt insertNewSecondPiePt(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void removeSecondPiePt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void setSecondPiePtArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public int sizeOfSecondPiePtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt getSecondPiePtArray(int i2) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void setSecondPiePtArray(int i2, CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
