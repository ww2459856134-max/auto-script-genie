package androidx.fragment.app;

/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ Fragment c;

    u(Fragment fragment) {
        this.c = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.i(false);
    }
}
