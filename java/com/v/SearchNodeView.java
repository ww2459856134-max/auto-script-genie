package com.v;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.NodeSearchAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SearchNodeView extends RelativeLayout {
    NodeSearchAdapter c;
    RecyclerView d;
    EditText e;

    class a implements View.OnClickListener {
        final /* synthetic */ List c;

        a(List list) {
            this.c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = SearchNodeView.this.e.getText().toString();
            if (TextUtils.isEmpty(string)) {
                SearchNodeView.this.e.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < this.c.size()) {
                Node node = (Node) this.c.get(i2);
                i2++;
                node.step = String.valueOf(i2);
                String str = node.name;
                if (str != null && str.contains(string)) {
                    arrayList.add(node);
                } else if (node.step.contains(string)) {
                    arrayList.add(node);
                }
            }
            SearchNodeView.this.c.setNewData(arrayList);
        }
    }

    public SearchNodeView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(lt ltVar, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Node item = this.c.getItem(i2);
        if (!item.invalid) {
            ltVar.a(item);
            com.frame.s0.g().d(SearchNodeView.class);
            return;
        }
        DingMsgView dingMsgView = new DingMsgView();
        dingMsgView.h("此节点设置了禁用，请先解禁后再选择。");
        dingMsgView.l("温馨提示");
        dingMsgView.k("知道了", null);
        dingMsgView.n();
    }

    public void set(List<Node> list, int i2, final lt ltVar) {
        this.c.setNewData(list);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.hl
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.c(ltVar, baseQuickAdapter, view, i3);
            }
        });
        this.d.j1(i2);
        findViewById(j.b.e.g).setOnClickListener(new a(list));
    }

    public SearchNodeView() {
        super(com.frame.v0.g());
        View.inflate(com.frame.v0.g(), j.b.f.V, this);
        this.e = (EditText) findViewById(j.b.e.J1);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        this.d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        NodeSearchAdapter nodeSearchAdapter = new NodeSearchAdapter(null);
        this.c = nodeSearchAdapter;
        this.d.setAdapter(nodeSearchAdapter);
        findViewById(j.b.e.P).setOnClickListener(new View.OnClickListener() { // from class: com.v.gl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(SearchNodeView.class);
            }
        });
    }
}
