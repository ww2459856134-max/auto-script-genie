package com.bumptech.glide.load.z.j;

import com.bumptech.glide.load.x.u0;

/* loaded from: classes.dex */
public class h extends com.bumptech.glide.load.z.h.b<f> implements u0 {
    public h(f fVar) {
        super(fVar);
    }

    @Override // com.bumptech.glide.load.x.z0
    public void a() {
        ((f) this.c).stop();
        ((f) this.c).k();
    }

    @Override // com.bumptech.glide.load.x.z0
    public Class<f> b() {
        return f.class;
    }

    @Override // com.bumptech.glide.load.z.h.b, com.bumptech.glide.load.x.u0
    public void c() {
        ((f) this.c).e().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.x.z0
    public int getSize() {
        return ((f) this.c).i();
    }
}
