package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ String[] c;
    final /* synthetic */ Activity d;
    final /* synthetic */ int e;

    a(String[] strArr, Activity activity, int i2) {
        this.c = strArr;
        this.d = activity;
        this.e = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.c.length];
        PackageManager packageManager = this.d.getPackageManager();
        String packageName = this.d.getPackageName();
        int length = this.c.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = packageManager.checkPermission(this.c[i2], packageName);
        }
        ((c) this.d).onRequestPermissionsResult(this.e, this.c, iArr);
    }
}
