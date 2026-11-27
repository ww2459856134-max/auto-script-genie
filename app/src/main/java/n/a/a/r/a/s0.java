package n.a.a.r.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/* loaded from: classes.dex */
public abstract class s0 extends n.a.a.j.c implements y {
    List<v0> c;
    List<h1> d;
    List<z> e;
    CTHdrFtr f;
    j0 g;

    protected s0() {
        this.c = new ArrayList();
        this.d = new ArrayList();
        new ArrayList();
        this.e = new ArrayList();
        this.f = CTHdrFtr.Factory.newInstance();
        K();
    }

    public CTHdrFtr I() {
        return this.f;
    }

    public v0 J() {
        v0 v0Var = new v0(this.f.addNewP(), this);
        this.c.add(v0Var);
        this.e.add(v0Var);
        return v0Var;
    }

    public void K() {
        this.e = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.f.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    v0 v0Var = new v0((CTP) object, this);
                    this.c.add(v0Var);
                    this.e.add(v0Var);
                }
                if (object instanceof CTTbl) {
                    h1 h1Var = new h1((CTTbl) object, this, false);
                    this.d.add(h1Var);
                    this.e.add(h1Var);
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

    @Override // n.a.a.j.c
    protected void prepareForCommit() {
        if (this.e.isEmpty()) {
            J();
        }
        Iterator<h1> it = this.d.iterator();
        while (it.hasNext()) {
            Iterator<k1> it2 = it.next().d.iterator();
            while (it2.hasNext()) {
                for (j1 j1Var : it2.next().a()) {
                    if (j1Var.d().isEmpty()) {
                        j1Var.a();
                    }
                }
            }
        }
        super.prepareForCommit();
    }

    @Override // n.a.a.r.a.y
    public j0 u() {
        j0 j0Var = this.g;
        return j0Var != null ? j0Var : (j0) getParent();
    }

    public s0(n.a.a.j.c cVar, n.a.a.k.b.m mVar) {
        super(cVar, mVar);
        this.c = new ArrayList();
        this.d = new ArrayList();
        new ArrayList();
        this.e = new ArrayList();
        n.a.a.j.c parent = getParent();
        StringBuilder sb = new StringBuilder();
        sb.append("Had unexpected type of parent: ");
        sb.append(parent == null ? "<null>" : parent.getClass());
        throw new IllegalArgumentException(sb.toString());
    }
}
