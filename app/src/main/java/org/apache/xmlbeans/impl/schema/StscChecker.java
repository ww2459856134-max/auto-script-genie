package org.apache.xmlbeans.impl.schema;

import com.tencent.open.SocialConstants;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlNOTATION;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;

/* loaded from: classes.dex */
public class StscChecker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static boolean blockSetOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaLocalElement.blockRestriction() && !schemaLocalElement2.blockRestriction()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "restriction", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (schemaLocalElement.blockExtension() && !schemaLocalElement2.blockExtension()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "extension", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.blockSubstitution() || schemaLocalElement2.blockSubstitution()) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$DISALLOWED_SUBSTITUTIONS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), "substitution", printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
        return false;
    }

    public static void checkAll() throws Exception {
        StscState stscState = StscState.get();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stscState.documentTypes()));
        arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
        arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
        arrayList.addAll(Arrays.asList(stscState.globalTypes()));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SchemaType schemaType = (SchemaType) arrayList.get(i2);
            if (!stscState.noPvr() && !schemaType.isDocumentType()) {
                checkRestriction((SchemaTypeImpl) schemaType);
            }
            checkFields((SchemaTypeImpl) schemaType);
            arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
        }
        checkSubstitutionGroups(stscState.globalElements());
    }

    private static boolean checkAllDerivationsForRestriction(SchemaType schemaType, SchemaType schemaType2, Collection<XmlError> collection, XmlObject xmlObject) {
        HashSet hashSet = schemaType.getSimpleVariety() == 2 ? new HashSet(Arrays.asList(schemaType.getUnionConstituentTypes())) : null;
        for (SchemaType baseType = schemaType2; !schemaType.equals(baseType) && hashSet != null && !hashSet.contains(baseType); baseType = baseType.getBaseType()) {
            if (baseType.getDerivationType() != 1) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_RESTRICTED, new Object[]{printType(schemaType2), printType(schemaType), printType(baseType)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    private static void checkElementDefaults(SchemaParticle schemaParticle, XmlObject xmlObject, SchemaType schemaType) throws Exception {
        String str;
        if (schemaParticle == null) {
            return;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1 || particleType == 2 || particleType == 3) {
            for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
                checkElementDefaults(schemaParticle2, xmlObject, schemaType);
            }
            return;
        }
        if (particleType != 4) {
            return;
        }
        String defaultText = schemaParticle.getDefaultText();
        if (defaultText != null) {
            if (schemaParticle.getType().isSimpleType() || schemaParticle.getType().getContentType() == 2) {
                try {
                    XmlAnySimpleType defaultValue = schemaParticle.getDefaultValue();
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setValidateTextOnly();
                    if (!defaultValue.validate(xmlOptions)) {
                        throw new Exception();
                    }
                    SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                        schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                    }
                } catch (Exception unused) {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                    StscState stscState = StscState.get();
                    Object[] objArr = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText, QNameHelper.pretty(schemaParticle.getType().getName())};
                    if (xmlObjectSelectAttribute == null) {
                        xmlObjectSelectAttribute = xmlObject;
                    }
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$CONSTRAINT_VALID, objArr, xmlObjectSelectAttribute);
                }
            } else if (schemaParticle.getType().getContentType() == 4) {
                if (schemaParticle.getType().getContentModel().isSkippable()) {
                    SchemaPropertyImpl schemaPropertyImpl2 = (SchemaPropertyImpl) schemaType.getElementProperty(schemaParticle.getName());
                    if (schemaPropertyImpl2 != null && schemaPropertyImpl2.getDefaultText() != null) {
                        schemaPropertyImpl2.setDefaultValue(new XmlValueRef(XmlString.type.newValue(defaultText)));
                    }
                } else {
                    str = schemaParticle.isFixed() ? "fixed" : "default";
                    XmlObject xmlObjectSelectAttribute2 = xmlObject.selectAttribute("", str);
                    StscState stscState2 = StscState.get();
                    Object[] objArr2 = {QNameHelper.pretty(schemaParticle.getName()), str, defaultText};
                    if (xmlObjectSelectAttribute2 == null) {
                        xmlObjectSelectAttribute2 = xmlObject;
                    }
                    stscState2.error(XmlErrorCodes.ELEM_DEFAULT_VALID$MIXED_AND_EMPTIABLE, objArr2, xmlObjectSelectAttribute2);
                }
            } else if (schemaParticle.getType().getContentType() == 3) {
                XmlObject xmlObjectSelectAttribute3 = xmlObject.selectAttribute("", "default");
                StscState stscState3 = StscState.get();
                Object[] objArr3 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "element"};
                if (xmlObjectSelectAttribute3 == null) {
                    xmlObjectSelectAttribute3 = xmlObject;
                }
                stscState3.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr3, xmlObjectSelectAttribute3);
            } else if (schemaParticle.getType().getContentType() == 1) {
                XmlObject xmlObjectSelectAttribute4 = xmlObject.selectAttribute("", "default");
                StscState stscState4 = StscState.get();
                Object[] objArr4 = {QNameHelper.pretty(schemaParticle.getName()), defaultText, "empty"};
                if (xmlObjectSelectAttribute4 == null) {
                    xmlObjectSelectAttribute4 = xmlObject;
                }
                stscState4.error(XmlErrorCodes.ELEM_DEFAULT_VALID$SIMPLE_TYPE_OR_MIXED, objArr4, xmlObjectSelectAttribute4);
            }
        }
        String localPart = null;
        SchemaTypeImpl schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ID;
        if (schemaTypeImpl.isAssignableFrom(schemaParticle.getType())) {
            localPart = schemaTypeImpl.getName().getLocalPart();
        } else {
            SchemaTypeImpl schemaTypeImpl2 = BuiltinSchemaTypeSystem.ST_IDREF;
            if (schemaTypeImpl2.isAssignableFrom(schemaParticle.getType())) {
                localPart = schemaTypeImpl2.getName().getLocalPart();
            } else {
                SchemaTypeImpl schemaTypeImpl3 = BuiltinSchemaTypeSystem.ST_IDREFS;
                if (schemaTypeImpl3.isAssignableFrom(schemaParticle.getType())) {
                    localPart = schemaTypeImpl3.getName().getLocalPart();
                } else {
                    SchemaTypeImpl schemaTypeImpl4 = BuiltinSchemaTypeSystem.ST_ENTITY;
                    if (schemaTypeImpl4.isAssignableFrom(schemaParticle.getType())) {
                        localPart = schemaTypeImpl4.getName().getLocalPart();
                    } else {
                        SchemaTypeImpl schemaTypeImpl5 = BuiltinSchemaTypeSystem.ST_ENTITIES;
                        if (schemaTypeImpl5.isAssignableFrom(schemaParticle.getType())) {
                            localPart = schemaTypeImpl5.getName().getLocalPart();
                        } else if (BuiltinSchemaTypeSystem.ST_NOTATION.isAssignableFrom(schemaParticle.getType())) {
                            if (schemaParticle.getType().getBuiltinTypeCode() == 8) {
                                StscState stscState5 = StscState.get();
                                Object[] objArr5 = {QNameHelper.pretty(schemaParticle.getName())};
                                XmlObject xmlObject2 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                stscState5.recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, objArr5, xmlObject2 == null ? xmlObject : xmlObject2.selectAttribute("", SocialConstants.PARAM_TYPE));
                            } else {
                                if (schemaParticle.getType().getSimpleVariety() == 2) {
                                    for (SchemaType schemaType2 : schemaParticle.getType().getUnionConstituentTypes()) {
                                        if (schemaType2.getBuiltinTypeCode() == 8) {
                                            StscState stscState6 = StscState.get();
                                            Object[] objArr6 = {QNameHelper.pretty(schemaParticle.getName())};
                                            XmlObject xmlObject3 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                            stscState6.recover(XmlErrorCodes.ELEM_NOTATION_TYPE_FORBIDDEN, objArr6, xmlObject3 == null ? xmlObject : xmlObject3.selectAttribute("", SocialConstants.PARAM_TYPE));
                                        }
                                    }
                                }
                                localPart = BuiltinSchemaTypeSystem.ST_NOTATION.getName().getLocalPart();
                            }
                            while (schemaType.getOuterType() != null) {
                                schemaType = schemaType.getOuterType();
                            }
                            if (!schemaType.isDocumentType() ? schemaType.getName().getNamespaceURI().length() <= 0 : schemaType.getDocumentElementName().getNamespaceURI().length() <= 0) {
                                StscState stscState7 = StscState.get();
                                Object[] objArr7 = {QNameHelper.pretty(schemaParticle.getName())};
                                XmlObject xmlObject4 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
                                if (xmlObject4 == null) {
                                    xmlObject4 = xmlObject;
                                }
                                stscState7.warning(XmlErrorCodes.ELEM_COMPATIBILITY_TARGETNS, objArr7, xmlObject4);
                            }
                        }
                    }
                }
            }
        }
        if (localPart != null) {
            StscState stscState8 = StscState.get();
            Object[] objArr8 = {QNameHelper.pretty(schemaParticle.getName()), localPart};
            XmlObject xmlObject5 = ((SchemaLocalElementImpl) schemaParticle)._parseObject;
            if (xmlObject5 != null) {
                xmlObject = xmlObject5.selectAttribute("", SocialConstants.PARAM_TYPE);
            }
            stscState8.warning(XmlErrorCodes.ELEM_COMPATIBILITY_TYPE, objArr8, xmlObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkFields(SchemaTypeImpl schemaTypeImpl) throws Exception {
        int i2;
        boolean z;
        if (schemaTypeImpl.isSimpleType()) {
            return;
        }
        XmlObject parseObject = schemaTypeImpl.getParseObject();
        SchemaAttributeModel attributeModel = schemaTypeImpl.getAttributeModel();
        if (attributeModel != null) {
            SchemaLocalAttribute[] attributes = attributeModel.getAttributes();
            int length = attributes.length;
            Object[] objArr = null;
            int i3 = 0;
            QName name = null;
            int i4 = 0;
            while (i4 < length) {
                SchemaLocalAttribute schemaLocalAttribute = attributes[i4];
                XmlObject xmlObject = ((SchemaLocalAttributeImpl) schemaLocalAttribute)._parseObject;
                if (XmlID.type.isAssignableFrom(schemaLocalAttribute.getType())) {
                    if (name == null) {
                        name = schemaLocalAttribute.getName();
                    } else {
                        StscState stscState = StscState.get();
                        Object[] objArr2 = new Object[2];
                        objArr2[i3] = QNameHelper.pretty(name);
                        objArr2[1] = schemaLocalAttribute.getName();
                        stscState.error(XmlErrorCodes.ATTR_GROUP_PROPERTIES$TWO_IDS, objArr2, xmlObject != null ? xmlObject : parseObject);
                    }
                    if (schemaLocalAttribute.getDefaultText() != null) {
                        StscState stscState2 = StscState.get();
                        if (xmlObject == null) {
                            xmlObject = parseObject;
                        }
                        stscState2.error(XmlErrorCodes.ATTR_PROPERTIES$ID_FIXED_OR_DEFAULT, objArr, xmlObject);
                    }
                } else {
                    if (XmlNOTATION.type.isAssignableFrom(schemaLocalAttribute.getType())) {
                        int i5 = 8;
                        if (schemaLocalAttribute.getType().getBuiltinTypeCode() == 8) {
                            StscState stscState3 = StscState.get();
                            Object[] objArr3 = new Object[1];
                            objArr3[i3] = QNameHelper.pretty(schemaLocalAttribute.getName());
                            if (xmlObject == null) {
                                xmlObject = parseObject;
                            }
                            stscState3.recover(XmlErrorCodes.ATTR_NOTATION_TYPE_FORBIDDEN, objArr3, xmlObject);
                        } else {
                            if (schemaLocalAttribute.getType().getSimpleVariety() == 2) {
                                SchemaType[] unionConstituentTypes = schemaLocalAttribute.getType().getUnionConstituentTypes();
                                int length2 = unionConstituentTypes.length;
                                int i6 = i3;
                                while (i6 < length2) {
                                    if (unionConstituentTypes[i6].getBuiltinTypeCode() == i5) {
                                        StscState stscState4 = StscState.get();
                                        Object[] objArr4 = new Object[1];
                                        objArr4[i3] = QNameHelper.pretty(schemaLocalAttribute.getName());
                                        stscState4.recover(XmlErrorCodes.ATTR_NOTATION_TYPE_FORBIDDEN, objArr4, xmlObject != null ? xmlObject : parseObject);
                                    }
                                    i6++;
                                    i3 = 0;
                                    i5 = 8;
                                }
                            }
                            if (schemaTypeImpl.isAttributeType()) {
                                z = schemaLocalAttribute.getName().getNamespaceURI().length() > 0;
                            } else {
                                SchemaType outerType = schemaTypeImpl;
                                while (outerType.getOuterType() != null) {
                                    outerType = outerType.getOuterType();
                                }
                                if (!outerType.isDocumentType() ? outerType.getName().getNamespaceURI().length() <= 0 : outerType.getDocumentElementName().getNamespaceURI().length() <= 0) {
                                }
                            }
                            if (z) {
                                StscState stscState5 = StscState.get();
                                Object[] objArr5 = {QNameHelper.pretty(schemaLocalAttribute.getName())};
                                if (xmlObject == null) {
                                    xmlObject = parseObject;
                                }
                                stscState5.warning(XmlErrorCodes.ATTR_COMPATIBILITY_TARGETNS, objArr5, xmlObject);
                            }
                        }
                    } else {
                        String defaultText = schemaLocalAttribute.getDefaultText();
                        if (defaultText != null) {
                            try {
                                XmlAnySimpleType defaultValue = schemaLocalAttribute.getDefaultValue();
                                if (!defaultValue.validate()) {
                                    throw new Exception();
                                }
                                SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl) schemaTypeImpl.getAttributeProperty(schemaLocalAttribute.getName());
                                if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null) {
                                    schemaPropertyImpl.setDefaultValue(new XmlValueRef(defaultValue));
                                }
                            } catch (Exception unused) {
                                String str = schemaLocalAttribute.isFixed() ? "fixed" : "default";
                                if (xmlObject != null) {
                                    XmlObject xmlObjectSelectAttribute = xmlObject.selectAttribute("", str);
                                    if (xmlObjectSelectAttribute != null) {
                                        xmlObject = xmlObjectSelectAttribute;
                                    }
                                } else {
                                    xmlObject = parseObject;
                                }
                                i2 = 0;
                                StscState.get().error(XmlErrorCodes.ATTR_PROPERTIES$CONSTRAINT_VALID, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName()), str, defaultText, QNameHelper.pretty(schemaLocalAttribute.getType().getName())}, xmlObject);
                            }
                        }
                        i4++;
                        i3 = i2;
                        objArr = null;
                    }
                    i2 = 0;
                    i4++;
                    i3 = i2;
                    objArr = null;
                }
                i2 = i3;
                i4++;
                i3 = i2;
                objArr = null;
            }
        }
        checkElementDefaults(schemaTypeImpl.getContentModel(), parseObject, schemaTypeImpl);
    }

    private static boolean checkFixed(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (!schemaLocalElement.isFixed() || schemaLocalElement.getDefaultText().equals(schemaLocalElement2.getDefaultText())) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$FIXED, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), schemaLocalElement2.getDefaultText(), printParticle((SchemaParticle) schemaLocalElement), schemaLocalElement.getDefaultText()}, xmlObject));
        return false;
    }

    private static boolean checkForIdentityConstraintExistence(SchemaIdentityConstraint[] schemaIdentityConstraintArr, SchemaIdentityConstraint schemaIdentityConstraint) {
        for (SchemaIdentityConstraint schemaIdentityConstraint2 : schemaIdentityConstraintArr) {
            if (schemaIdentityConstraint2.getName().equals(schemaIdentityConstraint.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean checkGroupOccurrenceOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        BigInteger effectiveMaxRangeAllSeq;
        boolean z;
        BigInteger effectiveMinRangeAllSeq = BigInteger.ZERO;
        int particleType = schemaParticle2.getParticleType();
        if (particleType == 1) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
        } else if (particleType == 2) {
            effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
            effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
        } else if (particleType != 3) {
            effectiveMaxRangeAllSeq = effectiveMinRangeAllSeq;
        }
        if (effectiveMinRangeAllSeq.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MIN_GTE_MIN, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            z = false;
        } else {
            z = true;
        }
        if (schemaParticle.getMaxOccurs() != null) {
            if (effectiveMaxRangeAllSeq == null) {
                collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
            if (effectiveMaxRangeAllSeq.compareTo(schemaParticle.getMaxOccurs()) > 0) {
                collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
                return false;
            }
        }
        return z;
    }

    private static boolean checkIdentityConstraints(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaIdentityConstraint[] identityConstraints = schemaLocalElement.getIdentityConstraints();
        for (SchemaIdentityConstraint schemaIdentityConstraint : schemaLocalElement2.getIdentityConstraints()) {
            if (checkForIdentityConstraintExistence(identityConstraints, schemaIdentityConstraint)) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$IDENTITY_CONSTRAINTS, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle((SchemaParticle) schemaLocalElement)}, xmlObject));
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkRestriction(SchemaTypeImpl schemaTypeImpl) {
        if (schemaTypeImpl.getDerivationType() == 1 && !schemaTypeImpl.isSimpleType()) {
            StscState stscState = StscState.get();
            XmlObject parseObject = schemaTypeImpl.getParseObject();
            SchemaType baseType = schemaTypeImpl.getBaseType();
            if (baseType.isSimpleType()) {
                stscState.error(XmlErrorCodes.SCHEMA_COMPLEX_TYPE$COMPLEX_CONTENT, new Object[]{QNameHelper.pretty(baseType.getName())}, parseObject);
                return false;
            }
            int contentType = schemaTypeImpl.getContentType();
            if (contentType == 1) {
                int contentType2 = baseType.getContentType();
                if (contentType2 != 1) {
                    if (contentType2 != 3 && contentType2 != 4) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_NOT_SIMPLE, (Object[]) null, parseObject);
                        return false;
                    }
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$EMPTY_AND_ELEMENT_OR_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 2) {
                int contentType3 = baseType.getContentType();
                if (contentType3 == 2) {
                    SchemaType contentBasedOnType = schemaTypeImpl.getContentBasedOnType();
                    if (contentBasedOnType != baseType) {
                        while (baseType != null && !baseType.isSimpleType()) {
                            baseType = baseType.getContentBasedOnType();
                        }
                        if (baseType != null && !baseType.isAssignableFrom(contentBasedOnType)) {
                            stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_NOT_DERIVED, (Object[]) null, parseObject);
                            return false;
                        }
                    }
                } else {
                    if (contentType3 != 4) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_SIMPLE_TYPE_OR_MIXED, (Object[]) null, parseObject);
                        return false;
                    }
                    if (baseType.getContentModel() != null && !baseType.getContentModel().isSkippable()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$SC_AND_MIXED_EMPTIABLE, (Object[]) null, parseObject);
                        return false;
                    }
                }
            } else if (contentType == 3) {
                if (baseType.getContentType() != 1) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_EMPTY, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() == 2) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_SIMPLE, (Object[]) null, parseObject);
                    return false;
                }
                SchemaParticle contentModel = baseType.getContentModel();
                SchemaParticle contentModel2 = schemaTypeImpl.getContentModel();
                if (contentModel2 == null && schemaTypeImpl.getDerivationType() == 1) {
                    return true;
                }
                if (contentModel == null || contentModel2 == null) {
                    XBeanDebug.LOG.atTrace().withThrowable(new Exception("Stacktrace")).log("Null models that weren't caught by EMPTY_CONTENT: {} ({}), {} ({})", baseType, contentModel, schemaTypeImpl, contentModel2);
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                if (!isParticleValidRestriction(contentModel, contentModel2, arrayList, parseObject)) {
                    if (arrayList.isEmpty()) {
                        stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_VALID, (Object[]) null, parseObject);
                    } else {
                        stscState.getErrorListener().add(arrayList.get(arrayList.size() - 1));
                    }
                    return false;
                }
            } else if (contentType == 4) {
                if (baseType.getContentType() != 4) {
                    stscState.error(XmlErrorCodes.COMPLEX_TYPE_RESTRICTION$ELEMENT_OR_MIXED_AND_MIXED, (Object[]) null, parseObject);
                    return false;
                }
                if (baseType.getContentType() != 1) {
                }
            }
        }
        return true;
    }

    private static void checkSubstitutionGroups(SchemaGlobalElement[] schemaGlobalElementArr) {
        StscState stscState = StscState.get();
        for (SchemaGlobalElement schemaGlobalElement : schemaGlobalElementArr) {
            SchemaGlobalElement schemaGlobalElementSubstitutionGroup = schemaGlobalElement.substitutionGroup();
            if (schemaGlobalElementSubstitutionGroup != null) {
                SchemaType type = schemaGlobalElementSubstitutionGroup.getType();
                SchemaType type2 = schemaGlobalElement.getType();
                XmlObject xmlObject = ((SchemaGlobalElementImpl) schemaGlobalElement)._parseObject;
                if (!type.isAssignableFrom(type2)) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_VALID, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName())}, xmlObject);
                } else if (schemaGlobalElementSubstitutionGroup.finalExtension() && schemaGlobalElementSubstitutionGroup.finalRestriction()) {
                    stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "#all"}, xmlObject);
                } else if (!type.equals(type2)) {
                    if (schemaGlobalElementSubstitutionGroup.finalExtension() && type2.getDerivationType() == 2) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "extension"}, xmlObject);
                    } else if (schemaGlobalElementSubstitutionGroup.finalRestriction() && type2.getDerivationType() == 1) {
                        stscState.error(XmlErrorCodes.ELEM_PROPERTIES$SUBSTITUTION_FINAL, new Object[]{QNameHelper.pretty(schemaGlobalElement.getName()), QNameHelper.pretty(schemaGlobalElementSubstitutionGroup.getName()), "restriction"}, xmlObject);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[PHI: r0
      0x0056: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:30:0x0054, B:25:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a A[LOOP:0: B:3:0x000c->B:34:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005d A[EDGE_INSN: B:44:0x005d->B:35:0x005d BREAK  A[LOOP:0: B:3:0x000c->B:34:0x005a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BigInteger getEffectiveMaxRangeAllSeq(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger bigIntegerAdd = effectiveMaxRangeAllSeq;
        boolean z = false;
        BigInteger bigInteger = bigIntegerAdd;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
                if (effectiveMaxRangeAllSeq != null) {
                    break;
                }
            } else {
                if (particleType == 2) {
                    effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                    if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    }
                } else if (particleType != 3) {
                    if (particleType == 4 || particleType == 5) {
                        if (schemaParticle2.getMaxOccurs() == null) {
                            effectiveMaxRangeAllSeq = null;
                        } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                            bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMaxOccurs());
                            z = true;
                        }
                    }
                }
                if (effectiveMaxRangeAllSeq != null) {
                }
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(bigIntegerAdd.add(bigInteger));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c A[PHI: r0
      0x005c: PHI (r0v6 java.math.BigInteger) = (r0v5 java.math.BigInteger), (r0v8 java.math.BigInteger) binds: [B:33:0x005a, B:28:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060 A[LOOP:0: B:3:0x000c->B:37:0x0060, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0063 A[EDGE_INSN: B:47:0x0063->B:38:0x0063 BREAK  A[LOOP:0: B:3:0x000c->B:37:0x0060], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BigInteger getEffectiveMaxRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMaxRangeAllSeq = BigInteger.ZERO;
        BigInteger maxOccurs = effectiveMaxRangeAllSeq;
        boolean z = false;
        BigInteger bigInteger = maxOccurs;
        for (SchemaParticle schemaParticle2 : schemaParticle.getParticleChildren()) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMaxRangeAllSeq = getEffectiveMaxRangeAllSeq(schemaParticle2);
                if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    bigInteger = effectiveMaxRangeAllSeq;
                }
                if (effectiveMaxRangeAllSeq != null) {
                    break;
                }
            } else {
                if (particleType == 2) {
                    effectiveMaxRangeAllSeq = getEffectiveMaxRangeChoice(schemaParticle2);
                    if (effectiveMaxRangeAllSeq != null && effectiveMaxRangeAllSeq.compareTo(bigInteger) > 0) {
                    }
                } else if (particleType != 3) {
                    if (particleType == 4 || particleType == 5) {
                        if (schemaParticle2.getMaxOccurs() == null) {
                            effectiveMaxRangeAllSeq = null;
                        } else if (schemaParticle2.getIntMaxOccurs() > 0) {
                            if (schemaParticle2.getMaxOccurs().compareTo(maxOccurs) > 0) {
                                maxOccurs = schemaParticle2.getMaxOccurs();
                            }
                            z = true;
                        }
                    }
                }
                if (effectiveMaxRangeAllSeq != null) {
                }
            }
        }
        if (effectiveMaxRangeAllSeq == null) {
            return effectiveMaxRangeAllSeq;
        }
        if (z && schemaParticle.getMaxOccurs() == null) {
            return null;
        }
        return schemaParticle.getMaxOccurs().multiply(maxOccurs.add(bigInteger));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BigInteger getEffectiveMinRangeAllSeq(SchemaParticle schemaParticle) {
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeAllSeq(schemaParticle2));
            } else if (particleType == 2) {
                bigIntegerAdd = bigIntegerAdd.add(getEffectiveMinRangeChoice(schemaParticle2));
            } else if (particleType != 3) {
                if (particleType == 4 || particleType == 5) {
                    bigIntegerAdd = bigIntegerAdd.add(schemaParticle2.getMinOccurs());
                }
            }
        }
        return schemaParticle.getMinOccurs().multiply(bigIntegerAdd);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f A[PHI: r4
      0x004f: PHI (r4v2 java.math.BigInteger) = (r4v1 java.math.BigInteger), (r4v1 java.math.BigInteger), (r4v3 java.math.BigInteger), (r4v3 java.math.BigInteger) binds: [B:29:0x0047, B:31:0x004d, B:24:0x003a, B:26:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static BigInteger getEffectiveMinRangeChoice(SchemaParticle schemaParticle) {
        BigInteger effectiveMinRangeAllSeq;
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        if (particleChildren.length == 0) {
            return BigInteger.ZERO;
        }
        BigInteger minOccurs = null;
        for (SchemaParticle schemaParticle2 : particleChildren) {
            int particleType = schemaParticle2.getParticleType();
            if (particleType == 1) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeAllSeq(schemaParticle2);
                if (minOccurs == null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                    minOccurs = effectiveMinRangeAllSeq;
                }
            } else if (particleType == 2) {
                effectiveMinRangeAllSeq = getEffectiveMinRangeChoice(schemaParticle2);
                if (minOccurs == null || minOccurs.compareTo(effectiveMinRangeAllSeq) > 0) {
                }
            } else if (particleType != 3) {
                if ((particleType == 4 || particleType == 5) && (minOccurs == null || minOccurs.compareTo(schemaParticle2.getMinOccurs()) > 0)) {
                    minOccurs = schemaParticle2.getMinOccurs();
                }
            }
        }
        if (minOccurs == null) {
            minOccurs = BigInteger.ZERO;
        }
        return schemaParticle.getMinOccurs().multiply(minOccurs);
    }

    public static boolean isParticleValidRestriction(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle.equals(schemaParticle2)) {
            return true;
        }
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            int particleType2 = schemaParticle2.getParticleType();
            if (particleType2 == 1) {
                return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
            }
            if (particleType2 != 2) {
                if (particleType2 == 3) {
                    return recurseUnordered(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType2 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 2) {
            int particleType3 = schemaParticle2.getParticleType();
            if (particleType3 != 1) {
                if (particleType3 == 2) {
                    return recurseLax(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 3) {
                    return mapAndSum(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType3 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 3) {
            int particleType4 = schemaParticle2.getParticleType();
            if (particleType4 != 1 && particleType4 != 2) {
                if (particleType4 == 3) {
                    return recurse(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 == 4) {
                    return recurseAsIfGroup(schemaParticle, schemaParticle2, collection, xmlObject);
                }
                if (particleType4 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType == 4) {
            int particleType5 = schemaParticle2.getParticleType();
            if (particleType5 != 1 && particleType5 != 2 && particleType5 != 3) {
                if (particleType5 == 4) {
                    return nameAndTypeOK((SchemaLocalElement) schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
                }
                if (particleType5 != 5) {
                    XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
                    return false;
                }
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION$INVALID_RESTRICTION, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (particleType != 5) {
            XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Base Type");
            return false;
        }
        int particleType6 = schemaParticle2.getParticleType();
        if (particleType6 == 1 || particleType6 == 2 || particleType6 == 3) {
            return nsRecurseCheckCardinality(schemaParticle, schemaParticle2, collection, xmlObject);
        }
        if (particleType6 == 4) {
            return nsCompat(schemaParticle, (SchemaLocalElement) schemaParticle2, collection, xmlObject);
        }
        if (particleType6 == 5) {
            return nsSubset(schemaParticle, schemaParticle2, collection, xmlObject);
        }
        XBeanDebug.LOG.atDebug().withThrowable(new Exception("stacktrace")).log("Unknown schema type for Derived Type");
        return false;
    }

    private static boolean mapAndSum(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        boolean z;
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            int length = particleChildren2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                if (isParticleValidRestriction(particleChildren2[i2], schemaParticle3, collection, xmlObject)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$MAP, new Object[]{printParticle(schemaParticle3)}, xmlObject));
                return false;
            }
        }
        BigInteger bigIntegerMultiply = schemaParticle2.getMinOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        BigInteger bigIntegerMultiply2 = schemaParticle2.getMaxOccurs() == null ? null : schemaParticle2.getMaxOccurs().multiply(BigInteger.valueOf(schemaParticle2.getParticleChildren().length));
        if (bigIntegerMultiply.compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MIN_OCCURS_GTE_MIN_OCCURS, new Object[]{bigIntegerMultiply.toString(), schemaParticle.getMinOccurs().toString()}, xmlObject));
            return false;
        }
        if (schemaParticle.getMaxOccurs() == null || (bigIntegerMultiply2 != null && bigIntegerMultiply2.compareTo(schemaParticle.getMaxOccurs()) <= 0)) {
            return true;
        }
        Object[] objArr = new Object[2];
        objArr[0] = bigIntegerMultiply2 == null ? "unbounded" : bigIntegerMultiply2.toString();
        objArr[1] = schemaParticle.getMaxOccurs().toString();
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_MAP_AND_SUM$SUM_MAX_OCCURS_LTE_MAX_OCCURS, objArr, xmlObject));
        return false;
    }

    private static boolean nameAndTypeOK(SchemaLocalElement schemaLocalElement, SchemaLocalElement schemaLocalElement2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticle schemaParticle = (SchemaParticle) schemaLocalElement;
        if (!schemaParticle.canStartWithElement(schemaLocalElement2.getName())) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NAME, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (!schemaLocalElement.isNillable() && schemaLocalElement2.isNillable()) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$NILLABLE, new Object[]{printParticle((SchemaParticle) schemaLocalElement2), printParticle(schemaParticle)}, xmlObject));
            return false;
        }
        if (occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement2, collection, xmlObject) && checkFixed(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && checkIdentityConstraints(schemaLocalElement, schemaLocalElement2, collection, xmlObject) && typeDerivationOK(schemaLocalElement.getType(), schemaLocalElement2.getType(), collection, xmlObject)) {
            return blockSetOK(schemaLocalElement, schemaLocalElement2, collection, xmlObject);
        }
        return false;
    }

    private static boolean nsCompat(SchemaParticle schemaParticle, SchemaLocalElement schemaLocalElement, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle.getWildcardSet().contains(schemaLocalElement.getName())) {
            return occurrenceRangeOK(schemaParticle, (SchemaParticle) schemaLocalElement, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_COMPAT$WILDCARD_VALID, new Object[]{printParticle((SchemaParticle) schemaLocalElement), printParticle(schemaParticle)}, xmlObject));
        return false;
    }

    private static boolean nsRecurseCheckCardinality(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        schemaParticleImpl.setWildcardProcess(schemaParticle.getWildcardProcess());
        schemaParticleImpl.setWildcardSet(schemaParticle.getWildcardSet());
        schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
        schemaParticleImpl.setMaxOccurs(null);
        schemaParticleImpl.setTransitionRules(schemaParticle.getWildcardSet(), true);
        schemaParticleImpl.setTransitionNotes(schemaParticle.getWildcardSet(), true);
        boolean zNsRecurseCheckCardinality = true;
        for (SchemaParticle schemaParticle3 : schemaParticle2.getParticleChildren()) {
            int particleType = schemaParticle3.getParticleType();
            if (particleType == 1 || particleType == 2 || particleType == 3) {
                zNsRecurseCheckCardinality = nsRecurseCheckCardinality(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            } else if (particleType == 4) {
                zNsRecurseCheckCardinality = nsCompat(schemaParticleImpl, (SchemaLocalElement) schemaParticle3, collection, xmlObject);
            } else if (particleType == 5) {
                zNsRecurseCheckCardinality = nsSubset(schemaParticleImpl, schemaParticle3, collection, xmlObject);
            }
            if (!zNsRecurseCheckCardinality) {
                break;
            }
        }
        return zNsRecurseCheckCardinality ? checkGroupOccurrenceOK(schemaParticle, schemaParticle2, collection, xmlObject) : zNsRecurseCheckCardinality;
    }

    private static boolean nsSubset(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            if (schemaParticle.getWildcardSet().inverse().isDisjoint(schemaParticle2.getWildcardSet())) {
                return true;
            }
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_NS_SUBST$WILDCARD_SUBSET, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle)}, xmlObject));
        }
        return false;
    }

    private static boolean occurrenceRangeOK(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaParticle2.getMinOccurs().compareTo(schemaParticle.getMinOccurs()) < 0) {
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MIN_GTE_MIN, new Object[]{printParticle(schemaParticle2), schemaParticle2.getMinOccurs().toString(), printParticle(schemaParticle), schemaParticle.getMinOccurs().toString()}, xmlObject));
        } else {
            if (schemaParticle.getMaxOccurs() == null) {
                return true;
            }
            if (schemaParticle2.getMaxOccurs() != null && schemaParticle.getMaxOccurs() != null && schemaParticle2.getMaxOccurs().compareTo(schemaParticle.getMaxOccurs()) <= 0) {
                return true;
            }
            collection.add(XmlError.forObject(XmlErrorCodes.OCCURRENCE_RANGE$MAX_LTE_MAX, new Object[]{printParticle(schemaParticle2), printMaxOccurs(schemaParticle2.getMaxOccurs()), printParticle(schemaParticle), printMaxOccurs(schemaParticle.getMaxOccurs())}, xmlObject));
        }
        return false;
    }

    private static String printMaxOccurs(BigInteger bigInteger) {
        return bigInteger == null ? "unbounded" : bigInteger.toString();
    }

    private static String printParticle(SchemaParticle schemaParticle) {
        int particleType = schemaParticle.getParticleType();
        if (particleType == 1) {
            return "<all>";
        }
        if (particleType == 2) {
            return "<choice>";
        }
        if (particleType == 3) {
            return "<sequence>";
        }
        if (particleType != 4) {
            return particleType != 5 ? "??" : "<any>";
        }
        return "<element name=\"" + QNameHelper.pretty(schemaParticle.getName()) + "\">";
    }

    private static String printParticles(List<SchemaParticle> list) {
        return printParticles((SchemaParticle[]) list.toArray(new SchemaParticle[0]));
    }

    private static String printType(SchemaType schemaType) {
        return schemaType.getName() != null ? QNameHelper.pretty(schemaType.getName()) : schemaType.toString();
    }

    private static boolean recurse(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        boolean z;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i2 = 0;
        int i3 = 0;
        while (i2 < particleChildren.length && i3 < particleChildren2.length) {
            SchemaParticle schemaParticle3 = particleChildren[i2];
            SchemaParticle schemaParticle4 = particleChildren2[i3];
            if (!isParticleValidRestriction(schemaParticle4, schemaParticle3, collection, xmlObject)) {
                if (!schemaParticle4.isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP_VALID, new Object[]{printParticle(schemaParticle3), printParticle(schemaParticle2), printParticle(schemaParticle4), printParticle(schemaParticle)}, xmlObject));
                    z = false;
                    break;
                }
            } else {
                i2++;
            }
            i3++;
        }
        z = true;
        if (i2 < particleChildren.length) {
            collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$MAP, new Object[]{printParticle(schemaParticle2), printParticle(schemaParticle), printParticles(particleChildren, i2)}, xmlObject));
            return false;
        }
        if (i3 < particleChildren2.length) {
            ArrayList arrayList = new ArrayList(particleChildren2.length);
            while (i3 < particleChildren2.length) {
                if (!particleChildren2[i3].isSkippable()) {
                    arrayList.add(particleChildren2[i3]);
                }
                i3++;
            }
            if (!arrayList.isEmpty()) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle(schemaParticle), printParticle(schemaParticle2), printParticles(arrayList)}, xmlObject));
                return false;
            }
        }
        return z;
    }

    private static boolean recurseAsIfGroup(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
        schemaParticleImpl.setParticleType(schemaParticle.getParticleType());
        BigInteger bigInteger = BigInteger.ONE;
        schemaParticleImpl.setMinOccurs(bigInteger);
        schemaParticleImpl.setMaxOccurs(bigInteger);
        schemaParticleImpl.setParticleChildren(new SchemaParticle[]{schemaParticle2});
        return isParticleValidRestriction(schemaParticle, schemaParticleImpl, collection, xmlObject);
    }

    private static boolean recurseLax(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle2.getParticleChildren();
        SchemaParticle[] particleChildren2 = schemaParticle.getParticleChildren();
        int i2 = 0;
        for (int i3 = 0; i2 < particleChildren.length && i3 < particleChildren2.length; i3++) {
            if (isParticleValidRestriction(particleChildren2[i3], particleChildren[i2], collection, xmlObject)) {
                i2++;
            }
        }
        if (i2 >= particleChildren.length) {
            return true;
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_LAX$MAP, new Object[]{printParticles(particleChildren2, i2)}, xmlObject));
        return false;
    }

    private static boolean recurseUnordered(SchemaParticle schemaParticle, SchemaParticle schemaParticle2, Collection<XmlError> collection, XmlObject xmlObject) {
        boolean z;
        if (!occurrenceRangeOK(schemaParticle, schemaParticle2, collection, xmlObject)) {
            return false;
        }
        SchemaParticle[] particleChildren = schemaParticle.getParticleChildren();
        HashMap map = new HashMap(10);
        Object obj = new Object();
        for (SchemaParticle schemaParticle3 : particleChildren) {
            map.put(schemaParticle3.getName(), schemaParticle3);
        }
        for (SchemaParticle schemaParticle4 : schemaParticle2.getParticleChildren()) {
            Object obj2 = map.get(schemaParticle4.getName());
            if (obj2 == null) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP, new Object[]{printParticle(schemaParticle4)}, xmlObject));
            } else if (obj2 == obj) {
                collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_UNIQUE, new Object[]{printParticle(schemaParticle4)}, xmlObject));
            } else {
                SchemaParticle schemaParticle5 = (SchemaParticle) obj2;
                if (schemaParticle4.getMaxOccurs() == null || schemaParticle4.getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$MAP_MAX_OCCURS_1, new Object[]{printParticle(schemaParticle4), printMaxOccurs(schemaParticle4.getMinOccurs())}, xmlObject));
                } else if (isParticleValidRestriction(schemaParticle5, schemaParticle4, collection, xmlObject)) {
                    map.put(schemaParticle4.getName(), obj);
                }
            }
            z = false;
        }
        z = true;
        if (z) {
            for (QName qName : map.keySet()) {
                if (map.get(qName) != obj && !((SchemaParticle) map.get(qName)).isSkippable()) {
                    collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_DERIVATION_RECURSE_UNORDERED$UNMAPPED_ARE_EMPTIABLE, new Object[]{printParticle((SchemaParticle) map.get(qName))}, xmlObject));
                    z = false;
                }
            }
        }
        return z;
    }

    private static boolean typeDerivationOK(SchemaType schemaType, SchemaType schemaType2, Collection<XmlError> collection, XmlObject xmlObject) {
        if (schemaType.isAssignableFrom(schemaType2)) {
            return checkAllDerivationsForRestriction(schemaType, schemaType2, collection, xmlObject);
        }
        collection.add(XmlError.forObject(XmlErrorCodes.PARTICLE_RESTRICTION_NAME_AND_TYPE$TYPE_VALID, new Object[]{printType(schemaType2), printType(schemaType)}, xmlObject));
        return false;
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr) {
        return printParticles(schemaParticleArr, 0, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i2) {
        return printParticles(schemaParticleArr, i2, schemaParticleArr.length);
    }

    private static String printParticles(SchemaParticle[] schemaParticleArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(schemaParticleArr.length * 30);
        while (i2 < i3) {
            sb.append(printParticle(schemaParticleArr[i2]));
            i2++;
            if (i2 != i3) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
