package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTControls extends XmlObject {
    public static final DocumentFactory<CTControls> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTControls> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcontrols75fftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTControl addNewControl();

    CTControl getControlArray(int i2);

    CTControl[] getControlArray();

    List<CTControl> getControlList();

    CTControl insertNewControl(int i2);

    void removeControl(int i2);

    void setControlArray(int i2, CTControl cTControl);

    void setControlArray(CTControl[] cTControlArr);

    int sizeOfControlArray();
}
