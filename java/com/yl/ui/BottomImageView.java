package com.yl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.frame.k0;
import com.frame.s0;
import com.frame.v0;

/* loaded from: classes.dex */
public class BottomImageView extends RelativeLayout {
    private int c;
    private String d;

    public BottomImageView(Context context) {
        super(context);
    }

    public BottomImageView b(String str) {
        this.d = str;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            ImageView imageView = (ImageView) findViewById(a0.f1137o);
            com.bumptech.glide.c.u(imageView).w(this.d).q0(imageView);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
    }

    public BottomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BottomImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public BottomImageView() {
        super(v0.g());
        View.inflate(v0.g(), b0.b, this);
        int i2 = this.c;
        if (i2 != 0) {
            setBackgroundResource(i2);
        }
        findViewById(a0.A).setOnClickListener(new View.OnClickListener() { // from class: com.yl.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g().d(BottomImageView.class);
            }
        });
    }
}
