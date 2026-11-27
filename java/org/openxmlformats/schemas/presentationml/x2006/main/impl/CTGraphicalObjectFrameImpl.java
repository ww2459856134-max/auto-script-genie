package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* loaded from: classes2.dex */
public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "xfrm"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphic"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst"), new QName("", "bwMode")};
    private static final long serialVersionUID = 1;

    public CTGraphicalObjectFrameImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr() {
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGraphicalObjectFrameNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D addNewXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public STBlackWhiteMode.Enum getBwMode() {
        STBlackWhiteMode.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            r1 = simpleValue == null ? null : (STBlackWhiteMode.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify getExtLst() {
        CTExtensionListModify cTExtensionListModifyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = null;
            }
        }
        return cTExtensionListModifyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject getGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTGraphicalObject == null) {
                cTGraphicalObject = null;
            }
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual getNvGraphicFramePr() {
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGraphicalObjectFrameNonVisual == null) {
                cTGraphicalObjectFrameNonVisual = null;
            }
        }
        return cTGraphicalObjectFrameNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D getXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTransform2D == null) {
                cTTransform2D = null;
            }
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public boolean isSetBwMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setBwMode(STBlackWhiteMode.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setExtLst(CTExtensionListModify cTExtensionListModify) throws Throwable {
        generatedSetterHelperImpl(cTExtensionListModify, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setGraphic(CTGraphicalObject cTGraphicalObject) throws Throwable {
        generatedSetterHelperImpl(cTGraphicalObject, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual) throws Throwable {
        generatedSetterHelperImpl(cTGraphicalObjectFrameNonVisual, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setXfrm(CTTransform2D cTTransform2D) throws Throwable {
        generatedSetterHelperImpl(cTTransform2D, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void unsetBwMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public STBlackWhiteMode xgetBwMode() {
        STBlackWhiteMode sTBlackWhiteMode;
        synchronized (monitor()) {
            check_orphaned();
            sTBlackWhiteMode = (STBlackWhiteMode) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTBlackWhiteMode;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STBlackWhiteMode sTBlackWhiteMode2 = (STBlackWhiteMode) typeStore.find_attribute_user(qNameArr[4]);
            if (sTBlackWhiteMode2 == null) {
                sTBlackWhiteMode2 = (STBlackWhiteMode) get_store().add_attribute_user(qNameArr[4]);
            }
            sTBlackWhiteMode2.set(sTBlackWhiteMode);
        }
    }
}
