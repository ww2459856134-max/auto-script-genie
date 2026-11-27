package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.RecycleBinAdapter;
import com.tencent.cursor.R;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import i.b.da;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class A99df5502f5 extends com.yl.ui.p {
    private RecyclerView P;
    private RecycleBinAdapter Q;
    private View U;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(View view) {
        w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(View view) {
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.Q.f(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(List list, DialogInterface dialogInterface, int i2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            da.B().M1((TaskSimple) it.next());
        }
        com.yl.ui.i0.j();
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(DialogInterface dialogInterface, int i2) {
        da.B().q();
        com.yl.ui.i0.i("remove.json", 2000L, null);
        u0();
    }

    private void u0() {
        List<TaskSimple> listY = da.B().y();
        this.Q.setNewData(listY);
        this.Q.c();
        boolean z = listY == null || listY.isEmpty();
        this.U.setVisibility(z ? 0 : 8);
        this.P.setVisibility(z ? 8 : 0);
    }

    private void v0() {
        final List<TaskSimple> listE = this.Q.e();
        if (listE.isEmpty()) {
            Y("请选择要还原的脚本");
            this.P.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
            return;
        }
        s.a aVar = new s.a(this);
        aVar.t("温馨提示");
        aVar.g(2131231019);
        aVar.j("是否确认还原选中的 " + listE.size() + " 个脚本？");
        aVar.m("取消", null);
        aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.y3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.r0(listE, dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    private void w0() {
        if (this.Q.getData().isEmpty()) {
            Y("回收站已经是空的");
            return;
        }
        s.a aVar = new s.a(this);
        aVar.t("温馨提示");
        aVar.g(2131231019);
        aVar.j("是否确认清空回收站？清空后脚本将无法恢复。");
        aVar.m("取消", null);
        aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.z3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.t0(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492914;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("回收站");
        g0("清空", new View.OnClickListener() { // from class: com.jsj.autojs.activity.a4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l0(view);
            }
        });
        i0("还原", new View.OnClickListener() { // from class: com.jsj.autojs.activity.w3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.n0(view);
            }
        });
        this.P = (RecyclerView) findViewById(R.id.recyclerView);
        this.U = findViewById(2131297222);
        this.P.setLayoutManager(new LinearLayoutManager(this));
        RecycleBinAdapter recycleBinAdapter = new RecycleBinAdapter(null);
        this.Q = recycleBinAdapter;
        recycleBinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.x3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.p0(baseQuickAdapter, view, i2);
            }
        });
        this.P.setAdapter(this.Q);
        u0();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
        u0();
    }
}
