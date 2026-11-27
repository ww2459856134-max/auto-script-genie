package i.g.a.a.a;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes.dex */
public final class c extends StringEnumAbstractBase {
    public static final StringEnumAbstractBase.Table c = new StringEnumAbstractBase.Table(new c[]{new c("none", 1), new c("rect", 2), new c("segments", 3), new c("custom", 4)});

    private c(String str, int i2) {
        super(str, i2);
    }

    public static c a(String str) {
        return (c) c.forString(str);
    }
}
