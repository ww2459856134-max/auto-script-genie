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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* loaded from: classes3.dex */
public class CTSdtContentCellImpl extends XmlComplexContentImpl implements CTSdtContentCell {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tc"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath")};
    private static final long serialVersionUID = 1;

    public CTSdtContentCellImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell addNewCustomXml() {
        CTCustomXmlCell cTCustomXmlCellAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlCellAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTCustomXmlCellAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm addNewPermEnd() {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell addNewSdt() {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc addNewTc() {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getBookmarkEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getBookmarkEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rv0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t70
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h53
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pf
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.h50
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark[] getBookmarkStartArray() {
        return (CTBookmark[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTBookmark> getBookmarkStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBookmarkStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fn
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBookmarkStartArray(((Integer) obj).intValue(), (CTBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.o21
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBookmarkStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wz
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBookmarkStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aj0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBookmarkStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getCommentRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getCommentRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ko
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jc2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dl2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fe1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wp1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getCommentRangeStartArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getCommentRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pk3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n90
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentRangeStartArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m51
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wn0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xl0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell[] getCustomXmlArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTCustomXmlCell[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p02
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gr
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.oz2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uq1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.il1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zc3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlDelRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zp2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlDelRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r40
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlDelRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.up2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlDelRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bp2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ir1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hf2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rc2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nz0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlInsRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.b42
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlInsRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.on0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nk
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlInsRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.iw1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlInsRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTCustomXmlCell> getCustomXmlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nl3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pe
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlArray(((Integer) obj).intValue(), (CTCustomXmlCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXml(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ja3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXml(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m32
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tc2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.x23
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveFromRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.e2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ab
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.rp1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lb3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.m41
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ec2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.cu0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        return (CTTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yg1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCustomXmlMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u71
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCustomXmlMoveToRangeStartArray(((Integer) obj).intValue(), (CTTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ht
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCustomXmlMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wv
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCustomXmlMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getDelArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getDelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.s21
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xm1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qj0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDel(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nx1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDel(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.dk0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getInsArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getInsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.aj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.p22
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInsArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k01
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewIns(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nw1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeIns(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.pq0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getMoveFromArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getMoveFromList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q90
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zw
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.kj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFrom(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFrom(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t02
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jl3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.xz
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.uv2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vb2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.k7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveFromRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveFromRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fr3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tg1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveFromRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yv0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveFromRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange[] getMoveToArray() {
        return (CTRunTrackChange[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTRunTrackChange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTRunTrackChange> getMoveToList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.c71
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fk3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToArray(((Integer) obj).intValue(), (CTRunTrackChange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.vi1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveTo(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ty2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveTo(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qu
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange[] getMoveToRangeEndArray() {
        return (CTMarkupRange[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTMarkupRange[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMarkupRange> getMoveToRangeEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.j00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.nw0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeEndArray(((Integer) obj).intValue(), (CTMarkupRange) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jr
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        return (CTMoveBookmark[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTMoveBookmark[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.km2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMoveToRangeStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jv
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMoveToRangeStartArray(((Integer) obj).intValue(), (CTMoveBookmark) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gh2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.r6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMoveToRangeStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.l11
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMoveToRangeStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath[] getOMathArray() {
        return (CTOMath[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTOMath[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTOMath> getOMathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zk0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.v8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathArray(((Integer) obj).intValue(), (CTOMath) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bt2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMath(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.az1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMath(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yz2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara[] getOMathParaArray() {
        return (CTOMathPara[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTOMathPara[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTOMathPara> getOMathParaList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.n42
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOMathParaArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.g92
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOMathParaArray(((Integer) obj).intValue(), (CTOMathPara) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hr0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOMathPara(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fi1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOMathPara(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.lo1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOMathParaArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm[] getPermEndArray() {
        return (CTPerm[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTPerm[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTPerm> getPermEndList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zl1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermEndArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.t83
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermEndArray(((Integer) obj).intValue(), (CTPerm) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermEnd(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ch0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermEnd(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ej2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermEndArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart[] getPermStartArray() {
        return (CTPermStart[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTPermStart[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTPermStart> getPermStartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.f2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPermStartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.tv
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPermStartArray(((Integer) obj).intValue(), (CTPermStart) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.u51
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPermStart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.mu2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePermStart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.ro2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPermStartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr[] getProofErrArray() {
        return (CTProofErr[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTProofErr[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTProofErr> getProofErrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.jr1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getProofErrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.fw2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setProofErrArray(((Integer) obj).intValue(), (CTProofErr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.qm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewProofErr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.bf3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeProofErr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.yj2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfProofErrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell[] getSdtArray() {
        return (CTSdtCell[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTSdtCell[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTSdtCell> getSdtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSdtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.hv
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSdtArray(((Integer) obj).intValue(), (CTSdtCell) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.q
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSdt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.z30
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSdt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.he2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSdtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc[] getTcArray() {
        return (CTTc[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTc[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public List<CTTc> getTcList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.zr2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTcArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.sl
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTcArray(((Integer) obj).intValue(), (CTTc) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.wx0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTc(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.gn1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTc(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.i5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTcArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewBookmarkEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark insertNewBookmarkStart(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewCommentRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewCommentRangeStart(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell insertNewCustomXml(int i2) {
        CTCustomXmlCell cTCustomXmlCellInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlCellInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTCustomXmlCellInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewDel(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewIns(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewMoveFrom(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewMoveFromRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark insertNewMoveFromRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange insertNewMoveTo(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange insertNewMoveToRangeEnd(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark insertNewMoveToRangeStart(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath insertNewOMath(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara insertNewOMathPara(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm insertNewPermEnd(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart insertNewPermStart(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr insertNewProofErr(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell insertNewSdt(int i2) {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc insertNewTc(int i2) {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeBookmarkEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeBookmarkStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCommentRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCommentRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXml(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlDelRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlDelRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlInsRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlInsRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeCustomXmlMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeDel(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeIns(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFrom(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFromRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveFromRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveTo(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveToRangeEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeMoveToRangeStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeOMath(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeOMathPara(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removePermEnd(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removePermStart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeProofErr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeSdt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void removeTc(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTBookmarkArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlArray(CTCustomXmlCell[] cTCustomXmlCellArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTCustomXmlCellArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTTrackChangeArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        check_orphaned();
        arraySetterHelper(cTRunTrackChangeArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupRangeArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        check_orphaned();
        arraySetterHelper(cTMoveBookmarkArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathArray(CTOMath[] cTOMathArr) {
        check_orphaned();
        arraySetterHelper(cTOMathArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        check_orphaned();
        arraySetterHelper(cTOMathParaArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermEndArray(CTPerm[] cTPermArr) {
        check_orphaned();
        arraySetterHelper(cTPermArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        check_orphaned();
        arraySetterHelper(cTPermStartArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        check_orphaned();
        arraySetterHelper(cTProofErrArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setSdtArray(CTSdtCell[] cTSdtCellArr) {
        check_orphaned();
        arraySetterHelper(cTSdtCellArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setTcArray(CTTc[] cTTcArr) {
        check_orphaned();
        arraySetterHelper(cTTcArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public int sizeOfTcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getBookmarkEndArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTBookmark getBookmarkStartArray(int i2) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getCommentRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getCommentRangeStartArray(int i2) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTMarkupRange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTCustomXmlCell getCustomXmlArray(int i2) {
        CTCustomXmlCell cTCustomXmlCellFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlCellFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTCustomXmlCellFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTCustomXmlCellFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlDelRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlDelRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlInsRangeEndArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlInsRangeStartArray(int i2) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getDelArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getInsArray(int i2) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTRunTrackChange == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getMoveFromArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getMoveFromRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark getMoveFromRangeStartArray(int i2) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTMoveBookmark == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTRunTrackChange getMoveToArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMarkupRange getMoveToRangeEndArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTMoveBookmark getMoveToRangeStartArray(int i2) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMath getOMathArray(int i2) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTOMath == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTOMathPara getOMathParaArray(int i2) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTOMathPara == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPerm getPermEndArray(int i2) {
        CTPerm cTPerm;
        synchronized (monitor()) {
            check_orphaned();
            cTPerm = (CTPerm) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTPerm == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPerm;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTPermStart getPermStartArray(int i2) {
        CTPermStart cTPermStart;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStart = (CTPermStart) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTPermStart == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPermStart;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTProofErr getProofErrArray(int i2) {
        CTProofErr cTProofErr;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErr = (CTProofErr) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTProofErr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTProofErr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTSdtCell getSdtArray(int i2) {
        CTSdtCell cTSdtCell;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtCell = (CTSdtCell) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTSdtCell == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSdtCell;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public CTTc getTcArray(int i2) {
        CTTc cTTc;
        synchronized (monitor()) {
            check_orphaned();
            cTTc = (CTTc) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTTc == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setBookmarkStartArray(int i2, CTBookmark cTBookmark) throws Throwable {
        generatedSetterHelperImpl(cTBookmark, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlArray(int i2, CTCustomXmlCell cTCustomXmlCell) throws Throwable {
        generatedSetterHelperImpl(cTCustomXmlCell, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlDelRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlInsRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveFromRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeEndArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setCustomXmlMoveToRangeStartArray(int i2, CTTrackChange cTTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTTrackChange, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setDelArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setInsArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveFromRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToArray(int i2, CTRunTrackChange cTRunTrackChange) throws Throwable {
        generatedSetterHelperImpl(cTRunTrackChange, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeEndArray(int i2, CTMarkupRange cTMarkupRange) throws Throwable {
        generatedSetterHelperImpl(cTMarkupRange, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setMoveToRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark) throws Throwable {
        generatedSetterHelperImpl(cTMoveBookmark, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathArray(int i2, CTOMath cTOMath) throws Throwable {
        generatedSetterHelperImpl(cTOMath, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setOMathParaArray(int i2, CTOMathPara cTOMathPara) throws Throwable {
        generatedSetterHelperImpl(cTOMathPara, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermEndArray(int i2, CTPerm cTPerm) throws Throwable {
        generatedSetterHelperImpl(cTPerm, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setPermStartArray(int i2, CTPermStart cTPermStart) throws Throwable {
        generatedSetterHelperImpl(cTPermStart, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setProofErrArray(int i2, CTProofErr cTProofErr) throws Throwable {
        generatedSetterHelperImpl(cTProofErr, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setSdtArray(int i2, CTSdtCell cTSdtCell) throws Throwable {
        generatedSetterHelperImpl(cTSdtCell, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell
    public void setTcArray(int i2, CTTc cTTc) throws Throwable {
        generatedSetterHelperImpl(cTTc, PROPERTY_QNAME[0], i2, (short) 2);
    }
}
