package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDuotoneEffect extends XmlObject {
    public static final DocumentFactory<CTDuotoneEffect> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDuotoneEffect> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctduotoneeffectae52type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClrArray(int i2);

    CTHslColor[] getHslClrArray();

    List<CTHslColor> getHslClrList();

    CTPresetColor getPrstClrArray(int i2);

    CTPresetColor[] getPrstClrArray();

    List<CTPresetColor> getPrstClrList();

    CTSchemeColor getSchemeClrArray(int i2);

    CTSchemeColor[] getSchemeClrArray();

    List<CTSchemeColor> getSchemeClrList();

    CTScRgbColor getScrgbClrArray(int i2);

    CTScRgbColor[] getScrgbClrArray();

    List<CTScRgbColor> getScrgbClrList();

    CTSRgbColor getSrgbClrArray(int i2);

    CTSRgbColor[] getSrgbClrArray();

    List<CTSRgbColor> getSrgbClrList();

    CTSystemColor getSysClrArray(int i2);

    CTSystemColor[] getSysClrArray();

    List<CTSystemColor> getSysClrList();

    CTHslColor insertNewHslClr(int i2);

    CTPresetColor insertNewPrstClr(int i2);

    CTSchemeColor insertNewSchemeClr(int i2);

    CTScRgbColor insertNewScrgbClr(int i2);

    CTSRgbColor insertNewSrgbClr(int i2);

    CTSystemColor insertNewSysClr(int i2);

    void removeHslClr(int i2);

    void removePrstClr(int i2);

    void removeSchemeClr(int i2);

    void removeScrgbClr(int i2);

    void removeSrgbClr(int i2);

    void removeSysClr(int i2);

    void setHslClrArray(int i2, CTHslColor cTHslColor);

    void setHslClrArray(CTHslColor[] cTHslColorArr);

    void setPrstClrArray(int i2, CTPresetColor cTPresetColor);

    void setPrstClrArray(CTPresetColor[] cTPresetColorArr);

    void setSchemeClrArray(int i2, CTSchemeColor cTSchemeColor);

    void setSchemeClrArray(CTSchemeColor[] cTSchemeColorArr);

    void setScrgbClrArray(int i2, CTScRgbColor cTScRgbColor);

    void setScrgbClrArray(CTScRgbColor[] cTScRgbColorArr);

    void setSrgbClrArray(int i2, CTSRgbColor cTSRgbColor);

    void setSrgbClrArray(CTSRgbColor[] cTSRgbColorArr);

    void setSysClrArray(int i2, CTSystemColor cTSystemColor);

    void setSysClrArray(CTSystemColor[] cTSystemColorArr);

    int sizeOfHslClrArray();

    int sizeOfPrstClrArray();

    int sizeOfSchemeClrArray();

    int sizeOfScrgbClrArray();

    int sizeOfSrgbClrArray();

    int sizeOfSysClrArray();
}
