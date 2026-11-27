package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* loaded from: classes2.dex */
public interface CTProtectedRange extends XmlObject {
    public static final DocumentFactory<CTProtectedRange> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTProtectedRange> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctprotectedrange7078type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    XmlString addNewSecurityDescriptor();

    void addSecurityDescriptor(String str);

    String getAlgorithmName();

    byte[] getHashValue();

    String getName();

    byte[] getPassword();

    byte[] getSaltValue();

    String getSecurityDescriptor2();

    String getSecurityDescriptorArray(int i2);

    String[] getSecurityDescriptorArray();

    List<String> getSecurityDescriptorList();

    long getSpinCount();

    List getSqref();

    XmlString insertNewSecurityDescriptor(int i2);

    void insertSecurityDescriptor(int i2, String str);

    boolean isSetAlgorithmName();

    boolean isSetHashValue();

    boolean isSetPassword();

    boolean isSetSaltValue();

    boolean isSetSecurityDescriptor2();

    boolean isSetSpinCount();

    void removeSecurityDescriptor(int i2);

    void setAlgorithmName(String str);

    void setHashValue(byte[] bArr);

    void setName(String str);

    void setPassword(byte[] bArr);

    void setSaltValue(byte[] bArr);

    void setSecurityDescriptor2(String str);

    void setSecurityDescriptorArray(int i2, String str);

    void setSecurityDescriptorArray(String[] strArr);

    void setSpinCount(long j2);

    void setSqref(List list);

    int sizeOfSecurityDescriptorArray();

    void unsetAlgorithmName();

    void unsetHashValue();

    void unsetPassword();

    void unsetSaltValue();

    void unsetSecurityDescriptor2();

    void unsetSpinCount();

    STXstring xgetAlgorithmName();

    XmlBase64Binary xgetHashValue();

    STXstring xgetName();

    STUnsignedShortHex xgetPassword();

    XmlBase64Binary xgetSaltValue();

    XmlString xgetSecurityDescriptor2();

    XmlString xgetSecurityDescriptorArray(int i2);

    XmlString[] xgetSecurityDescriptorArray();

    List<XmlString> xgetSecurityDescriptorList();

    XmlUnsignedInt xgetSpinCount();

    STSqref xgetSqref();

    void xsetAlgorithmName(STXstring sTXstring);

    void xsetHashValue(XmlBase64Binary xmlBase64Binary);

    void xsetName(STXstring sTXstring);

    void xsetPassword(STUnsignedShortHex sTUnsignedShortHex);

    void xsetSaltValue(XmlBase64Binary xmlBase64Binary);

    void xsetSecurityDescriptor2(XmlString xmlString);

    void xsetSecurityDescriptorArray(int i2, XmlString xmlString);

    void xsetSecurityDescriptorArray(XmlString[] xmlStringArr);

    void xsetSpinCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetSqref(STSqref sTSqref);
}
