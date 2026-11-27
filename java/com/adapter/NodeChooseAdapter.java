package com.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.v0;
import com.yl.model.Node;
import java.util.List;

/* loaded from: classes.dex */
public class NodeChooseAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    private int a;

    public NodeChooseAdapter(List<Node> list) {
        super(j.b.f.T0, list);
    }

    public void c(int i2) {
        this.a = i2;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        com.bumptech.glide.c.t(v0.g()).w(node.url).q0((ImageView) baseViewHolder.getView(j.b.e.I3));
        baseViewHolder.setText(j.b.e.n6, node.getName());
        baseViewHolder.setBackgroundColor(j.b.e.t3, v0.g().getResources().getColor(this.a == baseViewHolder.getLayoutPosition() ? j.b.c.e : j.b.c.a));
    }

    public int e() {
        return this.a;
    }
}
