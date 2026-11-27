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
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;

/* loaded from: classes2.dex */
public class RestrictionDocumentImpl extends XmlComplexContentImpl implements RestrictionDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "restriction")};
    private static final long serialVersionUID = 1;

    public static class RestrictionImpl extends AnnotatedImpl implements RestrictionDocument.Restriction {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.w3.org/2001/XMLSchema", "simpleType"), new QName("http://www.w3.org/2001/XMLSchema", "minExclusive"), new QName("http://www.w3.org/2001/XMLSchema", "minInclusive"), new QName("http://www.w3.org/2001/XMLSchema", "maxExclusive"), new QName("http://www.w3.org/2001/XMLSchema", "maxInclusive"), new QName("http://www.w3.org/2001/XMLSchema", "totalDigits"), new QName("http://www.w3.org/2001/XMLSchema", "fractionDigits"), new QName("http://www.w3.org/2001/XMLSchema", "length"), new QName("http://www.w3.org/2001/XMLSchema", "minLength"), new QName("http://www.w3.org/2001/XMLSchema", "maxLength"), new QName("http://www.w3.org/2001/XMLSchema", "enumeration"), new QName("http://www.w3.org/2001/XMLSchema", "whiteSpace"), new QName("http://www.w3.org/2001/XMLSchema", "pattern"), new QName("", "base")};
        private static final long serialVersionUID = 1;

        public RestrictionImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet addNewEnumeration() {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().add_element_user(PROPERTY_QNAME[10]);
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewFractionDigits() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[6]);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[7]);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMaxExclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[3]);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMaxInclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[4]);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewMaxLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[9]);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMinExclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[1]);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet addNewMinInclusive() {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().add_element_user(PROPERTY_QNAME[2]);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet addNewMinLength() {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().add_element_user(PROPERTY_QNAME[8]);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern addNewPattern() {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().add_element_user(PROPERTY_QNAME[12]);
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public LocalSimpleType addNewSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().add_element_user(PROPERTY_QNAME[5]);
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().add_element_user(PROPERTY_QNAME[11]);
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public QName getBase() {
            QName qNameValue;
            synchronized (monitor()) {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[13]);
                qNameValue = simpleValue == null ? null : simpleValue.getQNameValue();
            }
            return qNameValue;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet[] getEnumerationArray() {
            return (NoFixedFacet[]) getXmlObjectArray(PROPERTY_QNAME[10], new NoFixedFacet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<NoFixedFacet> getEnumerationList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getEnumerationArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f2
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setEnumerationArray(((Integer) obj).intValue(), (NoFixedFacet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewEnumeration(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j8
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeEnumeration(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x4
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfEnumerationArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getFractionDigitsArray() {
            return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[6], new NumFacet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<NumFacet> getFractionDigitsList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getFractionDigitsArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setFractionDigitsArray(((Integer) obj).intValue(), (NumFacet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.aa
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewFractionDigits(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeFractionDigits(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q3
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfFractionDigitsArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getLengthArray() {
            return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[7], new NumFacet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<NumFacet> getLengthList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d9
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getLengthArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewLength(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.v2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeLength(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.f8
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfLengthArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMaxExclusiveArray() {
            return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[3], new Facet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<Facet> getMaxExclusiveList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ra
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMaxExclusiveArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.z9
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMaxExclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMaxExclusive(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n6
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMaxExclusive(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMaxExclusiveArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMaxInclusiveArray() {
            return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[4], new Facet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<Facet> getMaxInclusiveList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMaxInclusiveArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMaxInclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMaxInclusive(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.c6
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMaxInclusive(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.d8
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMaxInclusiveArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getMaxLengthArray() {
            return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[9], new NumFacet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<NumFacet> getMaxLengthList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMaxLengthArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.n1
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMaxLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.g7
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMaxLength(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMaxLength(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ab
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMaxLengthArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMinExclusiveArray() {
            return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[1], new Facet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<Facet> getMinExclusiveList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMinExclusiveArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.db
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMinExclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.l6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMinExclusive(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.w3
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMinExclusive(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.hb
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMinExclusiveArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet[] getMinInclusiveArray() {
            return (Facet[]) getXmlObjectArray(PROPERTY_QNAME[2], new Facet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<Facet> getMinInclusiveList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMinInclusiveArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.b8
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMinInclusiveArray(((Integer) obj).intValue(), (Facet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMinInclusive(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.y7
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMinInclusive(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p2
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMinInclusiveArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet[] getMinLengthArray() {
            return (NumFacet[]) getXmlObjectArray(PROPERTY_QNAME[8], new NumFacet[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<NumFacet> getMinLengthList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s4
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getMinLengthArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.h0
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setMinLengthArray(((Integer) obj).intValue(), (NumFacet) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.a5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewMinLength(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.k
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeMinLength(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.q0
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfMinLengthArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern[] getPatternArray() {
            return (PatternDocument.Pattern[]) getXmlObjectArray(PROPERTY_QNAME[12], new PatternDocument.Pattern[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<PatternDocument.Pattern> getPatternList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.j5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getPatternArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.p6
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setPatternArray(((Integer) obj).intValue(), (PatternDocument.Pattern) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.x6
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewPattern(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.u9
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removePattern(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.e6
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfPatternArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public LocalSimpleType getSimpleType() {
            LocalSimpleType localSimpleType;
            synchronized (monitor()) {
                check_orphaned();
                localSimpleType = (LocalSimpleType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
                if (localSimpleType == null) {
                    localSimpleType = null;
                }
            }
            return localSimpleType;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
            return (TotalDigitsDocument.TotalDigits[]) getXmlObjectArray(PROPERTY_QNAME[5], new TotalDigitsDocument.TotalDigits[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<TotalDigitsDocument.TotalDigits> getTotalDigitsList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i3
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getTotalDigitsArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.t4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setTotalDigitsArray(((Integer) obj).intValue(), (TotalDigitsDocument.TotalDigits) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i2
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewTotalDigits(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ba
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeTotalDigits(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.s5
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfTotalDigitsArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
            return (WhiteSpaceDocument.WhiteSpace[]) getXmlObjectArray(PROPERTY_QNAME[11], new WhiteSpaceDocument.WhiteSpace[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public List<WhiteSpaceDocument.WhiteSpace> getWhiteSpaceList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i1
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.getWhiteSpaceArray(((Integer) obj).intValue());
                    }
                }, new BiConsumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.ca
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.a.setWhiteSpaceArray(((Integer) obj).intValue(), (WhiteSpaceDocument.WhiteSpace) obj2);
                    }
                }, new Function() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.i9
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.insertNewWhiteSpace(((Integer) obj).intValue());
                    }
                }, new Consumer() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.xa
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.a.removeWhiteSpace(((Integer) obj).intValue());
                    }
                }, new Supplier() { // from class: org.apache.xmlbeans.impl.xb.xsdschema.impl.o2
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        return Integer.valueOf(this.a.sizeOfWhiteSpaceArray());
                    }
                });
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet insertNewEnumeration(int i2) {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewFractionDigits(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewLength(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMaxExclusive(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMaxInclusive(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewMaxLength(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMinExclusive(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet insertNewMinInclusive(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet insertNewMinLength(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern insertNewPattern(int i2) {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int i2) {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int i2) {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public boolean isSetBase() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public boolean isSetSimpleType() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeEnumeration(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[10], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeFractionDigits(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[6], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeLength(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[7], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxExclusive(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[3], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxInclusive(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[4], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMaxLength(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[9], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinExclusive(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[1], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinInclusive(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[2], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeMinLength(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[8], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removePattern(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[12], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeTotalDigits(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[5], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void removeWhiteSpace(int i2) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[11], i2);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setBase(QName qName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
                }
                simpleValue.setQNameValue(qName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setEnumerationArray(NoFixedFacet[] noFixedFacetArr) {
            check_orphaned();
            arraySetterHelper(noFixedFacetArr, PROPERTY_QNAME[10]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setFractionDigitsArray(NumFacet[] numFacetArr) {
            check_orphaned();
            arraySetterHelper(numFacetArr, PROPERTY_QNAME[6]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setLengthArray(NumFacet[] numFacetArr) {
            check_orphaned();
            arraySetterHelper(numFacetArr, PROPERTY_QNAME[7]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxExclusiveArray(Facet[] facetArr) {
            check_orphaned();
            arraySetterHelper(facetArr, PROPERTY_QNAME[3]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxInclusiveArray(Facet[] facetArr) {
            check_orphaned();
            arraySetterHelper(facetArr, PROPERTY_QNAME[4]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxLengthArray(NumFacet[] numFacetArr) {
            check_orphaned();
            arraySetterHelper(numFacetArr, PROPERTY_QNAME[9]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinExclusiveArray(Facet[] facetArr) {
            check_orphaned();
            arraySetterHelper(facetArr, PROPERTY_QNAME[1]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinInclusiveArray(Facet[] facetArr) {
            check_orphaned();
            arraySetterHelper(facetArr, PROPERTY_QNAME[2]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinLengthArray(NumFacet[] numFacetArr) {
            check_orphaned();
            arraySetterHelper(numFacetArr, PROPERTY_QNAME[8]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setPatternArray(PatternDocument.Pattern[] patternArr) {
            check_orphaned();
            arraySetterHelper(patternArr, PROPERTY_QNAME[12]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setSimpleType(LocalSimpleType localSimpleType) throws Throwable {
            generatedSetterHelperImpl(localSimpleType, PROPERTY_QNAME[0], 0, (short) 1);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] totalDigitsArr) {
            check_orphaned();
            arraySetterHelper(totalDigitsArr, PROPERTY_QNAME[5]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] whiteSpaceArr) {
            check_orphaned();
            arraySetterHelper(whiteSpaceArr, PROPERTY_QNAME[11]);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfEnumerationArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfFractionDigitsArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfLengthArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxExclusiveArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxInclusiveArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMaxLengthArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinExclusiveArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinInclusiveArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfMinLengthArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfPatternArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfTotalDigitsArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public int sizeOfWhiteSpaceArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void unsetBase() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(PROPERTY_QNAME[13]);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void unsetSimpleType() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], 0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public XmlQName xgetBase() {
            XmlQName xmlQName;
            synchronized (monitor()) {
                check_orphaned();
                xmlQName = (XmlQName) get_store().find_attribute_user(PROPERTY_QNAME[13]);
            }
            return xmlQName;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void xsetBase(XmlQName xmlQName) {
            synchronized (monitor()) {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlQName xmlQName2 = (XmlQName) typeStore.find_attribute_user(qNameArr[13]);
                if (xmlQName2 == null) {
                    xmlQName2 = (XmlQName) get_store().add_attribute_user(qNameArr[13]);
                }
                xmlQName2.set(xmlQName);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NoFixedFacet getEnumerationArray(int i2) {
            NoFixedFacet noFixedFacet;
            synchronized (monitor()) {
                check_orphaned();
                noFixedFacet = (NoFixedFacet) get_store().find_element_user(PROPERTY_QNAME[10], i2);
                if (noFixedFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return noFixedFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getFractionDigitsArray(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[6], i2);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getLengthArray(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[7], i2);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMaxExclusiveArray(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[3], i2);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMaxInclusiveArray(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[4], i2);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getMaxLengthArray(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[9], i2);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMinExclusiveArray(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[1], i2);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public Facet getMinInclusiveArray(int i2) {
            Facet facet;
            synchronized (monitor()) {
                check_orphaned();
                facet = (Facet) get_store().find_element_user(PROPERTY_QNAME[2], i2);
                if (facet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return facet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public NumFacet getMinLengthArray(int i2) {
            NumFacet numFacet;
            synchronized (monitor()) {
                check_orphaned();
                numFacet = (NumFacet) get_store().find_element_user(PROPERTY_QNAME[8], i2);
                if (numFacet == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return numFacet;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public PatternDocument.Pattern getPatternArray(int i2) {
            PatternDocument.Pattern pattern;
            synchronized (monitor()) {
                check_orphaned();
                pattern = (PatternDocument.Pattern) get_store().find_element_user(PROPERTY_QNAME[12], i2);
                if (pattern == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return pattern;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int i2) {
            TotalDigitsDocument.TotalDigits totalDigits;
            synchronized (monitor()) {
                check_orphaned();
                totalDigits = (TotalDigitsDocument.TotalDigits) get_store().find_element_user(PROPERTY_QNAME[5], i2);
                if (totalDigits == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return totalDigits;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int i2) {
            WhiteSpaceDocument.WhiteSpace whiteSpace;
            synchronized (monitor()) {
                check_orphaned();
                whiteSpace = (WhiteSpaceDocument.WhiteSpace) get_store().find_element_user(PROPERTY_QNAME[11], i2);
                if (whiteSpace == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            return whiteSpace;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setEnumerationArray(int i2, NoFixedFacet noFixedFacet) throws Throwable {
            generatedSetterHelperImpl(noFixedFacet, PROPERTY_QNAME[10], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setFractionDigitsArray(int i2, NumFacet numFacet) throws Throwable {
            generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[6], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setLengthArray(int i2, NumFacet numFacet) throws Throwable {
            generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[7], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxExclusiveArray(int i2, Facet facet) throws Throwable {
            generatedSetterHelperImpl(facet, PROPERTY_QNAME[3], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxInclusiveArray(int i2, Facet facet) throws Throwable {
            generatedSetterHelperImpl(facet, PROPERTY_QNAME[4], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMaxLengthArray(int i2, NumFacet numFacet) throws Throwable {
            generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[9], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinExclusiveArray(int i2, Facet facet) throws Throwable {
            generatedSetterHelperImpl(facet, PROPERTY_QNAME[1], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinInclusiveArray(int i2, Facet facet) throws Throwable {
            generatedSetterHelperImpl(facet, PROPERTY_QNAME[2], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setMinLengthArray(int i2, NumFacet numFacet) throws Throwable {
            generatedSetterHelperImpl(numFacet, PROPERTY_QNAME[8], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setPatternArray(int i2, PatternDocument.Pattern pattern) throws Throwable {
            generatedSetterHelperImpl(pattern, PROPERTY_QNAME[12], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setTotalDigitsArray(int i2, TotalDigitsDocument.TotalDigits totalDigits) throws Throwable {
            generatedSetterHelperImpl(totalDigits, PROPERTY_QNAME[5], i2, (short) 2);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction
        public void setWhiteSpaceArray(int i2, WhiteSpaceDocument.WhiteSpace whiteSpace) throws Throwable {
            generatedSetterHelperImpl(whiteSpace, PROPERTY_QNAME[11], i2, (short) 2);
        }
    }

    public RestrictionDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public RestrictionDocument.Restriction addNewRestriction() {
        RestrictionDocument.Restriction restriction;
        synchronized (monitor()) {
            check_orphaned();
            restriction = (RestrictionDocument.Restriction) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return restriction;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public RestrictionDocument.Restriction getRestriction() {
        RestrictionDocument.Restriction restriction;
        synchronized (monitor()) {
            check_orphaned();
            restriction = (RestrictionDocument.Restriction) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (restriction == null) {
                restriction = null;
            }
        }
        return restriction;
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument
    public void setRestriction(RestrictionDocument.Restriction restriction) throws Throwable {
        generatedSetterHelperImpl(restriction, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
