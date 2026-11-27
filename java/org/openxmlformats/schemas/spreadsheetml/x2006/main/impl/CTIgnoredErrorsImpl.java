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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;

/* loaded from: classes2.dex */
public class CTIgnoredErrorsImpl extends XmlComplexContentImpl implements CTIgnoredErrors {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "ignoredError"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTIgnoredErrorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError addNewIgnoredError() {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError[] getIgnoredErrorArray() {
        return (CTIgnoredError[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTIgnoredError[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public List<CTIgnoredError> getIgnoredErrorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getIgnoredErrorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.w1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setIgnoredErrorArray(((Integer) obj).intValue(), (CTIgnoredError) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ha
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewIgnoredError(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeIgnoredError(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.qe
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfIgnoredErrorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError insertNewIgnoredError(int i2) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
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

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void removeIgnoredError(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(CTIgnoredError[] cTIgnoredErrorArr) {
        check_orphaned();
        arraySetterHelper(cTIgnoredErrorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public int sizeOfIgnoredErrorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public CTIgnoredError getIgnoredErrorArray(int i2) {
        CTIgnoredError cTIgnoredError;
        synchronized (monitor()) {
            check_orphaned();
            cTIgnoredError = (CTIgnoredError) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTIgnoredError == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIgnoredError;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors
    public void setIgnoredErrorArray(int i2, CTIgnoredError cTIgnoredError) throws Throwable {
        generatedSetterHelperImpl(cTIgnoredError, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
