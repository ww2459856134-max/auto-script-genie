package n.a.a.n.c;

import com.auto.exceldeps.log4j.Logger;
import com.auto.exceldeps.log4j.message.Message;
import com.auto.exceldeps.log4j.message.SimpleMessage;
import com.auto.exceldeps.log4j.util.Supplier;
import com.auto.exceldeps.log4j.util.Unbox;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import n.a.a.n.c.t1.j6;
import n.a.a.n.c.t1.p3;
import n.a.a.n.c.t1.w6;
import n.a.a.n.c.u1.b2;
import n.a.a.n.c.u1.c2;
import n.a.a.n.c.u1.e2;
import n.a.a.n.c.u1.g2;
import n.a.a.n.c.u1.k2;
import n.a.a.n.c.u1.p2;
import n.a.a.n.c.u1.q1;
import n.a.a.n.c.u1.q2;
import n.a.a.n.c.u1.t1;
import n.a.a.n.c.u1.t2;
import n.a.a.n.c.u1.x1;
import n.a.a.n.c.u1.x2;
import n.a.a.n.c.u1.y1;
import n.a.a.n.c.u1.z1;

/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: m, reason: collision with root package name */
    private static final Logger f2367m = n.a.a.i.b.a(n1.class);

    /* renamed from: n, reason: collision with root package name */
    private static final Logger f2368n = n.a.a.i.b.b("POI.FormulaEval");
    private final t a;
    private k b;
    private int c;
    private final l0 d;
    private final Map<o, Integer> e;
    private final Map<String, Integer> f;
    private i g;

    /* renamed from: h, reason: collision with root package name */
    private final m0 f2369h;

    /* renamed from: i, reason: collision with root package name */
    private final n.a.a.n.c.v1.a f2370i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2371j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2372k;

    /* renamed from: l, reason: collision with root package name */
    private int f2373l;

    public n1(t tVar, m0 m0Var, n.a.a.n.c.v1.c cVar) {
        this(tVar, null, m0Var, cVar);
    }

    static /* synthetic */ Message A(String str, t0 t0Var, k2[] k2VarArr) {
        return new SimpleMessage(str + "- evaluateFormula('" + t0Var.s().p() + "'/" + new n.a.a.n.e.s(t0Var.t(), t0Var.k()).g() + "): " + Arrays.toString(k2VarArr).replace("\\Qorg.apache.poi.ss.formula.ptg.\\E", ""));
    }

    private n.a.a.n.c.r1.w0 B(n.a.a.n.c.r1.w0 w0Var, t0 t0Var) {
        return w0Var instanceof n.a.a.n.c.r1.q ? n(((n.a.a.n.c.r1.q) w0Var).u(), t0Var) : w0Var;
    }

    private n.a.a.n.c.r1.v a(n.a.a.n.c.r1.v vVar, int i2, int i3, int i4) {
        try {
            return new n.a.a.n.c.r1.v("Error evaluating cell " + new n.a.a.n.e.s(this.a.c(i2), i3, i4, false, false).g(), vVar);
        } catch (Exception e) {
            f2367m.atError().withThrowable(e).log("Can't add exception info");
            return vVar;
        }
    }

    private static int c(k2[] k2VarArr, int i2, int i3) {
        int i4 = i2;
        while (i3 != 0) {
            i4++;
            if (i4 >= k2VarArr.length) {
                throw new IllegalStateException("Skip distance too far (ran out of formula tokens).");
            }
            i3 -= k2VarArr[i4].l();
            if (i3 < 0) {
                throw new IllegalStateException("Bad skip distance (wrong token size calculation).");
            }
        }
        return i4 - i2;
    }

    public static n.a.a.n.c.r1.w0 d(n.a.a.n.c.r1.w0 w0Var, int i2, int i3) {
        try {
            n.a.a.n.c.r1.w0 w0VarI = n.a.a.n.c.r1.z.i(w0Var, i2, i3);
            return w0VarI == n.a.a.n.c.r1.l.a ? n.a.a.n.c.r1.x.c : w0VarI;
        } catch (n.a.a.n.c.r1.p e) {
            return e.a();
        }
    }

    private static n.a.a.n.c.r1.w0 e(n.a.a.n.c.r1.w0 w0Var, t0 t0Var) {
        if (t0Var == null) {
            throw new IllegalArgumentException("OperationEvaluationContext ec is null");
        }
        if (t0Var.v() == null) {
            throw new IllegalArgumentException("OperationEvaluationContext ec.getWorkbook() is null");
        }
        l lVarA = t0Var.v().l(t0Var.u()).a(t0Var.t(), t0Var.k());
        n.a.a.n.c.r1.w0 w0VarH = (lVarA != null && lVarA.e() && (w0Var instanceof n.a.a.n.c.r1.j)) ? n.a.a.n.c.r1.z.h((n.a.a.n.c.r1.j) w0Var, lVarA) : d(w0Var, t0Var.t(), t0Var.k());
        return w0VarH == n.a.a.n.c.r1.l.a ? n.a.a.n.c.r1.x.c : w0VarH;
    }

    private n.a.a.n.c.r1.w0 h(l lVar, final int i2, final int i3, final int i4, p pVar) {
        n.a.a.n.c.r1.w0 xVar;
        m0 m0Var = this.f2369h;
        boolean z = m0Var == null || !m0Var.a(i2, i3, i4);
        if (lVar == null || lVar.b() != n.a.a.n.d.j.FORMULA) {
            n.a.a.n.c.r1.w0 w0VarW = w(lVar);
            if (z) {
                pVar.b(this.a, this.c, i2, i3, i4, w0VarW);
            }
            return w0VarW;
        }
        v vVarB = this.b.b(lVar);
        if (z || vVarB.g()) {
            pVar.a(vVarB);
        }
        l0 l0Var = this.d;
        if (vVarB.d() != null) {
            if (l0Var != null) {
                l0Var.a(i2, i3, i4, vVarB.d());
            }
            return vVarB.d();
        }
        try {
            if (!pVar.d(vVarB)) {
                return n.a.a.n.c.r1.o.f2387j;
            }
            try {
                k2[] k2VarArrQ = this.a.q(lVar);
                t0 t0Var = new t0(this, this.a, i2, i3, i4, pVar);
                if (l0Var == null) {
                    xVar = i(t0Var, k2VarArrQ);
                } else {
                    l0Var.d(lVar, vVarB);
                    n.a.a.n.c.r1.w0 w0VarI = i(t0Var, k2VarArrQ);
                    l0Var.c(vVarB, w0VarI);
                    xVar = w0VarI;
                }
                pVar.e(xVar);
            } catch (n.a.a.n.c.r1.v e) {
                throw a(e, i2, i3, i4);
            } catch (RuntimeException e2) {
                if (!(e2.getCause() instanceof h) || !this.f2371j) {
                    throw e2;
                }
                f2367m.atInfo().log("{} - Continuing with cached value!", e2.getCause().getMessage());
                int i5 = m1.a[lVar.h().ordinal()];
                if (i5 == 1) {
                    xVar = new n.a.a.n.c.r1.x(lVar.d());
                } else if (i5 == 2) {
                    xVar = new n.a.a.n.c.r1.m0(lVar.k());
                } else if (i5 == 3) {
                    xVar = n.a.a.n.c.r1.l.a;
                } else if (i5 == 4) {
                    xVar = n.a.a.n.c.r1.m.v(lVar.c());
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException("Unexpected cell type '" + lVar.b() + "' found!");
                    }
                    xVar = n.a.a.n.c.r1.o.w(lVar.a());
                }
            }
            final n.a.a.n.c.r1.w0 w0Var = xVar;
            f2367m.atDebug().log(new Supplier() { // from class: n.a.a.n.c.a
                @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                public final Object get() {
                    return this.a.z(i2, i3, i4, w0Var);
                }
            });
            return xVar;
        } finally {
            pVar.c(vVarB);
        }
    }

    private n.a.a.n.c.r1.w0 n(n nVar, t0 t0Var) {
        if (nVar.d()) {
            return new n.a.a.n.c.r1.s(nVar.f());
        }
        if (nVar.e()) {
            return j(nVar.b(), t0Var);
        }
        throw new IllegalStateException("Don't know how to evaluate name '" + nVar.f() + "'");
    }

    private n.a.a.n.c.r1.w0 o(k2 k2Var, t0 t0Var) {
        if (k2Var instanceof b2) {
            return n(this.a.p((b2) k2Var), t0Var);
        }
        if (k2Var instanceof c2) {
            return B(t0Var.o((c2) k2Var), t0Var);
        }
        if (k2Var instanceof t1) {
            return new n.a.a.n.c.r1.x(((t1) k2Var).p());
        }
        if (k2Var instanceof e2) {
            return new n.a.a.n.c.r1.x(((e2) k2Var).p());
        }
        if (k2Var instanceof t2) {
            return new n.a.a.n.c.r1.m0(((t2) k2Var).p());
        }
        if (k2Var instanceof n.a.a.n.c.u1.i1) {
            return n.a.a.n.c.r1.m.v(((n.a.a.n.c.u1.i1) k2Var).p());
        }
        if (k2Var instanceof n.a.a.n.c.u1.o1) {
            return n.a.a.n.c.r1.o.w(((n.a.a.n.c.u1.o1) k2Var).p());
        }
        if (k2Var instanceof z1) {
            return n.a.a.n.c.r1.u.a;
        }
        if (k2Var instanceof p2) {
            return t0Var.q((p2) k2Var);
        }
        if (k2Var instanceof n.a.a.n.c.u1.b1) {
            return t0Var.h((n.a.a.n.c.u1.b1) k2Var);
        }
        if (k2Var instanceof q2) {
            q2 q2Var = (q2) k2Var;
            return t0Var.r(q2Var.s(), q2Var.r());
        }
        if (k2Var instanceof n.a.a.n.c.u1.e1) {
            n.a.a.n.c.u1.e1 e1Var = (n.a.a.n.c.u1.e1) k2Var;
            return t0Var.i(e1Var.getFirstRow(), e1Var.getFirstColumn(), e1Var.getLastRow(), e1Var.getLastColumn());
        }
        if (k2Var instanceof n.a.a.n.c.u1.g1) {
            return t0Var.j(0, 0, r7.r() - 1, r7.p() - 1, ((n.a.a.n.c.u1.g1) k2Var).s());
        }
        throw new IllegalStateException("Unexpected ptg class (" + k2Var.getClass().getName() + ")");
    }

    private int u(o oVar) {
        Integer numValueOf = this.e.get(oVar);
        if (numValueOf == null) {
            int iJ = this.a.j(oVar);
            if (iJ < 0) {
                throw new IllegalStateException("Specified sheet from a different book");
            }
            numValueOf = Integer.valueOf(iJ);
            this.e.put(oVar, numValueOf);
        }
        return numValueOf.intValue();
    }

    static n.a.a.n.c.r1.w0 w(l lVar) {
        if (lVar == null) {
            return n.a.a.n.c.r1.l.a;
        }
        n.a.a.n.d.j jVarB = lVar.b();
        int i2 = m1.a[jVarB.ordinal()];
        if (i2 == 1) {
            return new n.a.a.n.c.r1.x(lVar.d());
        }
        if (i2 == 2) {
            return new n.a.a.n.c.r1.m0(lVar.k());
        }
        if (i2 == 3) {
            return n.a.a.n.c.r1.l.a;
        }
        if (i2 == 4) {
            return n.a.a.n.c.r1.m.v(lVar.c());
        }
        if (i2 == 5) {
            return n.a.a.n.c.r1.o.w(lVar.a());
        }
        throw new IllegalStateException("Unexpected cell type (" + jVarB + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Message z(int i2, int i3, int i4, n.a.a.n.c.r1.w0 w0Var) {
        return new SimpleMessage("Evaluated " + v(i2) + "!" + new n.a.a.n.e.s(i3, i4).g() + " to " + w0Var);
    }

    void b(i iVar, k kVar, int i2) {
        this.g = iVar;
        this.b = kVar;
        this.c = i2;
    }

    void f() {
        this.g = i.d;
        this.b = new k(this.d);
        this.c = 0;
    }

    public n.a.a.n.c.r1.w0 g(l lVar) {
        return h(lVar, u(lVar.getSheet()), lVar.g(), lVar.i(), new p(this.b));
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        r6 = n.a.a.n.c.r1.r.a(((n.a.a.n.c.u1.q1) r18[r11]).t()) instanceof n.a.a.n.c.t1.z2;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    n.a.a.n.c.r1.w0 i(final t0 t0Var, final k2[] k2VarArr) {
        final String strSubstring;
        int i2;
        boolean z;
        n.a.a.n.c.r1.w0 w0VarO;
        int iC;
        int iR;
        int i3;
        int iA;
        if (this.f2372k) {
            this.f2373l = 1;
            this.f2372k = true;
        }
        int i4 = this.f2373l;
        if (i4 > 0) {
            strSubstring = "                                                                                                    ".substring(0, Math.min(100, i4 * 2));
            f2368n.atWarn().log(new Supplier() { // from class: n.a.a.n.c.b
                @Override // com.auto.exceldeps.log4j.util.Supplier, java.util.function.Supplier
                public final Object get() {
                    return n1.A(strSubstring, t0Var, k2VarArr);
                }
            });
            this.f2373l++;
        } else {
            strSubstring = "";
        }
        String str = strSubstring;
        l lVarA = t0Var.v().l(t0Var.u()).a(t0Var.t(), t0Var.k());
        Stack stack = new Stack();
        int length = k2VarArr.length;
        int i5 = 0;
        while (i5 < length) {
            k2 k2Var = k2VarArr[i5];
            if (this.f2373l > 0) {
                i2 = i5;
                f2368n.atInfo().log("{}  * ptg {}: {}, stack: {}", str, Unbox.box(i5), k2Var, stack);
            } else {
                i2 = i5;
            }
            if (k2Var instanceof n.a.a.n.c.u1.h1) {
                n.a.a.n.c.u1.h1 h1Var = (n.a.a.n.c.u1.h1) k2Var;
                if (h1Var.B()) {
                    k2Var = q1.f2447j;
                }
                if (h1Var.w()) {
                    n.a.a.n.c.r1.w0 w0Var = (n.a.a.n.c.r1.w0) stack.pop();
                    int[] iArrT = h1Var.t();
                    int length2 = iArrT.length;
                    try {
                        iA = p3.a(w0Var, t0Var.t(), t0Var.k());
                    } catch (n.a.a.n.c.r1.p e) {
                        stack.push(e.a());
                        iR = h1Var.r();
                    }
                    if (iA >= 1 && iA <= length2) {
                        i3 = iArrT[iA - 1];
                        iC = i2 + c(k2VarArr, i2, i3 - ((length2 * 2) + 2));
                    }
                    stack.push(n.a.a.n.c.r1.o.e);
                    iR = h1Var.r();
                    i3 = iR + 4;
                    iC = i2 + c(k2VarArr, i2, i3 - ((length2 * 2) + 2));
                } else if (h1Var.x()) {
                    if (!lVarA.e()) {
                        n.a.a.n.c.r1.w0 w0Var2 = (n.a.a.n.c.r1.w0) stack.pop();
                        try {
                            if (w6.m(w0Var2, t0Var.t(), t0Var.k())) {
                                iC = i2;
                            } else {
                                iC = i2 + c(k2VarArr, i2, h1Var.s());
                                k2 k2Var2 = k2VarArr[iC + 1];
                                if ((k2VarArr[iC] instanceof n.a.a.n.c.u1.h1) && (k2Var2 instanceof q1) && ((q1) k2Var2).t() == 1) {
                                    stack.push(w0Var2);
                                    stack.push(n.a.a.n.c.r1.m.b);
                                }
                            }
                        } catch (n.a.a.n.c.r1.p e2) {
                            stack.push(e2.a());
                            int iC2 = i2 + c(k2VarArr, i2, h1Var.s());
                            iC = iC2 + c(k2VarArr, iC2, ((n.a.a.n.c.u1.h1) k2VarArr[iC2]).s() + 1);
                        }
                    }
                    z = false;
                    iC = i2;
                } else {
                    if (h1Var.z() && !lVarA.e()) {
                        iC = i2 + c(k2VarArr, i2, h1Var.s() + 1);
                        if (stack.peek() == n.a.a.n.c.r1.u.a) {
                            stack.pop();
                            stack.push(n.a.a.n.c.r1.l.a);
                        }
                    }
                    if ((k2Var instanceof n.a.a.n.c.u1.k1) || (k2Var instanceof y1) || (k2Var instanceof x1)) {
                        z = false;
                        iC = i2;
                    } else if (k2Var instanceof x2) {
                        if (k2Var instanceof g2) {
                            g2 g2Var = (g2) k2Var;
                            int iP = g2Var.p();
                            n.a.a.n.c.r1.w0[] w0VarArr = new n.a.a.n.c.r1.w0[iP];
                            boolean z2 = false;
                            for (int i6 = iP - 1; i6 >= 0; i6--) {
                                n.a.a.n.c.r1.w0 w0Var3 = (n.a.a.n.c.r1.w0) stack.pop();
                                w0VarArr[i6] = w0Var3;
                                if (w0Var3 instanceof n.a.a.n.c.r1.j) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                int i7 = i2;
                                while (true) {
                                    if (i7 >= length) {
                                        break;
                                    }
                                    if (k2VarArr[i7] instanceof q1) {
                                        break;
                                    }
                                    i7++;
                                }
                                t0Var.A(z);
                                w0VarO = u0.a(g2Var, w0VarArr, t0Var);
                                z = false;
                                t0Var.A(false);
                            } else {
                                boolean z3 = false;
                                t0Var.A(z3);
                                w0VarO = u0.a(g2Var, w0VarArr, t0Var);
                                z = false;
                                t0Var.A(false);
                            }
                        } else {
                            z = false;
                            w0VarO = o(k2Var, t0Var);
                        }
                        if (w0VarO == null) {
                            throw new IllegalStateException("Evaluation result must not be null");
                        }
                        stack.push(w0VarO);
                        if (this.f2373l > 0) {
                            f2368n.atInfo().log("{}    = {}", str, w0VarO);
                        }
                        iC = i2;
                    } else {
                        stack.push(new n.a.a.n.c.r1.e0((n.a.a.n.c.r1.w0) stack.pop(), (n.a.a.n.c.r1.w0) stack.pop()));
                        z = false;
                        iC = i2;
                    }
                }
                z = false;
            } else if (k2Var instanceof n.a.a.n.c.u1.k1) {
                if (k2Var instanceof x2) {
                }
            }
            i5 = iC + 1;
        }
        n.a.a.n.c.r1.w0 w0VarE = (n.a.a.n.c.r1.w0) stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("evaluation stack not empty");
        }
        if (t0Var.x()) {
            w0VarE = e(w0VarE, t0Var);
        }
        if (this.f2373l > 0) {
            f2368n.atInfo().log("{}finished eval of {}: {}", str, new n.a.a.n.e.s(t0Var.t(), t0Var.k()).g(), w0VarE);
            int i8 = this.f2373l - 1;
            this.f2373l = i8;
            if (i8 == 1) {
                this.f2373l = -1;
            }
        }
        return w0VarE;
    }

    n.a.a.n.c.r1.w0 j(k2[] k2VarArr, t0 t0Var) {
        return (k2VarArr.length != 1 || (k2VarArr[0] instanceof q1)) ? i(new t0(this, t0Var.v(), t0Var.u(), t0Var.t(), t0Var.k(), new p(this.b), false), k2VarArr) : o(k2VarArr[0], t0Var);
    }

    n.a.a.n.c.r1.w0 k(o oVar, int i2, int i3, int i4, p pVar) {
        return h(oVar.a(i3, i4), i2, i3, i4, pVar);
    }

    public j6 l(String str) {
        return this.f2370i.a(str);
    }

    i m() {
        return this.g;
    }

    l0 p() {
        return this.d;
    }

    n q(String str, int i2) {
        return this.a.a(str, i2);
    }

    n1 r(String str) throws h {
        return this.g.a(str);
    }

    o s(int i2) {
        return this.a.l(i2);
    }

    int t(String str) {
        Integer numValueOf = this.f.get(str);
        if (numValueOf == null) {
            int iG = this.a.g(str);
            if (iG < 0) {
                return -1;
            }
            numValueOf = Integer.valueOf(iG);
            this.f.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    String v(int i2) {
        return this.a.c(i2);
    }

    t x() {
        return this.a;
    }

    n1(t tVar, l0 l0Var, m0 m0Var, n.a.a.n.c.v1.c cVar) {
        this.f2373l = -1;
        this.a = tVar;
        this.d = l0Var;
        this.b = new k(l0Var);
        this.e = new IdentityHashMap();
        this.f = new IdentityHashMap();
        this.g = i.d;
        this.c = 0;
        this.f2369h = m0Var;
        n.a.a.n.c.v1.a aVar = tVar == null ? null : (n.a.a.n.c.v1.a) tVar.k();
        if (aVar != null && cVar != null) {
            aVar.b(cVar);
        }
        this.f2370i = aVar;
    }
}
