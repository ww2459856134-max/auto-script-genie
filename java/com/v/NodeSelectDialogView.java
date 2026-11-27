package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.NodeChooseAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.model.Node;
import java.util.List;

/* loaded from: classes.dex */
public class NodeSelectDialogView extends RelativeLayout implements View.OnClickListener {
    private a c;
    private NodeChooseAdapter d;

    public interface a {
        void a(int i2, List<Node> list);
    }

    public NodeSelectDialogView() {
        this(com.frame.v0.g());
    }

    private void a() {
        View.inflate(com.frame.v0.g(), j.b.f.f, this);
        setGravity(17);
        ((TextView) findViewById(j.b.e.w6)).setText("选择节点");
        this.d = new NodeChooseAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.d);
        TextView textView = (TextView) findViewById(j.b.e.g);
        textView.setOnClickListener(this);
        textView.setText("确定");
        TextView textView2 = (TextView) findViewById(j.b.e.P);
        textView2.setOnClickListener(this);
        textView2.setText("取消");
        TextView textView3 = new TextView(com.frame.v0.g());
        textView3.setText("无内容~");
        textView3.setGravity(17);
        textView3.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.d.setEmptyView(textView3);
        this.d.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.fh
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.c(baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.d.c(i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(NodeSelectDialogView.class);
            return;
        }
        if (id == j.b.e.g) {
            com.frame.s0.g().d(NodeSelectDialogView.class);
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.d.e(), this.d.getData());
            }
        }
    }

    public void setDefaultData(int i2, List<Node> list) {
        this.d.setNewData(list);
        this.d.c(i2);
    }

    public void setOnNodeChoose(a aVar) {
        this.c = aVar;
    }

    public void setTitle(String str) {
        ((TextView) findViewById(j.b.e.w6)).setText(str);
    }

    public NodeSelectDialogView(Context context) {
        this(context, null);
    }

    public NodeSelectDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setDefaultData(int i2) {
        this.d.c(i2);
    }
}
