package i.b.ka;

import android.text.Html;
import com.v.DelaySetNodeDialogView;
import com.v.FloatToast;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class j6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(lt ltVar, Node node) {
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(lt ltVar, Node node) {
        Q(ltVar, node);
        v8.m().a(node);
        FloatToast.g(j.b.d.E, Html.fromHtml("已添加<font color='#E73030'>『延迟』</font>操作"));
    }

    @Override // i.b.ka.x5
    public int B() {
        return 21;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        DelaySetNodeDialogView delaySetNodeDialogView = (DelaySetNodeDialogView) com.frame.s0.g().B(DelaySetNodeDialogView.class);
        delaySetNodeDialogView.w(task, node);
        delaySetNodeDialogView.v(new lt() { // from class: i.b.ka.i0
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.U(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 21;
        DelaySetNodeDialogView delaySetNodeDialogView = (DelaySetNodeDialogView) com.frame.s0.g().B(DelaySetNodeDialogView.class);
        delaySetNodeDialogView.w(v8.m().p(), nodeQ);
        delaySetNodeDialogView.v(new lt() { // from class: i.b.ka.j0
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.W(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("延迟时长：" + node.delay);
        this.c.W(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.I;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "延迟操作";
    }
}
