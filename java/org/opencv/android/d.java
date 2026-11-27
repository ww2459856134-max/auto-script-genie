package org.opencv.android;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes2.dex */
class d implements u {
    final /* synthetic */ e a;

    d(e eVar) {
        this.a = eVar;
    }

    @Override // org.opencv.android.u
    public void a() {
        Log.d("OpenCVManager/Helper", "Waiting for current installation");
        try {
            f fVar = this.a.a;
            if (fVar.a.e(fVar.c)) {
                Log.d("OpenCVManager/Helper", "Wating for package installation");
            } else {
                Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
                Log.d("OpenCVManager/Helper", "Init finished with status 2");
                Log.d("OpenCVManager/Helper", "Calling using callback");
                this.a.a.b.b(2);
            }
            Log.d("OpenCVManager/Helper", "Unbind from service");
            f fVar2 = this.a.a;
            fVar2.d.unbindService(fVar2.e);
        } catch (RemoteException e) {
            e.printStackTrace();
            Log.d("OpenCVManager/Helper", "Init finished with status 255");
            Log.d("OpenCVManager/Helper", "Unbind from service");
            f fVar3 = this.a.a;
            fVar3.d.unbindService(fVar3.e);
            Log.d("OpenCVManager/Helper", "Calling using callback");
            this.a.a.b.b(255);
        }
    }

    @Override // org.opencv.android.u
    public String b() {
        return "OpenCV library";
    }

    @Override // org.opencv.android.u
    public void c() {
        Log.e("OpenCVManager/Helper", "Nothing to install we just wait current installation");
    }

    @Override // org.opencv.android.u
    public void cancel() {
        Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
        f.g = false;
        Log.d("OpenCVManager/Helper", "Init finished with status 3");
        Log.d("OpenCVManager/Helper", "Unbind from service");
        f fVar = this.a.a;
        fVar.d.unbindService(fVar.e);
        Log.d("OpenCVManager/Helper", "Calling using callback");
        this.a.a.b.b(3);
    }
}
