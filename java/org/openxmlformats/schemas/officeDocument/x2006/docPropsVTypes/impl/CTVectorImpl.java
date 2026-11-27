package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlErrorCodes;
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
import org.apache.xmlbeans.impl.values.JavaListObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVariant;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STCy;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STError;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.STVectorBaseType$Enum;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* loaded from: classes2.dex */
public class CTVectorImpl extends XmlComplexContentImpl implements CTVector {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "variant"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i1"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i2"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "i8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui1"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui2"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "ui8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r4"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "r8"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "lpwstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bstr"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", XmlErrorCodes.DATE), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "filetime"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "bool"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "cy"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "error"), new QName("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "clsid"), new QName("", "baseType"), new QName("", "size")};
    private static final long serialVersionUID = 1;

    public CTVectorImpl(SchemaType schemaType) {
        super(schemaType);
    }

    static /* synthetic */ String[] C(int i2) {
        return new String[i2];
    }

    static /* synthetic */ String[] D(int i2) {
        return new String[i2];
    }

    static /* synthetic */ String[] E(int i2) {
        return new String[i2];
    }

    static /* synthetic */ Calendar[] F(int i2) {
        return new Calendar[i2];
    }

    static /* synthetic */ String[] G(int i2) {
        return new String[i2];
    }

    static /* synthetic */ Calendar[] H(int i2) {
        return new Calendar[i2];
    }

    static /* synthetic */ String[] I(int i2) {
        return new String[i2];
    }

    static /* synthetic */ String[] J(int i2) {
        return new String[i2];
    }

    static /* synthetic */ BigInteger[] K(int i2) {
        return new BigInteger[i2];
    }

    static /* synthetic */ XmlBoolean[] L(int i2) {
        return new XmlBoolean[i2];
    }

    static /* synthetic */ XmlString[] M(int i2) {
        return new XmlString[i2];
    }

    static /* synthetic */ STGuid[] N(int i2) {
        return new STGuid[i2];
    }

    static /* synthetic */ STCy[] O(int i2) {
        return new STCy[i2];
    }

    static /* synthetic */ XmlDateTime[] P(int i2) {
        return new XmlDateTime[i2];
    }

    static /* synthetic */ STError[] Q(int i2) {
        return new STError[i2];
    }

    static /* synthetic */ XmlDateTime[] R(int i2) {
        return new XmlDateTime[i2];
    }

    static /* synthetic */ XmlByte[] S(int i2) {
        return new XmlByte[i2];
    }

    static /* synthetic */ XmlShort[] T(int i2) {
        return new XmlShort[i2];
    }

    static /* synthetic */ XmlInt[] U(int i2) {
        return new XmlInt[i2];
    }

    static /* synthetic */ XmlLong[] V(int i2) {
        return new XmlLong[i2];
    }

    static /* synthetic */ XmlString[] W(int i2) {
        return new XmlString[i2];
    }

    static /* synthetic */ XmlString[] X(int i2) {
        return new XmlString[i2];
    }

    static /* synthetic */ XmlFloat[] Y(int i2) {
        return new XmlFloat[i2];
    }

    static /* synthetic */ XmlDouble[] Z(int i2) {
        return new XmlDouble[i2];
    }

    static /* synthetic */ XmlUnsignedByte[] a0(int i2) {
        return new XmlUnsignedByte[i2];
    }

    static /* synthetic */ XmlUnsignedShort[] b0(int i2) {
        return new XmlUnsignedShort[i2];
    }

    static /* synthetic */ XmlUnsignedInt[] c0(int i2) {
        return new XmlUnsignedInt[i2];
    }

    static /* synthetic */ XmlUnsignedLong[] d0(int i2) {
        return new XmlUnsignedLong[i2];
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addBool(boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[16])).setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addBstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[13])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addClsid(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[19])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addCy(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[17])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addDate(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[14])).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addError(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[18])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addFiletime(Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[15])).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI1(byte b) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[1])).setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI2(short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[2])).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI4(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[3])).setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addI8(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[4])).setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addLpstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[11])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addLpwstr(String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[12])).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean addNewBool() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewBstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STGuid addNewClsid() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy addNewCy() {
        STCy sTCyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return sTCyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime addNewDate() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError addNewError() {
        STError sTErrorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTErrorAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return sTErrorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime addNewFiletime() {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte addNewI1() {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort addNewI2() {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt addNewI4() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong addNewI8() {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewLpstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString addNewLpwstr() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat addNewR4() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble addNewR8() {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte addNewUi1() {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort addNewUi2() {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt addNewUi4() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong addNewUi8() {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant addNewVariant() {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addR4(float f) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[9])).setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addR8(double d) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[10])).setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi1(short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[5])).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi2(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[6])).setIntValue(i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi4(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[7])).setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void addUi8(BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().add_element_user(PROPERTY_QNAME[8])).setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STVectorBaseType$Enum getBaseType() {
        STVectorBaseType$Enum sTVectorBaseType$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[20]);
            sTVectorBaseType$Enum = simpleValue == null ? null : (STVectorBaseType$Enum) simpleValue.getEnumValue();
        }
        return sTVectorBaseType$Enum;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public boolean[] getBoolArray() {
        return getBooleanArray(PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Boolean> getBoolList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(this.a.getBoolArray(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setBoolArray(((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertBool(((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                }
            }, new e3(this), new d2(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getBstrArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[13], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.C(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getBstrList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.q2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setBstrArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertBstr(((Integer) obj).intValue(), (String) obj2);
                }
            }, new s3(this), new e4(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getClsidArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[19], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.D(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getClsidList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getClsidArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setClsidArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertClsid(((Integer) obj).intValue(), (String) obj2);
                }
            }, new f(this), new a2(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getCyArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[17], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.v0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.E(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getCyList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.q1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setCyArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertCy(((Integer) obj).intValue(), (String) obj2);
                }
            }, new m1(this), new y3(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar[] getDateArray() {
        return (Calendar[]) getObjectArray(PROPERTY_QNAME[14], i3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.q0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.F(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Calendar> getDateList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.a1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDateArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setDateArray(((Integer) obj).intValue(), (Calendar) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.n
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertDate(((Integer) obj).intValue(), (Calendar) obj2);
                }
            }, new f1(this), new n3(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getErrorArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[18], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.G(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getErrorList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getErrorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setErrorArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertError(((Integer) obj).intValue(), (String) obj2);
                }
            }, new h3(this), new t4(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar[] getFiletimeArray() {
        return (Calendar[]) getObjectArray(PROPERTY_QNAME[15], i3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.v
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.H(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Calendar> getFiletimeList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFiletimeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setFiletimeArray(((Integer) obj).intValue(), (Calendar) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertFiletime(((Integer) obj).intValue(), (Calendar) obj2);
                }
            }, new l4(this), new y0(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public byte[] getI1Array() {
        return getByteArray(PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Byte> getI1List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Byte.valueOf(this.a.getI1Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.q
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setI1Array(((Integer) obj).intValue(), ((Byte) obj2).byteValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertI1(((Integer) obj).intValue(), ((Byte) obj2).byteValue());
                }
            }, new z5(this), new e(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short[] getI2Array() {
        return getShortArray(PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Short> getI2List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Short.valueOf(this.a.getI2Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setI2Array(((Integer) obj).intValue(), ((Short) obj2).shortValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertI2(((Integer) obj).intValue(), ((Short) obj2).shortValue());
                }
            }, new g4(this), new i(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int[] getI4Array() {
        return getIntArray(PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Integer> getI4List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(this.a.getI4Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setI4Array(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertI4(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            }, new n4(this), new v4(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long[] getI8Array() {
        return getLongArray(PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Long> getI8List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.i1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(this.a.getI8Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setI8Array(((Integer) obj).intValue(), ((Long) obj2).longValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertI8(((Integer) obj).intValue(), ((Long) obj2).longValue());
                }
            }, new z3(this), new a6(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getLpstrArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[11], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.I(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getLpstrList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLpstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setLpstrArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertLpstr(((Integer) obj).intValue(), (String) obj2);
                }
            }, new p2(this), new v1(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String[] getLpwstrArray() {
        return (String[]) getObjectArray(PROPERTY_QNAME[12], a3.a, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.J(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<String> getLpwstrList() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLpwstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setLpwstrArray(((Integer) obj).intValue(), (String) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertLpwstr(((Integer) obj).intValue(), (String) obj2);
                }
            }, new n1(this), new q3(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public float[] getR4Array() {
        return getFloatArray(PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Float> getR4List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Float.valueOf(this.a.getR4Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setR4Array(((Integer) obj).intValue(), ((Float) obj2).floatValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.q4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertR4(((Integer) obj).intValue(), ((Float) obj2).floatValue());
                }
            }, new r(this), new y2(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public double[] getR8Array() {
        return getDoubleArray(PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Double> getR8List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Double.valueOf(this.a.getR8Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setR8Array(((Integer) obj).intValue(), ((Double) obj2).doubleValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.v3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertR8(((Integer) obj).intValue(), ((Double) obj2).doubleValue());
                }
            }, new o2(this), new o1(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getSize() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[21]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short[] getUi1Array() {
        return getShortArray(PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Short> getUi1List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Short.valueOf(this.a.getUi1Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setUi1Array(((Integer) obj).intValue(), ((Short) obj2).shortValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertUi1(((Integer) obj).intValue(), ((Short) obj2).shortValue());
                }
            }, new m(this), new x4(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int[] getUi2Array() {
        return getIntArray(PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Integer> getUi2List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(this.a.getUi2Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setUi2Array(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertUi2(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            }, new f2(this), new n5(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long[] getUi4Array() {
        return getLongArray(PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<Long> getUi4List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.m3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(this.a.getUi4Array(((Integer) obj).intValue()));
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setUi4Array(((Integer) obj).intValue(), ((Long) obj2).longValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertUi4(((Integer) obj).intValue(), ((Long) obj2).longValue());
                }
            }, new a(this), new u4(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public BigInteger[] getUi8Array() {
        return (BigInteger[]) getObjectArray(PROPERTY_QNAME[8], new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((SimpleValue) obj).getBigIntegerValue();
            }
        }, new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.K(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<BigInteger> getUi8List() {
        JavaListObject javaListObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListObject = new JavaListObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.k3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getUi8Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.a5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.setUi8Array(((Integer) obj).intValue(), (BigInteger) obj2);
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.insertUi8(((Integer) obj).intValue(), (BigInteger) obj2);
                }
            }, new c(this), new q5(this));
        }
        return javaListObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant[] getVariantArray() {
        return (CTVariant[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTVariant[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<CTVariant> getVariantList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getVariantArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setVariantArray(((Integer) obj).intValue(), (CTVariant) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewVariant(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeVariant(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfVariantArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertBool(int i2, boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[16], i2)).setBooleanValue(z);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertBstr(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[13], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertClsid(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[19], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertCy(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[17], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertDate(int i2, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[14], i2)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertError(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[18], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertFiletime(int i2, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[15], i2)).setCalendarValue(calendar);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI1(int i2, byte b) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[1], i2)).setByteValue(b);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI2(int i2, short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[2], i2)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI4(int i2, int i3) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[3], i2)).setIntValue(i3);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertI8(int i2, long j2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[4], i2)).setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertLpstr(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[11], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertLpwstr(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[12], i2)).setStringValue(str);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean insertNewBool(int i2) {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewBstr(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STGuid insertNewClsid(int i2) {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().insert_element_user(PROPERTY_QNAME[19], i2);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy insertNewCy(int i2) {
        STCy sTCyInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCyInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return sTCyInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime insertNewDate(int i2) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError insertNewError(int i2) {
        STError sTErrorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTErrorInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return sTErrorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime insertNewFiletime(int i2) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte insertNewI1(int i2) {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort insertNewI2(int i2) {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt insertNewI4(int i2) {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong insertNewI8(int i2) {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewLpstr(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString insertNewLpwstr(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat insertNewR4(int i2) {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble insertNewR8(int i2) {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte insertNewUi1(int i2) {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort insertNewUi2(int i2) {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt insertNewUi4(int i2) {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong insertNewUi8(int i2) {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant insertNewVariant(int i2) {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertR4(int i2, float f) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[9], i2)).setFloatValue(f);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertR8(int i2, double d) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[10], i2)).setDoubleValue(d);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi1(int i2, short s) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[5], i2)).setShortValue(s);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi2(int i2, int i3) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[6], i2)).setIntValue(i3);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi4(int i2, long j2) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[7], i2)).setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void insertUi8(int i2, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            ((SimpleValue) get_store().insert_element_user(PROPERTY_QNAME[8], i2)).setBigIntegerValue(bigInteger);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeBool(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeBstr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeClsid(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeCy(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeDate(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeError(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeFiletime(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI1(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI2(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI4(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeI8(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeLpstr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeLpwstr(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeR4(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeR8(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi1(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi2(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi4(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeUi8(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void removeVariant(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBaseType(STVectorBaseType$Enum sTVectorBaseType$Enum) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
            }
            simpleValue.setEnumValue(sTVectorBaseType$Enum);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBoolArray(boolean[] zArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(zArr, PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setClsidArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCyArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setDateArray(Calendar[] calendarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(calendarArr, PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setErrorArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setFiletimeArray(Calendar[] calendarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(calendarArr, PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI1Array(byte[] bArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bArr, PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI2Array(short[] sArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI4Array(int[] iArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(iArr, PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI8Array(long[] jArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(jArr, PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpwstrArray(String[] strArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(strArr, PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR4Array(float[] fArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(fArr, PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR8Array(double[] dArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(dArr, PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setSize(long j2) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[21]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[21]);
            }
            simpleValue.setLongValue(j2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi1Array(short[] sArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sArr, PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi2Array(int[] iArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(iArr, PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi4Array(long[] jArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(jArr, PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi8Array(BigInteger[] bigIntegerArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(bigIntegerArr, PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setVariantArray(CTVariant[] cTVariantArr) {
        check_orphaned();
        arraySetterHelper(cTVariantArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfBoolArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfBstrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfClsidArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfCyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfDateArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfErrorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfFiletimeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI1Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI4Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfI8Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfLpstrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfLpwstrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfR4Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfR8Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi1Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi4Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfUi8Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int sizeOfVariantArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STVectorBaseType xgetBaseType() {
        STVectorBaseType sTVectorBaseTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVectorBaseTypeFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[20]);
        }
        return sTVectorBaseTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean[] xgetBoolArray() {
        return (XmlBoolean[]) xgetArray(PROPERTY_QNAME[16], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.L(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlBoolean> xgetBoolList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.z2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetBoolArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetBoolArray(((Integer) obj).intValue(), (XmlBoolean) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.f5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBool(((Integer) obj).intValue());
                }
            }, new e3(this), new d2(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetBstrArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[13], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.i0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.M(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetBstrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetBstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetBstrArray(((Integer) obj).intValue(), (XmlString) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewBstr(((Integer) obj).intValue());
                }
            }, new s3(this), new e4(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STGuid[] xgetClsidArray() {
        return (STGuid[]) xgetArray(PROPERTY_QNAME[19], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.N(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STGuid> xgetClsidList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.m4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetClsidArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetClsidArray(((Integer) obj).intValue(), (STGuid) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.f4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewClsid(((Integer) obj).intValue());
                }
            }, new f(this), new a2(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy[] xgetCyArray() {
        return xgetArray(PROPERTY_QNAME[17], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.y
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.O(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STCy> xgetCyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.e6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetCyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.f3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetCyArray(((Integer) obj).intValue(), (STCy) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.e2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCy(((Integer) obj).intValue());
                }
            }, new m1(this), new y3(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime[] xgetDateArray() {
        return (XmlDateTime[]) xgetArray(PROPERTY_QNAME[14], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.P(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDateTime> xgetDateList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.x3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetDateArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetDateArray(((Integer) obj).intValue(), (XmlDateTime) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDate(((Integer) obj).intValue());
                }
            }, new f1(this), new n3(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError[] xgetErrorArray() {
        return xgetArray(PROPERTY_QNAME[18], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.t0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.Q(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<STError> xgetErrorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetErrorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.v2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetErrorArray(((Integer) obj).intValue(), (STError) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewError(((Integer) obj).intValue());
                }
            }, new h3(this), new t4(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime[] xgetFiletimeArray() {
        return (XmlDateTime[]) xgetArray(PROPERTY_QNAME[15], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.n0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.R(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDateTime> xgetFiletimeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.m5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetFiletimeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetFiletimeArray(((Integer) obj).intValue(), (XmlDateTime) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFiletime(((Integer) obj).intValue());
                }
            }, new l4(this), new y0(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte[] xgetI1Array() {
        return (XmlByte[]) xgetArray(PROPERTY_QNAME[1], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.f0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.S(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlByte> xgetI1List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.f6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetI1Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.z4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetI1Array(((Integer) obj).intValue(), (XmlByte) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.a4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI1(((Integer) obj).intValue());
                }
            }, new z5(this), new e(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort[] xgetI2Array() {
        return (XmlShort[]) xgetArray(PROPERTY_QNAME[2], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.a0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.T(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlShort> xgetI2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetI2Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetI2Array(((Integer) obj).intValue(), (XmlShort) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI2(((Integer) obj).intValue());
                }
            }, new g4(this), new i(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt[] xgetI4Array() {
        return (XmlInt[]) xgetArray(PROPERTY_QNAME[3], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.U(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlInt> xgetI4List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.i5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetI4Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.v5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetI4Array(((Integer) obj).intValue(), (XmlInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI4(((Integer) obj).intValue());
                }
            }, new n4(this), new v4(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong[] xgetI8Array() {
        return (XmlLong[]) xgetArray(PROPERTY_QNAME[4], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.V(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlLong> xgetI8List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetI8Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.w5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetI8Array(((Integer) obj).intValue(), (XmlLong) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.y5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI8(((Integer) obj).intValue());
                }
            }, new z3(this), new a6(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetLpstrArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[11], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.W(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetLpstrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.r3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetLpstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.o5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetLpstrArray(((Integer) obj).intValue(), (XmlString) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.n2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLpstr(((Integer) obj).intValue());
                }
            }, new p2(this), new v1(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString[] xgetLpwstrArray() {
        return (XmlString[]) xgetArray(PROPERTY_QNAME[12], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.m0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.X(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlString> xgetLpwstrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.e5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetLpwstrArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.i4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetLpwstrArray(((Integer) obj).intValue(), (XmlString) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.o4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLpwstr(((Integer) obj).intValue());
                }
            }, new n1(this), new q3(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat[] xgetR4Array() {
        return (XmlFloat[]) xgetArray(PROPERTY_QNAME[9], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.o0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.Y(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlFloat> xgetR4List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.m2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetR4Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.g1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetR4Array(((Integer) obj).intValue(), (XmlFloat) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR4(((Integer) obj).intValue());
                }
            }, new r(this), new y2(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble[] xgetR8Array() {
        return (XmlDouble[]) xgetArray(PROPERTY_QNAME[10], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.e0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.Z(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlDouble> xgetR8List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.i2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetR8Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.z1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetR8Array(((Integer) obj).intValue(), (XmlDouble) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.e1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewR8(((Integer) obj).intValue());
                }
            }, new o2(this), new o1(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt xgetSize() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[21]);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte[] xgetUi1Array() {
        return (XmlUnsignedByte[]) xgetArray(PROPERTY_QNAME[5], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.p0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.a0(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedByte> xgetUi1List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetUi1Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.j3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetUi1Array(((Integer) obj).intValue(), (XmlUnsignedByte) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.y1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewUi1(((Integer) obj).intValue());
                }
            }, new m(this), new x4(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort[] xgetUi2Array() {
        return (XmlUnsignedShort[]) xgetArray(PROPERTY_QNAME[6], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.z
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.b0(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedShort> xgetUi2List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.o
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetUi2Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.s1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetUi2Array(((Integer) obj).intValue(), (XmlUnsignedShort) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.u3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewUi2(((Integer) obj).intValue());
                }
            }, new f2(this), new n5(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt[] xgetUi4Array() {
        return (XmlUnsignedInt[]) xgetArray(PROPERTY_QNAME[7], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.c0(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedInt> xgetUi4List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.h4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetUi4Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.o3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetUi4Array(((Integer) obj).intValue(), (XmlUnsignedInt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.d5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewUi4(((Integer) obj).intValue());
                }
            }, new a(this), new u4(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong[] xgetUi8Array() {
        return (XmlUnsignedLong[]) xgetArray(PROPERTY_QNAME[8], new IntFunction() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.c0
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return CTVectorImpl.d0(i2);
            }
        });
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public List<XmlUnsignedLong> xgetUi8List() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.z0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.xgetUi8Array(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.l
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.a.xsetUi8Array(((Integer) obj).intValue(), (XmlUnsignedLong) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.y4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewUi8(((Integer) obj).intValue());
                }
            }, new c(this), new q5(this));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBaseType(STVectorBaseType sTVectorBaseType) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            STVectorBaseType sTVectorBaseTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[20]);
            if (sTVectorBaseTypeFind_attribute_user == null) {
                sTVectorBaseTypeFind_attribute_user = (STVectorBaseType) get_store().add_attribute_user(qNameArr[20]);
            }
            sTVectorBaseTypeFind_attribute_user.set(sTVectorBaseType);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBoolArray(XmlBoolean[] xmlBooleanArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlBooleanArr, PROPERTY_QNAME[16]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[13]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetClsidArray(STGuid[] sTGuidArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(sTGuidArr, PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetCyArray(STCy[] sTCyArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) sTCyArr, PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetDateArray(XmlDateTime[] xmlDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDateTimeArr, PROPERTY_QNAME[14]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetErrorArray(STError[] sTErrorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) sTErrorArr, PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetFiletimeArray(XmlDateTime[] xmlDateTimeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDateTimeArr, PROPERTY_QNAME[15]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI1Array(XmlByte[] xmlByteArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlByteArr, PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI2Array(XmlShort[] xmlShortArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlShortArr, PROPERTY_QNAME[2]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI4Array(XmlInt[] xmlIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlIntArr, PROPERTY_QNAME[3]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI8Array(XmlLong[] xmlLongArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlLongArr, PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[11]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpwstrArray(XmlString[] xmlStringArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlStringArr, PROPERTY_QNAME[12]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR4Array(XmlFloat[] xmlFloatArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlFloatArr, PROPERTY_QNAME[9]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR8Array(XmlDouble[] xmlDoubleArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlDoubleArr, PROPERTY_QNAME[10]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetSize(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[21]);
            if (xmlUnsignedInt2 == null) {
                xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[21]);
            }
            xmlUnsignedInt2.set(xmlUnsignedInt);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi1Array(XmlUnsignedByte[] xmlUnsignedByteArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedByteArr, PROPERTY_QNAME[5]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi2Array(XmlUnsignedShort[] xmlUnsignedShortArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedShortArr, PROPERTY_QNAME[6]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi4Array(XmlUnsignedInt[] xmlUnsignedIntArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedIntArr, PROPERTY_QNAME[7]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi8Array(XmlUnsignedLong[] xmlUnsignedLongArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(xmlUnsignedLongArr, PROPERTY_QNAME[8]);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public boolean getBoolArray(int i2) {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            booleanValue = simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getBstrArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getClsidArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getCyArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar getDateArray(int i2) {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            calendarValue = simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getErrorArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public Calendar getFiletimeArray(int i2) {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            calendarValue = simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public byte getI1Array(int i2) {
        byte byteValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            byteValue = simpleValue.getByteValue();
        }
        return byteValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short getI2Array(int i2) {
        short shortValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            shortValue = simpleValue.getShortValue();
        }
        return shortValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int getI4Array(int i2) {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            intValue = simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getI8Array(int i2) {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            longValue = simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getLpstrArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public String getLpwstrArray(int i2) {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            stringValue = simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public float getR4Array(int i2) {
        float floatValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            floatValue = simpleValue.getFloatValue();
        }
        return floatValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public double getR8Array(int i2) {
        double doubleValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            doubleValue = simpleValue.getDoubleValue();
        }
        return doubleValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public short getUi1Array(int i2) {
        short shortValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            shortValue = simpleValue.getShortValue();
        }
        return shortValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public int getUi2Array(int i2) {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            intValue = simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public long getUi4Array(int i2) {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            longValue = simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public BigInteger getUi8Array(int i2) {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (simpleValue == null) {
                throw new IndexOutOfBoundsException();
            }
            bigIntegerValue = simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public CTVariant getVariantArray(int i2) {
        CTVariant cTVariant;
        synchronized (monitor()) {
            check_orphaned();
            cTVariant = (CTVariant) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTVariant == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVariant;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlBoolean xgetBoolArray(int i2) {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (xmlBoolean == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetBstrArray(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STGuid xgetClsidArray(int i2) {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (sTGuid == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STCy xgetCyArray(int i2) {
        STCy sTCyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTCyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (sTCyFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTCyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime xgetDateArray(int i2) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (xmlDateTime == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public STError xgetErrorArray(int i2) {
        STError sTErrorFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTErrorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (sTErrorFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return sTErrorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDateTime xgetFiletimeArray(int i2) {
        XmlDateTime xmlDateTime;
        synchronized (monitor()) {
            check_orphaned();
            xmlDateTime = (XmlDateTime) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (xmlDateTime == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDateTime;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlByte xgetI1Array(int i2) {
        XmlByte xmlByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlByte = (XmlByte) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (xmlByte == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlShort xgetI2Array(int i2) {
        XmlShort xmlShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlShort = (XmlShort) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (xmlShort == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlInt xgetI4Array(int i2) {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (xmlInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlLong xgetI8Array(int i2) {
        XmlLong xmlLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlLong = (XmlLong) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (xmlLong == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetLpstrArray(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlString xgetLpwstrArray(int i2) {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (xmlString == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlFloat xgetR4Array(int i2) {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (xmlFloat == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlFloat;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlDouble xgetR8Array(int i2) {
        XmlDouble xmlDouble;
        synchronized (monitor()) {
            check_orphaned();
            xmlDouble = (XmlDouble) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (xmlDouble == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlDouble;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedByte xgetUi1Array(int i2) {
        XmlUnsignedByte xmlUnsignedByte;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedByte = (XmlUnsignedByte) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (xmlUnsignedByte == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedByte;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedShort xgetUi2Array(int i2) {
        XmlUnsignedShort xmlUnsignedShort;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedShort = (XmlUnsignedShort) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (xmlUnsignedShort == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedShort;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedInt xgetUi4Array(int i2) {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (xmlUnsignedInt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public XmlUnsignedLong xgetUi8Array(int i2) {
        XmlUnsignedLong xmlUnsignedLong;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedLong = (XmlUnsignedLong) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (xmlUnsignedLong == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return xmlUnsignedLong;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setVariantArray(int i2, CTVariant cTVariant) throws Throwable {
        generatedSetterHelperImpl(cTVariant, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBoolArray(int i2, boolean z) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (simpleValue != null) {
                simpleValue.setBooleanValue(z);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setBstrArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setClsidArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setCyArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setDateArray(int i2, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (simpleValue != null) {
                simpleValue.setCalendarValue(calendar);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setErrorArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setFiletimeArray(int i2, Calendar calendar) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (simpleValue != null) {
                simpleValue.setCalendarValue(calendar);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI1Array(int i2, byte b) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (simpleValue != null) {
                simpleValue.setByteValue(b);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI2Array(int i2, short s) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (simpleValue != null) {
                simpleValue.setShortValue(s);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI4Array(int i2, int i3) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (simpleValue != null) {
                simpleValue.setIntValue(i3);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setI8Array(int i2, long j2) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (simpleValue != null) {
                simpleValue.setLongValue(j2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpstrArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setLpwstrArray(int i2, String str) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (simpleValue != null) {
                simpleValue.setStringValue(str);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR4Array(int i2, float f) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (simpleValue != null) {
                simpleValue.setFloatValue(f);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setR8Array(int i2, double d) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (simpleValue != null) {
                simpleValue.setDoubleValue(d);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi1Array(int i2, short s) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (simpleValue != null) {
                simpleValue.setShortValue(s);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi2Array(int i2, int i3) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (simpleValue != null) {
                simpleValue.setIntValue(i3);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi4Array(int i2, long j2) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (simpleValue != null) {
                simpleValue.setLongValue(j2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void setUi8Array(int i2, BigInteger bigInteger) {
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (simpleValue != null) {
                simpleValue.setBigIntegerValue(bigInteger);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBoolArray(int i2, XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            check_orphaned();
            XmlBoolean xmlBoolean2 = (XmlBoolean) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (xmlBoolean2 != null) {
                xmlBoolean2.set(xmlBoolean);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetBstrArray(int i2, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (xmlString2 != null) {
                xmlString2.set(xmlString);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetClsidArray(int i2, STGuid sTGuid) {
        synchronized (monitor()) {
            check_orphaned();
            STGuid sTGuid2 = (STGuid) get_store().find_element_user(PROPERTY_QNAME[19], i2);
            if (sTGuid2 != null) {
                sTGuid2.set(sTGuid);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetCyArray(int i2, STCy sTCy) {
        synchronized (monitor()) {
            check_orphaned();
            STCy sTCyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (sTCyFind_element_user != null) {
                sTCyFind_element_user.set(sTCy);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetDateArray(int i2, XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDateTime xmlDateTime2 = (XmlDateTime) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (xmlDateTime2 != null) {
                xmlDateTime2.set(xmlDateTime);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetErrorArray(int i2, STError sTError) {
        synchronized (monitor()) {
            check_orphaned();
            STError sTErrorFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (sTErrorFind_element_user != null) {
                sTErrorFind_element_user.set(sTError);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetFiletimeArray(int i2, XmlDateTime xmlDateTime) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDateTime xmlDateTime2 = (XmlDateTime) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (xmlDateTime2 != null) {
                xmlDateTime2.set(xmlDateTime);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI1Array(int i2, XmlByte xmlByte) {
        synchronized (monitor()) {
            check_orphaned();
            XmlByte xmlByte2 = (XmlByte) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (xmlByte2 != null) {
                xmlByte2.set(xmlByte);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI2Array(int i2, XmlShort xmlShort) {
        synchronized (monitor()) {
            check_orphaned();
            XmlShort xmlShort2 = (XmlShort) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (xmlShort2 != null) {
                xmlShort2.set(xmlShort);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI4Array(int i2, XmlInt xmlInt) {
        synchronized (monitor()) {
            check_orphaned();
            XmlInt xmlInt2 = (XmlInt) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (xmlInt2 != null) {
                xmlInt2.set(xmlInt);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetI8Array(int i2, XmlLong xmlLong) {
        synchronized (monitor()) {
            check_orphaned();
            XmlLong xmlLong2 = (XmlLong) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (xmlLong2 != null) {
                xmlLong2.set(xmlLong);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpstrArray(int i2, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (xmlString2 != null) {
                xmlString2.set(xmlString);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetLpwstrArray(int i2, XmlString xmlString) {
        synchronized (monitor()) {
            check_orphaned();
            XmlString xmlString2 = (XmlString) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (xmlString2 != null) {
                xmlString2.set(xmlString);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR4Array(int i2, XmlFloat xmlFloat) {
        synchronized (monitor()) {
            check_orphaned();
            XmlFloat xmlFloat2 = (XmlFloat) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (xmlFloat2 != null) {
                xmlFloat2.set(xmlFloat);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetR8Array(int i2, XmlDouble xmlDouble) {
        synchronized (monitor()) {
            check_orphaned();
            XmlDouble xmlDouble2 = (XmlDouble) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (xmlDouble2 != null) {
                xmlDouble2.set(xmlDouble);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi1Array(int i2, XmlUnsignedByte xmlUnsignedByte) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedByte xmlUnsignedByte2 = (XmlUnsignedByte) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (xmlUnsignedByte2 != null) {
                xmlUnsignedByte2.set(xmlUnsignedByte);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi2Array(int i2, XmlUnsignedShort xmlUnsignedShort) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedShort xmlUnsignedShort2 = (XmlUnsignedShort) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (xmlUnsignedShort2 != null) {
                xmlUnsignedShort2.set(xmlUnsignedShort);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi4Array(int i2, XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (xmlUnsignedInt2 != null) {
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector
    public void xsetUi8Array(int i2, XmlUnsignedLong xmlUnsignedLong) {
        synchronized (monitor()) {
            check_orphaned();
            XmlUnsignedLong xmlUnsignedLong2 = (XmlUnsignedLong) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (xmlUnsignedLong2 != null) {
                xmlUnsignedLong2.set(xmlUnsignedLong);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}
