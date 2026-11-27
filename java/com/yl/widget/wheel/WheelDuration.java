package com.yl.widget.wheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.frame.k0;
import com.yl.ui.a0;
import com.yl.ui.b0;
import com.yl.widget.wheel.WheelView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class WheelDuration extends RelativeLayout implements WheelView.c {
    private WheelView c;
    private WheelView d;
    private ArrayList<String> e;
    private ArrayList<String> f;
    private a g;

    public interface a {
        void a(String str);
    }

    public WheelDuration(Context context) {
        super(context);
    }

    @Override // com.yl.widget.wheel.WheelView.c
    public void a(int i2, String str) {
        a aVar = this.g;
        if (aVar != null) {
            try {
                aVar.a(getSelectedTime());
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public String getSelectedTime() {
        return String.format("%02d:%02d", Integer.valueOf(this.c.getSeletedIndex()), Integer.valueOf(this.d.getSeletedIndex()));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        RelativeLayout.inflate(getContext(), b0.f1142l, this);
        findViewById(a0.q).setVisibility(8);
        this.c = (WheelView) findViewById(a0.M);
        this.d = (WheelView) findViewById(a0.N);
        this.c.setOffset(1);
        this.d.setOffset(1);
        this.c.setDefaultColor(Color.parseColor("#646D7C"));
        this.d.setDefaultColor(Color.parseColor("#646D7C"));
        this.f = new ArrayList<>();
        for (int i2 = 0; i2 < 24; i2++) {
            this.f.add(String.format("%02d", Integer.valueOf(i2)));
        }
        this.c.setItems(this.f);
        this.e = new ArrayList<>();
        for (int i3 = 0; i3 < 60; i3++) {
            this.e.add(String.format("%02d", Integer.valueOf(i3)));
        }
        this.d.setItems(this.e);
        this.d.setOnWheelViewListener(this);
        this.c.setOnWheelViewListener(this);
        ((TextView) findViewById(a0.C)).setText("小时");
        ((TextView) findViewById(a0.D)).setText("分钟");
    }

    public void setOnTimeChange(a aVar) {
        this.g = aVar;
    }

    @SuppressLint({"DefaultLocale"})
    public void setTime(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int i2 = Integer.parseInt(strArrSplit[0]);
        int i3 = Integer.parseInt(strArrSplit[1]);
        int iIndexOf = this.f.indexOf(String.format("%02d", Integer.valueOf(i2)));
        int iIndexOf2 = this.e.indexOf(String.format("%02d", Integer.valueOf(i3)));
        if (iIndexOf > -1) {
            this.c.setSeletion(iIndexOf);
        }
        if (iIndexOf2 > -1) {
            this.d.setSeletion(iIndexOf2);
        }
    }

    public WheelDuration(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WheelDuration(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
