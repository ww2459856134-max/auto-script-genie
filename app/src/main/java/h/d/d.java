package h.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class d<E> implements Collection<E>, Set<E> {
    private static final int[] g = new int[0];

    /* renamed from: h, reason: collision with root package name */
    private static final Object[] f1272h = new Object[0];

    /* renamed from: i, reason: collision with root package name */
    private static Object[] f1273i;

    /* renamed from: j, reason: collision with root package name */
    private static int f1274j;

    /* renamed from: k, reason: collision with root package name */
    private static Object[] f1275k;
    private static int t;
    private int[] c;
    Object[] d;
    int e;
    private h<E, E> f;

    public d() {
        this(0);
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (d.class) {
                Object[] objArr = f1275k;
                if (objArr != null) {
                    this.d = objArr;
                    f1275k = (Object[]) objArr[0];
                    this.c = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    t--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (d.class) {
                Object[] objArr2 = f1273i;
                if (objArr2 != null) {
                    this.d = objArr2;
                    f1273i = (Object[]) objArr2[0];
                    this.c = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1274j--;
                    return;
                }
            }
        }
        this.c = new int[i2];
        this.d = new Object[i2];
    }

    private static void e(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (t < 10) {
                    objArr[0] = f1275k;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1275k = objArr;
                    t++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (d.class) {
                if (f1274j < 10) {
                    objArr[0] = f1273i;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1273i = objArr;
                    f1274j++;
                }
            }
        }
    }

    private h<E, E> g() {
        if (this.f == null) {
            this.f = new c(this);
        }
        return this.f;
    }

    private int h(Object obj, int i2) {
        int i3 = this.e;
        if (i3 == 0) {
            return -1;
        }
        int iA = e.a(this.c, i3, i2);
        if (iA < 0 || obj.equals(this.d[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.c[i4] == i2) {
            if (obj.equals(this.d[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.c[i5] == i2; i5--) {
            if (obj.equals(this.d[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    private int j() {
        int i2 = this.e;
        if (i2 == 0) {
            return -1;
        }
        int iA = e.a(this.c, i2, 0);
        if (iA < 0 || this.d[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.c[i3] == 0) {
            if (this.d[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.c[i4] == 0; i4--) {
            if (this.d[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i2;
        int iH;
        if (e == null) {
            iH = j();
            i2 = 0;
        } else {
            int iHashCode = e.hashCode();
            i2 = iHashCode;
            iH = h(e, iHashCode);
        }
        if (iH >= 0) {
            return false;
        }
        int i3 = ~iH;
        int i4 = this.e;
        int[] iArr = this.c;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.d;
            a(i5);
            int[] iArr2 = this.c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.d, 0, objArr.length);
            }
            e(iArr, objArr, this.e);
        }
        int i6 = this.e;
        if (i3 < i6) {
            int[] iArr3 = this.c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, i3, objArr2, i7, this.e - i3);
        }
        this.c[i3] = i2;
        this.d[i3] = e;
        this.e++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.e + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i2) {
        int[] iArr = this.c;
        if (iArr.length < i2) {
            Object[] objArr = this.d;
            a(i2);
            int i3 = this.e;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.c, 0, i3);
                System.arraycopy(objArr, 0, this.d, 0, this.e);
            }
            e(iArr, objArr, this.e);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.e;
        if (i2 != 0) {
            e(this.c, this.d, i2);
            this.c = g;
            this.d = f1272h;
            this.e = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.e; i2++) {
                try {
                    if (!set.contains(l(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.c;
        int i2 = this.e;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? j() : h(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.e <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return g().m().iterator();
    }

    public E k(int i2) {
        Object[] objArr = this.d;
        E e = (E) objArr[i2];
        int i3 = this.e;
        if (i3 <= 1) {
            e(this.c, objArr, i3);
            this.c = g;
            this.d = f1272h;
            this.e = 0;
        } else {
            int[] iArr = this.c;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.e = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.d;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.e - i2);
                }
                this.d[this.e] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.e--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.c, 0, i2);
                    System.arraycopy(objArr, 0, this.d, 0, i2);
                }
                int i6 = this.e;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.c, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.d, i2, this.e - i2);
                }
            }
        }
        return e;
    }

    public E l(int i2) {
        return (E) this.d[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        k(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.e - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.d[i2])) {
                k(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.e;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.e;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.d, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E eL = l(i2);
            if (eL != this) {
                sb.append(eL);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        if (i2 == 0) {
            this.c = g;
            this.d = f1272h;
        } else {
            a(i2);
        }
        this.e = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.e) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.e));
        }
        System.arraycopy(this.d, 0, tArr, 0, this.e);
        int length = tArr.length;
        int i2 = this.e;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
