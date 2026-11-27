package h.a.o;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.t1;
import h.e.j.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
class j {
    h.e.j.e A;
    private CharSequence B;
    private CharSequence C;
    private ColorStateList D = null;
    private PorterDuff.Mode E = null;
    final /* synthetic */ k F;
    private Menu a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1256h;

    /* renamed from: i, reason: collision with root package name */
    private int f1257i;

    /* renamed from: j, reason: collision with root package name */
    private int f1258j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f1259k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f1260l;

    /* renamed from: m, reason: collision with root package name */
    private int f1261m;

    /* renamed from: n, reason: collision with root package name */
    private char f1262n;

    /* renamed from: o, reason: collision with root package name */
    private int f1263o;
    private char p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private String x;
    private String y;
    private String z;

    public j(k kVar, Menu menu) {
        this.F = kVar;
        this.a = menu;
        h();
    }

    private char c(String str) {
        if (str == null) {
            return (char) 0;
        }
        return str.charAt(0);
    }

    private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.F.c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return (T) constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void i(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.f1260l).setIcon(this.f1261m);
        int i2 = this.v;
        if (i2 >= 0) {
            menuItem.setShowAsAction(i2);
        }
        if (this.z != null) {
            if (this.F.c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new i(this.F.b(), this.z));
        }
        if (this.r >= 2) {
            if (menuItem instanceof p) {
                ((p) menuItem).t(true);
            } else if (menuItem instanceof v) {
                ((v) menuItem).h(true);
            }
        }
        String str = this.x;
        if (str != null) {
            menuItem.setActionView((View) e(str, k.e, this.F.a));
            z = true;
        }
        int i3 = this.w;
        if (i3 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i3);
            }
        }
        h.e.j.e eVar = this.A;
        if (eVar != null) {
            s.a(menuItem, eVar);
        }
        s.c(menuItem, this.B);
        s.g(menuItem, this.C);
        s.b(menuItem, this.f1262n, this.f1263o);
        s.f(menuItem, this.p, this.q);
        PorterDuff.Mode mode = this.E;
        if (mode != null) {
            s.e(menuItem, mode);
        }
        ColorStateList colorStateList = this.D;
        if (colorStateList != null) {
            s.d(menuItem, colorStateList);
        }
    }

    public void a() {
        this.f1256h = true;
        i(this.a.add(this.b, this.f1257i, this.f1258j, this.f1259k));
    }

    public SubMenu b() {
        this.f1256h = true;
        SubMenu subMenuAddSubMenu = this.a.addSubMenu(this.b, this.f1257i, this.f1258j, this.f1259k);
        i(subMenuAddSubMenu.getItem());
        return subMenuAddSubMenu;
    }

    public boolean d() {
        return this.f1256h;
    }

    public void f(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.F.c.obtainStyledAttributes(attributeSet, h.a.j.g1);
        this.b = typedArrayObtainStyledAttributes.getResourceId(h.a.j.i1, 0);
        this.c = typedArrayObtainStyledAttributes.getInt(h.a.j.k1, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(h.a.j.l1, 0);
        this.e = typedArrayObtainStyledAttributes.getInt(h.a.j.m1, 0);
        this.f = typedArrayObtainStyledAttributes.getBoolean(h.a.j.j1, true);
        this.g = typedArrayObtainStyledAttributes.getBoolean(h.a.j.h1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void g(AttributeSet attributeSet) {
        t1 t1VarT = t1.t(this.F.c, attributeSet, h.a.j.n1);
        this.f1257i = t1VarT.m(h.a.j.q1, 0);
        this.f1258j = (t1VarT.j(h.a.j.t1, this.c) & (-65536)) | (t1VarT.j(h.a.j.u1, this.d) & 65535);
        this.f1259k = t1VarT.o(h.a.j.v1);
        this.f1260l = t1VarT.o(h.a.j.w1);
        this.f1261m = t1VarT.m(h.a.j.o1, 0);
        this.f1262n = c(t1VarT.n(h.a.j.x1));
        this.f1263o = t1VarT.j(h.a.j.E1, XMLEvent.CHANGE_PREFIX_MAPPING);
        this.p = c(t1VarT.n(h.a.j.y1));
        this.q = t1VarT.j(h.a.j.I1, XMLEvent.CHANGE_PREFIX_MAPPING);
        int i2 = h.a.j.z1;
        if (t1VarT.r(i2)) {
            this.r = t1VarT.a(i2, false) ? 1 : 0;
        } else {
            this.r = this.e;
        }
        this.s = t1VarT.a(h.a.j.r1, false);
        this.t = t1VarT.a(h.a.j.s1, this.f);
        this.u = t1VarT.a(h.a.j.p1, this.g);
        this.v = t1VarT.j(h.a.j.J1, -1);
        this.z = t1VarT.n(h.a.j.A1);
        this.w = t1VarT.m(h.a.j.B1, 0);
        this.x = t1VarT.n(h.a.j.D1);
        String strN = t1VarT.n(h.a.j.C1);
        this.y = strN;
        boolean z = strN != null;
        if (z && this.w == 0 && this.x == null) {
            this.A = (h.e.j.e) e(strN, k.f, this.F.b);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.A = null;
        }
        this.B = t1VarT.o(h.a.j.F1);
        this.C = t1VarT.o(h.a.j.K1);
        int i3 = h.a.j.H1;
        if (t1VarT.r(i3)) {
            this.E = m0.e(t1VarT.j(i3, -1), this.E);
        } else {
            this.E = null;
        }
        int i4 = h.a.j.G1;
        if (t1VarT.r(i4)) {
            this.D = t1VarT.c(i4);
        } else {
            this.D = null;
        }
        t1VarT.v();
        this.f1256h = false;
    }

    public void h() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = true;
    }
}
