package com.jsj.autojs.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.cursor.R;
import com.v.TaskChooseDialogView;
import com.yl.model.Task;
import com.yl.model.TaskConfig;
import com.yl.model.TaskSimple;
import com.yl.ui.s;
import com.yl.ui.v;
import com.yl.widget.TabLinearLayout;
import i.b.da;

/* loaded from: classes.dex */
public class Ab27c48088c extends com.yl.ui.p implements View.OnClickListener {
    private TaskConfig P;
    private i.b.t7 Q;
    TextView U;
    TextView V;
    TextView W;

    class a implements View.OnClickListener {
        a(Ab27c48088c ab27c48088c) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == 2131297050) {
                com.frame.n0.i("listClick", 0);
            } else if (view.getId() == 2131297051) {
                com.frame.n0.i("listClick", 1);
            }
        }
    }

    private int k0(int i2) {
        return (int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(Task task) {
        this.U.setText(task.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(long j2) {
        final Task taskL = da.B().L(j2);
        if (taskL != null) {
            this.V.setSelected(true);
            findViewById(2131296949).setVisibility(0);
            com.frame.l1.e(new Runnable() { // from class: com.jsj.autojs.activity.k4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.m0(taskL);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean q0(Dialog dialog, String str) {
        try {
            if (Long.parseLong(str) > 120) {
                s.a aVar = new s.a(this);
                aVar.j("请不要超过两分钟，时间太长又起不到效果又有可能出错。");
                aVar.r("知道了", null);
                aVar.e().show();
                return false;
            }
            this.P.needResetOfferTimeByBrokenRun = Long.parseLong(str) * 1000;
            da.B().S1(this.P);
            this.W.setText(str);
            dialog.cancel();
            return true;
        } catch (Exception e) {
            Y("请输入整数（秒）");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(TaskSimple taskSimple) {
        if (taskSimple == null) {
            Y("选择任务失败，请重试");
            return;
        }
        i.b.i7.p().J(Long.valueOf(taskSimple.getId()));
        Task taskL = da.B().L(taskSimple.getId());
        if (taskL == null) {
            Y("任务已被删除，请重新选择");
            return;
        }
        this.U.setText(taskL.getName());
        this.V.setSelected(true);
        findViewById(2131296949).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v0() {
        com.frame.s0.g().d(TaskChooseDialogView.class);
        ((TaskChooseDialogView) com.frame.s0.g().x(TaskChooseDialogView.class)).setOnChooseListener(new TaskChooseDialogView.b() { // from class: com.jsj.autojs.activity.i4
            @Override // com.v.TaskChooseDialogView.b
            public final void a(TaskSimple taskSimple) {
                this.a.t0(taskSimple);
            }
        });
    }

    private void w0(TextView textView, String str, String str2) {
        String str3 = str + "\n" + str2;
        SpannableString spannableString = new SpannableString(str3);
        int length = str.length() + 1;
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.gray_999)), length, str3.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.75f), length, str3.length(), 33);
        spannableString.setSpan(new StyleSpan(0), length, str3.length(), 33);
        textView.setText(spannableString);
        textView.setLineSpacing(k0(4), 1.0f);
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 2131492909;
    }

    @Override // com.yl.ui.p
    public void b0() {
        j0("其他设置");
        this.P = da.B().M();
        TextView textView = (TextView) findViewById(2131297291);
        this.V = textView;
        w0(textView, "息屏执行自动解锁", "息屏运行任务前先亮屏，并执行你选择的解锁脚本");
        this.V.setOnClickListener(this);
        this.W = (TextView) findViewById(2131297205);
        this.W.setTypeface(Typeface.createFromAsset(com.frame.v0.g().getAssets(), "fonts/SwitzerlandBold2.otf"));
        this.W.setText((this.P.needResetOfferTimeByBrokenRun / 1000) + "");
        TextView textView2 = (TextView) findViewById(2131296746);
        w0(textView2, "停止后重置变量", "脚本停止后清空变量值，避免下次运行沿用旧数据");
        textView2.setOnClickListener(this);
        textView2.setSelected(this.P.isResetParamsAfterTaskFinish);
        TextView textView3 = (TextView) findViewById(2131296747);
        w0(textView3, "停止后重置循环次数", "脚本停止后把循环计数恢复初始值，下次从头计算");
        textView3.setOnClickListener(this);
        textView3.setSelected(this.P.isResetRepeatCountAfterTaskFinish);
        this.U = (TextView) findViewById(2131297292);
        findViewById(2131296743).setOnClickListener(this);
        findViewById(2131296949).setOnClickListener(this);
        final long jQ = i.b.i7.p().q();
        if (jQ == 0) {
            this.V.setSelected(false);
            this.U.setText("未设置");
            findViewById(2131296949).setVisibility(8);
        } else {
            com.frame.l1.g(new Runnable() { // from class: com.jsj.autojs.activity.f4
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o0(jQ);
                }
            });
        }
        TabLinearLayout tabLinearLayout = (TabLinearLayout) findViewById(2131296863);
        if (com.frame.n0.c("listClick", 0) == 0) {
            tabLinearLayout.b(2131297050);
        } else {
            tabLinearLayout.b(2131297051);
        }
        tabLinearLayout.setTabClickListener(new a(this));
        TextView textView4 = (TextView) findViewById(2131296782);
        w0(textView4, "任务完成后自动息屏", "自动亮屏执行的任务结束后，尝试关闭屏幕");
        textView4.setSelected(this.P.isAutoOffscreen);
        textView4.setOnClickListener(this);
        TextView textView5 = (TextView) findViewById(2131296739);
        w0(textView5, "完成后弹窗提醒", "任务结束时弹出结果提示，方便确认是否执行完成");
        textView5.setOnClickListener(this);
        textView5.setSelected(this.P.isFinishAlert);
        TextView textView6 = (TextView) findViewById(2131296793);
        w0(textView6, "完成后声音提醒", "任务结束时播放提示音，不看屏幕也能知道结果");
        textView6.setOnClickListener(this);
        textView6.setSelected(this.P.isFinishSound);
        TextView textView7 = (TextView) findViewById(2131296790);
        w0(textView7, "显示执行倒计时", "脚本运行时显示已执行时间和倒计时信息");
        textView7.setOnClickListener(this);
        textView7.setSelected(this.P.isShowTimeDown);
        TextView textView8 = (TextView) findViewById(2131296800);
        w0(textView8, "音量键控制执行", "脚本运行时可用音量键停止或暂停任务");
        textView8.setOnClickListener(this);
        textView8.setSelected(this.P.isCanVolumeButton);
        TextView textView9 = (TextView) findViewById(2131296492);
        w0(textView9, "暂停后显示节点列表", "用音量键暂停后弹出当前脚本节点，便于定位执行进度");
        textView9.setOnClickListener(this);
        textView9.setSelected(com.frame.n0.a("psnl", true));
        TextView textView10 = (TextView) findViewById(2131296780);
        w0(textView10, "执行时屏蔽通知", "脚本运行期间自动处理通知栏消息，减少弹窗干扰");
        textView10.setOnClickListener(this);
        textView10.setSelected(this.P.noNotificationWithTaskRun);
        TextView textView11 = (TextView) findViewById(2131296758);
        w0(textView11, "解锁页隐藏悬浮条", "在解锁页面不显示悬浮条，避免遮挡密码或手势区域");
        textView11.setOnClickListener(this);
        textView11.setSelected(this.P.isUnlockNoView);
        TextView textView12 = (TextView) findViewById(2131296755);
        w0(textView12, "闪退后自动继续", "脚本意外中断后，应用在有效时间内重启会尝试接着执行");
        textView12.setOnClickListener(this);
        textView12.setSelected(com.frame.n0.a("errorContinue", true));
        findViewById(2131296743).setVisibility(textView12.isSelected() ? 0 : 8);
        TextView textView13 = (TextView) findViewById(2131296741);
        w0(textView13, "自动任务显示执行条", "定时或外部触发的任务运行时显示执行控制条");
        textView13.setSelected(this.P.isShowHandlerWithAutoRun);
        textView13.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 2131296492:
                view.setSelected(!view.isSelected());
                com.frame.n0.g("psnl", view.isSelected());
                break;
            case 2131296739:
                view.setSelected(!view.isSelected());
                this.P.isFinishAlert = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296741:
                view.setSelected(!view.isSelected());
                this.P.isShowHandlerWithAutoRun = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296743:
                v.a aVar = new v.a(this);
                aVar.n("自动重启有效时间");
                aVar.f("请输入自动重启有效时间");
                aVar.h(2);
                aVar.k((this.P.needResetOfferTimeByBrokenRun / 1000) + "");
                aVar.l(1);
                aVar.i(4);
                aVar.o("秒");
                aVar.e(false);
                aVar.g(new v.b() { // from class: com.jsj.autojs.activity.h4
                    @Override // com.yl.ui.v.b
                    public final boolean a(Dialog dialog, String str) {
                        return this.a.q0(dialog, str);
                    }
                });
                aVar.d().show();
                break;
            case 2131296746:
                view.setSelected(!view.isSelected());
                this.P.isResetParamsAfterTaskFinish = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296747:
                view.setSelected(!view.isSelected());
                this.P.isResetRepeatCountAfterTaskFinish = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296755:
                view.setSelected(!view.isSelected());
                com.frame.n0.g("errorContinue", view.isSelected());
                findViewById(2131296743).setVisibility(view.isSelected() ? 0 : 8);
                break;
            case 2131296758:
                view.setSelected(!view.isSelected());
                this.P.isUnlockNoView = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296780:
                if (!com.permission.x0.m().r()) {
                    s.a aVar2 = new s.a(this);
                    aVar2.j("屏蔽通知栏消息需要读取/操作通知了权限，请先开启权限后再设置。");
                    aVar2.m("取消", null);
                    aVar2.r("开启", new DialogInterface.OnClickListener() { // from class: com.jsj.autojs.activity.g4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            com.permission.x0.m().h();
                        }
                    });
                    aVar2.t("温馨提示");
                    aVar2.e().show();
                    break;
                } else {
                    view.setSelected(!view.isSelected());
                    this.P.noNotificationWithTaskRun = view.isSelected();
                    da.B().S1(this.P);
                    break;
                }
            case 2131296782:
                view.setSelected(!view.isSelected());
                this.P.isAutoOffscreen = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296790:
                view.setSelected(!view.isSelected());
                this.P.isShowTimeDown = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296793:
                view.setSelected(!view.isSelected());
                this.P.isFinishSound = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296800:
                view.setSelected(!view.isSelected());
                this.P.isCanVolumeButton = view.isSelected();
                da.B().S1(this.P);
                break;
            case 2131296949:
            case 2131297291:
                if (!view.isSelected()) {
                    if (this.Q == null) {
                        this.Q = new i.b.t7();
                    }
                    this.Q.z0(new Runnable() { // from class: com.jsj.autojs.activity.j4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.v0();
                        }
                    });
                    this.Q.d();
                    break;
                } else {
                    i.b.i7.p().J(0L);
                    view.setSelected(false);
                    findViewById(2131296949).setVisibility(8);
                    this.U.setText((CharSequence) null);
                    break;
                }
        }
    }
}
