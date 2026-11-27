package com.act;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.frame.i0;
import com.frame.k0;
import com.frame.q1;
import com.frame.v0;
import i.a.i;
import i.a.j;

/* loaded from: classes.dex */
public abstract class f extends e implements i {
    public static boolean Q = true;
    private CountDownTimer K;
    public j M;
    protected boolean O = false;
    private Resources P;

    private void y() {
        ViewGroup viewGroup = (ViewGroup) findViewById(j.a.a.f1737h);
        TextView textView = (TextView) findViewById(j.a.a.g);
        TextView textView2 = (TextView) findViewById(j.a.a.f);
        ImageView imageView = (ImageView) findViewById(j.a.a.f1738i);
        ImageView imageView2 = (ImageView) findViewById(j.a.a.a);
        try {
            float fFloatValue = Float.valueOf(v0.f().getString("splash_height", "1")).floatValue();
            if (viewGroup != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = (int) ((q1.d() + q1.c()) * fFloatValue);
                viewGroup.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            k0.r(e);
        }
        j jVar = new j();
        this.M = jVar;
        jVar.i(this, this, viewGroup, textView, textView2, imageView, imageView2);
    }

    @Override // androidx.appcompat.app.s, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.O) {
            return super.getResources();
        }
        try {
            if (this.P == null) {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                this.P = resources;
            }
            return this.P;
        } catch (Exception unused) {
            return super.getResources();
        }
    }

    @Override // i.a.i
    public boolean i() {
        return true;
    }

    @Override // i.a.i
    public abstract void l();

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        v0.g().o(this);
        super.onCreate(bundle);
        setContentView(j.a.b.b);
        i0.k(this, Q);
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            ViewGroup viewGroup = (ViewGroup) findViewById(j.a.a.f1739j);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        } catch (Exception e) {
            k0.r(e);
        }
        j jVar = this.M;
        if (jVar != null) {
            try {
                jVar.q();
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
        this.M = null;
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            if (v0.g().l()) {
                k0.j(this);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.appcompat.app.s, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        try {
            y();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            k0.r(e);
        }
        v0.g().o(this);
        j jVar = this.M;
        if (jVar != null) {
            jVar.r();
        }
        try {
            if (v0.g().l()) {
                k0.k(this);
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        super.onStop();
        try {
            CountDownTimer countDownTimer = this.K;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e) {
            k0.r(e);
        }
        j jVar = this.M;
        if (jVar != null) {
            jVar.s();
        }
    }
}
