package i.b.ka;

import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.v8;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class q6 extends x5 {
    @Override // i.b.ka.x5
    public int B() {
        return 9;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, lt ltVar) {
        Q(ltVar, v8.m().U());
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        com.frame.y0.g("触发锁屏：" + node.getName());
        com.frame.w0.b().performGlobalAction(8);
        this.c.W(runnable);
        return true;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.d;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.T;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "锁屏";
    }
}
