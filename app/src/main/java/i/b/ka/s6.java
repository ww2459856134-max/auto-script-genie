package i.b.ka;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;
import com.yl.model.Node;
import i.b.da;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class s6 extends AccessibilityService.GestureResultCallback {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ long c;
    final /* synthetic */ Node d;
    final /* synthetic */ t6 e;

    s6(t6 t6Var, AtomicReference atomicReference, Runnable runnable, long j2, Node node) {
        this.e = t6Var;
        this.a = atomicReference;
        this.b = runnable;
        this.c = j2;
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
            t6 t6Var = this.e;
            if (t6Var.e <= 0) {
                da.B().w1("模拟手势失败");
                return;
            }
            t6Var.T(node, runnable);
            t6 t6Var2 = this.e;
            t6Var2.e--;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public void onCancelled(GestureDescription gestureDescription) {
        super.onCancelled(gestureDescription);
        final AtomicReference atomicReference = this.a;
        final long j2 = this.c;
        final Node node = this.d;
        final Runnable runnable = this.b;
        com.frame.l1.c(1002303, new Runnable() { // from class: i.b.ka.f1
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
        if (this.e.c.q()) {
            this.e.c.W(this.b);
        }
    }
}
