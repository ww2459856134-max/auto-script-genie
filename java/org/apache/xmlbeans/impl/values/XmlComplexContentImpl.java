package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;

/* loaded from: classes2.dex */
public class XmlComplexContentImpl extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchemaTypeImpl _schemaType;

    public XmlComplexContentImpl(SchemaType schemaType) {
        this._schemaType = (SchemaTypeImpl) schemaType;
        initComplexType(true, true);
    }

    static /* synthetic */ void b(SimpleValue[] simpleValueArr, XmlObjectBase xmlObjectBase, Integer num) {
        simpleValueArr[num.intValue()] = xmlObjectBase;
    }

    private <T> void commonSetterHelper(QName qName, QNameSet qNameSet, T[] tArr, BiConsumer<XmlObjectBase, Integer> biConsumer) {
        commonSetterHelper(qName, qNameSet, tArr == null ? 0 : tArr.length, biConsumer);
    }

    private <T> void commonSetterHelper2(QName qName, QNameSet qNameSet, T[] tArr, BiConsumer<XmlObjectBase, T> biConsumer) {
        int i2 = 0;
        int length = tArr == null ? 0 : tArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, iCount_elements - 1);
            } else {
                typeStore.remove_element(qNameSet, iCount_elements - 1);
            }
            iCount_elements--;
        }
        while (i2 < length) {
            biConsumer.accept((XmlObjectBase) (i2 >= iCount_elements ? typeStore.add_element_user(qName) : qNameSet == null ? typeStore.find_element_user(qName, i2) : typeStore.find_element_user(qNameSet, i2)), tArr[i2]);
            i2++;
        }
    }

    static /* synthetic */ void e(SimpleValue[] simpleValueArr, XmlObjectBase xmlObjectBase, Integer num) {
        simpleValueArr[num.intValue()] = xmlObjectBase;
    }

    protected SimpleValue[] arraySetterHelper(int i2, QName qName) {
        final SimpleValue[] simpleValueArr = new SimpleValue[i2];
        commonSetterHelper(qName, (QNameSet) null, simpleValueArr, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.s
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                XmlComplexContentImpl.b(simpleValueArr, (XmlObjectBase) obj, (Integer) obj2);
            }
        });
        return simpleValueArr;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._schemaType.equals(xmlObject.schemaType());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        return super.get_default_attribute_text(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        return schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        return new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected final void set_String(String str) {
        if (this._schemaType.getContentType() == 4 || this._schemaType.isNoType()) {
            super.set_String(str);
            return;
        }
        throw new IllegalArgumentException("Type does not allow for textual content: " + this._schemaType);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
    }

    protected void unionArraySetterHelper(Object[] objArr, QName qName) {
        commonSetterHelper2(qName, null, objArr, f.a);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected void update_from_complex_content() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    protected int value_hash_code() {
        throw new IllegalStateException("Complex types cannot be used as hash keys");
    }

    private void commonSetterHelper(QName qName, QNameSet qNameSet, int i2, BiConsumer<XmlObjectBase, Integer> biConsumer) {
        TypeStore typeStore = get_store();
        int iCount_elements = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
        while (iCount_elements > i2) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, iCount_elements - 1);
            } else {
                typeStore.remove_element(qNameSet, iCount_elements - 1);
            }
            iCount_elements--;
        }
        int i3 = 0;
        while (i3 < i2) {
            biConsumer.accept((XmlObjectBase) (i3 >= iCount_elements ? typeStore.add_element_user(qName) : qNameSet == null ? typeStore.find_element_user(qName, i3) : typeStore.find_element_user(qNameSet, i3)), Integer.valueOf(i3));
            i3++;
        }
    }

    protected void unionArraySetterHelper(Object[] objArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, objArr, f.a);
    }

    protected SimpleValue[] arraySetterHelper(int i2, QName qName, QNameSet qNameSet) {
        final SimpleValue[] simpleValueArr = new SimpleValue[i2];
        commonSetterHelper(qName, qNameSet, simpleValueArr, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.h
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                XmlComplexContentImpl.e(simpleValueArr, (XmlObjectBase) obj, (Integer) obj2);
            }
        });
        return simpleValueArr;
    }

    protected void arraySetterHelper(final boolean[] zArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, zArr == null ? 0 : zArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.k
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setBooleanValue(zArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final float[] fArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, fArr == null ? 0 : fArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.i
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setFloatValue(fArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final double[] dArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, dArr == null ? 0 : dArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.q
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setDoubleValue(dArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final byte[] bArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, bArr == null ? 0 : bArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.r
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setByteValue(bArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final short[] sArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, sArr == null ? 0 : sArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.n
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setShortValue(sArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final int[] iArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, iArr == null ? 0 : iArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.m
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setIntValue(iArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final long[] jArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, jArr == null ? 0 : jArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.t
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setLongValue(jArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName) {
        commonSetterHelper2(qName, null, bigDecimalArr, a.a);
    }

    protected void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName) {
        commonSetterHelper2(qName, null, bigIntegerArr, f0.a);
    }

    protected void arraySetterHelper(String[] strArr, QName qName) {
        commonSetterHelper2(qName, null, strArr, g0.a);
    }

    protected void arraySetterHelper(byte[][] bArr, QName qName) {
        commonSetterHelper2(qName, null, bArr, g.a);
    }

    protected void arraySetterHelper(GDate[] gDateArr, QName qName) {
        commonSetterHelper2(qName, null, gDateArr, b0.a);
    }

    protected void arraySetterHelper(GDuration[] gDurationArr, QName qName) {
        commonSetterHelper2(qName, null, gDurationArr, e0.a);
    }

    protected void arraySetterHelper(Calendar[] calendarArr, QName qName) {
        commonSetterHelper2(qName, null, calendarArr, b.a);
    }

    protected void arraySetterHelper(Date[] dateArr, QName qName) {
        commonSetterHelper2(qName, null, dateArr, d.a);
    }

    protected void arraySetterHelper(QName[] qNameArr, QName qName) {
        commonSetterHelper2(qName, null, qNameArr, j0.a);
    }

    protected void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName) {
        commonSetterHelper2(qName, null, stringEnumAbstractBaseArr, h0.a);
    }

    protected void arraySetterHelper(List<?>[] listArr, QName qName) {
        commonSetterHelper2(qName, null, listArr, e.a);
    }

    protected void arraySetterHelper(final boolean[] zArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, zArr == null ? 0 : zArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.v
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setBooleanValue(zArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final float[] fArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, fArr == null ? 0 : fArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.j
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setFloatValue(fArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final double[] dArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, dArr == null ? 0 : dArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.p
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setDoubleValue(dArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final byte[] bArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, bArr == null ? 0 : bArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.w
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setByteValue(bArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final short[] sArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, sArr == null ? 0 : sArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.u
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setShortValue(sArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final int[] iArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, iArr == null ? 0 : iArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setIntValue(iArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(final long[] jArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, jArr == null ? 0 : jArr.length, new BiConsumer() { // from class: org.apache.xmlbeans.impl.values.l
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((XmlObjectBase) obj).setLongValue(jArr[((Integer) obj2).intValue()]);
            }
        });
    }

    protected void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bigDecimalArr, a.a);
    }

    protected void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bigIntegerArr, f0.a);
    }

    protected void arraySetterHelper(String[] strArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, strArr, g0.a);
    }

    protected void arraySetterHelper(byte[][] bArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bArr, g.a);
    }

    protected void arraySetterHelper(GDate[] gDateArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, gDateArr, b0.a);
    }

    protected void arraySetterHelper(GDuration[] gDurationArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, gDurationArr, e0.a);
    }

    protected void arraySetterHelper(Calendar[] calendarArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, calendarArr, b.a);
    }

    protected void arraySetterHelper(Date[] dateArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, dateArr, d.a);
    }

    protected void arraySetterHelper(QName[] qNameArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, qNameArr, j0.a);
    }

    protected void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, stringEnumAbstractBaseArr, h0.a);
    }

    protected void arraySetterHelper(List<?>[] listArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, listArr, e.a);
    }

    protected void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName) {
        arraySetterHelper(xmlObjectArr, qName, (QNameSet) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName, QNameSet qNameSet) throws Throwable {
        int i2;
        int iCount_elements;
        int i3;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i4 = 0;
        if (xmlObjectArr != null && xmlObjectArr.length != 0) {
            int iCount_elements2 = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
            int i5 = 0;
            while (true) {
                if (i5 >= xmlObjectArr.length) {
                    break;
                }
                if (!xmlObjectArr[i5].isImmutable()) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArr[i5].newCursor();
                    try {
                        if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                            if (xmlCursorNewCursor != null) {
                                xmlCursorNewCursor.close();
                            }
                        } else if (xmlCursorNewCursor != null) {
                            xmlCursorNewCursor.close();
                        }
                    } finally {
                    }
                }
                i5++;
            }
            if (i5 >= xmlObjectArr.length) {
                i2 = i5;
                iCount_elements = iCount_elements2;
                i3 = 0;
            } else if ((qNameSet == null ? typeStore.find_element_user(qName, 0) : typeStore.find_element_user(qNameSet, 0)) == xmlObjectArr[i5]) {
                while (i4 < i5) {
                    ((XmlObjectBase) (qNameSet == null ? typeStore.insert_element_user(qName, i4) : typeStore.insert_element_user(qNameSet, qName, i4))).set(xmlObjectArr[i4]);
                    i4++;
                }
                i3 = i4 + 1;
                i4 = i5 + 1;
                while (i4 < xmlObjectArr.length) {
                    XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i4].isImmutable() ? null : xmlObjectArr[i4].newCursor();
                    if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                        xmlCursorNewCursor2.close();
                        if ((qNameSet == null ? typeStore.find_element_user(qName, i3) : typeStore.find_element_user(qNameSet, i3)) != xmlObjectArr[i4]) {
                            break;
                        }
                    } else {
                        if (xmlCursorNewCursor2 != null) {
                            xmlCursorNewCursor2.close();
                        }
                        ((XmlObjectBase) (qNameSet == null ? typeStore.insert_element_user(qName, i3) : typeStore.insert_element_user(qNameSet, qName, i3))).set(xmlObjectArr[i4]);
                    }
                    i4++;
                    i3++;
                }
                iCount_elements = typeStore.count_elements(qName);
                i2 = i4;
            }
            for (int i6 = i2; i6 < xmlObjectArr.length; i6++) {
                ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i6]);
            }
            while (iCount_elements > (i2 - i4) + i3) {
                if (qNameSet == null) {
                    typeStore.remove_element(qName, iCount_elements - 1);
                } else {
                    typeStore.remove_element(qNameSet, iCount_elements - 1);
                }
                iCount_elements--;
            }
            while (i4 < i2) {
                if (i3 >= iCount_elements) {
                    typeStoreUserFind_element_user = typeStore.add_element_user(qName);
                } else if (qNameSet == null) {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qName, i3);
                } else {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i3);
                }
                ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i4]);
                i4++;
                i3++;
            }
            return;
        }
        for (int iCount_elements3 = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet); iCount_elements3 > 0; iCount_elements3--) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, 0);
            } else {
                typeStore.remove_element(qNameSet, 0);
            }
        }
    }
}
