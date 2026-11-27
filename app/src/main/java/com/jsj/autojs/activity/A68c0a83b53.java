package com.jsj.autojs.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.adapter.TaskSimpleAdapter;
import com.auto.exceldeps.log4j.message.ParameterizedMessage;
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
import i.b.l9;
import i.h.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class A68c0a83b53 extends com.yl.ui.p implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.j {
    private RecyclerView P;
    private BackupListAdapter Q;
    private SwipeRefreshLayout U;
    private int V = 0;
    private l9 W;
    private boolean Z;

    class a extends i.h.g<ScriptModel> {
        a(Activity activity) {
            super(activity);
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            A68c0a83b53.this.Q.loadMoreComplete();
            A68c0a83b53.this.U.setRefreshing(false);
            A68c0a83b53.this.Y(str);
            A68c0a83b53.this.S();
            A68c0a83b53.this.Q.loadMoreComplete();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ScriptModel scriptModel) {
            A68c0a83b53.this.Q.loadMoreComplete();
            A68c0a83b53.this.U.setRefreshing(false);
            if (scriptModel == null || scriptModel.getContent() == null || scriptModel.getContent().size() <= 0) {
                A68c0a83b53.this.Q.loadMoreComplete();
            } else {
                A68c0a83b53.this.Q.addData((Collection) scriptModel.getContent());
                A68c0a83b53.this.Q.notifyDataSetChanged();
                boolean z = scriptModel.getNumber() + 1 < scriptModel.getTotalPages();
                A68c0a83b53.this.Q.loadMoreComplete();
                if (z) {
                    A68c0a83b53.this.Q.setEnableLoadMore(true);
                } else {
                    A68c0a83b53.this.Q.loadMoreEnd();
                    A68c0a83b53.this.Q.setEnableLoadMore(false);
                }
            }
            A68c0a83b53.this.S();
        }
    }

    class b implements w.b {
        b() {
        }

        @Override // com.jsj.autojs.i.w.b
        public void a(Collection<ScriptModel.ContentBean> collection) {
            if (A68c0a83b53.this.Z) {
                JSONObject jSONObjectI = A68c0a83b53.this.W.i();
                if (jSONObjectI == null) {
                    A68c0a83b53.this.Y("请退出重新加载页面获取子账号权限");
                    return;
                }
                if (jSONObjectI.has("noCloud")) {
                    s.a aVar = new s.a(com.frame.v0.g().d());
                    aVar.m("知道了", null);
                    aVar.s(2131558430);
                    aVar.g(2131231019);
                    aVar.j("该账号没有获取主账号脚本的权限，请联系脚本制作者（不是软件开发者）");
                    aVar.e().show();
                    return;
                }
            }
            if (collection.isEmpty()) {
                A68c0a83b53.this.Y("请选择需要恢复的任务");
                A68c0a83b53.this.P.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (ScriptModel.ContentBean contentBean : collection) {
                stringBuffer.append(",");
                stringBuffer.append(contentBean.getId());
            }
            A68c0a83b53.this.U();
            new m8(this, collection).run();
        }
    }

    class c extends i.h.g<ScriptModel> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, String str) {
            super(activity);
            this.b = str;
        }

        @Override // i.h.g, i.h.f.b
        public void a(int i2, String str) {
            A68c0a83b53.this.Y(str);
            A68c0a83b53.this.S();
        }

        @Override // i.h.f.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ScriptModel scriptModel) {
            for (String str : this.b.split(",")) {
                ScriptModel.ContentBean contentBean = new ScriptModel.ContentBean();
                contentBean.setId(Long.valueOf(str));
                int iIndexOf = A68c0a83b53.this.Q.getData().indexOf(contentBean);
                if (iIndexOf != -1) {
                    A68c0a83b53.this.Q.remove(iIndexOf);
                }
            }
            A68c0a83b53.this.Q.notifyDataSetChanged();
            A68c0a83b53.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(com.yl.ui.s sVar, final int i2, View view) {
        sVar.cancel();
        if (this.Z) {
            if (this.W.i() == null) {
                Y("请退出重新加载页面获取子账号权限");
                return;
            }
            if (this.W.i().has("noCloud")) {
                s.a aVar = new s.a(com.frame.v0.g().d());
                aVar.m("知道了", null);
                aVar.s(2131558430);
                aVar.g(2131231019);
                aVar.j("该账号没有获取主账号脚本的权限，请联系脚本制作者（不是软件开发者）");
                aVar.e().show();
                return;
            }
        }
        try {
            s.a aVar2 = new s.a(this);
            aVar2.g(2131231019);
            aVar2.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.p2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.c.z0(i2, dialogInterface, i3);
                }
            });
            aVar2.m("取消", null);
            aVar2.j("是否确认恢复此脚本备份任务？");
            aVar2.t("温馨提示");
            aVar2.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void A1() {
        Y("选择需要恢复的任务");
        com.jsj.autojs.i.w wVar = new com.jsj.autojs.i.w();
        wVar.p2(this.Q.getData());
        wVar.o2(new b());
        wVar.j2(x(), "");
    }

    static /* synthetic */ void D0(Runnable runnable) {
        SystemClock.sleep(500L);
        com.frame.l1.e(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(Long l2, final Runnable runnable) {
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
            y1(e);
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
                Runnable runnable3 = new Runnable() { // from class: com.jsj.autojs.activity.b2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.l1.e(l8.c);
                    }
                };
                i.b.f8 f8Var = new i.b.f8();
                String absolutePath = file.getAbsolutePath();
                if (runnable != null) {
                    runnable3 = new Runnable() { // from class: com.jsj.autojs.activity.d2
                        @Override // java.lang.Runnable
                        public final void run() {
                            A68c0a83b53.D0(runnable);
                        }
                    };
                }
                f8Var.c(absolutePath, null, null, true, runnable3);
            } catch (Exception e2) {
                x1(e2);
                com.frame.y0.l(e2);
                if (runnable != null) {
                    return;
                } else {
                    runnable2 = new Runnable() { // from class: com.jsj.autojs.activity.j8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.S();
                        }
                    };
                }
            }
            if (runnable == null) {
                runnable2 = new Runnable() { // from class: com.jsj.autojs.activity.j8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.S();
                    }
                };
                com.frame.l1.e(runnable2);
            }
        } catch (Throwable th) {
            if (runnable == null) {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.j8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.S();
                    }
                });
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        p0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean J0(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        return p0(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L0(String str, DialogInterface dialogInterface, int i2) {
        com.frame.m0.a(str);
        com.yl.ui.i0.j();
        Y("已复制剪切板，请发送给主账号绑定");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(DialogInterface dialogInterface, int i2) {
        try {
            final String strTrim = com.frame.n1.g(AccountTool.d().c().getId() + ParameterizedMessage.ERROR_MSG_SEPARATOR + System.currentTimeMillis()).trim();
            Bitmap bitmapC = new com.jsj.autojs.l.f0().c(strTrim);
            ImageView imageView = new ImageView(com.frame.v0.g());
            imageView.setImageBitmap(bitmapC);
            s.a aVar = new s.a(this);
            aVar.t("我的绑定码");
            aVar.u(imageView);
            aVar.j("请使用主账号手机扫描此二维码，既可绑定子账号。");
            aVar.r("复制码", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.i2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i3) {
                    this.c.L0(strTrim, dialogInterface2, i3);
                }
            });
            aVar.m("取消", null);
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(View view) {
        if (!AccountTool.d().j()) {
            startActivity(new Intent(this, (Class<?>) A047634d3a4.class));
            return;
        }
        if (AccountTool.d().c().getPid() != null) {
            this.Z = true;
            this.V = 0;
            this.Q.setNewData(null);
            t1();
            v1();
            return;
        }
        try {
            s.a aVar = new s.a(this);
            aVar.r("绑定", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.j2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.N0(dialogInterface, i2);
                }
            });
            aVar.m("刷新", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.r2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AccountTool.d().y(l8.c, null);
                }
            });
            aVar.n();
            aVar.t("温馨提醒");
            aVar.g(2131231019);
            aVar.j("未找到主账号信息，是否需要绑定主账号？");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(View view) {
        this.Z = false;
        this.V = 0;
        this.Q.setNewData(null);
        t1();
        u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(TaskSimpleAdapter taskSimpleAdapter, DialogInterface dialogInterface, int i2) {
        E1(taskSimpleAdapter.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(TaskSimpleAdapter taskSimpleAdapter, DialogInterface dialogInterface, int i2) {
        taskSimpleAdapter.k(true);
        E1(taskSimpleAdapter.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0() {
        Y("请先登录~");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b1(JSONObject jSONObject) {
        Y(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1(Exception exc) {
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

    static /* synthetic */ void f1(String str) {
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提醒");
            dingMsgView.h("脚本解压出错：" + str);
            dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.jsj.autojs.activity.e2
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
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i1(BackupListAdapter backupListAdapter, RecyclerView recyclerView, DialogInterface dialogInterface, int i2) {
        if (backupListAdapter.d().isEmpty()) {
            Y("请选择需要删除的任务");
            recyclerView.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), 2130772016));
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (ScriptModel.ContentBean contentBean : backupListAdapter.d()) {
            stringBuffer.append(",");
            stringBuffer.append(contentBean.getId());
        }
        C1(stringBuffer.substring(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k1(String str, DialogInterface dialogInterface, int i2) {
        U();
        f.a aVar = new f.a();
        aVar.f(com.frame.k0.f + "/removeScript");
        aVar.e("ids", str);
        aVar.g(true);
        aVar.a().l(ScriptModel.class, new c(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "backup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o1(DialogInterface dialogInterface, int i2) {
        Abd192a7cca.D0(this, "backup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q1() {
        S();
        this.V = 0;
        this.Q.setNewData(null);
        t1();
    }

    private View q0() {
        View viewInflate = View.inflate(com.frame.v0.g(), 2131493130, null);
        TextView textView = (TextView) viewInflate.findViewById(2131296443);
        textView.setOnClickListener(this);
        textView.setText("开始备份");
        ((TextView) viewInflate.findViewById(2131297161)).setText("可自定义选择需要脚本备份的脚本");
        ((TextView) viewInflate.findViewById(2131297162)).setText("脚本备份任务");
        com.jsj.autojs.l.w.b((ImageView) viewInflate.findViewById(R.id.iv_icon), "backup.png");
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s1(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Task taskL = da.B().L(((TaskSimple) it.next()).getId());
            if (this.W.e(taskL)) {
                w1(taskL);
            }
        }
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.t2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.q1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(int i2, com.yl.ui.s sVar, View view) {
        B1(i2);
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v0(com.yl.ui.s sVar, View view) {
        z1();
        sVar.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        A1();
    }

    private final void w1(Task task) {
        if (task.getCreateUserId() == null && AccountTool.d().j()) {
            task.setCreateUserId(AccountTool.d().g());
        }
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", task.getId() + "");
            map.put("name", task.getName());
            map.put("token", AccountTool.d().e());
            map.put("u", com.frame.p0.h().i());
            String strZ = com.frame.p0.h().z(da.s, new i.b.v7().o(task.getId(), false, false, null, null, -1L, task.getCreateUserId()).getPath(), map);
            if (TextUtils.isEmpty(strZ)) {
                Y("上传出错");
                return;
            }
            final JSONObject jSONObject = new JSONObject(strZ);
            int iOptInt = jSONObject.optInt("code");
            if (iOptInt == -5) {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.Z0();
                    }
                });
            } else if (iOptInt == 1) {
                jSONObject.optJSONObject("json").optLong("id");
            } else {
                com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.c2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.b1(jSONObject);
                    }
                });
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
            Y(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(int i2, DialogInterface dialogInterface, int i3) {
        U();
        r0(this.Q.getItem(i2).getId(), null);
    }

    private void z1() {
        Y("选择需要删除的任务");
        final RecyclerView recyclerView = new RecyclerView(com.frame.v0.g());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final BackupListAdapter backupListAdapter = new BackupListAdapter(this.Q.getData());
        backupListAdapter.e(true);
        backupListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.s2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                backupListAdapter.f(i2);
            }
        });
        recyclerView.setAdapter(backupListAdapter);
        s.a aVar = new s.a(this);
        aVar.t("请选择需要删除的任务");
        aVar.u(recyclerView);
        aVar.f();
        aVar.r("批量删除", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.y1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.i1(backupListAdapter, recyclerView, dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        aVar.e().show();
    }

    public void B1(int i2) {
        C1(this.Q.getItem(i2).getId() + "");
    }

    public void C1(final String str) {
        try {
            String str2 = str.contains(",") ? "是否确认批量删除选中的脚本备份任务？" : "是否确认删除该此脚本备份任务？";
            s.a aVar = new s.a(this);
            aVar.g(2131231019);
            aVar.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.x1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.c.k1(str, dialogInterface, i2);
                }
            });
            aVar.m("取消", null);
            aVar.j(str2);
            aVar.t("温馨提示");
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void D1() {
        s.a aVar = new s.a(this);
        aVar.j("脚本备份是会员权益功能功能，解锁更多任务及会员权益，请开通VIP可继续使用？");
        aVar.m("查看权益", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.h2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.m1(dialogInterface, i2);
            }
        });
        aVar.g(2131231260);
        aVar.r("去开通", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.q2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.o1(dialogInterface, i2);
            }
        });
        aVar.t("温馨提示");
        aVar.e().show();
    }

    public void E1(final Collection<TaskSimple> collection) {
        U();
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.o2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.s1(collection);
            }
        });
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492895;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("脚本备份");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.P = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BackupListAdapter backupListAdapter = new BackupListAdapter(null);
        this.Q = backupListAdapter;
        backupListAdapter.setEnableLoadMore(false);
        this.Q.setUpFetchEnable(true);
        this.Q.setOnLoadMoreListener(this);
        this.Q.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.f2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.H0(baseQuickAdapter, view, i2);
            }
        });
        this.Q.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.jsj.autojs.activity.w2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.J0(baseQuickAdapter, view, i2);
            }
        });
        this.P.setAdapter(this.Q);
        this.Q.addHeaderView(q0());
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131297080);
        this.U = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(true);
        this.U.setOnRefreshListener(this);
        try {
            this.Z = getIntent().getBooleanExtra("isMainLoad", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.W = new l9();
        if (!AccountTool.d().j()) {
            startActivity(new Intent(this, (Class<?>) A047634d3a4.class));
            return;
        }
        if (AccountTool.d().c().getPid() != null) {
            this.W.p();
        }
        t1();
        if (!AccountTool.d().j() || AccountTool.d().c().getPid() == null) {
            return;
        }
        if (this.Z) {
            v1();
        } else {
            u1();
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        this.V = 0;
        this.Q.setNewData(null);
        t1();
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
            D1();
            return;
        }
        if (!AccountTool.d().m()) {
            D1();
            return;
        }
        Y("选择需要备份的脚本");
        RecyclerView recyclerView = new RecyclerView(com.frame.v0.g());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TaskSimpleAdapter taskSimpleAdapter = new TaskSimpleAdapter(da.B().C());
        taskSimpleAdapter.l(true);
        taskSimpleAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.jsj.autojs.activity.y2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i2) {
                taskSimpleAdapter.m(i2);
            }
        });
        recyclerView.setAdapter(taskSimpleAdapter);
        s.a aVar = new s.a(this);
        aVar.t("请选择备份的任务");
        aVar.u(recyclerView);
        aVar.r("备份", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.w1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.V0(taskSimpleAdapter, dialogInterface, i2);
            }
        });
        aVar.m("全选备份", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.z1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.X0(taskSimpleAdapter, dialogInterface, i2);
            }
        });
        aVar.e().show();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.V++;
        t1();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public boolean p0(final int i2) {
        if (!AccountTool.d().m()) {
            D1();
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
        if (this.Z) {
            viewInflate.findViewById(2131296397).setVisibility(8);
        } else {
            viewInflate.findViewById(2131296397).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.z2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.t0(i2, sVarE, view);
                }
            });
        }
        if (this.Z) {
            viewInflate.findViewById(2131296383).setVisibility(8);
        } else {
            viewInflate.findViewById(2131296383).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.g2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.c.v0(sVarE, view);
                }
            });
        }
        viewInflate.findViewById(2131296384).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.x0(sVarE, view);
            }
        });
        viewInflate.findViewById(2131296400).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.activity.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.B0(sVarE, i2, view);
            }
        });
        return true;
    }

    public void r0(final Long l2, final Runnable runnable) {
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.x2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.F0(l2, runnable);
            }
        });
    }

    public void t1() {
        U();
        f.a aVar = new f.a();
        aVar.f(com.frame.k0.g + "/getScript");
        aVar.c("page", Integer.valueOf(this.V));
        aVar.c("size", 30);
        aVar.c("isPid", Integer.valueOf(this.Z ? 1 : 0));
        aVar.g(true);
        aVar.a().l(ScriptModel.class, new a(this));
    }

    public void u1() {
        i0(" 主账号脚本 ", new View.OnClickListener() { // from class: com.jsj.autojs.activity.v2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.Q0(view);
            }
        });
    }

    public void v1() {
        i0(" 本号脚本 ", new View.OnClickListener() { // from class: com.jsj.autojs.activity.u2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.S0(view);
            }
        });
    }

    public void x1(final Exception exc) {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.m2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.d1(exc);
            }
        });
    }

    public void y1(Exception exc) {
        com.frame.y0.l(exc);
        final String message = exc.getMessage();
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.k2
            @Override // java.lang.Runnable
            public final void run() {
                A68c0a83b53.f1(message);
            }
        });
    }
}
