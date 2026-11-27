package com.yl.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.g;
import com.yl.ui.a0;
import com.yl.ui.b0;
import com.yl.ui.z;

/* loaded from: classes.dex */
public class TitleBar extends LinearLayout {
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;

    public TitleBar(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(context).inflate(b0.f1141k, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(a0.f1130h);
        this.d = (ImageView) findViewById(a0.f1135m);
        this.e = (TextView) findViewById(a0.I);
        this.f = (TextView) findViewById(a0.G);
    }

    public void a() {
        View viewFindViewById = findViewById(a0.I);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        layoutParams.addRule(9);
        viewFindViewById.setLayoutParams(layoutParams);
    }

    public void b() {
        this.c.setVisibility(8);
    }

    public void setDark(boolean z) {
        if (z) {
            return;
        }
        this.e.setTextColor(-16777216);
        g.c(this.c, ColorStateList.valueOf(-16777216));
        findViewById(a0.z).setBackgroundColor(Color.parseColor("#000000"));
        setBackgroundColor(Color.parseColor("#000000"));
    }

    public void setRightButton(int i2, View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) findViewById(a0.f1135m);
        imageView.setImageResource(i2);
        imageView.setVisibility(0);
        imageView.setOnClickListener(onClickListener);
    }

    public void setRightWithBgButton(String str, View.OnClickListener onClickListener) {
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setVisibility(0);
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
        this.f.setBackgroundResource(z.a);
        this.f.setGravity(17);
    }

    public void setSecondRightButton(int i2, View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) findViewById(a0.f1136n);
        imageView.setVisibility(0);
        imageView.setImageResource(i2);
        imageView.setOnClickListener(onClickListener);
    }

    public void setSecondTextButton(String str, View.OnClickListener onClickListener) {
        TextView textView = (TextView) findViewById(a0.s);
        textView.setVisibility(0);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.e.setText(str);
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setVisibility(0);
        this.f.setText(str);
        this.f.setOnClickListener(onClickListener);
    }

    public void setSecondTextButton(String str, int i2, View.OnClickListener onClickListener) {
        TextView textView = (TextView) findViewById(a0.s);
        textView.setBackgroundResource(i2);
        textView.setVisibility(0);
        textView.setText(str);
        textView.setOnClickListener(onClickListener);
    }
}
