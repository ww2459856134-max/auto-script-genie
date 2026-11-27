package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTProperties extends XmlObject {
    public static final DocumentFactory<CTProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctproperties2c18type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTProperty addNewProperty();

    CTProperty getPropertyArray(int i2);

    CTProperty[] getPropertyArray();

    List<CTProperty> getPropertyList();

    CTProperty insertNewProperty(int i2);

    void removeProperty(int i2);

    void setPropertyArray(int i2, CTProperty cTProperty);

    void setPropertyArray(CTProperty[] cTPropertyArr);

    int sizeOfPropertyArray();
}
