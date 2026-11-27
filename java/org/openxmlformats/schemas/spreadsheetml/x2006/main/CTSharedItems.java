package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.Calendar;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* loaded from: classes2.dex */
public interface CTSharedItems extends XmlObject {
    public static final DocumentFactory<CTSharedItems> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSharedItems> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctshareditems677atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBoolean addNewB();

    CTDateTime addNewD();

    CTError addNewE();

    CTMissing addNewM();

    CTNumber addNewN();

    CTString addNewS();

    CTBoolean getBArray(int i2);

    CTBoolean[] getBArray();

    List<CTBoolean> getBList();

    boolean getContainsBlank();

    boolean getContainsDate();

    boolean getContainsInteger();

    boolean getContainsMixedTypes();

    boolean getContainsNonDate();

    boolean getContainsNumber();

    boolean getContainsSemiMixedTypes();

    boolean getContainsString();

    long getCount();

    CTDateTime getDArray(int i2);

    CTDateTime[] getDArray();

    List<CTDateTime> getDList();

    CTError getEArray(int i2);

    CTError[] getEArray();

    List<CTError> getEList();

    boolean getLongText();

    CTMissing getMArray(int i2);

    CTMissing[] getMArray();

    List<CTMissing> getMList();

    Calendar getMaxDate();

    double getMaxValue();

    Calendar getMinDate();

    double getMinValue();

    CTNumber getNArray(int i2);

    CTNumber[] getNArray();

    List<CTNumber> getNList();

    CTString getSArray(int i2);

    CTString[] getSArray();

    List<CTString> getSList();

    CTBoolean insertNewB(int i2);

    CTDateTime insertNewD(int i2);

    CTError insertNewE(int i2);

    CTMissing insertNewM(int i2);

    CTNumber insertNewN(int i2);

    CTString insertNewS(int i2);

    boolean isSetContainsBlank();

    boolean isSetContainsDate();

    boolean isSetContainsInteger();

    boolean isSetContainsMixedTypes();

    boolean isSetContainsNonDate();

    boolean isSetContainsNumber();

    boolean isSetContainsSemiMixedTypes();

    boolean isSetContainsString();

    boolean isSetCount();

    boolean isSetLongText();

    boolean isSetMaxDate();

    boolean isSetMaxValue();

    boolean isSetMinDate();

    boolean isSetMinValue();

    void removeB(int i2);

    void removeD(int i2);

    void removeE(int i2);

    void removeM(int i2);

    void removeN(int i2);

    void removeS(int i2);

    void setBArray(int i2, CTBoolean cTBoolean);

    void setBArray(CTBoolean[] cTBooleanArr);

    void setContainsBlank(boolean z);

    void setContainsDate(boolean z);

    void setContainsInteger(boolean z);

    void setContainsMixedTypes(boolean z);

    void setContainsNonDate(boolean z);

    void setContainsNumber(boolean z);

    void setContainsSemiMixedTypes(boolean z);

    void setContainsString(boolean z);

    void setCount(long j2);

    void setDArray(int i2, CTDateTime cTDateTime);

    void setDArray(CTDateTime[] cTDateTimeArr);

    void setEArray(int i2, CTError cTError);

    void setEArray(CTError[] cTErrorArr);

    void setLongText(boolean z);

    void setMArray(int i2, CTMissing cTMissing);

    void setMArray(CTMissing[] cTMissingArr);

    void setMaxDate(Calendar calendar);

    void setMaxValue(double d);

    void setMinDate(Calendar calendar);

    void setMinValue(double d);

    void setNArray(int i2, CTNumber cTNumber);

    void setNArray(CTNumber[] cTNumberArr);

    void setSArray(int i2, CTString cTString);

    void setSArray(CTString[] cTStringArr);

    int sizeOfBArray();

    int sizeOfDArray();

    int sizeOfEArray();

    int sizeOfMArray();

    int sizeOfNArray();

    int sizeOfSArray();

    void unsetContainsBlank();

    void unsetContainsDate();

    void unsetContainsInteger();

    void unsetContainsMixedTypes();

    void unsetContainsNonDate();

    void unsetContainsNumber();

    void unsetContainsSemiMixedTypes();

    void unsetContainsString();

    void unsetCount();

    void unsetLongText();

    void unsetMaxDate();

    void unsetMaxValue();

    void unsetMinDate();

    void unsetMinValue();

    XmlBoolean xgetContainsBlank();

    XmlBoolean xgetContainsDate();

    XmlBoolean xgetContainsInteger();

    XmlBoolean xgetContainsMixedTypes();

    XmlBoolean xgetContainsNonDate();

    XmlBoolean xgetContainsNumber();

    XmlBoolean xgetContainsSemiMixedTypes();

    XmlBoolean xgetContainsString();

    XmlUnsignedInt xgetCount();

    XmlBoolean xgetLongText();

    XmlDateTime xgetMaxDate();

    XmlDouble xgetMaxValue();

    XmlDateTime xgetMinDate();

    XmlDouble xgetMinValue();

    void xsetContainsBlank(XmlBoolean xmlBoolean);

    void xsetContainsDate(XmlBoolean xmlBoolean);

    void xsetContainsInteger(XmlBoolean xmlBoolean);

    void xsetContainsMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsNonDate(XmlBoolean xmlBoolean);

    void xsetContainsNumber(XmlBoolean xmlBoolean);

    void xsetContainsSemiMixedTypes(XmlBoolean xmlBoolean);

    void xsetContainsString(XmlBoolean xmlBoolean);

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetLongText(XmlBoolean xmlBoolean);

    void xsetMaxDate(XmlDateTime xmlDateTime);

    void xsetMaxValue(XmlDouble xmlDouble);

    void xsetMinDate(XmlDateTime xmlDateTime);

    void xsetMinValue(XmlDouble xmlDouble);
}
