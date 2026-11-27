package com.jsj.autojs.j;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.a.ExportAct;
import com.act.WebAct;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.jsj.autojs.activity.A047634d3a4;
import com.jsj.autojs.activity.A279c88ed4f;
import com.jsj.autojs.activity.A960be28d46;
import com.jsj.autojs.activity.Abd192a7cca;
import com.jsj.autojs.adapter.TaskAdapter;
import com.permission.ClickView;
import com.s.BoxService;
import com.s.ScreenshotService;
import com.s.TaskService;
import com.tencent.cursor.R;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.AlarmTaskDialogView;
import com.v.FloatHandler;
import com.v.FloatHandlerRecord;
import com.v.TaskChooseDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import com.yl.ui.v;
import i.b.da;
import i.b.f8;
import i.b.i9;
import i.b.l9;
import i.b.t7;
import i.b.y7;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p1 extends com.yl.widget.e implements View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemLongClickListener, SwipeRefreshLayout.j {
    private TextView H0;
    private TaskAdapter I0;
    private t7 J0;
    private SwipeRefreshLayout K0;
    private RecyclerView L0;
    private GridLayoutManager M0;
    private View N0;
    private View O0;
    private View P0;
    private View Q0;
    private final androidx.activity.result.d<String[]> R0 = v1(new androidx.activity.result.l.c(), new androidx.activity.result.c() { // from class: com.jsj.autojs.j.e0
        @Override // androidx.activity.result.c
        public final void a(Object obj) {
            this.a.n2((Uri) obj);
        }
    });
    private boolean S0;
    private boolean T0;

    class a extends RecyclerView.n {
        final /* synthetic */ int a;

        a(p1 p1Var, int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2 = this.a;
            rect.left = i2;
            rect.right = i2;
            rect.top = i2 * 2;
        }
    }

    class b implements OnItemDragListener {
        b(p1 p1Var) {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragEnd(RecyclerView.d0 d0Var, int i2) {
            da.B().P1();
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragMoving(RecyclerView.d0 d0Var, int i2, RecyclerView.d0 d0Var2, int i3) {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemDragListener
        public void onItemDragStart(RecyclerView.d0 d0Var, int i2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B2(DialogInterface dialogInterface, int i2) {
        try {
            BoxService.m().disableSelf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i9.J()) {
            i9.v().s();
        }
        com.frame.v0.g().stopService(new Intent(com.frame.v0.g(), (Class<?>) ScreenshotService.class));
        new com.frame.j0().a(new Intent(com.frame.v0.g(), (Class<?>) TaskService.class));
        q().finish();
        com.jsj.autojs.g.c().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D2(DialogInterface dialogInterface, int i2) {
        P1(new Intent(q(), (Class<?>) A047634d3a4.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F2(View view) {
        com.yl.ui.q qVar = new com.yl.ui.q();
        qVar.n2(R.drawable.dialog_bg);
        qVar.j2(F(), "file:///android_asset/share_wx.jpg");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I2(String str) throws JSONException {
        try {
            String string = new JSONObject(str).getString(SocialConstants.PARAM_SEND_MSG);
            s.a aVar = new s.a(q());
            aVar.r("知道了", null);
            aVar.n();
            aVar.t("温馨提醒");
            aVar.g(2131231019);
            aVar.j(string);
            if (string.contains("会员")) {
                aVar.m("取消", null);
                aVar.r("开通", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.g0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        Abd192a7cca.D0(com.frame.v0.g().d(), "download");
                    }
                });
            }
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K2() {
        U1();
        com.yl.ui.i0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M2() {
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.t
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R2(List list) {
        this.P0.setVisibility(!list.isEmpty() ? 8 : 0);
        this.I0.setNewData(list);
        this.I0.notifyDataSetChanged();
        this.K0.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T2() {
        final List<TaskSimple> listD = da.B().D(null, 0);
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.q
            @Override // java.lang.Runnable
            public final void run() {
                this.c.R2(listD);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean V2(Task task, int i2, Dialog dialog, String str) {
        try {
            task.setRepeatDelay(Long.parseLong(str));
            this.I0.notifyItemChanged(i2);
            da.B().R1(task);
            return true;
        } catch (Exception e) {
            h2("请输入整数（毫秒）");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean X2(Task task, int i2, Dialog dialog, String str) {
        try {
            task.setRepeatCount(Integer.parseInt(str));
            this.I0.notifyItemChanged(i2);
            da.B().R1(task);
            return true;
        } catch (Exception e) {
            h2("请输入整数（毫秒）");
            e.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ void Z2(String str) {
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提醒");
            dingMsgView.h("脚本解压出错：" + str);
            dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.jsj.autojs.j.z
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
    /* renamed from: a3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean b3(Task task, Dialog dialog, String str) {
        try {
            if (str.length() > 10) {
                h2("不能超过10个字");
                return false;
            }
            task.setName(str);
            this.I0.notifyDataSetChanged();
            da.B().R1(task);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    static /* synthetic */ void c3(FloatHandler floatHandler) {
        View viewFindViewById = floatHandler.findViewById(2131296499);
        if (viewFindViewById != null) {
            viewFindViewById.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3() {
        if (!(this.L0.getAdapter() instanceof TaskAdapter)) {
            this.L0.setAdapter(this.I0);
        }
        com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.m
            @Override // java.lang.Runnable
            public final void run() {
                this.c.T2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        final FloatHandler floatHandlerP = FloatHandler.P();
        floatHandlerP.post(new Runnable() { // from class: com.jsj.autojs.j.v
            @Override // java.lang.Runnable
            public final void run() {
                p1.c3(floatHandlerP);
            }
        });
    }

    private int j2() {
        return com.frame.p1.f() ? 4 : 2;
    }

    private void j3() {
        if (com.permission.x0.m().p()) {
            this.T0 = false;
            f2("正在检查ESP32 HID连接...");
            y7.d("录制脚本", new Runnable() { // from class: com.jsj.autojs.j.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.i3();
                }
            }, new Runnable() { // from class: com.jsj.autojs.j.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.U1();
                }
            });
        } else {
            this.T0 = true;
            com.permission.x0.m().f();
            Toast.makeText(com.frame.v0.g(), "HID模式录制只需开启悬浮窗权限", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n2(Uri uri) {
        if (uri == null) {
            com.jsj.autojs.l.c0.e().B("未选中导入的脚本文件", null);
            return;
        }
        h.h.a.a aVarF = h.h.a.a.f(y1(), uri);
        if (aVarF == null || !aVarF.d()) {
            com.jsj.autojs.l.c0.e().B("文件不存在", null);
            return;
        }
        y1().getContentResolver().takePersistableUriPermission(uri, 1);
        try {
            Intent intent = new Intent(com.frame.v0.g(), (Class<?>) A960be28d46.class);
            intent.setAction("fromMe");
            intent.setData(uri);
            P1(intent);
        } catch (Exception e) {
            com.jsj.autojs.l.c0.e().B("导入出错，请检查脚本是否有问题", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p2(Exception exc) {
        U1();
        try {
            s.a aVar = new s.a(q());
            aVar.r("知道了", null);
            aVar.n();
            aVar.t("温馨提醒");
            aVar.g(2131231019);
            aVar.j("脚本解压出错~" + exc.getMessage());
            aVar.e().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r2(Long l2) {
        final String strC;
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("id", l2 + ""));
        arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
        arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
        File file = new File(da.z(), "/script.zip");
        file.deleteOnExit();
        try {
            strC = com.frame.p0.h().c(da.t, file.getAbsolutePath(), arrayList);
        } catch (Exception e) {
            g3(e);
            strC = null;
        }
        if (strC != null) {
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.w
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.c.I2(strC);
                }
            });
            return;
        }
        if (!file.exists()) {
            h2("脚本下载失败");
        }
        try {
            new f8().b(file.getAbsolutePath(), l2, new Runnable() { // from class: com.jsj.autojs.j.i0
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.M2();
                }
            });
        } catch (Exception e2) {
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.p2(e2);
                }
            });
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean t2(Dialog dialog, String str) throws NumberFormatException {
        try {
            final Long lValueOf = Long.valueOf(str.split("#")[1]);
            g2(true);
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.r2(lValueOf);
                }
            });
            return true;
        } catch (Exception unused) {
            h2("请输入正确分享码");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v2(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        if (!AccountTool.d().j()) {
            h2("请先登录");
            P1(new Intent(q(), (Class<?>) A047634d3a4.class));
            return;
        }
        TextView textView = new TextView(com.frame.v0.g());
        int iC = com.frame.p1.c(25.0f);
        textView.setPadding(iC, 0, iC, iC);
        textView.setTextSize(12.0f);
        textView.setText(Html.fromHtml("分享码的脚本非官方出品，是由其他用户制作，如有问题请咨询分享码出处，<strong><font color='#F45075'>严禁</font></strong>使用APP制作<strong><font color='#F45075'>作弊器、外挂、刷屏、刷单</font></strong>等损害其他平台利益的行为。"));
        v.a aVar = new v.a(q());
        aVar.n("导入分享码");
        aVar.l(3);
        aVar.f("请输入脚本分享码");
        aVar.p(textView);
        aVar.g(new v.b() { // from class: com.jsj.autojs.j.b0
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.t2(dialog, str);
            }
        });
        aVar.d().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x2(com.yl.ui.s sVar, View view) {
        sVar.cancel();
        this.R0.a(new String[]{"*/*"});
    }

    static /* synthetic */ void z2() {
        if (com.frame.w0.d()) {
            FloatHandler.P().post(new Runnable() { // from class: com.jsj.autojs.j.d0
                @Override // java.lang.Runnable
                public final void run() {
                    ClickView.getInstance().a(FloatHandler.P().findViewById(2131296499).createAccessibilityNodeInfo(), "开始录制");
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void P0(int i2, String[] strArr, int[] iArr) {
        super.P0(i2, strArr, iArr);
        t7 t7Var = this.J0;
        if (t7Var != null) {
            t7Var.y0(i2, 0, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        try {
            if (com.frame.w0.d()) {
                this.O0.setVisibility(8);
                this.N0.setVisibility(0);
                this.Q0.setVisibility(com.frame.n0.a("fhclose", false) ? 0 : 8);
            } else {
                this.O0.setVisibility(0);
                this.N0.setVisibility(8);
                this.Q0.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yl.widget.e
    public int X1() {
        return 2131493042;
    }

    @Override // com.yl.widget.e
    public void Y1() {
        super.Y1();
        View viewV1 = V1(2131296945);
        this.Q0 = viewV1;
        viewV1.setOnClickListener(this);
        this.P0 = V1(2131296932);
        View viewV12 = V1(R.id.btn_close);
        this.N0 = viewV12;
        viewV12.setOnClickListener(this);
        V1(2131296494).setOnClickListener(this);
        this.H0 = (TextView) V1(2131297165);
        V1(2131296890).setOnClickListener(this);
        this.K0 = (SwipeRefreshLayout) V1(2131297080);
        this.J0 = new t7();
        this.L0 = (RecyclerView) V1(R.id.recyclerView);
        this.I0 = new TaskAdapter(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(W1(), j2());
        this.M0 = gridLayoutManager;
        this.L0.setLayoutManager(gridLayoutManager);
        this.L0.g(new a(this, com.frame.p1.c(5.0f)));
        V1(2131296348).setOnClickListener(this);
        V1(2131296376).setOnClickListener(this);
        this.L0.setAdapter(this.I0);
        this.K0.setOnRefreshListener(this);
        androidx.recyclerview.widget.k0 k0Var = new androidx.recyclerview.widget.k0(new ItemDragAndSwipeCallback(this.I0));
        k0Var.j(this.L0);
        this.I0.enableDragItem(k0Var, 2131296525, false);
        this.I0.setOnItemDragListener(new b(this));
        this.I0.setOnItemClickListener(this);
        this.I0.setOnItemLongClickListener(this);
        this.I0.setOnItemChildClickListener(this);
        this.K0.setEnabled(true);
        this.K0.setRefreshing(true);
        V1(2131296522).setOnClickListener(this);
        View viewV13 = V1(2131296933);
        this.O0 = viewV13;
        viewV13.setOnClickListener(this);
        V1(2131297228).setOnClickListener(this);
        V1(2131297220).setOnClickListener(this);
        d3();
        if (AccountTool.d().j() && AccountTool.d().c().getPid() != null) {
            new l9().p();
        }
        new i.a.k().d("index_warn", V1(2131297297), null, (TextView) V1(2131297297), q(), null, true, 0L, null, 0);
    }

    public void e3(final Task task, final int i2) {
        v.a aVar = new v.a(q());
        aVar.n("设置循环间隔时长");
        aVar.f("请输入循环间隔时间");
        aVar.h(2);
        aVar.k(task.getRepeatDelay() + "");
        aVar.l(1);
        aVar.o("毫秒");
        aVar.g(new v.b() { // from class: com.jsj.autojs.j.c0
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.V2(task, i2, dialog, str);
            }
        });
        aVar.d().show();
    }

    public void f3(final Task task, final int i2) {
        v.a aVar = new v.a(q());
        aVar.n("设置循环次数");
        aVar.f("请输入循环次数");
        aVar.h(2);
        aVar.k(task.getRepeatCount() + "");
        aVar.l(1);
        aVar.o("毫秒");
        aVar.g(new v.b() { // from class: com.jsj.autojs.j.o
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.X2(task, i2, dialog, str);
            }
        });
        aVar.d().show();
    }

    public void g3(Exception exc) {
        com.frame.y0.l(exc);
        final String message = exc.getMessage();
        com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.j.y
            @Override // java.lang.Runnable
            public final void run() {
                p1.Z2(message);
            }
        });
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void h() {
        V1(2131296890).setVisibility(8);
        d3();
        if (com.frame.s0.g().m(FloatHandlerRecord.class)) {
            return;
        }
        FloatHandler.P();
    }

    public void h3(final Task task, int i2) {
        if (task == null) {
            h2("出错了");
            return;
        }
        v.a aVar = new v.a(q());
        aVar.n("任务名称");
        aVar.f("请输入任务名称");
        aVar.k(task.getName());
        aVar.l(1);
        aVar.g(new v.b() { // from class: com.jsj.autojs.j.u
            @Override // com.yl.ui.v.b
            public final boolean a(Dialog dialog, String str) {
                return this.a.b3(task, dialog, str);
            }
        });
        aVar.d().show();
    }

    protected boolean i2() {
        if (!com.frame.w0.d() && !this.S0) {
            boolean zP = com.permission.x0.m().p();
            this.S0 = zP;
            if (!zP) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296348:
            case 2131296420:
            case 2131296421:
            case 2131296443:
            case 2131296444:
                if (!da.B().O()) {
                    t7 t7Var = new t7();
                    this.J0 = t7Var;
                    t7Var.z0(new Runnable() { // from class: com.jsj.autojs.j.j0
                        @Override // java.lang.Runnable
                        public final void run() {
                            p1.z2();
                        }
                    });
                    this.J0.d();
                    break;
                } else {
                    j3();
                    break;
                }
            case 2131296376:
                if (!AccountTool.d().j()) {
                    s.a aVar = new s.a(q());
                    aVar.j("请先登录");
                    aVar.r("登录", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.h0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.c.D2(dialogInterface, i2);
                        }
                    });
                    aVar.m("取消", null);
                    aVar.e().show();
                    break;
                } else {
                    View viewInflate = View.inflate(com.frame.v0.g(), 2131493127, null);
                    s.a aVar2 = new s.a(q());
                    aVar2.u(viewInflate);
                    aVar2.j("请勿导入不明、未知的脚本文件。您即将导入的脚本文件均为非官方出品，由其他用户自主开发制作。若在使用过程中遇到任何问题，请通过该脚本的分享来源渠道进行咨询。<br/>在此特别重申重要提醒：<strong><font color='#F45075'>严禁</font></strong>利用此类APP制作或使用任何形式的作弊工具（包括但不限于作弊器、外挂程序），以及实施刷屏、刷单等干扰平台正常运营、破坏公平环境或损害其他平台/用户利益的行为。此类行为不仅严重违反平台用户协议及管理规则，更可能触及《网络安全法》《反不正当竞争法》等相关法律法规，由此产生的一切法律责任将由行为人自行承担，请务必严格遵守。");
                    aVar2.f();
                    aVar2.r("确定", null);
                    aVar2.m("取消", null);
                    aVar2.n();
                    aVar2.t("选择导入方式");
                    final com.yl.ui.s sVarE = aVar2.e();
                    sVarE.show();
                    ((TextView) sVarE.findViewById(R.id.tv_content)).setTextSize(11.0f);
                    viewInflate.findViewById(2131296391).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.f0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.c.F2(view2);
                        }
                    });
                    viewInflate.findViewById(2131296352).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.c.v2(sVarE, view2);
                        }
                    });
                    viewInflate.findViewById(2131296373).setOnClickListener(new View.OnClickListener() { // from class: com.jsj.autojs.j.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.c.x2(sVarE, view2);
                        }
                    });
                    break;
                }
            case R.id.btn_close /* 2131296439 */:
                try {
                    s.a aVar3 = new s.a(q());
                    aVar3.g(2131231019);
                    aVar3.r("确认", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.j.p
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            this.c.B2(dialogInterface, i2);
                        }
                    });
                    aVar3.m("取消", null);
                    aVar3.j("是否强制关闭App，将会关闭后台程序、录屏权限、定时任务、悬浮条及无障碍权限？");
                    aVar3.t("温馨提示");
                    aVar3.g(2131231019);
                    aVar3.e().show();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 2131296494:
                new com.jsj.autojs.i.x().j2(F(), "");
                break;
            case 2131296522:
                P1(new Intent(com.frame.v0.g(), (Class<?>) A279c88ed4f.class));
                break;
            case 2131296890:
                V1(2131296890).setVisibility(8);
                d3();
                break;
            case 2131296933:
                if (this.J0 == null) {
                    this.J0 = new t7();
                }
                this.J0.d();
                break;
            case 2131296945:
                com.frame.n0.g("fhclose", false);
                FloatHandler.P();
                view.setVisibility(8);
                break;
            case 2131297220:
                try {
                    Intent intent = new Intent(com.frame.v0.g(), (Class<?>) WebAct.class);
                    intent.putExtra(SocialConstants.PARAM_URL, "https://www.wjx.cn/vj/PC4VQU1.aspx");
                    intent.putExtra("key", "autoRequest");
                    intent.putExtra("title", "申请成为脚本制作者");
                    P1(intent);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.frame.k0.r(e2);
                    return;
                }
            case 2131297228:
                try {
                    Intent intent2 = new Intent(com.frame.v0.g(), (Class<?>) WebAct.class);
                    intent2.putExtra(SocialConstants.PARAM_URL, "https://www.wjx.top/vj/mUtlXVg.aspx");
                    intent2.putExtra("key", "autoRequest");
                    intent2.putExtra("title", "帮我制作脚本");
                    P1(intent2);
                    break;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    com.frame.k0.r(e3);
                    return;
                }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GridLayoutManager gridLayoutManager = this.M0;
        if (gridLayoutManager != null) {
            gridLayoutManager.e3(j2());
            TaskAdapter taskAdapter = this.I0;
            if (taskAdapter != null) {
                taskAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskSimple taskSimpleW;
        TaskSimple item = this.I0.getItem(i2);
        if (item == null) {
            h2("请先刷新列表后再试");
        }
        final Task taskL = da.B().L(item.getId());
        if (taskL == null && !"group".equals(item.getPn())) {
            Toast.makeText(com.frame.v0.g(), "请先下拉刷新列表", 0).show();
            return;
        }
        if (view.getId() == 2131296523) {
            if ("group".equals(item.getPn())) {
                Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ExportAct.class);
                intent.putExtra("group", item.getName());
                com.frame.v0.g().startActivity(intent);
                return;
            } else {
                Intent intent2 = new Intent(q(), (Class<?>) ExportAct.class);
                intent2.putExtra("id", taskL.getId());
                P1(intent2);
                com.frame.s0.g().d(TaskChooseDialogView.class);
                return;
            }
        }
        if (!i2() && (view.getId() != 2131296507 || !da.B().O())) {
            t7 t7Var = new t7();
            this.J0 = t7Var;
            t7Var.d();
            return;
        }
        switch (view.getId()) {
            case 2131296426:
                ((AlarmTaskDialogView) com.frame.s0.g().y(AlarmTaskDialogView.class, 0, 0, -1, -1)).setTaskId(taskL.getId());
                break;
            case 2131296447:
                if (!"group".equals(item.getPn())) {
                    TaskSimple taskSimpleW2 = da.B().w(item.getId());
                    if (taskSimpleW2 == null) {
                        h2("请先下拉刷新列表");
                        break;
                    } else {
                        try {
                            new TaskChooseDialogView().showMenu(taskSimpleW2, new j(this));
                            break;
                        } catch (Exception unused) {
                            h2("打开任务菜单失败，请重试");
                            return;
                        }
                    }
                } else if (item.getDefaultTaskId() == 0 || (taskSimpleW = da.B().w(item.getDefaultTaskId())) == null) {
                    try {
                        new TaskChooseDialogView().showGroupMenu(item, new j(this));
                        break;
                    } catch (Exception unused2) {
                        h2("打开分组菜单失败，请重试");
                        return;
                    }
                } else {
                    try {
                        new TaskChooseDialogView().showGroupTaskMenu(taskSimpleW, new j(this));
                        break;
                    } catch (Exception unused3) {
                        h2("打开子任务菜单失败，请重试");
                        return;
                    }
                }
                break;
            case 2131296507:
                if (!com.frame.w0.d()) {
                    if (!da.B().O()) {
                        this.J0.d();
                        break;
                    } else {
                        y7.c("执行脚本", new Runnable() { // from class: com.jsj.autojs.j.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.a0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        da.B().e2(task, true);
                                    }
                                });
                            }
                        });
                        break;
                    }
                } else {
                    com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.j.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            da.B().e2(taskL, true);
                        }
                    });
                    break;
                }
            case 2131297255:
                h3(taskL, i2);
                break;
            case 2131297273:
                f3(taskL, i2);
                break;
            case 2131297274:
                e3(taskL, i2);
                break;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!i2() && (view.getId() != 2131296507 || !da.B().O())) {
            t7 t7Var = new t7();
            this.J0 = t7Var;
            t7Var.d();
            return;
        }
        TaskSimple item = this.I0.getItem(i2);
        if (item == null) {
            h2("请先刷新列表后再试");
            return;
        }
        if ("group".equals(item.getPn())) {
            V1(2131296890).setVisibility(0);
            this.H0.setText(item.getName());
            this.I0.setNewData(da.B().D(item.getName(), 0));
            return;
        }
        V1(2131296890).setVisibility(8);
        TaskSimple taskSimpleW = da.B().w(item.getId());
        if (taskSimpleW == null) {
            h2("请先下拉刷新列表");
            return;
        }
        try {
            new TaskChooseDialogView().showMenu(taskSimpleW, new j(this));
        } catch (Exception unused) {
            h2("打开任务菜单失败，请重试");
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
    public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskSimple taskSimpleW;
        if (!i2()) {
            t7 t7Var = new t7();
            this.J0 = t7Var;
            t7Var.d();
            return true;
        }
        TaskSimple item = this.I0.getItem(i2);
        if (item == null) {
            h2("请先刷新列表后再试");
            return true;
        }
        if (!"group".equals(item.getPn())) {
            TaskSimple taskSimpleW2 = da.B().w(item.getId());
            if (taskSimpleW2 == null) {
                h2("请先下拉刷新列表");
                return true;
            }
            try {
                new TaskChooseDialogView().showMenu(taskSimpleW2, new j(this));
            } catch (Exception unused) {
                h2("打开任务菜单失败，请重试");
            }
        } else {
            if (item.getDefaultTaskId() != 0 && (taskSimpleW = da.B().w(item.getDefaultTaskId())) != null) {
                try {
                    new TaskChooseDialogView().showGroupTaskMenu(taskSimpleW, new j(this));
                    return true;
                } catch (Exception unused2) {
                    h2("打开子任务菜单失败，请重试");
                    return true;
                }
            }
            try {
                new TaskChooseDialogView().showGroupMenu(item, new j(this));
            } catch (Exception unused3) {
                h2("打开分组菜单失败，请重试");
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void q0(int i2, int i3, Intent intent) {
        super.q0(i2, i3, intent);
        if (this.T0 && i2 == com.permission.x0.b.intValue()) {
            j3();
        }
        t7 t7Var = this.J0;
        if (t7Var != null) {
            t7Var.y0(i2, i3, intent);
        }
    }

    @Override // com.yl.widget.e, androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        super.v0(bundle);
    }
}
