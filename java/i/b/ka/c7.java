package i.b.ka;

import android.text.Html;
import com.v.FloatToast;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class c7 extends x5 {
    @Override // i.b.ka.x5
    public int B() {
        return 7;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, lt ltVar) {
        Node nodeN = v8.m().N();
        FloatToast.g(j.b.d.f0, Html.fromHtml("触发<font color='#E73030'>『后台多任务』</font>操作"));
        Q(ltVar, nodeN);
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.w0.b().performGlobalAction(3);
        this.c.W(runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.f0;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "后台按键";
    }
}
