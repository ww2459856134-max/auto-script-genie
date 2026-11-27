package com.yl.model;

import android.widget.TextView;
import i.b.o8;

/* loaded from: classes.dex */
public class Delay {
    public String delayMax;
    public String delayMin;

    public Delay(String str, String str2) {
        this.delayMin = str;
        this.delayMax = str2;
    }

    public void bindTextView(TextView textView) {
        textView.setText("等待：" + o8.c(this.delayMin, this.delayMax));
    }

    public void bindTextViewWithout0(TextView textView) {
        if (o8.e(this.delayMin) && o8.e(this.delayMax)) {
            textView.setText((CharSequence) null);
        } else {
            bindTextView(textView);
        }
    }

    public long getDelayMs() {
        return o8.i(this.delayMin, this.delayMax);
    }
}
