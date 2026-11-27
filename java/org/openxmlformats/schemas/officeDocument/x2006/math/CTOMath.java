package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
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
public interface CTOMath extends XmlObject {
    public static final DocumentFactory<CTOMath> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOMath> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctomath6725type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAcc addNewAcc();

    CTBar addNewBar();

    CTMarkupRange addNewBookmarkEnd();

    CTBookmark addNewBookmarkStart();

    CTBorderBox addNewBorderBox();

    CTBox addNewBox();

    CTMarkupRange addNewCommentRangeEnd();

    CTMarkupRange addNewCommentRangeStart();

    CTCustomXmlRun addNewCustomXml();

    CTMarkup addNewCustomXmlDelRangeEnd();

    CTTrackChange addNewCustomXmlDelRangeStart();

    CTMarkup addNewCustomXmlInsRangeEnd();

    CTTrackChange addNewCustomXmlInsRangeStart();

    CTMarkup addNewCustomXmlMoveFromRangeEnd();

    CTTrackChange addNewCustomXmlMoveFromRangeStart();

    CTMarkup addNewCustomXmlMoveToRangeEnd();

    CTTrackChange addNewCustomXmlMoveToRangeStart();

    CTD addNewD();

    CTRunTrackChange addNewDel();

    CTEqArr addNewEqArr();

    CTF addNewF();

    CTSimpleField addNewFldSimple();

    CTFunc addNewFunc();

    CTGroupChr addNewGroupChr();

    CTHyperlink addNewHyperlink();

    CTRunTrackChange addNewIns();

    CTLimLow addNewLimLow();

    CTLimUpp addNewLimUpp();

    CTM addNewM();

    CTRunTrackChange addNewMoveFrom();

    CTMarkupRange addNewMoveFromRangeEnd();

    CTMoveBookmark addNewMoveFromRangeStart();

    CTRunTrackChange addNewMoveTo();

    CTMarkupRange addNewMoveToRangeEnd();

    CTMoveBookmark addNewMoveToRangeStart();

    CTNary addNewNary();

    CTOMath addNewOMath();

    CTOMathPara addNewOMathPara();

    CTPerm addNewPermEnd();

    CTPermStart addNewPermStart();

    CTPhant addNewPhant();

    CTProofErr addNewProofErr();

    CTR addNewR();

    CTRad addNewRad();

    CTSPre addNewSPre();

    CTSSub addNewSSub();

    CTSSubSup addNewSSubSup();

    CTSSup addNewSSup();

    CTSdtRun addNewSdt();

    CTSmartTagRun addNewSmartTag();

    CTAcc getAccArray(int i2);

    CTAcc[] getAccArray();

    List<CTAcc> getAccList();

    CTBar getBarArray(int i2);

    CTBar[] getBarArray();

    List<CTBar> getBarList();

    CTMarkupRange getBookmarkEndArray(int i2);

    CTMarkupRange[] getBookmarkEndArray();

    List<CTMarkupRange> getBookmarkEndList();

    CTBookmark getBookmarkStartArray(int i2);

    CTBookmark[] getBookmarkStartArray();

    List<CTBookmark> getBookmarkStartList();

    CTBorderBox getBorderBoxArray(int i2);

    CTBorderBox[] getBorderBoxArray();

    List<CTBorderBox> getBorderBoxList();

    CTBox getBoxArray(int i2);

    CTBox[] getBoxArray();

    List<CTBox> getBoxList();

    CTMarkupRange getCommentRangeEndArray(int i2);

    CTMarkupRange[] getCommentRangeEndArray();

    List<CTMarkupRange> getCommentRangeEndList();

    CTMarkupRange getCommentRangeStartArray(int i2);

    CTMarkupRange[] getCommentRangeStartArray();

    List<CTMarkupRange> getCommentRangeStartList();

    CTCustomXmlRun getCustomXmlArray(int i2);

    CTCustomXmlRun[] getCustomXmlArray();

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

    List<CTCustomXmlRun> getCustomXmlList();

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

    CTD getDArray(int i2);

    CTD[] getDArray();

    List<CTD> getDList();

    CTRunTrackChange getDelArray(int i2);

    CTRunTrackChange[] getDelArray();

    List<CTRunTrackChange> getDelList();

