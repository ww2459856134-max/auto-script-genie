package n.a.a.r.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/* loaded from: classes.dex */
public class c1 implements d0 {
    private final List<Object> a = new ArrayList();

    public c1(CTSdtContentRun cTSdtContentRun, y yVar, b0 b0Var) {
        if (cTSdtContentRun == null) {
            return;
        }
        XmlCursor xmlCursorNewCursor = cTSdtContentRun.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTR) {
                    this.a.add(new z0((CTR) object, b0Var));
                } else if (object instanceof CTSdtRun) {
                    this.a.add(new a1((CTSdtRun) object, yVar));
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

    private void a(v0 v0Var, StringBuilder sb) {
        Iterator<z0> it = v0Var.b().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
    }

    private void b(h1 h1Var, StringBuilder sb) {
        Iterator<k1> it = h1Var.c().iterator();
        while (it.hasNext()) {
            List<a0> listB = it.next().b();
            for (int i2 = 0; i2 < listB.size(); i2++) {
                a0 a0Var = listB.get(i2);
                if (a0Var instanceof j1) {
                    sb.append(((j1) a0Var).f());
                } else if (a0Var instanceof b1) {
                    sb.append(((b1) a0Var).a().getText());
                }
                if (i2 < listB.size() - 1) {
                    sb.append("\t");
                }
            }
            sb.append('\n');
        }
    }

    @Override // n.a.a.r.a.d0
    public String getText() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            Object obj = this.a.get(i2);
            if (obj instanceof v0) {
                a((v0) obj, sb);
            } else if (obj instanceof h1) {
                b((h1) obj, sb);
            } else if (obj instanceof a1) {
                sb.append(((a1) obj).a().getText());
            } else {
                if (obj instanceof z0) {
                    sb.append(obj);
                    z = false;
                }
                if (!z && i2 < this.a.size() - 1) {
                    sb.append("\n");
                }
            }
            z = true;
            if (!z) {
            }
        }
        return sb.toString();
    }

    public String toString() {
        return getText();
    }

    public c1(CTSdtContentBlock cTSdtContentBlock, y yVar, b0 b0Var) {
        if (cTSdtContentBlock == null) {
            return;
        }
        XmlCursor xmlCursorNewCursor = cTSdtContentBlock.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    this.a.add(new v0((CTP) object, yVar));
                } else if (object instanceof CTTbl) {
                    this.a.add(new h1((CTTbl) object, yVar, false));
                } else if (object instanceof CTSdtBlock) {
                    this.a.add(new a1((CTSdtBlock) object, yVar));
                } else if (object instanceof CTR) {
                    this.a.add(new z0((CTR) object, b0Var));
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
}
