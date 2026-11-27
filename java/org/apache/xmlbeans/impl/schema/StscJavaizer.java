package org.apache.xmlbeans.impl.schema;

import com.auto.exceldeps.log4j.Logger;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.UserType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.logging.XmlBeansLogManager;

/* loaded from: classes.dex */
public class StscJavaizer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_ENUM_COUNT = 3668;
    private static final Logger LOG = XmlBeansLogManager.getLogger(StscJavaizer.class);
    private static final String[] PREFIXES = {"get", "xget", "isNil", "isSet", "sizeOf", "set", "xset", "addNew", "setNil", "unset", "insert", "add", "insertNew", "addNew", "remove"};
    static String[] PROTECTED_PROPERTIES = {"StringValue", "BooleanValue", "ByteValue", "ShortValue", "IntValue", "LongValue", "BigIntegerValue", "BigDecimalValue", "FloatValue", "DoubleValue", "ByteArrayValue", "EnumValue", "CalendarValue", "DateValue", "GDateValue", "GDurationValue", "QNameValue", "ListValue", "ObjectValue", "Class"};
    static Set<String> PROTECTED_PROPERTIES_SET = new HashSet(Arrays.asList(PROTECTED_PROPERTIES));

    static void addAnonymousTypesFromRedefinition(SchemaType schemaType, List<SchemaType> list) {
        while (((SchemaTypeImpl) schemaType).isRedefinition()) {
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            }
            schemaType = schemaType.getBaseType();
            SchemaType[] anonymousTypes = schemaType.getAnonymousTypes();
            if (anonymousTypes.length > 0) {
                list.addAll(Arrays.asList(anonymousTypes));
            }
        }
    }

    static void assignGlobalJavaNames(Collection<SchemaType> collection) throws IllegalArgumentException {
        HashSet hashSet = new HashSet();
        StscState stscState = StscState.get();
        Iterator<SchemaType> it = collection.iterator();
        while (it.hasNext()) {
            SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) it.next();
            String javaname = stscState.getJavaname(findTopName(schemaTypeImpl), schemaTypeImpl.isDocumentType() ? 2 : 1);
            if (schemaTypeImpl.isUnjavaized()) {
                schemaTypeImpl.setFullJavaName(pickFullJavaClassName(hashSet, findTopName(schemaTypeImpl), javaname, schemaTypeImpl.isDocumentType(), schemaTypeImpl.isAttributeType()));
                schemaTypeImpl.setFullJavaImplName(pickFullJavaImplName(hashSet, schemaTypeImpl.getFullJavaName()));
                setExtensions(schemaTypeImpl, stscState);
            }
        }
        setUserTypes(stscState);
        verifyInterfaceNameCollisions(hashSet, stscState);
    }

    static void assignJavaAnonymousTypeNames(SchemaTypeImpl schemaTypeImpl) throws IllegalArgumentException {
        String javaname;
        String localPart;
        HashSet hashSet = new HashSet();
        SchemaType[] anonymousTypes = schemaTypeImpl.getAnonymousTypes();
        StscState stscState = StscState.get();
        int length = anonymousTypes.length;
        if (schemaTypeImpl.isRedefinition()) {
            ArrayList arrayList = new ArrayList();
            addAnonymousTypesFromRedefinition(schemaTypeImpl, arrayList);
            if (!arrayList.isEmpty()) {
                SchemaType[] schemaTypeArr = new SchemaType[arrayList.size() + length];
                arrayList.toArray(schemaTypeArr);
                System.arraycopy(anonymousTypes, 0, schemaTypeArr, arrayList.size(), length);
                anonymousTypes = schemaTypeArr;
            }
        }
        for (SchemaType outerType = schemaTypeImpl; outerType != null; outerType = outerType.getOuterType()) {
            hashSet.add(outerType.getShortJavaName());
        }
        for (SchemaType outerType2 = schemaTypeImpl; outerType2 != null; outerType2 = outerType2.getOuterType()) {
            hashSet.add(outerType2.getShortJavaImplName());
        }
        hashSet.add(getOutermostPackage(schemaTypeImpl.getFullJavaName()));
        for (int i2 = 0; i2 < anonymousTypes.length; i2++) {
            SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) anonymousTypes[i2];
            if (schemaTypeImpl2 != null && !schemaTypeImpl2.isSkippedAnonymousType()) {
                if (schemaTypeImpl2.getContainerField() != null) {
                    localPart = schemaTypeImpl2.getContainerField().getName().getLocalPart();
                    javaname = stscState.getJavaname(schemaTypeImpl2.getContainerField().getName(), 1);
                } else {
                    int simpleVariety = schemaTypeImpl2.getOuterType().getSimpleVariety();
                    javaname = simpleVariety != 2 ? simpleVariety != 3 ? "Base" : "Item" : "Member";
                    localPart = null;
                }
                if (i2 < length) {
                    schemaTypeImpl2.setShortJavaName(pickInnerJavaClassName(hashSet, localPart, javaname));
                    schemaTypeImpl2.setShortJavaImplName(pickInnerJavaImplName(hashSet, localPart, javaname != null ? javaname + "Impl" : null));
                } else {
                    schemaTypeImpl2.setFullJavaName(schemaTypeImpl.getFullJavaName() + "$" + pickInnerJavaClassName(hashSet, localPart, javaname));
                    StringBuilder sb = new StringBuilder();
                    sb.append(schemaTypeImpl.getFullJavaImplName());
                    sb.append("$");
                    sb.append(pickInnerJavaImplName(hashSet, localPart, javaname != null ? javaname + "Impl" : null));
                    schemaTypeImpl2.setFullJavaImplName(sb.toString());
                }
                setExtensions(schemaTypeImpl2, stscState);
            }
        }
    }

    static void assignJavaPropertyNames(Set<String> set, SchemaProperty[] schemaPropertyArr, SchemaType schemaType, boolean z) {
        StscState stscState = StscState.get();
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            SchemaProperty attributeProperty = schemaPropertyImpl.isAttribute() ? schemaType.getAttributeProperty(schemaPropertyImpl.getName()) : schemaType.getElementProperty(schemaPropertyImpl.getName());
            if ((attributeProperty == null) != z) {
                QName name = schemaPropertyImpl.getName();
                schemaPropertyImpl.setJavaPropertyName(attributeProperty == null ? pickJavaPropertyName(set, name.getLocalPart(), stscState.getJavaname(name, schemaPropertyImpl.isAttribute() ? 4 : 3)) : attributeProperty.getJavaPropertyName());
                boolean z2 = schemaPropertyImpl.getMaxOccurs() == null || schemaPropertyImpl.getMaxOccurs().compareTo(BigInteger.ONE) > 0;
                boolean z3 = !z2 && schemaPropertyImpl.getMaxOccurs().signum() > 0;
                boolean z4 = z3 && schemaPropertyImpl.getMinOccurs().signum() == 0;
                SchemaType type = schemaPropertyImpl.getType();
                if (attributeProperty != null) {
                    if (attributeProperty.extendsJavaArray()) {
                        z3 = false;
                        z4 = false;
                        z2 = true;
                    }
                    if (attributeProperty.extendsJavaSingleton()) {
                        z3 = true;
                    }
                    boolean z5 = attributeProperty.extendsJavaOption() ? true : z4;
                    type = attributeProperty.javaBasedOnType();
                    z4 = z5;
                }
                schemaPropertyImpl.setExtendsJava(type.getRef(), z3, z4, z2);
            }
        }
    }

    static void assignJavaTypeCodes(SchemaProperty[] schemaPropertyArr) {
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaProperty;
            schemaPropertyImpl.setJavaTypeCode(javaTypeCodeForType(schemaPropertyImpl.javaBasedOnType()));
        }
    }

    private static void avoidExtensionMethods(Set<String> set, SchemaTypeImpl schemaTypeImpl) {
        InterfaceExtension[] interfaceExtensions = schemaTypeImpl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                for (InterfaceExtension.MethodSignature methodSignature : interfaceExtension.getMethods()) {
                    String name = methodSignature.getName();
                    for (String str : PREFIXES) {
                        if (name.startsWith(str)) {
                            set.add(name.substring(str.length()));
                        }
                    }
                }
            }
        }
    }

    static QName findTopName(SchemaType schemaType) {
        if (schemaType.getName() != null) {
            return schemaType.getName();
        }
        if (schemaType.isDocumentType()) {
            if (schemaType.getContentModel() == null || schemaType.getContentModel().getParticleType() != 4) {
                throw new IllegalStateException();
            }
            return schemaType.getDocumentElementName();
        }
        if (!schemaType.isAttributeType()) {
            return schemaType.getContainerField().getName();
        }
        if (schemaType.getAttributeModel() == null || schemaType.getAttributeModel().getAttributes().length != 1) {
            throw new IllegalStateException();
        }
        return schemaType.getAttributeTypeAttributeName();
    }

    static String getOutermostPackage(String str) {
        int iIndexOf;
        return (str != null && (iIndexOf = str.indexOf(46)) >= 0) ? str.substring(0, iIndexOf) : "";
    }

    static boolean isPropertyModelOrderInsensitive(SchemaProperty[] schemaPropertyArr) {
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            if (schemaProperty.hasNillable() == 1 || schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1) {
                return false;
            }
            if (schemaProperty.hasDefault() != 0 && schemaProperty.getDefaultText() == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStringType(SchemaType schemaType) {
        return schemaType != null && schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 12;
    }

    static int javaTypeCodeForType(SchemaType schemaType) {
        if (!schemaType.isSimpleType()) {
            return 0;
        }
        if (((SchemaTypeImpl) schemaType).getUserTypeHandlerName() != null) {
            return 20;
        }
        if (schemaType.getSimpleVariety() == 2) {
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType == null || unionCommonBaseType.isURType()) {
                return javaTypeCodeInCommon(schemaType.getUnionConstituentTypes());
            }
            schemaType = unionCommonBaseType;
        }
        if (schemaType.getSimpleVariety() == 3) {
            return 16;
        }
        if (schemaType.isURType()) {
            return 0;
        }
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return 10;
            case 3:
                return 1;
            case 4:
            case 5:
                return 11;
            case 6:
                return 10;
            case 7:
                return 15;
            case 8:
                return 0;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8) {
                    return 4;
                }
                if (decimalSize == 16) {
                    return 5;
                }
                if (decimalSize == 32) {
                    return 6;
                }
                if (decimalSize != 64) {
                    return decimalSize != 1000000 ? 8 : 9;
                }
                return 7;
            case 12:
                if (isStringType(schemaType.getBaseEnumType())) {
                    return (schemaType.getEnumerationValues() == null || schemaType.getEnumerationValues().length <= MAX_ENUM_COUNT) ? 18 : 10;
                }
                return 10;
            case 13:
                return 13;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return 17;
            default:
                throw new IllegalStateException("unrecognized code " + schemaType.getPrimitiveType().getBuiltinTypeCode() + " of " + schemaType.getPrimitiveType().getName());
        }
    }

    static int javaTypeCodeInCommon(SchemaType[] schemaTypeArr) {
        int iJavaTypeCodeForType = 0;
        if (schemaTypeArr != null && schemaTypeArr.length != 0) {
            iJavaTypeCodeForType = javaTypeCodeForType(schemaTypeArr[0]);
            if (iJavaTypeCodeForType == 19) {
                return iJavaTypeCodeForType;
            }
            for (int i2 = 1; i2 < schemaTypeArr.length; i2++) {
                if (iJavaTypeCodeForType != javaTypeCodeForType(schemaTypeArr[i2])) {
                    return 19;
                }
            }
        }
        return iJavaTypeCodeForType;
    }

    public static void javaizeAllTypes(boolean z) throws IllegalArgumentException {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        if (z) {
            assignGlobalJavaNames(arrayList);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i2);
            if (z) {
                javaizeType((SchemaTypeImpl) schemaType);
                String fullJavaName = schemaType.getFullJavaName();
                if (fullJavaName != null) {
                    stscState.addClassname(fullJavaName.replace('$', NameUtil.PERIOD), schemaType);
                }
            } else {
                skipJavaizingType((SchemaTypeImpl) schemaType);
            }
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
            addAnonymousTypesFromRedefinition(schemaType, arrayList);
        }
    }

    static void javaizeType(SchemaTypeImpl schemaTypeImpl) throws IllegalArgumentException {
        if (schemaTypeImpl.isJavaized()) {
            return;
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        if (schemaTypeImpl2 != null) {
            javaizeType(schemaTypeImpl2);
        }
        if (schemaTypeImpl.getContentBasedOnType() != null && schemaTypeImpl.getContentBasedOnType() != schemaTypeImpl2) {
            javaizeType((SchemaTypeImpl) schemaTypeImpl.getContentBasedOnType());
        }
        schemaTypeImpl.startJavaizing();
        schemaTypeImpl.setCompiled(true);
        secondPassProcessType(schemaTypeImpl);
        if (!schemaTypeImpl.isSimpleType()) {
            SchemaProperty[] elementProperties = schemaTypeImpl.getElementProperties();
            SchemaProperty[] attributeProperties = schemaTypeImpl.getAttributeProperties();
            HashSet hashSet = new HashSet();
            for (SchemaProperty schemaProperty : schemaTypeImpl2.getProperties()) {
                hashSet.add(schemaProperty.getJavaPropertyName());
            }
            avoidExtensionMethods(hashSet, schemaTypeImpl);
            boolean z = true;
            while (true) {
                if (elementProperties.length > 0) {
                    assignJavaPropertyNames(hashSet, elementProperties, schemaTypeImpl2, z);
                }
                assignJavaPropertyNames(hashSet, attributeProperties, schemaTypeImpl2, z);
                if (!z) {
                    break;
                } else {
                    z = false;
                }
            }
            SchemaProperty[] properties = schemaTypeImpl.getProperties();
            boolean zIsPropertyModelOrderInsensitive = isPropertyModelOrderInsensitive(properties);
            assignJavaTypeCodes(properties);
            schemaTypeImpl.setOrderSensitive(!zIsPropertyModelOrderInsensitive);
        }
        if (schemaTypeImpl.getFullJavaName() != null || schemaTypeImpl.getOuterType() != null) {
            assignJavaAnonymousTypeNames(schemaTypeImpl);
        }
        schemaTypeImpl.finishJavaizing();
    }

    static String pickConstantName(Set<String> set, String str) {
        String strUpperCaseUnderbar = NameUtil.upperCaseUnderbar(str);
        if (strUpperCaseUnderbar.isEmpty()) {
            strUpperCaseUnderbar = "X";
        }
        if (strUpperCaseUnderbar.startsWith("INT_")) {
            strUpperCaseUnderbar = "X_" + strUpperCaseUnderbar;
        }
        String str2 = strUpperCaseUnderbar;
        int i2 = 1;
        while (set.contains(str2)) {
            i2++;
            str2 = strUpperCaseUnderbar + "_" + i2;
        }
        set.add(str2);
        return str2;
    }

    static String pickFullJavaClassName(Set<String> set, QName qName, String str, boolean z, boolean z2) {
        boolean zProtectReservedGlobalClassNames;
        String str2;
        if (str == null || str.indexOf(46) < 0) {
            StscState stscState = StscState.get();
            String namespaceURI = qName.getNamespaceURI();
            String classNameFromQName = NameUtil.getClassNameFromQName(qName);
            String packageOverride = stscState.getPackageOverride(namespaceURI);
            if (packageOverride != null) {
                classNameFromQName = packageOverride + "." + classNameFromQName.substring(classNameFromQName.lastIndexOf(46) + 1);
            }
            String javaPrefix = stscState.getJavaPrefix(namespaceURI);
            if (javaPrefix != null) {
                classNameFromQName = classNameFromQName.substring(0, classNameFromQName.lastIndexOf(46) + 1) + javaPrefix + classNameFromQName.substring(classNameFromQName.lastIndexOf(46) + 1);
            }
            if (str != null) {
                classNameFromQName = classNameFromQName.substring(0, classNameFromQName.lastIndexOf(46) + 1) + str;
            }
            boolean zProtectReservedGlobalClassNames2 = protectReservedGlobalClassNames(classNameFromQName);
            if (str == null) {
                if (z) {
                    classNameFromQName = classNameFromQName + "Document";
                } else if (z2) {
                    classNameFromQName = classNameFromQName + "Attribute";
                }
                str = classNameFromQName;
                String javaSuffix = stscState.getJavaSuffix(namespaceURI);
                if (javaSuffix != null) {
                    str = str + javaSuffix;
                }
            } else {
                str = classNameFromQName;
            }
            zProtectReservedGlobalClassNames = zProtectReservedGlobalClassNames2;
        } else {
            zProtectReservedGlobalClassNames = protectReservedGlobalClassNames(str);
        }
        String outermostPackage = getOutermostPackage(str);
        if (zProtectReservedGlobalClassNames) {
            str2 = str + 1;
        } else {
            str2 = str;
        }
        int i2 = 1;
        while (true) {
            Locale locale = Locale.ROOT;
            if (!set.contains(str2.toLowerCase(locale)) && !str2.equals(outermostPackage)) {
                set.add(str2.toLowerCase(locale));
                return str2;
            }
            i2++;
            str2 = str + i2;
        }
    }

    static String pickFullJavaImplName(Set<String> set, String str) {
        String strSubstring;
        String strSubstring2;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            strSubstring = str.substring(iLastIndexOf + 1);
            strSubstring2 = str.substring(0, iLastIndexOf);
        } else {
            strSubstring = str;
            strSubstring2 = null;
        }
        String str2 = strSubstring2 + ".impl." + strSubstring + "Impl";
        String str3 = str2;
        int i2 = 1;
        while (true) {
            Locale locale = Locale.ROOT;
            if (!set.contains(str3.toLowerCase(locale))) {
                set.add(str3.toLowerCase(locale));
                return str3;
            }
            i2++;
            str3 = str2 + i2;
        }
    }

    static String pickInnerJavaClassName(Set<String> set, String str, String str2) {
        String str3;
        if (str2 == null) {
            str2 = NameUtil.upperCamelCase(str);
        }
        if (protectReservedInnerClassNames(str2)) {
            str3 = str2 + 1;
        } else {
            str3 = str2;
        }
        int i2 = 1;
        while (set.contains(str3)) {
            i2++;
            str3 = str2 + i2;
        }
        set.add(str3);
        return str3;
    }

    static String pickInnerJavaImplName(Set<String> set, String str, String str2) {
        if (str2 == null) {
            str2 = NameUtil.upperCamelCase(str) + "Impl";
        }
        int i2 = 1;
        String str3 = str2;
        while (set.contains(str3)) {
            i2++;
            str3 = str2 + i2;
        }
        set.add(str3);
        return str3;
    }

    static String pickJavaPropertyName(Set<String> set, String str, String str2) {
        String str3;
        if (str2 == null) {
            str2 = NameUtil.upperCamelCase(str);
        }
        if (protectReservedPropertyNames(str2)) {
            str3 = str2 + 1;
        } else {
            str3 = str2;
        }
        int i2 = 1;
        while (set.contains(str3)) {
            i2++;
            str3 = str2 + i2;
        }
        set.add(str3);
        return str3;
    }

    static boolean protectReservedGlobalClassNames(String str) {
        String strSubstring = str.substring(str.lastIndexOf(46) + 1);
        return strSubstring.endsWith("Document") && !strSubstring.equals("Document");
    }

    static boolean protectReservedInnerClassNames(String str) {
        return str.equals("Enum") || str.equals("Factory");
    }

    static boolean protectReservedPropertyNames(String str) {
        return PROTECTED_PROPERTIES_SET.contains(str) || (str.endsWith(SoapEncSchemaTypeSystem.SOAP_ARRAY) && !str.equals(SoapEncSchemaTypeSystem.SOAP_ARRAY));
    }

    static void secondPassProcessType(SchemaTypeImpl schemaTypeImpl) {
        XmlAnySimpleType[] enumerationValues;
        if (isStringType(schemaTypeImpl) && (enumerationValues = schemaTypeImpl.getEnumerationValues()) != null) {
            if (enumerationValues.length > MAX_ENUM_COUNT) {
                StscState.get().warning("SchemaType Enumeration found with too many enumeration values to create a Java enumeration. The base SchemaType \"" + schemaTypeImpl.getBaseEnumType() + "\" will be used instead", 1, (XmlObject) null);
                return;
            }
            SchemaType baseEnumType = schemaTypeImpl.getBaseEnumType();
            if (baseEnumType == null) {
                return;
            }
            SchemaStringEnumEntry[] schemaStringEnumEntryArr = new SchemaStringEnumEntry[enumerationValues.length];
            int i2 = 0;
            if (baseEnumType == schemaTypeImpl) {
                HashSet hashSet = new HashSet();
                while (i2 < enumerationValues.length) {
                    String stringValue = enumerationValues[i2].getStringValue();
                    int i3 = i2 + 1;
                    schemaStringEnumEntryArr[i2] = new SchemaStringEnumEntryImpl(stringValue, i3, pickConstantName(hashSet, stringValue));
                    i2 = i3;
                }
            } else {
                while (i2 < enumerationValues.length) {
                    schemaStringEnumEntryArr[i2] = baseEnumType.enumEntryForString(enumerationValues[i2].getStringValue());
                    i2++;
                }
            }
            schemaTypeImpl.setStringEnumEntries(schemaStringEnumEntryArr);
        }
    }

    private static void setExtensions(SchemaTypeImpl schemaTypeImpl, StscState stscState) throws IllegalArgumentException {
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (fullJavaName == null || bindingConfig == null) {
            return;
        }
        schemaTypeImpl.setInterfaceExtensions(bindingConfig.getInterfaceExtensions(fullJavaName));
        schemaTypeImpl.setPrePostExtension(bindingConfig.getPrePostExtension(fullJavaName));
    }

    private static void setUserTypes(StscState stscState) throws IllegalArgumentException {
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (bindingConfig != null) {
            for (UserType userType : bindingConfig.getUserTypes()) {
                SchemaTypeImpl schemaTypeImplFindGlobalType = stscState.findGlobalType(userType.getName(), null, null);
                if (schemaTypeImplFindGlobalType != null) {
                    schemaTypeImplFindGlobalType.setUserTypeName(userType.getJavaName());
                    schemaTypeImplFindGlobalType.setUserTypeHandlerName(userType.getStaticHandler());
                } else {
                    LOG.atWarn().log("Cannot match user type for {}", userType.getName());
                }
            }
        }
    }

    static void skipJavaizingType(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.isJavaized()) {
            return;
        }
        SchemaTypeImpl schemaTypeImpl2 = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        if (schemaTypeImpl2 != null) {
            skipJavaizingType(schemaTypeImpl2);
        }
        schemaTypeImpl.startJavaizing();
        secondPassProcessType(schemaTypeImpl);
        schemaTypeImpl.finishJavaizing();
    }

    private static void verifyInterfaceNameCollisions(Set<String> set, StscState stscState) throws IllegalArgumentException {
        BindingConfig bindingConfig = stscState.getBindingConfig();
        if (bindingConfig == null) {
            return;
        }
        for (InterfaceExtension interfaceExtension : bindingConfig.getInterfaceExtensions()) {
            String str = interfaceExtension.getInterface();
            Locale locale = Locale.ROOT;
            if (set.contains(str.toLowerCase(locale))) {
                stscState.error("InterfaceExtension interface '" + interfaceExtension.getInterface() + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject) null);
            }
            String staticHandler = interfaceExtension.getStaticHandler();
            if (staticHandler != null && set.contains(staticHandler.toLowerCase(locale))) {
                stscState.error("InterfaceExtension handler class '" + staticHandler + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject) null);
            }
        }
        for (PrePostExtension prePostExtension : bindingConfig.getPrePostExtensions()) {
            String staticHandler2 = prePostExtension.getStaticHandler();
            if (staticHandler2 != null && set.contains(staticHandler2.toLowerCase(Locale.ROOT))) {
                stscState.error("PrePostExtension handler class '" + staticHandler2 + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject) null);
            }
        }
    }
}
