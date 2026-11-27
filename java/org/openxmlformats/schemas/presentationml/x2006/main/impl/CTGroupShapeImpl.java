package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTRel;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* loaded from: classes2.dex */
public class CTGroupShapeImpl extends XmlComplexContentImpl implements CTGroupShape {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGrpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "grpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sp"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "grpSp"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "graphicFrame"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cxnSp"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "pic"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "contentPart"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst")};
    private static final long serialVersionUID = 1;

    public CTGroupShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTRel addNewContentPart() {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTConnector addNewCxnSp() {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModifyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTExtensionListModifyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGraphicalObjectFrame addNewGraphicFrame() {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShape addNewGrpSp() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShapeProperties addNewGrpSpPr() {
        CTGroupShapeProperties cTGroupShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeProperties = (CTGroupShapeProperties) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTGroupShapeProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShapeNonVisual addNewNvGrpSpPr() {
        CTGroupShapeNonVisual cTGroupShapeNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeNonVisual = (CTGroupShapeNonVisual) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGroupShapeNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTPicture addNewPic() {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTShape addNewSp() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTRel[] getContentPartArray() {
        return (CTRel[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTRel[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTRel> getContentPartList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getContentPartArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.v
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setContentPartArray(((Integer) obj).intValue(), (CTRel) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.v1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewContentPart(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.s1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeContentPart(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.r
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfContentPartArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTConnector[] getCxnSpArray() {
        return (CTConnector[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTConnector[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTConnector> getCxnSpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.i2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getCxnSpArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.j0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setCxnSpArray(((Integer) obj).intValue(), (CTConnector) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewCxnSp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.l3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeCxnSp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.s0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfCxnSpArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTExtensionListModify getExtLst() {
        CTExtensionListModify cTExtensionListModifyFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModifyFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTExtensionListModifyFind_element_user == null) {
                cTExtensionListModifyFind_element_user = null;
            }
        }
        return cTExtensionListModifyFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGraphicalObjectFrame[] getGraphicFrameArray() {
        return (CTGraphicalObjectFrame[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTGraphicalObjectFrame[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTGraphicalObjectFrame> getGraphicFrameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.q3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGraphicFrameArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.g0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGraphicFrameArray(((Integer) obj).intValue(), (CTGraphicalObjectFrame) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.n
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGraphicFrame(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.q1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGraphicFrame(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.p2
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGraphicFrameArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShape[] getGrpSpArray() {
        return (CTGroupShape[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTGroupShape[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTGroupShape> getGrpSpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.g2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getGrpSpArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.l1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setGrpSpArray(((Integer) obj).intValue(), (CTGroupShape) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.n1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewGrpSp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.v2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeGrpSp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.w3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfGrpSpArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShapeProperties getGrpSpPr() {
        CTGroupShapeProperties cTGroupShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeProperties = (CTGroupShapeProperties) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTGroupShapeProperties == null) {
                cTGroupShapeProperties = null;
            }
        }
        return cTGroupShapeProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShapeNonVisual getNvGrpSpPr() {
        CTGroupShapeNonVisual cTGroupShapeNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShapeNonVisual = (CTGroupShapeNonVisual) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTGroupShapeNonVisual == null) {
                cTGroupShapeNonVisual = null;
            }
        }
        return cTGroupShapeNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTPicture[] getPicArray() {
        return (CTPicture[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTPicture[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTPicture> getPicList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.p
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getPicArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.m0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setPicArray(((Integer) obj).intValue(), (CTPicture) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.c3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewPic(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.i1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removePic(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.u
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfPicArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTShape[] getSpArray() {
        return (CTShape[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTShape[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public List<CTShape> getSpList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.f3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getSpArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.d0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setSpArray(((Integer) obj).intValue(), (CTShape) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewSp(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.f0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeSp(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.g1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfSpArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTRel insertNewContentPart(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTConnector insertNewCxnSp(int i2) {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGraphicalObjectFrame insertNewGraphicFrame(int i2) {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().insert_element_user(PROPERTY_QNAME[4], i2);
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShape insertNewGrpSp(int i2) {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().insert_element_user(PROPERTY_QNAME[3], i2);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTPicture insertNewPic(int i2) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().insert_element_user(PROPERTY_QNAME[6], i2);
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTShape insertNewSp(int i2) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().insert_element_user(PROPERTY_QNAME[2], i2);
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removeContentPart(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removeCxnSp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removeGraphicFrame(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removeGrpSp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removePic(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void removeSp(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setContentPartArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper(cTRelArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setCxnSpArray(CTConnector[] cTConnectorArr) {
        check_orphaned();
        arraySetterHelper(cTConnectorArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setExtLst(CTExtensionListModify cTExtensionListModify) throws Throwable {
        generatedSetterHelperImpl(cTExtensionListModify, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setGraphicFrameArray(CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr) {
        check_orphaned();
        arraySetterHelper(cTGraphicalObjectFrameArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setGrpSpArray(CTGroupShape[] cTGroupShapeArr) {
        check_orphaned();
        arraySetterHelper(cTGroupShapeArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTGroupShapeProperties, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual) throws Throwable {
        generatedSetterHelperImpl(cTGroupShapeNonVisual, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setPicArray(CTPicture[] cTPictureArr) {
        check_orphaned();
        arraySetterHelper(cTPictureArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setSpArray(CTShape[] cTShapeArr) {
        check_orphaned();
        arraySetterHelper(cTShapeArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfContentPartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfCxnSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfGraphicFrameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfGrpSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfPicArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public int sizeOfSpArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTRel getContentPartArray(int i2) {
        CTRel cTRel;
        synchronized (monitor()) {
            check_orphaned();
            cTRel = (CTRel) get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTRel == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTRel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTConnector getCxnSpArray(int i2) {
        CTConnector cTConnector;
        synchronized (monitor()) {
            check_orphaned();
            cTConnector = (CTConnector) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTConnector == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTConnector;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGraphicalObjectFrame getGraphicFrameArray(int i2) {
        CTGraphicalObjectFrame cTGraphicalObjectFrame;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrame = (CTGraphicalObjectFrame) get_store().find_element_user(PROPERTY_QNAME[4], i2);
            if (cTGraphicalObjectFrame == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGraphicalObjectFrame;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTGroupShape getGrpSpArray(int i2) {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().find_element_user(PROPERTY_QNAME[3], i2);
            if (cTGroupShape == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTPicture getPicArray(int i2) {
        CTPicture cTPicture;
        synchronized (monitor()) {
            check_orphaned();
            cTPicture = (CTPicture) get_store().find_element_user(PROPERTY_QNAME[6], i2);
            if (cTPicture == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTPicture;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public CTShape getSpArray(int i2) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().find_element_user(PROPERTY_QNAME[2], i2);
            if (cTShape == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setContentPartArray(int i2, CTRel cTRel) throws Throwable {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[7], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setCxnSpArray(int i2, CTConnector cTConnector) throws Throwable {
        generatedSetterHelperImpl(cTConnector, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setGraphicFrameArray(int i2, CTGraphicalObjectFrame cTGraphicalObjectFrame) throws Throwable {
        generatedSetterHelperImpl(cTGraphicalObjectFrame, PROPERTY_QNAME[4], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setGrpSpArray(int i2, CTGroupShape cTGroupShape) throws Throwable {
        generatedSetterHelperImpl(cTGroupShape, PROPERTY_QNAME[3], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setPicArray(int i2, CTPicture cTPicture) throws Throwable {
        generatedSetterHelperImpl(cTPicture, PROPERTY_QNAME[6], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape
    public void setSpArray(int i2, CTShape cTShape) throws Throwable {
        generatedSetterHelperImpl(cTShape, PROPERTY_QNAME[2], i2, (short) 2);
    }
}
