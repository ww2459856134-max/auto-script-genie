package com.jsj.autojs.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.LogFileSimpleListAdapter;
import com.tencent.cursor.R;
import com.yl.float_ui.SimpleLogView;
import com.yl.ui.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Ad1caecde37 extends com.yl.ui.p implements View.OnClickListener {
    private LogFileSimpleListAdapter P;
    private View Q;
    private File U;
    private int V = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C0(com.yl.ui.w wVar, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        this.V = i2;
        this.P.setNewData(k0());
        wVar.X1();
    }

    private void D0() {
        if (k0().isEmpty()) {
            Y("暂无可清空的执行日志");
            return;
        }
        s.a aVar = new s.a(this);
        aVar.t("温馨提示");
        aVar.g(2131231019);
        aVar.j("是否确认清空所有执行日志？清空后无法恢复；若日志记录仍开启，之后产生的新日志会继续保留。");
        aVar.m("取消", null);
        aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.o5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.A0(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    private void E0() {
        final com.yl.ui.w wVar = new com.yl.ui.w();
        wVar.m2("日志排序");
        wVar.l2(Arrays.asList("默认", "按大小", "按创建时间", "按修改时间"), new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.k5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.C0(wVar, baseQuickAdapter, view, i2);
            }
        });
        wVar.j2(x(), "logSort");
    }

    private ArrayList<File> k0() {
        File[] fileArrS = com.frame.r0.s(this.U);
        ArrayList<File> arrayList = fileArrS == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(fileArrS));
        i.b.i8.a(arrayList, this.V);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(View view) {
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(View view) {
        E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(View view) {
        com.frame.y0.b().r(false);
        this.Q.setVisibility(0);
        g0(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intent intent = new Intent(this, (Class<?>) A6163c89234.class);
        intent.putExtra("file", this.P.getItem(i2).getAbsolutePath());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(int i2, DialogInterface dialogInterface, int i3) {
        this.P.getItem(i2).delete();
        this.P.remove(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean w0(BaseQuickAdapter baseQuickAdapter, View view, final int i2) {
        try {
            s.a aVar = new s.a(this);
            aVar.j("是否确认删除此日志");
            aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.n5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.u0(i2, dialogInterface, i3);
                }
            });
            aVar.m("取消", null);
            aVar.e().show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(DialogInterface dialogInterface, int i2) {
        com.yl.ui.i0.j();
        com.frame.y0.b().r(true);
        this.Q.setVisibility(8);
        try {
            if (com.frame.s0.g().m(SimpleLogView.class)) {
                com.frame.s0.g().d(SimpleLogView.class);
            } else {
                SimpleLogView.P().R(com.frame.y0.b().a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(DialogInterface dialogInterface, int i2) {
        Iterator<File> it = k0().iterator();
        boolean z = true;
        while (it.hasNext()) {
            File next = it.next();
            if (next.exists() && !next.delete()) {
                z = false;
            }
        }
        this.P.setNewData(k0());
        if (z) {
            com.yl.ui.i0.j();
        } else {
            Y("部分日志删除失败，请稍后重试");
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492905;
    }

    @Override // com.yl.ui.p
    public void b0() {
        super.b0();
        j0("日志列表");
        Z();
        i0("清空日志", new View.OnClickListener() { // from class: com.jsj.autojs.activity.j5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.m0(view);
            }
        });
        h0(2131231056, new View.OnClickListener() { // from class: com.jsj.autojs.activity.q5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o0(view);
            }
        });
        this.K.findViewById(R.id.iv_more2).setContentDescription("排序");
        View viewFindViewById = findViewById(2131296831);
        this.Q = viewFindViewById;
        viewFindViewById.setVisibility(com.frame.y0.b().f() ? 8 : 0);
        if (com.frame.y0.b().f()) {
            g0("关闭日志", new View.OnClickListener() { // from class: com.jsj.autojs.activity.l5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.q0(view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        File file = new File(com.frame.v0.g().getFilesDir(), "/clickHistory/");
        this.U = file;
        if (!file.exists()) {
            this.U.mkdirs();
        }
        LogFileSimpleListAdapter logFileSimpleListAdapter = new LogFileSimpleListAdapter(k0());
        this.P = logFileSimpleListAdapter;
        logFileSimpleListAdapter.d(false);
        this.P.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.m5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.s0(baseQuickAdapter, view, i2);
            }
        });
        this.P.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.jsj.autojs.activity.p5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.w0(baseQuickAdapter, view, i2);
            }
        });
        recyclerView.setAdapter(this.P);
        this.Q.findViewById(2131296443).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296443) {
            return;
        }
        s.a aVar = new s.a(this);
        aVar.t("温馨提示");
        aVar.j("调试模式未开启，没有记录执行日志，请先开启调试模式后在查看执行日志。在调试脚本正常后，请关闭调试模式，避免是执行操作变得卡顿。");
        aVar.g(2131231019);
        aVar.m("取消", null);
        aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.i5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.y0(dialogInterface, i2);
            }
        });
        aVar.e().show();
    }
}
