package com.bumptech.glide.load.x;

/* loaded from: classes.dex */
class s {
    private boolean a;
    private boolean b;
    private boolean c;

    s() {
    }

    private boolean a(boolean z) {
        return (this.c || z || this.b) && this.a;
    }

    synchronized boolean b() {
        this.b = true;
        return a(false);
    }

    synchronized boolean c() {
        this.c = true;
        return a(false);
    }

    synchronized boolean d(boolean z) {
        this.a = true;
        return a(z);
    }

    synchronized void e() {
        this.b = false;
        this.a = false;
        this.c = false;
    }
}
