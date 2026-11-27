package i.b.ka;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.v.MultiGestureRecordFloatView;
import com.v.PageScanFloatView;
import com.v.TextChooseDialogViewNew;
import com.v.lt;
import com.yl.model.Node;
import i.b.v8;

/* loaded from: classes.dex */
class l7 implements PageScanFloatView.b {
    final /* synthetic */ lt a;
    final /* synthetic */ m7 b;

    l7(m7 m7Var, lt ltVar) {
        this.b = m7Var;
        this.a = ltVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(lt ltVar, Node node) {
        Node nodeE0 = v8.m().e0(node);
        MultiGestureRecordFloatView.c(500L);
        this.b.Q(ltVar, nodeE0);
    }

    @Override // com.v.PageScanFloatView.b
    public void a(int i2, Rect rect, String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        Node nodeL = v8.m().l(i2, accessibilityNodeInfo);
        com.frame.s0.g().d(PageScanFloatView.class);
        TextChooseDialogViewNew textChooseDialogViewNew = (TextChooseDialogViewNew) com.frame.s0.g().x(TextChooseDialogViewNew.class);
        textChooseDialogViewNew.setTaskNode(v8.m().p(), nodeL);
        final lt ltVar = this.a;
        textChooseDialogViewNew.setNodeCallback(new lt() { // from class: i.b.ka.w4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.c(ltVar, node);
            }
        });
    }

    @Override // com.v.PageScanFloatView.b
    public void cancel() {
        MultiGestureRecordFloatView.c(0L);
        this.b.Q(this.a, null);
    }
}
