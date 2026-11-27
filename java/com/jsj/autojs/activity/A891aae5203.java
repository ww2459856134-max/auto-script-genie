package com.jsj.autojs.activity;

import android.app.Activity;
import android.os.Bundle;
import i.b.da;

/* loaded from: classes.dex */
public class A891aae5203 extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("shortcut_task_id", 0L);
        if (longExtra != 0) {
            finish();
            try {
                da.B().e2(da.B().L(longExtra), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
