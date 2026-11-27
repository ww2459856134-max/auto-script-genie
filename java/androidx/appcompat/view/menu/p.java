package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.a0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import org.apache.xmlbeans.xml.stream.XMLEvent;

/* loaded from: classes.dex */
public final class p implements h.e.e.a.b {
    private View A;
    private h.e.j.e B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;

    /* renamed from: h, reason: collision with root package name */
    private char f86h;

    /* renamed from: j, reason: collision with root package name */
    private char f88j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f90l;

    /* renamed from: n, reason: collision with root package name */
    m f92n;

    /* renamed from: o, reason: collision with root package name */
    private g0 f93o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private int z;

    /* renamed from: i, reason: collision with root package name */
    private int f87i = XMLEvent.CHANGE_PREFIX_MAPPING;

    /* renamed from: k, reason: collision with root package name */
    private int f89k = XMLEvent.CHANGE_PREFIX_MAPPING;

    /* renamed from: m, reason: collision with root package name */
    private int f91m = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    p(m mVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.z = 0;
        this.f92n = mVar;
        this.a = i3;
        this.b = i2;
        this.c = i4;
        this.d = i5;
        this.e = charSequence;
        this.z = i6;
    }

    private static void d(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.q(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.n(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.o(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    boolean A() {
        return this.f92n.H() && g() != 0;
    }

    public boolean B() {
        return (this.z & 4) == 4;
    }

    @Override // h.e.e.a.b
    public h.e.j.e a() {
        return this.B;
    }

    @Override // h.e.e.a.b
    public h.e.e.a.b b(h.e.j.e eVar) {
        h.e.j.e eVar2 = this.B;
        if (eVar2 != null) {
            eVar2.h();
        }
        this.A = null;
        this.B = eVar;
        this.f92n.K(true);
        h.e.j.e eVar3 = this.B;
        if (eVar3 != null) {
            eVar3.j(new o(this));
        }
        return this;
    }

    public void c() {
        this.f92n.I(this);
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f92n.f(this);
        }
        return false;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f92n.k(this);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    char g() {
        return this.f92n.G() ? this.f88j : this.f86h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        h.e.j.e eVar = this.B;
        if (eVar == null) {
            return null;
        }
        View viewD = eVar.d(this);
        this.A = viewD;
        return viewD;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f89k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f88j;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f90l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f91m == 0) {
            return null;
        }
        Drawable drawableD = h.a.k.a.b.d(this.f92n.u(), this.f91m);
        this.f91m = 0;
        this.f90l = drawableD;
        return e(drawableD);
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f87i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f86h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f93o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence == null) {
            charSequence = this.e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    String h() {
        char cG = g();
        if (cG == 0) {
            return "";
        }
        Resources resources = this.f92n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f92n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(h.a.h.f1224o));
        }
        int i2 = this.f92n.G() ? this.f89k : this.f87i;
        d(sb, i2, WXMediaMessage.THUMB_LENGTH_LIMIT, resources.getString(h.a.h.f1220k));
        d(sb, i2, XMLEvent.CHANGE_PREFIX_MAPPING, resources.getString(h.a.h.g));
        d(sb, i2, 2, resources.getString(h.a.h.f));
        d(sb, i2, 1, resources.getString(h.a.h.f1221l));
        d(sb, i2, 4, resources.getString(h.a.h.f1223n));
        d(sb, i2, 8, resources.getString(h.a.h.f1219j));
        if (cG == '\b') {
            sb.append(resources.getString(h.a.h.f1217h));
        } else if (cG == '\n') {
            sb.append(resources.getString(h.a.h.f1218i));
        } else if (cG != ' ') {
            sb.append(cG);
        } else {
            sb.append(resources.getString(h.a.h.f1222m));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f93o != null;
    }

    CharSequence i(a0.a aVar) {
        return (aVar == null || !aVar.c()) ? getTitle() : getTitleCondensed();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        h.e.j.e eVar = this.B;
        return (eVar == null || !eVar.g()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        h.e.j.e eVar;
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && (eVar = this.B) != null) {
            this.A = eVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        m mVar = this.f92n;
        if (mVar.h(mVar, this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.f92n.u().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        h.e.j.e eVar = this.B;
        return eVar != null && eVar.e();
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    public h.e.e.a.b p(int i2) {
        Context contextU = this.f92n.u();
        q(LayoutInflater.from(contextU).inflate(i2, (ViewGroup) new LinearLayout(contextU), false));
        return this;
    }

    public h.e.e.a.b q(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.a) > 0) {
            view.setId(i2);
        }
        this.f92n.I(this);
        return this;
    }

    public void r(boolean z) {
        this.D = z;
        this.f92n.K(false);
    }

    void s(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 2 : 0) | (i2 & (-3));
        this.y = i3;
        if (i2 != i3) {
            this.f92n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(int i2) {
        p(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f88j == c) {
            return this;
        }
        this.f88j = Character.toLowerCase(c);
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.y = i3;
        if (i2 != i3) {
            this.f92n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.f92n.T(this);
        } else {
            s(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f91m = 0;
        this.f90l = drawable;
        this.x = true;
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f86h == c) {
            return this;
        }
        this.f86h = c;
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f86h = c;
        this.f88j = Character.toLowerCase(c2);
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i2;
        this.f92n.I(this);
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setShowAsActionFlags(int i2) {
        w(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.f92n.K(false);
        g0 g0Var = this.f93o;
        if (g0Var != null) {
            g0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (y(z)) {
            this.f92n.J(this);
        }
        return this;
    }

    public void t(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public h.e.e.a.b w(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public void x(g0 g0Var) {
        this.f93o = g0Var;
        g0Var.setHeaderTitle(getTitle());
    }

    boolean y(boolean z) {
        int i2 = this.y;
        int i3 = (z ? 0 : 8) | (i2 & (-9));
        this.y = i3;
        return i2 != i3;
    }

    public boolean z() {
        return this.f92n.A();
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        q(view);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public h.e.e.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public h.e.e.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        if (this.f88j == c && this.f89k == i2) {
            return this;
        }
        this.f88j = Character.toLowerCase(c);
        this.f89k = KeyEvent.normalizeMetaState(i2);
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i2) {
        if (this.f86h == c && this.f87i == i2) {
            return this;
        }
        this.f86h = c;
        this.f87i = KeyEvent.normalizeMetaState(i2);
        this.f92n.K(false);
        return this;
    }

    @Override // h.e.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i2, int i3) {
        this.f86h = c;
        this.f87i = KeyEvent.normalizeMetaState(i2);
        this.f88j = Character.toLowerCase(c2);
        this.f89k = KeyEvent.normalizeMetaState(i3);
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f90l = null;
        this.f91m = i2;
        this.x = true;
        this.f92n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        setTitle(this.f92n.u().getString(i2));
        return this;
    }
}
