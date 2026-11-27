package com.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.act.QQEntryActivity;
import com.frame.k0;
import com.frame.l1;
import com.frame.v0;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p {
    private static p e;
    private Tencent a;
    private IUiListener b;
    private a c;
    IUiListener d = new o(this);

    public interface a {
        void a(String str, String str2);

        void b(String str);
    }

    private p() {
        if (TextUtils.isEmpty(k0.d)) {
            Log.e("QQ初始化失败", "QQ初始化失败--未设置APP_ID");
        }
    }

    public static p g() {
        if (e == null) {
            e = new p();
        }
        return e;
    }

    private void i() {
        if (this.a == null) {
            this.a = Tencent.createInstance(k0.d, v0.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(int i2, int i3, Intent intent) {
        Tencent.onActivityResultData(i2, i3, intent, this.b);
        if (i2 == 10100) {
            if (i3 == 10103 || i3 == 10104 || i3 == 11103) {
                Tencent.handleResultData(intent, this.b);
            }
        }
    }

    public void a(Activity activity, String str, String str2, String str3) {
        b(activity, str, str2, str3, null);
    }

    public void b(Activity activity, String str, String str2, String str3, IUiListener iUiListener) {
        if (iUiListener == null) {
            iUiListener = new q(this, null);
        }
        this.b = iUiListener;
        i();
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", str);
        bundle.putString("summary", str2);
        bundle.putString("targetUrl", str3);
        bundle.putString("imageUrl", "https://h5.skyingidea.com/img/qq_share.jpg");
        bundle.putString("appName", v0.g().getString(j.f.b.a));
        if (activity != null) {
            this.a.shareToQQ(activity, bundle, this.b);
        }
    }

    public void c(Activity activity, String str, String str2, String str3) {
        d(activity, str, str2, str3, null);
    }

    public void d(Activity activity, String str, String str2, String str3, IUiListener iUiListener) {
        if (iUiListener == null) {
            iUiListener = new q(this, null);
        }
        this.b = iUiListener;
        i();
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 0);
        bundle.putString("title", str);
        bundle.putString("summary", str2);
        bundle.putString("targetUrl", str3);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://h5.skyingidea.com/img/launcher.png");
        bundle.putStringArrayList("imageUrl", arrayList);
        if (activity != null) {
            this.a.shareToQzone(activity, bundle, this.b);
        }
    }

    public Tencent f() {
        Tencent tencent = this.a;
        if (tencent != null) {
            return tencent;
        }
        i();
        Tencent tencent2 = this.a;
        if (tencent2 != null) {
            return tencent2;
        }
        return null;
    }

    public IUiListener h() {
        return this.d;
    }

    public boolean j() {
        i();
        return this.a.isQQInstalled(v0.g());
    }

    public void m(final int i2, final int i3, final Intent intent) {
        l1.g(new Runnable() { // from class: com.user.f
            @Override // java.lang.Runnable
            public final void run() {
                this.c.l(i2, i3, intent);
            }
        });
    }

    public void n(a aVar) {
        this.b = this.d;
        this.c = aVar;
        i();
        v0.g().startActivity(new Intent(v0.g(), (Class<?>) QQEntryActivity.class));
    }
}
