package com.yl.float_ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.l1;
import com.frame.p1;
import com.frame.s0;
import com.frame.t0;
import com.frame.v0;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes.dex */
public class TipFloatView extends LinearLayout {
    public TipFloatView() {
        super(v0.g());
        View.inflate(getContext(), k0.d, this);
    }

    public static void c(Drawable drawable, String str, String str2, View.OnClickListener onClickListener) {
        if (s0.g().b(TipFloatView.class)) {
            l1.c(213123, new Runnable() { // from class: com.yl.float_ui.e0
                @Override // java.lang.Runnable
                public final void run() {
                    s0.g().d(TipFloatView.class);
                }
            }, 3000L);
            return;
        }
        try {
            WindowManager.LayoutParams layoutParamsB = t0.b(true);
            layoutParamsB.width = -2;
            layoutParamsB.height = -2;
            layoutParamsB.y = p1.c(100.0f);
            layoutParamsB.gravity = 53;
            layoutParamsB.windowAnimations = l0.a;
            TipFloatView tipFloatView = (TipFloatView) s0.g().z(TipFloatView.class, layoutParamsB);
            l1.c(213123, new Runnable() { // from class: com.yl.float_ui.f0
                @Override // java.lang.Runnable
                public final void run() {
                    s0.g().d(TipFloatView.class);
                }
            }, 3000L);
            TextView textView = (TextView) tipFloatView.findViewById(j0.v);
            TextView textView2 = (TextView) tipFloatView.findViewById(j0.t);
            if (drawable != null) {
                ((RoundedImageView) tipFloatView.findViewById(j0.f1128n)).setImageDrawable(drawable);
            }
            textView.setText(str);
            textView2.setText(str2);
            tipFloatView.setOnClickListener(onClickListener);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }
}
