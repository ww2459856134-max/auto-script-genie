package n.a.a.r.a;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;

/* loaded from: classes.dex */
public class v0 implements z, b0 {
    private final CTP c;
    protected y d;
    protected j0 e;
    protected List<z0> f;
    protected List<c0> g;

    /* renamed from: h, reason: collision with root package name */
    private final StringBuilder f2525h = new StringBuilder(64);

    public v0(CTP ctp, y yVar) {
        this.c = ctp;
        this.d = yVar;
        Objects.requireNonNull(yVar.u(), "null document in XWPFParagraph");
        this.f = new ArrayList();
        this.g = new ArrayList();
        a(ctp);
        Iterator<z0> it = this.f.iterator();
        while (it.hasNext()) {
            XmlCursor xmlCursorNewCursor = it.next().c().newCursor();
            try {
                xmlCursorNewCursor.selectPath("child::*");
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTFtnEdnRef) {
                        CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) object;
                        BigInteger id = cTFtnEdnRef.getId();
                        StringBuilder sb = this.f2525h;
                        sb.append(" [");
                        sb.append(id);
                        sb.append(": ");
                        e0 e0VarM = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? this.e.M(id == null ? 0 : id.intValue()) : this.e.L(id == null ? 0 : id.intValue());
                        if (e0VarM != null) {
                            boolean z = true;
                            for (v0 v0Var : e0VarM.a()) {
                                if (!z) {
                                    this.f2525h.append("\n");
                                }
                                this.f2525h.append(v0Var.c());
                                z = false;
                            }
                        } else {
                            StringBuilder sb2 = this.f2525h;
                            sb2.append("!!! End note with ID \"");
                            sb2.append(id);
                            sb2.append("\" not found in document.");
                        }
                        this.f2525h.append("] ");
                    }
                }
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
            } finally {
            }
        }
    }

    private void a(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath("child::*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTR) {
                    z0 z0Var = new z0((CTR) object, this);
                    this.f.add(z0Var);
                    this.g.add(z0Var);
                }
                if (object instanceof CTHyperlink) {
                    CTHyperlink cTHyperlink = (CTHyperlink) object;
                    for (CTR ctr : cTHyperlink.getRArray()) {
                        t0 t0Var = new t0(cTHyperlink, ctr, this);
                        this.f.add(t0Var);
                        this.g.add(t0Var);
                    }
                }
                if (object instanceof CTSimpleField) {
                    CTSimpleField cTSimpleField = (CTSimpleField) object;
                    for (CTR ctr2 : cTSimpleField.getRArray()) {
                        n0 n0Var = new n0(cTSimpleField, ctr2, this);
                        this.f.add(n0Var);
                        this.g.add(n0Var);
                    }
                }
                if (object instanceof CTSdtBlock) {
                    this.g.add(new a1((CTSdtBlock) object, this.d));
                }
                if (object instanceof CTSdtRun) {
                    this.g.add(new a1((CTSdtRun) object, this.d));
                }
                if (object instanceof CTRunTrackChange) {
                    CTRunTrackChange cTRunTrackChange = (CTRunTrackChange) object;
                    for (CTR ctr3 : cTRunTrackChange.getRArray()) {
                        z0 z0Var2 = new z0(ctr3, this);
                        this.f.add(z0Var2);
                        this.g.add(z0Var2);
                    }
                    for (CTRunTrackChange cTRunTrackChange2 : cTRunTrackChange.getInsArray()) {
                        a(cTRunTrackChange2);
                    }
                }
                if (object instanceof CTSmartTagRun) {
                    a(object);
                }
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public List<z0> b() {
        return Collections.unmodifiableList(this.f);
    }

    public String c() {
        StringBuilder sb = new StringBuilder(64);
        for (c0 c0Var : this.g) {
            if (c0Var instanceof z0) {
                z0 z0Var = (z0) c0Var;
                if (z0Var.c().sizeOfDelTextArray() == 0) {
                    sb.append(z0Var);
                }
            } else if (c0Var instanceof a1) {
                sb.append(((a1) c0Var).a().getText());
            } else {
                sb.append(c0Var);
            }
        }
        sb.append((CharSequence) this.f2525h);
        return sb.toString();
    }

    @Override // n.a.a.r.a.b0
    public j0 getDocument() {
        return this.e;
    }
}
