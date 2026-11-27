package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class a0 extends b0 {
    a0() {
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean a() {
        return true;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean b() {
        return true;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean c(com.bumptech.glide.load.a aVar) {
        return aVar == com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean d(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
        return ((z && aVar == com.bumptech.glide.load.a.DATA_DISK_CACHE) || aVar == com.bumptech.glide.load.a.LOCAL) && cVar == com.bumptech.glide.load.c.TRANSFORMED;
    }
}
