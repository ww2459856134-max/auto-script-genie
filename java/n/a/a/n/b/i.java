package n.a.a.n.b;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public class i extends b0 {
    private static final Pattern f = Pattern.compile("%");
    private final List<h> c;
    private h d;
    private final String e;

    public i(String str) {
        super(str);
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        StringBuffer stringBufferM = t.m(str, a0.f, new g(this));
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            h hVar = (h) listIterator.previous();
            int i2 = hVar.b;
            stringBufferM.replace(i2, hVar.c + i2, "%0" + hVar.c + "d");
            char c = hVar.a;
            if (c != this.d.a) {
                hVar.e = l(c, hVar.c);
            }
        }
        this.e = stringBufferM.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h j(char c, int i2, int i3) {
        h hVar = new h(c, i2, i3, k(c, i3));
        this.c.add(hVar);
        return hVar;
    }

    private static double k(char c, int i2) {
        if (c == '0') {
            return 1.1574074074074073E-5d / Math.pow(10.0d, i2);
        }
        if (c == 'h') {
            return 0.041666666666666664d;
        }
        if (c == 'm') {
            return 6.944444444444444E-4d;
        }
        if (c == 's') {
            return 1.1574074074074073E-5d;
        }
        throw new IllegalArgumentException("Unknown elapsed time spec: " + c);
    }

    private static double l(char c, int i2) {
        if (c == '0') {
            return Math.pow(10.0d, i2);
        }
        if (c == 'h') {
            return 24.0d;
        }
        if (c == 'm' || c == 's') {
            return 60.0d;
        }
        throw new IllegalArgumentException("Unknown elapsed time spec: " + c);
    }

    @Override // n.a.a.n.b.b0
    public void b(StringBuffer stringBuffer, Object obj) {
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue < 0.0d) {
            stringBuffer.append(NameUtil.HYPHEN);
            dDoubleValue = -dDoubleValue;
        }
        Long[] lArr = new Long[this.c.size()];
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            lArr[i2] = Long.valueOf(this.c.get(i2).a(dDoubleValue));
        }
        Formatter formatter = new Formatter(stringBuffer, Locale.ROOT);
        try {
            formatter.format(this.e, lArr);
            formatter.close();
        } finally {
        }
    }

    @Override // n.a.a.n.b.b0
    public void e(StringBuffer stringBuffer, Object obj) {
        b(stringBuffer, obj);
    }
}
