package i.e.a.i;

import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {
    static final HashMap<String, Integer> c;
    protected int a;
    protected int b;

    static {
        HashMap<String, Integer> map = new HashMap<>(16);
        c = map;
        map.put("org.codehaus.stax2.implName", 1);
        map.put("org.codehaus.stax2.implVersion", 2);
        map.put("org.codehaus.stax2.supportsXml11", 3);
        map.put("org.codehaus.stax2.supportXmlId", 4);
        map.put("http://java.sun.com/xml/stream/properties/implementation-name", 1);
    }

    protected a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public Object a(String str, boolean z) {
        Integer num = c.get(str);
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                return "aalto";
            }
            if (iIntValue == 2) {
                return "0.9";
            }
            if (iIntValue == 3) {
                return Boolean.FALSE;
            }
            if (iIntValue == 4) {
                return Boolean.FALSE;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Unrecognized property '" + str + "'");
    }

    protected final boolean b(int i2) {
        return c(i2) && d(i2);
    }

    protected final boolean c(int i2) {
        return (i2 & this.a) != 0;
    }

    protected final boolean d(int i2) {
        return (i2 & this.b) != 0;
    }

    public boolean e(String str) {
        return c.containsKey(str);
    }

    protected final void f(int i2, boolean z) {
        if (z) {
            this.a |= i2;
        } else {
            this.a &= ~i2;
        }
        this.b = i2 | this.b;
    }

    public boolean g(String str, Object obj) {
        if (c.get(str) != null) {
            return false;
        }
        throw new IllegalArgumentException("Unrecognized property '" + str + "'");
    }
}
