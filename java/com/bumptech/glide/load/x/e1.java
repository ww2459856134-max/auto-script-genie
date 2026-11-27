package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class e1 implements com.bumptech.glide.load.w.d<Object> {
    final /* synthetic */ com.bumptech.glide.load.y.o0 c;
    final /* synthetic */ f1 d;

    e1(f1 f1Var, com.bumptech.glide.load.y.o0 o0Var) {
        this.d = f1Var;
        this.c = o0Var;
    }

    @Override // com.bumptech.glide.load.w.d
    public void e(Object obj) {
        if (this.d.g(this.c)) {
            this.d.h(this.c, obj);
        }
    }

    @Override // com.bumptech.glide.load.w.d
    public void f(Exception exc) {
        if (this.d.g(this.c)) {
            this.d.i(this.c, exc);
        }
    }
}
