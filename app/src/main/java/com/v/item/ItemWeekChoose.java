package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ItemWeekChoose extends LinearLayout {
    private LinearLayout c;

    public ItemWeekChoose(Context context) {
        super(context);
    }

    public List<Integer> getRepeatWeek() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            if (this.c.getChildAt(i2).isSelected()) {
                arrayList.add(Integer.valueOf(i2 + 1));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LinearLayout.inflate(getContext(), j.b.f.f1, this);
        this.c = (LinearLayout) getChildAt(0);
        for (int i2 = 0; i2 < this.c.getChildCount(); i2++) {
            this.c.getChildAt(i2).setOnClickListener(new View.OnClickListener() { // from class: com.v.item.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    view.setSelected(!view.isSelected());
                }
            });
        }
    }

    public void setRepeatWeek(List<Integer> list) {
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.c.getChildAt(it.next().intValue() - 1).setSelected(true);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public ItemWeekChoose(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ItemWeekChoose(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
