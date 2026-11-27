package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSupplementalFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;

/* loaded from: classes2.dex */
public class CTFontCollectionImpl extends XmlComplexContentImpl implements CTFontCollection {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "latin"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "ea"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "cs"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "font"), new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTFontCollectionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewCs() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewEa() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont addNewFont() {
        CTSupplementalFont cTSupplementalFontAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTSupplementalFontAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont addNewLatin() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getCs() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTextFont == null) {
                cTTextFont = null;
            }
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getEa() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTextFont == null) {
                cTTextFont = null;
            }
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont[] getFontArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTSupplementalFont[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public List<CTSupplementalFont> getFontList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.xt
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getFontArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.l9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setFontArray(((Integer) obj).intValue(), (CTSupplementalFont) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.j00
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewFont(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.hm
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeFont(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.t9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfFontArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTTextFont getLatin() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextFont == null) {
                cTTextFont = null;
            }
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont insertNewFont(int i2) {
        CTSupplementalFont cTSupplementalFontInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTSupplementalFontInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void removeFont(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setCs(CTTextFont cTTextFont) throws Throwable {
        generatedSetterHelperImpl(cTTextFont, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setEa(CTTextFont cTTextFont) throws Throwable {
        generatedSetterHelperImpl(cTTextFont, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setFontArray(CTSupplementalFont[] cTSupplementalFontArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSupplementalFontArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setLatin(CTTextFont cTTextFont) throws Throwable {
        generatedSetterHelperImpl(cTTextFont, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public int sizeOfFontArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public CTSupplementalFont getFontArray(int i2) {
        CTSupplementalFont cTSupplementalFontFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSupplementalFontFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTSupplementalFontFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTSupplementalFontFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection
    public void setFontArray(int i2, CTSupplementalFont cTSupplementalFont) throws Throwable {
        generatedSetterHelperImpl(cTSupplementalFont, PROPERTY_QNAME[3], i2, (short) 2);
    }
}
