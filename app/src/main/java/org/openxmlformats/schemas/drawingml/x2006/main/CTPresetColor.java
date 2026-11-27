package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetColorVal;

/* loaded from: classes2.dex */
public interface CTPresetColor extends XmlObject {
    public static final DocumentFactory<CTPresetColor> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPresetColor> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpresetcolora675type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPositiveFixedPercentage addNewAlpha();

    CTPositivePercentage addNewAlphaMod();

    CTFixedPercentage addNewAlphaOff();

    CTPercentage addNewBlue();

    CTPercentage addNewBlueMod();

    CTPercentage addNewBlueOff();

    CTComplementTransform addNewComp();

    CTGammaTransform addNewGamma();

    CTGrayscaleTransform addNewGray();

    CTPercentage addNewGreen();

    CTPercentage addNewGreenMod();

    CTPercentage addNewGreenOff();

    CTPositiveFixedAngle addNewHue();

    CTPositivePercentage addNewHueMod();

    CTAngle addNewHueOff();

    CTInverseTransform addNewInv();

    CTInverseGammaTransform addNewInvGamma();

    CTPercentage addNewLum();

    CTPercentage addNewLumMod();

    CTPercentage addNewLumOff();

    CTPercentage addNewRed();

    CTPercentage addNewRedMod();

    CTPercentage addNewRedOff();

    CTPercentage addNewSat();

    CTPercentage addNewSatMod();

    CTPercentage addNewSatOff();

    CTPositiveFixedPercentage addNewShade();

    CTPositiveFixedPercentage addNewTint();

    CTPositiveFixedPercentage getAlphaArray(int i2);

    CTPositiveFixedPercentage[] getAlphaArray();

    List<CTPositiveFixedPercentage> getAlphaList();

    CTPositivePercentage getAlphaModArray(int i2);

    CTPositivePercentage[] getAlphaModArray();

    List<CTPositivePercentage> getAlphaModList();

    CTFixedPercentage getAlphaOffArray(int i2);

    CTFixedPercentage[] getAlphaOffArray();

    List<CTFixedPercentage> getAlphaOffList();

    CTPercentage getBlueArray(int i2);

    CTPercentage[] getBlueArray();

    List<CTPercentage> getBlueList();

    CTPercentage getBlueModArray(int i2);

    CTPercentage[] getBlueModArray();

    List<CTPercentage> getBlueModList();

    CTPercentage getBlueOffArray(int i2);

    CTPercentage[] getBlueOffArray();

    List<CTPercentage> getBlueOffList();

    CTComplementTransform getCompArray(int i2);

    CTComplementTransform[] getCompArray();

    List<CTComplementTransform> getCompList();

    CTGammaTransform getGammaArray(int i2);

    CTGammaTransform[] getGammaArray();

    List<CTGammaTransform> getGammaList();

    CTGrayscaleTransform getGrayArray(int i2);

    CTGrayscaleTransform[] getGrayArray();

    List<CTGrayscaleTransform> getGrayList();

    CTPercentage getGreenArray(int i2);

    CTPercentage[] getGreenArray();

    List<CTPercentage> getGreenList();

    CTPercentage getGreenModArray(int i2);

    CTPercentage[] getGreenModArray();

    List<CTPercentage> getGreenModList();

    CTPercentage getGreenOffArray(int i2);

    CTPercentage[] getGreenOffArray();

    List<CTPercentage> getGreenOffList();

    CTPositiveFixedAngle getHueArray(int i2);

    CTPositiveFixedAngle[] getHueArray();

    List<CTPositiveFixedAngle> getHueList();

    CTPositivePercentage getHueModArray(int i2);

    CTPositivePercentage[] getHueModArray();

    List<CTPositivePercentage> getHueModList();

    CTAngle getHueOffArray(int i2);

    CTAngle[] getHueOffArray();

    List<CTAngle> getHueOffList();

    CTInverseTransform getInvArray(int i2);

    CTInverseTransform[] getInvArray();

    CTInverseGammaTransform getInvGammaArray(int i2);

    CTInverseGammaTransform[] getInvGammaArray();

    List<CTInverseGammaTransform> getInvGammaList();

    List<CTInverseTransform> getInvList();

    CTPercentage getLumArray(int i2);

    CTPercentage[] getLumArray();

    List<CTPercentage> getLumList();

    CTPercentage getLumModArray(int i2);

    CTPercentage[] getLumModArray();

    List<CTPercentage> getLumModList();

    CTPercentage getLumOffArray(int i2);

