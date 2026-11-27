package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet;

/* loaded from: classes2.dex */
public class CTTextBlipBulletImpl extends XmlComplexContentImpl implements CTTextBlipBullet {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "blip")};
    private static final long serialVersionUID = 1;

    public CTTextBlipBulletImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet
    public CTBlip addNewBlip() {
        CTBlip cTBlip;
        synchronized (monitor()) {
            check_orphaned();
            cTBlip = (CTBlip) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBlip;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet
    public CTBlip getBlip() {
        CTBlip cTBlip;
        synchronized (monitor()) {
            check_orphaned();
            cTBlip = (CTBlip) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTBlip == null) {
                cTBlip = null;
            }
        }
        return cTBlip;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet
    public void setBlip(CTBlip cTBlip) throws Throwable {
        generatedSetterHelperImpl(cTBlip, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
