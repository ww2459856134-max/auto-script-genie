package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;

/* loaded from: classes2.dex */
public class CTConnectionSiteListImpl extends XmlComplexContentImpl implements CTConnectionSiteList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cxn")};
    private static final long serialVersionUID = 1;

    public CTConnectionSiteListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite addNewCxn() {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSite = (CTConnectionSite) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite[] getCxnArray() {
        return (CTConnectionSite[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTConnectionSite[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public List<CTConnectionSite> getCxnList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.qa0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCxnArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.z1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCxnArray(((Integer) obj).intValue(), (CTConnectionSite) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.s3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCxn(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.le
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCxn(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.sb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCxnArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite insertNewCxn(int i2) {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSite = (CTConnectionSite) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void removeCxn(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(CTConnectionSite[] cTConnectionSiteArr) {
        check_orphaned();
        arraySetterHelper(cTConnectionSiteArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public int sizeOfCxnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite getCxnArray(int i2) {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSite = (CTConnectionSite) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTConnectionSite == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(int i2, CTConnectionSite cTConnectionSite) throws Throwable {
        generatedSetterHelperImpl(cTConnectionSite, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
