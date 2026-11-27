package i.b;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u8 {
    private boolean a;

    public void a(String str, Runnable runnable) {
        try {
            str = com.frame.n1.b(str);
        } catch (Exception unused) {
        }
        try {
            this.a = true;
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("id", str));
            arrayList.add(new BasicNameValuePair("pn", com.frame.v0.g().getPackageName()));
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/bindChannel", arrayList));
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.e2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g().d(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
            } else {
                runnable.run();
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void b(String str, Long l2, Runnable runnable) {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("qrCode", str));
            arrayList.add(new BasicNameValuePair("subUserId", l2 + ""));
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/confirmSubQrLogin", arrayList));
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.i2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g().d(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
            } else {
                com.frame.l1.e(runnable);
            }
        } catch (Exception e) {
            com.frame.l1.e(new Runnable() { // from class: i.b.f2
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(com.frame.v0.g(), "出错了", 0).show();
                }
            });
            com.frame.k0.r(e);
        }
    }

    public void c(String str, Runnable runnable) {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("qrCode", str));
            arrayList.add(new BasicNameValuePair("token", AccountTool.d().e()));
            arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/confirmQrLogin", arrayList));
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.g2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
            } else {
                AccountTool.d().s();
                com.frame.l1.e(runnable);
            }
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void j(String str, Runnable runnable) {
        try {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("qrCode", str));
            arrayList.add(new BasicNameValuePair("pn", com.frame.v0.g().getPackageName()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/checkQrLogin", arrayList));
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.h2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
                return;
            }
            this.a = false;
            AccountTool.d().x(jSONObject.optString("json"));
            com.frame.a1.b().a();
            com.frame.l1.e(runnable);
        } catch (Exception e) {
            com.frame.k0.r(e);
        }
    }

    public void k() {
        this.a = false;
    }

    public void l(String str, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        try {
            this.a = true;
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("qrCode", str));
            arrayList.add(new BasicNameValuePair("pn", com.frame.v0.g().getPackageName()));
            arrayList.add(new BasicNameValuePair("u", com.frame.p0.h().i()));
            final JSONObject jSONObject = new JSONObject(com.frame.p0.h().p(com.frame.k0.g + "/submitQrLogin", arrayList));
            if (jSONObject.optInt("code") != 1) {
                com.frame.l1.e(new Runnable() { // from class: i.b.d2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(com.frame.v0.g().d(), jSONObject.optString(SocialConstants.PARAM_SEND_MSG), 0).show();
                    }
                });
                return;
            }
            com.frame.l1.e(runnable);
            SystemClock.sleep(2000L);
            for (int i2 = 0; i2 < 40; i2++) {
                if (this.a) {
                    SystemClock.sleep(3000L);
                    j(str, runnable2);
                }
            }
        } catch (Exception e) {
            com.frame.l1.e(runnable3);
            com.frame.k0.r(e);
        }
    }
}
