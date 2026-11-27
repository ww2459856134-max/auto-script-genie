package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTGeomGuideList extends XmlObject {
    public static final DocumentFactory<CTGeomGuideList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGeomGuideList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgeomguidelist364ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTGeomGuide addNewGd();

    CTGeomGuide getGdArray(int i2);

    CTGeomGuide[] getGdArray();

    List<CTGeomGuide> getGdList();

    CTGeomGuide insertNewGd(int i2);

    void removeGd(int i2);

    void setGdArray(int i2, CTGeomGuide cTGeomGuide);

    void setGdArray(CTGeomGuide[] cTGeomGuideArr);

    int sizeOfGdArray();
}
