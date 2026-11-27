package org.apache.xmlbeans.impl.inst2xsd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDuration;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlTime;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.inst2xsd.util.Attribute;
import org.apache.xmlbeans.impl.inst2xsd.util.Element;
import org.apache.xmlbeans.impl.inst2xsd.util.Type;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaGDateHolderEx;
import org.apache.xmlbeans.impl.values.JavaGDurationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolder;
import org.apache.xmlbeans.impl.values.JavaUriHolder;

/* loaded from: classes.dex */
public class RussianDollStrategy implements XsdGenStrategy {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
    static final QName _xsiNil = new QName(_xsi, "nil", "xsi");
    private final SCTValidationContext _validationContext = new SCTValidationContext();

    protected static class SCTValidationContext implements ValidationContext {
        protected boolean valid = true;

        protected SCTValidationContext() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            this.valid = false;
        }

        public boolean isValid() {
            return this.valid;
        }

        public void resetToValid() {
            this.valid = true;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            this.valid = false;
        }
    }

    protected Element addGlobalElement(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        Element globalElement = typeSystemHolder.getGlobalElement(element.getName());
        if (globalElement == null) {
            typeSystemHolder.addGlobalElement(element);
            return element;
        }
        combineTypes(globalElement.getType(), element.getType(), inst2XsdOptions);
        combineElementComments(globalElement, element);
        return globalElement;
    }

    protected void checkIfAttributeReferenceIsNeeded(Attribute attribute, String str, TypeSystemHolder typeSystemHolder) {
        if (attribute.getName().getNamespaceURI().equals("") || attribute.getName().getNamespaceURI().equals(str)) {
            return;
        }
        Attribute attribute2 = new Attribute();
        attribute2.setGlobal(true);
        attribute2.setName(attribute.getName());
        attribute2.setType(attribute.getType());
        typeSystemHolder.addGlobalAttribute(attribute2);
        attribute.setRef(attribute2);
    }

    protected void checkIfElementReferenceIsNeeded(Element element, String str, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        if (element.getName().getNamespaceURI().equals(str)) {
            return;
        }
        Element element2 = new Element();
        element2.setGlobal(true);
        element2.setName(element.getName());
        element2.setType(element.getType());
        if (element.isNillable()) {
            element2.setNillable(true);
            element.setNillable(false);
        }
        element.setRef(addGlobalElement(element2, typeSystemHolder, inst2XsdOptions));
    }

    protected void checkIfReferenceToGlobalTypeIsNeeded(Element element, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
    }

    protected void combineAttributesOfTypes(Type type, Type type2) {
        for (int i2 = 0; i2 < type2.getAttributes().size(); i2++) {
            Attribute attribute = type2.getAttributes().get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= type.getAttributes().size()) {
                    type.addAttribute(attribute);
                    break;
                }
                Attribute attribute2 = type.getAttributes().get(i3);
                if (attribute2.getName().equals(attribute.getName())) {
                    attribute2.getType().setName(combineToMoreGeneralSimpleType(attribute2.getType().getName(), attribute.getType().getName()));
                    break;
                }
                i3++;
            }
        }
        for (int i4 = 0; i4 < type.getAttributes().size(); i4++) {
            Attribute attribute3 = type.getAttributes().get(i4);
            for (int i5 = 0; i5 < type2.getAttributes().size(); i5++) {
                type2.getAttributes().get(i5).getName().equals(attribute3.getName());
            }
            attribute3.setOptional(true);
        }
    }

    protected void combineElementComments(Element element, Element element2) {
        if (element2.getComment() == null || element2.getComment().isEmpty()) {
            return;
        }
        if (element.getComment() == null) {
            element.setComment(element2.getComment());
            return;
        }
        element.setComment(element.getComment() + element2.getComment());
    }

    protected void combineElementsOfTypes(Type type, Type type2, Inst2XsdOptions inst2XsdOptions) {
        boolean z = (type.getTopParticleForComplexOrMixedContent() == 1 && type2.getTopParticleForComplexOrMixedContent() == 1) ? false : true;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; !z && i5 < type.getElements().size(); i5++) {
            Element element = type.getElements().get(i5);
            int i6 = i2;
            while (true) {
                if (i6 >= type2.getElements().size()) {
                    break;
                }
                if (element.getName().equals(type2.getElements().get(i6).getName())) {
                    i3 = i6;
                    break;
                }
                i6++;
            }
            if (i3 < i2) {
                arrayList.add(element);
                element.setMinOccurs(0);
            } else {
                int i7 = i2;
                while (true) {
                    if (i7 >= i3) {
                        break;
                    }
                    Element element2 = type2.getElements().get(i7);
                    for (int i8 = i5 + 1; i8 < type.getElements().size(); i8++) {
                        if (element2.getName().equals(type.getElements().get(i8).getName())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i7++;
                }
                if (i4 < i5) {
                    while (i2 < i3) {
                        Element element3 = type2.getElements().get(i2);
                        arrayList.add(element3);
                        element3.setMinOccurs(0);
                        i2++;
                    }
                    arrayList.add(element);
                    Element element4 = type2.getElements().get(i3);
                    if (element4.getMinOccurs() <= 0) {
                        element.setMinOccurs(0);
                    }
                    if (element4.getMaxOccurs() == -1) {
                        element.setMaxOccurs(-1);
                    }
                    combineTypes(element.getType(), element4.getType(), inst2XsdOptions);
                    combineElementComments(element, element4);
                    i2 = i3 + 1;
                } else {
                    z = true;
                }
            }
        }
        while (i2 < type2.getElements().size()) {
            Element element5 = type2.getElements().get(i2);
            arrayList.add(element5);
            element5.setMinOccurs(0);
            i2++;
        }
        if (!z) {
            type.setElements(arrayList);
            return;
        }
        type.setTopParticleForComplexOrMixedContent(2);
        for (int i9 = 0; i9 < type2.getElements().size(); i9++) {
            Element element6 = type2.getElements().get(i9);
            for (int i10 = 0; i10 < type.getElements().size(); i10++) {
                Element element7 = type.getElements().get(i10);
                element7.setMinOccurs(1);
                element7.setMaxOccurs(1);
                if (element7 != element6) {
                    if (element7.getName().equals(element6.getName())) {
                        combineTypes(element7.getType(), element6.getType(), inst2XsdOptions);
                        combineElementComments(element7, element6);
                    }
                }
            }
            type.addElement(element6);
            element6.setMinOccurs(1);
            element6.setMaxOccurs(1);
        }
    }

    protected void combineSimpleTypes(Type type, Type type2, Inst2XsdOptions inst2XsdOptions) {
        type.setName(combineToMoreGeneralSimpleType(type.getName(), type2.getName()));
        if (inst2XsdOptions.isUseEnumerations()) {
            type.addAllEnumerationsFrom(type2);
            if (type.getEnumerationValues().size() > inst2XsdOptions.getUseEnumerations()) {
                type.closeEnumeration();
            }
        }
    }

    protected QName combineToMoreGeneralSimpleType(QName qName, QName qName2) {
        if (qName.equals(qName2)) {
            return qName;
        }
        SchemaType schemaType = XmlShort.type;
        if (qName2.equals(schemaType.getName()) && qName.equals(XmlByte.type.getName())) {
            return qName2;
        }
        if (qName.equals(schemaType.getName()) && qName2.equals(XmlByte.type.getName())) {
            return qName;
        }
        SchemaType schemaType2 = XmlInt.type;
        if (qName2.equals(schemaType2.getName()) && (qName.equals(schemaType.getName()) || qName.equals(XmlByte.type.getName()))) {
            return qName2;
        }
        if (qName.equals(schemaType2.getName()) && (qName2.equals(schemaType.getName()) || qName2.equals(XmlByte.type.getName()))) {
            return qName;
        }
        SchemaType schemaType3 = XmlLong.type;
        if (qName2.equals(schemaType3.getName()) && (qName.equals(schemaType2.getName()) || qName.equals(schemaType.getName()) || qName.equals(XmlByte.type.getName()))) {
            return qName2;
        }
        if (qName.equals(schemaType3.getName()) && (qName2.equals(schemaType2.getName()) || qName2.equals(schemaType.getName()) || qName2.equals(XmlByte.type.getName()))) {
            return qName;
        }
        SchemaType schemaType4 = XmlInteger.type;
        if (qName2.equals(schemaType4.getName()) && (qName.equals(schemaType3.getName()) || qName.equals(schemaType2.getName()) || qName.equals(schemaType.getName()) || qName.equals(XmlByte.type.getName()))) {
            return qName2;
        }
        if (qName.equals(schemaType4.getName()) && (qName2.equals(schemaType3.getName()) || qName2.equals(schemaType2.getName()) || qName2.equals(schemaType.getName()) || qName2.equals(XmlByte.type.getName()))) {
            return qName;
        }
        SchemaType schemaType5 = XmlFloat.type;
        return (qName2.equals(schemaType5.getName()) && (qName.equals(schemaType4.getName()) || qName.equals(schemaType3.getName()) || qName.equals(schemaType2.getName()) || qName.equals(schemaType.getName()) || qName.equals(XmlByte.type.getName()))) ? qName2 : (qName.equals(schemaType5.getName()) && (qName2.equals(schemaType4.getName()) || qName2.equals(schemaType3.getName()) || qName2.equals(schemaType2.getName()) || qName2.equals(schemaType.getName()) || qName2.equals(XmlByte.type.getName()))) ? qName : XmlString.type.getName();
    }

    protected void combineTypes(Type type, Type type2, Inst2XsdOptions inst2XsdOptions) {
        if (type == type2) {
            return;
        }
        if (type.isGlobal() && type2.isGlobal() && type.getName().equals(type2.getName())) {
            return;
        }
        if (type.getContentType() == 1 && type2.getContentType() == 1) {
            combineSimpleTypes(type, type2, inst2XsdOptions);
            return;
        }
        if ((type.getContentType() == 1 || type.getContentType() == 2) && (type2.getContentType() == 1 || type2.getContentType() == 2)) {
            QName name = type.isComplexType() ? type.getExtensionType().getName() : type.getName();
            QName name2 = type2.isComplexType() ? type2.getExtensionType().getName() : type2.getName();
            type.setContentType(2);
            QName qNameCombineToMoreGeneralSimpleType = combineToMoreGeneralSimpleType(name, name2);
            if (type.isComplexType()) {
                type.setExtensionType(Type.createNamedType(qNameCombineToMoreGeneralSimpleType, 1));
            } else {
                type.setName(qNameCombineToMoreGeneralSimpleType);
            }
            combineAttributesOfTypes(type, type2);
            return;
        }
        if (type.getContentType() == 3 && type2.getContentType() == 3) {
            combineAttributesOfTypes(type, type2);
            combineElementsOfTypes(type, type2, inst2XsdOptions);
            return;
        }
        if (type.getContentType() == 1 || type.getContentType() == 2 || type2.getContentType() == 1 || type2.getContentType() == 2) {
            type.setContentType(4);
            combineAttributesOfTypes(type, type2);
            combineElementsOfTypes(type, type2, inst2XsdOptions);
        } else {
            if ((type.getContentType() != 1 && type.getContentType() != 2 && type.getContentType() != 3 && type.getContentType() != 4) || (type2.getContentType() != 1 && type2.getContentType() != 2 && type2.getContentType() != 3 && type2.getContentType() != 4)) {
                throw new IllegalArgumentException("Unknown content type.");
            }
            type.setContentType(4);
            combineAttributesOfTypes(type, type2);
            combineElementsOfTypes(type, type2, inst2XsdOptions);
        }
    }

    protected Attribute processAttribute(XmlCursor xmlCursor, Inst2XsdOptions inst2XsdOptions, String str, TypeSystemHolder typeSystemHolder) {
        Attribute attribute = new Attribute();
        attribute.setName(xmlCursor.getName());
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            Type typeCreateNamedType = Type.createNamedType(processSimpleContentType(xmlCursor.getTextValue(), inst2XsdOptions, xmlCursorNewCursor), 1);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            attribute.setType(typeCreateNamedType);
            checkIfAttributeReferenceIsNeeded(attribute, str, typeSystemHolder);
            return attribute;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected void processAttributesInComplexType(Type type, List<Attribute> list) {
        Iterator<Attribute> it = list.iterator();
        while (it.hasNext()) {
            type.addAttribute(it.next());
        }
    }

    @Override // org.apache.xmlbeans.impl.inst2xsd.XsdGenStrategy
    public void processDoc(XmlObject[] xmlObjectArr, Inst2XsdOptions inst2XsdOptions, TypeSystemHolder typeSystemHolder) {
        for (XmlObject xmlObject : xmlObjectArr) {
            XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
            try {
                StringBuilder sb = new StringBuilder();
                while (!xmlCursorNewCursor.isStart()) {
                    xmlCursorNewCursor.toNextToken();
                    if (xmlCursorNewCursor.isComment()) {
                        sb.append(xmlCursorNewCursor.getTextValue());
                    } else if (xmlCursorNewCursor.isEnddoc()) {
                        if (xmlCursorNewCursor != null) {
                            xmlCursorNewCursor.close();
                            return;
                        }
                        return;
                    }
                }
                Element elementProcessElement = processElement(xmlCursorNewCursor, sb.toString(), inst2XsdOptions, typeSystemHolder);
                elementProcessElement.setGlobal(true);
                addGlobalElement(elementProcessElement, typeSystemHolder, inst2XsdOptions);
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    protected Element processElement(XmlCursor xmlCursor, String str, Inst2XsdOptions inst2XsdOptions, TypeSystemHolder typeSystemHolder) {
        String string = str;
        Element element = new Element();
        element.setName(xmlCursor.getName());
        element.setGlobal(false);
        Type typeCreateUnnamedType = Type.createUnnamedType(1);
        element.setType(typeCreateUnnamedType);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            switch (xmlCursor.toNextToken().intValue()) {
                case 0:
                case 2:
                case 4:
                    String strCollapse = XmlWhitespace.collapse(sb.toString(), 3);
                    if (string == null) {
                        string = sb2.length() == 0 ? null : sb2.toString();
                    } else if (sb2.length() != 0) {
                        string = sb2.insert(0, string).toString();
                    }
                    element.setComment(string);
                    if (arrayList.isEmpty()) {
                        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
                        try {
                            xmlCursorNewCursor.toParent();
                            if (arrayList2.isEmpty()) {
                                typeCreateUnnamedType.setContentType(1);
                                typeCreateUnnamedType.setName(processSimpleContentType(sb.toString(), inst2XsdOptions, xmlCursorNewCursor));
                                if (XmlString.type.getName().equals(typeCreateUnnamedType.getName())) {
                                    strCollapse = sb.toString();
                                }
                                typeCreateUnnamedType.addEnumerationValue(strCollapse, xmlCursorNewCursor);
                            } else {
                                typeCreateUnnamedType.setContentType(2);
                                typeCreateUnnamedType.setExtensionType(Type.createNamedType(processSimpleContentType(sb.toString(), inst2XsdOptions, xmlCursorNewCursor), 1));
                                processAttributesInComplexType(typeCreateUnnamedType, arrayList2);
                            }
                            if (xmlCursorNewCursor != null) {
                                xmlCursorNewCursor.close();
                            }
                        } finally {
                        }
                    } else {
                        if (strCollapse.isEmpty()) {
                            typeCreateUnnamedType.setContentType(3);
                        } else {
                            typeCreateUnnamedType.setContentType(4);
                        }
                        processElementsInComplexType(typeCreateUnnamedType, arrayList, element.getName().getNamespaceURI(), typeSystemHolder, inst2XsdOptions);
                        processAttributesInComplexType(typeCreateUnnamedType, arrayList2);
                    }
                    checkIfReferenceToGlobalTypeIsNeeded(element, typeSystemHolder, inst2XsdOptions);
                    return element;
                case 1:
                    throw new IllegalStateException();
                case 3:
                    arrayList.add(processElement(xmlCursor, sb2.toString(), inst2XsdOptions, typeSystemHolder));
                    sb2.delete(0, sb2.length());
                    break;
                case 5:
                    sb.append(xmlCursor.getChars());
                    break;
                case 6:
                    QName name = xmlCursor.getName();
                    QName qName = _xsiNil;
                    if (!qName.getNamespaceURI().equals(name.getNamespaceURI())) {
                        arrayList2.add(processAttribute(xmlCursor, inst2XsdOptions, element.getName().getNamespaceURI(), typeSystemHolder));
                        break;
                    } else if (!qName.equals(name)) {
                        break;
                    } else {
                        element.setNillable(true);
                        break;
                    }
                case 7:
                case 9:
                    break;
                case 8:
                    sb2.append(xmlCursor.getTextValue());
                    break;
                default:
                    throw new IllegalStateException("Unknown TokenType.");
            }
        }
    }

    protected void processElementsInComplexType(Type type, List<Element> list, String str, TypeSystemHolder typeSystemHolder, Inst2XsdOptions inst2XsdOptions) {
        HashMap map = new HashMap();
        Element element = null;
        for (Element element2 : list) {
            if (element == null) {
                checkIfElementReferenceIsNeeded(element2, str, typeSystemHolder, inst2XsdOptions);
                type.addElement(element2);
                map.put(element2.getName(), element2);
            } else if (element.getName() != null && element.getName().equals(element2.getName())) {
                combineTypes(element.getType(), element2.getType(), inst2XsdOptions);
                combineElementComments(element, element2);
                element.setMinOccurs(0);
                element.setMaxOccurs(-1);
            } else if (((Element) map.get(element2.getName())) == null) {
                checkIfElementReferenceIsNeeded(element2, str, typeSystemHolder, inst2XsdOptions);
                type.addElement(element2);
                map.put(element2.getName(), element2);
            } else {
                combineTypes(element.getType(), element2.getType(), inst2XsdOptions);
                combineElementComments(element, element2);
                type.setTopParticleForComplexOrMixedContent(2);
            }
            element = element2;
        }
    }

    protected QName processSimpleContentType(String str, Inst2XsdOptions inst2XsdOptions, final XmlCursor xmlCursor) {
        if (inst2XsdOptions.getSimpleContentTypes() == 2) {
            return XmlString.type.getName();
        }
        if (inst2XsdOptions.getSimpleContentTypes() != 1) {
            throw new IllegalArgumentException("Unknown value for Inst2XsdOptions.getSimpleContentTypes() :" + inst2XsdOptions.getSimpleContentTypes());
        }
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                XsTypeConverter.lexByte(str);
                                return XmlByte.type.getName();
                            } catch (Exception unused) {
                                XsTypeConverter.lexShort(str);
                                return XmlShort.type.getName();
                            }
                        } catch (Exception unused2) {
                            XsTypeConverter.lexInteger(str);
                            return XmlInteger.type.getName();
                        }
                    } catch (Exception unused3) {
                        XsTypeConverter.lexInt(str);
                        return XmlInt.type.getName();
                    }
                } catch (Exception unused4) {
                    XsTypeConverter.lexFloat(str);
                    return XmlFloat.type.getName();
                }
            } catch (Exception unused5) {
                XsTypeConverter.lexLong(str);
                return XmlLong.type.getName();
            }
        } catch (Exception unused6) {
            SchemaType schemaType = XmlDate.type;
            JavaGDateHolderEx.validateLexical(str, schemaType, this._validationContext);
            if (this._validationContext.isValid()) {
                return schemaType.getName();
            }
            this._validationContext.resetToValid();
            SchemaType schemaType2 = XmlDateTime.type;
            JavaGDateHolderEx.validateLexical(str, schemaType2, this._validationContext);
            if (this._validationContext.isValid()) {
                return schemaType2.getName();
            }
            this._validationContext.resetToValid();
            SchemaType schemaType3 = XmlTime.type;
            JavaGDateHolderEx.validateLexical(str, schemaType3, this._validationContext);
            if (this._validationContext.isValid()) {
                return schemaType3.getName();
            }
            this._validationContext.resetToValid();
            SchemaType schemaType4 = XmlDuration.type;
            JavaGDurationHolderEx.validateLexical(str, schemaType4, this._validationContext);
            if (this._validationContext.isValid()) {
                return schemaType4.getName();
            }
            this._validationContext.resetToValid();
            if (str.startsWith("http://") || str.startsWith("www.")) {
                JavaUriHolder.validateLexical(str, this._validationContext);
                if (this._validationContext.isValid()) {
                    return XmlAnyURI.type.getName();
                }
                this._validationContext.resetToValid();
            }
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0 && iIndexOf == str.lastIndexOf(58) && iIndexOf + 1 < str.length()) {
                SCTValidationContext sCTValidationContext = this._validationContext;
                xmlCursor.getClass();
                JavaQNameHolder.validateLexical(str, sCTValidationContext, new PrefixResolver() { // from class: org.apache.xmlbeans.impl.inst2xsd.a
                    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
                    public final String getNamespaceForPrefix(String str2) {
                        return xmlCursor.namespaceForPrefix(str2);
                    }
                });
                if (this._validationContext.isValid()) {
                    return XmlQName.type.getName();
                }
                this._validationContext.resetToValid();
            }
            return XmlString.type.getName();
        }
    }
}
