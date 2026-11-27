package h.e.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
class i extends p {
    private static final Class<?> b;
    private static final Constructor<?> c;
    private static final Method d;
    private static final Method e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        c = constructor;
        b = cls;
        d = method2;
        e = method;
    }

    i() {
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // h.e.d.p
    public Typeface b(Context context, androidx.core.content.c.d dVar, Resources resources, int i2) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (androidx.core.content.c.e eVar : dVar.a()) {
            ByteBuffer byteBufferB = q.b(context, resources, eVar.b());
            if (byteBufferB == null || !k(objN, byteBufferB, eVar.c(), eVar.e(), eVar.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // h.e.d.p
    public Typeface c(Context context, CancellationSignal cancellationSignal, h.e.g.o[] oVarArr, int i2) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        h.d.i iVar = new h.d.i();
        for (h.e.g.o oVar : oVarArr) {
            Uri uriD = oVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) iVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = q.f(context, cancellationSignal, uriD);
                iVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, oVar.c(), oVar.e(), oVar.f())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i2);
    }
}
