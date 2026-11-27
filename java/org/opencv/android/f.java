package org.opencv.android;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
class f {
    protected static boolean f = false;
    protected static boolean g = false;
    protected n.c.b.c a;
    protected v b;
    protected String c;
    protected Context d;
    protected ServiceConnection e = new e(this);

    protected f(String str, Context context, v vVar) {
        this.c = str;
        this.b = vVar;
        this.d = context;
    }

    protected static void a(Context context, v vVar) {
        if (f) {
            Log.d("OpenCVManager/Helper", "Waiting current installation process");
            vVar.a(1, new b(vVar, context));
        } else {
            Log.d("OpenCVManager/Helper", "Request new service installation");
            vVar.a(0, new a(vVar, context));
        }
    }

    protected static boolean b(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=org.opencv.engine"));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(String str, Context context, v vVar) {
        f fVar = new f(str, context, vVar);
        Intent intent = new Intent("org.opencv.engine.BIND");
        intent.setPackage("org.opencv.engine");
        if (context.bindService(intent, fVar.e, 1)) {
            return true;
        }
        context.unbindService(fVar.e);
        a(context, vVar);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, String str2) {
        Log.d("OpenCVManager/Helper", "Trying to init OpenCV libs");
        if (str == null || str.length() == 0) {
            Log.d("OpenCVManager/Helper", "Library path \"" + str + "\" is empty");
            return false;
        }
        boolean zF = true;
        if (str2 == null || str2.length() == 0) {
            return f(str + File.separator + "libopencv_java3.so");
        }
        Log.d("OpenCVManager/Helper", "Trying to load libs by dependency list");
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ";");
        while (stringTokenizer.hasMoreTokens()) {
            zF &= f(str + File.separator + stringTokenizer.nextToken());
        }
        return zF;
    }

    private boolean f(String str) {
        Log.d("OpenCVManager/Helper", "Trying to load library " + str);
        try {
            System.load(str);
            Log.d("OpenCVManager/Helper", "OpenCV libs init was ok!");
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.d("OpenCVManager/Helper", "Cannot load library \"" + str + "\"");
            e.printStackTrace();
            return false;
        }
    }
}
