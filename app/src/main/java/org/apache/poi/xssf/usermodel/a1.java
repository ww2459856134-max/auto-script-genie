package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;

/* loaded from: classes.dex */
public class a1 implements n.a.a.n.d.i {
    private int a;
    private final n.a.a.q.b.i b;
    private CTXf c;
    private final CTXf d;

    public a1(int i2, int i3, n.a.a.q.b.i iVar, n.a.a.q.b.l lVar) {
        this.a = i2;
        this.b = iVar;
        this.c = iVar.N(i2);
        this.d = i3 == -1 ? null : iVar.M(i3);
    }

    @Override // n.a.a.n.d.i
    public String a() {
        return new h1(this.b).a(b());
    }

    @Override // n.a.a.n.d.i
    public short b() {
        return (short) this.c.getNumFmtId();
    }

    public CTXf c() {
        return this.c;
    }

    public void d(n.a.a.q.b.i iVar) {
        if (this.b != iVar) {
            throw new IllegalArgumentException("This Style does not belong to the supplied Workbook Styles Source. Are you trying to assign a style from one workbook to the cell of a different workbook?");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a1) {
            return this.c.toString().equals(((a1) obj).c().toString());
        }
        return false;
    }

    public int hashCode() {
        return this.c.toString().hashCode();
    }
}
