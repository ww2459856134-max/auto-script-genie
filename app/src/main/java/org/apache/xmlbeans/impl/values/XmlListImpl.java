package org.apache.xmlbeans.impl.values;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlSimpleList;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* loaded from: classes2.dex */
public class XmlListImpl extends XmlObjectBase implements XmlAnySimpleType {
    private static final String[] EMPTY_STRINGARRAY = new String[0];
    private XmlSimpleList<?> _jvalue;
    private final SchemaType _schemaType;
    private XmlSimpleList<? extends XmlAnySimpleType> _value;

    public XmlListImpl(SchemaType schemaType, boolean z) {
        this._schemaType = schemaType;
        initComplexType(z, false);
    }

    private static String compute_list_text(List<? extends XmlAnySimpleType> list) {
        return list.isEmpty() ? "" : (String) list.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.values.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return XmlListImpl.object2String((XmlAnySimpleType) obj);
            }
        }).collect(Collectors.joining(" "));
    }

    private static boolean contains_white_space(String str) {
        return str.indexOf(32) >= 0 || str.indexOf(9) >= 0 || str.indexOf(10) >= 0 || str.indexOf(13) >= 0;
    }

    static /* synthetic */ XmlAnySimpleType e(SchemaType schemaType, ValidationContext validationContext, String str) {
        try {
            return schemaType.newValue(str);
        } catch (XmlValueOutOfRangeException unused) {
            validationContext.invalid(XmlErrorCodes.LIST, new Object[]{"item '" + str + "' is not a valid value of " + QNameHelper.readable(schemaType)});
            return null;
        }
    }

    private static boolean equal_xmlLists(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!list.get(i2).equals(list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ XmlAnySimpleType g(SchemaType schemaType, Object obj) {
        if ((obj instanceof XmlObject) && permits_inner_space((XmlObject) obj) && contains_white_space(obj.toString())) {
            throw new XmlValueOutOfRangeException();
        }
        return schemaType.newValue(obj);
    }

    public static XmlSimpleList<? extends XmlAnySimpleType> lex(String str, final SchemaType schemaType, final ValidationContext validationContext, PrefixResolver prefixResolver) {
        boolean z;
        String[] strArrSplit_list = split_list(str);
        Function function = new Function() { // from class: org.apache.xmlbeans.impl.values.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return XmlListImpl.e(schemaType, validationContext, (String) obj);
            }
        };
        if (prefixResolver != null) {
            NamespaceContext.push(new NamespaceContext(prefixResolver));
            z = true;
        } else {
            z = false;
        }
        try {
            return new XmlSimpleList<>((List) Stream.of((Object[]) strArrSplit_list).map(function).collect(Collectors.toList()));
        } finally {
            if (z) {
                NamespaceContext.pop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String object2String(Object obj) {
        String stringValue = obj instanceof SimpleValue ? ((SimpleValue) obj).getStringValue() : obj.toString();
        return stringValue == null ? "" : stringValue;
    }

    private static boolean permits_inner_space(XmlObject xmlObject) {
        int builtinTypeCode = ((SimpleValue) xmlObject).instanceType().getPrimitiveType().getBuiltinTypeCode();
        return builtinTypeCode == 1 || builtinTypeCode == 2 || builtinTypeCode == 6 || builtinTypeCode == 12;
    }

    public static String[] split_list(String str) {
        if (str.isEmpty()) {
            return EMPTY_STRINGARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 < str.length() && XMLChar.isSpace(str.charAt(i2))) {
                i2++;
            } else {
                if (i2 >= str.length()) {
                    return (String[]) arrayList.toArray(EMPTY_STRINGARRAY);
                }
                int i3 = i2;
                while (i3 < str.length() && !XMLChar.isSpace(str.charAt(i3))) {
                    i3++;
                }
                arrayList.add(str.substring(i2, i3));
                i2 = i3;
            }
        }
    }

    public static void validateValue(XmlSimpleList<? extends XmlAnySimpleType> xmlSimpleList, SchemaType schemaType, ValidationContext validationContext) {
        int intValue;
        int intValue2;
        int intValue3;
        Object[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            int length = enumerationValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    validationContext.invalid(XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.LIST, xmlSimpleList, QNameHelper.readable(schemaType)});
                    break;
                } else if (equal_xmlLists(xmlSimpleList, ((XmlObjectBase) enumerationValues[i2]).xgetListValue())) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        XmlAnySimpleType facet = schemaType.getFacet(0);
        if (facet != null && (intValue3 = ((SimpleValue) facet).getIntValue()) != xmlSimpleList.size()) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, new Object[]{xmlSimpleList, Integer.valueOf(xmlSimpleList.size()), Integer.valueOf(intValue3), QNameHelper.readable(schemaType)});
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(1);
        if (facet2 != null && (intValue2 = ((SimpleValue) facet2).getIntValue()) > xmlSimpleList.size()) {
            validationContext.invalid(XmlErrorCodes.DATATYPE_MIN_LENGTH_VALID$LIST_LENGTH, new Object[]{xmlSimpleList, Integer.valueOf(xmlSimpleList.size()), Integer.valueOf(intValue2), QNameHelper.readable(schemaType)});
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(2);
        if (facet3 == null || (intValue = ((SimpleValue) facet3).getIntValue()) >= xmlSimpleList.size()) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.DATATYPE_MAX_LENGTH_VALID$LIST_LENGTH, new Object[]{xmlSimpleList, Integer.valueOf(xmlSimpleList.size()), Integer.valueOf(intValue), QNameHelper.readable(schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected String compute_text(NamespaceManager namespaceManager) {
        return compute_list_text(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean equal_to(XmlObject xmlObject) {
        return equal_xmlLists(this._value, ((XmlObjectBase) xmlObject).xgetListValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        check_dated();
        if (this._value == null) {
            return null;
        }
        XmlSimpleList<?> xmlSimpleList = this._jvalue;
        if (xmlSimpleList != null) {
            return xmlSimpleList;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends XmlAnySimpleType> it = this._value.iterator();
        while (it.hasNext()) {
            arrayList.add(XmlObjectBase.java_value(it.next()));
        }
        XmlSimpleList<?> xmlSimpleList2 = new XmlSimpleList<>(arrayList);
        this._jvalue = xmlSimpleList2;
        return xmlSimpleList2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected boolean is_defaultable_ws(String str) {
        try {
            XmlSimpleList<? extends XmlAnySimpleType> xmlSimpleList = this._value;
            set_text(str);
            this._value = xmlSimpleList;
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
    public void set_list(List<?> list) {
        boolean z;
        final SchemaType listItemType = this._schemaType.getListItemType();
        if (has_store()) {
            NamespaceContext.push(new NamespaceContext(get_store()));
            z = true;
        } else {
            z = false;
        }
        try {
            XmlSimpleList<? extends XmlAnySimpleType> xmlSimpleList = new XmlSimpleList<>((List) list.stream().map(new Function() { // from class: org.apache.xmlbeans.impl.values.x
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return XmlListImpl.g(listItemType, obj);
                }
            }).collect(Collectors.toList()));
            if (_validateOnSet()) {
                validateValue(xmlSimpleList, this._schemaType, XmlObjectBase._voorVc);
            }
            this._value = xmlSimpleList;
            this._jvalue = null;
        } finally {
            if (z) {
                NamespaceContext.pop();
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void set_text(String str) {
        if (_validateOnSet() && !this._schemaType.matchPatternFacet(str)) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.LIST, str, QNameHelper.readable(this._schemaType)});
        }
        SchemaType listItemType = this._schemaType.getListItemType();
        ValidationContext validationContext = XmlObjectBase._voorVc;
        XmlSimpleList<? extends XmlAnySimpleType> xmlSimpleListLex = lex(str, listItemType, validationContext, has_store() ? get_store() : null);
        if (_validateOnSet()) {
            validateValue(xmlSimpleListLex, this._schemaType, validationContext);
        }
        this._value = xmlSimpleListLex;
        this._jvalue = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void validate_simpleval(String str, ValidationContext validationContext) {
        validateValue(xgetListValue(), schemaType(), validationContext);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        XmlSimpleList<? extends XmlAnySimpleType> xmlSimpleList = this._value;
        if (xmlSimpleList == null) {
            return 0;
        }
        int size = xmlSimpleList.size();
        int size2 = this._value.size() / 9;
        if (size2 < 1) {
            size2 = 1;
        }
        for (int i2 = 0; i2 < this._value.size(); i2 += size2) {
            size = (size * 19) + this._value.get(i2).hashCode();
        }
        return size;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public XmlSimpleList<? extends XmlAnySimpleType> xgetListValue() {
        check_dated();
        return this._value;
    }
}
