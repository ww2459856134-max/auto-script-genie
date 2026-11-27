package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* loaded from: classes2.dex */
public interface CTVector extends XmlObject {
    public static final DocumentFactory<CTVector> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTVector> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctvectorc3e2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    void addBool(boolean z);

    void addBstr(String str);

    void addClsid(String str);

    void addCy(String str);

    void addDate(Calendar calendar);

    void addError(String str);

    void addFiletime(Calendar calendar);

    void addI1(byte b);

    void addI2(short s);

    void addI4(int i2);

    void addI8(long j2);

    void addLpstr(String str);

    void addLpwstr(String str);

    XmlBoolean addNewBool();

    XmlString addNewBstr();

    STGuid addNewClsid();

    STCy addNewCy();

    XmlDateTime addNewDate();

    STError addNewError();

    XmlDateTime addNewFiletime();

    XmlByte addNewI1();

    XmlShort addNewI2();

    XmlInt addNewI4();

    XmlLong addNewI8();

    XmlString addNewLpstr();

    XmlString addNewLpwstr();

    XmlFloat addNewR4();

    XmlDouble addNewR8();

    XmlUnsignedByte addNewUi1();

    XmlUnsignedShort addNewUi2();

    XmlUnsignedInt addNewUi4();

    XmlUnsignedLong addNewUi8();

    CTVariant addNewVariant();

    void addR4(float f);

    void addR8(double d);

    void addUi1(short s);

    void addUi2(int i2);

    void addUi4(long j2);

    void addUi8(BigInteger bigInteger);

    STVectorBaseType$Enum getBaseType();

    boolean getBoolArray(int i2);

    boolean[] getBoolArray();

    List<Boolean> getBoolList();

    String getBstrArray(int i2);

    String[] getBstrArray();

    List<String> getBstrList();

    String getClsidArray(int i2);

    String[] getClsidArray();

    List<String> getClsidList();

    String getCyArray(int i2);

    String[] getCyArray();

    List<String> getCyList();

    Calendar getDateArray(int i2);

    Calendar[] getDateArray();

    List<Calendar> getDateList();

    String getErrorArray(int i2);

    String[] getErrorArray();

    List<String> getErrorList();

    Calendar getFiletimeArray(int i2);

    Calendar[] getFiletimeArray();

    List<Calendar> getFiletimeList();

    byte getI1Array(int i2);

    byte[] getI1Array();

    List<Byte> getI1List();

    short getI2Array(int i2);

    short[] getI2Array();

    List<Short> getI2List();

    int getI4Array(int i2);

    int[] getI4Array();

    List<Integer> getI4List();

    long getI8Array(int i2);

    long[] getI8Array();

    List<Long> getI8List();

    String getLpstrArray(int i2);

    String[] getLpstrArray();

    List<String> getLpstrList();

    String getLpwstrArray(int i2);

    String[] getLpwstrArray();

    List<String> getLpwstrList();

    float getR4Array(int i2);

    float[] getR4Array();

    List<Float> getR4List();

    double getR8Array(int i2);

    double[] getR8Array();

    List<Double> getR8List();

    long getSize();

    short getUi1Array(int i2);

    short[] getUi1Array();

    List<Short> getUi1List();

    int getUi2Array(int i2);

    int[] getUi2Array();

    List<Integer> getUi2List();

    long getUi4Array(int i2);

    long[] getUi4Array();

    List<Long> getUi4List();

    BigInteger getUi8Array(int i2);

    BigInteger[] getUi8Array();

    List<BigInteger> getUi8List();

    CTVariant getVariantArray(int i2);

    CTVariant[] getVariantArray();

    List<CTVariant> getVariantList();

    void insertBool(int i2, boolean z);

    void insertBstr(int i2, String str);

    void insertClsid(int i2, String str);

    void insertCy(int i2, String str);

    void insertDate(int i2, Calendar calendar);

    void insertError(int i2, String str);

    void insertFiletime(int i2, Calendar calendar);

    void insertI1(int i2, byte b);

    void insertI2(int i2, short s);

    void insertI4(int i2, int i3);

    void insertI8(int i2, long j2);

    void insertLpstr(int i2, String str);

    void insertLpwstr(int i2, String str);

    XmlBoolean insertNewBool(int i2);

    XmlString insertNewBstr(int i2);

    STGuid insertNewClsid(int i2);

    STCy insertNewCy(int i2);

    XmlDateTime insertNewDate(int i2);

    STError insertNewError(int i2);

    XmlDateTime insertNewFiletime(int i2);

    XmlByte insertNewI1(int i2);

    XmlShort insertNewI2(int i2);

    XmlInt insertNewI4(int i2);

    XmlLong insertNewI8(int i2);

    XmlString insertNewLpstr(int i2);

    XmlString insertNewLpwstr(int i2);

    XmlFloat insertNewR4(int i2);

