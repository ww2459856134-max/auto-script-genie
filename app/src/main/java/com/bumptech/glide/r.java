package com.bumptech.glide;

/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ s c;

    r(s sVar) {
        this.c = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        s sVar = this.c;
        sVar.e.b(sVar);
    }
}
