package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes3.dex */
public interface CTNumbering extends XmlObject {
    public static final DocumentFactory<CTNumbering> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumbering> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumberingfdf9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAbstractNum addNewAbstractNum();

    CTNum addNewNum();

    CTDecimalNumber addNewNumIdMacAtCleanup();

    CTNumPicBullet addNewNumPicBullet();

    CTAbstractNum getAbstractNumArray(int i2);

    CTAbstractNum[] getAbstractNumArray();

    List<CTAbstractNum> getAbstractNumList();

    CTNum getNumArray(int i2);

    CTNum[] getNumArray();

    CTDecimalNumber getNumIdMacAtCleanup();

    List<CTNum> getNumList();

    CTNumPicBullet getNumPicBulletArray(int i2);

    CTNumPicBullet[] getNumPicBulletArray();

    List<CTNumPicBullet> getNumPicBulletList();

    CTAbstractNum insertNewAbstractNum(int i2);

    CTNum insertNewNum(int i2);

    CTNumPicBullet insertNewNumPicBullet(int i2);

    boolean isSetNumIdMacAtCleanup();

    void removeAbstractNum(int i2);

    void removeNum(int i2);

    void removeNumPicBullet(int i2);

    void setAbstractNumArray(int i2, CTAbstractNum cTAbstractNum);

    void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr);

    void setNumArray(int i2, CTNum cTNum);

    void setNumArray(CTNum[] cTNumArr);

    void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber);

    void setNumPicBulletArray(int i2, CTNumPicBullet cTNumPicBullet);

    void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr);

    int sizeOfAbstractNumArray();

    int sizeOfNumArray();

    int sizeOfNumPicBulletArray();

    void unsetNumIdMacAtCleanup();
}
