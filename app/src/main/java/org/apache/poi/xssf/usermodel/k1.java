package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;

/* loaded from: classes.dex */
public class k1 {
    public k1(CTDxf cTDxf, int i2, u0 u0Var) {
        if (cTDxf == null) {
            return;
        }
        if (cTDxf.isSetBorder()) {
            cTDxf.getBorder();
        }
        if (cTDxf.isSetFont()) {
            cTDxf.getFont();
        }
        if (cTDxf.isSetNumFmt()) {
            CTNumFmt numFmt = cTDxf.getNumFmt();
            numFmt.getNumFmtId();
            numFmt.getFormatCode();
        }
        if (cTDxf.isSetFill()) {
            cTDxf.getFill();
        }
    }
}
