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
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTMarker;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTrendline;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* loaded from: classes2.dex */
public class CTScatterSerImpl extends XmlComplexContentImpl implements CTScatterSer {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "idx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "order"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "tx"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "spPr"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "marker"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dPt"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "dLbls"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "trendline"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "errBars"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "xVal"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "yVal"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "smooth"), new QName("http://schemas.openxmlformats.org/drawingml/2006/chart", "extLst")};
    private static final long serialVersionUID = 1;

    public CTScatterSerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTDLbls addNewDLbls() {
        CTDLbls cTDLbls;
        synchronized (monitor()) {
            check_orphaned();
            cTDLbls = (CTDLbls) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTDLbls;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTDPt addNewDPt() {
        CTDPt cTDPt;
        synchronized (monitor()) {
            check_orphaned();
            cTDPt = (CTDPt) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTDPt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTErrBars addNewErrBars() {
        CTErrBars cTErrBars;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBars = (CTErrBars) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTErrBars;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTUnsignedInt addNewIdx() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTMarker addNewMarker() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTUnsignedInt addNewOrder() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTBoolean addNewSmooth() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTTrendline addNewTrendline() {
        CTTrendline cTTrendlineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTrendlineAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTSerTx addNewTx() {
        CTSerTx cTSerTx;
        synchronized (monitor()) {
            check_orphaned();
            cTSerTx = (CTSerTx) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSerTx;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTAxDataSource addNewXVal() {
        CTAxDataSource cTAxDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTAxDataSource = (CTAxDataSource) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAxDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTNumDataSource addNewYVal() {
        CTNumDataSource cTNumDataSource;
        synchronized (monitor()) {
            check_orphaned();
            cTNumDataSource = (CTNumDataSource) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTNumDataSource;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTDPt[] getDPtArray() {
        return (CTDPt[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTDPt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public List<CTDPt> getDPtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q9
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getDPtArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.q1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.i6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewDPt(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.ja
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeDPt(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfDPtArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTErrBars[] getErrBarsArray() {
        return (CTErrBars[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTErrBars[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public List<CTErrBars> getErrBarsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.d4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getErrBarsArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.tb
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setErrBarsArray(((Integer) obj).intValue(), (CTErrBars) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.p5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewErrBars(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.v9
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeErrBars(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.n9
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfErrBarsArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTExtensionList getExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTExtensionList == null) {
                cTExtensionList = null;
            }
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTMarker getMarker() {
        CTMarker cTMarker;
        synchronized (monitor()) {
            check_orphaned();
            cTMarker = (CTMarker) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTMarker == null) {
                cTMarker = null;
            }
        }
        return cTMarker;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTBoolean getSmooth() {
        CTBoolean cTBoolean;
        synchronized (monitor()) {
            check_orphaned();
            cTBoolean = (CTBoolean) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTBoolean == null) {
                cTBoolean = null;
            }
        }
        return cTBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTTrendline[] getTrendlineArray() {
        return getXmlObjectArray(PROPERTY_QNAME[7], (XmlObject[]) new CTTrendline[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public List<CTTrendline> getTrendlineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.getTrendlineArray(((Integer) obj).intValue());
                }
            }, new BiConsumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.k9
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) throws Throwable {
                    this.a.setTrendlineArray(((Integer) obj).intValue(), (CTTrendline) obj2);
                }
            }, new Function() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.e2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.a.insertNewTrendline(((Integer) obj).intValue());
                }
            }, new Consumer() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.t
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.removeTrendline(((Integer) obj).intValue());
                }
            }, new Supplier() { // from class: org.openxmlformats.schemas.drawingml.x2006.chart.impl.m1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return Integer.valueOf(this.a.sizeOfTrendlineArray());
                }
            });
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTDPt insertNewDPt(int i2) {
        CTDPt cTDPt;
        synchronized (monitor()) {
            check_orphaned();
            cTDPt = (CTDPt) get_store().insert_element_user(PROPERTY_QNAME[5], i2);
        }
        return cTDPt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTErrBars insertNewErrBars(int i2) {
        CTErrBars cTErrBars;
        synchronized (monitor()) {
            check_orphaned();
            cTErrBars = (CTErrBars) get_store().insert_element_user(PROPERTY_QNAME[8], i2);
        }
        return cTErrBars;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public CTTrendline insertNewTrendline(int i2) {
        CTTrendline cTTrendlineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTrendlineInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[7], i2);
        }
        return cTTrendlineInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetDLbls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetMarker() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetSmooth() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetSpPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetTx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetXVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public boolean isSetYVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void removeDPt(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void removeErrBars(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void removeTrendline(int i2) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setDLbls(CTDLbls cTDLbls) throws Throwable {
        generatedSetterHelperImpl(cTDLbls, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setDPtArray(CTDPt[] cTDPtArr) {
        check_orphaned();
        arraySetterHelper(cTDPtArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setErrBarsArray(CTErrBars[] cTErrBarsArr) {
        check_orphaned();
        arraySetterHelper(cTErrBarsArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setExtLst(CTExtensionList cTExtensionList) throws Throwable {
        generatedSetterHelperImpl(cTExtensionList, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setIdx(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setMarker(CTMarker cTMarker) throws Throwable {
        generatedSetterHelperImpl(cTMarker, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setOrder(CTUnsignedInt cTUnsignedInt) throws Throwable {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setSmooth(CTBoolean cTBoolean) throws Throwable {
        generatedSetterHelperImpl(cTBoolean, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setSpPr(CTShapeProperties cTShapeProperties) throws Throwable {
        generatedSetterHelperImpl(cTShapeProperties, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setTrendlineArray(CTTrendline[] cTTrendlineArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTrendlineArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setTx(CTSerTx cTSerTx) throws Throwable {
        generatedSetterHelperImpl(cTSerTx, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setXVal(CTAxDataSource cTAxDataSource) throws Throwable {
        generatedSetterHelperImpl(cTAxDataSource, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setYVal(CTNumDataSource cTNumDataSource) throws Throwable {
        generatedSetterHelperImpl(cTNumDataSource, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public int sizeOfDPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public int sizeOfErrBarsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public int sizeOfTrendlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetDLbls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetMarker() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetSmooth() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetSpPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetXVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void unsetYVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setDPtArray(int i2, CTDPt cTDPt) throws Throwable {
        generatedSetterHelperImpl(cTDPt, PROPERTY_QNAME[5], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setErrBarsArray(int i2, CTErrBars cTErrBars) throws Throwable {
        generatedSetterHelperImpl(cTErrBars, PROPERTY_QNAME[8], i2, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterSer
    public void setTrendlineArray(int i2, CTTrendline cTTrendline) throws Throwable {
        generatedSetterHelperImpl(cTTrendline, PROPERTY_QNAME[7], i2, (short) 2);
    }
}
