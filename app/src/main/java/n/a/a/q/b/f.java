package n.a.a.q.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import n.a.a.j.m;
import org.apache.poi.xssf.usermodel.t1;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMap;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMapInfo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.MapInfoDocument;

/* loaded from: classes.dex */
public class f extends n.a.a.j.c {
    private CTMapInfo a;
    private Map<Integer, t1> b;

    public f() {
        this.a = CTMapInfo.Factory.newInstance();
    }

    public Collection<t1> I() {
        return this.b.values();
    }

    public void J(InputStream inputStream) throws IOException {
        try {
            this.a = MapInfoDocument.Factory.parse(inputStream, m.a).getMapInfo();
            this.b = new HashMap();
            for (CTMap cTMap : this.a.getMapArray()) {
                this.b.put(Integer.valueOf((int) cTMap.getID()), new t1(cTMap, this));
            }
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    protected void K(OutputStream outputStream) throws IOException {
        MapInfoDocument mapInfoDocumentNewInstance = MapInfoDocument.Factory.newInstance();
        mapInfoDocumentNewInstance.setMapInfo(this.a);
        mapInfoDocumentNewInstance.save(outputStream, m.a);
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            K(outputStreamO);
            if (outputStreamO != null) {
                outputStreamO.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStreamO != null) {
                    try {
                        outputStreamO.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public f(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        InputStream inputStreamM = mVar.m();
        try {
            J(inputStreamM);
            if (inputStreamM != null) {
                inputStreamM.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamM != null) {
                    try {
                        inputStreamM.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
