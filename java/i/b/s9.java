package i.b;

import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class s9 {
    final Task a;
    final Node b;
    final int c;
    final boolean d;
    final long e;
    final da.a f;

    s9(String str, long j2, long j3, da daVar) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("frames");
        if (jSONArray.length() == 0 || jSONArray.getJSONObject(0).getLong("taskId") != j2 || jSONArray.getJSONObject(0).getLong("nodeId") != j3) {
            throw new JSONException("任务恢复记录不一致");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            r9 r9Var = null;
            if (i2 >= jSONArray.length()) {
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(length);
                    daVar.f1393l.put(Long.valueOf(((Task) arrayList.get(length)).getId()), Integer.valueOf(jSONObject2.optInt("taskRepeat")));
                    if (length > 0) {
                        t9 t9Var = new t9((Task) arrayList.get(length));
                        t9Var.e0((Node) arrayList2.get(length));
                        t9Var.f0(jSONObject2.optInt("nodeRepeat"));
                        t9Var.d0(jSONObject2.optBoolean("toolbar", true));
                        t9Var.h0(r9Var);
                        r9Var = new r9(t9Var);
                    }
                }
                this.a = (Task) arrayList.get(0);
                this.b = (Node) arrayList2.get(0);
                this.c = jSONArray.getJSONObject(0).optInt("nodeRepeat");
                this.d = jSONArray.getJSONObject(0).optBoolean("toolbar", true);
                this.e = jSONObject.optLong("startedAt");
                this.f = r9Var;
                return;
            }
            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
            Task taskL = daVar.L(jSONObject3.getLong("taskId"));
            Node node = taskL != null ? taskL.getNodeMap().get(Long.valueOf(jSONObject3.getLong("nodeId"))) : null;
            if (node == null) {
                throw new JSONException("恢复任务或返回节点已被删除");
            }
            arrayList.add(taskL);
            arrayList2.add(node);
            i2++;
        }
    }

    static String a(t9 t9Var, long j2, da daVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        while (t9Var != null) {
            if (!setNewSetFromMap.add(t9Var)) {
                throw new JSONException("任务返回链存在循环");
            }
            Node nodeI = t9Var.i();
            if (nodeI == null) {
                throw new JSONException("任务返回节点为空");
            }
            jSONArray.put(new JSONObject().put("taskId", t9Var.l().getId()).put("nodeId", nodeI.id).put("nodeRepeat", t9Var.j()).put("taskRepeat", daVar.f1393l.getOrDefault(Long.valueOf(t9Var.l().getId()), 0)).put("toolbar", t9Var.p()));
            da.a aVarM = t9Var.m();
            t9Var = aVarM instanceof r9 ? ((r9) aVarM).a : null;
            if (t9Var != null && !t9Var.q()) {
                t9Var = null;
            }
        }
        return new JSONObject().put("startedAt", j2).put("frames", jSONArray).toString();
    }
}
