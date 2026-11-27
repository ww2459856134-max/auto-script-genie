package i.b.ka;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import com.yl.model.Node;
import i.b.da;

/* loaded from: classes.dex */
class v5 extends AccessibilityService.GestureResultCallback {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Node b;
    final /* synthetic */ x5 c;

    v5(x5 x5Var, Runnable runnable, Node node) {
        this.c = x5Var;
        this.a = runnable;
        this.b = node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Node node, Runnable runnable) {
        if (this.c.c.q()) {
            if (this.c.b <= 0) {
                da.B().w1("模拟点击/手势失败，检查一下是不是点击耗时（持续时间）设置的太短，有些设备相应慢，把点击持续时间调长（50-100ms）试一试，再不行重启手机试一试。如果桌面可以模拟点击，到目标APP内就不能点击说明有可能该APP屏蔽了模拟手势功能。您也可以使用模拟器或云手机来运行。");
                return;
            }
            com.frame.y0.g("重试点击:" + (x5.d - this.c.b) + "次");
            this.c.i(node, runnable);
            x5.b(this.c);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        final Node node = this.b;
        final Runnable runnable = this.a;
        com.frame.l1.c(1002303, new Runnable() { // from class: i.b.ka.b
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b(node, runnable);
            }
        }, 500L);
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCompleted(GestureDescription gestureDescription) {
        super.onCompleted(gestureDescription);
        if (this.c.c.q()) {
            com.frame.l1.i(1002303);
            this.c.c.W(this.a);
        }
    }
}
