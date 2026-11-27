package com.jsj.autojs.window;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.frame.v0;

/* loaded from: classes.dex */
public class ToastView extends FrameLayout implements View.OnClickListener {
    private static ToastView c;

    private ToastView(Context context) {
        super(context);
        View.inflate(getContext(), 2131493191, this);
    }

    public static ToastView getInstance() {
        ToastView toastView = c;
        if (toastView != null) {
            return toastView;
        }
        ToastView toastView2 = new ToastView(v0.g());
        c = toastView2;
        return toastView2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
