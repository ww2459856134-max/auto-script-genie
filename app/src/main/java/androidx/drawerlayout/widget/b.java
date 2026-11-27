package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DrawerLayout.g c;

    b(DrawerLayout.g gVar) {
        this.c = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.o();
    }
}
