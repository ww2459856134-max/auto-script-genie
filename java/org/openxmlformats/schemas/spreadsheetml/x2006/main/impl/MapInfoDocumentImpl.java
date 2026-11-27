package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

/* loaded from: classes2.dex */
public class MapInfoDocumentImpl extends XmlComplexContentImpl implements MapInfoDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "MapInfo")};
    private static final long serialVersionUID = 1;

    public MapInfoDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public CTMapInfo addNewMapInfo() {
        CTMapInfo cTMapInfo;
        synchronized (monitor()) {
            check_orphaned();
            cTMapInfo = (CTMapInfo) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTMapInfo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public CTMapInfo getMapInfo() {
        CTMapInfo cTMapInfo;
        synchronized (monitor()) {
            check_orphaned();
            cTMapInfo = (CTMapInfo) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTMapInfo == null) {
                cTMapInfo = null;
            }
        }
        return cTMapInfo;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument
    public void setMapInfo(CTMapInfo cTMapInfo) throws Throwable {
        generatedSetterHelperImpl(cTMapInfo, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
