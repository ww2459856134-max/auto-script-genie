package i.b.ka;

import android.text.Html;
import com.v.FloatToast;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class n6 extends x5 {
    @Override // i.b.ka.x5
    public int B() {
        return 5;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, lt ltVar) {
        Node nodeM = v8.m().M();
        FloatToast.g(j.b.d.O, Html.fromHtml("触发<font color='#E73030'>『桌面』</font>操作"));
        Q(ltVar, nodeM);
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("触发桌面按键：" + node.getName());
        com.frame.w0.b().performGlobalAction(2);
        this.c.W(runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.O;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "桌面按键";
    }
}
