package i.b.ka;

import android.widget.Toast;
import com.v.AppChooseView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class d7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(final c6 c6Var, final String str, final Runnable runnable) {
        c6Var.S(this.c);
        this.c.W(new Runnable() { // from class: i.b.ka.a3
            @Override // java.lang.Runnable
            public final void run() {
                c6Var.Z(str, runnable);
            }
        });
    }

    static /* synthetic */ void X(lt ltVar, String str) {
        MultiGestureRecordFloatView.c(500L);
        Node nodeO = v8.m().O(str);
        nodeO.type = 35;
        if (ltVar != null) {
            ltVar.a(nodeO);
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 35;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, lt ltVar) {
        AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
        appChooseView.u(node.url);
        appChooseView.setCallback(new AppChooseView.a() { // from class: i.b.ka.b3
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                node.url = str;
            }
        });
        Toast.makeText(com.frame.v0.g(), "重启软件", 0).show();
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ((AppChooseView) com.frame.s0.g().B(AppChooseView.class)).setCallback(new AppChooseView.a() { // from class: i.b.ka.z2
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                d7.X(ltVar, str);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, final Runnable runnable) {
        final String str = node.url;
        h6 h6Var = (h6) z(30);
        final c6 c6Var = (c6) z(8);
        h6Var.S(this.c);
        h6Var.U(str, new Runnable() { // from class: i.b.ka.y2
            @Override // java.lang.Runnable
            public final void run() {
                this.c.V(c6Var, str, runnable);
            }
        });
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.R;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "重启软件";
    }
}
