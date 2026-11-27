package i.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import i.h.f;
import java.text.ParseException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l9 {
    private JSONObject a;

    public l9() {
        try {
            this.a = new JSONObject(com.frame.n0.e("sPermission"));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
    }

    static k9 h(Task task, Long l2, boolean z) {
        return (l2 == null || !l2.equals(task.getCreateUserId())) ? task.isCanNotShare() ? k9.DENY_RESHARE_DISABLED : (task.getLimitUserId() == null || z) ? k9.ALLOW : k9.DENY_USER_RESTRICTED : k9.ALLOW;
    }

    static /* synthetic */ void j(Task task) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("【" + task.getName() + "】不是您创建的脚本不能备份，已被忽略，可在主账号设置权限。");
        dingMsgView.k("知道了", null);
        dingMsgView.g(j.b.d.q0);
        dingMsgView.l("温馨提示");
    }

    static /* synthetic */ void l() {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.l("温馨提醒");
        dingMsgView.h("子账号使用主账号脚本有效期已过");
        dingMsgView.i("知道了", new View.OnClickListener() { // from class: i.b.l3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.frame.s0.g().d(DingMsgView.class);
            }
        });
    }

    static /* synthetic */ void m(Task task, String str) {
        DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
        dingMsgView.h("【" + task.getName() + "】" + str + "，不能导出。");
        dingMsgView.k("知道了", null);
        dingMsgView.g(j.b.d.q0);
        dingMsgView.l("温馨提示");
    }

    private void q(final Task task, final String str) {
        com.frame.l1.e(new Runnable() { // from class: i.b.k3
            @Override // java.lang.Runnable
            public final void run() {
                l9.m(task, str);
            }
        });
    }

    private void r() {
    }

    public boolean e(final Task task) {
        if (s8.a(task) || AccountTool.d().k(task.getCreateUserId())) {
            return true;
        }
        JSONObject jSONObject = this.a;
        if (jSONObject != null && jSONObject.has("canBackup")) {
            return true;
        }
        com.frame.l1.e(new Runnable() { // from class: i.b.j3
            @Override // java.lang.Runnable
            public final void run() {
                l9.j(task);
            }
        });
        return false;
    }

    public boolean f(Task task) {
        if (s8.a(task)) {
            return true;
        }
        Long lG = AccountTool.d().g();
        JSONObject jSONObject = this.a;
        k9 k9VarH = h(task, lG, jSONObject != null && jSONObject.has("canBackup"));
        if (k9VarH == k9.DENY_RESHARE_DISABLED) {
            q(task, "原作者已设置不可再次分享");
        } else if (k9VarH == k9.DENY_USER_RESTRICTED) {
            q(task, "原作者已限定可使用账号");
        }
        return k9VarH == k9.ALLOW;
    }

    public boolean g(Task task) {
        JSONObject jSONObject;
        if (s8.a(task) || task.getCreateUserId() == null || task.getCreateUserId().equals(AccountTool.d().g()) || (jSONObject = this.a) == null || !jSONObject.has("runTime")) {
            return true;
        }
        try {
            if (System.currentTimeMillis() <= com.frame.m1.e(this.a.optString("runTime"), "yyyy年MM月dd日")) {
                return true;
            }
            com.frame.l1.e(new Runnable() { // from class: i.b.i3
                @Override // java.lang.Runnable
                public final void run() {
                    l9.l();
                }
            });
            return false;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject i() {
        return this.a;
    }

    public void o() {
        com.frame.n0.k("sPermission", null);
    }

    public void p() {
        r();
        f.a aVar = new f.a();
        aVar.f("/getSubUserPermission");
        aVar.a().l(String.class, new j9(this));
    }

    public boolean s() {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/getSubUserPermission", arrayList));
            d();
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.h3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
                return false;
            }
            String strOptString = jSONObject.optString("json");
            if (TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject();
                this.a = jSONObject2;
                com.frame.n0.k("sPermission", jSONObject2.toString());
            } else {
                try {
                    String strOptString2 = new JSONObject(strOptString).optString("permissions");
                    com.frame.n0.k("sPermission", strOptString2);
                    this.a = new JSONObject(strOptString2);
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
            return true;
        } catch (Exception e2) {
            com.frame.k0.r(e2);
            return false;
        }
    }
}
