package com.frame;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import java.io.File;

/* loaded from: classes.dex */
public abstract class c1 {
    public static void a(File file) {
        b(file, "text/plain", file == null ? null : file.getName());
    }

    public static void b(final File file, final String str, final String str2) {
        l1.e(new Runnable() { // from class: com.frame.z
            @Override // java.lang.Runnable
            public final void run() {
                c1.c(file, str, str2);
            }
        });
    }

    static /* synthetic */ void c(File file, String str, String str2) {
        if (file == null || !file.isFile()) {
            Toast.makeText(v0.g(), "文件不存在，无法导出", 0).show();
            return;
        }
        if (!file.canRead()) {
            Toast.makeText(v0.g(), "文件无法读取，无法导出", 0).show();
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClassName(v0.g(), "com.a.FileSaveSafAct");
            intent.putExtra("source_path", file.getAbsolutePath());
            if (TextUtils.isEmpty(str)) {
                str = "text/plain";
            }
            intent.putExtra("mime_type", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = file.getName();
            }
            intent.putExtra("display_name", str2);
            Activity activityD = v0.g().d();
            if (activityD == null || activityD.isFinishing() || activityD.isDestroyed()) {
                v0.g().u(intent);
            } else {
                activityD.startActivity(intent);
            }
        } catch (Exception e) {
            k0.r(e);
            Toast.makeText(v0.g(), "无法打开导出界面，请重试", 0).show();
        }
    }
}
