package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class b0 implements Runnable {
    static final ThreadLocal<b0> g = new ThreadLocal<>();

    /* renamed from: h, reason: collision with root package name */
    static Comparator<c0> f351h = new a0();
    long d;
    long e;
    ArrayList<RecyclerView> c = new ArrayList<>();
    private ArrayList<c0> f = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    static class a implements RecyclerView.o.a {
        int a;
        int b;
        int[] c;
        int d;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.a
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i4 = this.d * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i4 * 2];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i4] = i2;
            iArr4[i4 + 1] = i3;
            this.d++;
        }

        void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.D;
            if (recyclerView.C == null || oVar == null || !oVar.t0()) {
                return;
            }
            if (z) {
                if (!recyclerView.f.p()) {
                    oVar.p(recyclerView.C.getItemCount(), this);
                }
            } else if (!recyclerView.n0()) {
                oVar.o(this.a, this.b, recyclerView.F0, this);
            }
            int i2 = this.d;
            if (i2 > oVar.f340l) {
                oVar.f340l = i2;
                oVar.f341m = z;
                recyclerView.d.K();
            }
        }

        boolean d(int i2) {
            if (this.c != null) {
                int i3 = this.d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    b0() {
    }

    private void b() {
        c0 c0Var;
        int size = this.c.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.c.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.E0.c(recyclerView, false);
                i2 += recyclerView.E0.d;
            }
        }
        this.f.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.c.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.E0;
                int iAbs = Math.abs(aVar.a) + Math.abs(aVar.b);
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i4 >= this.f.size()) {
                        c0Var = new c0();
                        this.f.add(c0Var);
                    } else {
                        c0Var = this.f.get(i4);
                    }
                    int[] iArr = aVar.c;
                    int i7 = iArr[i6 + 1];
                    c0Var.a = i7 <= iAbs;
                    c0Var.b = iAbs;
                    c0Var.c = i7;
                    c0Var.d = recyclerView2;
                    c0Var.e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f, f351h);
    }

    private void c(c0 c0Var, long j2) {
        RecyclerView.d0 d0VarI = i(c0Var.d, c0Var.e, c0Var.a ? Long.MAX_VALUE : j2);
        if (d0VarI == null || d0VarI.mNestedRecyclerView == null || !d0VarI.isBound() || d0VarI.isInvalid()) {
            return;
        }
        h(d0VarI.mNestedRecyclerView.get(), j2);
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            c0 c0Var = this.f.get(i2);
            if (c0Var.d == null) {
                return;
            }
            c(c0Var, j2);
            c0Var.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int iJ = recyclerView.g.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            RecyclerView.d0 d0VarH0 = RecyclerView.h0(recyclerView.g.i(i3));
            if (d0VarH0.mPosition == i2 && !d0VarH0.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.e0 && recyclerView.g.j() != 0) {
            recyclerView.V0();
        }
        a aVar = recyclerView.E0;
        aVar.c(recyclerView, true);
        if (aVar.d != 0) {
            try {
                h.e.f.d.a("RV Nested Prefetch");
                recyclerView.F0.f(recyclerView.C);
                for (int i2 = 0; i2 < aVar.d * 2; i2 += 2) {
                    i(recyclerView, aVar.c[i2], j2);
                }
            } finally {
                h.e.f.d.b();
            }
        }
    }

    private RecyclerView.d0 i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.d;
        try {
            recyclerView.H0();
            RecyclerView.d0 d0VarI = vVar.I(i2, false, j2);
            if (d0VarI != null) {
                if (!d0VarI.isBound() || d0VarI.isInvalid()) {
                    vVar.a(d0VarI, false);
                } else {
                    vVar.B(d0VarI.itemView);
                }
            }
            return d0VarI;
        } finally {
            recyclerView.J0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.c.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.d == 0) {
            this.d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.E0.e(i2, i3);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            h.e.f.d.a("RV Prefetch");
            if (!this.c.isEmpty()) {
                int size = this.c.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.c.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.e);
                }
            }
        } finally {
            this.d = 0L;
            h.e.f.d.b();
        }
    }
}
