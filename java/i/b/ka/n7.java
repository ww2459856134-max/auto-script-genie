package i.b.ka;

import android.text.Html;
import com.v.FloatToast;
import com.v.MultiGestureRecordFloatView;
import com.v.ToastDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.t9;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class n7 extends x5 {
    private int T(Node node) {
        int i2 = node.argInt1;
        if (i2 == 1) {
            return 17;
        }
        return i2 == 2 ? 80 : 48;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(lt ltVar, Node node) {
        Q(ltVar, node);
        com.frame.s0.g().d(MultiGestureRecordFloatView.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(lt ltVar, Node node) {
        v8.m().X(node);
        new t9(v8.m().p()).t(node, null);
        Q(ltVar, node);
        MultiGestureRecordFloatView.c(100L);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 29;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        ToastDialogView toastDialogView = (ToastDialogView) com.frame.s0.g().B(ToastDialogView.class);
        toastDialogView.setTaskNode(task, node);
        toastDialogView.c(new lt() { // from class: i.b.ka.d5
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.V(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ToastDialogView toastDialogView = (ToastDialogView) com.frame.s0.g().B(ToastDialogView.class);
        Node node = new Node();
        node.id = System.currentTimeMillis();
        node.type = B();
        node.delay = "100";
        toastDialogView.setTaskNode(v8.m().p(), node);
        toastDialogView.c(new lt() { // from class: i.b.ka.e5
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.X(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        FloatToast.h(0, Html.fromHtml(da.B().G(node.text)), false, T(node));
        this.c.W(runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.B;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "提示条";
    }
}
