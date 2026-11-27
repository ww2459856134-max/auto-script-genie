package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public abstract class m {
    private static final Map<String, m0<e>> a = new HashMap();

    private static m0<e> b(String str, Callable<k0<e>> callable) {
        e eVarA = str == null ? null : com.airbnb.lottie.v0.h.b().a(str);
        if (eVarA != null) {
            return new m0<>(new l(eVarA));
        }
        if (str != null) {
            Map<String, m0<e>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        m0<e> m0Var = new m0<>(callable);
        if (str != null) {
            m0Var.f(new f(str));
            m0Var.e(new g(str));
            a.put(str, m0Var);
        }
        return m0Var;
    }

    private static f0 c(e eVar, String str) {
        for (f0 f0Var : eVar.i().values()) {
            if (f0Var.b().equals(str)) {
                return f0Var;
            }
        }
        return null;
    }

    public static m0<e> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static m0<e> e(Context context, String str, String str2) {
        return b(str2, new i(context.getApplicationContext(), str, str2));
    }

    public static k0<e> f(Context context, String str, String str2) {
        try {
            return str.endsWith(".zip") ? r(new ZipInputStream(context.getAssets().open(str)), str2) : h(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new k0<>((Throwable) e);
        }
    }

    public static m0<e> g(InputStream inputStream, String str) {
        return b(str, new k(inputStream, str));
    }

    public static k0<e> h(InputStream inputStream, String str) {
        return i(inputStream, str, true);
    }

    private static k0<e> i(InputStream inputStream, String str, boolean z) throws IOException {
        try {
            return j(com.airbnb.lottie.x0.l0.e.u(m.f.a(m.f.c(inputStream))), str);
        } finally {
            if (z) {
                com.airbnb.lottie.y0.h.c(inputStream);
            }
        }
    }

    public static k0<e> j(com.airbnb.lottie.x0.l0.e eVar, String str) {
        return k(eVar, str, true);
    }

    private static k0<e> k(com.airbnb.lottie.x0.l0.e eVar, String str, boolean z) throws IOException {
        try {
            try {
                e eVarA = com.airbnb.lottie.x0.u.a(eVar);
                if (str != null) {
                    com.airbnb.lottie.v0.h.b().c(str, eVarA);
                }
                k0<e> k0Var = new k0<>(eVarA);
                if (z) {
                    com.airbnb.lottie.y0.h.c(eVar);
                }
                return k0Var;
            } catch (Exception e) {
                k0<e> k0Var2 = new k0<>(e);
                if (z) {
                    com.airbnb.lottie.y0.h.c(eVar);
                }
                return k0Var2;
            }
        } catch (Throwable th) {
            if (z) {
                com.airbnb.lottie.y0.h.c(eVar);
            }
            throw th;
        }
    }

    public static m0<e> l(Context context, int i2) {
        return m(context, i2, u(context, i2));
    }

    public static m0<e> m(Context context, int i2, String str) {
        return b(str, new j(new WeakReference(context), context.getApplicationContext(), i2));
    }

    public static k0<e> n(Context context, int i2) {
        return o(context, i2, u(context, i2));
    }

    public static k0<e> o(Context context, int i2, String str) {
        try {
            return h(context.getResources().openRawResource(i2), str);
        } catch (Resources.NotFoundException e) {
            return new k0<>((Throwable) e);
        }
    }

    public static m0<e> p(Context context, String str) {
        return q(context, str, "url_" + str);
    }

    public static m0<e> q(Context context, String str, String str2) {
        return b(str2, new h(context, str, str2));
    }

    public static k0<e> r(ZipInputStream zipInputStream, String str) throws IOException {
        try {
            return s(zipInputStream, str);
        } finally {
            com.airbnb.lottie.y0.h.c(zipInputStream);
        }
    }

    private static k0<e> s(ZipInputStream zipInputStream, String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            e eVarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    eVarB = k(com.airbnb.lottie.x0.l0.e.u(m.f.a(m.f.c(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp")) {
                    map.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (eVarB == null) {
                return new k0<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                f0 f0VarC = c(eVarB, (String) entry.getKey());
                if (f0VarC != null) {
                    f0VarC.f(com.airbnb.lottie.y0.h.l((Bitmap) entry.getValue(), f0VarC.e(), f0VarC.c()));
                }
            }
            for (Map.Entry<String, f0> entry2 : eVarB.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new k0<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                com.airbnb.lottie.v0.h.b().c(str, eVarB);
            }
            return new k0<>(eVarB);
        } catch (IOException e) {
            return new k0<>((Throwable) e);
        }
    }

    private static boolean t(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static String u(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(t(context) ? "_night_" : "_day_");
        sb.append(i2);
        return sb.toString();
    }
}
