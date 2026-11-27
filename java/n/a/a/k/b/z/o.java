package n.a.a.k.b.z;

import com.auto.exceldeps.log4j.Logger;
import i.b.ha.a.b.d.c.o1;
import i.b.ha.a.b.d.c.w1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import n.a.a.k.b.u;
import org.w3c.dom.Document;

/* loaded from: classes.dex */
public class o extends d {
    private static final Logger d = n.a.a.i.b.a(o.class);

    public o(InputStream inputStream, n.a.a.k.b.k kVar) throws n.a.a.k.a.a {
        super(inputStream, kVar);
    }

    @Override // n.a.a.k.b.z.d
    public boolean l(Document document, OutputStream outputStream) {
        w1 w1Var = outputStream instanceof w1 ? (w1) outputStream : new w1(outputStream);
        o1 o1Var = new o1("[Content_Types].xml");
        try {
            q.a(o1Var);
            w1Var.J(o1Var);
            try {
                return u.a(document, w1Var);
            } finally {
                w1Var.f();
            }
        } catch (IOException e) {
            d.atError().withThrowable(e).log("Cannot write: [Content_Types].xml in Zip !");
            return false;
        }
    }
}
