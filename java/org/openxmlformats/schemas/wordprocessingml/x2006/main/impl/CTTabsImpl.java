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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs;

/* loaded from: classes3.dex */
public class CTTabsImpl extends XmlComplexContentImpl implements CTTabs {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab")};
    private static final long serialVersionUID = 1;

    public CTTabsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop addNewTab() {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop[] getTabArray() {
        return (CTTabStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTabStop[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public List<CTTabStop> getTabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y02
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTabArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fn1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTabArray(((Integer) obj).intValue(), (CTTabStop) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l41
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTab(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.an
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTab(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mm2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTabArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop insertNewTab(int i2) {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void removeTab(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(CTTabStop[] cTTabStopArr) {
        check_orphaned();
        arraySetterHelper(cTTabStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public CTTabStop getTabArray(int i2) {
        CTTabStop cTTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTabStop = (CTTabStop) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTabStop == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTabStop;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabs
    public void setTabArray(int i2, CTTabStop cTTabStop) throws Throwable {
        generatedSetterHelperImpl(cTTabStop, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
