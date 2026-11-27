package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

/* loaded from: classes3.dex */
public class CTTblCellMarImpl extends XmlComplexContentImpl implements CTTblCellMar {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "start"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "end"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right")};
    private static final long serialVersionUID = 1;

    public CTTblCellMarImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewBottom() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewEnd() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewLeft() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewRight() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewStart() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth addNewTop() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getBottom() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getEnd() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getLeft() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getRight() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getStart() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public CTTblWidth getTop() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTblWidth == null) {
                cTTblWidth = null;
            }
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetEnd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetStart() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setBottom(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setEnd(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setLeft(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setRight(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setStart(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void setTop(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetEnd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetStart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
