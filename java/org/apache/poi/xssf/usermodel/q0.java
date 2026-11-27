package org.apache.poi.xssf.usermodel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes.dex */
public abstract class q0 implements n.a.a.n.c.e0, n.a.a.n.c.t, n.a.a.n.c.c0 {
    protected final XSSFWorkbook a;
    private Map<String, k2> b;

    protected q0(XSSFWorkbook xSSFWorkbook) {
        this.a = xSSFWorkbook;
    }

    private int s(String str, List<n.a.a.q.b.e> list) {
        Iterator<n.a.a.q.b.e> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().L().equals(str)) {
                return i2 + 1;
            }
            i2++;
        }
        return -1;
    }

    private Map<String, k2> v() {
        Map<String, k2> map = this.b;
        if (map != null) {
            return map;
        }
        this.b = new ConcurrentSkipListMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<n.a.a.n.d.p0> it = this.a.iterator();
        while (it.hasNext()) {
            for (k2 k2Var : ((i2) it.next()).a0()) {
                this.b.put(k2Var.getName(), k2Var);
            }
        }
        return this.b;
    }

    private int w(String str) {
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 2);
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            List<n.a.a.q.b.e> externalLinksTables = this.a.getExternalLinksTables();
            int iS = s(str, externalLinksTables);
            if (iS != -1) {
                return iS;
            }
            if (!str.startsWith("'file:///") || !str.endsWith("'")) {
                throw new IllegalStateException("Book not linked for filename " + str);
            }
            String strSubstring = str.substring(str.lastIndexOf(47) + 1);
            String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 1);
            int iS2 = s(strSubstring2, externalLinksTables);
            if (iS2 != -1) {
                return iS2;
            }
            this.a.addExternalLinksTable(new o0(strSubstring2));
            return externalLinksTables.size();
        }
    }

    @Override // n.a.a.n.c.t, n.a.a.n.c.c0
    public n.a.a.n.c.n a(String str, int i2) {
        for (int i3 = 0; i3 < this.a.getNumberOfNames(); i3++) {
            u1 nameAt = this.a.getNameAt(i3);
            String strD = nameAt.d();
            int iA = nameAt.a();
            if (str.equalsIgnoreCase(strD) && (iA == -1 || iA == i2)) {
                return new p0(nameAt, i3, this);
            }
        }
        if (i2 == -1) {
            return null;
        }
        return a(str, -1);
    }

    @Override // n.a.a.n.c.t, n.a.a.n.c.c0
    public n.a.a.n.a b() {
        return n.a.a.n.a.EXCEL2007;
    }

    @Override // n.a.a.n.c.t
    public String c(int i2) {
        return this.a.getSheetName(i2);
    }

    @Override // n.a.a.n.c.e0
    public String d(n.a.a.n.c.u1.b2 b2Var) {
        return this.a.getNameAt(b2Var.r()).d();
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.q e(String str, String str2, int i2) {
        if (i2 <= 0) {
            return new n.a.a.n.c.q(str, this.a.getNameIndex(str), 0);
        }
        n.a.a.q.b.e externalLinksTable = this.a.getExternalLinksTable(i2 - 1);
        for (n.a.a.n.d.m0 m0Var : externalLinksTable.K()) {
            if (m0Var.d().equals(str)) {
                return new n.a.a.n.c.q(str, -1, m0Var.a() + 1);
            }
        }
        throw new IllegalArgumentException("Name '" + str + "' not found in reference to " + externalLinksTable.L());
    }

    @Override // n.a.a.n.c.t
    public int g(String str) {
        return this.a.getSheetIndex(str);
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.v1.c k() {
        return this.a.getUDFFinder();
    }

    @Override // n.a.a.n.c.c0
    public n.a.a.n.c.u1.k2 m(n.a.a.n.e.s sVar, n.a.a.n.c.b1 b1Var) {
        return b1Var.c() != null ? new n.a.a.n.c.u1.p2(w(b1Var.c()), b1Var, sVar) : new n.a.a.n.c.u1.p2(b1Var, sVar);
    }

    @Override // n.a.a.n.c.c0
    public n.a.a.n.c.u1.k2 n(n.a.a.n.e.k kVar, n.a.a.n.c.b1 b1Var) {
        return b1Var.c() != null ? new n.a.a.n.c.u1.b1(w(b1Var.c()), b1Var, kVar) : new n.a.a.n.c.u1.b1(b1Var, kVar);
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.r o(String str, String str2, int i2) {
        String strL = i2 > 0 ? this.a.getExternalLinksTable(i2 - 1).L() : null;
        return (str2 == null || str.equals(str2)) ? new n.a.a.n.c.r(strL, str) : new n.a.a.n.c.s(strL, str, str2);
    }

    @Override // n.a.a.n.c.t
    public n.a.a.n.c.n p(n.a.a.n.c.u1.b2 b2Var) {
        int iR = b2Var.r();
        return new p0(this.a.getNameAt(iR), iR, this);
    }

    @Override // n.a.a.n.c.c0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public u1 i() {
        return this.a.createName();
    }

    @Override // n.a.a.n.c.c0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public n.a.a.n.c.u1.c2 h(String str, n.a.a.n.c.b1 b1Var) {
        if (((n.a.a.n.c.v1.b) k()).a(str) != null) {
            return new n.a.a.n.c.u1.c2(null, str);
        }
        if (b1Var == null) {
            if (this.a.getNames(str).isEmpty()) {
                return null;
            }
            return new n.a.a.n.c.u1.c2(null, str);
        }
        if (b1Var.d() == null) {
            return new n.a.a.n.c.u1.c2(w(b1Var.c()), null, str);
        }
        String strA = b1Var.d().a();
        return b1Var.c() != null ? new n.a.a.n.c.u1.c2(w(b1Var.c()), strA, str) : new n.a.a.n.c.u1.c2(strA, str);
    }

    @Override // n.a.a.n.c.c0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public k2 f(String str) {
        if (str == null) {
            return null;
        }
        return v().get(str);
    }
}
