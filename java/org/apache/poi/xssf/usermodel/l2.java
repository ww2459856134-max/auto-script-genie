package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;

/* loaded from: classes.dex */
public class l2 {
    private final CTTableColumn a;

    protected l2(k2 k2Var, CTTableColumn cTTableColumn) {
        this.a = cTTableColumn;
    }

    public long a() {
        return this.a.getId();
    }

    public String b() {
        return this.a.getName();
    }
}
