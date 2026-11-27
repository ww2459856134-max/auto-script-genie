package i.b.ka;

import android.view.View;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.v.lt;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Node;
import com.yl.model.Task;
import i.b.da;
import i.b.v8;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e6 extends x5 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(Node node, lt ltVar, View view) {
        com.frame.s0.g().d(DingMsgView.class);
        v8.m().c0(node);
        Q(ltVar, node);
    }

    @Override // i.b.ka.x5
    public int B() {
        return 43;
    }

    @Override // i.b.ka.x5
    public void P(int i2, Task task, Node node, lt ltVar) {
    }

    @Override // i.b.ka.x5
    public void R(int i2, final lt ltVar) {
        final Node nodeQ = v8.m().Q();
        nodeQ.type = 43;
        nodeQ.timeOut = 10000L;
        nodeQ.delay = "500";
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("这个节点是用于你在出售脚本时强制验证账号登录状态，避免用户通过漏洞跳过账号检测或一号多登的问题盗取脚本行为。");
        dingMsgView.i("知道了", new View.OnClickListener() { // from class: i.b.ka.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.c.U(nodeQ, ltVar, view);
            }
        });
        dingMsgView.g(j.b.d.M0);
        dingMsgView.l("温馨提示");
    }

    @Override // i.b.ka.x5
    public boolean p(LinkedHashMap<Long, Node> linkedHashMap, Node node, Runnable runnable) {
        try {
        } catch (Exception e) {
            com.frame.k0.r(e);
            da.B().w1("检测登录失败，请检查网络状态是否处于连接状态。");
        }
        if (!AccountTool.d().m()) {
            da.B().w1("检查您的账号是否是会员？请联系脚本制作者授权。");
            return false;
        }
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
        arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
        JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/getNewUserInfo", arrayList));
        if (jSONObject.optInt("code") != 1) {
            com.frame.v0.f().edit().putLong("getCurrentUserInfo", 0L).apply();
            da.B().w1(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
            return false;
        }
        AccountTool.d().x(jSONObject.optString("json"));
        if (AccountTool.d().m()) {
            this.c.W(runnable);
            return false;
        }
        da.B().w1("检查您的账号是否是会员？请联系脚本制作者授权。");
        return false;
    }

    @Override // i.b.ka.x5
    public String q() {
        return i.b.p7.c;
    }

    @Override // i.b.ka.x5
    public int r() {
        return j.b.d.H;
    }

    @Override // i.b.ka.x5
    public String t() {
        return "检测登录";
    }
}
