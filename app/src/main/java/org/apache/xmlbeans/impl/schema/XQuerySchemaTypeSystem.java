package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.regex.SchemaRegularExpression;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes.dex */
public class XQuerySchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BTC_ANY_ATOMIC = 52;
    public static final int BTC_DAY_TIME_DURATION = 53;
    public static final int BTC_FIRST_XQUERY = 52;
    public static final int BTC_LAST_XQUERY = 54;
    public static final int BTC_YEAR_MONTH_DURATION = 54;
    private static final XmlValueRef[] FACETS_BUILTIN_LIST;
    private static final XmlValueRef[] FACETS_BYTE;
    private static final XmlValueRef[] FACETS_INT;
    private static final XmlValueRef[] FACETS_INTEGER;
    static final XmlValueRef[] FACETS_LIST;
    private static final XmlValueRef[] FACETS_LONG;
    private static final XmlValueRef[] FACETS_NEGATIVE;
    private static final XmlValueRef[] FACETS_NONE;
    private static final XmlValueRef[] FACETS_NONNEGATIVE;
    private static final XmlValueRef[] FACETS_NONPOSITIVE;
    private static final XmlValueRef[] FACETS_POSITIVE;
    private static final XmlValueRef[] FACETS_SHORT;
    static final XmlValueRef[] FACETS_UNION;
    private static final XmlValueRef[] FACETS_UNSIGNED_BYTE;
    private static final XmlValueRef[] FACETS_UNSIGNED_INT;
    private static final XmlValueRef[] FACETS_UNSIGNED_LONG;
    private static final XmlValueRef[] FACETS_UNSIGNED_SHORT;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE;
    private static final XmlValueRef[] FACETS_WS_PRESERVE;
    private static final XmlValueRef[] FACETS_WS_REPLACE;
    private static final boolean[] FIXED_FACETS_INTEGER;
    static final boolean[] FIXED_FACETS_LIST;
    private static final boolean[] FIXED_FACETS_NONE;
    static final boolean[] FIXED_FACETS_UNION;
    private static final boolean[] FIXED_FACETS_WS;
    public static final SchemaTypeImpl ST_ANY_ATOMIC;
    public static final SchemaTypeImpl ST_ANY_SIMPLE;
    public static final SchemaTypeImpl ST_ANY_TYPE;
    public static final SchemaTypeImpl ST_ANY_URI;
    public static final SchemaTypeImpl ST_BASE_64_BINARY;
    public static final SchemaTypeImpl ST_BOOLEAN;
    public static final SchemaTypeImpl ST_BYTE;
    public static final SchemaTypeImpl ST_DATE;
    public static final SchemaTypeImpl ST_DATE_TIME;
    public static final SchemaTypeImpl ST_DAY_TIME_DURATION;
    public static final SchemaTypeImpl ST_DECIMAL;
    public static final SchemaTypeImpl ST_DOUBLE;
    public static final SchemaTypeImpl ST_DURATION;
    public static final SchemaTypeImpl ST_ENTITIES;
    public static final SchemaTypeImpl ST_ENTITY;
    public static final SchemaTypeImpl ST_FLOAT;
    public static final SchemaTypeImpl ST_G_DAY;
    public static final SchemaTypeImpl ST_G_MONTH;
    public static final SchemaTypeImpl ST_G_MONTH_DAY;
    public static final SchemaTypeImpl ST_G_YEAR;
    public static final SchemaTypeImpl ST_G_YEAR_MONTH;
    public static final SchemaTypeImpl ST_HEX_BINARY;
    public static final SchemaTypeImpl ST_ID;
    public static final SchemaTypeImpl ST_IDREF;
    public static final SchemaTypeImpl ST_IDREFS;
    public static final SchemaTypeImpl ST_INT;
    public static final SchemaTypeImpl ST_INTEGER;
    public static final SchemaTypeImpl ST_LANGUAGE;
    public static final SchemaTypeImpl ST_LONG;
    public static final SchemaTypeImpl ST_NAME;
    public static final SchemaTypeImpl ST_NCNAME;
    public static final SchemaTypeImpl ST_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NMTOKEN;
    public static final SchemaTypeImpl ST_NMTOKENS;
    public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER;
    public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_NORMALIZED_STRING;
    public static final SchemaTypeImpl ST_NOTATION;
    public static final SchemaTypeImpl ST_NO_TYPE;
    public static final SchemaTypeImpl ST_POSITIVE_INTEGER;
    public static final SchemaTypeImpl ST_QNAME;
    public static final SchemaTypeImpl ST_SHORT;
    public static final SchemaTypeImpl ST_STRING;
    public static final SchemaTypeImpl ST_TIME;
    public static final SchemaTypeImpl ST_TOKEN;
    public static final SchemaTypeImpl ST_UNSIGNED_BYTE;
    public static final SchemaTypeImpl ST_UNSIGNED_INT;
    public static final SchemaTypeImpl ST_UNSIGNED_LONG;
    public static final SchemaTypeImpl ST_UNSIGNED_SHORT;
    public static final SchemaTypeImpl ST_YEAR_MONTH_DURATION;
    private static final XmlValueRef XMLSTR_COLLAPSE;
    private static final XmlValueRef XMLSTR_PRESERVE;
    private static final XmlValueRef XMLSTR_REPLACE;
    private static final XQuerySchemaTypeSystem _global;
    private final SchemaContainer _container;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
    private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
    private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
    private final Map<QName, SchemaType> _typeMap = new HashMap();
    private final SchemaTypeImpl[] _typeArray = new SchemaTypeImpl[50];
    private final Map<String, SchemaType> _handlesToObjects = new HashMap();
    private final Map<SchemaType, String> _objectsToHandles = new HashMap();
    private final Map<String, SchemaType> _typesByClassname = new HashMap();

    static {
        XQuerySchemaTypeSystem xQuerySchemaTypeSystem = new XQuerySchemaTypeSystem();
        _global = xQuerySchemaTypeSystem;
        ST_ANY_TYPE = xQuerySchemaTypeSystem.getBuiltinType(1);
        ST_ANY_SIMPLE = xQuerySchemaTypeSystem.getBuiltinType(2);
        ST_ANY_ATOMIC = xQuerySchemaTypeSystem.getBuiltinType(52);
        ST_BOOLEAN = xQuerySchemaTypeSystem.getBuiltinType(3);
        ST_BASE_64_BINARY = xQuerySchemaTypeSystem.getBuiltinType(4);
        ST_HEX_BINARY = xQuerySchemaTypeSystem.getBuiltinType(5);
        ST_ANY_URI = xQuerySchemaTypeSystem.getBuiltinType(6);
        ST_QNAME = xQuerySchemaTypeSystem.getBuiltinType(7);
        ST_NOTATION = xQuerySchemaTypeSystem.getBuiltinType(8);
        ST_FLOAT = xQuerySchemaTypeSystem.getBuiltinType(9);
        ST_DOUBLE = xQuerySchemaTypeSystem.getBuiltinType(10);
        ST_DECIMAL = xQuerySchemaTypeSystem.getBuiltinType(11);
        ST_STRING = xQuerySchemaTypeSystem.getBuiltinType(12);
        ST_DURATION = xQuerySchemaTypeSystem.getBuiltinType(13);
        ST_DATE_TIME = xQuerySchemaTypeSystem.getBuiltinType(14);
        ST_TIME = xQuerySchemaTypeSystem.getBuiltinType(15);
        ST_DATE = xQuerySchemaTypeSystem.getBuiltinType(16);
        ST_G_YEAR_MONTH = xQuerySchemaTypeSystem.getBuiltinType(17);
        ST_G_YEAR = xQuerySchemaTypeSystem.getBuiltinType(18);
        ST_G_MONTH_DAY = xQuerySchemaTypeSystem.getBuiltinType(19);
        ST_G_DAY = xQuerySchemaTypeSystem.getBuiltinType(20);
        ST_G_MONTH = xQuerySchemaTypeSystem.getBuiltinType(21);
        ST_INTEGER = xQuerySchemaTypeSystem.getBuiltinType(22);
        ST_LONG = xQuerySchemaTypeSystem.getBuiltinType(23);
        ST_INT = xQuerySchemaTypeSystem.getBuiltinType(24);
        ST_SHORT = xQuerySchemaTypeSystem.getBuiltinType(25);
        ST_BYTE = xQuerySchemaTypeSystem.getBuiltinType(26);
        ST_NON_POSITIVE_INTEGER = xQuerySchemaTypeSystem.getBuiltinType(27);
        ST_NEGATIVE_INTEGER = xQuerySchemaTypeSystem.getBuiltinType(28);
        ST_NON_NEGATIVE_INTEGER = xQuerySchemaTypeSystem.getBuiltinType(29);
        ST_POSITIVE_INTEGER = xQuerySchemaTypeSystem.getBuiltinType(30);
        ST_UNSIGNED_LONG = xQuerySchemaTypeSystem.getBuiltinType(31);
        ST_UNSIGNED_INT = xQuerySchemaTypeSystem.getBuiltinType(32);
        ST_UNSIGNED_SHORT = xQuerySchemaTypeSystem.getBuiltinType(33);
        ST_UNSIGNED_BYTE = xQuerySchemaTypeSystem.getBuiltinType(34);
        ST_NORMALIZED_STRING = xQuerySchemaTypeSystem.getBuiltinType(35);
        ST_TOKEN = xQuerySchemaTypeSystem.getBuiltinType(36);
        ST_NAME = xQuerySchemaTypeSystem.getBuiltinType(37);
        ST_NCNAME = xQuerySchemaTypeSystem.getBuiltinType(38);
        ST_LANGUAGE = xQuerySchemaTypeSystem.getBuiltinType(39);
        ST_ID = xQuerySchemaTypeSystem.getBuiltinType(40);
        ST_IDREF = xQuerySchemaTypeSystem.getBuiltinType(41);
        ST_IDREFS = xQuerySchemaTypeSystem.getBuiltinType(42);
        ST_ENTITY = xQuerySchemaTypeSystem.getBuiltinType(43);
        ST_ENTITIES = xQuerySchemaTypeSystem.getBuiltinType(44);
        ST_NMTOKEN = xQuerySchemaTypeSystem.getBuiltinType(45);
        ST_NMTOKENS = xQuerySchemaTypeSystem.getBuiltinType(46);
        ST_DAY_TIME_DURATION = xQuerySchemaTypeSystem.getBuiltinType(53);
        ST_YEAR_MONTH_DURATION = xQuerySchemaTypeSystem.getBuiltinType(54);
        ST_NO_TYPE = xQuerySchemaTypeSystem.getBuiltinType(0);
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        XmlValueRef[] xmlValueRefArr = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = xmlValueRefArr;
        boolean[] zArr = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = zArr;
        XmlValueRef[] xmlValueRefArr2 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = xmlValueRefArr2;
        FACETS_WS_REPLACE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null};
        FACETS_WS_PRESERVE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null};
        BigInteger bigInteger = BigInteger.ZERO;
        FACETS_INTEGER = new XmlValueRef[]{null, null, null, null, null, null, null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-32768L)), buildInteger(BigInteger.valueOf(32767L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-128L)), buildInteger(BigInteger.valueOf(127L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_NONNEGATIVE = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger), null, null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        BigInteger bigInteger2 = BigInteger.ONE;
        FACETS_POSITIVE = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger2), null, null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_NONPOSITIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(bigInteger), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_NEGATIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(bigInteger2.negate()), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_UNSIGNED_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_UNSIGNED_INT = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_UNSIGNED_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger), buildInteger(BigInteger.valueOf(65535L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_UNSIGNED_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(bigInteger), buildInteger(BigInteger.valueOf(255L)), null, null, buildNnInteger(bigInteger), build_wsstring(3), null, null};
        FACETS_BUILTIN_LIST = new XmlValueRef[]{null, buildNnInteger(bigInteger2), null, null, null, null, null, null, null, build_wsstring(3), null, null};
        boolean[] zArr2 = {false, false, false, false, false, false, false, false, false, true, false, false};
        FIXED_FACETS_WS = zArr2;
        FIXED_FACETS_INTEGER = new boolean[]{false, false, false, false, false, false, false, false, true, true, false, false};
        FACETS_UNION = xmlValueRefArr;
        FIXED_FACETS_UNION = zArr;
        FACETS_LIST = xmlValueRefArr2;
        FIXED_FACETS_LIST = zArr2;
        for (int i2 = 0; i2 <= 46; i2++) {
            _global.fillInType(i2);
        }
        for (int i3 = 52; i3 <= 54; i3++) {
            _global.fillInType(i3);
        }
    }

    private XQuerySchemaTypeSystem() {
        SchemaContainer schemaContainer = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
        this._container = schemaContainer;
        schemaContainer.setTypeSystem(this);
        setupType(1, "anyType", "org.apache.xmlbeans.XmlObject");
        setupType(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
        setupType(52, "anyAtomicType", null);
        setupType(3, XmlErrorCodes.BOOLEAN, "org.apache.xmlbeans.XmlBoolean");
        setupType(4, XmlErrorCodes.BASE64BINARY, "org.apache.xmlbeans.XmlBase64Binary");
        setupType(5, XmlErrorCodes.HEXBINARY, "org.apache.xmlbeans.XmlHexBinary");
        setupType(6, XmlErrorCodes.ANYURI, "org.apache.xmlbeans.XmlAnyURI");
        setupType(7, XmlErrorCodes.QNAME, "org.apache.xmlbeans.XmlQName");
        setupType(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
        setupType(9, XmlErrorCodes.FLOAT, "org.apache.xmlbeans.XmlFloat");
        setupType(10, XmlErrorCodes.DOUBLE, "org.apache.xmlbeans.XmlDouble");
        setupType(11, XmlErrorCodes.DECIMAL, "org.apache.xmlbeans.XmlDecimal");
        setupType(12, "string", "org.apache.xmlbeans.XmlString");
        setupType(13, XmlErrorCodes.DURATION, "org.apache.xmlbeans.XmlDuration");
        setupType(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
        setupType(15, "time", "org.apache.xmlbeans.XmlTime");
        setupType(16, XmlErrorCodes.DATE, "org.apache.xmlbeans.XmlDate");
        setupType(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
        setupType(18, "gYear", "org.apache.xmlbeans.XmlGYear");
        setupType(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
        setupType(20, "gDay", "org.apache.xmlbeans.XmlGDay");
        setupType(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
        setupType(22, XmlErrorCodes.INTEGER, "org.apache.xmlbeans.XmlInteger");
        setupType(23, XmlErrorCodes.LONG, "org.apache.xmlbeans.XmlLong");
        setupType(24, XmlErrorCodes.INT, "org.apache.xmlbeans.XmlInt");
        setupType(25, "short", "org.apache.xmlbeans.XmlShort");
        setupType(26, "byte", "org.apache.xmlbeans.XmlByte");
        setupType(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
        setupType(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
        setupType(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
        setupType(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
        setupType(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
        setupType(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
        setupType(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
        setupType(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
        setupType(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
        setupType(36, "token", "org.apache.xmlbeans.XmlToken");
        setupType(37, "Name", "org.apache.xmlbeans.XmlName");
        setupType(38, XmlErrorCodes.NCNAME, "org.apache.xmlbeans.XmlNCName");
        setupType(39, "language", "org.apache.xmlbeans.XmlLanguage");
        setupType(40, "ID", "org.apache.xmlbeans.XmlID");
        setupType(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
        setupType(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
        setupType(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
        setupType(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
        setupType(45, XmlErrorCodes.NMTOKEN, "org.apache.xmlbeans.XmlNMTOKEN");
        setupType(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
        setupType(53, "dayTimeDuration", null);
        setupType(54, "yearMonthDuration", null);
        setupType(0, null, null);
        schemaContainer.setImmutable();
    }

    private int arrayIndexForBtc(int i2) {
        return i2 > 46 ? (i2 - 52) + 46 + 1 : i2;
    }

    private static XmlValueRef buildInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.setBigIntegerValue(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildNnInteger(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            return null;
        }
        try {
            XmlIntegerImpl xmlIntegerImpl = new XmlIntegerImpl();
            xmlIntegerImpl.setBigIntegerValue(bigInteger);
            xmlIntegerImpl.setImmutable();
            return new XmlValueRef(xmlIntegerImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef buildString(String str) {
        if (str == null) {
            return null;
        }
        try {
            XmlStringImpl xmlStringImpl = new XmlStringImpl();
            xmlStringImpl.setStringValue(str);
            xmlStringImpl.setImmutable();
            return new XmlValueRef(xmlStringImpl);
        } catch (XmlValueOutOfRangeException unused) {
            return null;
        }
    }

    private static XmlValueRef build_wsstring(int i2) {
        if (i2 == 1) {
            return XMLSTR_PRESERVE;
        }
        if (i2 == 2) {
            return XMLSTR_REPLACE;
        }
        if (i2 != 3) {
            return null;
        }
        return XMLSTR_COLLAPSE;
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    private SchemaTypeImpl getBuiltinType(int i2) {
        return this._typeArray[arrayIndexForBtc(i2)];
    }

    public static SchemaType getNoType() {
        return ST_NO_TYPE;
    }

    private void setupType(int i2, String str, String str2) {
        SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(this._container, true);
        this._container.addGlobalType(schemaTypeImpl.getRef());
        QName qNameForLNS = str == null ? null : QNameHelper.forLNS(str, "http://www.w3.org/2001/XMLSchema");
        StringBuilder sb = new StringBuilder();
        sb.append("_BI_");
        if (str == null) {
            str = "NO_TYPE";
        }
        sb.append(str);
        String string = sb.toString();
        schemaTypeImpl.setName(qNameForLNS);
        schemaTypeImpl.setBuiltinTypeCode(i2);
        if (str2 != null) {
            schemaTypeImpl.setFullJavaName(str2);
        }
        this._typeArray[arrayIndexForBtc(i2)] = schemaTypeImpl;
        this._typeMap.put(qNameForLNS, schemaTypeImpl);
        this._handlesToObjects.put(string, schemaTypeImpl);
        this._objectsToHandles.put(schemaTypeImpl, string);
        if (str2 != null) {
            this._typesByClassname.put(str2, schemaTypeImpl);
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAnnotation[] annotations() {
        return EMPTY_SCHEMAANNOTATION_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaAttributeGroup[] attributeGroups() {
        return EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] attributeTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] documentTypes() {
        return EMPTY_SCHEMATYPE_ARRAY;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:73:0x0105. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fillInType(int i2) {
        SchemaTypeImpl schemaTypeImpl;
        SchemaTypeImpl schemaTypeImpl2;
        int i3;
        XmlValueRef[] xmlValueRefArr;
        boolean[] zArr;
        boolean[] zArr2;
        XmlValueRef[] xmlValueRefArr2;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        RegularExpression regularExpressionForPattern;
        SchemaTypeImpl builtinType = getBuiltinType(i2);
        int i5 = 3;
        switch (i2) {
            case 0:
                schemaTypeImpl = ST_ANY_TYPE;
                schemaTypeImpl2 = null;
                i3 = 0;
                break;
            case 1:
                schemaTypeImpl = null;
                schemaTypeImpl2 = null;
                i3 = 0;
                break;
            case 2:
                schemaTypeImpl = ST_ANY_TYPE;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                schemaTypeImpl = ST_ANY_ATOMIC;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 22:
                schemaTypeImpl = ST_DECIMAL;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 23:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 24:
                schemaTypeImpl = ST_LONG;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 25:
                schemaTypeImpl = ST_INT;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 26:
                schemaTypeImpl = ST_SHORT;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 27:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 28:
                schemaTypeImpl = ST_NON_POSITIVE_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 29:
                schemaTypeImpl = ST_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 30:
                schemaTypeImpl = ST_NON_NEGATIVE_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 31:
                schemaTypeImpl = ST_NON_NEGATIVE_INTEGER;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 32:
                schemaTypeImpl = ST_UNSIGNED_LONG;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 33:
                schemaTypeImpl = ST_UNSIGNED_INT;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 34:
                schemaTypeImpl = ST_UNSIGNED_SHORT;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 35:
                schemaTypeImpl = ST_STRING;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 36:
                schemaTypeImpl = ST_NORMALIZED_STRING;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 37:
                schemaTypeImpl = ST_TOKEN;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 38:
                schemaTypeImpl = ST_NAME;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 39:
            case 45:
                schemaTypeImpl = ST_TOKEN;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 40:
            case 41:
            case 43:
                schemaTypeImpl = ST_NCNAME;
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
            case 42:
            case 44:
            case 46:
                schemaTypeImpl = ST_ANY_SIMPLE;
                schemaTypeImpl2 = i2 == 42 ? ST_IDREF : i2 == 44 ? ST_ENTITY : ST_NMTOKEN;
                i3 = 3;
                break;
            default:
                switch (i2) {
                    case 52:
                        schemaTypeImpl = ST_ANY_SIMPLE;
                        break;
                    case 53:
                    case 54:
                        schemaTypeImpl = ST_DURATION;
                        break;
                }
                schemaTypeImpl2 = null;
                i3 = 1;
                break;
        }
        builtinType.setDerivationType(1);
        builtinType.setSimpleTypeVariety(i3);
        if (i3 != 0) {
            builtinType.setSimpleType(true);
        }
        builtinType.setBaseTypeRef(schemaTypeImpl == null ? null : schemaTypeImpl.getRef());
        builtinType.setBaseDepth(schemaTypeImpl == null ? 0 : schemaTypeImpl.getBaseDepth() + 1);
        builtinType.setListItemTypeRef(schemaTypeImpl2 == null ? null : schemaTypeImpl2.getRef());
        if ((i2 >= 2 && i2 <= 21) || i2 == 52) {
            builtinType.setPrimitiveTypeRef(builtinType.getRef());
        } else if (i3 == 1) {
            if (schemaTypeImpl == null) {
                throw new IllegalStateException("Base was null for " + i2);
            }
            if (schemaTypeImpl.getPrimitiveType() == null) {
                throw new IllegalStateException("Base.gpt was null for " + i2);
            }
            builtinType.setPrimitiveTypeRef(schemaTypeImpl.getPrimitiveType().getRef());
        }
        int i6 = 64;
        int i7 = SchemaType.SIZE_BIG_INTEGER;
        switch (i2) {
            case 0:
            case 1:
            case 2:
                xmlValueRefArr = FACETS_NONE;
                zArr = FIXED_FACETS_NONE;
                i5 = 0;
                i7 = 0;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_WS;
                i7 = 0;
                break;
            case 11:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_WS;
                i6 = SchemaType.SIZE_BIG_DECIMAL;
                i7 = i6;
                break;
            case 12:
                xmlValueRefArr = FACETS_WS_PRESERVE;
                zArr = FIXED_FACETS_NONE;
                i7 = 0;
                i5 = 1;
                break;
            case 22:
                xmlValueRefArr = FACETS_INTEGER;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 23:
                xmlValueRefArr = FACETS_LONG;
                zArr = FIXED_FACETS_INTEGER;
                i7 = i6;
                break;
            case 24:
                xmlValueRefArr = FACETS_INT;
                zArr2 = FIXED_FACETS_INTEGER;
                i7 = 32;
                zArr = zArr2;
                break;
            case 25:
                xmlValueRefArr2 = FACETS_SHORT;
                zArr2 = FIXED_FACETS_INTEGER;
                i7 = 16;
                xmlValueRefArr = xmlValueRefArr2;
                zArr = zArr2;
                break;
            case 26:
                xmlValueRefArr = FACETS_BYTE;
                zArr = FIXED_FACETS_INTEGER;
                i6 = 8;
                i7 = i6;
                break;
            case 27:
                xmlValueRefArr = FACETS_NONPOSITIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 28:
                xmlValueRefArr = FACETS_NEGATIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 29:
                xmlValueRefArr = FACETS_NONNEGATIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 30:
                xmlValueRefArr = FACETS_POSITIVE;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 31:
                xmlValueRefArr = FACETS_UNSIGNED_LONG;
                zArr = FIXED_FACETS_INTEGER;
                break;
            case 32:
                xmlValueRefArr = FACETS_UNSIGNED_INT;
                zArr = FIXED_FACETS_INTEGER;
                i7 = i6;
                break;
            case 33:
                xmlValueRefArr = FACETS_UNSIGNED_SHORT;
                zArr2 = FIXED_FACETS_INTEGER;
                i7 = 32;
                zArr = zArr2;
                break;
            case 34:
                xmlValueRefArr2 = FACETS_UNSIGNED_BYTE;
                zArr2 = FIXED_FACETS_INTEGER;
                i7 = 16;
                xmlValueRefArr = xmlValueRefArr2;
                zArr = zArr2;
                break;
            case 35:
                xmlValueRefArr = FACETS_WS_REPLACE;
                zArr = FIXED_FACETS_NONE;
                i5 = 2;
                i7 = 0;
                break;
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
                xmlValueRefArr = FACETS_WS_COLLAPSE;
                zArr = FIXED_FACETS_NONE;
                i7 = 0;
                break;
            case 44:
            case 46:
                xmlValueRefArr = FACETS_BUILTIN_LIST;
                zArr = FIXED_FACETS_NONE;
                i5 = 0;
                i7 = 0;
                break;
            default:
                switch (i2) {
                    case 53:
                    case 54:
                        xmlValueRefArr = FACETS_WS_COLLAPSE;
                        zArr = FIXED_FACETS_WS;
                        i7 = 0;
                        break;
                }
        }
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                i4 = 0;
                z = false;
                z2 = z;
                z3 = z2;
                break;
            case 3:
                i4 = 0;
                z = false;
                z2 = false;
                z3 = true;
                break;
            case 9:
            case 10:
            case 11:
            case 22:
                i4 = 2;
                z = false;
                z3 = false;
                z2 = true;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                z = false;
                z2 = false;
                z3 = false;
                i4 = 1;
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                i4 = 2;
                z = true;
                z2 = z;
                z3 = z2;
                break;
            default:
                switch (i2) {
                }
        }
        builtinType.setBasicFacets(xmlValueRefArr, zArr);
        builtinType.setWhiteSpaceRule(i5);
        builtinType.setOrdered(i4);
        builtinType.setBounded(z);
        builtinType.setNumeric(z2);
        builtinType.setFinite(z3);
        builtinType.setDecimalSize(i7);
        builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        if (i2 == 43) {
            str = null;
            z4 = true;
        } else {
            if (i2 == 45) {
                str = "\\c+";
            } else if (i2 == 53) {
                str = "[^YM]*[DT].*";
            } else if (i2 != 54) {
                switch (i2) {
                    case 37:
                        str = "\\i\\c*";
                        break;
                    case 38:
                        str = "[\\i-[:]][\\c-[:]]*";
                        break;
                    case 39:
                        str = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
                        break;
                    case 40:
                    case 41:
                        break;
                    default:
                        str = null;
                        z4 = false;
                        break;
                }
            } else {
                str = "[^DT]*";
            }
            z4 = true;
        }
        if (str != null) {
            try {
                regularExpressionForPattern = SchemaRegularExpression.forPattern(str);
            } catch (ParseException unused) {
                regularExpressionForPattern = null;
            }
            builtinType.setPatterns(new RegularExpression[]{regularExpressionForPattern});
        }
        builtinType.setPatternFacet(z4);
        if (i2 == 1) {
            SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
            schemaParticleImpl.setParticleType(5);
            QNameSet qNameSet = QNameSet.ALL;
            schemaParticleImpl.setWildcardSet(qNameSet);
            schemaParticleImpl.setWildcardProcess(2);
            schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
            schemaParticleImpl.setMaxOccurs(null);
            schemaParticleImpl.setTransitionRules(qNameSet, true);
            schemaParticleImpl.setTransitionNotes(qNameSet, true);
            SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
            schemaAttributeModelImpl.setWildcardProcess(2);
            schemaAttributeModelImpl.setWildcardSet(qNameSet);
            builtinType.setComplexTypeVariety(4);
            Map<QName, SchemaProperty> map = Collections.EMPTY_MAP;
            builtinType.setContentModel(schemaParticleImpl, schemaAttributeModelImpl, map, map, false);
            builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
            builtinType.setWildcardSummary(qNameSet, true, qNameSet, true);
        } else if (i2 == 0) {
            SchemaAttributeModelImpl schemaAttributeModelImpl2 = new SchemaAttributeModelImpl();
            builtinType.setComplexTypeVariety(1);
            Map<QName, SchemaProperty> map2 = Collections.EMPTY_MAP;
            builtinType.setContentModel(null, schemaAttributeModelImpl2, map2, map2, false);
            builtinType.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
            QNameSet qNameSet2 = QNameSet.EMPTY;
            builtinType.setWildcardSummary(qNameSet2, false, qNameSet2, false);
        }
        builtinType.setOrderSensitive(false);
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName qName) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        return this._typeMap.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName qName) {
        SchemaType schemaTypeFindType = findType(qName);
        if (schemaTypeFindType == null) {
            return null;
        }
        return schemaTypeFindType.getRef();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return BuiltinSchemaTypeSystem.class.getClassLoader();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public String getName() {
        return "xquery.typesystem.builtin";
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public InputStream getSourceAsStream(String str) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalAttribute[] globalAttributes() {
        return EMPTY_SCHEMAATTRIBUTE_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaGlobalElement[] globalElements() {
        return EMPTY_SCHEMAELEMENT_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType[] globalTypes() {
        SchemaTypeImpl[] schemaTypeImplArr = this._typeArray;
        int length = schemaTypeImplArr.length - 1;
        SchemaType[] schemaTypeArr = new SchemaType[length];
        System.arraycopy(schemaTypeImplArr, 1, schemaTypeArr, 0, length);
        return schemaTypeArr;
    }

    public String handleForType(SchemaType schemaType) {
        return this._objectsToHandles.get(schemaType);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public boolean isNamespaceDefined(String str) {
        return str.equals("http://www.w3.org/2001/XMLSchema");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaModelGroup[] modelGroups() {
        return EMPTY_SCHEMAMODELGROUP_ARRAY;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void resolve() {
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String str) {
        return this._handlesToObjects.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void save(Filer filer) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public void saveToDirectory(File file) {
        throw new UnsupportedOperationException("The builtin schema type system cannot be saved.");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForClassname(String str) {
        return this._typesByClassname.get(str);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String str) {
        return this._handlesToObjects.get(str);
    }
}
