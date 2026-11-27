package n.a.a.e.a.d;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import n.a.a.i.b;

/* loaded from: classes.dex */
public enum a {
    ANSI(0, "Cp1252"),
    DEFAULT(1, "Cp1252"),
    SYMBOL(2, ""),
    MAC(77, "MacRoman"),
    SHIFTJIS(128, "Shift_JIS"),
    HANGUL(129, "cp949"),
    JOHAB(130, "x-Johab"),
    GB2312(134, "GB2312"),
    CHINESEBIG5(136, "Big5"),
    GREEK(161, "Cp1253"),
    TURKISH(162, "Cp1254"),
    VIETNAMESE(163, "Cp1258"),
    HEBREW(177, "Cp1255"),
    ARABIC(178, "Cp1256"),
    BALTIC(186, "Cp1257"),
    RUSSIAN(204, "Cp1251"),
    THAI(222, "x-windows-874"),
    EASTEUROPE(238, "Cp1250"),
    OEM(255, "Cp1252");

    private static a[] P = new a[256];
    private int c;

    static {
        for (a aVar : values()) {
            P[aVar.a()] = aVar;
        }
    }

    a(int i2, String str) {
        this.c = i2;
        if (str.length() > 0) {
            try {
                Charset.forName(str);
            } catch (UnsupportedCharsetException unused) {
                b.a(a.class).atWarn().log("Unsupported charset: {}", str);
            }
        }
    }

    public static a b(int i2) {
        if (i2 >= 0) {
            a[] aVarArr = P;
            if (i2 < aVarArr.length) {
                return aVarArr[i2];
            }
        }
        return null;
    }

    public int a() {
        return this.c;
    }
}
