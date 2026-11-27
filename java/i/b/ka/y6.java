package i.b.ka;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;
import com.yl.model.Node;
import i.b.da;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class y6 extends AccessibilityService.GestureResultCallback {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ long b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ Node d;
    final /* synthetic */ z6 e;

    y6(z6 z6Var, AtomicReference atomicReference, long j2, Runnable runnable, Node node) {
        this.e = z6Var;
        this.a = atomicReference;
        this.b = j2;
        this.c = runnable;
        this.d = node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(AtomicReference atomicReference, long j2, Node node, Runnable runnable) {
        if (((Boolean) atomicReference.get()).booleanValue()) {
            return;
        }
        Log.e("", "模拟手势失败" + (System.currentTimeMillis() - j2));
        if (this.e.c.q()) {
            z6 z6Var = this.e;
            if (z6Var.e <= 0) {
                da.B().w1("模拟手势失败");
                return;
            }
            z6Var.T(node, runnable);
            z6 z6Var2 = this.e;
            z6Var2.e--;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        final AtomicReference atomicReference = this.a;
        final long j2 = this.b;
        final Node node = this.d;
        final Runnable runnable = this.c;
        com.frame.l1.c(1002303, new Runnable() { // from class: i.b.ka.l2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.b(atomicReference, j2, node, runnable);
            }
        }, 1200L);
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCompleted(GestureDescription gestureDescription) {
        super.onCompleted(gestureDescription);
        this.a.set(Boolean.TRUE);
        com.frame.l1.i(1002303);
        Log.e("", "模拟手势成功，耗时：" + (System.currentTimeMillis() - this.b));
        if (this.e.c.q()) {
            this.e.c.W(this.c);
        }
    }
}
