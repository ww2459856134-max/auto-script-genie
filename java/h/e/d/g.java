package h.e.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public abstract class g {
    private static final p a;
    private static final h.d.g<String, Typeface> b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            a = new l();
        } else if (i2 >= 28) {
            a = new k();
        } else if (i2 >= 26) {
            a = new j();
        } else if (i2 >= 24 && i.m()) {
            a = new i();
        } else if (i2 >= 21) {
            a = new h();
        } else {
            a = new p();
        }
        b = new h.d.g<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, h.e.g.o[] oVarArr, int i2) {
        return a.c(context, cancellationSignal, oVarArr, i2);
    }

    public static Typeface c(Context context, androidx.core.content.c.c cVar, Resources resources, int i2, int i3, androidx.core.content.c.m mVar, Handler handler, boolean z) throws NoSuchFieldException {
        Typeface typefaceB;
        if (cVar instanceof androidx.core.content.c.f) {
            androidx.core.content.c.f fVar = (androidx.core.content.c.f) cVar;
            Typeface typefaceH = h(fVar.c());
            if (typefaceH != null) {
                if (mVar != null) {
                    mVar.b(typefaceH, handler);
                }
                return typefaceH;
            }
            boolean z2 = !z ? mVar != null : fVar.a() != 0;
            int iD = z ? fVar.d() : -1;
            typefaceB = h.e.g.q.a(context, fVar.b(), i3, z2, iD, androidx.core.content.c.m.c(handler), new f(mVar));
        } else {
            typefaceB = a.b(context, (androidx.core.content.c.d) cVar, resources, i3);
            if (mVar != null) {
                if (typefaceB != null) {
                    mVar.b(typefaceB, handler);
                } else {
                    mVar.a(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            b.d(e(resources, i2, i3), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        Typeface typefaceE = a.e(context, resources, i2, str, i3);
        if (typefaceE != null) {
            b.d(e(resources, i2, i3), typefaceE);
        }
        return typefaceE;
    }

    private static String e(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + ProcessIdUtil.DEFAULT_PROCESSID + i2 + ProcessIdUtil.DEFAULT_PROCESSID + i3;
    }

    public static Typeface f(Resources resources, int i2, int i3) {
        return b.c(e(resources, i2, i3));
    }

    private static Typeface g(Context context, Typeface typeface, int i2) throws NoSuchFieldException {
        p pVar = a;
        androidx.core.content.c.d dVarI = pVar.i(typeface);
        if (dVarI == null) {
            return null;
        }
        return pVar.b(context, dVarI, context.getResources(), i2);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
