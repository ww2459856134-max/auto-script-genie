package com.v;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.a.ExportAct;
import com.adapter.MultiTaskSimpleAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.AutoNotifyConfigDialogView;
import com.v.FileChooseView;
import com.v.FloatButtonConfigDialogView;
import com.v.ImageBoxSelectDialogView;
import com.v.ItemChooseDialogView;
import com.v.LooperCountDurationDialogView;
import com.yl.float_ui.CanDragFloatView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.float_ui.SimpleLogView;
import com.yl.model.AutoNotify;
import com.yl.model.FloatButtonConfig;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TaskChooseDialogView extends CanDragFloatView implements View.OnClickListener {
    private Button btnSearch;
    private EditText edtName;
    private String groupType;
    private View lySearch;
    private MultiTaskSimpleAdapter mAdapter;
    private b mOnChooseListener;
    private int sorter;

    class a implements ImageBoxSelectDialogView.c {
        a(TaskChooseDialogView taskChooseDialogView) {
        }

        @Override // com.v.ImageBoxSelectDialogView.c
        public void a(int i2, List<ImageBox> list) {
            com.frame.s0.g().d(ImageBoxSelectDialogView.class);
            com.frame.s0.g().u(FloatHandler.class);
        }
    }

    public interface b {
        void a(TaskSimple taskSimple);
    }

    public TaskChooseDialogView() {
        this(com.frame.v0.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean B0(final String str, final Runnable runnable, final String str2) {
        com.frame.s0.g().d(InputDialogView.class);
        com.frame.l1.g(new Runnable() { // from class: com.v.rn
            @Override // java.lang.Runnable
            public final void run() {
                this.c.z0(str, str2, runnable);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        com.frame.p1.b(this.edtName.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(TaskSimple taskSimple, Task task, Runnable runnable, ItemChooseDialogView itemChooseDialogView, int i2, List list) {
        String str = (String) list.get(i2);
        if ("定时执行".equals(str)) {
            showAlarmSetAlert(taskSimple);
        } else if ("修改参数".equals(str)) {
            if (TextUtils.isEmpty(task.getArgumentJson())) {
                FloatToast.i("没有预置的参数");
            } else {
                com.frame.s0.g().d(ItemChooseDialogView.class);
                ((ArgumentSetDialogView) com.frame.s0.g().B(ArgumentSetDialogView.class)).setTask(task);
            }
        } else if ("自动触发".equals(str)) {
            showAutoRunAlert(taskSimple);
        } else if ("悬浮按钮".equals(str)) {
            showCreateFloatButtonDialog(taskSimple);
        } else if ("删除".equals(str)) {
            showTasksByGroupNameAlert(taskSimple.getGroup(), runnable);
        }
        itemChooseDialogView.setDefaultData(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        com.frame.p1.g(this.edtName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(TaskSimple taskSimple, Task task, Runnable runnable, ItemChooseDialogView itemChooseDialogView, int i2, List list) {
        String str = (String) list.get(i2);
        if ("流程列表".equals(str)) {
            showNodeListView(taskSimple);
        } else if ("流程图".equals(str)) {
            showFlowView(task);
        } else if ("查看当前变量".equals(str)) {
            com.frame.s0.g().x(ParamsCurrentListDialogView.class);
        } else if ("定时执行".equals(str)) {
            showAlarmSetAlert(taskSimple);
        } else if ("删除分组".equals(str)) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            showTasksByGroupNameAlert(taskSimple.getName(), runnable);
        } else if ("自动触发".equals(str)) {
            showAutoRunAlert(taskSimple);
        } else if ("悬浮按钮".equals(str)) {
            showCreateFloatButtonDialog(taskSimple);
        } else if ("删除".equals(str)) {
            showTasksByGroupNameAlert(taskSimple.getGroup(), runnable);
        } else if ("导出分享".equals(str)) {
            exportGroupTask(taskSimple.getGroup());
        } else if ("分组分类".equals(str)) {
            showEditGroupName(taskSimple, runnable);
        } else if ("重命名分组".equals(str)) {
            showGroupRenameAlert(taskSimple.getGroup(), runnable);
        } else if ("解散分组".equals(str)) {
            showDisgroupAlert(taskSimple.getGroup());
        } else if ("查看子脚本".equals(str)) {
            showGroupTasks(taskSimple.getGroup(), runnable);
        } else if ("复制任务".equals(str)) {
            showCopyAlert(taskSimple, runnable);
        } else if ("预置参数".equals(str)) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            ((ArgumentDialogView) com.frame.s0.g().x(ArgumentDialogView.class)).setTask(task);
        } else if ("修改参数".equals(str)) {
            if (TextUtils.isEmpty(task.getArgumentJson())) {
                FloatToast.i("没有预置的参数");
            } else {
                com.frame.s0.g().d(ItemChooseDialogView.class);
                ((ArgumentSetDialogView) com.frame.s0.g().B(ArgumentSetDialogView.class)).setTask(task);
            }
        }
        itemChooseDialogView.setDefaultData(-1);
    }

    static /* synthetic */ void H(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(TaskChooseDialogView.class);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("chenai://www.skyingidea.com/pay"));
            com.frame.v0.g().startActivity(intent);
        } catch (Exception e) {
            com.frame.k0.i("no_webapp");
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void H0(String str) {
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提醒");
            dingMsgView.h("脚本解压出错：" + str);
            dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.v.fn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    static /* synthetic */ void J(String str) throws JSONException {
        try {
            String string = new JSONObject(str).getString(SocialConstants.PARAM_SEND_MSG);
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提醒");
            dingMsgView.h(string);
            dingMsgView.g(j.b.d.q0);
            if (string.contains("会员")) {
                dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.rm
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.k("开通", new View.OnClickListener() { // from class: com.v.en
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TaskChooseDialogView.H(view);
                    }
                });
            } else {
                dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.v.yl
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(com.frame.s0 s0Var) {
        if (s0Var.f(TaskChooseDialogView.class) != this) {
            return;
        }
        MultiTaskSimpleAdapter multiTaskSimpleAdapter = this.mAdapter;
        if (multiTaskSimpleAdapter != null) {
            multiTaskSimpleAdapter.notifyDataSetChanged();
        }
        s0Var.t(this);
    }

    static /* synthetic */ void K() {
        com.yl.ui.i0.l(null);
        com.frame.s0.g().d(TaskChooseDialogView.class);
        show();
    }

    static /* synthetic */ void L0(Task task, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        i.b.da.B().U1(Long.valueOf(task.getId()));
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Long l2) {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("id", l2 + ""));
        arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
        arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
        File file = new File(i.b.da.z(), "/script.zip");
        file.deleteOnExit();
        try {
            final String strC = com.frame.p0.h().c(i.b.da.t, file.getAbsolutePath(), arrayList);
            if (strC != null) {
                com.frame.l1.e(new Runnable() { // from class: com.v.am
                    @Override // java.lang.Runnable
                    public final void run() throws JSONException {
                        TaskChooseDialogView.J(strC);
                    }
                });
                return;
            }
            if (!file.exists()) {
                FloatToast.i("脚本下载失败");
                return;
            }
            try {
                new i.b.f8().b(file.getAbsolutePath(), l2, new Runnable() { // from class: com.v.hn
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.frame.l1.e(new Runnable() { // from class: com.v.gn
                            @Override // java.lang.Runnable
                            public final void run() {
                                TaskChooseDialogView.K();
                            }
                        });
                    }
                });
            } catch (Exception e) {
                showImportZipError(e);
            }
        } catch (Exception e2) {
            showImportZipError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(ItemChooseDialogView itemChooseDialogView, int i2, List list) {
        if (this.sorter == i2) {
            this.sorter = -i2;
        } else {
            this.sorter = i2;
        }
        update();
        com.frame.v0.f().edit().putInt("taskSort", this.sorter).apply();
        itemChooseDialogView.setDefaultData(this.sorter);
        com.frame.s0.g().d(ItemChooseDialogView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean P(String str) throws NumberFormatException {
        try {
            final Long lValueOf = Long.valueOf(str.split("#")[1]);
            com.frame.l1.g(new Runnable() { // from class: com.v.mm
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.N(lValueOf);
                }
            });
            return true;
        } catch (Exception unused) {
            FloatToast.i("请输入正确分享码");
            return false;
        }
    }

    static /* synthetic */ void O0(List list, Runnable runnable, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        for (int i2 = 0; i2 < list.size(); i2++) {
            i.b.da.B().v1((TaskSimple) list.get(i2));
        }
        if (runnable != null) {
            runnable.run();
        }
        com.yl.ui.i0.i("remove.json", 2000L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q0(List list) {
        this.mAdapter.setNewData(list);
    }

    static /* synthetic */ void Q() {
        com.yl.ui.i0.l(null);
        com.frame.s0.g().d(TaskChooseDialogView.class);
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0() {
        final List<TaskSimple> listD = i.b.da.B().D(this.groupType, this.sorter);
        com.frame.l1.e(new Runnable() { // from class: com.v.yn
            @Override // java.lang.Runnable
            public final void run() {
                this.c.Q0(listD);
            }
        });
    }

    static /* synthetic */ void S(File file) {
        try {
            new i.b.f8().d(file.getAbsolutePath(), new Runnable() { // from class: com.v.nl
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.l1.e(new Runnable() { // from class: com.v.nn
                        @Override // java.lang.Runnable
                        public final void run() {
                            TaskChooseDialogView.Q();
                        }
                    });
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
            FloatToast.i("导入出错，请确认是否是脚本文件");
        }
    }

    static /* synthetic */ void U(View view) {
        com.frame.s0.g().d(InputDialogView.class);
        ((FileChooseView) com.frame.s0.g().B(FileChooseView.class)).setCallback(new FileChooseView.b() { // from class: com.v.um
            @Override // com.v.FileChooseView.b
            public final void a(File file) {
                com.frame.l1.g(new Runnable() { // from class: com.v.tl
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskChooseDialogView.S(file);
                    }
                });
            }
        });
        FloatToast.i("请选择脚本文件");
    }

    static /* synthetic */ void W(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.yl.ui.i0.l(null);
        com.frame.y0.b().r(true);
        if (com.frame.s0.g().m(SimpleLogView.class)) {
            com.frame.s0.g().d(SimpleLogView.class);
        } else {
            SimpleLogView.P().R(com.frame.y0.b().a());
        }
    }

    static /* synthetic */ void X(long j2, Node node) {
        node.id = System.currentTimeMillis();
        node.arg2 = "0";
        node.nextType = 4;
        node.nextId = j2;
        node.errorType = 2;
        node.errorId = 0L;
        i.b.k8.d().a(node);
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void Y(Task task, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.n0.j("unlockAuto", task.getId());
        com.yl.ui.i0.l(null);
    }

    static /* synthetic */ void a0(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.n0.j("unlockAuto", 0L);
        com.yl.ui.i0.l(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(final Task task, int i2, List list) {
        final long id = task.getId();
        if (i2 == 0) {
            showAutoNotifyDialog(id);
            return;
        }
        if (i2 == 1) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            showRestPhoneAutoTask(task);
            return;
        }
        if (i2 == 2) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            PageScanFloatView pageScanFloatView = (PageScanFloatView) com.frame.s0.g().x(PageScanFloatView.class);
            pageScanFloatView.setNeedScanTextIfHash(true);
            pageScanFloatView.d(null);
            pageScanFloatView.setNodeCallback(new lt() { // from class: com.v.vm
                @Override // com.v.lt
                public final void a(Node node) {
                    TaskChooseDialogView.X(id, node);
                }
            });
            return;
        }
        if (i2 != 3) {
            return;
        }
        com.frame.s0.g().d(ItemChooseDialogView.class);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("是否需要在解锁手机时触发「<font color='#55CA9B'>%s</font>」脚本？", task.getName()));
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.om
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.Y(task, view);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.sl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
        if (com.frame.n0.d("unlockAuto", 0L) != 0) {
            TextView textView = new TextView(com.frame.v0.g());
            textView.setTextColor(Color.parseColor("#999999"));
            textView.setText("取消原有的解锁触发脚本");
            textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(15.0f), 0, com.frame.p1.c(5.0f));
            textView.setTextSize(12.0f);
            textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
            textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.J0, 0, 0, 0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.pl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskChooseDialogView.a0(view);
                }
            });
            dingMsgView.m(textView);
        }
    }

    private static void closeTaskMenuDialog() {
        com.frame.s0.g().d(TaskMenuDialogView.class);
        com.frame.s0.g().d(ItemChooseDialogView.class);
    }

    private View createHeaderView(final TaskSimple taskSimple, final Runnable runnable) {
        final View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.a1, null);
        com.frame.l1.g(new Runnable() { // from class: com.v.zn
            @Override // java.lang.Runnable
            public final void run() {
                TaskChooseDialogView.j(taskSimple, viewInflate);
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.n6);
        textView.setText(taskSimple.getName());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.xm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.o(taskSimple, runnable, view);
            }
        });
        final TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.r6);
        final TextView textView3 = (TextView) viewInflate.findViewById(j.b.e.q6);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.v.dm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.q(taskSimple, textView3, textView2, view);
            }
        };
        textView2.setText("循环间隔：" + taskSimple.getRepeatDelay() + "ms");
        textView2.setOnClickListener(onClickListener);
        textView3.setText("循环次数：" + taskSimple.getRepeatCount());
        textView3.setOnClickListener(onClickListener);
        return viewInflate;
    }

    static /* synthetic */ void d0(View view) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        com.frame.s0.g().d(ItemChooseDialogView.class);
        com.frame.s0.g().d(DingMsgView.class);
        com.permission.x0.m().h();
    }

    static /* synthetic */ void e0(boolean z, AutoNotify autoNotify) {
        if (z) {
            try {
                i.b.l7.b().c().add(autoNotify);
            } catch (Exception e) {
                com.frame.k0.r(e);
                return;
            }
        }
        i.b.l7.b().d();
        com.yl.ui.i0.j();
    }

    static /* synthetic */ void f0(FloatButtonConfig floatButtonConfig, View view) {
        i.b.w7.g().q(floatButtonConfig);
        com.frame.s0.g().d(DingMsgView.class);
    }

    public static int getH() {
        return com.frame.n0.c("tcd_h", com.frame.p1.c(400.0f));
    }

    public static int getW() {
        return com.frame.n0.c("tcd_w", com.frame.p1.c(320.0f));
    }

    static /* synthetic */ void h0(TaskSimple taskSimple, FloatButtonConfig floatButtonConfig, View view) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        closeTaskMenuDialog();
        com.frame.s0.g().d(DingMsgView.class);
        if (i.b.da.B().L(taskSimple.getId()) == null) {
            FloatToast.i("未找到任务~");
            return;
        }
        floatButtonConfig.taskId = taskSimple.getId();
        floatButtonConfig.id = System.currentTimeMillis();
        FloatButtonConfigDialogView floatButtonConfigDialogView = (FloatButtonConfigDialogView) com.frame.s0.g().B(FloatButtonConfigDialogView.class);
        floatButtonConfigDialogView.i(floatButtonConfig);
        floatButtonConfigDialogView.j(new FloatButtonConfigDialogView.c() { // from class: com.v.tm
            @Override // com.v.FloatButtonConfigDialogView.c
            public final void a(FloatButtonConfig floatButtonConfig2) {
                i.b.w7.g().a(floatButtonConfig2);
            }
        });
    }

    private void init() {
        this.sorter = com.frame.v0.f().getInt("taskSort", 0);
        View.inflate(com.frame.v0.g(), j.b.f.z, this);
        this.lySearch = findViewById(j.b.e.i4);
        this.edtName = (EditText) findViewById(j.b.e.I1);
        Button button = (Button) findViewById(j.b.e.M);
        this.btnSearch = button;
        button.setOnTouchListener(this.mSubTouchListener);
        this.btnSearch.setOnClickListener(this);
        ((TextView) findViewById(j.b.e.w6)).setOnTouchListener(this.mSubTouchListener);
        this.mAdapter = new MultiTaskSimpleAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        if (com.frame.k0.c().e() > com.frame.k0.c().d()) {
            recyclerView.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(com.frame.v0.g()));
        }
        recyclerView.setAdapter(this.mAdapter);
        View viewFindViewById = findViewById(j.b.e.u0);
        viewFindViewById.setOnClickListener(this);
        viewFindViewById.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById2 = findViewById(j.b.e.m0);
        viewFindViewById2.setOnClickListener(this);
        viewFindViewById2.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById3 = findViewById(j.b.e.u);
        viewFindViewById3.setOnClickListener(this);
        viewFindViewById3.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById4 = findViewById(j.b.e.N);
        viewFindViewById4.setOnClickListener(this);
        viewFindViewById4.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById5 = findViewById(j.b.e.v0);
        viewFindViewById5.setOnClickListener(this);
        viewFindViewById5.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById6 = findViewById(j.b.e.n0);
        viewFindViewById6.setOnClickListener(this);
        viewFindViewById6.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById7 = findViewById(j.b.e.P);
        viewFindViewById7.setOnClickListener(this);
        viewFindViewById7.setOnTouchListener(this.mSubTouchListener);
        View viewFindViewById8 = findViewById(j.b.e.h0);
        viewFindViewById8.setOnClickListener(this);
        viewFindViewById8.setOnTouchListener(this.mSubTouchListener);
        findViewById(j.b.e.g).setVisibility(8);
        TextView textView = (TextView) findViewById(j.b.e.i0);
        textView.setVisibility(0);
        textView.setText("执行日志");
        textView.setOnClickListener(this);
        this.mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.v.wl
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.v(baseQuickAdapter, view, i2);
            }
        });
        this.mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.zl
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.x(baseQuickAdapter, view, i2);
            }
        });
        this.mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.v.im
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                return this.c.A(baseQuickAdapter, view, i2);
            }
        });
        View viewFindViewById9 = findViewById(j.b.e.Q0);
        View viewFindViewById10 = findViewById(j.b.e.R0);
        i.b.y8 y8Var = new i.b.y8();
        y8Var.b(this, viewFindViewById9, new Runnable() { // from class: com.v.et
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
        y8Var.a(this, viewFindViewById10, new Runnable() { // from class: com.v.et
            @Override // java.lang.Runnable
            public final void run() {
                this.c.endResize();
            }
        });
    }

    static /* synthetic */ void j(TaskSimple taskSimple, View view) {
        try {
            PackageManager packageManager = com.frame.v0.g().getPackageManager();
            final Drawable drawableLoadIcon = packageManager.getApplicationInfo(taskSimple.getPn(), 128).loadIcon(packageManager);
            final ImageView imageView = (ImageView) view.findViewById(j.b.e.G3);
            com.frame.l1.e(new Runnable() { // from class: com.v.qn
                @Override // java.lang.Runnable
                public final void run() {
                    imageView.setImageDrawable(drawableLoadIcon);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void k0(TaskSimple taskSimple, View view) {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        closeTaskMenuDialog();
        com.frame.s0.g().d(DingMsgView.class);
        FloatButtonConfig floatButtonConfig = new FloatButtonConfig();
        floatButtonConfig.taskId = taskSimple.getId();
        floatButtonConfig.id = System.currentTimeMillis();
        floatButtonConfig.radius = 30;
        floatButtonConfig.alpha = 0.6f;
        floatButtonConfig.x = com.frame.p1.c(100.0f);
        floatButtonConfig.y = com.frame.p1.c(200.0f);
        FloatButtonConfigDialogView floatButtonConfigDialogView = (FloatButtonConfigDialogView) com.frame.s0.g().B(FloatButtonConfigDialogView.class);
        floatButtonConfigDialogView.i(floatButtonConfig);
        floatButtonConfigDialogView.j(new FloatButtonConfigDialogView.c() { // from class: com.v.ol
            @Override // com.v.FloatButtonConfigDialogView.c
            public final void a(FloatButtonConfig floatButtonConfig2) {
                i.b.w7.g().a(floatButtonConfig2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean m(TaskSimple taskSimple, Runnable runnable, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!i.b.da.B().R(str)) {
            Task taskL = i.b.da.B().L(taskSimple.getId());
            taskL.setName(str);
            i.b.da.B().R1(taskL);
            this.mAdapter.notifyDataSetChanged();
            if (runnable == null) {
                return true;
            }
            runnable.run();
            return true;
        }
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h("任务名请不要重复~~~");
            dingMsgView.l("温馨提示");
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.kn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
            dingMsgView.l("温馨提示");
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        return false;
    }

    static /* synthetic */ void l0(TaskSimple taskSimple, Runnable runnable, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.s0.g().d(NodeListDialogView.class);
        i.b.da.B().v1(taskSimple);
        if (runnable != null) {
            runnable.run();
        }
        com.yl.ui.i0.i("remove.json", 2000L, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0() {
        this.mAdapter.setNewData(i.b.da.B().D(null, this.sorter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(final TaskSimple taskSimple, final Runnable runnable, View view) {
        closeTaskMenuDialog();
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("任务名称");
        inputDialogView.s("请输入任务名称");
        inputDialogView.w(taskSimple.getName());
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.ql
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.m(taskSimple, runnable, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(String str) {
        for (TaskSimple taskSimple : i.b.da.B().D(str, this.sorter)) {
            taskSimple.setGroup(null);
            taskSimple.setLevel(0);
            Task taskL = i.b.da.B().L(taskSimple.getId());
            taskL.setGroup(null);
            i.b.da.B().R1(taskL);
        }
        setGroupType(null);
        i.b.da.B().P1();
        com.frame.l1.e(new Runnable() { // from class: com.v.wn
            @Override // java.lang.Runnable
            public final void run() {
                this.c.n0();
            }
        });
    }

    static /* synthetic */ void p(TextView textView, TaskSimple taskSimple, TextView textView2, String str) {
        textView.setText("循环次数：" + taskSimple.getRepeatCount());
        textView2.setText("循环间隔：" + taskSimple.getRepeatDelay());
    }

    static /* synthetic */ void q(final TaskSimple taskSimple, final TextView textView, final TextView textView2, View view) {
        Task taskL = i.b.da.B().L(taskSimple.getId());
        LooperCountDurationDialogView looperCountDurationDialogView = (LooperCountDurationDialogView) com.frame.s0.g().B(LooperCountDurationDialogView.class);
        looperCountDurationDialogView.setTask(taskL);
        looperCountDurationDialogView.y(new LooperCountDurationDialogView.a() { // from class: com.v.in
            @Override // com.v.LooperCountDurationDialogView.a
            public final void a(String str) {
                TaskChooseDialogView.p(textView, taskSimple, textView2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(final String str, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        com.frame.l1.g(new Runnable() { // from class: com.v.wm
            @Override // java.lang.Runnable
            public final void run() {
                this.c.p0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(View view) {
        com.frame.s0.g().d(DingMsgView.class);
        i.b.da.B().U1(0L);
        this.mAdapter.l(0L);
        this.mAdapter.notifyDataSetChanged();
    }

    static /* synthetic */ void s0(FlowLayout flowLayout, InputDialogView inputDialogView, TaskSimple taskSimple, View view) {
        if (flowLayout.getTag() != null) {
            ((View) flowLayout.getTag()).setSelected(false);
        }
        flowLayout.setTag(view);
        view.setSelected(true);
        inputDialogView.w(taskSimple.getGroup());
    }

    public static TaskChooseDialogView show() {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        return (TaskChooseDialogView) com.frame.s0.g().y(TaskChooseDialogView.class, com.frame.n0.c("tcd_x", iE), com.frame.n0.c("tcd_y", iD), w, h2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showMenu(int i2) {
        showMenu((TaskSimple) this.mAdapter.getItem(i2), new Runnable() { // from class: com.v.mn
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.s0.g().u(TaskChooseDialogView.class);
            }
        });
        com.frame.s0.g().i(TaskChooseDialogView.class);
    }

    private void showRestPhoneAutoTask(final Task task) {
        Task taskL;
        String str = String.format("是否设置手机重启后，执行【%s】任务，注意：手机重启后，需要手动解锁手机后才能执行【重启后的任务】，并可能存在一定延迟。", task.getName());
        if (i.b.da.B().J() != 0 && (taskL = i.b.da.B().L(i.b.da.B().J())) != null) {
            str = String.format("您之前已经设置过了重启后执行的任务:【%s】，是否换成执行【%s】任务，注意：手机重启后，需要手动解锁手机后才能执行【重启后的任务】，并可能存在一定延迟。", taskL.getName(), task.getName());
        }
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("温馨提示");
        dingMsgView.h(str);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.jm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.L0(task, view);
            }
        });
        dingMsgView.i("取消", null);
    }

    static /* synthetic */ boolean t0(TaskSimple taskSimple, Runnable runnable, String str) {
        closeTaskMenuDialog();
        if (TextUtils.isEmpty(str)) {
            taskSimple.setGroup(null);
            Task taskL = i.b.da.B().L(taskSimple.getId());
            taskL.setGroup(null);
            i.b.da.B().z1(taskL);
        } else {
            taskSimple.setGroup(str);
            Task taskL2 = i.b.da.B().L(taskSimple.getId());
            taskL2.setGroup(str);
            i.b.da.B().z1(taskL2);
        }
        i.b.da.B().P1();
        runnable.run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        long id = ((TaskSimple) this.mAdapter.getItem(i2)).getId();
        int id2 = view.getId();
        if (id2 == j.b.e.q0) {
            if (((TaskSimple) this.mAdapter.getItem(i2)).isExpanded()) {
                this.mAdapter.collapse(i2);
                return;
            } else {
                this.mAdapter.expand(i2);
                return;
            }
        }
        if (id2 == j.b.e.n0) {
            showCreateFloatButtonDialog((TaskSimple) this.mAdapter.getItem(i2));
            return;
        }
        if (id2 == j.b.e.Z) {
            com.frame.s0.g().d(ItemChooseDialogView.class);
            ((AlarmTaskDialogView) com.frame.s0.g().y(AlarmTaskDialogView.class, 0, 0, -1, -1)).setTaskId(id);
        } else {
            if (id2 == j.b.e.c0) {
                showAutoNotifyDialog(id);
                return;
            }
            if (id2 == j.b.e.P0) {
                DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView.h("是否取消重启手机启动触发功能？");
                dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.dn
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.xn
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.c.t(view2);
                    }
                });
                dingMsgView.l("温馨提示");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v0(TaskSimple taskSimple, Runnable runnable, ItemChooseDialogView itemChooseDialogView, int i2, List list) {
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (i2 == 0) {
            showGroupTasks(taskSimple.getName(), null);
        } else if (i2 == 1) {
            showGroupRenameAlert(taskSimple.getName(), runnable);
        } else if (i2 == 2) {
            showDisgroupAlert(taskSimple.getName());
        } else if (i2 == 3) {
            exportGroupTask(taskSimple.getName());
        } else if (i2 == 4) {
            showTasksByGroupNameAlert(taskSimple.getName(), runnable);
        }
        itemChooseDialogView.setDefaultData(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskSimple taskSimpleW;
        TaskSimple taskSimple = (TaskSimple) this.mAdapter.getItem(i2);
        if (!"group".equals(taskSimple.getPn())) {
            b bVar = this.mOnChooseListener;
            if (bVar != null) {
                bVar.a((TaskSimple) this.mAdapter.getItem(i2));
                com.frame.s0.g().d(TaskChooseDialogView.class);
                return;
            } else if (com.frame.n0.c("listClick", 0) == 0) {
                showMenu(i2);
                return;
            } else {
                showNodeListView(taskSimple);
                return;
            }
        }
        if (taskSimple.getDefaultTaskId() == 0 || (taskSimpleW = i.b.da.B().w(taskSimple.getDefaultTaskId())) == null) {
            if (((TaskSimple) this.mAdapter.getItem(i2)).isExpanded()) {
                this.mAdapter.collapse(i2);
                return;
            } else {
                this.mAdapter.expand(i2);
                return;
            }
        }
        b bVar2 = this.mOnChooseListener;
        if (bVar2 != null) {
            bVar2.a(taskSimpleW);
            com.frame.s0.g().d(TaskChooseDialogView.class);
        } else if (((TaskSimple) this.mAdapter.getItem(i2)).isExpanded()) {
            this.mAdapter.collapse(i2);
        } else {
            this.mAdapter.expand(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x0(Runnable runnable) {
        this.mAdapter.setNewData(i.b.da.B().D(null, this.sorter));
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(String str, String str2, final Runnable runnable) {
        for (TaskSimple taskSimple : i.b.da.B().D(str, this.sorter)) {
            Task taskL = i.b.da.B().L(taskSimple.getId());
            taskL.setGroup(str2);
            i.b.da.B().z1(taskL);
            taskSimple.setGroup(str2);
            if (taskSimple.getName().equals(str)) {
                taskSimple.setName(str2);
            }
        }
        i.b.da.B().P1();
        com.frame.l1.e(new Runnable() { // from class: com.v.jn
            @Override // java.lang.Runnable
            public final void run() {
                this.c.x0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean A(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskSimple taskSimpleW;
        TaskSimple taskSimple = (TaskSimple) this.mAdapter.getItem(i2);
        if (!"group".equals(taskSimple.getPn())) {
            Task taskL = i.b.da.B().L(taskSimple.getId());
            if (taskL == null) {
                try {
                    DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                    dingMsgView.l("温馨提醒");
                    dingMsgView.h("未找到任务，请重启手机试一试");
                    dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.v.em
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            com.frame.s0.g().d(DingMsgView.class);
                        }
                    });
                    return false;
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
            if (i.b.da.q || taskL.isCanNotShare() || com.frame.n0.c("listClick", 0) != 0) {
                showMenu(i2);
            } else {
                showNodeListView(taskSimple);
            }
        } else {
            if (taskSimple.getDefaultTaskId() != 0 && (taskSimpleW = i.b.da.B().w(taskSimple.getDefaultTaskId())) != null) {
                showGroupTaskMenu(taskSimpleW, it.c);
                com.frame.s0.g().i(TaskChooseDialogView.class);
                return true;
            }
            showGroupMenu(taskSimple, it.c);
        }
        return true;
    }

    public void endResize() {
        endMove(true);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        com.frame.n0.i("tcd_x", layoutParams.x);
        com.frame.n0.i("tcd_y", layoutParams.y);
        com.frame.n0.i("tcd_w", layoutParams.width);
        com.frame.n0.i("tcd_h", layoutParams.height);
    }

    public void exportGroupTask(String str) {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ExportAct.class);
        intent.putExtra("group", str);
        com.frame.v0.g().startActivity(intent);
        com.frame.s0.g().d(ItemChooseDialogView.class);
        com.frame.s0.g().d(TaskChooseDialogView.class);
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public Point loadXY() {
        int w = getW();
        int h2 = getH();
        return new Point(com.frame.n0.c("tcd_x", (com.frame.q1.e() - w) / 2), com.frame.n0.c("tcd_y", (com.frame.q1.d() - h2) / 2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.N) {
            showSorterDialog();
            return;
        }
        if (id == j.b.e.u) {
            if (this.lySearch.getVisibility() != 0) {
                this.lySearch.setVisibility(0);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                if (Build.VERSION.SDK_INT >= 19) {
                    layoutParams.flags = 201328160;
                } else {
                    layoutParams.flags = 544;
                }
                com.frame.s0.g().I(this, layoutParams);
                post(new Runnable() { // from class: com.v.cn
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.E();
                    }
                });
                return;
            }
            this.lySearch.setVisibility(8);
            this.btnSearch.setText("搜索");
            update();
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
            if (Build.VERSION.SDK_INT >= 19) {
                layoutParams2.flags = 201328160;
            } else {
                layoutParams2.flags = 544;
            }
            com.frame.s0.g().I(this, layoutParams2);
            post(new Runnable() { // from class: com.v.un
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.C();
                }
            });
            return;
        }
        if (id == j.b.e.M) {
            if (this.btnSearch.getText().toString().equals("搜索")) {
                this.btnSearch.setText("取消");
                this.mAdapter.setNewData(i.b.da.B().T1(String.valueOf(this.edtName.getText())));
                return;
            } else {
                this.edtName.setText((CharSequence) null);
                this.btnSearch.setText("搜索");
                update();
                return;
            }
        }
        if (id == j.b.e.P || id == j.b.e.h0) {
            com.frame.s0.g().d(TaskChooseDialogView.class);
            return;
        }
        if (id == j.b.e.u0) {
            com.frame.s0.g().d(TaskChooseDialogView.class);
            ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
            imageBoxSelectDialogView.b();
            imageBoxSelectDialogView.setOnImageBoxChoose(new a(this));
            imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: com.v.vn
                @Override // java.lang.Runnable
                public final void run() {
                    com.frame.s0.g().u(FloatHandler.class);
                }
            });
            return;
        }
        if (id == j.b.e.m0) {
            com.frame.s0.g().d(TaskChooseDialogView.class);
            nt.p();
            return;
        }
        if (id == j.b.e.n0) {
            return;
        }
        if (id != j.b.e.v0) {
            if (id != j.b.e.g && id == j.b.e.i0) {
                if (com.frame.y0.b().f()) {
                    if (com.frame.s0.g().m(SimpleLogView.class)) {
                        com.frame.s0.g().d(SimpleLogView.class);
                        return;
                    } else {
                        com.frame.s0.g().d(TaskChooseDialogView.class);
                        SimpleLogView.P().R(com.frame.y0.b().a());
                        return;
                    }
                }
                DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView.h("调试模式未开启，没有记录执行日志，请先开启调试模式后在查看执行日志。在调试脚本正常后，请关闭调试模式，避免是执行操作变得卡顿。");
                dingMsgView.i("取消", new View.OnClickListener() { // from class: com.v.ln
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.k("开启调试模式", new View.OnClickListener() { // from class: com.v.km
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        TaskChooseDialogView.W(view2);
                    }
                });
                dingMsgView.l("温馨提示");
                return;
            }
            return;
        }
        if (!AccountTool.d().j()) {
            FloatToast.i("请先登录");
            view.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
            return;
        }
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.s("请输入脚本分享码");
        inputDialogView.l("导入分享");
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.on
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return this.a.P(str);
            }
        });
        FlowLayout flowLayout = new FlowLayout(com.frame.v0.g());
        flowLayout.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(8.0f), com.frame.p1.c(20.0f), 0);
        flowLayout.setHorizontalSpacing(com.frame.p1.c(5.0f));
        flowLayout.setVerticalSpacing(com.frame.p1.c(10.0f));
        inputDialogView.a(flowLayout);
        TextView textView = new TextView(com.frame.v0.g());
        textView.setText("本地导入");
        int iC = com.frame.p1.c(6.0f);
        int i2 = iC / 2;
        textView.setPadding(iC, i2, iC, i2);
        textView.setTextSize(10.0f);
        textView.setBackgroundResource(j.b.d.D0);
        textView.setTextColor(com.frame.v0.g().getColor(j.b.c.f));
        flowLayout.addView(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.fm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskChooseDialogView.U(view2);
            }
        });
        TextView textView2 = new TextView(com.frame.v0.g());
        int iC2 = com.frame.p1.c(25.0f);
        textView2.setPadding(iC2, com.frame.p1.c(10.0f), iC2, 0);
        textView2.setTextSize(12.0f);
        textView2.setText(Html.fromHtml("分享码的脚本非官方出品，是由其他用户制作，如有问题请咨询分享码出处，<strong><font color='#F45075'>严禁</font></strong>使用APP制作<strong><font color='#F45075'>作弊器、外挂、刷屏、刷单</font></strong>等损害其他平台利益的行为。"));
        inputDialogView.a(textView2);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            update();
        }
    }

    @Override // com.yl.float_ui.CanDragFloatView
    public void saveXY(Point point) {
        com.frame.n0.i("tcd_x", point.x);
        com.frame.n0.i("tcd_y", point.y);
    }

    public void setGroupType(String str) {
        this.groupType = str;
    }

    public void setOnChooseListener(b bVar) {
        this.mOnChooseListener = bVar;
    }

    public void showAlarmSetAlert(TaskSimple taskSimple) {
        closeTaskMenuDialog();
        ((AlarmTaskDialogView) com.frame.s0.g().y(AlarmTaskDialogView.class, 0, 0, -1, -1)).setTaskId(taskSimple.getId());
    }

    public void showAutoMenu(final Task task) {
        ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setTitle("选择触发条件");
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("消息触发,重启手机时触发,指定页面触发,解锁手机时触发".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.rl
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.c0(task, i2, list);
            }
        });
    }

    public void showAutoNotifyDialog(long j2) {
        if (!com.permission.x0.m().r()) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.l("温馨提示");
            dingMsgView.h("还未开启读取消息权限，无法通过消息触发任务，是否开启权限？");
            dingMsgView.k("立即开启", new View.OnClickListener() { // from class: com.v.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskChooseDialogView.d0(view);
                }
            });
            dingMsgView.i("取消", null);
            return;
        }
        com.frame.s0.g().d(ItemChooseDialogView.class);
        AutoNotifyConfigDialogView autoNotifyConfigDialogView = (AutoNotifyConfigDialogView) com.frame.s0.g().x(AutoNotifyConfigDialogView.class);
        final boolean z = false;
        AutoNotify autoNotifyA = i.b.l7.b().a(j2);
        if (autoNotifyA == null) {
            z = true;
            autoNotifyA = new AutoNotify();
            autoNotifyA.taskId = j2;
        }
        autoNotifyConfigDialogView.q(autoNotifyA);
        autoNotifyConfigDialogView.r(new AutoNotifyConfigDialogView.a() { // from class: com.v.bn
            @Override // com.v.AutoNotifyConfigDialogView.a
            public final void a(AutoNotify autoNotify) {
                TaskChooseDialogView.e0(z, autoNotify);
            }
        });
    }

    public void showAutoRunAlert(TaskSimple taskSimple) {
        closeTaskMenuDialog();
        showAutoMenu(i.b.da.B().L(taskSimple.getId()));
    }

    public void showCopyAlert(TaskSimple taskSimple, Runnable runnable) {
        closeTaskMenuDialog();
        try {
            Task taskL = i.b.da.B().L(taskSimple.getId());
            Task task = (Task) new Gson().j(taskL.toJson().toString(), Task.class);
            task.setName(task.getName() + "(副本)");
            task.setId(System.currentTimeMillis());
            i.b.s8.b(taskL, task);
            i.b.da.B().R1(task);
            if (runnable != null) {
                runnable.run();
            }
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    public void showCreateFloatButtonDialog(final TaskSimple taskSimple) {
        final FloatButtonConfig floatButtonConfigF = i.b.w7.g().f(taskSimple.getId());
        if (floatButtonConfigF != null) {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.h(String.format("屏幕上已经显示了「%s」任务的悬浮快捷键是否继续编辑或删除？", taskSimple.getName()));
            dingMsgView.i("删除", new View.OnClickListener() { // from class: com.v.qm
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskChooseDialogView.f0(floatButtonConfigF, view);
                }
            });
            dingMsgView.k("编辑", new View.OnClickListener() { // from class: com.v.hm
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskChooseDialogView.h0(taskSimple, floatButtonConfigF, view);
                }
            });
            dingMsgView.l("温馨提示");
            return;
        }
        DingMsgView dingMsgView2 = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView2.h("是否要为此任务添加悬浮快捷键？");
        dingMsgView2.i("取消", new View.OnClickListener() { // from class: com.v.sn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView2.k("确定", new View.OnClickListener() { // from class: com.v.tn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.k0(taskSimple, view);
            }
        });
        dingMsgView2.l("温馨提示");
    }

    public void showDeleteAlert(final TaskSimple taskSimple, final Runnable runnable) {
        closeTaskMenuDialog();
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("是否确认删除「<font color='#F45075'>%s</font>」脚本？删除后将移入回收站，可在设置中还原。", taskSimple.getName()));
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.lm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.l0(taskSimple, runnable, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void showDisgroupAlert(final String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确定解散分组？");
        dingMsgView.l("温馨提示");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.cm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.r0(str, view);
            }
        });
        dingMsgView.i("取消", null);
    }

    public void showEditGroupName(final TaskSimple taskSimple, final Runnable runnable) {
        final InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("分组");
        inputDialogView.s("请输入分组名称");
        inputDialogView.w(taskSimple.getGroup());
        final FlowLayout flowLayout = new FlowLayout(com.frame.v0.g());
        flowLayout.setPadding(com.frame.p1.c(20.0f), 0, com.frame.p1.c(20.0f), 0);
        flowLayout.setHorizontalSpacing(com.frame.p1.c(5.0f));
        flowLayout.setVerticalSpacing(com.frame.p1.c(10.0f));
        ArrayList arrayList = new ArrayList();
        int iC = com.frame.p1.c(6.0f);
        int color = com.frame.v0.g().getColor(j.b.c.f);
        for (final TaskSimple taskSimple2 : i.b.da.B().C()) {
            if (!TextUtils.isEmpty(taskSimple2.getGroup()) && !arrayList.contains(taskSimple2.getGroup())) {
                TextView textView = new TextView(com.frame.v0.g());
                textView.setText(taskSimple2.getGroup());
                int i2 = iC / 2;
                textView.setPadding(iC, i2, iC, i2);
                textView.setTextSize(10.0f);
                textView.setBackgroundResource(j.b.d.D0);
                textView.setTextColor(color);
                flowLayout.addView(textView);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.bm
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TaskChooseDialogView.s0(flowLayout, inputDialogView, taskSimple2, view);
                    }
                });
                arrayList.add(taskSimple2.getGroup());
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.frame.p1.c(5.0f);
        inputDialogView.b(flowLayout, layoutParams);
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.ym
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return TaskChooseDialogView.t0(taskSimple, runnable, str);
            }
        });
    }

    public void showExportAlert(TaskSimple taskSimple) {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ExportAct.class);
        intent.putExtra("id", taskSimple.getId());
        com.frame.v0.g().startActivity(intent);
        closeTaskMenuDialog();
    }

    public void showFlowView(Task task) {
        closeTaskMenuDialog();
        int iK = (com.frame.q1.k() * 5) / 6;
        int i2 = (com.frame.q1.i() * 4) / 5;
        ((FlowView) com.frame.s0.g().y(FlowView.class, (com.frame.q1.k() - iK) / 2, (com.frame.q1.i() - i2) / 2, iK, i2)).setTask(task);
    }

    public void showGroupMenu(final TaskSimple taskSimple, final Runnable runnable) {
        if (taskSimple == null) {
            Toast.makeText(com.frame.v0.g(), "分组不存在，请先刷新列表", 0).show();
            return;
        }
        final ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("进入分组,重命名,解散分组,导出分享,删除分组".split(","))));
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.ul
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.v0(taskSimple, runnable, itemChooseDialogView, i2, list);
            }
        });
    }

    public void showGroupRenameAlert(final String str, final Runnable runnable) {
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("重命名分组");
        inputDialogView.s("请输入分组名称");
        inputDialogView.w(str);
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.pm
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str2) {
                return this.a.B0(str, runnable, str2);
            }
        });
    }

    public void showGroupTaskMenu(final TaskSimple taskSimple, final Runnable runnable) {
        final Task taskL = i.b.da.B().L(taskSimple.getId());
        if (taskL == null || !(taskL.isCanNotShare() || i.b.da.q)) {
            final ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
            itemChooseDialogView.c(createHeaderView(taskSimple, runnable));
            itemChooseDialogView.setDefaultData(-1, new ArrayList(Arrays.asList("流程列表,流程图,查看当前变量,预置参数,修改参数,定时执行,自动触发,悬浮按钮,复制任务,导出分享,查看子脚本,解散分组,重命名分组,删除分组".split(","))));
            itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.nm
                @Override // com.v.ItemChooseDialogView.b
                public final void a(int i2, List list) {
                    this.a.F0(taskSimple, taskL, runnable, itemChooseDialogView, i2, list);
                }
            });
            return;
        }
        final ItemChooseDialogView itemChooseDialogView2 = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        itemChooseDialogView2.c(createHeaderView(taskSimple, runnable));
        itemChooseDialogView2.setDefaultData(-1, new ArrayList(Arrays.asList("定时执行,自动触发,修改参数,悬浮按钮,删除".split(","))));
        itemChooseDialogView2.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.sm
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i2, List list) {
                this.a.D0(taskSimple, taskL, runnable, itemChooseDialogView2, i2, list);
            }
        });
    }

    public void showGroupTasks(String str, Runnable runnable) {
        setGroupType(str);
        this.mAdapter.setNewData(i.b.da.B().D(this.groupType, this.sorter));
        com.frame.s0.g().d(ItemChooseDialogView.class);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void showImportZipError(Exception exc) {
        com.frame.y0.l(exc);
        final String message = exc.getMessage();
        com.frame.l1.e(new Runnable() { // from class: com.v.zm
            @Override // java.lang.Runnable
            public final void run() {
                TaskChooseDialogView.H0(message);
            }
        });
    }

    public void showNodeListView(TaskSimple taskSimple) {
        closeTaskMenuDialog();
        final com.frame.s0 s0VarG = com.frame.s0.g();
        NodeListDialogView nodeListDialogViewH1 = NodeListDialogView.h1(taskSimple.getId());
        if (s0VarG.f(NodeListDialogView.class) != nodeListDialogViewH1) {
            return;
        }
        nodeListDialogViewH1.setBackAction(new Runnable() { // from class: com.v.gm
            @Override // java.lang.Runnable
            public final void run() {
                this.c.K0(s0VarG);
            }
        });
        s0VarG.j(this);
    }

    public void showSorterDialog() {
        final ItemChooseDialogView itemChooseDialogView = (ItemChooseDialogView) com.frame.s0.g().x(ItemChooseDialogView.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add("默认排序");
        int i2 = this.sorter;
        if (i2 == 1) {
            arrayList.add("按名字排序（降序）");
        } else if (i2 == -1) {
            arrayList.add("按名字排序（升序）");
        } else {
            arrayList.add("按名字排序");
        }
        itemChooseDialogView.setDefaultData(this.sorter, arrayList);
        itemChooseDialogView.setOnTextChoose(new ItemChooseDialogView.b() { // from class: com.v.pn
            @Override // com.v.ItemChooseDialogView.b
            public final void a(int i3, List list) {
                this.a.N0(itemChooseDialogView, i3, list);
            }
        });
    }

    public void showTasksByGroupNameAlert(String str, final Runnable runnable) {
        final List<TaskSimple> listD = i.b.da.B().D(str, this.sorter);
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h(String.format("是否确认删除「<font color='#F45075'>%s</font>」脚本，这个脚本包含「<font color='#F45075'>%d</font>」个子脚本，是否全部删除？删除后将移入回收站，可在设置中还原。", str, Integer.valueOf(listD.size())));
        dingMsgView.i("取消", null);
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.v.xl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskChooseDialogView.O0(listD, runnable, view);
            }
        });
        dingMsgView.l("温馨提示");
    }

    public void update() {
        this.mAdapter.l(i.b.da.B().J());
        com.frame.l1.g(new Runnable() { // from class: com.v.vl
            @Override // java.lang.Runnable
            public final void run() {
                this.c.S0();
            }
        });
    }

    public TaskChooseDialogView(Context context) {
        this(context, null);
    }

    public TaskChooseDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sorter = 0;
        init();
    }

    public void showMenu(TaskSimple taskSimple, Runnable runnable) {
        TaskMenuDialogView.t(taskSimple, runnable);
    }

    public static TaskChooseDialogView show(b bVar) {
        int w = getW();
        int h2 = getH();
        int iE = (com.frame.q1.e() - w) / 2;
        int iD = (com.frame.q1.d() - h2) / 2;
        TaskChooseDialogView taskChooseDialogView = (TaskChooseDialogView) com.frame.s0.g().y(TaskChooseDialogView.class, com.frame.n0.c("tcd_x", iE), com.frame.n0.c("tcd_y", iD), w, h2);
        taskChooseDialogView.setOnChooseListener(bVar);
        return taskChooseDialogView;
    }
}
