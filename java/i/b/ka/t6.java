package i.b.ka;

import android.accessibilityservice.GestureDescription;
import android.content.res.Resources;
import android.graphics.Path;
import com.v.FloatToast;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.GesturePath;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.x7;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class t6 extends x5 {
    int e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(MultiGestureRecordFloatView multiGestureRecordFloatView, lt ltVar, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(MultiGestureRecordFloatView multiGestureRecordFloatView, lt ltVar, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 26;
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
        if (!com.frame.s0.g().m(MultiGestureRecordFloatView.class)) {
            final MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().x(MultiGestureRecordFloatView.class);
            multiGestureRecordFloatView.setCallback(new lt() { // from class: i.b.ka.g1
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.V(multiGestureRecordFloatView, ltVar, node);
                }
            });
        } else {
            final MultiGestureRecordFloatView multiGestureRecordFloatView2 = (MultiGestureRecordFloatView) com.frame.s0.g().f(MultiGestureRecordFloatView.class);
            multiGestureRecordFloatView2.setVisibility(0);
            multiGestureRecordFloatView2.setCallback(new lt() { // from class: i.b.ka.h1
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.X(multiGestureRecordFloatView2, ltVar, node);
                }
            });
        }
    }

    public void T(Node node, Runnable runnable) {
        if (da.B().M().isShowGesturePath) {
            ((GesturePlayFloatView) com.frame.s0.g().h(GesturePlayFloatView.class)).y(node);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicReference atomicReference = new AtomicReference(Boolean.FALSE);
        GestureDescription.Builder builder = new GestureDescription.Builder();
        long clickDuration = da.B().M().getClickDuration();
        try {
            Iterator<GesturePath> it = node.paths.iterator();
            while (it.hasNext()) {
                GesturePath next = it.next();
                Path path = new Path();
                x7.d().a(path, next.points);
                builder.addStroke(new GestureDescription.StrokeDescription(path, next.startTime, Math.max(next.duration, clickDuration)));
            }
            com.frame.w0.b().dispatchGesture(builder.build(), new s6(this, atomicReference, runnable, jCurrentTimeMillis, node), null);
        } catch (Exception e) {
            FloatToast.i(e.getMessage());
            com.frame.k0.r(e);
        }
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
        return j.b.d.V;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "多指滑动";
    }
}
