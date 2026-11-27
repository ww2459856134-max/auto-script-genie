package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEastAsianLayout;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFitText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLanguage;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextEffect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextScale;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

/* loaded from: classes3.dex */
public class CTParaRPrOriginalImpl extends XmlComplexContentImpl implements CTParaRPrOriginal {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rStyle"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rFonts"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "b"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "i"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "iCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "caps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smallCaps"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "strike"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dstrike"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "outline"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shadow"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "emboss"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "imprint"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noProof"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "snapToGrid"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vanish"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "webHidden"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "spacing"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "kern"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "position"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sz"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "szCs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "highlight"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "u"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "effect"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "shd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fitText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "vertAlign"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rtl"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cs"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "em"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lang"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "eastAsianLayout"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "specVanish"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "oMath")};
    private static final long serialVersionUID = 1;

    public CTParaRPrOriginalImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewB() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewBCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTBorder addNewBdr() {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewCs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[37]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange addNewDel() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewDstrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEastAsianLayout addNewEastAsianLayout() {
        CTEastAsianLayout cTEastAsianLayoutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEastAsianLayoutAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[40]);
        }
        return cTEastAsianLayoutAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextEffect addNewEffect() {
        CTTextEffect cTTextEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTTextEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEm addNewEm() {
        CTEm cTEm;
        synchronized (monitor()) {
            check_orphaned();
            cTEm = (CTEm) get_store().add_element_user(PROPERTY_QNAME[38]);
        }
        return cTEm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewEmboss() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFitText addNewFitText() {
        CTFitText cTFitText;
        synchronized (monitor()) {
            check_orphaned();
            cTFitText = (CTFitText) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTFitText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHighlight addNewHighlight() {
        CTHighlight cTHighlight;
        synchronized (monitor()) {
            check_orphaned();
            cTHighlight = (CTHighlight) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTHighlight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewI() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewICs() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewImprint() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange addNewIns() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure addNewKern() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTLanguage addNewLang() {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().add_element_user(PROPERTY_QNAME[39]);
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange addNewMoveFrom() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange addNewMoveTo() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewNoProof() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewOMath() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[42]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewOutline() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedHpsMeasure addNewPosition() {
        CTSignedHpsMeasure cTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFonts addNewRFonts() {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTString addNewRStyle() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewRtl() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[36]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewShadow() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTShd addNewShd() {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewSmallCaps() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewSnapToGrid() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedTwipsMeasure addNewSpacing() {
        CTSignedTwipsMeasure cTSignedTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedTwipsMeasure = (CTSignedTwipsMeasure) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTSignedTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewSpecVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[41]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewStrike() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure addNewSz() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure addNewSzCs() {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTUnderline addNewU() {
        CTUnderline cTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderline = (CTUnderline) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewVanish() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTVerticalAlignRun addNewVertAlign() {
        CTVerticalAlignRun cTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRun = (CTVerticalAlignRun) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextScale addNewW() {
        CTTextScale cTTextScale;
        synchronized (monitor()) {
            check_orphaned();
            cTTextScale = (CTTextScale) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTTextScale;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff addNewWebHidden() {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getBArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getBCsArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getBCsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBCsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lv2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBCsArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vl0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBCs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u81
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBCs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kf3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBCsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getBList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jw2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i32
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ki1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewB(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n53
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeB(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nj2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTBorder[] getBdrArray() {
        return (CTBorder[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTBorder[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTBorder> getBdrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cj2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBdrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ee2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBdrArray(((Integer) obj).intValue(), (CTBorder) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vr
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBdr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uo0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBdr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.of1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBdrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getCapsArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getCapsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wk3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCapsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mp1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCapsArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g72
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCaps(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCaps(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ly1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCapsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTColor[] getColorArray() {
        return (CTColor[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTColor[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTColor> getColorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.la0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getColorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lj3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setColorArray(((Integer) obj).intValue(), (CTColor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o82
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewColor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yq3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeColor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ta1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfColorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getCsArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[37], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getCsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mm3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b02
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCsArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a11
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.eg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange getDel() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTrackChange == null) {
                cTTrackChange = null;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getDstrikeArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getDstrikeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uf2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDstrikeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oj1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDstrikeArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.og3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDstrike(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ae1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDstrike(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b10
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDstrikeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEastAsianLayout[] getEastAsianLayoutArray() {
        return getXmlObjectArray(PROPERTY_QNAME[40], (XmlObject[]) new CTEastAsianLayout[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTEastAsianLayout> getEastAsianLayoutList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sv2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEastAsianLayoutArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xn1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEastAsianLayoutArray(((Integer) obj).intValue(), (CTEastAsianLayout) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gk2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEastAsianLayout(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ud3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEastAsianLayout(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y73
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEastAsianLayoutArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextEffect[] getEffectArray() {
        return getXmlObjectArray(PROPERTY_QNAME[31], (XmlObject[]) new CTTextEffect[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTTextEffect> getEffectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jq3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEffectArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k62
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEffectArray(((Integer) obj).intValue(), (CTTextEffect) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xi3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEffect(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gq2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEffect(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yd2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEffectArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEm[] getEmArray() {
        return (CTEm[]) getXmlObjectArray(PROPERTY_QNAME[38], new CTEm[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTEm> getEmList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEmArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEmArray(((Integer) obj).intValue(), (CTEm) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hd3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEm(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rc3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEm(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dk2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEmArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getEmbossArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getEmbossList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hz
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEmbossArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g81
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEmbossArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wu1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEmboss(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEmboss(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEmbossArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFitText[] getFitTextArray() {
        return (CTFitText[]) getXmlObjectArray(PROPERTY_QNAME[34], new CTFitText[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTFitText> getFitTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ws0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFitTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rb2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFitTextArray(((Integer) obj).intValue(), (CTFitText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kp3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFitText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFitText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFitTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHighlight[] getHighlightArray() {
        return (CTHighlight[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTHighlight[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTHighlight> getHighlightList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ax
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHighlightArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n21
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHighlightArray(((Integer) obj).intValue(), (CTHighlight) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ea
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHighlight(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cv2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHighlight(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.me2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHighlightArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getIArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getICsArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getICsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jm1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getICsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jb1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setICsArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jp2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewICs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeICs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pi1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfICsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getIList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fl0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getIArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u11
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setIArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l43
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dp3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeI(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gc1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfIArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getImprintArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getImprintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g52
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getImprintArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.he0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setImprintArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewImprint(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a33
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeImprint(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b43
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfImprintArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange getIns() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTrackChange == null) {
                cTTrackChange = null;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure[] getKernArray() {
        return (CTHpsMeasure[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTHpsMeasure[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTHpsMeasure> getKernList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ca3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getKernArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tz2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setKernArray(((Integer) obj).intValue(), (CTHpsMeasure) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c83
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewKern(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lq2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeKern(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uw0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfKernArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTLanguage[] getLangArray() {
        return (CTLanguage[]) getXmlObjectArray(PROPERTY_QNAME[39], new CTLanguage[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTLanguage> getLangList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.iu0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLangArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xs1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLangArray(((Integer) obj).intValue(), (CTLanguage) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLang(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ui3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLang(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ss2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLangArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange getMoveFrom() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTrackChange == null) {
                cTTrackChange = null;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTrackChange getMoveTo() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTrackChange == null) {
                cTTrackChange = null;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getNoProofArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getNoProofList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ln0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNoProofArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wi3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNoProofArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yu
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNoProof(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pp1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNoProof(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNoProofArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getOMathArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[42], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getOMathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p93
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ip2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e13
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.re2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getOutlineArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getOutlineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOutlineArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e22
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOutlineArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gg2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOutline(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOutline(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k61
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOutlineArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedHpsMeasure[] getPositionArray() {
        return (CTSignedHpsMeasure[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTSignedHpsMeasure[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTSignedHpsMeasure> getPositionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sg1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPositionArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ns1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPositionArray(((Integer) obj).intValue(), (CTSignedHpsMeasure) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u52
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPosition(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yt1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePosition(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ke2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPositionArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFonts[] getRFontsArray() {
        return (CTFonts[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTFonts[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTFonts> getRFontsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l20
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRFontsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gv0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRFontsArray(((Integer) obj).intValue(), (CTFonts) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vz1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRFonts(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRFonts(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.eo2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRFontsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTString[] getRStyleArray() {
        return (CTString[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTString[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTString> getRStyleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRStyleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.up1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRStyleArray(((Integer) obj).intValue(), (CTString) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sj2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRStyle(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRStyle(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.od3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRStyleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getRtlArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[36], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getRtlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRtlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRtlArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hj0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRtl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.px2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRtl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ex
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRtlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getShadowArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getShadowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ve
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getShadowArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b01
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setShadowArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e23
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewShadow(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e80
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeShadow(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x82
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfShadowArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTShd[] getShdArray() {
        return (CTShd[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTShd[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTShd> getShdList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ru1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getShdArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.br2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setShdArray(((Integer) obj).intValue(), (CTShd) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bv0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewShd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeShd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v00
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfShdArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getSmallCapsArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getSmallCapsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zj0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSmallCapsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ny2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSmallCapsArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jm3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSmallCaps(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sl0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSmallCaps(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tl
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSmallCapsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getSnapToGridArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getSnapToGridList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSnapToGridArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ut
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSnapToGridArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z82
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSnapToGrid(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zh2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSnapToGrid(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t51
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSnapToGridArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedTwipsMeasure[] getSpacingArray() {
        return (CTSignedTwipsMeasure[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTSignedTwipsMeasure[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTSignedTwipsMeasure> getSpacingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k91
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSpacingArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSpacingArray(((Integer) obj).intValue(), (CTSignedTwipsMeasure) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yq2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSpacing(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSpacing(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dh0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSpacingArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getSpecVanishArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[41], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getSpecVanishList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sp0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSpecVanishArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yf0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSpecVanishArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yq0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSpecVanish(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xa3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSpecVanish(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSpecVanishArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getStrikeArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getStrikeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getStrikeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setStrikeArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewStrike(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uj1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeStrike(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l02
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfStrikeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure[] getSzArray() {
        return (CTHpsMeasure[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTHpsMeasure[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure[] getSzCsArray() {
        return (CTHpsMeasure[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTHpsMeasure[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTHpsMeasure> getSzCsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fl3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSzCsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oi1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSzCsArray(((Integer) obj).intValue(), (CTHpsMeasure) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xh1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSzCs(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qd3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSzCs(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ah2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSzCsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTHpsMeasure> getSzList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSzArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jr2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSzArray(((Integer) obj).intValue(), (CTHpsMeasure) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tg0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSz(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.st1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSz(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i23
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSzArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTUnderline[] getUArray() {
        return (CTUnderline[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTUnderline[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTUnderline> getUList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i61
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getUArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setUArray(((Integer) obj).intValue(), (CTUnderline) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ce0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewU(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeU(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfUArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getVanishArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getVanishList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n60
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getVanishArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z32
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setVanishArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bs1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewVanish(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.iq0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeVanish(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x52
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfVanishArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTVerticalAlignRun[] getVertAlignArray() {
        return (CTVerticalAlignRun[]) getXmlObjectArray(PROPERTY_QNAME[35], new CTVerticalAlignRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTVerticalAlignRun> getVertAlignList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bm2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getVertAlignArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ik
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setVertAlignArray(((Integer) obj).intValue(), (CTVerticalAlignRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l42
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewVertAlign(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.df2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeVertAlign(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jq0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfVertAlignArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextScale[] getWArray() {
        return (CTTextScale[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTTextScale[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTTextScale> getWList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ls3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getWArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ax1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setWArray(((Integer) obj).intValue(), (CTTextScale) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ft3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewW(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cx1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeW(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c52
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfWArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff[] getWebHiddenArray() {
        return (CTOnOff[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTOnOff[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public List<CTOnOff> getWebHiddenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cd3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getWebHiddenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setWebHiddenArray(((Integer) obj).intValue(), (CTOnOff) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewWebHidden(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeWebHidden(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfWebHiddenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewB(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewBCs(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTBorder insertNewBdr(int i2) {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().insert_element_user(PROPERTY_QNAME[32], i2);
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewCaps(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTColor insertNewColor(int i2) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewCs(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[37], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewDstrike(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEastAsianLayout insertNewEastAsianLayout(int i2) {
        CTEastAsianLayout cTEastAsianLayoutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEastAsianLayoutInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[40], i2);
        }
        return cTEastAsianLayoutInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextEffect insertNewEffect(int i2) {
        CTTextEffect cTTextEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[31], i2);
        }
        return cTTextEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEm insertNewEm(int i2) {
        CTEm cTEm;
        synchronized (monitor()) {
            check_orphaned();
            cTEm = (CTEm) get_store().insert_element_user(PROPERTY_QNAME[38], i2);
        }
        return cTEm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewEmboss(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFitText insertNewFitText(int i2) {
        CTFitText cTFitText;
        synchronized (monitor()) {
            check_orphaned();
            cTFitText = (CTFitText) get_store().insert_element_user(PROPERTY_QNAME[34], i2);
        }
        return cTFitText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHighlight insertNewHighlight(int i2) {
        CTHighlight cTHighlight;
        synchronized (monitor()) {
            check_orphaned();
            cTHighlight = (CTHighlight) get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTHighlight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewI(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewICs(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewImprint(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure insertNewKern(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTLanguage insertNewLang(int i2) {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().insert_element_user(PROPERTY_QNAME[39], i2);
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewNoProof(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewOMath(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[42], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewOutline(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedHpsMeasure insertNewPosition(int i2) {
        CTSignedHpsMeasure cTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFonts insertNewRFonts(int i2) {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTString insertNewRStyle(int i2) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewRtl(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[36], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewShadow(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTShd insertNewShd(int i2) {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().insert_element_user(PROPERTY_QNAME[33], i2);
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewSmallCaps(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewSnapToGrid(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedTwipsMeasure insertNewSpacing(int i2) {
        CTSignedTwipsMeasure cTSignedTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedTwipsMeasure = (CTSignedTwipsMeasure) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTSignedTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewSpecVanish(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[41], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewStrike(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure insertNewSz(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure insertNewSzCs(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTUnderline insertNewU(int i2) {
        CTUnderline cTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderline = (CTUnderline) get_store().insert_element_user(PROPERTY_QNAME[30], i2);
        }
        return cTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewVanish(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTVerticalAlignRun insertNewVertAlign(int i2) {
        CTVerticalAlignRun cTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRun = (CTVerticalAlignRun) get_store().insert_element_user(PROPERTY_QNAME[35], i2);
        }
        return cTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextScale insertNewW(int i2) {
        CTTextScale cTTextScale;
        synchronized (monitor()) {
            check_orphaned();
            cTTextScale = (CTTextScale) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTTextScale;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff insertNewWebHidden(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public boolean isSetDel() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public boolean isSetIns() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public boolean isSetMoveFrom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public boolean isSetMoveTo() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeB(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeBCs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeBdr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeCaps(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeColor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeCs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[37], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeDstrike(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeEastAsianLayout(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[40], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeEffect(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeEm(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[38], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeEmboss(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeFitText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeHighlight(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeI(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeICs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeImprint(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeKern(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeLang(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[39], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeNoProof(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeOMath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[42], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeOutline(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removePosition(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeRFonts(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeRStyle(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeRtl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[36], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeShadow(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeShd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSmallCaps(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSnapToGrid(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSpacing(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSpecVanish(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[41], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeStrike(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSz(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeSzCs(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeU(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeVanish(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeVertAlign(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeW(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void removeWebHidden(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBCsArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBdrArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper(cTBorderArr, PROPERTY_QNAME[32]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setCapsArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setColorArray(CTColor[] cTColorArr) {
        check_orphaned();
        arraySetterHelper(cTColorArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setCsArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[37]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setDel(CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setDstrikeArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEastAsianLayoutArray(CTEastAsianLayout[] cTEastAsianLayoutArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTEastAsianLayoutArr, PROPERTY_QNAME[40]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEffectArray(CTTextEffect[] cTTextEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTextEffectArr, PROPERTY_QNAME[31]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEmArray(CTEm[] cTEmArr) {
        check_orphaned();
        arraySetterHelper(cTEmArr, PROPERTY_QNAME[38]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEmbossArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setFitTextArray(CTFitText[] cTFitTextArr) {
        check_orphaned();
        arraySetterHelper(cTFitTextArr, PROPERTY_QNAME[34]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setHighlightArray(CTHighlight[] cTHighlightArr) {
        check_orphaned();
        arraySetterHelper(cTHighlightArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setIArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setICsArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setImprintArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setIns(CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setKernArray(CTHpsMeasure[] cTHpsMeasureArr) {
        check_orphaned();
        arraySetterHelper(cTHpsMeasureArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setLangArray(CTLanguage[] cTLanguageArr) {
        check_orphaned();
        arraySetterHelper(cTLanguageArr, PROPERTY_QNAME[39]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setMoveFrom(CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setMoveTo(CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setNoProofArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setOMathArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[42]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setOutlineArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setPositionArray(CTSignedHpsMeasure[] cTSignedHpsMeasureArr) {
        check_orphaned();
        arraySetterHelper(cTSignedHpsMeasureArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRFontsArray(CTFonts[] cTFontsArr) {
        check_orphaned();
        arraySetterHelper(cTFontsArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRStyleArray(CTString[] cTStringArr) {
        check_orphaned();
        arraySetterHelper(cTStringArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRtlArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[36]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setShadowArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setShdArray(CTShd[] cTShdArr) {
        check_orphaned();
        arraySetterHelper(cTShdArr, PROPERTY_QNAME[33]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSmallCapsArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSnapToGridArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSpacingArray(CTSignedTwipsMeasure[] cTSignedTwipsMeasureArr) {
        check_orphaned();
        arraySetterHelper(cTSignedTwipsMeasureArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSpecVanishArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[41]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setStrikeArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSzArray(CTHpsMeasure[] cTHpsMeasureArr) {
        check_orphaned();
        arraySetterHelper(cTHpsMeasureArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSzCsArray(CTHpsMeasure[] cTHpsMeasureArr) {
        check_orphaned();
        arraySetterHelper(cTHpsMeasureArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setUArray(CTUnderline[] cTUnderlineArr) {
        check_orphaned();
        arraySetterHelper(cTUnderlineArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setVanishArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setVertAlignArray(CTVerticalAlignRun[] cTVerticalAlignRunArr) {
        check_orphaned();
        arraySetterHelper(cTVerticalAlignRunArr, PROPERTY_QNAME[35]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setWArray(CTTextScale[] cTTextScaleArr) {
        check_orphaned();
        arraySetterHelper(cTTextScaleArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setWebHiddenArray(CTOnOff[] cTOnOffArr) {
        check_orphaned();
        arraySetterHelper(cTOnOffArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfBArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfBCsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfBdrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfCapsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfCsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[37]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfDstrikeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfEastAsianLayoutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[40]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfEmArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[38]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfEmbossArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfFitTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfHighlightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfIArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfICsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfImprintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfKernArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfLangArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[39]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfNoProofArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[42]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfOutlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfPositionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfRFontsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfRStyleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfRtlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[36]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfShdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSmallCapsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSnapToGridArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSpacingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSpecVanishArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[41]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfStrikeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSzArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfSzCsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfUArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfVanishArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfVertAlignArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[35]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfWArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public int sizeOfWebHiddenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void unsetDel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void unsetIns() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void unsetMoveFrom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void unsetMoveTo() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getBArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getBCsArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTBorder getBdrArray(int i2) {
        CTBorder cTBorder;
        synchronized (monitor()) {
            check_orphaned();
            cTBorder = (CTBorder) get_store().find_element_user(PROPERTY_QNAME[32], i2);
            if (cTBorder == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorder;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getCapsArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTColor getColorArray(int i2) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getCsArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[37], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getDstrikeArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEastAsianLayout getEastAsianLayoutArray(int i2) {
        CTEastAsianLayout cTEastAsianLayoutFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEastAsianLayoutFind_element_user = get_store().find_element_user(PROPERTY_QNAME[40], i2);
            if (cTEastAsianLayoutFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEastAsianLayoutFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextEffect getEffectArray(int i2) {
        CTTextEffect cTTextEffectFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTextEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[31], i2);
            if (cTTextEffectFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTEm getEmArray(int i2) {
        CTEm cTEm;
        synchronized (monitor()) {
            check_orphaned();
            cTEm = (CTEm) get_store().find_element_user(PROPERTY_QNAME[38], i2);
            if (cTEm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getEmbossArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFitText getFitTextArray(int i2) {
        CTFitText cTFitText;
        synchronized (monitor()) {
            check_orphaned();
            cTFitText = (CTFitText) get_store().find_element_user(PROPERTY_QNAME[34], i2);
            if (cTFitText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFitText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHighlight getHighlightArray(int i2) {
        CTHighlight cTHighlight;
        synchronized (monitor()) {
            check_orphaned();
            cTHighlight = (CTHighlight) get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTHighlight == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHighlight;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getIArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getICsArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getImprintArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure getKernArray(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTHpsMeasure == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTLanguage getLangArray(int i2) {
        CTLanguage cTLanguage;
        synchronized (monitor()) {
            check_orphaned();
            cTLanguage = (CTLanguage) get_store().find_element_user(PROPERTY_QNAME[39], i2);
            if (cTLanguage == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLanguage;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getNoProofArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getOMathArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[42], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getOutlineArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedHpsMeasure getPositionArray(int i2) {
        CTSignedHpsMeasure cTSignedHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedHpsMeasure = (CTSignedHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTSignedHpsMeasure == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSignedHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTFonts getRFontsArray(int i2) {
        CTFonts cTFonts;
        synchronized (monitor()) {
            check_orphaned();
            cTFonts = (CTFonts) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTFonts == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFonts;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTString getRStyleArray(int i2) {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getRtlArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[36], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getShadowArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTShd getShdArray(int i2) {
        CTShd cTShd;
        synchronized (monitor()) {
            check_orphaned();
            cTShd = (CTShd) get_store().find_element_user(PROPERTY_QNAME[33], i2);
            if (cTShd == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShd;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getSmallCapsArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getSnapToGridArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTSignedTwipsMeasure getSpacingArray(int i2) {
        CTSignedTwipsMeasure cTSignedTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTSignedTwipsMeasure = (CTSignedTwipsMeasure) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTSignedTwipsMeasure == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSignedTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getSpecVanishArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[41], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getStrikeArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure getSzArray(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTHpsMeasure == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTHpsMeasure getSzCsArray(int i2) {
        CTHpsMeasure cTHpsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            cTHpsMeasure = (CTHpsMeasure) get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTHpsMeasure == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHpsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTUnderline getUArray(int i2) {
        CTUnderline cTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderline = (CTUnderline) get_store().find_element_user(PROPERTY_QNAME[30], i2);
            if (cTUnderline == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getVanishArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTVerticalAlignRun getVertAlignArray(int i2) {
        CTVerticalAlignRun cTVerticalAlignRun;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignRun = (CTVerticalAlignRun) get_store().find_element_user(PROPERTY_QNAME[35], i2);
            if (cTVerticalAlignRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVerticalAlignRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTTextScale getWArray(int i2) {
        CTTextScale cTTextScale;
        synchronized (monitor()) {
            check_orphaned();
            cTTextScale = (CTTextScale) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTTextScale == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTextScale;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public CTOnOff getWebHiddenArray(int i2) {
        CTOnOff cTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            cTOnOff = (CTOnOff) get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTOnOff == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBCsArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setBdrArray(int i2, CTBorder cTBorder) throws Throwable {
        generatedSetterHelperImpl(cTBorder, PROPERTY_QNAME[32], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setCapsArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setColorArray(int i2, CTColor cTColor) throws Throwable {
        generatedSetterHelperImpl(cTColor, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setCsArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[37], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setDstrikeArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEastAsianLayoutArray(int i2, CTEastAsianLayout cTEastAsianLayout) throws Throwable {
        generatedSetterHelperImpl(cTEastAsianLayout, PROPERTY_QNAME[40], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEffectArray(int i2, CTTextEffect cTTextEffect) throws Throwable {
        generatedSetterHelperImpl(cTTextEffect, PROPERTY_QNAME[31], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEmArray(int i2, CTEm cTEm) throws Throwable {
        generatedSetterHelperImpl(cTEm, PROPERTY_QNAME[38], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setEmbossArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setFitTextArray(int i2, CTFitText cTFitText) throws Throwable {
        generatedSetterHelperImpl(cTFitText, PROPERTY_QNAME[34], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setHighlightArray(int i2, CTHighlight cTHighlight) throws Throwable {
        generatedSetterHelperImpl(cTHighlight, PROPERTY_QNAME[29], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setIArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setICsArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setImprintArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setKernArray(int i2, CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setLangArray(int i2, CTLanguage cTLanguage) throws Throwable {
        generatedSetterHelperImpl(cTLanguage, PROPERTY_QNAME[39], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setNoProofArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setOMathArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[42], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setOutlineArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setPositionArray(int i2, CTSignedHpsMeasure cTSignedHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTSignedHpsMeasure, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRFontsArray(int i2, CTFonts cTFonts) throws Throwable {
        generatedSetterHelperImpl(cTFonts, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRStyleArray(int i2, CTString cTString) throws Throwable {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setRtlArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[36], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setShadowArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setShdArray(int i2, CTShd cTShd) throws Throwable {
        generatedSetterHelperImpl(cTShd, PROPERTY_QNAME[33], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSmallCapsArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSnapToGridArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSpacingArray(int i2, CTSignedTwipsMeasure cTSignedTwipsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTSignedTwipsMeasure, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSpecVanishArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[41], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setStrikeArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSzArray(int i2, CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setSzCsArray(int i2, CTHpsMeasure cTHpsMeasure) throws Throwable {
        generatedSetterHelperImpl(cTHpsMeasure, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setUArray(int i2, CTUnderline cTUnderline) throws Throwable {
        generatedSetterHelperImpl(cTUnderline, PROPERTY_QNAME[30], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setVanishArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setVertAlignArray(int i2, CTVerticalAlignRun cTVerticalAlignRun) throws Throwable {
        generatedSetterHelperImpl(cTVerticalAlignRun, PROPERTY_QNAME[35], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setWArray(int i2, CTTextScale cTTextScale) throws Throwable {
        generatedSetterHelperImpl(cTTextScale, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPrOriginal
    public void setWebHiddenArray(int i2, CTOnOff cTOnOff) throws Throwable {
        generatedSetterHelperImpl(cTOnOff, PROPERTY_QNAME[21], i2, (short) 2);
    }
}
