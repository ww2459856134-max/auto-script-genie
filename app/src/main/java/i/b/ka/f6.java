package i.b.ka;

import android.content.res.Resources;
import android.text.TextUtils;
import com.v.ClickConfigDialogView;
import com.v.GesturePlayFloatView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class f6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(MultiGestureRecordFloatView multiGestureRecordFloatView, lt ltVar, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(MultiGestureRecordFloatView multiGestureRecordFloatView, lt ltVar, Node node) {
        multiGestureRecordFloatView.setCallback(null);
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 1;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) throws Resources.NotFoundException {
        GesturePlayFloatView gesturePlayFloatView = (GesturePlayFloatView) com.frame.s0.g().E(GesturePlayFloatView.class);
        gesturePlayFloatView.removeAllViews();
        gesturePlayFloatView.A(0, node);
        ClickConfigDialogView clickConfigDialogView = (ClickConfigDialogView) com.frame.s0.g().B(ClickConfigDialogView.class);
        clickConfigDialogView.j(task, node);
        clickConfigDialogView.g(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        if (!com.frame.s0.g().m(MultiGestureRecordFloatView.class)) {
            final MultiGestureRecordFloatView multiGestureRecordFloatView = (MultiGestureRecordFloatView) com.frame.s0.g().x(MultiGestureRecordFloatView.class);
            multiGestureRecordFloatView.setCallback(new lt() { // from class: i.b.ka.w
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.U(multiGestureRecordFloatView, ltVar, node);
                }
            });
        } else {
            final MultiGestureRecordFloatView multiGestureRecordFloatView2 = (MultiGestureRecordFloatView) com.frame.s0.g().f(MultiGestureRecordFloatView.class);
            multiGestureRecordFloatView2.setVisibility(0);
            multiGestureRecordFloatView2.setCallback(new lt() { // from class: i.b.ka.v
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.W(multiGestureRecordFloatView2, ltVar, node);
                }
            });
        }
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        if (TextUtils.isEmpty(node.text)) {
            g(node, runnable);
            return false;
        }
        try {
            node.pathPoints = x(node.text);
            g(node, runnable);
            return false;
        } catch (Exception unused) {
            com.frame.y0.j("点击变量坐标错误");
            runnable.run();
            return false;
        }
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.a;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.z;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "点击";
    }
}
