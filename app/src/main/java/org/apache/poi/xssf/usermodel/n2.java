package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

/* loaded from: classes.dex */
public class n2 implements n.a.a.n.d.t0 {
    private final CTTableStyleInfo a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    public n2(n.a.a.q.b.i iVar, CTTableStyleInfo cTTableStyleInfo) {
        this.b = cTTableStyleInfo.getShowColumnStripes();
        this.c = cTTableStyleInfo.getShowRowStripes();
        this.d = cTTableStyleInfo.getShowFirstColumn();
        this.e = cTTableStyleInfo.getShowLastColumn();
        iVar.T(cTTableStyleInfo.getName());
        this.a = cTTableStyleInfo;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.d = z;
        this.a.setShowFirstColumn(z);
    }

    public void f(boolean z) {
        this.e = z;
        this.a.setShowLastColumn(z);
    }

    public void g(boolean z) {
        this.b = z;
        this.a.setShowColumnStripes(z);
    }

    public void h(boolean z) {
        this.c = z;
        this.a.setShowRowStripes(z);
    }
}
