package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrGeneral;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblStylePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

/* loaded from: classes3.dex */
public class CTStyleImpl extends XmlComplexContentImpl implements CTStyle {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "aliases"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "basedOn"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "next"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "link"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoRedefine"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hidden"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiPriority"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "semiHidden"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "unhideWhenUsed"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "qFormat"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "locked"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personal"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalCompose"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalReply"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStylePr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", SocialConstants.PARAM_TYPE), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleId"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customStyle")};
    private static final long serialVersionUID = 1;

    public CTStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewAliases() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewAutoRedefine() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewBasedOn() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewLocked() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString addNewNext() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTPPrGeneral addNewPPr() {
        CTPPrGeneral cTPPrGeneral;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrGeneral = (CTPPrGeneral) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTPPrGeneral;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonal() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonalCompose() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewPersonalReply() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewQFormat() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTRPr addNewRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTLongHexNumber addNewRsid() {
        CTLongHexNumber cTLongHexNumberAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTLongHexNumberAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewSemiHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblPrBase addNewTblPr() {
        CTTblPrBase cTTblPrBase;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrBase = (CTTblPrBase) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTTblPrBase;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr addNewTblStylePr() {
        CTTblStylePr cTTblStylePrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblStylePrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTTblStylePrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTcPr addNewTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTrPr addNewTrPr() {
        CTTrPr cTTrPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTrPr = (CTTrPr) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTTrPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTDecimalNumber addNewUiPriority() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff addNewUnhideWhenUsed() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getAliases() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getAutoRedefine() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getBasedOn() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public Object getCustomStyle() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[25]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public Object getDefault() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[24]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getLink() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getLocked() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getName() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTString getNext() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTPPrGeneral getPPr() {
        CTPPrGeneral cTPPrGeneral;
        synchronized (monitor()) {
            check_orphaned();
            cTPPrGeneral = (CTPPrGeneral) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTPPrGeneral == null) {
                cTPPrGeneral = null;
            }
        }
        return cTPPrGeneral;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonal() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonalCompose() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getPersonalReply() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getQFormat() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTRPr getRPr() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            if (cTRPr == null) {
                cTRPr = null;
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTLongHexNumber getRsid() {
        CTLongHexNumber cTLongHexNumberFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLongHexNumberFind_element_user = get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTLongHexNumberFind_element_user == null) {
                cTLongHexNumberFind_element_user = null;
            }
        }
        return cTLongHexNumberFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getSemiHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public String getStyleId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[23]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblPrBase getTblPr() {
        CTTblPrBase cTTblPrBase;
        synchronized (monitor()) {
            check_orphaned();
            cTTblPrBase = (CTTblPrBase) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            if (cTTblPrBase == null) {
                cTTblPrBase = null;
            }
        }
        return cTTblPrBase;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr[] getTblStylePrArray() {
        return getXmlObjectArray(PROPERTY_QNAME[21], (XmlObject[]) new CTTblStylePr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public List<CTTblStylePr> getTblStylePrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n13
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTblStylePrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kc0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTblStylePrArray(((Integer) obj).intValue(), (CTTblStylePr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.w70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTblStylePr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.eo3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTblStylePr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l22
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTblStylePrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTcPr getTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().find_element_user(PROPERTY_QNAME[20], 0);
            if (cTTcPr == null) {
                cTTcPr = null;
            }
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTrPr getTrPr() {
        CTTrPr cTTrPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTrPr = (CTTrPr) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (cTTrPr == null) {
                cTTrPr = null;
            }
        }
        return cTTrPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STStyleType.Enum getType() {
        STStyleType.Enum r1;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[22]);
            r1 = simpleValue == null ? null : (STStyleType.Enum) simpleValue.getEnumValue();
        }
        return r1;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTDecimalNumber getUiPriority() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTDecimalNumber == null) {
                cTDecimalNumber = null;
            }
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTOnOff getUnhideWhenUsed() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTOnOff == null) {
                cTOnOff = null;
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr insertNewTblStylePr(int i2) {
        CTTblStylePr cTTblStylePrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblStylePrInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTTblStylePrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetAliases() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetAutoRedefine() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetBasedOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetCustomStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[25]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetDefault() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[24]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetLink() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetLocked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetNext() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonalCompose() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetPersonalReply() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetQFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetRsid() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetSemiHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetStyleId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[23]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTblPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[20]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetTrPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[22]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetUiPriority() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public boolean isSetUnhideWhenUsed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void removeTblStylePr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setAliases(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setAutoRedefine(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setBasedOn(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setCustomStyle(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[25]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setDefault(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[24]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setHidden(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setLink(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setLocked(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setName(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setNext(CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPPr(CTPPrGeneral cTPPrGeneral) throws Throwable {
        generatedSetterHelperImpl(cTPPrGeneral, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonal(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonalCompose(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setPersonalReply(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setQFormat(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setRPr(CTRPr cTRPr) throws Throwable {
        generatedSetterHelperImpl(cTRPr, PROPERTY_QNAME[17], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setRsid(CTLongHexNumber cTLongHexNumber) throws Throwable {
        generatedSetterHelperImpl(cTLongHexNumber, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setSemiHidden(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setStyleId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[23]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblPr(CTTblPrBase cTTblPrBase) throws Throwable {
        generatedSetterHelperImpl(cTTblPrBase, PROPERTY_QNAME[18], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblStylePrArray(CTTblStylePr[] cTTblStylePrArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTblStylePrArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTcPr(CTTcPr cTTcPr) throws Throwable {
        generatedSetterHelperImpl(cTTcPr, PROPERTY_QNAME[20], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTrPr(CTTrPr cTTrPr) throws Throwable {
        generatedSetterHelperImpl(cTTrPr, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setType(STStyleType.Enum r6) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[22]);
            }
            simpleValue.setEnumValue(r6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setUiPriority(CTDecimalNumber cTDecimalNumber) throws Throwable {
        generatedSetterHelperImpl(cTDecimalNumber, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setUnhideWhenUsed(CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public int sizeOfTblStylePrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetAliases() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetAutoRedefine() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetBasedOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetCustomStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[25]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetDefault() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[24]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetLink() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetLocked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetNext() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonalCompose() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetPersonalReply() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetRsid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[23]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTblPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetTrPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[22]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetUiPriority() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void unsetUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff xgetCustomStyle() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[25]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STOnOff xgetDefault() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[24]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STString xgetStyleId() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(PROPERTY_QNAME[23]);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public STStyleType xgetType() {
        STStyleType sTStyleType;
        synchronized (monitor()) {
            check_orphaned();
            sTStyleType = (STStyleType) get_store().find_attribute_user(PROPERTY_QNAME[22]);
        }
        return sTStyleType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetCustomStyle(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[25]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[25]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetDefault(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[24]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[24]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetStyleId(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STString sTString2 = (STString) typeStore.find_attribute_user(qNameArr[23]);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qNameArr[23]);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void xsetType(STStyleType sTStyleType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STStyleType sTStyleType2 = (STStyleType) typeStore.find_attribute_user(qNameArr[22]);
            if (sTStyleType2 == null) {
                sTStyleType2 = (STStyleType) get_store().add_attribute_user(qNameArr[22]);
            }
            sTStyleType2.set(sTStyleType);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public CTTblStylePr getTblStylePrArray(int i2) {
        CTTblStylePr cTTblStylePrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTblStylePrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTTblStylePrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTblStylePrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle
    public void setTblStylePrArray(int i2, CTTblStylePr cTTblStylePr) throws Throwable {
        generatedSetterHelperImpl(cTTblStylePr, PROPERTY_QNAME[21], i2, (short) 2);
    }
}
