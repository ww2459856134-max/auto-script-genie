package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTAcc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBar;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBorderBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTCtrlPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTEqArr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTF;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTFunc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTGroupChr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimLow;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimUpp;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTNary;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTPhant;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRad;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSPre;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSubSup;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes2.dex */
public class CTOMathArgImpl extends XmlComplexContentImpl implements CTOMathArg {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "argPr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "box"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "d"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "f"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "func"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "m"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "r"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldSimple"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyperlink"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "ctrlPr")};
    private static final long serialVersionUID = 1;

    public CTOMathArgImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc addNewAcc() {
        CTAcc cTAccAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTAccAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathArgPr addNewArgPr() {
        CTOMathArgPr cTOMathArgPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArgPrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOMathArgPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar addNewBar() {
        CTBar cTBarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox addNewBorderBox() {
        CTBorderBox cTBorderBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBorderBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox addNewBox() {
        CTBox cTBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[36]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCtrlPr addNewCtrlPr() {
        CTCtrlPr cTCtrlPr;
        synchronized (monitor()) {
            check_orphaned();
            cTCtrlPr = (CTCtrlPr) get_store().add_element_user(PROPERTY_QNAME[51]);
        }
        return cTCtrlPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[40]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[39]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[38]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[37]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[42]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[41]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[44]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[43]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD addNewD() {
        CTD ctd;
        synchronized (monitor()) {
            check_orphaned();
            ctd = (CTD) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return ctd;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[46]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr addNewEqArr() {
        CTEqArr cTEqArrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTEqArrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF addNewF() {
        CTF ctfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return ctfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSimpleField addNewFldSimple() {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc addNewFunc() {
        CTFunc cTFuncAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTFuncAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr addNewGroupChr() {
        CTGroupChr cTGroupChrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTGroupChrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[45]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow addNewLimLow() {
        CTLimLow cTLimLowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTLimLowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp addNewLimUpp() {
        CTLimUpp cTLimUppAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTLimUppAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM addNewM() {
        CTM ctm;
        synchronized (monitor()) {
            check_orphaned();
            ctm = (CTM) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return ctm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[47]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[48]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary addNewNary() {
        CTNary cTNaryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTNaryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(PROPERTY_QNAME[50]);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(PROPERTY_QNAME[49]);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm addNewPermEnd() {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant addNewPhant() {
        CTPhant cTPhantAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTPhantAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR addNewR() {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad addNewRad() {
        CTRad cTRadAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTRadAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre addNewSPre() {
        CTSPre cTSPreAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTSPreAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub addNewSSub() {
        CTSSub cTSSub;
        synchronized (monitor()) {
            check_orphaned();
            cTSSub = (CTSSub) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTSSub;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup addNewSSubSup() {
        CTSSubSup cTSSubSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTSSubSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup addNewSSup() {
        CTSSup cTSSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTSSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc[] getAccArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTAcc[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTAcc> getAccList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAccArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ap
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAccArray(((Integer) obj).intValue(), (CTAcc) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAcc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAcc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ui
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAccArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathArgPr getArgPr() {
        CTOMathArgPr cTOMathArgPrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArgPrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTOMathArgPrFind_element_user == null) {
                cTOMathArgPrFind_element_user = null;
            }
        }
        return cTOMathArgPrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar[] getBarArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTBar[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBar> getBarList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBarArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.t0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBarArray(((Integer) obj).intValue(), (CTBar) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBar(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBar(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBarArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getBookmarkEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getBookmarkEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.rn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kd
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ho
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark[] getBookmarkStartArray() {
        return (CTBookmark[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBookmark> getBookmarkStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.li
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkStartArray(((Integer) obj).intValue(), (CTBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.nf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xh
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zc
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox[] getBorderBoxArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTBorderBox[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBorderBox> getBorderBoxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ol
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBorderBoxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBorderBoxArray(((Integer) obj).intValue(), (CTBorderBox) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.re
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBorderBox(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBorderBox(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBorderBoxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox[] getBoxArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTBox[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBox> getBoxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.uf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBoxArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBoxArray(((Integer) obj).intValue(), (CTBox) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBox(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBox(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ek
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBoxArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getCommentRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[36], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getCommentRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.um
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getCommentRangeStartArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[35], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getCommentRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeStartArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCtrlPr getCtrlPr() {
        CTCtrlPr cTCtrlPr;
        synchronized (monitor()) {
            check_orphaned();
            cTCtrlPr = (CTCtrlPr) get_store().find_element_user(PROPERTY_QNAME[51], 0);
            if (cTCtrlPr == null) {
                cTCtrlPr = null;
            }
        }
        return cTCtrlPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCustomXmlRun[] getCustomXmlArray() {
        return (CTCustomXmlRun[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTCustomXmlRun[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[40], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.dl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.na
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[39], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[38], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.tj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[37], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.nb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTCustomXmlRun> getCustomXmlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.t5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlArray(((Integer) obj).intValue(), (CTCustomXmlRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXml(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXml(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.de
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[42], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ch
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ad
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xe
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[41], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ep
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.eb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[44], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vf
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[43], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD[] getDArray() {
        return (CTD[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTD[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTD> getDList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.on
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.t8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDArray(((Integer) obj).intValue(), (CTD) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewD(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oo
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeD(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xl
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getDelArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[46], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getDelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ni
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ei
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr[] getEqArrArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTEqArr[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTEqArr> getEqArrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEqArrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ef
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEqArrArray(((Integer) obj).intValue(), (CTEqArr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEqArr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEqArr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEqArrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF[] getFArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTF[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTF> getFList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFArray(((Integer) obj).intValue(), (CTF) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewF(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeF(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSimpleField[] getFldSimpleArray() {
        return (CTSimpleField[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTSimpleField[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSimpleField> getFldSimpleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ii
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFldSimpleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFldSimpleArray(((Integer) obj).intValue(), (CTSimpleField) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.al
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFldSimple(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFldSimple(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.le
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFldSimpleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc[] getFuncArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTFunc[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTFunc> getFuncList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFuncArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFuncArray(((Integer) obj).intValue(), (CTFunc) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ci
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFunc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFunc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFuncArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr[] getGroupChrArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTGroupChr[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTGroupChr> getGroupChrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGroupChrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bm
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGroupChrArray(((Integer) obj).intValue(), (CTGroupChr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGroupChr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGroupChr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGroupChrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTHyperlink[] getHyperlinkArray() {
        return (CTHyperlink[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTHyperlink[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTHyperlink> getHyperlinkList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHyperlinkArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHyperlinkArray(((Integer) obj).intValue(), (CTHyperlink) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHyperlink(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.aj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHyperlink(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.rj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHyperlinkArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getInsArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[45], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getInsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInsArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewIns(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeIns(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.t
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow[] getLimLowArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTLimLow[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTLimLow> getLimLowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLimLowArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ka
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLimLowArray(((Integer) obj).intValue(), (CTLimLow) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLimLow(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLimLow(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.h
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLimLowArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp[] getLimUppArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTLimUpp[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTLimUpp> getLimUppList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLimUppArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLimUppArray(((Integer) obj).intValue(), (CTLimUpp) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLimUpp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLimUpp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLimUppArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM[] getMArray() {
        return (CTM[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTM[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTM> getMList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.la
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMArray(((Integer) obj).intValue(), (CTM) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewM(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.np
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeM(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getMoveFromArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[47], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getMoveFromList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.tc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFrom(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFrom(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.cp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ld
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ul
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[31], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.rh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.t7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mo
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.cc
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getMoveToArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[48], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getMoveToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ag
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getMoveToRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[34], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ec
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ac
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xn
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary[] getNaryArray() {
        return getXmlObjectArray(PROPERTY_QNAME[13], (XmlObject[]) new CTNary[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTNary> getNaryList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNaryArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNaryArray(((Integer) obj).intValue(), (CTNary) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNary(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ie
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNary(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNaryArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath[] getOMathArray() {
        return (CTOMath[]) getXmlObjectArray(PROPERTY_QNAME[50], new CTOMath[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTOMath> getOMathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathArray(((Integer) obj).intValue(), (CTOMath) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara[] getOMathParaArray() {
        return (CTOMathPara[]) getXmlObjectArray(PROPERTY_QNAME[49], new CTOMathPara[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTOMathPara> getOMathParaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathParaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathParaArray(((Integer) obj).intValue(), (CTOMathPara) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMathPara(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMathPara(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathParaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm[] getPermEndArray() {
        return (CTPerm[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTPerm[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPerm> getPermEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermEndArray(((Integer) obj).intValue(), (CTPerm) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart[] getPermStartArray() {
        return (CTPermStart[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTPermStart[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPermStart> getPermStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.an
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qn
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermStartArray(((Integer) obj).intValue(), (CTPermStart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.tg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oj
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant[] getPhantArray() {
        return getXmlObjectArray(PROPERTY_QNAME[14], (XmlObject[]) new CTPhant[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPhant> getPhantList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.db
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPhantArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPhantArray(((Integer) obj).intValue(), (CTPhant) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.h5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPhant(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePhant(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ge
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPhantArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr[] getProofErrArray() {
        return (CTProofErr[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTProofErr[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTProofErr> getProofErrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getProofErrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setProofErrArray(((Integer) obj).intValue(), (CTProofErr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProofErr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProofErr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.am
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfProofErrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR[] getRArray() {
        return (CTR[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTR[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTR> getRList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.cl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.nc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRArray(((Integer) obj).intValue(), (CTR) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeR(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad[] getRadArray() {
        return getXmlObjectArray(PROPERTY_QNAME[15], (XmlObject[]) new CTRad[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRad> getRadList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRadArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.lo
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRadArray(((Integer) obj).intValue(), (CTRad) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.we
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRad(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.dd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRad(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.lp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRadArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre[] getSPreArray() {
        return getXmlObjectArray(PROPERTY_QNAME[16], (XmlObject[]) new CTSPre[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSPre> getSPreList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.il
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSPreArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSPreArray(((Integer) obj).intValue(), (CTSPre) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSPre(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kp
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSPre(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSPreArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub[] getSSubArray() {
        return (CTSSub[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTSSub[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSub> getSSubList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.dc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSSubArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gi
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSSubArray(((Integer) obj).intValue(), (CTSSub) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.nd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSSub(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSSub(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSSubArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup[] getSSubSupArray() {
        return getXmlObjectArray(PROPERTY_QNAME[18], (XmlObject[]) new CTSSubSup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSubSup> getSSubSupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ng
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSSubSupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSSubSupArray(((Integer) obj).intValue(), (CTSSubSup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSSubSup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.uk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSSubSup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSSubSupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup[] getSSupArray() {
        return getXmlObjectArray(PROPERTY_QNAME[19], (XmlObject[]) new CTSSup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSup> getSSupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSSupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSSupArray(((Integer) obj).intValue(), (CTSSup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSSup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSSup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSSupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSdtRun[] getSdtArray() {
        return (CTSdtRun[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTSdtRun[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSdtRun> getSdtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSdtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSdtArray(((Integer) obj).intValue(), (CTSdtRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSdt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.h3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSdt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ok
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSdtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSmartTagRun[] getSmartTagArray() {
        return (CTSmartTagRun[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTSmartTagRun[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSmartTagRun> getSmartTagList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSmartTagArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSmartTagArray(((Integer) obj).intValue(), (CTSmartTagRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSmartTag(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ki
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSmartTag(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ql
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSmartTagArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc insertNewAcc(int i2) {
        CTAcc cTAccInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTAccInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar insertNewBar(int i2) {
        CTBar cTBarInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTBarInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewBookmarkEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[30], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark insertNewBookmarkStart(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox insertNewBorderBox(int i2) {
        CTBorderBox cTBorderBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTBorderBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox insertNewBox(int i2) {
        CTBox cTBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewCommentRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[36], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewCommentRangeStart(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[35], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCustomXmlRun insertNewCustomXml(int i2) {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[40], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[39], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[38], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[37], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[42], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[41], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[44], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[43], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD insertNewD(int i2) {
        CTD ctd;
        synchronized (monitor()) {
            check_orphaned();
            ctd = (CTD) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return ctd;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewDel(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[46], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr insertNewEqArr(int i2) {
        CTEqArr cTEqArrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTEqArrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF insertNewF(int i2) {
        CTF ctfInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return ctfInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSimpleField insertNewFldSimple(int i2) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc insertNewFunc(int i2) {
        CTFunc cTFuncInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTFuncInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr insertNewGroupChr(int i2) {
        CTGroupChr cTGroupChrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTGroupChrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTHyperlink insertNewHyperlink(int i2) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewIns(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[45], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow insertNewLimLow(int i2) {
        CTLimLow cTLimLowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTLimLowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp insertNewLimUpp(int i2) {
        CTLimUpp cTLimUppInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTLimUppInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM insertNewM(int i2) {
        CTM ctm;
        synchronized (monitor()) {
            check_orphaned();
            ctm = (CTM) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return ctm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewMoveFrom(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[47], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewMoveFromRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[32], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark insertNewMoveFromRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[31], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewMoveTo(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[48], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewMoveToRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[34], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark insertNewMoveToRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[33], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary insertNewNary(int i2) {
        CTNary cTNaryInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTNaryInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath insertNewOMath(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(PROPERTY_QNAME[50], i2);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara insertNewOMathPara(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(PROPERTY_QNAME[49], i2);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm insertNewPermEnd(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart insertNewPermStart(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant insertNewPhant(int i2) {
        CTPhant cTPhantInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTPhantInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr insertNewProofErr(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR insertNewR(int i2) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad insertNewRad(int i2) {
        CTRad cTRadInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTRadInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre insertNewSPre(int i2) {
        CTSPre cTSPreInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTSPreInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub insertNewSSub(int i2) {
        CTSSub cTSSub;
        synchronized (monitor()) {
            check_orphaned();
            cTSSub = (CTSSub) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTSSub;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup insertNewSSubSup(int i2) {
        CTSSubSup cTSSubSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTSSubSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup insertNewSSup(int i2) {
        CTSSup cTSSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTSSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSdtRun insertNewSdt(int i2) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSmartTagRun insertNewSmartTag(int i2) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public boolean isSetArgPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public boolean isSetCtrlPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[51]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeAcc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBar(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBookmarkEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBookmarkStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBorderBox(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBox(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCommentRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[36], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCommentRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXml(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlDelRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[40], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlDelRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[39], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlInsRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[38], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlInsRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[37], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[42], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[41], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[44], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[43], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeD(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeDel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[46], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeEqArr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeF(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeFldSimple(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeFunc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeGroupChr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeHyperlink(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeIns(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[45], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeLimLow(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeLimUpp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeM(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFrom(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[47], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[48], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeNary(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeOMath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[50], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeOMathPara(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[49], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePermEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePermStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePhant(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeProofErr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeR(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeRad(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSPre(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSub(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSubSup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSdt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSmartTag(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setAccArray(CTAcc[] cTAccArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAccArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setArgPr(CTOMathArgPr cTOMathArgPr) throws Throwable {
        generatedSetterHelperImpl(cTOMathArgPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBarArray(CTBar[] cTBarArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBarArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTBookmarkArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBorderBoxArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBoxArray(CTBox[] cTBoxArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBoxArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[36]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[35]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCtrlPr(CTCtrlPr cTCtrlPr) throws Throwable {
        generatedSetterHelperImpl(cTCtrlPr, PROPERTY_QNAME[51], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        check_orphaned();
        arraySetterHelper(cTCustomXmlRunArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[40]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[39]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[38]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[37]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[42]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[41]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[44]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[43]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDArray(CTD[] ctdArr) {
        check_orphaned();
        arraySetterHelper(ctdArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[46]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setEqArrArray(CTEqArr[] cTEqArrArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTEqArrArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFArray(CTF[] ctfArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) ctfArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr) {
        check_orphaned();
        arraySetterHelper(cTSimpleFieldArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFuncArray(CTFunc[] cTFuncArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFuncArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setGroupChrArray(CTGroupChr[] cTGroupChrArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGroupChrArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        check_orphaned();
        arraySetterHelper(cTHyperlinkArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[45]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimLowArray(CTLimLow[] cTLimLowArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTLimLowArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimUppArray(CTLimUpp[] cTLimUppArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTLimUppArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMArray(CTM[] ctmArr) {
        check_orphaned();
        arraySetterHelper(ctmArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[47]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[32]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[31]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[48]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[34]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[33]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setNaryArray(CTNary[] cTNaryArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTNaryArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathArray(CTOMath[] cTOMathArr) {
        check_orphaned();
        arraySetterHelper(cTOMathArr, PROPERTY_QNAME[50]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        check_orphaned();
        arraySetterHelper(cTOMathParaArr, PROPERTY_QNAME[49]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermEndArray(CTPerm[] cTPermArr) {
        check_orphaned();
        arraySetterHelper(cTPermArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        check_orphaned();
        arraySetterHelper(cTPermStartArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPhantArray(CTPhant[] cTPhantArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTPhantArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        check_orphaned();
        arraySetterHelper(cTProofErrArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRArray(CTR[] ctrArr) {
        check_orphaned();
        arraySetterHelper(ctrArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRadArray(CTRad[] cTRadArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTRadArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSPreArray(CTSPre[] cTSPreArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSPreArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubArray(CTSSub[] cTSSubArr) {
        check_orphaned();
        arraySetterHelper(cTSSubArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubSupArray(CTSSubSup[] cTSSubSupArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSSubSupArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSupArray(CTSSup[] cTSSupArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSSupArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        check_orphaned();
        arraySetterHelper(cTSdtRunArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        check_orphaned();
        arraySetterHelper(cTSmartTagRunArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfAccArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBorderBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[36]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[35]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[40]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[39]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[38]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[37]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[42]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[41]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[44]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[43]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[46]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfEqArrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfFldSimpleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfFuncArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfGroupChrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfHyperlinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[45]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfLimLowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfLimUppArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[47]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[48]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfNaryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[50]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[49]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPhantArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfRadArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSPreArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSubArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSubSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSmartTagArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void unsetArgPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void unsetCtrlPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[51], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc getAccArray(int i2) {
        CTAcc cTAccFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTAccFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAccFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar getBarArray(int i2) {
        CTBar cTBarFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTBarFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBarFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getBookmarkEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[30], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark getBookmarkStartArray(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox getBorderBoxArray(int i2) {
        CTBorderBox cTBorderBoxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTBorderBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBorderBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox getBoxArray(int i2) {
        CTBox cTBoxFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTBoxFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getCommentRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[36], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getCommentRangeStartArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[35], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCustomXmlRun getCustomXmlArray(int i2) {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTCustomXmlRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlDelRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[40], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlDelRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[39], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlInsRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[38], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlInsRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[37], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[42], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[41], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[44], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[43], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD getDArray(int i2) {
        CTD ctd;
        synchronized (monitor()) {
            check_orphaned();
            ctd = (CTD) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (ctd == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctd;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getDelArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[46], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr getEqArrArray(int i2) {
        CTEqArr cTEqArrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTEqArrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEqArrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF getFArray(int i2) {
        CTF ctfFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (ctfFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctfFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSimpleField getFldSimpleArray(int i2) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTSimpleField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc getFuncArray(int i2) {
        CTFunc cTFuncFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTFuncFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFuncFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr getGroupChrArray(int i2) {
        CTGroupChr cTGroupChrFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTGroupChrFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroupChrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTHyperlink getHyperlinkArray(int i2) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTHyperlink == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getInsArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[45], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow getLimLowArray(int i2) {
        CTLimLow cTLimLowFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTLimLowFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLimLowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp getLimUppArray(int i2) {
        CTLimUpp cTLimUppFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTLimUppFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTLimUppFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM getMArray(int i2) {
        CTM ctm;
        synchronized (monitor()) {
            check_orphaned();
            ctm = (CTM) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (ctm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getMoveFromArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[47], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getMoveFromRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[32], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark getMoveFromRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[31], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getMoveToArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[48], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getMoveToRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[34], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark getMoveToRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[33], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary getNaryArray(int i2) {
        CTNary cTNaryFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTNaryFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTNaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath getOMathArray(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().find_element_user(PROPERTY_QNAME[50], i2);
            if (cTOMath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara getOMathParaArray(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().find_element_user(PROPERTY_QNAME[49], i2);
            if (cTOMathPara == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm getPermEndArray(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTPerm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart getPermStartArray(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTPermStart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant getPhantArray(int i2) {
        CTPhant cTPhantFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantFind_element_user = get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTPhantFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPhantFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr getProofErrArray(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR getRArray(int i2) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (ctr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad getRadArray(int i2) {
        CTRad cTRadFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadFind_element_user = get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTRadFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRadFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre getSPreArray(int i2) {
        CTSPre cTSPreFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreFind_element_user = get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTSPreFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSPreFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub getSSubArray(int i2) {
        CTSSub cTSSub;
        synchronized (monitor()) {
            check_orphaned();
            cTSSub = (CTSSub) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTSSub == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSSub;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup getSSubSupArray(int i2) {
        CTSSubSup cTSSubSupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTSSubSupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSSubSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup getSSupArray(int i2) {
        CTSSup cTSSupFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupFind_element_user = get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTSSupFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSdtRun getSdtArray(int i2) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTSdtRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSmartTagRun getSmartTagArray(int i2) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTSmartTagRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setAccArray(int i2, CTAcc cTAcc) throws Throwable {
        generatedSetterHelperImpl(cTAcc, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBarArray(int i2, CTBar cTBar) throws Throwable {
        generatedSetterHelperImpl(cTBar, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[30], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkStartArray(int i2, CTBookmark cTBookmark) throws Throwable {
        generatedSetterHelperImpl(cTBookmark, PROPERTY_QNAME[29], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBorderBoxArray(int i2, CTBorderBox cTBorderBox) throws Throwable {
        generatedSetterHelperImpl(cTBorderBox, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBoxArray(int i2, CTBox cTBox) throws Throwable {
        generatedSetterHelperImpl(cTBox, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[36], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[35], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlArray(int i2, CTCustomXmlRun cTCustomXmlRun) throws Throwable {
        generatedSetterHelperImpl(cTCustomXmlRun, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[40], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[39], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[38], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[37], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[42], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[41], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[44], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[43], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDArray(int i2, CTD ctd) throws Throwable {
        generatedSetterHelperImpl(ctd, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDelArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[46], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setEqArrArray(int i2, CTEqArr cTEqArr) throws Throwable {
        generatedSetterHelperImpl(cTEqArr, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFArray(int i2, CTF ctf) throws Throwable {
        generatedSetterHelperImpl(ctf, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFldSimpleArray(int i2, CTSimpleField cTSimpleField) throws Throwable {
        generatedSetterHelperImpl(cTSimpleField, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFuncArray(int i2, CTFunc cTFunc) throws Throwable {
        generatedSetterHelperImpl(cTFunc, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setGroupChrArray(int i2, CTGroupChr cTGroupChr) throws Throwable {
        generatedSetterHelperImpl(cTGroupChr, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setHyperlinkArray(int i2, CTHyperlink cTHyperlink) throws Throwable {
        generatedSetterHelperImpl(cTHyperlink, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setInsArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[45], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimLowArray(int i2, CTLimLow cTLimLow) throws Throwable {
        generatedSetterHelperImpl(cTLimLow, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimUppArray(int i2, CTLimUpp cTLimUpp) throws Throwable {
        generatedSetterHelperImpl(cTLimUpp, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMArray(int i2, CTM ctm) throws Throwable {
        generatedSetterHelperImpl(ctm, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[47], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[32], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[31], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[48], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[34], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[33], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setNaryArray(int i2, CTNary cTNary) throws Throwable {
        generatedSetterHelperImpl(cTNary, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathArray(int i2, CTOMath cTOMath) throws Throwable {
        generatedSetterHelperImpl(cTOMath, PROPERTY_QNAME[50], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathParaArray(int i2, CTOMathPara cTOMathPara) throws Throwable {
        generatedSetterHelperImpl(cTOMathPara, PROPERTY_QNAME[49], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermEndArray(int i2, CTPerm cTPerm) throws Throwable {
        generatedSetterHelperImpl(cTPerm, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermStartArray(int i2, CTPermStart cTPermStart) throws Throwable {
        generatedSetterHelperImpl(cTPermStart, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPhantArray(int i2, CTPhant cTPhant) throws Throwable {
        generatedSetterHelperImpl(cTPhant, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setProofErrArray(int i2, CTProofErr cTProofErr) throws Throwable {
        generatedSetterHelperImpl(cTProofErr, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRArray(int i2, CTR ctr) throws Throwable {
        generatedSetterHelperImpl(ctr, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRadArray(int i2, CTRad cTRad) throws Throwable {
        generatedSetterHelperImpl(cTRad, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSPreArray(int i2, CTSPre cTSPre) throws Throwable {
        generatedSetterHelperImpl(cTSPre, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubArray(int i2, CTSSub cTSSub) throws Throwable {
        generatedSetterHelperImpl(cTSSub, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubSupArray(int i2, CTSSubSup cTSSubSup) throws Throwable {
        generatedSetterHelperImpl(cTSSubSup, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSupArray(int i2, CTSSup cTSSup) throws Throwable {
        generatedSetterHelperImpl(cTSSup, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSdtArray(int i2, CTSdtRun cTSdtRun) throws Throwable {
        generatedSetterHelperImpl(cTSdtRun, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSmartTagArray(int i2, CTSmartTagRun cTSmartTagRun) throws Throwable {
        generatedSetterHelperImpl(cTSmartTagRun, PROPERTY_QNAME[24], i2, (short) 2);
    }
}
