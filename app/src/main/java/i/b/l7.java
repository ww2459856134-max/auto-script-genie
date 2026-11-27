package i.b;

import com.google.gson.Gson;
import com.yl.model.AutoNotify;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l7 {
    private static l7 b;
    private List<AutoNotify> a;

    public static l7 b() {
        l7 l7Var = b;
        if (l7Var != null) {
            return l7Var;
        }
        l7 l7Var2 = new l7();
        b = l7Var2;
        return l7Var2;
    }

    public AutoNotify a(long j2) {
        for (AutoNotify autoNotify : c()) {
            if (autoNotify.taskId == j2) {
                return autoNotify;
            }
        }
        return null;
    }

    public List<AutoNotify> c() {
        String strE = com.frame.n0.e("autoNotify");
        if (this.a == null) {
            this.a = (List) new Gson().k(strE, com.google.gson.k0.a.c(List.class, AutoNotify.class).e());
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a;
    }

    public void d() {
        e(this.a);
    }

    public void e(List<AutoNotify> list) {
        this.a = list;
        com.frame.n0.k("autoNotify", new Gson().s(list));
    }
}
