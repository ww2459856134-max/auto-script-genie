package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTagsData;

/* loaded from: classes2.dex */
public class CTCustomerDataListImpl extends XmlComplexContentImpl implements CTCustomerDataList {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custData"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tags")};
    private static final long serialVersionUID = 1;

    public CTCustomerDataListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData addNewCustData() {
        CTCustomerData cTCustomerDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomerDataAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTTagsData addNewTags() {
        CTTagsData cTTagsData;
        synchronized (monitor()) {
            check_orphaned();
            cTTagsData = (CTTagsData) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTagsData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData[] getCustDataArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTCustomerData[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public List<CTCustomerData> getCustDataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.x0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustDataArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustDataArray(((Integer) obj).intValue(), (CTCustomerData) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.k3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustData(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.t3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustData(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.h0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustDataArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTTagsData getTags() {
        CTTagsData cTTagsData;
        synchronized (monitor()) {
            check_orphaned();
            cTTagsData = (CTTagsData) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTagsData == null) {
                cTTagsData = null;
            }
        }
        return cTTagsData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData insertNewCustData(int i2) {
        CTCustomerData cTCustomerDataInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTCustomerDataInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public boolean isSetTags() {
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void removeCustData(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setCustDataArray(CTCustomerData[] cTCustomerDataArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTCustomerDataArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setTags(CTTagsData cTTagsData) throws Throwable {
        generatedSetterHelperImpl(cTTagsData, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public int sizeOfCustDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void unsetTags() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public CTCustomerData getCustDataArray(int i2) {
        CTCustomerData cTCustomerDataFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTCustomerDataFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomerDataFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList
    public void setCustDataArray(int i2, CTCustomerData cTCustomerData) throws Throwable {
        generatedSetterHelperImpl(cTCustomerData, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
