package org.opencv.android;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes2.dex */
class c implements u {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    @Override // org.opencv.android.u
    public void a() {
        Log.e("OpenCVManager/Helper", "Installation was not started! Nothing to wait!");
    }

    @Override // org.opencv.android.u
    public String b() {
        return "OpenCV library";
    }

    @Override // org.opencv.android.u
    public void c() {
        Log.d("OpenCVManager/Helper", "Trying to install OpenCV lib via Google Play");
        try {
            f fVar = this.a.a;
            if (fVar.a.e(fVar.c)) {
                f.g = true;
                Log.d("OpenCVManager/Helper", "Package installation started");
                Log.d("OpenCVManager/Helper", "Unbind from service");
                f fVar2 = this.a.a;
                fVar2.d.unbindService(fVar2.e);
            } else {
                Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
                Log.d("OpenCVManager/Helper", "Init finished with status 2");
                Log.d("OpenCVManager/Helper", "Unbind from service");
                f fVar3 = this.a.a;
                fVar3.d.unbindService(fVar3.e);
                Log.d("OpenCVManager/Helper", "Calling using callback");
                this.a.a.b.b(2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d("OpenCVManager/Helper", "Init finished with status 255");
            Log.d("OpenCVManager/Helper", "Unbind from service");
            f fVar4 = this.a.a;
            fVar4.d.unbindService(fVar4.e);
            Log.d("OpenCVManager/Helper", "Calling using callback");
            this.a.a.b.b(255);
        }
    }

    @Override // org.opencv.android.u
    public void cancel() {
        Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
        Log.d("OpenCVManager/Helper", "Init finished with status 3");
        Log.d("OpenCVManager/Helper", "Unbind from service");
        f fVar = this.a.a;
        fVar.d.unbindService(fVar.e);
        Log.d("OpenCVManager/Helper", "Calling using callback");
        this.a.a.b.b(3);
    }
}
