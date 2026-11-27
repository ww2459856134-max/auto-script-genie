package i.b.ka;

import com.v.VersionDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class p7 extends x5 {
    static /* synthetic */ void T(Node node, lt ltVar, Node node2) {
        v8.m().a(node);
        if (ltVar != null) {
            ltVar.a(node);
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 33;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
        VersionDialogView versionDialogView = (VersionDialogView) com.frame.s0.g().B(VersionDialogView.class);
        versionDialogView.h(task, node);
        versionDialogView.g(ltVar);
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        nodeQ.type = B();
        VersionDialogView versionDialogView = (VersionDialogView) com.frame.s0.g().B(VersionDialogView.class);
        versionDialogView.h(v8.m().p(), nodeQ);
        versionDialogView.g(new lt() { // from class: i.b.ka.h5
            @Override // com.v.lt
            public final void a(Node node) {
                p7.T(nodeQ, ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        if (Integer.valueOf(com.frame.p0.h().j().replace(".", "")).intValue() >= Integer.valueOf(node.text.replace(".", "")).intValue()) {
            this.c.W(runnable);
            return false;
        }
        da.B().h2();
        da.B().w1("您的app版本号低于限制版本");
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.R;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "版本限制";
    }
}
