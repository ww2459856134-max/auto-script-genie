package com.a;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.s.ScreenshotService;
import com.v.FloatHandler;
import com.v.FloatHandlerRecord;
import com.v.FloatHandlerRun;
import com.v.FloatToast;
import com.v.FlowView;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.NodeListDialogView;
import com.yl.model.TaskConfig;
import com.yl.ui.s;
import i.b.da;
import i.b.i9;
import i.b.o7;
import i.b.w7;
import i.b.z7;

/* loaded from: classes.dex */
public class ScreenshotAct extends com.yl.ui.p {
    private boolean P;
    private boolean Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(DialogInterface dialogInterface, int i2) {
        k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D0(DialogInterface dialogInterface, int i2) {
        L0();
        com.permission.x0.m().a();
    }

    static /* synthetic */ void E0() {
        Intent intent = new Intent(com.frame.v0.g(), (Class<?>) ScreenshotAct.class);
        intent.putExtra("confirm_hid_permission_record", true);
        intent.setFlags(268435456);
        com.frame.v0.g().startActivity(intent);
    }

    private void H0() {
        s.a aVar = new s.a(this);
        aVar.t("无障碍已开启");
        aVar.j("是否现在录制HID录屏授权脚本？录制完成后可以关闭无障碍，后续会一直复用这段授权脚本。");
        aVar.r("开始录制", new DialogInterface.OnClickListener() { // from class: com.a.o1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.s0(dialogInterface, i2);
            }
        });
        aVar.m("暂不录制", new DialogInterface.OnClickListener() { // from class: com.a.j1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.q0(dialogInterface, i2);
            }
        });
        com.yl.ui.s sVarE = aVar.e();
        if (sVarE != null) {
            sVarE.show();
        }
    }

    private void I0() {
        s.a aVar = new s.a(this);
        aVar.t("HID录屏授权");
        aVar.j("自动点击录屏授权仅无障碍模式可用。HID模式可以录制一个“录屏授权脚本”，以后需要录屏权限时会自动执行这段点击/滑动。");
        aVar.r("录制授权脚本", new DialogInterface.OnClickListener() { // from class: com.a.f1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.u0(dialogInterface, i2);
            }
        });
        aVar.m("暂不录制", new DialogInterface.OnClickListener() { // from class: com.a.g1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.w0(dialogInterface, i2);
            }
        });
        com.yl.ui.s sVarE = aVar.e();
        if (sVarE != null) {
            sVarE.show();
        }
    }

    private void K0() {
        if (com.frame.w0.d()) {
            i9.v().D(this);
            com.frame.l1.f(d2.c, 500L);
            return;
        }
        s.a aVar = new s.a(this);
        aVar.t("需要先开启无障碍");
        aVar.j("录制HID录屏授权脚本时，需要用无障碍创建遮罩来覆盖系统授权弹窗并记录点击/滑动轨迹。请先开启一次无障碍，录制完成后可以再关闭无障碍；授权脚本会一直复用。");
        aVar.r("去开启无障碍", new DialogInterface.OnClickListener() { // from class: com.a.m1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.D0(dialogInterface, i2);
            }
        });
        aVar.m("取消", null);
        com.yl.ui.s sVarE = aVar.e();
        if (sVarE != null) {
            sVarE.show();
        }
    }

    private void L0() {
        com.frame.w0.j(new Runnable() { // from class: com.a.e1
            @Override // java.lang.Runnable
            public final void run() {
                com.frame.l1.f(new Runnable() { // from class: com.a.i1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenshotAct.E0();
                    }
                }, 500L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        i9.v().n0(null);
        if (da.B().U()) {
            da.B().h2();
        }
        finish();
    }

    private void l0() {
        if (getIntent().getBooleanExtra("confirm_hid_permission_record", false)) {
            H0();
            return;
        }
        if (getIntent().getBooleanExtra("record_hid_permission", false)) {
            i9.v().D(this);
            com.frame.l1.f(d2.c, 500L);
        } else if (i9.v().H()) {
            i9.v().D(this);
            i9.v().f0();
        } else if (!da.B().O() || !z7.c()) {
            J0();
        } else {
            i9.v().D(this);
            z7.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o0(boolean z) {
        i9 i9VarV = i9.v();
        TaskConfig taskConfigM = da.B().M();
        if (taskConfigM.useAccessibilityScreenshot != z) {
            i9VarV.s();
            taskConfigM.useAccessibilityScreenshot = z;
        }
        taskConfigM.captureModeConfirmed = true;
        da.B().S1(taskConfigM);
        if (z) {
            i9VarV.D(this);
        } else {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q0(DialogInterface dialogInterface, int i2) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(DialogInterface dialogInterface, int i2) {
        i9.v().D(this);
        com.frame.l1.f(d2.c, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u0(DialogInterface dialogInterface, int i2) {
        K0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i2) {
        i9.v().D(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z0(TextView textView, DialogInterface dialogInterface, int i2) {
        if (!textView.isSelected()) {
            i9.v().D(this);
        } else {
            if (da.B().O()) {
                I0();
                return;
            }
            com.frame.n0.g("ifca", false);
            i9.v().D(this);
            i9.v().f0();
        }
    }

    public void G0() {
        com.frame.s0 s0VarG = com.frame.s0.g();
        s0VarG.d(FloatToast.class);
        FloatHandler floatHandler = (FloatHandler) s0VarG.f(FloatHandler.class);
        if (this.P && floatHandler != null && floatHandler.getVisibility() == 0) {
            s0VarG.u(FloatHandler.class);
        }
        for (Class<? extends NodeListDialogView> cls : NodeListDialogView.I) {
            NodeListDialogView nodeListDialogView = (NodeListDialogView) s0VarG.f(cls);
            if (nodeListDialogView != null && nodeListDialogView.getVisibility() == 0) {
                s0VarG.u(cls);
            }
        }
        FlowView flowView = (FlowView) s0VarG.f(FlowView.class);
        if (flowView != null && flowView.getVisibility() == 0) {
            s0VarG.u(FlowView.class);
        }
        if (((MultiGestureRecordFloatView) s0VarG.f(MultiGestureRecordFloatView.class)) == null || s0VarG.m(MultiGestureRecordFloatView.class)) {
            FloatHandlerRecord floatHandlerRecord = (FloatHandlerRecord) s0VarG.f(FloatHandlerRecord.class);
            if (floatHandlerRecord != null && floatHandlerRecord.getVisibility() == 0) {
                s0VarG.u(FloatHandlerRecord.class);
            }
        } else {
            s0VarG.E(GesturePlayFloatView.class);
            s0VarG.u(MultiGestureRecordFloatView.class);
            MultiGestureRecordFloatView.E();
        }
        GesturePlayFloatView gesturePlayFloatView = (GesturePlayFloatView) s0VarG.f(GesturePlayFloatView.class);
        if (gesturePlayFloatView != null) {
            com.frame.s0.g().D(gesturePlayFloatView);
            s0VarG.u(GesturePlayFloatView.class);
            s0VarG.u(FloatHandlerRun.class);
        }
        w7.g().p();
        com.frame.v0.g().o(null);
    }

    public void J0() {
        final TextView textView = new TextView(com.frame.v0.g());
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setText("不再提示，自动点击开启录屏");
        textView.setPadding(com.frame.p1.c(25.0f), com.frame.p1.c(8.0f), 0, com.frame.p1.c(10.0f));
        textView.setTextSize(12.0f);
        textView.setCompoundDrawablePadding(com.frame.p1.c(5.0f));
        textView.setCompoundDrawablesWithIntrinsicBounds(j.b.d.H0, 0, 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.a.l1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                textView.setSelected(!r0.isSelected());
            }
        });
        textView.startAnimation(AnimationUtils.loadAnimation(com.frame.v0.g(), j.b.a.d));
        s.a aVar = new s.a(com.frame.v0.g().d());
        aVar.r("确定", new DialogInterface.OnClickListener() { // from class: com.a.n1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.z0(textView, dialogInterface, i2);
            }
        });
        aVar.u(textView);
        aVar.m("取消", new DialogInterface.OnClickListener() { // from class: com.a.h1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.c.B0(dialogInterface, i2);
            }
        });
        aVar.s(j.b.g.b);
        aVar.j("您已选择<strong>录屏模式</strong>，需要开启录屏权限才能获取屏幕画面。每次重新开启录屏都需要系统授权，同一次录屏期间无需逐节点授权。勾选后可辅助点击系统授权按钮。");
        aVar.e().show();
    }

    @Override // com.yl.ui.p
    public int a0() {
        return 0;
    }

    @Override // androidx.fragment.app.h0, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1000 && i3 == -1) {
            i9.v().m0(false);
            if (Build.VERSION.SDK_INT < 29) {
                i9.v().p0(i3, intent);
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) ScreenshotService.class);
            intent2.putExtra("code", i3);
            intent2.putExtra("data", intent);
            startForegroundService(intent2);
            return;
        }
        if (1111 != i2 || i3 != -1) {
            com.frame.y0.j("ScreenshotAct-onActivityResult-finish()");
            k0();
        } else {
            if (Build.VERSION.SDK_INT < 29) {
                i9.v().p0(i3, intent);
                return;
            }
            Intent intent3 = new Intent(this, (Class<?>) ScreenshotService.class);
            intent3.putExtra("code", i3);
            intent3.putExtra("data", intent);
            startForegroundService(intent3);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Q) {
            return;
        }
        this.Q = true;
        if (getIntent().getBooleanExtra("confirm_hid_permission_record", false) || getIntent().getBooleanExtra("record_hid_permission", false)) {
            l0();
            return;
        }
        if (!da.B().M().captureModeConfirmed || i9.v().j0()) {
            o7.k(this, new o7.a() { // from class: com.a.k1
                @Override // i.b.o7.a
                public final void a(boolean z) {
                    this.a.o0(z);
                }
            }, new Runnable() { // from class: com.a.d1
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.k0();
                }
            });
        } else if (i9.v().F()) {
            i9.v().D(this);
        } else {
            l0();
        }
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.frame.s0 s0VarG = com.frame.s0.g();
        FloatHandler floatHandler = (FloatHandler) s0VarG.f(FloatHandler.class);
        this.P = (floatHandler == null || floatHandler.getParent() == null || floatHandler.getVisibility() != 0) ? false : true;
        s0VarG.k();
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.frame.s0.g().d(FloatToast.class);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.yl.ui.p, androidx.fragment.app.h0, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.yl.ui.p, androidx.appcompat.app.s, androidx.fragment.app.h0, android.app.Activity
    protected void onStop() {
        super.onStop();
        G0();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }
}
