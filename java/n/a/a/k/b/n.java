package n.a.a.k.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class n implements Serializable {
    private final Set<String> c = new HashSet();
    private final TreeMap<String, m> d = new TreeMap<>(new Comparator() { // from class: n.a.a.k.b.i
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o.b((String) obj, (String) obj2);
        }
    });

    static /* synthetic */ int e(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    void a() {
        Iterator<m> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public boolean b(o oVar) {
        return oVar != null && this.d.containsKey(oVar.f());
    }

    public m c(o oVar) {
        if (oVar == null) {
            return null;
        }
        return this.d.get(oVar.f());
    }

    public int d(String str) throws n.a.a.k.a.a {
        if (str == null || !str.contains("#")) {
            throw new n.a.a.k.a.a("name template must not be null and contain an index char (#)");
        }
        final Pattern patternCompile = Pattern.compile(str.replace("#", "([0-9]+)"));
        return ((i.i.a.h) this.d.keySet().stream().mapToInt(new ToIntFunction() { // from class: n.a.a.k.b.b
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return n.e(patternCompile, (String) obj);
            }
        }).collect(new Supplier() { // from class: n.a.a.k.b.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return new i.i.a.h();
            }
        }, new ObjIntConsumer() { // from class: n.a.a.k.b.h
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i2) {
                ((i.i.a.h) obj).i(i2);
            }
        }, new BiConsumer() { // from class: n.a.a.k.b.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) throws IndexOutOfBoundsException {
                ((i.i.a.h) obj).g((i.i.a.h) obj2);
            }
        })).d(1);
    }

    public m g(o oVar, m mVar) {
        String strF = oVar.f();
        StringBuilder sb = new StringBuilder();
        for (String str : strF.split("(?=[/])")) {
            sb.append(str);
            if (this.c.contains(sb.toString())) {
                throw new n.a.a.k.a.b("You can't add a part with a part name derived from another part ! [M1.11]");
            }
        }
        this.c.add(strF);
        return this.d.put(strF, mVar);
    }

    public m h(o oVar) {
        if (oVar == null) {
            return null;
        }
        String strF = oVar.f();
        m mVarRemove = this.d.remove(strF);
        if (mVarRemove != null) {
            this.c.remove(strF);
        }
        return mVarRemove;
    }

    public Collection<m> i() {
        return Collections.unmodifiableCollection(this.d.values());
    }
}
