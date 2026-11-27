package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTAdjustHandleList extends XmlObject {
    public static final DocumentFactory<CTAdjustHandleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAdjustHandleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctadjusthandlelistfdb0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPolarAdjustHandle addNewAhPolar();

    CTXYAdjustHandle addNewAhXY();

    CTPolarAdjustHandle getAhPolarArray(int i2);

    CTPolarAdjustHandle[] getAhPolarArray();

    List<CTPolarAdjustHandle> getAhPolarList();

    CTXYAdjustHandle getAhXYArray(int i2);

    CTXYAdjustHandle[] getAhXYArray();

    List<CTXYAdjustHandle> getAhXYList();

    CTPolarAdjustHandle insertNewAhPolar(int i2);

    CTXYAdjustHandle insertNewAhXY(int i2);

    void removeAhPolar(int i2);

    void removeAhXY(int i2);

    void setAhPolarArray(int i2, CTPolarAdjustHandle cTPolarAdjustHandle);

    void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr);

    void setAhXYArray(int i2, CTXYAdjustHandle cTXYAdjustHandle);

    void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr);

    int sizeOfAhPolarArray();

    int sizeOfAhXYArray();
}
