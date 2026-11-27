package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAltChunk;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes3.dex */
public class CTTcImpl extends XmlComplexContentImpl implements CTTc {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "p"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tbl"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id")};
    private static final long serialVersionUID = 1;

    public CTTcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk addNewAltChunk() {
        CTAltChunk cTAltChunk;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunk = (CTAltChunk) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTAltChunk;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock addNewCustomXml() {
        CTCustomXmlBlock cTCustomXmlBlockAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTCustomXmlBlockAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP addNewP() {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm addNewPermEnd() {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock addNewSdt() {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl addNewTbl() {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTcPr addNewTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk[] getAltChunkArray() {
        return (CTAltChunk[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTAltChunk[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTAltChunk> getAltChunkList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l10
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAltChunkArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAltChunkArray(((Integer) obj).intValue(), (CTAltChunk) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bp0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAltChunk(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.md3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAltChunk(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ws1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAltChunkArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getBookmarkEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getBookmarkEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dr
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.iu1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p82
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bm3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pu
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark[] getBookmarkStartArray() {
        return (CTBookmark[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTBookmark> getBookmarkStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yr
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.d91
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkStartArray(((Integer) obj).intValue(), (CTBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.as0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ji1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getCommentRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getCommentRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nh1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.id0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.db3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aj2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cm1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getCommentRangeStartArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getCommentRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.au1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t81
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeStartArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b83
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fo0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vj0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock[] getCustomXmlArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTCustomXmlBlock[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ue
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ez
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m82
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sf
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e82
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f30
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jq
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mb1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yr3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fy2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gj1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dj3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lo2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gv1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ki2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ee3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b70
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l00
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ef1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTCustomXmlBlock> getCustomXmlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tk2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlArray(((Integer) obj).intValue(), (CTCustomXmlBlock) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXml(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l81
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXml(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mt
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dt2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oy1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xl3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bg1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qr
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.st
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lh1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mm1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s92
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ra1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h01
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ms3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uf1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h91
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t12
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yf3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xr1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bq1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bz2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getDelArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getDelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ad2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qt2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aj3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bt1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m21
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[31]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getInsArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getInsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cf1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInsArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nk0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewIns(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.di2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeIns(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.km3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getMoveFromArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getMoveFromList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tx1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tm3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFrom(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tv1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFrom(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fp3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.il3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l72
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.na2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zw1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u43
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xh3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dq3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ap2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bm1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange[] getMoveToArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTRunTrackChange> getMoveToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xw0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sp3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.w20
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.do
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u21
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange[] getMoveToRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMarkupRange> getMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ta3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uw
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h31
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ev2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xa1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ai
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.d32
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ot2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u61
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath[] getOMathArray() {
        return (CTOMath[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTOMath[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTOMath> getOMathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ut3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathArray(((Integer) obj).intValue(), (CTOMath) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c53
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f42
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lu
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara[] getOMathParaArray() {
        return (CTOMathPara[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTOMathPara[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTOMathPara> getOMathParaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xd0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathParaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r41
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathParaArray(((Integer) obj).intValue(), (CTOMathPara) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jx1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMathPara(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.a90
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMathPara(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.d5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathParaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP[] getPArray() {
        return (CTP[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTP[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTP> getPList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vr2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPArray(((Integer) obj).intValue(), (CTP) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ac0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewP(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ak3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeP(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vq1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm[] getPermEndArray() {
        return (CTPerm[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTPerm[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTPerm> getPermEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermEndArray(((Integer) obj).intValue(), (CTPerm) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uq0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yn2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ri0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart[] getPermStartArray() {
        return (CTPermStart[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTPermStart[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTPermStart> getPermStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f13
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uf0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermStartArray(((Integer) obj).intValue(), (CTPermStart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dx2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yg0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tx
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr[] getProofErrArray() {
        return (CTProofErr[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTProofErr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTProofErr> getProofErrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oj0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getProofErrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wd0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setProofErrArray(((Integer) obj).intValue(), (CTProofErr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ku0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProofErr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i92
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProofErr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfProofErrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock[] getSdtArray() {
        return (CTSdtBlock[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTSdtBlock[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTSdtBlock> getSdtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kx0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSdtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r81
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSdtArray(((Integer) obj).intValue(), (CTSdtBlock) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ce3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSdt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ez0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSdt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bw
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSdtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl[] getTblArray() {
        return (CTTbl[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTTbl[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public List<CTTbl> getTblList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTblArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTblArray(((Integer) obj).intValue(), (CTTbl) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c12
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTbl(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x11
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTbl(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jo2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTblArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTcPr getTcPr() {
        CTTcPr cTTcPr;
        synchronized (monitor()) {
            check_orphaned();
            cTTcPr = (CTTcPr) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTcPr == null) {
                cTTcPr = null;
            }
        }
        return cTTcPr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk insertNewAltChunk(int i2) {
        CTAltChunk cTAltChunk;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunk = (CTAltChunk) get_store().insert_element_user(PROPERTY_QNAME[30], i2);
        }
        return cTAltChunk;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewBookmarkEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark insertNewBookmarkStart(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewCommentRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewCommentRangeStart(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock insertNewCustomXml(int i2) {
        CTCustomXmlBlock cTCustomXmlBlockInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTCustomXmlBlockInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewDel(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewIns(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewMoveFrom(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewMoveFromRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark insertNewMoveFromRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange insertNewMoveTo(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange insertNewMoveToRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark insertNewMoveToRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath insertNewOMath(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara insertNewOMathPara(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP insertNewP(int i2) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm insertNewPermEnd(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart insertNewPermStart(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr insertNewProofErr(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock insertNewSdt(int i2) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl insertNewTbl(int i2) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PROPERTY_QNAME[31]) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public boolean isSetTcPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeAltChunk(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeBookmarkEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeBookmarkStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCommentRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCommentRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXml(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlDelRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlDelRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlInsRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlInsRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeCustomXmlMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeDel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeIns(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFrom(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeOMath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeOMathPara(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeP(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removePermEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removePermStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeProofErr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeSdt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void removeTbl(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setAltChunkArray(CTAltChunk[] cTAltChunkArr) {
        check_orphaned();
        arraySetterHelper(cTAltChunkArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTBookmarkArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTCustomXmlBlockArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setId(String str) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[31]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[31]);
            }
            simpleValue.setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathArray(CTOMath[] cTOMathArr) {
        check_orphaned();
        arraySetterHelper(cTOMathArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        check_orphaned();
        arraySetterHelper(cTOMathParaArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPArray(CTP[] ctpArr) {
        check_orphaned();
        arraySetterHelper(ctpArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermEndArray(CTPerm[] cTPermArr) {
        check_orphaned();
        arraySetterHelper(cTPermArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        check_orphaned();
        arraySetterHelper(cTPermStartArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        check_orphaned();
        arraySetterHelper(cTProofErrArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setSdtArray(CTSdtBlock[] cTSdtBlockArr) {
        check_orphaned();
        arraySetterHelper(cTSdtBlockArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTblArray(CTTbl[] cTTblArr) {
        check_orphaned();
        arraySetterHelper(cTTblArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTcPr(CTTcPr cTTcPr) throws Throwable {
        generatedSetterHelperImpl(cTTcPr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfAltChunkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public int sizeOfTblArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[31]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void unsetTcPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public STString xgetId() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(PROPERTY_QNAME[31]);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void xsetId(STString sTString) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STString sTString2 = (STString) typeStore.find_attribute_user(qNameArr[31]);
            if (sTString2 == null) {
                sTString2 = (STString) get_store().add_attribute_user(qNameArr[31]);
            }
            sTString2.set(sTString);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTAltChunk getAltChunkArray(int i2) {
        CTAltChunk cTAltChunk;
        synchronized (monitor()) {
            check_orphaned();
            cTAltChunk = (CTAltChunk) get_store().find_element_user(PROPERTY_QNAME[30], i2);
            if (cTAltChunk == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTAltChunk;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getBookmarkEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTBookmark getBookmarkStartArray(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getCommentRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getCommentRangeStartArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTCustomXmlBlock getCustomXmlArray(int i2) {
        CTCustomXmlBlock cTCustomXmlBlockFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlBlockFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTCustomXmlBlockFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlBlockFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlDelRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlDelRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlInsRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlInsRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getDelArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getInsArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getMoveFromArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getMoveFromRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark getMoveFromRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTRunTrackChange getMoveToArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMarkupRange getMoveToRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTMoveBookmark getMoveToRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMath getOMathArray(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTOMath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTOMathPara getOMathParaArray(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTOMathPara == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTP getPArray(int i2) {
        CTP ctp;
        synchronized (monitor()) {
            check_orphaned();
            ctp = (CTP) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (ctp == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return ctp;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPerm getPermEndArray(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTPerm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTPermStart getPermStartArray(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTPermStart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTProofErr getProofErrArray(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTSdtBlock getSdtArray(int i2) {
        CTSdtBlock cTSdtBlock;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtBlock = (CTSdtBlock) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTSdtBlock == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtBlock;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public CTTbl getTblArray(int i2) {
        CTTbl cTTbl;
        synchronized (monitor()) {
            check_orphaned();
            cTTbl = (CTTbl) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTTbl == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTbl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setAltChunkArray(int i2, CTAltChunk cTAltChunk) throws Throwable {
        generatedSetterHelperImpl(cTAltChunk, PROPERTY_QNAME[30], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setBookmarkStartArray(int i2, CTBookmark cTBookmark) throws Throwable {
        generatedSetterHelperImpl(cTBookmark, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlArray(int i2, CTCustomXmlBlock cTCustomXmlBlock) throws Throwable {
        generatedSetterHelperImpl(cTCustomXmlBlock, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlDelRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlInsRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveFromRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setCustomXmlMoveToRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setDelArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setInsArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveFromRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setMoveToRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathArray(int i2, CTOMath cTOMath) throws Throwable {
        generatedSetterHelperImpl(cTOMath, PROPERTY_QNAME[29], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setOMathParaArray(int i2, CTOMathPara cTOMathPara) throws Throwable {
        generatedSetterHelperImpl(cTOMathPara, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPArray(int i2, CTP ctp) throws Throwable {
        generatedSetterHelperImpl(ctp, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermEndArray(int i2, CTPerm cTPerm) throws Throwable {
        generatedSetterHelperImpl(cTPerm, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setPermStartArray(int i2, CTPermStart cTPermStart) throws Throwable {
        generatedSetterHelperImpl(cTPermStart, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setProofErrArray(int i2, CTProofErr cTProofErr) throws Throwable {
        generatedSetterHelperImpl(cTProofErr, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setSdtArray(int i2, CTSdtBlock cTSdtBlock) throws Throwable {
        generatedSetterHelperImpl(cTSdtBlock, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc
    public void setTblArray(int i2, CTTbl cTTbl) throws Throwable {
        generatedSetterHelperImpl(cTTbl, PROPERTY_QNAME[4], i2, (short) 2);
    }
}
