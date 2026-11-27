package n.a.a.r.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/* loaded from: classes.dex */
public class j1 implements y, a0 {

    /* renamed from: i, reason: collision with root package name */
    private static final EnumMap<i1, STVerticalJc.Enum> f2520i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<Integer, i1> f2521j;
    private final CTTc c;
    private final j0 d;
    protected List<v0> e;
    protected List<h1> f;
    protected List<z> g;

    /* renamed from: h, reason: collision with root package name */
    protected y f2522h;

    static {
        EnumMap<i1, STVerticalJc.Enum> enumMap = new EnumMap<>(i1.class);
        f2520i = enumMap;
        i1 i1Var = i1.TOP;
        enumMap.put((EnumMap<i1, STVerticalJc.Enum>) i1Var, (i1) STVerticalJc.TOP);
        i1 i1Var2 = i1.CENTER;
        enumMap.put((EnumMap<i1, STVerticalJc.Enum>) i1Var2, (i1) STVerticalJc.CENTER);
        i1 i1Var3 = i1.BOTH;
        enumMap.put((EnumMap<i1, STVerticalJc.Enum>) i1Var3, (i1) STVerticalJc.BOTH);
        i1 i1Var4 = i1.BOTTOM;
        enumMap.put((EnumMap<i1, STVerticalJc.Enum>) i1Var4, (i1) STVerticalJc.BOTTOM);
        HashMap<Integer, i1> map = new HashMap<>();
        f2521j = map;
        map.put(1, i1Var);
        map.put(2, i1Var2);
        map.put(3, i1Var3);
        map.put(4, i1Var4);
    }

    public j1(CTTc cTTc, k1 k1Var, y yVar) {
        if (cTTc == null) {
            throw new IllegalArgumentException("CTTc cannot be null");
        }
        if (k1Var == null) {
            throw new IllegalArgumentException("tableRow cannot be null");
        }
        this.c = cTTc;
        this.f2522h = yVar;
        if (yVar != null) {
            yVar.u();
        }
        this.g = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    v0 v0Var = new v0((CTP) object, this);
                    this.e.add(v0Var);
                    this.g.add(v0Var);
                }
                if (object instanceof CTTbl) {
                    h1 h1Var = new h1((CTTbl) object, this, false);
                    this.f.add(h1Var);
                    this.g.add(h1Var);
                }
                if (object instanceof CTSdtBlock) {
                    this.g.add(new a1((CTSdtBlock) object, this));
                }
                if (object instanceof CTSdtRun) {
                    this.g.add(new a1((CTSdtRun) object, this));
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

    private void c(StringBuilder sb, z zVar, boolean z) {
        if (zVar instanceof v0) {
            sb.append(((v0) zVar).c());
            if (z) {
                return;
            }
            sb.append('\t');
            return;
        }
        if (!(zVar instanceof h1)) {
            if (zVar instanceof a1) {
                sb.append(((a1) zVar).a().getText());
                if (z) {
                    return;
                }
                sb.append('\t');
                return;
            }
            return;
        }
        Iterator<k1> it = ((h1) zVar).c().iterator();
        while (it.hasNext()) {
            Iterator<j1> it2 = it.next().a().iterator();
            while (it2.hasNext()) {
                List<z> listD = it2.next().d();
                for (int i2 = 0; i2 < listD.size(); i2++) {
                    boolean z2 = true;
                    if (i2 != listD.size() - 1) {
                        z2 = false;
                    }
                    c(sb, listD.get(i2), z2);
                }
            }
        }
        if (z) {
            return;
        }
        sb.append('\n');
    }

    private static j0 e(j1 j1Var, int i2) {
        if (i2 > 1000) {
            throw new IllegalStateException("Recursion depth exceeded while trying to get XWPFDocument from XWPFTableCell");
        }
        y yVar = j1Var.f2522h;
        return yVar instanceof j1 ? e((j1) yVar, i2 + 1) : yVar.u();
    }

    public v0 a() {
        v0 v0Var = new v0(this.c.addNewP(), this);
        b(v0Var);
        return v0Var;
    }

    public void b(v0 v0Var) {
        this.e.add(v0Var);
        this.g.add(v0Var);
    }

    public List<z> d() {
        return Collections.unmodifiableList(this.g);
    }

    public String f() {
        StringBuilder sb = new StringBuilder(64);
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            boolean z = true;
            if (i2 != this.g.size() - 1) {
                z = false;
            }
            c(sb, this.g.get(i2), z);
        }
        return sb.toString();
    }

    @Override // n.a.a.r.a.y
    public j0 u() {
        j0 j0Var = this.d;
        if (j0Var != null) {
            return j0Var;
        }
        y yVar = this.f2522h;
        if (yVar instanceof j1) {
            return e((j1) yVar, 0);
        }
        if (yVar != null) {
            return yVar.u();
        }
        return null;
    }
}
