package com.jsj.autojs.l;

import android.content.SharedPreferences;
import com.frame.v0;
import com.google.gson.Gson;
import com.jsj.autojs.model.AppConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class x {
    private static x d;
    private Set<AppConfig> a;
    private HashMap<String, AppConfig> b;
    SharedPreferences c = v0.g().getSharedPreferences("noAd", 0);

    private x() {
        try {
            this.a = (Set) new Gson().k(v0.e().getString("app_config", null), com.google.gson.k0.a.c(Set.class, AppConfig.class).e());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            this.a = new HashSet();
        }
    }

    public static x e() {
        x xVar = d;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        d = xVar2;
        return xVar2;
    }

    public void a(AppConfig appConfig) {
        this.b.put(appConfig.getPackageName(), appConfig);
        this.a.add(appConfig);
    }

    public boolean b(AppConfig appConfig) {
        if (appConfig.getTheme() != null || appConfig.isSkipAd() || appConfig.getColor() != null) {
            return false;
        }
        this.b.remove(appConfig);
        this.a.remove(appConfig);
        return true;
    }

    public void c(AppConfig appConfig) {
        appConfig.setSkipAd(false);
        b(appConfig);
    }

    public AppConfig d(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
            for (AppConfig appConfig : this.a) {
                this.b.put(appConfig.getPackageName(), appConfig);
            }
        }
        return this.b.get(str);
    }

    public long f(String str) {
        return this.c.getLong(str, 0L);
    }

    public HashMap<String, AppConfig> g() {
        HashMap<String, AppConfig> map = new HashMap<>();
        for (AppConfig appConfig : this.a) {
            if (appConfig.isSkipAd()) {
                map.put(appConfig.getPackageName(), appConfig);
            }
        }
        return map;
    }

    public void h() {
        v0.e().edit().putString("app_config", new Gson().s(this.a)).apply();
    }
}
