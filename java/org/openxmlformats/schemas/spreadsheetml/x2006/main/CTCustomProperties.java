package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTCustomProperties extends XmlObject {
    public static final DocumentFactory<CTCustomProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomproperties584dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustomProperty addNewCustomPr();

    CTCustomProperty getCustomPrArray(int i2);

    CTCustomProperty[] getCustomPrArray();

    List<CTCustomProperty> getCustomPrList();

    CTCustomProperty insertNewCustomPr(int i2);

    void removeCustomPr(int i2);

    void setCustomPrArray(int i2, CTCustomProperty cTCustomProperty);

    void setCustomPrArray(CTCustomProperty[] cTCustomPropertyArr);

    int sizeOfCustomPrArray();
}
