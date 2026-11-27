package org.opencv.android;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
final class b implements u {
    private v a;
    final /* synthetic */ v b;
    final /* synthetic */ Context c;

    b(v vVar, Context context) {
        this.b = vVar;
        this.c = context;
        this.a = vVar;
    }

    @Override // org.opencv.android.u
    public void a() {
        f.b(this.c);
    }

    @Override // org.opencv.android.u
    public String b() {
        return "OpenCV Manager";
    }

    @Override // org.opencv.android.u
    public void c() {
        Log.e("OpenCVManager/Helper", "Nothing to install we just wait current installation");
    }

    @Override // org.opencv.android.u
    public void cancel() {
        Log.d("OpenCVManager/Helper", "Waiting for OpenCV canceled by user");
        f.f = false;
        Log.d("OpenCVManager/Helper", "Init finished with status 3");
        Log.d("OpenCVManager/Helper", "Calling using callback");
        this.a.b(3);
    }
}
