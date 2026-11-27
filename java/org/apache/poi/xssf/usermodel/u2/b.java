package org.apache.poi.xssf.usermodel.u2;

import java.util.Iterator;
import n.a.a.n.c.b0;
import n.a.a.n.c.d0;
import n.a.a.n.c.f0;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.l2;
import n.a.a.n.c.u1.m2;
import n.a.a.n.d.e;
import n.a.a.n.d.j;
import n.a.a.n.d.o0;
import n.a.a.n.d.p0;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.b1;
import org.apache.poi.xssf.usermodel.j1;
import org.apache.poi.xssf.usermodel.o1;
import org.apache.poi.xssf.usermodel.u1;
import org.apache.poi.xssf.usermodel.z0;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public final class b {
    private final XSSFWorkbook a;
    private final o1 b;

    public b(XSSFWorkbook xSSFWorkbook) {
        this.a = xSSFWorkbook;
        this.b = o1.x(xSSFWorkbook);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Node node, String str, String str2) throws DOMException {
        String nodeValue = node.getNodeValue();
        if (nodeValue != null) {
            if (!nodeValue.contains(str + "!")) {
                if (nodeValue.contains(str + "'!")) {
                    u1 u1VarCreateName = this.a.createName();
                    u1VarCreateName.i(nodeValue);
                    c(u1VarCreateName, str, str2);
                    node.setNodeValue(u1VarCreateName.g());
                    this.a.removeName(u1VarCreateName);
                }
            }
        }
        NodeList childNodes = node.getChildNodes();
        for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
            a(childNodes.item(i2), str, str2);
        }
    }

    private void b(z0 z0Var, String str, String str2) {
        String stringValue;
        CTCellFormula f = z0Var.O().getF();
        if (f == null || (stringValue = f.getStringValue()) == null || stringValue.length() <= 0) {
            return;
        }
        k2[] k2VarArrI = b0.I(stringValue, this.b, f0.CELL, this.a.getSheetIndex(z0Var.getSheet()), z0Var.g());
        for (k2 k2Var : k2VarArrI) {
            d(k2Var, str, str2);
        }
        String strB = d0.b(this.b, k2VarArrI);
        if (stringValue.equals(strB)) {
            return;
        }
        f.setStringValue(strB);
    }

    private void c(u1 u1Var, String str, String str2) {
        String strG = u1Var.g();
        if (strG != null) {
            k2[] k2VarArrI = b0.I(strG, this.b, f0.NAMEDRANGE, u1Var.a(), -1);
            for (k2 k2Var : k2VarArrI) {
                d(k2Var, str, str2);
            }
            String strB = d0.b(this.b, k2VarArrI);
            if (strG.equals(strB)) {
                return;
            }
            u1Var.i(strB);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(k2 k2Var, String str, String str2) {
        if (k2Var instanceof m2) {
            m2 m2Var = (m2) k2Var;
            if (m2Var.f() < 1) {
                if (m2Var.c() != null && m2Var.c().equals(str)) {
                    m2Var.d(str2);
                }
                if (m2Var instanceof l2) {
                    l2 l2Var = (l2) m2Var;
                    if (l2Var.g() == null || !l2Var.g().equals(str)) {
                        return;
                    }
                    l2Var.a(str2);
                }
            }
        }
    }

    public void e(int i2, String str, String str2) {
        for (u1 u1Var : this.a.getAllNames()) {
            if (u1Var.a() == -1 || u1Var.a() == i2) {
                c(u1Var, str, str2);
            }
        }
        Iterator<p0> it = this.a.iterator();
        while (it.hasNext()) {
            Iterator<o0> it2 = it.next().iterator();
            while (it2.hasNext()) {
                for (e eVar : it2.next()) {
                    if (eVar.b() == j.FORMULA) {
                        b((z0) eVar, str, str2);
                    }
                }
            }
        }
        for (n.a.a.j.c cVar : this.a.getSheetAt(i2).getRelations()) {
            if (cVar instanceof j1) {
                Iterator<b1> it3 = ((j1) cVar).M().iterator();
                while (it3.hasNext()) {
                    a(it3.next().L().getDomNode(), str, str2);
                }
            }
        }
    }
}
