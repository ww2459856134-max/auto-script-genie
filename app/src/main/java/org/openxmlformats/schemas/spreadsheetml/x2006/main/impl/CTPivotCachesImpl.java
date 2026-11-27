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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;

/* loaded from: classes2.dex */
public class CTPivotCachesImpl extends XmlComplexContentImpl implements CTPivotCaches {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCache")};
    private static final long serialVersionUID = 1;

    public CTPivotCachesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache addNewPivotCache() {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache[] getPivotCacheArray() {
        return (CTPivotCache[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPivotCache[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public List<CTPivotCache> getPivotCacheList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.p9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPivotCacheArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.xb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPivotCacheArray(((Integer) obj).intValue(), (CTPivotCache) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.zc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPivotCache(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.r5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePivotCache(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ee
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPivotCacheArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache insertNewPivotCache(int i2) {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void removePivotCache(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void setPivotCacheArray(CTPivotCache[] cTPivotCacheArr) {
        check_orphaned();
        arraySetterHelper(cTPivotCacheArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public int sizeOfPivotCacheArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public CTPivotCache getPivotCacheArray(int i2) {
        CTPivotCache cTPivotCache;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotCache = (CTPivotCache) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTPivotCache == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPivotCache;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches
    public void setPivotCacheArray(int i2, CTPivotCache cTPivotCache) throws Throwable {
        generatedSetterHelperImpl(cTPivotCache, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
