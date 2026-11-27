package com.jsj.autojs.window;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.frame.v0;

/* loaded from: classes.dex */
public class NightView extends FrameLayout implements View.OnClickListener {
    private static NightView e;
    private WindowManager c;
    private WindowManager.LayoutParams d;

    private NightView(Context context) {
        super(context);
        setBackgroundColor(-16777216);
    }

    public static NightView getInstance() {
        NightView nightView = e;
        if (nightView != null) {
            return nightView;
        }
        NightView nightView2 = new NightView(v0.g());
        e = nightView2;
        return nightView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        WindowManager.LayoutParams layoutParams = this.d;
        layoutParams.alpha = f;
        this.c.updateViewLayout(this, layoutParams);
    }
}
