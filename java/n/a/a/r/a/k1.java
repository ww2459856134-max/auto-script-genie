package n.a.a.r.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* loaded from: classes.dex */
public class k1 {
    private final CTRow a;
    private final h1 b;
    private List<j1> c;

    public k1(CTRow cTRow, h1 h1Var) {
        this.b = h1Var;
        this.a = cTRow;
        a();
    }

    public List<j1> a() {
        if (this.c == null) {
            ArrayList arrayList = new ArrayList();
            for (CTTc cTTc : this.a.getTcArray()) {
                arrayList.add(new j1(cTTc, this, this.b.b()));
            }
            this.c = arrayList;
        }
        return Collections.unmodifiableList(this.c);
    }

    public List<a0> b() {
        ArrayList arrayList = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.a.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTTc) {
                    arrayList.add(new j1((CTTc) object, this, this.b.b()));
                } else if (object instanceof CTSdtCell) {
                    arrayList.add(new b1((CTSdtCell) object, this, this.b.b()));
                }
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return arrayList;
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
