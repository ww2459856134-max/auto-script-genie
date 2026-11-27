package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTrendline;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* loaded from: classes2.dex */
public class CTBubbleSerImpl extends XmlComplexContentImpl implements CTBubbleSer {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "idx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "order"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "invertIfNegative"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dPt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "trendline"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "errBars"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "xVal"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "yVal"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubbleSize"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "bubble3D"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTBubbleSerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTBoolean addNewBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTNumDataSource addNewBubbleSize() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDPt addNewDPt() {
        CTDPt cTDPt;
        synchronized (monitor()) {
            check_orphaned();
            cTDPt = (CTDPt) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDPt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTErrBars addNewErrBars() {
        CTErrBars cTErrBars;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBars = (CTErrBars) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTErrBars;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTUnsignedInt addNewIdx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTBoolean addNewInvertIfNegative() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTUnsignedInt addNewOrder() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTTrendline addNewTrendline() {
        CTTrendline cTTrendlineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTrendlineAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTSerTx addNewTx() {
        CTSerTx cTSerTx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerTx = (CTSerTx) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSerTx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTAxDataSource addNewXVal() {
        CTAxDataSource cTAxDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTAxDataSource = (CTAxDataSource) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAxDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTNumDataSource addNewYVal() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTBoolean getBubble3D() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTNumDataSource getBubbleSize() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTNumDataSource == null) {
                cTNumDataSource = null;
            }
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDLbls getDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTDLbls == null) {
                cTDLbls = null;
            }
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDPt[] getDPtArray() {
        return (CTDPt[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTDPt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public List<CTDPt> getDPtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.o8
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDPtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDPt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDPt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i7
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDPtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTErrBars[] getErrBarsArray() {
        return (CTErrBars[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTErrBars[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public List<CTErrBars> getErrBarsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.g3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getErrBarsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.y0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setErrBarsArray(((Integer) obj).intValue(), (CTErrBars) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.h6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewErrBars(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.s
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeErrBars(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.b1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfErrBarsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTUnsignedInt getIdx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTUnsignedInt == null) {
                cTUnsignedInt = null;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTBoolean getInvertIfNegative() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTUnsignedInt getOrder() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTUnsignedInt == null) {
                cTUnsignedInt = null;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTShapeProperties getSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTShapeProperties == null) {
                cTShapeProperties = null;
            }
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTTrendline[] getTrendlineArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTTrendline[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public List<CTTrendline> getTrendlineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.eb
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTrendlineArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.r7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTrendlineArray(((Integer) obj).intValue(), (CTTrendline) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.f2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTrendline(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.u8
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTrendline(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q8
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTrendlineArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTSerTx getTx() {
        CTSerTx cTSerTx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerTx = (CTSerTx) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTSerTx == null) {
                cTSerTx = null;
            }
        }
        return cTSerTx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTAxDataSource getXVal() {
        CTAxDataSource cTAxDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTAxDataSource = (CTAxDataSource) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTAxDataSource == null) {
                cTAxDataSource = null;
            }
        }
        return cTAxDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTNumDataSource getYVal() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTNumDataSource == null) {
                cTNumDataSource = null;
            }
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDPt insertNewDPt(int i2) {
        CTDPt cTDPt;
        synchronized (monitor()) {
            check_orphaned();
            cTDPt = (CTDPt) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTDPt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTErrBars insertNewErrBars(int i2) {
        CTErrBars cTErrBars;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBars = (CTErrBars) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTErrBars;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTTrendline insertNewTrendline(int i2) {
        CTTrendline cTTrendlineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTTrendlineInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetBubble3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetBubbleSize() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetInvertIfNegative() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetXVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public boolean isSetYVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void removeDPt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void removeErrBars(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void removeTrendline(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setBubble3D(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setBubbleSize(CTNumDataSource cTNumDataSource) throws Throwable {
        generatedSetterHelperImpl(cTNumDataSource, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setDPtArray(CTDPt[] cTDPtArr) {
        check_orphaned();
        arraySetterHelper(cTDPtArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setErrBarsArray(CTErrBars[] cTErrBarsArr) {
        check_orphaned();
        arraySetterHelper(cTErrBarsArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setIdx(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setInvertIfNegative(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setOrder(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setTrendlineArray(CTTrendline[] cTTrendlineArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTrendlineArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setTx(CTSerTx cTSerTx) throws Throwable {
        generatedSetterHelperImpl(cTSerTx, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setXVal(CTAxDataSource cTAxDataSource) throws Throwable {
        generatedSetterHelperImpl(cTAxDataSource, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setYVal(CTNumDataSource cTNumDataSource) throws Throwable {
        generatedSetterHelperImpl(cTNumDataSource, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public int sizeOfDPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public int sizeOfErrBarsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public int sizeOfTrendlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetBubble3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetBubbleSize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetInvertIfNegative() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetXVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void unsetYVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTDPt getDPtArray(int i2) {
        CTDPt cTDPt;
        synchronized (monitor()) {
            check_orphaned();
            cTDPt = (CTDPt) get_store().find_element_user(PROPERTY_QNAME[5], i2);
            if (cTDPt == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTDPt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTErrBars getErrBarsArray(int i2) {
        CTErrBars cTErrBars;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBars = (CTErrBars) get_store().find_element_user(PROPERTY_QNAME[8], i2);
            if (cTErrBars == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTErrBars;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public CTTrendline getTrendlineArray(int i2) {
        CTTrendline cTTrendlineFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], i2);
            if (cTTrendlineFind_element_user == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return cTTrendlineFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setDPtArray(int i2, CTDPt cTDPt) throws Throwable {
        generatedSetterHelperImpl(cTDPt, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setErrBarsArray(int i2, CTErrBars cTErrBars) throws Throwable {
        generatedSetterHelperImpl(cTErrBars, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleSer
    public void setTrendlineArray(int i2, CTTrendline cTTrendline) throws Throwable {
        generatedSetterHelperImpl(cTTrendline, PROPERTY_QNAME[7], i2, (short) 2);
    }
}
