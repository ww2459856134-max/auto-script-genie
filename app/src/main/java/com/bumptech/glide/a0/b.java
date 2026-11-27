package com.bumptech.glide.a0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.n;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public abstract class b {
    private static final ConcurrentMap<String, n> a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    private static String b(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    public static n c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, n> concurrentMap = a;
        n nVar = concurrentMap.get(packageName);
        if (nVar != null) {
            return nVar;
        }
        n nVarD = d(context);
        n nVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, nVarD);
        return nVarPutIfAbsent == null ? nVarD : nVarPutIfAbsent;
    }

    private static n d(Context context) {
        return new d(b(a(context)));
    }
}
