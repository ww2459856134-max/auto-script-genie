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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRange;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges;

/* loaded from: classes2.dex */
public class CTProtectedRangesImpl extends XmlComplexContentImpl implements CTProtectedRanges {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "protectedRange")};
    private static final long serialVersionUID = 1;

    public CTProtectedRangesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange addNewProtectedRange() {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRange = (CTProtectedRange) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange[] getProtectedRangeArray() {
        return (CTProtectedRange[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTProtectedRange[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public List<CTProtectedRange> getProtectedRangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getProtectedRangeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.xj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setProtectedRangeArray(((Integer) obj).intValue(), (CTProtectedRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.f9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProtectedRange(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProtectedRange(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ck
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfProtectedRangeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange insertNewProtectedRange(int i2) {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRange = (CTProtectedRange) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void removeProtectedRange(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void setProtectedRangeArray(CTProtectedRange[] cTProtectedRangeArr) {
        check_orphaned();
        arraySetterHelper(cTProtectedRangeArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public int sizeOfProtectedRangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange getProtectedRangeArray(int i2) {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRange = (CTProtectedRange) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTProtectedRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void setProtectedRangeArray(int i2, CTProtectedRange cTProtectedRange) throws Throwable {
        generatedSetterHelperImpl(cTProtectedRange, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
