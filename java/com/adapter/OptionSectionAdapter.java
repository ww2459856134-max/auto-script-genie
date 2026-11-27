package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yl.model.OptionCategory;
import i.b.ka.x5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OptionSectionAdapter extends BaseSectionQuickAdapter<OptionCategory, BaseViewHolder> {
    private ArrayList<Integer> a;

    public OptionSectionAdapter(List<OptionCategory> list) {
        super(j.b.f.U0, j.b.f.V0, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, OptionCategory optionCategory) {
        x5 x5Var = (x5) optionCategory.t;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseSectionQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convertHead(BaseViewHolder baseViewHolder, OptionCategory optionCategory) {
        baseViewHolder.setText(j.b.e.K5, optionCategory.header);
    }

    public ArrayList<Integer> e() {
        return this.a;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.a = arrayList;
    }

    public void g(int i2) {
        ArrayList<Integer> arrayList = this.a;
        if (arrayList == null) {
            return;
        }
        if (arrayList.contains(Integer.valueOf(i2))) {
            this.a.remove(Integer.valueOf(i2));
        } else {
            this.a.add(Integer.valueOf(i2));
        }
        notifyDataSetChanged();
    }
}
