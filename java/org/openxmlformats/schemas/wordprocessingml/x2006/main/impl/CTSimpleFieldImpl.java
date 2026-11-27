package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBdoContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDirContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes3.dex */
public class CTSimpleFieldImpl extends XmlComplexContentImpl implements CTSimpleField {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldData"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dir"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bdo"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "r"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldSimple"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hyperlink"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "subDoc"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "instr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldLock"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dirty")};
    private static final long serialVersionUID = 1;

    public CTSimpleFieldImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBdoContentRun addNewBdo() {
        CTBdoContentRun cTBdoContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTBdoContentRun = (CTBdoContentRun) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTBdoContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTDirContentRun addNewDir() {
        CTDirContentRun cTDirContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTDirContentRun = (CTDirContentRun) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTDirContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTText addNewFldData() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSimpleField addNewFldSimple() {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPerm addNewPermEnd() {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTR addNewR() {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRel addNewSubDoc() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBdoContentRun[] getBdoArray() {
        return (CTBdoContentRun[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTBdoContentRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTBdoContentRun> getBdoList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k73
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBdoArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mk1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBdoArray(((Integer) obj).intValue(), (CTBdoContentRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.db0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBdo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kn1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBdo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rt3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBdoArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange[] getBookmarkEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkupRange> getBookmarkEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uf3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ni2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hd1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ow0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mi
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBookmark[] getBookmarkStartArray() {
        return (CTBookmark[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTBookmark> getBookmarkStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z92
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkStartArray(((Integer) obj).intValue(), (CTBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nm3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qu0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r80
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange[] getCommentRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkupRange> getCommentRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ky1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wy
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.d10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hq0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange[] getCommentRangeStartArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkupRange> getCommentRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hc0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeStartArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j23
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.du
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTCustomXmlRun[] getCustomXmlArray() {
        return (CTCustomXmlRun[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTCustomXmlRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.su0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nv1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sf0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xe3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fc2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cl1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.im1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p62
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e03
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qd1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g41
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s31
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j63
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a43
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vt
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pm0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.er3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTCustomXmlRun> getCustomXmlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bv1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlArray(((Integer) obj).intValue(), (CTCustomXmlRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uv0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXml(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aa1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXml(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pc2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.co3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ep3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b71
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.on1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ro3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gz1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c63
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oo1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mk
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fy1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yq
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ze
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k92
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fm0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t01
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.eo0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange[] getDelArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTRunTrackChange> getDelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mc0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xl1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q92
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k82
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTDirContentRun[] getDirArray() {
        return (CTDirContentRun[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTDirContentRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTDirContentRun> getDirList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xb0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDirArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oq3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDirArray(((Integer) obj).intValue(), (CTDirContentRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z93
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDir(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ns2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDir(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p71
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDirArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public Object getDirty() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[37]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTText getFldData() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTText == null) {
                cTText = null;
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public Object getFldLock() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[36]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSimpleField[] getFldSimpleArray() {
        return (CTSimpleField[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTSimpleField[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTSimpleField> getFldSimpleList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bg3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFldSimpleArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.at0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFldSimpleArray(((Integer) obj).intValue(), (CTSimpleField) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gb3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFldSimple(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gx0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFldSimple(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h20
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFldSimpleArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTHyperlink[] getHyperlinkArray() {
        return (CTHyperlink[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTHyperlink[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTHyperlink> getHyperlinkList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ic3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getHyperlinkArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ce1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setHyperlinkArray(((Integer) obj).intValue(), (CTHyperlink) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ew0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewHyperlink(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zb0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeHyperlink(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yw0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfHyperlinkArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange[] getInsArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTRunTrackChange> getInsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xq3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m43
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInsArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rn0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewIns(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i51
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeIns(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ix1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public String getInstr() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[35]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange[] getMoveFromArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTRunTrackChange> getMoveFromList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f82
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e73
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFrom(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dt0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFrom(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a61
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e32
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f62
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qz2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f91
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qr0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jp3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x63
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h23
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange[] getMoveToArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTRunTrackChange> getMoveToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jl2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jn0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dm3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kv1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange[] getMoveToRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMarkupRange> getMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lk1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ud1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.in0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.js1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.us3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y21
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r12
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s01
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ed3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fx0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMath[] getOMathArray() {
        return (CTOMath[]) getXmlObjectArray(PROPERTY_QNAME[31], new CTOMath[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTOMath> getOMathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.um2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.he1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathArray(((Integer) obj).intValue(), (CTOMath) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qx2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ke1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.y92
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMathPara[] getOMathParaArray() {
        return (CTOMathPara[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTOMathPara[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTOMathPara> getOMathParaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.th3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathParaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zi
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathParaArray(((Integer) obj).intValue(), (CTOMathPara) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xv1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMathPara(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMathPara(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jo
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathParaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPerm[] getPermEndArray() {
        return (CTPerm[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTPerm[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTPerm> getPermEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lp3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c73
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermEndArray(((Integer) obj).intValue(), (CTPerm) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mq0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p81
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPermStart[] getPermStartArray() {
        return (CTPermStart[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTPermStart[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTPermStart> getPermStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ap1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i83
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermStartArray(((Integer) obj).intValue(), (CTPermStart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t42
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jt0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTProofErr[] getProofErrArray() {
        return (CTProofErr[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTProofErr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTProofErr> getProofErrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.id3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getProofErrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.le2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setProofErrArray(((Integer) obj).intValue(), (CTProofErr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qe3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProofErr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ub3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProofErr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oj3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfProofErrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTR[] getRArray() {
        return (CTR[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTR[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTR> getRList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kd0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ar
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRArray(((Integer) obj).intValue(), (CTR) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sj1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ye1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeR(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tr0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSdtRun[] getSdtArray() {
        return (CTSdtRun[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTSdtRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTSdtRun> getSdtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSdtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q31
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSdtArray(((Integer) obj).intValue(), (CTSdtRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a62
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSdt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSdt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.id2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSdtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSmartTagRun[] getSmartTagArray() {
        return (CTSmartTagRun[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTSmartTagRun[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTSmartTagRun> getSmartTagList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j01
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSmartTagArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j51
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSmartTagArray(((Integer) obj).intValue(), (CTSmartTagRun) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSmartTag(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSmartTag(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x80
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSmartTagArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRel[] getSubDocArray() {
        return (CTRel[]) getXmlObjectArray(PROPERTY_QNAME[34], new CTRel[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public List<CTRel> getSubDocList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cq2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSubDocArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p40
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSubDocArray(((Integer) obj).intValue(), (CTRel) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h22
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSubDoc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSubDoc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ap
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSubDocArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBdoContentRun insertNewBdo(int i2) {
        CTBdoContentRun cTBdoContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTBdoContentRun = (CTBdoContentRun) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTBdoContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange insertNewBookmarkEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBookmark insertNewBookmarkStart(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange insertNewCommentRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange insertNewCommentRangeStart(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTCustomXmlRun insertNewCustomXml(int i2) {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange insertNewDel(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTDirContentRun insertNewDir(int i2) {
        CTDirContentRun cTDirContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTDirContentRun = (CTDirContentRun) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTDirContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSimpleField insertNewFldSimple(int i2) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().insert_element_user(PROPERTY_QNAME[32], i2);
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTHyperlink insertNewHyperlink(int i2) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().insert_element_user(PROPERTY_QNAME[33], i2);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange insertNewIns(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange insertNewMoveFrom(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange insertNewMoveFromRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark insertNewMoveFromRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange insertNewMoveTo(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange insertNewMoveToRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark insertNewMoveToRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMath insertNewOMath(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(PROPERTY_QNAME[31], i2);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMathPara insertNewOMathPara(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(PROPERTY_QNAME[30], i2);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPerm insertNewPermEnd(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPermStart insertNewPermStart(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTProofErr insertNewProofErr(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTR insertNewR(int i2) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSdtRun insertNewSdt(int i2) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSmartTagRun insertNewSmartTag(int i2) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRel insertNewSubDoc(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().insert_element_user(PROPERTY_QNAME[34], i2);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public boolean isSetDirty() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[37]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public boolean isSetFldData() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public boolean isSetFldLock() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[36]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeBdo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeBookmarkEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeBookmarkStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCommentRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCommentRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXml(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlDelRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlDelRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlInsRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlInsRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeCustomXmlMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeDel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeDir(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeFldSimple(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeHyperlink(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeIns(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveFrom(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeOMath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeOMathPara(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removePermEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removePermStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeProofErr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeR(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeSdt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeSmartTag(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void removeSubDoc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBdoArray(CTBdoContentRun[] cTBdoContentRunArr) {
        check_orphaned();
        arraySetterHelper(cTBdoContentRunArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTBookmarkArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        check_orphaned();
        arraySetterHelper(cTCustomXmlRunArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setDirArray(CTDirContentRun[] cTDirContentRunArr) {
        check_orphaned();
        arraySetterHelper(cTDirContentRunArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setDirty(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[37]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[37]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setFldData(CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setFldLock(Object obj) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[36]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[36]);
            }
            simpleValue.setObjectValue(obj);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr) {
        check_orphaned();
        arraySetterHelper(cTSimpleFieldArr, PROPERTY_QNAME[32]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        check_orphaned();
        arraySetterHelper(cTHyperlinkArr, PROPERTY_QNAME[33]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setInstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[35]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[35]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setOMathArray(CTOMath[] cTOMathArr) {
        check_orphaned();
        arraySetterHelper(cTOMathArr, PROPERTY_QNAME[31]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        check_orphaned();
        arraySetterHelper(cTOMathParaArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setPermEndArray(CTPerm[] cTPermArr) {
        check_orphaned();
        arraySetterHelper(cTPermArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        check_orphaned();
        arraySetterHelper(cTPermStartArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        check_orphaned();
        arraySetterHelper(cTProofErrArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setRArray(CTR[] ctrArr) {
        check_orphaned();
        arraySetterHelper(ctrArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        check_orphaned();
        arraySetterHelper(cTSdtRunArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        check_orphaned();
        arraySetterHelper(cTSmartTagRunArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSubDocArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, PROPERTY_QNAME[34]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfBdoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfDirArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfFldSimpleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfHyperlinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfSmartTagArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public int sizeOfSubDocArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void unsetDirty() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[37]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void unsetFldData() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void unsetFldLock() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[36]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public STOnOff xgetDirty() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[37]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public STOnOff xgetFldLock() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(PROPERTY_QNAME[36]);
        }
        return sTOnOff;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public STString xgetInstr() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(PROPERTY_QNAME[35]);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void xsetDirty(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[37]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[37]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void xsetFldLock(STOnOff sTOnOff) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qNameArr[36]);
            if (sTOnOff2 == null) {
                sTOnOff2 = (STOnOff) get_store().add_attribute_user(qNameArr[36]);
            }
            sTOnOff2.set(sTOnOff);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void xsetInstr(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STString sTString2 = (STString) typeStore.find_attribute_user(qNameArr[35]);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qNameArr[35]);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBdoContentRun getBdoArray(int i2) {
        CTBdoContentRun cTBdoContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTBdoContentRun = (CTBdoContentRun) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTBdoContentRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBdoContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange getBookmarkEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTBookmark getBookmarkStartArray(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange getCommentRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange getCommentRangeStartArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTCustomXmlRun getCustomXmlArray(int i2) {
        CTCustomXmlRun cTCustomXmlRun;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRun = (CTCustomXmlRun) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTCustomXmlRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup getCustomXmlDelRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange getCustomXmlDelRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup getCustomXmlInsRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange getCustomXmlInsRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange getDelArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTDirContentRun getDirArray(int i2) {
        CTDirContentRun cTDirContentRun;
        synchronized (monitor()) {
            check_orphaned();
            cTDirContentRun = (CTDirContentRun) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTDirContentRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDirContentRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSimpleField getFldSimpleArray(int i2) {
        CTSimpleField cTSimpleField;
        synchronized (monitor()) {
            check_orphaned();
            cTSimpleField = (CTSimpleField) get_store().find_element_user(PROPERTY_QNAME[32], i2);
            if (cTSimpleField == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSimpleField;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTHyperlink getHyperlinkArray(int i2) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().find_element_user(PROPERTY_QNAME[33], i2);
            if (cTHyperlink == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange getInsArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange getMoveFromArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange getMoveFromRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark getMoveFromRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRunTrackChange getMoveToArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMarkupRange getMoveToRangeEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTMoveBookmark getMoveToRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMath getOMathArray(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().find_element_user(PROPERTY_QNAME[31], i2);
            if (cTOMath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTOMathPara getOMathParaArray(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().find_element_user(PROPERTY_QNAME[30], i2);
            if (cTOMathPara == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPerm getPermEndArray(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTPerm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTPermStart getPermStartArray(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTPermStart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTProofErr getProofErrArray(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTR getRArray(int i2) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (ctr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSdtRun getSdtArray(int i2) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTSdtRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTSmartTagRun getSmartTagArray(int i2) {
        CTSmartTagRun cTSmartTagRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRun = (CTSmartTagRun) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTSmartTagRun == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSmartTagRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public CTRel getSubDocArray(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[34], i2);
            if (cTRel == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBdoArray(int i2, CTBdoContentRun cTBdoContentRun) throws Throwable {
        generatedSetterHelperImpl(cTBdoContentRun, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setBookmarkStartArray(int i2, CTBookmark cTBookmark) throws Throwable {
        generatedSetterHelperImpl(cTBookmark, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlArray(int i2, CTCustomXmlRun cTCustomXmlRun) throws Throwable {
        generatedSetterHelperImpl(cTCustomXmlRun, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlDelRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlDelRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlInsRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlInsRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveFromRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveFromRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveToRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setCustomXmlMoveToRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setDelArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setDirArray(int i2, CTDirContentRun cTDirContentRun) throws Throwable {
        generatedSetterHelperImpl(cTDirContentRun, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setFldSimpleArray(int i2, CTSimpleField cTSimpleField) throws Throwable {
        generatedSetterHelperImpl(cTSimpleField, PROPERTY_QNAME[32], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setHyperlinkArray(int i2, CTHyperlink cTHyperlink) throws Throwable {
        generatedSetterHelperImpl(cTHyperlink, PROPERTY_QNAME[33], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setInsArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveFromRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[29], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setMoveToRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setOMathArray(int i2, CTOMath cTOMath) throws Throwable {
        generatedSetterHelperImpl(cTOMath, PROPERTY_QNAME[31], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setOMathParaArray(int i2, CTOMathPara cTOMathPara) throws Throwable {
        generatedSetterHelperImpl(cTOMathPara, PROPERTY_QNAME[30], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setPermEndArray(int i2, CTPerm cTPerm) throws Throwable {
        generatedSetterHelperImpl(cTPerm, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setPermStartArray(int i2, CTPermStart cTPermStart) throws Throwable {
        generatedSetterHelperImpl(cTPermStart, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setProofErrArray(int i2, CTProofErr cTProofErr) throws Throwable {
        generatedSetterHelperImpl(cTProofErr, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setRArray(int i2, CTR ctr) throws Throwable {
        generatedSetterHelperImpl(ctr, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSdtArray(int i2, CTSdtRun cTSdtRun) throws Throwable {
        generatedSetterHelperImpl(cTSdtRun, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSmartTagArray(int i2, CTSmartTagRun cTSmartTagRun) throws Throwable {
        generatedSetterHelperImpl(cTSmartTagRun, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField
    public void setSubDocArray(int i2, CTRel cTRel) throws Throwable {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[34], i2, (short) 2);
    }
}
