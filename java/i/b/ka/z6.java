package i.b.ka;

import android.content.res.Resources;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class z6 extends x5 {
    int e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(MultiGestureRecordFloatView multiGestureRecordFloatView, lt ltVar, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 2;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) throws Resources.NotFoundException {
        GesturePlayFloatView gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().E(GesturePlayFloatView.class);
        gesturePlayFloatView.removeAllViews();
        gesturePlayFloatView.A(0, node);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        if (da.B().C().size() < 4 && com.frame.n0.a("guideAudio", true)) {
            da.B().B1("record_gesture.mp4");
        }
        if (com.frame.s0.g().m(MultiGestureRecordFloatView.class)) {
            return;
        }
        final MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().x(MultiGestureRecordFloatView.class);
        multiGestureRecordFloatView.setCallback(new lt() { // from class: i.b.ka.m2
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.V(multiGestureRecordFloatView, ltVar, node);
            }
        });
    }

    public void T(Node node, Runnable runnable) {
        if (da.B().M().isShowGesturePath) {
            ((GesturePlayFloatView) com.frame.s0.g().h(GesturePlayFloatView.class)).y(node);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.f(node, new y6(this, new AtomicReference(Boolean.FALSE), jCurrentTimeMillis, runnable, node));
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        this.e = 5;
        T(node, runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.a;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.p;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "手势滑动";
    }
}
