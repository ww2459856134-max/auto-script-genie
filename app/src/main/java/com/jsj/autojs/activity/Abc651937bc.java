package com.jsj.autojs.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.adapter.TaskSimpleAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jsj.autojs.adapter.BackupListAdapter;
import com.jsj.autojs.i.w;
import com.jsj.autojs.model.ScriptModel;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import i.b.da;
import i.h.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Abc651937bc extends com.yl.ui.p implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.j {
    private RecyclerView P;
    private BackupListAdapter Q;
    private SwipeRefreshLayout U;
    private long V;
    private int W = 0;
    private JSONObject Z;

    class a extends i.h.g<ScriptModel> {
        a(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            Abc651937bc.this.Q.loadMoreComplete();
            Abc651937bc.this.U.setRefreshing(false);
            Abc651937bc.this.Y(str);
            Abc651937bc.this.S();
            Abc651937bc.this.Q.loadMoreComplete();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ScriptModel scriptModel) {
            Abc651937bc.this.Q.loadMoreComplete();
            Abc651937bc.this.U.setRefreshing(false);
            if (scriptModel == null || scriptModel.getContent() == null || scriptModel.getContent().size() <= 0) {
                Abc651937bc.this.Q.loadMoreComplete();
            } else {
                Abc651937bc.this.Q.addData((Collection) scriptModel.getContent());
                Abc651937bc.this.Q.notifyDataSetChanged();
                boolean z = scriptModel.getNumber() + 1 < scriptModel.getTotalPages();
                Abc651937bc.this.Q.loadMoreComplete();
                if (z) {
                    Abc651937bc.this.Q.setEnableLoadMore(true);
                } else {
                    Abc651937bc.this.Q.loadMoreEnd();
                    Abc651937bc.this.Q.setEnableLoadMore(false);
                }
            }
            Abc651937bc.this.S();
        }
    }

    class b implements w.b {
        b() {
        }

        @Override // com.jsj.autojs.i.w.b
        public void a(Collection<ScriptModel.ContentBean> collection) {
            if (collection.isEmpty()) {
                Abc651937bc.this.Y("请选择需要恢复的任务");
                Abc651937bc.this.P.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (ScriptModel.ContentBean contentBean : collection) {
                stringBuffer.append(",");
                stringBuffer.append(contentBean.getId());
            }
            Abc651937bc.this.U();
            new n8(this, collection).run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean C0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        return n0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        n0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(TaskSimpleAdapter taskSimpleAdapter, DialogInterface dialogInterface, int i2) {
        g1(taskSimpleAdapter.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0(TaskSimpleAdapter taskSimpleAdapter, DialogInterface dialogInterface, int i2) {
        taskSimpleAdapter.k(true);
        g1(taskSimpleAdapter.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L0() {
        Y("请先登录~");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(JSONObject jSONObject) {
        Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0(Exception exc) {
        try {
            String message = exc.getMessage();
            s.a aVar = new s.a(this);
            aVar.r("知道了", null);
            aVar.n();
            aVar.t("温馨提醒");
            aVar.g(2131231019);
            aVar.j("脚本解压出错：" + message);
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void R0(String str) {
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提醒");
            dingMsgView.h("脚本解压出错：" + str);
            dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.jsj.autojs.activity.l4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T0(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "backup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "backup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0() {
        S();
        this.W = 0;
        this.Q.setNewData(null);
        a1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Task taskL = da.B().L(((TaskSimple) it.next()).getId());
            if (taskL.getCreateUserId() == null || taskL.getCreateUserId().equals(AccountTool.d().g())) {
                b1(taskL);
            } else {
                JSONObject jSONObject = this.Z;
                if (jSONObject == null || !jSONObject.has("canBackup")) {
                    Y(taskL.getName() + "不是您创建的脚本不能备份，已被忽略");
                } else {
                    b1(taskL);
                }
            }
        }
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.n4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.X0();
            }
        });
    }

    private final void b1(Task task) {
        if (task.getCreateUserId() == null && AccountTool.d().j()) {
            task.setCreateUserId(AccountTool.d().g());
        }
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", task.getId() + "");
            map.put("name", task.getName());
            map.put("token", AccountTool.d().e());
            map.put("u", com.frame.p0.h().i());
            String strZ = com.frame.p0.h().z(da.s, new i.b.v7().o(task.getId(), false, false, null, null, null, AccountTool.d().g()).getPath(), map);
            if (TextUtils.isEmpty(strZ)) {
                Y("上传出错");
                return;
            }
            final JSONObject jSONObject = new JSONObject(strZ);
            int iOptInt = jSONObject.optInt("code");
            if (iOptInt == -5) {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.v4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.L0();
                    }
                });
            } else if (iOptInt == 1) {
                jSONObject.optJSONObject("json").optLong("id");
            } else {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.t4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.N0(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
            Y(e.getMessage());
        }
    }

    private void e1() {
        Y("选择需要恢复的任务");
        com.jsj.autojs.i.w wVar = new com.jsj.autojs.i.w();
        wVar.p2(this.Q.getData());
        wVar.o2(new b());
        wVar.j2(x(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        e1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(int i2, DialogInterface dialogInterface, int i3) {
        U();
        o0(this.Q.getItem(i2).getId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(com.yl.ui.s sVar, final int i2, View view) {
        sVar.cancel();
        try {
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.m4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.s0(i2, dialogInterface, i3);
                }
            });
            aVar.m("取消", null);
            aVar.j("是否确认恢复此脚本备份任务？");
            aVar.t("温馨提示");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void w0(Runnable runnable) {
        SystemClock.sleep(500L);
        com.frame.l1.e(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0() {
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(Long l2, final Runnable runnable) {
        Runnable runnable2;
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("id", l2 + ""));
        arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
        arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
        File file = new File(da.z(), "/script.zip");
        file.deleteOnExit();
        try {
            com.frame.p0.h().c(da.t, file.getAbsolutePath(), arrayList);
        } catch (Exception e) {
            d1(e);
        }
        if (!file.exists()) {
            Y("脚本下载失败");
            if (runnable != null) {
                SystemClock.sleep(500L);
                com.frame.l1.e(runnable);
                return;
            }
            return;
        }
        try {
            try {
                Runnable runnable3 = new Runnable() { // from class: com.jsj.autojs.activity.d5
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.l1.e(l8.c);
                    }
                };
                i.b.f8 f8Var = new i.b.f8();
                String absolutePath = file.getAbsolutePath();
                if (runnable != null) {
                    runnable3 = new Runnable() { // from class: com.jsj.autojs.activity.r4
                        @Override // java.lang.Runnable
                        public final void run() {
                            Abc651937bc.w0(runnable);
                        }
                    };
                }
                f8Var.c(absolutePath, null, null, true, runnable3);
            } catch (Exception e2) {
                c1(e2);
                com.frame.y0.l(e2);
                if (runnable != null) {
                    return;
                } else {
                    runnable2 = new Runnable() { // from class: com.jsj.autojs.activity.y4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.y0();
                        }
                    };
                }
            }
            if (runnable == null) {
                runnable2 = new Runnable() { // from class: com.jsj.autojs.activity.y4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.y0();
                    }
                };
                com.frame.l1.e(runnable2);
            }
        } catch (Throwable th) {
            if (runnable == null) {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.y4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.y0();
                    }
                });
            }
            throw th;
        }
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492895;
    }

    public void a1() {
        U();
        f.a aVar = new f.a();
        aVar.f(com.frame.k0.g + "/getScript");
        aVar.c("page", Integer.valueOf(this.W));
        aVar.c("size", 100);
        aVar.d("userId", Long.valueOf(this.V));
        aVar.g(true);
        aVar.a().l(ScriptModel.class, new a(this));
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("子账号备份的脚本");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.P = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BackupListAdapter backupListAdapter = new BackupListAdapter(null);
        this.Q = backupListAdapter;
        backupListAdapter.setEnableLoadMore(false);
        this.Q.setUpFetchEnable(true);
        this.Q.setOnLoadMoreListener(this);
        this.Q.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.b5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.E0(baseQuickAdapter, view, i2);
            }
        });
        this.Q.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.jsj.autojs.activity.e5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.C0(baseQuickAdapter, view, i2);
            }
        });
        this.P.setAdapter(this.Q);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131297080);
        this.U = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.U.setOnRefreshListener(this);
        long longExtra = getIntent().getLongExtra("userId", 0L);
        this.V = longExtra;
        if (longExtra == 0) {
            finish();
        } else {
            a1();
        }
    }

    public void c1(final Exception exc) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.f5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.P0(exc);
            }
        });
    }

    public void d1(Exception exc) {
        com.frame.y0.l(exc);
        final String message = exc.getMessage();
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.q4
            @Override // java.lang.Runnable
            public final void run() {
                Abc651937bc.R0(message);
            }
        });
    }

    public void f1() {
        s.a aVar = new s.a(this);
        aVar.j("脚本备份是会员权益功能功能，解锁更多任务及会员权益，请开通VIP可继续使用？");
        aVar.m("查看权益", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.w4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.T0(dialogInterface, i2);
            }
        });
        aVar.g(2131231260);
        aVar.r("去开通", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.u4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.V0(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
    }

    public void g1(final Collection<TaskSimple> collection) {
        U();
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.a5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Z0(collection);
            }
        });
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        this.W = 0;
        this.Q.setNewData(null);
        a1();
    }

    public boolean n0(final int i2) {
        if (!AccountTool.d().m()) {
            f1();
            return true;
        }
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493112, null);
        s.a aVar = new s.a(this);
        aVar.u(viewInflate);
        aVar.f();
        aVar.r("确定", null);
        aVar.m("取消", null);
        aVar.n();
        aVar.t("请选择操作");
        final com.yl.ui.s sVarE = aVar.e();
        sVarE.show();
        viewInflate.findViewById(2131296397).setVisibility(8);
        viewInflate.findViewById(2131296383).setVisibility(8);
        viewInflate.findViewById(2131296384).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.x4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.q0(sVarE, view);
            }
        });
        viewInflate.findViewById(2131296400).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.z4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.u0(sVarE, i2, view);
            }
        });
        return true;
    }

    public void o0(final Long l2, final Runnable runnable) {
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.c5
            @Override // java.lang.Runnable
            public final void run() {
                this.c.A0(l2, runnable);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296443) {
            return;
        }
        if (!AccountTool.d().j()) {
            Y("请先登录");
            startActivity(new Intent(this, (Class<?>) A047634d3a4.class));
            return;
        }
        if (!AccountTool.d().m()) {
            f1();
            return;
        }
        Y("选择需要备份的脚本");
        RecyclerView recyclerView = new RecyclerView(com.frame.v0.g());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TaskSimpleAdapter taskSimpleAdapter = new TaskSimpleAdapter(da.B().C());
        taskSimpleAdapter.l(true);
        taskSimpleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.p4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                taskSimpleAdapter.m(i2);
            }
        });
        recyclerView.setAdapter(taskSimpleAdapter);
        s.a aVar = new s.a(this);
        aVar.t("请选择备份的任务");
        aVar.u(recyclerView);
        aVar.r("备份", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.s4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.H0(taskSimpleAdapter, dialogInterface, i2);
            }
        });
        aVar.m("全选备份", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.o4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.J0(taskSimpleAdapter, dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.W++;
        a1();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
