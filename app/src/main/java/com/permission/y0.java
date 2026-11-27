package com.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/* loaded from: classes.dex */
public class y0 extends z0 {
    @Override // com.permission.z0
    public void a() {
        Intent[] intentArr = {new Intent().setComponent(new ComponentName("com.yulong.android.coolsafe", "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity"))};
        for (int i2 = 0; i2 < 1; i2++) {
            try {
                com.frame.v0.g().d().startActivityForResult(intentArr[i2], 0);
                return;
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }

    @Override // com.permission.z0
    public void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
            intent.setFlags(268435456);
            if (h(intent, context)) {
                context.startActivity(intent);
            } else {
                intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.appEnterActivity");
                if (h(intent, context)) {
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "请手动设置悬浮窗权限", 1).show();
                    Log.e("QikuUtils", "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
                }
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            if (Build.VERSION.SDK_INT >= 23) {
                super.b(context);
            }
        }
    }

    @Override // com.permission.z0
    public float g() {
        return 0.0f;
    }
}
