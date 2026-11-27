package i.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class g8 {
    private static g8 b = null;
    public static boolean c = true;
    private List<ResolveInfo> a;

    private g8(Context context) {
        this.a = c(context);
    }

    public static g8 d() {
        g8 g8Var = b;
        if (g8Var != null) {
            return g8Var;
        }
        g8 g8Var2 = new g8(com.frame.v0.g());
        b = g8Var2;
        return g8Var2;
    }

    public ResolveInfo a(String str) {
        List<ResolveInfo> list = this.a;
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                try {
                    if (this.a.get(i2).activityInfo != null && str.equals(this.a.get(i2).activityInfo.packageName)) {
                        return this.a.get(i2);
                    }
                } catch (Exception e) {
                    com.frame.k0.r(e);
                }
            }
        }
        return null;
    }

    public List<ResolveInfo> b() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a;
    }

    public List<ResolveInfo> c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        String packageName = com.frame.v0.g().getPackageName();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
            ResolveInfo resolveInfo = listQueryIntentActivities.get(i2);
            try {
                if (c && packageName.equals(resolveInfo.activityInfo.packageName)) {
                    listQueryIntentActivities.remove(resolveInfo);
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
                listQueryIntentActivities.remove(resolveInfo);
            }
        }
        return listQueryIntentActivities;
    }

    public String e(String str) {
        List<ResolveInfo> list = this.a;
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            try {
                if (this.a.get(i2).activityInfo != null && str.equals(this.a.get(i2).activityInfo.packageName)) {
                    return this.a.get(i2).activityInfo.applicationInfo != null ? this.a.get(i2).activityInfo.applicationInfo.loadLabel(com.frame.v0.g().getPackageManager()).toString() : "";
                }
            } catch (Exception e) {
                com.frame.k0.r(e);
            }
        }
        return "";
    }

    public void f(List<ResolveInfo> list) {
        this.a = list;
    }
}
