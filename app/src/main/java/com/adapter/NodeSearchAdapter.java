package com.adapter;

import android.text.TextUtils;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.yl.model.Node;
import i.b.ka.x5;
import i.b.x7;
import java.util.List;

/* loaded from: classes.dex */
public class NodeSearchAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    private int a;

    public NodeSearchAdapter(List<Node> list) {
        super(j.b.f.S0, list);
        this.a = v0.g().getColor(j.b.c.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        int i2 = j.b.e.m6;
        TextView textView = (TextView) baseViewHolder.getView(i2);
        x5 x5VarE = x7.d().e(node.type);
        if (x5VarE != null) {
            int iR = x5VarE.r();
            textView.setText(x5VarE.t());
            textView.setCompoundDrawablesWithIntrinsicBounds(iR, 0, 0, 0);
        }
        if (!TextUtils.isEmpty(node.name)) {
            textView.setText(node.name);
        }
        baseViewHolder.setText(j.b.e.k6, node.step + ".");
        baseViewHolder.setTextColor(i2, node.invalid ? -7829368 : this.a);
    }
}
