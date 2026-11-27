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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;

/* loaded from: classes2.dex */
public class CTDefinedNamesImpl extends XmlComplexContentImpl implements CTDefinedNames {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedName")};
    private static final long serialVersionUID = 1;

    public CTDefinedNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName addNewDefinedName() {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName[] getDefinedNameArray() {
        return (CTDefinedName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTDefinedName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public List<CTDefinedName> getDefinedNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.u3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDefinedNameArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.f8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDefinedNameArray(((Integer) obj).intValue(), (CTDefinedName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.dk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDefinedName(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.bb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDefinedName(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDefinedNameArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName insertNewDefinedName(int i2) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void removeDefinedName(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr) {
        check_orphaned();
        arraySetterHelper(cTDefinedNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public int sizeOfDefinedNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName getDefinedNameArray(int i2) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTDefinedName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(int i2, CTDefinedName cTDefinedName) throws Throwable {
        generatedSetterHelperImpl(cTDefinedName, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
