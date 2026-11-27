package i.b.ka;

import com.v.FloatToast;
import com.v.NodeJumpChooseDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.LinkedHashMap;
import org.json.JSONException;

/* loaded from: classes.dex */
public class o6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(Node node, lt ltVar, Node node2) {
        FloatToast.g(j.b.d.Q, "跳转节点已添加");
        v8.m().S(node);
        Q(ltVar, node);
        com.yl.ui.i0.l(null);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 15;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        NodeJumpChooseDialogView nodeJumpChooseDialogView = (NodeJumpChooseDialogView) com.frame.s0.g().x(NodeJumpChooseDialogView.class);
        nodeJumpChooseDialogView.j(task, node);
        nodeJumpChooseDialogView.i(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        try {
            final Node nodeQ = v8.m().Q();
            nodeQ.type = 15;
            nodeQ.nextType = 2;
            NodeJumpChooseDialogView nodeJumpChooseDialogView = (NodeJumpChooseDialogView) com.frame.s0.g().x(NodeJumpChooseDialogView.class);
            nodeJumpChooseDialogView.j(v8.m().p(), nodeQ);
            nodeJumpChooseDialogView.i(new lt() { // from class: i.b.ka.s0
                @Override // com.v.lt
                public final void a(Node node) {
                    this.a.V(nodeQ, ltVar, node);
                }
            });
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void T(Node node, int i2, long j2, Runnable runnable) throws JSONException {
        if (i2 != 4) {
            super.k(node, runnable);
            return;
        }
        Task taskL = da.B().L(j2);
        if (taskL == null) {
            com.frame.y0.j("跳转任务失败，未找到任务id：" + j2);
            da.B().w1("跳转任务失败，未找到任务指定脚本，可能是脚本已被删除或还未导入子脚本。");
            return;
        }
        Node node2 = node.nextTaskNodeId != 0 ? taskL.getNodeMap().get(Long.valueOf(node.nextTaskNodeId)) : null;
        Task taskL2 = this.c.l();
        if (taskL2 == null) {
            com.frame.y0.j("跳转任务失败，找不到当前任务，请咨询技术小哥");
            return;
        }
        if (taskL2 != taskL) {
            if (!node.jumpBack) {
                da.B().b2(taskL, node2, this.c.p(), null, false);
                return;
            } else {
                da.B().b2(taskL, node2, this.c.p(), e(this.c), false);
                return;
            }
        }
        Node node3 = new Node();
        node3.id = node.id;
        node3.errorType = 3;
        long j3 = node.nextTaskNodeId;
        if (j3 == 0) {
            j3 = taskL.getNodeMap().values().iterator().next().id;
        }
        node3.errorId = j3;
        super.k(node3, runnable);
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) throws JSONException {
        com.frame.y0.g("触发跳转节点：" + node.getName());
        T(node, node.errorType, node.errorId, runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.Q;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "跳转节点/任务";
    }
}
