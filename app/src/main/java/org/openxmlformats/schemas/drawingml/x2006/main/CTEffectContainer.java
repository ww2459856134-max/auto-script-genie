package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTEffectContainer extends XmlObject {
    public static final DocumentFactory<CTEffectContainer> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEffectContainer> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cteffectcontainer2e21type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAlphaBiLevelEffect addNewAlphaBiLevel();

    CTAlphaCeilingEffect addNewAlphaCeiling();

    CTAlphaFloorEffect addNewAlphaFloor();

    CTAlphaInverseEffect addNewAlphaInv();

    CTAlphaModulateEffect addNewAlphaMod();

    CTAlphaModulateFixedEffect addNewAlphaModFix();

    CTAlphaOutsetEffect addNewAlphaOutset();

    CTAlphaReplaceEffect addNewAlphaRepl();

    CTBiLevelEffect addNewBiLevel();

    CTBlendEffect addNewBlend();

    CTBlurEffect addNewBlur();

    CTColorChangeEffect addNewClrChange();

    CTColorReplaceEffect addNewClrRepl();

    CTEffectContainer addNewCont();

    CTDuotoneEffect addNewDuotone();

    CTEffectReference addNewEffect();

    CTFillEffect addNewFill();

    CTFillOverlayEffect addNewFillOverlay();

    CTGlowEffect addNewGlow();

    CTGrayscaleEffect addNewGrayscl();

    CTHSLEffect addNewHsl();

    CTInnerShadowEffect addNewInnerShdw();

    CTLuminanceEffect addNewLum();

    CTOuterShadowEffect addNewOuterShdw();

    CTPresetShadowEffect addNewPrstShdw();

    CTReflectionEffect addNewReflection();

    CTRelativeOffsetEffect addNewRelOff();

    CTSoftEdgesEffect addNewSoftEdge();

    CTTintEffect addNewTint();

    CTTransformEffect addNewXfrm();

    CTAlphaBiLevelEffect getAlphaBiLevelArray(int i2);

    CTAlphaBiLevelEffect[] getAlphaBiLevelArray();

    List<CTAlphaBiLevelEffect> getAlphaBiLevelList();

    CTAlphaCeilingEffect getAlphaCeilingArray(int i2);

    CTAlphaCeilingEffect[] getAlphaCeilingArray();

    List<CTAlphaCeilingEffect> getAlphaCeilingList();

    CTAlphaFloorEffect getAlphaFloorArray(int i2);

    CTAlphaFloorEffect[] getAlphaFloorArray();

    List<CTAlphaFloorEffect> getAlphaFloorList();

    CTAlphaInverseEffect getAlphaInvArray(int i2);

    CTAlphaInverseEffect[] getAlphaInvArray();

    List<CTAlphaInverseEffect> getAlphaInvList();

    CTAlphaModulateEffect getAlphaModArray(int i2);

    CTAlphaModulateEffect[] getAlphaModArray();

    CTAlphaModulateFixedEffect getAlphaModFixArray(int i2);

    CTAlphaModulateFixedEffect[] getAlphaModFixArray();

    List<CTAlphaModulateFixedEffect> getAlphaModFixList();

    List<CTAlphaModulateEffect> getAlphaModList();

    CTAlphaOutsetEffect getAlphaOutsetArray(int i2);

    CTAlphaOutsetEffect[] getAlphaOutsetArray();

    List<CTAlphaOutsetEffect> getAlphaOutsetList();

    CTAlphaReplaceEffect getAlphaReplArray(int i2);

    CTAlphaReplaceEffect[] getAlphaReplArray();

    List<CTAlphaReplaceEffect> getAlphaReplList();

    CTBiLevelEffect getBiLevelArray(int i2);

    CTBiLevelEffect[] getBiLevelArray();

    List<CTBiLevelEffect> getBiLevelList();

    CTBlendEffect getBlendArray(int i2);

    CTBlendEffect[] getBlendArray();

    List<CTBlendEffect> getBlendList();

    CTBlurEffect getBlurArray(int i2);

    CTBlurEffect[] getBlurArray();

    List<CTBlurEffect> getBlurList();

    CTColorChangeEffect getClrChangeArray(int i2);

    CTColorChangeEffect[] getClrChangeArray();

    List<CTColorChangeEffect> getClrChangeList();

    CTColorReplaceEffect getClrReplArray(int i2);

    CTColorReplaceEffect[] getClrReplArray();

    List<CTColorReplaceEffect> getClrReplList();

    CTEffectContainer getContArray(int i2);

    CTEffectContainer[] getContArray();

    List<CTEffectContainer> getContList();

    CTDuotoneEffect getDuotoneArray(int i2);

    CTDuotoneEffect[] getDuotoneArray();

    List<CTDuotoneEffect> getDuotoneList();

    CTEffectReference getEffectArray(int i2);

    CTEffectReference[] getEffectArray();

    List<CTEffectReference> getEffectList();

    CTFillEffect getFillArray(int i2);

    CTFillEffect[] getFillArray();

    List<CTFillEffect> getFillList();

    CTFillOverlayEffect getFillOverlayArray(int i2);

    CTFillOverlayEffect[] getFillOverlayArray();

    List<CTFillOverlayEffect> getFillOverlayList();

    CTGlowEffect getGlowArray(int i2);

    CTGlowEffect[] getGlowArray();

    List<CTGlowEffect> getGlowList();

    CTGrayscaleEffect getGraysclArray(int i2);

    CTGrayscaleEffect[] getGraysclArray();

    List<CTGrayscaleEffect> getGraysclList();

    CTHSLEffect getHslArray(int i2);

    CTHSLEffect[] getHslArray();

    List<CTHSLEffect> getHslList();

    CTInnerShadowEffect getInnerShdwArray(int i2);

    CTInnerShadowEffect[] getInnerShdwArray();

    List<CTInnerShadowEffect> getInnerShdwList();

    CTLuminanceEffect getLumArray(int i2);

    CTLuminanceEffect[] getLumArray();

    List<CTLuminanceEffect> getLumList();

    String getName();

    CTOuterShadowEffect getOuterShdwArray(int i2);

    CTOuterShadowEffect[] getOuterShdwArray();

    List<CTOuterShadowEffect> getOuterShdwList();

    CTPresetShadowEffect getPrstShdwArray(int i2);

    CTPresetShadowEffect[] getPrstShdwArray();

    List<CTPresetShadowEffect> getPrstShdwList();

    CTReflectionEffect getReflectionArray(int i2);

    CTReflectionEffect[] getReflectionArray();

    List<CTReflectionEffect> getReflectionList();

    CTRelativeOffsetEffect getRelOffArray(int i2);

    CTRelativeOffsetEffect[] getRelOffArray();

    List<CTRelativeOffsetEffect> getRelOffList();

    CTSoftEdgesEffect getSoftEdgeArray(int i2);

    CTSoftEdgesEffect[] getSoftEdgeArray();

    List<CTSoftEdgesEffect> getSoftEdgeList();

    CTTintEffect getTintArray(int i2);

    CTTintEffect[] getTintArray();

    List<CTTintEffect> getTintList();

    STEffectContainerType$Enum getType();

    CTTransformEffect getXfrmArray(int i2);

    CTTransformEffect[] getXfrmArray();

    List<CTTransformEffect> getXfrmList();

    CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i2);

    CTAlphaCeilingEffect insertNewAlphaCeiling(int i2);

    CTAlphaFloorEffect insertNewAlphaFloor(int i2);

    CTAlphaInverseEffect insertNewAlphaInv(int i2);

    CTAlphaModulateEffect insertNewAlphaMod(int i2);

    CTAlphaModulateFixedEffect insertNewAlphaModFix(int i2);

    CTAlphaOutsetEffect insertNewAlphaOutset(int i2);

    CTAlphaReplaceEffect insertNewAlphaRepl(int i2);

    CTBiLevelEffect insertNewBiLevel(int i2);

    CTBlendEffect insertNewBlend(int i2);

    CTBlurEffect insertNewBlur(int i2);

    CTColorChangeEffect insertNewClrChange(int i2);

    CTColorReplaceEffect insertNewClrRepl(int i2);

    CTEffectContainer insertNewCont(int i2);

    CTDuotoneEffect insertNewDuotone(int i2);

    CTEffectReference insertNewEffect(int i2);

    CTFillEffect insertNewFill(int i2);

    CTFillOverlayEffect insertNewFillOverlay(int i2);

    CTGlowEffect insertNewGlow(int i2);

    CTGrayscaleEffect insertNewGrayscl(int i2);

    CTHSLEffect insertNewHsl(int i2);

    CTInnerShadowEffect insertNewInnerShdw(int i2);

    CTLuminanceEffect insertNewLum(int i2);

    CTOuterShadowEffect insertNewOuterShdw(int i2);

    CTPresetShadowEffect insertNewPrstShdw(int i2);

    CTReflectionEffect insertNewReflection(int i2);

    CTRelativeOffsetEffect insertNewRelOff(int i2);

    CTSoftEdgesEffect insertNewSoftEdge(int i2);

    CTTintEffect insertNewTint(int i2);

    CTTransformEffect insertNewXfrm(int i2);

    boolean isSetName();

    boolean isSetType();

    void removeAlphaBiLevel(int i2);

    void removeAlphaCeiling(int i2);

    void removeAlphaFloor(int i2);

    void removeAlphaInv(int i2);

    void removeAlphaMod(int i2);

    void removeAlphaModFix(int i2);

    void removeAlphaOutset(int i2);

    void removeAlphaRepl(int i2);

    void removeBiLevel(int i2);

    void removeBlend(int i2);

    void removeBlur(int i2);

    void removeClrChange(int i2);

    void removeClrRepl(int i2);

    void removeCont(int i2);

    void removeDuotone(int i2);

    void removeEffect(int i2);

    void removeFill(int i2);

    void removeFillOverlay(int i2);

    void removeGlow(int i2);

    void removeGrayscl(int i2);

    void removeHsl(int i2);

    void removeInnerShdw(int i2);

    void removeLum(int i2);

    void removeOuterShdw(int i2);

    void removePrstShdw(int i2);

    void removeReflection(int i2);

    void removeRelOff(int i2);

    void removeSoftEdge(int i2);

    void removeTint(int i2);

    void removeXfrm(int i2);

    void setAlphaBiLevelArray(int i2, CTAlphaBiLevelEffect cTAlphaBiLevelEffect);

    void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr);

    void setAlphaCeilingArray(int i2, CTAlphaCeilingEffect cTAlphaCeilingEffect);

    void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr);

    void setAlphaFloorArray(int i2, CTAlphaFloorEffect cTAlphaFloorEffect);

    void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr);

    void setAlphaInvArray(int i2, CTAlphaInverseEffect cTAlphaInverseEffect);

    void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr);

    void setAlphaModArray(int i2, CTAlphaModulateEffect cTAlphaModulateEffect);

    void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr);

    void setAlphaModFixArray(int i2, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect);

    void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr);

    void setAlphaOutsetArray(int i2, CTAlphaOutsetEffect cTAlphaOutsetEffect);

    void setAlphaOutsetArray(CTAlphaOutsetEffect[] cTAlphaOutsetEffectArr);

    void setAlphaReplArray(int i2, CTAlphaReplaceEffect cTAlphaReplaceEffect);

    void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr);

    void setBiLevelArray(int i2, CTBiLevelEffect cTBiLevelEffect);

    void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr);

    void setBlendArray(int i2, CTBlendEffect cTBlendEffect);

    void setBlendArray(CTBlendEffect[] cTBlendEffectArr);

    void setBlurArray(int i2, CTBlurEffect cTBlurEffect);

    void setBlurArray(CTBlurEffect[] cTBlurEffectArr);

    void setClrChangeArray(int i2, CTColorChangeEffect cTColorChangeEffect);

    void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr);

    void setClrReplArray(int i2, CTColorReplaceEffect cTColorReplaceEffect);

    void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr);

    void setContArray(int i2, CTEffectContainer cTEffectContainer);

    void setContArray(CTEffectContainer[] cTEffectContainerArr);

    void setDuotoneArray(int i2, CTDuotoneEffect cTDuotoneEffect);

    void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr);

    void setEffectArray(int i2, CTEffectReference cTEffectReference);

    void setEffectArray(CTEffectReference[] cTEffectReferenceArr);

    void setFillArray(int i2, CTFillEffect cTFillEffect);

    void setFillArray(CTFillEffect[] cTFillEffectArr);

    void setFillOverlayArray(int i2, CTFillOverlayEffect cTFillOverlayEffect);

    void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr);

    void setGlowArray(int i2, CTGlowEffect cTGlowEffect);

    void setGlowArray(CTGlowEffect[] cTGlowEffectArr);

    void setGraysclArray(int i2, CTGrayscaleEffect cTGrayscaleEffect);

    void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr);

    void setHslArray(int i2, CTHSLEffect cTHSLEffect);

    void setHslArray(CTHSLEffect[] cTHSLEffectArr);

    void setInnerShdwArray(int i2, CTInnerShadowEffect cTInnerShadowEffect);

    void setInnerShdwArray(CTInnerShadowEffect[] cTInnerShadowEffectArr);

    void setLumArray(int i2, CTLuminanceEffect cTLuminanceEffect);

    void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr);

    void setName(String str);

    void setOuterShdwArray(int i2, CTOuterShadowEffect cTOuterShadowEffect);

    void setOuterShdwArray(CTOuterShadowEffect[] cTOuterShadowEffectArr);

    void setPrstShdwArray(int i2, CTPresetShadowEffect cTPresetShadowEffect);

    void setPrstShdwArray(CTPresetShadowEffect[] cTPresetShadowEffectArr);

    void setReflectionArray(int i2, CTReflectionEffect cTReflectionEffect);

    void setReflectionArray(CTReflectionEffect[] cTReflectionEffectArr);

    void setRelOffArray(int i2, CTRelativeOffsetEffect cTRelativeOffsetEffect);

    void setRelOffArray(CTRelativeOffsetEffect[] cTRelativeOffsetEffectArr);

    void setSoftEdgeArray(int i2, CTSoftEdgesEffect cTSoftEdgesEffect);

    void setSoftEdgeArray(CTSoftEdgesEffect[] cTSoftEdgesEffectArr);

    void setTintArray(int i2, CTTintEffect cTTintEffect);

    void setTintArray(CTTintEffect[] cTTintEffectArr);

    void setType(STEffectContainerType$Enum sTEffectContainerType$Enum);

    void setXfrmArray(int i2, CTTransformEffect cTTransformEffect);

    void setXfrmArray(CTTransformEffect[] cTTransformEffectArr);

    int sizeOfAlphaBiLevelArray();

    int sizeOfAlphaCeilingArray();

    int sizeOfAlphaFloorArray();

    int sizeOfAlphaInvArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaModFixArray();

    int sizeOfAlphaOutsetArray();

    int sizeOfAlphaReplArray();

    int sizeOfBiLevelArray();

    int sizeOfBlendArray();

    int sizeOfBlurArray();

    int sizeOfClrChangeArray();

    int sizeOfClrReplArray();

    int sizeOfContArray();

    int sizeOfDuotoneArray();

    int sizeOfEffectArray();

    int sizeOfFillArray();

    int sizeOfFillOverlayArray();

    int sizeOfGlowArray();

    int sizeOfGraysclArray();

    int sizeOfHslArray();

    int sizeOfInnerShdwArray();

    int sizeOfLumArray();

    int sizeOfOuterShdwArray();

    int sizeOfPrstShdwArray();

    int sizeOfReflectionArray();

    int sizeOfRelOffArray();

    int sizeOfSoftEdgeArray();

    int sizeOfTintArray();

    int sizeOfXfrmArray();

    void unsetName();

    void unsetType();

    XmlToken xgetName();

    STEffectContainerType xgetType();

    void xsetName(XmlToken xmlToken);

    void xsetType(STEffectContainerType sTEffectContainerType);
}
