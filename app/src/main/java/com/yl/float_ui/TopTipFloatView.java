package com.yl.float_ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.frame.p1;
import com.frame.s0;
import com.frame.t0;
import com.frame.v0;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes.dex */
public class TopTipFloatView extends LinearLayout {
    public TopTipFloatView() {
        super(v0.g());
        View.inflate(getContext(), k0.e, this);
    }

    public static TopTipFloatView a(Drawable drawable, String str, View.OnClickListener onClickListener) {
        if (s0.g().b(TopTipFloatView.class)) {
            return (TopTipFloatView) s0.g().f(TopTipFloatView.class);
        }
        try {
            WindowManager.LayoutParams layoutParamsB = t0.b(true);
            layoutParamsB.width = -2;
            layoutParamsB.height = -2;
            layoutParamsB.y = p1.c(30.0f);
            layoutParamsB.gravity = 49;
            layoutParamsB.windowAnimations = l0.a;
            TopTipFloatView topTipFloatView = (TopTipFloatView) s0.g().z(TopTipFloatView.class, layoutParamsB);
            TextView textView = (TextView) topTipFloatView.findViewById(j0.u);
            if (drawable != null) {
                ((RoundedImageView) topTipFloatView.findViewById(j0.f1128n)).setImageDrawable(drawable);
            }
            textView.setText(str);
            topTipFloatView.findViewById(j0.a).setOnClickListener(onClickListener);
            return topTipFloatView;
        } catch (Exception e) {
            com.frame.k0.r(e);
            return null;
        }
    }
}
