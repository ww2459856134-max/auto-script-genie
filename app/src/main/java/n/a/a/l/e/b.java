package n.a.a.l.e;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class b implements Comparator<e>, Serializable {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(e eVar, e eVar2) {
        String strB = eVar.b();
        String strB2 = eVar2.b();
        int length = strB.length() - strB2.length();
        if (length != 0) {
            return length;
        }
        if (strB.compareTo("_VBA_PROJECT") != 0) {
            if (strB2.compareTo("_VBA_PROJECT") != 0) {
                if (strB.startsWith("__") && strB2.startsWith("__")) {
                    return strB.compareToIgnoreCase(strB2);
                }
                if (!strB.startsWith("__")) {
                    if (!strB2.startsWith("__")) {
                        return strB.compareToIgnoreCase(strB2);
                    }
                }
            }
            return -1;
        }
        return 1;
    }
}
