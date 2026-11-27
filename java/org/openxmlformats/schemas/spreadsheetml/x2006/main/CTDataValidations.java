package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTDataValidations extends XmlObject {
    public static final DocumentFactory<CTDataValidations> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataValidations> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdatavalidationse46ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDataValidation addNewDataValidation();

    long getCount();

    CTDataValidation getDataValidationArray(int i2);

    CTDataValidation[] getDataValidationArray();

    List<CTDataValidation> getDataValidationList();

    boolean getDisablePrompts();

    long getXWindow();

    long getYWindow();

    CTDataValidation insertNewDataValidation(int i2);

    boolean isSetCount();

    boolean isSetDisablePrompts();

    boolean isSetXWindow();

    boolean isSetYWindow();

    void removeDataValidation(int i2);

    void setCount(long j2);

    void setDataValidationArray(int i2, CTDataValidation cTDataValidation);

    void setDataValidationArray(CTDataValidation[] cTDataValidationArr);

    void setDisablePrompts(boolean z);

    void setXWindow(long j2);

    void setYWindow(long j2);

    int sizeOfDataValidationArray();

    void unsetCount();

    void unsetDisablePrompts();

    void unsetXWindow();

    void unsetYWindow();

    XmlUnsignedInt xgetCount();

    XmlBoolean xgetDisablePrompts();

    XmlUnsignedInt xgetXWindow();

    XmlUnsignedInt xgetYWindow();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetDisablePrompts(XmlBoolean xmlBoolean);

    void xsetXWindow(XmlUnsignedInt xmlUnsignedInt);

    void xsetYWindow(XmlUnsignedInt xmlUnsignedInt);
}
