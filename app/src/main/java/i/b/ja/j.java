package i.b.ja;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: classes.dex */
class j implements ServiceConnection {
    final /* synthetic */ m a;

    j(m mVar) {
        this.a = mVar;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.a.f();
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        this.a.f();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.a) {
            this.a.b = com.jsj.autojs.k.b.g(iBinder);
            try {
                final m mVar = this.a;
                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: i.b.ja.a
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        mVar.f();
                    }
                }, 0);
            } catch (RemoteException unused) {
                this.a.b = null;
            }
            if (this.a.c != null) {
                this.a.c.countDown();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f();
    }
}
