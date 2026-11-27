package i.b.ka;

import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.Rect;
import android.net.Uri;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import com.frame.g0;
import com.v.AppChooseView;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class h6 extends x5 {
    long e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(Runnable runnable, AccessibilityNodeInfo accessibilityNodeInfo) {
        T(accessibilityNodeInfo);
        SystemClock.sleep(600L);
        com.frame.w0.b().performGlobalAction(1);
        f0(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(final Runnable runnable, AccessibilityNodeInfo accessibilityNodeInfo) {
        T(accessibilityNodeInfo);
        SystemClock.sleep(700L);
        com.frame.g0.v().p(null, com.frame.g0.v().c(5, "确定", "强行停止", "OK"), new g0.a() { // from class: i.b.ka.c0
            @Override // com.frame.g0.a
            public final void a(AccessibilityNodeInfo accessibilityNodeInfo2) {
                this.a.W(runnable, accessibilityNodeInfo2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(final Runnable runnable) {
        try {
            com.frame.g0.v().p(null, com.frame.g0.v().c(5, "强制关闭", "结束运行", "强行停止", "FORCE STOP"), new g0.a() { // from class: i.b.ka.x
                @Override // com.frame.g0.a
                public final void a(AccessibilityNodeInfo accessibilityNodeInfo) {
                    this.a.Y(runnable, accessibilityNodeInfo);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c0(Runnable runnable) {
        do {
            SystemClock.sleep(500L);
        } while (System.currentTimeMillis() - this.e <= 5000);
        f0(runnable);
    }

    static /* synthetic */ void e0(lt ltVar, String str) {
        MultiGestureRecordFloatView.c(500L);
        Node nodeO = v8.m().O(str);
        if (ltVar != null) {
            ltVar.a(nodeO);
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 30;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, lt ltVar) {
        AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
        appChooseView.u(node.url);
        appChooseView.setCallback(new AppChooseView.a() { // from class: i.b.ka.a0
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                node.url = str;
            }
        });
        Toast.makeText(com.frame.v0.g(), "关闭app", 0).show();
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ((AppChooseView) com.frame.s0.g().B(AppChooseView.class)).setCallback(new AppChooseView.a() { // from class: i.b.ka.b0
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                h6.e0(ltVar, str);
            }
        });
    }

    public void T(AccessibilityNodeInfo accessibilityNodeInfo) {
        com.frame.y0.j("权限点击:使用模拟点击：" + ((Object) accessibilityNodeInfo.getText()));
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        try {
            com.frame.s0.g().E(GesturePlayFloatView.class);
            GesturePlayFloatView.B(rect);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int iCenterX = rect.centerX();
        float fCenterY = rect.centerY();
        Path path = new Path();
        float f = iCenterX;
        path.moveTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        path.lineTo(f, fCenterY);
        try {
            com.frame.w0.b().dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 120L)).build(), new g6(this), null);
        } catch (Exception e2) {
            com.frame.k0.r(e2);
        }
    }

    public void U(String str, final Runnable runnable) {
        this.e = System.currentTimeMillis();
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", str, null));
            com.frame.v0.g().t(intent, com.permission.x0.f.intValue());
            SystemClock.sleep(700L);
            com.frame.l1.g(new Runnable() { // from class: i.b.ka.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.a0(runnable);
                }
            });
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    public synchronized void f0(Runnable runnable) {
        if (runnable != null) {
            if (this.e != 0) {
                this.c.W(runnable);
                this.e = 0L;
            }
        }
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, final Runnable runnable) {
        com.frame.y0.n("关闭App：" + node.url);
        U(node.url, runnable);
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.y
            @Override // java.lang.Runnable
            public final void run() {
                this.c.c0(runnable);
            }
        });
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.G;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "关闭软件";
    }
}
