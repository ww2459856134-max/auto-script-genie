package i.b.ha.a.e.b.p;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class b implements Serializable {
    private List<c> c = new ArrayList();
    private List<Object[]> d = new ArrayList();

    public b(Throwable th) {
        new HashMap();
    }

    private String b(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        int size = this.c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            sb.append(new MessageFormat(this.c.get(i3).j(locale), locale).format(this.d.get(i3)));
            i2++;
            if (i2 < size) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public void a(c cVar, Object... objArr) {
        this.c.add(cVar);
        this.d.add(a.a(objArr));
    }

    public String c() {
        return e(Locale.getDefault());
    }

    public String d() {
        return e(Locale.US);
    }

    public String e(Locale locale) {
        return b(locale, ": ");
    }
}
