package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.NodeClipBoardAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NodeClipBoardDialogView extends RelativeLayout implements View.OnClickListener {
    private c c;
    private NodeClipBoardAdapter d;

    class a implements BaseQuickAdapter.OnItemChildClickListener {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            if (view.getId() == j.b.e.O0) {
                NodeClipBoardDialogView.this.d.remove(i2);
            } else if (view.getId() == j.b.e.k1) {
                NodeClipBoardDialogView.this.d.h(i2);
            }
        }
    }

    class b implements BaseQuickAdapter.OnItemClickListener {
        b() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            NodeClipBoardDialogView.this.d.h(i2);
        }
    }

    public interface c {
        void a(List<Node> list);
    }

    public NodeClipBoardDialogView() {
        this(com.frame.v0.g());
    }

    private void b() {
        View.inflate(com.frame.v0.g(), j.b.f.N, this);
        setGravity(17);
        this.d = new NodeClipBoardAdapter(i.b.v8.m().n());
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        ((TextView) findViewById(j.b.e.w6)).setText("节点剪切板");
        findViewById(j.b.e.P).setOnClickListener(this);
        int i2 = j.b.e.g;
        findViewById(i2).setOnClickListener(this);
        ((TextView) findViewById(i2)).setText("确定");
        findViewById(j.b.e.f0).setOnClickListener(this);
        findViewById(j.b.e.C0).setOnClickListener(this);
        this.d.setOnItemChildClickListener(new a());
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText("剪切板无内容~");
        textView.setGravity(17);
        textView.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setEmptyView(textView);
        this.d.setOnItemClickListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(NodeClipBoardDialogView.class);
            return;
        }
        if (id == j.b.e.C0) {
            if (view.isSelected()) {
                view.setSelected(false);
                this.d.e().clear();
            } else {
                view.setSelected(true);
                for (int i2 = 0; i2 < this.d.getData().size(); i2++) {
                    this.d.c(i2);
                }
            }
            this.d.notifyDataSetChanged();
            FloatToast.i("已全选");
            return;
        }
        if (id == j.b.e.f0) {
            if (this.d.e().isEmpty()) {
                FloatToast.i("请先选择需要移出的节点");
                return;
            }
            this.d.getData().removeAll(this.d.e().values());
            this.d.e().clear();
            this.d.notifyDataSetChanged();
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(NodeClipBoardDialogView.class);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a(new ArrayList(this.d.e().values()));
            }
        }
    }

    public void setOnTextChoose(c cVar) {
        this.c = cVar;
    }

    public NodeClipBoardDialogView(Context context) {
        this(context, null);
    }

    public NodeClipBoardDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
