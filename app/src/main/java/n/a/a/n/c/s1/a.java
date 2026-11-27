package n.a.a.n.c.s1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class a {
    private final Map<String, b> b;
    private final Map<Integer, b> c;
    private int a = -1;
    private final Set<Integer> d = new HashSet();

    public a(int i2) {
        int i3 = (i2 * 3) / 2;
        this.b = new HashMap(i3);
        this.c = new HashMap(i3);
    }

    public void a(int i2, String str, int i3, int i4, byte b, byte[] bArr, boolean z) {
        b bVar = new b(i2, str, i3, i4, b, bArr);
        Integer numValueOf = Integer.valueOf(i2);
        if (i2 > this.a) {
            this.a = i2;
        }
        b bVar2 = this.b.get(str);
        if (bVar2 != null) {
            if (!z || !this.d.contains(numValueOf)) {
                throw new IllegalStateException("Multiple entries for function name '" + str + "'");
            }
            this.c.remove(Integer.valueOf(bVar2.a()));
        }
        b bVar3 = this.c.get(numValueOf);
        if (bVar3 != null) {
            if (!z || !this.d.contains(numValueOf)) {
                throw new IllegalStateException("Multiple entries for function index (" + i2 + ")");
            }
            this.b.remove(bVar3.d());
        }
        if (z) {
            this.d.add(numValueOf);
        }
        this.c.put(numValueOf, bVar);
        this.b.put(str, bVar);
    }

    public d b() {
        int size = this.b.size();
        b[] bVarArr = new b[size];
        this.b.values().toArray(bVarArr);
        b[] bVarArr2 = new b[this.a + 1];
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = bVarArr[i2];
            bVarArr2[bVar.a()] = bVar;
        }
        return new d(bVarArr2, this.b);
    }
}
