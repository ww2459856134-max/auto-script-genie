package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k0;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements k0.b {
    int A;
    private boolean B;
    d C;
    final a D;
    private final b E;
    private int F;
    private int[] G;
    int r;
    private c s;
    x0 t;
    private boolean u;
    private boolean v;
    boolean w;
    private boolean x;
    private boolean y;
    int z;

    static class a {
        x0 a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            e();
        }

        void a() {
            this.c = this.d ? this.a.i() : this.a.m();
        }

        public void b(View view, int i2) {
            if (this.d) {
                this.c = this.a.d(view) + this.a.o();
            } else {
                this.c = this.a.g(view);
            }
            this.b = i2;
        }

        public void c(View view, int i2) {
            int iO = this.a.o();
            if (iO >= 0) {
                b(view, i2);
                return;
            }
            this.b = i2;
            if (this.d) {
                int i3 = (this.a.i() - iO) - this.a.d(view);
                this.c = this.a.i() - i3;
                if (i3 > 0) {
                    int iE = this.c - this.a.e(view);
                    int iM = this.a.m();
                    int iMin = iE - (iM + Math.min(this.a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.c += Math.min(i3, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.a.g(view);
            int iM2 = iG - this.a.m();
            this.c = iG;
            if (iM2 > 0) {
                int i4 = (this.a.i() - Math.min(0, (this.a.i() - iO) - this.a.d(view))) - (iG + this.a.e(view));
                if (i4 < 0) {
                    this.c -= Math.min(iM2, -i4);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        /* renamed from: j, reason: collision with root package name */
        boolean f318j;

        /* renamed from: k, reason: collision with root package name */
        int f319k;

        /* renamed from: m, reason: collision with root package name */
        boolean f321m;
        boolean a = true;

        /* renamed from: h, reason: collision with root package name */
        int f316h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f317i = 0;

        /* renamed from: l, reason: collision with root package name */
        List<RecyclerView.d0> f320l = null;

        c() {
        }

        private View e() {
            int size = this.f320l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f320l.get(i2).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            if (viewF == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.p) viewF.getLayoutParams()).a();
            }
        }

        boolean c(RecyclerView.a0 a0Var) {
            int i2 = this.d;
            return i2 >= 0 && i2 < a0Var.b();
        }

        View d(RecyclerView.v vVar) {
            if (this.f320l != null) {
                return e();
            }
            View viewO = vVar.o(this.d);
            this.d += this.e;
            return viewO;
        }

        public View f(View view) {
            int iA;
            int size = this.f320l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f320l.get(i3).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (iA = (pVar.a() - this.d) * this.e) >= 0 && iA < i2) {
                    view2 = view3;
                    if (iA == 0) {
                        break;
                    }
                    i2 = iA;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new r0();
        int c;
        int d;
        boolean e;

        public d() {
        }

        boolean a() {
            return this.c >= 0;
        }

        void b() {
            this.c = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }

        d(Parcel parcel) {
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private boolean E2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (J() == 0) {
            return false;
        }
        View viewV = V();
        if (viewV != null && aVar.d(viewV, a0Var)) {
            aVar.c(viewV, g0(viewV));
            return true;
        }
        if (this.u != this.x) {
            return false;
        }
        View viewG2 = aVar.d ? g2(vVar, a0Var) : h2(vVar, a0Var);
        if (viewG2 == null) {
            return false;
        }
        aVar.b(viewG2, g0(viewG2));
        if (!a0Var.e() && H1()) {
            if (this.t.g(viewG2) >= this.t.i() || this.t.d(viewG2) < this.t.m()) {
                aVar.c = aVar.d ? this.t.i() : this.t.m();
            }
        }
        return true;
    }

    private boolean F2(RecyclerView.a0 a0Var, a aVar) {
        int i2;
        if (!a0Var.e() && (i2 = this.z) != -1) {
            if (i2 >= 0 && i2 < a0Var.b()) {
                aVar.b = this.z;
                d dVar = this.C;
                if (dVar != null && dVar.a()) {
                    boolean z = this.C.e;
                    aVar.d = z;
                    if (z) {
                        aVar.c = this.t.i() - this.C.d;
                    } else {
                        aVar.c = this.t.m() + this.C.d;
                    }
                    return true;
                }
                if (this.A != Integer.MIN_VALUE) {
                    boolean z2 = this.w;
                    aVar.d = z2;
                    if (z2) {
                        aVar.c = this.t.i() - this.A;
                    } else {
                        aVar.c = this.t.m() + this.A;
                    }
                    return true;
                }
                View viewC = C(this.z);
                if (viewC == null) {
                    if (J() > 0) {
                        aVar.d = (this.z < g0(I(0))) == this.w;
                    }
                    aVar.a();
                } else {
                    if (this.t.e(viewC) > this.t.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.t.g(viewC) - this.t.m() < 0) {
                        aVar.c = this.t.m();
                        aVar.d = false;
                        return true;
                    }
                    if (this.t.i() - this.t.d(viewC) < 0) {
                        aVar.c = this.t.i();
                        aVar.d = true;
                        return true;
                    }
                    aVar.c = aVar.d ? this.t.d(viewC) + this.t.o() : this.t.g(viewC);
                }
                return true;
            }
            this.z = -1;
            this.A = Integer.MIN_VALUE;
        }
        return false;
    }

    private void G2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (F2(a0Var, aVar) || E2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.b = this.x ? a0Var.b() - 1 : 0;
    }

    private void H2(int i2, int i3, boolean z, RecyclerView.a0 a0Var) {
        int iM;
        this.s.f321m = x2();
        this.s.f = i2;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        I1(a0Var, iArr);
        int iMax = Math.max(0, this.G[0]);
        int iMax2 = Math.max(0, this.G[1]);
        boolean z2 = i2 == 1;
        c cVar = this.s;
        int i4 = z2 ? iMax2 : iMax;
        cVar.f316h = i4;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.f317i = iMax;
        if (z2) {
            cVar.f316h = i4 + this.t.j();
            View viewK2 = k2();
            c cVar2 = this.s;
            cVar2.e = this.w ? -1 : 1;
            int iG0 = g0(viewK2);
            c cVar3 = this.s;
            cVar2.d = iG0 + cVar3.e;
            cVar3.b = this.t.d(viewK2);
            iM = this.t.d(viewK2) - this.t.i();
        } else {
            View viewL2 = l2();
            this.s.f316h += this.t.m();
            c cVar4 = this.s;
            cVar4.e = this.w ? 1 : -1;
            int iG02 = g0(viewL2);
            c cVar5 = this.s;
            cVar4.d = iG02 + cVar5.e;
            cVar5.b = this.t.g(viewL2);
            iM = (-this.t.g(viewL2)) + this.t.m();
        }
        c cVar6 = this.s;
        cVar6.c = i3;
        if (z) {
            cVar6.c = i3 - iM;
        }
        cVar6.g = iM;
    }

    private void I2(int i2, int i3) {
        this.s.c = this.t.i() - i3;
        c cVar = this.s;
        cVar.e = this.w ? -1 : 1;
        cVar.d = i2;
        cVar.f = 1;
        cVar.b = i3;
        cVar.g = Integer.MIN_VALUE;
    }

    private void J2(a aVar) {
        I2(aVar.b, aVar.c);
    }

    private int K1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        P1();
        return f1.a(a0Var, this.t, V1(!this.y, true), U1(!this.y, true), this, this.y);
    }

    private void K2(int i2, int i3) {
        this.s.c = i3 - this.t.m();
        c cVar = this.s;
        cVar.d = i2;
        cVar.e = this.w ? 1 : -1;
        cVar.f = -1;
        cVar.b = i3;
        cVar.g = Integer.MIN_VALUE;
    }

    private int L1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        P1();
        return f1.b(a0Var, this.t, V1(!this.y, true), U1(!this.y, true), this, this.y, this.w);
    }

    private void L2(a aVar) {
        K2(aVar.b, aVar.c);
    }

    private int M1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        P1();
        return f1.c(a0Var, this.t, V1(!this.y, true), U1(!this.y, true), this, this.y);
    }

    private View S1() {
        return b2(0, J());
    }

    private View T1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return f2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View Y1() {
        return b2(J() - 1, -1);
    }

    private View Z1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return f2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View d2() {
        return this.w ? S1() : Y1();
    }

    private View e2() {
        return this.w ? Y1() : S1();
    }

    private View g2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w ? T1(vVar, a0Var) : Z1(vVar, a0Var);
    }

    private View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w ? Z1(vVar, a0Var) : T1(vVar, a0Var);
    }

    private int i2(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i3;
        int i4 = this.t.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -z2(-i4, vVar, a0Var);
        int i6 = i2 + i5;
        if (!z || (i3 = this.t.i() - i6) <= 0) {
            return i5;
        }
        this.t.r(i3);
        return i3 + i5;
    }

    private int j2(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iM2 = i2 - this.t.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i3 = -z2(iM2, vVar, a0Var);
        int i4 = i2 + i3;
        if (!z || (iM = i4 - this.t.m()) <= 0) {
            return i3;
        }
        this.t.r(-iM);
        return i3 - iM;
    }

    private View k2() {
        return I(this.w ? 0 : J() - 1);
    }

    private View l2() {
        return I(this.w ? J() - 1 : 0);
    }

    private void r2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !H1()) {
            return;
        }
        List<RecyclerView.d0> listK = vVar.k();
        int size = listK.size();
        int iG0 = g0(I(0));
        int iE = 0;
        int iE2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.d0 d0Var = listK.get(i4);
            if (!d0Var.isRemoved()) {
                if (((d0Var.getLayoutPosition() < iG0) != this.w ? (char) 65535 : (char) 1) == 65535) {
                    iE += this.t.e(d0Var.itemView);
                } else {
                    iE2 += this.t.e(d0Var.itemView);
                }
            }
        }
        this.s.f320l = listK;
        if (iE > 0) {
            K2(g0(l2()), i2);
            c cVar = this.s;
            cVar.f316h = iE;
            cVar.c = 0;
            cVar.a();
            Q1(vVar, this.s, a0Var, false);
        }
        if (iE2 > 0) {
            I2(g0(k2()), i3);
            c cVar2 = this.s;
            cVar2.f316h = iE2;
            cVar2.c = 0;
            cVar2.a();
            Q1(vVar, this.s, a0Var, false);
        }
        this.s.f320l = null;
    }

    private void t2(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.f321m) {
            return;
        }
        int i2 = cVar.g;
        int i3 = cVar.f317i;
        if (cVar.f == -1) {
            v2(vVar, i2, i3);
        } else {
            w2(vVar, i2, i3);
        }
    }

    private void u2(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                l1(i2, vVar);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                l1(i4, vVar);
            }
        }
    }

    private void v2(RecyclerView.v vVar, int i2, int i3) {
        int iJ = J();
        if (i2 < 0) {
            return;
        }
        int iH = (this.t.h() - i2) + i3;
        if (this.w) {
            for (int i4 = 0; i4 < iJ; i4++) {
                View viewI = I(i4);
                if (this.t.g(viewI) < iH || this.t.q(viewI) < iH) {
                    u2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iJ - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewI2 = I(i6);
            if (this.t.g(viewI2) < iH || this.t.q(viewI2) < iH) {
                u2(vVar, i5, i6);
                return;
            }
        }
    }

    private void w2(RecyclerView.v vVar, int i2, int i3) {
        if (i2 < 0) {
            return;
        }
        int i4 = i2 - i3;
        int iJ = J();
        if (!this.w) {
            for (int i5 = 0; i5 < iJ; i5++) {
                View viewI = I(i5);
                if (this.t.d(viewI) > i4 || this.t.p(viewI) > i4) {
                    u2(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = iJ - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View viewI2 = I(i7);
            if (this.t.d(viewI2) > i4 || this.t.p(viewI2) > i4) {
                u2(vVar, i6, i7);
                return;
            }
        }
    }

    private void y2() {
        if (this.r == 1 || !o2()) {
            this.w = this.v;
        } else {
            this.w = !this.v;
        }
    }

    public void A2(int i2, int i3) {
        this.z = i2;
        this.A = i3;
        d dVar = this.C;
        if (dVar != null) {
            dVar.b();
        }
        r1();
    }

    public void B2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        g(null);
        if (i2 != this.r || this.t == null) {
            x0 x0VarB = x0.b(this, i2);
            this.t = x0VarB;
            this.D.a = x0VarB;
            this.r = i2;
            r1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i2) {
        int iJ = J();
        if (iJ == 0) {
            return null;
        }
        int iG0 = i2 - g0(I(0));
        if (iG0 >= 0 && iG0 < iJ) {
            View viewI = I(iG0);
            if (g0(viewI) == i2) {
                return viewI;
            }
        }
        return super.C(i2);
    }

    public void C2(boolean z) {
        g(null);
        if (z == this.v) {
            return;
        }
        this.v = z;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    public void D2(boolean z) {
        g(null);
        if (this.x == z) {
            return;
        }
        this.x = z;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean E1() {
        return (X() == 1073741824 || o0() == 1073741824 || !p0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void H0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.H0(recyclerView, vVar);
        if (this.B) {
            i1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.C == null && this.u == this.x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View I0(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iN1;
        y2();
        if (J() == 0 || (iN1 = N1(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        P1();
        H2(iN1, (int) (this.t.n() * 0.33333334f), false, a0Var);
        c cVar = this.s;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = false;
        Q1(vVar, cVar, a0Var, true);
        View viewE2 = iN1 == -1 ? e2() : d2();
        View viewL2 = iN1 == -1 ? l2() : k2();
        if (!viewL2.hasFocusable()) {
            return viewE2;
        }
        if (viewE2 == null) {
            return null;
        }
        return viewL2;
    }

    protected void I1(RecyclerView.a0 a0Var, int[] iArr) {
        int i2;
        int iM2 = m2(a0Var);
        if (this.s.f == -1) {
            i2 = 0;
        } else {
            i2 = iM2;
            iM2 = 0;
        }
        iArr[0] = iM2;
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(AccessibilityEvent accessibilityEvent) {
        super.J0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(W1());
            accessibilityEvent.setToIndex(a2());
        }
    }

    void J1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.a aVar) {
        int i2 = cVar.d;
        if (i2 < 0 || i2 >= a0Var.b()) {
            return;
        }
        aVar.a(i2, Math.max(0, cVar.g));
    }

    int N1(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.r == 1) ? 1 : Integer.MIN_VALUE : this.r == 0 ? 1 : Integer.MIN_VALUE : this.r == 1 ? -1 : Integer.MIN_VALUE : this.r == 0 ? -1 : Integer.MIN_VALUE : (this.r != 1 && o2()) ? -1 : 1 : (this.r != 1 && o2()) ? 1 : -1;
    }

    c O1() {
        return new c();
    }

    void P1() {
        if (this.s == null) {
            this.s = O1();
        }
    }

    int Q1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i2 = cVar.c;
        int i3 = cVar.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.g = i3 + i2;
            }
            t2(vVar, cVar);
        }
        int i4 = cVar.c + cVar.f316h;
        b bVar = this.E;
        while (true) {
            if ((!cVar.f321m && i4 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            q2(vVar, a0Var, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!bVar.c || cVar.f320l != null || !a0Var.e()) {
                    int i5 = cVar.c;
                    int i6 = bVar.a;
                    cVar.c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.a;
                    cVar.g = i8;
                    int i9 = cVar.c;
                    if (i9 < 0) {
                        cVar.g = i8 + i9;
                    }
                    t2(vVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.c;
    }

    public int R1() {
        View viewC2 = c2(0, J(), true, false);
        if (viewC2 == null) {
            return -1;
        }
        return g0(viewC2);
    }

    View U1(boolean z, boolean z2) {
        return this.w ? c2(0, J(), z, z2) : c2(J() - 1, -1, z, z2);
    }

    View V1(boolean z, boolean z2) {
        return this.w ? c2(J() - 1, -1, z, z2) : c2(0, J(), z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int iI2;
        int i6;
        View viewC;
        int iG;
        int i7;
        int i8 = -1;
        if (!(this.C == null && this.z == -1) && a0Var.b() == 0) {
            i1(vVar);
            return;
        }
        d dVar = this.C;
        if (dVar != null && dVar.a()) {
            this.z = this.C.c;
        }
        P1();
        this.s.a = false;
        y2();
        View viewV = V();
        a aVar = this.D;
        if (!aVar.e || this.z != -1 || this.C != null) {
            aVar.e();
            a aVar2 = this.D;
            aVar2.d = this.w ^ this.x;
            G2(vVar, a0Var, aVar2);
            this.D.e = true;
        } else if (viewV != null && (this.t.g(viewV) >= this.t.i() || this.t.d(viewV) <= this.t.m())) {
            this.D.c(viewV, g0(viewV));
        }
        c cVar = this.s;
        cVar.f = cVar.f319k >= 0 ? 1 : -1;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        I1(a0Var, iArr);
        int iMax = Math.max(0, this.G[0]) + this.t.m();
        int iMax2 = Math.max(0, this.G[1]) + this.t.j();
        if (a0Var.e() && (i6 = this.z) != -1 && this.A != Integer.MIN_VALUE && (viewC = C(i6)) != null) {
            if (this.w) {
                i7 = this.t.i() - this.t.d(viewC);
                iG = this.A;
            } else {
                iG = this.t.g(viewC) - this.t.m();
                i7 = this.A;
            }
            int i9 = i7 - iG;
            if (i9 > 0) {
                iMax += i9;
            } else {
                iMax2 -= i9;
            }
        }
        a aVar3 = this.D;
        if (!aVar3.d ? !this.w : this.w) {
            i8 = 1;
        }
        s2(vVar, a0Var, aVar3, i8);
        w(vVar);
        this.s.f321m = x2();
        this.s.f318j = a0Var.e();
        this.s.f317i = 0;
        a aVar4 = this.D;
        if (aVar4.d) {
            L2(aVar4);
            c cVar2 = this.s;
            cVar2.f316h = iMax;
            Q1(vVar, cVar2, a0Var, false);
            c cVar3 = this.s;
            i3 = cVar3.b;
            int i10 = cVar3.d;
            int i11 = cVar3.c;
            if (i11 > 0) {
                iMax2 += i11;
            }
            J2(this.D);
            c cVar4 = this.s;
            cVar4.f316h = iMax2;
            cVar4.d += cVar4.e;
            Q1(vVar, cVar4, a0Var, false);
            c cVar5 = this.s;
            i2 = cVar5.b;
            int i12 = cVar5.c;
            if (i12 > 0) {
                K2(i10, i3);
                c cVar6 = this.s;
                cVar6.f316h = i12;
                Q1(vVar, cVar6, a0Var, false);
                i3 = this.s.b;
            }
        } else {
            J2(aVar4);
            c cVar7 = this.s;
            cVar7.f316h = iMax2;
            Q1(vVar, cVar7, a0Var, false);
            c cVar8 = this.s;
            i2 = cVar8.b;
            int i13 = cVar8.d;
            int i14 = cVar8.c;
            if (i14 > 0) {
                iMax += i14;
            }
            L2(this.D);
            c cVar9 = this.s;
            cVar9.f316h = iMax;
            cVar9.d += cVar9.e;
            Q1(vVar, cVar9, a0Var, false);
            c cVar10 = this.s;
            i3 = cVar10.b;
            int i15 = cVar10.c;
            if (i15 > 0) {
                I2(i13, i2);
                c cVar11 = this.s;
                cVar11.f316h = i15;
                Q1(vVar, cVar11, a0Var, false);
                i2 = this.s.b;
            }
        }
        if (J() > 0) {
            if (this.w ^ this.x) {
                int iI22 = i2(i2, vVar, a0Var, true);
                i4 = i3 + iI22;
                i5 = i2 + iI22;
                iI2 = j2(i4, vVar, a0Var, false);
            } else {
                int iJ2 = j2(i3, vVar, a0Var, true);
                i4 = i3 + iJ2;
                i5 = i2 + iJ2;
                iI2 = i2(i5, vVar, a0Var, false);
            }
            i3 = i4 + iI2;
            i2 = i5 + iI2;
        }
        r2(vVar, a0Var, i3, i2);
        if (a0Var.e()) {
            this.D.e();
        } else {
            this.t.s();
        }
        this.u = this.x;
    }

    public int W1() {
        View viewC2 = c2(0, J(), false, true);
        if (viewC2 == null) {
            return -1;
        }
        return g0(viewC2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.a0 a0Var) {
        super.X0(a0Var);
        this.C = null;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.D.e();
    }

    public int X1() {
        View viewC2 = c2(J() - 1, -1, true, false);
        if (viewC2 == null) {
            return -1;
        }
        return g0(viewC2);
    }

    @Override // androidx.recyclerview.widget.k0.b
    public void a(View view, View view2, int i2, int i3) {
        g("Cannot drop a view during a scroll or layout calculation");
        P1();
        y2();
        int iG0 = g0(view);
        int iG02 = g0(view2);
        char c2 = iG0 < iG02 ? (char) 1 : (char) 65535;
        if (this.w) {
            if (c2 == 1) {
                A2(iG02, this.t.i() - (this.t.g(view2) + this.t.e(view)));
                return;
            } else {
                A2(iG02, this.t.i() - this.t.d(view2));
                return;
            }
        }
        if (c2 == 65535) {
            A2(iG02, this.t.g(view2));
        } else {
            A2(iG02, this.t.d(view2) - this.t.e(view));
        }
    }

    public int a2() {
        View viewC2 = c2(J() - 1, -1, false, true);
        if (viewC2 == null) {
            return -1;
        }
        return g0(viewC2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.C = (d) parcelable;
            r1();
        }
    }

    View b2(int i2, int i3) {
        int i4;
        int i5;
        P1();
        if ((i3 > i2 ? (char) 1 : i3 < i2 ? (char) 65535 : (char) 0) == 0) {
            return I(i2);
        }
        if (this.t.g(I(i2)) < this.t.m()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.r == 0 ? this.e.a(i2, i3, i4, i5) : this.f.a(i2, i3, i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable c1() {
        if (this.C != null) {
            return new d(this.C);
        }
        d dVar = new d();
        if (J() > 0) {
            P1();
            boolean z = this.u ^ this.w;
            dVar.e = z;
            if (z) {
                View viewK2 = k2();
                dVar.d = this.t.i() - this.t.d(viewK2);
                dVar.c = g0(viewK2);
            } else {
                View viewL2 = l2();
                dVar.c = g0(viewL2);
                dVar.d = this.t.g(viewL2) - this.t.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    View c2(int i2, int i3, boolean z, boolean z2) {
        P1();
        int i4 = z ? 24579 : 320;
        int i5 = z2 ? 320 : 0;
        return this.r == 0 ? this.e.a(i2, i3, i4, i5) : this.f.a(i2, i3, i4, i5);
    }

    View f2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3, int i4) {
        P1();
        int iM = this.t.m();
        int i5 = this.t.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View viewI = I(i2);
            int iG0 = g0(viewI);
            if (iG0 >= 0 && iG0 < i4) {
                if (((RecyclerView.p) viewI.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.t.g(viewI) < i5 && this.t.d(viewI) >= iM) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.C == null) {
            super.g(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.r == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.r == 1;
    }

    @Deprecated
    protected int m2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.t.n();
        }
        return 0;
    }

    public int n2() {
        return this.r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.o.a aVar) {
        if (this.r != 0) {
            i2 = i3;
        }
        if (J() == 0 || i2 == 0) {
            return;
        }
        P1();
        H2(i2 > 0 ? 1 : -1, Math.abs(i2), true, a0Var);
        J1(a0Var, this.s, aVar);
    }

    protected boolean o2() {
        return Y() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i2, RecyclerView.o.a aVar) {
        boolean z;
        int i3;
        d dVar = this.C;
        if (dVar == null || !dVar.a()) {
            y2();
            z = this.w;
            i3 = this.z;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        } else {
            d dVar2 = this.C;
            z = dVar2.e;
            i3 = dVar2.c;
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.F && i3 >= 0 && i3 < i2; i5++) {
            aVar.a(i3, 0);
            i3 += i4;
        }
    }

    public boolean p2() {
        return this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return K1(a0Var);
    }

    void q2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int iD0;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f320l == null) {
            if (this.w == (cVar.f == -1)) {
                d(viewD);
            } else {
                e(viewD, 0);
            }
        } else {
            if (this.w == (cVar.f == -1)) {
                b(viewD);
            } else {
                c(viewD, 0);
            }
        }
        z0(viewD, 0, 0);
        bVar.a = this.t.e(viewD);
        if (this.r == 1) {
            if (o2()) {
                iF = n0() - e0();
                iD0 = iF - this.t.f(viewD);
            } else {
                iD0 = d0();
                iF = this.t.f(viewD) + iD0;
            }
            if (cVar.f == -1) {
                int i5 = cVar.b;
                i4 = i5;
                i3 = iF;
                i2 = i5 - bVar.a;
            } else {
                int i6 = cVar.b;
                i2 = i6;
                i3 = iF;
                i4 = bVar.a + i6;
            }
        } else {
            int iF0 = f0();
            int iF2 = this.t.f(viewD) + iF0;
            if (cVar.f == -1) {
                int i7 = cVar.b;
                i3 = i7;
                i2 = iF0;
                i4 = iF2;
                iD0 = i7 - bVar.a;
            } else {
                int i8 = cVar.b;
                i2 = iF0;
                i3 = bVar.a + i8;
                i4 = iF2;
                iD0 = i8;
            }
        }
        y0(viewD, iD0, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.c = true;
        }
        bVar.d = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return L1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return M1(a0Var);
    }

    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return K1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return L1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.r == 1) {
            return 0;
        }
        return z2(i2, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return M1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(int i2) {
        this.z = i2;
        this.A = Integer.MIN_VALUE;
        d dVar = this.C;
        if (dVar != null) {
            dVar.b();
        }
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.r == 0) {
            return 0;
        }
        return z2(i2, vVar, a0Var);
    }

    boolean x2() {
        return this.t.k() == 0 && this.t.h() == 0;
    }

    int z2(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i2 == 0) {
            return 0;
        }
        P1();
        this.s.a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        H2(i3, iAbs, true, a0Var);
        c cVar = this.s;
        int iQ1 = cVar.g + Q1(vVar, cVar, a0Var, false);
        if (iQ1 < 0) {
            return 0;
        }
        if (iAbs > iQ1) {
            i2 = i3 * iQ1;
        }
        this.t.r(-i2);
        this.s.f319k = i2;
        return i2;
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        B2(i2);
        C2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        RecyclerView.o.b bVarH0 = RecyclerView.o.h0(context, attributeSet, i2, i3);
        B2(bVarH0.a);
        C2(bVarH0.c);
        D2(bVarH0.d);
    }
}
