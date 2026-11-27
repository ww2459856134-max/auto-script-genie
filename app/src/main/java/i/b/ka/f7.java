package i.b.ka;

import com.v.FloatHandlerRecord;
import com.v.FloatToast;
import com.v.FlowView;
import com.v.ImageBoxSelectDialogView;
import com.v.NodeListDialogView;
import com.v.lt;
import com.yl.model.ImageBox;
import com.yl.model.Node;
import i.b.v8;
import java.util.List;

/* loaded from: classes.dex */
public class f7 extends e7 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1(Node node, lt ltVar, Node node2) {
        if (node2 != null) {
            v8.m().W(node2, node.url);
            Q(ltVar, node);
        }
        com.frame.s0.g().u(NodeListDialogView.class);
        com.frame.s0.g().u(FlowView.class);
        com.frame.s0.g().u(FloatHandlerRecord.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c1(final lt ltVar, int i2, List list) {
        if (i2 == -1) {
            FloatToast.i("请选择图集");
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            return;
        }
        if (list.isEmpty() || ((ImageBox) list.get(i2)).urls.isEmpty()) {
            FloatToast.i("此图集为空");
            com.frame.s0.g().u(NodeListDialogView.class);
            com.frame.s0.g().u(FlowView.class);
            com.frame.s0.g().u(FloatHandlerRecord.class);
            return;
        }
        long j2 = ((ImageBox) list.get(i2)).id;
        final Node nodeH = v8.m().h(null);
        nodeH.url = j2 + "";
        P(0, v8.m().p(), nodeH, new lt() { // from class: i.b.ka.d4
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.a1(nodeH, ltVar, node);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e1(lt ltVar) {
        c(ltVar);
    }

    @Override // i.b.ka.e7, i.b.ka.x5
    public int B() {
        return 22;
    }

    @Override // i.b.ka.e7, i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ImageBoxSelectDialogView imageBoxSelectDialogView = (ImageBoxSelectDialogView) com.frame.s0.g().x(ImageBoxSelectDialogView.class);
        imageBoxSelectDialogView.b();
        imageBoxSelectDialogView.setOnImageBoxChoose(new ImageBoxSelectDialogView.c() { // from class: i.b.ka.b4
            @Override // com.v.ImageBoxSelectDialogView.c
            public final void a(int i3, List list) {
                this.a.c1(ltVar, i3, list);
            }
        });
        imageBoxSelectDialogView.setOnCancelListener(new Runnable() { // from class: i.b.ka.c4
            @Override // java.lang.Runnable
            public final void run() {
                this.c.e1(ltVar);
            }
        });
    }

    @Override // i.b.ka.e7, i.b.ka.x5
    public String q() {
        return i.b.p7.b;
    }

    @Override // i.b.ka.e7, i.b.ka.x5
    public int r() {
        return j.b.d.W;
    }

    @Override // i.b.ka.e7, i.b.ka.x5
    public String t() {
        return "多图识别";
    }
}
