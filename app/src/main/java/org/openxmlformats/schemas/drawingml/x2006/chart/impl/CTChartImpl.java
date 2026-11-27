package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDispBlanksAs;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPivotFmts;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTView3D;

/* loaded from: classes2.dex */
public class CTChartImpl extends XmlComplexContentImpl implements CTChart {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "title"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "autoTitleDeleted"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "pivotFmts"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "view3D"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "floor"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "sideWall"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "backWall"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotArea"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "legend"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "plotVisOnly"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dispBlanksAs"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "showDLblsOverMax"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTChartImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewAutoTitleDeleted() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewBackWall() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTDispBlanksAs addNewDispBlanksAs() {
        CTDispBlanksAs cTDispBlanksAs;
        synchronized (monitor()) {
            check_orphaned();
            cTDispBlanksAs = (CTDispBlanksAs) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTDispBlanksAs;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewFloor() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTLegend addNewLegend() {
        CTLegend cTLegend;
        synchronized (monitor()) {
            check_orphaned();
            cTLegend = (CTLegend) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTLegend;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPivotFmts addNewPivotFmts() {
        CTPivotFmts cTPivotFmtsAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotFmtsAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTPivotFmtsAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPlotArea addNewPlotArea() {
        CTPlotArea cTPlotArea;
        synchronized (monitor()) {
            check_orphaned();
            cTPlotArea = (CTPlotArea) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPlotArea;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewPlotVisOnly() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean addNewShowDLblsOverMax() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface addNewSideWall() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTView3D addNewView3D() {
        CTView3D cTView3D;
        synchronized (monitor()) {
            check_orphaned();
            cTView3D = (CTView3D) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTView3D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getAutoTitleDeleted() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getBackWall() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTSurface == null) {
                cTSurface = null;
            }
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTDispBlanksAs getDispBlanksAs() {
        CTDispBlanksAs cTDispBlanksAs;
        synchronized (monitor()) {
            check_orphaned();
            cTDispBlanksAs = (CTDispBlanksAs) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTDispBlanksAs == null) {
                cTDispBlanksAs = null;
            }
        }
        return cTDispBlanksAs;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getFloor() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTSurface == null) {
                cTSurface = null;
            }
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTLegend getLegend() {
        CTLegend cTLegend;
        synchronized (monitor()) {
            check_orphaned();
            cTLegend = (CTLegend) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTLegend == null) {
                cTLegend = null;
            }
        }
        return cTLegend;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPivotFmts getPivotFmts() {
        CTPivotFmts cTPivotFmtsFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPivotFmtsFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTPivotFmtsFind_element_user == null) {
                cTPivotFmtsFind_element_user = null;
            }
        }
        return cTPivotFmtsFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTPlotArea getPlotArea() {
        CTPlotArea cTPlotArea;
        synchronized (monitor()) {
            check_orphaned();
            cTPlotArea = (CTPlotArea) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTPlotArea == null) {
                cTPlotArea = null;
            }
        }
        return cTPlotArea;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getPlotVisOnly() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTBoolean getShowDLblsOverMax() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTSurface getSideWall() {
        CTSurface cTSurface;
        synchronized (monitor()) {
            check_orphaned();
            cTSurface = (CTSurface) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTSurface == null) {
                cTSurface = null;
            }
        }
        return cTSurface;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTTitle getTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTitle == null) {
                cTTitle = null;
            }
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public CTView3D getView3D() {
        CTView3D cTView3D;
        synchronized (monitor()) {
            check_orphaned();
            cTView3D = (CTView3D) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTView3D == null) {
                cTView3D = null;
            }
        }
        return cTView3D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetAutoTitleDeleted() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetBackWall() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetDispBlanksAs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetFloor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetLegend() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetPivotFmts() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetPlotVisOnly() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetShowDLblsOverMax() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetSideWall() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public boolean isSetView3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setAutoTitleDeleted(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setBackWall(CTSurface cTSurface) throws Throwable {
        generatedSetterHelperImpl(cTSurface, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setDispBlanksAs(CTDispBlanksAs cTDispBlanksAs) throws Throwable {
        generatedSetterHelperImpl(cTDispBlanksAs, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setFloor(CTSurface cTSurface) throws Throwable {
        generatedSetterHelperImpl(cTSurface, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setLegend(CTLegend cTLegend) throws Throwable {
        generatedSetterHelperImpl(cTLegend, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPivotFmts(CTPivotFmts cTPivotFmts) throws Throwable {
        generatedSetterHelperImpl(cTPivotFmts, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPlotArea(CTPlotArea cTPlotArea) throws Throwable {
        generatedSetterHelperImpl(cTPlotArea, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setPlotVisOnly(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setShowDLblsOverMax(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setSideWall(CTSurface cTSurface) throws Throwable {
        generatedSetterHelperImpl(cTSurface, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setTitle(CTTitle cTTitle) throws Throwable {
        generatedSetterHelperImpl(cTTitle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void setView3D(CTView3D cTView3D) throws Throwable {
        generatedSetterHelperImpl(cTView3D, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetAutoTitleDeleted() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetBackWall() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetDispBlanksAs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetFloor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetLegend() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetPivotFmts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetPlotVisOnly() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetShowDLblsOverMax() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetSideWall() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTChart
    public void unsetView3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
