package i.b.ka;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.v.FloatToast;
import com.v.UrlDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.t9;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class o7 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(Node node, lt ltVar, Node node2) {
        v8.m().X(node2);
        p(null, node, null);
        Q(ltVar, node2);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 32;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        UrlDialogView urlDialogView = (UrlDialogView) com.frame.s0.g().B(UrlDialogView.class);
        urlDialogView.setTaskNode(v8.m().p(), node);
        urlDialogView.c(new lt() { // from class: i.b.ka.f5
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.U(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        nodeQ.type = 32;
        UrlDialogView urlDialogView = (UrlDialogView) com.frame.s0.g().B(UrlDialogView.class);
        urlDialogView.setTaskNode(v8.m().p(), nodeQ);
        urlDialogView.c(new lt() { // from class: i.b.ka.g5
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.W(nodeQ, ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        String strG = da.B().G(node.url);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(strG));
        com.frame.y0.g("跳转：" + strG);
        if (!TextUtils.isEmpty(node.arg2)) {
            for (String str : da.B().G(node.arg2).split("&")) {
                intent.putExtra(str.split("=")[0], str.split("=")[1]);
            }
        }
        try {
            com.frame.v0.g().startActivity(intent);
        } catch (Exception unused) {
            com.frame.y0.j("未找到Activity(ActivityNotFoundException)");
            FloatToast.i("未找到Activity(ActivityNotFoundException)");
        }
        t9 t9Var = this.c;
        if (t9Var != null) {
            t9Var.W(runnable);
        }
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.m0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "URL跳转";
    }
}
