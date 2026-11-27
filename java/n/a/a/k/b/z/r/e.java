package n.a.a.k.b.z.r;

import com.auto.exceldeps.log4j.Logger;
import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.w1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.Objects;
import n.a.a.k.a.f;
import n.a.a.k.b.m;
import n.a.a.k.b.o;
import n.a.a.k.b.q;
import n.a.a.k.b.r;
import n.a.a.k.b.s;
import n.a.a.k.b.u;
import n.a.a.k.b.v;
import n.a.a.k.b.z.l;
import n.a.a.o.w0;
import org.apache.poi.xssf.usermodel.c2;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes.dex */
public final class e implements l {
    private static final Logger a = n.a.a.i.b.a(e.class);

    public static boolean b(r rVar, o oVar, w1 w1Var) throws DOMException {
        String string;
        Document documentB = n.a.a.j.o.a.b();
        Element elementCreateElementNS = documentB.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationships");
        documentB.appendChild(elementCreateElementNS);
        URI uriH = s.h(oVar.g());
        Iterator<q> it = rVar.iterator();
        while (it.hasNext()) {
            q next = it.next();
            Element elementCreateElementNS2 = documentB.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
            elementCreateElementNS.appendChild(elementCreateElementNS2);
            elementCreateElementNS2.setAttribute("Id", next.a());
            elementCreateElementNS2.setAttribute("Type", next.b());
            URI uriE = next.e();
            if (Objects.equals(next.b(), "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink")) {
                string = uriE.toString();
                if (next.d() == v.EXTERNAL) {
                    elementCreateElementNS2.setAttribute("TargetMode", "External");
                }
            } else if (next.d() == v.EXTERNAL) {
                string = uriE.toString();
                elementCreateElementNS2.setAttribute("TargetMode", "External");
            } else {
                string = s.l(uriH, next.e(), true).toString();
            }
            elementCreateElementNS2.setAttribute("Target", string);
        }
        documentB.normalize();
        o1 o1Var = new o1(n.a.a.k.b.z.q.e(oVar.g().toASCIIString()).getPath());
        try {
            n.a.a.k.b.z.q.a(o1Var);
            w1Var.J(o1Var);
            try {
                return u.a(documentB, w1Var);
            } finally {
                w1Var.f();
            }
        } catch (IOException e) {
            a.atError().withThrowable(e).log("Cannot create zip entry {}", oVar);
            return false;
        }
    }

    @Override // n.a.a.k.b.z.l
    public boolean a(m mVar, OutputStream outputStream) throws f {
        if (!(outputStream instanceof w1)) {
            a.atError().log("Unexpected class {}", outputStream.getClass().getName());
            throw new f("ZipArchiveOutputStream expected !");
        }
        if (mVar.x() == 0 && mVar.r().f().equals(c2.f2554m.c())) {
            return true;
        }
        w1 w1Var = (w1) outputStream;
        o1 o1Var = new o1(n.a.a.k.b.z.q.d(mVar.r().g().getPath()));
        try {
            n.a.a.k.b.z.q.a(o1Var);
            w1Var.J(o1Var);
            try {
                InputStream inputStreamM = mVar.m();
                try {
                    w0.h(inputStreamM, w1Var);
                    if (inputStreamM != null) {
                        inputStreamM.close();
                    }
                    if (!mVar.y()) {
                        return true;
                    }
                    return b(mVar.u(), s.g(mVar.r()), w1Var);
                } finally {
                }
            } finally {
                w1Var.f();
            }
        } catch (IOException e) {
            a.atError().withThrowable(e).log("Cannot write: {}: in ZIP", mVar.r());
            return false;
        }
    }
}
