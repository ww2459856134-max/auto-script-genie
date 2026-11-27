package i.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import com.yl.float_ui.DingMsgView;
import com.yl.model.Task;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a8 implements e8 {
    private final l9 a = new l9();
    private final HashMap<Long, Boolean> b = new HashMap<>();

    private boolean b(Long l2) {
        if (l2 == null) {
            return false;
        }
        String strF = com.frame.n0.f("subUserIds", "");
        if (TextUtils.isEmpty(strF)) {
            return false;
        }
        for (String str : strF.split(",")) {
            if (String.valueOf(l2).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void d(String str) {
        Toast.makeText(com.frame.v0.g(), str, 0).show();
        try {
            DingMsgView dingMsgView = (DingMsgView) com.frame.s0.g().x(DingMsgView.class);
            dingMsgView.g(j.b.d.q0);
            dingMsgView.h(str);
            dingMsgView.l("温馨提示");
            dingMsgView.i("知道了", null);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    @Override // i.b.e8
    public boolean a(Task task) throws ParseException {
        if (task.getCreateUserId() == null) {
            return true;
        }
        try {
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(this.b.get(task.getCreateUserId()))) {
                ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
                arrayList.add(new BasicNameValuePair("id", task.getId() + ""));
                arrayList.add(new BasicNameValuePair("cid", task.getCreateUserId() + ""));
                arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
                arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
                JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.f + "/checkScript", arrayList));
                if (jSONObject.optInt("code") != 1) {
                    String strOptString = jSONObject.optString(SocialConstants.PARAM_SEND_MSG);
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (strOptString.contains(task.getCreateUserId() + "")) {
                        }
                    }
                    e(jSONObject.optString(SocialConstants.PARAM_SEND_MSG));
                    return false;
                }
                if ("超限制".equals(jSONObject.optString(SocialConstants.PARAM_SEND_MSG))) {
                    if (!AccountTool.d().m()) {
                        com.frame.l1.e(new Runnable() { // from class: i.b.r1
                            @Override // java.lang.Runnable
                            public final void run() {
                                da.B().a2();
                            }
                        });
                        return false;
                    }
                } else if (jSONObject.optInt("code") == 1) {
                    this.b.put(task.getCreateUserId(), bool);
                }
            }
        } catch (Exception e) {
            e("验证失败，请检查网络问题！");
            com.frame.k0.r(e);
        }
        if (task.getLimitUserId() != null) {
            if (!AccountTool.d().j()) {
                e("需要先登录");
                return false;
            }
            if (!AccountTool.d().k(task.getCreateUserId()) && !b(task.getCreateUserId())) {
                if (task.getLimitUserId().longValue() == -1) {
                    Long pid = AccountTool.d().c().getPid();
                    if (pid == null || task.getCreateUserId() == null || !pid.equals(task.getCreateUserId())) {
                        if (task.getCreateUserId() == null) {
                            e("此脚本限制仅创建者的子账号可使用，您不可用，请联系脚本创建者：没有创建者信息（非官方开发者）！");
                            return false;
                        }
                        if (!AccountTool.d().k(task.getCreateUserId())) {
                            e("此脚本限制仅创建者的子账号可使用，您不可用，请联系脚本创建者id：" + task.getCreateUserId() + "（非软件开发者）！");
                        }
                    }
                    task.setLimitUserId(AccountTool.d().g());
                    task.setLimitTime(Long.valueOf(com.frame.m1.e(AccountTool.d().c().getVipEndTime(), "yyyy-MM-dd HH:mm")));
                    JSONObject jSONObjectI = this.a.i();
                    if (jSONObjectI == null) {
                        this.a.p();
                        e("请退出重新加载页面获取子账号权限");
                    } else if (jSONObjectI.has("noShare")) {
                        task.setCanNotShare(true);
                    } else if (jSONObjectI.has("runTime")) {
                        task.setLimitTime(Long.valueOf(com.frame.m1.e(jSONObjectI.optString("runTime"), "yyyy年MM月dd日")));
                        task.setCanNotShare(true);
                    }
                    if (jSONObjectI.has("canBackup")) {
                        task.setCanBackup(true);
                    }
                } else if (!AccountTool.d().k(task.getLimitUserId()) && !AccountTool.d().k(task.getCreateUserId()) && !b(task.getCreateUserId())) {
                    if (task.getCreateUserId() == null) {
                        e("此脚本限制某个用户使用，您不可用，请联系脚本创建者:没有创建者信息（非软件开发者）！");
                    } else {
                        e("此脚本限制某个用户使用，您不可用，请联系脚本创建者id：" + task.getCreateUserId() + "（非软件开发者）！");
                    }
                    return false;
                }
            }
        }
        if (task.getLimitTime() == null || System.currentTimeMillis() <= task.getLimitTime().longValue()) {
            return true;
        }
        e("授权时间已过期！");
        return false;
    }

    public void e(final String str) {
        com.frame.l1.e(new Runnable() { // from class: i.b.q1
            @Override // java.lang.Runnable
            public final void run() {
                a8.d(str);
            }
        });
    }
}
