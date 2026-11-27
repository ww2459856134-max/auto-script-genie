package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;

/* loaded from: classes2.dex */
public class CTGraphicalObjectImpl extends XmlComplexContentImpl implements CTGraphicalObject {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "graphicData")};
    private static final long serialVersionUID = 1;

    public CTGraphicalObjectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public CTGraphicalObjectData addNewGraphicData() {
        CTGraphicalObjectData cTGraphicalObjectData;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectData = (CTGraphicalObjectData) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGraphicalObjectData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public CTGraphicalObjectData getGraphicData() {
        CTGraphicalObjectData cTGraphicalObjectData;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectData = (CTGraphicalObjectData) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGraphicalObjectData == null) {
                cTGraphicalObjectData = null;
            }
        }
        return cTGraphicalObjectData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public void setGraphicData(CTGraphicalObjectData cTGraphicalObjectData) throws Throwable {
        generatedSetterHelperImpl(cTGraphicalObjectData, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
