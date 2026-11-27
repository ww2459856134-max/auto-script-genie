package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* loaded from: classes2.dex */
public class CTDLblsImpl extends XmlComplexContentImpl implements CTDLbls {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbl"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "delete"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numFmt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLblPos"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showLegendKey"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showVal"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showCatName"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showSerName"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showPercent"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showBubbleSize"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "separator"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showLeaderLines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "leaderLines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTDLblsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLbl addNewDLbl() {
        CTDLbl cTDLblAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTDLblAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLblPos addNewDLblPos() {
        CTDLblPos cTDLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblPos = (CTDLblPos) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTChartLines addNewLeaderLines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowBubbleSize() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowCatName() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowLeaderLines() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowLegendKey() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowPercent() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowSerName() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean addNewShowVal() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLbl[] getDLblArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTDLbl[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public List<CTDLbl> getDLblList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDLblArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDLblArray(((Integer) obj).intValue(), (CTDLbl) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.wb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDLbl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.w9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDLbl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.j9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDLblArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLblPos getDLblPos() {
        CTDLblPos cTDLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblPos = (CTDLblPos) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTDLblPos == null) {
                cTDLblPos = null;
            }
        }
        return cTDLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTChartLines getLeaderLines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTChartLines == null) {
                cTChartLines = null;
            }
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTNumFmt getNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTNumFmt == null) {
                cTNumFmt = null;
            }
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public String getSeparator() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowBubbleSize() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowCatName() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowLeaderLines() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowLegendKey() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowPercent() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowSerName() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTBoolean getShowVal() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTTextBody getTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTextBody == null) {
                cTTextBody = null;
            }
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLbl insertNewDLbl(int i2) {
        CTDLbl cTDLblInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTDLblInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetDLblPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetDelete() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetLeaderLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetSeparator() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowBubbleSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowCatName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowLeaderLines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowLegendKey() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowPercent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowSerName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetShowVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void removeDLbl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setDLblArray(CTDLbl[] cTDLblArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTDLblArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setDLblPos(CTDLblPos cTDLblPos) throws Throwable {
        generatedSetterHelperImpl(cTDLblPos, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setDelete(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setLeaderLines(CTChartLines cTChartLines) throws Throwable {
        generatedSetterHelperImpl(cTChartLines, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setNumFmt(CTNumFmt cTNumFmt) throws Throwable {
        generatedSetterHelperImpl(cTNumFmt, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setSeparator(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[12], 0);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[12]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowBubbleSize(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowCatName(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowLeaderLines(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowLegendKey(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowPercent(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowSerName(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setShowVal(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setTxPr(CTTextBody cTTextBody) throws Throwable {
        generatedSetterHelperImpl(cTTextBody, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public int sizeOfDLblArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetDLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetDelete() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetLeaderLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetSeparator() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowBubbleSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowCatName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowLeaderLines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowLegendKey() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowPercent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowSerName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetShowVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public XmlString xgetSeparator() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[12], 0);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void xsetSeparator(XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[12], 0);
            if (xmlString2 == null) {
                xmlString2 = (XmlString) get_store().add_element_user(qNameArr[12]);
            }
            xmlString2.set(xmlString);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public CTDLbl getDLblArray(int i2) {
        CTDLbl cTDLblFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDLblFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTDLblFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDLblFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls
    public void setDLblArray(int i2, CTDLbl cTDLbl) throws Throwable {
        generatedSetterHelperImpl(cTDLbl, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
