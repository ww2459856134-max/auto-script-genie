package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeaders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextDirection;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;

/* loaded from: classes3.dex */
public class CTTcPrBaseImpl extends XmlComplexContentImpl implements CTTcPrBase {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cnfStyle"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcW"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gridSpan"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hMerge"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vMerge"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcBorders"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noWrap"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcMar"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "textDirection"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcFitText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vAlign"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hideMark"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "headers")};
    private static final long serialVersionUID = 1;

    public CTTcPrBaseImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf addNewCnfStyle() {
        CTCnf cTCnf;
        synchronized (monitor()) {
            check_orphaned();
            cTCnf = (CTCnf) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCnf;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber addNewGridSpan() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge addNewHMerge() {
        CTHMerge cTHMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTHMerge = (CTHMerge) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTHMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHeaders addNewHeaders() {
        CTHeaders cTHeadersAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeadersAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTHeadersAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewHideMark() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewNoWrap() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders addNewTcBorders() {
        CTTcBorders cTTcBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTTcBorders = (CTTcBorders) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTcBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff addNewTcFitText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar addNewTcMar() {
        CTTcMar cTTcMar;
        synchronized (monitor()) {
            check_orphaned();
            cTTcMar = (CTTcMar) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTcMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth addNewTcW() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection addNewTextDirection() {
        CTTextDirection cTTextDirection;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirection = (CTTextDirection) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTextDirection;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc addNewVAlign() {
        CTVerticalJc cTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJc = (CTVerticalJc) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge addNewVMerge() {
        CTVMerge cTVMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTVMerge = (CTVMerge) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTVMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTCnf getCnfStyle() {
        CTCnf cTCnf;
        synchronized (monitor()) {
            check_orphaned();
            cTCnf = (CTCnf) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTCnf == null) {
                cTCnf = null;
            }
        }
        return cTCnf;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTDecimalNumber getGridSpan() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHMerge getHMerge() {
        CTHMerge cTHMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTHMerge = (CTHMerge) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTHMerge == null) {
                cTHMerge = null;
            }
        }
        return cTHMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTHeaders getHeaders() {
        CTHeaders cTHeadersFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeadersFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTHeadersFind_element_user == null) {
                cTHeadersFind_element_user = null;
            }
        }
        return cTHeadersFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getHideMark() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getNoWrap() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTShd getShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTShd == null) {
                cTShd = null;
            }
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcBorders getTcBorders() {
        CTTcBorders cTTcBorders;
        synchronized (monitor()) {
            check_orphaned();
            cTTcBorders = (CTTcBorders) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTcBorders == null) {
                cTTcBorders = null;
            }
        }
        return cTTcBorders;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTOnOff getTcFitText() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTcMar getTcMar() {
        CTTcMar cTTcMar;
        synchronized (monitor()) {
            check_orphaned();
            cTTcMar = (CTTcMar) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTcMar == null) {
                cTTcMar = null;
            }
        }
        return cTTcMar;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTblWidth getTcW() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTTextDirection getTextDirection() {
        CTTextDirection cTTextDirection;
        synchronized (monitor()) {
            check_orphaned();
            cTTextDirection = (CTTextDirection) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTextDirection == null) {
                cTTextDirection = null;
            }
        }
        return cTTextDirection;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVerticalJc getVAlign() {
        CTVerticalJc cTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalJc = (CTVerticalJc) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTVerticalJc == null) {
                cTVerticalJc = null;
            }
        }
        return cTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public CTVMerge getVMerge() {
        CTVMerge cTVMerge;
        synchronized (monitor()) {
            check_orphaned();
            cTVMerge = (CTVMerge) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTVMerge == null) {
                cTVMerge = null;
            }
        }
        return cTVMerge;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetCnfStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetGridSpan() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHeaders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetHideMark() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetNoWrap() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetShd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcBorders() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcFitText() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcMar() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTcW() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetTextDirection() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVAlign() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public boolean isSetVMerge() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setCnfStyle(CTCnf cTCnf) throws Throwable {
        generatedSetterHelperImpl(cTCnf, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setGridSpan(CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHMerge(CTHMerge cTHMerge) throws Throwable {
        generatedSetterHelperImpl(cTHMerge, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHeaders(CTHeaders cTHeaders) throws Throwable {
        generatedSetterHelperImpl(cTHeaders, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setHideMark(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setNoWrap(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setShd(CTShd cTShd) throws Throwable {
        generatedSetterHelperImpl(cTShd, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcBorders(CTTcBorders cTTcBorders) throws Throwable {
        generatedSetterHelperImpl(cTTcBorders, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcFitText(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcMar(CTTcMar cTTcMar) throws Throwable {
        generatedSetterHelperImpl(cTTcMar, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTcW(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setTextDirection(CTTextDirection cTTextDirection) throws Throwable {
        generatedSetterHelperImpl(cTTextDirection, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVAlign(CTVerticalJc cTVerticalJc) throws Throwable {
        generatedSetterHelperImpl(cTVerticalJc, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void setVMerge(CTVMerge cTVMerge) throws Throwable {
        generatedSetterHelperImpl(cTVMerge, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetCnfStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetGridSpan() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHeaders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetHideMark() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetNoWrap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetShd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcBorders() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcFitText() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcMar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTcW() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetTextDirection() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVAlign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPrBase
    public void unsetVMerge() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }
}
