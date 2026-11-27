package org.opencv.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.opencv.core.Core;

/* loaded from: classes2.dex */
class e implements ServiceConnection {
    final /* synthetic */ f a;

    e(f fVar) {
        this.a = fVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("OpenCVManager/Helper", "Service connection created");
        this.a.a = n.c.b.b.g(iBinder);
        n.c.b.c cVar = this.a.a;
        if (cVar == null) {
            Log.d("OpenCVManager/Helper", "OpenCV Manager Service connection fails. May be service was not installed?");
            f fVar = this.a;
            f.a(fVar.d, fVar.b);
            return;
        }
        int i2 = 0;
        f.f = false;
        try {
            if (cVar.d() < 2) {
                Log.d("OpenCVManager/Helper", "Init finished with status 4");
                Log.d("OpenCVManager/Helper", "Unbind from service");
                f fVar2 = this.a;
                fVar2.d.unbindService(fVar2.e);
                Log.d("OpenCVManager/Helper", "Calling using callback");
                this.a.b.b(4);
                return;
            }
            Log.d("OpenCVManager/Helper", "Trying to get library path");
            f fVar3 = this.a;
            String strB = fVar3.a.b(fVar3.c);
            if (strB != null && strB.length() != 0) {
                Log.d("OpenCVManager/Helper", "Trying to get library list");
                f.g = false;
                f fVar4 = this.a;
                String strC = fVar4.a.c(fVar4.c);
                Log.d("OpenCVManager/Helper", "Library list: \"" + strC + "\"");
                Log.d("OpenCVManager/Helper", "First attempt to load libs");
                if (this.a.e(strB, strC)) {
                    Log.d("OpenCVManager/Helper", "First attempt to load libs is OK");
                    for (String str : Core.a().split(System.getProperty("line.separator"))) {
                        Log.i("OpenCVManager/Helper", str);
                    }
                } else {
                    Log.d("OpenCVManager/Helper", "First attempt to load libs fails");
                    i2 = 255;
                }
                Log.d("OpenCVManager/Helper", "Init finished with status " + i2);
                Log.d("OpenCVManager/Helper", "Unbind from service");
                f fVar5 = this.a;
                fVar5.d.unbindService(fVar5.e);
                Log.d("OpenCVManager/Helper", "Calling using callback");
                this.a.b.b(i2);
                return;
            }
            if (f.g) {
                this.a.b.a(1, new d(this));
            } else {
                this.a.b.a(0, new c(this));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d("OpenCVManager/Helper", "Init finished with status 255");
            Log.d("OpenCVManager/Helper", "Unbind from service");
            f fVar6 = this.a;
            fVar6.d.unbindService(fVar6.e);
            Log.d("OpenCVManager/Helper", "Calling using callback");
            this.a.b.b(255);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.a = null;
    }
}
