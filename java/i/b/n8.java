package i.b;

import com.google.gson.Gson;
import com.yl.model.Node;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class n8 {
    private static final Type a = new m8().e();
    private static long b;

    public static ArrayList<Node> a(List<Node> list, Collection<Node> collection) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Node node : list) {
                if (node != null) {
                    arrayList.add(node);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return new ArrayList<>();
        }
        HashSet hashSet = new HashSet();
        if (collection != null) {
            for (Node node2 : collection) {
                if (node2 != null) {
                    hashSet.add(Long.valueOf(node2.id));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(((Node) it.next()).id));
        }
        Gson gson = new Gson();
        HashMap map = new HashMap();
        ArrayList<Node> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Node node3 = (Node) it2.next();
            Node node4 = (Node) gson.j(gson.s(node3), Node.class);
            long jC = c(hashSet);
            node4.id = jC;
            hashSet.add(Long.valueOf(jC));
            long j2 = node3.id;
            if (j2 != 0 && !map.containsKey(Long.valueOf(j2))) {
                map.put(Long.valueOf(node3.id), Long.valueOf(node4.id));
            }
            arrayList2.add(node4);
        }
        Iterator<Node> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            d(it3.next(), map, gson);
        }
        return arrayList2;
    }

    private static boolean b(int i2) {
        return i2 == 3 || i2 == 13;
    }

    private static synchronized long c(Set<Long> set) {
        long jMax;
        jMax = Math.max(System.currentTimeMillis(), b + 1);
        while (set.contains(Long.valueOf(jMax))) {
            jMax++;
        }
        b = jMax;
        return jMax;
    }

    private static void d(Node node, Map<Long, Long> map, Gson gson) {
        String str;
        if (b(node.nextType)) {
            long j2 = node.nextTaskId;
            if (j2 == 0) {
                j2 = node.nextId;
            }
            if (j2 != 0) {
                node.nextTaskId = e(j2, map);
            }
        }
        if (b(node.errorType)) {
            long j3 = node.errorId;
            if (j3 != 0) {
                node.errorId = e(j3, map);
            }
        }
        if (node.type != 34 || (str = node.arg1) == null || str.trim().isEmpty()) {
            return;
        }
        try {
            List<Node> list = (List) gson.k(node.arg1, a);
            if (list == null) {
                return;
            }
            for (Node node2 : list) {
                if (node2 != null && b(node2.nextType)) {
                    long j4 = node2.nextTaskId;
                    if (j4 == 0) {
                        j4 = node2.nextId;
                    }
                    if (j4 != 0) {
                        node2.nextId = e(j4, map);
                        node2.nextTaskId = 0L;
                    }
                }
            }
            node.arg1 = gson.s(list);
        } catch (RuntimeException unused) {
        }
    }

    private static long e(long j2, Map<Long, Long> map) {
        Long l2 = map.get(Long.valueOf(j2));
        return l2 == null ? j2 : l2.longValue();
    }
}
