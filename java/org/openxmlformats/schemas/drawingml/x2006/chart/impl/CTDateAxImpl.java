package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxisUnit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDouble;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLblOffset;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTimeUnit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;

/* loaded from: classes2.dex */
public class CTDateAxImpl extends XmlComplexContentImpl implements CTDateAx {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axId"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "scaling"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "delete"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "axPos"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorGridlines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorGridlines"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "title"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numFmt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorTickMark"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorTickMark"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tickLblPos"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "txPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossAx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crosses"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "crossesAt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "auto"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "lblOffset"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "baseTimeUnit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorUnit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "majorTimeUnit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorUnit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "minorTimeUnit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTDateAxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean addNewAuto() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt addNewAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxPos addNewAxPos() {
        CTAxPos cTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            cTAxPos = (CTAxPos) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewBaseTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt addNewCrossAx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTCrosses addNewCrosses() {
        CTCrosses cTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            cTCrosses = (CTCrosses) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTDouble addNewCrossesAt() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean addNewDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTLblOffset addNewLblOffset() {
        CTLblOffset cTLblOffsetAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLblOffsetAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTLblOffsetAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines addNewMajorGridlines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark addNewMajorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewMajorTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit addNewMajorUnit() {
        CTAxisUnit cTAxisUnit;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnit = (CTAxisUnit) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTAxisUnit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines addNewMinorGridlines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark addNewMinorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit addNewMinorTimeUnit() {
        CTTimeUnit cTTimeUnitAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTTimeUnitAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit addNewMinorUnit() {
        CTAxisUnit cTAxisUnit;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnit = (CTAxisUnit) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTAxisUnit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTNumFmt addNewNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTScaling addNewScaling() {
        CTScaling cTScaling;
        synchronized (monitor()) {
            check_orphaned();
            cTScaling = (CTScaling) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTScaling;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickLblPos addNewTickLblPos() {
        CTTickLblPos cTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTTickLblPos = (CTTickLblPos) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTitle addNewTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTextBody addNewTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean getAuto() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt getAxId() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTUnsignedInt == null) {
                cTUnsignedInt = null;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxPos getAxPos() {
        CTAxPos cTAxPos;
        synchronized (monitor()) {
            check_orphaned();
            cTAxPos = (CTAxPos) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTAxPos == null) {
                cTAxPos = null;
            }
        }
        return cTAxPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getBaseTimeUnit() {
        CTTimeUnit cTTimeUnitFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = null;
            }
        }
        return cTTimeUnitFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTUnsignedInt getCrossAx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTUnsignedInt == null) {
                cTUnsignedInt = null;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTCrosses getCrosses() {
        CTCrosses cTCrosses;
        synchronized (monitor()) {
            check_orphaned();
            cTCrosses = (CTCrosses) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTCrosses == null) {
                cTCrosses = null;
            }
        }
        return cTCrosses;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTDouble getCrossesAt() {
        CTDouble cTDouble;
        synchronized (monitor()) {
            check_orphaned();
            cTDouble = (CTDouble) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTDouble == null) {
                cTDouble = null;
            }
        }
        return cTDouble;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTBoolean getDelete() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[23], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTLblOffset getLblOffset() {
        CTLblOffset cTLblOffsetFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLblOffsetFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTLblOffsetFind_element_user == null) {
                cTLblOffsetFind_element_user = null;
            }
        }
        return cTLblOffsetFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines getMajorGridlines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTChartLines == null) {
                cTChartLines = null;
            }
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark getMajorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTickMark == null) {
                cTTickMark = null;
            }
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getMajorTimeUnit() {
        CTTimeUnit cTTimeUnitFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitFind_element_user = get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = null;
            }
        }
        return cTTimeUnitFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit getMajorUnit() {
        CTAxisUnit cTAxisUnit;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnit = (CTAxisUnit) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTAxisUnit == null) {
                cTAxisUnit = null;
            }
        }
        return cTAxisUnit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTChartLines getMinorGridlines() {
        CTChartLines cTChartLines;
        synchronized (monitor()) {
            check_orphaned();
            cTChartLines = (CTChartLines) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTChartLines == null) {
                cTChartLines = null;
            }
        }
        return cTChartLines;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickMark getMinorTickMark() {
        CTTickMark cTTickMark;
        synchronized (monitor()) {
            check_orphaned();
            cTTickMark = (CTTickMark) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTickMark == null) {
                cTTickMark = null;
            }
        }
        return cTTickMark;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTimeUnit getMinorTimeUnit() {
        CTTimeUnit cTTimeUnitFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeUnitFind_element_user = get_store().find_element_user(PROPERTY_QNAME[22], 0);
            if (cTTimeUnitFind_element_user == null) {
                cTTimeUnitFind_element_user = null;
            }
        }
        return cTTimeUnitFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTAxisUnit getMinorUnit() {
        CTAxisUnit cTAxisUnit;
        synchronized (monitor()) {
            check_orphaned();
            cTAxisUnit = (CTAxisUnit) get_store().find_element_user(PROPERTY_QNAME[21], 0);
            if (cTAxisUnit == null) {
                cTAxisUnit = null;
            }
        }
        return cTAxisUnit;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTNumFmt getNumFmt() {
        CTNumFmt cTNumFmt;
        synchronized (monitor()) {
            check_orphaned();
            cTNumFmt = (CTNumFmt) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTNumFmt == null) {
                cTNumFmt = null;
            }
        }
        return cTNumFmt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTScaling getScaling() {
        CTScaling cTScaling;
        synchronized (monitor()) {
            check_orphaned();
            cTScaling = (CTScaling) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTScaling == null) {
                cTScaling = null;
            }
        }
        return cTScaling;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTickLblPos getTickLblPos() {
        CTTickLblPos cTTickLblPos;
        synchronized (monitor()) {
            check_orphaned();
            cTTickLblPos = (CTTickLblPos) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTTickLblPos == null) {
                cTTickLblPos = null;
            }
        }
        return cTTickLblPos;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTitle getTitle() {
        CTTitle cTTitle;
        synchronized (monitor()) {
            check_orphaned();
            cTTitle = (CTTitle) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTTitle == null) {
                cTTitle = null;
            }
        }
        return cTTitle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public CTTextBody getTxPr() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTTextBody == null) {
                cTTextBody = null;
            }
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetAuto() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetBaseTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetCrosses() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetCrossesAt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetDelete() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[23]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetLblOffset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMajorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorGridlines() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorTickMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorTimeUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[22]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetMinorUnit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[21]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetNumFmt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTickLblPos() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTitle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public boolean isSetTxPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setAuto(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setAxId(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setAxPos(CTAxPos cTAxPos) throws Throwable {
        generatedSetterHelperImpl(cTAxPos, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setBaseTimeUnit(CTTimeUnit cTTimeUnit) throws Throwable {
        generatedSetterHelperImpl(cTTimeUnit, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setCrossAx(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setCrosses(CTCrosses cTCrosses) throws Throwable {
        generatedSetterHelperImpl(cTCrosses, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setCrossesAt(CTDouble cTDouble) throws Throwable {
        generatedSetterHelperImpl(cTDouble, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setDelete(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[23], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setLblOffset(CTLblOffset cTLblOffset) throws Throwable {
        generatedSetterHelperImpl(cTLblOffset, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorGridlines(CTChartLines cTChartLines) throws Throwable {
        generatedSetterHelperImpl(cTChartLines, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorTickMark(CTTickMark cTTickMark) throws Throwable {
        generatedSetterHelperImpl(cTTickMark, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorTimeUnit(CTTimeUnit cTTimeUnit) throws Throwable {
        generatedSetterHelperImpl(cTTimeUnit, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMajorUnit(CTAxisUnit cTAxisUnit) throws Throwable {
        generatedSetterHelperImpl(cTAxisUnit, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorGridlines(CTChartLines cTChartLines) throws Throwable {
        generatedSetterHelperImpl(cTChartLines, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorTickMark(CTTickMark cTTickMark) throws Throwable {
        generatedSetterHelperImpl(cTTickMark, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorTimeUnit(CTTimeUnit cTTimeUnit) throws Throwable {
        generatedSetterHelperImpl(cTTimeUnit, PROPERTY_QNAME[22], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setMinorUnit(CTAxisUnit cTAxisUnit) throws Throwable {
        generatedSetterHelperImpl(cTAxisUnit, PROPERTY_QNAME[21], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setNumFmt(CTNumFmt cTNumFmt) throws Throwable {
        generatedSetterHelperImpl(cTNumFmt, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setScaling(CTScaling cTScaling) throws Throwable {
        generatedSetterHelperImpl(cTScaling, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setTickLblPos(CTTickLblPos cTTickLblPos) throws Throwable {
        generatedSetterHelperImpl(cTTickLblPos, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setTitle(CTTitle cTTitle) throws Throwable {
        generatedSetterHelperImpl(cTTitle, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void setTxPr(CTTextBody cTTextBody) throws Throwable {
        generatedSetterHelperImpl(cTTextBody, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetAuto() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetBaseTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetCrosses() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetCrossesAt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetDelete() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetLblOffset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMajorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorGridlines() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorTickMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorTimeUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetMinorUnit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetNumFmt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTickLblPos() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx
    public void unsetTxPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }
}
