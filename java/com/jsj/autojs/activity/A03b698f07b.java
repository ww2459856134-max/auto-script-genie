package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.act.WebAct;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.PageScanAdapter;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.v.WidgetScanDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.ui.s;
import i.b.v8;

/* loaded from: classes.dex */
public class A03b698f07b extends q8 implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemLongClickListener {
    private PageScanAdapter P;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == 2131296546) {
            this.P.j(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(View view) {
        Intent intent = new Intent(this, (Class<?>) WebAct.class);
        intent.putExtra(SocialConstants.PARAM_URL, "https://mp.weixin.qq.com/s/vWdEC9ySzgVI_nowfs3QhQ");
        intent.putExtra("title", "页面自动触发");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(DialogInterface dialogInterface, int i2) {
        com.frame.n0.k("pageSL", null);
        i.b.k8.d().b();
        this.P.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(View view) {
        s.a aVar = new s.a(this);
        aVar.j("是否清空所有页面自动触发任务。");
        aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.p0(dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.e().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(Node node) {
        i.b.k8.d().k(this.P.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v0(int i2, DialogInterface dialogInterface, int i3) {
        this.P.remove(i2);
        i.b.k8.d().k(this.P.getData());
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        j0("页面触发任务");
        Z();
        ((SwipeRefreshLayout) findViewById(2131297080)).setEnabled(false);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PageScanAdapter pageScanAdapter = new PageScanAdapter(i.b.k8.d().f());
        this.P = pageScanAdapter;
        recyclerView.setAdapter(pageScanAdapter);
        this.P.setOnItemClickListener(this);
        this.P.setOnItemLongClickListener(this);
        this.P.setOnLoadMoreListener(this);
        this.P.setEnableLoadMore(false);
        this.P.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.jsj.autojs.activity.c
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.l0(baseQuickAdapter, view, i2);
            }
        });
        View viewInflate = View.inflate(getApplicationContext(), 2131493137, null);
        ((TextView) viewInflate.findViewById(2131297224)).setText("页面自动触发");
        ((TextView) viewInflate.findViewById(2131297223)).setText("先录制需要触发的脚本，在脚本菜单中选择自动触发");
        TextView textView = (TextView) viewInflate.findViewById(2131296443);
        textView.setText("视频教程");
        this.P.addHeaderView(viewInflate);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n0(view);
            }
        });
        i0("清空", new View.OnClickListener() { // from class: com.jsj.autojs.activity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r0(view);
            }
        });
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        WidgetScanDialogView widgetScanDialogView = (WidgetScanDialogView) com.frame.s0.g().B(WidgetScanDialogView.class);
        widgetScanDialogView.D(v8.m().p(), this.P.getItem(i2));
        widgetScanDialogView.C(new lt() { // from class: com.jsj.autojs.activity.b
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.t0(node);
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        String str = String.format("是否确认「%s」？", this.P.getItem(i2).getName());
        s.a aVar = new s.a(this);
        aVar.g(2131231019);
        aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.c.v0(i2, dialogInterface, i3);
            }
        });
        aVar.m("取消", null);
        aVar.j(str);
        aVar.t("删除提醒");
        aVar.e().show();
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        super.onStop();
        i.b.k8.d().l();
    }
}
