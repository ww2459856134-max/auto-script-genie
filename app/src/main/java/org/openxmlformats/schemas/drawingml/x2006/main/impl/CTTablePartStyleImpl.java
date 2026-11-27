package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;

/* loaded from: classes2.dex */
public class CTTablePartStyleImpl extends XmlComplexContentImpl implements CTTablePartStyle {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tcTxStyle"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tcStyle")};
    private static final long serialVersionUID = 1;

    public CTTablePartStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleCellStyle addNewTcStyle() {
        CTTableStyleCellStyle cTTableStyleCellStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleCellStyle = (CTTableStyleCellStyle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTableStyleCellStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleTextStyle addNewTcTxStyle() {
        CTTableStyleTextStyle cTTableStyleTextStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleTextStyle = (CTTableStyleTextStyle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableStyleTextStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleCellStyle getTcStyle() {
        CTTableStyleCellStyle cTTableStyleCellStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleCellStyle = (CTTableStyleCellStyle) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTableStyleCellStyle == null) {
                cTTableStyleCellStyle = null;
            }
        }
        return cTTableStyleCellStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleTextStyle getTcTxStyle() {
        CTTableStyleTextStyle cTTableStyleTextStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleTextStyle = (CTTableStyleTextStyle) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableStyleTextStyle == null) {
                cTTableStyleTextStyle = null;
            }
        }
        return cTTableStyleTextStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public boolean isSetTcStyle() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public boolean isSetTcTxStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void setTcStyle(CTTableStyleCellStyle cTTableStyleCellStyle) throws Throwable {
        generatedSetterHelperImpl(cTTableStyleCellStyle, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void setTcTxStyle(CTTableStyleTextStyle cTTableStyleTextStyle) throws Throwable {
        generatedSetterHelperImpl(cTTableStyleTextStyle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void unsetTcStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void unsetTcTxStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
