package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class x extends b0 {
    x() {
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
        return (aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || aVar == com.bumptech.glide.load.a.MEMORY_CACHE) ? false : true;
    }
}
