package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTR extends XmlObject {
    public static final DocumentFactory<CTR> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTR> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctr8120type");
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

    CTText addNewDelInstrText();

    CTText addNewDelText();

    CTDrawing addNewDrawing();

    CTEmpty addNewEndnoteRef();

    CTFtnEdnRef addNewEndnoteReference();

    CTFldChar addNewFldChar();

    CTEmpty addNewFootnoteRef();

    CTFtnEdnRef addNewFootnoteReference();

    CTText addNewInstrText();

    CTEmpty addNewLastRenderedPageBreak();

    CTEmpty addNewMonthLong();

    CTEmpty addNewMonthShort();

    CTEmpty addNewNoBreakHyphen();

    CTObject addNewObject();

    CTEmpty addNewPgNum();

    CTPicture addNewPict();

    CTPTab addNewPtab();

    CTRPr addNewRPr();

    CTRuby addNewRuby();

    CTEmpty addNewSeparator();

    CTEmpty addNewSoftHyphen();

    CTSym addNewSym();

    CTText addNewT();

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

    CTText getDelInstrTextArray(int i2);

    CTText[] getDelInstrTextArray();

    List<CTText> getDelInstrTextList();

    CTText getDelTextArray(int i2);

    CTText[] getDelTextArray();

    List<CTText> getDelTextList();

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

    CTText getInstrTextArray(int i2);

    CTText[] getInstrTextArray();

    List<CTText> getInstrTextList();

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

    CTRPr getRPr();

    byte[] getRsidDel();

    byte[] getRsidR();

    byte[] getRsidRPr();

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

    CTText getTArray(int i2);

    CTText[] getTArray();

    List<CTText> getTList();

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

    CTText insertNewDelInstrText(int i2);

    CTText insertNewDelText(int i2);

    CTDrawing insertNewDrawing(int i2);

    CTEmpty insertNewEndnoteRef(int i2);

    CTFtnEdnRef insertNewEndnoteReference(int i2);

    CTFldChar insertNewFldChar(int i2);

    CTEmpty insertNewFootnoteRef(int i2);

    CTFtnEdnRef insertNewFootnoteReference(int i2);

    CTText insertNewInstrText(int i2);

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

    CTText insertNewT(int i2);

    CTEmpty insertNewTab(int i2);

    CTEmpty insertNewYearLong(int i2);

    CTEmpty insertNewYearShort(int i2);

    boolean isSetRPr();

    boolean isSetRsidDel();

    boolean isSetRsidR();

    boolean isSetRsidRPr();

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

    void setDelInstrTextArray(int i2, CTText cTText);

    void setDelInstrTextArray(CTText[] cTTextArr);

    void setDelTextArray(int i2, CTText cTText);

    void setDelTextArray(CTText[] cTTextArr);

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

    void setInstrTextArray(int i2, CTText cTText);

    void setInstrTextArray(CTText[] cTTextArr);

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

    void setRPr(CTRPr cTRPr);

    void setRsidDel(byte[] bArr);

    void setRsidR(byte[] bArr);

    void setRsidRPr(byte[] bArr);

    void setRubyArray(int i2, CTRuby cTRuby);

    void setRubyArray(CTRuby[] cTRubyArr);

    void setSeparatorArray(int i2, CTEmpty cTEmpty);

    void setSeparatorArray(CTEmpty[] cTEmptyArr);

    void setSoftHyphenArray(int i2, CTEmpty cTEmpty);

    void setSoftHyphenArray(CTEmpty[] cTEmptyArr);

    void setSymArray(int i2, CTSym cTSym);

    void setSymArray(CTSym[] cTSymArr);

    void setTArray(int i2, CTText cTText);

    void setTArray(CTText[] cTTextArr);

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

    int sizeOfTArray();

    int sizeOfTabArray();

    int sizeOfYearLongArray();

    int sizeOfYearShortArray();

    void unsetRPr();

    void unsetRsidDel();

    void unsetRsidR();

    void unsetRsidRPr();

    STLongHexNumber xgetRsidDel();

    STLongHexNumber xgetRsidR();

    STLongHexNumber xgetRsidRPr();

    void xsetRsidDel(STLongHexNumber sTLongHexNumber);

    void xsetRsidR(STLongHexNumber sTLongHexNumber);

    void xsetRsidRPr(STLongHexNumber sTLongHexNumber);
}
