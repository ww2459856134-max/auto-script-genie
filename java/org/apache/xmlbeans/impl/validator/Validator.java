package org.apache.xmlbeans.impl.validator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.IdentityConstraint;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.ExceptionUtil;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaBase64Holder;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.JavaBooleanHolder;
import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
import org.apache.xmlbeans.impl.values.JavaGDateHolderEx;
import org.apache.xmlbeans.impl.values.JavaGDurationHolderEx;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolder;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolder;
import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* loaded from: classes.dex */
public final class Validator implements ValidatorListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean _booleanValue;
    private byte[] _byteArrayValue;
    private final IdentityConstraint _constraintEngine;
    private BigDecimal _decimalValue;
    private double _doubleValue;
    private int _eatContent;
    private Collection<XmlError> _errorListener;
    private int _errorState;
    private float _floatValue;
    private GDate _gdateValue;
    private GDuration _gdurationValue;
    private final SchemaTypeLoader _globalTypes;
    private boolean _invalid;
    private List<SchemaType> _listTypes;
    private List<Object> _listValue;
    private SchemaLocalAttribute _localAttribute;
    private SchemaLocalElement _localElement;
    private QName _qnameValue;
    private final SchemaField _rootField;
    private final SchemaType _rootType;
    private State _stateStack;
    private final boolean _strict;
    private String _stringValue;
    private int _suspendErrors;
    private final boolean _treatLaxAsSkip;
    private SchemaType _unionType;
    private final ValidatorVC _vc;
    private final LinkedList<TypeStoreVisitor> _visitorPool = new LinkedList<>();
    private SchemaAttributeModel _wildcardAttribute;
    private SchemaParticle _wildcardElement;

    private static final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        SchemaAttributeModel _attrModel;
        HashSet<QName> _attrs;
        boolean _canHaveAttrs;
        boolean _canHaveElements;
        boolean _canHaveMixedContent;
        SchemaField _field;
        boolean _hasSimpleContent;
        boolean _isEmpty;
        boolean _isNil;
        State _next;
        boolean _sawText;
        SchemaType _type;
        SchemaTypeVisitorImpl _visitor;

        private State() {
        }

        SchemaParticle currentParticle() {
            return this._visitor.currentParticle();
        }

        boolean end() {
            return !this._canHaveElements || this._visitor.visit(null);
        }

        boolean test(QName qName) {
            return this._canHaveElements && this._visitor.testValid(qName);
        }

        boolean visit(QName qName) {
            return this._canHaveElements && this._visitor.visit(qName);
        }
    }

    private class ValidatorVC implements ValidationContext {
        ValidatorListener.Event _event;

        private ValidatorVC() {
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str) {
            Validator.this.emitError(this._event, str, null, null, XmlValidationError.ATTRIBUTE_TYPE_INVALID);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String str, Object[] objArr) {
            Validator.this.emitError(this._event, str, objArr, null, null, XmlValidationError.ATTRIBUTE_TYPE_INVALID, null);
        }
    }

    public Validator(SchemaType schemaType, SchemaField schemaField, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection<XmlError> collection) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        this._errorListener = xmlOptionsMaskNull.getErrorListener();
        this._treatLaxAsSkip = xmlOptionsMaskNull.isValidateTreatLaxAsSkip();
        this._strict = xmlOptionsMaskNull.isValidateStrict();
        if (this._errorListener == null) {
            this._errorListener = collection;
        }
        this._constraintEngine = new IdentityConstraint(this._errorListener, schemaType.isDocumentType());
        this._globalTypes = schemaTypeLoader;
        this._rootType = schemaType;
        this._rootField = schemaField;
        this._vc = new ValidatorVC();
    }

    private void addToList(SchemaType schemaType) {
        if (schemaType.getSimpleVariety() == 1 || schemaType.getSimpleVariety() == 2) {
            if (schemaType.getUnionMemberTypes().length > 0 && getUnionType() != null) {
                schemaType = getUnionType();
                this._unionType = null;
            }
            this._listTypes.add(schemaType);
            if (schemaType.getPrimitiveType() == null) {
                this._listValue.add(null);
                return;
            }
            switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
                case 2:
                case 6:
                    this._listValue.add(this._stringValue);
                    return;
                case 3:
                    this._listValue.add(this._booleanValue ? Boolean.TRUE : Boolean.FALSE);
                    this._booleanValue = false;
                    return;
                case 4:
                case 5:
                    this._listValue.add(this._byteArrayValue);
                    this._byteArrayValue = null;
                    return;
                case 7:
                case 8:
                    this._listValue.add(this._qnameValue);
                    this._qnameValue = null;
                    return;
                case 9:
                    this._listValue.add(Float.valueOf(this._floatValue));
                    this._floatValue = 0.0f;
                    return;
                case 10:
                    this._listValue.add(Double.valueOf(this._doubleValue));
                    this._doubleValue = 0.0d;
                    return;
                case 11:
                    this._listValue.add(this._decimalValue);
                    this._decimalValue = null;
                    return;
                case 12:
                    this._listValue.add(this._stringValue);
                    this._stringValue = null;
                    return;
                case 13:
                    this._listValue.add(this._gdurationValue);
                    this._gdurationValue = null;
                    return;
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    this._listValue.add(this._gdateValue);
                    this._gdateValue = null;
                    return;
                default:
                    throw new RuntimeException("Unexpected primitive type code");
            }
        }
    }

    private void attrEvent(ValidatorListener.Event event) {
        QName name = event.getName();
        State state = topState();
        if (state._attrs == null) {
            state._attrs = new HashSet<>();
        }
        if (state._attrs.contains(name)) {
            emitFieldError(event, XmlErrorCodes.XML_DUPLICATE_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
            return;
        }
        state._attrs.add(name);
        if (!state._canHaveAttrs) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
            return;
        }
        SchemaAttributeModel schemaAttributeModel = state._attrModel;
        SchemaLocalAttribute attribute = schemaAttributeModel == null ? null : schemaAttributeModel.getAttribute(name);
        if (attribute != null) {
            this._localAttribute = attribute;
            if (attribute.getUse() == 1) {
                emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$PROHIBITED_ATTRIBUTE, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
                return;
            } else {
                this._constraintEngine.attr(event, name, attribute.getType(), validateSimpleType(attribute.getType(), attribute, event, false, false));
                return;
            }
        }
        int wildcardProcess = state._attrModel.getWildcardProcess();
        SchemaAttributeModel schemaAttributeModel2 = state._attrModel;
        this._wildcardAttribute = schemaAttributeModel2;
        if (wildcardProcess == 0) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NO_WILDCARD, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
            return;
        }
        if (!schemaAttributeModel2.getWildcardSet().contains(name)) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$NOT_WILDCARD_VALID, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
            return;
        }
        if (wildcardProcess != 3) {
            if (wildcardProcess == 2 && this._treatLaxAsSkip) {
                return;
            }
            SchemaGlobalAttribute schemaGlobalAttributeFindAttribute = this._globalTypes.findAttribute(name);
            this._localAttribute = schemaGlobalAttributeFindAttribute;
            if (schemaGlobalAttributeFindAttribute != null) {
                this._constraintEngine.attr(event, name, schemaGlobalAttributeFindAttribute.getType(), validateSimpleType(schemaGlobalAttributeFindAttribute.getType(), schemaGlobalAttributeFindAttribute, event, false, false));
            } else {
                if (wildcardProcess == 2) {
                    return;
                }
                emitFieldError(event, XmlErrorCodes.ASSESS_ATTR_SCHEMA_VALID$NOT_RESOLVED, new Object[]{QNameHelper.pretty(name)}, name, null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void beginEvent(ValidatorListener.Event event) {
        int i2;
        SchemaField schemaField;
        SchemaType type;
        SchemaType schemaType;
        SchemaField schemaField2;
        SchemaType schemaType2;
        SchemaType schemaType3;
        SchemaField schemaField3;
        boolean zValidateLexical;
        SchemaField schemaField4;
        SchemaType schemaType4;
        boolean z;
        int i3;
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        int i4 = 0;
        if (state == null) {
            SchemaType schemaType5 = this._rootType;
            schemaField = this._rootField;
            type = schemaType5;
            i2 = 1;
        } else {
            QName name = event.getName();
            state._isEmpty = false;
            if (state._isNil) {
                QName name2 = state._field.getName();
                SchemaType schemaType6 = state._type;
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_CONTENT, null, name2, schemaType6, null, 4, schemaType6);
                this._eatContent = 1;
                return;
            }
            SchemaField schemaField5 = state._field;
            if (schemaField5 == null || !schemaField5.isFixed()) {
                i2 = 1;
            } else {
                Object[] objArr = {QNameHelper.pretty(state._field.getName())};
                QName name3 = state._field.getName();
                SchemaType schemaType7 = state._type;
                i2 = 1;
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_WITH_CONTENT, objArr, name3, schemaType7, null, 2, schemaType7);
            }
            if (!state.visit(name)) {
                findDetailedErrorBegin(event, state, name);
                this._eatContent = i2;
                return;
            }
            SchemaParticle schemaParticleCurrentParticle = state.currentParticle();
            this._wildcardElement = schemaParticleCurrentParticle;
            if (schemaParticleCurrentParticle.getParticleType() == 5) {
                if (!schemaParticleCurrentParticle.getWildcardSet().contains(name)) {
                    Object[] objArr2 = new Object[i2];
                    objArr2[0] = QNameHelper.pretty(name);
                    emitFieldError(event, XmlErrorCodes.PARTICLE_VALID$NOT_WILDCARD_VALID, objArr2, name, null, null, 2, state._type);
                    this._eatContent = i2;
                    return;
                }
                int wildcardProcess = schemaParticleCurrentParticle.getWildcardProcess();
                if (wildcardProcess == 3 || (wildcardProcess == 2 && this._treatLaxAsSkip)) {
                    this._eatContent = i2;
                    return;
                }
                SchemaGlobalElement schemaGlobalElementFindElement = this._globalTypes.findElement(name);
                this._localElement = schemaGlobalElementFindElement;
                if (schemaGlobalElementFindElement == null) {
                    if (wildcardProcess == i2) {
                        Object[] objArr3 = new Object[i2];
                        objArr3[0] = QNameHelper.pretty(name);
                        SchemaType schemaType8 = state._type;
                        emitFieldError(event, XmlErrorCodes.ASSESS_ELEM_SCHEMA_VALID$NOT_RESOLVED, objArr3, name, schemaType8, null, 2, schemaType8);
                    }
                    this._eatContent = i2;
                    return;
                }
                schemaField = schemaGlobalElementFindElement;
            } else if (schemaParticleCurrentParticle.getName().equals(name)) {
                schemaField = (SchemaField) schemaParticleCurrentParticle;
            } else {
                if (((SchemaLocalElement) schemaParticleCurrentParticle).blockSubstitution()) {
                    Object[] objArr4 = new Object[i2];
                    objArr4[0] = QNameHelper.pretty(name);
                    SchemaType schemaType9 = state._type;
                    emitFieldError(event, XmlErrorCodes.PARTICLE_VALID$BLOCK_SUBSTITUTION, objArr4, name, schemaType9, null, 2, schemaType9);
                    this._eatContent = i2;
                    return;
                }
                SchemaGlobalElement schemaGlobalElementFindElement2 = this._globalTypes.findElement(name);
                this._localElement = schemaGlobalElementFindElement2;
                schemaField = schemaGlobalElementFindElement2;
            }
            type = schemaField.getType();
        }
        SchemaField schemaField6 = schemaField;
        if (type.isNoType()) {
            schemaType = type;
            schemaField2 = schemaField6;
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NO_TYPE, null, event.getName(), null, null, 3, null);
            this._eatContent = i2;
        } else {
            schemaType = type;
            schemaField2 = schemaField6;
        }
        String xsiType = event.getXsiType();
        if (xsiType != null) {
            int i5 = this._errorState;
            this._suspendErrors += i2;
            try {
                ValidatorVC validatorVC = this._vc;
                schemaType2 = null;
                try {
                    validatorVC._event = null;
                    SchemaType schemaTypeFindType = this._globalTypes.findType(JavaQNameHolder.validateLexical(xsiType, validatorVC, event));
                    this._suspendErrors -= i2;
                    schemaType3 = schemaTypeFindType;
                } catch (Throwable th) {
                    th = th;
                    try {
                        if (ExceptionUtil.isFatal(th)) {
                            ExceptionUtil.rethrow(th);
                        }
                        this._errorState += i2;
                        this._suspendErrors -= i2;
                        schemaType3 = schemaType2;
                        if (i5 == this._errorState) {
                        }
                    } catch (Throwable th2) {
                        this._suspendErrors -= i2;
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                schemaType2 = null;
            }
            if (i5 == this._errorState) {
                Object[] objArr5 = new Object[i2];
                objArr5[0] = xsiType;
                QName name4 = event.getName();
                if (state != null) {
                    schemaType2 = state._type;
                }
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_INVALID_QNAME, objArr5, name4, schemaType3, null, 3, schemaType2);
                this._eatContent = i2;
                return;
            }
            if (schemaType3 == null) {
                Object[] objArr6 = new Object[i2];
                objArr6[0] = xsiType;
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_NOT_FOUND, objArr6, event.getName(), null, null, 3, null);
                this._eatContent = i2;
                return;
            }
        } else {
            schemaType2 = null;
            schemaType3 = null;
        }
        if (schemaType3 == null || schemaType3.equals(schemaType)) {
            schemaField3 = schemaField2;
        } else {
            if (!schemaType.isAssignableFrom(schemaType3)) {
                Object[] objArr7 = new Object[2];
                objArr7[0] = schemaType3;
                objArr7[i2] = schemaType;
                QName name5 = event.getName();
                if (state != null) {
                    schemaType2 = state._type;
                }
                emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_NOT_DERIVED, objArr7, name5, schemaType, null, 3, schemaType2);
                this._eatContent = i2;
                return;
            }
            if (schemaType.blockExtension()) {
                for (SchemaType baseType = schemaType3; !baseType.equals(schemaType); baseType = baseType.getBaseType()) {
                    if (baseType.getDerivationType() == 2) {
                        Object[] objArr8 = new Object[2];
                        objArr8[0] = schemaType3;
                        objArr8[i2] = schemaType;
                        QName name6 = event.getName();
                        if (state != null) {
                            schemaType2 = state._type;
                        }
                        emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_BLOCK_EXTENSION, objArr8, name6, schemaType, null, 3, schemaType2);
                        this._eatContent = i2;
                        return;
                    }
                }
            }
            if (schemaType.blockRestriction()) {
                for (SchemaType baseType2 = schemaType3; !baseType2.equals(schemaType); baseType2 = baseType2.getBaseType()) {
                    if (baseType2.getDerivationType() == i2) {
                        Object[] objArr9 = new Object[2];
                        objArr9[0] = schemaType3;
                        objArr9[i2] = schemaType;
                        QName name7 = event.getName();
                        if (state != null) {
                            schemaType2 = state._type;
                        }
                        emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_BLOCK_RESTRICTION, objArr9, name7, schemaType, null, 3, schemaType2);
                        this._eatContent = i2;
                        return;
                    }
                }
            }
            schemaField3 = schemaField2;
            if (schemaField3 instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField3;
                this._localElement = schemaLocalElement;
                if (schemaLocalElement.blockExtension() || schemaLocalElement.blockRestriction()) {
                    for (SchemaType baseType3 = schemaType3; !baseType3.equals(schemaType); baseType3 = baseType3.getBaseType()) {
                        if (baseType3.getDerivationType() == i2 && schemaLocalElement.blockRestriction()) {
                            i3 = 2;
                        } else {
                            i3 = 2;
                            if (baseType3.getDerivationType() != 2 || !schemaLocalElement.blockExtension()) {
                            }
                        }
                        Object[] objArr10 = new Object[i3];
                        objArr10[0] = schemaType3;
                        objArr10[i2] = QNameHelper.pretty(schemaLocalElement.getName());
                        emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$XSI_TYPE_PROHIBITED_SUBST, objArr10, schemaLocalElement.getName(), null, null, 3, null);
                        this._eatContent = i2;
                        return;
                    }
                }
            }
            schemaType = schemaType3;
        }
        boolean z2 = schemaField3 instanceof SchemaLocalElement;
        if (z2) {
            SchemaLocalElement schemaLocalElement2 = (SchemaLocalElement) schemaField3;
            this._localElement = schemaLocalElement2;
            if (schemaLocalElement2.isAbstract()) {
                Object[] objArr11 = new Object[i2];
                objArr11[0] = QNameHelper.pretty(schemaLocalElement2.getName());
                emitError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$ABSTRACT, objArr11, schemaLocalElement2.getName(), null, 3, null);
                this._eatContent = i2;
                return;
            }
        }
        if (schemaType.isAbstract()) {
            Object[] objArr12 = new Object[i2];
            objArr12[0] = schemaType;
            emitError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$ABSTRACT, objArr12, event.getName(), schemaType, 3, state == null ? schemaType2 : state._type);
            this._eatContent = i2;
            return;
        }
        String xsiNil = event.getXsiNil();
        if (xsiNil != null) {
            ValidatorVC validatorVC2 = this._vc;
            validatorVC2._event = event;
            zValidateLexical = JavaBooleanHolder.validateLexical(xsiNil, validatorVC2);
            i4 = i2;
        } else {
            zValidateLexical = false;
        }
        if (i4 != 0 && (schemaField3 == null || !schemaField3.isNillable())) {
            QName name8 = schemaField3 == null ? schemaType2 : schemaField3.getName();
            if (state != null) {
                schemaType2 = state._type;
            }
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NOT_NILLABLE, null, name8, schemaType, null, 3, schemaType2);
            this._eatContent = i2;
            return;
        }
        if (zValidateLexical && schemaField3 != null && schemaField3.isFixed()) {
            schemaField4 = schemaField3;
            schemaType4 = schemaType2;
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_FIXED, null, schemaField3.getName(), schemaType, null, 3, state == null ? schemaType2 : state._type);
            z = zValidateLexical;
        } else {
            schemaField4 = schemaField3;
            schemaType4 = schemaType2;
            z = zValidateLexical;
        }
        newState(schemaType, schemaField4, z);
        this._constraintEngine.element(event, schemaType, z2 ? ((SchemaLocalElement) schemaField4).getIdentityConstraints() : schemaType4);
    }

    private boolean derivedFromInteger(SchemaType schemaType) {
        int builtinTypeCode = schemaType.getBuiltinTypeCode();
        while (builtinTypeCode == 0) {
            schemaType = schemaType.getBaseType();
            builtinTypeCode = schemaType.getBuiltinTypeCode();
        }
        return builtinTypeCode >= 22 && builtinTypeCode <= 34;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, QName qName, SchemaType schemaType, int i2) {
        emitError(event, str, null, null, 0, null, qName, schemaType, null, i2, null);
    }

    private void emitFieldError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, List<QName> list, int i2, SchemaType schemaType2) {
        SchemaField schemaField;
        State state = this._stateStack;
        emitError(event, null, str, objArr, 0, (state == null || (schemaField = state._field) == null) ? null : schemaField.getName(), qName, schemaType, list, i2, schemaType2);
    }

    private void endAttrsEvent(ValidatorListener.Event event) {
        State state = topState();
        SchemaAttributeModel schemaAttributeModel = state._attrModel;
        if (schemaAttributeModel != null) {
            for (SchemaLocalAttribute schemaLocalAttribute : schemaAttributeModel.getAttributes()) {
                HashSet<QName> hashSet = state._attrs;
                if (hashSet == null || !hashSet.contains(schemaLocalAttribute.getName())) {
                    if (schemaLocalAttribute.getUse() == 3) {
                        emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_REQUIRED_ATTRIBUTE, new Object[]{QNameHelper.pretty(schemaLocalAttribute.getName())}, schemaLocalAttribute.getName(), null, null, XmlValidationError.INCORRECT_ATTRIBUTE, state._type);
                    } else if (schemaLocalAttribute.isDefault() || schemaLocalAttribute.isFixed()) {
                        this._constraintEngine.attr(event, schemaLocalAttribute.getName(), schemaLocalAttribute.getType(), schemaLocalAttribute.getDefaultText());
                    }
                }
            }
        }
    }

    private void endEvent(ValidatorListener.Event event) {
        this._localElement = null;
        this._wildcardElement = null;
        State state = topState();
        if (!state._isNil) {
            if (!state.end()) {
                findDetailedErrorEnd(event, state);
            }
            if (state._isEmpty) {
                handleText(event, true, state._field);
            }
        }
        popState(event);
        this._constraintEngine.endElement(event);
    }

    private void findDetailedErrorBegin(ValidatorListener.Event event, State state, QName qName) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : state._type.getElementProperties()) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        ArrayList arrayList3 = arrayList.isEmpty() ? arrayList2 : arrayList;
        if (arrayList3.isEmpty()) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_NOT_ALLOWED, new Object[]{QNameHelper.pretty(qName)}, qName, null, null, 1, state._type);
        } else {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_DIFFERENT_ELEMENT, new Object[]{Integer.valueOf(arrayList3.size()), (String) arrayList3.stream().map(a.a).collect(Collectors.joining(" ")), QNameHelper.pretty(qName)}, qName, null, arrayList3, 1, state._type);
        }
    }

    private void findDetailedErrorEnd(ValidatorListener.Event event, State state) {
        SchemaProperty[] elementProperties = state._type.getElementProperties();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SchemaProperty schemaProperty : elementProperties) {
            if (state.test(schemaProperty.getName())) {
                if (BigInteger.ZERO.compareTo(schemaProperty.getMinOccurs()) == 0) {
                    arrayList2.add(schemaProperty.getName());
                } else {
                    arrayList.add(schemaProperty.getName());
                }
            }
        }
        ArrayList arrayList3 = arrayList.isEmpty() ? arrayList2 : arrayList;
        if (arrayList3.isEmpty()) {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EXPECTED_ELEMENT, null, null, null, null, 2, state._type);
        } else {
            emitFieldError(event, XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$MISSING_ELEMENT, new Object[]{Integer.valueOf(arrayList3.size()), (String) arrayList3.stream().map(a.a).collect(Collectors.joining(" "))}, null, null, arrayList3, 1, state._type);
        }
    }

    private void handleText(ValidatorListener.Event event, boolean z, SchemaField schemaField) {
        State state = topState();
        if (!state._sawText) {
            if (state._hasSimpleContent) {
                this._constraintEngine.text(event, state._type, validateSimpleType(state._type, schemaField, event, z, true), false);
            } else if (state._canHaveMixedContent) {
                SchemaType schemaType = XmlString.type;
                this._constraintEngine.text(event, schemaType, validateSimpleType(schemaType, schemaField, event, z, true), false);
            } else if (z) {
                this._constraintEngine.text(event, state._type, null, true);
            } else {
                this._constraintEngine.text(event, state._type, "", false);
            }
        }
        if (!z && !state._canHaveMixedContent && !event.textIsWhitespace() && !state._hasSimpleContent) {
            if (schemaField instanceof SchemaLocalElement) {
                SchemaLocalElement schemaLocalElement = (SchemaLocalElement) schemaField;
                emitError(event, state._type.getContentType() == 1 ? XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$EMPTY_WITH_CONTENT : XmlErrorCodes.ELEM_COMPLEX_TYPE_LOCALLY_VALID$ELEMENT_ONLY_WITH_TEXT, new Object[]{QNameHelper.pretty(schemaLocalElement.getName())}, schemaLocalElement.getName(), schemaField.getType(), 3, null);
            } else {
                emitError(event, "Can't have mixed content", event.getName(), state._type, 3);
            }
        }
        if (z) {
            return;
        }
        state._sawText = true;
    }

    private SchemaTypeVisitorImpl initVisitor(SchemaParticle schemaParticle) {
        if (this._visitorPool.isEmpty()) {
            return new SchemaTypeVisitorImpl(schemaParticle);
        }
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = (SchemaTypeVisitorImpl) this._visitorPool.removeLast();
        schemaTypeVisitorImpl.init(schemaParticle);
        return schemaTypeVisitorImpl;
    }

    private void newState(SchemaType schemaType, SchemaField schemaField, boolean z) {
        State state = new State();
        state._type = schemaType;
        state._field = schemaField;
        state._isEmpty = true;
        state._isNil = z;
        if (schemaType.isSimpleType()) {
            state._hasSimpleContent = true;
        } else {
            state._canHaveAttrs = true;
            state._attrModel = schemaType.getAttributeModel();
            int contentType = schemaType.getContentType();
            if (contentType != 1) {
                if (contentType != 2) {
                    if (contentType != 3) {
                        if (contentType != 4) {
                            throw new RuntimeException("Unexpected content type");
                        }
                        state._canHaveMixedContent = true;
                    }
                    SchemaParticle contentModel = schemaType.getContentModel();
                    boolean z2 = contentModel != null;
                    state._canHaveElements = z2;
                    if (z2) {
                        state._visitor = initVisitor(contentModel);
                    }
                } else {
                    state._hasSimpleContent = true;
                }
            }
        }
        pushState(state);
    }

    private void poolVisitor(SchemaTypeVisitorImpl schemaTypeVisitorImpl) {
        this._visitorPool.add(schemaTypeVisitorImpl);
    }

    private void popState(ValidatorListener.Event event) {
        SchemaTypeVisitorImpl schemaTypeVisitorImpl = this._stateStack._visitor;
        if (schemaTypeVisitorImpl != null) {
            poolVisitor(schemaTypeVisitorImpl);
            this._stateStack._visitor = null;
        }
        this._stateStack = this._stateStack._next;
    }

    private void pushState(State state) {
        state._next = this._stateStack;
        this._stateStack = state;
    }

    private void resetValues() {
        this._localAttribute = null;
        this._wildcardAttribute = null;
        this._stringValue = null;
        this._decimalValue = null;
        this._booleanValue = false;
        this._floatValue = 0.0f;
        this._doubleValue = 0.0d;
        this._qnameValue = null;
        this._gdateValue = null;
        this._gdurationValue = null;
        this._byteArrayValue = null;
        this._listValue = null;
        this._listTypes = null;
        this._unionType = null;
    }

    private void textEvent(ValidatorListener.Event event) {
        State state = topState();
        if (state._isNil) {
            QName name = state._field.getName();
            SchemaType schemaType = state._type;
            emitFieldError(event, XmlErrorCodes.ELEM_LOCALLY_VALID$NIL_WITH_CONTENT, null, name, schemaType, null, 4, schemaType);
        } else {
            handleText(event, false, state._field);
        }
        state._isEmpty = false;
    }

    private State topState() {
        return this._stateStack;
    }

    private void validateAtomicType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int i2 = this._errorState;
        this._vc._event = event;
        switch (schemaType.getPrimitiveType().getBuiltinTypeCode()) {
            case 2:
                this._stringValue = str;
                return;
            case 3:
                this._booleanValue = JavaBooleanHolderEx.validateLexical(str, schemaType, this._vc);
                return;
            case 4:
                byte[] bArrValidateLexical = JavaBase64Holder.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical != null) {
                    JavaBase64HolderEx.validateValue(bArrValidateLexical, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical;
                return;
            case 5:
                byte[] bArrValidateLexical2 = JavaHexBinaryHolder.validateLexical(str, schemaType, this._vc);
                if (bArrValidateLexical2 != null) {
                    JavaHexBinaryHolderEx.validateValue(bArrValidateLexical2, schemaType, this._vc);
                }
                this._byteArrayValue = bArrValidateLexical2;
                return;
            case 6:
                JavaUriHolderEx.validateLexical(str, schemaType, this._vc);
                if (this._strict) {
                    try {
                        XsTypeConverter.lexAnyURI(str);
                    } catch (InvalidLexicalValueException unused) {
                        this._vc.invalid(XmlErrorCodes.ANYURI, new Object[]{str});
                    }
                }
                this._stringValue = str;
                return;
            case 7:
                QName qNameValidateLexical = JavaQNameHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i2 == this._errorState) {
                    JavaQNameHolderEx.validateValue(qNameValidateLexical, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical;
                return;
            case 8:
                QName qNameValidateLexical2 = JavaNotationHolderEx.validateLexical(str, schemaType, this._vc, event);
                if (i2 == this._errorState) {
                    JavaNotationHolderEx.validateValue(qNameValidateLexical2, schemaType, this._vc);
                }
                this._qnameValue = qNameValidateLexical2;
                return;
            case 9:
                float fValidateLexical = JavaFloatHolderEx.validateLexical(str, schemaType, this._vc);
                if (i2 == this._errorState) {
                    JavaFloatHolderEx.validateValue(fValidateLexical, schemaType, this._vc);
                }
                this._floatValue = fValidateLexical;
                return;
            case 10:
                double dValidateLexical = JavaDoubleHolderEx.validateLexical(str, schemaType, this._vc);
                if (i2 == this._errorState) {
                    JavaDoubleHolderEx.validateValue(dValidateLexical, schemaType, this._vc);
                }
                this._doubleValue = dValidateLexical;
                return;
            case 11:
                JavaDecimalHolderEx.validateLexical(str, schemaType, this._vc);
                if (derivedFromInteger(schemaType) && str.lastIndexOf(46) >= 0) {
                    this._vc.invalid(XmlErrorCodes.INTEGER, new Object[]{str});
                }
                if (i2 == this._errorState) {
                    BigDecimal bigDecimal = new BigDecimal(str);
                    this._decimalValue = bigDecimal;
                    JavaDecimalHolderEx.validateValue(bigDecimal, schemaType, this._vc);
                    return;
                }
                return;
            case 12:
                JavaStringEnumerationHolderEx.validateLexical(str, schemaType, this._vc);
                this._stringValue = str;
                return;
            case 13:
                GDuration gDurationValidateLexical = JavaGDurationHolderEx.validateLexical(str, schemaType, this._vc);
                if (gDurationValidateLexical != null) {
                    JavaGDurationHolderEx.validateValue(gDurationValidateLexical, schemaType, this._vc);
                }
                this._gdurationValue = gDurationValidateLexical;
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                break;
            case 21:
                if (this._strict && str.length() == 6 && str.charAt(4) == '-' && str.charAt(5) == '-') {
                    this._vc.invalid(XmlErrorCodes.DATE, new Object[]{str});
                    break;
                }
                break;
            default:
                throw new RuntimeException("Unexpected primitive type code");
        }
        GDate gDateValidateLexical = JavaGDateHolderEx.validateLexical(str, schemaType, this._vc);
        if (gDateValidateLexical != null) {
            JavaGDateHolderEx.validateValue(gDateValidateLexical, schemaType, this._vc);
        }
        this._gdateValue = gDateValidateLexical;
    }

    private void validateListType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        int i2;
        int i3;
        String[] strArr;
        int intValue;
        int intValue2;
        int intValue3;
        int i4 = this._errorState;
        if (schemaType.matchPatternFacet(str)) {
            i2 = 0;
            i3 = 1;
        } else {
            i2 = 0;
            i3 = 1;
            emitError(event, XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.LIST, str, QNameHelper.readable(schemaType)}, null, schemaType, XmlValidationError.LIST_INVALID, null);
        }
        String[] strArrSplit_list = XmlListImpl.split_list(str);
        XmlAnySimpleType facet = schemaType.getFacet(i2);
        if (facet == null || (intValue3 = ((SimpleValue) facet).getIntValue()) == strArrSplit_list.length) {
            strArr = strArrSplit_list;
        } else {
            Object[] objArr = new Object[4];
            objArr[i2] = str;
            objArr[i3] = Integer.valueOf(strArrSplit_list.length);
            objArr[2] = Integer.valueOf(intValue3);
            objArr[3] = QNameHelper.readable(schemaType);
            strArr = strArrSplit_list;
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, objArr, null, schemaType, XmlValidationError.LIST_INVALID, null);
        }
        XmlAnySimpleType facet2 = schemaType.getFacet(i3);
        if (facet2 != null && (intValue2 = ((SimpleValue) facet2).getIntValue()) > strArr.length) {
            Object[] objArr2 = new Object[4];
            objArr2[0] = str;
            objArr2[i3] = Integer.valueOf(strArr.length);
            objArr2[2] = Integer.valueOf(intValue2);
            objArr2[3] = QNameHelper.readable(schemaType);
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, objArr2, null, schemaType, XmlValidationError.LIST_INVALID, null);
        }
        XmlAnySimpleType facet3 = schemaType.getFacet(2);
        if (facet3 != null && (intValue = ((SimpleValue) facet3).getIntValue()) < strArr.length) {
            Object[] objArr3 = new Object[4];
            objArr3[0] = str;
            objArr3[i3] = Integer.valueOf(strArr.length);
            objArr3[2] = Integer.valueOf(intValue);
            objArr3[3] = QNameHelper.readable(schemaType);
            emitError(event, XmlErrorCodes.DATATYPE_LENGTH_VALID$LIST_LENGTH, objArr3, null, schemaType, XmlValidationError.LIST_INVALID, null);
        }
        SchemaType listItemType = schemaType.getListItemType();
        this._listValue = new ArrayList();
        this._listTypes = new ArrayList();
        for (String str2 : strArr) {
            validateSimpleType(listItemType, str2, event);
            addToList(listItemType);
        }
        if (i4 != this._errorState || schemaType.getEnumerationValues() == null) {
            return;
        }
        NamespaceContext.push(new NamespaceContext(event));
        try {
            try {
                ((SchemaTypeImpl) schemaType).newValidatingValue(str);
            } catch (XmlValueOutOfRangeException unused) {
                Object[] objArr4 = new Object[3];
                objArr4[0] = XmlErrorCodes.LIST;
                objArr4[i3] = str;
                objArr4[2] = QNameHelper.readable(schemaType);
                emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, objArr4, null, schemaType, XmlValidationError.LIST_INVALID, null);
            }
        } finally {
            NamespaceContext.pop();
        }
    }

    private String validateSimpleType(SchemaType schemaType, SchemaField schemaField, ValidatorListener.Event event, boolean z, boolean z2) {
        String text;
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            return null;
        }
        if (schemaType.isNoType()) {
            emitError(event, schemaField.isAttribute() ? XmlErrorCodes.ATTR_LOCALLY_VALID$NO_TYPE : XmlErrorCodes.ELEM_LOCALLY_VALID$NO_TYPE, null, schemaField.getName(), schemaType, 3, null);
            return null;
        }
        if (z) {
            text = "";
        } else {
            int whiteSpaceRule = schemaType.getWhiteSpaceRule();
            text = whiteSpaceRule == 1 ? event.getText() : event.getText(whiteSpaceRule);
        }
        if (text.isEmpty() && z2 && schemaField != null && (schemaField.isDefault() || schemaField.isFixed())) {
            if (!XmlQName.type.isAssignableFrom(schemaType)) {
                String strCollapse = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
                if (validateSimpleType(schemaType, strCollapse, event)) {
                    return strCollapse;
                }
                return null;
            }
            emitError(event, "Default QName values are unsupported for " + QNameHelper.readable(schemaType) + " - ignoring.", null, null, 2, schemaField.getName(), null, schemaType, null, 3, null);
            return null;
        }
        if (!validateSimpleType(schemaType, text, event)) {
            return null;
        }
        if (schemaField != null && schemaField.isFixed()) {
            String strCollapse2 = XmlWhitespace.collapse(schemaField.getDefaultText(), schemaType.getWhiteSpaceRule());
            if (!validateSimpleType(schemaType, strCollapse2, event)) {
                return null;
            }
            if (!schemaType.newValue(text).valueEquals(schemaType.newValue(strCollapse2))) {
                if (schemaField.isAttribute()) {
                    emitError(event, XmlErrorCodes.ATTR_LOCALLY_VALID$FIXED, new Object[]{text, strCollapse2, QNameHelper.pretty(event.getName())}, null, schemaField.getType(), 3, null);
                } else {
                    emitError(event, schemaField.getType().getContentType() == 4 ? XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_MIXED_CONTENT : schemaType.isSimpleType() ? XmlErrorCodes.ELEM_LOCALLY_VALID$FIXED_VALID_SIMPLE_TYPE : null, new Object[]{text, strCollapse2}, schemaField.getName(), schemaField.getType(), 3, null);
                }
                return null;
            }
        }
        return text;
    }

    private void validateUnionType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.matchPatternFacet(str)) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$PATTERN_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, XmlValidationError.UNION_INVALID, null);
        }
        SchemaType[] unionMemberTypes = schemaType.getUnionMemberTypes();
        int i2 = this._errorState;
        String strCollapse = str;
        int i3 = 0;
        int i4 = 1;
        while (true) {
            if (i3 >= unionMemberTypes.length) {
                break;
            }
            int whiteSpaceRule = unionMemberTypes[i3].getWhiteSpaceRule();
            if (whiteSpaceRule == 0) {
                whiteSpaceRule = 1;
            }
            if (whiteSpaceRule != i4) {
                strCollapse = XmlWhitespace.collapse(str, whiteSpaceRule);
                i4 = whiteSpaceRule;
            }
            int i5 = this._errorState;
            this._suspendErrors++;
            try {
                validateSimpleType(unionMemberTypes[i3], strCollapse, event);
                this._suspendErrors--;
                if (i5 == this._errorState) {
                    this._unionType = unionMemberTypes[i3];
                    break;
                }
                i3++;
            } catch (Throwable th) {
                this._suspendErrors--;
                throw th;
            }
        }
        this._errorState = i2;
        if (i3 >= unionMemberTypes.length) {
            emitError(event, XmlErrorCodes.DATATYPE_VALID$UNION, new Object[]{str, QNameHelper.readable(schemaType)}, null, schemaType, XmlValidationError.UNION_INVALID, null);
            return;
        }
        XmlAnySimpleType[] enumerationValues = schemaType.getEnumerationValues();
        if (enumerationValues != null) {
            NamespaceContext.push(new NamespaceContext(event));
            try {
                try {
                    XmlAnySimpleType xmlAnySimpleTypeNewValue = schemaType.newValue(str);
                    int i6 = 0;
                    while (i6 < enumerationValues.length && !xmlAnySimpleTypeNewValue.valueEquals(enumerationValues[i6])) {
                        i6++;
                    }
                    if (i6 >= enumerationValues.length) {
                        emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, XmlValidationError.UNION_INVALID, null);
                    }
                } catch (XmlValueOutOfRangeException unused) {
                    emitError(event, XmlErrorCodes.DATATYPE_ENUM_VALID, new Object[]{XmlErrorCodes.UNION, str, QNameHelper.readable(schemaType)}, null, schemaType, XmlValidationError.UNION_INVALID, null);
                }
            } finally {
                NamespaceContext.pop();
            }
        }
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public byte[] getByteArrayValue() {
        return this._byteArrayValue;
    }

    public SchemaLocalAttribute getCurrentAttribute() {
        return this._localAttribute;
    }

    public SchemaLocalElement getCurrentElement() {
        State state;
        SchemaLocalElement schemaLocalElement = this._localElement;
        if (schemaLocalElement != null) {
            return schemaLocalElement;
        }
        if (this._eatContent <= 0 && (state = this._stateStack) != null) {
            SchemaField schemaField = state._field;
            if (schemaField instanceof SchemaLocalElement) {
                return (SchemaLocalElement) schemaField;
            }
        }
        return null;
    }

    public SchemaType getCurrentElementSchemaType() {
        State state = topState();
        if (state != null) {
            return state._type;
        }
        return null;
    }

    public SchemaAttributeModel getCurrentWildcardAttribute() {
        return this._wildcardAttribute;
    }

    public SchemaParticle getCurrentWildcardElement() {
        return this._wildcardElement;
    }

    public BigDecimal getDecimalValue() {
        return this._decimalValue;
    }

    public double getDoubleValue() {
        return this._doubleValue;
    }

    public float getFloatValue() {
        return this._floatValue;
    }

    public GDate getGDateValue() {
        return this._gdateValue;
    }

    public GDuration getGDurationValue() {
        return this._gdurationValue;
    }

    public List<SchemaType> getListTypes() {
        return this._listTypes;
    }

    public List<Object> getListValue() {
        return this._listValue;
    }

    public QName getQNameValue() {
        return this._qnameValue;
    }

    public String getStringValue() {
        return this._stringValue;
    }

    public SchemaType getUnionType() {
        return this._unionType;
    }

    public boolean isValid() {
        return !this._invalid && this._constraintEngine.isValid();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener
    public void nextEvent(int i2, ValidatorListener.Event event) {
        resetValues();
        int i3 = this._eatContent;
        if (i3 > 0) {
            if (i2 == 1) {
                this._eatContent = i3 + 1;
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                this._eatContent = i3 - 1;
                return;
            }
        }
        if (i2 == 1) {
            beginEvent(event);
            return;
        }
        if (i2 == 2) {
            endEvent(event);
            return;
        }
        if (i2 == 3) {
            textEvent(event);
        } else if (i2 == 4) {
            attrEvent(event);
        } else {
            if (i2 != 5) {
                return;
            }
            endAttrsEvent(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emitError(ValidatorListener.Event event, String str, Object[] objArr, QName qName, SchemaType schemaType, int i2, SchemaType schemaType2) {
        emitError(event, null, str, objArr, 0, null, qName, schemaType, null, i2, schemaType2);
    }

    private void emitError(ValidatorListener.Event event, String str, String str2, Object[] objArr, int i2, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i3, SchemaType schemaType2) {
        XmlValidationError xmlValidationErrorForLocationWithDetails;
        this._errorState++;
        if (this._suspendErrors == 0) {
            if (i2 == 0) {
                this._invalid = true;
            }
            if (this._errorListener != null) {
                XmlCursor locationAsCursor = event.getLocationAsCursor();
                if (locationAsCursor != null) {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forCursorWithDetails(str, str2, objArr, i2, locationAsCursor, qName, qName2, schemaType, list, i3, schemaType2);
                } else {
                    xmlValidationErrorForLocationWithDetails = XmlValidationError.forLocationWithDetails(str, str2, objArr, i2, event.getLocation(), qName, qName2, schemaType, list, i3, schemaType2);
                }
                this._errorListener.add(xmlValidationErrorForLocationWithDetails);
            }
        }
    }

    private boolean validateSimpleType(SchemaType schemaType, String str, ValidatorListener.Event event) {
        if (!schemaType.isSimpleType() && schemaType.getContentType() != 2) {
            throw new RuntimeException("Not a simple type");
        }
        int i2 = this._errorState;
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 1) {
            validateAtomicType(schemaType, str, event);
        } else if (simpleVariety == 2) {
            validateUnionType(schemaType, str, event);
        } else if (simpleVariety == 3) {
            validateListType(schemaType, str, event);
        } else {
            throw new RuntimeException("Unexpected simple variety");
        }
        return i2 == this._errorState;
    }
}
