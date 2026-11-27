package n.a.a.p.a.a;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;

/* loaded from: classes.dex */
public interface p<T> {
    boolean a();

    T b(int i2);

    default void c(CTNumData cTNumData) {
        String formatCode = getFormatCode();
        if (formatCode != null) {
            cTNumData.setFormatCode(formatCode);
        } else if (cTNumData.isSetFormatCode()) {
            cTNumData.unsetFormatCode();
        }
        cTNumData.setPtArray(null);
        int iE = e();
        int i2 = 0;
        for (int i3 = 0; i3 < iE; i3++) {
            T tB = b(i3);
            if (tB != null) {
                CTNumVal cTNumValAddNewPt = cTNumData.addNewPt();
                cTNumValAddNewPt.setIdx(i3);
                cTNumValAddNewPt.setV(tB.toString());
                i2++;
            }
        }
        if (i2 == 0) {
            if (cTNumData.isSetPtCount()) {
                cTNumData.unsetPtCount();
            }
        } else if (cTNumData.isSetPtCount()) {
            cTNumData.getPtCount().setVal(iE);
        } else {
            cTNumData.addNewPtCount().setVal(iE);
        }
    }

    String d();

    int e();

    default void f(CTStrData cTStrData) {
        cTStrData.setPtArray(null);
        int iE = e();
        int i2 = 0;
        for (int i3 = 0; i3 < iE; i3++) {
            T tB = b(i3);
            if (tB != null) {
                CTStrVal cTStrValAddNewPt = cTStrData.addNewPt();
                cTStrValAddNewPt.setIdx(i3);
                cTStrValAddNewPt.setV(tB.toString());
                i2++;
            }
        }
        if (i2 == 0) {
            if (cTStrData.isSetPtCount()) {
                cTStrData.unsetPtCount();
            }
        } else if (cTStrData.isSetPtCount()) {
            cTStrData.getPtCount().setVal(iE);
        } else {
            cTStrData.addNewPtCount().setVal(iE);
        }
    }

    String getFormatCode();

    boolean isNumeric();
}
