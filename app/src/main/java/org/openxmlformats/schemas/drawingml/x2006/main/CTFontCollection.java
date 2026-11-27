package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTFontCollection extends XmlObject {
    public static final DocumentFactory<CTFontCollection> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFontCollection> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfontcollectiondd68type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTextFont addNewCs();

    CTTextFont addNewEa();

    CTOfficeArtExtensionList addNewExtLst();

    CTSupplementalFont addNewFont();

    CTTextFont addNewLatin();

    CTTextFont getCs();

    CTTextFont getEa();

    CTOfficeArtExtensionList getExtLst();

    CTSupplementalFont getFontArray(int i2);

    CTSupplementalFont[] getFontArray();

    List<CTSupplementalFont> getFontList();

    CTTextFont getLatin();

    CTSupplementalFont insertNewFont(int i2);

    boolean isSetExtLst();

    void removeFont(int i2);

    void setCs(CTTextFont cTTextFont);

    void setEa(CTTextFont cTTextFont);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFontArray(int i2, CTSupplementalFont cTSupplementalFont);

    void setFontArray(CTSupplementalFont[] cTSupplementalFontArr);

    void setLatin(CTTextFont cTTextFont);

    int sizeOfFontArray();

    void unsetExtLst();
}
