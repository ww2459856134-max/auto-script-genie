package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties;

/* loaded from: classes2.dex */
public class CTStretchInfoPropertiesImpl extends XmlComplexContentImpl implements CTStretchInfoProperties {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "fillRect")};
    private static final long serialVersionUID = 1;

    public CTStretchInfoPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public CTRelativeRect addNewFillRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public CTRelativeRect getFillRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTRelativeRect == null) {
                cTRelativeRect = null;
            }
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public boolean isSetFillRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public void setFillRect(CTRelativeRect cTRelativeRect) throws Throwable {
        generatedSetterHelperImpl(cTRelativeRect, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStretchInfoProperties
    public void unsetFillRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
