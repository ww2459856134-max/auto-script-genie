package i.a;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.act.WebAct;
import com.frame.a1;
import com.frame.i0;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {
    private boolean f(JSONObject jSONObject) {
        try {
            SharedPreferences sharedPreferencesF = v0.f();
            if (v0.g().h() < jSONObject.optInt("minStartCount")) {
                return false;
            }
            int iOptInt = jSONObject.optInt("isLogin", 0);
            boolean z = sharedPreferencesF.getInt("isLogin", 0) == 1;
            if (iOptInt == 1 && !z) {
                return false;
            }
            if (iOptInt == 2 && z) {
                return false;
            }
            if (!z) {
                return true;
            }
            long jOptLong = jSONObject.optLong("vipConfigId", 0L);
            if (jOptLong != 0 && sharedPreferencesF.getLong("vipConfigId", 0L) != jOptLong) {
                return false;
            }
            int iOptInt2 = jSONObject.optInt("isVip", 0);
            boolean z2 = sharedPreferencesF.getInt("isVip", 0) == 1;
            if (iOptInt2 != 1 || z2) {
                return (iOptInt2 == 2 && z2) ? false : true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(WeakReference weakReference, String str, String str2) {
        g((Activity) weakReference.get(), str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(final String str, View.OnClickListener onClickListener, long j2, final WeakReference weakReference, final String str2, View view) {
        try {
            if (!TextUtils.isEmpty(str)) {
                k0.i(str);
            }
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (j2 == 0) {
                g((Activity) weakReference.get(), str2, str, null);
            } else {
                l1.f(new Runnable() { // from class: i.a.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.c.i(weakReference, str2, str);
                    }
                }, j2);
            }
            JSONObject jSONObjectF = a1.b().f(str);
            if (jSONObjectF != null && jSONObjectF.optInt("dayOneClick", 0) == 1) {
                view.setVisibility(8);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            l(str);
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public void a(String str, String str2, View view, Activity activity) {
        b(str, str2, view, activity, 0L, null);
    }

    public void b(final String str, final String str2, View view, Activity activity, final long j2, final View.OnClickListener onClickListener) {
        final WeakReference weakReference = new WeakReference(activity);
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: i.a.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.c.k(str, onClickListener, j2, weakReference, str2, view2);
            }
        });
    }

    public void c(String str, View view, ImageView imageView, TextView textView, Activity activity, String str2) {
        d(str, view, imageView, textView, activity, str2, false, 0L, null, 0);
    }

    @Deprecated
    public void d(String str, View view, ImageView imageView, TextView textView, Activity activity, String str2, boolean z, long j2, View.OnClickListener onClickListener, int i2) {
        try {
            if (a1.b().c() == null) {
                if (!TextUtils.isEmpty(str2)) {
                    a(str, str2, view, activity);
                    return;
                }
                if (onClickListener != null) {
                    if (z) {
                        if (view != null) {
                            view.setOnClickListener(onClickListener);
                            return;
                        }
                        return;
                    } else {
                        if (view != null) {
                            view.setVisibility(8);
                        }
                        if (imageView != null) {
                            imageView.setVisibility(8);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (a1.b().c().isNull(str) && !TextUtils.isEmpty(str2)) {
                a(str, str2, view, activity);
                return;
            }
            if (a1.b().c().isNull(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    a(str, str2, view, activity);
                    return;
                }
                if (z) {
                    if (view != null) {
                        view.setOnClickListener(onClickListener);
                        return;
                    }
                    return;
                } else {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
            JSONObject jSONObjectF = a1.b().f(str);
            if (!f(jSONObjectF)) {
                if (view != null) {
                    view.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            String str3 = str + "_clickTime";
            float fCurrentTimeMillis = (System.currentTimeMillis() - v0.f().getLong(str3, 0L)) / 8.64E7f;
            boolean z2 = ((double) fCurrentTimeMillis) < jSONObjectF.optDouble("offsetDay", 0.0d) && fCurrentTimeMillis > 0.0f;
            String strOptString = jSONObjectF.optString("ignoreVersion", null);
            if ((TextUtils.isEmpty(strOptString) || !strOptString.contains(a1.b().g())) && !e(str, jSONObjectF) && !z2) {
                view.setVisibility(0);
                String strOptString2 = jSONObjectF.optString("icon");
                String strOptString3 = jSONObjectF.optString("label");
                String strOptString4 = jSONObjectF.optString(SocialConstants.PARAM_URL);
                if (textView != null && !TextUtils.isEmpty(strOptString3)) {
                    textView.setText(strOptString3);
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        com.bumptech.glide.c.t(v0.g()).w(strOptString2).R(i2).q0(imageView);
                    }
                }
                b(str, strOptString4, view, activity, j2, onClickListener);
                return;
            }
            if (z) {
                return;
            }
            view.setVisibility(8);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } catch (Exception e) {
            k0.r(e);
        }
    }

    public boolean e(String str, JSONObject jSONObject) {
        if (jSONObject.isNull("dayOneClick") || jSONObject.optInt("dayOneClick") != 1) {
            return false;
        }
        String str2 = str + "_dayOneClick";
        Log.d(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "checkDayOneClicked: " + Calendar.getInstance().toString());
        return v0.f().getLong(str2, 0L) == System.currentTimeMillis() / 43200000;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0106 -> B:58:0x011f). Please report as a decompilation issue!!! */
    public void g(Activity activity, String str, String str2, String str3) {
        if (activity == null) {
            activity = v0.g().d();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
        } catch (Exception e) {
            k0.r(e);
        }
        if (str.startsWith("broadcast_receiver://")) {
            k0.s(new Intent(str.replace("broadcast_receiver://", "")));
            return;
        }
        if (str.startsWith("file://")) {
            Intent intent = new Intent(activity, (Class<?>) WebAct.class);
            intent.putExtra(SocialConstants.PARAM_URL, str);
            intent.putExtra("key", str2);
            intent.putExtra("title", str3);
            if (activity == null) {
                v0.g().startActivity(intent);
                return;
            } else {
                activity.startActivity(intent);
                return;
            }
        }
        if (str.startsWith("market")) {
            i0.b(str.split("=")[1]);
            return;
        }
        if (str.startsWith("web://")) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str.substring(6)));
                if (activity == null) {
                    intent2.setFlags(268435456);
                    v0.g().startActivity(intent2);
                } else {
                    activity.startActivity(intent2);
                }
                return;
            } catch (Exception e2) {
                k0.i("no_webapp");
                k0.r(e2);
                return;
            }
        }
        if (str.toLowerCase().startsWith("http") && (k0.g(v0.g()) || "privacy".equals(str2))) {
            Intent intent3 = new Intent(activity, (Class<?>) WebAct.class);
            intent3.putExtra(SocialConstants.PARAM_URL, str);
            intent3.putExtra("key", str2);
            intent3.putExtra("title", str3);
            if (activity != null) {
                activity.startActivity(intent3);
                return;
            } else {
                intent3.setFlags(268435456);
                v0.g().startActivity(intent3);
                return;
            }
        }
        try {
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setData(Uri.parse(str));
            if (activity == null) {
                intent4.setFlags(268435456);
                v0.g().startActivity(intent4);
            } else {
                activity.startActivity(intent4);
            }
        } catch (Exception e3) {
            Toast.makeText(v0.g(), "未找到可用的应用市场！", 0).show();
            k0.i("no_webapp");
            k0.r(e3);
        }
        return;
        k0.r(e);
    }

    public void l(String str) {
        v0.f().edit().putLong(str + "_dayOneClick", System.currentTimeMillis() / 43200000).putLong(str + "_clickTime", System.currentTimeMillis()).apply();
    }
}
