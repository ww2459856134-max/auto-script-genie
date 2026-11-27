package org.apache.xmlbeans.impl.schema;

import com.auto.exceldeps.log4j.message.StructuredDataId;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.InterfaceExtension;
import org.apache.xmlbeans.PrePostExtension;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.apache.xmlbeans.impl.repackage.Repackager;

/* loaded from: classes.dex */
public final class SchemaTypeCodePrinter implements SchemaCodePrinter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_NEW_VALUE = 3;
    private static final int INDENT_INCREMENT = 4;
    static final String INDEX_CLASSNAME = "TypeSystemHolder";
    private static final String MAX_SPACES = "                                        ";
    private static final int NOTHING = 1;
    private static final int THROW_EXCEPTION = 4;
    private int _indent = 0;
    private Writer _writer;
    private XmlOptions opt;

    private static class Identifier {
        private final int getindex;
        private Integer setindex;

        public String getIdentifier() {
            return "PROPERTY_QNAME[" + this.getindex + "]";
        }

        public String getSetIdentifier() {
            if (this.setindex == null) {
                return getIdentifier();
            }
            return "PROPERTY_QSET[" + this.setindex + "]";
        }

        public void setSetIndex(int i2) {
            this.setindex = Integer.valueOf(i2);
        }

        private Identifier(int i2) {
            this.setindex = null;
            this.getindex = i2;
        }
    }

    private void emitSpecializedAccessors(SchemaType schemaType) throws IOException {
        int decimalSize;
        if (schemaType.getSimpleVariety() == 1 && schemaType.getPrimitiveType().getBuiltinTypeCode() == 11 && ((decimalSize = schemaType.getDecimalSize()) != schemaType.getBaseType().getDecimalSize() || schemaType.getBaseType().getFullJavaName() == null)) {
            if (decimalSize == 8) {
                emit("byte getByteValue();", XmlOptions.BeanMethod.GET);
                emit("void setByteValue(byte b);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 16) {
                emit("short getShortValue();", XmlOptions.BeanMethod.GET);
                emit("void setShortValue(short s);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 32) {
                emit("int getIntValue();", XmlOptions.BeanMethod.GET);
                emit("void setIntValue(int i);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 64) {
                emit("long getLongValue();", XmlOptions.BeanMethod.GET);
                emit("void setLongValue(long l);", XmlOptions.BeanMethod.SET);
            } else if (decimalSize == 1000000) {
                emit("java.math.BigInteger getBigIntegerValue();", XmlOptions.BeanMethod.GET);
                emit("void setBigIntegerValue(java.math.BigInteger bi);", XmlOptions.BeanMethod.SET);
            }
        }
        if (schemaType.getSimpleVariety() == 2) {
            emit("java.lang.Object getObjectValue();", XmlOptions.BeanMethod.GET);
            emit("void setObjectValue(java.lang.Object val);", XmlOptions.BeanMethod.SET);
            emit("org.apache.xmlbeans.SchemaType instanceType();", XmlOptions.BeanMethod.INSTANCE_TYPE);
            SchemaType unionCommonBaseType = schemaType.getUnionCommonBaseType();
            if (unionCommonBaseType != null && unionCommonBaseType.getSimpleVariety() != 2) {
                emitSpecializedAccessors(unionCommonBaseType);
            }
        }
        if (schemaType.getSimpleVariety() == 3) {
            emit("java.util.List getListValue();", XmlOptions.BeanMethod.GET_LIST);
            emit("java.util.List xgetListValue();", XmlOptions.BeanMethod.XGET_LIST);
            emit("void setListValue(java.util.List<?> list);", XmlOptions.BeanMethod.SET_LIST);
        }
    }

    static SchemaType findBaseType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType;
    }

    private SchemaProperty[] getDerivedProperties(SchemaType schemaType) {
        QName name = schemaType.getName();
        if (name == null || !name.equals(schemaType.getBaseType().getName())) {
            return schemaType.getDerivedProperties();
        }
        SchemaProperty[] derivedProperties = schemaType.getDerivedProperties();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SchemaProperty schemaProperty : derivedProperties) {
            linkedHashMap.put(schemaProperty.getName(), schemaProperty);
        }
        for (SchemaType baseType = schemaType.getBaseType(); baseType != null && name.equals(baseType.getName()); baseType = baseType.getBaseType()) {
            for (SchemaProperty schemaProperty2 : baseType.getDerivedProperties()) {
                if (!linkedHashMap.containsKey(schemaProperty2.getName())) {
                    linkedHashMap.put(schemaProperty2.getName(), schemaProperty2);
                }
            }
        }
        return (SchemaProperty[]) linkedHashMap.values().toArray(new SchemaProperty[0]);
    }

    private static String getExtensionInterfaces(SchemaType schemaType) {
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        InterfaceExtension[] interfaceExtensions = impl.getInterfaceExtensions();
        if (interfaceExtensions != null) {
            for (InterfaceExtension interfaceExtension : interfaceExtensions) {
                sb.append(", ");
                sb.append(interfaceExtension.getInterface());
            }
        }
        return sb.toString();
    }

    private String getFullJavaName(SchemaType schemaType) {
        SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl) schemaType;
        String fullJavaName = schemaTypeImpl.getFullJavaName();
        while (schemaTypeImpl != null && schemaTypeImpl.isRedefinition()) {
            fullJavaName = schemaTypeImpl.getFullJavaName();
            schemaTypeImpl = (SchemaTypeImpl) schemaTypeImpl.getBaseType();
        }
        return fullJavaName;
    }

    private static SchemaTypeImpl getImpl(SchemaType schemaType) {
        if (schemaType instanceof SchemaTypeImpl) {
            return (SchemaTypeImpl) schemaType;
        }
        return null;
    }

    private String getUserTypeStaticHandlerMethod(boolean z, SchemaTypeImpl schemaTypeImpl) {
        String upperCase;
        String localPart = schemaTypeImpl.getName().getLocalPart();
        if (localPart.length() < 2) {
            upperCase = localPart.toUpperCase(Locale.ROOT);
        } else {
            upperCase = localPart.substring(0, 1).toUpperCase(Locale.ROOT) + localPart.substring(1);
        }
        if (z) {
            return schemaTypeImpl.getUserTypeHandlerName() + ".encode" + upperCase;
        }
        return schemaTypeImpl.getUserTypeHandlerName() + ".decode" + upperCase;
    }

    private boolean hasBase(SchemaType schemaType) {
        SchemaType baseEnumType = schemaType.getBaseEnumType();
        if (baseEnumType.isAnonymousType() && baseEnumType.isSkippedAnonymousType()) {
            if (schemaType.getContentBasedOnType() != null) {
                if (schemaType.getContentBasedOnType().getBaseType() != baseEnumType) {
                    return true;
                }
            } else if (schemaType.getBaseType() != baseEnumType) {
                return true;
            }
        } else if (baseEnumType != schemaType) {
            return true;
        }
        return false;
    }

    public static String indexClassForSystem(SchemaTypeSystem schemaTypeSystem) {
        return schemaTypeSystem.getName() + "." + INDEX_CLASSNAME;
    }

    static boolean isJavaPrimitive(int i2) {
        return i2 >= 1 && i2 <= 7;
    }

    public static String javaStringEscape(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\"' || cCharAt == '\\') {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 == '\n') {
                        sb.append("\\n");
                    } else if (cCharAt2 == '\r') {
                        sb.append("\\r");
                    } else if (cCharAt2 == '\"') {
                        sb.append("\\\"");
                    } else if (cCharAt2 != '\\') {
                        sb.append(cCharAt2);
                    } else {
                        sb.append("\\\\");
                    }
                }
                return sb.toString();
            }
        }
        return str;
    }

    static String javaWrappedType(int i2) {
        switch (i2) {
            case 1:
                return "java.lang.Boolean";
            case 2:
                return "java.lang.Float";
            case 3:
                return "java.lang.Double";
            case 4:
                return "java.lang.Byte";
            case 5:
                return "java.lang.Short";
            case 6:
                return "java.lang.Integer";
            case 7:
                return "java.lang.Long";
            default:
                throw new IllegalStateException();
        }
    }

    private static String makeSafe(String str) {
        CharsetEncoder charsetEncoderNewEncoder = Charset.defaultCharset().newEncoder();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length() && charsetEncoderNewEncoder.canEncode(str.charAt(i2))) {
            i2++;
        }
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (charsetEncoderNewEncoder.canEncode(cCharAt)) {
                sb.append(cCharAt);
            } else {
                String hexString = Integer.toHexString(cCharAt);
                int length = hexString.length();
                if (length == 1) {
                    sb.append("\\u000");
                    sb.append(hexString);
                } else if (length == 2) {
                    sb.append("\\u00");
                    sb.append(hexString);
                } else if (length == 3) {
                    sb.append("\\u0");
                    sb.append(hexString);
                } else {
                    if (length != 4) {
                        throw new IllegalStateException();
                    }
                    sb.append("\\u");
                    sb.append(hexString);
                }
            }
            i2++;
        }
        return sb.toString();
    }

    static String prettyQName(QName qName) {
        if (qName == null) {
            return "";
        }
        String localPart = qName.getLocalPart();
        if (qName.getNamespaceURI() == null) {
            return localPart;
        }
        return localPart + "(@" + qName.getNamespaceURI() + ")";
    }

    private void printExtensionImplMethods(SchemaType schemaType) throws IOException {
        InterfaceExtension[] interfaceExtensions;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (interfaceExtensions = impl.getInterfaceExtensions()) == null) {
            return;
        }
        for (InterfaceExtension interfaceExtension : interfaceExtensions) {
            InterfaceExtension.MethodSignature[] methods = interfaceExtension.getMethods();
            if (methods != null) {
                for (InterfaceExtension.MethodSignature methodSignature : methods) {
                    printJavaDoc("Implementation method for interface " + interfaceExtension.getStaticHandler());
                    printInterfaceMethodDecl(methodSignature);
                    startBlock();
                    printInterfaceMethodImpl(interfaceExtension.getStaticHandler(), methodSignature);
                    endBlock();
                }
            }
        }
    }

    static boolean xmlTypeForPropertyIsUnion(SchemaProperty schemaProperty) {
        SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
        return schemaTypeJavaBasedOnType.isSimpleType() && schemaTypeJavaBasedOnType.getSimpleVariety() == 2;
    }

    void emit(String str, XmlOptions.BeanMethod beanMethod) throws IOException {
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod == null || compilePartialMethod.contains(beanMethod)) {
            emit(str);
        }
    }

    void emitAddTarget(String str, boolean z, String str2) throws IOException {
        if (z) {
            emit("target = (" + str2 + ")get_store().add_attribute_user(" + str + ");");
            return;
        }
        emit("target = (" + str2 + ")get_store().add_element_user(" + str + ");");
    }

    void emitGetTarget(String str, String str2, boolean z, String str3, int i2, String str4) throws IOException {
        emit(str4 + " target = null;");
        if (z) {
            emit("target = (" + str4 + ")get_store().find_attribute_user(" + str2 + ");");
        } else {
            emit("target = (" + str4 + ")get_store().find_element_user(" + str + ", " + str3 + ");");
        }
        if (i2 == 1) {
            return;
        }
        emit("if (target == null) {");
        startBlock();
        if (i2 == 3) {
            emitAddTarget(str2, z, str4);
        } else if (i2 == 4) {
            emit("throw new IndexOutOfBoundsException();");
        }
        endBlock();
    }

    void emitImplementationPostamble() throws IOException {
        outdent();
        emit("}");
    }

    void emitImplementationPreamble() throws IOException {
        emit("synchronized (monitor()) {");
        indent();
        emit("check_orphaned();");
    }

    void emitPost(SchemaType schemaType, int i2, String str, boolean z) throws IOException {
        emitPost(schemaType, i2, str, z, StructuredDataId.RESERVED);
    }

    void emitPre(SchemaType schemaType, int i2, String str, boolean z) throws IOException {
        emitPre(schemaType, i2, str, z, StructuredDataId.RESERVED);
    }

    void endBlock() throws IOException {
        outdent();
        emit("}");
    }

    String findJavaType(SchemaType schemaType) {
        while (schemaType.getFullJavaName() == null) {
            schemaType = schemaType.getBaseType();
        }
        return schemaType.getFullJavaName();
    }

    String getAtomicRestrictionType(SchemaType schemaType) {
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                return "org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl";
            case 3:
                return "org.apache.xmlbeans.impl.values.JavaBooleanHolderEx";
            case 4:
                return "org.apache.xmlbeans.impl.values.JavaBase64HolderEx";
            case 5:
                return "org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx";
            case 6:
                return "org.apache.xmlbeans.impl.values.JavaUriHolderEx";
            case 7:
                return "org.apache.xmlbeans.impl.values.JavaQNameHolderEx";
            case 8:
                return "org.apache.xmlbeans.impl.values.JavaNotationHolderEx";
            case 9:
                return "org.apache.xmlbeans.impl.values.JavaFloatHolderEx";
            case 10:
                return "org.apache.xmlbeans.impl.values.JavaDoubleHolderEx";
            case 11:
                int decimalSize = schemaType.getDecimalSize();
                if (decimalSize == 8 || decimalSize == 16 || decimalSize == 32) {
                    return "org.apache.xmlbeans.impl.values.JavaIntHolderEx";
                }
                if (decimalSize == 64) {
                    return "org.apache.xmlbeans.impl.values.JavaLongHolderEx";
                }
                switch (decimalSize) {
                    case SchemaType.SIZE_BIG_INTEGER /* 1000000 */:
                        return "org.apache.xmlbeans.impl.values.JavaIntegerHolderEx";
                    case SchemaType.SIZE_BIG_DECIMAL /* 1000001 */:
                    default:
                        return "org.apache.xmlbeans.impl.values.JavaDecimalHolderEx";
                }
            case 12:
                return schemaType.hasStringEnumValues() ? "org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx" : "org.apache.xmlbeans.impl.values.JavaStringHolderEx";
            case 13:
                return "org.apache.xmlbeans.impl.values.JavaGDurationHolderEx";
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return "org.apache.xmlbeans.impl.values.JavaGDateHolderEx";
            default:
                return null;
        }
    }

    String getBaseClass(SchemaType schemaType) {
        SchemaType schemaTypeFindBaseType = findBaseType(schemaType.getBaseType());
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            return !XmlObject.type.equals(schemaTypeFindBaseType) ? schemaTypeFindBaseType.getFullJavaImplName() : "org.apache.xmlbeans.impl.values.XmlComplexContentImpl";
        }
        if (simpleVariety == 1) {
            return getAtomicRestrictionType(schemaType);
        }
        if (simpleVariety == 2) {
            return "org.apache.xmlbeans.impl.values.XmlUnionImpl";
        }
        if (simpleVariety == 3) {
            return "org.apache.xmlbeans.impl.values.XmlListImpl";
        }
        throw new IllegalStateException();
    }

    SchemaProperty[] getSchemaProperties(SchemaType schemaType) {
        if (schemaType.getContentType() != 2) {
            return getDerivedProperties(schemaType);
        }
        SchemaType baseType = schemaType.getBaseType();
        ArrayList arrayList = null;
        while (true) {
            if (baseType.isSimpleType() || baseType.isBuiltinType()) {
                break;
            }
            for (SchemaProperty schemaProperty : baseType.getDerivedProperties()) {
                if (!schemaProperty.isAttribute() || schemaType.getAttributeProperty(schemaProperty.getName()) == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(schemaProperty);
                }
            }
            baseType = baseType.getBaseType();
        }
        SchemaProperty[] properties = schemaType.getProperties();
        if (arrayList == null) {
            return properties;
        }
        Collections.addAll(arrayList, properties);
        return (SchemaProperty[]) arrayList.toArray(new SchemaProperty[0]);
    }

    void indent() {
        this._indent += 4;
    }

    String javaTypeForProperty(SchemaProperty schemaProperty) {
        if (schemaProperty.getJavaTypeCode() == 0) {
            return findJavaType(schemaProperty.javaBasedOnType()).replace('$', NameUtil.PERIOD);
        }
        if (schemaProperty.getJavaTypeCode() == 20) {
            return ((SchemaTypeImpl) schemaProperty.getType()).getUserTypeName();
        }
        switch (schemaProperty.getJavaTypeCode()) {
            case 1:
                return XmlErrorCodes.BOOLEAN;
            case 2:
                return XmlErrorCodes.FLOAT;
            case 3:
                return XmlErrorCodes.DOUBLE;
            case 4:
                return "byte";
            case 5:
                return "short";
            case 6:
                return XmlErrorCodes.INT;
            case 7:
                return XmlErrorCodes.LONG;
            case 8:
                return "java.math.BigDecimal";
            case 9:
                return "java.math.BigInteger";
            case 10:
                return "java.lang.String";
            case 11:
                return "byte[]";
            case 12:
                return "org.apache.xmlbeans.GDate";
            case 13:
                return "org.apache.xmlbeans.GDuration";
            case 14:
                return "java.util.Date";
            case 15:
                return "org.apache.poi.javax.xml.namespace.QName";
            case 16:
                return "java.util.List";
            case 17:
                return "java.util.Calendar";
            case 18:
                SchemaType schemaTypeJavaBasedOnType = schemaProperty.javaBasedOnType();
                if (schemaTypeJavaBasedOnType.getSimpleVariety() == 2) {
                    schemaTypeJavaBasedOnType = schemaTypeJavaBasedOnType.getUnionCommonBaseType();
                }
                if (hasBase(schemaTypeJavaBasedOnType)) {
                    return findJavaType(schemaTypeJavaBasedOnType.getBaseEnumType()).replace('$', NameUtil.PERIOD) + ".Enum";
                }
                return findJavaType(schemaTypeJavaBasedOnType).replace('$', NameUtil.PERIOD) + ".Enum";
            case 19:
                return "java.lang.Object";
            default:
                throw new IllegalStateException();
        }
    }

    void makeAttributeDefaultValue(String str, SchemaProperty schemaProperty, String str2) throws IOException {
        if (str == null) {
            str = schemaProperty.javaBasedOnType().getFullJavaName().replace('$', NameUtil.PERIOD);
        }
        emit("target = (" + str + ")get_default_attribute_value(" + str2 + ");");
    }

    String makeMissingValue(int i2) throws IOException {
        switch (i2) {
            case 1:
                return "false";
            case 2:
                return "0.0f";
            case 3:
                return "0.0";
            case 4:
            case 5:
            case 6:
                return "0";
            case 7:
                return "0L";
            default:
                return "null";
        }
    }

    void outdent() {
        this._indent -= 4;
    }

    String prePostOpString(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "org.apache.xmlbeans.PrePostExtension.OPERATION_SET" : "org.apache.xmlbeans.PrePostExtension.OPERATION_REMOVE" : "org.apache.xmlbeans.PrePostExtension.OPERATION_INSERT" : "org.apache.xmlbeans.PrePostExtension.OPERATION_SET";
    }

    void printConstructor(SchemaType schemaType, String str) throws IOException {
        String string;
        emit("");
        emit("public " + str + "(org.apache.xmlbeans.SchemaType sType) {");
        startBlock();
        StringBuilder sb = new StringBuilder();
        sb.append("super(sType");
        if (schemaType.getSimpleVariety() == 0) {
            string = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(!schemaType.isSimpleType());
            string = sb2.toString();
        }
        sb.append(string);
        sb.append(");");
        emit(sb.toString());
        endBlock();
        if (schemaType.getSimpleVariety() != 0) {
            emit("");
            emit("protected " + str + "(org.apache.xmlbeans.SchemaType sType, boolean b) {");
            startBlock();
            emit("super(sType, b);");
            endBlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0311  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void printGetterImpls(SchemaProperty schemaProperty, Map<SchemaProperty, Identifier> map) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Set<XmlOptions.BeanMethod> set;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i2;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        Set<XmlOptions.BeanMethod> set2;
        String str26;
        String str27;
        SchemaProperty schemaProperty2;
        String str28;
        String str29;
        String str30;
        int i3;
        String str31;
        String str32;
        String str33;
        Set<XmlOptions.BeanMethod> set3;
        String str34;
        QName name = schemaProperty.getName();
        String identifier = map.get(schemaProperty).getIdentifier();
        String setIdentifier = map.get(schemaProperty).getSetIdentifier();
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean z = schemaProperty.hasNillable() != 0;
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        String documentation = schemaProperty.getDocumentation();
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        boolean z2 = javaTypeCode == 0;
        String str35 = (xmlTypeForPropertyIsUnion(schemaProperty) || !z2) ? "org.apache.xmlbeans.SimpleValue" : strXmlTypeForProperty;
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        boolean z3 = z;
        int i4 = javaTypeCode;
        if (schemaProperty.extendsJavaSingleton()) {
            String str36 = str35;
            if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.GET)) {
                if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(zExtendsJavaArray ? "Gets first " : "Gets the ");
                    sb2.append(string);
                    printJavaDoc(sb2.toString());
                } else {
                    printJavaDocParagraph(documentation);
                }
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit("public " + strJavaTypeForProperty + " get" + javaPropertyName + "() {");
                startBlock();
                emitImplementationPreamble();
                str25 = "return target;";
                set2 = compilePartialMethod;
                str26 = string;
                str27 = javaPropertyName;
                emitGetTarget(setIdentifier, identifier, zIsAttribute, "0", 1, str36);
                if (zIsAttribute && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                    str29 = "if (target == null) {";
                    emit(str29);
                    startBlock();
                    schemaProperty2 = schemaProperty;
                    str28 = "@Override";
                    str30 = str36;
                    makeAttributeDefaultValue(str30, schemaProperty2, identifier);
                    endBlock();
                } else {
                    schemaProperty2 = schemaProperty;
                    str28 = "@Override";
                    str29 = "if (target == null) {";
                    str30 = str36;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("return (target == null) ? ");
                i3 = i4;
                sb3.append(makeMissingValue(i3));
                sb3.append(" : ");
                sb3.append(printJGetValue(i3, strJavaTypeForProperty, (SchemaTypeImpl) schemaProperty.getType()));
                str31 = ";";
                sb3.append(str31);
                emit(sb3.toString());
                emitImplementationPostamble();
                endBlock();
            } else {
                str25 = "return target;";
                set2 = compilePartialMethod;
                str26 = string;
                str27 = javaPropertyName;
                str28 = "@Override";
                i3 = i4;
                str30 = str36;
                schemaProperty2 = schemaProperty;
                str29 = "if (target == null) {";
                str31 = ";";
            }
            if (z2) {
                str7 = str31;
                i4 = i3;
                str32 = str28;
                str2 = str30;
                str10 = " get";
                str5 = " xget";
                str6 = strXmlTypeForProperty;
                str33 = str25;
                set3 = set2;
            } else {
                Set<XmlOptions.BeanMethod> set4 = set2;
                if (set4 == null || set4.contains(XmlOptions.BeanMethod.XGET)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(zExtendsJavaArray ? "Gets (as xml) first " : "Gets (as xml) the ");
                    String str37 = str26;
                    sb4.append(str37);
                    printJavaDoc(sb4.toString());
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit(str28);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("public ");
                    sb5.append(strXmlTypeForProperty);
                    sb5.append(" xget");
                    String str38 = str27;
                    sb5.append(str38);
                    sb5.append("() {");
                    emit(sb5.toString());
                    startBlock();
                    emitImplementationPreamble();
                    str34 = str37;
                    set3 = set4;
                    str7 = str31;
                    i4 = i3;
                    str32 = str28;
                    str2 = str30;
                    str10 = " get";
                    str5 = " xget";
                    str9 = strJavaTypeForProperty;
                    str12 = str38;
                    String str39 = str29;
                    emitGetTarget(setIdentifier, identifier, zIsAttribute, "0", 1, strXmlTypeForProperty);
                    if (zIsAttribute && (schemaProperty.hasDefault() == 2 || schemaProperty.hasFixed() == 2)) {
                        emit(str39);
                        startBlock();
                        str6 = strXmlTypeForProperty;
                        makeAttributeDefaultValue(str6, schemaProperty, identifier);
                        endBlock();
                    } else {
                        str6 = strXmlTypeForProperty;
                    }
                    str33 = str25;
                    emit(str33);
                    emitImplementationPostamble();
                    endBlock();
                    if (z3) {
                        str = str33;
                        str8 = "public ";
                        str4 = "public boolean isNil";
                        str11 = str34;
                        set = set3;
                        str3 = str32;
                    } else {
                        Set<XmlOptions.BeanMethod> set5 = set3;
                        if (set5 == null || set5.contains(XmlOptions.BeanMethod.IS_NIL)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(zExtendsJavaArray ? "Tests for nil first " : "Tests for nil ");
                            String str40 = str34;
                            sb6.append(str40);
                            printJavaDoc(sb6.toString());
                            String str41 = str32;
                            if (!this.opt.isCompileNoAnnotations()) {
                                emit(str41);
                            }
                            emit("public boolean isNil" + str12 + "() {");
                            startBlock();
                            emitImplementationPreamble();
                            str4 = "public boolean isNil";
                            str3 = str41;
                            str11 = str40;
                            str8 = "public ";
                            set = set5;
                            str = str33;
                            emitGetTarget(setIdentifier, identifier, zIsAttribute, "0", 1, str6);
                            emit("return target != null && target.isNil();");
                            emitImplementationPostamble();
                            endBlock();
                        } else {
                            str = str33;
                            str8 = "public ";
                            str4 = "public boolean isNil";
                            str11 = str34;
                            str3 = str32;
                            set = set5;
                        }
                    }
                } else {
                    set3 = set4;
                    str7 = str31;
                    i4 = i3;
                    str32 = str28;
                    str2 = str30;
                    str10 = " get";
                    str5 = " xget";
                    str6 = strXmlTypeForProperty;
                    str33 = str25;
                }
            }
            str34 = str26;
            str9 = strJavaTypeForProperty;
            str12 = str27;
            if (z3) {
            }
        } else {
            str = "return target;";
            str2 = str35;
            str3 = "@Override";
            str4 = "public boolean isNil";
            str5 = " xget";
            str6 = strXmlTypeForProperty;
            str7 = ";";
            str8 = "public ";
            str9 = strJavaTypeForProperty;
            str10 = " get";
            set = compilePartialMethod;
            str11 = string;
            str12 = javaPropertyName;
        }
        if (schemaProperty.extendsJavaOption() && (set == null || set.contains(XmlOptions.BeanMethod.IS_SET))) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(zExtendsJavaArray ? "True if has at least one " : "True if has ");
            sb7.append(str11);
            printJavaDoc(sb7.toString());
            str13 = str3;
            if (!this.opt.isCompileNoAnnotations()) {
                emit(str13);
            }
            emit("public boolean isSet" + str12 + "() {");
            startBlock();
            emitImplementationPreamble();
            if (zIsAttribute) {
                emit("return get_store().find_attribute_user(" + identifier + ") != null;");
            } else {
                emit("return get_store().count_elements(" + setIdentifier + ") != 0;");
            }
            emitImplementationPostamble();
            endBlock();
        } else {
            str13 = str3;
        }
        if (zExtendsJavaArray) {
            String str42 = str12 + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            String str43 = str6;
            String str44 = str13;
            printListGetterImpl(str11, str12, isJavaPrimitive(i4) ? javaWrappedType(i4) : str9, z2, false);
            if (set == null || set.contains(XmlOptions.BeanMethod.GET_ARRAY)) {
                printJavaDoc("Gets array of all " + str11 + "s");
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                StringBuilder sb8 = new StringBuilder();
                str14 = str8;
                sb8.append(str14);
                str15 = str9;
                sb8.append(str15);
                sb8.append("[] get");
                sb8.append(str42);
                sb8.append("() {");
                emit(sb8.toString());
                startBlock();
                i2 = i4;
                printJGetArrayValue(i2, str15, (SchemaTypeImpl) schemaProperty.getType(), setIdentifier);
                endBlock();
            } else {
                str15 = str9;
                str14 = str8;
                i2 = i4;
            }
            if (set == null || set.contains(XmlOptions.BeanMethod.GET_IDX)) {
                StringBuilder sb9 = new StringBuilder();
                int i5 = i2;
                sb9.append("Gets ith ");
                sb9.append(str11);
                printJavaDoc(sb9.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                emit(str14 + str15 + str10 + str42 + "(int i) {");
                startBlock();
                emitImplementationPreamble();
                str16 = "(int i) {";
                str17 = identifier;
                str18 = str14;
                str19 = setIdentifier;
                str20 = "s";
                str21 = "return get_store().count_elements(";
                emitGetTarget(setIdentifier, identifier, zIsAttribute, "i", 4, str2);
                emit("return " + printJGetValue(i5, str15, (SchemaTypeImpl) schemaProperty.getType()) + str7);
                emitImplementationPostamble();
                endBlock();
            } else {
                str16 = "(int i) {";
                str21 = "return get_store().count_elements(";
                str17 = identifier;
                str19 = setIdentifier;
                str18 = str14;
                str20 = "s";
            }
            if (!z2) {
                printListGetterImpl(str11, str12, str43, false, true);
            }
            if (z2 || !(set == null || set.contains(XmlOptions.BeanMethod.XGET_ARRAY))) {
                str22 = str19;
                str23 = str43;
            } else {
                printJavaDoc("Gets (as xml) array of all " + str11 + str20);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str18);
                str23 = str43;
                sb10.append(str23);
                sb10.append("[] xget");
                sb10.append(str42);
                sb10.append("() {");
                emit(sb10.toString());
                startBlock();
                StringBuilder sb11 = new StringBuilder();
                sb11.append("return xgetArray(");
                str22 = str19;
                sb11.append(str22);
                sb11.append(", ");
                sb11.append(str23);
                sb11.append("[]::new);");
                emit(sb11.toString());
                endBlock();
            }
            if (z2 || !(set == null || set.contains(XmlOptions.BeanMethod.XGET_IDX))) {
                str24 = str16;
            } else {
                printJavaDoc("Gets (as xml) ith " + str11);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str18);
                sb12.append(str23);
                sb12.append(str5);
                sb12.append(str42);
                str24 = str16;
                sb12.append(str24);
                emit(sb12.toString());
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str22, str17, zIsAttribute, "i", 4, str23);
                emit(str);
                emitImplementationPostamble();
                endBlock();
            }
            if (z3 && (set == null || set.contains(XmlOptions.BeanMethod.IS_NIL_IDX))) {
                printJavaDoc("Tests for nil ith " + str11);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                emit(str4 + str42 + str24);
                startBlock();
                emitImplementationPreamble();
                emitGetTarget(str22, str17, zIsAttribute, "i", 4, str23);
                emit("return target.isNil();");
                emitImplementationPostamble();
                endBlock();
            }
            if (set == null || set.contains(XmlOptions.BeanMethod.SIZE_OF_ARRAY)) {
                printJavaDoc("Returns number of " + str11);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit(str44);
                }
                emit("public int sizeOf" + str42 + "() {");
                startBlock();
                emitImplementationPreamble();
                emit(str21 + str22 + ");");
                emitImplementationPostamble();
                endBlock();
            }
        }
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printHolder(Writer writer, SchemaTypeSystem schemaTypeSystem, XmlOptions xmlOptions, Repackager repackager) throws IOException {
        this._writer = writer;
        String name = schemaTypeSystem.getName();
        if (repackager != null) {
            name = repackager.repackage(new StringBuffer(name)).toString();
        }
        emit("package " + name + ";");
        emit("");
        emit("import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;");
        emit("");
        emit("public final class TypeSystemHolder extends SchemaTypeSystemImpl {");
        indent();
        emit("public static final TypeSystemHolder typeSystem = new TypeSystemHolder();");
        emit("");
        emit("private TypeSystemHolder() {");
        indent();
        emit("super(TypeSystemHolder.class);");
        outdent();
        emit("}");
        outdent();
        emit("}");
    }

    void printInnerType(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        emit("");
        printInnerTypeJavaDoc(schemaType);
        startInterface(schemaType);
        printStaticTypeDeclaration(schemaType, schemaTypeSystem);
        if (!schemaType.isSimpleType()) {
            if (schemaType.getContentType() == 2 && schemaType.hasStringEnumValues()) {
                printStringEnumeration(schemaType);
            }
            for (SchemaProperty schemaProperty : getDerivedProperties(schemaType)) {
                printPropertyGetters(schemaProperty);
                if (!schemaProperty.isReadOnly()) {
                    printPropertySetters(schemaProperty);
                }
            }
        } else if (schemaType.hasStringEnumValues()) {
            printStringEnumeration(schemaType);
        }
        printNestedInnerTypes(schemaType, schemaTypeSystem);
        endBlock();
    }

    void printInnerTypeImpl(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem, boolean z) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        printInnerTypeJavaDoc(schemaType);
        startClass(schemaType, z);
        printConstructor(schemaType, shortJavaImplName);
        printExtensionImplMethods(schemaType);
        if (!schemaType.isSimpleType()) {
            SchemaProperty[] schemaProperties = getSchemaProperties(schemaType);
            HashMap map = new HashMap();
            printStaticFields(schemaProperties, map);
            for (SchemaProperty schemaProperty : schemaProperties) {
                printGetterImpls(schemaProperty, map);
                if (!schemaProperty.isReadOnly()) {
                    printSetterImpls(schemaProperty, map, schemaType);
                }
            }
        }
        printNestedTypeImpls(schemaType, schemaTypeSystem);
        endBlock();
    }

    void printInnerTypeJavaDoc(SchemaType schemaType) throws IOException {
        QName name = schemaType.getName();
        if (name == null) {
            if (schemaType.isDocumentType()) {
                name = schemaType.getDocumentElementName();
            } else if (schemaType.isAttributeType()) {
                name = schemaType.getAttributeTypeAttributeName();
            } else if (schemaType.getContainerField() != null) {
                name = schemaType.getContainerField().getName();
            }
        }
        emit("/**");
        if (this.opt.isCompileAnnotationAsJavadoc() && schemaType.getDocumentation() != null && schemaType.getDocumentation().length() > 0) {
            emit(" *");
            printJavaDocBody(schemaType.getDocumentation());
            emit(" *");
        }
        if (schemaType.isDocumentType()) {
            emit(" * A document containing one " + prettyQName(name) + " element.");
        } else if (schemaType.isAttributeType()) {
            emit(" * A document containing one " + prettyQName(name) + " attribute.");
        } else if (name != null) {
            emit(" * An XML " + prettyQName(name) + ".");
        } else {
            emit(" * An anonymous inner XML type.");
        }
        emit(" *");
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 0) {
            emit(" * This is a complex type.");
        } else if (simpleVariety == 1) {
            emit(" * This is an atomic type that is a restriction of " + getFullJavaName(schemaType) + ".");
        } else if (simpleVariety == 2) {
            emit(" * This is a union type. Instances are of one of the following types:");
            for (SchemaType schemaType2 : schemaType.getUnionConstituentTypes()) {
                emit(" *     " + schemaType2.getFullJavaName());
            }
        } else if (simpleVariety == 3) {
            emit(" * This is a list type whose items are " + schemaType.getListItemType().getFullJavaName() + ".");
        }
        emit(" */");
    }

    void printInterfaceMethodDecl(InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuilder sb = new StringBuilder(60);
        sb.append("public ");
        sb.append(methodSignature.getReturnType());
        sb.append(" ");
        sb.append(methodSignature.getName());
        sb.append("(");
        String[] parameterTypes = methodSignature.getParameterTypes();
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i2 = 1; i2 < parameterTypes.length; i2++) {
            if (i2 > 1) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2]);
            sb.append(" ");
            sb.append(parameterNames[i2]);
        }
        sb.append(")");
        String[] exceptionTypes = methodSignature.getExceptionTypes();
        int i3 = 0;
        while (i3 < exceptionTypes.length) {
            sb.append(i3 == 0 ? " throws " : ", ");
            sb.append(exceptionTypes[i3]);
            i3++;
        }
        sb.append(" {");
        emit(sb.toString());
    }

    void printInterfaceMethodImpl(String str, InterfaceExtension.MethodSignature methodSignature) throws IOException {
        StringBuilder sb = new StringBuilder(60);
        if (!methodSignature.getReturnType().equals("void")) {
            sb.append("return ");
        }
        sb.append(str);
        sb.append(".");
        sb.append(methodSignature.getName());
        sb.append("(this");
        String[] parameterTypes = methodSignature.getParameterTypes();
        String[] parameterNames = methodSignature.getParameterNames();
        for (int i2 = 1; i2 < parameterTypes.length; i2++) {
            sb.append(", ");
            sb.append(parameterNames[i2]);
        }
        sb.append(");");
        emit(sb.toString());
    }

    void printJGetArrayValue(int i2, String str, SchemaTypeImpl schemaTypeImpl, String str2) throws IOException {
        String str3;
        switch (i2) {
            case 0:
                str3 = "XmlObjectArray(#ID#, new " + str + "[0]);";
                break;
            case 1:
                str3 = "BooleanArray(#ID#);";
                break;
            case 2:
                str3 = "FloatArray(#ID#);";
                break;
            case 3:
                str3 = "DoubleArray(#ID#);";
                break;
            case 4:
                str3 = "ByteArray(#ID#);";
                break;
            case 5:
                str3 = "ShortArray(#ID#);";
                break;
            case 6:
                str3 = "IntArray(#ID#);";
                break;
            case 7:
                str3 = "LongArray(#ID#);";
                break;
            case 8:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getBigDecimalValue, java.math.BigDecimal[]::new);";
                break;
            case 9:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getBigIntegerValue, java.math.BigInteger[]::new);";
                break;
            case 10:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getStringValue, String[]::new);";
                break;
            case 11:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getByteArrayValue, byte[][]::new);";
                break;
            case 12:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getGDateValue, org.apache.xmlbeans.GDate[]::new);";
                break;
            case 13:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getGDurationValue, org.apache.xmlbeans.GDuration[]::new);";
                break;
            case 14:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getDateValue, java.util.Date[]::new);";
                break;
            case 15:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getQNameValue, javax.xml.namespace.QName[]::new);";
                break;
            case 16:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getListValue, java.util.List[]::new);";
                break;
            case 17:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getCalendarValue, java.util.Calendar[]::new);";
                break;
            case 18:
                str3 = "EnumArray(#ID#, " + str + "[]::new);";
                break;
            case 19:
                str3 = "ObjectArray(#ID#, org.apache.xmlbeans.SimpleValue::getObjectValue, java.lang.Object[]::new);";
                break;
            case 20:
                str3 = "ObjectArray(#ID#, e -> " + getUserTypeStaticHandlerMethod(false, schemaTypeImpl) + "(e), " + schemaTypeImpl.getUserTypeName() + "[]::new);";
                break;
            default:
                throw new IllegalStateException();
        }
        emit("return get" + str3.replace("#ID#", str2), XmlOptions.BeanMethod.GET_ARRAY);
    }

    String printJGetValue(int i2, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        switch (i2) {
            case 0:
                return "target";
            case 1:
                return "target.getBooleanValue()";
            case 2:
                return "target.getFloatValue()";
            case 3:
                return "target.getDoubleValue()";
            case 4:
                return "target.getByteValue()";
            case 5:
                return "target.getShortValue()";
            case 6:
                return "target.getIntValue()";
            case 7:
                return "target.getLongValue()";
            case 8:
                return "target.getBigDecimalValue()";
            case 9:
                return "target.getBigIntegerValue()";
            case 10:
                return "target.getStringValue()";
            case 11:
                return "target.getByteArrayValue()";
            case 12:
                return "target.getGDateValue()";
            case 13:
                return "target.getGDurationValue()";
            case 14:
                return "target.getDateValue()";
            case 15:
                return "target.getQNameValue()";
            case 16:
                return "target.getListValue()";
            case 17:
                return "target.getCalendarValue()";
            case 18:
                return "(" + str + ")target.getEnumValue()";
            case 19:
                return "target.getObjectValue()";
            case 20:
                return getUserTypeStaticHandlerMethod(false, schemaTypeImpl) + "(target)";
            default:
                throw new IllegalStateException();
        }
    }

    void printJSetValue(int i2, String str, SchemaTypeImpl schemaTypeImpl) throws IOException {
        String str2;
        switch (i2) {
            case 0:
                str2 = "target.set(#VARNAME#)";
                break;
            case 1:
                str2 = "target.setBooleanValue(#VARNAME#)";
                break;
            case 2:
                str2 = "target.setFloatValue(#VARNAME#)";
                break;
            case 3:
                str2 = "target.setDoubleValue(#VARNAME#)";
                break;
            case 4:
                str2 = "target.setByteValue(#VARNAME#)";
                break;
            case 5:
                str2 = "target.setShortValue(#VARNAME#)";
                break;
            case 6:
                str2 = "target.setIntValue(#VARNAME#)";
                break;
            case 7:
                str2 = "target.setLongValue(#VARNAME#)";
                break;
            case 8:
                str2 = "target.setBigDecimalValue(#VARNAME#)";
                break;
            case 9:
                str2 = "target.setBigIntegerValue(#VARNAME#)";
                break;
            case 10:
                str2 = "target.setStringValue(#VARNAME#)";
                break;
            case 11:
                str2 = "target.setByteArrayValue(#VARNAME#)";
                break;
            case 12:
                str2 = "target.setGDateValue(#VARNAME#)";
                break;
            case 13:
                str2 = "target.setGDurationValue(#VARNAME#)";
                break;
            case 14:
                str2 = "target.setDateValue(#VARNAME#)";
                break;
            case 15:
                str2 = "target.setQNameValue(#VARNAME#)";
                break;
            case 16:
                str2 = "target.setListValue(#VARNAME#)";
                break;
            case 17:
                str2 = "target.setCalendarValue(#VARNAME#)";
                break;
            case 18:
                str2 = "target.setEnumValue(#VARNAME#)";
                break;
            case 19:
                str2 = "target.setObjectValue(#VARNAME#)";
                break;
            case 20:
                str2 = getUserTypeStaticHandlerMethod(true, schemaTypeImpl) + "(#VARNAME#, target)";
                break;
            default:
                throw new IllegalStateException();
        }
        emit(str2.replace("#VARNAME#", str) + ";");
    }

    void printJavaDoc(String str, XmlOptions.BeanMethod beanMethod) throws IOException {
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod == null || compilePartialMethod.contains(beanMethod)) {
            printJavaDoc(str);
        }
    }

    void printJavaDocBody(String str) throws IOException {
        for (String str2 : str.trim().replace("\t", "").replace("*/", "* /").split("[\\n\\r]+")) {
            emit(" * " + str2);
        }
    }

    void printJavaDocParagraph(String str) throws IOException {
        emit("");
        emit("/**");
        printJavaDocBody(str);
        emit(" */");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void printListGetterImpl(String str, String str2, String str3, boolean z, boolean z2) throws IOException {
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        if (compilePartialMethod != null) {
            if (!compilePartialMethod.contains(z2 ? XmlOptions.BeanMethod.XGET_LIST : XmlOptions.BeanMethod.GET_LIST)) {
                return;
            }
        }
        String str4 = str2 + SoapEncSchemaTypeSystem.SOAP_ARRAY;
        StringBuilder sb = new StringBuilder();
        sb.append("Gets ");
        sb.append(z2 ? "(as xml) " : "");
        sb.append("a List of ");
        sb.append(str);
        sb.append("s");
        printJavaDoc(sb.toString());
        if (!this.opt.isCompileNoAnnotations()) {
            emit("@Override");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("public java.util.List<");
        sb2.append(str3);
        sb2.append("> ");
        sb2.append(z2 ? "xget" : "get");
        sb2.append(str2);
        sb2.append("List() {");
        emit(sb2.toString());
        startBlock();
        emitImplementationPreamble();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("return new org.apache.xmlbeans.impl.values.JavaList");
        sb3.append((z || z2) ? "Xml" : "");
        sb3.append("Object<>(");
        emit(sb3.toString());
        indent();
        if (compilePartialMethod == null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("this::");
            sb4.append(z2 ? "xget" : "get");
            sb4.append(str4);
            sb4.append(",");
            emit(sb4.toString());
        } else {
            if (!compilePartialMethod.contains(z2 ? XmlOptions.BeanMethod.XGET_IDX : XmlOptions.BeanMethod.GET_IDX)) {
                emit("null,");
            }
        }
        if (compilePartialMethod == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("this::");
            sb5.append(z2 ? "xset" : "set");
            sb5.append(str4);
            sb5.append(",");
            emit(sb5.toString());
        } else {
            if (!compilePartialMethod.contains(z2 ? XmlOptions.BeanMethod.XSET_IDX : XmlOptions.BeanMethod.SET_IDX)) {
                emit("null,");
            }
        }
        if (compilePartialMethod == null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("this::insert");
            sb6.append((z || z2) ? "New" : "");
            sb6.append(str2);
            sb6.append(",");
            emit(sb6.toString());
        } else {
            if (!compilePartialMethod.contains((z || z2) ? XmlOptions.BeanMethod.INSERT_NEW_IDX : XmlOptions.BeanMethod.INSERT_IDX)) {
                emit("null,");
            }
        }
        if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.REMOVE_IDX)) {
            emit("this::remove" + str2 + ",");
        } else {
            emit("null,");
        }
        if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.SIZE_OF_ARRAY)) {
            emit("this::sizeOf" + str4);
        } else {
            emit("null");
        }
        outdent();
        emit(");");
        emitImplementationPostamble();
        endBlock();
    }

    void printNestedInnerTypes(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            for (SchemaType schemaType2 : schemaType.getAnonymousTypes()) {
                if (schemaType2.isSkippedAnonymousType()) {
                    printNestedInnerTypes(schemaType2, schemaTypeSystem);
                } else {
                    printInnerType(schemaType2, schemaTypeSystem);
                }
            }
            if (!z) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    void printNestedTypeImpls(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        boolean z = schemaType.getName() != null && schemaType.getName().equals(schemaType.getBaseType().getName());
        while (schemaType != null) {
            for (SchemaType schemaType2 : schemaType.getAnonymousTypes()) {
                if (schemaType2.isSkippedAnonymousType()) {
                    printNestedTypeImpls(schemaType2, schemaTypeSystem);
                } else {
                    printInnerTypeImpl(schemaType2, schemaTypeSystem, true);
                }
            }
            if (!z) {
                return;
            }
            if (schemaType.getDerivationType() != 2 && !schemaType.isSimpleType()) {
                return;
            } else {
                schemaType = schemaType.getBaseType();
            }
        }
    }

    void printPackage(SchemaType schemaType, boolean z) throws IOException {
        String fullJavaName = z ? schemaType.getFullJavaName() : schemaType.getFullJavaImplName();
        int iLastIndexOf = fullJavaName.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return;
        }
        emit("package " + fullJavaName.substring(0, iLastIndexOf) + ";");
    }

    void printPropertyGetters(SchemaProperty schemaProperty) throws IOException {
        String str;
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        boolean z = schemaProperty.hasNillable() != 0;
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        String documentation = schemaProperty.getDocumentation();
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(schemaProperty.getName().getLocalPart());
        sb.append("\"");
        sb.append(schemaProperty.isAttribute() ? " attribute" : " element");
        String string = sb.toString();
        boolean z2 = javaTypeCode == 0;
        if (schemaProperty.extendsJavaSingleton()) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(zExtendsJavaArray ? "Gets first " : "Gets the ");
                sb2.append(string);
                printJavaDoc(sb2.toString(), XmlOptions.BeanMethod.GET);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(strJavaTypeForProperty + " get" + javaPropertyName + "();", XmlOptions.BeanMethod.GET);
            if (!z2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(zExtendsJavaArray ? "Gets (as xml) first " : "Gets (as xml) the ");
                sb3.append(string);
                String string2 = sb3.toString();
                XmlOptions.BeanMethod beanMethod = XmlOptions.BeanMethod.XGET;
                printJavaDoc(string2, beanMethod);
                emit(strXmlTypeForProperty + " xget" + javaPropertyName + "();", beanMethod);
            }
            if (z) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(zExtendsJavaArray ? "Tests for nil first " : "Tests for nil ");
                sb4.append(string);
                String string3 = sb4.toString();
                XmlOptions.BeanMethod beanMethod2 = XmlOptions.BeanMethod.IS_NIL;
                printJavaDoc(string3, beanMethod2);
                emit("boolean isNil" + javaPropertyName + "();", beanMethod2);
            }
        }
        if (schemaProperty.extendsJavaOption()) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(zExtendsJavaArray ? "True if has at least one " : "True if has ");
                sb5.append(string);
                printJavaDoc(sb5.toString(), XmlOptions.BeanMethod.IS_SET);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit("boolean isSet" + javaPropertyName + "();", XmlOptions.BeanMethod.IS_SET);
        }
        if (zExtendsJavaArray) {
            if (this.opt.isCompileAnnotationAsJavadoc() && documentation != null && documentation.length() > 0) {
                printJavaDocParagraph(documentation);
            }
            String str2 = javaPropertyName + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            String strJavaWrappedType = isJavaPrimitive(javaTypeCode) ? javaWrappedType(javaTypeCode) : strJavaTypeForProperty;
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                StringBuilder sb6 = new StringBuilder();
                str = "boolean isNil";
                sb6.append("Gets a List of ");
                sb6.append(string);
                sb6.append("s");
                printJavaDoc(sb6.toString(), XmlOptions.BeanMethod.GET_LIST);
            } else {
                printJavaDocParagraph(documentation);
                str = "boolean isNil";
            }
            boolean z3 = z;
            emit("java.util.List<" + strJavaWrappedType + "> get" + javaPropertyName + "List();", XmlOptions.BeanMethod.GET_LIST);
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                printJavaDoc("Gets array of all " + string + "s", XmlOptions.BeanMethod.GET_ARRAY);
            } else {
                printJavaDocParagraph(documentation);
            }
            emit(strJavaTypeForProperty + "[] get" + str2 + "();", XmlOptions.BeanMethod.GET_ARRAY);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Gets ith ");
            sb7.append(string);
            String string4 = sb7.toString();
            XmlOptions.BeanMethod beanMethod3 = XmlOptions.BeanMethod.GET_IDX;
            printJavaDoc(string4, beanMethod3);
            emit(strJavaTypeForProperty + " get" + str2 + "(int i);", beanMethod3);
            if (!z2) {
                XmlOptions.BeanMethod beanMethod4 = XmlOptions.BeanMethod.XGET_LIST;
                printJavaDoc("Gets (as xml) a List of " + string + "s", beanMethod4);
                emit("java.util.List<" + strXmlTypeForProperty + "> xget" + javaPropertyName + "List();", beanMethod4);
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Gets (as xml) array of all ");
                sb8.append(string);
                sb8.append("s");
                String string5 = sb8.toString();
                XmlOptions.BeanMethod beanMethod5 = XmlOptions.BeanMethod.XGET_ARRAY;
                printJavaDoc(string5, beanMethod5);
                emit(strXmlTypeForProperty + "[] xget" + str2 + "();", beanMethod5);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("Gets (as xml) ith ");
                sb9.append(string);
                String string6 = sb9.toString();
                XmlOptions.BeanMethod beanMethod6 = XmlOptions.BeanMethod.XGET_IDX;
                printJavaDoc(string6, beanMethod6);
                emit(strXmlTypeForProperty + " xget" + str2 + "(int i);", beanMethod6);
            }
            if (z3) {
                XmlOptions.BeanMethod beanMethod7 = XmlOptions.BeanMethod.IS_NIL_IDX;
                printJavaDoc("Tests for nil ith " + string, beanMethod7);
                emit(str + str2 + "(int i);", beanMethod7);
            }
            XmlOptions.BeanMethod beanMethod8 = XmlOptions.BeanMethod.SIZE_OF_ARRAY;
            printJavaDoc("Returns number of " + string, beanMethod8);
            emit("int sizeOf" + str2 + "();", beanMethod8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void printPropertySetters(SchemaProperty schemaProperty) throws IOException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        QName name = schemaProperty.getName();
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        boolean z = schemaProperty.hasNillable() != 0;
        boolean zExtendsJavaOption = schemaProperty.extendsJavaOption();
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean zExtendsJavaSingleton = schemaProperty.extendsJavaSingleton();
        String documentation = schemaProperty.getDocumentation();
        String strNonJavaKeyword = NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(javaPropertyName));
        if (strNonJavaKeyword.equals("i")) {
            strNonJavaKeyword = "iValue";
        }
        boolean z2 = javaTypeCode == 0;
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        boolean z3 = z;
        if (zExtendsJavaSingleton) {
            if (!this.opt.isCompileAnnotationAsJavadoc() || documentation == null || documentation.length() <= 0) {
                StringBuilder sb2 = new StringBuilder();
                str2 = documentation;
                sb2.append(zExtendsJavaArray ? "Sets first " : "Sets the ");
                sb2.append(string);
                printJavaDoc(sb2.toString(), XmlOptions.BeanMethod.SET);
            } else {
                printJavaDocParagraph(documentation);
                str2 = documentation;
            }
            emit("void set" + javaPropertyName + "(" + strJavaTypeForProperty + " " + strNonJavaKeyword + ");", XmlOptions.BeanMethod.SET);
            if (!z2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(zExtendsJavaArray ? "Sets (as xml) first " : "Sets (as xml) the ");
                sb3.append(string);
                String string2 = sb3.toString();
                XmlOptions.BeanMethod beanMethod = XmlOptions.BeanMethod.XSET;
                printJavaDoc(string2, beanMethod);
                emit("void xset" + javaPropertyName + "(" + strXmlTypeForProperty + " " + strNonJavaKeyword + ");", beanMethod);
            }
            if (!z2 || zExtendsJavaArray) {
                str = " addNew";
                str3 = "();";
            } else {
                XmlOptions.BeanMethod beanMethod2 = XmlOptions.BeanMethod.ADD_NEW;
                printJavaDoc("Appends and returns a new empty " + string, beanMethod2);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(strXmlTypeForProperty);
                sb4.append(" addNew");
                sb4.append(javaPropertyName);
                str = " addNew";
                str3 = "();";
                sb4.append(str3);
                emit(sb4.toString(), beanMethod2);
            }
            if (z3) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(zExtendsJavaArray ? "Nils the first " : "Nils the ");
                sb5.append(string);
                String string3 = sb5.toString();
                XmlOptions.BeanMethod beanMethod3 = XmlOptions.BeanMethod.SET_NIL;
                printJavaDoc(string3, beanMethod3);
                StringBuilder sb6 = new StringBuilder();
                str4 = strXmlTypeForProperty;
                str5 = "void setNil";
                sb6.append(str5);
                sb6.append(javaPropertyName);
                sb6.append(str3);
                emit(sb6.toString(), beanMethod3);
            }
            if (zExtendsJavaOption) {
                str6 = str5;
                str7 = str2;
            } else {
                if (!this.opt.isCompileAnnotationAsJavadoc() || str2 == null || str2.length() <= 0) {
                    str7 = str2;
                    StringBuilder sb7 = new StringBuilder();
                    str6 = str5;
                    sb7.append(zExtendsJavaArray ? "Removes first " : "Unsets the ");
                    sb7.append(string);
                    printJavaDoc(sb7.toString(), XmlOptions.BeanMethod.UNSET);
                } else {
                    str7 = str2;
                    printJavaDocParagraph(str7);
                    str6 = str5;
                }
                emit("void unset" + javaPropertyName + str3, XmlOptions.BeanMethod.UNSET);
            }
            if (zExtendsJavaArray) {
                return;
            }
            String str10 = javaPropertyName + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            if (!this.opt.isCompileAnnotationAsJavadoc() || str7 == null || str7.length() <= 0) {
                printJavaDoc("Sets array of all " + string, XmlOptions.BeanMethod.SET_ARRAY);
            } else {
                printJavaDocParagraph(str7);
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("void set");
            sb8.append(str10);
            sb8.append("(");
            sb8.append(strJavaTypeForProperty);
            sb8.append("[] ");
            sb8.append(strNonJavaKeyword);
            String str11 = str3;
            sb8.append("Array);");
            emit(sb8.toString(), XmlOptions.BeanMethod.SET_ARRAY);
            if (!this.opt.isCompileAnnotationAsJavadoc() || str7 == null || str7.length() <= 0) {
                printJavaDoc("Sets ith " + string, XmlOptions.BeanMethod.SET_IDX);
            } else {
                printJavaDocParagraph(str7);
            }
            emit("void set" + str10 + "(int i, " + strJavaTypeForProperty + " " + strNonJavaKeyword + ");", XmlOptions.BeanMethod.SET_IDX);
            if (z2) {
                str8 = str4;
            } else {
                XmlOptions.BeanMethod beanMethod4 = XmlOptions.BeanMethod.XSET_ARRAY;
                printJavaDoc("Sets (as xml) array of all " + string, beanMethod4);
                StringBuilder sb9 = new StringBuilder();
                sb9.append("void xset");
                sb9.append(str10);
                sb9.append("(");
                str8 = str4;
                sb9.append(str8);
                sb9.append("[] ");
                sb9.append(strNonJavaKeyword);
                sb9.append("Array);");
                emit(sb9.toString(), beanMethod4);
                XmlOptions.BeanMethod beanMethod5 = XmlOptions.BeanMethod.XSET_IDX;
                printJavaDoc("Sets (as xml) ith " + string, beanMethod5);
                emit("void xset" + str10 + "(int i, " + str8 + " " + strNonJavaKeyword + ");", beanMethod5);
            }
            if (z3) {
                XmlOptions.BeanMethod beanMethod6 = XmlOptions.BeanMethod.SET_NIL_IDX;
                printJavaDoc("Nils the ith " + string, beanMethod6);
                emit(str6 + str10 + "(int i);", beanMethod6);
            }
            if (z2) {
                str9 = javaPropertyName;
            } else {
                XmlOptions.BeanMethod beanMethod7 = XmlOptions.BeanMethod.INSERT_IDX;
                printJavaDoc("Inserts the value as the ith " + string, beanMethod7);
                StringBuilder sb10 = new StringBuilder();
                sb10.append("void insert");
                str9 = javaPropertyName;
                sb10.append(str9);
                sb10.append("(int i, ");
                sb10.append(strJavaTypeForProperty);
                sb10.append(" ");
                sb10.append(strNonJavaKeyword);
                sb10.append(");");
                emit(sb10.toString(), beanMethod7);
                XmlOptions.BeanMethod beanMethod8 = XmlOptions.BeanMethod.ADD;
                printJavaDoc("Appends the value as the last " + string, beanMethod8);
                emit("void add" + str9 + "(" + strJavaTypeForProperty + " " + strNonJavaKeyword + ");", beanMethod8);
            }
            XmlOptions.BeanMethod beanMethod9 = XmlOptions.BeanMethod.INSERT_NEW_IDX;
            printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + string, beanMethod9);
            emit(str8 + " insertNew" + str9 + "(int i);", beanMethod9);
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Appends and returns a new empty value (as xml) as the last ");
            sb11.append(string);
            String string4 = sb11.toString();
            XmlOptions.BeanMethod beanMethod10 = XmlOptions.BeanMethod.ADD_NEW;
            printJavaDoc(string4, beanMethod10);
            emit(str8 + str + str9 + str11, beanMethod10);
            StringBuilder sb12 = new StringBuilder();
            sb12.append("Removes the ith ");
            sb12.append(string);
            String string5 = sb12.toString();
            XmlOptions.BeanMethod beanMethod11 = XmlOptions.BeanMethod.REMOVE_IDX;
            printJavaDoc(string5, beanMethod11);
            emit("void remove" + str9 + "(int i);", beanMethod11);
            return;
        }
        str = " addNew";
        str2 = documentation;
        str3 = "();";
        str4 = strXmlTypeForProperty;
        str5 = "void setNil";
        if (zExtendsJavaOption) {
        }
        if (zExtendsJavaArray) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:213:0x09dd  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0a95  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0ac9  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0c23  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0cc3  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0cdd  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0cf9  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0d48  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0d6c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0dc1  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0ddd  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0e56  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void printSetterImpls(SchemaProperty schemaProperty, Map<SchemaProperty, Identifier> map, SchemaType schemaType) throws IOException {
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        boolean z;
        String str13;
        String str14;
        int i3;
        Set<XmlOptions.BeanMethod> set;
        String str15;
        String str16;
        String str17;
        boolean z2;
        String str18;
        String str19;
        SchemaType schemaType2;
        String str20;
        Set<XmlOptions.BeanMethod> set2;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        Set<XmlOptions.BeanMethod> set3;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        int i4;
        String str42;
        String str43;
        String str44;
        int i5;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        int i6;
        String str58;
        String str59;
        String str60;
        String str61;
        String str62;
        String str63;
        String str64;
        String str65;
        String str66;
        String str67;
        String str68;
        String str69;
        boolean z3;
        int i7;
        Set<XmlOptions.BeanMethod> set4;
        String str70;
        String str71;
        String str72;
        String str73;
        String str74;
        String str75;
        String str76;
        String str77;
        boolean z4;
        QName name = schemaProperty.getName();
        String identifier = map.get(schemaProperty).getIdentifier();
        String setIdentifier = map.get(schemaProperty).getSetIdentifier();
        boolean zExtendsJavaArray = schemaProperty.extendsJavaArray();
        boolean z5 = schemaProperty.hasNillable() != 0;
        String strJavaTypeForProperty = javaTypeForProperty(schemaProperty);
        String strXmlTypeForProperty = xmlTypeForProperty(schemaProperty);
        int javaTypeCode = schemaProperty.getJavaTypeCode();
        boolean zIsAttribute = schemaProperty.isAttribute();
        String javaPropertyName = schemaProperty.getJavaPropertyName();
        XmlOptions xmlOptions = this.opt;
        Set<XmlOptions.BeanMethod> compilePartialMethod = xmlOptions == null ? null : xmlOptions.getCompilePartialMethod();
        String strNonExtraKeyword = NameUtil.nonExtraKeyword(NameUtil.nonJavaKeyword(NameUtil.lowerCamelCase(javaPropertyName)));
        boolean z6 = javaTypeCode == 0;
        boolean z7 = javaTypeCode == 19;
        boolean z8 = !Objects.equals(identifier, setIdentifier);
        if (xmlTypeForPropertyIsUnion(schemaProperty) || !z6) {
            str = "org.apache.xmlbeans.SimpleValue";
            i2 = javaTypeCode;
        } else {
            i2 = javaTypeCode;
            str = strXmlTypeForProperty;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(name.getLocalPart());
        sb.append("\"");
        sb.append(zIsAttribute ? " attribute" : " element");
        String string = sb.toString();
        boolean z9 = z7;
        boolean z10 = z5;
        if (schemaProperty.extendsJavaSingleton()) {
            if (compilePartialMethod == null || compilePartialMethod.contains(XmlOptions.BeanMethod.SET)) {
                StringBuilder sb2 = new StringBuilder();
                Set<XmlOptions.BeanMethod> set5 = compilePartialMethod;
                sb2.append(zExtendsJavaArray ? "Sets first " : "Sets the ");
                sb2.append(string);
                printJavaDoc(sb2.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit("public void set" + javaPropertyName + "(" + strJavaTypeForProperty + " " + strNonExtraKeyword + ") {");
                startBlock();
                if (!z6 || z8 || zIsAttribute) {
                    str69 = javaPropertyName;
                    z3 = zIsAttribute;
                    str6 = strJavaTypeForProperty;
                    i7 = i2;
                    str11 = ", ";
                    set4 = set5;
                    str15 = "public void set";
                    str10 = setIdentifier;
                    str70 = strNonExtraKeyword;
                    str71 = "public ";
                    emitImplementationPreamble();
                    emitPre(schemaType, 1, identifier, z3, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    str72 = ") {";
                    str7 = strXmlTypeForProperty;
                    str73 = " ";
                    str13 = string;
                    emitGetTarget(str10, identifier, z3, "0", 3, str);
                    printJSetValue(i7, str70, (SchemaTypeImpl) schemaProperty.getType());
                    emitPost(schemaType, 1, identifier, z3, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    emitImplementationPostamble();
                } else {
                    set4 = set5;
                    str69 = javaPropertyName;
                    z3 = zIsAttribute;
                    str6 = strJavaTypeForProperty;
                    i7 = i2;
                    str15 = "public void set";
                    emitPre(schemaType, 1, identifier, false, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    emit("generatedSetterHelperImpl(" + strNonExtraKeyword + ", " + setIdentifier + ", 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);");
                    str10 = setIdentifier;
                    str11 = ", ";
                    str71 = "public ";
                    str70 = strNonExtraKeyword;
                    emitPost(schemaType, 1, identifier, false, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    str72 = ") {";
                    str7 = strXmlTypeForProperty;
                    str73 = " ";
                    str13 = string;
                }
                endBlock();
            } else {
                set4 = compilePartialMethod;
                str69 = javaPropertyName;
                z3 = zIsAttribute;
                str6 = strJavaTypeForProperty;
                i7 = i2;
                str10 = setIdentifier;
                str11 = ", ";
                str71 = "public ";
                str72 = ") {";
                str15 = "public void set";
                str7 = strXmlTypeForProperty;
                str70 = strNonExtraKeyword;
                str73 = " ";
                str13 = string;
            }
            if (z6) {
                str4 = str73;
                str5 = str72;
                str74 = ");";
                str14 = "(";
                i3 = i7;
                set = set4;
                str12 = str69;
            } else {
                Set<XmlOptions.BeanMethod> set6 = set4;
                if (set6 == null || set6.contains(XmlOptions.BeanMethod.XSET)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(zExtendsJavaArray ? "Sets (as xml) first " : "Sets (as xml) the ");
                    sb3.append(str13);
                    printJavaDoc(sb3.toString());
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("public void xset");
                    String str78 = str69;
                    sb4.append(str78);
                    sb4.append("(");
                    sb4.append(str7);
                    String str79 = str73;
                    sb4.append(str79);
                    sb4.append(str70);
                    String str80 = str72;
                    sb4.append(str80);
                    emit(sb4.toString());
                    startBlock();
                    emitImplementationPreamble();
                    str5 = str80;
                    str4 = str79;
                    i3 = i7;
                    str12 = str78;
                    emitPre(schemaType, 1, identifier, z3, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    str14 = "(";
                    set = set6;
                    emitGetTarget(str10, identifier, z3, "0", 3, str7);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("target.set(");
                    sb5.append(str70);
                    str74 = ");";
                    sb5.append(str74);
                    emit(sb5.toString());
                    emitPost(schemaType, 1, identifier, z3, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str4 = str73;
                    str5 = str72;
                    str14 = "(";
                    i3 = i7;
                    str12 = str69;
                    set = set6;
                    str74 = ");";
                }
            }
            if (z6 && !zExtendsJavaArray && (set == null || set.contains(XmlOptions.BeanMethod.ADD_NEW))) {
                printJavaDoc("Appends and returns a new empty " + str13);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                StringBuilder sb6 = new StringBuilder();
                str77 = str71;
                sb6.append(str77);
                sb6.append(str7);
                sb6.append(" addNew");
                sb6.append(str12);
                str76 = "() {";
                sb6.append(str76);
                emit(sb6.toString());
                startBlock();
                emitImplementationPreamble();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str7);
                str75 = " target = null;";
                sb7.append(str75);
                emit(sb7.toString());
                z4 = z3;
                emitPre(schemaType, 2, identifier, z4);
                emitAddTarget(identifier, z4, str7);
                emitPost(schemaType, 2, identifier, z4);
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            } else {
                str75 = " target = null;";
                str76 = "() {";
                str77 = str71;
                z4 = z3;
            }
            if (z10 && (set == null || set.contains(XmlOptions.BeanMethod.SET_NIL))) {
                StringBuilder sb8 = new StringBuilder();
                boolean z11 = z4;
                sb8.append(zExtendsJavaArray ? "Nils the first " : "Nils the ");
                sb8.append(str13);
                printJavaDoc(sb8.toString());
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit("public void setNil" + str12 + str76);
                startBlock();
                emitImplementationPreamble();
                z = z11;
                str8 = str75;
                str9 = str76;
                str3 = str77;
                emitPre(schemaType, 1, identifier, z, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                str2 = str70;
                str16 = str74;
                emitGetTarget(str10, identifier, z, "0", 3, str7);
                emit("target.setNil();");
                emitPost(schemaType, 1, identifier, z, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
                emitImplementationPostamble();
                endBlock();
            } else {
                z = z4;
                str8 = str75;
                str9 = str76;
                str3 = str77;
                str2 = str70;
                str16 = str74;
            }
        } else {
            str2 = strNonExtraKeyword;
            str3 = "public ";
            str4 = " ";
            str5 = ") {";
            str6 = strJavaTypeForProperty;
            str7 = strXmlTypeForProperty;
            str8 = " target = null;";
            str9 = "() {";
            str10 = setIdentifier;
            str11 = ", ";
            str12 = javaPropertyName;
            z = zIsAttribute;
            str13 = string;
            str14 = "(";
            i3 = i2;
            set = compilePartialMethod;
            str15 = "public void set";
            str16 = ");";
        }
        if (schemaProperty.extendsJavaOption() && (set == null || set.contains(XmlOptions.BeanMethod.UNSET))) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(zExtendsJavaArray ? "Removes first " : "Unsets the ");
            sb9.append(str13);
            printJavaDoc(sb9.toString());
            if (!this.opt.isCompileNoAnnotations()) {
                emit("@Override");
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append("public void unset");
            sb10.append(str12);
            str19 = str9;
            sb10.append(str19);
            emit(sb10.toString());
            startBlock();
            emitImplementationPreamble();
            emitPre(schemaType, 3, identifier, z, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
            boolean z12 = z;
            if (z12) {
                emit("get_store().remove_attribute(" + identifier + str16);
                str68 = str10;
            } else {
                StringBuilder sb11 = new StringBuilder();
                sb11.append("get_store().remove_element(");
                str68 = str10;
                sb11.append(str68);
                sb11.append(", 0);");
                emit(sb11.toString());
            }
            str18 = str68;
            str17 = str7;
            z2 = z12;
            emitPost(schemaType, 3, identifier, z12, zExtendsJavaArray ? "0" : StructuredDataId.RESERVED);
            emitImplementationPostamble();
            endBlock();
        } else {
            str17 = str7;
            z2 = z;
            str18 = str10;
            str19 = str9;
        }
        if (zExtendsJavaArray) {
            String str81 = str12 + SoapEncSchemaTypeSystem.SOAP_ARRAY;
            if (set != null && !set.contains(XmlOptions.BeanMethod.SET_ARRAY)) {
                schemaType2 = schemaType;
                str20 = str19;
                set2 = set;
                str28 = str81;
                str21 = str12;
                str22 = str15;
                str23 = str14;
                str24 = str2;
                str26 = str18;
                str29 = "arraySetterHelper(";
                str27 = "Array) {";
                str25 = str11;
            } else if (z6) {
                printJavaDoc("Sets array of all " + str13 + "  WARNING: This method is not atomicaly synchronized.");
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                StringBuilder sb12 = new StringBuilder();
                str22 = str15;
                sb12.append(str22);
                sb12.append(str81);
                str21 = str12;
                str23 = str14;
                sb12.append(str23);
                str20 = str19;
                String str82 = str6;
                sb12.append(str82);
                set2 = set;
                sb12.append("[] ");
                str24 = str2;
                sb12.append(str24);
                sb12.append("Array) {");
                emit(sb12.toString());
                startBlock();
                emit("check_orphaned();");
                schemaType2 = schemaType;
                str27 = "Array) {";
                emitPre(schemaType2, 1, identifier, z2);
                if (!z9) {
                    str6 = str82;
                    str30 = str11;
                    str31 = str18;
                    if (z8) {
                        emit("arraySetterHelper(" + str24 + "Array, " + identifier + str30 + str31 + str16);
                    } else {
                        emit("arraySetterHelper(" + str24 + "Array, " + identifier + str16);
                    }
                } else if (z8) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append("unionArraySetterHelper(");
                    sb13.append(str24);
                    sb13.append("Array, ");
                    sb13.append(identifier);
                    str30 = str11;
                    sb13.append(str30);
                    str6 = str82;
                    str31 = str18;
                    sb13.append(str31);
                    sb13.append(str16);
                    emit(sb13.toString());
                } else {
                    emit("unionArraySetterHelper(" + str24 + "Array, " + identifier + str16);
                    str6 = str82;
                    str30 = str11;
                    str31 = str18;
                }
                emitPost(schemaType2, 1, identifier, z2);
                endBlock();
                str25 = str30;
                str26 = str31;
                str28 = str81;
                str29 = "arraySetterHelper(";
            } else {
                schemaType2 = schemaType;
                str20 = str19;
                set2 = set;
                str21 = str12;
                str22 = str15;
                str23 = str14;
                str24 = str2;
                String str83 = str18;
                str25 = str11;
                printJavaDoc("Sets array of all " + str13);
                if (!this.opt.isCompileNoAnnotations()) {
                    emit("@Override");
                }
                emit(str22 + str81 + str23 + str6 + "[] " + str24 + "Array) {");
                startBlock();
                emitImplementationPreamble();
                emitPre(schemaType2, 1, identifier, z2);
                if (!z9) {
                    str26 = str83;
                    str27 = "Array) {";
                    if (schemaProperty.getJavaTypeCode() == 20) {
                        if (z8) {
                            str28 = str81;
                            emit("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(" + str24 + "Array.length, " + identifier + str25 + str26 + str16);
                            emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                            StringBuilder sb14 = new StringBuilder();
                            sb14.append("    ");
                            sb14.append(getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType()));
                            sb14.append(str23);
                            sb14.append(str24);
                            sb14.append("Array[i], dests[i]);");
                            emit(sb14.toString());
                            emit("}");
                        } else {
                            emit("org.apache.xmlbeans.SimpleValue[] dests = arraySetterHelper(" + str24 + "Array.length, " + identifier + str16);
                            emit("for ( int i = 0 ; i < dests.length ; i++ ) {");
                            StringBuilder sb15 = new StringBuilder();
                            sb15.append("    ");
                            str28 = str81;
                            sb15.append(getUserTypeStaticHandlerMethod(true, (SchemaTypeImpl) schemaProperty.getType()));
                            sb15.append(str23);
                            sb15.append(str24);
                            sb15.append("Array[i], dests[i]);");
                            emit(sb15.toString());
                            emit("}");
                        }
                        str29 = "arraySetterHelper(";
                        emitPost(schemaType2, 1, identifier, z2);
                        emitImplementationPostamble();
                        endBlock();
                    } else {
                        str28 = str81;
                        if (z8) {
                            str29 = "arraySetterHelper(";
                            emit(str29 + str24 + "Array, " + identifier + str25 + str26 + str16);
                        } else {
                            StringBuilder sb16 = new StringBuilder();
                            str29 = "arraySetterHelper(";
                            sb16.append(str29);
                            sb16.append(str24);
                            sb16.append("Array, ");
                            sb16.append(identifier);
                            sb16.append(str16);
                            emit(sb16.toString());
                        }
                        emitPost(schemaType2, 1, identifier, z2);
                        emitImplementationPostamble();
                        endBlock();
                    }
                } else if (z8) {
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append("unionArraySetterHelper(");
                    sb17.append(str24);
                    sb17.append("Array, ");
                    sb17.append(identifier);
                    sb17.append(str25);
                    str26 = str83;
                    sb17.append(str26);
                    sb17.append(str16);
                    emit(sb17.toString());
                    str27 = "Array) {";
                    str28 = str81;
                    str29 = "arraySetterHelper(";
                    emitPost(schemaType2, 1, identifier, z2);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    emit("unionArraySetterHelper(" + str24 + "Array, " + identifier + str16);
                    str27 = "Array) {";
                    str28 = str81;
                    str29 = "arraySetterHelper(";
                    str26 = str83;
                    emitPost(schemaType2, 1, identifier, z2);
                    emitImplementationPostamble();
                    endBlock();
                }
            }
            if (set2 != null) {
                str32 = str16;
                set3 = set2;
                if (!set3.contains(XmlOptions.BeanMethod.SET_IDX)) {
                    str39 = str26;
                    str34 = "Array, ";
                    str38 = str25;
                    str35 = str29;
                    str36 = "(int i, ";
                    str41 = str28;
                    str40 = str20;
                    i4 = i3;
                    str33 = str5;
                    str37 = str4;
                }
                if (z6 && (set3 == null || set3.contains(XmlOptions.BeanMethod.XSET_ARRAY))) {
                    printJavaDoc("Sets (as xml) array of all " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append("public void xset");
                    sb18.append(str41);
                    sb18.append(str23);
                    str42 = str17;
                    sb18.append(str42);
                    sb18.append("[]");
                    sb18.append(str24);
                    sb18.append(str27);
                    emit(sb18.toString());
                    startBlock();
                    emitImplementationPreamble();
                    emitPre(schemaType, 1, identifier, z2);
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append(str35);
                    sb19.append(str24);
                    sb19.append(str34);
                    sb19.append(identifier);
                    str43 = str32;
                    sb19.append(str43);
                    emit(sb19.toString());
                    emitPost(schemaType, 1, identifier, z2);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str42 = str17;
                    str43 = str32;
                }
                if (z6 && (set3 == null || set3.contains(XmlOptions.BeanMethod.XSET_IDX))) {
                    printJavaDoc("Sets (as xml) ith " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    StringBuilder sb20 = new StringBuilder();
                    sb20.append("public void xset");
                    sb20.append(str41);
                    sb20.append(str36);
                    sb20.append(str42);
                    String str84 = str37;
                    sb20.append(str84);
                    sb20.append(str24);
                    String str85 = str33;
                    sb20.append(str85);
                    emit(sb20.toString());
                    startBlock();
                    emitImplementationPreamble();
                    str45 = str23;
                    str47 = str85;
                    str48 = str84;
                    str46 = str36;
                    str44 = str42;
                    emitPre(schemaType, 1, identifier, z2, "i");
                    i5 = i4;
                    emitGetTarget(str39, identifier, z2, "i", 4, str44);
                    emit("target.set(" + str24 + str43);
                    emitPost(schemaType, 1, identifier, z2, "i");
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str44 = str42;
                    i5 = i4;
                    str45 = str23;
                    str46 = str36;
                    str47 = str33;
                    str48 = str37;
                }
                if (z10 && (set3 == null || set3.contains(XmlOptions.BeanMethod.SET_NIL_IDX))) {
                    printJavaDoc("Nils the ith " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit("public void setNil" + str41 + "(int i) {");
                    startBlock();
                    emitImplementationPreamble();
                    emitPre(schemaType, 1, identifier, z2, "i");
                    emitGetTarget(str39, identifier, z2, "i", 4, str44);
                    emit("target.setNil();");
                    emitPost(schemaType, 1, identifier, z2, "i");
                    emitImplementationPostamble();
                    endBlock();
                }
                if (z6 && (set3 == null || set3.contains(XmlOptions.BeanMethod.INSERT_IDX))) {
                    printJavaDoc("Inserts the value as the ith " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    StringBuilder sb21 = new StringBuilder();
                    sb21.append("public void insert");
                    String str86 = str21;
                    sb21.append(str86);
                    sb21.append(str46);
                    sb21.append(str6);
                    String str87 = str48;
                    sb21.append(str87);
                    sb21.append(str24);
                    String str88 = str47;
                    sb21.append(str88);
                    emit(sb21.toString());
                    startBlock();
                    emitImplementationPreamble();
                    str55 = str88;
                    str54 = str87;
                    str52 = str86;
                    emitPre(schemaType, 2, identifier, z2, "i");
                    StringBuilder sb22 = new StringBuilder();
                    String str89 = str;
                    sb22.append(str89);
                    sb22.append(" target =");
                    emit(sb22.toString());
                    indent();
                    if (z8) {
                        str65 = str45;
                        StringBuilder sb23 = new StringBuilder();
                        sb23.append(str65);
                        sb23.append(str89);
                        sb23.append(")get_store().insert_element_user(");
                        str66 = str39;
                        sb23.append(str66);
                        str67 = str38;
                        sb23.append(str67);
                        sb23.append(identifier);
                        sb23.append(", i);");
                        emit(sb23.toString());
                    } else {
                        StringBuilder sb24 = new StringBuilder();
                        str65 = str45;
                        sb24.append(str65);
                        sb24.append(str89);
                        sb24.append(")get_store().insert_element_user(");
                        sb24.append(identifier);
                        sb24.append(", i);");
                        emit(sb24.toString());
                        str66 = str39;
                        str67 = str38;
                    }
                    outdent();
                    int i8 = i5;
                    printJSetValue(i8, str24, (SchemaTypeImpl) schemaProperty.getType());
                    str57 = ", i);";
                    i6 = i8;
                    str53 = str67;
                    str51 = str66;
                    str50 = str65;
                    str49 = ")get_store().insert_element_user(";
                    str56 = str89;
                    emitPost(schemaType, 2, identifier, z2, "i");
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str49 = ")get_store().insert_element_user(";
                    str50 = str45;
                    str51 = str39;
                    str52 = str21;
                    str53 = str38;
                    str54 = str48;
                    str55 = str47;
                    str56 = str;
                    str57 = ", i);";
                    i6 = i5;
                }
                if (z6 && (set3 == null || set3.contains(XmlOptions.BeanMethod.ADD))) {
                    printJavaDoc("Appends the value as the last " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit("public void add" + str52 + str50 + str6 + str54 + str24 + str55);
                    startBlock();
                    emitImplementationPreamble();
                    StringBuilder sb25 = new StringBuilder();
                    sb25.append(str56);
                    str58 = str8;
                    sb25.append(str58);
                    emit(sb25.toString());
                    emitPre(schemaType, 2, identifier, z2);
                    emitAddTarget(identifier, z2, str56);
                    printJSetValue(i6, str24, (SchemaTypeImpl) schemaProperty.getType());
                    emitPost(schemaType, 2, identifier, z2);
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str58 = str8;
                }
                if (set3 != null || set3.contains(XmlOptions.BeanMethod.INSERT_NEW_IDX)) {
                    printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    StringBuilder sb26 = new StringBuilder();
                    str59 = str3;
                    sb26.append(str59);
                    str60 = str44;
                    sb26.append(str60);
                    sb26.append(" insertNew");
                    sb26.append(str52);
                    sb26.append("(int i) {");
                    emit(sb26.toString());
                    startBlock();
                    emitImplementationPreamble();
                    emit(str60 + str58);
                    str61 = str58;
                    emitPre(schemaType, 2, identifier, z2, "i");
                    if (z8) {
                        StringBuilder sb27 = new StringBuilder();
                        sb27.append("target = (");
                        sb27.append(str60);
                        sb27.append(str49);
                        sb27.append(identifier);
                        str62 = str57;
                        sb27.append(str62);
                        emit(sb27.toString());
                        str63 = str51;
                    } else {
                        str62 = str57;
                        StringBuilder sb28 = new StringBuilder();
                        sb28.append("target = (");
                        sb28.append(str60);
                        sb28.append(str49);
                        str63 = str51;
                        sb28.append(str63);
                        sb28.append(str53);
                        sb28.append(identifier);
                        sb28.append(str62);
                        emit(sb28.toString());
                    }
                    str57 = str62;
                    str64 = str63;
                    emitPost(schemaType, 2, identifier, z2, "i");
                    emit("return target;");
                    emitImplementationPostamble();
                    endBlock();
                } else {
                    str61 = str58;
                    str60 = str44;
                    str59 = str3;
                    str64 = str51;
                }
                if (set3 != null || set3.contains(XmlOptions.BeanMethod.ADD_NEW)) {
                    printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit(str59 + str60 + " addNew" + str52 + str40);
                    startBlock();
                    emitImplementationPreamble();
                    StringBuilder sb29 = new StringBuilder();
                    sb29.append(str60);
                    sb29.append(str61);
                    emit(sb29.toString());
                    emitPre(schemaType, 2, identifier, z2);
                    emitAddTarget(identifier, z2, str60);
                    emitPost(schemaType, 2, identifier, z2);
                    emit("return target;");
                    emitImplementationPostamble();
                    endBlock();
                }
                if (set3 != null || set3.contains(XmlOptions.BeanMethod.REMOVE_IDX)) {
                    printJavaDoc("Removes the ith " + str13);
                    if (!this.opt.isCompileNoAnnotations()) {
                        emit("@Override");
                    }
                    emit("public void remove" + str52 + "(int i) {");
                    startBlock();
                    emitImplementationPreamble();
                    boolean z13 = z2;
                    emitPre(schemaType, 3, identifier, z13, "i");
                    emit("get_store().remove_element(" + str64 + str57);
                    emitPost(schemaType, 3, identifier, z13, "i");
                    emitImplementationPostamble();
                    endBlock();
                }
                return;
            }
            str32 = str16;
            set3 = set2;
            StringBuilder sb30 = new StringBuilder();
            String str90 = str26;
            sb30.append("Sets ith ");
            sb30.append(str13);
            printJavaDoc(sb30.toString());
            if (!this.opt.isCompileNoAnnotations()) {
                emit("@Override");
            }
            StringBuilder sb31 = new StringBuilder();
            sb31.append(str22);
            String str91 = str28;
            sb31.append(str91);
            sb31.append("(int i, ");
            sb31.append(str6);
            String str92 = str4;
            sb31.append(str92);
            sb31.append(str24);
            String str93 = str5;
            sb31.append(str93);
            emit(sb31.toString());
            startBlock();
            if (!z6 || z8) {
                str33 = str93;
                str34 = "Array, ";
                str35 = str29;
                str36 = "(int i, ";
                str37 = str92;
                emitImplementationPreamble();
                emitPre(schemaType, 1, identifier, z2, "i");
                str38 = str25;
                str6 = str6;
                str39 = str90;
                str40 = str20;
                str41 = str91;
                emitGetTarget(str90, identifier, z2, "i", 4, str);
                i4 = i3;
                printJSetValue(i4, str24, (SchemaTypeImpl) schemaProperty.getType());
                emitPost(schemaType, 1, identifier, z2, "i");
                emitImplementationPostamble();
            } else {
                str36 = "(int i, ";
                str33 = str93;
                str37 = str92;
                str34 = "Array, ";
                str35 = str29;
                boolean z14 = z2;
                String str94 = str25;
                emitPre(schemaType, 1, identifier, z14, "i");
                emit("generatedSetterHelperImpl(" + str24 + str94 + str90 + ", i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);");
                emitPost(schemaType, 1, identifier, z14, "i");
                str38 = str94;
                str39 = str90;
                str40 = str20;
                str41 = str91;
                i4 = i3;
            }
            endBlock();
            if (z6) {
                str42 = str17;
                str43 = str32;
            }
            if (z6) {
                str44 = str42;
                i5 = i4;
                str45 = str23;
                str46 = str36;
                str47 = str33;
                str48 = str37;
            }
            if (z10) {
                printJavaDoc("Nils the ith " + str13);
                if (!this.opt.isCompileNoAnnotations()) {
                }
                emit("public void setNil" + str41 + "(int i) {");
                startBlock();
                emitImplementationPreamble();
                emitPre(schemaType, 1, identifier, z2, "i");
                emitGetTarget(str39, identifier, z2, "i", 4, str44);
                emit("target.setNil();");
                emitPost(schemaType, 1, identifier, z2, "i");
                emitImplementationPostamble();
                endBlock();
            }
            if (z6) {
                str49 = ")get_store().insert_element_user(";
                str50 = str45;
                str51 = str39;
                str52 = str21;
                str53 = str38;
                str54 = str48;
                str55 = str47;
                str56 = str;
                str57 = ", i);";
                i6 = i5;
            }
            if (z6) {
                str58 = str8;
            }
            if (set3 != null) {
                printJavaDoc("Inserts and returns a new empty value (as xml) as the ith " + str13);
                if (!this.opt.isCompileNoAnnotations()) {
                }
                StringBuilder sb262 = new StringBuilder();
                str59 = str3;
                sb262.append(str59);
                str60 = str44;
                sb262.append(str60);
                sb262.append(" insertNew");
                sb262.append(str52);
                sb262.append("(int i) {");
                emit(sb262.toString());
                startBlock();
                emitImplementationPreamble();
                emit(str60 + str58);
                str61 = str58;
                emitPre(schemaType, 2, identifier, z2, "i");
                if (z8) {
                }
                str57 = str62;
                str64 = str63;
                emitPost(schemaType, 2, identifier, z2, "i");
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (set3 != null) {
                printJavaDoc("Appends and returns a new empty value (as xml) as the last " + str13);
                if (!this.opt.isCompileNoAnnotations()) {
                }
                emit(str59 + str60 + " addNew" + str52 + str40);
                startBlock();
                emitImplementationPreamble();
                StringBuilder sb292 = new StringBuilder();
                sb292.append(str60);
                sb292.append(str61);
                emit(sb292.toString());
                emitPre(schemaType, 2, identifier, z2);
                emitAddTarget(identifier, z2, str60);
                emitPost(schemaType, 2, identifier, z2);
                emit("return target;");
                emitImplementationPostamble();
                endBlock();
            }
            if (set3 != null) {
            }
            printJavaDoc("Removes the ith " + str13);
            if (!this.opt.isCompileNoAnnotations()) {
            }
            emit("public void remove" + str52 + "(int i) {");
            startBlock();
            emitImplementationPreamble();
            boolean z132 = z2;
            emitPre(schemaType, 3, identifier, z132, "i");
            emit("get_store().remove_element(" + str64 + str57);
            emitPost(schemaType, 3, identifier, z132, "i");
            emitImplementationPostamble();
            endBlock();
        }
    }

    void printStaticFields(SchemaProperty[] schemaPropertyArr, Map<SchemaProperty, Identifier> map) throws IOException {
        if (schemaPropertyArr.length == 0) {
            return;
        }
        emit("");
        emit("private static final QName[] PROPERTY_QNAME = {");
        indent();
        int iMax = 0;
        for (SchemaProperty schemaProperty : schemaPropertyArr) {
            QName name = schemaProperty.getName();
            map.put(schemaProperty, new Identifier(map.size()));
            emit("new QName(\"" + name.getNamespaceURI() + "\", \"" + name.getLocalPart() + "\"),");
            iMax = Math.max(iMax, schemaProperty.acceptedNames() == null ? 0 : schemaProperty.acceptedNames().length);
        }
        outdent();
        emit("};");
        emit("");
        int i2 = 1;
        if (iMax > 1) {
            emit("private static final QNameSet[] PROPERTY_QSET = {");
            int length = schemaPropertyArr.length;
            int i3 = 0;
            while (i3 < length) {
                SchemaProperty schemaProperty2 = schemaPropertyArr[i3];
                QName[] qNameArrAcceptedNames = schemaProperty2.acceptedNames();
                if (qNameArrAcceptedNames != null && qNameArrAcceptedNames.length > i2) {
                    map.get(schemaProperty2).setSetIndex(0);
                    emit("QNameSet.forArray( new QName[] { ");
                    indent();
                    for (QName qName : qNameArrAcceptedNames) {
                        emit("new QName(\"" + qName.getNamespaceURI() + "\", \"" + qName.getLocalPart() + "\"),");
                    }
                    outdent();
                    emit("}),");
                }
                i3++;
                i2 = 1;
            }
            emit("};");
        }
    }

    void printStaticTypeDeclaration(SchemaType schemaType, SchemaTypeSystem schemaTypeSystem) throws IOException {
        String simpleName = ((!schemaType.isAnonymousType() || schemaType.isDocumentType() || schemaType.isAttributeType()) ? schemaType.isSimpleType() ? SimpleTypeFactory.class : schemaType.isAbstract() ? AbstractDocumentFactory.class : DocumentFactory.class : ElementFactory.class).getSimpleName();
        emit(simpleName + "<" + schemaType.getFullJavaName().replace('$', NameUtil.PERIOD) + "> Factory = new " + simpleName + "<>(" + schemaType.getTypeSystem().getName() + ".TypeSystemHolder.typeSystem, \"" + ((SchemaTypeSystemImpl) schemaTypeSystem).handleForType(schemaType) + "\");");
        emit("org.apache.xmlbeans.SchemaType type = Factory.getType();");
        emit("");
    }

    void printStringEnumeration(SchemaType schemaType) throws IOException {
        String fullJavaName = schemaType.getBaseEnumType().getFullJavaName();
        boolean zHasBase = hasBase(schemaType);
        if (!zHasBase) {
            emit("");
            emit("org.apache.xmlbeans.StringEnumAbstractBase getEnumValue();", XmlOptions.BeanMethod.GET);
            emit("void setEnumValue(org.apache.xmlbeans.StringEnumAbstractBase e);", XmlOptions.BeanMethod.SET);
        }
        emit("");
        SchemaStringEnumEntry[] stringEnumEntries = schemaType.getStringEnumEntries();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (SchemaStringEnumEntry schemaStringEnumEntry : stringEnumEntries) {
            String string = schemaStringEnumEntry.getString();
            if (hashSet.contains(string)) {
                hashSet2.add(string);
            } else {
                hashSet.add(string);
                String enumName = schemaStringEnumEntry.getEnumName();
                if (zHasBase) {
                    emit(fullJavaName + ".Enum " + enumName + " = " + fullJavaName + "." + enumName + ";");
                } else {
                    emit("Enum " + enumName + " = Enum.forString(\"" + javaStringEscape(string) + "\");");
                }
            }
        }
        emit("");
        for (SchemaStringEnumEntry schemaStringEnumEntry2 : stringEnumEntries) {
            if (!hashSet2.contains(schemaStringEnumEntry2.getString())) {
                String str = "INT_" + schemaStringEnumEntry2.getEnumName();
                if (zHasBase) {
                    emit("int " + str + " = " + fullJavaName + "." + str + ";");
                } else {
                    emit("int " + str + " = Enum." + str + ";");
                }
            }
        }
        if (zHasBase) {
            return;
        }
        emit("");
        emit("/**");
        emit(" * Enumeration value class for " + fullJavaName + ".");
        emit(" * These enum values can be used as follows:");
        emit(" * <pre>");
        emit(" * enum.toString(); // returns the string value of the enum");
        emit(" * enum.intValue(); // returns an int value, useful for switches");
        if (stringEnumEntries.length > 0) {
            emit(" * // e.g., case Enum.INT_" + stringEnumEntries[0].getEnumName());
        }
        emit(" * Enum.forString(s); // returns the enum value for a string");
        emit(" * Enum.forInt(i); // returns the enum value for an int");
        emit(" * </pre>");
        emit(" * Enumeration objects are immutable singleton objects that");
        emit(" * can be compared using == object equality. They have no");
        emit(" * public constructor. See the constants defined within this");
        emit(" * class for all the valid values.");
        emit(" */");
        emit("final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase {");
        indent();
        emit("/**");
        emit(" * Returns the enum value for a string, or null if none.");
        emit(" */");
        emit("public static Enum forString(java.lang.String s) {");
        emit("    return (Enum)table.forString(s);");
        emit("}");
        emit("");
        emit("/**");
        emit(" * Returns the enum value corresponding to an int, or null if none.");
        emit(" */");
        emit("public static Enum forInt(int i) {");
        emit("    return (Enum)table.forInt(i);");
        emit("}");
        emit("");
        emit("private Enum(java.lang.String s, int i) {");
        emit("    super(s, i);");
        emit("}");
        emit("");
        for (SchemaStringEnumEntry schemaStringEnumEntry3 : stringEnumEntries) {
            emit("static final int " + ("INT_" + schemaStringEnumEntry3.getEnumName()) + " = " + schemaStringEnumEntry3.getIntValue() + ";");
        }
        emit("");
        emit("public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =");
        emit("    new org.apache.xmlbeans.StringEnumAbstractBase.Table(new Enum[] {");
        indent();
        for (SchemaStringEnumEntry schemaStringEnumEntry4 : stringEnumEntries) {
            emit("new Enum(\"" + javaStringEscape(schemaStringEnumEntry4.getString()) + "\", " + ("INT_" + schemaStringEnumEntry4.getEnumName()) + "),");
        }
        outdent();
        emit("});");
        emit("private static final long serialVersionUID = 1L;");
        emit("private java.lang.Object readResolve() {");
        emit("    return forInt(intValue());");
        emit("}");
        outdent();
        emit("}");
    }

    void printTopComment(SchemaType schemaType) throws IOException {
        emit("/*");
        if (schemaType.getName() != null) {
            emit(" * XML Type:  " + schemaType.getName().getLocalPart());
            emit(" * Namespace: " + schemaType.getName().getNamespaceURI());
        } else {
            QName attributeTypeAttributeName = null;
            if (schemaType.isDocumentType()) {
                attributeTypeAttributeName = schemaType.getDocumentElementName();
                emit(" * An XML document type.");
            } else if (schemaType.isAttributeType()) {
                attributeTypeAttributeName = schemaType.getAttributeTypeAttributeName();
                emit(" * An XML attribute type.");
            }
            emit(" * Localname: " + attributeTypeAttributeName.getLocalPart());
            emit(" * Namespace: " + attributeTypeAttributeName.getNamespaceURI());
        }
        emit(" * Java type: " + schemaType.getFullJavaName());
        emit(" *");
        emit(" * Automatically generated - do not modify.");
        emit(" */");
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printType(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        this.opt = xmlOptions;
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, true);
        emit("");
        emit("import " + ElementFactory.class.getName() + ";");
        emit("import " + AbstractDocumentFactory.class.getName() + ";");
        emit("import " + DocumentFactory.class.getName() + ";");
        emit("import " + SimpleTypeFactory.class.getName() + ";");
        emit("");
        printInnerType(schemaType, schemaType.getTypeSystem());
        this._writer.flush();
    }

    @Override // org.apache.xmlbeans.SchemaCodePrinter
    public void printTypeImpl(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        this.opt = xmlOptions;
        this._writer = writer;
        printTopComment(schemaType);
        printPackage(schemaType, false);
        emit("");
        emit("import javax.xml.namespace.QName;");
        emit("import org.apache.xmlbeans.QNameSet;");
        emit("import org.apache.xmlbeans.XmlObject;");
        emit("");
        printInnerTypeImpl(schemaType, schemaType.getTypeSystem(), false);
    }

    void startBlock() {
        indent();
    }

    void startClass(SchemaType schemaType, boolean z) throws IOException {
        String shortJavaImplName = schemaType.getShortJavaImplName();
        String baseClass = getBaseClass(schemaType);
        StringBuilder sb = new StringBuilder();
        sb.append(schemaType.getFullJavaName().replace('$', NameUtil.PERIOD));
        if (schemaType.getSimpleVariety() == 2) {
            for (SchemaType schemaType2 : schemaType.getUnionMemberTypes()) {
                sb.append(", ");
                sb.append(schemaType2.getFullJavaName().replace('$', NameUtil.PERIOD));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("public ");
        sb2.append(z ? "static " : "");
        sb2.append("class ");
        sb2.append(shortJavaImplName);
        sb2.append(" extends ");
        sb2.append(baseClass);
        sb2.append(" implements ");
        sb2.append((Object) sb);
        sb2.append(" {");
        emit(sb2.toString());
        startBlock();
        emit("private static final long serialVersionUID = 1L;");
    }

    void startInterface(SchemaType schemaType) throws IOException {
        emit("public interface " + schemaType.getShortJavaName() + " extends " + findJavaType(schemaType.getBaseType()) + getExtensionInterfaces(schemaType) + " {");
        indent();
        emitSpecializedAccessors(schemaType);
    }

    String xmlTypeForProperty(SchemaProperty schemaProperty) {
        return findJavaType(schemaProperty.javaBasedOnType()).replace('$', NameUtil.PERIOD);
    }

    void emitPost(SchemaType schemaType, int i2, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null) {
            return;
        }
        if (prePostExtension.hasPreCall()) {
            endBlock();
        }
        if (prePostExtension.hasPostCall()) {
            emit(prePostExtension.getStaticHandler() + ".postSet(" + prePostOpString(i2) + ", this, " + str + ", " + z + ", " + str2 + ");");
        }
    }

    void emitPre(SchemaType schemaType, int i2, String str, boolean z, String str2) throws IOException {
        PrePostExtension prePostExtension;
        SchemaTypeImpl impl = getImpl(schemaType);
        if (impl == null || (prePostExtension = impl.getPrePostExtension()) == null || !prePostExtension.hasPreCall()) {
            return;
        }
        emit("if ( " + prePostExtension.getStaticHandler() + ".preSet(" + prePostOpString(i2) + ", this, " + str + ", " + z + ", " + str2 + ")) {");
        startBlock();
    }

    void emit(String str) throws IOException {
        if (!str.trim().isEmpty()) {
            int i2 = this._indent;
            if (i2 > 20) {
                i2 = (i2 / 2) + 10;
            }
            if (i2 > 40) {
                i2 = 40;
            }
            this._writer.write(MAX_SPACES.substring(0, i2));
        }
        try {
            this._writer.write(str);
        } catch (CharacterCodingException unused) {
            this._writer.write(makeSafe(str));
        }
        this._writer.write(System.lineSeparator());
    }

    void printJavaDoc(String str) throws IOException {
        emit("");
        emit("/**");
        emit(" * " + str);
        emit(" */");
    }
}
