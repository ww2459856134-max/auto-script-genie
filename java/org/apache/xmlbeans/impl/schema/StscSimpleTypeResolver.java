package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;

/* loaded from: classes.dex */
public class StscSimpleTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final RegularExpression[] EMPTY_REGEX_ARRAY = new RegularExpression[0];
    private static final CodeForNameEntry[] facetCodes = {new CodeForNameEntry(QNameHelper.forLNS("length", "http://www.w3.org/2001/XMLSchema"), 0), new CodeForNameEntry(QNameHelper.forLNS("minLength", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("maxLength", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("pattern", "http://www.w3.org/2001/XMLSchema"), 10), new CodeForNameEntry(QNameHelper.forLNS("enumeration", "http://www.w3.org/2001/XMLSchema"), 11), new CodeForNameEntry(QNameHelper.forLNS("whiteSpace", "http://www.w3.org/2001/XMLSchema"), 9), new CodeForNameEntry(QNameHelper.forLNS("maxInclusive", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("maxExclusive", "http://www.w3.org/2001/XMLSchema"), 6), new CodeForNameEntry(QNameHelper.forLNS("minInclusive", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("minExclusive", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("totalDigits", "http://www.w3.org/2001/XMLSchema"), 7), new CodeForNameEntry(QNameHelper.forLNS("fractionDigits", "http://www.w3.org/2001/XMLSchema"), 8)};
    private static final Map<QName, Integer> facetCodeMap = buildFacetCodeMap();

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName qName, int i2) {
            this.name = qName;
            this.code = i2;
        }
    }

    static /* synthetic */ SchemaType.Ref[] a(int i2) {
        return new SchemaType.Ref[i2];
    }

    private static Map<QName, Integer> buildFacetCodeMap() {
        HashMap map = new HashMap();
        for (CodeForNameEntry codeForNameEntry : facetCodes) {
            map.put(codeForNameEntry.name, Integer.valueOf(codeForNameEntry.code));
        }
        return map;
    }

    private static int decimalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        int iMathematicalSizeOfType = mathematicalSizeOfType(schemaTypeImpl);
        if (iMathematicalSizeOfType == 8 && !XmlByte.type.isAssignableFrom(schemaTypeImpl)) {
            iMathematicalSizeOfType = 16;
        }
        if (iMathematicalSizeOfType != 16 || XmlShort.type.isAssignableFrom(schemaTypeImpl) || XmlUnsignedByte.type.isAssignableFrom(schemaTypeImpl)) {
            return iMathematicalSizeOfType;
        }
        return 32;
    }

    static boolean facetAppliesToType(int i2, SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 2) {
            return i2 == 10 || i2 == 11;
        }
        if (simpleVariety == 3) {
            if (i2 != 0 && i2 != 1 && i2 != 2) {
                switch (i2) {
                    case 9:
                    case 10:
                    case 11:
                        break;
                    default:
                        return false;
                }
            }
            return true;
        }
        switch (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
            default:
                return false;
            case 3:
                return i2 == 9 || i2 == 10;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 12:
                if (i2 != 0 && i2 != 1 && i2 != 2) {
                    switch (i2) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            return false;
                    }
                }
                return true;
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
                switch (i2) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    case 7:
                    case 8:
                    default:
                        return false;
                }
            case 11:
                switch (i2) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static boolean isDiscreteType(SchemaTypeImpl schemaTypeImpl) {
        int builtinTypeCode;
        if (schemaTypeImpl.getFacet(8) == null && (builtinTypeCode = schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) != 3) {
            switch (builtinTypeCode) {
            }
            return true;
        }
        return true;
    }

    static boolean isMultipleFacet(int i2) {
        return i2 == 11 || i2 == 10;
    }

    private static boolean isNumericPrimitive(SchemaType schemaType) {
        switch (schemaType.getBuiltinTypeCode()) {
            case 9:
            case 10:
            case 11:
                return true;
            default:
                return false;
        }
    }

    private static SchemaType.Ref[] makeRefArray(List<? extends SchemaType> list) {
        return (SchemaType.Ref[]) list.stream().map(m2.a).toArray(new IntFunction() { // from class: org.apache.xmlbeans.impl.schema.d1
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return StscSimpleTypeResolver.a(i2);
            }
        });
    }

    private static XmlValueRef[] makeValueRefArray(XmlAnySimpleType[] xmlAnySimpleTypeArr) {
        int length = xmlAnySimpleTypeArr.length;
        XmlValueRef[] xmlValueRefArr = new XmlValueRef[length];
        for (int i2 = 0; i2 < length; i2++) {
            xmlValueRefArr[i2] = xmlAnySimpleTypeArr[i2] == null ? null : new XmlValueRef(xmlAnySimpleTypeArr[i2]);
        }
        return xmlValueRefArr;
    }

    private static int mathematicalSizeOfType(SchemaTypeImpl schemaTypeImpl) {
        BigInteger bigIntegerValueOf;
        if (schemaTypeImpl.getPrimitiveType().getBuiltinTypeCode() != 11) {
            return 0;
        }
        if (schemaTypeImpl.getFacet(8) == null || ((SimpleValue) schemaTypeImpl.getFacet(8)).getBigIntegerValue().signum() != 0) {
            return SchemaType.SIZE_BIG_DECIMAL;
        }
        BigInteger bigInteger = null;
        BigInteger bigIntegerValue = schemaTypeImpl.getFacet(3) != null ? ((SimpleValue) schemaTypeImpl.getFacet(3)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(4) != null) {
            bigIntegerValue = ((SimpleValue) schemaTypeImpl.getFacet(4)).getBigIntegerValue();
        }
        BigInteger bigIntegerValue2 = schemaTypeImpl.getFacet(5) != null ? ((SimpleValue) schemaTypeImpl.getFacet(5)).getBigIntegerValue() : null;
        if (schemaTypeImpl.getFacet(6) != null) {
            bigIntegerValue2 = ((SimpleValue) schemaTypeImpl.getFacet(6)).getBigIntegerValue();
        }
        if (schemaTypeImpl.getFacet(7) != null) {
            try {
                switch (((SimpleValue) schemaTypeImpl.getFacet(7)).getBigIntegerValue().intValue()) {
                    case 0:
                    case 1:
                    case 2:
                        bigIntegerValueOf = BigInteger.valueOf(99L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 3:
                    case 4:
                        bigIntegerValueOf = BigInteger.valueOf(9999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        bigIntegerValueOf = BigInteger.valueOf(999999999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        bigIntegerValueOf = BigInteger.valueOf(999999999999999999L);
                        bigInteger = bigIntegerValueOf;
                        break;
                }
            } catch (XmlValueOutOfRangeException unused) {
            }
            if (bigInteger != null) {
                BigInteger bigIntegerNegate = bigInteger.negate();
                if (bigIntegerValue != null) {
                    bigIntegerNegate = bigIntegerValue.max(bigIntegerNegate);
                }
                bigIntegerValue = bigIntegerNegate;
                bigIntegerValue2 = bigIntegerValue2 == null ? bigInteger : bigIntegerValue2.min(bigInteger);
            }
        }
        if (bigIntegerValue == null || bigIntegerValue2 == null) {
            return SchemaType.SIZE_BIG_INTEGER;
        }
        if (bigIntegerValue.signum() < 0) {
            bigIntegerValue = bigIntegerValue.negate().subtract(BigInteger.ONE);
        }
        if (bigIntegerValue2.signum() < 0) {
            bigIntegerValue2 = bigIntegerValue2.negate().subtract(BigInteger.ONE);
        }
        BigInteger bigIntegerMax = bigIntegerValue2.max(bigIntegerValue);
        if (bigIntegerMax.compareTo(BigInteger.valueOf(127L)) <= 0) {
            return 8;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(32767L)) <= 0) {
            return 16;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
            return 32;
        }
        if (bigIntegerMax.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
            return 64;
        }
        return SchemaType.SIZE_BIG_INTEGER;
    }

    private static int other_similar_limit(int i2) {
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 5) {
            return 6;
        }
        if (i2 == 6) {
            return 5;
        }
        throw new IllegalStateException();
    }

    static void resolveErrorSimpleType(SchemaTypeImpl schemaTypeImpl) {
        schemaTypeImpl.setSimpleTypeVariety(1);
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl2.getRef());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x024f, code lost:
    
        if (r10 == r13) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03ae A[PHI: r13 r14 r15 r17
      0x03ae: PHI (r13v29 int) = (r13v25 int), (r13v30 int) binds: [B:212:0x03b8, B:207:0x03ac] A[DONT_GENERATE, DONT_INLINE]
      0x03ae: PHI (r14v10 java.util.ArrayList) = (r14v8 java.util.ArrayList), (r14v3 java.util.ArrayList) binds: [B:212:0x03b8, B:207:0x03ac] A[DONT_GENERATE, DONT_INLINE]
      0x03ae: PHI (r15v10 java.util.ArrayList) = (r15v8 java.util.ArrayList), (r15v3 java.util.ArrayList) binds: [B:212:0x03b8, B:207:0x03ac] A[DONT_GENERATE, DONT_INLINE]
      0x03ae: PHI (r17v15 boolean[]) = (r17v11 boolean[]), (r17v16 boolean[]) binds: [B:212:0x03b8, B:207:0x03ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ba A[Catch: all -> 0x03d1, TryCatch #0 {all -> 0x03d1, blocks: (B:5:0x001d, B:7:0x0026, B:214:0x03bd, B:10:0x003b, B:12:0x004a, B:13:0x0060, B:15:0x0067, B:23:0x007c, B:24:0x0092, B:26:0x0096, B:28:0x009c, B:29:0x00a3, B:33:0x00b6, B:35:0x00c1, B:36:0x00c6, B:41:0x00ea, B:43:0x00fb, B:44:0x0100, B:47:0x0121, B:49:0x012f, B:50:0x013b, B:211:0x03b4, B:213:0x03ba, B:51:0x0149, B:53:0x0153, B:54:0x0158, B:56:0x015c, B:58:0x0164, B:59:0x016f, B:61:0x0175, B:63:0x017d, B:64:0x0183, B:66:0x0187, B:68:0x018f, B:69:0x0195, B:70:0x0199, B:72:0x01a3, B:73:0x01aa, B:75:0x01ae, B:77:0x01b6, B:78:0x01c1, B:80:0x01c5, B:82:0x01cd, B:83:0x01d3, B:84:0x01d7, B:86:0x01df, B:100:0x01fd, B:101:0x0206, B:103:0x020a, B:105:0x0212, B:106:0x021d, B:108:0x0221, B:110:0x0227, B:112:0x022d, B:114:0x0234, B:115:0x0241, B:128:0x0262, B:129:0x0268, B:140:0x0281, B:141:0x0291, B:142:0x02a1, B:143:0x02b1, B:144:0x02c1, B:146:0x02cb, B:148:0x02d4, B:150:0x02d8, B:152:0x02e0, B:153:0x02ea, B:155:0x02ef, B:157:0x02f5, B:161:0x0300, B:170:0x031c, B:172:0x0321, B:174:0x0329, B:175:0x0331, B:177:0x0336, B:179:0x033e, B:180:0x0345, B:168:0x0314, B:164:0x0309, B:181:0x0349, B:183:0x0355, B:184:0x035b, B:186:0x035f, B:188:0x0367, B:189:0x0371, B:191:0x0376, B:193:0x037c, B:195:0x0384, B:197:0x038a, B:198:0x038f, B:200:0x0394, B:202:0x039a, B:204:0x03a2, B:206:0x03a8, B:209:0x03b0, B:39:0x00ce, B:46:0x0105), top: B:266:0x001d, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0432  */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r0v47, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r0v71, types: [org.apache.xmlbeans.XmlObject, org.apache.xmlbeans.XmlPositiveInteger] */
    /* JADX WARN: Type inference failed for: r0v75, types: [org.apache.xmlbeans.XmlNonNegativeInteger, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v17, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v38, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r10v49, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [org.apache.xmlbeans.XmlAnySimpleType, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v13, types: [org.apache.xmlbeans.XmlAnySimpleType, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v14, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [org.apache.xmlbeans.XmlAnySimpleType, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v19, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v28, types: [org.apache.xmlbeans.XmlAnySimpleType, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v35, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v40, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v42, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r13v10, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r13v13, types: [org.apache.xmlbeans.XmlNonNegativeInteger, org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r13v23, types: [org.apache.xmlbeans.XmlObject] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.apache.xmlbeans.XmlAnySimpleType[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void resolveFacets(SchemaTypeImpl schemaTypeImpl, XmlObject xmlObject, SchemaTypeImpl schemaTypeImpl2) {
        boolean z;
        int whiteSpaceRule;
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z2;
        SchemaType baseEnumType;
        int i2;
        boolean[] zArr;
        ?? facet;
        ?? facet2;
        int i3;
        int i4;
        StscState stscState = StscState.get();
        boolean[] zArr2 = new boolean[12];
        ?? basicFacets = schemaTypeImpl2.getBasicFacets();
        boolean[] fixedFacets = schemaTypeImpl2.getFixedFacets();
        char c = 0;
        if (xmlObject != null) {
            XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
            try {
                boolean firstChild = xmlCursorNewCursor.toFirstChild();
                int iTranslateWhitespaceCode = 0;
                arrayList = null;
                arrayList2 = null;
                while (firstChild) {
                    QName name = xmlCursorNewCursor.getName();
                    String localPart = name.getLocalPart();
                    int iTranslateFacetCode = translateFacetCode(name);
                    if (iTranslateFacetCode == -1) {
                        zArr = zArr2;
                        i2 = iTranslateWhitespaceCode;
                        iTranslateWhitespaceCode = i2;
                    } else {
                        Facet facet3 = (Facet) xmlCursorNewCursor.getObject();
                        if (facetAppliesToType(iTranslateFacetCode, schemaTypeImpl2)) {
                            if (schemaTypeImpl2.getSimpleVariety() == 1 && schemaTypeImpl2.getPrimitiveType().getBuiltinTypeCode() == 8) {
                                if (iTranslateFacetCode == 0 || iTranslateFacetCode == 1) {
                                    i4 = 2;
                                } else {
                                    i4 = 2;
                                    if (iTranslateFacetCode == 2) {
                                    }
                                }
                                Object[] objArr = new Object[i4];
                                objArr[0] = localPart;
                                objArr[1] = QNameHelper.pretty(schemaTypeImpl2.getName());
                                stscState.warning(XmlErrorCodes.FACETS_DEPRECATED_NOTATION, objArr, facet3);
                            }
                            if (!zArr2[iTranslateFacetCode] || isMultipleFacet(iTranslateFacetCode)) {
                                zArr2[iTranslateFacetCode] = true;
                                i2 = iTranslateWhitespaceCode;
                                switch (iTranslateFacetCode) {
                                    case 0:
                                        zArr = zArr2;
                                        XmlNonNegativeInteger xmlNonNegativeIntegerBuildNnInteger = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (xmlNonNegativeIntegerBuildNnInteger == null) {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                        } else if (fixedFacets[iTranslateFacetCode] && !basicFacets[iTranslateFacetCode].valueEquals(xmlNonNegativeIntegerBuildNnInteger)) {
                                            stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                        } else if (basicFacets[1] != 0 && ((facet2 = schemaTypeImpl2.getFacet(1)) == 0 || !facet2.valueEquals(basicFacets[1]) || facet2.compareValue(xmlNonNegativeIntegerBuildNnInteger) > 0)) {
                                            stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                        } else if (basicFacets[2] == 0 || ((facet = schemaTypeImpl2.getFacet(2)) != 0 && facet.valueEquals(basicFacets[2]) && facet.compareValue(xmlNonNegativeIntegerBuildNnInteger) >= 0)) {
                                            basicFacets[iTranslateFacetCode] = xmlNonNegativeIntegerBuildNnInteger;
                                            iTranslateWhitespaceCode = i2;
                                            if (!facet3.getFixed()) {
                                                break;
                                            } else {
                                                fixedFacets[iTranslateFacetCode] = true;
                                                break;
                                            }
                                        } else {
                                            stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                        }
                                        iTranslateWhitespaceCode = i2;
                                        break;
                                    case 1:
                                    case 2:
                                        ?? BuildNnInteger = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (BuildNnInteger == 0) {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                        } else if (!fixedFacets[iTranslateFacetCode] || basicFacets[iTranslateFacetCode].valueEquals(BuildNnInteger)) {
                                            if (basicFacets[0] != 0) {
                                                ?? facet4 = schemaTypeImpl2.getFacet(iTranslateFacetCode);
                                                if (facet4 == 0 || !facet4.valueEquals(BuildNnInteger)) {
                                                    zArr = zArr2;
                                                } else {
                                                    zArr = zArr2;
                                                    if (iTranslateFacetCode == 1) {
                                                        if (facet4.compareTo(basicFacets[0]) <= 0) {
                                                        }
                                                    } else if (facet4.compareTo(basicFacets[0]) < 0) {
                                                    }
                                                }
                                                stscState.error(XmlErrorCodes.DATATYPE_LENGTH, (Object[]) null, facet3);
                                                iTranslateWhitespaceCode = i2;
                                                break;
                                            } else {
                                                zArr = zArr2;
                                            }
                                            if (basicFacets[2] != 0 && BuildNnInteger.compareValue(basicFacets[2]) > 0) {
                                                stscState.error(XmlErrorCodes.DATATYPE_MAX_LENGTH_RESTRICTION, (Object[]) null, facet3);
                                            } else if (basicFacets[1] == 0 || BuildNnInteger.compareValue(basicFacets[1]) >= 0) {
                                                basicFacets[iTranslateFacetCode] = BuildNnInteger;
                                                iTranslateWhitespaceCode = i2;
                                                if (!facet3.getFixed()) {
                                                }
                                            } else {
                                                stscState.error(XmlErrorCodes.DATATYPE_MIN_LENGTH_RESTRICTION, (Object[]) null, facet3);
                                            }
                                            iTranslateWhitespaceCode = i2;
                                        } else {
                                            stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                        }
                                        zArr = zArr2;
                                        iTranslateWhitespaceCode = i2;
                                        break;
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                        if (zArr2[other_similar_limit(iTranslateFacetCode)]) {
                                            stscState.error("Cannot define both inclusive and exclusive limit in the same restriciton", 19, facet3);
                                        } else {
                                            boolean z3 = iTranslateFacetCode == 3 || iTranslateFacetCode == 4;
                                            boolean z4 = iTranslateFacetCode == 3 || iTranslateFacetCode == 6;
                                            try {
                                                ?? NewValue = schemaTypeImpl2.newValue(facet3.getValue(), true);
                                                if (!fixedFacets[iTranslateFacetCode] || basicFacets[iTranslateFacetCode].valueEquals(NewValue)) {
                                                    if (basicFacets[iTranslateFacetCode] != 0) {
                                                        SchemaType schemaType = NewValue.schemaType();
                                                        NewValue = NewValue;
                                                        if (schemaType != null) {
                                                            NewValue = NewValue;
                                                            if (!schemaType.isSimpleType()) {
                                                                NewValue = NewValue;
                                                                if (schemaType.getContentType() == 2) {
                                                                    NewValue = schemaTypeImpl2.getContentBasedOnType().newValue(facet3.getValue());
                                                                }
                                                            }
                                                        }
                                                        int iCompareValue = NewValue.compareValue(basicFacets[iTranslateFacetCode]);
                                                        if (iCompareValue != 2) {
                                                            if (!z3) {
                                                                i3 = 1;
                                                                break;
                                                            } else {
                                                                i3 = -1;
                                                                break;
                                                            }
                                                        }
                                                        stscState.error(z3 ? z4 ? "Must be greater than or equal to previous minExclusive" : "Must be greater than or equal to previous minInclusive" : z4 ? "Must be less than or equal to previous maxExclusive" : "Must be less than or equal to previous maxInclusive", 20, facet3);
                                                    }
                                                    basicFacets[iTranslateFacetCode] = NewValue;
                                                    basicFacets[other_similar_limit(iTranslateFacetCode)] = 0;
                                                    zArr = zArr2;
                                                    iTranslateWhitespaceCode = i2;
                                                    if (!facet3.getFixed()) {
                                                    }
                                                } else {
                                                    stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                }
                                            } catch (XmlValueOutOfRangeException e) {
                                                if (iTranslateFacetCode == 3) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MIN_EXCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                } else if (iTranslateFacetCode == 4) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MIN_INCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                } else if (iTranslateFacetCode == 5) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MAX_INCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                } else if (iTranslateFacetCode == 6) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_MAX_EXCLUSIVE_RESTRICTION, new Object[]{e.getMessage()}, facet3);
                                                }
                                            }
                                        }
                                        zArr = zArr2;
                                        iTranslateWhitespaceCode = i2;
                                        break;
                                    case 7:
                                        ?? BuildPosInteger = StscTranslator.buildPosInteger(facet3.getValue());
                                        if (BuildPosInteger != 0) {
                                            if (fixedFacets[iTranslateFacetCode] && !basicFacets[iTranslateFacetCode].valueEquals(BuildPosInteger)) {
                                                stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                zArr = zArr2;
                                                iTranslateWhitespaceCode = i2;
                                                break;
                                            } else {
                                                if (basicFacets[7] != 0 && BuildPosInteger.compareValue(basicFacets[7]) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_TOTAL_DIGITS_RESTRICTION, (Object[]) null, facet3);
                                                }
                                                basicFacets[iTranslateFacetCode] = BuildPosInteger;
                                            }
                                        } else {
                                            stscState.error("Must be a positive integer", 20, facet3);
                                        }
                                        zArr = zArr2;
                                        iTranslateWhitespaceCode = i2;
                                        if (!facet3.getFixed()) {
                                        }
                                        break;
                                    case 8:
                                        ?? BuildNnInteger2 = StscTranslator.buildNnInteger(facet3.getValue());
                                        if (BuildNnInteger2 != 0) {
                                            if (fixedFacets[iTranslateFacetCode] && !basicFacets[iTranslateFacetCode].valueEquals(BuildNnInteger2)) {
                                                stscState.error(XmlErrorCodes.FACET_FIXED, new Object[]{localPart}, facet3);
                                                zArr = zArr2;
                                                iTranslateWhitespaceCode = i2;
                                                break;
                                            } else {
                                                if (basicFacets[8] != 0 && BuildNnInteger2.compareValue(basicFacets[8]) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_FRACTION_DIGITS_RESTRICTION, (Object[]) null, facet3);
                                                }
                                                if (basicFacets[7] != 0 && BuildNnInteger2.compareValue(basicFacets[7]) > 0) {
                                                    stscState.error(XmlErrorCodes.DATATYPE_FRACTION_DIGITS_LE_TOTAL_DIGITS, (Object[]) null, facet3);
                                                }
                                                basicFacets[iTranslateFacetCode] = BuildNnInteger2;
                                            }
                                        } else {
                                            stscState.error("Must be a nonnegative integer", 20, facet3);
                                        }
                                        zArr = zArr2;
                                        iTranslateWhitespaceCode = i2;
                                        if (!facet3.getFixed()) {
                                        }
                                        break;
                                    case 9:
                                        iTranslateWhitespaceCode = translateWhitespaceCode(facet3.getValue());
                                        if (schemaTypeImpl2.getWhiteSpaceRule() > iTranslateWhitespaceCode) {
                                            stscState.error(XmlErrorCodes.DATATYPE_WHITESPACE_RESTRICTION, (Object[]) null, facet3);
                                            zArr = zArr2;
                                            iTranslateWhitespaceCode = 0;
                                            break;
                                        } else {
                                            basicFacets[iTranslateFacetCode] = StscState.build_wsstring(iTranslateWhitespaceCode).get();
                                            zArr = zArr2;
                                            if (!facet3.getFixed()) {
                                            }
                                        }
                                        break;
                                    case 10:
                                        try {
                                            RegularExpression regularExpression = new RegularExpression(facet3.getValue().getStringValue(), "X");
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(regularExpression);
                                            zArr = zArr2;
                                            iTranslateWhitespaceCode = i2;
                                            if (!facet3.getFixed()) {
                                            }
                                        } catch (ParseException e2) {
                                            stscState.error(XmlErrorCodes.PATTERN_REGEX, new Object[]{facet3.getValue().getStringValue(), e2.getMessage()}, facet3);
                                            break;
                                        }
                                        break;
                                    case 11:
                                        try {
                                            XmlAnySimpleType xmlAnySimpleTypeNewValue = schemaTypeImpl2.newValue(facet3.getValue(), true);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(xmlAnySimpleTypeNewValue);
                                            zArr = zArr2;
                                            iTranslateWhitespaceCode = i2;
                                            if (!facet3.getFixed()) {
                                            }
                                        } catch (XmlValueOutOfRangeException e3) {
                                            stscState.error(XmlErrorCodes.DATATYPE_ENUM_RESTRICTION, new Object[]{facet3.getValue().getStringValue(), e3.getMessage()}, facet3);
                                            break;
                                        }
                                        break;
                                    default:
                                        zArr = zArr2;
                                        iTranslateWhitespaceCode = i2;
                                        if (!facet3.getFixed()) {
                                        }
                                        break;
                                }
                            } else {
                                stscState.error(XmlErrorCodes.DATATYPE_SINGLE_FACET_VALUE, (Object[]) null, facet3);
                            }
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[c] = localPart;
                            objArr2[1] = QNameHelper.pretty(schemaTypeImpl2.getName());
                            stscState.error(XmlErrorCodes.FACETS_APPLICABLE, objArr2, facet3);
                        }
                        zArr = zArr2;
                        i2 = iTranslateWhitespaceCode;
                        iTranslateWhitespaceCode = i2;
                    }
                    firstChild = xmlCursorNewCursor.toNextSibling();
                    zArr2 = zArr;
                    c = 0;
                }
                int i5 = iTranslateWhitespaceCode;
                z = true;
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                whiteSpaceRule = i5;
            } finally {
            }
        } else {
            z = true;
            whiteSpaceRule = 0;
            arrayList = null;
            arrayList2 = null;
        }
        schemaTypeImpl.setBasicFacets(makeValueRefArray(basicFacets), fixedFacets);
        if (whiteSpaceRule == 0) {
            whiteSpaceRule = schemaTypeImpl2.getWhiteSpaceRule();
        }
        schemaTypeImpl.setWhiteSpaceRule(whiteSpaceRule);
        if (arrayList != null) {
            z2 = false;
            schemaTypeImpl.setEnumerationValues(makeValueRefArray((XmlAnySimpleType[]) arrayList.toArray(new XmlAnySimpleType[0])));
            if (schemaTypeImpl.isRedefinition()) {
                baseEnumType = schemaTypeImpl.getBaseType().getBaseEnumType();
                if (baseEnumType == null || schemaTypeImpl.getBaseType() == baseEnumType) {
                    baseEnumType = schemaTypeImpl;
                }
                schemaTypeImpl.setBaseEnumTypeRef(baseEnumType.getRef());
            } else {
                if (schemaTypeImpl.getBaseType().getBaseEnumType() != null) {
                    baseEnumType = schemaTypeImpl.getBaseType().getBaseEnumType();
                }
                schemaTypeImpl.setBaseEnumTypeRef(baseEnumType.getRef());
            }
        } else {
            z2 = false;
            schemaTypeImpl.copyEnumerationValues(schemaTypeImpl2);
        }
        RegularExpression[] regularExpressionArr = EMPTY_REGEX_ARRAY;
        if (arrayList2 != null) {
            regularExpressionArr = (RegularExpression[]) arrayList2.toArray(regularExpressionArr);
        }
        schemaTypeImpl.setPatternFacet((regularExpressionArr.length > 0 || schemaTypeImpl2.hasPatternFacet()) ? z : z2);
        schemaTypeImpl.setPatterns(regularExpressionArr);
        if (schemaTypeImpl2.getBuiltinTypeCode() == 8 && schemaTypeImpl.getEnumerationValues() == null) {
            stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlObject);
        }
    }

    static void resolveFundamentalFacets(SchemaTypeImpl schemaTypeImpl) {
        int simpleVariety = schemaTypeImpl.getSimpleVariety();
        if (simpleVariety == 1) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
            schemaTypeImpl.setOrdered(schemaTypeImpl2.ordered());
            schemaTypeImpl.setBounded(((schemaTypeImpl.getFacet(3) == null && schemaTypeImpl.getFacet(4) == null) || (schemaTypeImpl.getFacet(5) == null && schemaTypeImpl.getFacet(6) == null)) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl2.isFinite() || (schemaTypeImpl.isBounded() && isDiscreteType(schemaTypeImpl)));
            if (!schemaTypeImpl2.isNumeric() && !isNumericPrimitive(schemaTypeImpl.getPrimitiveType())) {
                z = false;
            }
            schemaTypeImpl.setNumeric(z);
            schemaTypeImpl.setDecimalSize(decimalSizeOfType(schemaTypeImpl));
            return;
        }
        if (simpleVariety != 2) {
            if (simpleVariety != 3) {
                return;
            }
            schemaTypeImpl.setOrdered(0);
            schemaTypeImpl.setBounded((schemaTypeImpl.getFacet(0) == null && schemaTypeImpl.getFacet(2) == null) ? false : true);
            schemaTypeImpl.setFinite(schemaTypeImpl.getListItemType().isFinite() && schemaTypeImpl.isBounded());
            schemaTypeImpl.setNumeric(false);
            schemaTypeImpl.setDecimalSize(0);
            return;
        }
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i2 = 0;
        for (SchemaType schemaType : schemaTypeImpl.getUnionMemberTypes()) {
            if (schemaType.ordered() != 0) {
                i2 = 1;
            }
            if (!schemaType.isBounded()) {
                z = false;
            }
            if (!schemaType.isFinite()) {
                z2 = false;
            }
            if (!schemaType.isNumeric()) {
                z3 = false;
            }
        }
        schemaTypeImpl.setOrdered(i2);
        schemaTypeImpl.setBounded(z);
        schemaTypeImpl.setFinite(z2);
        schemaTypeImpl.setNumeric(z3);
        schemaTypeImpl.setDecimalSize(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.apache.xmlbeans.impl.xb.xsdschema.SimpleType] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void resolveListType(SchemaTypeImpl schemaTypeImpl, ListDocument.List list, List<SchemaType> list2) {
        XmlQName xmlQNameXgetItemType;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        SchemaTypeImpl schemaTypeImpl2 = schemaTypeImpl;
        StscState stscState = StscState.get();
        schemaTypeImpl.setSimpleTypeVariety(3);
        SchemaTypeImpl schemaTypeImpl3 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl3.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl3.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.LIST}, list);
        }
        QName itemType = list.getItemType();
        LocalSimpleType simpleType = list.getSimpleType();
        if (itemType == null || simpleType == null) {
            xmlQNameXgetItemType = simpleType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_BOTH_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
            xmlQNameXgetItemType = null;
        }
        if (itemType != null) {
            schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(itemType, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            xmlQNameXgetItemType = list.xgetItemType();
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(itemType, 0, list.xgetItemType(), true);
                schemaTypeImplTranslateAnonymousSimpleType = schemaTypeImpl3;
            }
        } else {
            if (xmlQNameXgetItemType == null) {
                stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$LIST_HAS_NEITHER_ITEM_OR_SIMPLE_TYPE, (Object[]) null, list);
                resolveErrorSimpleType(schemaTypeImpl);
                return;
            }
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(xmlQNameXgetItemType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list2, schemaTypeImpl);
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalList()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$LIST_FINAL, (Object[]) null, list);
        }
        StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType);
        if (!schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_NOT_SIMPLE, (Object[]) null, xmlQNameXgetItemType);
            schemaTypeImpl2 = schemaTypeImpl3;
        }
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
                stscState.recover(XmlErrorCodes.DATATYPE_ENUM_NOTATION, null, xmlQNameXgetItemType);
            }
        } else if (simpleVariety == 2) {
            if (schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_UNION_OF_LIST, (Object[]) null, xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
            if (schemaTypeImpl2.getBuiltinTypeCode() == 8) {
            }
        } else {
            if (simpleVariety == 3) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$LIST_ITEM_IS_LIST, (Object[]) null, xmlQNameXgetItemType);
                resolveErrorSimpleType(schemaTypeImpl2);
                return;
            }
            schemaTypeImpl2.setListItemTypeRef(schemaTypeImpl3.getRef());
        }
        schemaTypeImpl2.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
        schemaTypeImpl2.setWhiteSpaceRule(3);
        resolveFundamentalFacets(schemaTypeImpl2);
    }

    static void resolveSimpleRestrictionType(SchemaTypeImpl schemaTypeImpl, RestrictionDocument.Restriction restriction, List<SchemaType> list) {
        LocalSimpleType localSimpleType;
        SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType;
        QName base = restriction.getBase();
        LocalSimpleType simpleType = restriction.getSimpleType();
        StscState stscState = StscState.get();
        if (base == null || simpleType == null) {
            localSimpleType = simpleType;
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_BOTH_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            localSimpleType = null;
        }
        if (base != null) {
            if (schemaTypeImpl.isRedefinition()) {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findRedefinedGlobalType(restriction.getBase(), schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl);
                if (schemaTypeImplTranslateAnonymousSimpleType != null && !schemaTypeImplTranslateAnonymousSimpleType.getName().equals(schemaTypeImpl.getName())) {
                    stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$SAME_TYPE, new Object[]{"<simpleType>", QNameHelper.pretty(base), QNameHelper.pretty(schemaTypeImpl.getName())}, restriction);
                }
            } else {
                schemaTypeImplTranslateAnonymousSimpleType = stscState.findGlobalType(base, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
            }
            if (schemaTypeImplTranslateAnonymousSimpleType == null) {
                stscState.notFoundError(base, 0, restriction.xgetBase(), true);
                schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
            }
        } else if (localSimpleType != null) {
            if (schemaTypeImpl.isRedefinition()) {
                StscState.get().error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{"<simpleType>"}, localSimpleType);
            }
            schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(localSimpleType, schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
        } else {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$RESTRICTION_HAS_NEITHER_BASE_OR_SIMPLE_TYPE, (Object[]) null, restriction);
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (!StscResolver.resolveType(schemaTypeImplTranslateAnonymousSimpleType)) {
            schemaTypeImplTranslateAnonymousSimpleType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        }
        if (schemaTypeImplTranslateAnonymousSimpleType.finalRestriction()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$RESTRICTION_FINAL, (Object[]) null, restriction);
        }
        schemaTypeImpl.setBaseTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImplTranslateAnonymousSimpleType.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        if (!schemaTypeImplTranslateAnonymousSimpleType.isSimpleType()) {
            stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$ATOMIC_NOT_SIMPLE, (Object[]) null, restriction.xgetBase());
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        schemaTypeImpl.setSimpleTypeVariety(schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety());
        int simpleVariety = schemaTypeImplTranslateAnonymousSimpleType.getSimpleVariety();
        if (simpleVariety == 1) {
            schemaTypeImpl.setPrimitiveTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getPrimitiveType().getRef());
        } else if (simpleVariety == 2) {
            schemaTypeImpl.setUnionOfLists(schemaTypeImplTranslateAnonymousSimpleType.isUnionOfLists());
            schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImplTranslateAnonymousSimpleType.getUnionMemberTypes())));
        } else if (simpleVariety == 3) {
            schemaTypeImpl.setListItemTypeRef(schemaTypeImplTranslateAnonymousSimpleType.getListItemType().getRef());
        }
        resolveFacets(schemaTypeImpl, restriction, schemaTypeImplTranslateAnonymousSimpleType);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void resolveSimpleType(SchemaTypeImpl schemaTypeImpl) {
        boolean zContains;
        SimpleType simpleType = (SimpleType) schemaTypeImpl.getParseObject();
        SchemaDocument.Schema schema = StscComplexTypeResolver.getSchema(simpleType);
        int i2 = (simpleType.isSetList() ? 1 : 0) + (simpleType.isSetUnion() ? 1 : 0) + (simpleType.isSetRestriction() ? 1 : 0);
        boolean z = true;
        if (i2 > 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: more than one found.", 52, simpleType);
        } else if (i2 < 1) {
            StscState.get().error("A simple type must define either a list, a union, or a restriction: none was found.", 52, simpleType);
            resolveErrorSimpleType(schemaTypeImpl);
            return;
        }
        Object finalDefault = null;
        if (simpleType.isSetFinal()) {
            finalDefault = simpleType.getFinal();
        } else if (schema != null && schema.isSetFinalDefault()) {
            finalDefault = schema.getFinalDefault();
        }
        if (finalDefault == null) {
            z = false;
            zContains = false;
        } else if (finalDefault instanceof String) {
            if ("#all".equals(finalDefault)) {
                z = true;
                zContains = true;
            }
        } else if (finalDefault instanceof List) {
            List list = (List) finalDefault;
            boolean zContains2 = list.contains("restriction");
            zContains = list.contains(XmlErrorCodes.LIST);
            z = list.contains(XmlErrorCodes.UNION);
            z = zContains2;
        }
        schemaTypeImpl.setSimpleFinal(z, zContains, z);
        ArrayList arrayList = new ArrayList();
        if (simpleType.getList() != null) {
            resolveListType(schemaTypeImpl, simpleType.getList(), arrayList);
        } else if (simpleType.getUnion() != null) {
            resolveUnionType(schemaTypeImpl, simpleType.getUnion(), arrayList);
        } else if (simpleType.getRestriction() != null) {
            resolveSimpleRestrictionType(schemaTypeImpl, simpleType.getRestriction(), arrayList);
        }
        schemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [org.apache.xmlbeans.XmlObject] */
    static void resolveUnionType(SchemaTypeImpl schemaTypeImpl, UnionDocument.Union union, List<SchemaType> list) {
        String str;
        UnionDocument.Union.MemberTypes memberTypesXgetMemberTypes;
        XmlObject xmlObjectXgetMemberTypes;
        schemaTypeImpl.setSimpleTypeVariety(2);
        SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        schemaTypeImpl.setBaseTypeRef(schemaTypeImpl2.getRef());
        schemaTypeImpl.setBaseDepth(schemaTypeImpl2.getBaseDepth() + 1);
        schemaTypeImpl.setDerivationType(1);
        StscState stscState = StscState.get();
        if (schemaTypeImpl.isRedefinition()) {
            stscState.error(XmlErrorCodes.SCHEMA_REDEFINE$EXTEND_OR_RESTRICT, new Object[]{XmlErrorCodes.UNION}, union);
        }
        List<QName> memberTypes = union.getMemberTypes();
        LocalSimpleType[] simpleTypeArray = union.getSimpleTypeArray();
        ArrayList arrayList = new ArrayList();
        if (simpleTypeArray.length == 0 && (memberTypes == null || memberTypes.isEmpty())) {
            stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$UNION_HAS_MEMBER_TYPES_OR_SIMPLE_TYPES, (Object[]) null, union);
        }
        if (memberTypes != null) {
            for (QName qName : memberTypes) {
                SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(qName, schemaTypeImpl.getChameleonNamespace(), schemaTypeImpl.getTargetNamespace());
                if (schemaTypeImplFindGlobalType == null) {
                    stscState.notFoundError(qName, 0, union.xgetMemberTypes(), true);
                } else {
                    arrayList.add(schemaTypeImplFindGlobalType);
                }
            }
        }
        int i2 = 0;
        while (i2 < simpleTypeArray.length) {
            SchemaTypeImpl schemaTypeImplTranslateAnonymousSimpleType = StscTranslator.translateAnonymousSimpleType(simpleTypeArray[i2], schemaTypeImpl.getTargetNamespace(), schemaTypeImpl.getChameleonNamespace() != null, schemaTypeImpl.getElemFormDefault(), schemaTypeImpl.getAttFormDefault(), list, schemaTypeImpl);
            arrayList.add(schemaTypeImplTranslateAnonymousSimpleType);
            i2++;
            schemaTypeImplTranslateAnonymousSimpleType.setAnonymousUnionMemberOrdinal(i2);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            String str2 = "";
            if (!it.hasNext()) {
                break;
            }
            SchemaTypeImpl schemaTypeImpl3 = (SchemaTypeImpl) it.next();
            if (!StscResolver.resolveType(schemaTypeImpl3)) {
                if (Objects.equals(schemaTypeImpl3.getOuterType(), schemaTypeImpl)) {
                    xmlObjectXgetMemberTypes = schemaTypeImpl3.getParseObject();
                } else {
                    str2 = QNameHelper.pretty(schemaTypeImpl3.getName()) + " ";
                    xmlObjectXgetMemberTypes = union.xgetMemberTypes();
                }
                stscState.error(XmlErrorCodes.SCHEMA_SIMPLE_TYPE$CYCLIC_UNION, new Object[]{str2}, xmlObjectXgetMemberTypes);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            SchemaTypeImpl schemaTypeImpl4 = (SchemaTypeImpl) it2.next();
            if (!schemaTypeImpl4.isSimpleType()) {
                if (schemaTypeImpl4.getOuterType() == null || !schemaTypeImpl4.getOuterType().equals(schemaTypeImpl)) {
                    str = QNameHelper.pretty(schemaTypeImpl4.getName()) + " ";
                    memberTypesXgetMemberTypes = union.xgetMemberTypes();
                } else {
                    memberTypesXgetMemberTypes = schemaTypeImpl4.getParseObject();
                    str = "";
                }
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_RESTRICTION$UNION_MEMBER_NOT_SIMPLE, new Object[]{str}, memberTypesXgetMemberTypes);
                it2.remove();
            } else if (schemaTypeImpl4.getSimpleVariety() == 3 || (schemaTypeImpl4.getSimpleVariety() == 2 && schemaTypeImpl4.isUnionOfLists())) {
                z = true;
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            if (((SchemaTypeImpl) it3.next()).finalUnion()) {
                stscState.error(XmlErrorCodes.SIMPLE_TYPE_PROPERTIES$UNION_FINAL, (Object[]) null, union);
            }
        }
        schemaTypeImpl.setUnionOfLists(z);
        schemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(arrayList));
        schemaTypeImpl.setBasicFacets(StscState.FACETS_UNION, StscState.FIXED_FACETS_UNION);
        resolveFundamentalFacets(schemaTypeImpl);
    }

    private static int translateFacetCode(QName qName) {
        return facetCodeMap.getOrDefault(qName, -1).intValue();
    }

    static int translateWhitespaceCode(XmlAnySimpleType xmlAnySimpleType) {
        String stringValue = xmlAnySimpleType.getStringValue();
        if (stringValue.equals("collapse")) {
            return 3;
        }
        if (stringValue.equals("preserve")) {
            return 1;
        }
        if (stringValue.equals("replace")) {
            return 2;
        }
        StscState.get().error("Unrecognized whitespace value \"" + stringValue + "\"", 20, xmlAnySimpleType);
        return 0;
    }
}
