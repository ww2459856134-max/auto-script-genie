package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRPR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

/* loaded from: classes2.dex */
public class CTRImpl extends XmlComplexContentImpl implements CTR {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "br"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "t"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "contentPart"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "instrText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "delInstrText"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "noBreakHyphen"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "softHyphen"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayShort"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthShort"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearShort"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "dayLong"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "monthLong"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "yearLong"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "annotationRef"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteRef"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteRef"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "separator"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "continuationSeparator"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sym"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pgNum"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "cr"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tab"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "object"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pict"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "fldChar"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ruby"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footnoteReference"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnoteReference"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentReference"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "drawing"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ptab"), new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lastRenderedPageBreak"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "t")};
    private static final long serialVersionUID = 1;

    public CTRImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewAnnotationRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr addNewBr() {
        CTBr cTBr;
        synchronized (monitor()) {
            check_orphaned();
            cTBr = (CTBr) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup addNewCommentReference() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel addNewContentPart() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewContinuationSeparator() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewCr() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewDayLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewDayShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewDelInstrText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewDelText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing addNewDrawing() {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewEndnoteRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef addNewEndnoteReference() {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar addNewFldChar() {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            check_orphaned();
            cTFldChar = (CTFldChar) get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewFootnoteRef() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef addNewFootnoteReference() {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewInstrText() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewLastRenderedPageBreak() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewMonthLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewMonthShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewNoBreakHyphen() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject addNewObject() {
        CTObject cTObject;
        synchronized (monitor()) {
            check_orphaned();
            cTObject = (CTObject) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewPgNum() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture addNewPict() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab addNewPtab() {
        CTPTab cTPTab;
        synchronized (monitor()) {
            check_orphaned();
            cTPTab = (CTPTab) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPR addNewRPr() {
        CTRPR ctrprAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrprAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctrprAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPr addNewRPr2() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby addNewRuby() {
        CTRuby cTRuby;
        synchronized (monitor()) {
            check_orphaned();
            cTRuby = (CTRuby) get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewSeparator() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewSoftHyphen() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym addNewSym() {
        CTSym cTSym;
        synchronized (monitor()) {
            check_orphaned();
            cTSym = (CTSym) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText addNewT() {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText addNewT2() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().add_element_user(PROPERTY_QNAME[35]);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewTab() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewYearLong() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty addNewYearShort() {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getAnnotationRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getAnnotationRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.if
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAnnotationRefArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAnnotationRefArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAnnotationRef(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAnnotationRef(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fo
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAnnotationRefArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr[] getBrArray() {
        return (CTBr[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTBr[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTBr> getBrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ko
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBrArray(((Integer) obj).intValue(), (CTBr) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jp
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeBr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup[] getCommentReferenceArray() {
        return (CTMarkup[]) getXmlObjectArray(PROPERTY_QNAME[31], new CTMarkup[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTMarkup> getCommentReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ai
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCommentReferenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCommentReferenceArray(((Integer) obj).intValue(), (CTMarkup) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.te
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCommentReference(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCommentReference(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCommentReferenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel[] getContentPartArray() {
        return (CTRel[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTRel[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTRel> getContentPartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getContentPartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setContentPartArray(((Integer) obj).intValue(), (CTRel) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewContentPart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeContentPart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.he
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfContentPartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getContinuationSeparatorArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[20], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getContinuationSeparatorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getContinuationSeparatorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setContinuationSeparatorArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewContinuationSeparator(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeContinuationSeparator(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ti
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfContinuationSeparatorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getCrArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getCrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCrArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCr(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCr(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCrArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getDayLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getDayLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDayLongArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wn
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDayLongArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDayLong(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.uj
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDayLong(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDayLongArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getDayShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getDayShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ej
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDayShortArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gf
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDayShortArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.y6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDayShort(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDayShort(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDayShortArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getDelInstrTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getDelInstrTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelInstrTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pg
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelInstrTextArray(((Integer) obj).intValue(), (CTText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.eo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDelInstrText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.gc
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDelInstrText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ll
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelInstrTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getDelTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getDelTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDelTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDelTextArray(((Integer) obj).intValue(), (CTText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.dp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDelText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDelText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.nn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDelTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing[] getDrawingArray() {
        return (CTDrawing[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTDrawing[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTDrawing> getDrawingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDrawingArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ra
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDrawingArray(((Integer) obj).intValue(), (CTDrawing) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDrawing(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.go
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDrawing(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ao
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDrawingArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getEndnoteRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[18], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getEndnoteRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.no
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEndnoteRefArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.rk
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEndnoteRefArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.cn
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEndnoteRef(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.se
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEndnoteRef(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.jd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEndnoteRefArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef[] getEndnoteReferenceArray() {
        return (CTFtnEdnRef[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTFtnEdnRef[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFtnEdnRef> getEndnoteReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.fe
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEndnoteReferenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vn
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEndnoteReferenceArray(((Integer) obj).intValue(), (CTFtnEdnRef) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEndnoteReference(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pl
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEndnoteReference(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEndnoteReferenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar[] getFldCharArray() {
        return (CTFldChar[]) getXmlObjectArray(PROPERTY_QNAME[27], new CTFldChar[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFldChar> getFldCharList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFldCharArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.em
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFldCharArray(((Integer) obj).intValue(), (CTFldChar) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFldChar(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFldChar(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFldCharArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getFootnoteRefArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[17], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getFootnoteRefList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ee
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFootnoteRefArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ve
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFootnoteRefArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.og
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFootnoteRef(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFootnoteRef(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w5
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFootnoteRefArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef[] getFootnoteReferenceArray() {
        return (CTFtnEdnRef[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTFtnEdnRef[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTFtnEdnRef> getFootnoteReferenceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.df
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFootnoteReferenceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.uc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFootnoteReferenceArray(((Integer) obj).intValue(), (CTFtnEdnRef) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFootnoteReference(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFootnoteReference(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sn
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFootnoteReferenceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getInstrTextArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getInstrTextList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getInstrTextArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setInstrTextArray(((Integer) obj).intValue(), (CTText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewInstrText(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeInstrText(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.zb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfInstrTextArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getLastRenderedPageBreakArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[34], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getLastRenderedPageBreakList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.dk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLastRenderedPageBreakArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLastRenderedPageBreakArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLastRenderedPageBreak(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLastRenderedPageBreak(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLastRenderedPageBreakArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getMonthLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getMonthLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.uo
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMonthLongArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pc
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMonthLongArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMonthLong(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.so
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMonthLong(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.f7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMonthLongArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getMonthShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getMonthShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMonthShortArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMonthShortArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.lg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMonthShort(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ym
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMonthShort(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.cf
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMonthShortArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getNoBreakHyphenArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getNoBreakHyphenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getNoBreakHyphenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ae
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setNoBreakHyphenArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewNoBreakHyphen(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ga
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeNoBreakHyphen(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ik
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfNoBreakHyphenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject[] getObjectArray() {
        return (CTObject[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTObject[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTObject> getObjectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.c6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getObjectArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setObjectArray(((Integer) obj).intValue(), (CTObject) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.en
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewObject(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ih
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeObject(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.bg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfObjectArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getPgNumArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[22], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getPgNumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.td
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPgNumArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.h6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPgNumArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.n6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPgNum(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ob
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePgNum(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.u9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPgNumArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture[] getPictArray() {
        return (CTPicture[]) getXmlObjectArray(PROPERTY_QNAME[26], new CTPicture[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTPicture> getPictList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wi
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPictArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPictArray(((Integer) obj).intValue(), (CTPicture) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vl
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPict(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePict(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.va
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPictArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab[] getPtabArray() {
        return (CTPTab[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTPTab[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTPTab> getPtabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.k9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPtabArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.th
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPtabArray(((Integer) obj).intValue(), (CTPTab) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPtab(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.i3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePtab(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPtabArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPR getRPr() {
        CTRPR ctrprFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrprFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (ctrprFind_element_user == null) {
                ctrprFind_element_user = null;
            }
        }
        return ctrprFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRPr getRPr2() {
        CTRPr cTRPr;
        synchronized (monitor()) {
            check_orphaned();
            cTRPr = (CTRPr) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTRPr == null) {
                cTRPr = null;
            }
        }
        return cTRPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby[] getRubyArray() {
        return (CTRuby[]) getXmlObjectArray(PROPERTY_QNAME[28], new CTRuby[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTRuby> getRubyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRubyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ic
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRubyArray(((Integer) obj).intValue(), (CTRuby) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.j7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRuby(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ph
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRuby(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vm
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRubyArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getSeparatorArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[19], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getSeparatorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSeparatorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSeparatorArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSeparator(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.x8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSeparator(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.xd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSeparatorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getSoftHyphenArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getSoftHyphenList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.rb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSoftHyphenArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yk
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSoftHyphenArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.z7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSoftHyphen(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSoftHyphen(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.d6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSoftHyphenArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym[] getSymArray() {
        return (CTSym[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTSym[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTSym> getSymList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ba
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSymArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.kj
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSymArray(((Integer) obj).intValue(), (CTSym) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.wf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSym(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.yd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSym(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.ca
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSymArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText[] getT2Array() {
        return (org.openxmlformats.schemas.officeDocument.x2006.math.CTText[]) getXmlObjectArray(PROPERTY_QNAME[35], new org.openxmlformats.schemas.officeDocument.x2006.math.CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<org.openxmlformats.schemas.officeDocument.x2006.math.CTText> getT2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.r2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getT2Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.m9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setT2Array(((Integer) obj).intValue(), (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.sk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewT2(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeT2(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.oh
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfT2Array());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText[] getTArray() {
        return (CTText[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTText[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTText> getTList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.tk
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.g5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTArray(((Integer) obj).intValue(), (CTText) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.a6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewT(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.o3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeT(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.mp
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getTabArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getTabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.l9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTabArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.p1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTabArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.h8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTab(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.el
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTab(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.hl
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTabArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getYearLongArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getYearLongList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.od
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getYearLongArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.v9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setYearLongArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.e6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewYearLong(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.s3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeYearLong(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.vo
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfYearLongArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty[] getYearShortArray() {
        return (CTEmpty[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTEmpty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public List<CTEmpty> getYearShortList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.pm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getYearShortArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.q9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setYearShortArray(((Integer) obj).intValue(), (CTEmpty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.qm
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewYearShort(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.b2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeYearShort(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.co
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfYearShortArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewAnnotationRef(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr insertNewBr(int i2) {
        CTBr cTBr;
        synchronized (monitor()) {
            check_orphaned();
            cTBr = (CTBr) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup insertNewCommentReference(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(PROPERTY_QNAME[31], i2);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel insertNewContentPart(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewContinuationSeparator(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[20], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewCr(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[23], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewDayLong(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewDayShort(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewDelInstrText(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewDelText(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing insertNewDrawing(int i2) {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().insert_element_user(PROPERTY_QNAME[32], i2);
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewEndnoteRef(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef insertNewEndnoteReference(int i2) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().insert_element_user(PROPERTY_QNAME[30], i2);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar insertNewFldChar(int i2) {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            check_orphaned();
            cTFldChar = (CTFldChar) get_store().insert_element_user(PROPERTY_QNAME[27], i2);
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewFootnoteRef(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef insertNewFootnoteReference(int i2) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().insert_element_user(PROPERTY_QNAME[29], i2);
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewInstrText(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewLastRenderedPageBreak(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[34], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewMonthLong(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewMonthShort(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewNoBreakHyphen(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject insertNewObject(int i2) {
        CTObject cTObject;
        synchronized (monitor()) {
            check_orphaned();
            cTObject = (CTObject) get_store().insert_element_user(PROPERTY_QNAME[25], i2);
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewPgNum(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[22], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture insertNewPict(int i2) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().insert_element_user(PROPERTY_QNAME[26], i2);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab insertNewPtab(int i2) {
        CTPTab cTPTab;
        synchronized (monitor()) {
            check_orphaned();
            cTPTab = (CTPTab) get_store().insert_element_user(PROPERTY_QNAME[33], i2);
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby insertNewRuby(int i2) {
        CTRuby cTRuby;
        synchronized (monitor()) {
            check_orphaned();
            cTRuby = (CTRuby) get_store().insert_element_user(PROPERTY_QNAME[28], i2);
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewSeparator(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewSoftHyphen(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym insertNewSym(int i2) {
        CTSym cTSym;
        synchronized (monitor()) {
            check_orphaned();
            cTSym = (CTSym) get_store().insert_element_user(PROPERTY_QNAME[21], i2);
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText insertNewT(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText insertNewT2(int i2) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().insert_element_user(PROPERTY_QNAME[35], i2);
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewTab(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[24], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewYearLong(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty insertNewYearShort(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public boolean isSetRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public boolean isSetRPr2() {
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

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeAnnotationRef(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeBr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeCommentReference(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeContentPart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeContinuationSeparator(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeCr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDayLong(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDayShort(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDelInstrText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDelText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeDrawing(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeEndnoteRef(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeEndnoteReference(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFldChar(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFootnoteRef(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeFootnoteReference(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeInstrText(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeLastRenderedPageBreak(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeMonthLong(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeMonthShort(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeNoBreakHyphen(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeObject(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePgNum(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePict(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removePtab(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeRuby(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSeparator(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSoftHyphen(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeSym(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeT(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeT2(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[35], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeTab(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeYearLong(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void removeYearShort(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setAnnotationRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setBrArray(CTBr[] cTBrArr) {
        check_orphaned();
        arraySetterHelper(cTBrArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCommentReferenceArray(CTMarkup[] cTMarkupArr) {
        check_orphaned();
        arraySetterHelper(cTMarkupArr, PROPERTY_QNAME[31]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContentPartArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCrArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelInstrTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDrawingArray(CTDrawing[] cTDrawingArr) {
        check_orphaned();
        arraySetterHelper(cTDrawingArr, PROPERTY_QNAME[32]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnRefArr, PROPERTY_QNAME[30]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFldCharArray(CTFldChar[] cTFldCharArr) {
        check_orphaned();
        arraySetterHelper(cTFldCharArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteRefArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr) {
        check_orphaned();
        arraySetterHelper(cTFtnEdnRefArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setInstrTextArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[34]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setObjectArray(CTObject[] cTObjectArr) {
        check_orphaned();
        arraySetterHelper(cTObjectArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPgNumArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPictArray(CTPicture[] cTPictureArr) {
        check_orphaned();
        arraySetterHelper(cTPictureArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPtabArray(CTPTab[] cTPTabArr) {
        check_orphaned();
        arraySetterHelper(cTPTabArr, PROPERTY_QNAME[33]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRPr(CTRPR ctrpr) throws Throwable {
        generatedSetterHelperImpl(ctrpr, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRPr2(CTRPr cTRPr) throws Throwable {
        generatedSetterHelperImpl(cTRPr, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRubyArray(CTRuby[] cTRubyArr) {
        check_orphaned();
        arraySetterHelper(cTRubyArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSeparatorArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSoftHyphenArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSymArray(CTSym[] cTSymArr) {
        check_orphaned();
        arraySetterHelper(cTSymArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setT2Array(org.openxmlformats.schemas.officeDocument.x2006.math.CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[35]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTArray(CTText[] cTTextArr) {
        check_orphaned();
        arraySetterHelper(cTTextArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTabArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearLongArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearShortArray(CTEmpty[] cTEmptyArr) {
        check_orphaned();
        arraySetterHelper(cTEmptyArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfAnnotationRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfBrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfCommentReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfContentPartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfContinuationSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfCrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDayLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDayShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDelInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDelTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfDrawingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfEndnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfEndnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFldCharArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFootnoteRefArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfFootnoteReferenceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfInstrTextArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfLastRenderedPageBreakArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfMonthLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfMonthShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfNoBreakHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfObjectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPgNumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPictArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfPtabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfRubyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSeparatorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSoftHyphenArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfSymArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfT2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[35]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfTArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfYearLongArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public int sizeOfYearShortArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void unsetRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void unsetRPr2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getAnnotationRefArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTBr getBrArray(int i2) {
        CTBr cTBr;
        synchronized (monitor()) {
            check_orphaned();
            cTBr = (CTBr) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTBr == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTMarkup getCommentReferenceArray(int i2) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().find_element_user(PROPERTY_QNAME[31], i2);
            if (cTMarkup == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRel getContentPartArray(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTRel == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getContinuationSeparatorArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[20], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getCrArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[23], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getDayLongArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getDayShortArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getDelInstrTextArray(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getDelTextArray(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTDrawing getDrawingArray(int i2) {
        CTDrawing cTDrawing;
        synchronized (monitor()) {
            check_orphaned();
            cTDrawing = (CTDrawing) get_store().find_element_user(PROPERTY_QNAME[32], i2);
            if (cTDrawing == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDrawing;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getEndnoteRefArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef getEndnoteReferenceArray(int i2) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().find_element_user(PROPERTY_QNAME[30], i2);
            if (cTFtnEdnRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFldChar getFldCharArray(int i2) {
        CTFldChar cTFldChar;
        synchronized (monitor()) {
            check_orphaned();
            cTFldChar = (CTFldChar) get_store().find_element_user(PROPERTY_QNAME[27], i2);
            if (cTFldChar == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFldChar;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getFootnoteRefArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTFtnEdnRef getFootnoteReferenceArray(int i2) {
        CTFtnEdnRef cTFtnEdnRef;
        synchronized (monitor()) {
            check_orphaned();
            cTFtnEdnRef = (CTFtnEdnRef) get_store().find_element_user(PROPERTY_QNAME[29], i2);
            if (cTFtnEdnRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFtnEdnRef;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getInstrTextArray(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getLastRenderedPageBreakArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[34], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getMonthLongArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getMonthShortArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getNoBreakHyphenArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTObject getObjectArray(int i2) {
        CTObject cTObject;
        synchronized (monitor()) {
            check_orphaned();
            cTObject = (CTObject) get_store().find_element_user(PROPERTY_QNAME[25], i2);
            if (cTObject == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getPgNumArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[22], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPicture getPictArray(int i2) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().find_element_user(PROPERTY_QNAME[26], i2);
            if (cTPicture == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTPTab getPtabArray(int i2) {
        CTPTab cTPTab;
        synchronized (monitor()) {
            check_orphaned();
            cTPTab = (CTPTab) get_store().find_element_user(PROPERTY_QNAME[33], i2);
            if (cTPTab == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPTab;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTRuby getRubyArray(int i2) {
        CTRuby cTRuby;
        synchronized (monitor()) {
            check_orphaned();
            cTRuby = (CTRuby) get_store().find_element_user(PROPERTY_QNAME[28], i2);
            if (cTRuby == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRuby;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getSeparatorArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getSoftHyphenArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTSym getSymArray(int i2) {
        CTSym cTSym;
        synchronized (monitor()) {
            check_orphaned();
            cTSym = (CTSym) get_store().find_element_user(PROPERTY_QNAME[21], i2);
            if (cTSym == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSym;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTText getT2Array(int i2) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (org.openxmlformats.schemas.officeDocument.x2006.math.CTText) get_store().find_element_user(PROPERTY_QNAME[35], i2);
            if (cTText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTText getTArray(int i2) {
        CTText cTText;
        synchronized (monitor()) {
            check_orphaned();
            cTText = (CTText) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTText == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTText;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getTabArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[24], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getYearLongArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public CTEmpty getYearShortArray(int i2) {
        CTEmpty cTEmpty;
        synchronized (monitor()) {
            check_orphaned();
            cTEmpty = (CTEmpty) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTEmpty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTEmpty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setAnnotationRefArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setBrArray(int i2, CTBr cTBr) throws Throwable {
        generatedSetterHelperImpl(cTBr, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCommentReferenceArray(int i2, CTMarkup cTMarkup) throws Throwable {
        generatedSetterHelperImpl(cTMarkup, PROPERTY_QNAME[31], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContentPartArray(int i2, CTRel cTRel) throws Throwable {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setContinuationSeparatorArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[20], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setCrArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[23], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayLongArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDayShortArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelInstrTextArray(int i2, CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDelTextArray(int i2, CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setDrawingArray(int i2, CTDrawing cTDrawing) throws Throwable {
        generatedSetterHelperImpl(cTDrawing, PROPERTY_QNAME[32], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteRefArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setEndnoteReferenceArray(int i2, CTFtnEdnRef cTFtnEdnRef) throws Throwable {
        generatedSetterHelperImpl(cTFtnEdnRef, PROPERTY_QNAME[30], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFldCharArray(int i2, CTFldChar cTFldChar) throws Throwable {
        generatedSetterHelperImpl(cTFldChar, PROPERTY_QNAME[27], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteRefArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setFootnoteReferenceArray(int i2, CTFtnEdnRef cTFtnEdnRef) throws Throwable {
        generatedSetterHelperImpl(cTFtnEdnRef, PROPERTY_QNAME[29], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setInstrTextArray(int i2, CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setLastRenderedPageBreakArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[34], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthLongArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setMonthShortArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setNoBreakHyphenArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setObjectArray(int i2, CTObject cTObject) throws Throwable {
        generatedSetterHelperImpl(cTObject, PROPERTY_QNAME[25], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPgNumArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[22], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPictArray(int i2, CTPicture cTPicture) throws Throwable {
        generatedSetterHelperImpl(cTPicture, PROPERTY_QNAME[26], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setPtabArray(int i2, CTPTab cTPTab) throws Throwable {
        generatedSetterHelperImpl(cTPTab, PROPERTY_QNAME[33], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setRubyArray(int i2, CTRuby cTRuby) throws Throwable {
        generatedSetterHelperImpl(cTRuby, PROPERTY_QNAME[28], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSeparatorArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[19], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSoftHyphenArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setSymArray(int i2, CTSym cTSym) throws Throwable {
        generatedSetterHelperImpl(cTSym, PROPERTY_QNAME[21], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setT2Array(int i2, org.openxmlformats.schemas.officeDocument.x2006.math.CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[35], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTArray(int i2, CTText cTText) throws Throwable {
        generatedSetterHelperImpl(cTText, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setTabArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[24], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearLongArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[15], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTR
    public void setYearShortArray(int i2, CTEmpty cTEmpty) throws Throwable {
        generatedSetterHelperImpl(cTEmpty, PROPERTY_QNAME[12], i2, (short) 2);
    }
}
