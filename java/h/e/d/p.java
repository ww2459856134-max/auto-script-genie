package h.e.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class p {

    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, androidx.core.content.c.d> a = new ConcurrentHashMap<>();

    p() {
    }

    private void a(Typeface typeface, androidx.core.content.c.d dVar) throws NoSuchFieldException {
        long j2 = j(typeface);
        if (j2 != 0) {
            this.a.put(Long.valueOf(j2), dVar);
        }
    }

    private androidx.core.content.c.e f(androidx.core.content.c.d dVar, int i2) {
        return (androidx.core.content.c.e) g(dVar.a(), i2, new n(this));
    }

    private static <T> T g(T[] tArr, int i2, o<T> oVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(oVar.a(t2) - i3) * 2) + (oVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > iAbs) {
                t = t2;
                i4 = iAbs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) throws NoSuchFieldException {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public Typeface b(Context context, androidx.core.content.c.d dVar, Resources resources, int i2) throws NoSuchFieldException {
        androidx.core.content.c.e eVarF = f(dVar, i2);
        if (eVarF == null) {
            return null;
        }
        Typeface typefaceD = g.d(context, resources, eVarF.b(), eVarF.a(), i2);
        a(typefaceD, dVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, h.e.g.o[] oVarArr, int i2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (oVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(oVarArr, i2).d());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface typefaceD = d(context, inputStreamOpenInputStream);
            q.a(inputStreamOpenInputStream);
            return typefaceD;
        } catch (IOException unused2) {
            q.a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            q.a(inputStream);
            throw th;
        }
    }

    protected Typeface d(Context context, InputStream inputStream) {
        File fileE = q.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (q.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i2, String str, int i3) {
        File fileE = q.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (q.c(fileE, resources, i2)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected h.e.g.o h(h.e.g.o[] oVarArr, int i2) {
        return (h.e.g.o) g(oVarArr, i2, new m(this));
    }

    androidx.core.content.c.d i(Typeface typeface) throws NoSuchFieldException {
        long j2 = j(typeface);
        if (j2 == 0) {
            return null;
        }
        return this.a.get(Long.valueOf(j2));
    }
}
