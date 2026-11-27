package n.a.a.r.a;

import java.io.IOException;
import java.io.InputStream;
import org.apache.xmlbeans.XmlException;

/* loaded from: classes.dex */
public class h0 extends n.a.a.p.a.a.l {
    private Long d;

    protected h0() {
    }

    @Override // n.a.a.p.a.a.l
    protected n.a.a.j.e O() {
        return m0.a();
    }

    @Override // n.a.a.p.a.a.l
    protected n.a.a.j.l Q() {
        return y0.f2528j;
    }

    public Long Z() throws IOException {
        if (this.d == null) {
            try {
                InputStream inputStreamM = getPackagePart().m();
                try {
                    this.d = Long.valueOf(n.a.a.o.w0.b(inputStreamM));
                    if (inputStreamM != null) {
                        inputStreamM.close();
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new n.a.a.j.d(e);
            }
        }
        return this.d;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return Z().hashCode();
    }

    protected h0(n.a.a.k.b.m mVar) throws XmlException, IOException {
        super(mVar);
    }
}
