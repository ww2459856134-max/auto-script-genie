package com.a;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.v.FileChooseView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FileChooseSafAct extends com.yl.ui.p {
    private boolean P;

    private List<Uri> k0(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                Uri uri = intent.getClipData().getItemAt(i2).getUri();
                if (uri != null) {
                    arrayList.add(uri);
                }
            }
        } else if (intent.getData() != null) {
            arrayList.add(intent.getData());
        }
        return arrayList;
    }

    private void l0() {
        if (this.P) {
            return;
        }
        this.P = true;
        com.frame.s0.g().v();
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().f(FileChooseView.class);
        if (fileChooseView != null) {
            fileChooseView.x();
        }
        com.frame.v0.g().o(null);
        finish();
    }

    private void m0(List<File> list) {
        if (this.P) {
            return;
        }
        this.P = true;
        com.frame.s0.g().v();
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().f(FileChooseView.class);
        if (fileChooseView != null) {
            fileChooseView.b(list);
        }
        com.frame.v0.g().o(null);
        finish();
    }

    private void n0(List<Uri> list) {
        if (this.P) {
            return;
        }
        for (Uri uri : list) {
            try {
                getContentResolver().takePersistableUriPermission(uri, 1);
                getContentResolver().takePersistableUriPermission(uri, 2);
            } catch (Exception unused) {
            }
        }
        this.P = true;
        com.frame.s0.g().v();
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().f(FileChooseView.class);
        if (fileChooseView != null) {
            fileChooseView.c(list);
        }
        com.frame.v0.g().o(null);
        finish();
    }

    private String o0(Uri uri) {
        int columnIndex;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_display_name")) >= 0) {
                    String string = cursorQuery.getString(columnIndex);
                    if (!TextUtils.isEmpty(string)) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return "file_" + System.currentTimeMillis();
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private boolean p0(String str) {
        return "image/*".equals(str) || str.startsWith("image/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(List list) {
        if (list.isEmpty()) {
            l0();
        } else {
            m0(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(List list) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File fileW0 = w0((Uri) it.next());
            if (fileW0 != null) {
                arrayList.add(fileW0);
            }
        }
        com.frame.l1.e(new Runnable() { // from class: com.a.y0
            @Override // java.lang.Runnable
            public final void run() {
                this.c.r0(arrayList);
            }
        });
    }

    private void u0() {
        Intent intent;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            l0();
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("allow_multiple", false);
        String stringExtra = getIntent().getStringExtra("mime_type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "*/*";
        }
        if (booleanExtra && p0(stringExtra)) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(stringExtra);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        } else {
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType(stringExtra);
            if (booleanExtra && i2 >= 18) {
                intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent = intent2;
        }
        intent.addFlags(1);
        intent.addFlags(2);
        intent.addFlags(64);
        try {
            startActivityForResult(intent, com.permission.x0.f838k.intValue());
        } catch (Exception e) {
            com.frame.k0.r(e);
            l0();
        }
    }

    public static void v0(boolean z, String str) {
        if (com.frame.v0.g().d() instanceof FileChooseSafAct) {
            return;
        }
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) FileChooseSafAct.class);
        intent.addFlags(268435456);
        intent.putExtra("allow_multiple", z);
        if (TextUtils.isEmpty(str)) {
            str = "*/*";
        }
        intent.putExtra("mime_type", str);
        com.frame.v0.g().startActivity(intent);
    }

    private File w0(Uri uri) {
        try {
            getContentResolver().takePersistableUriPermission(uri, 1);
        } catch (Exception unused) {
        }
        try {
            return com.frame.r0.c(uri, "saf_pick", o0(uri));
        } catch (IOException e) {
            com.frame.k0.r(e);
            File fileK = com.frame.r0.k(uri);
            if (fileK == null || !fileK.exists()) {
                return null;
            }
            return fileK;
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != com.permission.x0.f838k.intValue()) {
            return;
        }
        if (i3 != -1 || intent == null) {
            l0();
            return;
        }
        final List<Uri> listK0 = k0(intent);
        if (listK0.isEmpty()) {
            l0();
            return;
        }
        FileChooseView fileChooseView = (FileChooseView) com.frame.s0.g().f(FileChooseView.class);
        if ((fileChooseView == null || (fileChooseView.getCallback() == null && fileChooseView.getMultiFileChooseCallback() == null)) ? false : true) {
            com.frame.l1.g(new Runnable() { // from class: com.a.z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.t0(listK0);
                }
            });
        } else {
            n0(listK0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        l0();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.frame.s0.g().k();
        com.frame.v0.g().o(this);
        u0();
    }
}
