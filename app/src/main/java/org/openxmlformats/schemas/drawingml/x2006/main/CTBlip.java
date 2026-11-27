package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlipCompression;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* loaded from: classes2.dex */
public interface CTBlip extends XmlObject {
    public static final DocumentFactory<CTBlip> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBlip> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctblip034ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAlphaBiLevelEffect addNewAlphaBiLevel();

    CTAlphaCeilingEffect addNewAlphaCeiling();

    CTAlphaFloorEffect addNewAlphaFloor();

    CTAlphaInverseEffect addNewAlphaInv();

    CTAlphaModulateEffect addNewAlphaMod();

    CTAlphaModulateFixedEffect addNewAlphaModFix();

    CTAlphaReplaceEffect addNewAlphaRepl();

    CTBiLevelEffect addNewBiLevel();

    CTBlurEffect addNewBlur();

    CTColorChangeEffect addNewClrChange();

    CTColorReplaceEffect addNewClrRepl();

    CTDuotoneEffect addNewDuotone();

    CTOfficeArtExtensionList addNewExtLst();

    CTFillOverlayEffect addNewFillOverlay();

    CTGrayscaleEffect addNewGrayscl();

    CTHSLEffect addNewHsl();

    CTLuminanceEffect addNewLum();

    CTTintEffect addNewTint();

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

    CTAlphaReplaceEffect getAlphaReplArray(int i2);

    CTAlphaReplaceEffect[] getAlphaReplArray();

    List<CTAlphaReplaceEffect> getAlphaReplList();

    CTBiLevelEffect getBiLevelArray(int i2);

    CTBiLevelEffect[] getBiLevelArray();

    List<CTBiLevelEffect> getBiLevelList();

    CTBlurEffect getBlurArray(int i2);

    CTBlurEffect[] getBlurArray();

    List<CTBlurEffect> getBlurList();

    CTColorChangeEffect getClrChangeArray(int i2);

    CTColorChangeEffect[] getClrChangeArray();

    List<CTColorChangeEffect> getClrChangeList();

    CTColorReplaceEffect getClrReplArray(int i2);

    CTColorReplaceEffect[] getClrReplArray();

    List<CTColorReplaceEffect> getClrReplList();

    STBlipCompression.Enum getCstate();

    CTDuotoneEffect getDuotoneArray(int i2);

    CTDuotoneEffect[] getDuotoneArray();

    List<CTDuotoneEffect> getDuotoneList();

    String getEmbed();

    CTOfficeArtExtensionList getExtLst();

    CTFillOverlayEffect getFillOverlayArray(int i2);

    CTFillOverlayEffect[] getFillOverlayArray();

    List<CTFillOverlayEffect> getFillOverlayList();

    CTGrayscaleEffect getGraysclArray(int i2);

    CTGrayscaleEffect[] getGraysclArray();

    List<CTGrayscaleEffect> getGraysclList();

    CTHSLEffect getHslArray(int i2);

    CTHSLEffect[] getHslArray();

    List<CTHSLEffect> getHslList();

    String getLink();

    CTLuminanceEffect getLumArray(int i2);

    CTLuminanceEffect[] getLumArray();

    List<CTLuminanceEffect> getLumList();

    CTTintEffect getTintArray(int i2);

    CTTintEffect[] getTintArray();

    List<CTTintEffect> getTintList();

    CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i2);

    CTAlphaCeilingEffect insertNewAlphaCeiling(int i2);

    CTAlphaFloorEffect insertNewAlphaFloor(int i2);

    CTAlphaInverseEffect insertNewAlphaInv(int i2);

    CTAlphaModulateEffect insertNewAlphaMod(int i2);

    CTAlphaModulateFixedEffect insertNewAlphaModFix(int i2);

    CTAlphaReplaceEffect insertNewAlphaRepl(int i2);

    CTBiLevelEffect insertNewBiLevel(int i2);

    CTBlurEffect insertNewBlur(int i2);

    CTColorChangeEffect insertNewClrChange(int i2);

    CTColorReplaceEffect insertNewClrRepl(int i2);

    CTDuotoneEffect insertNewDuotone(int i2);

    CTFillOverlayEffect insertNewFillOverlay(int i2);

    CTGrayscaleEffect insertNewGrayscl(int i2);

    CTHSLEffect insertNewHsl(int i2);

    CTLuminanceEffect insertNewLum(int i2);

    CTTintEffect insertNewTint(int i2);

    boolean isSetCstate();

    boolean isSetEmbed();

    boolean isSetExtLst();

    boolean isSetLink();

    void removeAlphaBiLevel(int i2);

    void removeAlphaCeiling(int i2);

    void removeAlphaFloor(int i2);

    void removeAlphaInv(int i2);

    void removeAlphaMod(int i2);

    void removeAlphaModFix(int i2);

    void removeAlphaRepl(int i2);

    void removeBiLevel(int i2);

    void removeBlur(int i2);

    void removeClrChange(int i2);

    void removeClrRepl(int i2);

    void removeDuotone(int i2);

    void removeFillOverlay(int i2);

    void removeGrayscl(int i2);

    void removeHsl(int i2);

    void removeLum(int i2);

    void removeTint(int i2);

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

    void setAlphaReplArray(int i2, CTAlphaReplaceEffect cTAlphaReplaceEffect);

    void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr);

    void setBiLevelArray(int i2, CTBiLevelEffect cTBiLevelEffect);

    void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr);

    void setBlurArray(int i2, CTBlurEffect cTBlurEffect);

    void setBlurArray(CTBlurEffect[] cTBlurEffectArr);

    void setClrChangeArray(int i2, CTColorChangeEffect cTColorChangeEffect);

    void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr);

    void setClrReplArray(int i2, CTColorReplaceEffect cTColorReplaceEffect);

    void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr);

    void setCstate(STBlipCompression.Enum r1);

    void setDuotoneArray(int i2, CTDuotoneEffect cTDuotoneEffect);

    void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr);

    void setEmbed(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFillOverlayArray(int i2, CTFillOverlayEffect cTFillOverlayEffect);

    void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr);

    void setGraysclArray(int i2, CTGrayscaleEffect cTGrayscaleEffect);

    void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr);

    void setHslArray(int i2, CTHSLEffect cTHSLEffect);

    void setHslArray(CTHSLEffect[] cTHSLEffectArr);

    void setLink(String str);

    void setLumArray(int i2, CTLuminanceEffect cTLuminanceEffect);

    void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr);

    void setTintArray(int i2, CTTintEffect cTTintEffect);

    void setTintArray(CTTintEffect[] cTTintEffectArr);

    int sizeOfAlphaBiLevelArray();

    int sizeOfAlphaCeilingArray();

    int sizeOfAlphaFloorArray();

    int sizeOfAlphaInvArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaModFixArray();

    int sizeOfAlphaReplArray();

    int sizeOfBiLevelArray();

    int sizeOfBlurArray();

    int sizeOfClrChangeArray();

    int sizeOfClrReplArray();

    int sizeOfDuotoneArray();

    int sizeOfFillOverlayArray();

    int sizeOfGraysclArray();

    int sizeOfHslArray();

    int sizeOfLumArray();

    int sizeOfTintArray();

    void unsetCstate();

    void unsetEmbed();

    void unsetExtLst();

    void unsetLink();

    STBlipCompression xgetCstate();

    STRelationshipId xgetEmbed();

    STRelationshipId xgetLink();

    void xsetCstate(STBlipCompression sTBlipCompression);

    void xsetEmbed(STRelationshipId sTRelationshipId);

    void xsetLink(STRelationshipId sTRelationshipId);
}
