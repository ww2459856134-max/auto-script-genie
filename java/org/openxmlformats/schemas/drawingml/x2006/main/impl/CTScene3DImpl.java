package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackdrop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCamera;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLightRig;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;

/* loaded from: classes2.dex */
public class CTScene3DImpl extends XmlComplexContentImpl implements CTScene3D {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "camera"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "lightRig"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "backdrop"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTScene3DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTBackdrop addNewBackdrop() {
        CTBackdrop cTBackdropAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBackdropAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBackdropAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTCamera addNewCamera() {
        CTCamera cTCameraAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCameraAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCameraAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTLightRig addNewLightRig() {
        CTLightRig cTLightRigAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLightRigAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTLightRigAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTBackdrop getBackdrop() {
        CTBackdrop cTBackdropFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBackdropFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTBackdropFind_element_user == null) {
                cTBackdropFind_element_user = null;
            }
        }
        return cTBackdropFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTCamera getCamera() {
        CTCamera cTCameraFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCameraFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCameraFind_element_user == null) {
                cTCameraFind_element_user = null;
            }
        }
        return cTCameraFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public CTLightRig getLightRig() {
        CTLightRig cTLightRigFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLightRigFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTLightRigFind_element_user == null) {
                cTLightRigFind_element_user = null;
            }
        }
        return cTLightRigFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public boolean isSetBackdrop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void setBackdrop(CTBackdrop cTBackdrop) throws Throwable {
        generatedSetterHelperImpl(cTBackdrop, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void setCamera(CTCamera cTCamera) throws Throwable {
        generatedSetterHelperImpl(cTCamera, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void setLightRig(CTLightRig cTLightRig) throws Throwable {
        generatedSetterHelperImpl(cTLightRig, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void unsetBackdrop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }
}
