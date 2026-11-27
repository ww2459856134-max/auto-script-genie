package n.a.a.n.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum i0 {
    _NO_ERROR(-1, "(no error)"),
    NULL(0, "#NULL!"),
    DIV0(7, "#DIV/0!"),
    VALUE(15, "#VALUE!"),
    REF(23, "#REF!"),
    NAME(29, "#NAME?"),
    NUM(36, "#NUM!"),
    NA(42, "#N/A"),
    CIRCULAR_REF(-60, "~CIRCULAR~REF~"),
    FUNCTION_NOT_IMPLEMENTED(-30, "~FUNCTION~NOT~IMPLEMENTED~");

    private static final Map<String, i0> G;
    private static final Map<Byte, i0> H;
    private static final Map<Integer, i0> I;
    private final byte c;
    private final int d;
    private final String e;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (i0 i0Var : values()) {
            map2.put(Byte.valueOf(i0Var.d()), i0Var);
            map3.put(Integer.valueOf(i0Var.e()), i0Var);
            map.put(i0Var.f(), i0Var);
        }
        G = Collections.unmodifiableMap(map);
        H = Collections.unmodifiableMap(map2);
        I = Collections.unmodifiableMap(map3);
    }

    i0(int i2, String str) {
        this.c = (byte) i2;
        this.d = i2;
        this.e = str;
    }

    public static i0 a(byte b) throws IllegalArgumentException {
        i0 i0Var = H.get(Byte.valueOf(b));
        if (i0Var != null) {
            return i0Var;
        }
        throw new IllegalArgumentException("Unknown error type: " + ((int) b));
    }

    public static i0 b(int i2) throws IllegalArgumentException {
        i0 i0Var = I.get(Integer.valueOf(i2));
        if (i0Var == null) {
            i0Var = H.get(Byte.valueOf((byte) i2));
        }
        if (i0Var != null) {
            return i0Var;
        }
        throw new IllegalArgumentException("Unknown error type: " + i2);
    }

    public static i0 c(String str) throws IllegalArgumentException {
        i0 i0Var = G.get(str);
        if (i0Var != null) {
            return i0Var;
        }
        throw new IllegalArgumentException("Unknown error code: " + str);
    }

    public static boolean g(int i2) {
        for (i0 i0Var : values()) {
            if (i0Var.d() == i2 || i0Var.e() == i2) {
                return true;
            }
        }
        return false;
    }

    public byte d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }
}
