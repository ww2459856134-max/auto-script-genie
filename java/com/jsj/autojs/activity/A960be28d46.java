package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.user.AccountTool;
import com.v.TaskChooseDialogView;
import com.yl.float_ui.SimpleLogView;
import com.yl.ui.s;
import i.b.da;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class A960be28d46 extends com.yl.ui.p {
    public static void k0(final com.yl.ui.p pVar, Intent intent) {
        final String str = da.z() + "/import/temp.ajs";
        final File file = new File(str);
        try {
            Uri data = intent.getData();
            final Uri uri = data == null ? (Uri) intent.getParcelableExtra("android.intent.extra.STREAM") : data;
            final String string = uri.toString();
            String strT = com.frame.r0.t(pVar, uri);
            if (strT == null) {
                strT = uri.getLastPathSegment();
            }
            final String str2 = strT;
            pVar.V("导入中...");
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.r3
                @Override // java.lang.Runnable
                public final void run() {
                    A960be28d46.o0(pVar, uri, file, string, str, str2);
                }
            });
        } catch (Exception e) {
            com.frame.y0.l(e);
            com.jsj.autojs.l.c0.e().B("导入错误！请确认是否是脚本文件", e);
        }
    }

    static /* synthetic */ void m0(com.yl.ui.p pVar) {
        pVar.S();
        if (com.frame.w0.d() || com.permission.x0.m().p()) {
            TaskChooseDialogView.show();
        }
        if (pVar != null) {
            pVar.finish();
        }
    }

    static /* synthetic */ void n0(final com.yl.ui.p pVar) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.f8
            @Override // java.lang.Runnable
            public final void run() {
                com.jsj.widget.d.a();
            }
        });
        com.frame.l1.f(new Runnable() { // from class: com.jsj.autojs.activity.o3
            @Override // java.lang.Runnable
            public final void run() {
                A960be28d46.m0(pVar);
            }
        }, 600L);
    }

    static /* synthetic */ void o0(final com.yl.ui.p pVar, Uri uri, File file, String str, final String str2, String str3) {
        InputStream inputStreamOpenInputStream;
        try {
            try {
                try {
                    inputStreamOpenInputStream = pVar.getContentResolver().openInputStream(uri);
                } catch (Exception e) {
                    pVar.S();
                    com.jsj.autojs.l.c0.e().B("导入错误！请确认是否是脚本文件(" + file.getName() + ")", e);
                    file.delete();
                }
                try {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    o.a.b.a(inputStreamOpenInputStream, new FileOutputStream(file));
                    if (str.endsWith(".txt")) {
                        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.t3
                            @Override // java.lang.Runnable
                            public final void run() {
                                SimpleLogView.P().R(new File(str2));
                            }
                        });
                    } else {
                        new i.b.f8().c(str2, null, str3, false, new Runnable() { // from class: com.jsj.autojs.activity.s3
                            @Override // java.lang.Runnable
                            public final void run() {
                                A960be28d46.n0(pVar);
                            }
                        });
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    file.delete();
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th3) {
            try {
                file.delete();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(DialogInterface dialogInterface, int i2) {
        startActivity(new Intent(this, (Class<?>) A047634d3a4.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(DialogInterface dialogInterface, int i2) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(Intent intent) {
        k0(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(Intent intent) {
        k0(this, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(Intent intent) {
        k0(this, intent);
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!AccountTool.d().j()) {
            s.a aVar = new s.a(this);
            aVar.j("请先登录");
            aVar.r("登录", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.p3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.q0(dialogInterface, i2);
                }
            });
            aVar.m("关闭", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.v3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.s0(dialogInterface, i2);
                }
            });
            aVar.e().show();
            return;
        }
        final Intent intent = getIntent();
        String action = intent.getAction();
        intent.getType();
        if ("fromMe".equals(action)) {
            U();
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.n3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.u0(intent);
                }
            });
        } else if ("android.intent.action.SEND".equals(action)) {
            U();
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.q3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.w0(intent);
                }
            });
        } else if ("android.intent.action.VIEW".equals(action)) {
            U();
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.u3
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.y0(intent);
                }
            });
        }
    }
}