    CTPercentage[] getLumOffArray();

    List<CTPercentage> getLumOffList();

    CTPercentage getRedArray(int i2);

    CTPercentage[] getRedArray();

    List<CTPercentage> getRedList();

    CTPercentage getRedModArray(int i2);

    CTPercentage[] getRedModArray();

    List<CTPercentage> getRedModList();

    CTPercentage getRedOffArray(int i2);

    CTPercentage[] getRedOffArray();

    List<CTPercentage> getRedOffList();

    CTPercentage getSatArray(int i2);

    CTPercentage[] getSatArray();

    List<CTPercentage> getSatList();

    CTPercentage getSatModArray(int i2);

    CTPercentage[] getSatModArray();

    List<CTPercentage> getSatModList();

    CTPercentage getSatOffArray(int i2);

    CTPercentage[] getSatOffArray();

    List<CTPercentage> getSatOffList();

    CTPositiveFixedPercentage getShadeArray(int i2);

    CTPositiveFixedPercentage[] getShadeArray();

    List<CTPositiveFixedPercentage> getShadeList();

    CTPositiveFixedPercentage getTintArray(int i2);

    CTPositiveFixedPercentage[] getTintArray();

    List<CTPositiveFixedPercentage> getTintList();

    STPresetColorVal.Enum getVal();

    CTPositiveFixedPercentage insertNewAlpha(int i2);

    CTPositivePercentage insertNewAlphaMod(int i2);

    CTFixedPercentage insertNewAlphaOff(int i2);

    CTPercentage insertNewBlue(int i2);

    CTPercentage insertNewBlueMod(int i2);

    CTPercentage insertNewBlueOff(int i2);

    CTComplementTransform insertNewComp(int i2);

    CTGammaTransform insertNewGamma(int i2);

    CTGrayscaleTransform insertNewGray(int i2);

    CTPercentage insertNewGreen(int i2);

    CTPercentage insertNewGreenMod(int i2);

    CTPercentage insertNewGreenOff(int i2);

    CTPositiveFixedAngle insertNewHue(int i2);

    CTPositivePercentage insertNewHueMod(int i2);

    CTAngle insertNewHueOff(int i2);

    CTInverseTransform insertNewInv(int i2);

    CTInverseGammaTransform insertNewInvGamma(int i2);

    CTPercentage insertNewLum(int i2);

    CTPercentage insertNewLumMod(int i2);

    CTPercentage insertNewLumOff(int i2);

    CTPercentage insertNewRed(int i2);

    CTPercentage insertNewRedMod(int i2);

    CTPercentage insertNewRedOff(int i2);

    CTPercentage insertNewSat(int i2);

    CTPercentage insertNewSatMod(int i2);

    CTPercentage insertNewSatOff(int i2);

    CTPositiveFixedPercentage insertNewShade(int i2);

    CTPositiveFixedPercentage insertNewTint(int i2);

    void removeAlpha(int i2);

    void removeAlphaMod(int i2);

    void removeAlphaOff(int i2);

    void removeBlue(int i2);

    void removeBlueMod(int i2);

    void removeBlueOff(int i2);

    void removeComp(int i2);

    void removeGamma(int i2);

    void removeGray(int i2);

    void removeGreen(int i2);

    void removeGreenMod(int i2);

    void removeGreenOff(int i2);

    void removeHue(int i2);

    void removeHueMod(int i2);

    void removeHueOff(int i2);

    void removeInv(int i2);

    void removeInvGamma(int i2);

    void removeLum(int i2);

    void removeLumMod(int i2);

    void removeLumOff(int i2);

    void removeRed(int i2);

    void removeRedMod(int i2);

    void removeRedOff(int i2);

    void removeSat(int i2);

    void removeSatMod(int i2);

    void removeSatOff(int i2);

    void removeShade(int i2);

    void removeTint(int i2);

    void setAlphaArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setAlphaArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setAlphaModArray(int i2, CTPositivePercentage cTPositivePercentage);

    void setAlphaModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setAlphaOffArray(int i2, CTFixedPercentage cTFixedPercentage);

    void setAlphaOffArray(CTFixedPercentage[] cTFixedPercentageArr);

    void setBlueArray(int i2, CTPercentage cTPercentage);

    void setBlueArray(CTPercentage[] cTPercentageArr);

    void setBlueModArray(int i2, CTPercentage cTPercentage);

    void setBlueModArray(CTPercentage[] cTPercentageArr);

    void setBlueOffArray(int i2, CTPercentage cTPercentage);

