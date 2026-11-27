package com.jsj.autojs.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.frame.i0;
import com.user.w;

/* loaded from: classes.dex */
public class WXEntryActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        i0.k(this, true);
        if (w.e == null) {
            finish();
        }
        super.onCreate(bundle);
        w.h().i(getIntent());
        finish();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return true;
    }
}
