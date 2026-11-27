package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupLocking;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* loaded from: classes2.dex */
public class CTNonVisualGroupDrawingShapePropsImpl extends XmlComplexContentImpl implements CTNonVisualGroupDrawingShapeProps {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "grpSpLocks"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTNonVisualGroupDrawingShapePropsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTGroupLocking addNewGrpSpLocks() {
        CTGroupLocking cTGroupLockingAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupLockingAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGroupLockingAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public CTGroupLocking getGrpSpLocks() {
        CTGroupLocking cTGroupLockingFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupLockingFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGroupLockingFind_element_user == null) {
                cTGroupLockingFind_element_user = null;
            }
        }
        return cTGroupLockingFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public boolean isSetExtLst() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public boolean isSetGrpSpLocks() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void setGrpSpLocks(CTGroupLocking cTGroupLocking) throws Throwable {
        generatedSetterHelperImpl(cTGroupLocking, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps
    public void unsetGrpSpLocks() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
