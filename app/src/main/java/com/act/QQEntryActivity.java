package com.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.s;
import com.user.p;

/* loaded from: classes.dex */
public class QQEntryActivity extends s {
    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        p.g().m(i2, i3, intent);
        finish();
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (p.g().f() == null || p.g().f().isSessionValid()) {
            return;
        }
        p.g().f().login(this, "all", p.g().h());
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }
}
