package com.jsj.autojs;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.frame.y0;
import com.jsj.autojs.activity.A047634d3a4;
import com.jsj.autojs.l.c0;
import com.tencent.open.SocialConstants;
import com.user.AccountTool;
import i.b.a9;
import i.b.da;
import i.b.i7;
import i.b.ja.o;
import i.h.f;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class App90534 extends v0 {
    static /* synthetic */ boolean A(final i.h.f fVar, String str, JSONObject jSONObject) throws JSONException {
        final String strOptString = jSONObject.optString(SocialConstants.PARAM_SEND_MSG);
        final int iOptInt = jSONObject.optInt("code");
        if (iOptInt == -5) {
            l1.e(new Runnable() { // from class: com.jsj.autojs.e
                @Override // java.lang.Runnable
                public final void run() {
                    App90534.y(fVar, iOptInt, strOptString);
                }
            });
            return true;
        }
        if (iOptInt == 1) {
            return false;
        }
        l1.e(new Runnable() { // from class: com.jsj.autojs.a
            @Override // java.lang.Runnable
            public final void run() {
                App90534.z(fVar, iOptInt, strOptString);
            }
        });
        return true;
    }

    static /* synthetic */ void B() {
        y0.b().f();
        if (v0.f().getLong("doTaskId", 0L) != 0) {
            y0.j("application:上次非正常退出脚本，请检查首页右上角权限，特别是自启动点进去找到我们app检测是否勾选，华为手机要改成手动管理，三项全勾选。\n如果出现多次这个情况，看看出问题的节点是不是图片识别，将其识别区域重新设置一下就可以了。");
            da.B().L1();
        }
        i7.p().d();
        try {
            com.jsj.autojs.receiver.a aVar = new com.jsj.autojs.receiver.a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            k0.q(aVar, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void y(i.h.f fVar, int i2, String str) {
        fVar.i();
        fVar.m(i2, str);
        AccountTool.d().s();
        v0.g().startActivity(new Intent(v0.g(), (Class<?>) A047634d3a4.class));
    }

    static /* synthetic */ void z(i.h.f fVar, int i2, String str) {
        fVar.m(i2, str);
        fVar.i();
    }

    public void C() {
        l1.g(new Runnable() { // from class: com.jsj.autojs.f
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                a9.b();
            }
        });
        k0.d = "102042600";
        k0.e = "wx99dde4207a4e0d5d";
        i.h.f.n(new f.c() { // from class: com.jsj.autojs.c
            @Override // i.h.f.c
            public final boolean a(i.h.f fVar, String str, JSONObject jSONObject) {
                return App90534.A(fVar, str, jSONObject);
            }
        });
        l1.g(new Runnable() { // from class: com.jsj.autojs.d
            @Override // java.lang.Runnable
            public final void run() {
                App90534.B();
            }
        });
    }

    @Override // com.frame.v0, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.frame.v0, android.app.Application
    public void onCreate() {
        super.onCreate();
        l1.a(new Handler());
        o.j(new Runnable() { // from class: com.jsj.autojs.b
            @Override // java.lang.Runnable
            public final void run() {
                c0.e().h();
            }
        });
        if (v0.g().l()) {
            C();
        }
    }
}
