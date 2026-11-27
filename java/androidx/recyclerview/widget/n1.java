package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class n1 {
    final h.d.i<RecyclerView.d0, m1> a = new h.d.i<>();
    final h.d.f<RecyclerView.d0> b = new h.d.f<>();

    interface a {
        void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void b(RecyclerView.d0 d0Var);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2);
    }

    n1() {
    }

    private RecyclerView.l.b l(RecyclerView.d0 d0Var, int i2) {
        m1 m1VarM;
        RecyclerView.l.b bVar;
        int iF = this.a.f(d0Var);
        if (iF >= 0 && (m1VarM = this.a.m(iF)) != null) {
            int i3 = m1VarM.a;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                m1VarM.a = i4;
                if (i2 == 4) {
                    bVar = m1VarM.b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    bVar = m1VarM.c;
                }
                if ((i4 & 12) == 0) {
                    this.a.k(iF);
                    m1.c(m1VarM);
                }
                return bVar;
            }
        }
        return null;
    }

    void a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        m1 m1VarB = this.a.get(d0Var);
        if (m1VarB == null) {
            m1VarB = m1.b();
            this.a.put(d0Var, m1VarB);
        }
        m1VarB.a |= 2;
        m1VarB.b = bVar;
    }

    void b(RecyclerView.d0 d0Var) {
        m1 m1VarB = this.a.get(d0Var);
        if (m1VarB == null) {
            m1VarB = m1.b();
            this.a.put(d0Var, m1VarB);
        }
        m1VarB.a |= 1;
    }

    void c(long j2, RecyclerView.d0 d0Var) {
        this.b.j(j2, d0Var);
    }

    void d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        m1 m1VarB = this.a.get(d0Var);
        if (m1VarB == null) {
            m1VarB = m1.b();
            this.a.put(d0Var, m1VarB);
        }
        m1VarB.c = bVar;
        m1VarB.a |= 8;
    }

    void e(RecyclerView.d0 d0Var, RecyclerView.l.b bVar) {
        m1 m1VarB = this.a.get(d0Var);
        if (m1VarB == null) {
            m1VarB = m1.b();
            this.a.put(d0Var, m1VarB);
        }
        m1VarB.b = bVar;
        m1VarB.a |= 4;
    }

    void f() {
        this.a.clear();
        this.b.b();
    }

    RecyclerView.d0 g(long j2) {
        return this.b.f(j2);
    }

    boolean h(RecyclerView.d0 d0Var) {
        m1 m1Var = this.a.get(d0Var);
        return (m1Var == null || (m1Var.a & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.d0 d0Var) {
        m1 m1Var = this.a.get(d0Var);
        return (m1Var == null || (m1Var.a & 4) == 0) ? false : true;
    }

    void j() {
        m1.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    RecyclerView.l.b m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    RecyclerView.l.b n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    void o(a aVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 d0VarI = this.a.i(size);
            m1 m1VarK = this.a.k(size);
            int i2 = m1VarK.a;
            if ((i2 & 3) == 3) {
                aVar.b(d0VarI);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.b bVar = m1VarK.b;
                if (bVar == null) {
                    aVar.b(d0VarI);
                } else {
                    aVar.c(d0VarI, bVar, m1VarK.c);
                }
            } else if ((i2 & 14) == 14) {
                aVar.a(d0VarI, m1VarK.b, m1VarK.c);
            } else if ((i2 & 12) == 12) {
                aVar.d(d0VarI, m1VarK.b, m1VarK.c);
            } else if ((i2 & 4) != 0) {
                aVar.c(d0VarI, m1VarK.b, null);
            } else if ((i2 & 8) != 0) {
                aVar.a(d0VarI, m1VarK.b, m1VarK.c);
            }
            m1.c(m1VarK);
        }
    }

    void p(RecyclerView.d0 d0Var) {
        m1 m1Var = this.a.get(d0Var);
        if (m1Var == null) {
            return;
        }
        m1Var.a &= -2;
    }

    void q(RecyclerView.d0 d0Var) {
        int iM = this.b.m() - 1;
        while (true) {
            if (iM < 0) {
                break;
            }
            if (d0Var == this.b.n(iM)) {
                this.b.l(iM);
                break;
            }
            iM--;
        }
        m1 m1VarRemove = this.a.remove(d0Var);
        if (m1VarRemove != null) {
            m1.c(m1VarRemove);
        }
    }
}
