package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* loaded from: classes3.dex */
public interface CTTc extends XmlObject {
    public static final DocumentFactory<CTTc> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTc> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttc4019type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAltChunk addNewAltChunk();

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

    CTMarkupRange addNewCommentRangeEnd();

    CTMarkupRange addNewCommentRangeStart();

    CTCustomXmlBlock addNewCustomXml();

    CTMarkup addNewCustomXmlDelRangeEnd();

    CTTrackChange addNewCustomXmlDelRangeStart();

    CTMarkup addNewCustomXmlInsRangeEnd();

    CTTrackChange addNewCustomXmlInsRangeStart();

    CTMarkup addNewCustomXmlMoveFromRangeEnd();

    CTTrackChange addNewCustomXmlMoveFromRangeStart();

    CTMarkup addNewCustomXmlMoveToRangeEnd();

    CTTrackChange addNewCustomXmlMoveToRangeStart();

    CTRunTrackChange addNewDel();

    CTRunTrackChange addNewIns();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTP addNewP();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTProofErr addNewProofErr();

    CTSdtBlock addNewSdt();

    CTTbl addNewTbl();

    CTTcPr addNewTcPr();

    CTAltChunk getAltChunkArray(int i2);

    CTAltChunk[] getAltChunkArray();

    List<CTAltChunk> getAltChunkList();

