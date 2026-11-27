package com.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yl.model.Node;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class NodeClipBoardAdapter extends BaseItemDraggableAdapter<Node, BaseViewHolder> {
    private LinkedHashMap<Integer, Node> a;

    public NodeClipBoardAdapter(List<Node> list) {
        super(j.b.f.Q0, list);
        this.a = new LinkedHashMap<>();
    }

    public void c(int i2) {
        this.a.put(Integer.valueOf(i2), getItem(i2));
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Node node) {
        baseViewHolder.addOnClickListener(j.b.e.O0);
        baseViewHolder.setText(j.b.e.v6, node.getName());
        baseViewHolder.getView(j.b.e.k1).setSelected(this.a.containsKey(Integer.valueOf(baseViewHolder.getAdapterPosition())));
    }

    public HashMap<Integer, Node> e() {
        return this.a;
    }

    public boolean f(int i2) {
        return this.a.containsKey(Integer.valueOf(i2));
    }

    public void g(int i2) {
        this.a.remove(Integer.valueOf(i2), getItem(i2));
        notifyDataSetChanged();
    }

    public void h(int i2) {
        if (f(i2)) {
            g(i2);
        } else {
            c(i2);
        }
    }
}
