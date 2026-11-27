package com.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.permission.v0;

/* loaded from: classes.dex */
public class PermissionAdapter extends BaseItemDraggableAdapter<v0, BaseViewHolder> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, v0 v0Var) {
        baseViewHolder.setText(j.b.e.n6, v0Var.a).setText(j.b.e.g6, v0Var.b).setImageResource(j.b.e.G3, v0Var.c);
        TextView textView = (TextView) baseViewHolder.getView(j.b.e.f1);
        Boolean bool = v0Var.d;
        if (bool == null) {
            textView.setSelected(false);
            textView.setText("去检查");
        } else {
            textView.setSelected(bool.booleanValue());
            textView.setText(v0Var.d.booleanValue() ? "已完成" : "去设置");
        }
    }
}
