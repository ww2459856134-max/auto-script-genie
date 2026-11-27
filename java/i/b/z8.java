package i.b;

import android.content.Intent;
import android.os.RemoteException;
import android.view.IRotationWatcher;

/* loaded from: classes.dex */
class z8 extends IRotationWatcher.Stub {
    z8() {
    }

    @Override // android.view.IRotationWatcher
    public void onRotationChanged(int i2) throws RemoteException {
        if (a9.a != i2) {
            try {
                a9.a = i2;
                a9.f(i2);
                Intent intent = new Intent("SCREEN_ROTATION");
                intent.putExtra("rotation", i2);
                h.m.a.d.b(com.frame.v0.g()).c(intent);
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }
}
