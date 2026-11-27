package i.g.a.b;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes.dex */
public final class g extends StringEnumAbstractBase {
    public static final StringEnumAbstractBase.Table c = new StringEnumAbstractBase.Table(new g[]{new g("round", 1), new g("bevel", 2), new g("miter", 3)});

    private g(String str, int i2) {
        super(str, i2);
    }

    public static g a(String str) {
        return (g) c.forString(str);
    }
}
