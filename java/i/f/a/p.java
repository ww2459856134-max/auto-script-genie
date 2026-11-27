package i.f.a;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class p {
    private final String a;
    private final byte[] b;
    private r[] c;
    private final a d;
    private Map<q, Object> e;

    public p(String str, byte[] bArr, r[] rVarArr, a aVar) {
        this(str, bArr, rVarArr, aVar, System.currentTimeMillis());
    }

    public void a(r[] rVarArr) {
        r[] rVarArr2 = this.c;
        if (rVarArr2 == null) {
            this.c = rVarArr;
            return;
        }
        if (rVarArr == null || rVarArr.length <= 0) {
            return;
        }
        r[] rVarArr3 = new r[rVarArr2.length + rVarArr.length];
        System.arraycopy(rVarArr2, 0, rVarArr3, 0, rVarArr2.length);
        System.arraycopy(rVarArr, 0, rVarArr3, rVarArr2.length, rVarArr.length);
        this.c = rVarArr3;
    }

    public a b() {
        return this.d;
    }

    public byte[] c() {
        return this.b;
    }

    public Map<q, Object> d() {
        return this.e;
    }

    public r[] e() {
        return this.c;
    }

    public String f() {
        return this.a;
    }

    public void g(Map<q, Object> map) {
        if (map != null) {
            Map<q, Object> map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(q qVar, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(q.class);
        }
        this.e.put(qVar, obj);
    }

    public String toString() {
        return this.a;
    }

    public p(String str, byte[] bArr, r[] rVarArr, a aVar, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, rVarArr, aVar, j2);
    }

    public p(String str, byte[] bArr, int i2, r[] rVarArr, a aVar, long j2) {
        this.a = str;
        this.b = bArr;
        this.c = rVarArr;
        this.d = aVar;
        this.e = null;
    }
}
