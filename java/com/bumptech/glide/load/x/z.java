package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class z extends b0 {
    z() {
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean a() {
        return true;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean b() {
        return false;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean c(com.bumptech.glide.load.a aVar) {
        return (aVar == com.bumptech.glide.load.a.DATA_DISK_CACHE || aVar == com.bumptech.glide.load.a.MEMORY_CACHE) ? false : true;
    }

    @Override // com.bumptech.glide.load.x.b0
    public boolean d(boolean z, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.c cVar) {
        return false;
    }
}
