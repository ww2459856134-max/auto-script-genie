package h.e.j;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public abstract class s0 {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;
    private static WeakHashMap<View, String> e;
    private static WeakHashMap<View, z0> f;
    private static Field g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f1318h;

    /* renamed from: i, reason: collision with root package name */
    private static ThreadLocal<Rect> f1319i;

    /* renamed from: j, reason: collision with root package name */
    private static final c0 f1320j;

    static {
        new AtomicInteger(1);
        f = null;
        f1318h = false;
        f1320j = new f0();
        new k0();
    }

    static b A(View view) {
        b bVarI = i(view);
        if (bVarI == null) {
            bVarI = new b();
        }
        Z(view, bVarI);
        return bVarI;
    }

    public static ViewParent B(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static e1 C(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return o0.a(view);
        }
        if (i2 >= 21) {
            return n0.c(view);
        }
        return null;
    }

    public static final CharSequence D(View view) {
        return l0().f(view);
    }

    public static String E(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = e;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int F(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static boolean G(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static boolean H(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static boolean I(View view) {
        Boolean boolF = a().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    public static boolean J(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean K(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean L(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof u) {
            return ((u) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean M(View view) {
        Boolean boolF = Y().f(view);
        if (boolF == null) {
            return false;
        }
        return boolF.booleanValue();
    }

    static void N(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m(view) != null && view.getVisibility() == 0;
            if (l(view) != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(m(view));
                    k0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(m(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void O(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (i3 < 21) {
            c(view, i2);
            return;
        }
        Rect rectR = r();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        c(view, i2);
        if (z && rectR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectR);
        }
    }

    public static void P(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (i3 < 21) {
            d(view, i2);
            return;
        }
        Rect rectR = r();
        boolean z = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectR.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !rectR.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i2);
        if (z && rectR.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectR);
        }
    }

    public static e1 Q(View view, e1 e1Var) {
        WindowInsets windowInsetsQ;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsQ = e1Var.q()) != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsQ);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsQ)) {
                return e1.s(windowInsetsOnApplyWindowInsets, view);
            }
        }
        return e1Var;
    }

    private static l0<CharSequence> R() {
        return new h0(h.e.b.e, CharSequence.class, 8, 28);
    }

    public static g S(View view, g gVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + gVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        b0 b0Var = (b0) view.getTag(h.e.b.g);
        if (b0Var == null) {
            return s(view).a(gVar);
        }
        g gVarA = b0Var.a(view, gVar);
        if (gVarA == null) {
            return null;
        }
        return s(view).a(gVarA);
    }

    public static void T(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void U(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void V(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void W(View view) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else if (i2 >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static void X(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            p0.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    private static l0<Boolean> Y() {
        return new g0(h.e.b.f1280i, Boolean.class, 28);
    }

    public static void Z(View view, b bVar) {
        if (bVar == null && (j(view) instanceof a)) {
            bVar = new b();
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.d());
    }

    private static l0<Boolean> a() {
        return new j0(h.e.b.d, Boolean.class, 28);
    }

    public static void a0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static z0 b(View view) {
        if (f == null) {
            f = new WeakHashMap<>();
        }
        z0 z0Var = f.get(view);
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(view);
        f.put(view, z0Var2);
        return z0Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b0(View view, ColorStateList colorStateList) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof e0) {
                ((e0) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static void c(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            n0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c0(View view, PorterDuff.Mode mode) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (view instanceof e0) {
                ((e0) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (i2 == 21) {
            Drawable background = view.getBackground();
            boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    private static void d(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            n0(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                n0((View) parent);
            }
        }
    }

    public static void d0(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static e1 e(View view, e1 e1Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? n0.b(view, e1Var, rect) : e1Var;
    }

    public static void e0(View view, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (i3 >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static e1 f(View view, e1 e1Var) {
        WindowInsets windowInsetsQ;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsQ = e1Var.q()) != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsetsQ);
            if (!windowInsetsDispatchApplyWindowInsets.equals(windowInsetsQ)) {
                return e1.s(windowInsetsDispatchApplyWindowInsets, view);
            }
        }
        return e1Var;
    }

    public static void f0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    static boolean g(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r0.a(view).b(view, keyEvent);
    }

    public static void g0(View view, a0 a0Var) {
        if (Build.VERSION.SDK_INT >= 21) {
            n0.d(view, a0Var);
        }
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r0.a(view).f(keyEvent);
    }

    public static void h0(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static b i(View view) {
        View.AccessibilityDelegate accessibilityDelegateJ = j(view);
        if (accessibilityDelegateJ == null) {
            return null;
        }
        return accessibilityDelegateJ instanceof a ? ((a) accessibilityDelegateJ).a : new b(accessibilityDelegateJ);
    }

    public static void i0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            l0().g(view, charSequence);
        }
    }

    private static View.AccessibilityDelegate j(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : k(view);
    }

    public static void j0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (e == null) {
            e = new WeakHashMap<>();
        }
        e.put(view, str);
    }

    private static View.AccessibilityDelegate k(View view) {
        if (f1318h) {
            return null;
        }
        if (g == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                g = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1318h = true;
                return null;
            }
        }
        try {
            Object obj = g.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1318h = true;
            return null;
        }
    }

    private static void k0(View view) {
        if (u(view) == 0) {
            e0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (u((View) parent) == 4) {
                e0(view, 2);
                return;
            }
        }
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    private static l0<CharSequence> l0() {
        return new i0(h.e.b.f1281j, CharSequence.class, 64, 30);
    }

    public static CharSequence m(View view) {
        return R().f(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof u) {
            ((u) view).stopNestedScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof e0) {
            return ((e0) view).getSupportBackgroundTintList();
        }
        return null;
    }

    private static void n0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof e0) {
            return ((e0) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static Display p(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (J(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static float q(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    private static Rect r() {
        if (f1319i == null) {
            f1319i = new ThreadLocal<>();
        }
        Rect rect = f1319i.get();
        if (rect == null) {
            rect = new Rect();
            f1319i.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static c0 s(View view) {
        return view instanceof c0 ? (c0) view : f1320j;
    }

    public static boolean t(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    public static int u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    public static int v(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int x(View view) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!d) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            d = true;
        }
        Field field = c;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int y(View view) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!b) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            b = true;
        }
        Field field = a;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static String[] z(View view) {
        return (String[]) view.getTag(h.e.b.f1279h);
    }
}
