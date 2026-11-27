package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
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

/* loaded from: classes2.dex */
public interface CTR extends XmlObject {
    public static final DocumentFactory<CTR> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTR> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctr386atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEmpty addNewAnnotationRef();

    CTBr addNewBr();

    CTMarkup addNewCommentReference();

    CTRel addNewContentPart();

    CTEmpty addNewContinuationSeparator();

    CTEmpty addNewCr();

    CTEmpty addNewDayLong();

    CTEmpty addNewDayShort();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewDelInstrText();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewDelText();

    CTDrawing addNewDrawing();

    CTEmpty addNewEndnoteRef();

    CTFtnEdnRef addNewEndnoteReference();

    CTFldChar addNewFldChar();

    CTEmpty addNewFootnoteRef();

    CTFtnEdnRef addNewFootnoteReference();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewInstrText();

    CTEmpty addNewLastRenderedPageBreak();

    CTEmpty addNewMonthLong();

    CTEmpty addNewMonthShort();

    CTEmpty addNewNoBreakHyphen();

    CTObject addNewObject();

    CTEmpty addNewPgNum();

    CTPicture addNewPict();

    CTPTab addNewPtab();

    CTRPR addNewRPr();

    CTRPr addNewRPr2();

    CTRuby addNewRuby();

    CTEmpty addNewSeparator();

    CTEmpty addNewSoftHyphen();

    CTSym addNewSym();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText addNewT();

    CTText addNewT2();

    CTEmpty addNewTab();

    CTEmpty addNewYearLong();

    CTEmpty addNewYearShort();

    CTEmpty getAnnotationRefArray(int i2);

    CTEmpty[] getAnnotationRefArray();

    List<CTEmpty> getAnnotationRefList();

    CTBr getBrArray(int i2);

    CTBr[] getBrArray();

    List<CTBr> getBrList();

    CTMarkup getCommentReferenceArray(int i2);

    CTMarkup[] getCommentReferenceArray();

    List<CTMarkup> getCommentReferenceList();

    CTRel getContentPartArray(int i2);

    CTRel[] getContentPartArray();

    List<CTRel> getContentPartList();

    CTEmpty getContinuationSeparatorArray(int i2);

    CTEmpty[] getContinuationSeparatorArray();

    List<CTEmpty> getContinuationSeparatorList();

    CTEmpty getCrArray(int i2);

    CTEmpty[] getCrArray();

    List<CTEmpty> getCrList();

    CTEmpty getDayLongArray(int i2);

    CTEmpty[] getDayLongArray();

    List<CTEmpty> getDayLongList();

    CTEmpty getDayShortArray(int i2);

    CTEmpty[] getDayShortArray();

