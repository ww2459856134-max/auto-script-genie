package k.x.j1;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
class b1 implements u0 {

    /* renamed from: i, reason: collision with root package name */
    private static k.y.c f2113i = k.y.c.b(b1.class);
    private String a;
    private String b;
    private t0 c;
    private Stack d;
    private k.w e;
    private t f;
    private k.x.a1 g;

    /* renamed from: h, reason: collision with root package name */
    private s0 f2114h;

    public b1(String str, t tVar, k.x.a1 a1Var, k.w wVar, s0 s0Var) {
        this.a = str;
        this.e = wVar;
        this.f = tVar;
        this.g = a1Var;
        this.f2114h = s0Var;
    }

    private ArrayList c() throws w {
        ArrayList arrayList = new ArrayList();
        o1 o1Var = new o1(new StringReader(this.a));
        o1Var.b(this.f);
        o1Var.c(this.g);
        try {
            for (t0 t0VarE = o1Var.e(); t0VarE != null; t0VarE = o1Var.e()) {
                arrayList.add(t0VarE);
            }
        } catch (IOException e) {
            f2113i.f(e.toString());
        } catch (Error unused) {
            throw new w(w.f, this.a + " at char  " + o1Var.a());
        }
        return arrayList;
    }

    private void d(c1 c1Var, Iterator it, Stack stack) throws w {
        t0 t0VarF = f(it);
        if (c1Var.j(this.e) == y.f2150i) {
            throw new w(w.d);
        }
        if (c1Var.j(this.e) == y.f && this.d == null) {
            e eVar = new e(c1Var, this.e);
            eVar.j(t0VarF);
            stack.push(eVar);
            return;
        }
        if (c1Var.j(this.e) == y.f2149h) {
            e eVar2 = new e(c1Var, this.e);
            n1 n1Var = new n1(this.e);
            int size = this.d.size();
            while (i < size) {
                n1Var.j((t0) this.d.get(i));
                i++;
            }
            eVar2.t(n1Var);
            stack.push(eVar2);
            return;
        }
        if (c1Var.j(this.e).f() != 255) {
            h hVar = new h(c1Var.j(this.e), this.e);
            int iF = c1Var.j(this.e).f();
            if (iF == 1) {
                hVar.j(t0VarF);
            } else {
                Stack stack2 = this.d;
                if ((stack2 == null && iF != 0) || (stack2 != null && iF != stack2.size())) {
                    throw new w(w.g);
                }
                while (i < iF) {
                    hVar.j((t0) this.d.get(i));
                    i++;
                }
            }
            stack.push(hVar);
            return;
        }
        Stack stack3 = this.d;
        if (stack3 == null) {
            n1 n1Var2 = new n1(c1Var.j(this.e), t0VarF != null ? 1 : 0, this.e);
            if (t0VarF != null) {
                n1Var2.j(t0VarF);
            }
            stack.push(n1Var2);
            return;
        }
        int size2 = stack3.size();
        n1 n1Var3 = new n1(c1Var.j(this.e), size2, this.e);
        t0[] t0VarArr = new t0[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            t0VarArr[(size2 - i2) - 1] = (t0) this.d.pop();
        }
        while (i < size2) {
            n1Var3.j(t0VarArr[i]);
            i++;
        }
        stack.push(n1Var3);
        this.d.clear();
        this.d = null;
    }

    private void e(p0 p0Var, Stack stack) {
        boolean z = p0Var instanceof c0;
        if (!z) {
            stack.push(p0Var);
            return;
        }
        if (z) {
            c0 c0Var = (c0) p0Var;
            if (c0Var.k()) {
                stack.push(new q(c0Var.j()));
            } else {
                stack.push(c0Var);
            }
        }
    }

    private t0 f(Iterator it) throws w {
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        boolean z = false;
        Stack stack3 = null;
        t0 t0Var = null;
        while (it.hasNext() && !z) {
            t0 t0Var2 = (t0) it.next();
            t0Var2.g(this.f2114h);
            if (t0Var2 instanceof p0) {
                e((p0) t0Var2, stack);
            } else if (t0Var2 instanceof c1) {
                d((c1) t0Var2, it, stack);
            } else if (t0Var2 instanceof q0) {
                q0 q0VarP = (q0) t0Var2;
                if (q0VarP instanceof d1) {
                    d1 d1Var = (d1) q0VarP;
                    q0VarP = (stack.isEmpty() || (t0Var instanceof q0)) ? d1Var.p() : d1Var.o();
                }
                if (stack2.empty()) {
                    stack2.push(q0VarP);
                } else {
                    q0 q0Var = (q0) stack2.peek();
                    if (q0VarP.m() < q0Var.m()) {
                        stack2.push(q0VarP);
                    } else if (q0VarP.m() == q0Var.m() && (q0VarP instanceof l1)) {
                        stack2.push(q0VarP);
                    } else {
                        stack2.pop();
                        q0Var.k(stack);
                        stack.push(q0Var);
                        stack2.push(q0VarP);
                    }
                }
            } else if (t0Var2 instanceof d) {
                while (!stack2.isEmpty()) {
                    q0 q0Var2 = (q0) stack2.pop();
                    q0Var2.k(stack);
                    stack.push(q0Var2);
                }
                if (stack3 == null) {
                    stack3 = new Stack();
                }
                stack3.push(stack.pop());
                stack.clear();
            } else if (t0Var2 instanceof o0) {
                t0 t0VarF = f(it);
                r0 r0Var = new r0();
                t0VarF.f(r0Var);
                r0Var.j(t0VarF);
                stack.push(r0Var);
            } else if (t0Var2 instanceof l) {
                z = true;
            }
            t0Var = t0Var2;
        }
        while (!stack2.isEmpty()) {
            q0 q0Var3 = (q0) stack2.pop();
            q0Var3.k(stack);
            stack.push(q0Var3);
        }
        t0 t0Var3 = stack.empty() ? null : (t0) stack.pop();
        if (stack3 != null && t0Var3 != null) {
            stack3.push(t0Var3);
        }
        this.d = stack3;
        if (!stack.empty() || !stack2.empty()) {
            f2113i.f("Formula " + this.a + " has a non-empty parse stack");
        }
        return t0Var3;
    }

    @Override // k.x.j1.u0
    public byte[] a() {
        byte[] bArrA = this.c.a();
        if (!this.c.d()) {
            return bArrA;
        }
        byte[] bArr = new byte[bArrA.length + 4];
        System.arraycopy(bArrA, 0, bArr, 4, bArrA.length);
        bArr[0] = i1.L.a();
        bArr[1] = 1;
        return bArr;
    }

    @Override // k.x.j1.u0
    public void b() throws w {
        this.c = f(c().iterator());
    }

    @Override // k.x.j1.u0
    public String getFormula() {
        if (this.b == null) {
            StringBuffer stringBuffer = new StringBuffer();
            this.c.c(stringBuffer);
            this.b = stringBuffer.toString();
        }
        return this.b;
    }
}
