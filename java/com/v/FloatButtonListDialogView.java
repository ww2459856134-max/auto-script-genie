package com.v;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.FloatButtonAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.v.FloatButtonConfigDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.FloatButtonConfig;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FloatButtonListDialogView extends RelativeLayout implements View.OnClickListener, OnItemDragListener {
    private FloatButtonAdapter c;
    private Runnable d;

    public FloatButtonListDialogView() {
        this(com.frame.v0.g());
    }

    private void a() {
        View.inflate(com.frame.v0.g(), j.b.f.v, this);
        setGravity(17);
        this.c = new FloatButtonAdapter(new ArrayList(i.b.w7.g().e()));
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        recyclerView.setAdapter(this.c);
        ImageView imageView = (ImageView) findViewById(j.b.e.X);
        imageView.setImageResource(j.b.d.L0);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageTintList(null);
        imageView.setImageTintMode(null);
        TextView textView = (TextView) findViewById(j.b.e.g6);
        textView.setVisibility(0);
        textView.setText("可临时关闭悬浮快捷按钮");
        ((TextView) findViewById(j.b.e.A)).setOnClickListener(this);
        TextView textView2 = new TextView(com.frame.v0.g());
        textView2.setText("无内容~");
        textView2.setGravity(17);
        textView2.setTextColor(com.frame.v0.g().getResources().getColor(j.b.c.d));
        this.c.setEmptyView(textView2);
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.u5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.e(baseQuickAdapter, view, i2);
            }
        });
        this.c.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.v.z5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.j(baseQuickAdapter, view, i2);
            }
        });
        this.c.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.v5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.l(baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(int i2, FloatButtonConfig floatButtonConfig) {
        this.c.notifyItemChanged(i2);
        i.b.w7.g().r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        FloatButtonConfig item = this.c.getItem(i2);
        FloatButtonConfigDialogView floatButtonConfigDialogView = (FloatButtonConfigDialogView) com.frame.s0.g().B(FloatButtonConfigDialogView.class);
        floatButtonConfigDialogView.i(item);
        floatButtonConfigDialogView.j(new FloatButtonConfigDialogView.c() { // from class: com.v.w5
            @Override // com.v.FloatButtonConfigDialogView.c
            public final void a(FloatButtonConfig floatButtonConfig) {
                this.a.c(i2, floatButtonConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(int i2, View view) {
        i.b.w7.g().q(this.c.getItem(i2));
        com.frame.s0.g().d(DingMsgView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean j(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("温馨提醒");
        dingMsgView.h("是否删除悬浮快捷键？");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.y5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.g(i2, view2);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.x5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == j.b.e.k1) {
            this.c.getItem(i2).isOpen = !r1.isOpen;
            this.c.notifyItemChanged(i2);
            i.b.w7.g().p();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            com.frame.s0.g().d(FloatButtonListDialogView.class);
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (id == j.b.e.A) {
            com.frame.s0.g().o(this);
        } else if (id == j.b.e.X) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h("列表用来统一管理悬浮快捷键的，可以临时开关悬浮按钮，修改按钮配置");
            dingMsgView.i("知道了", null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i.b.w7.g().r();
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragEnd(RecyclerView.d0 d0Var, int i2) {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3) {
    }

    @Override // com.chad.library.adapter.base.listener.OnItemDragListener
    public void onItemDragStart(RecyclerView.d0 d0Var, int i2) {
    }

    public void setOnCancelListener(Runnable runnable) {
        this.d = runnable;
    }

    public FloatButtonListDialogView(Context context) {
        this(context, null);
    }

    public FloatButtonListDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
