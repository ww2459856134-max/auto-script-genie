package k.x.j1;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/* loaded from: classes.dex */
public class z {
    private HashMap a;
    private HashMap b;

    static {
        k.y.c.b(z.class);
    }

    public z(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("functions", locale);
        y[] yVarArrD = y.d();
        this.a = new HashMap(yVarArrD.length);
        this.b = new HashMap(yVarArrD.length);
        for (y yVar : yVarArrD) {
            String strG = yVar.g();
            String string = strG.length() != 0 ? bundle.getString(strG) : null;
            if (string != null) {
                this.a.put(yVar, string);
                this.b.put(string, yVar);
            }
        }
    }

    y a(String str) {
        return (y) this.b.get(str);
    }

    String b(y yVar) {
        return (String) this.a.get(yVar);
    }
}
