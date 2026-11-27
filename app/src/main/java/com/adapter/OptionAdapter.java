package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import i.b.ka.x5;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class OptionAdapter extends BaseItemDraggableAdapter<x5, BaseViewHolder> {
    private ArrayList<Integer> a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, x5 x5Var) {
        TextView textView = (TextView) baseViewHolder.getView(j.b.e.t5);
        textView.setText(x5Var.t());
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(x5Var.r(), 0, 0, 0);
        TextView textView2 = (TextView) baseViewHolder.getView(j.b.e.G5);
        ArrayList<Integer> arrayList = this.a;
        if (arrayList == null) {
            textView2.setVisibility(8);
            return;
        }
        boolean zContains = arrayList.contains(Integer.valueOf(x5Var.B()));
        baseViewHolder.getConvertView().setSelected(zContains);
        if (!zContains) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(String.valueOf(this.a.indexOf(Integer.valueOf(x5Var.B())) + 1));
        }
    }
}
