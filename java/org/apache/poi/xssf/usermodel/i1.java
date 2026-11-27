package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* loaded from: classes.dex */
public class i1 extends i2 implements n.a.a.n.d.p0 {
    protected CTDialogsheet C;

    protected i1(i2 i2Var) {
        super(i2Var.getPackagePart());
        this.C = CTDialogsheet.Factory.newInstance();
        this.d = CTWorksheet.Factory.newInstance();
    }

    @Override // org.apache.poi.xssf.usermodel.i2, n.a.a.n.d.p0
    /* renamed from: K */
    public f2 B(int i2) {
        return null;
    }
}
