package h.f.a;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes.dex */
class a extends ContentObserver {
    final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a(c cVar) {
        super(new Handler());
        this.a = cVar;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.a.i();
    }
}
