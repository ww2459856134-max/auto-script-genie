package n.a.a.q.c;

import java.util.Comparator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

/* loaded from: classes.dex */
public abstract class c {
    public static final Comparator<CTCol> a = new Comparator() { // from class: n.a.a.q.c.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Long.compare(((CTCol) obj).getMax(), ((CTCol) obj2).getMax());
        }
    };
    public static final Comparator<CTCol> b = new Comparator() { // from class: n.a.a.q.c.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return c.b((CTCol) obj, (CTCol) obj2);
        }
    };

    static /* synthetic */ int b(CTCol cTCol, CTCol cTCol2) {
        long min = cTCol.getMin();
        long min2 = cTCol2.getMin();
        if (min < min2) {
            return -1;
        }
        if (min > min2) {
            return 1;
        }
        return a.compare(cTCol, cTCol2);
    }
}
