package i.b.ka;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.v.AppChooseView;
import com.v.MultiGestureRecordFloatView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class b6 extends x5 {
    static /* synthetic */ void V(lt ltVar, String str) {
        MultiGestureRecordFloatView.c(500L);
        Node nodeT = v8.m().T(str);
        if (ltVar != null) {
            ltVar.a(nodeT);
        }
    }

    @Override // i.b.ka.x5
    public int B() {
        return 40;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, final Node node, lt ltVar) {
        AppChooseView appChooseView = (AppChooseView) com.frame.s0.g().B(AppChooseView.class);
        appChooseView.u(node.url);
        appChooseView.setCallback(new AppChooseView.a() { // from class: i.b.ka.o
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                node.url = str;
            }
        });
        Toast.makeText(com.frame.v0.g(), "跳转APP详情", 0).show();
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        ((AppChooseView) com.frame.s0.g().B(AppChooseView.class)).setCallback(new AppChooseView.a() { // from class: i.b.ka.p
            @Override // com.v.AppChooseView.a
            public final void a(String str) {
                b6.V(ltVar, str);
            }
        });
    }

    public void T(String str, Runnable runnable) {
        System.currentTimeMillis();
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", str, null));
            com.frame.v0.g().t(intent, com.permission.x0.f.intValue());
            this.c.W(runnable);
        } catch (Exception e) {
            com.frame.y0.l(e);
        }
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.n("跳转App详情：" + node.url);
        T(node.url, runnable);
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.e;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.G;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "跳转App详情";
    }
}
