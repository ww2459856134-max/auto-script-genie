package n.a.a.p.a.a;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir;

/* loaded from: classes.dex */
public enum a {
    BAR(STBarDir.BAR),
    COL(STBarDir.COL);

    private static final HashMap<STBarDir.Enum, a> f = new HashMap<>();
    final STBarDir.Enum c;

    static {
        for (a aVar : values()) {
            f.put(aVar.c, aVar);
        }
    }

    a(STBarDir.Enum r3) {
        this.c = r3;
    }
}
