package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDefinedNames extends XmlObject {
    public static final DocumentFactory<CTDefinedNames> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDefinedNames> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdefinednamesce48type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDefinedName addNewDefinedName();

    CTDefinedName getDefinedNameArray(int i2);

    CTDefinedName[] getDefinedNameArray();

    List<CTDefinedName> getDefinedNameList();

    CTDefinedName insertNewDefinedName(int i2);

    void removeDefinedName(int i2);

    void setDefinedNameArray(int i2, CTDefinedName cTDefinedName);

    void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr);

    int sizeOfDefinedNameArray();
}
