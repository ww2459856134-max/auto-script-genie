package com.s;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import com.frame.k0;
import com.frame.l1;
import com.frame.n0;
import com.frame.p0;
import com.frame.s0;
import com.frame.v0;
import com.frame.w0;
import com.frame.y0;
import com.permission.x0;
import com.s.BoxService;
import com.user.AccountTool;
import com.v.FloatHandler;
import com.v.FloatHandlerRun;
import com.v.FloatToast;
import com.yl.float_ui.DingMsgView;
import com.yl.float_ui.SimpleLogView;
import com.yl.model.Task;
import i.b.da;
import i.b.i7;
import i.b.i9;
import i.b.k8;
import i.b.w7;

/* loaded from: classes.dex */
public class BoxService extends w0 {
    public boolean f;
    private BroadcastReceiver g = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        static /* synthetic */ void a(long j2) {
            try {
                Task taskL = da.B().L(j2);
                if (taskL != null) {
                    y0.o("解锁时触发任务");
                    da.B().D1(da.B().M().alarmTaskSoundFile);
                    da.B().e2(taskL, false);
                }
            } catch (Exception e) {
                k0.r(e);
            }
        }

        static /* synthetic */ void b(View view) {
            x0.m().a();
            s0.g().d(DingMsgView.class);
        }

