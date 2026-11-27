package com.user;

import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.frame.k0;
import com.frame.l1;
import com.frame.m1;
import com.frame.n0;
import com.frame.n1;
import com.frame.p0;
import com.frame.v0;
import com.google.gson.Gson;
import com.user.model.WechatModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AccountTool {
    private static AccountTool d = null;
    public static int e = 5;
    private volatile WechatModel b;
    private Gson a = new Gson();
    private final s c = new s();

    public static class CheckAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void convert(BaseViewHolder baseViewHolder, String str) {
            baseViewHolder.setText(j.f.a.a, str);
        }
    }

    private AccountTool() {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void p(r rVar, Runnable runnable) {
        try {
            this.c.c(rVar, runnable);
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    private void b(final r rVar, Exception exc) {
        synchronized (this.c) {
            if (this.c.e(rVar)) {
                v0.f().edit().remove("getCurrentUserInfo").apply();
                List<Runnable> listD = this.c.d(rVar, false, SystemClock.elapsedRealtime());
                k0.r(exc);
                for (final Runnable runnable : listD) {
                    l1.e(new Runnable() { // from class: com.user.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.c.p(rVar, runnable);
                        }
                    });
                }
            }
        }
    }

    public static synchronized AccountTool d() {
        if (d == null) {
            d = new AccountTool();
        }
        return d;
    }

    private void i(WechatModel wechatModel) {
        if (this.b == null || wechatModel == null || !String.valueOf(this.b.getId()).equals(String.valueOf(wechatModel.getId())) || !TextUtils.equals(this.b.getToken(), wechatModel.getToken())) {
            this.c.g();
            v0.f().edit().remove("getCurrentUserInfo").apply();
        }
    }

    private void t() {
        SharedPreferences sharedPreferencesF = v0.f();
        String string = sharedPreferencesF.getString("uData", null);
        if (TextUtils.isEmpty(string)) {
            sharedPreferencesF.edit().remove("isLogin").remove("isVip").apply();
            if (m()) {
                System.exit(0);
                Process.killProcess(Process.myPid());
                k0.i("pirateApp");
                return;
            }
            return;
        }
        try {
            this.b = (WechatModel) this.a.j(string, WechatModel.class);
            if (!m()) {
                sharedPreferencesF.edit().putInt("isLogin", 1).remove("isVip").apply();
            } else {
                sharedPreferencesF.edit().putLong("vipConfigId", this.b.getVipConfigId() == null ? 0L : this.b.getVipConfigId().longValue()).putInt("isVip", 1).putInt("isLogin", 1).putString("splash_vip_time", String.valueOf(m1.c("yyyy-MM-dd HH:mm", this.b.getVipEndTime()))).putBoolean("need_refresh_use", false).apply();
            }
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void r(r rVar, Long l2, String str, String str2) {
        try {
            if (this.c.e(rVar)) {
                ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
                arrayList.add(new BasicNameValuePair("token", str));
                arrayList.add(new BasicNameValuePair("u", str2));
                JSONObject jSONObject = new JSONObject(p0.h().p(k0.g + "/getNewUserInfo", arrayList));
                synchronized (this.c) {
                    if (this.c.e(rVar)) {
                        if (jSONObject.optInt("code") != 1) {
                            v0.f().edit().remove("getCurrentUserInfo").apply();
                            this.c.d(rVar, false, SystemClock.elapsedRealtime());
                            return;
                        }
                        String strC = n1.c(jSONObject.getString("json"), "4jso$dkm#kkd*lsdk@");
                        WechatModel wechatModel = (WechatModel) this.a.j(strC, WechatModel.class);
                        if (wechatModel == null || l2 == null || !l2.equals(wechatModel.getId()) || !TextUtils.equals(str, wechatModel.getToken())) {
                            throw new IllegalStateException("Invalid refreshed account identity");
                        }
                        if (wechatModel.getIsVip() >= 1) {
                            m1.c("yyyy-MM-dd HH:mm", wechatModel.getVipEndTime());
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (!v0.f().edit().putString("uData", strC).putLong("uTime", jCurrentTimeMillis).putLong("getCurrentUserInfo", jCurrentTimeMillis).commit()) {
                            v0.f().edit().remove("getCurrentUserInfo").apply();
                            throw new IOException("Unable to persist refreshed account");
                        }
                        t();
                        n0.i("uisfc", 0);
                        Iterator<Runnable> it = this.c.d(rVar, true, SystemClock.elapsedRealtime()).iterator();
                        while (it.hasNext()) {
                            o(rVar, it.next());
                        }
                    }
                }
            }
        } catch (Exception e2) {
            b(rVar, e2);
        }
    }

    private void z(boolean z, Runnable runnable, Runnable runnable2) {
        synchronized (this.c) {
            if (this.b == null) {
                return;
            }
            long jF = this.c.f(SystemClock.elapsedRealtime());
            if (jF > 0) {
                if (!z) {
                    l1.j("请在 " + ((jF + 999) / 1000) + " 秒后重试");
                }
                return;
            }
            long j2 = v0.f().getLong("getCurrentUserInfo", 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j2;
            final r rVarB = this.c.b(SystemClock.elapsedRealtime(), z && j2 > 0 && jCurrentTimeMillis >= 0 && jCurrentTimeMillis < 3600000, runnable, runnable2);
            if (rVarB == null) {
                return;
            }
            final Long id = this.b.getId();
            final String token = this.b.getToken();
            try {
                final String strI = p0.h().i();
                l1.g(new Runnable() { // from class: com.user.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.r(rVarB, id, token, strI);
                    }
                });
            } catch (Exception e2) {
                b(rVarB, e2);
            }
        }
    }

    public void A(Runnable runnable) {
        z(true, null, runnable);
    }

    public WechatModel c() {
        return this.b;
    }

    public String e() {
        if (this.b != null) {
            return this.b.getToken();
        }
        return null;
    }

    public String f() {
        if (this.b != null) {
            return String.valueOf(this.b.getId());
        }
        return null;
    }

    public Long g() {
        if (this.b != null) {
            return this.b.getId();
        }
        return null;
    }

    public Long h() {
        if (this.b != null) {
            return this.b.getPid();
        }
        return null;
    }

    public boolean j() {
        return v0.f().getInt("isLogin", 0) == 1 && this.b != null;
    }

    public boolean k(Long l2) {
        return this.b != null && this.b.getId().equals(l2);
    }

    public boolean l() {
        if (this.b != null && this.b.getVipEndTime() != null) {
            try {
                return m1.e(this.b.getVipEndTime(), "yyyy-MM-dd HH:mm") - System.currentTimeMillis() > 315360000000L;
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
        return false;
    }

    public boolean m() {
        return this.b != null && this.b.getIsVip() >= 1;
    }

    public boolean n() {
        return (d().m() || TextUtils.isEmpty(this.b.getVipEndTime())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[Catch: all -> 0x0096, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0022, B:8:0x0054, B:12:0x005c, B:13:0x0094, B:11:0x0059), top: B:18:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s() {
        File file;
        synchronized (this.c) {
            this.c.g();
            v0.g().getSharedPreferences("local_keyword_page_rules", 0).edit().clear().commit();
            if (this.b != null) {
                try {
                    file = new File(v0.g().getFilesDir() + "/desktopDir/share_" + this.b.getId() + ".png");
                } catch (Exception e2) {
                    k0.r(e2);
                }
                if (file.exists()) {
                    file.delete();
                    v0.f().edit().remove("isLogin").remove("isVip").remove("commitPromote").remove("uData").remove("unReadCount").remove("token").remove("getCurrentUserInfo").apply();
                    this.b = null;
                } else {
                    v0.f().edit().remove("isLogin").remove("isVip").remove("commitPromote").remove("uData").remove("unReadCount").remove("token").remove("getCurrentUserInfo").apply();
                    this.b = null;
                }
            }
        }
    }

    public void v() {
        synchronized (this.c) {
            String string = v0.f().getString("uData", null);
            if (TextUtils.isEmpty(string)) {
                this.c.g();
                this.b = null;
            } else {
                try {
                    WechatModel wechatModel = (WechatModel) this.a.j(string, WechatModel.class);
                    if (wechatModel != null && wechatModel.getIsVip() == 1) {
                        if (System.currentTimeMillis() > m1.c("yyyy-MM-dd HH:mm", this.b.getVipEndTime())) {
                            wechatModel.setIsVip(0);
                            w(wechatModel);
                            t();
                        } else {
                            if (System.currentTimeMillis() - v0.f().getLong("uTime", 0L) > 259200000) {
                                v0.f().edit().remove("isVip").remove("isLogin").apply();
                            }
                        }
                    }
                } catch (Exception e2) {
                    k0.r(e2);
                }
            }
        }
    }

    public void w(WechatModel wechatModel) {
        synchronized (this.c) {
            i(wechatModel);
            this.b = wechatModel;
            try {
                v0.f().edit().putString("uData", new Gson().s(wechatModel)).putLong("uTime", System.currentTimeMillis()).apply();
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    public void x(String str) {
        synchronized (this.c) {
            try {
                String strC = n1.c(str, "4jso$dkm#kkd*lsdk@");
                i((WechatModel) this.a.j(strC, WechatModel.class));
                v0.f().edit().putString("uData", strC).putLong("uTime", System.currentTimeMillis()).apply();
                t();
            } catch (Exception e2) {
                k0.r(e2);
            }
        }
    }

    public void y(Runnable runnable, Runnable runnable2) {
        z(false, runnable, runnable2);
    }
}
