package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.widget.b1;

/* loaded from: classes.dex */
class g implements b1 {
    final /* synthetic */ i c;

    g(i iVar) {
        this.c = iVar;
    }

    @Override // androidx.appcompat.widget.b1
    public void b(m mVar, MenuItem menuItem) {
        this.c.f70i.removeCallbacksAndMessages(null);
        int size = this.c.f72k.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (mVar == this.c.f72k.get(i2).b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return;
        }
        int i3 = i2 + 1;
        this.c.f70i.postAtTime(new f(this, i3 < this.c.f72k.size() ? this.c.f72k.get(i3) : null, menuItem, mVar), mVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // androidx.appcompat.widget.b1
    public void h(m mVar, MenuItem menuItem) {
        this.c.f70i.removeCallbacksAndMessages(mVar);
    }
}
