package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* loaded from: classes2.dex */
public class CTLegendImpl extends XmlComplexContentImpl implements CTLegend {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendPos"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legendEntry"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "layout"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "overlay"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTLegendImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLayout addNewLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry addNewLegendEntry() {
        CTLegendEntry cTLegendEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntry = (CTLegendEntry) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTLegendEntry;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendPos addNewLegendPos() {
        CTLegendPos cTLegendPos;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendPos = (CTLegendPos) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTLegendPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTBoolean addNewOverlay() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLayout getLayout() {
        CTLayout cTLayout;
        synchronized (monitor()) {
            check_orphaned();
            cTLayout = (CTLayout) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTLayout == null) {
                cTLayout = null;
            }
        }
        return cTLayout;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry[] getLegendEntryArray() {
        return (CTLegendEntry[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTLegendEntry[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public List<CTLegendEntry> getLegendEntryList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLegendEntryArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.b0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLegendEntryArray(((Integer) obj).intValue(), (CTLegendEntry) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.z9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLegendEntry(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLegendEntry(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLegendEntryArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendPos getLegendPos() {
        CTLegendPos cTLegendPos;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendPos = (CTLegendPos) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTLegendPos == null) {
                cTLegendPos = null;
            }
        }
        return cTLegendPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTBoolean getOverlay() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTTextBody getTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTextBody == null) {
                cTTextBody = null;
            }
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry insertNewLegendEntry(int i2) {
        CTLegendEntry cTLegendEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntry = (CTLegendEntry) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTLegendEntry;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetLayout() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetLegendPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetOverlay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void removeLegendEntry(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLayout(CTLayout cTLayout) throws Throwable {
        generatedSetterHelperImpl(cTLayout, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendEntryArray(CTLegendEntry[] cTLegendEntryArr) {
        check_orphaned();
        arraySetterHelper(cTLegendEntryArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendPos(CTLegendPos cTLegendPos) throws Throwable {
        generatedSetterHelperImpl(cTLegendPos, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setOverlay(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setTxPr(CTTextBody cTTextBody) throws Throwable {
        generatedSetterHelperImpl(cTTextBody, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public int sizeOfLegendEntryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetLayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetLegendPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetOverlay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public CTLegendEntry getLegendEntryArray(int i2) {
        CTLegendEntry cTLegendEntry;
        synchronized (monitor()) {
            check_orphaned();
            cTLegendEntry = (CTLegendEntry) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTLegendEntry == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLegendEntry;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend
    public void setLegendEntryArray(int i2, CTLegendEntry cTLegendEntry) throws Throwable {
        generatedSetterHelperImpl(cTLegendEntry, PROPERTY_QNAME[1], i2, (short) 2);
    }
}