    CTMarkupRange getBookmarkEndArray(int i2);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i2);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

    CTMarkupRange getCommentRangeEndArray(int i2);

    CTMarkupRange[] getCommentRangeEndArray();

    List<CTMarkupRange> getCommentRangeEndList();

    CTMarkupRange getCommentRangeStartArray(int i2);

    CTMarkupRange[] getCommentRangeStartArray();

    List<CTMarkupRange> getCommentRangeStartList();

    CTCustomXmlBlock getCustomXmlArray(int i2);

    CTCustomXmlBlock[] getCustomXmlArray();

    CTMarkup getCustomXmlDelRangeEndArray(int i2);

    CTMarkup[] getCustomXmlDelRangeEndArray();

    List<CTMarkup> getCustomXmlDelRangeEndList();

    CTTrackChange getCustomXmlDelRangeStartArray(int i2);

    CTTrackChange[] getCustomXmlDelRangeStartArray();

    List<CTTrackChange> getCustomXmlDelRangeStartList();

    CTMarkup getCustomXmlInsRangeEndArray(int i2);

    CTMarkup[] getCustomXmlInsRangeEndArray();

    List<CTMarkup> getCustomXmlInsRangeEndList();

    CTTrackChange getCustomXmlInsRangeStartArray(int i2);

    CTTrackChange[] getCustomXmlInsRangeStartArray();

    List<CTTrackChange> getCustomXmlInsRangeStartList();

    List<CTCustomXmlBlock> getCustomXmlList();

    CTMarkup getCustomXmlMoveFromRangeEndArray(int i2);

    CTMarkup[] getCustomXmlMoveFromRangeEndArray();

    List<CTMarkup> getCustomXmlMoveFromRangeEndList();

    CTTrackChange getCustomXmlMoveFromRangeStartArray(int i2);

    CTTrackChange[] getCustomXmlMoveFromRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveFromRangeStartList();

    CTMarkup getCustomXmlMoveToRangeEndArray(int i2);

    CTMarkup[] getCustomXmlMoveToRangeEndArray();

    List<CTMarkup> getCustomXmlMoveToRangeEndList();

    CTTrackChange getCustomXmlMoveToRangeStartArray(int i2);

    CTTrackChange[] getCustomXmlMoveToRangeStartArray();

    List<CTTrackChange> getCustomXmlMoveToRangeStartList();

    CTRunTrackChange getDelArray(int i2);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    String getId();

    CTRunTrackChange getInsArray(int i2);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

    CTRunTrackChange getMoveFromArray(int i2);

    CTRunTrackChange[] getMoveFromArray();

    List<CTRunTrackChange> getMoveFromList();

    CTMarkupRange getMoveFromRangeEndArray(int i2);

    CTMarkupRange[] getMoveFromRangeEndArray();

    List<CTMarkupRange> getMoveFromRangeEndList();

    CTMoveBookmark getMoveFromRangeStartArray(int i2);

    CTMoveBookmark[] getMoveFromRangeStartArray();

    List<CTMoveBookmark> getMoveFromRangeStartList();

    CTRunTrackChange getMoveToArray(int i2);

    CTRunTrackChange[] getMoveToArray();

    List<CTRunTrackChange> getMoveToList();

    CTMarkupRange getMoveToRangeEndArray(int i2);

    CTMarkupRange[] getMoveToRangeEndArray();

    List<CTMarkupRange> getMoveToRangeEndList();

    CTMoveBookmark getMoveToRangeStartArray(int i2);

    CTMoveBookmark[] getMoveToRangeStartArray();

    List<CTMoveBookmark> getMoveToRangeStartList();

    CTOMath getOMathArray(int i2);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathPara getOMathParaArray(int i2);

    CTOMathPara[] getOMathParaArray();

    List<CTOMathPara> getOMathParaList();

    CTP getPArray(int i2);

    CTP[] getPArray();

    List<CTP> getPList();

    CTPerm getPermEndArray(int i2);

    CTPerm[] getPermEndArray();

    List<CTPerm> getPermEndList();

    CTPermStart getPermStartArray(int i2);

    CTPermStart[] getPermStartArray();

    List<CTPermStart> getPermStartList();

    CTProofErr getProofErrArray(int i2);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    CTSdtBlock getSdtArray(int i2);

    CTSdtBlock[] getSdtArray();

    List<CTSdtBlock> getSdtList();

    CTTbl getTblArray(int i2);

    CTTbl[] getTblArray();

    List<CTTbl> getTblList();

    CTTcPr getTcPr();

    CTAltChunk insertNewAltChunk(int i2);

    CTMarkupRange insertNewBookmarkEnd(int i2);

    CTBookmark insertNewBookmarkStart(int i2);

    CTMarkupRange insertNewCommentRangeEnd(int i2);

    CTMarkupRange insertNewCommentRangeStart(int i2);

    CTCustomXmlBlock insertNewCustomXml(int i2);

    CTMarkup insertNewCustomXmlDelRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlDelRangeStart(int i2);

    CTMarkup insertNewCustomXmlInsRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlInsRangeStart(int i2);

    CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2);

    CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2);

    CTRunTrackChange insertNewDel(int i2);

    CTRunTrackChange insertNewIns(int i2);

    CTRunTrackChange insertNewMoveFrom(int i2);

    CTMarkupRange insertNewMoveFromRangeEnd(int i2);

    CTMoveBookmark insertNewMoveFromRangeStart(int i2);

    CTRunTrackChange insertNewMoveTo(int i2);

    CTMarkupRange insertNewMoveToRangeEnd(int i2);

    CTMoveBookmark insertNewMoveToRangeStart(int i2);

    CTOMath insertNewOMath(int i2);

    CTOMathPara insertNewOMathPara(int i2);

    CTP insertNewP(int i2);

    CTPerm insertNewPermEnd(int i2);

    CTPermStart insertNewPermStart(int i2);

    CTProofErr insertNewProofErr(int i2);

    CTSdtBlock insertNewSdt(int i2);

    CTTbl insertNewTbl(int i2);

    boolean isSetId();

    boolean isSetTcPr();

    void removeAltChunk(int i2);

    void removeBookmarkEnd(int i2);

    void removeBookmarkStart(int i2);

    void removeCommentRangeEnd(int i2);

    void removeCommentRangeStart(int i2);

    void removeCustomXml(int i2);

    void removeCustomXmlDelRangeEnd(int i2);

    void removeCustomXmlDelRangeStart(int i2);

    void removeCustomXmlInsRangeEnd(int i2);

    void removeCustomXmlInsRangeStart(int i2);

    void removeCustomXmlMoveFromRangeEnd(int i2);

    void removeCustomXmlMoveFromRangeStart(int i2);

    void removeCustomXmlMoveToRangeEnd(int i2);

    void removeCustomXmlMoveToRangeStart(int i2);

    void removeDel(int i2);

    void removeIns(int i2);

    void removeMoveFrom(int i2);

    void removeMoveFromRangeEnd(int i2);

    void removeMoveFromRangeStart(int i2);

    void removeMoveTo(int i2);

    void removeMoveToRangeEnd(int i2);

    void removeMoveToRangeStart(int i2);

    void removeOMath(int i2);

    void removeOMathPara(int i2);

    void removeP(int i2);

    void removePermEnd(int i2);

    void removePermStart(int i2);

    void removeProofErr(int i2);

    void removeSdt(int i2);

    void removeTbl(int i2);

    void setAltChunkArray(int i2, CTAltChunk cTAltChunk);

    void setAltChunkArray(CTAltChunk[] cTAltChunkArr);

    void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i2, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

    void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange);

    void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCustomXmlArray(int i2, CTCustomXmlBlock cTCustomXmlBlock);

    void setCustomXmlArray(CTCustomXmlBlock[] cTCustomXmlBlockArr);

    void setCustomXmlDelRangeEndArray(int i2, CTMarkup cTMarkup);

    void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlDelRangeStartArray(int i2, CTTrackChange cTTrackChange);

    void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlInsRangeEndArray(int i2, CTMarkup cTMarkup);

    void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlInsRangeStartArray(int i2, CTTrackChange cTTrackChange);

    void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveFromRangeEndArray(int i2, CTMarkup cTMarkup);

    void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveFromRangeStartArray(int i2, CTTrackChange cTTrackChange);

    void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setCustomXmlMoveToRangeEndArray(int i2, CTMarkup cTMarkup);

    void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr);

    void setCustomXmlMoveToRangeStartArray(int i2, CTTrackChange cTTrackChange);

    void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr);

    void setDelArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setId(String str);

    void setInsArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveFromRangeEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveFromRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark);

    void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setMoveToArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setMoveToRangeEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setMoveToRangeStartArray(int i2, CTMoveBookmark cTMoveBookmark);

    void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr);

    void setOMathArray(int i2, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i2, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPArray(int i2, CTP ctp);

    void setPArray(CTP[] ctpArr);

    void setPermEndArray(int i2, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i2, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setProofErrArray(int i2, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setSdtArray(int i2, CTSdtBlock cTSdtBlock);

    void setSdtArray(CTSdtBlock[] cTSdtBlockArr);

    void setTblArray(int i2, CTTbl cTTbl);

    void setTblArray(CTTbl[] cTTblArr);

    void setTcPr(CTTcPr cTTcPr);

    int sizeOfAltChunkArray();

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

    int sizeOfCommentRangeEndArray();

    int sizeOfCommentRangeStartArray();

    int sizeOfCustomXmlArray();

    int sizeOfCustomXmlDelRangeEndArray();

    int sizeOfCustomXmlDelRangeStartArray();

    int sizeOfCustomXmlInsRangeEndArray();

    int sizeOfCustomXmlInsRangeStartArray();

    int sizeOfCustomXmlMoveFromRangeEndArray();

    int sizeOfCustomXmlMoveFromRangeStartArray();

    int sizeOfCustomXmlMoveToRangeEndArray();

    int sizeOfCustomXmlMoveToRangeStartArray();

    int sizeOfDelArray();

    int sizeOfInsArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfProofErrArray();

    int sizeOfSdtArray();

    int sizeOfTblArray();

    void unsetId();

    void unsetTcPr();

    STString xgetId();

    void xsetId(STString sTString);
}
