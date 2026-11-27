package org.apache.poi.xssf.usermodel;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;

/* loaded from: classes.dex */
public class s1 {
    private final n.a.a.e.a.b a;
    private final n.a.a.k.b.q b;
    private final CTHyperlink c;
    private String d;

    protected s1(CTHyperlink cTHyperlink, n.a.a.k.b.q qVar) {
        this.c = cTHyperlink;
        this.b = qVar;
        if (qVar == null) {
            if (cTHyperlink.getLocation() != null) {
                this.a = n.a.a.e.a.b.DOCUMENT;
                this.d = cTHyperlink.getLocation();
                return;
            } else {
                if (cTHyperlink.getId() == null) {
                    this.a = n.a.a.e.a.b.DOCUMENT;
                    return;
                }
                throw new IllegalStateException("The hyperlink for cell " + cTHyperlink.getRef() + " references relation " + cTHyperlink.getId() + ", but that didn't exist!");
            }
        }
        this.d = qVar.e().toString();
        if (cTHyperlink.getLocation() != null) {
            this.d += "#" + cTHyperlink.getLocation();
        }
        if (this.d.startsWith("http://") || this.d.startsWith("https://") || this.d.startsWith("ftp://")) {
            this.a = n.a.a.e.a.b.URL;
        } else if (this.d.startsWith("mailto:")) {
            this.a = n.a.a.e.a.b.EMAIL;
        } else {
            this.a = n.a.a.e.a.b.FILE;
        }
    }

    protected void a(n.a.a.k.b.m mVar) {
        if (this.b == null && c()) {
            this.c.setId(mVar.b(this.d, c2.C.h()).a());
        }
    }

    public CTHyperlink b() {
        return this.c;
    }

    public boolean c() {
        return this.a != n.a.a.e.a.b.DOCUMENT;
    }
}
