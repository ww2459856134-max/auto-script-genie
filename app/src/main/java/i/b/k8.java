package i.b;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.s.BoxService;
import com.yl.model.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class k8 {
    private static k8 c;
    private static Gson d = new Gson();
    private Map<String, List<Node>> a;
    private List<Node> b = f();

    private k8() {
    }

    public static k8 d() {
        k8 k8Var = c;
        if (k8Var != null) {
            return k8Var;
        }
        k8 k8Var2 = new k8();
        c = k8Var2;
        return k8Var2;
    }

    public void a(Node node) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(node);
        k(this.b);
    }

    public void b() {
        this.b.clear();
        this.a.clear();
    }

    public boolean c(long j2) {
        ArrayList arrayList = new ArrayList();
        List<Node> list = this.b;
        if (list == null) {
            return false;
        }
        for (Node node : list) {
            if (node.nextId == j2 || node.nextTaskId == j2) {
                arrayList.add(node);
                return true;
            }
        }
        return false;
    }

    public List<Node> e(long j2) {
        ArrayList arrayList = new ArrayList();
        List<Node> list = this.b;
        if (list != null) {
            for (Node node : list) {
                if (node.nextId == j2 || node.nextTaskId == j2) {
                    arrayList.add(node);
                }
            }
        }
        return arrayList;
    }

    public List<Node> f() {
        List<Node> list = this.b;
        if (list != null) {
            return list;
        }
        String strG = g();
        List<Node> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(strG)) {
            arrayList = (List) d.k(strG, com.google.gson.k0.a.c(List.class, Node.class).e());
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.b = arrayList;
        return arrayList;
    }

    public String g() {
        return com.frame.n0.f("pageSL", "");
    }

    public Map<String, List<Node>> h() {
        return this.a;
    }

    public void i() {
        j(d.s(this.b));
    }

    public void j(String str) {
        if (str == null) {
            return;
        }
        com.frame.n0.k("pageSL", str);
        l();
        if (!com.frame.w0.d() || BoxService.m().f) {
            return;
        }
        BoxService.m().x();
    }

    public void k(List<Node> list) {
        if (list == null) {
            return;
        }
        j(d.s(list));
    }

    public void l() {
        List arrayList;
        HashMap map = new HashMap();
        List<Node> listF = d().f();
        this.b = listF;
        boolean z = false;
        if (listF != null && !listF.isEmpty()) {
            for (Node node : listF) {
                if (map.containsKey(node.url)) {
                    arrayList = (List) map.get(node.url);
                } else {
                    arrayList = new ArrayList();
                    map.put(node.url, arrayList);
                }
                arrayList.add(node);
                z = true;
            }
        }
        this.a = map;
        if (z) {
            try {
                if (com.frame.w0.d()) {
                    BoxService.m().a(j8.b());
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
    }
}
