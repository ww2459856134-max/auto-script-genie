package i.b.ka;

import android.text.Html;
import com.v.FloatToast;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class d6 extends x5 {
    @Override // i.b.ka.x5
    public int B() {
        return 6;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, lt ltVar) {
        Node nodeL = v8.m().L();
        FloatToast.g(j.b.d.E, Html.fromHtml("触发<font color='#E73030'>『返回』</font>操作"));
        Q(ltVar, nodeL);
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("触发返回按键：" + node.getName());
        com.frame.w0.b().performGlobalAction(1);
        this.c.W(runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.E;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "返回按键";
    }
}
