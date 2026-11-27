package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;

/* loaded from: classes2.dex */
public class CTRPrEltImpl extends XmlComplexContentImpl implements CTRPrElt {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "rFont"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "charset"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "family"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "b"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "i"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "strike"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "outline"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "shadow"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "condense"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extend"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "color"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sz"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "u"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "vertAlign"), new QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "scheme")};
    private static final long serialVersionUID = 1;

    public CTRPrEltImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewB() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty addNewCharset() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor addNewColor() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewCondense() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewExtend() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty addNewFamily() {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewI() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewOutline() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName addNewRFont() {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme addNewScheme() {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewShadow() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty addNewStrike() {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize addNewSz() {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty addNewU() {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty addNewVertAlign() {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getBArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getBList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.bf
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getBArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.a2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setBArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.l6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewB(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.l
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeB(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.oe
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfBArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty[] getCharsetArray() {
        return (CTIntProperty[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTIntProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTIntProperty> getCharsetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.m5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCharsetArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ti
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCharsetArray(((Integer) obj).intValue(), (CTIntProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.gg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCharset(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCharset(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCharsetArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor[] getColorArray() {
        return (CTColor[]) getXmlObjectArray(PROPERTY_QNAME[10], new CTColor[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTColor> getColorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.u7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getColorArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setColorArray(((Integer) obj).intValue(), (CTColor) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewColor(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.re
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeColor(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ne
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfColorArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getCondenseArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getCondenseList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.y9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCondenseArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.z9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCondenseArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.di
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCondense(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.w0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCondense(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.x6
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCondenseArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getExtendArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[9], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getExtendList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.j
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getExtendArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.pk
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setExtendArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.nc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewExtend(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.p0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeExtend(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ad
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfExtendArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty[] getFamilyArray() {
        return (CTIntProperty[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTIntProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTIntProperty> getFamilyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.i4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFamilyArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFamilyArray(((Integer) obj).intValue(), (CTIntProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.li
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFamily(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.hd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFamily(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.qg
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFamilyArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getIArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getIList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.s2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getIArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.c4
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setIArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.th
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewI(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.qb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeI(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rd
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfIArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getOutlineArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getOutlineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.nd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getOutlineArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.c
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setOutlineArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewOutline(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.nb
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeOutline(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ag
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfOutlineArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName[] getRFontArray() {
        return (CTFontName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTFontName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontName> getRFontList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rj
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getRFontArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.u0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setRFontArray(((Integer) obj).intValue(), (CTFontName) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.v4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewRFont(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.k4
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeRFont(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.rk
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfRFontArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme[] getSchemeArray() {
        return (CTFontScheme[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTFontScheme[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontScheme> getSchemeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.c1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSchemeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.fh
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSchemeArray(((Integer) obj).intValue(), (CTFontScheme) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ga
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewScheme(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.p2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeScheme(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.x0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSchemeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getShadowArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getShadowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.xh
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getShadowArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setShadowArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.f6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewShadow(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.nh
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeShadow(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.te
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfShadowArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty[] getStrikeArray() {
        return (CTBooleanProperty[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTBooleanProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTBooleanProperty> getStrikeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getStrikeArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ji
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setStrikeArray(((Integer) obj).intValue(), (CTBooleanProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.y2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewStrike(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.le
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeStrike(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.b7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfStrikeArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize[] getSzArray() {
        return (CTFontSize[]) getXmlObjectArray(PROPERTY_QNAME[11], new CTFontSize[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTFontSize> getSzList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSzArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.j0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSzArray(((Integer) obj).intValue(), (CTFontSize) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.r7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSz(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.l9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSz(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.q8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSzArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty[] getUArray() {
        return (CTUnderlineProperty[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTUnderlineProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTUnderlineProperty> getUList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.e7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getUArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.w8
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setUArray(((Integer) obj).intValue(), (CTUnderlineProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.lg
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewU(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.o0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeU(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.x3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfUArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty[] getVertAlignArray() {
        return (CTVerticalAlignFontProperty[]) getXmlObjectArray(PROPERTY_QNAME[13], new CTVerticalAlignFontProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public List<CTVerticalAlignFontProperty> getVertAlignList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.h1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getVertAlignArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.sa
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setVertAlignArray(((Integer) obj).intValue(), (CTVerticalAlignFontProperty) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.t1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewVertAlign(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.na
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeVertAlign(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.ya
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfVertAlignArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewB(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty insertNewCharset(int i2) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(PROPERTY_QNAME[1], i2);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor insertNewColor(int i2) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().insert_element_user(PROPERTY_QNAME[10], i2);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewCondense(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewExtend(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[9], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty insertNewFamily(int i2) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewI(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewOutline(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName insertNewRFont(int i2) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().insert_element_user(PROPERTY_QNAME[0], i2);
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme insertNewScheme(int i2) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().insert_element_user(PROPERTY_QNAME[14], i2);
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewShadow(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty insertNewStrike(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize insertNewSz(int i2) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().insert_element_user(PROPERTY_QNAME[11], i2);
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty insertNewU(int i2) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().insert_element_user(PROPERTY_QNAME[12], i2);
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty insertNewVertAlign(int i2) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().insert_element_user(PROPERTY_QNAME[13], i2);
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeB(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeCharset(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeColor(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeCondense(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeExtend(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeFamily(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeI(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeOutline(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeRFont(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeScheme(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeShadow(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeStrike(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeSz(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeU(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void removeVertAlign(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i2);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setBArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCharsetArray(CTIntProperty[] cTIntPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTIntPropertyArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setColorArray(CTColor[] cTColorArr) {
        check_orphaned();
        arraySetterHelper(cTColorArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCondenseArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setExtendArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setFamilyArray(CTIntProperty[] cTIntPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTIntPropertyArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setIArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setOutlineArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setRFontArray(CTFontName[] cTFontNameArr) {
        check_orphaned();
        arraySetterHelper(cTFontNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSchemeArray(CTFontScheme[] cTFontSchemeArr) {
        check_orphaned();
        arraySetterHelper(cTFontSchemeArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setShadowArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setStrikeArray(CTBooleanProperty[] cTBooleanPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTBooleanPropertyArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSzArray(CTFontSize[] cTFontSizeArr) {
        check_orphaned();
        arraySetterHelper(cTFontSizeArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setUArray(CTUnderlineProperty[] cTUnderlinePropertyArr) {
        check_orphaned();
        arraySetterHelper(cTUnderlinePropertyArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setVertAlignArray(CTVerticalAlignFontProperty[] cTVerticalAlignFontPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTVerticalAlignFontPropertyArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfBArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfCharsetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfCondenseArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfExtendArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfFamilyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfIArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfOutlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfRFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfSchemeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfStrikeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfSzArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfUArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public int sizeOfVertAlignArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getBArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty getCharsetArray(int i2) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(PROPERTY_QNAME[1], i2);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTColor getColorArray(int i2) {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(PROPERTY_QNAME[10], i2);
            if (cTColor == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getCondenseArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getExtendArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[9], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTIntProperty getFamilyArray(int i2) {
        CTIntProperty cTIntProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTIntProperty = (CTIntProperty) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTIntProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTIntProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getIArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getOutlineArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontName getRFontArray(int i2) {
        CTFontName cTFontName;
        synchronized (monitor()) {
            check_orphaned();
            cTFontName = (CTFontName) get_store().find_element_user(PROPERTY_QNAME[0], i2);
            if (cTFontName == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontScheme getSchemeArray(int i2) {
        CTFontScheme cTFontScheme;
        synchronized (monitor()) {
            check_orphaned();
            cTFontScheme = (CTFontScheme) get_store().find_element_user(PROPERTY_QNAME[14], i2);
            if (cTFontScheme == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontScheme;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getShadowArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTBooleanProperty getStrikeArray(int i2) {
        CTBooleanProperty cTBooleanProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTBooleanProperty = (CTBooleanProperty) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTBooleanProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTBooleanProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTFontSize getSzArray(int i2) {
        CTFontSize cTFontSize;
        synchronized (monitor()) {
            check_orphaned();
            cTFontSize = (CTFontSize) get_store().find_element_user(PROPERTY_QNAME[11], i2);
            if (cTFontSize == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTFontSize;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTUnderlineProperty getUArray(int i2) {
        CTUnderlineProperty cTUnderlineProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTUnderlineProperty = (CTUnderlineProperty) get_store().find_element_user(PROPERTY_QNAME[12], i2);
            if (cTUnderlineProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTUnderlineProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public CTVerticalAlignFontProperty getVertAlignArray(int i2) {
        CTVerticalAlignFontProperty cTVerticalAlignFontProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTVerticalAlignFontProperty = (CTVerticalAlignFontProperty) get_store().find_element_user(PROPERTY_QNAME[13], i2);
            if (cTVerticalAlignFontProperty == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTVerticalAlignFontProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setBArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCharsetArray(int i2, CTIntProperty cTIntProperty) throws Throwable {
        generatedSetterHelperImpl(cTIntProperty, PROPERTY_QNAME[1], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setColorArray(int i2, CTColor cTColor) throws Throwable {
        generatedSetterHelperImpl(cTColor, PROPERTY_QNAME[10], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setCondenseArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setExtendArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[9], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setFamilyArray(int i2, CTIntProperty cTIntProperty) throws Throwable {
        generatedSetterHelperImpl(cTIntProperty, PROPERTY_QNAME[2], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setIArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setOutlineArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setRFontArray(int i2, CTFontName cTFontName) throws Throwable {
        generatedSetterHelperImpl(cTFontName, PROPERTY_QNAME[0], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSchemeArray(int i2, CTFontScheme cTFontScheme) throws Throwable {
        generatedSetterHelperImpl(cTFontScheme, PROPERTY_QNAME[14], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setShadowArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setStrikeArray(int i2, CTBooleanProperty cTBooleanProperty) throws Throwable {
        generatedSetterHelperImpl(cTBooleanProperty, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setSzArray(int i2, CTFontSize cTFontSize) throws Throwable {
        generatedSetterHelperImpl(cTFontSize, PROPERTY_QNAME[11], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setUArray(int i2, CTUnderlineProperty cTUnderlineProperty) throws Throwable {
        generatedSetterHelperImpl(cTUnderlineProperty, PROPERTY_QNAME[12], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt
    public void setVertAlignArray(int i2, CTVerticalAlignFontProperty cTVerticalAlignFontProperty) throws Throwable {
        generatedSetterHelperImpl(cTVerticalAlignFontProperty, PROPERTY_QNAME[13], i2, (short) 2);
    }
}