        static /* synthetic */ void c() {
            try {
                DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
                dingMsgView.l("温馨提示");
                dingMsgView.h("无障碍服务未开启或丢失，自动自行任务无法继续，请先开启无障碍服务~");
                dingMsgView.k("立即开启", new View.OnClickListener() { // from class: com.s.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BoxService.a.b(view);
                    }
                });
                dingMsgView.i("取消", null);
            } catch (Exception e) {
                k0.r(e);
            }
        }

        static /* synthetic */ void d(Intent intent) {
            y0.o("TaskReceiver:触发定时任务");
            i7.p().e();
            long longExtra = intent.getLongExtra("taskId", 0L);
            if (longExtra == 0) {
                return;
            }
            if (!w0.d()) {
                l1.e(new Runnable() { // from class: com.s.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        BoxService.a.c();
                    }
                });
                return;
            }
            y0.o("触发定时任务");
            Task taskL = da.B().L(longExtra);
            if (taskL != null) {
                i7.p().y();
                da.B().f2(taskL);
            } else {
                y0.j("未找到定时任务（BoxService）：" + longExtra);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (da.B().M().isUnlockNoView) {
                    s0.g().u(FloatHandler.class);
                }
                final long jD = n0.d("unlockAuto", 0L);
                if (jD != 0) {
                    l1.g(new Runnable() { // from class: com.s.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            BoxService.a.a(jD);
                        }
                    });
                    return;
                }
                return;
            }
            if ("ACTION_SHOW_FLOAT_BAR".equals(action)) {
                FloatHandler.P();
                v0.g().stopService(new Intent(v0.g(), (Class<?>) u.class));
                return;
            }
            if ("ACTION_CLOSE_SCREEN_CAPTURE".equals(action)) {
                BoxService.this.y();
                return;
            }
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                if (da.B().M().isUnlockNoView) {
                    s0.g().i(FloatHandler.class);
                }
            } else if (!"android.intent.action.TIME_TICK".equals(action) && "TaskReceiver".equals(action)) {
                l1.g(new Runnable() { // from class: com.s.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        BoxService.a.d(intent);
                    }
                });
            }
        }
    }

    public static BoxService m() {
        return (BoxService) w0.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o() {
        try {
            if (this.g != null) {
                v0.g().unregisterReceiver(this.g);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    static /* synthetic */ void p() {
        if (s0.g().m(FloatHandler.class)) {
            s0.g().d(FloatHandler.class);
        }
        if (n0.a("fhclose", false)) {
            k0.c().x(u.class);
        } else {
            FloatHandler.P();
        }
    }

    static /* synthetic */ void r() {
        w7.g().i();
        l1.e(new Runnable() { // from class: com.s.h
            @Override // java.lang.Runnable
            public final void run() {
                w7.g().p();
            }
        });
    }

    static /* synthetic */ void u(View view) {
        s0.g().d(DingMsgView.class);
        i9.v().s();
        v0.g().stopService(new Intent(v0.g(), (Class<?>) ScreenshotService.class));
    }

    private void w() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("TaskReceiver");
            intentFilter.addAction("ACTION_CLOSE_SCREEN_CAPTURE");
            intentFilter.addAction("ACTION_SHOW_FLOAT_BAR");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.setPriority(Integer.MAX_VALUE);
            v0.g().registerReceiver(this.g, intentFilter);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        DingMsgView dingMsgView = (DingMsgView) s0.g().x(DingMsgView.class);
        dingMsgView.h("是否确定关闭录屏权限，关闭后再次调用图片识别、颜色识别等功能时会重新弹窗授权。");
        dingMsgView.k("确定", new View.OnClickListener() { // from class: com.s.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BoxService.u(view);
            }
        });
        dingMsgView.i("取消", new View.OnClickListener() { // from class: com.s.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.g().d(DingMsgView.class);
            }
        });
        dingMsgView.l("温馨提示");
    }

    @Override // com.frame.w0
    public void k() {
        x();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.frame.w0, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        y0.o(v0.g().getResources().getString(j.b.g.c) + "....无障碍关闭....");
        l1.g(new Runnable() { // from class: com.s.f
            @Override // java.lang.Runnable
            public final void run() {
                this.c.o();
            }
        });
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        y0.o("....无障碍中断....");
    }

    @Override // com.frame.w0, android.accessibilityservice.AccessibilityService
    protected boolean onKeyEvent(KeyEvent keyEvent) {
        if (!da.B().M().isCanVolumeButton) {
            return super.onKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 24) {
            if (keyCode == 25 && da.B().U()) {
                y0.o("音量-停止任务");
                da.B().h2();
                FloatToast.i("任务已停止");
                i7.p().z();
                return true;
            }
        } else if (da.B().U()) {
            y0.o("音量-暂停任务");
            FloatToast.i("任务已暂停");
            FloatHandlerRun floatHandlerRun = (FloatHandlerRun) s0.g().f(FloatHandlerRun.class);
            if (floatHandlerRun != null) {
                floatHandlerRun.findViewById(j.b.e.Z0).callOnClick();
            } else {
                da.B().A1();
            }
            i7.p().z();
            return true;
        }
        return super.onKeyEvent(keyEvent);
    }

    @Override // com.frame.w0, android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        super.onServiceConnected();
        y0.o(v0.g().getResources().getString(j.b.g.c) + "....无障碍启动....");
        if (v0.f().getLong("doTaskId", 0L) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("accessibility:上次非正常退出脚本，请检查首页右上角权限，特别是自启动点进去找到我们app检测是否勾选，华为手机要改成手动管理，三项全勾选<br/>，SDK_INT：");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("，手机品牌：");
            sb.append(Build.BRAND);
            sb.append("，手机型号：");
            sb.append(Build.MODEL);
            sb.append("，软件版本：");
            sb.append(p0.h().j());
            sb.append("，用户：");
            sb.append(AccountTool.d().l() ? "终身VIP" : AccountTool.d().m() ? "VIP" : "普通用户");
            y0.j(sb.toString());
            da.B().L1();
        }
        w();
        l1.e(new Runnable() { // from class: com.s.g
            @Override // java.lang.Runnable
            public final void run() {
                BoxService.p();
            }
        });
        l1.g(new Runnable() { // from class: com.s.i
            @Override // java.lang.Runnable
            public final void run() {
                BoxService.r();
            }
        });
        l1.g(new Runnable() { // from class: com.s.l
            @Override // java.lang.Runnable
            public final void run() {
                k8.d().l();
            }
        });
        x();
        l1.g(new Runnable() { // from class: com.s.j
            @Override // java.lang.Runnable
            public final void run() {
                i7.p().d();
            }
        });
        if (y0.b().e()) {
            SimpleLogView.P().R(y0.b().a());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }

    public void x() {
        try {
            if (this.f) {
                return;
            }
            AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
            accessibilityServiceInfo.eventTypes = 4198443;
            accessibilityServiceInfo.feedbackType = -1;
            accessibilityServiceInfo.flags = 115;
            accessibilityServiceInfo.notificationTimeout = 100L;
            m().setServiceInfo(accessibilityServiceInfo);
            this.f = true;
        } catch (Exception e) {
            k0.r(e);
            k0.r(e);
        }
    }
}