    CTEqArr getEqArrArray(int i2);

    CTEqArr[] getEqArrArray();

    List<CTEqArr> getEqArrList();

    CTF getFArray(int i2);

    CTF[] getFArray();

    List<CTF> getFList();

    CTSimpleField getFldSimpleArray(int i2);

    CTSimpleField[] getFldSimpleArray();

    List<CTSimpleField> getFldSimpleList();

    CTFunc getFuncArray(int i2);

    CTFunc[] getFuncArray();

    List<CTFunc> getFuncList();

    CTGroupChr getGroupChrArray(int i2);

    CTGroupChr[] getGroupChrArray();

    List<CTGroupChr> getGroupChrList();

    CTHyperlink getHyperlinkArray(int i2);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTRunTrackChange getInsArray(int i2);

    CTRunTrackChange[] getInsArray();

    List<CTRunTrackChange> getInsList();

    CTLimLow getLimLowArray(int i2);

    CTLimLow[] getLimLowArray();

    List<CTLimLow> getLimLowList();

    CTLimUpp getLimUppArray(int i2);

    CTLimUpp[] getLimUppArray();

    List<CTLimUpp> getLimUppList();

    CTM getMArray(int i2);

    CTM[] getMArray();

    List<CTM> getMList();

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

    CTNary getNaryArray(int i2);

    CTNary[] getNaryArray();

    List<CTNary> getNaryList();

    CTOMath getOMathArray(int i2);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathPara getOMathParaArray(int i2);

    CTOMathPara[] getOMathParaArray();

    List<CTOMathPara> getOMathParaList();

    CTPerm getPermEndArray(int i2);

    CTPerm[] getPermEndArray();

    List<CTPerm> getPermEndList();

    CTPermStart getPermStartArray(int i2);

    CTPermStart[] getPermStartArray();

    List<CTPermStart> getPermStartList();

    CTPhant getPhantArray(int i2);

    CTPhant[] getPhantArray();

    List<CTPhant> getPhantList();

    CTProofErr getProofErrArray(int i2);

    CTProofErr[] getProofErrArray();

    List<CTProofErr> getProofErrList();

    CTR getRArray(int i2);

    CTR[] getRArray();

    List<CTR> getRList();

    CTRad getRadArray(int i2);

    CTRad[] getRadArray();

    List<CTRad> getRadList();

    CTSPre getSPreArray(int i2);

    CTSPre[] getSPreArray();

    List<CTSPre> getSPreList();

    CTSSub getSSubArray(int i2);

    CTSSub[] getSSubArray();

    List<CTSSub> getSSubList();

    CTSSubSup getSSubSupArray(int i2);

    CTSSubSup[] getSSubSupArray();

    List<CTSSubSup> getSSubSupList();

    CTSSup getSSupArray(int i2);

    CTSSup[] getSSupArray();

    List<CTSSup> getSSupList();

    CTSdtRun getSdtArray(int i2);

    CTSdtRun[] getSdtArray();

    List<CTSdtRun> getSdtList();

    CTSmartTagRun getSmartTagArray(int i2);

    CTSmartTagRun[] getSmartTagArray();

    List<CTSmartTagRun> getSmartTagList();

    CTAcc insertNewAcc(int i2);

    CTBar insertNewBar(int i2);

    CTMarkupRange insertNewBookmarkEnd(int i2);

    CTBookmark insertNewBookmarkStart(int i2);

    CTBorderBox insertNewBorderBox(int i2);

    CTBox insertNewBox(int i2);

    CTMarkupRange insertNewCommentRangeEnd(int i2);

    CTMarkupRange insertNewCommentRangeStart(int i2);

    CTCustomXmlRun insertNewCustomXml(int i2);

    CTMarkup insertNewCustomXmlDelRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlDelRangeStart(int i2);

    CTMarkup insertNewCustomXmlInsRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlInsRangeStart(int i2);

    CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i2);

    CTMarkup insertNewCustomXmlMoveToRangeEnd(int i2);

    CTTrackChange insertNewCustomXmlMoveToRangeStart(int i2);

    CTD insertNewD(int i2);

    CTRunTrackChange insertNewDel(int i2);

    CTEqArr insertNewEqArr(int i2);

    CTF insertNewF(int i2);

    CTSimpleField insertNewFldSimple(int i2);

    CTFunc insertNewFunc(int i2);

    CTGroupChr insertNewGroupChr(int i2);

    CTHyperlink insertNewHyperlink(int i2);

    CTRunTrackChange insertNewIns(int i2);

    CTLimLow insertNewLimLow(int i2);

    CTLimUpp insertNewLimUpp(int i2);

    CTM insertNewM(int i2);

    CTRunTrackChange insertNewMoveFrom(int i2);

    CTMarkupRange insertNewMoveFromRangeEnd(int i2);

    CTMoveBookmark insertNewMoveFromRangeStart(int i2);

    CTRunTrackChange insertNewMoveTo(int i2);

    CTMarkupRange insertNewMoveToRangeEnd(int i2);

    CTMoveBookmark insertNewMoveToRangeStart(int i2);

    CTNary insertNewNary(int i2);

    CTOMath insertNewOMath(int i2);

    CTOMathPara insertNewOMathPara(int i2);

    CTPerm insertNewPermEnd(int i2);

    CTPermStart insertNewPermStart(int i2);

    CTPhant insertNewPhant(int i2);

    CTProofErr insertNewProofErr(int i2);

    CTR insertNewR(int i2);

    CTRad insertNewRad(int i2);

    CTSPre insertNewSPre(int i2);

    CTSSub insertNewSSub(int i2);

    CTSSubSup insertNewSSubSup(int i2);

    CTSSup insertNewSSup(int i2);

    CTSdtRun insertNewSdt(int i2);

    CTSmartTagRun insertNewSmartTag(int i2);

    void removeAcc(int i2);

    void removeBar(int i2);

    void removeBookmarkEnd(int i2);

    void removeBookmarkStart(int i2);

    void removeBorderBox(int i2);

    void removeBox(int i2);

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

    void removeD(int i2);

    void removeDel(int i2);

    void removeEqArr(int i2);

    void removeF(int i2);

    void removeFldSimple(int i2);

    void removeFunc(int i2);

    void removeGroupChr(int i2);

    void removeHyperlink(int i2);

    void removeIns(int i2);

    void removeLimLow(int i2);

    void removeLimUpp(int i2);

    void removeM(int i2);

    void removeMoveFrom(int i2);

    void removeMoveFromRangeEnd(int i2);

    void removeMoveFromRangeStart(int i2);

    void removeMoveTo(int i2);

    void removeMoveToRangeEnd(int i2);

    void removeMoveToRangeStart(int i2);

    void removeNary(int i2);

    void removeOMath(int i2);

    void removeOMathPara(int i2);

    void removePermEnd(int i2);

    void removePermStart(int i2);

    void removePhant(int i2);

    void removeProofErr(int i2);

    void removeR(int i2);

    void removeRad(int i2);

    void removeSPre(int i2);

    void removeSSub(int i2);

    void removeSSubSup(int i2);

    void removeSSup(int i2);

    void removeSdt(int i2);

    void removeSmartTag(int i2);

    void setAccArray(int i2, CTAcc cTAcc);

    void setAccArray(CTAcc[] cTAccArr);

    void setBarArray(int i2, CTBar cTBar);

    void setBarArray(CTBar[] cTBarArr);

    void setBookmarkEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setBookmarkStartArray(int i2, CTBookmark cTBookmark);

    void setBookmarkStartArray(CTBookmark[] cTBookmarkArr);

    void setBorderBoxArray(int i2, CTBorderBox cTBorderBox);

    void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr);

    void setBoxArray(int i2, CTBox cTBox);

    void setBoxArray(CTBox[] cTBoxArr);

    void setCommentRangeEndArray(int i2, CTMarkupRange cTMarkupRange);

    void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCommentRangeStartArray(int i2, CTMarkupRange cTMarkupRange);

    void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr);

    void setCustomXmlArray(int i2, CTCustomXmlRun cTCustomXmlRun);

    void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr);

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

    void setDArray(int i2, CTD ctd);

    void setDArray(CTD[] ctdArr);

    void setDelArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setEqArrArray(int i2, CTEqArr cTEqArr);

    void setEqArrArray(CTEqArr[] cTEqArrArr);

    void setFArray(int i2, CTF ctf);

    void setFArray(CTF[] ctfArr);

    void setFldSimpleArray(int i2, CTSimpleField cTSimpleField);

    void setFldSimpleArray(CTSimpleField[] cTSimpleFieldArr);

    void setFuncArray(int i2, CTFunc cTFunc);

    void setFuncArray(CTFunc[] cTFuncArr);

    void setGroupChrArray(int i2, CTGroupChr cTGroupChr);

    void setGroupChrArray(CTGroupChr[] cTGroupChrArr);

    void setHyperlinkArray(int i2, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    void setInsArray(int i2, CTRunTrackChange cTRunTrackChange);

    void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr);

    void setLimLowArray(int i2, CTLimLow cTLimLow);

    void setLimLowArray(CTLimLow[] cTLimLowArr);

    void setLimUppArray(int i2, CTLimUpp cTLimUpp);

    void setLimUppArray(CTLimUpp[] cTLimUppArr);

    void setMArray(int i2, CTM ctm);

    void setMArray(CTM[] ctmArr);

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

    void setNaryArray(int i2, CTNary cTNary);

    void setNaryArray(CTNary[] cTNaryArr);

    void setOMathArray(int i2, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaArray(int i2, CTOMathPara cTOMathPara);

    void setOMathParaArray(CTOMathPara[] cTOMathParaArr);

    void setPermEndArray(int i2, CTPerm cTPerm);

    void setPermEndArray(CTPerm[] cTPermArr);

    void setPermStartArray(int i2, CTPermStart cTPermStart);

    void setPermStartArray(CTPermStart[] cTPermStartArr);

    void setPhantArray(int i2, CTPhant cTPhant);

    void setPhantArray(CTPhant[] cTPhantArr);

    void setProofErrArray(int i2, CTProofErr cTProofErr);

    void setProofErrArray(CTProofErr[] cTProofErrArr);

    void setRArray(int i2, CTR ctr);

    void setRArray(CTR[] ctrArr);

    void setRadArray(int i2, CTRad cTRad);

    void setRadArray(CTRad[] cTRadArr);

    void setSPreArray(int i2, CTSPre cTSPre);

    void setSPreArray(CTSPre[] cTSPreArr);

    void setSSubArray(int i2, CTSSub cTSSub);

    void setSSubArray(CTSSub[] cTSSubArr);

    void setSSubSupArray(int i2, CTSSubSup cTSSubSup);

    void setSSubSupArray(CTSSubSup[] cTSSubSupArr);

    void setSSupArray(int i2, CTSSup cTSSup);

    void setSSupArray(CTSSup[] cTSSupArr);

    void setSdtArray(int i2, CTSdtRun cTSdtRun);

    void setSdtArray(CTSdtRun[] cTSdtRunArr);

    void setSmartTagArray(int i2, CTSmartTagRun cTSmartTagRun);

    void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr);

    int sizeOfAccArray();

    int sizeOfBarArray();

    int sizeOfBookmarkEndArray();

    int sizeOfBookmarkStartArray();

    int sizeOfBorderBoxArray();

    int sizeOfBoxArray();

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

    int sizeOfDArray();

    int sizeOfDelArray();

    int sizeOfEqArrArray();

    int sizeOfFArray();

    int sizeOfFldSimpleArray();

    int sizeOfFuncArray();

    int sizeOfGroupChrArray();

    int sizeOfHyperlinkArray();

    int sizeOfInsArray();

    int sizeOfLimLowArray();

    int sizeOfLimUppArray();

    int sizeOfMArray();

    int sizeOfMoveFromArray();

    int sizeOfMoveFromRangeEndArray();

    int sizeOfMoveFromRangeStartArray();

    int sizeOfMoveToArray();

    int sizeOfMoveToRangeEndArray();

    int sizeOfMoveToRangeStartArray();

    int sizeOfNaryArray();

    int sizeOfOMathArray();

    int sizeOfOMathParaArray();

    int sizeOfPermEndArray();

    int sizeOfPermStartArray();

    int sizeOfPhantArray();

    int sizeOfProofErrArray();

    int sizeOfRArray();

    int sizeOfRadArray();

    int sizeOfSPreArray();

    int sizeOfSSubArray();

    int sizeOfSSubSupArray();

    int sizeOfSSupArray();

    int sizeOfSdtArray();

    int sizeOfSmartTagArray();
}
