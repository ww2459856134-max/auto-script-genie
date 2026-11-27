package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;

/* loaded from: classes2.dex */
public class CTTextSpacingImpl extends XmlComplexContentImpl implements CTTextSpacing {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPct"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "spcPts")};
    private static final long serialVersionUID = 1;

    public CTTextSpacingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPercent addNewSpcPct() {
        CTTextSpacingPercent cTTextSpacingPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPercent = (CTTextSpacingPercent) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextSpacingPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPoint addNewSpcPts() {
        CTTextSpacingPoint cTTextSpacingPoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPoint = (CTTextSpacingPoint) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTextSpacingPoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPercent getSpcPct() {
        CTTextSpacingPercent cTTextSpacingPercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPercent = (CTTextSpacingPercent) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextSpacingPercent == null) {
                cTTextSpacingPercent = null;
            }
        }
        return cTTextSpacingPercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public CTTextSpacingPoint getSpcPts() {
        CTTextSpacingPoint cTTextSpacingPoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacingPoint = (CTTextSpacingPoint) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTextSpacingPoint == null) {
                cTTextSpacingPoint = null;
            }
        }
        return cTTextSpacingPoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public boolean isSetSpcPct() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public boolean isSetSpcPts() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent) throws Throwable {
        generatedSetterHelperImpl(cTTextSpacingPercent, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint) throws Throwable {
        generatedSetterHelperImpl(cTTextSpacingPoint, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void unsetSpcPct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing
    public void unsetSpcPts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }
}
