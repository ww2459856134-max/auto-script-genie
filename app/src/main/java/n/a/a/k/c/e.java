package n.a.a.k.c;

import i.b.ha.a.b.d.c.o1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import n.a.a.k.b.z.g;

/* loaded from: classes.dex */
public class e implements c {
    private static int e = -1;
    private static boolean f = false;
    private final Map<String, a> c = new HashMap();
    private InputStream d;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        throw new n.a.a.k.b.z.g("Input file contains an entry with an empty name");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e(b bVar) throws IOException {
        HashSet hashSet = new HashSet();
        while (true) {
            o1 o1VarC = bVar.c();
            if (o1VarC == null) {
                this.d = bVar;
                return;
            }
            String name = o1VarC.getName();
            if (name == null || name.isEmpty()) {
                break;
            }
            String lowerCase = name.toLowerCase(Locale.ROOT);
            if (hashSet.contains(lowerCase)) {
                throw new g("Input file contains more than 1 entry with the name " + o1VarC.getName());
            }
            hashSet.add(lowerCase);
            this.c.put(lowerCase, new a(o1VarC, bVar));
        }
    }

    public static int a() {
        return e;
    }

    public static boolean c() {
        return f;
    }

    @Override // n.a.a.k.c.c
    public Enumeration<? extends o1> A() {
        return Collections.enumeration(this.c.values());
    }

    @Override // n.a.a.k.c.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<a> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.c.clear();
        this.d.close();
    }

    @Override // n.a.a.k.c.c
    public o1 k(String str) {
        String strReplace = str.replace('\\', '/');
        a aVar = this.c.get(strReplace);
        if (aVar != null) {
            return aVar;
        }
        for (Map.Entry<String, a> entry : this.c.entrySet()) {
            if (strReplace.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override // n.a.a.k.c.c
    public boolean l() {
        return this.c.isEmpty();
    }

    @Override // n.a.a.k.c.c
    public InputStream v(o1 o1Var) throws IOException {
        return ((a) o1Var).l0();
    }
}
