package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.v.item.ItemWeekChoose;
import com.yl.widget.wheel.Wheel24Time;
import java.util.List;

/* loaded from: classes.dex */
public class TimeWeekPick extends LinearLayout {
    private ItemWeekChoose c;
    private Wheel24Time d;

    public TimeWeekPick(Context context) {
        super(context);
    }

    public void a() {
        View.inflate(com.frame.v0.g(), j.b.f.b0, this);
        this.d = (Wheel24Time) findViewById(j.b.e.F6);
        this.c = (ItemWeekChoose) findViewById(j.b.e.K4);
    }

    public List<Integer> getRepeatWeek() {
        return this.c.getRepeatWeek();
    }

    public String getSelectedTime() {
        return this.d.getSelectedTime();
    }

    public void setDefaultValue(String str, List<Integer> list) throws NumberFormatException {
        this.d.setTime(str);
        if (list == null) {
            this.c.setVisibility(8);
        } else {
            setRepeatWeek(list);
        }
    }

    public void setRepeatWeek(List<Integer> list) {
        this.c.setRepeatWeek(list);
    }

    public TimeWeekPick(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimeWeekPick(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
