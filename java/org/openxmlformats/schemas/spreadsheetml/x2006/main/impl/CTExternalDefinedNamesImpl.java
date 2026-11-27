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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames;

/* loaded from: classes2.dex */
public class CTExternalDefinedNamesImpl extends XmlComplexContentImpl implements CTExternalDefinedNames {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedName")};
    private static final long serialVersionUID = 1;

    public CTExternalDefinedNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public CTExternalDefinedName addNewDefinedName() {
        CTExternalDefinedName cTExternalDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedName = (CTExternalDefinedName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public CTExternalDefinedName[] getDefinedNameArray() {
        return (CTExternalDefinedName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalDefinedName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public List<CTExternalDefinedName> getDefinedNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ac
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDefinedNameArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.nk
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDefinedNameArray(((Integer) obj).intValue(), (CTExternalDefinedName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.p5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDefinedName(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ub
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDefinedName(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.va
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDefinedNameArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public CTExternalDefinedName insertNewDefinedName(int i2) {
        CTExternalDefinedName cTExternalDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedName = (CTExternalDefinedName) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTExternalDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public void removeDefinedName(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public void setDefinedNameArray(CTExternalDefinedName[] cTExternalDefinedNameArr) {
        check_orphaned();
        arraySetterHelper(cTExternalDefinedNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public int sizeOfDefinedNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public CTExternalDefinedName getDefinedNameArray(int i2) {
        CTExternalDefinedName cTExternalDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalDefinedName = (CTExternalDefinedName) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTExternalDefinedName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTExternalDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedNames
    public void setDefinedNameArray(int i2, CTExternalDefinedName cTExternalDefinedName) throws Throwable {
        generatedSetterHelperImpl(cTExternalDefinedName, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
