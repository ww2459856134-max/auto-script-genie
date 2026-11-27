package h.e.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.auto.exceldeps.log4j.util.ProcessIdUtil;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.apache.xmlbeans.XmlValidationError;

/* loaded from: classes.dex */
abstract class m {
    static final h.d.g<String, Typeface> a = new h.d.g<>(16);
    private static final ExecutorService b = v.a("fonts-androidx", 10, XmlValidationError.UNDEFINED);
    static final Object c = new Object();
    static final h.d.i<String, ArrayList<h.e.i.a<l>>> d = new h.d.i<>();

    private static String a(g gVar, int i2) {
        return gVar.d() + ProcessIdUtil.DEFAULT_PROCESSID + i2;
    }

    @SuppressLint({"WrongConstant"})
    private static int b(n nVar) {
        int i2 = 1;
        if (nVar.c() != 0) {
            return nVar.c() != 1 ? -3 : -2;
        }
        o[] oVarArrB = nVar.b();
        if (oVarArrB != null && oVarArrB.length != 0) {
            i2 = 0;
            for (o oVar : oVarArrB) {
                int iB = oVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i2;
    }

    static l c(String str, Context context, g gVar, int i2) {
        h.d.g<String, Typeface> gVar2 = a;
        Typeface typefaceC = gVar2.c(str);
        if (typefaceC != null) {
            return new l(typefaceC);
        }
        try {
            n nVarD = f.d(context, gVar, null);
            int iB = b(nVarD);
            if (iB != 0) {
                return new l(iB);
            }
            Typeface typefaceB = h.e.d.g.b(context, null, nVarD.b(), i2);
            if (typefaceB == null) {
                return new l(-3);
            }
            gVar2.d(str, typefaceB);
            return new l(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new l(-1);
        }
    }

    static Typeface d(Context context, g gVar, int i2, Executor executor, c cVar) {
        String strA = a(gVar, i2);
        Typeface typefaceC = a.c(strA);
        if (typefaceC != null) {
            cVar.b(new l(typefaceC));
            return typefaceC;
        }
        i iVar = new i(cVar);
        synchronized (c) {
            h.d.i<String, ArrayList<h.e.i.a<l>>> iVar2 = d;
            ArrayList<h.e.i.a<l>> arrayList = iVar2.get(strA);
            if (arrayList != null) {
                arrayList.add(iVar);
                return null;
            }
            ArrayList<h.e.i.a<l>> arrayList2 = new ArrayList<>();
            arrayList2.add(iVar);
            iVar2.put(strA, arrayList2);
            j jVar = new j(strA, context, gVar, i2);
            if (executor == null) {
                executor = b;
            }
            v.b(executor, jVar, new k(strA));
            return null;
        }
    }

    static Typeface e(Context context, g gVar, c cVar, int i2, int i3) {
        String strA = a(gVar, i2);
        Typeface typefaceC = a.c(strA);
        if (typefaceC != null) {
            cVar.b(new l(typefaceC));
            return typefaceC;
        }
        if (i3 == -1) {
            l lVarC = c(strA, context, gVar, i2);
            cVar.b(lVarC);
            return lVarC.a;
        }
        try {
            l lVar = (l) v.c(b, new h(strA, context, gVar, i2), i3);
            cVar.b(lVar);
            return lVar.a;
        } catch (InterruptedException unused) {
            cVar.b(new l(-3));
            return null;
        }
    }
}
