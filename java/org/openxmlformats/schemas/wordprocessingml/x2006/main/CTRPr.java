package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTRPr extends XmlObject {
    public static final DocumentFactory<CTRPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTRPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctrpr097etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOnOff addNewB();

    CTOnOff addNewBCs();

    CTBorder addNewBdr();

    CTOnOff addNewCaps();

    CTColor addNewColor();

    CTOnOff addNewCs();

    CTOnOff addNewDstrike();

    CTEastAsianLayout addNewEastAsianLayout();

    CTTextEffect addNewEffect();

    CTEm addNewEm();

    CTOnOff addNewEmboss();

    CTFitText addNewFitText();

    CTHighlight addNewHighlight();

    CTOnOff addNewI();

    CTOnOff addNewICs();

    CTOnOff addNewImprint();

    CTHpsMeasure addNewKern();

    CTLanguage addNewLang();

    CTOnOff addNewNoProof();

    CTOnOff addNewOMath();

    CTOnOff addNewOutline();

    CTSignedHpsMeasure addNewPosition();

    CTFonts addNewRFonts();

    CTRPrChange addNewRPrChange();

    CTString addNewRStyle();

    CTOnOff addNewRtl();

    CTOnOff addNewShadow();

    CTShd addNewShd();

    CTOnOff addNewSmallCaps();

    CTOnOff addNewSnapToGrid();

    CTSignedTwipsMeasure addNewSpacing();

    CTOnOff addNewSpecVanish();

    CTOnOff addNewStrike();

    CTHpsMeasure addNewSz();

    CTHpsMeasure addNewSzCs();

    CTUnderline addNewU();

    CTOnOff addNewVanish();

    CTVerticalAlignRun addNewVertAlign();

    CTTextScale addNewW();

    CTOnOff addNewWebHidden();

    CTOnOff getBArray(int i2);

    CTOnOff[] getBArray();

    CTOnOff getBCsArray(int i2);

    CTOnOff[] getBCsArray();

    List<CTOnOff> getBCsList();

    List<CTOnOff> getBList();

    CTBorder getBdrArray(int i2);

    CTBorder[] getBdrArray();

    List<CTBorder> getBdrList();

    CTOnOff getCapsArray(int i2);

    CTOnOff[] getCapsArray();

    List<CTOnOff> getCapsList();

    CTColor getColorArray(int i2);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTOnOff getCsArray(int i2);

    CTOnOff[] getCsArray();

    List<CTOnOff> getCsList();

    CTOnOff getDstrikeArray(int i2);

    CTOnOff[] getDstrikeArray();

    List<CTOnOff> getDstrikeList();

    CTEastAsianLayout getEastAsianLayoutArray(int i2);

    CTEastAsianLayout[] getEastAsianLayoutArray();

    List<CTEastAsianLayout> getEastAsianLayoutList();

    CTTextEffect getEffectArray(int i2);

    CTTextEffect[] getEffectArray();

    List<CTTextEffect> getEffectList();

    CTEm getEmArray(int i2);

    CTEm[] getEmArray();

    List<CTEm> getEmList();

    CTOnOff getEmbossArray(int i2);

    CTOnOff[] getEmbossArray();

    List<CTOnOff> getEmbossList();

    CTFitText getFitTextArray(int i2);

    CTFitText[] getFitTextArray();

    List<CTFitText> getFitTextList();

    CTHighlight getHighlightArray(int i2);

    CTHighlight[] getHighlightArray();

    List<CTHighlight> getHighlightList();

    CTOnOff getIArray(int i2);

    CTOnOff[] getIArray();

    CTOnOff getICsArray(int i2);

    CTOnOff[] getICsArray();

    List<CTOnOff> getICsList();

    List<CTOnOff> getIList();

    CTOnOff getImprintArray(int i2);

    CTOnOff[] getImprintArray();

    List<CTOnOff> getImprintList();

    CTHpsMeasure getKernArray(int i2);

    CTHpsMeasure[] getKernArray();

    List<CTHpsMeasure> getKernList();

    CTLanguage getLangArray(int i2);

    CTLanguage[] getLangArray();

    List<CTLanguage> getLangList();

    CTOnOff getNoProofArray(int i2);

    CTOnOff[] getNoProofArray();

    List<CTOnOff> getNoProofList();

    CTOnOff getOMathArray(int i2);

    CTOnOff[] getOMathArray();

    List<CTOnOff> getOMathList();

    CTOnOff getOutlineArray(int i2);

    CTOnOff[] getOutlineArray();

    List<CTOnOff> getOutlineList();

    CTSignedHpsMeasure getPositionArray(int i2);

    CTSignedHpsMeasure[] getPositionArray();

    List<CTSignedHpsMeasure> getPositionList();

    CTFonts getRFontsArray(int i2);

    CTFonts[] getRFontsArray();

    List<CTFonts> getRFontsList();

    CTRPrChange getRPrChange();

    CTString getRStyleArray(int i2);

    CTString[] getRStyleArray();

    List<CTString> getRStyleList();

    CTOnOff getRtlArray(int i2);

    CTOnOff[] getRtlArray();

    List<CTOnOff> getRtlList();

    CTOnOff getShadowArray(int i2);

    CTOnOff[] getShadowArray();

    List<CTOnOff> getShadowList();

    CTShd getShdArray(int i2);

    CTShd[] getShdArray();

    List<CTShd> getShdList();

    CTOnOff getSmallCapsArray(int i2);

    CTOnOff[] getSmallCapsArray();

    List<CTOnOff> getSmallCapsList();

    CTOnOff getSnapToGridArray(int i2);

    CTOnOff[] getSnapToGridArray();

    List<CTOnOff> getSnapToGridList();

    CTSignedTwipsMeasure getSpacingArray(int i2);

    CTSignedTwipsMeasure[] getSpacingArray();

    List<CTSignedTwipsMeasure> getSpacingList();

    CTOnOff getSpecVanishArray(int i2);

    CTOnOff[] getSpecVanishArray();

    List<CTOnOff> getSpecVanishList();

    CTOnOff getStrikeArray(int i2);

    CTOnOff[] getStrikeArray();

    List<CTOnOff> getStrikeList();

    CTHpsMeasure getSzArray(int i2);

    CTHpsMeasure[] getSzArray();

    CTHpsMeasure getSzCsArray(int i2);

    CTHpsMeasure[] getSzCsArray();

    List<CTHpsMeasure> getSzCsList();

    List<CTHpsMeasure> getSzList();

    CTUnderline getUArray(int i2);

    CTUnderline[] getUArray();

    List<CTUnderline> getUList();

    CTOnOff getVanishArray(int i2);

    CTOnOff[] getVanishArray();

    List<CTOnOff> getVanishList();

    CTVerticalAlignRun getVertAlignArray(int i2);

    CTVerticalAlignRun[] getVertAlignArray();

    List<CTVerticalAlignRun> getVertAlignList();

    CTTextScale getWArray(int i2);

    CTTextScale[] getWArray();

    List<CTTextScale> getWList();

    CTOnOff getWebHiddenArray(int i2);

    CTOnOff[] getWebHiddenArray();

    List<CTOnOff> getWebHiddenList();

    CTOnOff insertNewB(int i2);

    CTOnOff insertNewBCs(int i2);

    CTBorder insertNewBdr(int i2);

    CTOnOff insertNewCaps(int i2);

    CTColor insertNewColor(int i2);

    CTOnOff insertNewCs(int i2);

    CTOnOff insertNewDstrike(int i2);

    CTEastAsianLayout insertNewEastAsianLayout(int i2);

    CTTextEffect insertNewEffect(int i2);

    CTEm insertNewEm(int i2);

    CTOnOff insertNewEmboss(int i2);

    CTFitText insertNewFitText(int i2);

    CTHighlight insertNewHighlight(int i2);

    CTOnOff insertNewI(int i2);

    CTOnOff insertNewICs(int i2);

    CTOnOff insertNewImprint(int i2);

    CTHpsMeasure insertNewKern(int i2);

    CTLanguage insertNewLang(int i2);

    CTOnOff insertNewNoProof(int i2);

    CTOnOff insertNewOMath(int i2);

    CTOnOff insertNewOutline(int i2);

    CTSignedHpsMeasure insertNewPosition(int i2);

    CTFonts insertNewRFonts(int i2);

    CTString insertNewRStyle(int i2);

    CTOnOff insertNewRtl(int i2);

    CTOnOff insertNewShadow(int i2);

    CTShd insertNewShd(int i2);

    CTOnOff insertNewSmallCaps(int i2);

    CTOnOff insertNewSnapToGrid(int i2);

    CTSignedTwipsMeasure insertNewSpacing(int i2);

    CTOnOff insertNewSpecVanish(int i2);

    CTOnOff insertNewStrike(int i2);

    CTHpsMeasure insertNewSz(int i2);

    CTHpsMeasure insertNewSzCs(int i2);

    CTUnderline insertNewU(int i2);

    CTOnOff insertNewVanish(int i2);

    CTVerticalAlignRun insertNewVertAlign(int i2);

    CTTextScale insertNewW(int i2);

    CTOnOff insertNewWebHidden(int i2);

    boolean isSetRPrChange();

    void removeB(int i2);

    void removeBCs(int i2);

    void removeBdr(int i2);

    void removeCaps(int i2);

    void removeColor(int i2);

    void removeCs(int i2);

    void removeDstrike(int i2);

    void removeEastAsianLayout(int i2);

    void removeEffect(int i2);

    void removeEm(int i2);

    void removeEmboss(int i2);

    void removeFitText(int i2);

    void removeHighlight(int i2);

    void removeI(int i2);

    void removeICs(int i2);

    void removeImprint(int i2);

    void removeKern(int i2);

    void removeLang(int i2);

    void removeNoProof(int i2);

    void removeOMath(int i2);

    void removeOutline(int i2);

    void removePosition(int i2);

    void removeRFonts(int i2);

    void removeRStyle(int i2);

    void removeRtl(int i2);

    void removeShadow(int i2);

    void removeShd(int i2);

    void removeSmallCaps(int i2);

    void removeSnapToGrid(int i2);

    void removeSpacing(int i2);

    void removeSpecVanish(int i2);

    void removeStrike(int i2);

    void removeSz(int i2);

    void removeSzCs(int i2);

    void removeU(int i2);

    void removeVanish(int i2);

    void removeVertAlign(int i2);

    void removeW(int i2);

    void removeWebHidden(int i2);

    void setBArray(int i2, CTOnOff cTOnOff);

    void setBArray(CTOnOff[] cTOnOffArr);

    void setBCsArray(int i2, CTOnOff cTOnOff);

    void setBCsArray(CTOnOff[] cTOnOffArr);

    void setBdrArray(int i2, CTBorder cTBorder);

    void setBdrArray(CTBorder[] cTBorderArr);

    void setCapsArray(int i2, CTOnOff cTOnOff);

    void setCapsArray(CTOnOff[] cTOnOffArr);

    void setColorArray(int i2, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    void setCsArray(int i2, CTOnOff cTOnOff);

    void setCsArray(CTOnOff[] cTOnOffArr);

    void setDstrikeArray(int i2, CTOnOff cTOnOff);

    void setDstrikeArray(CTOnOff[] cTOnOffArr);

    void setEastAsianLayoutArray(int i2, CTEastAsianLayout cTEastAsianLayout);

    void setEastAsianLayoutArray(CTEastAsianLayout[] cTEastAsianLayoutArr);

    void setEffectArray(int i2, CTTextEffect cTTextEffect);

    void setEffectArray(CTTextEffect[] cTTextEffectArr);

    void setEmArray(int i2, CTEm cTEm);

    void setEmArray(CTEm[] cTEmArr);

    void setEmbossArray(int i2, CTOnOff cTOnOff);

    void setEmbossArray(CTOnOff[] cTOnOffArr);

    void setFitTextArray(int i2, CTFitText cTFitText);

    void setFitTextArray(CTFitText[] cTFitTextArr);

    void setHighlightArray(int i2, CTHighlight cTHighlight);

    void setHighlightArray(CTHighlight[] cTHighlightArr);

    void setIArray(int i2, CTOnOff cTOnOff);

    void setIArray(CTOnOff[] cTOnOffArr);

    void setICsArray(int i2, CTOnOff cTOnOff);

    void setICsArray(CTOnOff[] cTOnOffArr);

    void setImprintArray(int i2, CTOnOff cTOnOff);

    void setImprintArray(CTOnOff[] cTOnOffArr);

    void setKernArray(int i2, CTHpsMeasure cTHpsMeasure);

    void setKernArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setLangArray(int i2, CTLanguage cTLanguage);

    void setLangArray(CTLanguage[] cTLanguageArr);

    void setNoProofArray(int i2, CTOnOff cTOnOff);

    void setNoProofArray(CTOnOff[] cTOnOffArr);

    void setOMathArray(int i2, CTOnOff cTOnOff);

    void setOMathArray(CTOnOff[] cTOnOffArr);

    void setOutlineArray(int i2, CTOnOff cTOnOff);

    void setOutlineArray(CTOnOff[] cTOnOffArr);

    void setPositionArray(int i2, CTSignedHpsMeasure cTSignedHpsMeasure);

    void setPositionArray(CTSignedHpsMeasure[] cTSignedHpsMeasureArr);

    void setRFontsArray(int i2, CTFonts cTFonts);

    void setRFontsArray(CTFonts[] cTFontsArr);

    void setRPrChange(CTRPrChange cTRPrChange);

    void setRStyleArray(int i2, CTString cTString);

    void setRStyleArray(CTString[] cTStringArr);

    void setRtlArray(int i2, CTOnOff cTOnOff);

    void setRtlArray(CTOnOff[] cTOnOffArr);

    void setShadowArray(int i2, CTOnOff cTOnOff);

    void setShadowArray(CTOnOff[] cTOnOffArr);

    void setShdArray(int i2, CTShd cTShd);

    void setShdArray(CTShd[] cTShdArr);

    void setSmallCapsArray(int i2, CTOnOff cTOnOff);

    void setSmallCapsArray(CTOnOff[] cTOnOffArr);

    void setSnapToGridArray(int i2, CTOnOff cTOnOff);

    void setSnapToGridArray(CTOnOff[] cTOnOffArr);

    void setSpacingArray(int i2, CTSignedTwipsMeasure cTSignedTwipsMeasure);

    void setSpacingArray(CTSignedTwipsMeasure[] cTSignedTwipsMeasureArr);

    void setSpecVanishArray(int i2, CTOnOff cTOnOff);

    void setSpecVanishArray(CTOnOff[] cTOnOffArr);

    void setStrikeArray(int i2, CTOnOff cTOnOff);

    void setStrikeArray(CTOnOff[] cTOnOffArr);

    void setSzArray(int i2, CTHpsMeasure cTHpsMeasure);

    void setSzArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setSzCsArray(int i2, CTHpsMeasure cTHpsMeasure);

    void setSzCsArray(CTHpsMeasure[] cTHpsMeasureArr);

    void setUArray(int i2, CTUnderline cTUnderline);

    void setUArray(CTUnderline[] cTUnderlineArr);

    void setVanishArray(int i2, CTOnOff cTOnOff);

    void setVanishArray(CTOnOff[] cTOnOffArr);

    void setVertAlignArray(int i2, CTVerticalAlignRun cTVerticalAlignRun);

    void setVertAlignArray(CTVerticalAlignRun[] cTVerticalAlignRunArr);

    void setWArray(int i2, CTTextScale cTTextScale);

    void setWArray(CTTextScale[] cTTextScaleArr);

    void setWebHiddenArray(int i2, CTOnOff cTOnOff);

    void setWebHiddenArray(CTOnOff[] cTOnOffArr);

    int sizeOfBArray();

    int sizeOfBCsArray();

    int sizeOfBdrArray();

    int sizeOfCapsArray();

    int sizeOfColorArray();

    int sizeOfCsArray();

    int sizeOfDstrikeArray();

    int sizeOfEastAsianLayoutArray();

    int sizeOfEffectArray();

    int sizeOfEmArray();

    int sizeOfEmbossArray();

    int sizeOfFitTextArray();

    int sizeOfHighlightArray();

    int sizeOfIArray();

    int sizeOfICsArray();

    int sizeOfImprintArray();

    int sizeOfKernArray();

    int sizeOfLangArray();

    int sizeOfNoProofArray();

    int sizeOfOMathArray();

    int sizeOfOutlineArray();

    int sizeOfPositionArray();

    int sizeOfRFontsArray();

    int sizeOfRStyleArray();

    int sizeOfRtlArray();

    int sizeOfShadowArray();

    int sizeOfShdArray();

    int sizeOfSmallCapsArray();

    int sizeOfSnapToGridArray();

    int sizeOfSpacingArray();

    int sizeOfSpecVanishArray();

    int sizeOfStrikeArray();

    int sizeOfSzArray();

    int sizeOfSzCsArray();

    int sizeOfUArray();

    int sizeOfVanishArray();

    int sizeOfVertAlignArray();

    int sizeOfWArray();

    int sizeOfWebHiddenArray();

    void unsetRPrChange();
}
