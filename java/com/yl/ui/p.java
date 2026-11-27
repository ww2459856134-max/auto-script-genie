package com.yl.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.frame.k0;
import com.frame.v0;
import com.yl.widget.TitleBar;

/* loaded from: classes.dex */
public abstract class p extends com.act.e {
    public static boolean O = true;
    public TitleBar K;
    protected boolean M = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(View view) {
        if (e0()) {
            return;
        }
        finish();
    }

    public void Z() {
        TitleBar titleBar = this.K;
        if (titleBar != null) {
            titleBar.a();
        }
    }

    public abstract int a0();

    public void b0() {
    }

    public boolean e0() {
        return false;
    }

    public void f0(int i2, View.OnClickListener onClickListener) {
        TitleBar titleBar = this.K;
        if (titleBar == null) {
            return;
        }
        titleBar.setRightButton(i2, onClickListener);
    }

    public void g0(String str, View.OnClickListener onClickListener) {
        if (this.K == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.K.setRightButton(str, onClickListener);
    }

    public void h0(int i2, View.OnClickListener onClickListener) {
        TitleBar titleBar = this.K;
        if (titleBar == null) {
            return;
        }
        titleBar.setSecondRightButton(i2, onClickListener);
    }

    public void i0(String str, View.OnClickListener onClickListener) {
        TitleBar titleBar = this.K;
        if (titleBar == null) {
            return;
        }
        titleBar.setSecondTextButton(str, onClickListener);
    }

    public void j0(String str) {
        TitleBar titleBar = this.K;
        if (titleBar != null) {
            ((TextView) titleBar.findViewById(a0.I)).setText(str);
        }
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        v0.g().q(true);
        com.frame.i0.k(this, O);
        super.onCreate(bundle);
        if (a0() != 0) {
            setContentView(a0());
        }
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (equals(v0.g().d())) {
            v0.g().o(null);
        }
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            if (this.M && v0.g().l()) {
                k0.j(this);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.appcompat.app.s, android.app.Activity
    @SuppressLint({"WrongViewCast"})
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        TitleBar titleBar = (TitleBar) findViewById(a0.z);
        this.K = titleBar;
        if (titleBar != null) {
            titleBar.findViewById(a0.f1130h).setOnClickListener(new View.OnClickListener() { // from class: com.yl.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.d0(view);
                }
            });
        }
        b0();
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            v0.g().o(this);
            if (this.M && v0.g().l()) {
                k0.k(this);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        v0.g().q(false);
        super.onStop();
    }
}
