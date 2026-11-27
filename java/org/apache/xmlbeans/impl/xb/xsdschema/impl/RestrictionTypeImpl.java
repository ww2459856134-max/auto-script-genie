package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;

/* loaded from: classes2.dex */
public class RestrictionTypeImpl extends AnnotatedImpl implements RestrictionType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "group"), new QName("http://www.w3.org/2001/XMLSchema", "all"), new QName("http://www.w3.org/2001/XMLSchema", "choice"), new QName("http://www.w3.org/2001/XMLSchema", "sequence"), new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", "minExclusive"), new QName("http://www.w3.org/2001/XMLSchema", "minInclusive"), new QName("http://www.w3.org/2001/XMLSchema", "maxExclusive"), new QName("http://www.w3.org/2001/XMLSchema", "maxInclusive"), new QName("http://www.w3.org/2001/XMLSchema", "totalDigits"), new QName("http://www.w3.org/2001/XMLSchema", "fractionDigits"), new QName("http://www.w3.org/2001/XMLSchema", "length"), new QName("http://www.w3.org/2001/XMLSchema", "minLength"), new QName("http://www.w3.org/2001/XMLSchema", "maxLength"), new QName("http://www.w3.org/2001/XMLSchema", "enumeration"), new QName("http://www.w3.org/2001/XMLSchema", "whiteSpace"), new QName("http://www.w3.org/2001/XMLSchema", "pattern"), new QName("http://www.w3.org/2001/XMLSchema", "attribute"), new QName("http://www.w3.org/2001/XMLSchema", "attributeGroup"), new QName("http://www.w3.org/2001/XMLSchema", "anyAttribute"), new QName("", "base")};
    private static final long serialVersionUID = 1;

    public RestrictionTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Wildcard addNewAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute addNewAttribute() {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef addNewAttributeGroup() {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup addNewChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet addNewEnumeration() {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewFractionDigits() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public GroupRef addNewGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMaxExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMaxInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewMaxLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMinExclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet addNewMinInclusive() {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet addNewMinLength() {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern addNewPattern() {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup addNewSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public LocalSimpleType addNewSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public All getAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (all == null) {
                all = null;
            }
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Wildcard getAnyAttribute() {
        Wildcard wildcard;
        synchronized (monitor()) {
            check_orphaned();
            wildcard = (Wildcard) get_store().find_element_user(PROPERTY_QNAME[19], 0);
            if (wildcard == null) {
                wildcard = null;
            }
        }
        return wildcard;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute[] getAttributeArray() {
        return (Attribute[]) getXmlObjectArray(PROPERTY_QNAME[17], new Attribute[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef[] getAttributeGroupArray() {
        return (AttributeGroupRef[]) getXmlObjectArray(PROPERTY_QNAME[18], new AttributeGroupRef[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<AttributeGroupRef> getAttributeGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttributeGroupArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttributeGroupArray(((Integer) obj).intValue(), (AttributeGroupRef) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttributeGroup(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttributeGroup(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttributeGroupArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<Attribute> getAttributeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getAttributeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setAttributeArray(((Integer) obj).intValue(), (Attribute) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewAttribute(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeAttribute(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfAttributeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public QName getBase() {
        QName qNameValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[20]);
            qNameValue = simpleValue == null ? null : simpleValue.getQNameValue();
        }
        return qNameValue;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup getChoice() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (explicitGroup == null) {
                explicitGroup = null;
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet[] getEnumerationArray() {
        return (NoFixedFacet[]) getXmlObjectArray(PROPERTY_QNAME[14], new NoFixedFacet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<NoFixedFacet> getEnumerationList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getEnumerationArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setEnumerationArray(((Integer) obj).intValue(), (NoFixedFacet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewEnumeration(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ma
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeEnumeration(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfEnumerationArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getFractionDigitsArray() {
        return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[10], new NumFacet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<NumFacet> getFractionDigitsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.z8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFractionDigitsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t6
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFractionDigitsArray(((Integer) obj).intValue(), (NumFacet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFractionDigits(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFractionDigits(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.fb
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFractionDigitsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public GroupRef getGroup() {
        GroupRef groupRef;
        synchronized (monitor()) {
            check_orphaned();
            groupRef = (GroupRef) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (groupRef == null) {
                groupRef = null;
            }
        }
        return groupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getLengthArray() {
        return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[11], new NumFacet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<NumFacet> getLengthList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getLengthArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewLength(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeLength(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.qa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfLengthArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMaxExclusiveArray() {
        return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[7], new Facet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<Facet> getMaxExclusiveList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.va
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMaxExclusiveArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMaxExclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMaxExclusive(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMaxExclusive(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMaxExclusiveArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMaxInclusiveArray() {
        return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[8], new Facet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<Facet> getMaxInclusiveList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMaxInclusiveArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMaxInclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMaxInclusive(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.m4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMaxInclusive(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMaxInclusiveArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getMaxLengthArray() {
        return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[13], new NumFacet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<NumFacet> getMaxLengthList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMaxLengthArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMaxLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMaxLength(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMaxLength(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.fa
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMaxLengthArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMinExclusiveArray() {
        return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[5], new Facet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<Facet> getMinExclusiveList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMinExclusiveArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMinExclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMinExclusive(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMinExclusive(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMinExclusiveArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet[] getMinInclusiveArray() {
        return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[6], new Facet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<Facet> getMinInclusiveList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMinInclusiveArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMinInclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMinInclusive(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMinInclusive(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMinInclusiveArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet[] getMinLengthArray() {
        return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[12], new NumFacet[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<NumFacet> getMinLengthList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getMinLengthArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ka
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setMinLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewMinLength(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeMinLength(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfMinLengthArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern[] getPatternArray() {
        return (PatternDocument.Pattern[]) getXmlObjectArray(PROPERTY_QNAME[16], new PatternDocument.Pattern[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<PatternDocument.Pattern> getPatternList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPatternArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPatternArray(((Integer) obj).intValue(), (PatternDocument.Pattern) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPattern(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePattern(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ia
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPatternArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public ExplicitGroup getSequence() {
        ExplicitGroup explicitGroup;
        synchronized (monitor()) {
            check_orphaned();
            explicitGroup = (ExplicitGroup) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (explicitGroup == null) {
                explicitGroup = null;
            }
        }
        return explicitGroup;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public LocalSimpleType getSimpleType() {
        LocalSimpleType localSimpleType;
        synchronized (monitor()) {
            check_orphaned();
            localSimpleType = (LocalSimpleType) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (localSimpleType == null) {
                localSimpleType = null;
            }
        }
        return localSimpleType;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
        return (TotalDigitsDocument.TotalDigits[]) getXmlObjectArray(PROPERTY_QNAME[9], new TotalDigitsDocument.TotalDigits[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<TotalDigitsDocument.TotalDigits> getTotalDigitsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTotalDigitsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTotalDigitsArray(((Integer) obj).intValue(), (TotalDigitsDocument.TotalDigits) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTotalDigits(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.z5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTotalDigits(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTotalDigitsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
        return (WhiteSpaceDocument.WhiteSpace[]) getXmlObjectArray(PROPERTY_QNAME[15], new WhiteSpaceDocument.WhiteSpace[0]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.r1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getWhiteSpaceArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setWhiteSpaceArray(((Integer) obj).intValue(), (WhiteSpaceDocument.WhiteSpace) obj2);
                }
            }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewWhiteSpace(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeWhiteSpace(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfWhiteSpaceArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute insertNewAttribute(int i2) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().insert_element_user(PROPERTY_QNAME[17], i2);
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef insertNewAttributeGroup(int i2) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().insert_element_user(PROPERTY_QNAME[18], i2);
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet insertNewEnumeration(int i2) {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewFractionDigits(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewLength(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMaxExclusive(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMaxInclusive(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewMaxLength(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMinExclusive(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet insertNewMinInclusive(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet insertNewMinLength(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern insertNewPattern(int i2) {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().insert_element_user(PROPERTY_QNAME[16], i2);
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i2) {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i2) {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().insert_element_user(PROPERTY_QNAME[15], i2);
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetAll() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetAnyAttribute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[19]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetChoice() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetGroup() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetSequence() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public boolean isSetSimpleType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeAttribute(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeAttributeGroup(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeEnumeration(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeFractionDigits(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeLength(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxExclusive(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxInclusive(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMaxLength(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinExclusive(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinInclusive(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeMinLength(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removePattern(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeTotalDigits(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void removeWhiteSpace(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i2);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAll(All all) throws Throwable {
        generatedSetterHelperImpl(all, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAnyAttribute(Wildcard wildcard) throws Throwable {
        generatedSetterHelperImpl(wildcard, PROPERTY_QNAME[19], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeArray(Attribute[] attributeArr) {
        check_orphaned();
        arraySetterHelper(attributeArr, PROPERTY_QNAME[17]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeGroupArray(AttributeGroupRef[] attributeGroupRefArr) {
        check_orphaned();
        arraySetterHelper(attributeGroupRefArr, PROPERTY_QNAME[18]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setBase(QName qName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
            if (simpleValue == null) {
                simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
            }
            simpleValue.setQNameValue(qName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setChoice(ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setEnumerationArray(NoFixedFacet[] noFixedFacetArr) {
        check_orphaned();
        arraySetterHelper(noFixedFacetArr, PROPERTY_QNAME[14]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setFractionDigitsArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, PROPERTY_QNAME[10]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setGroup(GroupRef groupRef) throws Throwable {
        generatedSetterHelperImpl(groupRef, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, PROPERTY_QNAME[11]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxExclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, PROPERTY_QNAME[7]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxInclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, PROPERTY_QNAME[8]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, PROPERTY_QNAME[13]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinExclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, PROPERTY_QNAME[5]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinInclusiveArray(Facet[] facetArr) {
        check_orphaned();
        arraySetterHelper(facetArr, PROPERTY_QNAME[6]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinLengthArray(NumFacet[] numFacetArr) {
        check_orphaned();
        arraySetterHelper(numFacetArr, PROPERTY_QNAME[12]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setPatternArray(PatternDocument.Pattern[] patternArr) {
        check_orphaned();
        arraySetterHelper(patternArr, PROPERTY_QNAME[16]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setSequence(ExplicitGroup explicitGroup) throws Throwable {
        generatedSetterHelperImpl(explicitGroup, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setSimpleType(LocalSimpleType localSimpleType) throws Throwable {
        generatedSetterHelperImpl(localSimpleType, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr) {
        check_orphaned();
        arraySetterHelper(totalDigitsArr, PROPERTY_QNAME[9]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr) {
        check_orphaned();
        arraySetterHelper(whiteSpaceArr, PROPERTY_QNAME[15]);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfAttributeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfAttributeGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfEnumerationArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfFractionDigitsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxExclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxInclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMaxLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinExclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinInclusiveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfMinLengthArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfPatternArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfTotalDigitsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public int sizeOfWhiteSpaceArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetAll() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetAnyAttribute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetChoice() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetGroup() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetSequence() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void unsetSimpleType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public XmlQName xgetBase() {
        XmlQName xmlQName;
        synchronized (monitor()) {
            check_orphaned();
            xmlQName = (XmlQName) get_store().find_attribute_user(PROPERTY_QNAME[20]);
        }
        return xmlQName;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void xsetBase(XmlQName xmlQName) {
        synchronized (monitor()) {
            check_orphaned();
            TypeStore typeStore = get_store();
            QName[] qNameArr = PROPERTY_QNAME;
            XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qNameArr[20]);
            if (xmlQName2 == null) {
                xmlQName2 = (XmlQName) get_store().add_attribute_user(qNameArr[20]);
            }
            xmlQName2.set(xmlQName);
        }
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Attribute getAttributeArray(int i2) {
        Attribute attribute;
        synchronized (monitor()) {
            check_orphaned();
            attribute = (Attribute) get_store().find_element_user(PROPERTY_QNAME[17], i2);
            if (attribute == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attribute;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public AttributeGroupRef getAttributeGroupArray(int i2) {
        AttributeGroupRef attributeGroupRef;
        synchronized (monitor()) {
            check_orphaned();
            attributeGroupRef = (AttributeGroupRef) get_store().find_element_user(PROPERTY_QNAME[18], i2);
            if (attributeGroupRef == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return attributeGroupRef;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NoFixedFacet getEnumerationArray(int i2) {
        NoFixedFacet noFixedFacet;
        synchronized (monitor()) {
            check_orphaned();
            noFixedFacet = (NoFixedFacet) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (noFixedFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return noFixedFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getFractionDigitsArray(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getLengthArray(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMaxExclusiveArray(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMaxInclusiveArray(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getMaxLengthArray(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMinExclusiveArray(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public Facet getMinInclusiveArray(int i2) {
        Facet facet;
        synchronized (monitor()) {
            check_orphaned();
            facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (facet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return facet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public NumFacet getMinLengthArray(int i2) {
        NumFacet numFacet;
        synchronized (monitor()) {
            check_orphaned();
            numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (numFacet == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return numFacet;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public PatternDocument.Pattern getPatternArray(int i2) {
        PatternDocument.Pattern pattern;
        synchronized (monitor()) {
            check_orphaned();
            pattern = (PatternDocument.Pattern) get_store().find_element_user(PROPERTY_QNAME[16], i2);
            if (pattern == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return pattern;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i2) {
        TotalDigitsDocument.TotalDigits totalDigits;
        synchronized (monitor()) {
            check_orphaned();
            totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (totalDigits == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return totalDigits;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i2) {
        WhiteSpaceDocument.WhiteSpace whiteSpace;
        synchronized (monitor()) {
            check_orphaned();
            whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(PROPERTY_QNAME[15], i2);
            if (whiteSpace == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return whiteSpace;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeArray(int i2, Attribute attribute) throws Throwable {
        generatedSetterHelperImpl(attribute, PROPERTY_QNAME[17], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setAttributeGroupArray(int i2, AttributeGroupRef attributeGroupRef) throws Throwable {
        generatedSetterHelperImpl(attributeGroupRef, PROPERTY_QNAME[18], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setEnumerationArray(int i2, NoFixedFacet noFixedFacet) throws Throwable {
        generatedSetterHelperImpl(noFixedFacet, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setFractionDigitsArray(int i2, NumFacet numFacet) throws Throwable {
        generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setLengthArray(int i2, NumFacet numFacet) throws Throwable {
        generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxExclusiveArray(int i2, Facet facet) throws Throwable {
        generatedSetterHelperImpl(facet, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxInclusiveArray(int i2, Facet facet) throws Throwable {
        generatedSetterHelperImpl(facet, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMaxLengthArray(int i2, NumFacet numFacet) throws Throwable {
        generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[13], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinExclusiveArray(int i2, Facet facet) throws Throwable {
        generatedSetterHelperImpl(facet, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinInclusiveArray(int i2, Facet facet) throws Throwable {
        generatedSetterHelperImpl(facet, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setMinLengthArray(int i2, NumFacet numFacet) throws Throwable {
        generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setPatternArray(int i2, PatternDocument.Pattern pattern) throws Throwable {
        generatedSetterHelperImpl(pattern, PROPERTY_QNAME[16], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setTotalDigitsArray(int i2, TotalDigitsDocument.TotalDigits totalDigits) throws Throwable {
        generatedSetterHelperImpl(totalDigits, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionType
    public void setWhiteSpaceArray(int i2, WhiteSpaceDocument.WhiteSpace whiteSpace) throws Throwable {
        generatedSetterHelperImpl(whiteSpace, PROPERTY_QNAME[15], i2, (short) 2);
    }
}
