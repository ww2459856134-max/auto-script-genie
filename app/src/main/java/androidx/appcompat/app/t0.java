package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.e2;
import androidx.appcompat.widget.t1;
import androidx.lifecycle.f;
import org.apache.xmlbeans.xml.stream.XMLEvent;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class t0 extends u implements m.a, LayoutInflater.Factory2 {
    private static final h.d.i<String, Integer> B0 = new h.d.i<>();
    private static final boolean C0;
    private static final int[] D0;
    private static final boolean E0;
    private static final boolean F0;
    private static boolean G0;
    private CharSequence A;
    private y0 A0;
    private androidx.appcompat.widget.k0 C;
    private d0 D;
    private s0 G;
    h.a.o.c H;
    ActionBarContextView I;
    PopupWindow J;
    Runnable K;
    h.e.j.z0 M;
    private boolean O;
    private boolean P;
    ViewGroup Q;
    private TextView U;
    private View V;
    private boolean W;
    private boolean Z;
    boolean a0;
    boolean b0;
    boolean c0;
    boolean d0;
    boolean e0;
    final Object f;
    private boolean f0;
    final Context g;
    private r0[] g0;

    /* renamed from: h, reason: collision with root package name */
    Window f41h;
    private r0 h0;

    /* renamed from: i, reason: collision with root package name */
    private k0 f42i;
    private boolean i0;

    /* renamed from: j, reason: collision with root package name */
    final t f43j;
    private boolean j0;

    /* renamed from: k, reason: collision with root package name */
    a f44k;
    private boolean k0;
    private boolean l0;
    boolean m0;
    private int n0;
    private int o0;
    private boolean p0;
    private boolean q0;
    private n0 r0;
    private n0 s0;
    MenuInflater t;
    boolean t0;
    int u0;
    private final Runnable v0;
    private boolean w0;
    private Rect x0;
    private Rect y0;
    private x0 z0;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = i2 < 21;
        C0 = z;
        D0 = new int[]{R.attr.windowBackground};
        E0 = !"robolectric".equals(Build.FINGERPRINT);
        F0 = i2 >= 17;
        if (!z || G0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new v(Thread.getDefaultUncaughtExceptionHandler()));
        G0 = true;
    }

    t0(Activity activity, t tVar) {
        this(activity, null, tVar, activity);
    }

    private boolean A0(r0 r0Var, KeyEvent keyEvent) {
        androidx.appcompat.widget.k0 k0Var;
        androidx.appcompat.widget.k0 k0Var2;
        androidx.appcompat.widget.k0 k0Var3;
        androidx.appcompat.widget.k0 k0Var4;
        if (this.m0) {
            return false;
        }
        if (r0Var.f38m) {
            return true;
        }
        r0 r0Var2 = this.h0;
        if (r0Var2 != null && r0Var2 != r0Var) {
            O(r0Var2, false);
        }
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null) {
            r0Var.f34i = callbackF0.onCreatePanelView(r0Var.a);
        }
        int i2 = r0Var.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (k0Var4 = this.C) != null) {
            k0Var4.setMenuPrepared();
        }
        if (r0Var.f34i == null) {
            if (z) {
                y0();
            }
            androidx.appcompat.view.menu.m mVar = r0Var.f35j;
            if (mVar == null || r0Var.r) {
                if (mVar == null && (!j0(r0Var) || r0Var.f35j == null)) {
                    return false;
                }
                if (z && (k0Var2 = this.C) != null) {
                    if (this.D == null) {
                        this.D = new d0(this);
                    }
                    k0Var2.setMenu(r0Var.f35j, this.D);
                }
                r0Var.f35j.d0();
                if (!callbackF0.onCreatePanelMenu(r0Var.a, r0Var.f35j)) {
                    r0Var.c(null);
                    if (z && (k0Var = this.C) != null) {
                        k0Var.setMenu(null, this.D);
                    }
                    return false;
                }
                r0Var.r = false;
            }
            r0Var.f35j.d0();
            Bundle bundle = r0Var.s;
            if (bundle != null) {
                r0Var.f35j.P(bundle);
                r0Var.s = null;
            }
            if (!callbackF0.onPreparePanel(0, r0Var.f34i, r0Var.f35j)) {
                if (z && (k0Var3 = this.C) != null) {
                    k0Var3.setMenu(null, this.D);
                }
                r0Var.f35j.c0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            r0Var.p = z2;
            r0Var.f35j.setQwertyMode(z2);
            r0Var.f35j.c0();
        }
        r0Var.f38m = true;
        r0Var.f39n = false;
        this.h0 = r0Var;
        return true;
    }

    private void B0(boolean z) {
        androidx.appcompat.widget.k0 k0Var = this.C;
        if (k0Var == null || !k0Var.a() || (ViewConfiguration.get(this.g).hasPermanentMenuKey() && !this.C.e())) {
            r0 r0VarD0 = d0(0, true);
            r0VarD0.q = true;
            O(r0VarD0, false);
            x0(r0VarD0, null);
            return;
        }
        Window.Callback callbackF0 = f0();
        if (this.C.c() && z) {
            this.C.d();
            if (this.m0) {
                return;
            }
            callbackF0.onPanelClosed(108, d0(0, true).f35j);
            return;
        }
        if (callbackF0 == null || this.m0) {
            return;
        }
        if (this.t0 && (this.u0 & 1) != 0) {
            this.f41h.getDecorView().removeCallbacks(this.v0);
            this.v0.run();
        }
        r0 r0VarD02 = d0(0, true);
        androidx.appcompat.view.menu.m mVar = r0VarD02.f35j;
        if (mVar == null || r0VarD02.r || !callbackF0.onPreparePanel(0, r0VarD02.f34i, mVar)) {
            return;
        }
        callbackF0.onMenuOpened(108, r0VarD02.f35j);
        this.C.b();
    }

    private int C0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean E0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f41h.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || h.e.j.s0.J((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean G(boolean z) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        if (this.m0) {
            return false;
        }
        int iJ = J();
        boolean zJ0 = J0(n0(this.g, iJ), z);
        if (iJ == 0) {
            c0(this.g).e();
        } else {
            n0 n0Var = this.r0;
            if (n0Var != null) {
                n0Var.a();
            }
        }
        if (iJ == 3) {
            b0(this.g).e();
        } else {
            n0 n0Var2 = this.s0;
            if (n0Var2 != null) {
                n0Var2.a();
            }
        }
        return zJ0;
    }

    private void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.Q.findViewById(R.id.content);
        View decorView = this.f41h.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.g.obtainStyledAttributes(h.a.j.x0);
        typedArrayObtainStyledAttributes.getValue(h.a.j.J0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(h.a.j.K0, contentFrameLayout.getMinWidthMinor());
        int i2 = h.a.j.H0;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.getValue(i2, contentFrameLayout.getFixedWidthMajor());
        }
        int i3 = h.a.j.I0;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            typedArrayObtainStyledAttributes.getValue(i3, contentFrameLayout.getFixedWidthMinor());
        }
        int i4 = h.a.j.F0;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            typedArrayObtainStyledAttributes.getValue(i4, contentFrameLayout.getFixedHeightMajor());
        }
        int i5 = h.a.j.G0;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            typedArrayObtainStyledAttributes.getValue(i5, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void H0() {
        if (this.P) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void I(Window window) {
        if (this.f41h != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof k0) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        k0 k0Var = new k0(this, callback);
        this.f42i = k0Var;
        window.setCallback(k0Var);
        t1 t1VarT = t1.t(this.g, null, D0);
        Drawable drawableG = t1VarT.g(0);
        if (drawableG != null) {
            window.setBackgroundDrawable(drawableG);
        }
        t1VarT.v();
        this.f41h = window;
    }

    private s I0() {
        for (Context baseContext = this.g; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof s) {
                return (s) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private int J() {
        int i2 = this.n0;
        return i2 != -100 ? i2 : u.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean J0(int i2, boolean z) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        boolean z2;
        Configuration configurationP = P(this.g, i2, null);
        boolean zL0 = l0();
        int i3 = this.g.getResources().getConfiguration().uiMode & 48;
        int i4 = configurationP.uiMode & 48;
        boolean z3 = true;
        if (i3 != i4 && z && !zL0 && this.j0 && (E0 || this.k0)) {
            Object obj = this.f;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                androidx.core.app.f.k((Activity) this.f);
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2 || i3 == i4) {
            z3 = z2;
        } else {
            K0(i4, zL0, null);
        }
        if (z3) {
            Object obj2 = this.f;
            if (obj2 instanceof s) {
                ((s) obj2).K(i2);
            }
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void K0(int i2, boolean z, Configuration configuration) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Resources resources = this.g.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            z0.a(resources);
        }
        int i4 = this.o0;
        if (i4 != 0) {
            this.g.setTheme(i4);
            if (i3 >= 23) {
                this.g.getTheme().applyStyle(this.o0, true);
            }
        }
        if (z) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.i) {
                    if (((androidx.lifecycle.i) activity).o().b().a(f.b.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.l0) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void M() {
        n0 n0Var = this.r0;
        if (n0Var != null) {
            n0Var.a();
        }
        n0 n0Var2 = this.s0;
        if (n0Var2 != null) {
            n0Var2.a();
        }
    }

    private void M0(View view) {
        view.setBackgroundColor((h.e.j.s0.F(view) & XMLEvent.ENTITY_REFERENCE) != 0 ? androidx.core.content.a.c(this.g, h.a.c.b) : androidx.core.content.a.c(this.g, h.a.c.a));
    }

    private Configuration P(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup Q() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.g.obtainStyledAttributes(h.a.j.x0);
        int i2 = h.a.j.C0;
        if (!typedArrayObtainStyledAttributes.hasValue(i2)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.a.j.L0, false)) {
            z(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i2, false)) {
            z(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.a.j.D0, false)) {
            z(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(h.a.j.E0, false)) {
            z(10);
        }
        this.d0 = typedArrayObtainStyledAttributes.getBoolean(h.a.j.y0, false);
        typedArrayObtainStyledAttributes.recycle();
        X();
        this.f41h.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.g);
        if (this.e0) {
            viewGroup = this.c0 ? (ViewGroup) layoutInflaterFrom.inflate(h.a.g.q, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(h.a.g.p, (ViewGroup) null);
        } else if (this.d0) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(h.a.g.f1209h, (ViewGroup) null);
            this.b0 = false;
            this.a0 = false;
        } else if (this.a0) {
            TypedValue typedValue = new TypedValue();
            this.g.getTheme().resolveAttribute(h.a.a.g, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new h.a.o.e(this.g, typedValue.resourceId) : this.g).inflate(h.a.g.r, (ViewGroup) null);
            androidx.appcompat.widget.k0 k0Var = (androidx.appcompat.widget.k0) viewGroup.findViewById(h.a.f.q);
            this.C = k0Var;
            k0Var.setWindowCallback(f0());
            if (this.b0) {
                this.C.i(109);
            }
            if (this.W) {
                this.C.i(2);
            }
            if (this.Z) {
                this.C.i(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.a0 + ", windowActionBarOverlay: " + this.b0 + ", android:windowIsFloating: " + this.d0 + ", windowActionModeOverlay: " + this.c0 + ", windowNoTitle: " + this.e0 + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            h.e.j.s0.g0(viewGroup, new x(this));
        } else if (viewGroup instanceof androidx.appcompat.widget.q0) {
            ((androidx.appcompat.widget.q0) viewGroup).setOnFitSystemWindowsListener(new y(this));
        }
        if (this.C == null) {
            this.U = (TextView) viewGroup.findViewById(h.a.f.S);
        }
        e2.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(h.a.f.b);
        ViewGroup viewGroup2 = (ViewGroup) this.f41h.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f41h.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new z(this));
        return viewGroup;
    }

    private void W() {
        if (this.P) {
            return;
        }
        this.Q = Q();
        CharSequence charSequenceE0 = e0();
        if (!TextUtils.isEmpty(charSequenceE0)) {
            androidx.appcompat.widget.k0 k0Var = this.C;
            if (k0Var != null) {
                k0Var.setWindowTitle(charSequenceE0);
            } else if (y0() != null) {
                y0().t(charSequenceE0);
            } else {
                TextView textView = this.U;
                if (textView != null) {
                    textView.setText(charSequenceE0);
                }
            }
        }
        H();
        w0(this.Q);
        this.P = true;
        r0 r0VarD0 = d0(0, false);
        if (this.m0) {
            return;
        }
        if (r0VarD0 == null || r0VarD0.f35j == null) {
            k0(108);
        }
    }

    private void X() {
        if (this.f41h == null) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f41h == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration Z(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f = configuration.fontScale;
            float f2 = configuration2.fontScale;
            if (f != f2) {
                configuration3.fontScale = f2;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24) {
                i0.a(configuration, configuration2, configuration3);
            } else if (!h.e.i.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i7 = configuration.touchscreen;
            int i8 = configuration2.touchscreen;
            if (i7 != i8) {
                configuration3.touchscreen = i8;
            }
            int i9 = configuration.keyboard;
            int i10 = configuration2.keyboard;
            if (i9 != i10) {
                configuration3.keyboard = i10;
            }
            int i11 = configuration.keyboardHidden;
            int i12 = configuration2.keyboardHidden;
            if (i11 != i12) {
                configuration3.keyboardHidden = i12;
            }
            int i13 = configuration.navigation;
            int i14 = configuration2.navigation;
            if (i13 != i14) {
                configuration3.navigation = i14;
            }
            int i15 = configuration.navigationHidden;
            int i16 = configuration2.navigationHidden;
            if (i15 != i16) {
                configuration3.navigationHidden = i16;
            }
            int i17 = configuration.orientation;
            int i18 = configuration2.orientation;
            if (i17 != i18) {
                configuration3.orientation = i18;
            }
            int i19 = configuration.screenLayout & 15;
            int i20 = configuration2.screenLayout;
            if (i19 != (i20 & 15)) {
                configuration3.screenLayout |= i20 & 15;
            }
            int i21 = configuration.screenLayout & 192;
            int i22 = configuration2.screenLayout;
            if (i21 != (i22 & 192)) {
                configuration3.screenLayout |= i22 & 192;
            }
            int i23 = configuration.screenLayout & 48;
            int i24 = configuration2.screenLayout;
            if (i23 != (i24 & 48)) {
                configuration3.screenLayout |= i24 & 48;
            }
            int i25 = configuration.screenLayout & 768;
            int i26 = configuration2.screenLayout;
            if (i25 != (i26 & 768)) {
                configuration3.screenLayout |= i26 & 768;
            }
            if (i6 >= 26) {
                j0.a(configuration, configuration2, configuration3);
            }
            int i27 = configuration.uiMode & 15;
            int i28 = configuration2.uiMode;
            if (i27 != (i28 & 15)) {
                configuration3.uiMode |= i28 & 15;
            }
            int i29 = configuration.uiMode & 48;
            int i30 = configuration2.uiMode;
            if (i29 != (i30 & 48)) {
                configuration3.uiMode |= i30 & 48;
            }
            int i31 = configuration.screenWidthDp;
            int i32 = configuration2.screenWidthDp;
            if (i31 != i32) {
                configuration3.screenWidthDp = i32;
            }
            int i33 = configuration.screenHeightDp;
            int i34 = configuration2.screenHeightDp;
            if (i33 != i34) {
                configuration3.screenHeightDp = i34;
            }
            int i35 = configuration.smallestScreenWidthDp;
            int i36 = configuration2.smallestScreenWidthDp;
            if (i35 != i36) {
                configuration3.smallestScreenWidthDp = i36;
            }
            if (i6 >= 17) {
                g0.b(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private n0 b0(Context context) {
        if (this.s0 == null) {
            this.s0 = new l0(this, context);
        }
        return this.s0;
    }

    private n0 c0(Context context) {
        if (this.r0 == null) {
            this.r0 = new o0(this, c1.a(context));
        }
        return this.r0;
    }

    private void g0() {
        W();
        if (this.a0 && this.f44k == null) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                this.f44k = new h1((Activity) this.f, this.b0);
            } else if (obj instanceof Dialog) {
                this.f44k = new h1((Dialog) this.f);
            }
            a aVar = this.f44k;
            if (aVar != null) {
                aVar.r(this.w0);
            }
        }
    }

    private boolean h0(r0 r0Var) {
        View view = r0Var.f34i;
        if (view != null) {
            r0Var.f33h = view;
            return true;
        }
        if (r0Var.f35j == null) {
            return false;
        }
        if (this.G == null) {
            this.G = new s0(this);
        }
        View view2 = (View) r0Var.a(this.G);
        r0Var.f33h = view2;
        return view2 != null;
    }

    private boolean i0(r0 r0Var) {
        r0Var.d(a0());
        r0Var.g = new q0(this, r0Var.f37l);
        r0Var.c = 81;
        return true;
    }

    private boolean j0(r0 r0Var) {
        Context context = this.g;
        int i2 = r0Var.a;
        if ((i2 == 0 || i2 == 108) && this.C != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(h.a.a.g, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(h.a.a.f1176h, typedValue, true);
            } else {
                theme.resolveAttribute(h.a.a.f1176h, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                h.a.o.e eVar = new h.a.o.e(context, 0);
                eVar.getTheme().setTo(themeNewTheme);
                context = eVar;
            }
        }
        androidx.appcompat.view.menu.m mVar = new androidx.appcompat.view.menu.m(context);
        mVar.R(this);
        r0Var.c(mVar);
        return true;
    }

    private void k0(int i2) {
        this.u0 = (1 << i2) | this.u0;
        if (this.t0) {
            return;
        }
        h.e.j.s0.U(this.f41h.getDecorView(), this.v0);
        this.t0 = true;
    }

    private boolean l0() throws PackageManager.NameNotFoundException {
        if (!this.q0 && (this.f instanceof Activity)) {
            PackageManager packageManager = this.g.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i2 = Build.VERSION.SDK_INT;
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.g, this.f.getClass()), i2 >= 29 ? 269221888 : i2 >= 24 ? 786432 : 0);
                this.p0 = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                this.p0 = false;
            }
        }
        this.q0 = true;
        return this.p0;
    }

    private boolean q0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        r0 r0VarD0 = d0(i2, true);
        if (r0VarD0.f40o) {
            return false;
        }
        return A0(r0VarD0, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean t0(int i2, KeyEvent keyEvent) {
        boolean zA0;
        androidx.appcompat.widget.k0 k0Var;
        if (this.H != null) {
            return false;
        }
        boolean zD = true;
        r0 r0VarD0 = d0(i2, true);
        if (i2 != 0 || (k0Var = this.C) == null || !k0Var.a() || ViewConfiguration.get(this.g).hasPermanentMenuKey()) {
            boolean z = r0VarD0.f40o;
            if (z || r0VarD0.f39n) {
                O(r0VarD0, true);
                zD = z;
            } else if (r0VarD0.f38m) {
                if (r0VarD0.r) {
                    r0VarD0.f38m = false;
                    zA0 = A0(r0VarD0, keyEvent);
                } else {
                    zA0 = true;
                }
                if (zA0) {
                    x0(r0VarD0, keyEvent);
                }
            } else {
                zD = false;
            }
        } else if (this.C.c()) {
            zD = this.C.d();
        } else if (!this.m0 && A0(r0VarD0, keyEvent)) {
            zD = this.C.b();
        }
        if (zD) {
            AudioManager audioManager = (AudioManager) this.g.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zD;
    }

    private void x0(r0 r0Var, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (r0Var.f40o || this.m0) {
            return;
        }
        if (r0Var.a == 0) {
            if ((this.g.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null && !callbackF0.onMenuOpened(r0Var.a, r0Var.f35j)) {
            O(r0Var, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
        if (windowManager != null && A0(r0Var, keyEvent)) {
            ViewGroup viewGroup = r0Var.g;
            if (viewGroup != null && !r0Var.q) {
                View view = r0Var.f34i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i2 = -1;
                }
                r0Var.f39n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, r0Var.d, r0Var.e, 1002, 8519680, -3);
                layoutParams2.gravity = r0Var.c;
                layoutParams2.windowAnimations = r0Var.f;
                windowManager.addView(r0Var.g, layoutParams2);
                r0Var.f40o = true;
            }
            if (viewGroup == null) {
                if (!i0(r0Var) || r0Var.g == null) {
                    return;
                }
            } else if (r0Var.q && viewGroup.getChildCount() > 0) {
                r0Var.g.removeAllViews();
            }
            if (!h0(r0Var) || !r0Var.b()) {
                r0Var.q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = r0Var.f33h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            r0Var.g.setBackgroundResource(r0Var.b);
            ViewParent parent = r0Var.f33h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(r0Var.f33h);
            }
            r0Var.g.addView(r0Var.f33h, layoutParams3);
            if (!r0Var.f33h.hasFocus()) {
                r0Var.f33h.requestFocus();
            }
            i2 = -2;
            r0Var.f39n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, r0Var.d, r0Var.e, 1002, 8519680, -3);
            layoutParams22.gravity = r0Var.c;
            layoutParams22.windowAnimations = r0Var.f;
            windowManager.addView(r0Var.g, layoutParams22);
            r0Var.f40o = true;
        }
    }

    private boolean z0(r0 r0Var, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.m mVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((r0Var.f38m || A0(r0Var, keyEvent)) && (mVar = r0Var.f35j) != null) {
            zPerformShortcut = mVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.C == null) {
            O(r0Var, true);
        }
        return zPerformShortcut;
    }

    @Override // androidx.appcompat.app.u
    public void A(int i2) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.Q.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.g).inflate(i2, viewGroup);
        this.f42i.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.u
    public void B(View view) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.Q.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f42i.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.u
    public void C(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ViewGroup viewGroup = (ViewGroup) this.Q.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f42i.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.u
    public void D(int i2) {
        this.o0 = i2;
    }

    final boolean D0() {
        ViewGroup viewGroup;
        return this.P && (viewGroup = this.Q) != null && h.e.j.s0.K(viewGroup);
    }

    @Override // androidx.appcompat.app.u
    public final void E(CharSequence charSequence) {
        this.A = charSequence;
        androidx.appcompat.widget.k0 k0Var = this.C;
        if (k0Var != null) {
            k0Var.setWindowTitle(charSequence);
            return;
        }
        if (y0() != null) {
            y0().t(charSequence);
            return;
        }
        TextView textView = this.U;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean F() {
        return G(true);
    }

    public h.a.o.c F0(h.a.o.b bVar) {
        t tVar;
        if (bVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        h.a.o.c cVar = this.H;
        if (cVar != null) {
            cVar.c();
        }
        f0 f0Var = new f0(this, bVar);
        a aVarM = m();
        if (aVarM != null) {
            h.a.o.c cVarU = aVarM.u(f0Var);
            this.H = cVarU;
            if (cVarU != null && (tVar = this.f43j) != null) {
                tVar.c(cVarU);
            }
        }
        if (this.H == null) {
            this.H = G0(f0Var);
        }
        return this.H;
    }

    h.a.o.c G0(h.a.o.b bVar) {
        h.a.o.c cVarD;
        Context eVar;
        t tVar;
        V();
        h.a.o.c cVar = this.H;
        if (cVar != null) {
            cVar.c();
        }
        if (!(bVar instanceof f0)) {
            bVar = new f0(this, bVar);
        }
        t tVar2 = this.f43j;
        if (tVar2 == null || this.m0) {
            cVarD = null;
        } else {
            try {
                cVarD = tVar2.d(bVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (cVarD != null) {
            this.H = cVarD;
        } else {
            if (this.I == null) {
                if (this.d0) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.g.getTheme();
                    theme.resolveAttribute(h.a.a.g, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.g.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        eVar = new h.a.o.e(this.g, 0);
                        eVar.getTheme().setTo(themeNewTheme);
                    } else {
                        eVar = this.g;
                    }
                    this.I = new ActionBarContextView(eVar);
                    PopupWindow popupWindow = new PopupWindow(eVar, (AttributeSet) null, h.a.a.f1178j);
                    this.J = popupWindow;
                    androidx.core.widget.k.b(popupWindow, 2);
                    this.J.setContentView(this.I);
                    this.J.setWidth(-1);
                    eVar.getTheme().resolveAttribute(h.a.a.b, typedValue, true);
                    this.I.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, eVar.getResources().getDisplayMetrics()));
                    this.J.setHeight(-2);
                    this.K = new b0(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.Q.findViewById(h.a.f.f1201h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(a0()));
                        this.I = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.I != null) {
                V();
                this.I.k();
                h.a.o.f fVar = new h.a.o.f(this.I.getContext(), this.I, bVar, this.J == null);
                if (bVar.a(fVar, fVar.e())) {
                    fVar.k();
                    this.I.h(fVar);
                    this.H = fVar;
                    if (D0()) {
                        this.I.setAlpha(0.0f);
                        h.e.j.z0 z0VarB = h.e.j.s0.b(this.I);
                        z0VarB.a(1.0f);
                        this.M = z0VarB;
                        z0VarB.f(new c0(this));
                    } else {
                        this.I.setAlpha(1.0f);
                        this.I.setVisibility(0);
                        this.I.sendAccessibilityEvent(32);
                        if (this.I.getParent() instanceof View) {
                            h.e.j.s0.W((View) this.I.getParent());
                        }
                    }
                    if (this.J != null) {
                        this.f41h.getDecorView().post(this.K);
                    }
                } else {
                    this.H = null;
                }
            }
        }
        h.a.o.c cVar2 = this.H;
        if (cVar2 != null && (tVar = this.f43j) != null) {
            tVar.c(cVar2);
        }
        return this.H;
    }

    void K(int i2, r0 r0Var, Menu menu) {
        if (menu == null) {
            if (r0Var == null && i2 >= 0) {
                r0[] r0VarArr = this.g0;
                if (i2 < r0VarArr.length) {
                    r0Var = r0VarArr[i2];
                }
            }
            if (r0Var != null) {
                menu = r0Var.f35j;
            }
        }
        if ((r0Var == null || r0Var.f40o) && !this.m0) {
            this.f42i.a().onPanelClosed(i2, menu);
        }
    }

    void L(androidx.appcompat.view.menu.m mVar) {
        if (this.f0) {
            return;
        }
        this.f0 = true;
        this.C.k();
        Window.Callback callbackF0 = f0();
        if (callbackF0 != null && !this.m0) {
            callbackF0.onPanelClosed(108, mVar);
        }
        this.f0 = false;
    }

    final int L0(h.e.j.e1 e1Var, Rect rect) {
        boolean z;
        boolean z2;
        int iH = e1Var != null ? e1Var.h() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.I;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.I.getLayoutParams();
            if (this.I.isShown()) {
                if (this.x0 == null) {
                    this.x0 = new Rect();
                    this.y0 = new Rect();
                }
                Rect rect2 = this.x0;
                Rect rect3 = this.y0;
                if (e1Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(e1Var.f(), e1Var.h(), e1Var.g(), e1Var.e());
                }
                e2.a(this.Q, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                h.e.j.e1 e1VarC = h.e.j.s0.C(this.Q);
                int iF = e1VarC == null ? 0 : e1VarC.f();
                int iG = e1VarC == null ? 0 : e1VarC.g();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.V != null) {
                    View view = this.V;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != iF || marginLayoutParams2.rightMargin != iG) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = iF;
                            marginLayoutParams2.rightMargin = iG;
                            this.V.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.g);
                    this.V = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iF;
                    layoutParams.rightMargin = iG;
                    this.Q.addView(this.V, -1, layoutParams);
                }
                View view3 = this.V;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    M0(this.V);
                }
                if (!this.c0 && z) {
                    iH = 0;
                }
                z = z;
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                this.I.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.V;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iH;
    }

    void N(int i2) {
        O(d0(i2, true), true);
    }

    void O(r0 r0Var, boolean z) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.k0 k0Var;
        if (z && r0Var.a == 0 && (k0Var = this.C) != null && k0Var.c()) {
            L(r0Var.f35j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
        if (windowManager != null && r0Var.f40o && (viewGroup = r0Var.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                K(r0Var.a, r0Var, null);
            }
        }
        r0Var.f38m = false;
        r0Var.f39n = false;
        r0Var.f40o = false;
        r0Var.f33h = null;
        r0Var.q = true;
        if (this.h0 == r0Var) {
            this.h0 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View R(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (this.z0 == null) {
            String string = this.g.obtainStyledAttributes(h.a.j.x0).getString(h.a.j.B0);
            if (string == null) {
                this.z0 = new x0();
            } else {
                try {
                    this.z0 = (x0) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.z0 = new x0();
                }
            }
        }
        boolean z3 = C0;
        boolean zE0 = true;
        if (z3) {
            if (this.A0 == null) {
                this.A0 = new y0();
            }
            if (this.A0.a(attributeSet)) {
                z = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    }
                    z = z2;
                } else {
                    zE0 = E0((ViewParent) view);
                }
                z2 = zE0;
                z = z2;
            }
        } else {
            z = z2;
        }
        return this.z0.q(view, str, context, attributeSet, z, z3, true, d2.b());
    }

    void S() {
        androidx.appcompat.view.menu.m mVar;
        androidx.appcompat.widget.k0 k0Var = this.C;
        if (k0Var != null) {
            k0Var.k();
        }
        if (this.J != null) {
            this.f41h.getDecorView().removeCallbacks(this.K);
            if (this.J.isShowing()) {
                try {
                    this.J.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.J = null;
        }
        V();
        r0 r0VarD0 = d0(0, false);
        if (r0VarD0 == null || (mVar = r0VarD0.f35j) == null) {
            return;
        }
        mVar.close();
    }

    boolean T(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f;
        if (((obj instanceof h.e.j.o) || (obj instanceof v0)) && (decorView = this.f41h.getDecorView()) != null && h.e.j.p.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f42i.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? p0(keyCode, keyEvent) : s0(keyCode, keyEvent);
    }

    void U(int i2) {
        r0 r0VarD0;
        r0 r0VarD02 = d0(i2, true);
        if (r0VarD02.f35j != null) {
            Bundle bundle = new Bundle();
            r0VarD02.f35j.Q(bundle);
            if (bundle.size() > 0) {
                r0VarD02.s = bundle;
            }
            r0VarD02.f35j.d0();
            r0VarD02.f35j.clear();
        }
        r0VarD02.r = true;
        r0VarD02.q = true;
        if ((i2 != 108 && i2 != 0) || this.C == null || (r0VarD0 = d0(0, false)) == null) {
            return;
        }
        r0VarD0.f38m = false;
        A0(r0VarD0, null);
    }

    void V() {
        h.e.j.z0 z0Var = this.M;
        if (z0Var != null) {
            z0Var.b();
        }
    }

    r0 Y(Menu menu) {
        r0[] r0VarArr = this.g0;
        int length = r0VarArr != null ? r0VarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            r0 r0Var = r0VarArr[i2];
            if (r0Var != null && r0Var.f35j == menu) {
                return r0Var;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(androidx.appcompat.view.menu.m mVar, MenuItem menuItem) {
        r0 r0VarY;
        Window.Callback callbackF0 = f0();
        if (callbackF0 == null || this.m0 || (r0VarY = Y(mVar.D())) == null) {
            return false;
        }
        return callbackF0.onMenuItemSelected(r0VarY.a, menuItem);
    }

    final Context a0() {
        a aVarM = m();
        Context contextK = aVarM != null ? aVarM.k() : null;
        return contextK == null ? this.g : contextK;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void b(androidx.appcompat.view.menu.m mVar) {
        B0(true);
    }

    @Override // androidx.appcompat.app.u
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        W();
        ((ViewGroup) this.Q.findViewById(R.id.content)).addView(view, layoutParams);
        this.f42i.a().onContentChanged();
    }

    protected r0 d0(int i2, boolean z) {
        r0[] r0VarArr = this.g0;
        if (r0VarArr == null || r0VarArr.length <= i2) {
            r0[] r0VarArr2 = new r0[i2 + 1];
            if (r0VarArr != null) {
                System.arraycopy(r0VarArr, 0, r0VarArr2, 0, r0VarArr.length);
            }
            this.g0 = r0VarArr2;
            r0VarArr = r0VarArr2;
        }
        r0 r0Var = r0VarArr[i2];
        if (r0Var != null) {
            return r0Var;
        }
        r0 r0Var2 = new r0(i2);
        r0VarArr[i2] = r0Var2;
        return r0Var2;
    }

    final CharSequence e0() {
        Object obj = this.f;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.A;
    }

    @Override // androidx.appcompat.app.u
    public Context f(Context context) {
        this.j0 = true;
        int iN0 = n0(context, J());
        Configuration configurationZ = null;
        if (F0 && (context instanceof ContextThemeWrapper)) {
            try {
                p0.a((ContextThemeWrapper) context, P(context, iN0, null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof h.a.o.e) {
            try {
                ((h.a.o.e) context).a(P(context, iN0, null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!E0) {
            super.f(context);
            return context;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration = new Configuration();
            configuration.uiMode = -1;
            configuration.fontScale = 0.0f;
            Configuration configuration2 = g0.a(context, configuration).getResources().getConfiguration();
            Configuration configuration3 = context.getResources().getConfiguration();
            configuration2.uiMode = configuration3.uiMode;
            if (!configuration2.equals(configuration3)) {
                configurationZ = Z(configuration2, configuration3);
            }
        }
        Configuration configurationP = P(context, iN0, configurationZ);
        h.a.o.e eVar = new h.a.o.e(context, h.a.i.c);
        eVar.a(configurationP);
        boolean z = false;
        try {
            z = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z) {
            androidx.core.content.c.p.a(eVar.getTheme());
        }
        super.f(eVar);
        return eVar;
    }

    final Window.Callback f0() {
        return this.f41h.getCallback();
    }

    @Override // androidx.appcompat.app.u
    public <T extends View> T i(int i2) {
        W();
        return (T) this.f41h.findViewById(i2);
    }

    @Override // androidx.appcompat.app.u
    public int k() {
        return this.n0;
    }

    @Override // androidx.appcompat.app.u
    public MenuInflater l() {
        if (this.t == null) {
            g0();
            a aVar = this.f44k;
            this.t = new h.a.o.k(aVar != null ? aVar.k() : this.g);
        }
        return this.t;
    }

    @Override // androidx.appcompat.app.u
    public a m() {
        g0();
        return this.f44k;
    }

    public boolean m0() {
        return this.O;
    }

    @Override // androidx.appcompat.app.u
    public void n() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.g);
        if (layoutInflaterFrom.getFactory() == null) {
            h.e.j.q.b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof t0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    int n0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return c0(context).c();
                }
                return -1;
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return b0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.u
    public void o() {
        a aVarM = m();
        if (aVarM == null || !aVarM.l()) {
            k0(0);
        }
    }

    boolean o0() {
        h.a.o.c cVar = this.H;
        if (cVar != null) {
            cVar.c();
            return true;
        }
        a aVarM = m();
        return aVarM != null && aVarM.h();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return R(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.u
    public void p(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        a aVarM;
        if (this.a0 && this.P && (aVarM = m()) != null) {
            aVarM.m(configuration);
        }
        androidx.appcompat.widget.p.b().g(this.g);
        G(false);
    }

    boolean p0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.i0 = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            q0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.u
    public void q(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        this.j0 = true;
        G(false);
        X();
        Object obj = this.f;
        if (obj instanceof Activity) {
            String strC = null;
            try {
                strC = androidx.core.app.o.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (strC != null) {
                a aVarY0 = y0();
                if (aVarY0 == null) {
                    this.w0 = true;
                } else {
                    aVarY0.r(true);
                }
            }
            u.c(this);
        }
        this.k0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    @Override // androidx.appcompat.app.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r() {
        if (this.f instanceof Activity) {
            u.x(this);
        }
        if (this.t0) {
            this.f41h.getDecorView().removeCallbacks(this.v0);
        }
        this.l0 = false;
        this.m0 = true;
        if (this.n0 != -100) {
            Object obj = this.f;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                B0.put(this.f.getClass().getName(), Integer.valueOf(this.n0));
            } else {
                B0.remove(this.f.getClass().getName());
            }
        }
        a aVar = this.f44k;
        if (aVar != null) {
            aVar.n();
        }
        M();
    }

    boolean r0(int i2, KeyEvent keyEvent) {
        a aVarM = m();
        if (aVarM != null && aVarM.o(i2, keyEvent)) {
            return true;
        }
        r0 r0Var = this.h0;
        if (r0Var != null && z0(r0Var, keyEvent.getKeyCode(), keyEvent, 1)) {
            r0 r0Var2 = this.h0;
            if (r0Var2 != null) {
                r0Var2.f39n = true;
            }
            return true;
        }
        if (this.h0 == null) {
            r0 r0VarD0 = d0(0, true);
            A0(r0VarD0, keyEvent);
            boolean zZ0 = z0(r0VarD0, keyEvent.getKeyCode(), keyEvent, 1);
            r0VarD0.f38m = false;
            if (zZ0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.u
    public void s(Bundle bundle) {
        W();
    }

    boolean s0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z = this.i0;
            this.i0 = false;
            r0 r0VarD0 = d0(0, false);
            if (r0VarD0 != null && r0VarD0.f40o) {
                if (!z) {
                    O(r0VarD0, true);
                }
                return true;
            }
            if (o0()) {
                return true;
            }
        } else if (i2 == 82) {
            t0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.u
    public void t() {
        a aVarM = m();
        if (aVarM != null) {
            aVarM.s(true);
        }
    }

    @Override // androidx.appcompat.app.u
    public void u(Bundle bundle) {
    }

    void u0(int i2) {
        a aVarM;
        if (i2 != 108 || (aVarM = m()) == null) {
            return;
        }
        aVarM.i(true);
    }

    @Override // androidx.appcompat.app.u
    public void v() {
        this.l0 = true;
        F();
    }

    void v0(int i2) {
        if (i2 == 108) {
            a aVarM = m();
            if (aVarM != null) {
                aVarM.i(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            r0 r0VarD0 = d0(i2, true);
            if (r0VarD0.f40o) {
                O(r0VarD0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.u
    public void w() {
        this.l0 = false;
        a aVarM = m();
        if (aVarM != null) {
            aVarM.s(false);
        }
    }

    void w0(ViewGroup viewGroup) {
    }

    final a y0() {
        return this.f44k;
    }

    @Override // androidx.appcompat.app.u
    public boolean z(int i2) {
        int iC0 = C0(i2);
        if (this.e0 && iC0 == 108) {
            return false;
        }
        if (this.a0 && iC0 == 1) {
            this.a0 = false;
        }
        if (iC0 == 1) {
            H0();
            this.e0 = true;
            return true;
        }
        if (iC0 == 2) {
            H0();
            this.W = true;
            return true;
        }
        if (iC0 == 5) {
            H0();
            this.Z = true;
            return true;
        }
        if (iC0 == 10) {
            H0();
            this.c0 = true;
            return true;
        }
        if (iC0 == 108) {
            H0();
            this.a0 = true;
            return true;
        }
        if (iC0 != 109) {
            return this.f41h.requestFeature(iC0);
        }
        H0();
        this.b0 = true;
        return true;
    }

    t0(Dialog dialog, t tVar) {
        this(dialog.getContext(), dialog.getWindow(), tVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private t0(Context context, Window window, t tVar, Object obj) {
        h.d.i<String, Integer> iVar;
        Integer num;
        s sVarI0;
        this.M = null;
        this.O = true;
        this.n0 = -100;
        this.v0 = new w(this);
        this.g = context;
        this.f43j = tVar;
        this.f = obj;
        if ((obj instanceof Dialog) && (sVarI0 = I0()) != null) {
            this.n0 = sVarI0.F().k();
        }
        if (this.n0 == -100 && (num = (iVar = B0).get(obj.getClass().getName())) != null) {
            this.n0 = num.intValue();
            iVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.p.h();
    }
}