    XmlDouble insertNewR8(int i2);

    XmlUnsignedByte insertNewUi1(int i2);

    XmlUnsignedShort insertNewUi2(int i2);

    XmlUnsignedInt insertNewUi4(int i2);

    XmlUnsignedLong insertNewUi8(int i2);

    CTVariant insertNewVariant(int i2);

    void insertR4(int i2, float f);

    void insertR8(int i2, double d);

    void insertUi1(int i2, short s);

    void insertUi2(int i2, int i3);

    void insertUi4(int i2, long j2);

    void insertUi8(int i2, BigInteger bigInteger);

    void removeBool(int i2);

    void removeBstr(int i2);

    void removeClsid(int i2);

    void removeCy(int i2);

    void removeDate(int i2);

    void removeError(int i2);

    void removeFiletime(int i2);

    void removeI1(int i2);

    void removeI2(int i2);

    void removeI4(int i2);

    void removeI8(int i2);

    void removeLpstr(int i2);

    void removeLpwstr(int i2);

    void removeR4(int i2);

    void removeR8(int i2);

    void removeUi1(int i2);

    void removeUi2(int i2);

    void removeUi4(int i2);

    void removeUi8(int i2);

    void removeVariant(int i2);

    void setBaseType(STVectorBaseType$Enum sTVectorBaseType$Enum);

    void setBoolArray(int i2, boolean z);

    void setBoolArray(boolean[] zArr);

    void setBstrArray(int i2, String str);

    void setBstrArray(String[] strArr);

    void setClsidArray(int i2, String str);

    void setClsidArray(String[] strArr);

    void setCyArray(int i2, String str);

    void setCyArray(String[] strArr);

    void setDateArray(int i2, Calendar calendar);

    void setDateArray(Calendar[] calendarArr);

    void setErrorArray(int i2, String str);

    void setErrorArray(String[] strArr);

    void setFiletimeArray(int i2, Calendar calendar);

    void setFiletimeArray(Calendar[] calendarArr);

    void setI1Array(int i2, byte b);

    void setI1Array(byte[] bArr);

    void setI2Array(int i2, short s);

    void setI2Array(short[] sArr);

    void setI4Array(int i2, int i3);

    void setI4Array(int[] iArr);

    void setI8Array(int i2, long j2);

    void setI8Array(long[] jArr);

    void setLpstrArray(int i2, String str);

    void setLpstrArray(String[] strArr);

    void setLpwstrArray(int i2, String str);

    void setLpwstrArray(String[] strArr);

    void setR4Array(int i2, float f);

    void setR4Array(float[] fArr);

    void setR8Array(int i2, double d);

    void setR8Array(double[] dArr);

    void setSize(long j2);

    void setUi1Array(int i2, short s);

    void setUi1Array(short[] sArr);

    void setUi2Array(int i2, int i3);

    void setUi2Array(int[] iArr);

    void setUi4Array(int i2, long j2);

    void setUi4Array(long[] jArr);

    void setUi8Array(int i2, BigInteger bigInteger);

    void setUi8Array(BigInteger[] bigIntegerArr);

    void setVariantArray(int i2, CTVariant cTVariant);

    void setVariantArray(CTVariant[] cTVariantArr);

    int sizeOfBoolArray();

    int sizeOfBstrArray();

    int sizeOfClsidArray();

    int sizeOfCyArray();

    int sizeOfDateArray();

    int sizeOfErrorArray();

    int sizeOfFiletimeArray();

    int sizeOfI1Array();

    int sizeOfI2Array();

    int sizeOfI4Array();

    int sizeOfI8Array();

    int sizeOfLpstrArray();

    int sizeOfLpwstrArray();

    int sizeOfR4Array();

    int sizeOfR8Array();

    int sizeOfUi1Array();

    int sizeOfUi2Array();

    int sizeOfUi4Array();

    int sizeOfUi8Array();

    int sizeOfVariantArray();

    STVectorBaseType xgetBaseType();

    XmlBoolean xgetBoolArray(int i2);

    XmlBoolean[] xgetBoolArray();

    List<XmlBoolean> xgetBoolList();

    XmlString xgetBstrArray(int i2);

    XmlString[] xgetBstrArray();

    List<XmlString> xgetBstrList();

    STGuid xgetClsidArray(int i2);

    STGuid[] xgetClsidArray();

    List<STGuid> xgetClsidList();

    STCy xgetCyArray(int i2);

    STCy[] xgetCyArray();

    List<STCy> xgetCyList();

    XmlDateTime xgetDateArray(int i2);

    XmlDateTime[] xgetDateArray();

    List<XmlDateTime> xgetDateList();

    STError xgetErrorArray(int i2);

    STError[] xgetErrorArray();

    List<STError> xgetErrorList();

    XmlDateTime xgetFiletimeArray(int i2);

