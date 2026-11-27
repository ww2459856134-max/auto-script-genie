package n.a.a.l.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;

/* loaded from: classes.dex */
public abstract class c extends e implements Object, Iterable<e> {
    private final List<e> C = new ArrayList();
    private final Set<String> D = new HashSet();

    public c(String str) throws ArrayIndexOutOfBoundsException {
        p(str);
        w(0);
        v((byte) 1);
        z(0);
        t((byte) 1);
    }

    public void D(e eVar) throws IOException {
        String strB = eVar.b();
        if (!this.D.contains(strB)) {
            this.D.add(strB);
            this.C.add(eVar);
        } else {
            throw new IOException("Duplicate name \"" + strB + "\"");
        }
    }

    public Iterator<e> E() {
        return this.C.iterator();
    }

    @Override // n.a.a.l.e.e
    public boolean h() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n.a.a.l.e.e
    protected void j() throws ArrayIndexOutOfBoundsException {
        if (this.C.isEmpty()) {
            return;
        }
        e[] eVarArr = (e[]) this.C.toArray(new e[0]);
        Arrays.sort(eVarArr, new b());
        int length = eVarArr.length / 2;
        k(eVarArr[length].a());
        eVarArr[0].u(null);
        eVarArr[0].r(null);
        for (int i2 = 1; i2 < length; i2++) {
            eVarArr[i2].u(eVarArr[i2 - 1]);
            eVarArr[i2].r(null);
        }
        if (length != 0) {
            eVarArr[length].u(eVarArr[length - 1]);
        }
        if (length == eVarArr.length - 1) {
            eVarArr[length].r(null);
            return;
        }
        g gVar = eVarArr[length];
        int i3 = length + 1;
        gVar.r(eVarArr[i3]);
        while (i3 < eVarArr.length - 1) {
            eVarArr[i3].u(null);
            g gVar2 = eVarArr[i3];
            i3++;
            gVar2.r(eVarArr[i3]);
        }
        eVarArr[eVarArr.length - 1].u(null);
        eVarArr[eVarArr.length - 1].r(null);
    }

    @Override // java.lang.Iterable
    public Spliterator<e> spliterator() {
        return this.C.spliterator();
    }
}
