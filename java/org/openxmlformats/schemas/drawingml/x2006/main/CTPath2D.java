package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathFillMode;

/* loaded from: classes2.dex */
public interface CTPath2D extends XmlObject {
    public static final DocumentFactory<CTPath2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPath2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpath2d73d2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPath2DArcTo addNewArcTo();

    CTPath2DClose addNewClose();

    CTPath2DCubicBezierTo addNewCubicBezTo();

    CTPath2DLineTo addNewLnTo();

    CTPath2DMoveTo addNewMoveTo();

    CTPath2DQuadBezierTo addNewQuadBezTo();

    CTPath2DArcTo getArcToArray(int i2);

    CTPath2DArcTo[] getArcToArray();

    List<CTPath2DArcTo> getArcToList();

    CTPath2DClose getCloseArray(int i2);

    CTPath2DClose[] getCloseArray();

    List<CTPath2DClose> getCloseList();

    CTPath2DCubicBezierTo getCubicBezToArray(int i2);

    CTPath2DCubicBezierTo[] getCubicBezToArray();

    List<CTPath2DCubicBezierTo> getCubicBezToList();

    boolean getExtrusionOk();

    STPathFillMode.Enum getFill();

    long getH();

    CTPath2DLineTo getLnToArray(int i2);

    CTPath2DLineTo[] getLnToArray();

    List<CTPath2DLineTo> getLnToList();

    CTPath2DMoveTo getMoveToArray(int i2);

    CTPath2DMoveTo[] getMoveToArray();

    List<CTPath2DMoveTo> getMoveToList();

    CTPath2DQuadBezierTo getQuadBezToArray(int i2);

    CTPath2DQuadBezierTo[] getQuadBezToArray();

    List<CTPath2DQuadBezierTo> getQuadBezToList();

    boolean getStroke();

    long getW();

    CTPath2DArcTo insertNewArcTo(int i2);

    CTPath2DClose insertNewClose(int i2);

    CTPath2DCubicBezierTo insertNewCubicBezTo(int i2);

    CTPath2DLineTo insertNewLnTo(int i2);

    CTPath2DMoveTo insertNewMoveTo(int i2);

    CTPath2DQuadBezierTo insertNewQuadBezTo(int i2);

    boolean isSetExtrusionOk();

    boolean isSetFill();

    boolean isSetH();

    boolean isSetStroke();

    boolean isSetW();

    void removeArcTo(int i2);

    void removeClose(int i2);

    void removeCubicBezTo(int i2);

    void removeLnTo(int i2);

    void removeMoveTo(int i2);

    void removeQuadBezTo(int i2);

    void setArcToArray(int i2, CTPath2DArcTo cTPath2DArcTo);

    void setArcToArray(CTPath2DArcTo[] cTPath2DArcToArr);

    void setCloseArray(int i2, CTPath2DClose cTPath2DClose);

    void setCloseArray(CTPath2DClose[] cTPath2DCloseArr);

    void setCubicBezToArray(int i2, CTPath2DCubicBezierTo cTPath2DCubicBezierTo);

    void setCubicBezToArray(CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr);

    void setExtrusionOk(boolean z);

    void setFill(STPathFillMode.Enum r1);

    void setH(long j2);

    void setLnToArray(int i2, CTPath2DLineTo cTPath2DLineTo);

    void setLnToArray(CTPath2DLineTo[] cTPath2DLineToArr);

    void setMoveToArray(int i2, CTPath2DMoveTo cTPath2DMoveTo);

    void setMoveToArray(CTPath2DMoveTo[] cTPath2DMoveToArr);

    void setQuadBezToArray(int i2, CTPath2DQuadBezierTo cTPath2DQuadBezierTo);

    void setQuadBezToArray(CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr);

    void setStroke(boolean z);

    void setW(long j2);

    int sizeOfArcToArray();

    int sizeOfCloseArray();

    int sizeOfCubicBezToArray();

    int sizeOfLnToArray();

    int sizeOfMoveToArray();

    int sizeOfQuadBezToArray();

    void unsetExtrusionOk();

    void unsetFill();

    void unsetH();

    void unsetStroke();

    void unsetW();

    XmlBoolean xgetExtrusionOk();

    STPathFillMode xgetFill();

    STPositiveCoordinate xgetH();

    XmlBoolean xgetStroke();

    STPositiveCoordinate xgetW();

    void xsetExtrusionOk(XmlBoolean xmlBoolean);

    void xsetFill(STPathFillMode sTPathFillMode);

    void xsetH(STPositiveCoordinate sTPositiveCoordinate);

    void xsetStroke(XmlBoolean xmlBoolean);

    void xsetW(STPositiveCoordinate sTPositiveCoordinate);
}
