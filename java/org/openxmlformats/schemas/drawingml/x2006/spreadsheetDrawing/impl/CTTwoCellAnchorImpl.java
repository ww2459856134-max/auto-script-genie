package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTRel;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;

/* loaded from: classes2.dex */
public class CTTwoCellAnchorImpl extends XmlComplexContentImpl implements CTTwoCellAnchor {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "from"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "to"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "sp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "grpSp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "graphicFrame"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "cxnSp"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "pic"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "contentPart"), new QName("http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing", "clientData"), new QName("", "editAs")};
    private static final long serialVersionUID = 1;

    public CTTwoCellAnchorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTAnchorClientData addNewClientData() {
        CTAnchorClientData cTAnchorClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorClientData = (CTAnchorClientData) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTAnchorClientData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTRel addNewContentPart() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTRelAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTConnector addNewCxnSp() {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker addNewFrom() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGraphicalObjectFrame addNewGraphicFrame() {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGroupShape addNewGrpSp() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTPicture addNewPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTShape addNewSp() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker addNewTo() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTAnchorClientData getClientData() {
        CTAnchorClientData cTAnchorClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorClientData = (CTAnchorClientData) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTAnchorClientData == null) {
                cTAnchorClientData = null;
            }
        }
        return cTAnchorClientData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTRel getContentPart() {
        CTRel cTRelFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTRelFind_element_user == null) {
                cTRelFind_element_user = null;
            }
        }
        return cTRelFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTConnector getCxnSp() {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTConnector == null) {
                cTConnector = null;
            }
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public STEditAs.Enum getEditAs() {
        STEditAs.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[9]);
            }
            r1 = simpleValue == null ? null : (STEditAs.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker getFrom() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMarker == null) {
                cTMarker = null;
            }
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGraphicalObjectFrame getGraphicFrame() {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTGraphicalObjectFrame == null) {
                cTGraphicalObjectFrame = null;
            }
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTGroupShape getGrpSp() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTGroupShape == null) {
                cTGroupShape = null;
            }
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTPicture getPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTPicture == null) {
                cTPicture = null;
            }
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTShape getSp() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTShape == null) {
                cTShape = null;
            }
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public CTMarker getTo() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTMarker == null) {
                cTMarker = null;
            }
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetContentPart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetCxnSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetEditAs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[9]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetGraphicFrame() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetGrpSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetPic() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public boolean isSetSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setClientData(CTAnchorClientData cTAnchorClientData) throws Throwable {
        generatedSetterHelperImpl(cTAnchorClientData, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setContentPart(CTRel cTRel) throws Throwable {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setCxnSp(CTConnector cTConnector) throws Throwable {
        generatedSetterHelperImpl(cTConnector, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setEditAs(STEditAs.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setFrom(CTMarker cTMarker) throws Throwable {
        generatedSetterHelperImpl(cTMarker, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame) throws Throwable {
        generatedSetterHelperImpl(cTGraphicalObjectFrame, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setGrpSp(CTGroupShape cTGroupShape) throws Throwable {
        generatedSetterHelperImpl(cTGroupShape, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setPic(CTPicture cTPicture) throws Throwable {
        generatedSetterHelperImpl(cTPicture, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setSp(CTShape cTShape) throws Throwable {
        generatedSetterHelperImpl(cTShape, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void setTo(CTMarker cTMarker) throws Throwable {
        generatedSetterHelperImpl(cTMarker, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetContentPart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetCxnSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetEditAs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetGraphicFrame() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetGrpSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetPic() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void unsetSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public STEditAs xgetEditAs() {
        STEditAs sTEditAs;
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            sTEditAs = (STEditAs) typeStore.find_attribute_user(qNameArr[9]);
            if (sTEditAs == null) {
                sTEditAs = (STEditAs) get_default_attribute_value(qNameArr[9]);
            }
        }
        return sTEditAs;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor
    public void xsetEditAs(STEditAs sTEditAs) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STEditAs sTEditAs2 = (STEditAs) typeStore.find_attribute_user(qNameArr[9]);
            if (sTEditAs2 == null) {
                sTEditAs2 = (STEditAs) get_store().add_attribute_user(qNameArr[9]);
            }
            sTEditAs2.set(sTEditAs);
        }
    }
}
