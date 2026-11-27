package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTFont extends XmlObject {
    public static final DocumentFactory<CTFont> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFont> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfont14d8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBooleanProperty addNewB();

    CTIntProperty addNewCharset();

    CTColor addNewColor();

    CTBooleanProperty addNewCondense();

    CTBooleanProperty addNewExtend();

    CTFontFamily addNewFamily();

    CTBooleanProperty addNewI();

    CTFontName addNewName();

    CTBooleanProperty addNewOutline();

    CTFontScheme addNewScheme();

    CTBooleanProperty addNewShadow();

    CTBooleanProperty addNewStrike();

    CTFontSize addNewSz();

    CTUnderlineProperty addNewU();

    CTVerticalAlignFontProperty addNewVertAlign();

    CTBooleanProperty getBArray(int i2);

    CTBooleanProperty[] getBArray();

    List<CTBooleanProperty> getBList();

    CTIntProperty getCharsetArray(int i2);

    CTIntProperty[] getCharsetArray();

    List<CTIntProperty> getCharsetList();

    CTColor getColorArray(int i2);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTBooleanProperty getCondenseArray(int i2);

    CTBooleanProperty[] getCondenseArray();

    List<CTBooleanProperty> getCondenseList();

    CTBooleanProperty getExtendArray(int i2);

    CTBooleanProperty[] getExtendArray();

    List<CTBooleanProperty> getExtendList();

    CTFontFamily getFamilyArray(int i2);

    CTFontFamily[] getFamilyArray();

    List<CTFontFamily> getFamilyList();

    CTBooleanProperty getIArray(int i2);

    CTBooleanProperty[] getIArray();

    List<CTBooleanProperty> getIList();

    CTFontName getNameArray(int i2);

    CTFontName[] getNameArray();

    List<CTFontName> getNameList();

    CTBooleanProperty getOutlineArray(int i2);

    CTBooleanProperty[] getOutlineArray();

    List<CTBooleanProperty> getOutlineList();

    CTFontScheme getSchemeArray(int i2);

    CTFontScheme[] getSchemeArray();

    List<CTFontScheme> getSchemeList();

    CTBooleanProperty getShadowArray(int i2);

    CTBooleanProperty[] getShadowArray();

    List<CTBooleanProperty> getShadowList();

    CTBooleanProperty getStrikeArray(int i2);

    CTBooleanProperty[] getStrikeArray();

    List<CTBooleanProperty> getStrikeList();

    CTFontSize getSzArray(int i2);

    CTFontSize[] getSzArray();

    List<CTFontSize> getSzList();

    CTUnderlineProperty getUArray(int i2);

    CTUnderlineProperty[] getUArray();

    List<CTUnderlineProperty> getUList();

    CTVerticalAlignFontProperty getVertAlignArray(int i2);

    CTVerticalAlignFontProperty[] getVertAlignArray();

    List<CTVerticalAlignFontProperty> getVertAlignList();

    CTBooleanProperty insertNewB(int i2);

    CTIntProperty insertNewCharset(int i2);

    CTColor insertNewColor(int i2);

    CTBooleanProperty insertNewCondense(int i2);

    CTBooleanProperty insertNewExtend(int i2);

    CTFontFamily insertNewFamily(int i2);

    CTBooleanProperty insertNewI(int i2);

    CTFontName insertNewName(int i2);

    CTBooleanProperty insertNewOutline(int i2);

    CTFontScheme insertNewScheme(int i2);

    CTBooleanProperty insertNewShadow(int i2);

    CTBooleanProperty insertNewStrike(int i2);

    CTFontSize insertNewSz(int i2);

    CTUnderlineProperty insertNewU(int i2);

    CTVerticalAlignFontProperty insertNewVertAlign(int i2);

    void removeB(int i2);

    void removeCharset(int i2);

    void removeColor(int i2);

    void removeCondense(int i2);

    void removeExtend(int i2);

    void removeFamily(int i2);

    void removeI(int i2);

    void removeName(int i2);

    void removeOutline(int i2);

    void removeScheme(int i2);

    void removeShadow(int i2);

    void removeStrike(int i2);

    void removeSz(int i2);

    void removeU(int i2);

    void removeVertAlign(int i2);

    void setBArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setBArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setCharsetArray(int i2, CTIntProperty cTIntProperty);

    void setCharsetArray(CTIntProperty[] cTIntPropertyArr);

    void setColorArray(int i2, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    void setCondenseArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setCondenseArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setExtendArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setExtendArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setFamilyArray(int i2, CTFontFamily cTFontFamily);

    void setFamilyArray(CTFontFamily[] cTFontFamilyArr);

    void setIArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setIArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setNameArray(int i2, CTFontName cTFontName);

    void setNameArray(CTFontName[] cTFontNameArr);

    void setOutlineArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setOutlineArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setSchemeArray(int i2, CTFontScheme cTFontScheme);

    void setSchemeArray(CTFontScheme[] cTFontSchemeArr);

    void setShadowArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setShadowArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setStrikeArray(int i2, CTBooleanProperty cTBooleanProperty);

    void setStrikeArray(CTBooleanProperty[] cTBooleanPropertyArr);

    void setSzArray(int i2, CTFontSize cTFontSize);

    void setSzArray(CTFontSize[] cTFontSizeArr);

    void setUArray(int i2, CTUnderlineProperty cTUnderlineProperty);

    void setUArray(CTUnderlineProperty[] cTUnderlinePropertyArr);

    void setVertAlignArray(int i2, CTVerticalAlignFontProperty cTVerticalAlignFontProperty);

    void setVertAlignArray(CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr);

    int sizeOfBArray();

    int sizeOfCharsetArray();

    int sizeOfColorArray();

    int sizeOfCondenseArray();

    int sizeOfExtendArray();

    int sizeOfFamilyArray();

    int sizeOfIArray();

    int sizeOfNameArray();

    int sizeOfOutlineArray();

    int sizeOfSchemeArray();

    int sizeOfShadowArray();

    int sizeOfStrikeArray();

    int sizeOfSzArray();

    int sizeOfUArray();

    int sizeOfVertAlignArray();
}
