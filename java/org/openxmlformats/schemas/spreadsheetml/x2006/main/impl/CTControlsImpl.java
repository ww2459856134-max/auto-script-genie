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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls;

/* loaded from: classes2.dex */
public class CTControlsImpl extends XmlComplexContentImpl implements CTControls {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "control")};
    private static final long serialVersionUID = 1;

    public CTControlsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl addNewControl() {
        CTControl cTControl;
        synchronized (monitor()) {
            check_orphaned();
            cTControl = (CTControl) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl[] getControlArray() {
        return (CTControl[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTControl[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public List<CTControl> getControlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.si
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getControlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.pi
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setControlArray(((Integer) obj).intValue(), (CTControl) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewControl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ge
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeControl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.oa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfControlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl insertNewControl(int i2) {
        CTControl cTControl;
        synchronized (monitor()) {
            check_orphaned();
            cTControl = (CTControl) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void removeControl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void setControlArray(CTControl[] cTControlArr) {
        check_orphaned();
        arraySetterHelper(cTControlArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public int sizeOfControlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl getControlArray(int i2) {
        CTControl cTControl;
        synchronized (monitor()) {
            check_orphaned();
            cTControl = (CTControl) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTControl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void setControlArray(int i2, CTControl cTControl) throws Throwable {
        generatedSetterHelperImpl(cTControl, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
