package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTColorScale extends XmlObject {
    public static final DocumentFactory<CTColorScale> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColorScale> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolorscale1a70type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCfvo addNewCfvo();

    CTColor addNewColor();

    CTCfvo getCfvoArray(int i2);

    CTCfvo[] getCfvoArray();

    List<CTCfvo> getCfvoList();

    CTColor getColorArray(int i2);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTCfvo insertNewCfvo(int i2);

    CTColor insertNewColor(int i2);

    void removeCfvo(int i2);

    void removeColor(int i2);

    void setCfvoArray(int i2, CTCfvo cTCfvo);

    void setCfvoArray(CTCfvo[] cTCfvoArr);

    void setColorArray(int i2, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    int sizeOfCfvoArray();

    int sizeOfColorArray();
}
