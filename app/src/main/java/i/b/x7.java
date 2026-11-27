package i.b;

import android.graphics.Path;
import android.os.Looper;
import com.v.ProgressBar;
import com.yl.model.Node;
import com.yl.model.Task;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class x7 {
    private static x7 b;
    private HashMap<Integer, i.b.ka.x5> a = new HashMap<>();

    private x7() {
        i.b.ka.x5[] x5VarArr = {new i.b.ka.t6(), new i.b.ka.g7(), new i.b.ka.e7(), new i.b.ka.m7(), new i.b.ka.n6(), new i.b.ka.r6(), new i.b.ka.m6(), new i.b.ka.b7(), new i.b.ka.d6(), new i.b.ka.w6(), new i.b.ka.c6(), new i.b.ka.q6(), new i.b.ka.c7(), new i.b.ka.h7(), new i.b.ka.i6(), new i.b.ka.o6(), new i.b.ka.i7(), new i.b.ka.z6(), new i.b.ka.f6(), new i.b.ka.s7(), new i.b.ka.k7(), new i.b.ka.j6(), new i.b.ka.f7(), new i.b.ka.v6(), new i.b.ka.a7(), new i.b.ka.a6(), new i.b.ka.p6(), new i.b.ka.t7(), new i.b.ka.n7(), new i.b.ka.h6(), new i.b.ka.x6(), new i.b.ka.o7(), new i.b.ka.p7(), new i.b.ka.u6(), new i.b.ka.d7(), new i.b.ka.z5(), new i.b.ka.q7(), new i.b.ka.e6(), new i.b.ka.j7(), new i.b.ka.k6(), new i.b.ka.l6(), new i.b.ka.b6()};
        for (int i2 = 0; i2 < 42; i2++) {
            i.b.ka.x5 x5Var = x5VarArr[i2];
            this.a.put(Integer.valueOf(x5Var.B()), x5Var);
        }
    }

    public static synchronized x7 d() {
        x7 x7Var;
        x7Var = b;
        if (x7Var == null) {
            x7Var = new x7();
            b = x7Var;
        }
        return x7Var;
    }

    static x7 f() {
        return new x7();
    }

    public void a(Path path, ArrayList<Integer> arrayList) {
        for (int i2 = 0; i2 < arrayList.size() / 2; i2++) {
            int i3 = i2 * 2;
            int iAbs = Math.abs(arrayList.get(i3).intValue());
            int iAbs2 = Math.abs(arrayList.get(i3 + 1).intValue());
            if (path.isEmpty()) {
                path.moveTo(iAbs, iAbs2);
            } else {
                path.lineTo(arrayList.get(i3).intValue(), arrayList.get(r3).intValue());
            }
        }
    }

    public void b(long j2) {
        if (j2 > 0) {
            if (j2 > 500) {
                try {
                    if (da.B().M().isShowTimeDown) {
                        ProgressBar.h((int) j2);
                    }
                } catch (InterruptedException e) {
                    com.frame.y0.l(e);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Looper.getMainLooper().getThread() == Thread.currentThread() ? "<font  color='#EB5E00'>主线程延迟：</font>" : "子线程延迟：");
            sb.append(j2);
            com.frame.y0.g(sb.toString());
            if (j2 < 1000) {
                Thread.sleep(j2);
                return;
            }
            long j3 = j2 / 1000;
            for (int i2 = 0; i2 < j3; i2++) {
                Thread.sleep(1000L);
            }
            Thread.sleep(j2 % 1000);
        }
    }

    public HashMap<Integer, i.b.ka.x5> c() {
        return this.a;
    }

    public i.b.ka.x5 e(int i2) {
        return this.a.get(Integer.valueOf(i2));
    }

    public List<Node> g(Task task) {
        LinkedHashMap<Long, Node> nodeMap = task.getNodeMap();
        ArrayList arrayList = new ArrayList();
        if (nodeMap != null && !nodeMap.isEmpty()) {
            for (Node node : nodeMap.values()) {
                if (task.getFirstNodeId() == 0) {
                    task.setFirstNodeId(node.id);
                }
                arrayList.add(node);
            }
        }
        return arrayList;
    }
}
