package com.bumptech.glide.load.x.h1;

/* loaded from: classes.dex */
public class v {
    private final com.bumptech.glide.b0.k<com.bumptech.glide.load.n, String> a = new com.bumptech.glide.b0.k<>(1000);
    private final h.e.i.e<u> b = com.bumptech.glide.b0.q.h.d(10, new t(this));

    private String a(com.bumptech.glide.load.n nVar) {
        u uVarA = this.b.a();
        com.bumptech.glide.b0.n.d(uVarA);
        u uVar = uVarA;
        try {
            nVar.b(uVar.c);
            return com.bumptech.glide.b0.p.s(uVar.c.digest());
        } finally {
            this.b.b(uVar);
        }
    }

    public String b(com.bumptech.glide.load.n nVar) {
        String strG;
        synchronized (this.a) {
            strG = this.a.g(nVar);
        }
        if (strG == null) {
            strG = a(nVar);
        }
        synchronized (this.a) {
            this.a.k(nVar, strG);
        }
        return strG;
    }
}
