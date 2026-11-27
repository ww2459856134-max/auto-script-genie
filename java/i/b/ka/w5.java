package i.b.ka;

import android.graphics.Rect;
import com.yl.model.Node;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class w5 implements Runnable {
    final /* synthetic */ AtomicReference c;
    final /* synthetic */ int d;
    final /* synthetic */ Runnable e;
    final /* synthetic */ Rect f;
    final /* synthetic */ long g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Node f1536h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ x5 f1537i;

    w5(x5 x5Var, AtomicReference atomicReference, int i2, Runnable runnable, Rect rect, long j2, Node node) {
        this.f1537i = x5Var;
        this.c = atomicReference;
        this.d = i2;
        this.e = runnable;
        this.f = rect;
        this.g = j2;
        this.f1536h = node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Runnable] */
    @Override // java.lang.Runnable
    public void run() {
        AtomicReference atomicReference = this.c;
        atomicReference.set(Integer.valueOf(((Integer) atomicReference.get()).intValue() + 1));
        this.f1537i.f(this.f, this.g, this.f1536h.getPoint(), ((Integer) this.c.get()).intValue() >= this.d ? this.e : this);
    }
}
