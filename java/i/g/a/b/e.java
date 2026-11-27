package i.g.a.b;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* loaded from: classes.dex */
public final class e extends StringEnumAbstractBase {
    public static final StringEnumAbstractBase.Table c = new StringEnumAbstractBase.Table(new e[]{new e("view", 1), new e("edit", 2), new e("backwardCompatible", 3)});

    private e(String str, int i2) {
        super(str, i2);
    }

    public static e a(String str) {
        return (e) c.forString(str);
    }
}
