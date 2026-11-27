package i.b.ha.a.b.d.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum i0 {
    DES(26113),
    RC2pre52(26114),
    TripleDES168(26115),
    TripleDES192(26121),
    AES128(26126),
    AES192(26127),
    AES256(26128),
    RC2(26370),
    RC4(26625),
    UNKNOWN(65535);

    private static final Map<Integer, i0> C;
    private final int c;

    static {
        HashMap map = new HashMap();
        for (i0 i0Var : values()) {
            map.put(Integer.valueOf(i0Var.c()), i0Var);
        }
        C = Collections.unmodifiableMap(map);
    }

    i0(int i2) {
        this.c = i2;
    }

    public static i0 b(int i2) {
        return C.get(Integer.valueOf(i2));
    }

    public int c() {
        return this.c;
    }
}
