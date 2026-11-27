package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import h.e.j.q1.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean H;
    int I;
    int[] J;
    View[] K;
    final SparseIntArray L;
    final SparseIntArray M;
    c N;
    final Rect O;
    private boolean P;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        int getCachedSpanGroupIndex(int i2, int i3) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i2, i3);
            }
            int i4 = this.mSpanGroupIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanGroupIndex = getSpanGroupIndex(i2, i3);
            this.mSpanGroupIndexCache.put(i2, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i2, int i3) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i2, i3);
            }
            int i4 = this.mSpanIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanIndex = getSpanIndex(i2, i3);
            this.mSpanIndexCache.put(i2, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i2, int i3) {
            int i4;
            int i5;
            int cachedSpanIndex;
            int iA;
            if (!this.mCacheSpanGroupIndices || (iA = a(this.mSpanGroupIndexCache, i2)) == -1) {
                i4 = 0;
                i5 = 0;
                cachedSpanIndex = 0;
            } else {
                i4 = this.mSpanGroupIndexCache.get(iA);
                i5 = iA + 1;
                cachedSpanIndex = getCachedSpanIndex(iA, i3) + getSpanSize(iA);
                if (cachedSpanIndex == i3) {
                    i4++;
                    cachedSpanIndex = 0;
                }
            }
            int spanSize = getSpanSize(i2);
            while (i5 < i2) {
                int spanSize2 = getSpanSize(i5);
                cachedSpanIndex += spanSize2;
                if (cachedSpanIndex == i3) {
                    i4++;
                    cachedSpanIndex = 0;
                } else if (cachedSpanIndex > i3) {
                    i4++;
                    cachedSpanIndex = spanSize2;
                }
                i5++;
            }
            return cachedSpanIndex + spanSize > i3 ? i4 + 1 : i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i2, int i3) {
            int iA;
            int spanSize;
            int spanSize2 = getSpanSize(i2);
            if (spanSize2 == i3) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (iA = a(this.mSpanIndexCache, i2)) < 0) {
                iA = 0;
                spanSize = 0;
                if (iA >= i2) {
                    int spanSize3 = getSpanSize(iA);
                    spanSize += spanSize3;
                    if (spanSize == i3) {
                        spanSize = 0;
                    } else if (spanSize > i3) {
                        spanSize = spanSize3;
                    }
                    iA++;
                    if (iA >= i2) {
                        if (spanSize2 + spanSize <= i3) {
                            return spanSize;
                        }
                        return 0;
                    }
                }
            } else {
                spanSize = this.mSpanIndexCache.get(iA) + getSpanSize(iA);
                iA++;
                if (iA >= i2) {
                }
            }
        }

        public abstract int getSpanSize(int i2);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        e3(RecyclerView.o.h0(context, attributeSet, i2, i3).b);
    }

    private void M2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i4 = 1;
            i6 = i2;
            i3 = 0;
        } else {
            i3 = i2 - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.K[i3];
            b bVar = (b) view.getLayoutParams();
            int iZ2 = Z2(vVar, a0Var, g0(view));
            bVar.f = iZ2;
            bVar.e = i5;
            i5 += iZ2;
            i3 += i4;
        }
    }

    private void N2() {
        int iJ = J();
        for (int i2 = 0; i2 < iJ; i2++) {
            b bVar = (b) I(i2).getLayoutParams();
            int iA = bVar.a();
            this.L.put(iA, bVar.f());
            this.M.put(iA, bVar.e());
        }
    }

    private void O2(int i2) {
        this.J = P2(this.J, this.I, i2);
    }

    static int[] P2(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void Q2() {
        this.L.clear();
        this.M.clear();
    }

    private int R2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            P1();
            boolean zP2 = p2();
            View viewV1 = V1(!zP2, true);
            View viewU1 = U1(!zP2, true);
            if (viewV1 != null && viewU1 != null) {
                int cachedSpanGroupIndex = this.N.getCachedSpanGroupIndex(g0(viewV1), this.I);
                int cachedSpanGroupIndex2 = this.N.getCachedSpanGroupIndex(g0(viewU1), this.I);
                int iMax = this.w ? Math.max(0, ((this.N.getCachedSpanGroupIndex(a0Var.b() - 1, this.I) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (zP2) {
                    return Math.round((iMax * (Math.abs(this.t.d(viewU1) - this.t.g(viewV1)) / ((this.N.getCachedSpanGroupIndex(g0(viewU1), this.I) - this.N.getCachedSpanGroupIndex(g0(viewV1), this.I)) + 1))) + (this.t.m() - this.t.g(viewV1)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int S2(RecyclerView.a0 a0Var) {
        if (J() != 0 && a0Var.b() != 0) {
            P1();
            View viewV1 = V1(!p2(), true);
            View viewU1 = U1(!p2(), true);
            if (viewV1 != null && viewU1 != null) {
                if (!p2()) {
                    return this.N.getCachedSpanGroupIndex(a0Var.b() - 1, this.I) + 1;
                }
                int iD = this.t.d(viewU1) - this.t.g(viewV1);
                int cachedSpanGroupIndex = this.N.getCachedSpanGroupIndex(g0(viewV1), this.I);
                return (int) ((iD / ((this.N.getCachedSpanGroupIndex(g0(viewU1), this.I) - cachedSpanGroupIndex) + 1)) * (this.N.getCachedSpanGroupIndex(a0Var.b() - 1, this.I) + 1));
            }
        }
        return 0;
    }

    private void T2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int iY2 = Y2(vVar, a0Var, aVar.b);
        if (z) {
            while (iY2 > 0) {
                int i3 = aVar.b;
                if (i3 <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                aVar.b = i4;
                iY2 = Y2(vVar, a0Var, i4);
            }
            return;
        }
        int iB = a0Var.b() - 1;
        int i5 = aVar.b;
        while (i5 < iB) {
            int i6 = i5 + 1;
            int iY22 = Y2(vVar, a0Var, i6);
            if (iY22 <= iY2) {
                break;
            }
            i5 = i6;
            iY2 = iY22;
        }
        aVar.b = i5;
    }

    private void U2() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private int X2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.N.getCachedSpanGroupIndex(i2, this.I);
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.N.getCachedSpanGroupIndex(iF, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int Y2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.N.getCachedSpanIndex(i2, this.I);
        }
        int i3 = this.M.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.N.getCachedSpanIndex(iF, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int Z2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.N.getSpanSize(i2);
        }
        int i3 = this.L.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int iF = vVar.f(i2);
        if (iF != -1) {
            return this.N.getSpanSize(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void b3(float f, int i2) {
        O2(Math.max(Math.round(f * this.I), i2));
    }

    private void c3(View view, int i2, boolean z) {
        int iK;
        int iK2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iV2 = V2(bVar.e, bVar.f);
        if (this.r == 1) {
            iK2 = RecyclerView.o.K(iV2, i2, i4, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iK = RecyclerView.o.K(this.t.n(), X(), i3, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iK3 = RecyclerView.o.K(iV2, i2, i3, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iK4 = RecyclerView.o.K(this.t.n(), o0(), i4, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iK = iK3;
            iK2 = iK4;
        }
        d3(view, iK2, iK, z);
    }

    private void d3(View view, int i2, int i3, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? F1(view, i2, i3, pVar) : D1(view, i2, i3, pVar)) {
            view.measure(i2, i3);
        }
    }

    private void g3() {
        int iW;
        int iF0;
        if (n2() == 1) {
            iW = n0() - e0();
            iF0 = d0();
        } else {
            iW = W() - c0();
            iF0 = f0();
        }
        O2(iW - iF0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void A1(Rect rect, int i2, int i3) {
        int iN;
        int iN2;
        if (this.J == null) {
            super.A1(rect, i2, i3);
        }
        int iD0 = d0() + e0();
        int iF0 = f0() + c0();
        if (this.r == 1) {
            iN2 = RecyclerView.o.n(i3, rect.height() + iF0, a0());
            int[] iArr = this.J;
            iN = RecyclerView.o.n(i2, iArr[iArr.length - 1] + iD0, b0());
        } else {
            iN = RecyclerView.o.n(i2, rect.width() + iD0, b0());
            int[] iArr2 = this.J;
            iN2 = RecyclerView.o.n(i3, iArr2[iArr2.length - 1] + iF0, a0());
        }
        z1(iN, iN2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.r == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.D2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean H1() {
        return this.C == null && !this.H;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View I0(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iJ;
        int i3;
        int iJ2;
        View view2;
        View view3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.a0 a0Var2 = a0Var;
        View viewB = B(view);
        View view4 = null;
        if (viewB == null) {
            return null;
        }
        b bVar = (b) viewB.getLayoutParams();
        int i8 = bVar.e;
        int i9 = bVar.f + i8;
        if (super.I0(view, i2, vVar, a0Var) == null) {
            return null;
        }
        if ((N1(i2) == 1) != this.w) {
            iJ2 = J() - 1;
            iJ = -1;
            i3 = -1;
        } else {
            iJ = J();
            i3 = 1;
            iJ2 = 0;
        }
        boolean z2 = this.r == 1 && o2();
        int iX2 = X2(vVar2, a0Var2, iJ2);
        int i10 = -1;
        int i11 = -1;
        int iMin = 0;
        int iMin2 = 0;
        int i12 = iJ2;
        View view5 = null;
        while (i12 != iJ) {
            int iX22 = X2(vVar2, a0Var2, i12);
            View viewI = I(i12);
            if (viewI == viewB) {
                break;
            }
            if (!viewI.hasFocusable() || iX22 == iX2) {
                b bVar2 = (b) viewI.getLayoutParams();
                int i13 = bVar2.e;
                view2 = viewB;
                int i14 = bVar2.f + i13;
                if (viewI.hasFocusable() && i13 == i8 && i14 == i9) {
                    return viewI;
                }
                if (!(viewI.hasFocusable() && view4 == null) && (viewI.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i14, i9) - Math.max(i13, i8);
                    if (!viewI.hasFocusable()) {
                        if (view4 == null) {
                            i4 = iMin;
                            i5 = iJ;
                            if (x0(viewI, false, true)) {
                                i6 = iMin2;
                                if (iMin3 > i6) {
                                    i7 = i11;
                                    if (!z) {
                                        if (viewI.hasFocusable()) {
                                            i10 = bVar2.e;
                                            i11 = i7;
                                            iMin2 = i6;
                                            view5 = view3;
                                            view4 = viewI;
                                            iMin = Math.min(i14, i9) - Math.max(i13, i8);
                                        } else {
                                            int i15 = bVar2.e;
                                            iMin2 = Math.min(i14, i9) - Math.max(i13, i8);
                                            i11 = i15;
                                            iMin = i4;
                                            view5 = viewI;
                                        }
                                    }
                                    i12 += i3;
                                    vVar2 = vVar;
                                    a0Var2 = a0Var;
                                    viewB = view2;
                                    iJ = i5;
                                } else if (iMin3 == i6) {
                                    i7 = i11;
                                    if (z2 == (i13 > i7)) {
                                        z = true;
                                    }
                                    if (!z) {
                                    }
                                    i12 += i3;
                                    vVar2 = vVar;
                                    a0Var2 = a0Var;
                                    viewB = view2;
                                    iJ = i5;
                                } else {
                                    i7 = i11;
                                }
                            }
                            z = false;
                            if (!z) {
                            }
                            i12 += i3;
                            vVar2 = vVar;
                            a0Var2 = a0Var;
                            viewB = view2;
                            iJ = i5;
                        }
                        i7 = i11;
                        i6 = iMin2;
                        z = false;
                        if (!z) {
                        }
                        i12 += i3;
                        vVar2 = vVar;
                        a0Var2 = a0Var;
                        viewB = view2;
                        iJ = i5;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                    i4 = iMin;
                    i5 = iJ;
                    i7 = i11;
                    i6 = iMin2;
                    z = false;
                    if (!z) {
                    }
                    i12 += i3;
                    vVar2 = vVar;
                    a0Var2 = a0Var;
                    viewB = view2;
                    iJ = i5;
                } else {
                    view3 = view5;
                }
                i4 = iMin;
                i5 = iJ;
                i7 = i11;
                i6 = iMin2;
                z = true;
                if (!z) {
                }
                i12 += i3;
                vVar2 = vVar;
                a0Var2 = a0Var;
                viewB = view2;
                iJ = i5;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewB;
                view3 = view5;
                i4 = iMin;
                i5 = iJ;
                i7 = i11;
                i6 = iMin2;
            }
            i11 = i7;
            iMin2 = i6;
            iMin = i4;
            view5 = view3;
            i12 += i3;
            vVar2 = vVar;
            a0Var2 = a0Var;
            viewB = view2;
            iJ = i5;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void J1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.a aVar) {
        int spanSize = this.I;
        for (int i2 = 0; i2 < this.I && cVar.c(a0Var) && spanSize > 0; i2++) {
            int i3 = cVar.d;
            aVar.a(i3, Math.max(0, cVar.g));
            spanSize -= this.N.getSpanSize(i3);
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.r == 1) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return X2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, h.e.j.q1.e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.N0(view, eVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iX2 = X2(vVar, a0Var, bVar.a());
        if (this.r == 0) {
            eVar.X(e.a.f(bVar.e(), bVar.f(), iX2, 1, false, false));
        } else {
            eVar.X(e.a.f(iX2, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView recyclerView, int i2, int i3) {
        this.N.invalidateSpanIndexCache();
        this.N.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView) {
        this.N.invalidateSpanIndexCache();
        this.N.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.N.invalidateSpanIndexCache();
        this.N.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i2, int i3) {
        this.N.invalidateSpanIndexCache();
        this.N.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.N.invalidateSpanIndexCache();
        this.N.invalidateSpanGroupIndexCache();
    }

    int V2(int i2, int i3) {
        if (this.r != 1 || !o2()) {
            int[] iArr = this.J;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.J;
        int i4 = this.I;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            N2();
        }
        super.W0(vVar, a0Var);
        Q2();
    }

    public int W2() {
        return this.I;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.a0 a0Var) {
        super.X0(a0Var);
        this.H = false;
    }

    public c a3() {
        return this.N;
    }

    public void e3(int i2) {
        if (i2 == this.I) {
            return;
        }
        this.H = true;
        if (i2 >= 1) {
            this.I = i2;
            this.N.invalidateSpanIndexCache();
            r1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (iG0 >= 0 && iG0 < i4 && Y2(vVar, a0Var, iG0) == 0) {
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

    public void f3(c cVar) {
        this.N = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int j0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.r == 0) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return X2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0218  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void q2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int iF;
        int i3;
        int i4;
        int i5;
        int iF2;
        int iF3;
        int i6;
        int iK;
        int iK2;
        View viewD;
        int iL = this.t.l();
        ?? r5 = 0;
        boolean z = iL != 1073741824;
        int i7 = J() > 0 ? this.J[this.I] : 0;
        if (z) {
            g3();
        }
        boolean z2 = cVar.e == 1;
        int iY2 = this.I;
        if (!z2) {
            iY2 = Y2(vVar, a0Var, cVar.d) + Z2(vVar, a0Var, cVar.d);
        }
        int i8 = 0;
        while (i8 < this.I && cVar.c(a0Var) && iY2 > 0) {
            int i9 = cVar.d;
            int iZ2 = Z2(vVar, a0Var, i9);
            if (iZ2 > this.I) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iZ2 + " spans but GridLayoutManager has only " + this.I + " spans.");
            }
            iY2 -= iZ2;
            if (iY2 < 0 || (viewD = cVar.d(vVar)) == null) {
                break;
            }
            this.K[i8] = viewD;
            i8++;
        }
        if (i8 == 0) {
            bVar.b = true;
            return;
        }
        float f = 0.0f;
        M2(vVar, a0Var, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.K[i10];
            if (cVar.f320l == null) {
                if (z2) {
                    d(view);
                } else {
                    e(view, r5);
                }
            } else if (z2) {
                b(view);
            } else {
                c(view, r5);
            }
            j(view, this.O);
            c3(view, iL, r5);
            int iE = this.t.e(view);
            if (iE > i11) {
                i11 = iE;
            }
            float f2 = (this.t.f(view) * 1.0f) / ((b) view.getLayoutParams()).f;
            if (f2 > f) {
                f = f2;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            b3(f, i7);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.K[i12];
                c3(view2, WXVideoFileObject.FILE_SIZE_LIMIT, true);
                int iE2 = this.t.e(view2);
                if (iE2 > i11) {
                    i11 = iE2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.K[i13];
            if (this.t.e(view3) != i11) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.b;
                int i14 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i15 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int iV2 = V2(bVar2.e, bVar2.f);
                if (this.r == 1) {
                    iK2 = RecyclerView.o.K(iV2, WXVideoFileObject.FILE_SIZE_LIMIT, i15, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    iK = View.MeasureSpec.makeMeasureSpec(i11 - i14, WXVideoFileObject.FILE_SIZE_LIMIT);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, WXVideoFileObject.FILE_SIZE_LIMIT);
                    iK = RecyclerView.o.K(iV2, WXVideoFileObject.FILE_SIZE_LIMIT, i14, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    iK2 = iMakeMeasureSpec;
                }
                d3(view3, iK2, iK, true);
            }
        }
        int i16 = 0;
        bVar.a = i11;
        if (this.r == 1) {
            if (cVar.f == -1) {
                i3 = cVar.b;
                i4 = i3 - i11;
            } else {
                int i17 = cVar.b;
                i4 = i17;
                i3 = i11 + i17;
            }
            i2 = 0;
            iF = 0;
        } else if (cVar.f == -1) {
            int i18 = cVar.b;
            iF = i18 - i11;
            i4 = 0;
            i2 = i18;
            i3 = 0;
        } else {
            int i19 = cVar.b;
            i2 = i11 + i19;
            iF = i19;
            i3 = 0;
            i4 = 0;
        }
        while (i16 < i8) {
            View view4 = this.K[i16];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.r != 1) {
                int iF0 = f0() + this.J[bVar3.e];
                i5 = iF0;
                iF2 = i2;
                iF3 = this.t.f(view4) + iF0;
            } else if (o2()) {
                int iD0 = d0() + this.J[this.I - bVar3.e];
                iF = iD0 - this.t.f(view4);
                iF3 = i3;
                iF2 = iD0;
                i5 = i4;
            } else {
                int iD02 = d0() + this.J[bVar3.e];
                iF3 = i3;
                i6 = iD02;
                i5 = i4;
                iF2 = this.t.f(view4) + iD02;
                y0(view4, i6, i5, iF2, iF3);
                if (!bVar3.c() || bVar3.b()) {
                    bVar.c = true;
                }
                bVar.d |= view4.hasFocusable();
                i16++;
                i3 = iF3;
                i2 = iF2;
                i4 = i5;
                iF = i6;
            }
            i6 = iF;
            y0(view4, i6, i5, iF2, iF3);
            if (!bVar3.c()) {
                bVar.c = true;
            }
            bVar.d |= view4.hasFocusable();
            i16++;
            i3 = iF3;
            i2 = iF2;
            i4 = i5;
            iF = i6;
        }
        Arrays.fill(this.K, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return this.P ? R2(a0Var) : super.r(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return this.P ? S2(a0Var) : super.s(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void s2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        super.s2(vVar, a0Var, aVar, i2);
        g3();
        if (a0Var.b() > 0 && !a0Var.e()) {
            T2(vVar, a0Var, aVar, i2);
        }
        U2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return this.P ? R2(a0Var) : super.u(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int u1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        g3();
        U2();
        return super.u1(i2, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return this.P ? S2(a0Var) : super.v(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        g3();
        U2();
        return super.w1(i2, vVar, a0Var);
    }

    public static class b extends RecyclerView.p {
        int e;
        int f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        e3(i2);
    }
}