    XmlDateTime[] xgetFiletimeArray();

    List<XmlDateTime> xgetFiletimeList();

    XmlByte xgetI1Array(int i2);

    XmlByte[] xgetI1Array();

    List<XmlByte> xgetI1List();

    XmlShort xgetI2Array(int i2);

    XmlShort[] xgetI2Array();

    List<XmlShort> xgetI2List();

    XmlInt xgetI4Array(int i2);

    XmlInt[] xgetI4Array();

    List<XmlInt> xgetI4List();

    XmlLong xgetI8Array(int i2);

    XmlLong[] xgetI8Array();

    List<XmlLong> xgetI8List();

    XmlString xgetLpstrArray(int i2);

    XmlString[] xgetLpstrArray();

    List<XmlString> xgetLpstrList();

    XmlString xgetLpwstrArray(int i2);

    XmlString[] xgetLpwstrArray();

    List<XmlString> xgetLpwstrList();

    XmlFloat xgetR4Array(int i2);

    XmlFloat[] xgetR4Array();

    List<XmlFloat> xgetR4List();

    XmlDouble xgetR8Array(int i2);

    XmlDouble[] xgetR8Array();

    List<XmlDouble> xgetR8List();

    XmlUnsignedInt xgetSize();

    XmlUnsignedByte xgetUi1Array(int i2);

    XmlUnsignedByte[] xgetUi1Array();

    List<XmlUnsignedByte> xgetUi1List();

    XmlUnsignedShort xgetUi2Array(int i2);

    XmlUnsignedShort[] xgetUi2Array();

    List<XmlUnsignedShort> xgetUi2List();

    XmlUnsignedInt xgetUi4Array(int i2);

    XmlUnsignedInt[] xgetUi4Array();

    List<XmlUnsignedInt> xgetUi4List();

    XmlUnsignedLong xgetUi8Array(int i2);

    XmlUnsignedLong[] xgetUi8Array();

    List<XmlUnsignedLong> xgetUi8List();

    void xsetBaseType(STVectorBaseType sTVectorBaseType);

    void xsetBoolArray(int i2, XmlBoolean xmlBoolean);

    void xsetBoolArray(XmlBoolean[] xmlBooleanArr);

    void xsetBstrArray(int i2, XmlString xmlString);

    void xsetBstrArray(XmlString[] xmlStringArr);

    void xsetClsidArray(int i2, STGuid sTGuid);

    void xsetClsidArray(STGuid[] sTGuidArr);

    void xsetCyArray(int i2, STCy sTCy);

    void xsetCyArray(STCy[] sTCyArr);

    void xsetDateArray(int i2, XmlDateTime xmlDateTime);

    void xsetDateArray(XmlDateTime[] xmlDateTimeArr);

    void xsetErrorArray(int i2, STError sTError);

    void xsetErrorArray(STError[] sTErrorArr);

    void xsetFiletimeArray(int i2, XmlDateTime xmlDateTime);

    void xsetFiletimeArray(XmlDateTime[] xmlDateTimeArr);

    void xsetI1Array(int i2, XmlByte xmlByte);

    void xsetI1Array(XmlByte[] xmlByteArr);

    void xsetI2Array(int i2, XmlShort xmlShort);

    void xsetI2Array(XmlShort[] xmlShortArr);

    void xsetI4Array(int i2, XmlInt xmlInt);

    void xsetI4Array(XmlInt[] xmlIntArr);

    void xsetI8Array(int i2, XmlLong xmlLong);

    void xsetI8Array(XmlLong[] xmlLongArr);

    void xsetLpstrArray(int i2, XmlString xmlString);

    void xsetLpstrArray(XmlString[] xmlStringArr);

    void xsetLpwstrArray(int i2, XmlString xmlString);

    void xsetLpwstrArray(XmlString[] xmlStringArr);

    void xsetR4Array(int i2, XmlFloat xmlFloat);

    void xsetR4Array(XmlFloat[] xmlFloatArr);

    void xsetR8Array(int i2, XmlDouble xmlDouble);

    void xsetR8Array(XmlDouble[] xmlDoubleArr);

    void xsetSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetUi1Array(int i2, XmlUnsignedByte xmlUnsignedByte);

    void xsetUi1Array(XmlUnsignedByte[] xmlUnsignedByteArr);

    void xsetUi2Array(int i2, XmlUnsignedShort xmlUnsignedShort);

    void xsetUi2Array(XmlUnsignedShort[] xmlUnsignedShortArr);

    void xsetUi4Array(int i2, XmlUnsignedInt xmlUnsignedInt);

    void xsetUi4Array(XmlUnsignedInt[] xmlUnsignedIntArr);

    void xsetUi8Array(int i2, XmlUnsignedLong xmlUnsignedLong);

    void xsetUi8Array(XmlUnsignedLong[] xmlUnsignedLongArr);
}
