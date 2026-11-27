package com.a;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.v.FloatToast;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class FileSaveSafAct extends com.yl.ui.p {
    private boolean P;
    private File Q;

    private void k0() {
        l0();
    }

    private void l0() {
        if (this.P) {
            return;
        }
        this.P = true;
        com.frame.s0.g().v();
        com.frame.v0.g().o(null);
        finish();
    }

    private boolean m0(File file, Uri uri) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(uri, "wt");
                if (outputStreamOpenOutputStream == null) {
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                    fileInputStream.close();
                    return false;
                }
                try {
                    o.a.b.b(fileInputStream, outputStreamOpenOutputStream, false);
                    outputStreamOpenOutputStream.flush();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                    fileInputStream.close();
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(boolean z, Uri uri) {
        if (z) {
            s0(uri);
        } else {
            FloatToast.i("导出失败");
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(final Uri uri) throws IOException {
        final boolean zM0 = m0(this.Q, uri);
        com.frame.l1.e(new Runnable() { // from class: com.a.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o0(zM0, uri);
            }
        });
    }

    private void r0() {
        if (Build.VERSION.SDK_INT < 19) {
            k0();
            return;
        }
        String stringExtra = getIntent().getStringExtra("mime_type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "text/plain";
        }
        String stringExtra2 = getIntent().getStringExtra("display_name");
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = this.Q.getName();
        }
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(stringExtra);
        intent.putExtra("android.intent.extra.TITLE", stringExtra2);
        intent.addFlags(2);
        intent.addFlags(1);
        try {
            startActivityForResult(intent, 10024);
        } catch (Exception e) {
            com.frame.k0.r(e);
            FloatToast.i("无法打开文件保存界面，请检查系统文件管理器");
            k0();
        }
    }

    private void s0(Uri uri) {
        String stringExtra = getIntent().getStringExtra("mime_type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "text/plain";
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(stringExtra);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setClipData(ClipData.newRawUri("日志", uri));
        intent.addFlags(1);
        try {
            startActivityForResult(Intent.createChooser(intent, "分享日志"), 10025);
        } catch (Exception e) {
            com.frame.k0.r(e);
            FloatToast.i("日志导出成功，但无法打开分享");
            l0();
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10025) {
            l0();
            return;
        }
        if (i2 != 10024) {
            return;
        }
        if (i3 != -1 || intent == null || intent.getData() == null) {
            k0();
        } else {
            final Uri data = intent.getData();
            com.frame.l1.g(new Runnable() { // from class: com.a.b1
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.c.q0(data);
                }
            });
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
        String stringExtra = getIntent().getStringExtra("source_path");
        if (TextUtils.isEmpty(stringExtra)) {
            k0();
            return;
        }
        File file = new File(stringExtra);
        this.Q = file;
        if (!file.isFile() || !this.Q.canRead()) {
            FloatToast.i("文件不存在或无法读取");
            k0();
        } else if (bundle == null) {
            r0();
        }
    }
}
