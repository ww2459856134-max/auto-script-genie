package n.a.a.n.c.p1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import n.a.a.o.a1;

/* loaded from: classes.dex */
public class s {
    public static final s a = new s();
    private static final Set<Integer> b;
    private static final Set<Integer> c;
    private static final Set<Integer> d;
    private static final Set<Integer> e;
    private static final Set<Integer> f;
    private static final Set<Integer> g;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<Integer> f2374h;

    /* renamed from: i, reason: collision with root package name */
    private static final Set<Integer> f2375i;

    /* renamed from: j, reason: collision with root package name */
    private static final Set<Integer> f2376j;

    /* renamed from: k, reason: collision with root package name */
    private static final Set<Integer> f2377k;

    /* renamed from: l, reason: collision with root package name */
    private static final Set<Integer> f2378l;

    /* renamed from: m, reason: collision with root package name */
    private static final Set<Integer> f2379m;

    /* renamed from: n, reason: collision with root package name */
    private static final Set<Integer> f2380n;

    /* renamed from: o, reason: collision with root package name */
    private static final Set<Integer> f2381o;
    private static final Map<Integer, Set<Integer>> p;

    static {
        HashSet hashSet = new HashSet(Arrays.asList(7, 1));
        b = hashSet;
        HashSet hashSet2 = new HashSet(Arrays.asList(1, 2));
        c = hashSet2;
        HashSet hashSet3 = new HashSet(Arrays.asList(2, 3));
        d = hashSet3;
        HashSet hashSet4 = new HashSet(Arrays.asList(3, 4));
        e = hashSet4;
        HashSet hashSet5 = new HashSet(Arrays.asList(4, 5));
        f = hashSet5;
        HashSet hashSet6 = new HashSet(Arrays.asList(5, 6));
        g = hashSet6;
        HashSet hashSet7 = new HashSet(Arrays.asList(6, 7));
        f2374h = hashSet7;
        Set<Integer> setSingleton = Collections.singleton(2);
        f2375i = setSingleton;
        Set<Integer> setSingleton2 = Collections.singleton(3);
        f2376j = setSingleton2;
        Set<Integer> setSingleton3 = Collections.singleton(4);
        f2377k = setSingleton3;
        Set<Integer> setSingleton4 = Collections.singleton(5);
        f2378l = setSingleton4;
        Set<Integer> setSingleton5 = Collections.singleton(6);
        f2379m = setSingleton5;
        Set<Integer> setSingleton6 = Collections.singleton(7);
        f2380n = setSingleton6;
        Set<Integer> setSingleton7 = Collections.singleton(1);
        f2381o = setSingleton7;
        HashMap map = new HashMap();
        p = map;
        map.put(1, hashSet);
        map.put(2, hashSet2);
        map.put(3, hashSet3);
        map.put(4, hashSet4);
        map.put(5, hashSet5);
        map.put(6, hashSet6);
        map.put(7, hashSet7);
        map.put(11, setSingleton7);
        map.put(12, setSingleton);
        map.put(13, setSingleton2);
        map.put(14, setSingleton3);
        map.put(15, setSingleton4);
        map.put(16, setSingleton5);
        map.put(17, setSingleton6);
    }

    private s() {
    }

    private boolean i(Calendar calendar) {
        return j(calendar, b);
    }

    private boolean j(Calendar calendar, Set<Integer> set) {
        return set.contains(Integer.valueOf(calendar.get(7)));
    }

    protected int a(double d2, double d3, double[] dArr) {
        double[] dArr2 = dArr;
        double dMin = Math.min(d2, d3);
        double dMax = Math.max(d3, d2);
        int length = dArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            double d4 = dArr2[i3];
            int i4 = i2;
            int i5 = length;
            int i6 = i3;
            i2 = (!g(dMin, dMax, d4) || h(d4)) ? i4 : i4 + 1;
            i3 = i6 + 1;
            dArr2 = dArr;
            length = i5;
        }
        int i7 = i2;
        return d2 <= d3 ? i7 : -i7;
    }

    public int b(double d2, double d3, double[] dArr) {
        Set<Integer> set = b;
        Integer[] numArr = (Integer[]) set.toArray(new Integer[set.size()]);
        int iK = numArr.length == 0 ? 0 : k(d2, d3, numArr[0].intValue());
        return ((((int) ((d3 - d2) + 1.0d)) - iK) - (numArr.length > 1 ? k(d2, d3, numArr[1].intValue()) : 0)) - a(d2, d3, dArr);
    }

    public Date c(double d2, int i2, int i3, double[] dArr) {
        Set<Integer> orDefault = p.getOrDefault(Integer.valueOf(i3), b);
        Date dateK = n.a.a.n.d.y.k(d2);
        int i4 = i2 < 0 ? -1 : 1;
        Calendar calendarA = a1.a();
        calendarA.setTime(dateK);
        double dF = n.a.a.n.d.y.f(calendarA.getTime());
        while (i2 != 0) {
            calendarA.add(6, i4);
            dF += i4;
            if (!j(calendarA, orDefault) && !f(dF, dArr)) {
                i2 -= i4;
            }
        }
        return calendarA.getTime();
    }

    public Date d(double d2, int i2, double[] dArr) {
        return c(d2, i2, 1, dArr);
    }

    public Set<Integer> e() {
        return p.keySet();
    }

    protected boolean f(double d2, double[] dArr) {
        for (double d3 : dArr) {
            if (Math.round(d3) == Math.round(d2)) {
                return true;
            }
        }
        return false;
    }

    protected boolean g(double d2, double d3, double d4) {
        return d4 >= d2 && d4 <= d3;
    }

    protected boolean h(double d2) {
        Calendar calendarA = a1.a();
        calendarA.setTime(n.a.a.n.d.y.k(d2));
        return i(calendarA);
    }

    protected int k(double d2, double d3, int i2) {
        int iFloor = (int) Math.floor(Math.max(d3, d2));
        int i3 = 0;
        for (int iFloor2 = (int) Math.floor(Math.min(d2, d3)); iFloor2 <= iFloor; iFloor2++) {
            Calendar calendarA = a1.a();
            calendarA.setTime(n.a.a.n.d.y.k(iFloor2));
            if (calendarA.get(7) == i2) {
                i3++;
            }
        }
        return d2 <= d3 ? i3 : -i3;
    }
}
