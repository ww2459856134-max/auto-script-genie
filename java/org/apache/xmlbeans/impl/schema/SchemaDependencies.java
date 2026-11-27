package org.apache.xmlbeans.impl.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes.dex */
public class SchemaDependencies {
    private final Map<String, List<String>> _contributions = new HashMap();
    private final Map<String, Set<String>> _dependencies = new HashMap();

    SchemaDependencies() {
    }

    static /* synthetic */ boolean a(final Set set, Map.Entry entry) {
        Stream stream = ((List) entry.getValue()).stream();
        set.getClass();
        return stream.anyMatch(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.e2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return set.contains((String) obj);
            }
        });
    }

    static /* synthetic */ List c(String str) {
        return new ArrayList();
    }

    static /* synthetic */ Set d(String str) {
        return new HashSet();
    }

    Set<String> computeTransitiveClosure(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet(list);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Set<String> set = this._dependencies.get(arrayList.get(i2));
            if (set != null) {
                for (String str : set) {
                    if (!hashSet.contains(str)) {
                        arrayList.add(str);
                        hashSet.add(str);
                    }
                }
            }
        }
        return hashSet;
    }

    List<String> getFilesTouched(Set<String> set) {
        Stream<String> stream = set.stream();
        final Map<String, List<String>> map = this._contributions;
        map.getClass();
        return (List) stream.map(new Function() { // from class: org.apache.xmlbeans.impl.schema.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (List) map.get((String) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.q1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((List) obj);
            }
        }).flatMap(c.a).collect(Collectors.toList());
    }

    List<String> getNamespacesTouched(final Set<String> set) {
        return (List) this._contributions.entrySet().stream().filter(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.b0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return SchemaDependencies.a(set, (Map.Entry) obj);
            }
        }).map(new Function() { // from class: org.apache.xmlbeans.impl.schema.g2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }).collect(Collectors.toList());
    }

    boolean isFileRepresented(final String str) {
        return this._contributions.values().stream().anyMatch(new Predicate() { // from class: org.apache.xmlbeans.impl.schema.a0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((List) obj).contains(str);
            }
        });
    }

    void registerContribution(String str, String str2) {
        this._contributions.computeIfAbsent(str, new Function() { // from class: org.apache.xmlbeans.impl.schema.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaDependencies.c((String) obj);
            }
        }).add(str2);
    }

    void registerDependency(String str, String str2) {
        this._dependencies.computeIfAbsent(str2, new Function() { // from class: org.apache.xmlbeans.impl.schema.z
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SchemaDependencies.d((String) obj);
            }
        }).add(str);
    }

    SchemaDependencies(SchemaDependencies schemaDependencies, Set<String> set) {
        for (String str : schemaDependencies._dependencies.keySet()) {
            if (!set.contains(str)) {
                HashSet hashSet = new HashSet();
                this._dependencies.put(str, hashSet);
                for (String str2 : schemaDependencies._dependencies.get(str)) {
                    if (!set.contains(str2)) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        for (String str3 : schemaDependencies._contributions.keySet()) {
            if (!set.contains(str3)) {
                ArrayList arrayList = new ArrayList();
                this._contributions.put(str3, arrayList);
                arrayList.addAll(schemaDependencies._contributions.get(str3));
            }
        }
    }
}
