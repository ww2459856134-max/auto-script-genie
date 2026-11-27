package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;

/* loaded from: classes2.dex */
public class CTCommentAuthorListImpl extends XmlComplexContentImpl implements CTCommentAuthorList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmAuthor")};
    private static final long serialVersionUID = 1;

    public CTCommentAuthorListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor addNewCmAuthor() {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor[] getCmAuthorArray() {
        return (CTCommentAuthor[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCommentAuthor[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public List<CTCommentAuthor> getCmAuthorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.j2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCmAuthorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCmAuthorArray(((Integer) obj).intValue(), (CTCommentAuthor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.h3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCmAuthor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.u2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCmAuthor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.a4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCmAuthorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor insertNewCmAuthor(int i2) {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void removeCmAuthor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void setCmAuthorArray(CTCommentAuthor[] cTCommentAuthorArr) {
        check_orphaned();
        arraySetterHelper(cTCommentAuthorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public int sizeOfCmAuthorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public CTCommentAuthor getCmAuthorArray(int i2) {
        CTCommentAuthor cTCommentAuthor;
        synchronized (monitor()) {
            check_orphaned();
            cTCommentAuthor = (CTCommentAuthor) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCommentAuthor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCommentAuthor;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList
    public void setCmAuthorArray(int i2, CTCommentAuthor cTCommentAuthor) throws Throwable {
        generatedSetterHelperImpl(cTCommentAuthor, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
