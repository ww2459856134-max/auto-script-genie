package com.yl.widget.wheel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
import com.frame.k0;
import com.yl.ui.a0;
import com.yl.ui.b0;
import com.yl.widget.wheel.WheelView;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class WheelTime extends RelativeLayout implements WheelView.c {
    private WheelView c;
    private WheelView d;
    private WheelView e;
    private ArrayList<String> f;
    private ArrayList<String> g;

    /* renamed from: h, reason: collision with root package name */
    private a f1171h;

    public interface a {
        void a(String str);
    }

    public WheelTime(Context context) {
        super(context);
    }

    @Override // com.yl.widget.wheel.WheelView.c
    public void a(int i2, String str) {
        a aVar = this.f1171h;
        if (aVar != null) {
            try {
                aVar.a(getSelectedTime());
            } catch (Exception e) {
                k0.r(e);
            }
        }
    }

    public String getSelectedTime() {
        int seletedIndex = this.c.getSeletedIndex();
        int seletedIndex2 = this.d.getSeletedIndex();
        int seletedIndex3 = this.e.getSeletedIndex();
        if (seletedIndex == 1) {
            seletedIndex2 += 12;
        }
        return String.format("%02d:%02d", Integer.valueOf(seletedIndex2), Integer.valueOf(seletedIndex3));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        RelativeLayout.inflate(getContext(), b0.f1142l, this);
        this.c = (WheelView) findViewById(a0.O);
        this.d = (WheelView) findViewById(a0.M);
        this.e = (WheelView) findViewById(a0.N);
        this.c.setOffset(1);
        this.d.setOffset(1);
        this.e.setOffset(1);
        this.c.setDefaultColor(Color.parseColor("#646D7C"));
        this.d.setDefaultColor(Color.parseColor("#646D7C"));
        this.e.setDefaultColor(Color.parseColor("#646D7C"));
        this.c.setItems(Arrays.asList("上午", "下午"));
        this.g = new ArrayList<>();
        for (int i2 = 0; i2 < 13; i2++) {
            this.g.add(String.format("%02d", Integer.valueOf(i2)));
        }
        this.d.setItems(this.g);
        this.f = new ArrayList<>();
        for (int i3 = 0; i3 < 60; i3++) {
            this.f.add(String.format("%02d", Integer.valueOf(i3)));
        }
        this.e.setItems(this.f);
        this.e.setOnWheelViewListener(this);
        this.c.setOnWheelViewListener(this);
        this.d.setOnWheelViewListener(this);
    }

    public void setOnTimeChange(a aVar) {
        this.f1171h = aVar;
    }

    @SuppressLint({"DefaultLocale"})
    public void setTime(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int i2 = Integer.parseInt(strArrSplit[0]);
        int i3 = Integer.parseInt(strArrSplit[1]);
        if (i2 > 12) {
            this.c.setSeletion(1);
            i2 -= 12;
        } else {
            this.c.setSeletion(0);
        }
        int iIndexOf = this.g.indexOf(String.format("%02d", Integer.valueOf(i2)));
        int iIndexOf2 = this.f.indexOf(String.format("%02d", Integer.valueOf(i3)));
        if (iIndexOf > -1) {
            this.d.setSeletion(iIndexOf);
        }
        if (iIndexOf2 > -1) {
            this.e.setSeletion(iIndexOf2);
        }
    }

    public WheelTime(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WheelTime(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