    void setBlueOffArray(CTPercentage[] cTPercentageArr);

    void setCompArray(int i2, CTComplementTransform cTComplementTransform);

    void setCompArray(CTComplementTransform[] cTComplementTransformArr);

    void setGammaArray(int i2, CTGammaTransform cTGammaTransform);

    void setGammaArray(CTGammaTransform[] cTGammaTransformArr);

    void setGrayArray(int i2, CTGrayscaleTransform cTGrayscaleTransform);

    void setGrayArray(CTGrayscaleTransform[] cTGrayscaleTransformArr);

    void setGreenArray(int i2, CTPercentage cTPercentage);

    void setGreenArray(CTPercentage[] cTPercentageArr);

    void setGreenModArray(int i2, CTPercentage cTPercentage);

    void setGreenModArray(CTPercentage[] cTPercentageArr);

    void setGreenOffArray(int i2, CTPercentage cTPercentage);

    void setGreenOffArray(CTPercentage[] cTPercentageArr);

    void setHueArray(int i2, CTPositiveFixedAngle cTPositiveFixedAngle);

    void setHueArray(CTPositiveFixedAngle[] cTPositiveFixedAngleArr);

    void setHueModArray(int i2, CTPositivePercentage cTPositivePercentage);

    void setHueModArray(CTPositivePercentage[] cTPositivePercentageArr);

    void setHueOffArray(int i2, CTAngle cTAngle);

    void setHueOffArray(CTAngle[] cTAngleArr);

    void setInvArray(int i2, CTInverseTransform cTInverseTransform);

    void setInvArray(CTInverseTransform[] cTInverseTransformArr);

    void setInvGammaArray(int i2, CTInverseGammaTransform cTInverseGammaTransform);

    void setInvGammaArray(CTInverseGammaTransform[] cTInverseGammaTransformArr);

    void setLumArray(int i2, CTPercentage cTPercentage);

    void setLumArray(CTPercentage[] cTPercentageArr);

    void setLumModArray(int i2, CTPercentage cTPercentage);

    void setLumModArray(CTPercentage[] cTPercentageArr);

    void setLumOffArray(int i2, CTPercentage cTPercentage);

    void setLumOffArray(CTPercentage[] cTPercentageArr);

    void setRedArray(int i2, CTPercentage cTPercentage);

    void setRedArray(CTPercentage[] cTPercentageArr);

    void setRedModArray(int i2, CTPercentage cTPercentage);

    void setRedModArray(CTPercentage[] cTPercentageArr);

    void setRedOffArray(int i2, CTPercentage cTPercentage);

    void setRedOffArray(CTPercentage[] cTPercentageArr);

    void setSatArray(int i2, CTPercentage cTPercentage);

    void setSatArray(CTPercentage[] cTPercentageArr);

    void setSatModArray(int i2, CTPercentage cTPercentage);

    void setSatModArray(CTPercentage[] cTPercentageArr);

    void setSatOffArray(int i2, CTPercentage cTPercentage);

    void setSatOffArray(CTPercentage[] cTPercentageArr);

    void setShadeArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setShadeArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setTintArray(int i2, CTPositiveFixedPercentage cTPositiveFixedPercentage);

    void setTintArray(CTPositiveFixedPercentage[] cTPositiveFixedPercentageArr);

    void setVal(STPresetColorVal.Enum r1);

    int sizeOfAlphaArray();

    int sizeOfAlphaModArray();

    int sizeOfAlphaOffArray();

    int sizeOfBlueArray();

    int sizeOfBlueModArray();

    int sizeOfBlueOffArray();

    int sizeOfCompArray();

    int sizeOfGammaArray();

    int sizeOfGrayArray();

    int sizeOfGreenArray();

    int sizeOfGreenModArray();

    int sizeOfGreenOffArray();

    int sizeOfHueArray();

    int sizeOfHueModArray();

    int sizeOfHueOffArray();

    int sizeOfInvArray();

    int sizeOfInvGammaArray();

    int sizeOfLumArray();

    int sizeOfLumModArray();

    int sizeOfLumOffArray();

    int sizeOfRedArray();

    int sizeOfRedModArray();

    int sizeOfRedOffArray();

    int sizeOfSatArray();

    int sizeOfSatModArray();

    int sizeOfSatOffArray();

    int sizeOfShadeArray();

    int sizeOfTintArray();

    STPresetColorVal xgetVal();

    void xsetVal(STPresetColorVal sTPresetColorVal);
}
