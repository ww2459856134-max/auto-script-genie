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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments;

/* loaded from: classes3.dex */
public class CTCommentsImpl extends XmlComplexContentImpl implements CTComments {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "comment")};
    private static final long serialVersionUID = 1;

    public CTCommentsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment addNewComment() {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment[] getCommentArray() {
        return (CTComment[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTComment[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public List<CTComment> getCommentList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.is3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j60
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentArray(((Integer) obj).intValue(), (CTComment) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h32
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewComment(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mp2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeComment(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vt1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment insertNewComment(int i2) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void removeComment(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void setCommentArray(CTComment[] cTCommentArr) {
        check_orphaned();
        arraySetterHelper(cTCommentArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public int sizeOfCommentArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public CTComment getCommentArray(int i2) {
        CTComment cTComment;
        synchronized (monitor()) {
            check_orphaned();
            cTComment = (CTComment) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTComment == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTComment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComments
    public void setCommentArray(int i2, CTComment cTComment) throws Throwable {
        generatedSetterHelperImpl(cTComment, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
