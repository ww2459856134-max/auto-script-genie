package com.jsj.autojs.activity;

import android.os.Bundle;
import com.tencent.cursor.R;

/* loaded from: classes.dex */
public class A7e785dd303 extends com.yl.ui.p {
    int P;

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.frame.k0.t(this, getString(R.string.app_name), getIntent().getStringExtra("data"));
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.P > 0) {
            finish();
        }
        this.P++;
    }
}
