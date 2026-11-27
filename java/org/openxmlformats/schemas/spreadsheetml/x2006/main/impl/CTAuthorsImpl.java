package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors;

/* loaded from: classes2.dex */
public class CTAuthorsImpl extends XmlComplexContentImpl implements CTAuthors {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "author")};
    private static final long serialVersionUID = 1;

    public CTAuthorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    static /* synthetic */ String[] C(int i2) {
        return new String[i2];
    }

    static /* synthetic */ STXstring[] D(int i2) {
        return new STXstring[i2];
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void addAuthor(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[0])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring addNewAuthor() {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public String[] getAuthorArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[0], u9.a, new IntFunction() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.c3
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTAuthorsImpl.C(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public List<String> getAuthorList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAuthorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ce
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setAuthorArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.vi
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertAuthor(((Integer) obj).intValue(), (String) obj2);
                }
            }, new d2(this), new d7(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void insertAuthor(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[0], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring insertNewAuthor(int i2) {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void removeAuthor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void setAuthorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public int sizeOfAuthorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring[] xgetAuthorArray() {
        return (STXstring[]) xgetArray(PROPERTY_QNAME[0], new IntFunction() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.d3
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTAuthorsImpl.D(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public List<STXstring> xgetAuthorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.dg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetAuthorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.d8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetAuthorArray(((Integer) obj).intValue(), (STXstring) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAuthor(((Integer) obj).intValue());
                }
            }, new d2(this), new d7(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void xsetAuthorArray(STXstring[] sTXstringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTXstringArr, PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public String getAuthorArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public STXstring xgetAuthorArray(int i2) {
        STXstring sTXstring;
        synchronized (monitor()) {
            check_orphaned();
            sTXstring = (STXstring) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (sTXstring == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTXstring;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void setAuthorArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAuthors
    public void xsetAuthorArray(int i2, STXstring sTXstring) {
        synchronized (monitor()) {
            check_orphaned();
            STXstring sTXstring2 = (STXstring) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (sTXstring2 != null) {
                sTXstring2.set(sTXstring);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
