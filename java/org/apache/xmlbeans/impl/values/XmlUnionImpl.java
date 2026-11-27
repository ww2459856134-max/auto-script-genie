package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;

/* loaded from: classes2.dex */
public class XmlUnionImpl extends XmlObjectBase implements XmlAnySimpleType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int JAVA_BYTEARRAY = 50;
    private static final int JAVA_CALENDAR = 49;
    private static final int JAVA_DATE = 48;
    private static final int JAVA_LIST = 51;
    private static final int JAVA_NUMBER = 47;
    private final SchemaType _schemaType;
    private String _textvalue = "";
    private XmlAnySimpleType _value;

    public XmlUnionImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    private static boolean check(XmlObject xmlObject, SchemaType schemaType) {
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues == null) {
            return true;
        }
        for (XmlAnySimpleType xmlAnySimpleType : enumerationValues) {
            if (xmlAnySimpleType.valueEquals(xmlObject)) {
                return true;
            }
        }
        return false;
    }

    private static boolean logical_overlap(SchemaType schemaType, int i2) {
        if (i2 <= 46) {
            return schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == i2;
        }
        switch (i2) {
            case 47:
                if (schemaType.getSimpleVariety() == 1) {
                    int builtinTypeCode = schemaType.getPrimitiveType().getBuiltinTypeCode();
                    if (builtinTypeCode != 18 && builtinTypeCode != 20 && builtinTypeCode != 21) {
                        switch (builtinTypeCode) {
                        }
                    }
                }
                break;
            case 48:
                if (schemaType.getSimpleVariety() == 1) {
                    int builtinTypeCode2 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                    if (builtinTypeCode2 == 14 || builtinTypeCode2 == 16) {
                    }
                }
                break;
            case 49:
                if (schemaType.getSimpleVariety() == 1) {
                    switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                    }
                }
                break;
            case 50:
                if (schemaType.getSimpleVariety() == 1) {
                    int builtinTypeCode3 = schemaType.getPrimitiveType().getBuiltinTypeCode();
                    if (builtinTypeCode3 == 4 || builtinTypeCode3 == 5) {
                    }
                }
                break;
            case 51:
                if (schemaType.getSimpleVariety() != 3) {
                    break;
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        r9._value = r10;
        r9._textvalue = r10.getStringValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026 A[Catch: all -> 0x006b, TryCatch #1 {all -> 0x006b, blocks: (B:8:0x0020, B:10:0x0026, B:12:0x002a, B:14:0x0032, B:15:0x0038), top: B:33:0x0020 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void set_primitive(int i2, Object obj) {
        boolean z;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        boolean z2 = true;
        loop0: while (true) {
            if (!z2) {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (SchemaType schemaType : unionConstituentTypes) {
                        if (logical_overlap(schemaType, i2)) {
                            try {
                                XmlAnySimpleType xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(obj, z2);
                                break loop0;
                            } catch (XmlValueOutOfRangeException | Exception unused) {
                                continue;
                            }
                        }
                    }
                    if (!z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } finally {
                    if (z) {
                        NamespaceContext.pop();
                    }
                }
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{obj.toString(), QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return this._textvalue;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return this._value.valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        return xmlAnySimpleType != null && ((SimpleValue) xmlAnySimpleType).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (byte) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getByteValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0d;
        }
        return ((SimpleValue) xmlAnySimpleType).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getEnumValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0.0f;
        }
        return ((SimpleValue) xmlAnySimpleType).getFloatValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDateValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getIntValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return 0L;
        }
        return ((SimpleValue) xmlAnySimpleType).getLongValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).getQNameValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return (short) 0;
        }
        return ((SimpleValue) xmlAnySimpleType).getShortValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return xmlAnySimpleType.getStringValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).instanceType();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            XmlAnySimpleType xmlAnySimpleType = this._value;
            set_text(str);
            this._value = xmlAnySimpleType;
            return false;
        } catch (XmlValueOutOfRangeException unused) {
            return true;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigDecimal(BigDecimal bigDecimal) {
        set_primitive(47, bigDecimal);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_BigInteger(BigInteger bigInteger) {
        set_primitive(47, bigInteger);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_ByteArray(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Calendar(Calendar calendar) {
        set_primitive(49, calendar);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_Date(Date date) {
        set_primitive(48, date);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDate(GDateSpecification gDateSpecification) {
        int builtinTypeCode = gDateSpecification.getBuiltinTypeCode();
        if (builtinTypeCode <= 0) {
            throw new XmlValueOutOfRangeException();
        }
        set_primitive(builtinTypeCode, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_GDuration(GDurationSpecification gDurationSpecification) {
        set_primitive(13, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_QName(QName qName) {
        set_primitive(7, qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_b64(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_boolean(boolean z) {
        set_primitive(3, Boolean.valueOf(z));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_byte(byte b) {
        set_primitive(47, Byte.valueOf(b));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_double(double d) {
        set_primitive(47, Double.valueOf(d));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_enum(StringEnumAbstractBase stringEnumAbstractBase) {
        set_primitive(12, stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_float(float f) {
        set_primitive(47, Float.valueOf(f));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_hex(byte[] bArr) {
        set_primitive(50, bArr);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_int(int i2) {
        set_primitive(47, Integer.valueOf(i2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_list(List<?> list) {
        set_primitive(51, list);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_long(long j2) {
        set_primitive(47, Long.valueOf(j2));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
        this._textvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_short(short s) {
        set_primitive(47, Short.valueOf(s));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:15:0x004d, B:17:0x0053, B:19:0x0057, B:20:0x0059, B:23:0x0068, B:28:0x0071, B:29:0x0087), top: B:42:0x004d, inners: #3 }] */
    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void set_text(String str) {
        boolean z;
        XmlAnySimpleType xmlAnySimpleTypeNewValue;
        if (!this._schemaType.matchPatternFacet(str) && _validateOnSet()) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{"string", str, QNameHelper.readable(this._schemaType)});
        }
        String str2 = this._textvalue;
        this._textvalue = str;
        SchemaType[] unionConstituentTypes = this._schemaType.getUnionConstituentTypes();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        boolean z2 = true;
        while (true) {
            if (!z2) {
                try {
                    if (_validateOnSet()) {
                        break;
                    }
                    for (SchemaType schemaType : unionConstituentTypes) {
                        try {
                            xmlAnySimpleTypeNewValue = ((SchemaTypeImpl) schemaType).newValue(str, z2);
                        } catch (XmlValueOutOfRangeException unused) {
                        } catch (Exception e) {
                            throw new RuntimeException("Troublesome union exception caused by unexpected " + e, e);
                        }
                        if (check(xmlAnySimpleTypeNewValue, this._schemaType)) {
                            this._value = xmlAnySimpleTypeNewValue;
                            if (z) {
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    if (!z2) {
                        break;
                    } else {
                        z2 = false;
                    }
                } finally {
                    if (z) {
                        NamespaceContext.pop();
                    }
                }
            }
        }
        if (z) {
            NamespaceContext.pop();
        }
        this._textvalue = str2;
        throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(this._schemaType)});
    }

    protected void set_xmldate(XmlObject xmlObject) {
        set_primitive(16, xmlObject);
    }

    protected void set_xmldatetime(XmlObject xmlObject) {
        set_primitive(14, xmlObject);
    }

    protected void set_xmldecimal(XmlObject xmlObject) {
        set_primitive(11, xmlObject);
    }

    protected void set_xmldouble(XmlObject xmlObject) {
        set_primitive(10, xmlObject);
    }

    protected void set_xmlduration(XmlObject xmlObject) {
        set_primitive(13, xmlObject);
    }

    protected void set_xmlfloat(XmlObject xmlObject) {
        set_primitive(9, xmlObject);
    }

    protected void set_xmlgday(XmlObject xmlObject) {
        set_primitive(20, xmlObject);
    }

    protected void set_xmlgmonth(XmlObject xmlObject) {
        set_primitive(21, xmlObject);
    }

    protected void set_xmlgmonthday(XmlObject xmlObject) {
        set_primitive(19, xmlObject);
    }

    protected void set_xmlgyear(XmlObject xmlObject) {
        set_primitive(18, xmlObject);
    }

    protected void set_xmlgyearmonth(XmlObject xmlObject) {
        set_primitive(17, xmlObject);
    }

    protected void set_xmltime(XmlObject xmlObject) {
        set_primitive(15, xmlObject);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        try {
            check_dated();
            XmlTokenSource xmlTokenSource = this._value;
            if (xmlTokenSource != null) {
                ((XmlObjectBase) xmlTokenSource).validate_simpleval(str, validationContext);
                return;
            }
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{"'" + str + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
        } catch (Exception unused) {
            validationContext.invalid(XmlErrorCodes.UNION, new Object[]{"'" + str + "' does not match any of the member types for " + QNameHelper.readable(schemaType())});
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        return this._value.hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<? extends XmlAnySimpleType> xgetListValue() {
        check_dated();
        XmlAnySimpleType xmlAnySimpleType = this._value;
        if (xmlAnySimpleType == null) {
            return null;
        }
        return ((SimpleValue) xmlAnySimpleType).xgetListValue();
    }
}
