package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public abstract class n implements v {
    protected Context a;

    public n(Context context) {
        this.a = context;
    }

    @Override // org.opencv.android.v
    public void a(int i2, u uVar) {
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.a).create();
            alertDialogCreate.setTitle("OpenCV is not ready");
            alertDialogCreate.setMessage("Installation is in progress. Wait or exit?");
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setButton(-1, "Wait", new l(this, uVar));
            alertDialogCreate.setButton(-2, "Exit", new m(this, uVar));
            alertDialogCreate.show();
            return;
        }
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.a).create();
        alertDialogCreate2.setTitle("Package not found");
        alertDialogCreate2.setMessage(uVar.b() + " package was not found! Try to install it?");
        alertDialogCreate2.setCancelable(false);
        alertDialogCreate2.setButton(-1, "Yes", new j(this, uVar));
        alertDialogCreate2.setButton(-2, "No", new k(this, uVar));
        alertDialogCreate2.show();
    }

    @Override // org.opencv.android.v
    public void b(int i2) {
        if (i2 != 0) {
            if (i2 == 2) {
                Log.e("OpenCVLoader/BaseLoaderCallback", "Package installation failed!");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this.a).create();
                alertDialogCreate.setTitle("OpenCV Manager");
                alertDialogCreate.setMessage("Package installation failed!");
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.setButton(-1, "OK", new g(this));
                alertDialogCreate.show();
                return;
            }
            if (i2 == 3) {
                Log.d("OpenCVLoader/BaseLoaderCallback", "OpenCV library installation was canceled by user");
                c();
                return;
            }
            if (i2 != 4) {
                Log.e("OpenCVLoader/BaseLoaderCallback", "OpenCV loading failed!");
                AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.a).create();
                alertDialogCreate2.setTitle("OpenCV error");
                alertDialogCreate2.setMessage("OpenCV was not initialised correctly. Application will be shut down");
                alertDialogCreate2.setCancelable(false);
                alertDialogCreate2.setButton(-1, "OK", new i(this));
                alertDialogCreate2.show();
                return;
            }
            Log.d("OpenCVLoader/BaseLoaderCallback", "OpenCV Manager Service is uncompatible with this app!");
            AlertDialog alertDialogCreate3 = new AlertDialog.Builder(this.a).create();
            alertDialogCreate3.setTitle("OpenCV Manager");
            alertDialogCreate3.setMessage("OpenCV Manager service is incompatible with this app. Try to update it via Google Play.");
            alertDialogCreate3.setCancelable(false);
            alertDialogCreate3.setButton(-1, "OK", new h(this));
            alertDialogCreate3.show();
        }
    }

    void c() {
        ((Activity) this.a).finish();
    }
}
