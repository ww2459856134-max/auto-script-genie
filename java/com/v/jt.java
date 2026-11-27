package com.v;

import android.view.View;
import android.widget.TextView;
import com.v.CalculateDialogView;
import com.v.ItemChooseDialogView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class jt implements View.OnClickListener {
    final /* synthetic */ TextView c;

    jt(CalculateDialogView.a aVar, TextView textView) {
        this.c = textView;
    }

    static /* synthetic */ void a(TextView textView, ArrayList arrayList, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        textView.setText((CharSequence) arrayList.get(i2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("顺序取值");
        arrayList.add("随机取值");
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("设置每次执行节点的变量读取方式，1");
        itemChooseDialogView.setDefaultData(-1, arrayList);
        final TextView textView = this.c;
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.k2
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                jt.a(textView, arrayList, i2, list);
            }
        });
    }
}
