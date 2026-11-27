package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* loaded from: classes2.dex */
public interface CTAreaSer extends XmlObject {
    public static final DocumentFactory<CTAreaSer> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAreaSer> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctareaser4f73type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAxDataSource addNewCat();

    CTDLbls addNewDLbls();

    CTDPt addNewDPt();

    CTErrBars addNewErrBars();

    CTExtensionList addNewExtLst();

    CTUnsignedInt addNewIdx();

    CTUnsignedInt addNewOrder();

    CTPictureOptions addNewPictureOptions();

    CTShapeProperties addNewSpPr();

    CTTrendline addNewTrendline();

    CTSerTx addNewTx();

    CTNumDataSource addNewVal();

    CTAxDataSource getCat();

    CTDLbls getDLbls();

    CTDPt getDPtArray(int i2);

    CTDPt[] getDPtArray();

    List<CTDPt> getDPtList();

    CTErrBars getErrBarsArray(int i2);

    CTErrBars[] getErrBarsArray();

    List<CTErrBars> getErrBarsList();

    CTExtensionList getExtLst();

    CTUnsignedInt getIdx();

    CTUnsignedInt getOrder();

    CTPictureOptions getPictureOptions();

    CTShapeProperties getSpPr();

    CTTrendline getTrendlineArray(int i2);

    CTTrendline[] getTrendlineArray();

    List<CTTrendline> getTrendlineList();

    CTSerTx getTx();

    CTNumDataSource getVal();

    CTDPt insertNewDPt(int i2);

    CTErrBars insertNewErrBars(int i2);

    CTTrendline insertNewTrendline(int i2);

    boolean isSetCat();

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetPictureOptions();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetVal();

    void removeDPt(int i2);

    void removeErrBars(int i2);

    void removeTrendline(int i2);

    void setCat(CTAxDataSource cTAxDataSource);

    void setDLbls(CTDLbls cTDLbls);

    void setDPtArray(int i2, CTDPt cTDPt);

    void setDPtArray(CTDPt[] cTDPtArr);

    void setErrBarsArray(int i2, CTErrBars cTErrBars);

    void setErrBarsArray(CTErrBars[] cTErrBarsArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIdx(CTUnsignedInt cTUnsignedInt);

    void setOrder(CTUnsignedInt cTUnsignedInt);

    void setPictureOptions(CTPictureOptions cTPictureOptions);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTrendlineArray(int i2, CTTrendline cTTrendline);

    void setTrendlineArray(CTTrendline[] cTTrendlineArr);

    void setTx(CTSerTx cTSerTx);

    void setVal(CTNumDataSource cTNumDataSource);

    int sizeOfDPtArray();

    int sizeOfErrBarsArray();

    int sizeOfTrendlineArray();

    void unsetCat();

    void unsetDLbls();

    void unsetExtLst();

    void unsetPictureOptions();

    void unsetSpPr();

    void unsetTx();

    void unsetVal();
}
