package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTLineStyleList extends XmlObject {
    public static final DocumentFactory<CTLineStyleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLineStyleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlinestylelist510ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTLineProperties addNewLn();

    CTLineProperties getLnArray(int i2);

    CTLineProperties[] getLnArray();

    List<CTLineProperties> getLnList();

    CTLineProperties insertNewLn(int i2);

    void removeLn(int i2);

    void setLnArray(int i2, CTLineProperties cTLineProperties);

    void setLnArray(CTLineProperties[] cTLinePropertiesArr);

    int sizeOfLnArray();
}
