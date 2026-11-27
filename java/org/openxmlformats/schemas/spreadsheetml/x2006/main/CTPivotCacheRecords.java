package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTPivotCacheRecords extends XmlObject {
    public static final DocumentFactory<CTPivotCacheRecords> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotCacheRecords> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotcacherecords5be1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTRecord addNewR();

    long getCount();

    CTExtensionList getExtLst();

    CTRecord getRArray(int i2);

    CTRecord[] getRArray();

    List<CTRecord> getRList();

    CTRecord insertNewR(int i2);

    boolean isSetCount();

    boolean isSetExtLst();

    void removeR(int i2);

    void setCount(long j2);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRArray(int i2, CTRecord cTRecord);

    void setRArray(CTRecord[] cTRecordArr);

    int sizeOfRArray();

    void unsetCount();

    void unsetExtLst();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
