package com.bumptech.glide.load.y.u1;

import com.bumptech.glide.load.q;
import com.bumptech.glide.load.r;
import com.bumptech.glide.load.w.p;
import com.bumptech.glide.load.y.c0;
import com.bumptech.glide.load.y.n0;
import com.bumptech.glide.load.y.o0;
import com.bumptech.glide.load.y.p0;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b implements p0<c0, InputStream> {
    public static final q<Integer> b = q.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final n0<c0, c0> a;

    public b(n0<c0, c0> n0Var) {
        this.a = n0Var;
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o0<InputStream> a(c0 c0Var, int i2, int i3, r rVar) {
        n0<c0, c0> n0Var = this.a;
        if (n0Var != null) {
            c0 c0VarA = n0Var.a(c0Var, 0, 0);
            if (c0VarA == null) {
                this.a.b(c0Var, 0, 0, c0Var);
            } else {
                c0Var = c0VarA;
            }
        }
        return new o0<>(c0Var, new p(c0Var, ((Integer) rVar.c(b)).intValue()));
    }

    @Override // com.bumptech.glide.load.y.p0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(c0 c0Var) {
        return true;
    }
}
