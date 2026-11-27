package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjustHandleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* loaded from: classes2.dex */
public class CTCustomGeometry2DImpl extends XmlComplexContentImpl implements CTCustomGeometry2D {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "avLst"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "gdLst"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ahLst"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cxnLst"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rect"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "pathLst")};
    private static final long serialVersionUID = 1;

    public CTCustomGeometry2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList addNewAhLst() {
        CTAdjustHandleList cTAdjustHandleList;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjustHandleList = (CTAdjustHandleList) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAdjustHandleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList addNewCxnLst() {
        CTConnectionSiteList cTConnectionSiteList;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSiteList = (CTConnectionSiteList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTConnectionSiteList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList addNewGdLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList addNewPathLst() {
        CTPath2DList cTPath2DList;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DList = (CTPath2DList) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPath2DList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect addNewRect() {
        CTGeomRect cTGeomRect;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomRect = (CTGeomRect) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGeomRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTAdjustHandleList getAhLst() {
        CTAdjustHandleList cTAdjustHandleList;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjustHandleList = (CTAdjustHandleList) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTAdjustHandleList == null) {
                cTAdjustHandleList = null;
            }
        }
        return cTAdjustHandleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getAvLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGeomGuideList == null) {
                cTGeomGuideList = null;
            }
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTConnectionSiteList getCxnLst() {
        CTConnectionSiteList cTConnectionSiteList;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSiteList = (CTConnectionSiteList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTConnectionSiteList == null) {
                cTConnectionSiteList = null;
            }
        }
        return cTConnectionSiteList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomGuideList getGdLst() {
        CTGeomGuideList cTGeomGuideList;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomGuideList = (CTGeomGuideList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTGeomGuideList == null) {
                cTGeomGuideList = null;
            }
        }
        return cTGeomGuideList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTPath2DList getPathLst() {
        CTPath2DList cTPath2DList;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2DList = (CTPath2DList) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTPath2DList == null) {
                cTPath2DList = null;
            }
        }
        return cTPath2DList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public CTGeomRect getRect() {
        CTGeomRect cTGeomRect;
        synchronized (monitor()) {
            check_orphaned();
            cTGeomRect = (CTGeomRect) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTGeomRect == null) {
                cTGeomRect = null;
            }
        }
        return cTGeomRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAhLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetAvLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetCxnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetGdLst() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public boolean isSetRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAhLst(CTAdjustHandleList cTAdjustHandleList) throws Throwable {
        generatedSetterHelperImpl(cTAdjustHandleList, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setAvLst(CTGeomGuideList cTGeomGuideList) throws Throwable {
        generatedSetterHelperImpl(cTGeomGuideList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setCxnLst(CTConnectionSiteList cTConnectionSiteList) throws Throwable {
        generatedSetterHelperImpl(cTConnectionSiteList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setGdLst(CTGeomGuideList cTGeomGuideList) throws Throwable {
        generatedSetterHelperImpl(cTGeomGuideList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setPathLst(CTPath2DList cTPath2DList) throws Throwable {
        generatedSetterHelperImpl(cTPath2DList, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void setRect(CTGeomRect cTGeomRect) throws Throwable {
        generatedSetterHelperImpl(cTGeomRect, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAhLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetAvLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetCxnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetGdLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D
    public void unsetRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }
}
