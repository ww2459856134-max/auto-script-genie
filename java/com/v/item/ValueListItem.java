package com.v.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.ValueListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.v.NodeListDialogView;
import com.yl.float_ui.InputDialogView;
import java.util.List;

/* loaded from: classes.dex */
public class ValueListItem extends BaseItemView {
    private ValueListAdapter c;
    private TextView d;
    private String e;

    public ValueListItem(Context context) {
        super(context);
        this.e = "添加内容";
    }

    private View c() {
        View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.y0, null);
        viewInflate.setId(j.b.e.T1);
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.K5);
        this.d = textView;
        textView.setText(this.e);
        this.d.setGravity(17);
        this.d.setPadding(0, 0, 0, 0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.v.item.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.h(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f(String str) {
        this.c.addData((ValueListAdapter) str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view) {
        com.frame.s0.g().i(NodeListDialogView.class);
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("输入内容");
        inputDialogView.s("请输入内容");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.item.b2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.f(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(int i2, String str) {
        this.c.setData(i2, str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("输入内容");
        inputDialogView.w(this.c.getItem(i2));
        inputDialogView.s("请输入内容");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.item.a2
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.j(i2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.O0) {
            this.c.remove(i2);
        }
    }

    public void d() {
        View.inflate(getContext(), j.b.f.L0, this);
        int i2 = j.b.e.O4;
        this.c = new ValueListAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(i2);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.c);
        this.c.addFooterView(c());
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.item.c2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.l(baseQuickAdapter, view, i3);
            }
        });
        this.c.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.item.d2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.c.n(baseQuickAdapter, view, i3);
            }
        });
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.c));
        k0Var.j(recyclerView);
        this.c.enableDragItem(k0Var, j.b.e.h1, false);
    }

    public void setBtnAddName(String str) {
        this.e = str;
        this.d.setText(str);
    }

    public void setValue(List<String> list) {
        this.c.setNewData(list);
    }

    @Override // com.v.item.BaseItemView
    public List<String> getValue() {
        return this.c.getData();
    }

    public ValueListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "添加内容";
        d();
    }

    public ValueListItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = "添加内容";
    }
}
