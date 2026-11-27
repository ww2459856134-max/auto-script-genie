package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

/* loaded from: classes.dex */
public class p2 {
    private final CTRegularTextRun a;

    p2(CTRegularTextRun cTRegularTextRun, o2 o2Var) {
        this.a = cTRegularTextRun;
    }

    public String a() {
        return this.a.getT();
    }

    public String toString() {
        return "[" + p2.class + "]" + a();
    }
}
