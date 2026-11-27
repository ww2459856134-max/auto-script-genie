package com.yl.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
class g0 extends ClickableSpan {
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ View.OnClickListener e;

    g0(int i2, String str, View.OnClickListener onClickListener) {
        this.c = i2;
        this.d = str;
        this.e = onClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        view.setTag(this.d);
        this.e.onClick(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.c);
        textPaint.setUnderlineText(true);
    }
}
