package n.a.a.q.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n.a.a.j.m;
import n.a.a.n.d.n0;
import org.apache.poi.xssf.usermodel.d2;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;

/* loaded from: classes.dex */
public class g extends n.a.a.j.c implements Closeable {

    /* renamed from: h, reason: collision with root package name */
    private static final XmlOptions f2505h;
    private final List<CTRst> c;
    private final Map<String, Integer> d;
    protected int e;
    protected int f;
    private SstDocument g;

    static {
        XmlOptions xmlOptions = new XmlOptions();
        f2505h = xmlOptions;
        xmlOptions.setSaveInner();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setUseDefaultNamespace(true);
        xmlOptions.setSaveImplicitNamespaces(Collections.singletonMap("", "http://schemas.openxmlformats.org/spreadsheetml/2006/main"));
    }

    public g() {
        this.c = new ArrayList();
        this.d = new HashMap();
        SstDocument sstDocumentNewInstance = SstDocument.Factory.newInstance();
        this.g = sstDocumentNewInstance;
        sstDocumentNewInstance.addNewSst();
    }

    int I(CTRst cTRst) {
        String strN = N(cTRst);
        this.e++;
        if (this.d.containsKey(strN)) {
            return this.d.get(strN).intValue();
        }
        this.f++;
        CTRst cTRstAddNewSi = this.g.getSst().addNewSi();
        cTRstAddNewSi.set(cTRst);
        int size = this.c.size();
        this.d.put(strN, Integer.valueOf(size));
        this.c.add(cTRstAddNewSi);
        return size;
    }

    public int J(n0 n0Var) {
        if (n0Var instanceof d2) {
            return I(((d2) n0Var).a());
        }
        throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
    }

    public n0 K(int i2) {
        return new d2(this.c.get(i2));
    }

    public void L(InputStream inputStream) throws IOException {
        try {
            SstDocument sstDocument = SstDocument.Factory.parse(inputStream, m.a);
            this.g = sstDocument;
            CTSst sst = sstDocument.getSst();
            this.e = (int) sst.getCount();
            this.f = (int) sst.getUniqueCount();
            int i2 = 0;
            for (CTRst cTRst : sst.getSiArray()) {
                this.d.put(N(cTRst), Integer.valueOf(i2));
                this.c.add(cTRst);
                i2++;
            }
        } catch (XmlException e) {
            throw new IOException("unable to parse shared strings table", e);
        }
    }

    public void M(OutputStream outputStream) throws IOException {
        XmlOptions xmlOptions = new XmlOptions(m.a);
        xmlOptions.setSaveCDataLengthThreshold(SchemaType.SIZE_BIG_INTEGER);
        xmlOptions.setSaveCDataEntityCountThreshold(-1);
        CTSst sst = this.g.getSst();
        sst.setCount(this.e);
        sst.setUniqueCount(this.f);
        this.g.save(outputStream, xmlOptions);
    }

    protected String N(CTRst cTRst) {
        return cTRst.xmlText(f2505h);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // n.a.a.j.c
    protected void commit() throws IOException {
        OutputStream outputStreamO = getPackagePart().o();
        try {
            M(outputStreamO);
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

    public g(n.a.a.k.b.m mVar) throws IOException {
        super(mVar);
        this.c = new ArrayList();
        this.d = new HashMap();
        InputStream inputStreamM = mVar.m();
        try {
            L(inputStreamM);
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
