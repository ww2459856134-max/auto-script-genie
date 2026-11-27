package i.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.x.b0;
import com.frame.a1;
import com.frame.k0;
import com.frame.l1;
import com.frame.q1;
import com.frame.v0;
import com.tencent.open.SocialConstants;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlValidationError;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    public static int G = 1000;
    public static int H = 3000;
    private static List<m> I;
    private k A;
    private int C;
    private i D;
    private boolean d;
    private ViewGroup g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f1385h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f1386i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f1387j;

    /* renamed from: k, reason: collision with root package name */
    private Activity f1388k;
    private boolean c = false;
    private long e = 0;
    private Handler f = new Handler();
    private boolean t = false;

    private boolean f(JSONObject jSONObject) {
        String strValueOf;
        String strOptString = jSONObject.optString("ignoreVersion", null);
        try {
            strValueOf = String.valueOf(v0.g().getPackageManager().getPackageInfo(v0.g().getPackageName(), 0).versionCode);
        } catch (Exception e) {
            k0.r(e);
            strValueOf = "";
        }
        if (!TextUtils.isEmpty(strOptString) && strOptString.contains(">")) {
            if (Integer.valueOf(a1.b().g()).intValue() > Integer.valueOf(strOptString.substring(strOptString.indexOf(">") + 1).trim()).intValue()) {
                return true;
            }
        }
        return !TextUtils.isEmpty(strOptString) && strOptString.contains(strValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        JSONObject jSONObjectF;
        try {
            if (this.f == null || this.f1386i == null || (jSONObjectF = a1.b().f("splash")) == null || f(jSONObjectF) || g("splash", jSONObjectF)) {
                return;
            }
            String strOptString = jSONObjectF.optString("icon");
            this.f1386i.setVisibility(0);
            com.bumptech.glide.c.t(v0.g()).w(strOptString).c().f(b0.a).q0(this.f1386i);
            this.f1386i.setOnClickListener(this);
            this.f1385h.setOnClickListener(this);
            if (jSONObjectF.optInt("full", 0) == 0) {
                try {
                    this.f1387j.setVisibility(0);
                    float fFloatValue = Float.valueOf(v0.f().getString("splash_height", "1")).floatValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = (int) (q1.d() * fFloatValue);
                    this.f1386i.setLayoutParams(layoutParams);
                } catch (Exception e) {
                    k0.r(e);
                }
            }
            int iOptInt = jSONObjectF.optInt(XmlErrorCodes.DURATION, 3);
            if (iOptInt == 0) {
                t();
                return;
            }
            this.f1385h.setVisibility(0);
            this.f.removeMessages(1);
            w(iOptInt);
        } catch (Exception e2) {
            k0.r(e2);
            t();
            if (v0.g().l()) {
                k0.r(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        if (d()) {
            h();
        } else {
            l1.e(new f(this));
        }
    }

    public boolean d() {
        try {
            if (this.g != null && this.D.i() && v0.g().j()) {
                return l();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void e() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }

    public boolean g(String str, JSONObject jSONObject) {
        String str2 = str + "_clickTime";
        float fCurrentTimeMillis = (System.currentTimeMillis() - v0.f().getLong(str2, 0L)) / 8.64E7f;
        return ((double) fCurrentTimeMillis) < jSONObject.optDouble("offsetDay", 0.0d) && fCurrentTimeMillis > 0.0f;
    }

    public void h() {
        List<m> list;
        this.f.sendEmptyMessageDelayed(1, H);
        if (this.f1388k == null || (list = I) == null || list.isEmpty()) {
            return;
        }
        try {
            switch (v0.f().getInt("splash_type", 1)) {
                case 1:
                case 4:
                    I.get(this.C).a(this, this.f1388k, this.g, this.f1385h);
                    break;
                case 2:
                case 5:
                    List<m> list2 = I;
                    int i2 = this.C + 1;
                    this.C = i2;
                    list2.get(i2 % list2.size()).a(this, this.f1388k, this.g, this.f1385h);
                    break;
                case 3:
                case 6:
                case 7:
                case 8:
                    I.get(this.C).a(this, this.f1388k, this.g, this.f1385h);
                    break;
                default:
                    l1.e(new f(this));
                    break;
            }
        } catch (Exception e) {
            l1.e(new f(this));
            k0.r(e);
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void i(Activity activity, i iVar, ViewGroup viewGroup, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        this.D = iVar;
        this.A = new k();
        this.e = System.currentTimeMillis();
        this.f1388k = activity;
        this.g = viewGroup;
        this.f1385h = textView;
        this.f1386i = imageView;
        this.f1387j = imageView2;
        this.f = new h(this, Looper.getMainLooper());
        try {
            if (v0.g().m()) {
                this.D.m();
            } else {
                j();
            }
        } catch (Exception e) {
            if (this.c) {
                o();
            } else {
                t();
            }
            if (v0.g().l()) {
                k0.r(e);
            }
        }
    }

    public void j() {
        try {
            l1.g(new Runnable() { // from class: i.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.n();
                }
            });
        } catch (Exception e) {
            t();
            k0.r(e);
        }
        try {
            a1.b().k(this.f);
            a1.b().h();
        } catch (Exception e2) {
            k0.r(e2);
        }
    }

    public boolean l() {
        try {
            if (a1.b().c() == null) {
                return true;
            }
            return (System.currentTimeMillis() - k0.b()) / 86400000 >= ((long) a1.b().c().optInt("splash_delay_day", 0));
        } catch (Exception e) {
            k0.r(e);
            return true;
        }
    }

    public void o() {
        try {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(1);
            }
            if (!this.t && this.f1388k != null) {
                this.t = true;
                this.D.l();
            }
            v0.g().b();
        } catch (Exception e) {
            k0.r(e);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!view.equals(this.f1386i)) {
            if (j.a.a.g == view.getId()) {
                o();
                return;
            }
            return;
        }
        try {
            u("splash");
            JSONObject jSONObjectF = a1.b().f("splash");
            if (this.A == null || jSONObjectF == null) {
                return;
            }
            e();
            this.d = true;
            this.A.g(this.f1388k, jSONObjectF.optString(SocialConstants.PARAM_URL), "splash", null);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void p(long j2) {
        if (this.f1385h != null) {
            int iRound = Math.round(j2 / 1000.0f);
            this.f1385h.setText(String.format("跳过 %d", Integer.valueOf(iRound)));
            this.f1385h.setClickable(iRound < 4);
        }
    }

    public void q() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(1);
            this.f.removeMessages(2);
            this.f.removeCallbacksAndMessages(null);
        }
        this.C = 0;
    }

    public void r() {
        if (this.d) {
            t();
        }
    }

    public void s() {
    }

    public void t() {
        Handler handler;
        try {
            if (this.c) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
            int i2 = G;
            if (jCurrentTimeMillis <= i2 && (handler = this.f) != null) {
                handler.sendEmptyMessageDelayed(1, i2 - jCurrentTimeMillis);
            } else {
                l1.e(new Runnable() { // from class: i.a.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.o();
                    }
                });
            }
        } catch (Exception e) {
            if (v0.g().l()) {
                k0.r(e);
            }
            l1.e(new Runnable() { // from class: i.a.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.c.o();
                }
            });
        }
    }

    public void u(String str) {
        v0.f().edit().putLong(str + "_clickTime", System.currentTimeMillis()).apply();
    }

    public void v() {
        this.c = true;
        Handler handler = this.f;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void w(int i2) {
        Handler handler = this.f;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(2, i2 * XmlValidationError.INCORRECT_ATTRIBUTE, 0));
        }
    }
}
