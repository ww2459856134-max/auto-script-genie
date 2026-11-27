package n.a.a.n.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class r {
    private static final Map<String, Integer> a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put("<", 0);
        map.put("<=", 1);
        map.put(">", 2);
        map.put(">=", 3);
        map.put("=", 4);
        map.put("==", 4);
        map.put("!=", 5);
        map.put("<>", 5);
    }

    public static r a(String str, String str2) throws NumberFormatException {
        Map<String, Integer> map = a;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown test: " + str);
        }
        int iIntValue = map.get(str).intValue();
        double d = Double.parseDouble(str2);
        if (iIntValue == 0) {
            return new l(d);
        }
        if (iIntValue == 1) {
            return new m(d);
        }
        if (iIntValue == 2) {
            return new n(d);
        }
        if (iIntValue == 3) {
            return new o(d);
        }
        if (iIntValue == 4) {
            return new p(d);
        }
        if (iIntValue == 5) {
            return new q(d);
        }
        throw new IllegalArgumentException("Cannot create for test number " + iIntValue + "(\"" + str + "\")");
    }

    public abstract boolean b(double d);
}
