package com.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.v.FileChooseView;
import i.b.t7;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FileChooseStoragePermissionAct extends com.yl.ui.p {
    private boolean P;

    private void k0() {
        if (this.P) {
            return;
        }
        this.P = true;
        com.frame.s0.g().v();
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().f(FileChooseView.class);
        if (fileChooseView != null) {
            fileChooseView.y();
        }
        com.frame.v0.g().o(null);
        finish();
    }

    private void l0() {
        if (Build.VERSION.SDK_INT < t7.d) {
            ArrayList arrayList = new ArrayList();
            if (androidx.core.content.a.a(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
            if (androidx.core.content.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (arrayList.isEmpty()) {
                k0();
                return;
            } else {
                androidx.core.app.f.l(this, (String[]) arrayList.toArray(new String[0]), com.permission.x0.e.intValue());
                return;
            }
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, com.permission.x0.e.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            k0();
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (com.permission.x0.e.intValue() == i2) {
            k0();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        k0();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.frame.s0.g().k();
        com.frame.v0.g().o(this);
        if (t7.l()) {
            k0();
        } else {
            l0();
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (com.permission.x0.e.intValue() == i2) {
            k0();
        }
    }
}
