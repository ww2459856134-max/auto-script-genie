package com.v;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adapter.TaskMenuGridAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.user.AccountTool;
import com.v.LooperCountDurationDialogView;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.InputDialogView;
import com.yl.model.Task;
import com.yl.model.TaskSimple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TaskMenuDialogView extends FrameLayout implements View.OnClickListener {

    /* renamed from: h, reason: collision with root package name */
    private static final Map<String, Integer> f1061h;
    private TaskMenuGridAdapter c;
    private TaskChooseDialogView d;
    private TaskSimple e;
    private Task f;
    private Runnable g;

    class a extends RecyclerView.n {
        final /* synthetic */ int a;

        a(TaskMenuDialogView taskMenuDialogView, int i2) {
            this.a = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            int i2 = this.a;
            rect.left = i2;
            rect.right = i2;
            rect.bottom = i2;
            rect.top = i2;
        }
    }

    static {
        HashMap map = new HashMap();
        f1061h = map;
        map.put("流程列表", Integer.valueOf(j.b.d.S));
        map.put("流程图", Integer.valueOf(j.b.d.N));
        int i2 = j.b.d.R;
        map.put("查看当前变量", Integer.valueOf(i2));
        int i3 = j.b.d.L;
        map.put("预置参数", Integer.valueOf(i3));
        map.put("修改参数", Integer.valueOf(i3));
        map.put("定时执行", Integer.valueOf(j.b.d.p0));
        map.put("自动触发", Integer.valueOf(j.b.d.Y));
        map.put("悬浮按钮", Integer.valueOf(j.b.d.x));
        map.put("复制任务", Integer.valueOf(j.b.d.C));
        map.put("导出分享", Integer.valueOf(i2));
        map.put("分组分类", Integer.valueOf(j.b.d.j0));
        map.put("删除", Integer.valueOf(j.b.d.J));
    }

    public TaskMenuDialogView() {
        this(com.frame.v0.g());
    }

    private void a(TaskSimple taskSimple, Task task, Runnable runnable) {
        this.e = taskSimple;
        this.f = task;
        this.g = runnable;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(j.b.e.w4);
        relativeLayout.removeAllViews();
        relativeLayout.addView(d(taskSimple, runnable));
        List<String> listB = b(task);
        ArrayList arrayList = new ArrayList();
        for (String str : listB) {
            arrayList.add(new TaskMenuGridAdapter.a(str, e(str)));
        }
        this.c.setNewData(arrayList);
    }

    private List<String> b(Task task) {
        return (task.isCanNotShare() || i.b.da.q) ? !task.isCanBackup() ? Arrays.asList("定时执行", "自动触发", "悬浮按钮", "预置参数", "修改参数", "删除") : Arrays.asList("流程列表", "流程图", "查看当前变量", "预置参数", "修改参数", "定时执行", "自动触发", "悬浮按钮", "删除") : Arrays.asList("流程列表", "流程图", "查看当前变量", "预置参数", "修改参数", "定时执行", "自动触发", "悬浮按钮", "复制任务", "导出分享", "分组分类", "删除");
    }

    private void c() {
        com.frame.s0.g().d(TaskMenuDialogView.class);
    }

    private View d(final TaskSimple taskSimple, final Runnable runnable) {
        final View viewInflate = View.inflate(com.frame.v0.g(), j.b.f.a1, null);
        com.frame.l1.g(new Runnable() { // from class: com.v.lo
            @Override // java.lang.Runnable
            public final void run() {
                TaskMenuDialogView.h(taskSimple, viewInflate);
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(j.b.e.n6);
        textView.setText(taskSimple.getName());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.v.no
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.l(taskSimple, runnable, view);
            }
        });
        final TextView textView2 = (TextView) viewInflate.findViewById(j.b.e.r6);
        final TextView textView3 = (TextView) viewInflate.findViewById(j.b.e.q6);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.v.mo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskMenuDialogView.n(taskSimple, textView3, textView2, view);
            }
        };
        textView2.setText("循环间隔：" + taskSimple.getRepeatDelay() + "ms");
        textView2.setOnClickListener(onClickListener);
        textView3.setText("循环次数：" + taskSimple.getRepeatCount());
        textView3.setOnClickListener(onClickListener);
        return viewInflate;
    }

    private int e(String str) {
        Integer num = f1061h.get(str);
        return num != null ? num.intValue() : j.b.d.S;
    }

    private void f() {
        View.inflate(com.frame.v0.g(), j.b.f.X, this);
        this.d = new TaskChooseDialogView();
        this.c = new TaskMenuGridAdapter(null);
        RecyclerView recyclerView = (RecyclerView) findViewById(j.b.e.O4);
        recyclerView.setLayoutManager(new GridLayoutManager(com.frame.v0.g(), 3));
        recyclerView.setAdapter(this.c);
        recyclerView.g(new a(this, com.frame.p1.c(4.0f)));
        this.c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.v.jo
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.c.p(baseQuickAdapter, view, i2);
            }
        });
        findViewById(j.b.e.P).setOnClickListener(this);
        findViewById(j.b.e.J).setOnClickListener(this);
    }

    static /* synthetic */ void h(TaskSimple taskSimple, View view) {
        try {
            PackageManager packageManager = com.frame.v0.g().getPackageManager();
            final Drawable drawableLoadIcon = packageManager.getApplicationInfo(taskSimple.getPn(), 128).loadIcon(packageManager);
            final ImageView imageView = (ImageView) view.findViewById(j.b.e.G3);
            com.frame.l1.e(new Runnable() { // from class: com.v.io
                @Override // java.lang.Runnable
                public final void run() {
                    imageView.setImageDrawable(drawableLoadIcon);
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ boolean j(TaskSimple taskSimple, Runnable runnable, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!i.b.da.B().R(str)) {
            Task taskL = i.b.da.B().L(taskSimple.getId());
            taskL.setName(str);
            i.b.da.B().R1(taskL);
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
            dingMsgView.k("知道了", new View.OnClickListener() { // from class: com.v.oo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.frame.s0.g().d(DingMsgView.class);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(final TaskSimple taskSimple, final Runnable runnable, View view) {
        c();
        InputDialogView inputDialogView = (InputDialogView) com.frame.s0.g().B(InputDialogView.class);
        inputDialogView.v(1);
        inputDialogView.l("任务名称");
        inputDialogView.s("请输入任务名称");
        inputDialogView.w(taskSimple.getName());
        inputDialogView.t(new InputDialogView.a() { // from class: com.v.go
            @Override // com.yl.float_ui.InputDialogView.a
            public final boolean a(String str) {
                return TaskMenuDialogView.j(taskSimple, runnable, str);
            }
        });
    }

    static /* synthetic */ void m(TextView textView, TaskSimple taskSimple, TextView textView2, String str) {
        textView.setText("循环次数：" + taskSimple.getRepeatCount());
        textView2.setText("循环间隔：" + taskSimple.getRepeatDelay());
    }

    static /* synthetic */ void n(final TaskSimple taskSimple, final TextView textView, final TextView textView2, View view) {
        Task taskL = i.b.da.B().L(taskSimple.getId());
        LooperCountDurationDialogView looperCountDurationDialogView = (LooperCountDurationDialogView) com.frame.s0.g().B(LooperCountDurationDialogView.class);
        looperCountDurationDialogView.setTask(taskL);
        looperCountDurationDialogView.y(new LooperCountDurationDialogView.a() { // from class: com.v.ko
            @Override // com.v.LooperCountDurationDialogView.a
            public final void a(String str) {
                TaskMenuDialogView.m(textView, taskSimple, textView2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        TaskMenuGridAdapter.a item = this.c.getItem(i2);
        if (item != null) {
            r(item.a);
        }
    }

    private void r(String str) {
        str.hashCode();
        switch (str) {
            case "删除":
                this.d.showDeleteAlert(this.e, this.g);
                break;
            case "流程图":
                this.d.showFlowView(this.f);
                break;
            case "查看当前变量":
                com.frame.s0.g().x(ParamsCurrentListDialogView.class);
                break;
            case "修改参数":
                if (!TextUtils.isEmpty(this.f.getArgumentJson())) {
                    c();
                    ((ArgumentSetDialogView) com.frame.s0.g().B(ArgumentSetDialogView.class)).setTask(this.f);
                    break;
                } else {
                    FloatToast.i("没有预置的参数");
                    break;
                }
            case "分组分类":
                this.d.showEditGroupName(this.e, this.g);
                break;
            case "复制任务":
                this.d.showCopyAlert(this.e, this.g);
                break;
            case "导出分享":
                this.d.showExportAlert(this.e);
                break;
            case "定时执行":
                this.d.showAlarmSetAlert(this.e);
                break;
            case "悬浮按钮":
                this.d.showCreateFloatButtonDialog(this.e);
                break;
            case "流程列表":
                this.d.showNodeListView(this.e);
                break;
            case "自动触发":
                this.d.showAutoRunAlert(this.e);
                break;
            case "预置参数":
                c();
                ((ArgumentDialogView) com.frame.s0.g().x(ArgumentDialogView.class)).setTask(this.f);
                break;
        }
    }

    private void s() {
        Task task = this.f;
        if (task == null) {
            return;
        }
        if (task.getNodeMap() == null || this.f.getNodeMap().isEmpty()) {
            FloatToast.i("节点空");
            return;
        }
        if (!com.frame.w0.d() && (Build.VERSION.SDK_INT < 28 || !i.b.da.B().O())) {
            com.permission.x0.m().a();
            Toast.makeText(com.frame.v0.g(), "请先开启无障碍权限", 0).show();
            return;
        }
        i.b.ea eaVar = new i.b.ea();
        if (eaVar.d()) {
            if (!this.f.isNeedScan() || eaVar.c()) {
                c();
                com.frame.s0.g().d(TaskChooseDialogView.class);
                i.b.da.B().f();
                i.b.da.B().e2(this.f, true);
            }
        }
    }

    public static TaskMenuDialogView t(TaskSimple taskSimple, Runnable runnable) {
        if (taskSimple == null) {
            Toast.makeText(com.frame.v0.g(), "任务脚本不存在，请先刷新列表", 0).show();
            return null;
        }
        Task taskL = i.b.da.B().L(taskSimple.getId());
        if (taskL == null) {
            Toast.makeText(com.frame.v0.g(), "任务脚本不存在，请先刷新列表", 0).show();
            return null;
        }
        if (taskL.getCreateUserId() != null && taskL.getLimitUserId() != null) {
            if (!AccountTool.d().j()) {
                DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
                dingMsgView.h("请先登录，验证账号权限！");
                dingMsgView.i("知道了", new View.OnClickListener() { // from class: com.v.ho
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.frame.s0.g().d(DingMsgView.class);
                    }
                });
                dingMsgView.g(j.b.d.M0);
                dingMsgView.l("温馨提示");
                return null;
            }
            if (!AccountTool.d().k(taskL.getLimitUserId()) && !AccountTool.d().k(taskL.getCreateUserId())) {
                if (!com.frame.n0.f("subUserIds", "").contains(taskL.getCreateUserId() + "")) {
                    i.b.da.B().X1(taskL.getCreateUserId());
                    return null;
                }
            }
        }
        com.frame.s0.g().d(TaskMenuDialogView.class);
        TaskMenuDialogView taskMenuDialogView = (TaskMenuDialogView) com.frame.s0.g().x(TaskMenuDialogView.class);
        taskMenuDialogView.a(taskSimple, taskL, runnable);
        return taskMenuDialogView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == j.b.e.P) {
            c();
        } else if (id == j.b.e.J) {
            s();
        }
    }

    public TaskMenuDialogView(Context context) {
        this(context, null);
    }

    public TaskMenuDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }
}
