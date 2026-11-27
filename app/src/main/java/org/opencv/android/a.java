package org.opencv.android;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
final class a implements u {
    private v a;
    final /* synthetic */ v b;
    final /* synthetic */ Context c;

    a(v vVar, Context context) {
        this.b = vVar;
        this.c = context;
        this.a = vVar;
    }

    @Override // org.opencv.android.u
    public void a() {
        Log.e("OpenCVManager/Helper", "Installation was not started! Nothing to wait!");
    }

    @Override // org.opencv.android.u
    public String b() {
        return "OpenCV Manager";
    }

    @Override // org.opencv.android.u
    public void c() {
        Log.d("OpenCVManager/Helper", "Trying to install OpenCV Manager via Google Play");
        if (f.b(this.c)) {
            f.f = true;
            Log.d("OpenCVManager/Helper", "Package installation started");
            return;
        }
        Log.d("OpenCVManager/Helper", "OpenCV package was not installed!");
        Log.d("OpenCVManager/Helper", "Init finished with status 2");
        Log.d("OpenCVManager/Helper", "Unbind from service");
        Log.d("OpenCVManager/Helper", "Calling using callback");
        this.a.b(2);
    }

    @Override // org.opencv.android.u
    public void cancel() {
        Log.d("OpenCVManager/Helper", "OpenCV library installation was canceled");
        Log.d("OpenCVManager/Helper", "Init finished with status 3");
        Log.d("OpenCVManager/Helper", "Calling using callback");
        this.a.b(3);
    }
}
