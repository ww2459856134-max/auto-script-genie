package com.bumptech.glide.load.x.h1;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.x.z0;

/* loaded from: classes.dex */
public class m extends com.bumptech.glide.b0.k<com.bumptech.glide.load.n, z0<?>> implements o {
    private n d;

    public m(long j2) {
        super(j2);
    }

    @Override // com.bumptech.glide.load.x.h1.o
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.x.h1.o
    public /* bridge */ /* synthetic */ z0 c(com.bumptech.glide.load.n nVar, z0 z0Var) {
        return (z0) super.k(nVar, z0Var);
    }

    @Override // com.bumptech.glide.load.x.h1.o
    public /* bridge */ /* synthetic */ z0 d(com.bumptech.glide.load.n nVar) {
        return (z0) super.l(nVar);
    }

    @Override // com.bumptech.glide.load.x.h1.o
    public void e(n nVar) {
        this.d = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.b0.k
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(z0<?> z0Var) {
        return z0Var == null ? super.i(null) : z0Var.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.b0.k
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(com.bumptech.glide.load.n nVar, z0<?> z0Var) {
        n nVar2 = this.d;
        if (nVar2 == null || z0Var == null) {
            return;
        }
        nVar2.d(z0Var);
    }
}
