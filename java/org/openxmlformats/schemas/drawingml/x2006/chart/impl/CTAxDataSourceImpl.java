package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMultiLvlStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;

/* loaded from: classes2.dex */
public class CTAxDataSourceImpl extends XmlComplexContentImpl implements CTAxDataSource {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "multiLvlStrRef"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numRef"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "numLit"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strRef"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "strLit")};
    private static final long serialVersionUID = 1;

    public CTAxDataSourceImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTMultiLvlStrRef addNewMultiLvlStrRef() {
        CTMultiLvlStrRef cTMultiLvlStrRefAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLvlStrRefAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMultiLvlStrRefAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumData addNewNumLit() {
        CTNumData cTNumData;
        synchronized (monitor()) {
            check_orphaned();
            cTNumData = (CTNumData) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTNumData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumRef addNewNumRef() {
        CTNumRef cTNumRef;
        synchronized (monitor()) {
            check_orphaned();
            cTNumRef = (CTNumRef) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTNumRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrData addNewStrLit() {
        CTStrData cTStrData;
        synchronized (monitor()) {
            check_orphaned();
            cTStrData = (CTStrData) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTStrData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrRef addNewStrRef() {
        CTStrRef cTStrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTStrRef = (CTStrRef) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTStrRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTMultiLvlStrRef getMultiLvlStrRef() {
        CTMultiLvlStrRef cTMultiLvlStrRefFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTMultiLvlStrRefFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMultiLvlStrRefFind_element_user == null) {
                cTMultiLvlStrRefFind_element_user = null;
            }
        }
        return cTMultiLvlStrRefFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumData getNumLit() {
        CTNumData cTNumData;
        synchronized (monitor()) {
            check_orphaned();
            cTNumData = (CTNumData) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTNumData == null) {
                cTNumData = null;
            }
        }
        return cTNumData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTNumRef getNumRef() {
        CTNumRef cTNumRef;
        synchronized (monitor()) {
            check_orphaned();
            cTNumRef = (CTNumRef) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTNumRef == null) {
                cTNumRef = null;
            }
        }
        return cTNumRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrData getStrLit() {
        CTStrData cTStrData;
        synchronized (monitor()) {
            check_orphaned();
            cTStrData = (CTStrData) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTStrData == null) {
                cTStrData = null;
            }
        }
        return cTStrData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public CTStrRef getStrRef() {
        CTStrRef cTStrRef;
        synchronized (monitor()) {
            check_orphaned();
            cTStrRef = (CTStrRef) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTStrRef == null) {
                cTStrRef = null;
            }
        }
        return cTStrRef;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetMultiLvlStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetNumLit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetNumRef() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetStrLit() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public boolean isSetStrRef() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setMultiLvlStrRef(CTMultiLvlStrRef cTMultiLvlStrRef) throws Throwable {
        generatedSetterHelperImpl(cTMultiLvlStrRef, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setNumLit(CTNumData cTNumData) throws Throwable {
        generatedSetterHelperImpl(cTNumData, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setNumRef(CTNumRef cTNumRef) throws Throwable {
        generatedSetterHelperImpl(cTNumRef, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setStrLit(CTStrData cTStrData) throws Throwable {
        generatedSetterHelperImpl(cTStrData, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void setStrRef(CTStrRef cTStrRef) throws Throwable {
        generatedSetterHelperImpl(cTStrRef, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetMultiLvlStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetNumLit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetNumRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetStrLit() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource
    public void unsetStrRef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
