package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import h.e.j.q1.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o {
    private BitSet A;
    private boolean F;
    private boolean G;
    private e H;
    private int I;
    private int[] N;
    f[] s;
    x0 t;
    x0 u;
    private int v;
    private int w;
    private final q0 x;
    private int r = -1;
    boolean y = false;
    boolean z = false;
    int B = -1;
    int C = Integer.MIN_VALUE;
    d D = new d();
    private int E = 2;
    private final Rect J = new Rect();
    private final b K = new b();
    private boolean L = false;
    private boolean M = true;
    private final Runnable O = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.O1();
        }
    }

    class b {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        b() {
            c();
        }

        void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.t.i() : StaggeredGridLayoutManager.this.t.m();
        }

        void b(int i2) {
            if (this.c) {
                this.b = StaggeredGridLayoutManager.this.t.i() - i2;
            } else {
                this.b = StaggeredGridLayoutManager.this.t.m() + i2;
            }
        }

        void c() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.s.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f[i2] = fVarArr[i2].r(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {
        f e;
        boolean f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.e;
            if (fVar == null) {
                return -1;
            }
            return fVar.e;
        }

        public boolean f() {
            return this.f;
        }

        public void g(boolean z) {
            this.f = z;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new i1();
        int c;
        int d;
        int e;
        int[] f;
        int g;

        /* renamed from: h, reason: collision with root package name */
        int[] f346h;

        /* renamed from: i, reason: collision with root package name */
        List<d.a> f347i;

        /* renamed from: j, reason: collision with root package name */
        boolean f348j;

        /* renamed from: k, reason: collision with root package name */
        boolean f349k;
        boolean t;

        public e() {
        }

        void a() {
            this.f = null;
            this.e = 0;
            this.c = -1;
            this.d = -1;
        }

        void b() {
            this.f = null;
            this.e = 0;
            this.g = 0;
            this.f346h = null;
            this.f347i = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.g);
            if (this.g > 0) {
                parcel.writeIntArray(this.f346h);
            }
            parcel.writeInt(this.f348j ? 1 : 0);
            parcel.writeInt(this.f349k ? 1 : 0);
            parcel.writeInt(this.t ? 1 : 0);
            parcel.writeList(this.f347i);
        }

        e(Parcel parcel) {
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            int i2 = parcel.readInt();
            this.e = i2;
            if (i2 > 0) {
                int[] iArr = new int[i2];
                this.f = iArr;
                parcel.readIntArray(iArr);
            }
            int i3 = parcel.readInt();
            this.g = i3;
            if (i3 > 0) {
                int[] iArr2 = new int[i3];
                this.f346h = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f348j = parcel.readInt() == 1;
            this.f349k = parcel.readInt() == 1;
            this.t = parcel.readInt() == 1;
            this.f347i = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.e = eVar.e;
            this.c = eVar.c;
            this.d = eVar.d;
            this.f = eVar.f;
            this.g = eVar.g;
            this.f346h = eVar.f346h;
            this.f348j = eVar.f348j;
            this.f349k = eVar.f349k;
            this.t = eVar.t;
            this.f347i = eVar.f347i;
        }
    }

    class f {
        ArrayList<View> a = new ArrayList<>();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        f(int i2) {
            this.e = i2;
        }

        void a(View view) {
            c cVarP = p(view);
            cVarP.e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (cVarP.c() || cVarP.b()) {
                this.d += StaggeredGridLayoutManager.this.t.e(view);
            }
        }

        void b(boolean z, int i2) {
            int iN = z ? n(Integer.MIN_VALUE) : r(Integer.MIN_VALUE);
            e();
            if (iN == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iN >= StaggeredGridLayoutManager.this.t.i()) {
                if (z || iN <= StaggeredGridLayoutManager.this.t.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        iN += i2;
                    }
                    this.c = iN;
                    this.b = iN;
                }
            }
        }

        void c() {
            d.a aVarF;
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarP = p(view);
            this.c = StaggeredGridLayoutManager.this.t.d(view);
            if (cVarP.f && (aVarF = StaggeredGridLayoutManager.this.D.f(cVarP.a())) != null && aVarF.d == 1) {
                this.c += aVarF.a(this.e);
            }
        }

        void d() {
            d.a aVarF;
            View view = this.a.get(0);
            c cVarP = p(view);
            this.b = StaggeredGridLayoutManager.this.t.g(view);
            if (cVarP.f && (aVarF = StaggeredGridLayoutManager.this.D.f(cVarP.a())) != null && aVarF.d == -1) {
                this.b -= aVarF.a(this.e);
            }
        }

        void e() {
            this.a.clear();
            s();
            this.d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.y ? j(this.a.size() - 1, -1, true) : j(0, this.a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.y ? k(0, this.a.size(), true) : k(this.a.size() - 1, -1, true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.y ? j(0, this.a.size(), true) : j(this.a.size() - 1, -1, true);
        }

        int i(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.t.m();
            int i4 = StaggeredGridLayoutManager.this.t.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.a.get(i2);
                int iG = StaggeredGridLayoutManager.this.t.g(view);
                int iD = StaggeredGridLayoutManager.this.t.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i4 : iG > i4;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i4) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                        if (iG < iM || iD > i4) {
                            return StaggeredGridLayoutManager.this.g0(view);
                        }
                    }
                }
                i2 += i5;
            }
            return -1;
        }

        int j(int i2, int i3, boolean z) {
            return i(i2, i3, false, false, z);
        }

        int k(int i2, int i3, boolean z) {
            return i(i2, i3, z, true, false);
        }

        public int l() {
            return this.d;
        }

        int m() {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.c;
        }

        int n(int i2) {
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            c();
            return this.c;
        }

        public View o(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.y && staggeredGridLayoutManager.g0(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.y && staggeredGridLayoutManager2.g0(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.y && staggeredGridLayoutManager3.g0(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.y && staggeredGridLayoutManager4.g0(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        c p(View view) {
            return (c) view.getLayoutParams();
        }

        int q() {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.b;
        }

        int r(int i2) {
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            d();
            return this.b;
        }

        void s() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void t(int i2) {
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                this.b = i3 + i2;
            }
            int i4 = this.c;
            if (i4 != Integer.MIN_VALUE) {
                this.c = i4 + i2;
            }
        }

        void u() {
            int size = this.a.size();
            View viewRemove = this.a.remove(size - 1);
            c cVarP = p(viewRemove);
            cVarP.e = null;
            if (cVarP.c() || cVarP.b()) {
                this.d -= StaggeredGridLayoutManager.this.t.e(viewRemove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void v() {
            View viewRemove = this.a.remove(0);
            c cVarP = p(viewRemove);
            cVarP.e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (cVarP.c() || cVarP.b()) {
                this.d -= StaggeredGridLayoutManager.this.t.e(viewRemove);
            }
            this.b = Integer.MIN_VALUE;
        }

        void w(View view) {
            c cVarP = p(view);
            cVarP.e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (cVarP.c() || cVarP.b()) {
                this.d += StaggeredGridLayoutManager.this.t.e(view);
            }
        }

        void x(int i2) {
            this.b = i2;
            this.c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.b bVarH0 = RecyclerView.o.h0(context, attributeSet, i2, i3);
        F2(bVarH0.a);
        H2(bVarH0.b);
        G2(bVarH0.c);
        this.x = new q0();
        W1();
    }

    private void A2(RecyclerView.v vVar, int i2) {
        while (J() > 0) {
            View viewI = I(0);
            if (this.t.d(viewI) > i2 || this.t.p(viewI) > i2) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    if (this.s[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.r; i4++) {
                    this.s[i4].v();
                }
            } else if (cVar.e.a.size() == 1) {
                return;
            } else {
                cVar.e.v();
            }
            k1(viewI, vVar);
        }
    }

    private void B2() {
        if (this.u.k() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int iJ = J();
        for (int i2 = 0; i2 < iJ; i2++) {
            View viewI = I(i2);
            float fE = this.u.e(viewI);
            if (fE >= fMax) {
                if (((c) viewI.getLayoutParams()).f()) {
                    fE = (fE * 1.0f) / this.r;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i3 = this.w;
        int iRound = Math.round(fMax * this.r);
        if (this.u.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.u.n());
        }
        N2(iRound);
        if (this.w == i3) {
            return;
        }
        for (int i4 = 0; i4 < iJ; i4++) {
            View viewI2 = I(i4);
            c cVar = (c) viewI2.getLayoutParams();
            if (!cVar.f) {
                if (r2() && this.v == 1) {
                    int i5 = this.r;
                    int i6 = cVar.e.e;
                    viewI2.offsetLeftAndRight(((-((i5 - 1) - i6)) * this.w) - ((-((i5 - 1) - i6)) * i3));
                } else {
                    int i7 = cVar.e.e;
                    int i8 = this.w * i7;
                    int i9 = i7 * i3;
                    if (this.v == 1) {
                        viewI2.offsetLeftAndRight(i8 - i9);
                    } else {
                        viewI2.offsetTopAndBottom(i8 - i9);
                    }
                }
            }
        }
    }

    private void C2() {
        if (this.v == 1 || !r2()) {
            this.z = this.y;
        } else {
            this.z = !this.y;
        }
    }

    private void E2(int i2) {
        q0 q0Var = this.x;
        q0Var.e = i2;
        q0Var.d = this.z != (i2 == -1) ? -1 : 1;
    }

    private void I1(View view) {
        for (int i2 = this.r - 1; i2 >= 0; i2--) {
            this.s[i2].a(view);
        }
    }

    private void I2(int i2, int i3) {
        for (int i4 = 0; i4 < this.r; i4++) {
            if (!this.s[i4].a.isEmpty()) {
                O2(this.s[i4], i2, i3);
            }
        }
    }

    private void J1(b bVar) {
        e eVar = this.H;
        int i2 = eVar.e;
        if (i2 > 0) {
            if (i2 == this.r) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    this.s[i3].e();
                    e eVar2 = this.H;
                    int i4 = eVar2.f[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        i4 += eVar2.f349k ? this.t.i() : this.t.m();
                    }
                    this.s[i3].x(i4);
                }
            } else {
                eVar.b();
                e eVar3 = this.H;
                eVar3.c = eVar3.d;
            }
        }
        e eVar4 = this.H;
        this.G = eVar4.t;
        G2(eVar4.f348j);
        C2();
        e eVar5 = this.H;
        int i5 = eVar5.c;
        if (i5 != -1) {
            this.B = i5;
            bVar.c = eVar5.f349k;
        } else {
            bVar.c = this.z;
        }
        if (eVar5.g > 1) {
            d dVar = this.D;
            dVar.a = eVar5.f346h;
            dVar.b = eVar5.f347i;
        }
    }

    private boolean J2(RecyclerView.a0 a0Var, b bVar) {
        bVar.a = this.F ? d2(a0Var.b()) : Y1(a0Var.b());
        bVar.b = Integer.MIN_VALUE;
        return true;
    }

    private void M1(View view, c cVar, q0 q0Var) {
        if (q0Var.e == 1) {
            if (cVar.f) {
                I1(view);
                return;
            } else {
                cVar.e.a(view);
                return;
            }
        }
        if (cVar.f) {
            x2(view);
        } else {
            cVar.e.w(view);
        }
    }

    private void M2(int i2, RecyclerView.a0 a0Var) {
        int iN;
        int iN2;
        int iC;
        q0 q0Var = this.x;
        boolean z = false;
        q0Var.b = 0;
        q0Var.c = i2;
        if (!w0() || (iC = a0Var.c()) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.z == (iC < i2)) {
                iN = this.t.n();
                iN2 = 0;
            } else {
                iN2 = this.t.n();
                iN = 0;
            }
        }
        if (M()) {
            this.x.f = this.t.m() - iN2;
            this.x.g = this.t.i() + iN;
        } else {
            this.x.g = this.t.h() + iN;
            this.x.f = -iN2;
        }
        q0 q0Var2 = this.x;
        q0Var2.f376h = false;
        q0Var2.a = true;
        if (this.t.k() == 0 && this.t.h() == 0) {
            z = true;
        }
        q0Var2.f377i = z;
    }

    private int N1(int i2) {
        if (J() == 0) {
            return this.z ? 1 : -1;
        }
        return (i2 < g2()) != this.z ? -1 : 1;
    }

    private void O2(f fVar, int i2, int i3) {
        int iL = fVar.l();
        if (i2 == -1) {
            if (fVar.q() + iL <= i3) {
                this.A.set(fVar.e, false);
            }
        } else if (fVar.m() - iL >= i3) {
            this.A.set(fVar.e, false);
        }
    }

    private boolean P1(f fVar) {
        if (this.z) {
            if (fVar.m() < this.t.i()) {
                ArrayList<View> arrayList = fVar.a;
                return !fVar.p(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (fVar.q() > this.t.m()) {
            return !fVar.p(fVar.a.get(0)).f;
        }
        return false;
    }

    private int P2(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    private int Q1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return f1.a(a0Var, this.t, a2(!this.M), Z1(!this.M), this, this.M);
    }

    private int R1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return f1.b(a0Var, this.t, a2(!this.M), Z1(!this.M), this, this.M, this.z);
    }

    private int S1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return f1.c(a0Var, this.t, a2(!this.M), Z1(!this.M), this, this.M);
    }

    private int T1(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.v == 1) ? 1 : Integer.MIN_VALUE : this.v == 0 ? 1 : Integer.MIN_VALUE : this.v == 1 ? -1 : Integer.MIN_VALUE : this.v == 0 ? -1 : Integer.MIN_VALUE : (this.v != 1 && r2()) ? -1 : 1 : (this.v != 1 && r2()) ? 1 : -1;
    }

    private d.a U1(int i2) {
        d.a aVar = new d.a();
        aVar.e = new int[this.r];
        for (int i3 = 0; i3 < this.r; i3++) {
            aVar.e[i3] = i2 - this.s[i3].n(i2);
        }
        return aVar;
    }

    private d.a V1(int i2) {
        d.a aVar = new d.a();
        aVar.e = new int[this.r];
        for (int i3 = 0; i3 < this.r; i3++) {
            aVar.e[i3] = this.s[i3].r(i2) - i2;
        }
        return aVar;
    }

    private void W1() {
        this.t = x0.b(this, this.v);
        this.u = x0.b(this, 1 - this.v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int X1(RecyclerView.v vVar, q0 q0Var, RecyclerView.a0 a0Var) {
        f fVarM2;
        int iE;
        int i2;
        int iE2;
        int iE3;
        boolean z;
        ?? r9 = 0;
        this.A.set(0, this.r, true);
        int i3 = this.x.f377i ? q0Var.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : q0Var.e == 1 ? q0Var.g + q0Var.b : q0Var.f - q0Var.b;
        I2(q0Var.e, i3);
        int i4 = this.z ? this.t.i() : this.t.m();
        boolean z2 = false;
        while (q0Var.a(a0Var) && (this.x.f377i || !this.A.isEmpty())) {
            View viewB = q0Var.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iA = cVar.a();
            int iG = this.D.g(iA);
            boolean z3 = iG == -1 ? true : r9;
            if (z3) {
                fVarM2 = cVar.f ? this.s[r9] : m2(q0Var);
                this.D.n(iA, fVarM2);
            } else {
                fVarM2 = this.s[iG];
            }
            f fVar = fVarM2;
            cVar.e = fVar;
            if (q0Var.e == 1) {
                d(viewB);
            } else {
                e(viewB, r9);
            }
            t2(viewB, cVar, r9);
            if (q0Var.e == 1) {
                int iI2 = cVar.f ? i2(i4) : fVar.n(i4);
                int iE4 = this.t.e(viewB) + iI2;
                if (z3 && cVar.f) {
                    d.a aVarU1 = U1(iI2);
                    aVarU1.d = -1;
                    aVarU1.c = iA;
                    this.D.a(aVarU1);
                }
                i2 = iE4;
                iE = iI2;
            } else {
                int iL2 = cVar.f ? l2(i4) : fVar.r(i4);
                iE = iL2 - this.t.e(viewB);
                if (z3 && cVar.f) {
                    d.a aVarV1 = V1(iL2);
                    aVarV1.d = 1;
                    aVarV1.c = iA;
                    this.D.a(aVarV1);
                }
                i2 = iL2;
            }
            if (cVar.f && q0Var.d == -1) {
                if (z3) {
                    this.L = true;
                } else {
                    if (!(q0Var.e == 1 ? K1() : L1())) {
                        d.a aVarF = this.D.f(iA);
                        if (aVarF != null) {
                            aVarF.f = true;
                        }
                        this.L = true;
                    }
                }
            }
            M1(viewB, cVar, q0Var);
            if (r2() && this.v == 1) {
                int i5 = cVar.f ? this.u.i() : this.u.i() - (((this.r - 1) - fVar.e) * this.w);
                iE3 = i5;
                iE2 = i5 - this.u.e(viewB);
            } else {
                int iM = cVar.f ? this.u.m() : (fVar.e * this.w) + this.u.m();
                iE2 = iM;
                iE3 = this.u.e(viewB) + iM;
            }
            if (this.v == 1) {
                y0(viewB, iE2, iE, iE3, i2);
            } else {
                y0(viewB, iE, iE2, i2, iE3);
            }
            if (cVar.f) {
                I2(this.x.e, i3);
            } else {
                O2(fVar, this.x.e, i3);
            }
            y2(vVar, this.x);
            if (!this.x.f376h || !viewB.hasFocusable()) {
                z = false;
            } else if (cVar.f) {
                this.A.clear();
                z = false;
            } else {
                z = false;
                this.A.set(fVar.e, false);
            }
            r9 = z;
            z2 = true;
        }
        int i6 = r9;
        if (!z2) {
            y2(vVar, this.x);
        }
        int iM2 = this.x.e == -1 ? this.t.m() - l2(this.t.m()) : i2(this.t.i()) - this.t.i();
        return iM2 > 0 ? Math.min(q0Var.b, iM2) : i6;
    }

    private int Y1(int i2) {
        int iJ = J();
        for (int i3 = 0; i3 < iJ; i3++) {
            int iG0 = g0(I(i3));
            if (iG0 >= 0 && iG0 < i2) {
                return iG0;
            }
        }
        return 0;
    }

    private int d2(int i2) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            int iG0 = g0(I(iJ));
            if (iG0 >= 0 && iG0 < i2) {
                return iG0;
            }
        }
        return 0;
    }

    private void e2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i2;
        int iI2 = i2(Integer.MIN_VALUE);
        if (iI2 != Integer.MIN_VALUE && (i2 = this.t.i() - iI2) > 0) {
            int i3 = i2 - (-D2(-i2, vVar, a0Var));
            if (!z || i3 <= 0) {
                return;
            }
            this.t.r(i3);
        }
    }

    private void f2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iL2 = l2(Integer.MAX_VALUE);
        if (iL2 != Integer.MAX_VALUE && (iM = iL2 - this.t.m()) > 0) {
            int iD2 = iM - D2(iM, vVar, a0Var);
            if (!z || iD2 <= 0) {
                return;
            }
            this.t.r(-iD2);
        }
    }

    private int i2(int i2) {
        int iN = this.s[0].n(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iN2 = this.s[i3].n(i2);
            if (iN2 > iN) {
                iN = iN2;
            }
        }
        return iN;
    }

    private int j2(int i2) {
        int iR = this.s[0].r(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iR2 = this.s[i3].r(i2);
            if (iR2 > iR) {
                iR = iR2;
            }
        }
        return iR;
    }

    private int k2(int i2) {
        int iN = this.s[0].n(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iN2 = this.s[i3].n(i2);
            if (iN2 < iN) {
                iN = iN2;
            }
        }
        return iN;
    }

    private int l2(int i2) {
        int iR = this.s[0].r(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int iR2 = this.s[i3].r(i2);
            if (iR2 < iR) {
                iR = iR2;
            }
        }
        return iR;
    }

    private f m2(q0 q0Var) {
        int i2;
        int i3;
        int i4 = -1;
        if (v2(q0Var.e)) {
            i2 = this.r - 1;
            i3 = -1;
        } else {
            i2 = 0;
            i4 = this.r;
            i3 = 1;
        }
        f fVar = null;
        if (q0Var.e == 1) {
            int i5 = Integer.MAX_VALUE;
            int iM = this.t.m();
            while (i2 != i4) {
                f fVar2 = this.s[i2];
                int iN = fVar2.n(iM);
                if (iN < i5) {
                    fVar = fVar2;
                    i5 = iN;
                }
                i2 += i3;
            }
            return fVar;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = this.t.i();
        while (i2 != i4) {
            f fVar3 = this.s[i2];
            int iR = fVar3.r(i7);
            if (iR > i6) {
                fVar = fVar3;
                i6 = iR;
            }
            i2 += i3;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o2(int i2, int i3, int i4) {
        int i5;
        int i6;
        int iH2 = this.z ? h2() : g2();
        if (i4 != 8) {
            i5 = i2 + i3;
        } else {
            if (i2 >= i3) {
                i5 = i2 + 1;
                i6 = i3;
                this.D.h(i6);
                if (i4 != 1) {
                    this.D.j(i2, i3);
                } else if (i4 == 2) {
                    this.D.k(i2, i3);
                } else if (i4 == 8) {
                    this.D.k(i2, 1);
                    this.D.j(i3, 1);
                }
                if (i5 > iH2) {
                    return;
                }
                if (i6 <= (this.z ? g2() : h2())) {
                    r1();
                    return;
                }
                return;
            }
            i5 = i3 + 1;
        }
        i6 = i2;
        this.D.h(i6);
        if (i4 != 1) {
        }
        if (i5 > iH2) {
        }
    }

    private void s2(View view, int i2, int i3, boolean z) {
        j(view, this.J);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.J;
        int iP2 = P2(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.J;
        int iP22 = P2(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? F1(view, iP2, iP22, cVar) : D1(view, iP2, iP22, cVar)) {
            view.measure(iP2, iP22);
        }
    }

    private void t2(View view, c cVar, boolean z) {
        if (cVar.f) {
            if (this.v == 1) {
                s2(view, this.I, RecyclerView.o.K(W(), X(), f0() + c0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
                return;
            } else {
                s2(view, RecyclerView.o.K(n0(), o0(), d0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.I, z);
                return;
            }
        }
        if (this.v == 1) {
            s2(view, RecyclerView.o.K(this.w, o0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.K(W(), X(), f0() + c0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z);
        } else {
            s2(view, RecyclerView.o.K(n0(), o0(), d0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.K(this.w, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        e eVar;
        b bVar = this.K;
        if (!(this.H == null && this.B == -1) && a0Var.b() == 0) {
            i1(vVar);
            bVar.c();
            return;
        }
        boolean z2 = true;
        boolean z3 = (bVar.e && this.B == -1 && this.H == null) ? false : true;
        if (z3) {
            bVar.c();
            if (this.H != null) {
                J1(bVar);
            } else {
                C2();
                bVar.c = this.z;
            }
            L2(a0Var, bVar);
            bVar.e = true;
        }
        if (this.H == null && this.B == -1 && (bVar.c != this.F || r2() != this.G)) {
            this.D.b();
            bVar.d = true;
        }
        if (J() > 0 && ((eVar = this.H) == null || eVar.e < 1)) {
            if (bVar.d) {
                for (int i2 = 0; i2 < this.r; i2++) {
                    this.s[i2].e();
                    int i3 = bVar.b;
                    if (i3 != Integer.MIN_VALUE) {
                        this.s[i2].x(i3);
                    }
                }
            } else if (z3 || this.K.f == null) {
                for (int i4 = 0; i4 < this.r; i4++) {
                    this.s[i4].b(this.z, bVar.b);
                }
                this.K.d(this.s);
            } else {
                for (int i5 = 0; i5 < this.r; i5++) {
                    f fVar = this.s[i5];
                    fVar.e();
                    fVar.x(this.K.f[i5]);
                }
            }
        }
        w(vVar);
        this.x.a = false;
        this.L = false;
        N2(this.u.n());
        M2(bVar.a, a0Var);
        if (bVar.c) {
            E2(-1);
            X1(vVar, this.x, a0Var);
            E2(1);
            q0 q0Var = this.x;
            q0Var.c = bVar.a + q0Var.d;
            X1(vVar, q0Var, a0Var);
        } else {
            E2(1);
            X1(vVar, this.x, a0Var);
            E2(-1);
            q0 q0Var2 = this.x;
            q0Var2.c = bVar.a + q0Var2.d;
            X1(vVar, q0Var2, a0Var);
        }
        B2();
        if (J() > 0) {
            if (this.z) {
                e2(vVar, a0Var, true);
                f2(vVar, a0Var, false);
            } else {
                f2(vVar, a0Var, true);
                e2(vVar, a0Var, false);
            }
        }
        if (!z || a0Var.e()) {
            z2 = false;
        } else if (this.E != 0 && J() > 0 && (this.L || p2() != null)) {
            m1(this.O);
            if (!O1()) {
            }
        }
        if (a0Var.e()) {
            this.K.c();
        }
        this.F = bVar.c;
        this.G = r2();
        if (z2) {
            this.K.c();
            u2(vVar, a0Var, false);
        }
    }

    private boolean v2(int i2) {
        if (this.v == 0) {
            return (i2 == -1) != this.z;
        }
        return ((i2 == -1) == this.z) == r2();
    }

    private void x2(View view) {
        for (int i2 = this.r - 1; i2 >= 0; i2--) {
            this.s[i2].w(view);
        }
    }

    private void y2(RecyclerView.v vVar, q0 q0Var) {
        if (!q0Var.a || q0Var.f377i) {
            return;
        }
        if (q0Var.b == 0) {
            if (q0Var.e == -1) {
                z2(vVar, q0Var.g);
                return;
            } else {
                A2(vVar, q0Var.f);
                return;
            }
        }
        if (q0Var.e != -1) {
            int iK2 = k2(q0Var.g) - q0Var.g;
            A2(vVar, iK2 < 0 ? q0Var.f : Math.min(iK2, q0Var.b) + q0Var.f);
        } else {
            int i2 = q0Var.f;
            int iJ2 = i2 - j2(i2);
            z2(vVar, iJ2 < 0 ? q0Var.g : q0Var.g - Math.min(iJ2, q0Var.b));
        }
    }

    private void z2(RecyclerView.v vVar, int i2) {
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            if (this.t.g(viewI) < i2 || this.t.q(viewI) < i2) {
                return;
            }
            c cVar = (c) viewI.getLayoutParams();
            if (cVar.f) {
                for (int i3 = 0; i3 < this.r; i3++) {
                    if (this.s[i3].a.size() == 1) {
                        return;
                    }
                }
                for (int i4 = 0; i4 < this.r; i4++) {
                    this.s[i4].u();
                }
            } else if (cVar.e.a.size() == 1) {
                return;
            } else {
                cVar.e.u();
            }
            k1(viewI, vVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void A1(Rect rect, int i2, int i3) {
        int iN;
        int iN2;
        int iD0 = d0() + e0();
        int iF0 = f0() + c0();
        if (this.v == 1) {
            iN2 = RecyclerView.o.n(i3, rect.height() + iF0, a0());
            iN = RecyclerView.o.n(i2, (this.w * this.r) + iD0, b0());
        } else {
            iN = RecyclerView.o.n(i2, rect.width() + iD0, b0());
            iN2 = RecyclerView.o.n(i3, (this.w * this.r) + iF0, a0());
        }
        z1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void B0(int i2) {
        super.B0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            this.s[i3].t(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i2) {
        super.C0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            this.s[i3].t(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.v == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    int D2(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i2 == 0) {
            return 0;
        }
        w2(i2, a0Var);
        int iX1 = X1(vVar, this.x, a0Var);
        if (this.x.b >= iX1) {
            i2 = i2 < 0 ? -iX1 : iX1;
        }
        this.t.r(-i2);
        this.F = this.z;
        q0 q0Var = this.x;
        q0Var.b = 0;
        y2(vVar, q0Var);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public void F2(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i2 == this.v) {
            return;
        }
        this.v = i2;
        x0 x0Var = this.t;
        this.t = this.u;
        this.u = x0Var;
        r1();
    }

    public void G2(boolean z) {
        g(null);
        e eVar = this.H;
        if (eVar != null && eVar.f348j != z) {
            eVar.f348j = z;
        }
        this.y = z;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void H0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.H0(recyclerView, vVar);
        m1(this.O);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.s[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.H == null;
    }

    public void H2(int i2) {
        g(null);
        if (i2 != this.r) {
            q2();
            this.r = i2;
            this.A = new BitSet(this.r);
            this.s = new f[this.r];
            for (int i3 = 0; i3 < this.r; i3++) {
                this.s[i3] = new f(i3);
            }
            r1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View I0(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewB;
        View viewO;
        if (J() == 0 || (viewB = B(view)) == null) {
            return null;
        }
        C2();
        int iT1 = T1(i2);
        if (iT1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewB.getLayoutParams();
        boolean z = cVar.f;
        f fVar = cVar.e;
        int iH2 = iT1 == 1 ? h2() : g2();
        M2(iH2, a0Var);
        E2(iT1);
        q0 q0Var = this.x;
        q0Var.c = q0Var.d + iH2;
        q0Var.b = (int) (this.t.n() * 0.33333334f);
        q0 q0Var2 = this.x;
        q0Var2.f376h = true;
        q0Var2.a = false;
        X1(vVar, q0Var2, a0Var);
        this.F = this.z;
        if (!z && (viewO = fVar.o(iH2, iT1)) != null && viewO != viewB) {
            return viewO;
        }
        if (v2(iT1)) {
            for (int i3 = this.r - 1; i3 >= 0; i3--) {
                View viewO2 = this.s[i3].o(iH2, iT1);
                if (viewO2 != null && viewO2 != viewB) {
                    return viewO2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.r; i4++) {
                View viewO3 = this.s[i4].o(iH2, iT1);
                if (viewO3 != null && viewO3 != viewB) {
                    return viewO3;
                }
            }
        }
        boolean z2 = (this.y ^ true) == (iT1 == -1);
        if (!z) {
            View viewC = C(z2 ? fVar.f() : fVar.h());
            if (viewC != null && viewC != viewB) {
                return viewC;
            }
        }
        if (v2(iT1)) {
            for (int i5 = this.r - 1; i5 >= 0; i5--) {
                if (i5 != fVar.e) {
                    View viewC2 = C(z2 ? this.s[i5].f() : this.s[i5].h());
                    if (viewC2 != null && viewC2 != viewB) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.r; i6++) {
                View viewC3 = C(z2 ? this.s[i6].f() : this.s[i6].h());
                if (viewC3 != null && viewC3 != viewB) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(AccessibilityEvent accessibilityEvent) {
        super.J0(accessibilityEvent);
        if (J() > 0) {
            View viewA2 = a2(false);
            View viewZ1 = Z1(false);
            if (viewA2 == null || viewZ1 == null) {
                return;
            }
            int iG0 = g0(viewA2);
            int iG02 = g0(viewZ1);
            if (iG0 < iG02) {
                accessibilityEvent.setFromIndex(iG0);
                accessibilityEvent.setToIndex(iG02);
            } else {
                accessibilityEvent.setFromIndex(iG02);
                accessibilityEvent.setToIndex(iG0);
            }
        }
    }

    boolean K1() {
        int iN = this.s[0].n(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.r; i2++) {
            if (this.s[i2].n(Integer.MIN_VALUE) != iN) {
                return false;
            }
        }
        return true;
    }

    boolean K2(RecyclerView.a0 a0Var, b bVar) {
        int i2;
        if (!a0Var.e() && (i2 = this.B) != -1) {
            if (i2 >= 0 && i2 < a0Var.b()) {
                e eVar = this.H;
                if (eVar == null || eVar.c == -1 || eVar.e < 1) {
                    View viewC = C(this.B);
                    if (viewC != null) {
                        bVar.a = this.z ? h2() : g2();
                        if (this.C != Integer.MIN_VALUE) {
                            if (bVar.c) {
                                bVar.b = (this.t.i() - this.C) - this.t.d(viewC);
                            } else {
                                bVar.b = (this.t.m() + this.C) - this.t.g(viewC);
                            }
                            return true;
                        }
                        if (this.t.e(viewC) > this.t.n()) {
                            bVar.b = bVar.c ? this.t.i() : this.t.m();
                            return true;
                        }
                        int iG = this.t.g(viewC) - this.t.m();
                        if (iG < 0) {
                            bVar.b = -iG;
                            return true;
                        }
                        int i3 = this.t.i() - this.t.d(viewC);
                        if (i3 < 0) {
                            bVar.b = i3;
                            return true;
                        }
                        bVar.b = Integer.MIN_VALUE;
                    } else {
                        int i4 = this.B;
                        bVar.a = i4;
                        int i5 = this.C;
                        if (i5 == Integer.MIN_VALUE) {
                            bVar.c = N1(i4) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i5);
                        }
                        bVar.d = true;
                    }
                } else {
                    bVar.b = Integer.MIN_VALUE;
                    bVar.a = this.B;
                }
                return true;
            }
            this.B = -1;
            this.C = Integer.MIN_VALUE;
        }
        return false;
    }

    boolean L1() {
        int iR = this.s[0].r(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.r; i2++) {
            if (this.s[i2].r(Integer.MIN_VALUE) != iR) {
                return false;
            }
        }
        return true;
    }

    void L2(RecyclerView.a0 a0Var, b bVar) {
        if (K2(a0Var, bVar) || J2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.v == 1 ? this.r : super.N(vVar, a0Var);
    }

    void N2(int i2) {
        this.w = i2 / this.r;
        this.I = View.MeasureSpec.makeMeasureSpec(i2, this.u.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, h.e.j.q1.e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.N0(view, eVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.v == 0) {
            eVar.X(e.a.f(cVar.e(), cVar.f ? this.r : 1, -1, -1, false, false));
        } else {
            eVar.X(e.a.f(-1, -1, cVar.e(), cVar.f ? this.r : 1, false, false));
        }
    }

    boolean O1() {
        int iG2;
        int iH2;
        if (J() == 0 || this.E == 0 || !q0()) {
            return false;
        }
        if (this.z) {
            iG2 = h2();
            iH2 = g2();
        } else {
            iG2 = g2();
            iH2 = h2();
        }
        if (iG2 == 0 && p2() != null) {
            this.D.b();
            s1();
            r1();
            return true;
        }
        if (!this.L) {
            return false;
        }
        int i2 = this.z ? -1 : 1;
        int i3 = iH2 + 1;
        d.a aVarE = this.D.e(iG2, i3, i2, true);
        if (aVarE == null) {
            this.L = false;
            this.D.d(i3);
            return false;
        }
        d.a aVarE2 = this.D.e(iG2, aVarE.c, i2 * (-1), true);
        if (aVarE2 == null) {
            this.D.d(aVarE.c);
        } else {
            this.D.d(aVarE2.c + 1);
        }
        s1();
        r1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView recyclerView, int i2, int i3) {
        o2(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView) {
        this.D.b();
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        o2(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i2, int i3) {
        o2(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        o2(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        u2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.a0 a0Var) {
        super.X0(a0Var);
        this.B = -1;
        this.C = Integer.MIN_VALUE;
        this.H = null;
        this.K.c();
    }

    View Z1(boolean z) {
        int iM = this.t.m();
        int i2 = this.t.i();
        View view = null;
        for (int iJ = J() - 1; iJ >= 0; iJ--) {
            View viewI = I(iJ);
            int iG = this.t.g(viewI);
            int iD = this.t.d(viewI);
            if (iD > iM && iG < i2) {
                if (iD <= i2 || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    View a2(boolean z) {
        int iM = this.t.m();
        int i2 = this.t.i();
        int iJ = J();
        View view = null;
        for (int i3 = 0; i3 < iJ; i3++) {
            View viewI = I(i3);
            int iG = this.t.g(viewI);
            if (this.t.d(viewI) > iM && iG < i2) {
                if (iG >= iM || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.H = (e) parcelable;
            r1();
        }
    }

    int b2() {
        View viewZ1 = this.z ? Z1(true) : a2(true);
        if (viewZ1 == null) {
            return -1;
        }
        return g0(viewZ1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable c1() {
        int iR;
        int iM;
        int[] iArr;
        if (this.H != null) {
            return new e(this.H);
        }
        e eVar = new e();
        eVar.f348j = this.y;
        eVar.f349k = this.F;
        eVar.t = this.G;
        d dVar = this.D;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar.g = 0;
        } else {
            eVar.f346h = iArr;
            eVar.g = iArr.length;
            eVar.f347i = dVar.b;
        }
        if (J() > 0) {
            eVar.c = this.F ? h2() : g2();
            eVar.d = b2();
            int i2 = this.r;
            eVar.e = i2;
            eVar.f = new int[i2];
            for (int i3 = 0; i3 < this.r; i3++) {
                if (this.F) {
                    iR = this.s[i3].n(Integer.MIN_VALUE);
                    if (iR != Integer.MIN_VALUE) {
                        iM = this.t.i();
                        iR -= iM;
                    }
                } else {
                    iR = this.s[i3].r(Integer.MIN_VALUE);
                    if (iR != Integer.MIN_VALUE) {
                        iM = this.t.m();
                        iR -= iM;
                    }
                }
                eVar.f[i3] = iR;
            }
        } else {
            eVar.c = -1;
            eVar.d = -1;
            eVar.e = 0;
        }
        return eVar;
    }

    public int[] c2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.r];
        } else if (iArr.length < this.r) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.r + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.r; i2++) {
            iArr[i2] = this.s[i2].g();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(int i2) {
        if (i2 == 0) {
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.H == null) {
            super.g(str);
        }
    }

    int g2() {
        if (J() == 0) {
            return 0;
        }
        return g0(I(0));
    }

    int h2() {
        int iJ = J();
        if (iJ == 0) {
            return 0;
        }
        return g0(I(iJ - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int j0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.v == 0 ? this.r : super.j0(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.v == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.v == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public int n2() {
        return this.r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.o.a aVar) {
        int iN;
        int iR;
        if (this.v != 0) {
            i2 = i3;
        }
        if (J() == 0 || i2 == 0) {
            return;
        }
        w2(i2, a0Var);
        int[] iArr = this.N;
        if (iArr == null || iArr.length < this.r) {
            this.N = new int[this.r];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.r; i5++) {
            q0 q0Var = this.x;
            if (q0Var.d == -1) {
                iN = q0Var.f;
                iR = this.s[i5].r(iN);
            } else {
                iN = this.s[i5].n(q0Var.g);
                iR = this.x.g;
            }
            int i6 = iN - iR;
            if (i6 >= 0) {
                this.N[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.N, 0, i4);
        for (int i7 = 0; i7 < i4 && this.x.a(a0Var); i7++) {
            aVar.a(this.x.c, this.N[i7]);
            q0 q0Var2 = this.x;
            q0Var2.c += q0Var2.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View p2() {
        int i2;
        int i3;
        boolean z;
        int iJ = J() - 1;
        BitSet bitSet = new BitSet(this.r);
        bitSet.set(0, this.r, true);
        char c2 = (this.v == 1 && r2()) ? (char) 1 : (char) 65535;
        if (this.z) {
            i2 = -1;
        } else {
            i2 = iJ + 1;
            iJ = 0;
        }
        int i4 = iJ < i2 ? 1 : -1;
        while (iJ != i2) {
            View viewI = I(iJ);
            c cVar = (c) viewI.getLayoutParams();
            if (bitSet.get(cVar.e.e)) {
                if (P1(cVar.e)) {
                    return viewI;
                }
                bitSet.clear(cVar.e.e);
            }
            if (!cVar.f && (i3 = iJ + i4) != i2) {
                View viewI2 = I(i3);
                if (this.z) {
                    int iD = this.t.d(viewI);
                    int iD2 = this.t.d(viewI2);
                    if (iD < iD2) {
                        return viewI;
                    }
                    z = iD == iD2;
                } else {
                    int iG = this.t.g(viewI);
                    int iG2 = this.t.g(viewI2);
                    if (iG > iG2) {
                        return viewI;
                    }
                    if (iG == iG2) {
                    }
                }
                if (z) {
                    if ((cVar.e.e - ((c) viewI2.getLayoutParams()).e.e < 0) != (c2 < 0)) {
                        return viewI;
                    }
                } else {
                    continue;
                }
            }
            iJ += i4;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    public void q2() {
        this.D.b();
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return R1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean r0() {
        return this.E != 0;
    }

    boolean r2() {
        return Y() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return S1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return Q1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return R1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return D2(i2, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return S1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(int i2) {
        e eVar = this.H;
        if (eVar != null && eVar.c != i2) {
            eVar.a();
        }
        this.B = i2;
        this.C = Integer.MIN_VALUE;
        r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return D2(i2, vVar, a0Var);
    }

    void w2(int i2, RecyclerView.a0 a0Var) {
        int i3;
        int iG2;
        if (i2 > 0) {
            iG2 = h2();
            i3 = 1;
        } else {
            i3 = -1;
            iG2 = g2();
        }
        this.x.a = true;
        M2(iG2, a0Var);
        E2(i3);
        q0 q0Var = this.x;
        q0Var.c = iG2 + q0Var.d;
        q0Var.b = Math.abs(i2);
    }

    static class d {
        int[] a;
        List<a> b;

        d() {
        }

        private int i(int i2) {
            if (this.b == null) {
                return -1;
            }
            a aVarF = f(i2);
            if (aVarF != null) {
                this.b.remove(aVarF);
            }
            int size = this.b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (this.b.get(i3).c >= i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return -1;
            }
            a aVar = this.b.get(i3);
            this.b.remove(i3);
            return aVar.c;
        }

        private void l(int i2, int i3) {
            List<a> list = this.b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                int i4 = aVar.c;
                if (i4 >= i2) {
                    aVar.c = i4 + i3;
                }
            }
        }

        private void m(int i2, int i3) {
            List<a> list = this.b;
            if (list == null) {
                return;
            }
            int i4 = i2 + i3;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                int i5 = aVar.c;
                if (i5 >= i2) {
                    if (i5 < i4) {
                        this.b.remove(size);
                    } else {
                        aVar.c = i5 - i3;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.b.get(i2);
                if (aVar2.c == aVar.c) {
                    this.b.remove(i2);
                }
                if (aVar2.c >= aVar.c) {
                    this.b.add(i2, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        void b() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        void c(int i2) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i2, 10) + 1];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i2) {
            List<a> list = this.b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).c >= i2) {
                        this.b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public a e(int i2, int i3, int i4, boolean z) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = this.b.get(i5);
                int i6 = aVar.c;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.d == i4 || (z && aVar.f))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i2) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.c == i2) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i2) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        int h(int i2) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.a.length;
            }
            int i4 = i3 + 1;
            Arrays.fill(this.a, i2, i4, -1);
            return i4;
        }

        void j(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
            Arrays.fill(this.a, i2, i4, -1);
            l(i2, i3);
        }

        void k(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return;
            }
            int i4 = i2 + i3;
            c(i4);
            int[] iArr2 = this.a;
            System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
            int[] iArr3 = this.a;
            Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
            m(i2, i3);
        }

        void n(int i2, f fVar) {
            c(i2);
            this.a[i2] = fVar.e;
        }

        int o(int i2) {
            int length = this.a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new h1();
            int c;
            int d;
            int[] e;
            boolean f;

            a(Parcel parcel) {
                this.c = parcel.readInt();
                this.d = parcel.readInt();
                this.f = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    this.e = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int a(int i2) {
                int[] iArr = this.e;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.c + ", mGapDir=" + this.d + ", mHasUnwantedGapAfter=" + this.f + ", mGapPerSpan=" + Arrays.toString(this.e) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.c);
                parcel.writeInt(this.d);
                parcel.writeInt(this.f ? 1 : 0);
                int[] iArr = this.e;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.e);
                }
            }

            a() {
            }
        }
    }
}
