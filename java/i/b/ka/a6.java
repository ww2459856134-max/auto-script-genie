package i.b.ka;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.user.AccountTool;
import com.v.ApiDialogView;
import com.v.lt;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

/* loaded from: classes.dex */
public class a6 extends x5 {
    private String T(String str, String str2) {
        try {
            return com.frame.p0.h().d(str);
        } catch (Exception e) {
            com.frame.k0.r(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(Node node, AtomicReference atomicReference, Runnable runnable) throws JSONException, InterruptedException {
        try {
            long j2 = node.timeOut;
            if (j2 == 0) {
                j2 = 10000;
            }
            Thread.sleep(j2);
            if (((Boolean) atomicReference.get()).booleanValue()) {
                atomicReference.set(Boolean.FALSE);
                k(node, runnable);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(lt ltVar, Node node) {
        v8.m().X(node);
        Q(ltVar, node);
    }

    private String b0(String str, List<String> list, List<String> list2) {
        HashMap<String, String> map;
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        if (list != null) {
            com.frame.y0.g("params：");
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strG = da.B().G(str2.split("=")[0]);
                    String strG2 = da.B().G(str2.split("=")[1]);
                    com.frame.y0.g("params：" + strG + "=" + strG2);
                    arrayList.add(new BasicNameValuePair(strG, strG2));
                }
            }
        }
        if (list2 != null) {
            map = new HashMap<>();
            for (String str3 : list2) {
                if (!TextUtils.isEmpty(str3)) {
                    String strG3 = da.B().G(str3.split("=")[0]);
                    String strG4 = da.B().G(str3.split("=")[1]);
                    com.frame.y0.g("headers：" + strG3 + "=" + strG4);
                    map.put(strG3, strG4);
                }
            }
        } else {
            map = null;
        }
        try {
            return com.frame.p0.h().r(str, arrayList, map, false);
        } catch (Exception e) {
            com.frame.k0.r(e);
            return null;
        }
    }

    private String c0(String str, String str2, List<String> list) {
        HashMap<String, String> map;
        if (list != null) {
            try {
                map = new HashMap<>();
                for (String str3 : list) {
                    if (!TextUtils.isEmpty(str3)) {
                        String strG = da.B().G(str3.split("=")[0]);
                        String strG2 = da.B().G(str3.split("=")[1]);
                        com.frame.y0.g("headers：" + strG + "=" + strG2);
                        map.put(strG, strG2);
                    }
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                return null;
            }
        } else {
            map = null;
        }
        return com.frame.p0.h().x(str, da.B().G(str2), map);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 25;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, final lt ltVar) {
        ApiDialogView apiDialogView = (ApiDialogView) com.frame.s0.g().B(ApiDialogView.class);
        apiDialogView.setTaskNode(v8.m().p(), node);
        apiDialogView.F(new lt() { // from class: i.b.ka.l
            @Override // com.v.lt
            public final void a(Node node2) {
                this.a.Y(ltVar, node2);
            }
        });
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        Node nodeQ = v8.m().Q();
        nodeQ.type = 25;
        nodeQ.timeOut = 10000L;
        nodeQ.errorType = 2;
        ApiDialogView apiDialogView = (ApiDialogView) com.frame.s0.g().B(ApiDialogView.class);
        apiDialogView.setTaskNode(v8.m().p(), nodeQ);
        apiDialogView.F(new lt() { // from class: i.b.ka.n
            @Override // com.v.lt
            public final void a(Node node) {
                this.a.a0(ltVar, node);
            }
        });
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, final Node node, final Runnable runnable) {
        String strB0;
        String strG = da.B().G(node.url);
        if (strG != null && strG.trim().regionMatches(true, 0, "http://", 0, 7)) {
            com.frame.y0.j("API地址不是HTTPS，跳过节点：" + strG);
            this.c.Y(node, runnable);
            return false;
        }
        if (runnable != null && !AccountTool.d().m() && this.c.l().getCreateUserId() != null && !AccountTool.d().k(this.c.l().getCreateUserId()) && !AccountTool.d().m()) {
            com.frame.l1.e(new Runnable() { // from class: i.b.ka.m
                @Override // java.lang.Runnable
                public final void run() {
                    da.B().a2();
                }
            });
            return false;
        }
        final AtomicReference atomicReference = new AtomicReference(Boolean.TRUE);
        com.frame.l1.g(new Runnable() { // from class: i.b.ka.k
            @Override // java.lang.Runnable
            public final void run() throws JSONException, InterruptedException {
                this.c.W(node, atomicReference, runnable);
            }
        });
        String strT = null;
        if (Constants.HTTP_POST.equals(node.arg1) || TextUtils.isEmpty(node.arg1)) {
            com.frame.y0.g("api操作(POST)：" + strG);
            List<String> listAsList = !TextUtils.isEmpty(node.arg4) ? Arrays.asList(node.arg4.split("&")) : null;
            if (node.what == 1) {
                strB0 = c0(strG, node.arg2, listAsList);
            } else {
                strB0 = b0(strG, TextUtils.isEmpty(node.arg2) ? null : Arrays.asList(node.arg2.split("&")), listAsList);
            }
            strT = strB0;
        } else if (Constants.HTTP_GET.equals(node.arg1)) {
            com.frame.y0.g("api操作(GET)：" + strG);
            strT = T(strG, node.arg2);
        }
        com.frame.y0.g("api请求结果：" + strT);
        da.B().E1(node.arg3, strT);
        if (((Boolean) atomicReference.get()).booleanValue()) {
            atomicReference.set(Boolean.FALSE);
            this.c.W(runnable);
        } else {
            atomicReference.set(Boolean.FALSE);
        }
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.D;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "API接口";
    }
}
