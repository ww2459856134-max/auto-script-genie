package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: i, reason: collision with root package name */
    private static j1 f166i;
    private WeakHashMap<Context, h.d.j<ColorStateList>> a;
    private h.d.i<String, g1> b;
    private h.d.j<String> c;
    private final WeakHashMap<Context, h.d.f<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);
    private TypedValue e;
    private boolean f;
    private h1 g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f165h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final e1 f167j = new e1(6);

    private void a(String str, g1 g1Var) {
        if (this.b == null) {
            this.b = new h.d.i<>();
        }
        this.b.put(str, g1Var);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        h.d.f<WeakReference<Drawable.ConstantState>> fVar = this.d.get(context);
        if (fVar == null) {
            fVar = new h.d.f<>();
            this.d.put(context, fVar);
        }
        fVar.j(j2, new WeakReference<>(constantState));
        return true;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap<>();
        }
        h.d.j<ColorStateList> jVar = this.a.get(context);
        if (jVar == null) {
            jVar = new h.d.j<>();
            this.a.put(context, jVar);
        }
        jVar.a(i2, colorStateList);
    }

    private void d(Context context) {
        if (this.f) {
            return;
        }
        this.f = true;
        Drawable drawableJ = j(context, h.a.m.a.a);
        if (drawableJ == null || !q(drawableJ)) {
            this.f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i2) throws Resources.NotFoundException {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        h1 h1Var = this.g;
        Drawable drawableA = h1Var == null ? null : h1Var.a(this, context, i2);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized j1 h() {
        if (f166i == null) {
            j1 j1Var = new j1();
            f166i = j1Var;
            p(j1Var);
        }
        return f166i;
    }

    private synchronized Drawable i(Context context, long j2) {
        h.d.f<WeakReference<Drawable.ConstantState>> fVar = this.d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceF = fVar.f(j2);
        if (weakReferenceF != null) {
            Drawable.ConstantState constantState = weakReferenceF.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.k(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterJ;
        e1 e1Var = f167j;
        porterDuffColorFilterJ = e1Var.j(i2, mode);
        if (porterDuffColorFilterJ == null) {
            porterDuffColorFilterJ = new PorterDuffColorFilter(i2, mode);
            e1Var.k(i2, mode, porterDuffColorFilterJ);
        }
        return porterDuffColorFilterJ;
    }

    private ColorStateList n(Context context, int i2) {
        h.d.j<ColorStateList> jVar;
        WeakHashMap<Context, h.d.j<ColorStateList>> weakHashMap = this.a;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.e(i2);
    }

    private static void p(j1 j1Var) {
        if (Build.VERSION.SDK_INT < 24) {
            j1Var.a("vector", new i1());
            j1Var.a("animated-vector", new d1());
            j1Var.a("animated-selector", new c1());
            j1Var.a("drawable", new f1());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof h.p.a.a.v) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        h.d.i<String, g1> iVar = this.b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        h.d.j<String> jVar = this.c;
        if (jVar != null) {
            String strE = jVar.e(i2);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.b.get(strE) == null)) {
                return null;
            }
        } else {
            this.c = new h.d.j<>();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.c.a(i2, name);
                g1 g1Var = this.b.get(name);
                if (g1Var != null) {
                    drawableI = g1Var.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableI == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return drawableI;
    }

    private Drawable v(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            h1 h1Var = this.g;
            if ((h1Var == null || !h1Var.d(context, i2, drawable)) && !x(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (m0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableQ = androidx.core.graphics.drawable.a.q(drawable);
        androidx.core.graphics.drawable.a.n(drawableQ, colorStateListM);
        PorterDuff.Mode modeO = o(i2);
        if (modeO == null) {
            return drawableQ;
        }
        androidx.core.graphics.drawable.a.o(drawableQ, modeO);
        return drawableQ;
    }

    static void w(Drawable drawable, r1 r1Var, int[] iArr) {
        if (m0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = r1Var.d;
        if (z || r1Var.c) {
            drawable.setColorFilter(g(z ? r1Var.a : null, r1Var.c ? r1Var.b : f165h, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    synchronized Drawable k(Context context, int i2, boolean z) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = f(context, i2);
        }
        if (drawableR == null) {
            drawableR = androidx.core.content.a.e(context, i2);
        }
        if (drawableR != null) {
            drawableR = v(context, i2, z, drawableR);
        }
        if (drawableR != null) {
            m0.b(drawableR);
        }
        return drawableR;
    }

    synchronized ColorStateList m(Context context, int i2) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i2);
        if (colorStateListN == null) {
            h1 h1Var = this.g;
            colorStateListN = h1Var == null ? null : h1Var.b(context, i2);
            if (colorStateListN != null) {
                c(context, i2, colorStateListN);
            }
        }
        return colorStateListN;
    }

    PorterDuff.Mode o(int i2) {
        h1 h1Var = this.g;
        if (h1Var == null) {
            return null;
        }
        return h1Var.c(i2);
    }

    public synchronized void s(Context context) {
        h.d.f<WeakReference<Drawable.ConstantState>> fVar = this.d.get(context);
        if (fVar != null) {
            fVar.b();
        }
    }

    synchronized Drawable t(Context context, d2 d2Var, int i2) {
        Drawable drawableR = r(context, i2);
        if (drawableR == null) {
            drawableR = d2Var.c(i2);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i2, false, drawableR);
    }

    public synchronized void u(h1 h1Var) {
        this.g = h1Var;
    }

    boolean x(Context context, int i2, Drawable drawable) {
        h1 h1Var = this.g;
        return h1Var != null && h1Var.e(context, i2, drawable);
    }
}
