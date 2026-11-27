package i.b.ha.a.b.d.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum j0 {
    NONE(0),
    CRC32(1),
    MD5(32771),
    SHA1(32772),
    RIPEND160(32775),
    SHA256(32780),
    SHA384(32781),
    SHA512(32782);

    private static final Map<Integer, j0> t;
    private final int c;

    static {
        HashMap map = new HashMap();
        for (j0 j0Var : values()) {
            map.put(Integer.valueOf(j0Var.c()), j0Var);
        }
        t = Collections.unmodifiableMap(map);
    }

    j0(int i2) {
        this.c = i2;
    }

    public static j0 b(int i2) {
        return t.get(Integer.valueOf(i2));
    }

    public int c() {
        return this.c;
    }
}
