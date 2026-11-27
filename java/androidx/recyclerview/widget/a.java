package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class a implements t0 {
    private h.e.i.e<b> a;
    final ArrayList<b> b;
    final ArrayList<b> c;
    final InterfaceC0002a d;
    Runnable e;
    final boolean f;
    final u0 g;

    /* renamed from: h, reason: collision with root package name */
    private int f350h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0002a {
        void a(int i2, int i3);

        void b(b bVar);

        void c(b bVar);

        RecyclerView.d0 d(int i2);

        void e(int i2, int i3);

        void f(int i2, int i3);

        void g(int i2, int i3);

        void h(int i2, int i3, Object obj);
    }

    static class b {
        int a;
        int b;
        Object c;
        int d;

        b(int i2, int i3, int i4, Object obj) {
            this.a = i2;
            this.b = i3;
            this.d = i4;
            this.c = obj;
        }

        String a() {
            int i2 = this.a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.a;
            if (i2 != bVar.a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    a(InterfaceC0002a interfaceC0002a) {
        this(interfaceC0002a, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z;
        char c;
        int i2 = bVar.b;
        int i3 = bVar.d + i2;
        char c2 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.d.d(i4) != null || h(i4)) {
                if (c2 == 0) {
                    k(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    v(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c2 = c;
        }
        if (i5 != bVar.d) {
            b(bVar);
            bVar = a(2, i2, i5, null);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i2 = bVar.b;
        int i3 = bVar.d + i2;
        int i4 = 0;
        boolean z = -1;
        int i5 = i2;
        while (i2 < i3) {
            if (this.d.d(i2) != null || h(i2)) {
                if (!z) {
                    k(a(4, i5, i4, bVar.c));
                    i5 = i2;
                    i4 = 0;
                }
                z = true;
            } else {
                if (z) {
                    v(a(4, i5, i4, bVar.c));
                    i5 = i2;
                    i4 = 0;
                }
                z = false;
            }
            i4++;
            i2++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            b(bVar);
            bVar = a(4, i5, i4, obj);
        }
        if (z) {
            v(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                if (n(bVar.d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.b;
                int i6 = bVar.d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i2;
        int i3 = bVar.a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iZ = z(bVar.b, i3);
        int i4 = bVar.b;
        int i5 = bVar.a;
        if (i5 == 2) {
            i2 = 0;
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i2 = 1;
        }
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.d; i7++) {
            int iZ2 = z(bVar.b + (i2 * i7), bVar.a);
            int i8 = bVar.a;
            if (i8 == 2 ? iZ2 == iZ : i8 == 4 && iZ2 == iZ + 1) {
                i6++;
            } else {
                b bVarA = a(i8, iZ, i6, bVar.c);
                l(bVarA, i4);
                b(bVarA);
                if (bVar.a == 4) {
                    i4 += i6;
                }
                i6 = 1;
                iZ = iZ2;
            }
        }
        Object obj = bVar.c;
        b(bVar);
        if (i6 > 0) {
            b bVarA2 = a(bVar.a, iZ, i6, obj);
            l(bVarA2, i4);
            b(bVarA2);
        }
    }

    private void v(b bVar) {
        this.c.add(bVar);
        int i2 = bVar.a;
        if (i2 == 1) {
            this.d.e(bVar.b, bVar.d);
            return;
        }
        if (i2 == 2) {
            this.d.g(bVar.b, bVar.d);
            return;
        }
        if (i2 == 4) {
            this.d.h(bVar.b, bVar.d, bVar.c);
        } else {
            if (i2 == 8) {
                this.d.a(bVar.b, bVar.d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = this.c.get(size);
            int i6 = bVar.a;
            if (i6 == 8) {
                int i7 = bVar.b;
                int i8 = bVar.d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            bVar.b = i7 + 1;
                            bVar.d = i8 + 1;
                        } else if (i3 == 2) {
                            bVar.b = i7 - 1;
                            bVar.d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        bVar.d = i8 + 1;
                    } else if (i3 == 2) {
                        bVar.d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.b = i7 + 1;
                    } else if (i3 == 2) {
                        bVar.b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = bVar.b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= bVar.d;
                    } else if (i6 == 2) {
                        i2 += bVar.d;
                    }
                } else if (i3 == 1) {
                    bVar.b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.b = i9 - 1;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.c.get(size2);
            if (bVar2.a == 8) {
                int i10 = bVar2.d;
                if (i10 == bVar2.b || i10 < 0) {
                    this.c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.c.remove(size2);
                b(bVar2);
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.t0
    public b a(int i2, int i3, int i4, Object obj) {
        b bVarA = this.a.a();
        if (bVarA == null) {
            return new b(i2, i3, i4, obj);
        }
        bVarA.a = i2;
        bVarA.b = i3;
        bVarA.d = i4;
        bVarA.c = obj;
        return bVarA;
    }

    @Override // androidx.recyclerview.widget.t0
    public void b(b bVar) {
        if (this.f) {
            return;
        }
        bVar.c = null;
        this.a.b(bVar);
    }

    public int e(int i2) {
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    void i() {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.d.c(this.c.get(i2));
        }
        x(this.c);
        this.f350h = 0;
    }

    void j() {
        i();
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                this.d.c(bVar);
                this.d.e(bVar.b, bVar.d);
            } else if (i3 == 2) {
                this.d.c(bVar);
                this.d.f(bVar.b, bVar.d);
            } else if (i3 == 4) {
                this.d.c(bVar);
                this.d.h(bVar.b, bVar.d, bVar.c);
            } else if (i3 == 8) {
                this.d.c(bVar);
                this.d.a(bVar.b, bVar.d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.b);
        this.f350h = 0;
    }

    void l(b bVar, int i2) {
        this.d.b(bVar);
        int i3 = bVar.a;
        if (i3 == 2) {
            this.d.f(i2, bVar.d);
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.d.h(i2, bVar.d, bVar.c);
        }
    }

    int m(int i2) {
        return n(i2, 0);
    }

    int n(int i2, int i3) {
        int size = this.c.size();
        while (i3 < size) {
            b bVar = this.c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                int i5 = bVar.b;
                if (i5 == i2) {
                    i2 = bVar.d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.d;
                }
            }
            i3++;
        }
        return i2;
    }

    boolean o(int i2) {
        return (i2 & this.f350h) != 0;
    }

    boolean p() {
        return this.b.size() > 0;
    }

    boolean q() {
        return (this.c.isEmpty() || this.b.isEmpty()) ? false : true;
    }

    boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.b.add(a(4, i2, i3, obj));
        this.f350h |= 4;
        return this.b.size() == 1;
    }

    boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.b.add(a(1, i2, i3, null));
        this.f350h |= 1;
        return this.b.size() == 1;
    }

    boolean t(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.b.add(a(8, i2, i3, null));
        this.f350h |= 8;
        return this.b.size() == 1;
    }

    boolean u(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.b.add(a(2, i2, i3, null));
        this.f350h |= 2;
        return this.b.size() == 1;
    }

    void w() {
        this.g.b(this.b);
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                c(bVar);
            } else if (i3 == 2) {
                f(bVar);
            } else if (i3 == 4) {
                g(bVar);
            } else if (i3 == 8) {
                d(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.b.clear();
    }

    void x(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(list.get(i2));
        }
        list.clear();
    }

    void y() {
        x(this.b);
        x(this.c);
        this.f350h = 0;
    }

    a(InterfaceC0002a interfaceC0002a, boolean z) {
        this.a = new h.e.i.f(30);
        this.b = new ArrayList<>();
        this.c = new ArrayList<>();
        this.f350h = 0;
        this.d = interfaceC0002a;
        this.f = z;
        this.g = new u0(this);
    }
}