    List<CTEmpty> getDayShortList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getDelInstrTextArray(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getDelInstrTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getDelInstrTextList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getDelTextArray(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getDelTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getDelTextList();

    CTDrawing getDrawingArray(int i2);

    CTDrawing[] getDrawingArray();

    List<CTDrawing> getDrawingList();

    CTEmpty getEndnoteRefArray(int i2);

    CTEmpty[] getEndnoteRefArray();

    List<CTEmpty> getEndnoteRefList();

    CTFtnEdnRef getEndnoteReferenceArray(int i2);

    CTFtnEdnRef[] getEndnoteReferenceArray();

    List<CTFtnEdnRef> getEndnoteReferenceList();

    CTFldChar getFldCharArray(int i2);

    CTFldChar[] getFldCharArray();

    List<CTFldChar> getFldCharList();

    CTEmpty getFootnoteRefArray(int i2);

    CTEmpty[] getFootnoteRefArray();

    List<CTEmpty> getFootnoteRefList();

    CTFtnEdnRef getFootnoteReferenceArray(int i2);

    CTFtnEdnRef[] getFootnoteReferenceArray();

    List<CTFtnEdnRef> getFootnoteReferenceList();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getInstrTextArray(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getInstrTextArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getInstrTextList();

    CTEmpty getLastRenderedPageBreakArray(int i2);

    CTEmpty[] getLastRenderedPageBreakArray();

    List<CTEmpty> getLastRenderedPageBreakList();

    CTEmpty getMonthLongArray(int i2);

    CTEmpty[] getMonthLongArray();

    List<CTEmpty> getMonthLongList();

    CTEmpty getMonthShortArray(int i2);

    CTEmpty[] getMonthShortArray();

    List<CTEmpty> getMonthShortList();

    CTEmpty getNoBreakHyphenArray(int i2);

    CTEmpty[] getNoBreakHyphenArray();

    List<CTEmpty> getNoBreakHyphenList();

    CTObject getObjectArray(int i2);

    CTObject[] getObjectArray();

    List<CTObject> getObjectList();

    CTEmpty getPgNumArray(int i2);

    CTEmpty[] getPgNumArray();

    List<CTEmpty> getPgNumList();

    CTPicture getPictArray(int i2);

    CTPicture[] getPictArray();

    List<CTPicture> getPictList();

    CTPTab getPtabArray(int i2);

    CTPTab[] getPtabArray();

    List<CTPTab> getPtabList();

    CTRPR getRPr();

    CTRPr getRPr2();

    CTRuby getRubyArray(int i2);

    CTRuby[] getRubyArray();

    List<CTRuby> getRubyList();

    CTEmpty getSeparatorArray(int i2);

    CTEmpty[] getSeparatorArray();

    List<CTEmpty> getSeparatorList();

    CTEmpty getSoftHyphenArray(int i2);

    CTEmpty[] getSoftHyphenArray();

    List<CTEmpty> getSoftHyphenList();

    CTSym getSymArray(int i2);

    CTSym[] getSymArray();

    List<CTSym> getSymList();

    CTText getT2Array(int i2);

    CTText[] getT2Array();

    List<CTText> getT2List();

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText getTArray(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] getTArray();

    List<org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText> getTList();

    CTEmpty getTabArray(int i2);

    CTEmpty[] getTabArray();

    List<CTEmpty> getTabList();

    CTEmpty getYearLongArray(int i2);

    CTEmpty[] getYearLongArray();

    List<CTEmpty> getYearLongList();

    CTEmpty getYearShortArray(int i2);

    CTEmpty[] getYearShortArray();

    List<CTEmpty> getYearShortList();

    CTEmpty insertNewAnnotationRef(int i2);

    CTBr insertNewBr(int i2);

    CTMarkup insertNewCommentReference(int i2);

    CTRel insertNewContentPart(int i2);

    CTEmpty insertNewContinuationSeparator(int i2);

    CTEmpty insertNewCr(int i2);

    CTEmpty insertNewDayLong(int i2);

    CTEmpty insertNewDayShort(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewDelInstrText(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewDelText(int i2);

    CTDrawing insertNewDrawing(int i2);

    CTEmpty insertNewEndnoteRef(int i2);

    CTFtnEdnRef insertNewEndnoteReference(int i2);

    CTFldChar insertNewFldChar(int i2);

    CTEmpty insertNewFootnoteRef(int i2);

    CTFtnEdnRef insertNewFootnoteReference(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewInstrText(int i2);

    CTEmpty insertNewLastRenderedPageBreak(int i2);

    CTEmpty insertNewMonthLong(int i2);

    CTEmpty insertNewMonthShort(int i2);

    CTEmpty insertNewNoBreakHyphen(int i2);

    CTObject insertNewObject(int i2);

    CTEmpty insertNewPgNum(int i2);

    CTPicture insertNewPict(int i2);

    CTPTab insertNewPtab(int i2);

    CTRuby insertNewRuby(int i2);

    CTEmpty insertNewSeparator(int i2);

    CTEmpty insertNewSoftHyphen(int i2);

    CTSym insertNewSym(int i2);

    org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText insertNewT(int i2);

    CTText insertNewT2(int i2);

    CTEmpty insertNewTab(int i2);

    CTEmpty insertNewYearLong(int i2);

    CTEmpty insertNewYearShort(int i2);

    boolean isSetRPr();

    boolean isSetRPr2();

    void removeAnnotationRef(int i2);

    void removeBr(int i2);

    void removeCommentReference(int i2);

    void removeContentPart(int i2);

    void removeContinuationSeparator(int i2);

    void removeCr(int i2);

    void removeDayLong(int i2);

    void removeDayShort(int i2);

    void removeDelInstrText(int i2);

    void removeDelText(int i2);

    void removeDrawing(int i2);

    void removeEndnoteRef(int i2);

    void removeEndnoteReference(int i2);

    void removeFldChar(int i2);

    void removeFootnoteRef(int i2);

    void removeFootnoteReference(int i2);

    void removeInstrText(int i2);

    void removeLastRenderedPageBreak(int i2);

    void removeMonthLong(int i2);

    void removeMonthShort(int i2);

    void removeNoBreakHyphen(int i2);

    void removeObject(int i2);

    void removePgNum(int i2);

    void removePict(int i2);

    void removePtab(int i2);

    void removeRuby(int i2);

    void removeSeparator(int i2);

    void removeSoftHyphen(int i2);

    void removeSym(int i2);

    void removeT(int i2);

    void removeT2(int i2);

    void removeTab(int i2);

    void removeYearLong(int i2);

    void removeYearShort(int i2);

    void setAnnotationRefArray(int i2, CTEmpty cTEmpty);

    void setAnnotationRefArray(CTEmpty[] cTEmptyArr);

    void setBrArray(int i2, CTBr cTBr);

    void setBrArray(CTBr[] cTBrArr);

    void setCommentReferenceArray(int i2, CTMarkup cTMarkup);

    void setCommentReferenceArray(CTMarkup[] cTMarkupArr);

    void setContentPartArray(int i2, CTRel cTRel);

    void setContentPartArray(CTRel[] cTRelArr);

    void setContinuationSeparatorArray(int i2, CTEmpty cTEmpty);

    void setContinuationSeparatorArray(CTEmpty[] cTEmptyArr);

    void setCrArray(int i2, CTEmpty cTEmpty);

    void setCrArray(CTEmpty[] cTEmptyArr);

    void setDayLongArray(int i2, CTEmpty cTEmpty);

    void setDayLongArray(CTEmpty[] cTEmptyArr);

    void setDayShortArray(int i2, CTEmpty cTEmpty);

    void setDayShortArray(CTEmpty[] cTEmptyArr);

    void setDelInstrTextArray(int i2, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setDelInstrTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setDelTextArray(int i2, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setDelTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setDrawingArray(int i2, CTDrawing cTDrawing);

    void setDrawingArray(CTDrawing[] cTDrawingArr);

    void setEndnoteRefArray(int i2, CTEmpty cTEmpty);

    void setEndnoteRefArray(CTEmpty[] cTEmptyArr);

    void setEndnoteReferenceArray(int i2, CTFtnEdnRef cTFtnEdnRef);

    void setEndnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setFldCharArray(int i2, CTFldChar cTFldChar);

    void setFldCharArray(CTFldChar[] cTFldCharArr);

    void setFootnoteRefArray(int i2, CTEmpty cTEmpty);

    void setFootnoteRefArray(CTEmpty[] cTEmptyArr);

    void setFootnoteReferenceArray(int i2, CTFtnEdnRef cTFtnEdnRef);

    void setFootnoteReferenceArray(CTFtnEdnRef[] cTFtnEdnRefArr);

    void setInstrTextArray(int i2, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setInstrTextArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setLastRenderedPageBreakArray(int i2, CTEmpty cTEmpty);

    void setLastRenderedPageBreakArray(CTEmpty[] cTEmptyArr);

    void setMonthLongArray(int i2, CTEmpty cTEmpty);

    void setMonthLongArray(CTEmpty[] cTEmptyArr);

    void setMonthShortArray(int i2, CTEmpty cTEmpty);

    void setMonthShortArray(CTEmpty[] cTEmptyArr);

    void setNoBreakHyphenArray(int i2, CTEmpty cTEmpty);

    void setNoBreakHyphenArray(CTEmpty[] cTEmptyArr);

    void setObjectArray(int i2, CTObject cTObject);

    void setObjectArray(CTObject[] cTObjectArr);

    void setPgNumArray(int i2, CTEmpty cTEmpty);

    void setPgNumArray(CTEmpty[] cTEmptyArr);

    void setPictArray(int i2, CTPicture cTPicture);

    void setPictArray(CTPicture[] cTPictureArr);

    void setPtabArray(int i2, CTPTab cTPTab);

    void setPtabArray(CTPTab[] cTPTabArr);

    void setRPr(CTRPR ctrpr);

    void setRPr2(CTRPr cTRPr);

    void setRubyArray(int i2, CTRuby cTRuby);

    void setRubyArray(CTRuby[] cTRubyArr);

    void setSeparatorArray(int i2, CTEmpty cTEmpty);

    void setSeparatorArray(CTEmpty[] cTEmptyArr);

    void setSoftHyphenArray(int i2, CTEmpty cTEmpty);

    void setSoftHyphenArray(CTEmpty[] cTEmptyArr);

    void setSymArray(int i2, CTSym cTSym);

    void setSymArray(CTSym[] cTSymArr);

    void setT2Array(int i2, CTText cTText);

    void setT2Array(CTText[] cTTextArr);

    void setTArray(int i2, org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText cTText);

    void setTArray(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText[] cTTextArr);

    void setTabArray(int i2, CTEmpty cTEmpty);

    void setTabArray(CTEmpty[] cTEmptyArr);

    void setYearLongArray(int i2, CTEmpty cTEmpty);

    void setYearLongArray(CTEmpty[] cTEmptyArr);

    void setYearShortArray(int i2, CTEmpty cTEmpty);

    void setYearShortArray(CTEmpty[] cTEmptyArr);

    int sizeOfAnnotationRefArray();

    int sizeOfBrArray();

    int sizeOfCommentReferenceArray();

    int sizeOfContentPartArray();

    int sizeOfContinuationSeparatorArray();

    int sizeOfCrArray();

    int sizeOfDayLongArray();

    int sizeOfDayShortArray();

    int sizeOfDelInstrTextArray();

    int sizeOfDelTextArray();

    int sizeOfDrawingArray();

    int sizeOfEndnoteRefArray();

    int sizeOfEndnoteReferenceArray();

    int sizeOfFldCharArray();

    int sizeOfFootnoteRefArray();

    int sizeOfFootnoteReferenceArray();

    int sizeOfInstrTextArray();

    int sizeOfLastRenderedPageBreakArray();

    int sizeOfMonthLongArray();

    int sizeOfMonthShortArray();

    int sizeOfNoBreakHyphenArray();

    int sizeOfObjectArray();

    int sizeOfPgNumArray();

    int sizeOfPictArray();

    int sizeOfPtabArray();

    int sizeOfRubyArray();

    int sizeOfSeparatorArray();

    int sizeOfSoftHyphenArray();

    int sizeOfSymArray();

    int sizeOfT2Array();

    int sizeOfTArray();

    int sizeOfTabArray();

    int sizeOfYearLongArray();

    int sizeOfYearShortArray();

    void unsetRPr();

    void unsetRPr2();
}
